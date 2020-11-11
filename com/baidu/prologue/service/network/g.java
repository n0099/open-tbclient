package com.baidu.prologue.service.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
/* loaded from: classes19.dex */
public class g {
    private final int netType;
    private final int subType;

    public g(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager == null ? null : connectivityManager.getActiveNetworkInfo();
        this.netType = activeNetworkInfo == null ? -1 : activeNetworkInfo.getType();
        this.subType = (activeNetworkInfo == null || this.netType != 0) ? 0 : activeNetworkInfo.getSubtype();
    }

    public int acY() {
        switch (this.netType) {
            case -1:
            default:
                return 0;
            case 0:
                return acZ();
            case 1:
                return 1;
        }
    }

    public boolean isWifi() {
        return acY() == 1;
    }

    public boolean isMobileNet() {
        return this.netType == 0;
    }

    private int acZ() {
        switch (this.subType) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return 2;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return 3;
            case 13:
            default:
                return 4;
        }
    }
}
