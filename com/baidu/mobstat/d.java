package com.baidu.mobstat;

import android.content.Context;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ int c;
    final /* synthetic */ long d;
    final /* synthetic */ Context e;
    final /* synthetic */ c f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, String str, String str2, int i, long j, Context context) {
        this.f = cVar;
        this.a = str;
        this.b = str2;
        this.c = i;
        this.d = j;
        this.e = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!j.a().c()) {
            synchronized (j.a()) {
                try {
                    j.a().wait();
                } catch (InterruptedException e) {
                    com.baidu.mobstat.a.e.a("statsdk", e);
                }
            }
        }
        DataCore.getInstance().putEvent(this.a, this.b, this.c, this.d, 0L);
        DataCore.getInstance().flush(this.e);
    }
}
