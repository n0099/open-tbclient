package com.baidu.platform.comapi.wnplatform.o;

import android.content.SharedPreferences;
/* loaded from: classes4.dex */
public class n extends com.baidu.platform.comapi.walknavi.a {

    /* renamed from: b  reason: collision with root package name */
    private SharedPreferences.Editor f4468b = null;

    /* renamed from: a  reason: collision with root package name */
    private SharedPreferences f4467a = com.baidu.platform.comapi.wnplatform.o.b.a.a().getSharedPreferences("walknavi_preference", 0);

    @Override // com.baidu.platform.comapi.walknavi.a
    public void release() {
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public boolean ready() {
        return true;
    }

    public String a(String str, String str2) {
        return this.f4467a.getString(str, str2);
    }

    public boolean a(String str, boolean z) {
        return this.f4467a.getBoolean(str, z);
    }

    public boolean b(String str, boolean z) {
        this.f4468b = this.f4467a.edit();
        this.f4468b.putBoolean(str, z);
        return this.f4468b.commit();
    }

    public boolean b(String str, String str2) {
        this.f4468b = this.f4467a.edit();
        this.f4468b.putString(str, str2);
        return this.f4468b.commit();
    }
}
