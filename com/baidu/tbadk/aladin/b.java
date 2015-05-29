package com.baidu.tbadk.aladin;

import android.content.Intent;
import com.baidu.tbadk.aladin.b.c;
import com.baidu.tbadk.aladin.b.d;
import com.baidu.tbadk.aladin.b.e;
import com.baidu.tieba.service.WebNativeReceiver;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
/* loaded from: classes.dex */
public class b extends Thread {
    private AladinServer Nk;
    private Socket Nn;
    private a No;

    public b(Socket socket, AladinServer aladinServer, a aVar) {
        this.Nn = socket;
        this.Nk = aladinServer;
        this.No = aVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [148=6, 150=6, 151=6, 153=6, 154=6, 157=6, 158=6, 160=6, 161=6, 164=6, 165=6, 167=6, 168=6] */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        String readLine;
        com.baidu.tbadk.aladin.a.a pm;
        if (this.Nn == null) {
            return;
        }
        try {
            if (this.Nk == null || this.No == null) {
                if (this.Nn != null) {
                    try {
                        if (!this.Nn.isInputShutdown()) {
                            this.Nn.shutdownInput();
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    try {
                        if (!this.Nn.isOutputShutdown()) {
                            this.Nn.shutdownOutput();
                        }
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                    try {
                        if (this.Nn.isClosed()) {
                            return;
                        }
                        this.Nn.close();
                        return;
                    } catch (Throwable th3) {
                        th3.printStackTrace();
                        return;
                    }
                }
                return;
            }
            this.Nn.setSoTimeout(1000);
            this.Nn.setTcpNoDelay(true);
            InputStream inputStream = this.Nn.getInputStream();
            if (inputStream == null) {
                if (this.Nn != null) {
                    try {
                        if (!this.Nn.isInputShutdown()) {
                            this.Nn.shutdownInput();
                        }
                    } catch (Throwable th4) {
                        th4.printStackTrace();
                    }
                    try {
                        if (!this.Nn.isOutputShutdown()) {
                            this.Nn.shutdownOutput();
                        }
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                    }
                    try {
                        if (this.Nn.isClosed()) {
                            return;
                        }
                        this.Nn.close();
                        return;
                    } catch (Throwable th6) {
                        th6.printStackTrace();
                        return;
                    }
                }
                return;
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            String str = null;
            do {
                readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                } else if (str == null) {
                    str = readLine;
                }
            } while (readLine.length() != 0);
            com.baidu.tbadk.aladin.a.a pm2 = new d(new com.baidu.tbadk.aladin.a.a(str)).pm();
            if (pm2 != null && (pm = new e(pm2).pm()) != null && c.pl()) {
                com.baidu.tbadk.aladin.a.b bVar = new com.baidu.tbadk.aladin.a.b(pm);
                boolean pi = bVar.pi();
                String response = bVar.getResponse();
                if (pi) {
                    Intent intent = bVar.getIntent();
                    if (intent == null) {
                        bVar.setErrorCode(2);
                        response = bVar.getResponse();
                    } else if (new com.baidu.tbadk.aladin.b.a().G(intent)) {
                        try {
                            intent.setClass(this.Nk.getApplicationContext(), WebNativeReceiver.class);
                            this.Nk.sendBroadcast(intent);
                        } catch (Exception e) {
                            bVar.setErrorCode(1);
                            response = bVar.getResponse();
                        }
                    } else {
                        bVar.setErrorCode(2);
                        response = bVar.getResponse();
                    }
                } else {
                    bVar.setErrorCode(2);
                    response = bVar.getResponse();
                }
                com.baidu.tbadk.aladin.a.c cVar = new com.baidu.tbadk.aladin.a.c();
                cVar.S("Connection", "Close");
                cVar.setContent(response);
                String pk = cVar.pk();
                OutputStream outputStream = this.Nn.getOutputStream();
                if (outputStream == null) {
                    if (this.Nn != null) {
                        try {
                            if (!this.Nn.isInputShutdown()) {
                                this.Nn.shutdownInput();
                            }
                        } catch (Throwable th7) {
                            th7.printStackTrace();
                        }
                        try {
                            if (!this.Nn.isOutputShutdown()) {
                                this.Nn.shutdownOutput();
                            }
                        } catch (Throwable th8) {
                            th8.printStackTrace();
                        }
                        try {
                            if (this.Nn.isClosed()) {
                                return;
                            }
                            this.Nn.close();
                            return;
                        } catch (Throwable th9) {
                            th9.printStackTrace();
                            return;
                        }
                    }
                    return;
                }
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
                bufferedWriter.write(pk);
                bufferedWriter.flush();
            }
            if (this.Nn != null) {
                try {
                    if (!this.Nn.isInputShutdown()) {
                        this.Nn.shutdownInput();
                    }
                } catch (Throwable th10) {
                    th10.printStackTrace();
                }
                try {
                    if (!this.Nn.isOutputShutdown()) {
                        this.Nn.shutdownOutput();
                    }
                } catch (Throwable th11) {
                    th11.printStackTrace();
                }
                try {
                    if (this.Nn.isClosed()) {
                        return;
                    }
                    this.Nn.close();
                } catch (Throwable th12) {
                    th12.printStackTrace();
                }
            }
        } catch (Throwable th13) {
            if (this.Nn != null) {
                try {
                    if (!this.Nn.isInputShutdown()) {
                        this.Nn.shutdownInput();
                    }
                } catch (Throwable th14) {
                    th14.printStackTrace();
                }
                try {
                    if (!this.Nn.isOutputShutdown()) {
                        this.Nn.shutdownOutput();
                    }
                } catch (Throwable th15) {
                    th15.printStackTrace();
                }
                try {
                    if (!this.Nn.isClosed()) {
                        this.Nn.close();
                    }
                } catch (Throwable th16) {
                    th16.printStackTrace();
                }
            }
            throw th13;
        }
    }
}
