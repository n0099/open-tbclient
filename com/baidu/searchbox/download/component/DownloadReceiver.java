package com.baidu.searchbox.download.component;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteFullException;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.io.Closeables;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.developer.DebugException;
import com.baidu.searchbox.download.callback.ISystemFacade;
import com.baidu.searchbox.download.model.Constants;
import com.baidu.searchbox.download.model.Downloads;
import com.baidu.searchbox.download.util.DownloadStatisticUtil;
import com.baidu.searchbox.downloads.DSUtils;
import com.baidu.searchbox.downloads.DownloadNotification;
@SuppressLint({"LogConditional"})
/* loaded from: classes3.dex */
public class DownloadReceiver extends BroadcastReceiver {
    public ISystemFacade mISystemFacade = null;

    private void handleNotificationBroadcast(Context context, Intent intent) {
        Uri data = intent.getData();
        String action = intent.getAction();
        if (Constants.LOGVV) {
            if (action.equals(Constants.ACTION_OPEN)) {
                Log.v("DownloadManager", "Receiver open for " + data);
            } else if (action.equals(Constants.ACTION_LIST)) {
                Log.v("DownloadManager", "Receiver list for " + data);
            } else {
                Log.v("DownloadManager", "Receiver hide for " + data);
            }
        }
        Cursor cursor = null;
        try {
            try {
                cursor = context.getContentResolver().query(data, null, null, null, null);
            } finally {
                Closeables.closeSafely((Cursor) null);
            }
        } catch (SQLiteFullException e) {
            e.printStackTrace();
        } catch (Throwable th) {
            if (AppConfig.isDebug()) {
                throw new DebugException("DownloadReciever", th);
            }
        }
        if (cursor == null) {
            return;
        }
        if (!cursor.moveToFirst()) {
            return;
        }
        int intExtra = intent.getIntExtra(Constants.EXTRA_TYPE, 5);
        if (action.equals(Constants.ACTION_OPEN)) {
            openDownload(context, intent, cursor);
            hideNotification(context, data, cursor);
        } else if (action.equals(Constants.ACTION_LIST)) {
            sendNotificationClickedIntent(intent, cursor);
            if (Downloads.Impl.isStatusCompleted(cursor.getInt(cursor.getColumnIndexOrThrow("status")))) {
                hideNotification(context, data, cursor);
            }
            DownloadStatisticUtil.downloadNotificationClick(intExtra, "downloading");
        } else {
            hideNotification(context, data, cursor);
        }
    }

    private void hideNotification(Context context, Uri uri, Cursor cursor) {
        this.mISystemFacade.cancelNotification(ContentUris.parseId(uri));
        DownloadNotification.deleteNotificationIcon(context, Long.valueOf(ContentUris.parseId(uri)));
        int i = cursor.getInt(cursor.getColumnIndexOrThrow("status"));
        int i2 = cursor.getInt(cursor.getColumnIndexOrThrow("visibility"));
        if (Downloads.Impl.isStatusCompleted(i) && i2 == 1) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("visibility", (Integer) 0);
            context.getContentResolver().update(uri, contentValues, null, null);
        }
    }

    private void openDownload(Context context, Intent intent, Cursor cursor) {
        boolean z;
        String string = cursor.getString(cursor.getColumnIndexOrThrow("notificationpackage"));
        if (!TextUtils.isEmpty(string)) {
            String string2 = cursor.getString(cursor.getColumnIndexOrThrow("notificationclass"));
            if (cursor.getInt(cursor.getColumnIndex(Downloads.Impl.COLUMN_IS_PUBLIC_API)) != 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z && !TextUtils.isEmpty(string2)) {
                sendNotificationClickedIntent(intent, cursor, string, string2, z, false);
            }
        }
    }

    private void sendNotificationClickedIntent(Intent intent, Cursor cursor) {
        boolean z;
        String string = cursor.getString(cursor.getColumnIndexOrThrow("notificationpackage"));
        if (string == null) {
            return;
        }
        String string2 = cursor.getString(cursor.getColumnIndexOrThrow("notificationclass"));
        if (cursor.getInt(cursor.getColumnIndex(Downloads.Impl.COLUMN_IS_PUBLIC_API)) != 0) {
            z = true;
        } else {
            z = false;
        }
        sendNotificationClickedIntent(intent, cursor, string, string2, z, true);
    }

    private void sendNotificationClickedIntent(Intent intent, Cursor cursor, String str, String str2, boolean z, boolean z2) {
        Intent intent2;
        if (z) {
            intent2 = new Intent("android.intent.action.DOWNLOAD_NOTIFICATION_CLICKED");
            intent2.setPackage(str);
        } else if (str2 == null) {
            return;
        } else {
            Intent intent3 = new Intent(Downloads.Impl.ACTION_NOTIFICATION_CLICKED);
            intent3.setClassName(str, str2);
            if (z2 && intent.getBooleanExtra("multiple", true)) {
                intent3.setData(Downloads.Impl.CONTENT_URI);
            } else {
                intent3.setData(ContentUris.withAppendedId(Downloads.Impl.CONTENT_URI, cursor.getLong(cursor.getColumnIndexOrThrow("_id"))));
            }
            intent2 = intent3;
        }
        this.mISystemFacade.sendBroadcast(intent2);
    }

    private void startService(Context context) {
        DSUtils.startDownloadServices(context);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (this.mISystemFacade == null) {
            this.mISystemFacade = new RealSystemFacade(context);
        }
        String action = intent.getAction();
        if (action.equals("android.intent.action.BOOT_COMPLETED")) {
            startService(context);
        } else if (action.equals(Constants.ACTION_RETRY)) {
            startService(context);
        } else if (action.equals(Constants.ACTION_OPEN) || action.equals(Constants.ACTION_LIST) || action.equals(Constants.ACTION_HIDE)) {
            handleNotificationBroadcast(context, intent);
        }
    }
}
