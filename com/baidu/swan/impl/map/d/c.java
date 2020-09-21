package com.baidu.swan.impl.map.d;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.baidu.mapapi.model.LatLng;
import com.baidu.swan.apps.ap.ak;
/* loaded from: classes24.dex */
public abstract class c {
    protected String dEZ;
    protected boolean dFa = false;
    protected String mId;
    protected String mName;

    protected abstract void a(Context context, LatLng latLng, LatLng latLng2, String str, String str2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(String str, String str2, String str3) {
        this.mId = str;
        this.mName = str2;
        this.dEZ = str3;
    }

    public boolean dz(Context context) {
        return ak.getPackageInfo(context.getApplicationContext(), this.dEZ) != null;
    }

    public boolean aTb() {
        return this.dFa;
    }

    public String getName() {
        return this.mName;
    }

    public void b(Context context, LatLng latLng, LatLng latLng2, String str, String str2) {
        if (!dz(context) && this.dFa) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + this.dEZ));
            intent.addFlags(268435456);
            context.startActivity(intent);
            return;
        }
        a(context, latLng, latLng2, str, str2);
    }
}
