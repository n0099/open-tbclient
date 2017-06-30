package com.baidu.tbadk.core;

import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.tbadk.util.e;
/* loaded from: classes.dex */
class z implements e.a {
    final /* synthetic */ y RY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar) {
        this.RY = yVar;
    }

    @Override // com.baidu.tbadk.util.e.a
    public void al(boolean z) {
        if (!z) {
            BdSocketLinkService.startService(false, "restart");
        }
    }
}
