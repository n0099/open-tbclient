package com.baidu.android.pushservice.b;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ o f703a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.f703a = oVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean d;
        Context context;
        d = this.f703a.d();
        if (d) {
            context = this.f703a.b;
            if (m.e(context)) {
                this.f703a.c();
            }
        }
    }
}
