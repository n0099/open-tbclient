package com.baidu.swan.c.a;

import com.baidu.searchbox.http.AbstractHttpManager;
import com.baidu.swan.c.d.c;
/* loaded from: classes11.dex */
public class j extends c.a {
    public j(AbstractHttpManager abstractHttpManager) {
        super(abstractHttpManager);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.c.d.c.a, com.baidu.searchbox.http.request.HttpRequestBuilder
    /* renamed from: aFw */
    public com.baidu.swan.c.d.c build() {
        com.baidu.swan.c.b.aFt().a(this.httpUrl.toString(), this);
        return super.build();
    }
}
