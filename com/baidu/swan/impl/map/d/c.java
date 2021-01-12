package com.baidu.swan.impl.map.d;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.baidu.mapapi.model.LatLng;
import com.baidu.swan.apps.ao.ak;
/* loaded from: classes8.dex */
public abstract class c {
    protected String eoY;
    protected boolean eoZ = false;
    protected String mId;
    protected String mName;

    protected abstract void a(Context context, LatLng latLng, LatLng latLng2, String str, String str2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(String str, String str2, String str3) {
        this.mId = str;
        this.mName = str2;
        this.eoY = str3;
    }

    public boolean eD(Context context) {
        return ak.ap(context.getApplicationContext(), this.eoY) != null;
    }

    public boolean bbc() {
        return this.eoZ;
    }

    public String getName() {
        return this.mName;
    }

    public void b(Context context, LatLng latLng, LatLng latLng2, String str, String str2) {
        if (!eD(context) && this.eoZ) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + this.eoY));
            intent.addFlags(268435456);
            context.startActivity(intent);
            return;
        }
        a(context, latLng, latLng2, str, str2);
    }
}
