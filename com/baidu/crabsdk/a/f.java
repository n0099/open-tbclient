package com.baidu.crabsdk.a;
/* loaded from: classes2.dex */
final class f implements Runnable {
    final /* synthetic */ e Se;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.Se = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String E = com.baidu.crabsdk.b.n.E();
        if ("NONE".equals(E) || "UNKNOWN".equals(E)) {
            com.baidu.crabsdk.c.a.cf("network is not available!");
        } else if ("WIFI".equals(E)) {
            e.a(this.Se);
        } else if (com.baidu.crabsdk.a.s) {
            com.baidu.crabsdk.c.a.cf("network is not wifi, and UPLOAD_CRASH_ONLY_WIFI is true!");
        } else if (!"MOBILE".equals(E)) {
            com.baidu.crabsdk.c.a.cf("network is not wifi!");
        } else {
            com.baidu.crabsdk.c.a.cf("upload without wifi!");
            e.a(this.Se);
        }
    }
}
