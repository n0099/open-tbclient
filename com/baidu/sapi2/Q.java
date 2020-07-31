package com.baidu.sapi2;

import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidubce.http.Headers;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes19.dex */
public class Q extends HttpHandlerWrap {
    final /* synthetic */ X a;
    final /* synthetic */ V b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Q(V v, boolean z, X x) {
        super(z);
        this.b = v;
        this.a = x;
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
