package com.baidu.adp.lib.util;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
public class e {
    Context mContext;

    public e(Context context) {
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
    }

    public void eV() {
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
