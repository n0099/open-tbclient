package com.baidu.sapi2.share;

import com.baidu.sapi2.SapiAccountManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class l implements Runnable {
    final /* synthetic */ boolean a;
    final /* synthetic */ m b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(m mVar, boolean z) {
        this.b = mVar;
        this.a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        new ShareStorage().a(this.a);
        x.b();
        SapiAccountManager.getInstance().getAccountService().refreshOpenidToUid();
    }
}
