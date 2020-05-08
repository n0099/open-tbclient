package com.baidu.swan.impl.map.d;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.baidu.mapapi.model.LatLng;
import com.baidu.swan.apps.as.ai;
/* loaded from: classes12.dex */
public abstract class c {
    protected String cXl;
    protected boolean cXm = false;
    protected String mId;
    protected String mName;

    protected abstract void a(Context context, LatLng latLng, LatLng latLng2, String str, String str2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(String str, String str2, String str3) {
        this.mId = str;
        this.mName = str2;
        this.cXl = str3;
    }

    public boolean da(Context context) {
        return ai.getPackageInfo(context.getApplicationContext(), this.cXl) != null;
    }

    public boolean aAK() {
        return this.cXm;
    }

    public String getName() {
        return this.mName;
    }

    public void b(Context context, LatLng latLng, LatLng latLng2, String str, String str2) {
        if (!da(context) && this.cXm) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + this.cXl));
            intent.addFlags(268435456);
            context.startActivity(intent);
            return;
        }
        a(context, latLng, latLng2, str, str2);
    }
}
