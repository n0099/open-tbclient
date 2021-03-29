package com.baidu.sofire.core;

import android.content.IntentFilter;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public String f11708a;

    /* renamed from: b  reason: collision with root package name */
    public String f11709b;

    /* renamed from: c  reason: collision with root package name */
    public String f11710c;

    /* renamed from: d  reason: collision with root package name */
    public IntentFilter f11711d;

    public g(String str, IntentFilter intentFilter, String str2, String str3) {
        this.f11708a = str;
        this.f11711d = intentFilter;
        this.f11709b = str2;
        this.f11710c = str3;
    }

    public final boolean a(g gVar) {
        if (gVar != null) {
            try {
                if (!TextUtils.isEmpty(gVar.f11708a) && !TextUtils.isEmpty(gVar.f11709b) && !TextUtils.isEmpty(gVar.f11710c) && gVar.f11708a.equals(this.f11708a) && gVar.f11709b.equals(this.f11709b) && gVar.f11710c.equals(this.f11710c)) {
                    if (gVar.f11711d != null && this.f11711d != null) {
                        return this.f11711d == gVar.f11711d;
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
            return "PluginloaderIntentFilter:" + this.f11708a + "-" + this.f11709b + "-" + this.f11710c + "-" + this.f11711d;
        } catch (Throwable unused) {
            return "";
        }
    }
}
