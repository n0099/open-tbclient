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
/* loaded from: classes8.dex */
public class c implements a.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private a.InterfaceC0398a cMi;
    private LocalServerSocket cMj;
    com.baidu.swan.apps.console.v8inspector.a.a cMk;
    private String cMl;
    private boolean mRunning;

    /* loaded from: classes8.dex */
    public static class a {
        String cMm;
        boolean cMn;
        Map<String, String> headers = new HashMap();
        String method;
        String uri;
    }

    public c(String str, a.InterfaceC0398a interfaceC0398a) {
        this.cMl = str;
        this.cMi = interfaceC0398a;
    }

    @Override // com.baidu.swan.apps.console.v8inspector.a.b
    public void start() {
        if (!this.mRunning) {
            try {
                this.cMj = new LocalServerSocket(this.cMl);
                this.mRunning = true;
                int i = 0;
                while (this.mRunning) {
                    LocalSocket accept = this.cMj.accept();
                    this.cMk = new com.baidu.swan.apps.console.v8inspector.a.a(accept.getInputStream(), accept.getOutputStream());
                    this.cMk.b(this.cMi);
                    ExecutorUtilsExt.postOnSerial(this.cMk, "V8InspectorServer");
                    if (com.baidu.swan.apps.ad.a.a.aER() && (i = i + 1) > 10) {
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
        if (this.cMj != null) {
            try {
                this.cMj.close();
            } catch (IOException e) {
                com.baidu.swan.apps.console.c.e("V8InspectorServer", "stop local server fail", e);
            }
            this.cMj = null;
        }
        if (this.cMk != null) {
            this.cMk.close();
            this.cMk = null;
        }
        this.cMi = null;
    }

    /* loaded from: classes8.dex */
    public static abstract class b {
        a cMo;

        abstract Map<String, String> amf();

        abstract String amg();

        public b(a aVar) {
            this.cMo = aVar;
        }

        protected String getContent() {
            return "";
        }

        public void send(OutputStream outputStream) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E, d MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            PrintWriter printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
            printWriter.append("HTTP/1.1").append(' ').append((CharSequence) amg()).append(" \r\n");
            a(printWriter, "Date", simpleDateFormat.format(new Date()));
            printWriter.print("Content-Length: " + getContent().getBytes().length + "\r\n");
            Map<String, String> amf = amf();
            if (amf != null && amf.size() > 0) {
                for (Map.Entry<String, String> entry : amf().entrySet()) {
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
