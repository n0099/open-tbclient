package com.baidu.tbadk.a;

import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.lib.network.websocket.m;
/* loaded from: classes.dex */
class f implements m {
    final /* synthetic */ e a;
    private final /* synthetic */ com.baidu.tbadk.message.websockt.a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, com.baidu.tbadk.message.websockt.a aVar) {
        this.a = eVar;
        this.b = aVar;
    }

    @Override // com.baidu.adp.lib.network.websocket.m
    public boolean a(SocketMessage socketMessage) {
        return socketMessage != null && this.b != null && (socketMessage instanceof SocketMessage) && socketMessage.getCmd() == this.b.c() && socketMessage.getSquencedId() == this.b.e();
    }

    @Override // com.baidu.adp.lib.network.websocket.m
    public int a() {
        return this.b.c();
    }
}
