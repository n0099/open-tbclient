package com.baidu.swan.b.a;

import com.baidu.searchbox.http.AbstractHttpManager;
import com.baidu.swan.b.d.a;
/* loaded from: classes10.dex */
public class a extends a.C0419a {
    public a(AbstractHttpManager abstractHttpManager) {
        super(abstractHttpManager);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.b.d.a.C0419a, com.baidu.searchbox.http.request.HttpRequestBuilder
    /* renamed from: aKr */
    public com.baidu.swan.b.d.a build() {
        com.baidu.swan.b.b.aKq().a(this.httpUrl.toString(), this);
        return super.build();
    }
}
