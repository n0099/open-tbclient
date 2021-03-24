package com.baidu.sofire.core;

import android.content.IntentFilter;
import android.text.TextUtils;
/* loaded from: classes3.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public String f11707a;

    /* renamed from: b  reason: collision with root package name */
    public String f11708b;

    /* renamed from: c  reason: collision with root package name */
    public String f11709c;

    /* renamed from: d  reason: collision with root package name */
    public IntentFilter f11710d;

    public g(String str, IntentFilter intentFilter, String str2, String str3) {
        this.f11707a = str;
        this.f11710d = intentFilter;
        this.f11708b = str2;
        this.f11709c = str3;
    }

    public final boolean a(g gVar) {
        if (gVar != null) {
            try {
                if (!TextUtils.isEmpty(gVar.f11707a) && !TextUtils.isEmpty(gVar.f11708b) && !TextUtils.isEmpty(gVar.f11709c) && gVar.f11707a.equals(this.f11707a) && gVar.f11708b.equals(this.f11708b) && gVar.f11709c.equals(this.f11709c)) {
                    if (gVar.f11710d != null && this.f11710d != null) {
                        return this.f11710d == gVar.f11710d;
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
            return "PluginloaderIntentFilter:" + this.f11707a + "-" + this.f11708b + "-" + this.f11709c + "-" + this.f11710d;
        } catch (Throwable unused) {
            return "";
        }
    }
}
