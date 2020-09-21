package com.baidu.platform.comapi.walknavi.g;

import android.app.Activity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class q implements Runnable {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(a aVar) {
        this.a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Activity activity;
        activity = this.a.g;
        if (activity != null) {
            com.baidu.platform.comapi.walknavi.b.a().K().b("WALKNAVI_AR_HINT_HAS_SHOW", true);
        }
    }
}
