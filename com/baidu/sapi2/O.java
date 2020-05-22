package com.baidu.sapi2;

import android.content.Context;
import com.baidu.sapi2.V;
import com.baidu.sapi2.X;
/* loaded from: classes6.dex */
class O implements V.a {
    final /* synthetic */ Context a;
    final /* synthetic */ V b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public O(V v, Context context) {
        this.b = v;
        this.a = context;
    }

    @Override // com.baidu.sapi2.V.a
    public void a(X.a.C0260a c0260a, String str) {
        this.b.a(c0260a.a, str);
    }

    @Override // com.baidu.sapi2.V.a
    public void a(X.a.C0260a c0260a) {
        this.b.a(this.a, c0260a);
    }
}
