package com.baidu.platform.comapi.wnplatform.o;

import android.content.SharedPreferences;
/* loaded from: classes2.dex */
public class n extends com.baidu.platform.comapi.walknavi.a {

    /* renamed from: b  reason: collision with root package name */
    public SharedPreferences.Editor f10304b = null;

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f10303a = com.baidu.platform.comapi.wnplatform.o.b.a.a().getSharedPreferences("walknavi_preference", 0);

    public String a(String str, String str2) {
        return this.f10303a.getString(str, str2);
    }

    public boolean b(String str, boolean z) {
        SharedPreferences.Editor edit = this.f10303a.edit();
        this.f10304b = edit;
        edit.putBoolean(str, z);
        return this.f10304b.commit();
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public boolean ready() {
        return true;
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public void release() {
    }

    public boolean a(String str, boolean z) {
        return this.f10303a.getBoolean(str, z);
    }

    public boolean b(String str, String str2) {
        SharedPreferences.Editor edit = this.f10303a.edit();
        this.f10304b = edit;
        edit.putString(str, str2);
        return this.f10304b.commit();
    }
}
