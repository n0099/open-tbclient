package com.baidu.platform.comapi.walknavi.g;

import android.app.Activity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class p implements Runnable {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(a aVar) {
        this.a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Activity activity;
        activity = this.a.i;
        if (activity != null) {
            com.baidu.platform.comapi.walknavi.b.a().H().b("WALKNAVI_AR_HINT_HAS_SHOW", true);
        }
    }
}
