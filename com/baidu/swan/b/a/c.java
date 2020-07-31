package com.baidu.swan.b.a;

import com.baidu.searchbox.http.AbstractHttpManager;
import com.baidu.searchbox.http.request.GetRequest;
/* loaded from: classes10.dex */
public class c extends GetRequest.GetRequestBuilder {
    public c(AbstractHttpManager abstractHttpManager) {
        super(abstractHttpManager);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.GetRequest.GetRequestBuilder, com.baidu.searchbox.http.request.HttpRequestBuilder
    public GetRequest build() {
        com.baidu.swan.b.b.aKq().a(this.httpUrl.toString(), this);
        return super.build();
    }
}
