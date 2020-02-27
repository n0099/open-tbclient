package com.baidu.crabsdk.b;

import java.io.IOException;
/* loaded from: classes8.dex */
final class k implements Runnable {
    final /* synthetic */ Process RR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(Process process) {
        this.RR = process;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            do {
            } while (this.RR.getErrorStream().read(new byte[8192]) >= 0);
        } catch (IOException e) {
            com.baidu.crabsdk.c.a.f("dummy", e);
        }
    }
}
