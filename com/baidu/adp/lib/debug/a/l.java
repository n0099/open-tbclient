package com.baidu.adp.lib.debug.a;

import java.io.IOException;
import java.io.InputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends Thread {
    private boolean gC = false;
    final /* synthetic */ k gD;
    private InputStream in;

    public l(k kVar, InputStream inputStream) {
        this.gD = kVar;
        this.in = inputStream;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        int read;
        byte[] bArr = new byte[512];
        while (!this.gC && (read = this.in.read(bArr)) != -1) {
            try {
                String str = new String(bArr, 0, read);
                if (str != null) {
                    this.gD.O(str);
                }
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
    }

    public synchronized void finish() {
        this.gC = true;
    }
}
