package com.baidu.searchbox.downloads;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import com.baidu.android.ext.widget.dialog.BoxAlertDialog;
import com.baidu.android.util.concurrent.UiThreadUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.download.ioc.IDownloadApp;
import com.baidu.searchbox.downloads.manage.SearchBoxDownloadManager;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public final class ExitWithDownloadsDialog {
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String TAG = "ExistWithDownloadsDialog";

    public static void exit(final Context context) {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.searchbox.downloads.ExitWithDownloadsDialog.4
            @Override // java.lang.Runnable
            public void run() {
                IDownloadApp.Impl.get().doSearchBoxStateInfoRelease();
                IDownloadApp.Impl.get().doAppExit(context);
            }
        });
    }

    public static void showDialog(final Context context) {
        showDialog(context, new DialogInterface.OnDismissListener() { // from class: com.baidu.searchbox.downloads.ExitWithDownloadsDialog.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                Context context2 = context;
                if (context2 instanceof Activity) {
                    ((Activity) context2).finish();
                }
            }
        });
    }

    @SuppressLint({"LongLogTag"})
    public static void showDialog(final Context context, DialogInterface.OnDismissListener onDismissListener) {
        if (DEBUG) {
            Log.v(TAG, "EXIST IN DIALOG");
        }
        new BoxAlertDialog.Builder(context).setTitle(R.string.obfuscated_res_0x7f0f05fc).setNegativeButton(R.string.obfuscated_res_0x7f0f0e7b, new DialogInterface.OnClickListener() { // from class: com.baidu.searchbox.downloads.ExitWithDownloadsDialog.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                SearchBoxDownloadManager.getInstance(AppRuntime.getAppContext()).pauseAllDownloadingTasks();
                Intent intent = new Intent(DownloadConstants.ACTION_DOWNLOAD_STOP_NOTIFICATION);
                intent.setPackage(context.getPackageName());
                context.sendBroadcast(intent);
                ExitWithDownloadsDialog.exit(context);
            }
        }).setPositiveButton(R.string.obfuscated_res_0x7f0f1918, new DialogInterface.OnClickListener() { // from class: com.baidu.searchbox.downloads.ExitWithDownloadsDialog.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                ExitWithDownloadsDialog.exit(context);
            }
        }).setMessage(R.string.obfuscated_res_0x7f0f05d1).setOnDismissListener(onDismissListener).show(true);
    }
}
