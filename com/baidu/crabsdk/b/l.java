package com.baidu.crabsdk.b;

import java.io.IOException;
/* loaded from: classes8.dex */
final class l implements Runnable {
    final /* synthetic */ Process akZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(Process process) {
        this.akZ = process;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            do {
            } while (this.akZ.getErrorStream().read(new byte[8192]) >= 0);
        } catch (IOException e) {
            com.baidu.crabsdk.c.a.a("dummy", e);
        }
    }
}
