package com.baidu.tbadk.core;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements com.baidu.adp.framework.client.socket.link.f {
    final /* synthetic */ TbadkCoreApplication this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(TbadkCoreApplication tbadkCoreApplication) {
        this.this$0 = tbadkCoreApplication;
    }

    @Override // com.baidu.adp.framework.client.socket.link.f
    public boolean eS() {
        return !this.this$0.isExitAppCloseWebSocket();
    }
}
