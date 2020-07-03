package com.baidu.swan.c.a;

import com.baidu.searchbox.http.AbstractHttpManager;
import com.baidu.searchbox.http.request.HeadRequest;
/* loaded from: classes11.dex */
public class d extends HeadRequest.HeadRequestBuilder {
    public d(AbstractHttpManager abstractHttpManager) {
        super(abstractHttpManager);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HeadRequest.HeadRequestBuilder, com.baidu.searchbox.http.request.HttpRequestBuilder
    public HeadRequest build() {
        com.baidu.swan.c.b.aGz().a(this.httpUrl.toString(), this);
        return super.build();
    }
}
