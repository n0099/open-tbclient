package com.baidu.crabsdk.b;

import java.io.IOException;
/* loaded from: classes11.dex */
final class l implements Runnable {
    final /* synthetic */ Process aoE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(Process process) {
        this.aoE = process;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            do {
            } while (this.aoE.getErrorStream().read(new byte[8192]) >= 0);
        } catch (IOException e) {
            com.baidu.crabsdk.c.a.a("dummy", e);
        }
    }
}
