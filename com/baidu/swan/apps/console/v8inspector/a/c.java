package com.baidu.swan.apps.console.v8inspector.a;

import android.net.LocalServerSocket;
import android.net.LocalSocket;
import android.util.Log;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.console.v8inspector.a;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
/* loaded from: classes11.dex */
public class c implements a.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String bXA;
    private a.InterfaceC0332a bXx;
    private LocalServerSocket bXy;
    com.baidu.swan.apps.console.v8inspector.a.a bXz;
    private boolean mRunning;

    /* loaded from: classes11.dex */
    public static class a {
        String bXB;
        boolean bXC;
        Map<String, String> headers = new HashMap();
        String method;
        String uri;
    }

    public c(String str, a.InterfaceC0332a interfaceC0332a) {
        this.bXA = str;
        this.bXx = interfaceC0332a;
    }

    @Override // com.baidu.swan.apps.console.v8inspector.a.b
    public void start() {
        if (!this.mRunning) {
            try {
                this.bXy = new LocalServerSocket(this.bXA);
                this.mRunning = true;
                int i = 0;
                while (this.mRunning) {
                    LocalSocket accept = this.bXy.accept();
                    this.bXz = new com.baidu.swan.apps.console.v8inspector.a.a(accept.getInputStream(), accept.getOutputStream());
                    this.bXz.b(this.bXx);
                    ExecutorUtilsExt.postOnSerial(this.bXz, "V8InspectorServer");
                    if (com.baidu.swan.apps.af.a.a.anx() && (i = i + 1) > 10) {
                        if (DEBUG) {
                            Log.e("V8InspectorServer", "v8 inspector handshake exceeding the maximum limit");
                            return;
                        }
                        return;
                    }
                }
            } catch (IOException e) {
                com.baidu.swan.apps.console.c.e("V8InspectorServer", "launch local server fail", e);
            }
        }
    }

    @Override // com.baidu.swan.apps.console.v8inspector.a.b
    public void stop() {
        this.mRunning = false;
        if (this.bXy != null) {
            try {
                this.bXy.close();
            } catch (IOException e) {
                com.baidu.swan.apps.console.c.e("V8InspectorServer", "stop local server fail", e);
            }
            this.bXy = null;
        }
        if (this.bXz != null) {
            this.bXz.close();
            this.bXz = null;
        }
        this.bXx = null;
    }

    /* loaded from: classes11.dex */
    public static abstract class b {
        a bXD;

        abstract Map<String, String> XL();

        abstract String XM();

        public b(a aVar) {
            this.bXD = aVar;
        }

        protected String getContent() {
            return "";
        }

        public void send(OutputStream outputStream) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E, d MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            PrintWriter printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
            printWriter.append("HTTP/1.1").append(' ').append((CharSequence) XM()).append(" \r\n");
            a(printWriter, "Date", simpleDateFormat.format(new Date()));
            printWriter.print("Content-Length: " + getContent().getBytes().length + "\r\n");
            Map<String, String> XL = XL();
            if (XL != null && XL.size() > 0) {
                for (Map.Entry<String, String> entry : XL().entrySet()) {
                    a(printWriter, entry.getKey(), entry.getValue());
                }
            }
            printWriter.append("\r\n");
            printWriter.append((CharSequence) getContent());
            printWriter.flush();
        }

        private void a(PrintWriter printWriter, String str, String str2) {
            printWriter.append((CharSequence) str).append(": ").append((CharSequence) str2).append("\r\n");
        }
    }
}
