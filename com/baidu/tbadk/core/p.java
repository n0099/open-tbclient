package com.baidu.tbadk.core;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements com.baidu.adp.framework.client.socket.link.h {
    final /* synthetic */ TbadkCoreApplication Oz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(TbadkCoreApplication tbadkCoreApplication) {
        this.Oz = tbadkCoreApplication;
    }

    @Override // com.baidu.adp.framework.client.socket.link.h
    public boolean eK() {
        return !this.Oz.isExitAppCloseWebSocket();
    }
}
