package com.baidu.android.pushservice;

import com.baidu.android.common.logging.Log;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f604a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar) {
        this.f604a = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        if (b.a()) {
            Log.i("PushConnection", " -- Send Timeout --");
        }
        z = this.f604a.r;
        if (z) {
            this.f604a.r = false;
            this.f604a.b(false);
        }
        this.f604a.g();
    }
}
