package com.baidu.sofire.core;

import android.content.IntentFilter;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public String f10284a;

    /* renamed from: b  reason: collision with root package name */
    public String f10285b;

    /* renamed from: c  reason: collision with root package name */
    public String f10286c;

    /* renamed from: d  reason: collision with root package name */
    public IntentFilter f10287d;

    public g(String str, IntentFilter intentFilter, String str2, String str3) {
        this.f10284a = str;
        this.f10287d = intentFilter;
        this.f10285b = str2;
        this.f10286c = str3;
    }

    public final boolean a(g gVar) {
        if (gVar != null) {
            try {
                if (!TextUtils.isEmpty(gVar.f10284a) && !TextUtils.isEmpty(gVar.f10285b) && !TextUtils.isEmpty(gVar.f10286c) && gVar.f10284a.equals(this.f10284a) && gVar.f10285b.equals(this.f10285b) && gVar.f10286c.equals(this.f10286c)) {
                    if (gVar.f10287d != null && this.f10287d != null) {
                        return this.f10287d == gVar.f10287d;
                    }
                    return true;
                }
                return false;
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
            }
        }
        return false;
    }

    public final String toString() {
        try {
            return "PluginloaderIntentFilter:" + this.f10284a + "-" + this.f10285b + "-" + this.f10286c + "-" + this.f10287d;
        } catch (Throwable unused) {
            return "";
        }
    }
}
