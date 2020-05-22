package com.baidu.sapi2;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.sapi2.V;
import com.baidu.sapi2.X;
import com.baidu.sapi2.httpwrap.HttpClientWrap;
import com.baidu.sapi2.httpwrap.HttpHashMapWrap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class T implements V.a {
    final /* synthetic */ X.a.C0260a a;
    final /* synthetic */ X b;
    final /* synthetic */ X.a c;
    final /* synthetic */ V d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public T(V v, X.a.C0260a c0260a, X x, X.a aVar) {
        this.d = v;
        this.a = c0260a;
        this.b = x;
        this.c = aVar;
    }

    @Override // com.baidu.sapi2.V.a
    public void a(X.a.C0260a c0260a, String str) {
        Context context;
        if (TextUtils.isEmpty(this.a.a) || TextUtils.isEmpty(str)) {
            return;
        }
        this.d.a(this.a.a, str);
        V v = this.d;
        context = v.d;
        v.a(context, X.a.C0260a.c(this.a.a), str.getBytes());
    }

    @Override // com.baidu.sapi2.V.a
    public void a(X.a.C0260a c0260a) {
        new HttpClientWrap().get(this.a.b, new HttpHashMapWrap(), null, null, new S(this, true));
    }
}
