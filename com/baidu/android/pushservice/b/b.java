package com.baidu.android.pushservice.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.baidu.android.pushservice.i.a.b;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import java.io.File;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Context f2728a;

    /* renamed from: b  reason: collision with root package name */
    public String f2729b;

    /* renamed from: c  reason: collision with root package name */
    public String f2730c;

    public b(Context context) {
        this.f2728a = context;
    }

    public boolean a() {
        b.c cVar;
        String a2 = new File(this.f2730c).exists() ? a.a(this.f2728a, this.f2730c) : a.a();
        if (!TextUtils.isEmpty(a2)) {
            try {
                byte[] decode = Base64.decode(a2.getBytes(), 2);
                if (decode != null && decode.length > 0) {
                    this.f2729b = new String(BaiduAppSSOJni.decryptAES(decode, decode.length, 0), "utf-8");
                }
            } catch (Exception e2) {
                e = e2;
                cVar = new b.c(this.f2728a);
                cVar.a(Log.getStackTraceString(e)).a();
                return !TextUtils.isEmpty(this.f2729b);
            } catch (UnsatisfiedLinkError e3) {
                e = e3;
                cVar = new b.c(this.f2728a);
                cVar.a(Log.getStackTraceString(e)).a();
                return !TextUtils.isEmpty(this.f2729b);
            }
        }
        return !TextUtils.isEmpty(this.f2729b);
    }

    public boolean a(Context context, String str) {
        return a.a(context, this.f2730c, str);
    }
}
