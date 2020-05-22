package com.baidu.swan.c.a;

import com.baidu.searchbox.http.AbstractHttpManager;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.searchbox.http.request.PostStringRequest;
/* loaded from: classes11.dex */
public class h extends PostStringRequest.PostStringRequestBuilder {
    public h(AbstractHttpManager abstractHttpManager) {
        super(abstractHttpManager);
    }

    @Override // com.baidu.searchbox.http.request.PostStringRequest.PostStringRequestBuilder, com.baidu.searchbox.http.request.HttpRequestBuilder
    public HttpRequest build() {
        com.baidu.swan.c.b.aFt().a(this.httpUrl.toString(), this);
        return super.build();
    }
}
