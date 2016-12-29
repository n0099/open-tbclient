package com.baidu.tbadk.core;

import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.tbadk.util.c;
/* loaded from: classes.dex */
class t implements c.a {
    final /* synthetic */ s Oo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar) {
        this.Oo = sVar;
    }

    @Override // com.baidu.tbadk.util.c.a
    public void am(boolean z) {
        if (!z) {
            BdSocketLinkService.startService(false, "restart");
        }
    }
}
