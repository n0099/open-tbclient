package a.a.a.a.t;

import com.baidu.down.loopj.android.http.AsyncHttpClient;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.GZIPInputStream;
/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    public String f1330a;

    /* renamed from: b  reason: collision with root package name */
    public String f1331b;

    /* renamed from: c  reason: collision with root package name */
    public String f1332c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f1333d;

    public d(String str, e eVar) {
        StringBuilder sb;
        if (str == null) {
            throw new IllegalArgumentException("url is null");
        }
        this.f1330a = str;
        if (eVar != null) {
            String str2 = "?";
            if (str.contains("?")) {
                sb = new StringBuilder();
                sb.append(this.f1330a);
                str2 = "&";
            } else {
                sb = new StringBuilder();
                sb.append(this.f1330a);
            }
            sb.append(str2);
            sb.append(eVar.b());
            this.f1330a = sb.toString();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0074 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00f8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x00f1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public f a() {
        OutputStream outputStream;
        InputStream inputStream;
        Throwable th;
        OutputStream outputStream2;
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f1330a).openConnection();
        InputStream inputStream2 = null;
        try {
            httpURLConnection.setConnectTimeout(30000);
            httpURLConnection.setReadTimeout(8000);
            httpURLConnection.setRequestMethod(this.f1331b);
            httpURLConnection.setDoOutput("POST".equals(this.f1331b) && this.f1333d != null);
            if (this.f1332c != null) {
                httpURLConnection.setRequestProperty("Content-Type", this.f1332c);
            }
            httpURLConnection.setRequestProperty("Accept-Charset", "UTF-8");
            try {
                httpURLConnection.setRequestProperty("user-agent", System.getProperty("http.agent"));
                httpURLConnection.setRequestProperty("Accept-Encoding", "gzip,deflate");
                try {
                    httpURLConnection.connect();
                    if (httpURLConnection.getDoOutput()) {
                        outputStream2 = httpURLConnection.getOutputStream();
                        if (outputStream2 != null) {
                            try {
                                outputStream2.write(this.f1333d);
                                outputStream2.close();
                            } catch (Exception e2) {
                                e = e2;
                                throw new IOException(e);
                            }
                        }
                        inputStream = httpURLConnection.getInputStream();
                        if (inputStream != null) {
                            httpURLConnection.disconnect();
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception unused) {
                                }
                            }
                            if (outputStream2 != null) {
                                try {
                                    outputStream2.close();
                                } catch (Exception unused2) {
                                }
                            }
                            return null;
                        }
                        try {
                            String contentEncoding = httpURLConnection.getContentEncoding();
                            if (contentEncoding != null && AsyncHttpClient.ENCODING_GZIP.equals(contentEncoding.toLowerCase())) {
                                inputStream = new GZIPInputStream(inputStream);
                            }
                        } catch (Throwable th2) {
                            outputStream = outputStream2;
                            th = th2;
                            inputStream2 = inputStream;
                            inputStream = inputStream2;
                            th = th;
                            outputStream2 = outputStream;
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception unused3) {
                                }
                            }
                            if (outputStream2 != null) {
                                try {
                                    outputStream2.close();
                                } catch (Exception unused4) {
                                }
                            }
                            throw th;
                        }
                        try {
                            byte[] bArr = new byte[16384];
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr, 0, read);
                            }
                            f fVar = new f(httpURLConnection.getResponseCode(), httpURLConnection.getContentType(), byteArrayOutputStream.toString());
                            httpURLConnection.disconnect();
                            try {
                                inputStream.close();
                            } catch (Exception unused5) {
                            }
                            if (outputStream2 != null) {
                                try {
                                    outputStream2.close();
                                } catch (Exception unused6) {
                                }
                            }
                            return fVar;
                        } catch (Throwable th3) {
                            th = th3;
                            if (httpURLConnection != null) {
                            }
                            if (inputStream != null) {
                            }
                            if (outputStream2 != null) {
                            }
                            throw th;
                        }
                    }
                    outputStream2 = null;
                    inputStream = httpURLConnection.getInputStream();
                    if (inputStream != null) {
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (Throwable th4) {
                outputStream = "user-agent";
                th = th4;
            }
        } catch (Throwable th5) {
            th = th5;
            outputStream = null;
        }
    }
}
