package com.baidu.sapi2;

import android.content.Context;
import com.baidu.sapi2.P;
import com.baidu.sapi2.S;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class K implements P.a {
    final /* synthetic */ P a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public K(P p) {
        this.a = p;
    }

    @Override // com.baidu.sapi2.P.a
    public void a(S.a.C0163a c0163a, String str) {
        this.a.a(c0163a.a, str);
    }

    @Override // com.baidu.sapi2.P.a
    public void a(S.a.C0163a c0163a) {
        Context context;
        P p = this.a;
        context = p.d;
        p.a(context, c0163a);
    }
}
