package com.baidu.sapi2;

import android.content.Context;
import com.baidu.sapi2.P;
import com.baidu.sapi2.S;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class O implements P.a {
    final /* synthetic */ P a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public O(P p) {
        this.a = p;
    }

    @Override // com.baidu.sapi2.P.a
    public void a(S.a.C0134a c0134a) {
        Context context;
        Context context2;
        Context context3;
        String c = S.a.C0134a.c(c0134a.a);
        String b = S.a.C0134a.b(c0134a.a);
        context = this.a.d;
        if (new File(context.getFilesDir(), c).exists()) {
            try {
                P p = this.a;
                context2 = this.a.d;
                String d = p.d(context2, c);
                context3 = this.a.d;
                if (SapiUtils.checkRequestPermission("android.permission.WRITE_EXTERNAL_STORAGE", context3)) {
                    this.a.a(b, d.getBytes());
                }
            } catch (Throwable th) {
                Log.e(th);
            }
        }
    }

    @Override // com.baidu.sapi2.P.a
    public void a(S.a.C0134a c0134a, String str) {
    }
}
