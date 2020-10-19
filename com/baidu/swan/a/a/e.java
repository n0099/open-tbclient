package com.baidu.swan.a.a;

import com.baidu.searchbox.http.AbstractHttpManager;
import com.baidu.swan.a.d.b;
/* loaded from: classes8.dex */
public class e extends b.a {
    public e(AbstractHttpManager abstractHttpManager) {
        super(abstractHttpManager);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.a.d.b.a, com.baidu.searchbox.http.request.HttpRequestBuilder
    /* renamed from: aWp */
    public com.baidu.swan.a.d.b build() {
        com.baidu.swan.a.b.aWn().a(this.httpUrl.toString(), this);
        return super.build();
    }
}
