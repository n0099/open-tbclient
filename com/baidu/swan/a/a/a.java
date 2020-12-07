package com.baidu.swan.a.a;

import com.baidu.searchbox.http.AbstractHttpManager;
import com.baidu.swan.a.d.a;
/* loaded from: classes5.dex */
public class a extends a.C0378a {
    public a(AbstractHttpManager abstractHttpManager) {
        super(abstractHttpManager);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.a.d.a.C0378a, com.baidu.searchbox.http.request.HttpRequestBuilder
    /* renamed from: bdf */
    public com.baidu.swan.a.d.a build() {
        com.baidu.swan.a.b.bde().a(this.httpUrl.toString(), this);
        return super.build();
    }
}
