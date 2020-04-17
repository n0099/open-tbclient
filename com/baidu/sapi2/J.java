package com.baidu.sapi2;

import android.content.Context;
import com.baidu.sapi2.P;
import com.baidu.sapi2.S;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class J implements P.a {
    final /* synthetic */ Context a;
    final /* synthetic */ P b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public J(P p, Context context) {
        this.b = p;
        this.a = context;
    }

    @Override // com.baidu.sapi2.P.a
    public void a(S.a.C0203a c0203a, String str) {
        this.b.a(c0203a.a, str);
    }

    @Override // com.baidu.sapi2.P.a
    public void a(S.a.C0203a c0203a) {
        this.b.a(this.a, c0203a);
    }
}
