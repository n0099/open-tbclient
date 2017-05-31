package com.baidu.tbadk.core;

import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.tbadk.util.d;
/* loaded from: classes.dex */
class z implements d.a {
    final /* synthetic */ y Sd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar) {
        this.Sd = yVar;
    }

    @Override // com.baidu.tbadk.util.d.a
    public void al(boolean z) {
        if (!z) {
            BdSocketLinkService.startService(false, "restart");
        }
    }
}
