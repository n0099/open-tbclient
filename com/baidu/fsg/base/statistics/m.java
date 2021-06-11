package com.baidu.fsg.base.statistics;

import com.baidu.fsg.base.restnet.beans.IBeanResponseCallback;
/* loaded from: classes2.dex */
public class m implements IBeanResponseCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f5298a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ l f5299b;

    public m(l lVar, String str) {
        this.f5299b = lVar;
        this.f5298a = str;
    }

    @Override // com.baidu.fsg.base.restnet.beans.IBeanResponseCallback
    public void onBeanExecFailure(int i2, int i3, String str) {
    }

    @Override // com.baidu.fsg.base.restnet.beans.IBeanResponseCallback
    public void onBeanExecSuccess(int i2, Object obj, String str, String str2) {
        f.a().a(this.f5298a);
    }
}
