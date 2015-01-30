package com.baidu.tbadk.core;

import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
/* loaded from: classes.dex */
class r implements com.baidu.tbadk.util.e {
    final /* synthetic */ q CT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.CT = qVar;
    }

    @Override // com.baidu.tbadk.util.e
    public void ae(boolean z) {
        if (!z) {
            BdSocketLinkService.startService(false, "restart");
        }
    }
}
