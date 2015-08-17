package com.baidu.tbadk.core;

import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.tbadk.util.c;
/* loaded from: classes.dex */
class q implements c.a {
    final /* synthetic */ p TK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.TK = pVar;
    }

    @Override // com.baidu.tbadk.util.c.a
    public void ag(boolean z) {
        if (!z) {
            BdSocketLinkService.startService(false, "restart");
        }
    }
}
