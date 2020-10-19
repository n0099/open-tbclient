package com.baidu.swan.impl.map.d;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.baidu.mapapi.model.LatLng;
import com.baidu.swan.apps.ap.ak;
/* loaded from: classes25.dex */
public abstract class c {
    protected String dRa;
    protected boolean dRb = false;
    protected String mId;
    protected String mName;

    protected abstract void a(Context context, LatLng latLng, LatLng latLng2, String str, String str2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(String str, String str2, String str3) {
        this.mId = str;
        this.mName = str2;
        this.dRa = str3;
    }

    public boolean dF(Context context) {
        return ak.getPackageInfo(context.getApplicationContext(), this.dRa) != null;
    }

    public boolean aVK() {
        return this.dRb;
    }

    public String getName() {
        return this.mName;
    }

    public void b(Context context, LatLng latLng, LatLng latLng2, String str, String str2) {
        if (!dF(context) && this.dRb) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + this.dRa));
            intent.addFlags(268435456);
            context.startActivity(intent);
            return;
        }
        a(context, latLng, latLng2, str, str2);
    }
}
