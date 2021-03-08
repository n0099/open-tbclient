package a.a.a.a.b;

import com.baidu.webkit.internal.ETAG;
import com.baidubce.http.Headers;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.GZIPInputStream;
/* loaded from: classes4.dex */
public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    public String f956a;
    public String b;
    public String c;
    public byte[] d;

    public d(String str, e eVar) {
        if (str == null) {
            throw new IllegalArgumentException("url is null");
        }
        this.f956a = str;
        if (eVar != null) {
            if (str.contains("?")) {
                this.f956a += ETAG.ITEM_SEPARATOR + eVar.b();
            } else {
                this.f956a += "?" + eVar.b();
            }
        }
    }

    public f hv() {
        OutputStream outputStream;
        boolean z = false;
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f956a).openConnection();
        try {
            httpURLConnection.setConnectTimeout(30000);
            httpURLConnection.setReadTimeout(8000);
            httpURLConnection.setRequestMethod(this.b);
            if ("POST".equals(this.b) && this.d != null) {
                z = true;
            }
            httpURLConnection.setDoOutput(z);
            if (this.c != null) {
                httpURLConnection.setRequestProperty("Content-Type", this.c);
            }
            httpURLConnection.setRequestProperty("Accept-Charset", "UTF-8");
            httpURLConnection.setRequestProperty("user-agent", System.getProperty("http.agent"));
            httpURLConnection.setRequestProperty(Headers.ACCEPT_ENCODING, "gzip,deflate");
            httpURLConnection.connect();
            if (httpURLConnection.getDoOutput() && (outputStream = httpURLConnection.getOutputStream()) != null) {
                outputStream.write(this.d);
                outputStream.close();
            }
            try {
                InputStream inputStream = httpURLConnection.getInputStream();
                if (inputStream == null) {
                    httpURLConnection.disconnect();
                    return null;
                }
                String contentEncoding = httpURLConnection.getContentEncoding();
                InputStream gZIPInputStream = (contentEncoding == null || !"gzip".equals(contentEncoding.toLowerCase())) ? inputStream : new GZIPInputStream(inputStream);
                byte[] bArr = new byte[16384];
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    int read = gZIPInputStream.read(bArr);
                    if (read == -1) {
                        gZIPInputStream.close();
                        f fVar = new f(httpURLConnection.getResponseCode(), httpURLConnection.getContentType(), byteArrayOutputStream.toString());
                        httpURLConnection.disconnect();
                        return fVar;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
            } catch (Exception e) {
                throw new IOException(e);
            }
        } catch (Throwable th) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }
}
