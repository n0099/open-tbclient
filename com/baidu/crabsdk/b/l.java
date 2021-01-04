package com.baidu.crabsdk.b;

import java.io.IOException;
/* loaded from: classes3.dex */
final class l implements Runnable {
    final /* synthetic */ Process apY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(Process process) {
        this.apY = process;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            do {
            } while (this.apY.getErrorStream().read(new byte[8192]) >= 0);
        } catch (IOException e) {
            com.baidu.crabsdk.c.a.a("dummy", e);
        }
    }
}
