package com.baidu.mobstat;

import android.content.Context;
/* loaded from: classes.dex */
class f implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ long c;
    final /* synthetic */ Context d;
    final /* synthetic */ c e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar, String str, String str2, long j, Context context) {
        this.e = cVar;
        this.a = str;
        this.b = str2;
        this.c = j;
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
        String a = this.e.a(this.a, this.b);
        h hVar = this.e.a.get(a);
        if (hVar == null) {
            com.baidu.mobstat.a.e.b("statsdk", "EventStat: event_id[" + this.a + "] with label[" + this.b + "] is not started or alread done.");
        } else if (!this.a.equals(hVar.a) || !this.b.equals(hVar.b)) {
            com.baidu.mobstat.a.e.a("statsdk", "EventStat: Wrong Case, eventId/label pair not match");
        } else {
            this.e.a.remove(a);
            long j = this.c - hVar.c;
            if (j <= 0) {
                com.baidu.mobstat.a.e.a("statsdk", "EventStat: Wrong Case, Duration must be positive");
                return;
            }
            DataCore.getInstance().putEvent(this.a, this.b, 1, hVar.c, j);
            DataCore.getInstance().flush(this.d);
        }
    }
}
