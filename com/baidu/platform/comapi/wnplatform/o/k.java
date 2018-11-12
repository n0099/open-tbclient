package com.baidu.platform.comapi.wnplatform.o;

import android.content.SharedPreferences;
/* loaded from: classes4.dex */
public class k extends com.baidu.platform.comapi.walknavi.a {
    private SharedPreferences.Editor b = null;
    private SharedPreferences a = com.baidu.platform.comapi.wnplatform.o.b.a.a().getSharedPreferences("walknavi_preference", 0);

    @Override // com.baidu.platform.comapi.walknavi.a
    public void release() {
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public boolean ready() {
        return true;
    }

    public boolean a(String str, boolean z) {
        return this.a.getBoolean(str, z);
    }

    public boolean b(String str, boolean z) {
        this.b = this.a.edit();
        this.b.putBoolean(str, z);
        return this.b.commit();
    }
}
