package com.baidu.sofire.core;

import android.content.IntentFilter;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public String f11199a;

    /* renamed from: b  reason: collision with root package name */
    public String f11200b;

    /* renamed from: c  reason: collision with root package name */
    public String f11201c;

    /* renamed from: d  reason: collision with root package name */
    public IntentFilter f11202d;

    public g(String str, IntentFilter intentFilter, String str2, String str3) {
        this.f11199a = str;
        this.f11202d = intentFilter;
        this.f11200b = str2;
        this.f11201c = str3;
    }

    public final boolean a(g gVar) {
        if (gVar != null) {
            try {
                if (!TextUtils.isEmpty(gVar.f11199a) && !TextUtils.isEmpty(gVar.f11200b) && !TextUtils.isEmpty(gVar.f11201c) && gVar.f11199a.equals(this.f11199a) && gVar.f11200b.equals(this.f11200b) && gVar.f11201c.equals(this.f11201c)) {
                    if (gVar.f11202d != null && this.f11202d != null) {
                        return this.f11202d == gVar.f11202d;
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
            return "PluginloaderIntentFilter:" + this.f11199a + "-" + this.f11200b + "-" + this.f11201c + "-" + this.f11202d;
        } catch (Throwable unused) {
            return "";
        }
    }
}
