package com.baidu.crabsdk.b;

import java.io.IOException;
/* loaded from: classes3.dex */
final class k implements Runnable {
    final /* synthetic */ Process ZI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(Process process) {
        this.ZI = process;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            do {
            } while (this.ZI.getErrorStream().read(new byte[8192]) >= 0);
        } catch (IOException e) {
            com.baidu.crabsdk.c.a.a("dummy", e);
        }
    }
}
