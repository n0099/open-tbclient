package com.baidu.tbadk.core;

import com.baidu.adp.base.BdBaseService;
import com.baidu.tbadk.util.d;
/* loaded from: classes.dex */
class af implements d.a {
    final /* synthetic */ ae Ss;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ae aeVar) {
        this.Ss = aeVar;
    }

    @Override // com.baidu.tbadk.util.d.a
    public void am(boolean z) {
        if (z) {
            BdBaseService.serviceStartFlag = 2;
        } else {
            BdBaseService.serviceStartFlag = 1;
        }
    }
}
