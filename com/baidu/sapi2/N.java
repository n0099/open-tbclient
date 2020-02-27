package com.baidu.sapi2;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.sapi2.P;
import com.baidu.sapi2.S;
import com.baidu.sapi2.httpwrap.HttpClientWrap;
import com.baidu.sapi2.httpwrap.HttpHashMapWrap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class N implements P.a {
    final /* synthetic */ S.a.C0172a a;
    final /* synthetic */ S b;
    final /* synthetic */ S.a c;
    final /* synthetic */ P d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public N(P p, S.a.C0172a c0172a, S s, S.a aVar) {
        this.d = p;
        this.a = c0172a;
        this.b = s;
        this.c = aVar;
    }

    @Override // com.baidu.sapi2.P.a
    public void a(S.a.C0172a c0172a, String str) {
        Context context;
        if (TextUtils.isEmpty(this.a.a) || TextUtils.isEmpty(str)) {
            return;
        }
        this.d.a(this.a.a, str);
        P p = this.d;
        context = p.d;
        p.a(context, S.a.C0172a.c(this.a.a), str.getBytes());
    }

    @Override // com.baidu.sapi2.P.a
    public void a(S.a.C0172a c0172a) {
        new HttpClientWrap().get(this.a.b, new HttpHashMapWrap(), null, null, new M(this, true));
    }
}
