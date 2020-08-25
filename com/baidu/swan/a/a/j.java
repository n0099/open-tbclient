package com.baidu.swan.a.a;

import com.baidu.searchbox.http.AbstractHttpManager;
import com.baidu.swan.a.d.c;
/* loaded from: classes4.dex */
public class j extends c.a {
    public j(AbstractHttpManager abstractHttpManager) {
        super(abstractHttpManager);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.a.d.c.a, com.baidu.searchbox.http.request.HttpRequestBuilder
    /* renamed from: aSV */
    public com.baidu.swan.a.d.c build() {
        com.baidu.swan.a.b.aSS().a(this.httpUrl.toString(), this);
        return super.build();
    }
}
