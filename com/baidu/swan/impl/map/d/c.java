package com.baidu.swan.impl.map.d;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.baidu.mapapi.model.LatLng;
import com.baidu.swan.apps.aq.al;
/* loaded from: classes19.dex */
public abstract class c {
    protected String dsU;
    protected boolean dsV = false;
    protected String mId;
    protected String mName;

    protected abstract void a(Context context, LatLng latLng, LatLng latLng2, String str, String str2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(String str, String str2, String str3) {
        this.mId = str;
        this.mName = str2;
        this.dsU = str3;
    }

    public boolean du(Context context) {
        return al.getPackageInfo(context.getApplicationContext(), this.dsU) != null;
    }

    public boolean aJz() {
        return this.dsV;
    }

    public String getName() {
        return this.mName;
    }

    public void b(Context context, LatLng latLng, LatLng latLng2, String str, String str2) {
        if (!du(context) && this.dsV) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + this.dsU));
            intent.addFlags(268435456);
            context.startActivity(intent);
            return;
        }
        a(context, latLng, latLng2, str, str2);
    }
}
