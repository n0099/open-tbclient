package com.baidu.fsg.base.statistics;

import com.baidu.fsg.base.restnet.beans.IBeanResponseCallback;
/* loaded from: classes15.dex */
class m implements IBeanResponseCallback {
    final /* synthetic */ String a;
    final /* synthetic */ l b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, String str) {
        this.b = lVar;
        this.a = str;
    }

    @Override // com.baidu.fsg.base.restnet.beans.IBeanResponseCallback
    public void onBeanExecSuccess(int i, Object obj, String str, String str2) {
        f.a().a(this.a);
    }

    @Override // com.baidu.fsg.base.restnet.beans.IBeanResponseCallback
    public void onBeanExecFailure(int i, int i2, String str) {
    }
}
