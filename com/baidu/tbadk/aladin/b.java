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
    private AladinServer RR;
    private Socket RV;
    private a RW;

    public b(Socket socket, AladinServer aladinServer, a aVar) {
        this.RV = socket;
        this.RR = aladinServer;
        this.RW = aVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [148=6, 150=6, 151=6, 153=6, 154=6, 157=6, 158=6, 160=6, 161=6, 164=6, 165=6, 167=6, 168=6] */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        String readLine;
        com.baidu.tbadk.aladin.a.a qk;
        if (this.RV == null) {
            return;
        }
        try {
            if (this.RR == null || this.RW == null) {
                if (this.RV != null) {
                    try {
                        if (!this.RV.isInputShutdown()) {
                            this.RV.shutdownInput();
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    try {
                        if (!this.RV.isOutputShutdown()) {
                            this.RV.shutdownOutput();
                        }
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                    try {
                        if (this.RV.isClosed()) {
                            return;
                        }
                        this.RV.close();
                        return;
                    } catch (Throwable th3) {
                        th3.printStackTrace();
                        return;
                    }
                }
                return;
            }
            this.RV.setSoTimeout(1000);
            this.RV.setTcpNoDelay(true);
            InputStream inputStream = this.RV.getInputStream();
            if (inputStream == null) {
                if (this.RV != null) {
                    try {
                        if (!this.RV.isInputShutdown()) {
                            this.RV.shutdownInput();
                        }
                    } catch (Throwable th4) {
                        th4.printStackTrace();
                    }
                    try {
                        if (!this.RV.isOutputShutdown()) {
                            this.RV.shutdownOutput();
                        }
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                    }
                    try {
                        if (this.RV.isClosed()) {
                            return;
                        }
                        this.RV.close();
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
            com.baidu.tbadk.aladin.a.a qk2 = new d(new com.baidu.tbadk.aladin.a.a(str)).qk();
            if (qk2 != null && (qk = new e(qk2).qk()) != null && c.qj()) {
                com.baidu.tbadk.aladin.a.b bVar = new com.baidu.tbadk.aladin.a.b(qk);
                boolean qf = bVar.qf();
                String qh = bVar.qh();
                if (qf) {
                    Intent intent = bVar.getIntent();
                    if (intent == null) {
                        bVar.setErrorCode(2);
                        qh = bVar.qh();
                    } else if (new com.baidu.tbadk.aladin.b.a().G(intent)) {
                        try {
                            intent.setClass(this.RR.getApplicationContext(), WebNativeReceiver.class);
                            this.RR.sendBroadcast(intent);
                        } catch (Exception e) {
                            bVar.setErrorCode(1);
                            qh = bVar.qh();
                        }
                    } else {
                        bVar.setErrorCode(2);
                        qh = bVar.qh();
                    }
                } else {
                    bVar.setErrorCode(2);
                    qh = bVar.qh();
                }
                com.baidu.tbadk.aladin.a.c cVar = new com.baidu.tbadk.aladin.a.c();
                cVar.S("Connection", "Close");
                cVar.setContent(qh);
                String qi = cVar.qi();
                OutputStream outputStream = this.RV.getOutputStream();
                if (outputStream == null) {
                    if (this.RV != null) {
                        try {
                            if (!this.RV.isInputShutdown()) {
                                this.RV.shutdownInput();
                            }
                        } catch (Throwable th7) {
                            th7.printStackTrace();
                        }
                        try {
                            if (!this.RV.isOutputShutdown()) {
                                this.RV.shutdownOutput();
                            }
                        } catch (Throwable th8) {
                            th8.printStackTrace();
                        }
                        try {
                            if (this.RV.isClosed()) {
                                return;
                            }
                            this.RV.close();
                            return;
                        } catch (Throwable th9) {
                            th9.printStackTrace();
                            return;
                        }
                    }
                    return;
                }
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
                bufferedWriter.write(qi);
                bufferedWriter.flush();
            }
            if (this.RV != null) {
                try {
                    if (!this.RV.isInputShutdown()) {
                        this.RV.shutdownInput();
                    }
                } catch (Throwable th10) {
                    th10.printStackTrace();
                }
                try {
                    if (!this.RV.isOutputShutdown()) {
                        this.RV.shutdownOutput();
                    }
                } catch (Throwable th11) {
                    th11.printStackTrace();
                }
                try {
                    if (this.RV.isClosed()) {
                        return;
                    }
                    this.RV.close();
                } catch (Throwable th12) {
                    th12.printStackTrace();
                }
            }
        } catch (Throwable th13) {
            if (this.RV != null) {
                try {
                    if (!this.RV.isInputShutdown()) {
                        this.RV.shutdownInput();
                    }
                } catch (Throwable th14) {
                    th14.printStackTrace();
                }
                try {
                    if (!this.RV.isOutputShutdown()) {
                        this.RV.shutdownOutput();
                    }
                } catch (Throwable th15) {
                    th15.printStackTrace();
                }
                try {
                    if (!this.RV.isClosed()) {
                        this.RV.close();
                    }
                } catch (Throwable th16) {
                    th16.printStackTrace();
                }
            }
            throw th13;
        }
    }
}
