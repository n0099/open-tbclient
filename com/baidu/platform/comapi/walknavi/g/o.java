package com.baidu.platform.comapi.walknavi.g;

import android.app.Activity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class o implements Runnable {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(a aVar) {
        this.a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Activity activity;
        activity = this.a.i;
        if (activity != null) {
            com.baidu.platform.comapi.walknavi.b.a().C().b("WALKNAVI_AR_HINT_HAS_SHOW", true);
        }
    }
}
