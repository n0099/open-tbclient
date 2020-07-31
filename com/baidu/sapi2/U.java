package com.baidu.sapi2;

import android.content.Context;
import com.baidu.sapi2.V;
import com.baidu.sapi2.X;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes19.dex */
public class U implements V.a {
    final /* synthetic */ V a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public U(V v) {
        this.a = v;
    }

    @Override // com.baidu.sapi2.V.a
    public void a(X.a.C0269a c0269a) {
        Context context;
        Context context2;
        Context context3;
        String c = X.a.C0269a.c(c0269a.a);
        String b = X.a.C0269a.b(c0269a.a);
        context = this.a.d;
        if (new File(context.getFilesDir(), c).exists()) {
            try {
                V v = this.a;
                context2 = this.a.d;
                String d = v.d(context2, c);
                context3 = this.a.d;
                if (SapiUtils.checkRequestPermission("android.permission.WRITE_EXTERNAL_STORAGE", context3)) {
                    this.a.a(b, d.getBytes());
                }
            } catch (Throwable th) {
                Log.e(th);
            }
        }
    }

    @Override // com.baidu.sapi2.V.a
    public void a(X.a.C0269a c0269a, String str) {
    }
}
