package com.baidu.platform.comapi.walknavi.g;

import android.app.Activity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes26.dex */
public class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f3074a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(a aVar) {
        this.f3074a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Activity activity;
        activity = this.f3074a.g;
        if (activity != null) {
            com.baidu.platform.comapi.walknavi.b.a().K().b("WALKNAVI_AR_HINT_HAS_SHOW", true);
        }
    }
}
