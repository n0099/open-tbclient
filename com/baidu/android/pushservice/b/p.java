package com.baidu.android.pushservice.b;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ o f702a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.f702a = oVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean d;
        Context context;
        d = this.f702a.d();
        if (d) {
            context = this.f702a.b;
            if (m.e(context)) {
                this.f702a.c();
            }
        }
    }
}
