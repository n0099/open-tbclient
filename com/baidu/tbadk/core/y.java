package com.baidu.tbadk.core;

import com.baidu.adp.base.BdBaseService;
import com.baidu.tbadk.util.c;
/* loaded from: classes.dex */
class y implements c.a {
    final /* synthetic */ x Mc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar) {
        this.Mc = xVar;
    }

    @Override // com.baidu.tbadk.util.c.a
    public void ai(boolean z) {
        if (z) {
            BdBaseService.serviceStartFlag = 2;
        } else {
            BdBaseService.serviceStartFlag = 1;
        }
    }
}
