package com.baidu.tbadk.core;

import com.baidu.adp.base.BdBaseService;
/* loaded from: classes.dex */
class w implements com.baidu.tbadk.util.e {
    final /* synthetic */ v CS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar) {
        this.CS = vVar;
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
