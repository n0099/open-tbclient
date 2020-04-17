package com.baidu.crabsdk.b;

import java.io.IOException;
/* loaded from: classes8.dex */
final class l implements Runnable {
    final /* synthetic */ Process akn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(Process process) {
        this.akn = process;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            do {
            } while (this.akn.getErrorStream().read(new byte[8192]) >= 0);
        } catch (IOException e) {
            com.baidu.crabsdk.c.a.f("dummy", e);
        }
    }
}
