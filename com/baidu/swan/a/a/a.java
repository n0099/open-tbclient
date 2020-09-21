package com.baidu.swan.a.a;

import com.baidu.searchbox.http.AbstractHttpManager;
import com.baidu.swan.a.d.a;
/* loaded from: classes24.dex */
public class a extends a.C0325a {
    public a(AbstractHttpManager abstractHttpManager) {
        super(abstractHttpManager);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.a.d.a.C0325a, com.baidu.searchbox.http.request.HttpRequestBuilder
    /* renamed from: aTF */
    public com.baidu.swan.a.d.a build() {
        com.baidu.swan.a.b.aTE().a(this.httpUrl.toString(), this);
        return super.build();
    }
}
