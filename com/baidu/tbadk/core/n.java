package com.baidu.tbadk.core;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements com.baidu.adp.framework.client.socket.link.h {
    final /* synthetic */ TbadkCoreApplication CR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(TbadkCoreApplication tbadkCoreApplication) {
        this.CR = tbadkCoreApplication;
    }

    @Override // com.baidu.adp.framework.client.socket.link.h
    public boolean bn() {
        return !this.CR.isExitAppCloseWebSocket();
    }
}
