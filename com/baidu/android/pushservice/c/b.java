package com.baidu.android.pushservice.c;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import java.io.File;
/* loaded from: classes2.dex */
public class b {
    protected Context a;
    protected String b;
    protected String c;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(Context context) {
        this.a = context;
    }

    public boolean a() {
        String a;
        if (new File(this.c).exists()) {
            a = a.a(this.c);
            com.baidu.android.pushservice.g.a.c("BaseConfig", "load config from " + this.c);
        } else {
            a = a.a();
            com.baidu.android.pushservice.g.a.c("BaseConfig", "load config from defaultConfig");
        }
        if (!TextUtils.isEmpty(a)) {
            try {
                byte[] a2 = com.baidu.android.pushservice.k.b.a(a.getBytes());
                if (a2 != null && a2.length > 0) {
                    this.b = new String(BaiduAppSSOJni.decryptAES(a2, a2.length, 0));
                }
            } catch (Exception e) {
                com.baidu.android.pushservice.g.a.a("BaseConfig", e);
            } catch (UnsatisfiedLinkError e2) {
                com.baidu.android.pushservice.g.a.a("BaseConfig", e2);
            }
        }
        com.baidu.android.pushservice.g.a.c("BaseConfig", "the config content = " + this.b);
        return !TextUtils.isEmpty(this.b);
    }

    public boolean a(String str) {
        return a.a(this.c, str);
    }
}
