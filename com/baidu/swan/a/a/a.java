package com.baidu.swan.a.a;

import com.baidu.searchbox.http.AbstractHttpManager;
import com.baidu.swan.a.d.a;
/* loaded from: classes15.dex */
public class a extends a.C0351a {
    public a(AbstractHttpManager abstractHttpManager) {
        super(abstractHttpManager);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.a.d.a.C0351a, com.baidu.searchbox.http.request.HttpRequestBuilder
    /* renamed from: bbV */
    public com.baidu.swan.a.d.a build() {
        com.baidu.swan.a.b.bbU().a(this.httpUrl.toString(), this);
        return super.build();
    }
}
