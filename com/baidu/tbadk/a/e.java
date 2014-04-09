package com.baidu.tbadk.a;

import com.baidu.adp.framework.message.g;
import com.baidu.adp.lib.network.websocket.m;
/* loaded from: classes.dex */
final class e implements m {
    final /* synthetic */ d a;
    private final /* synthetic */ com.baidu.tbadk.message.websockt.a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, com.baidu.tbadk.message.websockt.a aVar) {
        this.a = dVar;
        this.b = aVar;
    }

    @Override // com.baidu.adp.lib.network.websocket.m
    public final boolean a(g gVar) {
        if (gVar == null || this.b == null || !(gVar instanceof com.baidu.tbadk.message.websockt.d)) {
            return false;
        }
        com.baidu.tbadk.message.websockt.d dVar = (com.baidu.tbadk.message.websockt.d) gVar;
        return dVar.e() == this.b.c() && dVar.k() == this.b.e();
    }

    @Override // com.baidu.adp.lib.network.websocket.m
    public final int a() {
        return this.b.c();
    }
}
