package com.baidu.fsg.base.statistics;

import com.baidu.fsg.base.restnet.beans.IBeanResponseCallback;
/* loaded from: classes6.dex */
class m implements IBeanResponseCallback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f2006a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ l f2007b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, String str) {
        this.f2007b = lVar;
        this.f2006a = str;
    }

    @Override // com.baidu.fsg.base.restnet.beans.IBeanResponseCallback
    public void onBeanExecSuccess(int i, Object obj, String str, String str2) {
        f.a().a(this.f2006a);
    }

    @Override // com.baidu.fsg.base.restnet.beans.IBeanResponseCallback
    public void onBeanExecFailure(int i, int i2, String str) {
    }
}
