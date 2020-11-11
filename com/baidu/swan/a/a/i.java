package com.baidu.swan.a.a;

import com.baidu.searchbox.http.AbstractHttpManager;
import com.baidu.searchbox.http.request.PutBodyRequest;
/* loaded from: classes8.dex */
public class i extends PutBodyRequest.PutBodyRequestBuilder {
    public i(AbstractHttpManager abstractHttpManager) {
        super(abstractHttpManager);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.PutBodyRequest.PutBodyRequestBuilder, com.baidu.searchbox.http.request.HttpRequestBuilder
    public PutBodyRequest build() {
        com.baidu.swan.a.b.baG().a(this.httpUrl.toString(), this);
        return super.build();
    }
}
