package com.baidu.android.nebula.b;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ Socket a;
    final /* synthetic */ InputStream b;
    final /* synthetic */ i c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(i iVar, Socket socket, InputStream inputStream) {
        this.c = iVar;
        this.a = socket;
        this.b = inputStream;
    }

    @Override // java.lang.Runnable
    public void run() {
        b bVar;
        OutputStream outputStream = null;
        try {
            outputStream = this.a.getOutputStream();
            bVar = this.c.a.g;
            l lVar = new l(this.c.a, bVar.a(), this.b, outputStream, this.a.getInetAddress());
            while (!this.a.isClosed()) {
                lVar.f();
            }
        } catch (Exception e) {
            if (!(e instanceof SocketException) || !"NanoHttpd Shutdown".equals(e.getMessage())) {
                e.printStackTrace();
            }
        } finally {
            h.b(outputStream);
            h.b(this.b);
            h.d(this.a);
            this.c.a.b(this.a);
        }
    }
}
