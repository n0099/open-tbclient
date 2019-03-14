package com.baidu.crabsdk.a;
/* loaded from: classes3.dex */
final class f implements Runnable {
    final /* synthetic */ e abf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.abf = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String F = com.baidu.crabsdk.b.n.F();
        if ("NONE".equals(F) || "UNKNOWN".equals(F)) {
            com.baidu.crabsdk.c.a.cx("network is not available!");
        } else if ("WIFI".equals(F)) {
            e.a(this.abf);
        } else if (com.baidu.crabsdk.a.s) {
            com.baidu.crabsdk.c.a.cx("network is not wifi, and UPLOAD_CRASH_ONLY_WIFI is true!");
        } else if (!"MOBILE".equals(F)) {
            com.baidu.crabsdk.c.a.cx("network is not wifi!");
        } else {
            com.baidu.crabsdk.c.a.cx("upload without wifi!");
            e.a(this.abf);
        }
    }
}
