package com.baidu.tbadk.core;

import com.baidu.adp.base.BdBaseService;
import com.baidu.tbadk.util.e;
/* loaded from: classes.dex */
class af implements e.a {
    final /* synthetic */ ae Sa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ae aeVar) {
        this.Sa = aeVar;
    }

    @Override // com.baidu.tbadk.util.e.a
    public void al(boolean z) {
        if (z) {
            BdBaseService.serviceStartFlag = 2;
        } else {
            BdBaseService.serviceStartFlag = 1;
        }
    }
}
