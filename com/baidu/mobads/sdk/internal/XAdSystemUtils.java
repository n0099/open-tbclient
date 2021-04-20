package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.baidu.down.utils.Utils;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
/* loaded from: classes2.dex */
public class XAdSystemUtils {
    public static volatile XAdSystemUtils shareInstance;

    public static XAdSystemUtils getInstance() {
        if (shareInstance == null) {
            synchronized (XAdSystemUtils.class) {
                if (shareInstance == null) {
                    shareInstance = new XAdSystemUtils();
                }
            }
        }
        return shareInstance;
    }

    private Boolean isXTypeConnected(Context context, int i) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            boolean z = true;
            if (context.checkCallingOrSelfPermission(DefaultConnectivityMonitorFactory.NETWORK_PERMISSION) != 0) {
                XAdLogger.getInstance().e(Utils.TAG, "no permission android.permission.ACCESS_NETWORK_STATE");
                return Boolean.FALSE;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || activeNetworkInfo.getType() != i || !activeNetworkInfo.isConnected()) {
                z = false;
            }
            return Boolean.valueOf(z);
        } catch (Exception unused) {
            return Boolean.FALSE;
        }
    }

    public Boolean is3GConnected(Context context) {
        return isXTypeConnected(context, 0);
    }

    public boolean isCurrentNetworkAvailable(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isAvailable();
            }
            return false;
        } catch (Exception e2) {
            XAdLogger.getInstance().d("isCurrentNetworkAvailable", e2);
            return false;
        }
    }

    public Boolean isWifiConnected(Context context) {
        return isXTypeConnected(context, 1);
    }
}
