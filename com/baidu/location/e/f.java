package com.baidu.location.e;

import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
/* loaded from: classes2.dex */
public class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e f6752a;

    public f(e eVar) {
        this.f6752a = eVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x0119 A[EDGE_INSN: B:109:0x0119->B:81:0x0119 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00f9 A[LOOP:0: B:3:0x0018->B:65:0x00f9, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0106 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0110 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStream;
        boolean z;
        InputStream inputStream2;
        this.f6752a.f6750h = k.e();
        this.f6752a.b();
        this.f6752a.a();
        int i2 = this.f6752a.f6751i;
        InputStream inputStream3 = null;
        HttpURLConnection httpURLConnection = null;
        while (i2 > 0) {
            try {
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(this.f6752a.f6750h).openConnection();
                try {
                    httpURLConnection2.setRequestMethod("GET");
                    httpURLConnection2.setDoInput(true);
                    httpURLConnection2.setDoOutput(true);
                    httpURLConnection2.setUseCaches(false);
                    httpURLConnection2.setConnectTimeout(a.f6711b);
                    httpURLConnection2.setReadTimeout(a.f6711b);
                    httpURLConnection2.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
                    httpURLConnection2.setRequestProperty("Accept-Charset", "UTF-8");
                    if (k.ax != null) {
                        httpURLConnection2.setRequestProperty("bd-loc-android", k.ax);
                    }
                    if (httpURLConnection2.getResponseCode() == 200) {
                        inputStream2 = httpURLConnection2.getInputStream();
                        try {
                            byteArrayOutputStream = new ByteArrayOutputStream();
                            try {
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int read = inputStream2.read(bArr);
                                    if (read == -1) {
                                        break;
                                    }
                                    byteArrayOutputStream.write(bArr, 0, read);
                                }
                                inputStream2.close();
                                byteArrayOutputStream.close();
                                this.f6752a.j = new String(byteArrayOutputStream.toByteArray(), "utf-8");
                                this.f6752a.a(true);
                                httpURLConnection2.disconnect();
                                z = true;
                            } catch (Exception unused) {
                                inputStream = inputStream2;
                                httpURLConnection = httpURLConnection2;
                                try {
                                    Log.d(a.f6710a, "NetworkCommunicationException!");
                                    if (httpURLConnection != null) {
                                        httpURLConnection.disconnect();
                                    }
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Exception e2) {
                                            e2.printStackTrace();
                                        }
                                    }
                                    if (byteArrayOutputStream != null) {
                                        try {
                                            byteArrayOutputStream.close();
                                        } catch (Exception e3) {
                                            e3.printStackTrace();
                                        }
                                    }
                                    z = false;
                                    if (!z) {
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    inputStream3 = inputStream;
                                    if (httpURLConnection != null) {
                                        httpURLConnection.disconnect();
                                    }
                                    if (inputStream3 != null) {
                                        try {
                                            inputStream3.close();
                                        } catch (Exception e4) {
                                            e4.printStackTrace();
                                        }
                                    }
                                    if (byteArrayOutputStream != null) {
                                        try {
                                            byteArrayOutputStream.close();
                                        } catch (Exception e5) {
                                            e5.printStackTrace();
                                        }
                                    }
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                inputStream3 = inputStream2;
                                httpURLConnection = httpURLConnection2;
                                if (httpURLConnection != null) {
                                }
                                if (inputStream3 != null) {
                                }
                                if (byteArrayOutputStream != null) {
                                }
                                throw th;
                            }
                        } catch (Exception unused2) {
                            byteArrayOutputStream = null;
                        } catch (Throwable th3) {
                            th = th3;
                            byteArrayOutputStream = null;
                        }
                    } else {
                        httpURLConnection2.disconnect();
                        inputStream2 = null;
                        byteArrayOutputStream = null;
                        z = false;
                    }
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (Exception e6) {
                            e6.printStackTrace();
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception e7) {
                            e7.printStackTrace();
                        }
                    }
                    httpURLConnection = httpURLConnection2;
                } catch (Exception unused3) {
                    byteArrayOutputStream = null;
                    httpURLConnection = httpURLConnection2;
                    inputStream = null;
                } catch (Throwable th4) {
                    th = th4;
                    byteArrayOutputStream = null;
                }
            } catch (Exception unused4) {
                inputStream = null;
                byteArrayOutputStream = null;
            } catch (Throwable th5) {
                th = th5;
                byteArrayOutputStream = null;
            }
            if (!z) {
                break;
            }
            i2--;
        }
        if (i2 > 0) {
            e.p = 0;
            return;
        }
        e.p++;
        e eVar = this.f6752a;
        eVar.j = null;
        eVar.a(false);
    }
}
