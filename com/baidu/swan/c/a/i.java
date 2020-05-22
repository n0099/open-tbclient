package com.baidu.swan.c.a;

import com.baidu.searchbox.http.AbstractHttpManager;
import com.baidu.searchbox.http.request.PutBodyRequest;
/* loaded from: classes11.dex */
public class i extends PutBodyRequest.PutBodyRequestBuilder {
    public i(AbstractHttpManager abstractHttpManager) {
        super(abstractHttpManager);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.PutBodyRequest.PutBodyRequestBuilder, com.baidu.searchbox.http.request.HttpRequestBuilder
    public PutBodyRequest build() {
        com.baidu.swan.c.b.aFt().a(this.httpUrl.toString(), this);
        return super.build();
    }
}
