package com.baidu.swan.c.a;

import com.baidu.searchbox.http.AbstractHttpManager;
import com.baidu.searchbox.http.request.GetRequest;
/* loaded from: classes11.dex */
public class c extends GetRequest.GetRequestBuilder {
    public c(AbstractHttpManager abstractHttpManager) {
        super(abstractHttpManager);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.GetRequest.GetRequestBuilder, com.baidu.searchbox.http.request.HttpRequestBuilder
    public GetRequest build() {
        com.baidu.swan.c.b.aGz().a(this.httpUrl.toString(), this);
        return super.build();
    }
}
