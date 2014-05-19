package com.baidu.mobstat;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ long a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ c d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, long j, String str, String str2) {
        this.d = cVar;
        this.a = j;
        this.b = str;
        this.c = str2;
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
        h hVar = new h(this.d);
        hVar.c = this.a;
        hVar.a = this.b;
        hVar.b = this.c;
        String a = this.d.a(this.b, this.c);
        if (this.d.a.get(a) != null) {
            com.baidu.mobstat.a.e.b("statsdk", "EventStat: event_id[" + this.b + "] with label[" + this.c + "] is duplicated, older is removed");
        }
        this.d.a.put(a, hVar);
        com.baidu.mobstat.a.e.a("statsdk", "put a keyword[" + a + "] into durationlist");
    }
}
