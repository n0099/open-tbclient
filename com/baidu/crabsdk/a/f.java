package com.baidu.crabsdk.a;

import com.baidu.searchbox.ng.ai.apps.util.AiAppRomUtils;
/* loaded from: classes6.dex */
final class f implements Runnable {
    final /* synthetic */ e Xu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.Xu = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String F = com.baidu.crabsdk.b.n.F();
        if ("NONE".equals(F) || AiAppRomUtils.UNKNOWN.equals(F)) {
            com.baidu.crabsdk.c.a.cI("network is not available!");
        } else if ("WIFI".equals(F)) {
            e.a(this.Xu);
        } else if (com.baidu.crabsdk.a.s) {
            com.baidu.crabsdk.c.a.cI("network is not wifi, and UPLOAD_CRASH_ONLY_WIFI is true!");
        } else if (!"MOBILE".equals(F)) {
            com.baidu.crabsdk.c.a.cI("network is not wifi!");
        } else {
            com.baidu.crabsdk.c.a.cI("upload without wifi!");
            e.a(this.Xu);
        }
    }
}
