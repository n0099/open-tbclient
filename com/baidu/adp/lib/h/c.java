package com.baidu.adp.lib.h;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    Context f503a;

    public c(Context context) {
        a(context);
    }

    private void a(Context context) {
        this.f503a = context;
    }

    public void a() {
        Intent intent = new Intent();
        intent.setAction("android.settings.LOCATION_SOURCE_SETTINGS");
        intent.setFlags(268435456);
        try {
            this.f503a.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            intent.setAction("android.settings.SETTINGS");
            try {
                this.f503a.startActivity(intent);
            } catch (Exception e2) {
            }
        }
    }
}
