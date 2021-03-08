package com.baidu.crabsdk.b;

import java.io.IOException;
/* loaded from: classes5.dex */
final class l implements Runnable {
    final /* synthetic */ Process aqA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(Process process) {
        this.aqA = process;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            do {
            } while (this.aqA.getErrorStream().read(new byte[8192]) >= 0);
        } catch (IOException e) {
            com.baidu.crabsdk.c.a.a("dummy", e);
        }
    }
}
