package com.baidu.location.e;

import android.util.Log;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f2724a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.f2724a = fVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x00b6 A[EDGE_INSN: B:105:0x00b6->B:33:0x00b6 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0138 A[LOOP:0: B:3:0x0014->B:68:0x0138, LOOP_END] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        HttpsURLConnection httpsURLConnection;
        boolean z;
        boolean z2;
        this.f2724a.h = l.f;
        this.f2724a.a();
        HttpsURLConnection httpsURLConnection2 = null;
        int i = this.f2724a.i;
        while (i > 0) {
            try {
                httpsURLConnection = (HttpsURLConnection) new URL(this.f2724a.h).openConnection();
                try {
                    httpsURLConnection.setRequestMethod("GET");
                    httpsURLConnection.setDoInput(true);
                    httpsURLConnection.setDoOutput(true);
                    httpsURLConnection.setUseCaches(false);
                    httpsURLConnection.setConnectTimeout(a.f2710b);
                    httpsURLConnection.setReadTimeout(a.f2710b);
                    httpsURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
                    httpsURLConnection.setRequestProperty("Accept-Charset", "UTF-8");
                    if (l.ax != null) {
                        httpsURLConnection.setRequestProperty("bd-loc-android", l.ax);
                    }
                    if (httpsURLConnection.getResponseCode() == 200) {
                        inputStream = httpsURLConnection.getInputStream();
                        try {
                            String contentEncoding = httpsURLConnection.getContentEncoding();
                            if (contentEncoding != null && contentEncoding.contains("gzip")) {
                                inputStream = new GZIPInputStream(new BufferedInputStream(inputStream));
                            }
                            byteArrayOutputStream2 = new ByteArrayOutputStream();
                            try {
                                try {
                                    byte[] bArr = new byte[1024];
                                    while (true) {
                                        int read = inputStream.read(bArr);
                                        if (read == -1) {
                                            break;
                                        }
                                        byteArrayOutputStream2.write(bArr, 0, read);
                                    }
                                    inputStream.close();
                                    byteArrayOutputStream2.close();
                                    this.f2724a.j = new String(byteArrayOutputStream2.toByteArray(), "utf-8");
                                    this.f2724a.a(true);
                                    httpsURLConnection.disconnect();
                                    z2 = true;
                                } catch (Throwable th2) {
                                    th = th2;
                                    byteArrayOutputStream = byteArrayOutputStream2;
                                    httpsURLConnection2 = httpsURLConnection;
                                    if (httpsURLConnection2 != null) {
                                        httpsURLConnection2.disconnect();
                                    }
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                    if (byteArrayOutputStream != null) {
                                        try {
                                            byteArrayOutputStream.close();
                                        } catch (Exception e2) {
                                            e2.printStackTrace();
                                        }
                                    }
                                    throw th;
                                }
                            } catch (Exception e3) {
                                Log.d(a.f2709a, "NetworkCommunicationException!");
                                if (httpsURLConnection != null) {
                                    httpsURLConnection.disconnect();
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e4) {
                                        e4.printStackTrace();
                                    }
                                }
                                if (byteArrayOutputStream2 != null) {
                                    try {
                                        byteArrayOutputStream2.close();
                                        z = false;
                                        httpsURLConnection2 = httpsURLConnection;
                                    } catch (Exception e5) {
                                        e5.printStackTrace();
                                        z = false;
                                        httpsURLConnection2 = httpsURLConnection;
                                    }
                                } else {
                                    z = false;
                                    httpsURLConnection2 = httpsURLConnection;
                                }
                                if (!z) {
                                }
                            }
                        } catch (Exception e6) {
                            byteArrayOutputStream2 = null;
                        } catch (Throwable th3) {
                            th = th3;
                            byteArrayOutputStream = null;
                            httpsURLConnection2 = httpsURLConnection;
                        }
                    } else {
                        httpsURLConnection.disconnect();
                        z2 = false;
                        byteArrayOutputStream2 = null;
                        inputStream = null;
                    }
                    if (httpsURLConnection != null) {
                        httpsURLConnection.disconnect();
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e7) {
                            e7.printStackTrace();
                        }
                    }
                    if (byteArrayOutputStream2 != null) {
                        try {
                            byteArrayOutputStream2.close();
                            z = z2;
                            httpsURLConnection2 = httpsURLConnection;
                        } catch (Exception e8) {
                            e8.printStackTrace();
                            z = z2;
                            httpsURLConnection2 = httpsURLConnection;
                        }
                    } else {
                        z = z2;
                        httpsURLConnection2 = httpsURLConnection;
                    }
                } catch (Exception e9) {
                    byteArrayOutputStream2 = null;
                    inputStream = null;
                } catch (Throwable th4) {
                    th = th4;
                    byteArrayOutputStream = null;
                    inputStream = null;
                    httpsURLConnection2 = httpsURLConnection;
                }
            } catch (Exception e10) {
                byteArrayOutputStream2 = null;
                inputStream = null;
                httpsURLConnection = httpsURLConnection2;
            } catch (Throwable th5) {
                th = th5;
                byteArrayOutputStream = null;
                inputStream = null;
            }
            if (!z) {
                break;
            }
            i--;
        }
        if (i > 0) {
            f.p = 0;
            return;
        }
        f.p++;
        this.f2724a.j = null;
        this.f2724a.a(false);
    }
}
