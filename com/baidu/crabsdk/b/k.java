package com.baidu.crabsdk.b;

import java.io.IOException;
/* loaded from: classes5.dex */
final class k implements Runnable {
    final /* synthetic */ Process Qi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(Process process) {
        this.Qi = process;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            do {
            } while (this.Qi.getErrorStream().read(new byte[8192]) >= 0);
        } catch (IOException e) {
            com.baidu.crabsdk.c.a.f("dummy", e);
        }
    }
}
