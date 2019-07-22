package com.baidu.crabsdk.b;

import java.io.IOException;
/* loaded from: classes3.dex */
final class k implements Runnable {
    final /* synthetic */ Process aac;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(Process process) {
        this.aac = process;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            do {
            } while (this.aac.getErrorStream().read(new byte[8192]) >= 0);
        } catch (IOException e) {
            com.baidu.crabsdk.c.a.a("dummy", e);
        }
    }
}
