package com.baidu.swan.a.a;

import com.baidu.searchbox.http.AbstractHttpManager;
import com.baidu.swan.a.d.a;
/* loaded from: classes14.dex */
public class a extends a.C0357a {
    public a(AbstractHttpManager abstractHttpManager) {
        super(abstractHttpManager);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.a.d.a.C0357a, com.baidu.searchbox.http.request.HttpRequestBuilder
    /* renamed from: bbX */
    public com.baidu.swan.a.d.a build() {
        com.baidu.swan.a.b.bbW().a(this.httpUrl.toString(), this);
        return super.build();
    }
}
