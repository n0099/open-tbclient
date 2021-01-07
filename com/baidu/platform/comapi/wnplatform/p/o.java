package com.baidu.platform.comapi.wnplatform.p;

import android.content.SharedPreferences;
/* loaded from: classes3.dex */
public class o extends com.baidu.platform.comapi.walknavi.a {

    /* renamed from: b  reason: collision with root package name */
    private SharedPreferences.Editor f4702b = null;

    /* renamed from: a  reason: collision with root package name */
    private SharedPreferences f4701a = com.baidu.platform.comapi.wnplatform.p.b.a.a().getSharedPreferences("walknavi_preference", 0);

    @Override // com.baidu.platform.comapi.walknavi.a
    public void release() {
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public boolean ready() {
        return true;
    }

    public String a(String str, String str2) {
        return this.f4701a.getString(str, str2);
    }

    public boolean a(String str, boolean z) {
        return this.f4701a.getBoolean(str, z);
    }

    public boolean b(String str, boolean z) {
        this.f4702b = this.f4701a.edit();
        this.f4702b.putBoolean(str, z);
        return this.f4702b.commit();
    }

    public boolean b(String str, String str2) {
        this.f4702b = this.f4701a.edit();
        this.f4702b.putString(str, str2);
        return this.f4702b.commit();
    }
}
