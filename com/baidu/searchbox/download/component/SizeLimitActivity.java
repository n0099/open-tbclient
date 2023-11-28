package com.baidu.searchbox.download.component;

import android.app.Dialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteFullException;
import android.net.Uri;
import android.text.format.Formatter;
import android.util.Log;
import com.baidu.android.ext.widget.dialog.BoxAlertDialog;
import com.baidu.android.util.io.Closeables;
import com.baidu.searchbox.appframework.BaseActivity;
import com.baidu.searchbox.download.ioc.DownloadRuntime;
import com.baidu.searchbox.download.model.DownloadInfo;
import com.baidu.searchbox.download.model.Downloads;
import com.baidu.tieba.R;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes3.dex */
public class SizeLimitActivity extends BaseActivity implements DialogInterface.OnCancelListener, DialogInterface.OnClickListener {
    public Intent mCurrentIntent;
    public Uri mCurrentUri;
    public Dialog mDialog;
    public Queue<Intent> mDownloadsToShow = new LinkedList();

    private void dialogClosed() {
        this.mDialog = null;
        this.mCurrentUri = null;
        showNextDialog();
    }

    @Override // com.baidu.searchbox.appframework.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        Intent intent = getIntent();
        if (intent != null) {
            this.mDownloadsToShow.add(intent);
            setIntent(null);
            showNextDialog();
        }
        Dialog dialog = this.mDialog;
        if (dialog != null && !dialog.isShowing()) {
            this.mDialog.show();
        }
    }

    private void showDialog(Cursor cursor) {
        String formatFileSize = Formatter.formatFileSize(this, cursor.getInt(cursor.getColumnIndexOrThrow("total_bytes")));
        String string = getString(R.string.obfuscated_res_0x7f0f05cd);
        boolean z = this.mCurrentIntent.getExtras().getBoolean(DownloadInfo.EXTRA_IS_WIFI_REQUIRED);
        BoxAlertDialog.Builder builder = new BoxAlertDialog.Builder(this);
        if (z) {
            builder.setTitle(R.string.obfuscated_res_0x7f0f060b).setMessage(getString(R.string.obfuscated_res_0x7f0f060a, new Object[]{formatFileSize, string})).setPositiveButton(R.string.obfuscated_res_0x7f0f05cd, this).setNegativeButton(R.string.obfuscated_res_0x7f0f05cc, this);
        } else {
            builder.setTitle(R.string.obfuscated_res_0x7f0f0609).setMessage(getString(R.string.obfuscated_res_0x7f0f0608, new Object[]{formatFileSize, string})).setPositiveButton(R.string.obfuscated_res_0x7f0f05ce, this).setNegativeButton(R.string.obfuscated_res_0x7f0f05cd, this);
        }
        this.mDialog = builder.setOnCancelListener(this).show(true);
    }

    private void showNextDialog() {
        if (this.mDialog != null) {
            return;
        }
        if (this.mDownloadsToShow.isEmpty()) {
            finish();
            return;
        }
        Intent poll = this.mDownloadsToShow.poll();
        this.mCurrentIntent = poll;
        Uri data = poll.getData();
        this.mCurrentUri = data;
        if (data == null) {
            finish();
            return;
        }
        Cursor cursor = null;
        try {
            try {
                cursor = getContentResolver().query(this.mCurrentUri, null, null, null, null);
            } catch (SQLiteFullException e) {
                if (DownloadRuntime.GLOBAL_DEBUG) {
                    e.printStackTrace();
                }
            }
            if (!cursor.moveToFirst()) {
                if (DownloadRuntime.GLOBAL_DEBUG) {
                    Log.e("DownloadManager", "Empty cursor for URI " + this.mCurrentUri);
                }
                dialogClosed();
                return;
            }
            showDialog(cursor);
        } finally {
            Closeables.closeSafely((Cursor) null);
        }
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        dialogClosed();
    }

    @Override // com.baidu.searchbox.appframework.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        boolean z = this.mCurrentIntent.getExtras().getBoolean(DownloadInfo.EXTRA_IS_WIFI_REQUIRED);
        if (z && i == -2) {
            getContentResolver().delete(this.mCurrentUri, null, null);
        } else if (!z && i == -1) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(Downloads.Impl.COLUMN_BYPASS_RECOMMENDED_SIZE_LIMIT, Boolean.TRUE);
            getContentResolver().update(this.mCurrentUri, contentValues, null, null);
        }
        dialogClosed();
    }
}
