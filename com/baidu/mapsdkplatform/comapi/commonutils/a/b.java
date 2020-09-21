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
    private String a;
    private File b;
    private a c;
    private d.b d;
    private volatile boolean e = false;

    public b(String str, File file, a aVar, d.b bVar) {
        this.a = str;
        this.b = file;
        this.c = aVar;
        this.d = bVar;
    }

    public boolean a() {
        return this.e;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00e0 A[Catch: IOException -> 0x00e4, TRY_LEAVE, TryCatch #1 {IOException -> 0x00e4, blocks: (B:41:0x00db, B:43:0x00e0), top: B:55:0x00db }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00db A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        InputStream inputStream;
        RandomAccessFile randomAccessFile;
        HttpsURLConnection httpsURLConnection;
        RandomAccessFile randomAccessFile2 = null;
        r4 = null;
        r4 = null;
        InputStream inputStream2 = null;
        try {
            URL url = new URL(this.a);
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
            randomAccessFile = new RandomAccessFile(this.b, "rw");
            try {
                try {
                    randomAccessFile.seek(this.c.a());
                    int responseCode = httpsURLConnection.getResponseCode();
                    if (responseCode == 200 || responseCode == 206) {
                        byte[] bArr = new byte[1048576];
                        inputStream2 = httpsURLConnection.getInputStream();
                        while (true) {
                            try {
                                int read = inputStream2.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                randomAccessFile.write(bArr, 0, read);
                            } catch (Throwable th) {
                                inputStream = inputStream2;
                                randomAccessFile2 = randomAccessFile;
                                th = th;
                                if (inputStream != null) {
                                }
                                if (randomAccessFile2 != null) {
                                }
                                throw th;
                            }
                        }
                    }
                    this.e = true;
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (randomAccessFile != null) {
                        randomAccessFile.close();
                    }
                } catch (Exception e2) {
                    this.e = false;
                    this.d.b(this);
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    if (randomAccessFile != null) {
                        randomAccessFile.close();
                    }
                    this.d.a(this);
                }
            } catch (Throwable th2) {
                inputStream = null;
                randomAccessFile2 = randomAccessFile;
                th = th2;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                        throw th;
                    }
                }
                if (randomAccessFile2 != null) {
                    randomAccessFile2.close();
                }
                throw th;
            }
        } catch (Exception e5) {
            randomAccessFile = null;
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
        }
        this.d.a(this);
    }
}
