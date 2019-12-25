package com.baidu.android.pushservice.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import java.io.File;
/* loaded from: classes5.dex */
public class b {
    protected Context a;
    protected String b;
    protected String c;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(Context context) {
        this.a = context;
    }

    public boolean a() {
        String a = new File(this.c).exists() ? a.a(this.c) : a.a();
        if (!TextUtils.isEmpty(a)) {
            try {
                byte[] a2 = com.baidu.android.pushservice.j.b.a(a.getBytes());
                if (a2 != null && a2.length > 0) {
                    this.b = new String(BaiduAppSSOJni.decryptAES(a2, a2.length, 0));
                }
            } catch (Exception e) {
            } catch (UnsatisfiedLinkError e2) {
            }
        }
        return !TextUtils.isEmpty(this.b);
    }

    public boolean a(String str) {
        return a.a(this.c, str);
    }
}
