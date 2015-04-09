package com.baidu.tbadk.core;

import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
/* loaded from: classes.dex */
class r implements com.baidu.tbadk.util.e {
    final /* synthetic */ q OA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.OA = qVar;
    }

    @Override // com.baidu.tbadk.util.e
    public void aa(boolean z) {
        if (!z) {
            BdSocketLinkService.startService(false, "restart");
        }
    }
}
