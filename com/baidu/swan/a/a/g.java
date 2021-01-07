package com.baidu.swan.a.a;

import com.baidu.searchbox.http.AbstractHttpManager;
import com.baidu.searchbox.http.request.PostFormRequest;
/* loaded from: classes3.dex */
public class g extends PostFormRequest.PostFormRequestBuilder {
    public g(AbstractHttpManager abstractHttpManager) {
        super(abstractHttpManager);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.PostFormRequest.PostFormRequestBuilder, com.baidu.searchbox.http.request.HttpRequestBuilder
    public PostFormRequest build() {
        com.baidu.swan.a.b.bfB().a(this.httpUrl.toString(), this);
        return super.build();
    }
}
