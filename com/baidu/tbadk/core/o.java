package com.baidu.tbadk.core;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements com.baidu.adp.framework.client.socket.link.f {
    final /* synthetic */ TbadkCoreApplication TJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(TbadkCoreApplication tbadkCoreApplication) {
        this.TJ = tbadkCoreApplication;
    }

    @Override // com.baidu.adp.framework.client.socket.link.f
    public boolean eO() {
        return !this.TJ.isExitAppCloseWebSocket();
    }
}
