package com.baidu.platform.comapi.wnplatform.o;

import android.content.SharedPreferences;
/* loaded from: classes4.dex */
public class n extends com.baidu.platform.comapi.walknavi.a {
    private SharedPreferences.Editor b = null;

    /* renamed from: a  reason: collision with root package name */
    private SharedPreferences f3089a = com.baidu.platform.comapi.wnplatform.o.b.a.a().getSharedPreferences("walknavi_preference", 0);

    @Override // com.baidu.platform.comapi.walknavi.a
    public void release() {
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public boolean ready() {
        return true;
    }

    public String a(String str, String str2) {
        return this.f3089a.getString(str, str2);
    }

    public boolean a(String str, boolean z) {
        return this.f3089a.getBoolean(str, z);
    }

    public boolean b(String str, boolean z) {
        this.b = this.f3089a.edit();
        this.b.putBoolean(str, z);
        return this.b.commit();
    }

    public boolean b(String str, String str2) {
        this.b = this.f3089a.edit();
        this.b.putString(str, str2);
        return this.b.commit();
    }
}
