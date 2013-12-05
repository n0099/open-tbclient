package com.baidu.mobstat;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f963a;
    final /* synthetic */ String b;
    final /* synthetic */ int c;
    final /* synthetic */ Context d;
    final /* synthetic */ c e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, String str, String str2, int i, Context context) {
        this.e = cVar;
        this.f963a = str;
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
        b.a().a(this.f963a, this.b, this.c, System.currentTimeMillis());
        b.a().b(this.d);
    }
}
