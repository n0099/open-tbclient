package com.baidu.platform.comapi.wnplatform.p;

import android.content.SharedPreferences;
/* loaded from: classes15.dex */
public class o extends com.baidu.platform.comapi.walknavi.a {

    /* renamed from: b  reason: collision with root package name */
    private SharedPreferences.Editor f4701b = null;

    /* renamed from: a  reason: collision with root package name */
    private SharedPreferences f4700a = com.baidu.platform.comapi.wnplatform.p.b.a.a().getSharedPreferences("walknavi_preference", 0);

    @Override // com.baidu.platform.comapi.walknavi.a
    public void release() {
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public boolean ready() {
        return true;
    }

    public String a(String str, String str2) {
        return this.f4700a.getString(str, str2);
    }

    public boolean a(String str, boolean z) {
        return this.f4700a.getBoolean(str, z);
    }

    public boolean b(String str, boolean z) {
        this.f4701b = this.f4700a.edit();
        this.f4701b.putBoolean(str, z);
        return this.f4701b.commit();
    }

    public boolean b(String str, String str2) {
        this.f4701b = this.f4700a.edit();
        this.f4701b.putString(str, str2);
        return this.f4701b.commit();
    }
}
