package com.baidu.platform.comapi.wnplatform.o;

import android.content.SharedPreferences;
/* loaded from: classes10.dex */
public class n extends com.baidu.platform.comapi.walknavi.a {
    private SharedPreferences.Editor b = null;
    private SharedPreferences a = com.baidu.platform.comapi.wnplatform.o.b.a.a().getSharedPreferences("walknavi_preference", 0);

    @Override // com.baidu.platform.comapi.walknavi.a
    public void release() {
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public boolean ready() {
        return true;
    }

    public String a(String str, String str2) {
        return this.a.getString(str, str2);
    }

    public boolean a(String str, boolean z) {
        return this.a.getBoolean(str, z);
    }

    public boolean b(String str, boolean z) {
        this.b = this.a.edit();
        this.b.putBoolean(str, z);
        return this.b.commit();
    }

    public boolean b(String str, String str2) {
        this.b = this.a.edit();
        this.b.putString(str, str2);
        return this.b.commit();
    }
}
