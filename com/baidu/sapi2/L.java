package com.baidu.sapi2;

import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidubce.http.Headers;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class L extends HttpHandlerWrap {
    final /* synthetic */ S a;
    final /* synthetic */ P b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public L(P p, boolean z, S s) {
        super(z);
        this.b = p;
        this.a = s;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
    public void onFailure(Throwable th, int i, String str) {
        this.b.c(this.a);
        this.b.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
    public void onSuccess(int i, String str, HashMap<String, String> hashMap) {
        if (str != null) {
            this.b.a(str, this.a);
            if (hashMap != null) {
                SapiContext.getInstance().put(SapiContext.KEY_CONFIG_FILE_ETAG, hashMap.get(Headers.ETAG));
            }
            this.b.b();
        }
    }
}
