package com.baidu.sofire.core;

import android.content.IntentFilter;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public String f11369a;

    /* renamed from: b  reason: collision with root package name */
    public String f11370b;

    /* renamed from: c  reason: collision with root package name */
    public String f11371c;

    /* renamed from: d  reason: collision with root package name */
    public IntentFilter f11372d;

    public g(String str, IntentFilter intentFilter, String str2, String str3) {
        this.f11369a = str;
        this.f11372d = intentFilter;
        this.f11370b = str2;
        this.f11371c = str3;
    }

    public final boolean a(g gVar) {
        if (gVar != null) {
            try {
                if (!TextUtils.isEmpty(gVar.f11369a) && !TextUtils.isEmpty(gVar.f11370b) && !TextUtils.isEmpty(gVar.f11371c) && gVar.f11369a.equals(this.f11369a) && gVar.f11370b.equals(this.f11370b) && gVar.f11371c.equals(this.f11371c)) {
                    if (gVar.f11372d != null && this.f11372d != null) {
                        return this.f11372d == gVar.f11372d;
                    }
                    return true;
                }
                return false;
            } catch (Throwable unused) {
                com.baidu.sofire.g.d.a();
            }
        }
        return false;
    }

    public final String toString() {
        try {
            return "PluginloaderIntentFilter:" + this.f11369a + "-" + this.f11370b + "-" + this.f11371c + "-" + this.f11372d;
        } catch (Throwable unused) {
            return "";
        }
    }
}
