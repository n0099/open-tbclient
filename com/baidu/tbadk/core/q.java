package com.baidu.tbadk.core;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements com.baidu.adp.framework.client.socket.link.f {
    final /* synthetic */ TbadkCoreApplication Tw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(TbadkCoreApplication tbadkCoreApplication) {
        this.Tw = tbadkCoreApplication;
    }

    @Override // com.baidu.adp.framework.client.socket.link.f
    public boolean eN() {
        return !this.Tw.isExitAppCloseWebSocket();
    }
}
