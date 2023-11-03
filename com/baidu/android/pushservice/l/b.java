package com.baidu.android.pushservice.l;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import java.io.File;
/* loaded from: classes.dex */
public class b {
    public Context a;
    public String b;
    public String c;

    public b(Context context) {
        this.a = context;
    }

    public boolean a() {
        String b = new File(this.c).exists() ? a.b(this.a, this.c) : a.a();
        if (!TextUtils.isEmpty(b)) {
            try {
                byte[] decode = Base64.decode(b.getBytes(), 2);
                if (decode != null && decode.length > 0) {
                    this.b = new String(BaiduAppSSOJni.decryptAES(decode, decode.length, 0), "utf-8");
                }
            } catch (Exception | UnsatisfiedLinkError unused) {
            }
        }
        return !TextUtils.isEmpty(this.b);
    }

    public boolean a(Context context, String str) {
        return a.a(context, this.c, str);
    }
}
