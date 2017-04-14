package com.baidu.tbadk.core;

import com.baidu.adp.base.BdBaseService;
import com.baidu.tbadk.util.c;
/* loaded from: classes.dex */
class ae implements c.a {
    final /* synthetic */ ad SX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ad adVar) {
        this.SX = adVar;
    }

    @Override // com.baidu.tbadk.util.c.a
    public void an(boolean z) {
        if (z) {
            BdBaseService.serviceStartFlag = 2;
        } else {
            BdBaseService.serviceStartFlag = 1;
        }
    }
}
