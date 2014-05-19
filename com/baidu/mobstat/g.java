package com.baidu.mobstat;

import android.content.Context;
/* loaded from: classes.dex */
class g implements Runnable {
    final /* synthetic */ long a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ Context d;
    final /* synthetic */ c e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(c cVar, long j, String str, String str2, Context context) {
        this.e = cVar;
        this.a = j;
        this.b = str;
        this.c = str2;
        this.d = context;
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
        if (this.a <= 0) {
            com.baidu.mobstat.a.e.a("statsdk", "EventStat: Wrong Case, Duration must be positive");
            return;
        }
        DataCore.getInstance().putEvent(this.b, this.c, 1, System.currentTimeMillis(), this.a);
        DataCore.getInstance().flush(this.d);
    }
}
