package com.baidu.tbadk.core;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements com.baidu.adp.framework.client.socket.link.f {
    final /* synthetic */ TbadkCoreApplication TK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(TbadkCoreApplication tbadkCoreApplication) {
        this.TK = tbadkCoreApplication;
    }

    @Override // com.baidu.adp.framework.client.socket.link.f
    public boolean eN() {
        return !this.TK.isExitAppCloseWebSocket();
    }
}
