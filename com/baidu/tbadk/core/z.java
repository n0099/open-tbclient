package com.baidu.tbadk.core;

import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.tbadk.util.d;
/* loaded from: classes.dex */
class z implements d.a {
    final /* synthetic */ y Sq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar) {
        this.Sq = yVar;
    }

    @Override // com.baidu.tbadk.util.d.a
    public void am(boolean z) {
        if (!z) {
            BdSocketLinkService.startService(false, "restart");
        }
    }
}
