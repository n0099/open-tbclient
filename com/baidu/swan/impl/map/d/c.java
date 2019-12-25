package com.baidu.swan.impl.map.d;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.baidu.mapapi.model.LatLng;
import com.baidu.swan.apps.as.ai;
/* loaded from: classes9.dex */
public abstract class c {
    protected String ctL;
    protected boolean ctM = false;
    protected String mId;
    protected String mName;

    protected abstract void a(Context context, LatLng latLng, LatLng latLng2, String str, String str2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(String str, String str2, String str3) {
        this.mId = str;
        this.mName = str2;
        this.ctL = str3;
    }

    public boolean dv(Context context) {
        return ai.getPackageInfo(context.getApplicationContext(), this.ctL) != null;
    }

    public boolean apO() {
        return this.ctM;
    }

    public String getName() {
        return this.mName;
    }

    public void b(Context context, LatLng latLng, LatLng latLng2, String str, String str2) {
        if (!dv(context) && this.ctM) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + this.ctL));
            intent.addFlags(268435456);
            context.startActivity(intent);
            return;
        }
        a(context, latLng, latLng2, str, str2);
    }
}
