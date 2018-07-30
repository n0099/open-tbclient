package com.baidu.crabsdk.b;

import java.io.IOException;
/* loaded from: classes2.dex */
final class k implements Runnable {
    final /* synthetic */ Process SQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(Process process) {
        this.SQ = process;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            do {
            } while (this.SQ.getErrorStream().read(new byte[8192]) >= 0);
        } catch (IOException e) {
            com.baidu.crabsdk.c.a.b("dummy", e);
        }
    }
}
