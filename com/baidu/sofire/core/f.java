package com.baidu.sofire.core;

import android.content.IntentFilter;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public final class f {
    public IntentFilter QC;
    public String a;
    public String b;
    public String c;

    public f(String str, IntentFilter intentFilter, String str2, String str3) {
        this.a = str;
        this.QC = intentFilter;
        this.b = str2;
        this.c = str3;
    }

    public final boolean c(f fVar) {
        if (fVar != null) {
            try {
                if (!TextUtils.isEmpty(fVar.a) && !TextUtils.isEmpty(fVar.b) && !TextUtils.isEmpty(fVar.c)) {
                    if (fVar.a.equals(this.a) && fVar.b.equals(this.b) && fVar.c.equals(this.c)) {
                        if (fVar.QC == null || this.QC == null) {
                            return true;
                        }
                        return this.QC == fVar.QC;
                    }
                    return false;
                }
            } catch (Throwable th) {
                com.baidu.sofire.b.d.a(th);
                return false;
            }
        }
        return false;
    }

    public final String toString() {
        try {
            return "PluginloaderIntentFilter:" + this.a + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.b + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.c + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.QC;
        } catch (Throwable th) {
            return "";
        }
    }
}
