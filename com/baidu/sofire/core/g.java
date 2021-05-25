package com.baidu.sofire.core;

import android.content.IntentFilter;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public String f10167a;

    /* renamed from: b  reason: collision with root package name */
    public String f10168b;

    /* renamed from: c  reason: collision with root package name */
    public String f10169c;

    /* renamed from: d  reason: collision with root package name */
    public IntentFilter f10170d;

    public g(String str, IntentFilter intentFilter, String str2, String str3) {
        this.f10167a = str;
        this.f10170d = intentFilter;
        this.f10168b = str2;
        this.f10169c = str3;
    }

    public final boolean a(g gVar) {
        if (gVar != null) {
            try {
                if (!TextUtils.isEmpty(gVar.f10167a) && !TextUtils.isEmpty(gVar.f10168b) && !TextUtils.isEmpty(gVar.f10169c) && gVar.f10167a.equals(this.f10167a) && gVar.f10168b.equals(this.f10168b) && gVar.f10169c.equals(this.f10169c)) {
                    if (gVar.f10170d != null && this.f10170d != null) {
                        return this.f10170d == gVar.f10170d;
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
            return "PluginloaderIntentFilter:" + this.f10167a + "-" + this.f10168b + "-" + this.f10169c + "-" + this.f10170d;
        } catch (Throwable unused) {
            return "";
        }
    }
}
