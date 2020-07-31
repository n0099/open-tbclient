package com.baidu.swan.b.a;

import com.baidu.searchbox.http.AbstractHttpManager;
import com.baidu.swan.b.d.b;
/* loaded from: classes10.dex */
public class e extends b.a {
    public e(AbstractHttpManager abstractHttpManager) {
        super(abstractHttpManager);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.b.d.b.a, com.baidu.searchbox.http.request.HttpRequestBuilder
    /* renamed from: aKs */
    public com.baidu.swan.b.d.b build() {
        com.baidu.swan.b.b.aKq().a(this.httpUrl.toString(), this);
        return super.build();
    }
}
