package com.baidu.android.nebula.b;

import com.baidu.kirin.KirinConfig;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {
    final /* synthetic */ h a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.a = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ServerSocket serverSocket;
        ServerSocket serverSocket2;
        g gVar;
        do {
            try {
                serverSocket2 = this.a.c;
                Socket accept = serverSocket2.accept();
                this.a.a(accept);
                accept.setSoTimeout(KirinConfig.READ_TIME_OUT);
                InputStream inputStream = accept.getInputStream();
                if (inputStream == null) {
                    h.d(accept);
                    this.a.b(accept);
                } else {
                    gVar = this.a.f;
                    gVar.a(new e(this, accept, inputStream));
                }
            } catch (IOException e) {
            }
            serverSocket = this.a.c;
        } while (!serverSocket.isClosed());
    }
}
