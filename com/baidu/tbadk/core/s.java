package com.baidu.tbadk.core;

import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.tbadk.util.c;
/* loaded from: classes.dex */
class s implements c.a {
    final /* synthetic */ r Op;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar) {
        this.Op = rVar;
    }

    @Override // com.baidu.tbadk.util.c.a
    public void ak(boolean z) {
        if (!z) {
            BdSocketLinkService.startService(false, "restart");
        }
    }
}
