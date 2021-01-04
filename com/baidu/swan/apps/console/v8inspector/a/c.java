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
/* loaded from: classes9.dex */
public class c implements a.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private a.InterfaceC0415a cQU;
    private LocalServerSocket cQV;
    com.baidu.swan.apps.console.v8inspector.a.a cQW;
    private String cQX;
    private boolean mRunning;

    /* loaded from: classes9.dex */
    public static class a {
        String cQY;
        boolean cQZ;
        Map<String, String> headers = new HashMap();
        String method;
        String uri;
    }

    public c(String str, a.InterfaceC0415a interfaceC0415a) {
        this.cQX = str;
        this.cQU = interfaceC0415a;
    }

    @Override // com.baidu.swan.apps.console.v8inspector.a.b
    public void start() {
        if (!this.mRunning) {
            try {
                this.cQV = new LocalServerSocket(this.cQX);
                this.mRunning = true;
                int i = 0;
                while (this.mRunning) {
                    LocalSocket accept = this.cQV.accept();
                    this.cQW = new com.baidu.swan.apps.console.v8inspector.a.a(accept.getInputStream(), accept.getOutputStream());
                    this.cQW.b(this.cQU);
                    ExecutorUtilsExt.postOnSerial(this.cQW, "V8InspectorServer");
                    if (com.baidu.swan.apps.ad.a.a.aIK() && (i = i + 1) > 10) {
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
        if (this.cQV != null) {
            try {
                this.cQV.close();
            } catch (IOException e) {
                com.baidu.swan.apps.console.c.e("V8InspectorServer", "stop local server fail", e);
            }
            this.cQV = null;
        }
        if (this.cQW != null) {
            this.cQW.close();
            this.cQW = null;
        }
        this.cQU = null;
    }

    /* loaded from: classes9.dex */
    public static abstract class b {
        a cRa;

        abstract Map<String, String> apZ();

        abstract String aqa();

        public b(a aVar) {
            this.cRa = aVar;
        }

        protected String getContent() {
            return "";
        }

        public void send(OutputStream outputStream) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E, d MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            PrintWriter printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
            printWriter.append("HTTP/1.1").append(' ').append((CharSequence) aqa()).append(" \r\n");
            a(printWriter, "Date", simpleDateFormat.format(new Date()));
            printWriter.print("Content-Length: " + getContent().getBytes().length + "\r\n");
            Map<String, String> apZ = apZ();
            if (apZ != null && apZ.size() > 0) {
                for (Map.Entry<String, String> entry : apZ().entrySet()) {
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
