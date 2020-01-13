package com.baidu.sapi2;

import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
/* loaded from: classes5.dex */
class M extends HttpHandlerWrap {
    final /* synthetic */ N a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public M(N n, boolean z) {
        super(z);
        this.a = n;
    }

    @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
    public void onFailure(Throwable th, int i, String str) {
        N n = this.a;
        n.b.a(n.c);
        SapiContext.getInstance().setSapiOptions(this.a.b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
    public void onSuccess(int i, String str) {
        N n = this.a;
        n.d.a(str, n.a);
    }
}
