package com.baidu.swan.c.a;

import com.baidu.searchbox.http.AbstractHttpManager;
import com.baidu.searchbox.http.request.DeleteRequest;
/* loaded from: classes11.dex */
public class b extends DeleteRequest.DeleteRequestBuilder {
    public b(AbstractHttpManager abstractHttpManager) {
        super(abstractHttpManager);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.DeleteRequest.DeleteRequestBuilder, com.baidu.searchbox.http.request.HttpRequestBuilder
    public DeleteRequest build() {
        com.baidu.swan.c.b.aFt().a(this.httpUrl.toString(), this);
        return super.build();
    }
}
