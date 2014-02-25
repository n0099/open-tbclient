package com.baidu.sapi2.a;

import com.baidu.sapi2.utils.L;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;
import org.apache.commons.io.IOUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;
/* loaded from: classes.dex */
class d implements HttpEntity {
    private static final char[] d = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    ByteArrayOutputStream a = new ByteArrayOutputStream();
    boolean b = false;
    boolean c = false;
    private String e;

    public d() {
        this.e = null;
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 30; i++) {
            sb.append(d[random.nextInt(d.length)]);
        }
        this.e = sb.toString();
    }

    public void a() {
        if (!this.c) {
            try {
                this.a.write(("--" + this.e + IOUtils.LINE_SEPARATOR_WINDOWS).getBytes());
            } catch (IOException e) {
                L.e(e);
            }
        }
        this.c = true;
    }

    public void b() {
        if (!this.b) {
            try {
                this.a.write(("\r\n--" + this.e + "--\r\n").getBytes());
            } catch (IOException e) {
                L.e(e);
            }
            this.b = true;
        }
    }

    public void a(String str, String str2) {
        a();
        try {
            this.a.write(("Content-Disposition: form-data; name=\"" + str + "\"\r\n\r\n").getBytes());
            this.a.write(str2.getBytes());
            this.a.write(("\r\n--" + this.e + IOUtils.LINE_SEPARATOR_WINDOWS).getBytes());
        } catch (IOException e) {
            L.e(e);
        }
    }

    public void a(String str, String str2, InputStream inputStream, boolean z) {
        a(str, str2, inputStream, "application/octet-stream", z);
    }

    public void a(String str, String str2, InputStream inputStream, String str3, boolean z) {
        a();
        try {
            try {
                this.a.write(("Content-Disposition: form-data; name=\"" + str + "\"; filename=\"" + str2 + "\"\r\n").getBytes());
                this.a.write(("Content-Type: " + str3 + IOUtils.LINE_SEPARATOR_WINDOWS).getBytes());
                this.a.write("Content-Transfer-Encoding: binary\r\n\r\n".getBytes());
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    this.a.write(bArr, 0, read);
                }
                if (!z) {
                    this.a.write(("\r\n--" + this.e + IOUtils.LINE_SEPARATOR_WINDOWS).getBytes());
                }
                this.a.flush();
                try {
                    inputStream.close();
                } catch (IOException e) {
                    L.e(e);
                }
            } catch (IOException e2) {
                L.e(e2);
            }
        } finally {
            try {
                inputStream.close();
            } catch (IOException e3) {
                L.e(e3);
            }
        }
    }

    public long getContentLength() {
        b();
        return this.a.toByteArray().length;
    }

    public Header getContentType() {
        return new BasicHeader("Content-Type", "multipart/form-data; boundary=" + this.e);
    }

    public boolean isChunked() {
        return false;
    }

    public boolean isRepeatable() {
        return false;
    }

    public boolean isStreaming() {
        return false;
    }

    public void writeTo(OutputStream outputStream) {
        outputStream.write(this.a.toByteArray());
    }

    public Header getContentEncoding() {
        return null;
    }

    public void consumeContent() {
        if (isStreaming()) {
            throw new UnsupportedOperationException("Streaming entity does not implement #consumeContent()");
        }
    }

    public InputStream getContent() {
        return new ByteArrayInputStream(this.a.toByteArray());
    }
}
