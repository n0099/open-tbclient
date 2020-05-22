package com.baidu.swan.c.a;

import com.baidu.searchbox.http.AbstractHttpManager;
import com.baidu.swan.c.d.b;
/* loaded from: classes11.dex */
public class e extends b.a {
    public e(AbstractHttpManager abstractHttpManager) {
        super(abstractHttpManager);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.c.d.b.a, com.baidu.searchbox.http.request.HttpRequestBuilder
    /* renamed from: aFv */
    public com.baidu.swan.c.d.b build() {
        com.baidu.swan.c.b.aFt().a(this.httpUrl.toString(), this);
        return super.build();
    }
}
