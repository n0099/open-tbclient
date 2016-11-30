package com.baidu.tbadk.core;

import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.tbadk.util.c;
/* loaded from: classes.dex */
class t implements c.a {
    final /* synthetic */ s Os;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar) {
        this.Os = sVar;
    }

    @Override // com.baidu.tbadk.util.c.a
    public void am(boolean z) {
        if (!z) {
            BdSocketLinkService.startService(false, "restart");
        }
    }
}
