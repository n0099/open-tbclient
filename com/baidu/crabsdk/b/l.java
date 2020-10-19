package com.baidu.crabsdk.b;

import java.io.IOException;
/* loaded from: classes11.dex */
final class l implements Runnable {
    final /* synthetic */ Process aoD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(Process process) {
        this.aoD = process;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            do {
            } while (this.aoD.getErrorStream().read(new byte[8192]) >= 0);
        } catch (IOException e) {
            com.baidu.crabsdk.c.a.a("dummy", e);
        }
    }
}
