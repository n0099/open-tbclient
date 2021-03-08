package com.baidu.location.d;

import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class f extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f1970a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.f1970a = eVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0119 A[LOOP:0: B:3:0x001b->B:60:0x0119, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0097 A[EDGE_INSN: B:96:0x0097->B:25:0x0097 ?: BREAK  , SYNTHETIC] */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        HttpURLConnection httpURLConnection;
        boolean z;
        boolean z2;
        this.f1970a.h = j.c();
        this.f1970a.b();
        this.f1970a.a();
        HttpURLConnection httpURLConnection2 = null;
        int i = this.f1970a.i;
        while (i > 0) {
            try {
                httpURLConnection = (HttpURLConnection) new URL(this.f1970a.h).openConnection();
                try {
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setConnectTimeout(a.b);
                    httpURLConnection.setReadTimeout(a.b);
                    httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
                    httpURLConnection.setRequestProperty("Accept-Charset", "UTF-8");
                    if (httpURLConnection.getResponseCode() == 200) {
                        inputStream = httpURLConnection.getInputStream();
                        try {
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
                                    this.f1970a.j = new String(byteArrayOutputStream2.toByteArray(), "utf-8");
                                    this.f1970a.a(true);
                                    httpURLConnection.disconnect();
                                    z2 = true;
                                } catch (Throwable th2) {
                                    th = th2;
                                    byteArrayOutputStream = byteArrayOutputStream2;
                                    httpURLConnection2 = httpURLConnection;
                                    if (httpURLConnection2 != null) {
                                        httpURLConnection2.disconnect();
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
                                Log.d(a.f1963a, "NetworkCommunicationException!");
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
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
                                        httpURLConnection2 = httpURLConnection;
                                    } catch (Exception e5) {
                                        e5.printStackTrace();
                                        z = false;
                                        httpURLConnection2 = httpURLConnection;
                                    }
                                } else {
                                    z = false;
                                    httpURLConnection2 = httpURLConnection;
                                }
                                if (!z) {
                                }
                            }
                        } catch (Exception e6) {
                            byteArrayOutputStream2 = null;
                        } catch (Throwable th3) {
                            th = th3;
                            byteArrayOutputStream = null;
                            httpURLConnection2 = httpURLConnection;
                        }
                    } else {
                        httpURLConnection.disconnect();
                        z2 = false;
                        byteArrayOutputStream2 = null;
                        inputStream = null;
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
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
                            httpURLConnection2 = httpURLConnection;
                        } catch (Exception e8) {
                            e8.printStackTrace();
                            z = z2;
                            httpURLConnection2 = httpURLConnection;
                        }
                    } else {
                        z = z2;
                        httpURLConnection2 = httpURLConnection;
                    }
                } catch (Exception e9) {
                    byteArrayOutputStream2 = null;
                    inputStream = null;
                } catch (Throwable th4) {
                    th = th4;
                    byteArrayOutputStream = null;
                    inputStream = null;
                    httpURLConnection2 = httpURLConnection;
                }
            } catch (Exception e10) {
                byteArrayOutputStream2 = null;
                inputStream = null;
                httpURLConnection = httpURLConnection2;
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
            e.p = 0;
            return;
        }
        e.p++;
        this.f1970a.j = null;
        this.f1970a.a(false);
    }
}
