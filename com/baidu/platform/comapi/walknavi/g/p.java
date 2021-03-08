package com.baidu.platform.comapi.walknavi.g;

import android.app.Activity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f3014a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(a aVar) {
        this.f3014a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Activity activity;
        activity = this.f3014a.i;
        if (activity != null) {
            com.baidu.platform.comapi.walknavi.b.a().H().b("WALKNAVI_AR_HINT_HAS_SHOW", true);
        }
    }
}
