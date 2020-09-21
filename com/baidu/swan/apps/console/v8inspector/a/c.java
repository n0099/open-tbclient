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
/* loaded from: classes3.dex */
public class c implements a.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private a.InterfaceC0370a cgf;
    private LocalServerSocket cgg;
    com.baidu.swan.apps.console.v8inspector.a.a cgh;
    private String cgi;
    private boolean mRunning;

    /* loaded from: classes3.dex */
    public static class a {
        String cgj;
        boolean cgk;
        Map<String, String> headers = new HashMap();
        String method;
        String uri;
    }

    public c(String str, a.InterfaceC0370a interfaceC0370a) {
        this.cgi = str;
        this.cgf = interfaceC0370a;
    }

    @Override // com.baidu.swan.apps.console.v8inspector.a.b
    public void start() {
        if (!this.mRunning) {
            try {
                this.cgg = new LocalServerSocket(this.cgi);
                this.mRunning = true;
                int i = 0;
                while (this.mRunning) {
                    LocalSocket accept = this.cgg.accept();
                    this.cgh = new com.baidu.swan.apps.console.v8inspector.a.a(accept.getInputStream(), accept.getOutputStream());
                    this.cgh.b(this.cgf);
                    ExecutorUtilsExt.postOnSerial(this.cgh, "V8InspectorServer");
                    if (com.baidu.swan.apps.ad.a.a.axM() && (i = i + 1) > 10) {
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
        if (this.cgg != null) {
            try {
                this.cgg.close();
            } catch (IOException e) {
                com.baidu.swan.apps.console.c.e("V8InspectorServer", "stop local server fail", e);
            }
            this.cgg = null;
        }
        if (this.cgh != null) {
            this.cgh.close();
            this.cgh = null;
        }
        this.cgf = null;
    }

    /* loaded from: classes3.dex */
    public static abstract class b {
        a cgl;

        abstract Map<String, String> afh();

        abstract String afi();

        public b(a aVar) {
            this.cgl = aVar;
        }

        protected String getContent() {
            return "";
        }

        public void send(OutputStream outputStream) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E, d MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            PrintWriter printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
            printWriter.append("HTTP/1.1").append(' ').append((CharSequence) afi()).append(" \r\n");
            a(printWriter, "Date", simpleDateFormat.format(new Date()));
            printWriter.print("Content-Length: " + getContent().getBytes().length + "\r\n");
            Map<String, String> afh = afh();
            if (afh != null && afh.size() > 0) {
                for (Map.Entry<String, String> entry : afh().entrySet()) {
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
