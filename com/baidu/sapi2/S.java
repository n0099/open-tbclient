package com.baidu.sapi2;

import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
/* loaded from: classes19.dex */
class S extends HttpHandlerWrap {
    final /* synthetic */ T a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public S(T t, boolean z) {
        super(z);
        this.a = t;
    }

    @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
    public void onFailure(Throwable th, int i, String str) {
        T t = this.a;
        t.b.a(t.c);
        SapiContext.getInstance().setSapiOptions(this.a.b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
    public void onSuccess(int i, String str) {
        T t = this.a;
        t.d.a(str, t.a);
    }
}
