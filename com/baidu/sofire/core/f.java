package com.baidu.sofire.core;

import android.content.IntentFilter;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public final class f {
    public IntentFilter PR;
    public String a;
    public String b;
    public String c;

    public f(String str, IntentFilter intentFilter, String str2, String str3) {
        this.a = str;
        this.PR = intentFilter;
        this.b = str2;
        this.c = str3;
    }

    public final boolean c(f fVar) {
        if (fVar == null || TextUtils.isEmpty(fVar.a) || TextUtils.isEmpty(fVar.b) || TextUtils.isEmpty(fVar.c)) {
            return false;
        }
        if (fVar.a.equals(this.a) && fVar.b.equals(this.b) && fVar.c.equals(this.c)) {
            return fVar.PR == null || this.PR == null || this.PR == fVar.PR;
        }
        return false;
    }

    public final String toString() {
        try {
            return "PluginloaderIntentFilter:" + this.a + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.b + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.c + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.PR;
        } catch (Throwable th) {
            return "";
        }
    }
}
