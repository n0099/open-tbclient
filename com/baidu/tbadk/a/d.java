package com.baidu.tbadk.a;

import com.baidu.adp.framework.message.g;
import com.baidu.adp.lib.network.websocket.l;
/* loaded from: classes.dex */
final class d implements l {
    final /* synthetic */ c a;
    private final /* synthetic */ com.baidu.tbadk.message.websockt.a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, com.baidu.tbadk.message.websockt.a aVar) {
        this.a = cVar;
        this.b = aVar;
    }

    @Override // com.baidu.adp.lib.network.websocket.l
    public final boolean a(g gVar) {
        if (gVar == null || this.b == null || !(gVar instanceof com.baidu.tbadk.message.websockt.d)) {
            return false;
        }
        com.baidu.tbadk.message.websockt.d dVar = (com.baidu.tbadk.message.websockt.d) gVar;
        return dVar.e() == this.b.c() && dVar.k() == this.b.e();
    }

    @Override // com.baidu.adp.lib.network.websocket.l
    public final int a() {
        return this.b.c();
    }
}
