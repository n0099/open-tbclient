package com.baidu.sapi2;

import android.content.Context;
import com.baidu.sapi2.V;
import com.baidu.sapi2.X;
/* loaded from: classes19.dex */
class O implements V.a {
    final /* synthetic */ Context a;
    final /* synthetic */ V b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public O(V v, Context context) {
        this.b = v;
        this.a = context;
    }

    @Override // com.baidu.sapi2.V.a
    public void a(X.a.C0269a c0269a, String str) {
        this.b.a(c0269a.a, str);
    }

    @Override // com.baidu.sapi2.V.a
    public void a(X.a.C0269a c0269a) {
        this.b.a(this.a, c0269a);
    }
}
