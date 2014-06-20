package com.baidu.android.nebula.b;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.apache.commons.io.IOUtils;
/* loaded from: classes.dex */
public class c {
    private u a;
    private String b;
    private InputStream c;
    private Map d;
    private k e;
    private boolean f;

    public c(u uVar, String str, InputStream inputStream) {
        this.d = new HashMap();
        this.a = uVar;
        this.b = str;
        this.c = inputStream;
    }

    public c(u uVar, String str, String str2) {
        ByteArrayInputStream byteArrayInputStream;
        this.d = new HashMap();
        this.a = uVar;
        this.b = str;
        if (str2 != null) {
            try {
                byteArrayInputStream = new ByteArrayInputStream(str2.getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return;
            }
        } else {
            byteArrayInputStream = null;
        }
        this.c = byteArrayInputStream;
    }

    public c(String str) {
        this(u.OK, "text/html", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(OutputStream outputStream) {
        String str = this.b;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E, d MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        try {
            if (this.a == null) {
                throw new Error("sendResponse(): Status can't be null.");
            }
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.print("HTTP/1.1 " + this.a.a() + " \r\n");
            if (str != null) {
                printWriter.print("Content-Type: " + str + IOUtils.LINE_SEPARATOR_WINDOWS);
            }
            if (this.d == null || this.d.get("Date") == null) {
                printWriter.print("Date: " + simpleDateFormat.format(new Date()) + IOUtils.LINE_SEPARATOR_WINDOWS);
            }
            if (this.d != null) {
                for (String str2 : this.d.keySet()) {
                    printWriter.print(str2 + ": " + ((String) this.d.get(str2)) + IOUtils.LINE_SEPARATOR_WINDOWS);
                }
            }
            printWriter.print("Connection: keep-alive\r\n");
            if (this.e == k.HEAD || !this.f) {
                b(outputStream, printWriter);
            } else {
                a(outputStream, printWriter);
            }
            outputStream.flush();
            h.b(this.c);
        } catch (IOException e) {
        }
    }

    private void a(OutputStream outputStream, PrintWriter printWriter) {
        printWriter.print("Transfer-Encoding: chunked\r\n");
        printWriter.print(IOUtils.LINE_SEPARATOR_WINDOWS);
        printWriter.flush();
        byte[] bytes = IOUtils.LINE_SEPARATOR_WINDOWS.getBytes();
        byte[] bArr = new byte[16384];
        while (true) {
            int read = this.c.read(bArr);
            if (read <= 0) {
                outputStream.write(String.format("0\r\n\r\n", new Object[0]).getBytes());
                return;
            }
            outputStream.write(String.format("%x\r\n", Integer.valueOf(read)).getBytes());
            outputStream.write(bArr, 0, read);
            outputStream.write(bytes);
        }
    }

    private void b(OutputStream outputStream, PrintWriter printWriter) {
        int available = this.c != null ? this.c.available() : 0;
        printWriter.print("Content-Length: " + available + IOUtils.LINE_SEPARATOR_WINDOWS);
        printWriter.print(IOUtils.LINE_SEPARATOR_WINDOWS);
        printWriter.flush();
        if (this.e == k.HEAD || this.c == null) {
            return;
        }
        byte[] bArr = new byte[16384];
        int i = available;
        while (i > 0) {
            int read = this.c.read(bArr, 0, i > 16384 ? 16384 : i);
            if (read <= 0) {
                return;
            }
            outputStream.write(bArr, 0, read);
            i -= read;
        }
    }

    public void a(k kVar) {
        this.e = kVar;
    }

    public void a(String str, String str2) {
        this.d.put(str, str2);
    }
}
