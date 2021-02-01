package com.baidu.platform.comapi.walknavi.g;

import android.app.Activity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f4349a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(a aVar) {
        this.f4349a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Activity activity;
        activity = this.f4349a.i;
        if (activity != null) {
            com.baidu.platform.comapi.walknavi.b.a().H().b("WALKNAVI_AR_HINT_HAS_SHOW", true);
        }
    }
}
