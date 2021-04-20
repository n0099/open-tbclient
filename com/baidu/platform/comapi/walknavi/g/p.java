package com.baidu.platform.comapi.walknavi.g;

import android.app.Activity;
/* loaded from: classes2.dex */
public class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f9701a;

    public p(a aVar) {
        this.f9701a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Activity activity;
        activity = this.f9701a.i;
        if (activity != null) {
            com.baidu.platform.comapi.walknavi.b.a().H().b("WALKNAVI_AR_HINT_HAS_SHOW", true);
        }
    }
}
