package com.baidu.mobstat;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ int c;
    final /* synthetic */ Context d;
    final /* synthetic */ c e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, String str, String str2, int i, Context context) {
        this.e = cVar;
        this.a = str;
        this.b = str2;
        this.c = i;
        this.d = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!f.a().c()) {
            synchronized (f.a()) {
                try {
                    f.a().wait();
                } catch (InterruptedException e) {
                    com.baidu.mobstat.a.b.a("stat", e);
                }
            }
        }
        b.a().a(this.a, this.b, this.c, System.currentTimeMillis());
        b.a().b(this.d);
    }
}
