package com.baidu.sofire.core;

import android.content.IntentFilter;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class h {
    public String a;
    public String b;
    public String c;
    public IntentFilter d;

    public h(String str, IntentFilter intentFilter, String str2, String str3) {
        this.a = str;
        this.d = intentFilter;
        this.b = str2;
        this.c = str3;
    }

    public boolean a(h hVar) {
        if (hVar != null) {
            try {
                if (TextUtils.isEmpty(hVar.a) || TextUtils.isEmpty(hVar.b) || TextUtils.isEmpty(hVar.c) || !hVar.a.equals(this.a) || !hVar.b.equals(this.b) || !hVar.c.equals(this.c)) {
                    return false;
                }
                if (hVar.d == null || this.d == null) {
                    return true;
                }
                return this.d == hVar.d;
            } catch (Throwable th) {
                com.baidu.sofire.b.e.a(th);
                return false;
            }
        }
        return false;
    }

    public String toString() {
        try {
            return "PluginloaderIntentFilter:" + this.a + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.b + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.c + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.d;
        } catch (Throwable th) {
            return "";
        }
    }
}
