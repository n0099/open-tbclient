package com.baidu.swan.b.a;

import com.baidu.searchbox.http.AbstractHttpManager;
import com.baidu.swan.b.d.c;
/* loaded from: classes10.dex */
public class j extends c.a {
    public j(AbstractHttpManager abstractHttpManager) {
        super(abstractHttpManager);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.b.d.c.a, com.baidu.searchbox.http.request.HttpRequestBuilder
    /* renamed from: aKt */
    public com.baidu.swan.b.d.c build() {
        com.baidu.swan.b.b.aKq().a(this.httpUrl.toString(), this);
        return super.build();
    }
}
