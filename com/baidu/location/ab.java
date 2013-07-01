package com.baidu.location;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ w f455a;

    private ab(w wVar) {
        this.f455a = wVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        Handler handler;
        Handler handler2;
        z = this.f455a.q;
        if (!z || !ap.k) {
            this.f455a.s = false;
            return;
        }
        handler = this.f455a.f;
        handler.obtainMessage(91).sendToTarget();
        handler2 = this.f455a.f;
        handler2.postDelayed(this, ap.L);
        this.f455a.s = true;
    }
}
