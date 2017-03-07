package com.baidu.tbadk.core;

import com.baidu.adp.base.BdBaseService;
import com.baidu.tbadk.util.c;
/* loaded from: classes.dex */
class z implements c.a {
    final /* synthetic */ y SF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar) {
        this.SF = yVar;
    }

    @Override // com.baidu.tbadk.util.c.a
    public void al(boolean z) {
        if (z) {
            BdBaseService.serviceStartFlag = 2;
        } else {
            BdBaseService.serviceStartFlag = 1;
        }
    }
}
