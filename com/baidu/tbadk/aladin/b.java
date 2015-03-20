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
    private AladinServer MU;
    private Socket MX;
    private a MY;

    public b(Socket socket, AladinServer aladinServer, a aVar) {
        this.MX = socket;
        this.MU = aladinServer;
        this.MY = aVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [148=6, 150=6, 151=6, 153=6, 154=6, 157=6, 158=6, 160=6, 161=6, 164=6, 165=6, 167=6, 168=6] */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        String readLine;
        com.baidu.tbadk.aladin.a.a oM;
        if (this.MX == null) {
            return;
        }
        try {
            if (this.MU == null || this.MY == null) {
                if (this.MX != null) {
                    try {
                        if (!this.MX.isInputShutdown()) {
                            this.MX.shutdownInput();
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    try {
                        if (!this.MX.isOutputShutdown()) {
                            this.MX.shutdownOutput();
                        }
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                    try {
                        if (this.MX.isClosed()) {
                            return;
                        }
                        this.MX.close();
                        return;
                    } catch (Throwable th3) {
                        th3.printStackTrace();
                        return;
                    }
                }
                return;
            }
            this.MX.setSoTimeout(1000);
            this.MX.setTcpNoDelay(true);
            InputStream inputStream = this.MX.getInputStream();
            if (inputStream == null) {
                if (this.MX != null) {
                    try {
                        if (!this.MX.isInputShutdown()) {
                            this.MX.shutdownInput();
                        }
                    } catch (Throwable th4) {
                        th4.printStackTrace();
                    }
                    try {
                        if (!this.MX.isOutputShutdown()) {
                            this.MX.shutdownOutput();
                        }
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                    }
                    try {
                        if (this.MX.isClosed()) {
                            return;
                        }
                        this.MX.close();
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
            com.baidu.tbadk.aladin.a.a oM2 = new d(new com.baidu.tbadk.aladin.a.a(str)).oM();
            if (oM2 != null && (oM = new e(oM2).oM()) != null && c.oL()) {
                com.baidu.tbadk.aladin.a.b bVar = new com.baidu.tbadk.aladin.a.b(oM);
                boolean oI = bVar.oI();
                String response = bVar.getResponse();
                if (oI) {
                    Intent intent = bVar.getIntent();
                    if (intent == null) {
                        bVar.setErrorCode(2);
                        response = bVar.getResponse();
                    } else if (new com.baidu.tbadk.aladin.b.a().G(intent)) {
                        try {
                            intent.setClass(this.MU.getApplicationContext(), WebNativeReceiver.class);
                            this.MU.sendBroadcast(intent);
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
                cVar.O("Connection", "Close");
                cVar.setContent(response);
                String oK = cVar.oK();
                OutputStream outputStream = this.MX.getOutputStream();
                if (outputStream == null) {
                    if (this.MX != null) {
                        try {
                            if (!this.MX.isInputShutdown()) {
                                this.MX.shutdownInput();
                            }
                        } catch (Throwable th7) {
                            th7.printStackTrace();
                        }
                        try {
                            if (!this.MX.isOutputShutdown()) {
                                this.MX.shutdownOutput();
                            }
                        } catch (Throwable th8) {
                            th8.printStackTrace();
                        }
                        try {
                            if (this.MX.isClosed()) {
                                return;
                            }
                            this.MX.close();
                            return;
                        } catch (Throwable th9) {
                            th9.printStackTrace();
                            return;
                        }
                    }
                    return;
                }
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
                bufferedWriter.write(oK);
                bufferedWriter.flush();
            }
            if (this.MX != null) {
                try {
                    if (!this.MX.isInputShutdown()) {
                        this.MX.shutdownInput();
                    }
                } catch (Throwable th10) {
                    th10.printStackTrace();
                }
                try {
                    if (!this.MX.isOutputShutdown()) {
                        this.MX.shutdownOutput();
                    }
                } catch (Throwable th11) {
                    th11.printStackTrace();
                }
                try {
                    if (this.MX.isClosed()) {
                        return;
                    }
                    this.MX.close();
                } catch (Throwable th12) {
                    th12.printStackTrace();
                }
            }
        } catch (Throwable th13) {
            if (this.MX != null) {
                try {
                    if (!this.MX.isInputShutdown()) {
                        this.MX.shutdownInput();
                    }
                } catch (Throwable th14) {
                    th14.printStackTrace();
                }
                try {
                    if (!this.MX.isOutputShutdown()) {
                        this.MX.shutdownOutput();
                    }
                } catch (Throwable th15) {
                    th15.printStackTrace();
                }
                try {
                    if (!this.MX.isClosed()) {
                        this.MX.close();
                    }
                } catch (Throwable th16) {
                    th16.printStackTrace();
                }
            }
            throw th13;
        }
    }
}
