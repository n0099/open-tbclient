package com.baidu.searchbox.downloads.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.core.content.ContextCompat;
import com.baidu.android.common.logging.Log;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.download.ioc.IDownloadApp;
import com.baidu.searchbox.downloads.DownloadConstants;
/* loaded from: classes3.dex */
public class VideoContinueReceiver extends BroadcastReceiver {
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String TAG = VideoContinueReceiver.class.getSimpleName();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (DEBUG) {
            Log.v(TAG, "视频下载监听 receiver");
        }
        String action = intent.getAction();
        if (action != null && DownloadConstants.ACTION_DOWNLOAD_VIDEO_CONTINUE.equals(action)) {
            context.startActivity(IDownloadApp.Impl.get().buildVideoContinueActivityIntent(context));
            if (ContextCompat.checkSelfPermission(context, "android.permission.BROADCAST_STICKY") == 0) {
                context.removeStickyBroadcast(intent);
            }
        }
    }
}
