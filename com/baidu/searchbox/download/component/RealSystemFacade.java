package com.baidu.searchbox.download.component;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.baidu.searchbox.download.callback.ISystemFacade;
import com.baidu.searchbox.download.ioc.DownloadRuntime;
import com.baidu.searchbox.download.model.Constants;
/* loaded from: classes3.dex */
public class RealSystemFacade implements ISystemFacade {
    public static final long MAX_BTYES_OVER_MOBILE = Long.MAX_VALUE;
    public static final long RECOMMENDED_MAX_BTYES_OVER_MOBILE = Long.MAX_VALUE;
    public Context mContext;
    public NotificationManager mNotificationManager;

    public RealSystemFacade(Context context) {
        this.mContext = context;
        this.mNotificationManager = (NotificationManager) context.getSystemService("notification");
    }

    @Override // com.baidu.searchbox.download.callback.ISystemFacade
    public void cancelNotification(long j) {
        this.mNotificationManager.cancel((int) j);
    }

    @Override // com.baidu.searchbox.download.callback.ISystemFacade
    public void sendBroadcast(Intent intent) {
        this.mContext.sendBroadcast(intent);
    }

    @Override // com.baidu.searchbox.download.callback.ISystemFacade
    public void startThread(Thread thread) {
        thread.start();
    }

    @Override // com.baidu.searchbox.download.callback.ISystemFacade
    public void cancelAllNotifications() {
        this.mNotificationManager.cancelAll();
    }

    @Override // com.baidu.searchbox.download.callback.ISystemFacade
    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    @Override // com.baidu.searchbox.download.callback.ISystemFacade
    public Integer getActiveNetworkType() {
        ConnectivityManager connectivityManager = (ConnectivityManager) this.mContext.getSystemService("connectivity");
        if (connectivityManager == null) {
            if (DownloadRuntime.GLOBAL_DEBUG) {
                Log.w("DownloadManager", "couldn't get connectivity manager");
            }
            return null;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            if (Constants.LOGVV) {
                Log.v("DownloadManager", "network is not available");
            }
            return null;
        }
        return Integer.valueOf(activeNetworkInfo.getType());
    }

    @Override // com.baidu.searchbox.download.callback.ISystemFacade
    public Long getMaxBytesOverMobile() {
        return Long.MAX_VALUE;
    }

    @Override // com.baidu.searchbox.download.callback.ISystemFacade
    public Long getRecommendedMaxBytesOverMobile() {
        return Long.MAX_VALUE;
    }

    @Override // com.baidu.searchbox.download.callback.ISystemFacade
    public boolean isNetworkRoaming() {
        boolean z;
        ConnectivityManager connectivityManager = (ConnectivityManager) this.mContext.getSystemService("connectivity");
        boolean z2 = false;
        if (connectivityManager == null) {
            if (DownloadRuntime.GLOBAL_DEBUG) {
                Log.w("DownloadManager", "couldn't get connectivity manager");
            }
            return false;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.getType() == 0) {
            z = true;
        } else {
            z = false;
        }
        TelephonyManager telephonyManager = (TelephonyManager) this.mContext.getSystemService("phone");
        if (z && telephonyManager.isNetworkRoaming()) {
            z2 = true;
        }
        if (Constants.LOGVV && z2) {
            Log.v("DownloadManager", "network is roaming");
        }
        return z2;
    }

    @Override // com.baidu.searchbox.download.callback.ISystemFacade
    public void postNotification(long j, Notification notification) {
        this.mNotificationManager.notify((int) j, notification);
    }

    @Override // com.baidu.searchbox.download.callback.ISystemFacade
    public boolean userOwnsPackage(int i, String str) throws PackageManager.NameNotFoundException {
        if (this.mContext.getPackageManager().getApplicationInfo(str, 0).uid != i) {
            return false;
        }
        return true;
    }
}
