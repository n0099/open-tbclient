package com.baidu.swan.c.a;

import com.baidu.searchbox.http.AbstractHttpManager;
import com.baidu.swan.c.d.a;
/* loaded from: classes11.dex */
public class a extends a.C0420a {
    public a(AbstractHttpManager abstractHttpManager) {
        super(abstractHttpManager);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.c.d.a.C0420a, com.baidu.searchbox.http.request.HttpRequestBuilder
    /* renamed from: aGA */
    public com.baidu.swan.c.d.a build() {
        com.baidu.swan.c.b.aGz().a(this.httpUrl.toString(), this);
        return super.build();
    }
}
