package com.baidu.crabsdk.b;

import java.io.IOException;
/* loaded from: classes2.dex */
final class k implements Runnable {
    final /* synthetic */ Process ST;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(Process process) {
        this.ST = process;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            do {
            } while (this.ST.getErrorStream().read(new byte[8192]) >= 0);
        } catch (IOException e) {
            com.baidu.crabsdk.c.a.b("dummy", e);
        }
    }
}
