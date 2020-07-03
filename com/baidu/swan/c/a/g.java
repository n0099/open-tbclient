package com.baidu.swan.c.a;

import com.baidu.searchbox.http.AbstractHttpManager;
import com.baidu.searchbox.http.request.PostFormRequest;
/* loaded from: classes11.dex */
public class g extends PostFormRequest.PostFormRequestBuilder {
    public g(AbstractHttpManager abstractHttpManager) {
        super(abstractHttpManager);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.PostFormRequest.PostFormRequestBuilder, com.baidu.searchbox.http.request.HttpRequestBuilder
    public PostFormRequest build() {
        com.baidu.swan.c.b.aGz().a(this.httpUrl.toString(), this);
        return super.build();
    }
}
