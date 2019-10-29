package com.baidu.live.adp.lib.util;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.net.http.Headers;
/* loaded from: classes6.dex */
public class BdGPSHelper {
    Context mContext;

    public BdGPSHelper(Context context) {
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
    }

    public boolean getGPSIsOpen() {
        return ((LocationManager) this.mContext.getSystemService(Headers.LOCATION)).isProviderEnabled("gps");
    }

    public void openGPSSetting() {
        Intent intent = new Intent();
        intent.setAction("android.settings.LOCATION_SOURCE_SETTINGS");
        intent.setFlags(268435456);
        try {
            this.mContext.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            intent.setAction("android.settings.SETTINGS");
            try {
                this.mContext.startActivity(intent);
            } catch (Exception e2) {
            }
        }
    }
}
