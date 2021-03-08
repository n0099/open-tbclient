package com.baidu.android.pushservice.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.baidu.android.pushservice.h.a.b;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import java.io.File;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    protected Context f1083a;
    protected String b;
    protected String c;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(Context context) {
        this.f1083a = context;
    }

    public boolean a() {
        String a2 = new File(this.c).exists() ? a.a(this.f1083a, this.c) : a.a();
        if (!TextUtils.isEmpty(a2)) {
            try {
                byte[] decode = Base64.decode(a2.getBytes(), 2);
                if (decode != null && decode.length > 0) {
                    this.b = new String(BaiduAppSSOJni.decryptAES(decode, decode.length, 0), "utf-8");
                }
            } catch (Exception e) {
                new b.c(this.f1083a).a(Log.getStackTraceString(e)).a();
            } catch (UnsatisfiedLinkError e2) {
                new b.c(this.f1083a).a(Log.getStackTraceString(e2)).a();
            }
        }
        return !TextUtils.isEmpty(this.b);
    }

    public boolean a(Context context, String str) {
        return a.a(context, this.c, str);
    }
}
