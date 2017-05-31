package com.baidu.tbadk.core;

import com.baidu.adp.base.BdBaseService;
import com.baidu.tbadk.util.d;
/* loaded from: classes.dex */
class af implements d.a {
    final /* synthetic */ ae Sf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ae aeVar) {
        this.Sf = aeVar;
    }

    @Override // com.baidu.tbadk.util.d.a
    public void al(boolean z) {
        if (z) {
            BdBaseService.serviceStartFlag = 2;
        } else {
            BdBaseService.serviceStartFlag = 1;
        }
    }
}
