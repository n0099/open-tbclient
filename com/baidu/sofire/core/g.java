package com.baidu.sofire.core;

import android.content.IntentFilter;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public String f10229a;

    /* renamed from: b  reason: collision with root package name */
    public String f10230b;

    /* renamed from: c  reason: collision with root package name */
    public String f10231c;

    /* renamed from: d  reason: collision with root package name */
    public IntentFilter f10232d;

    public g(String str, IntentFilter intentFilter, String str2, String str3) {
        this.f10229a = str;
        this.f10232d = intentFilter;
        this.f10230b = str2;
        this.f10231c = str3;
    }

    public final boolean a(g gVar) {
        if (gVar != null) {
            try {
                if (!TextUtils.isEmpty(gVar.f10229a) && !TextUtils.isEmpty(gVar.f10230b) && !TextUtils.isEmpty(gVar.f10231c) && gVar.f10229a.equals(this.f10229a) && gVar.f10230b.equals(this.f10230b) && gVar.f10231c.equals(this.f10231c)) {
                    if (gVar.f10232d != null && this.f10232d != null) {
                        return this.f10232d == gVar.f10232d;
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
            return "PluginloaderIntentFilter:" + this.f10229a + "-" + this.f10230b + "-" + this.f10231c + "-" + this.f10232d;
        } catch (Throwable unused) {
            return "";
        }
    }
}
