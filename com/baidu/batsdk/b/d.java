package com.baidu.batsdk.b;

import java.io.IOException;
/* loaded from: classes.dex */
final class d implements Runnable {
    private final /* synthetic */ Process a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Process process) {
        this.a = process;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            do {
            } while (this.a.getErrorStream().read(new byte[8192]) >= 0);
        } catch (IOException e) {
        }
    }
}
