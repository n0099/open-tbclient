package com.baidu.tbadk.core;

import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.tbadk.util.c;
/* loaded from: classes.dex */
class y implements c.a {
    final /* synthetic */ x SV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar) {
        this.SV = xVar;
    }

    @Override // com.baidu.tbadk.util.c.a
    public void an(boolean z) {
        if (!z) {
            BdSocketLinkService.startService(false, "restart");
        }
    }
}
