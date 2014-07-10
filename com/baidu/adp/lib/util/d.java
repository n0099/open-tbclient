package com.baidu.adp.lib.util;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
public class d {
    Context a;

    public d(Context context) {
        a(context);
    }

    private void a(Context context) {
        this.a = context;
    }

    public void a() {
        Intent intent = new Intent();
        intent.setAction("android.settings.LOCATION_SOURCE_SETTINGS");
        intent.setFlags(268435456);
        try {
            this.a.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            intent.setAction("android.settings.SETTINGS");
            try {
                this.a.startActivity(intent);
            } catch (Exception e2) {
            }
        }
    }
}
