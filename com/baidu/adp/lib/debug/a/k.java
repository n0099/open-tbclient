package com.baidu.adp.lib.debug.a;

import java.io.IOException;
import java.io.InputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends Thread {
    final /* synthetic */ j a;
    private InputStream b;
    private boolean c = false;

    public k(j jVar, InputStream inputStream) {
        this.a = jVar;
        this.b = inputStream;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        int read;
        byte[] bArr = new byte[8192];
        while (!this.c && (read = this.b.read(bArr)) != -1) {
            try {
                String str = new String(bArr, 0, read);
                if (str != null) {
                    this.a.a(str);
                }
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
    }

    public synchronized void a() {
        this.c = true;
    }
}
