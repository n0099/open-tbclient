package com.baidu.crabsdk.a;

import com.baidu.searchbox.ng.ai.apps.util.AiAppRomUtils;
/* loaded from: classes6.dex */
final class f implements Runnable {
    final /* synthetic */ e XD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.XD = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String F = com.baidu.crabsdk.b.n.F();
        if ("NONE".equals(F) || AiAppRomUtils.UNKNOWN.equals(F)) {
            com.baidu.crabsdk.c.a.cJ("network is not available!");
        } else if ("WIFI".equals(F)) {
            e.a(this.XD);
        } else if (com.baidu.crabsdk.a.s) {
            com.baidu.crabsdk.c.a.cJ("network is not wifi, and UPLOAD_CRASH_ONLY_WIFI is true!");
        } else if (!"MOBILE".equals(F)) {
            com.baidu.crabsdk.c.a.cJ("network is not wifi!");
        } else {
            com.baidu.crabsdk.c.a.cJ("upload without wifi!");
            e.a(this.XD);
        }
    }
}
