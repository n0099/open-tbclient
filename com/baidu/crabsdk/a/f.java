package com.baidu.crabsdk.a;

import com.baidu.android.util.devices.RomUtils;
/* loaded from: classes8.dex */
final class f implements Runnable {
    final /* synthetic */ e akm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.akm = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String I = com.baidu.crabsdk.b.o.I();
        if ("NONE".equals(I) || RomUtils.UNKNOWN.equals(I)) {
            com.baidu.crabsdk.c.a.v("network is not available!");
        } else if ("WIFI".equals(I)) {
            e.a(this.akm);
        } else if (com.baidu.crabsdk.a.s) {
            com.baidu.crabsdk.c.a.v("network is not wifi, and UPLOAD_CRASH_ONLY_WIFI is true!");
        } else if (!"MOBILE".equals(I)) {
            com.baidu.crabsdk.c.a.v("network is not wifi!");
        } else {
            com.baidu.crabsdk.c.a.v("upload without wifi!");
            e.a(this.akm);
        }
    }
}
