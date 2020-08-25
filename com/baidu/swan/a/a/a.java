package com.baidu.swan.a.a;

import com.baidu.searchbox.http.AbstractHttpManager;
import com.baidu.swan.a.d.a;
/* loaded from: classes4.dex */
public class a extends a.C0330a {
    public a(AbstractHttpManager abstractHttpManager) {
        super(abstractHttpManager);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.a.d.a.C0330a, com.baidu.searchbox.http.request.HttpRequestBuilder
    /* renamed from: aST */
    public com.baidu.swan.a.d.a build() {
        com.baidu.swan.a.b.aSS().a(this.httpUrl.toString(), this);
        return super.build();
    }
}
