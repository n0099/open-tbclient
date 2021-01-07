package com.baidu.swan.a.a;

import com.baidu.searchbox.http.AbstractHttpManager;
import com.baidu.searchbox.http.request.PostBodyRequest;
/* loaded from: classes3.dex */
public class f extends PostBodyRequest.PostBodyRequestBuilder {
    public f(AbstractHttpManager abstractHttpManager) {
        super(abstractHttpManager);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.PostBodyRequest.PostBodyRequestBuilder, com.baidu.searchbox.http.request.HttpRequestBuilder
    public PostBodyRequest build() {
        com.baidu.swan.a.b.bfB().a(this.httpUrl.toString(), this);
        return super.build();
    }
}
