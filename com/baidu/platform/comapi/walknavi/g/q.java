package com.baidu.platform.comapi.walknavi.g;

import android.app.Activity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f4570a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(a aVar) {
        this.f4570a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Activity activity;
        activity = this.f4570a.g;
        if (activity != null) {
            com.baidu.platform.comapi.walknavi.b.a().K().b("WALKNAVI_AR_HINT_HAS_SHOW", true);
        }
    }
}
