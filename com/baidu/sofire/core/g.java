package com.baidu.sofire.core;

import android.content.IntentFilter;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public String f11377a;

    /* renamed from: b  reason: collision with root package name */
    public String f11378b;

    /* renamed from: c  reason: collision with root package name */
    public String f11379c;

    /* renamed from: d  reason: collision with root package name */
    public IntentFilter f11380d;

    public g(String str, IntentFilter intentFilter, String str2, String str3) {
        this.f11377a = str;
        this.f11380d = intentFilter;
        this.f11378b = str2;
        this.f11379c = str3;
    }

    public final boolean a(g gVar) {
        if (gVar != null) {
            try {
                if (!TextUtils.isEmpty(gVar.f11377a) && !TextUtils.isEmpty(gVar.f11378b) && !TextUtils.isEmpty(gVar.f11379c) && gVar.f11377a.equals(this.f11377a) && gVar.f11378b.equals(this.f11378b) && gVar.f11379c.equals(this.f11379c)) {
                    if (gVar.f11380d != null && this.f11380d != null) {
                        return this.f11380d == gVar.f11380d;
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
            return "PluginloaderIntentFilter:" + this.f11377a + "-" + this.f11378b + "-" + this.f11379c + "-" + this.f11380d;
        } catch (Throwable unused) {
            return "";
        }
    }
}
