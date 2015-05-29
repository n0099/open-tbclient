package com.baidu.tbadk.core;

import com.baidu.adp.base.BdBaseService;
/* loaded from: classes.dex */
class x implements com.baidu.tbadk.util.e {
    final /* synthetic */ w OZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar) {
        this.OZ = wVar;
    }

    @Override // com.baidu.tbadk.util.e
    public void ae(boolean z) {
        if (z) {
            BdBaseService.serviceStartFlag = 2;
        } else {
            BdBaseService.serviceStartFlag = 1;
        }
    }
}
