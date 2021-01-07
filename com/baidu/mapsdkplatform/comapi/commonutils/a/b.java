package com.baidu.mapsdkplatform.comapi.commonutils.a;

import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapsdkplatform.comapi.commonutils.a.d;
import com.baidubce.http.Headers;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.protocol.HTTP;
/* loaded from: classes3.dex */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private String f3147a;

    /* renamed from: b  reason: collision with root package name */
    private File f3148b;
    private a c;
    private d.b d;
    private volatile boolean e = false;

    public b(String str, File file, a aVar, d.b bVar) {
        this.f3147a = str;
        this.f3148b = file;
        this.c = aVar;
        this.d = bVar;
    }

    public boolean a() {
        return this.e;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00e3 A[Catch: IOException -> 0x00e7, TRY_LEAVE, TryCatch #2 {IOException -> 0x00e7, blocks: (B:42:0x00de, B:44:0x00e3), top: B:58:0x00de }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00de A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        Throwable th;
        RandomAccessFile randomAccessFile;
        InputStream inputStream;
        RandomAccessFile randomAccessFile2;
        InputStream inputStream2;
        HttpsURLConnection httpsURLConnection;
        InputStream inputStream3 = null;
        try {
            URL url = new URL(this.f3147a);
            if (HttpClient.isHttpsEnable) {
                HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) url.openConnection();
                httpsURLConnection2.setHostnameVerifier(new c(this));
                httpsURLConnection = httpsURLConnection2;
            } else {
                httpsURLConnection = (HttpURLConnection) url.openConnection();
            }
            httpsURLConnection.setRequestMethod("GET");
            httpsURLConnection.setConnectTimeout(10000);
            httpsURLConnection.setReadTimeout(10000);
            httpsURLConnection.setRequestProperty(Headers.RANGE, "bytes=" + this.c.a() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.c.b());
            httpsURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            randomAccessFile2 = new RandomAccessFile(this.f3148b, "rw");
            try {
                randomAccessFile2.seek(this.c.a());
                int responseCode = httpsURLConnection.getResponseCode();
                if (responseCode == 200 || responseCode == 206) {
                    byte[] bArr = new byte[1048576];
                    inputStream3 = httpsURLConnection.getInputStream();
                    while (true) {
                        try {
                            int read = inputStream3.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            randomAccessFile2.write(bArr, 0, read);
                        } catch (Exception e) {
                            inputStream2 = inputStream3;
                            try {
                                this.e = false;
                                this.d.b(this);
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (IOException e2) {
                                        e2.printStackTrace();
                                    }
                                }
                                if (randomAccessFile2 != null) {
                                    randomAccessFile2.close();
                                }
                                this.d.a(this);
                            } catch (Throwable th2) {
                                th = th2;
                                randomAccessFile = randomAccessFile2;
                                inputStream = inputStream2;
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException e3) {
                                        e3.printStackTrace();
                                        throw th;
                                    }
                                }
                                if (randomAccessFile != null) {
                                    randomAccessFile.close();
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            randomAccessFile = randomAccessFile2;
                            inputStream = inputStream3;
                            if (inputStream != null) {
                            }
                            if (randomAccessFile != null) {
                            }
                            throw th;
                        }
                    }
                }
                this.e = true;
                if (inputStream3 != null) {
                    try {
                        inputStream3.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                if (randomAccessFile2 != null) {
                    randomAccessFile2.close();
                }
            } catch (Exception e5) {
                inputStream2 = null;
            } catch (Throwable th4) {
                th = th4;
                randomAccessFile = randomAccessFile2;
                inputStream = null;
            }
        } catch (Exception e6) {
            randomAccessFile2 = null;
            inputStream2 = null;
        } catch (Throwable th5) {
            th = th5;
            randomAccessFile = null;
            inputStream = null;
        }
        this.d.a(this);
    }
}
