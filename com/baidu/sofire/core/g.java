package com.baidu.sofire.core;

import android.content.IntentFilter;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public String f10266a;

    /* renamed from: b  reason: collision with root package name */
    public String f10267b;

    /* renamed from: c  reason: collision with root package name */
    public String f10268c;

    /* renamed from: d  reason: collision with root package name */
    public IntentFilter f10269d;

    public g(String str, IntentFilter intentFilter, String str2, String str3) {
        this.f10266a = str;
        this.f10269d = intentFilter;
        this.f10267b = str2;
        this.f10268c = str3;
    }

    public final boolean a(g gVar) {
        if (gVar != null) {
            try {
                if (!TextUtils.isEmpty(gVar.f10266a) && !TextUtils.isEmpty(gVar.f10267b) && !TextUtils.isEmpty(gVar.f10268c) && gVar.f10266a.equals(this.f10266a) && gVar.f10267b.equals(this.f10267b) && gVar.f10268c.equals(this.f10268c)) {
                    if (gVar.f10269d != null && this.f10269d != null) {
                        return this.f10269d == gVar.f10269d;
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
            return "PluginloaderIntentFilter:" + this.f10266a + "-" + this.f10267b + "-" + this.f10268c + "-" + this.f10269d;
        } catch (Throwable unused) {
            return "";
        }
    }
}
