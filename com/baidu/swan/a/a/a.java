package com.baidu.swan.a.a;

import com.baidu.searchbox.http.AbstractHttpManager;
import com.baidu.swan.a.d.a;
/* loaded from: classes5.dex */
public class a extends a.C0366a {
    public a(AbstractHttpManager abstractHttpManager) {
        super(abstractHttpManager);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.a.d.a.C0366a, com.baidu.searchbox.http.request.HttpRequestBuilder
    /* renamed from: baa */
    public com.baidu.swan.a.d.a build() {
        com.baidu.swan.a.b.aZZ().a(this.httpUrl.toString(), this);
        return super.build();
    }
}
