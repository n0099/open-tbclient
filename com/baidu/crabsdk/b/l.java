package com.baidu.crabsdk.b;

import java.io.IOException;
/* loaded from: classes8.dex */
final class l implements Runnable {
    final /* synthetic */ Process RU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(Process process) {
        this.RU = process;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            do {
            } while (this.RU.getErrorStream().read(new byte[8192]) >= 0);
        } catch (IOException e) {
            com.baidu.crabsdk.c.a.f("dummy", e);
        }
    }
}
