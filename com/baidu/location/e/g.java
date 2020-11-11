package com.baidu.location.e;

import android.util.Log;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f1952a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.f1952a = fVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x00b9 A[EDGE_INSN: B:117:0x00b9->B:34:0x00b9 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x013f A[LOOP:0: B:3:0x0014->B:69:0x013f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x012c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0131 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        HttpsURLConnection httpsURLConnection;
        InputStream inputStream2;
        boolean z;
        boolean z2;
        ByteArrayOutputStream byteArrayOutputStream2;
        InputStream inputStream3;
        ByteArrayOutputStream byteArrayOutputStream3;
        ByteArrayOutputStream byteArrayOutputStream4 = null;
        this.f1952a.h = l.f;
        this.f1952a.a();
        HttpsURLConnection httpsURLConnection2 = null;
        int i = this.f1952a.i;
        while (i > 0) {
            try {
                HttpsURLConnection httpsURLConnection3 = (HttpsURLConnection) new URL(this.f1952a.h).openConnection();
                try {
                    httpsURLConnection3.setRequestMethod("GET");
                    httpsURLConnection3.setDoInput(true);
                    httpsURLConnection3.setDoOutput(true);
                    httpsURLConnection3.setUseCaches(false);
                    httpsURLConnection3.setConnectTimeout(a.b);
                    httpsURLConnection3.setReadTimeout(a.b);
                    httpsURLConnection3.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
                    httpsURLConnection3.setRequestProperty("Accept-Charset", "UTF-8");
                    if (l.ax != null) {
                        httpsURLConnection3.setRequestProperty("bd-loc-android", l.ax);
                    }
                    if (httpsURLConnection3.getResponseCode() == 200) {
                        inputStream2 = httpsURLConnection3.getInputStream();
                        try {
                            String contentEncoding = httpsURLConnection3.getContentEncoding();
                            inputStream = (contentEncoding == null || !contentEncoding.contains("gzip")) ? inputStream2 : new GZIPInputStream(new BufferedInputStream(inputStream2));
                            try {
                                byteArrayOutputStream3 = new ByteArrayOutputStream();
                            } catch (Exception e) {
                                inputStream2 = inputStream;
                                httpsURLConnection = httpsURLConnection3;
                                byteArrayOutputStream = null;
                            } catch (Throwable th) {
                                httpsURLConnection2 = httpsURLConnection3;
                                th = th;
                            }
                        } catch (Exception e2) {
                            httpsURLConnection = httpsURLConnection3;
                            byteArrayOutputStream = null;
                        } catch (Throwable th2) {
                            inputStream = inputStream2;
                            httpsURLConnection2 = httpsURLConnection3;
                            th = th2;
                        }
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream3.write(bArr, 0, read);
                            }
                            inputStream.close();
                            byteArrayOutputStream3.close();
                            this.f1952a.j = new String(byteArrayOutputStream3.toByteArray(), "utf-8");
                            this.f1952a.a(true);
                            httpsURLConnection3.disconnect();
                            inputStream3 = inputStream;
                            byteArrayOutputStream2 = byteArrayOutputStream3;
                            z2 = true;
                        } catch (Exception e3) {
                            inputStream2 = inputStream;
                            httpsURLConnection = httpsURLConnection3;
                            byteArrayOutputStream = byteArrayOutputStream3;
                            try {
                                Log.d(a.f1944a, "NetworkCommunicationException!");
                                if (httpsURLConnection != null) {
                                    httpsURLConnection.disconnect();
                                }
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (Exception e4) {
                                        e4.printStackTrace();
                                    }
                                }
                                if (byteArrayOutputStream != null) {
                                    try {
                                        byteArrayOutputStream.close();
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
                            } catch (Throwable th3) {
                                byteArrayOutputStream4 = byteArrayOutputStream;
                                th = th3;
                                InputStream inputStream4 = inputStream2;
                                httpsURLConnection2 = httpsURLConnection;
                                inputStream = inputStream4;
                                if (httpsURLConnection2 != null) {
                                    httpsURLConnection2.disconnect();
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e6) {
                                        e6.printStackTrace();
                                    }
                                }
                                if (byteArrayOutputStream4 != null) {
                                    try {
                                        byteArrayOutputStream4.close();
                                    } catch (Exception e7) {
                                        e7.printStackTrace();
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th4) {
                            byteArrayOutputStream4 = byteArrayOutputStream3;
                            httpsURLConnection2 = httpsURLConnection3;
                            th = th4;
                            if (httpsURLConnection2 != null) {
                            }
                            if (inputStream != null) {
                            }
                            if (byteArrayOutputStream4 != null) {
                            }
                            throw th;
                        }
                    } else {
                        httpsURLConnection3.disconnect();
                        z2 = false;
                        byteArrayOutputStream2 = null;
                        inputStream3 = null;
                    }
                    if (httpsURLConnection3 != null) {
                        httpsURLConnection3.disconnect();
                    }
                    if (inputStream3 != null) {
                        try {
                            inputStream3.close();
                        } catch (Exception e8) {
                            e8.printStackTrace();
                        }
                    }
                    if (byteArrayOutputStream2 != null) {
                        try {
                            byteArrayOutputStream2.close();
                            boolean z3 = z2;
                            httpsURLConnection2 = httpsURLConnection3;
                            z = z3;
                        } catch (Exception e9) {
                            e9.printStackTrace();
                            boolean z4 = z2;
                            httpsURLConnection2 = httpsURLConnection3;
                            z = z4;
                        }
                    } else {
                        boolean z5 = z2;
                        httpsURLConnection2 = httpsURLConnection3;
                        z = z5;
                    }
                } catch (Exception e10) {
                    inputStream2 = null;
                    httpsURLConnection = httpsURLConnection3;
                    byteArrayOutputStream = null;
                } catch (Throwable th5) {
                    inputStream = null;
                    httpsURLConnection2 = httpsURLConnection3;
                    th = th5;
                }
            } catch (Exception e11) {
                byteArrayOutputStream = null;
                httpsURLConnection = httpsURLConnection2;
                inputStream2 = null;
            } catch (Throwable th6) {
                th = th6;
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
        this.f1952a.j = null;
        this.f1952a.a(false);
    }
}
