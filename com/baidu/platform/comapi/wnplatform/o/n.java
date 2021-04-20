package com.baidu.platform.comapi.wnplatform.o;

import android.content.SharedPreferences;
/* loaded from: classes2.dex */
public class n extends com.baidu.platform.comapi.walknavi.a {

    /* renamed from: b  reason: collision with root package name */
    public SharedPreferences.Editor f9936b = null;

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f9935a = com.baidu.platform.comapi.wnplatform.o.b.a.a().getSharedPreferences("walknavi_preference", 0);

    public String a(String str, String str2) {
        return this.f9935a.getString(str, str2);
    }

    public boolean b(String str, boolean z) {
        SharedPreferences.Editor edit = this.f9935a.edit();
        this.f9936b = edit;
        edit.putBoolean(str, z);
        return this.f9936b.commit();
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public boolean ready() {
        return true;
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public void release() {
    }

    public boolean a(String str, boolean z) {
        return this.f9935a.getBoolean(str, z);
    }

    public boolean b(String str, String str2) {
        SharedPreferences.Editor edit = this.f9935a.edit();
        this.f9936b = edit;
        edit.putString(str, str2);
        return this.f9936b.commit();
    }
}
