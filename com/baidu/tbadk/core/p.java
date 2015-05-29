package com.baidu.tbadk.core;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements com.baidu.adp.framework.client.socket.link.h {
    final /* synthetic */ TbadkCoreApplication OW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(TbadkCoreApplication tbadkCoreApplication) {
        this.OW = tbadkCoreApplication;
    }

    @Override // com.baidu.adp.framework.client.socket.link.h
    public boolean eN() {
        return !this.OW.isExitAppCloseWebSocket();
    }
}
