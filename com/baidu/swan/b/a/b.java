package com.baidu.swan.b.a;

import com.baidu.searchbox.http.AbstractHttpManager;
import com.baidu.searchbox.http.request.DeleteRequest;
/* loaded from: classes10.dex */
public class b extends DeleteRequest.DeleteRequestBuilder {
    public b(AbstractHttpManager abstractHttpManager) {
        super(abstractHttpManager);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.DeleteRequest.DeleteRequestBuilder, com.baidu.searchbox.http.request.HttpRequestBuilder
    public DeleteRequest build() {
        com.baidu.swan.b.b.aKq().a(this.httpUrl.toString(), this);
        return super.build();
    }
}
