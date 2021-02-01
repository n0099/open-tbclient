package com.baidu.swan.a.a;

import com.baidu.searchbox.http.AbstractHttpManager;
import com.baidu.searchbox.http.request.PostBodyRequest;
/* loaded from: classes15.dex */
public class f extends PostBodyRequest.PostBodyRequestBuilder {
    public f(AbstractHttpManager abstractHttpManager) {
        super(abstractHttpManager);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.PostBodyRequest.PostBodyRequestBuilder, com.baidu.searchbox.http.request.HttpRequestBuilder
    public PostBodyRequest build() {
        com.baidu.swan.a.b.bbU().a(this.httpUrl.toString(), this);
        return super.build();
    }
}
