package com.baidu.sapi2;

import android.content.Context;
import com.baidu.sapi2.V;
import com.baidu.sapi2.X;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class P implements V.a {
    final /* synthetic */ V a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public P(V v) {
        this.a = v;
    }

    @Override // com.baidu.sapi2.V.a
    public void a(X.a.C0260a c0260a, String str) {
        this.a.a(c0260a.a, str);
    }

    @Override // com.baidu.sapi2.V.a
    public void a(X.a.C0260a c0260a) {
        Context context;
        V v = this.a;
        context = v.d;
        v.a(context, c0260a);
    }
}
