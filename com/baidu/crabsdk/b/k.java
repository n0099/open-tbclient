package com.baidu.crabsdk.b;

import java.io.IOException;
/* loaded from: classes6.dex */
final class k implements Runnable {
    final /* synthetic */ Process Yf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(Process process) {
        this.Yf = process;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            do {
            } while (this.Yf.getErrorStream().read(new byte[8192]) >= 0);
        } catch (IOException e) {
            com.baidu.crabsdk.c.a.f("dummy", e);
        }
    }
}
