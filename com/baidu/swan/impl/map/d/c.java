package com.baidu.swan.impl.map.d;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.baidu.mapapi.model.LatLng;
import com.baidu.swan.apps.aq.aj;
/* loaded from: classes12.dex */
public abstract class c {
    protected String dmY;
    protected boolean dmZ = false;
    protected String mId;
    protected String mName;

    protected abstract void a(Context context, LatLng latLng, LatLng latLng2, String str, String str2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(String str, String str2, String str3) {
        this.mId = str;
        this.mName = str2;
        this.dmY = str3;
    }

    public boolean dq(Context context) {
        return aj.getPackageInfo(context.getApplicationContext(), this.dmY) != null;
    }

    public boolean aFI() {
        return this.dmZ;
    }

    public String getName() {
        return this.mName;
    }

    public void b(Context context, LatLng latLng, LatLng latLng2, String str, String str2) {
        if (!dq(context) && this.dmZ) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + this.dmY));
            intent.addFlags(268435456);
            context.startActivity(intent);
            return;
        }
        a(context, latLng, latLng2, str, str2);
    }
}
