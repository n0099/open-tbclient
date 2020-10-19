package com.baidu.sofire.core;

import android.content.IntentFilter;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes15.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public String f3613a;
    public String b;
    public String c;
    public IntentFilter d;

    public g(String str, IntentFilter intentFilter, String str2, String str3) {
        this.f3613a = str;
        this.d = intentFilter;
        this.b = str2;
        this.c = str3;
    }

    public final boolean a(g gVar) {
        if (gVar != null) {
            try {
                if (!TextUtils.isEmpty(gVar.f3613a) && !TextUtils.isEmpty(gVar.b) && !TextUtils.isEmpty(gVar.c)) {
                    if (gVar.f3613a.equals(this.f3613a) && gVar.b.equals(this.b) && gVar.c.equals(this.c)) {
                        if (gVar.d == null || this.d == null) {
                            return true;
                        }
                        return this.d == gVar.d;
                    }
                    return false;
                }
            } catch (Throwable th) {
                com.baidu.sofire.i.e.a();
                return false;
            }
        }
        return false;
    }

    public final String toString() {
        try {
            return "PluginloaderIntentFilter:" + this.f3613a + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.b + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.c + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.d;
        } catch (Throwable th) {
            return "";
        }
    }
}
