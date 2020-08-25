package com.baidu.location.e;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.webkit.internal.ETAG;
import com.baidubce.http.Headers;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.zip.GZIPInputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes20.dex */
public class h implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ boolean b;
    final /* synthetic */ f c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar, String str, boolean z) {
        this.c = fVar;
        this.a = str;
        this.b = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x024f A[LOOP:0: B:3:0x0016->B:113:0x024f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0223 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0228 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:171:0x022d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0080 A[EDGE_INSN: B:186:0x0080->B:22:0x0080 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x021e  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        ByteArrayOutputStream byteArrayOutputStream;
        OutputStream outputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        HttpURLConnection httpURLConnection2;
        InputStream inputStream2;
        OutputStream outputStream2;
        HttpURLConnection httpURLConnection3;
        boolean z;
        boolean z2;
        ByteArrayOutputStream byteArrayOutputStream3;
        InputStream inputStream3;
        OutputStream outputStream3 = null;
        this.c.h = l.e();
        this.c.a();
        HttpURLConnection httpURLConnection4 = null;
        int i = this.c.i;
        while (i > 0) {
            try {
                URL url = new URL(this.c.h);
                StringBuffer stringBuffer = new StringBuffer();
                for (Map.Entry<String, Object> entry : this.c.k.entrySet()) {
                    stringBuffer.append(entry.getKey());
                    stringBuffer.append(ETAG.EQUAL);
                    stringBuffer.append(entry.getValue());
                    stringBuffer.append(ETAG.ITEM_SEPARATOR);
                }
                if (stringBuffer.length() > 0) {
                    stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                }
                httpURLConnection3 = (HttpURLConnection) url.openConnection();
                try {
                    httpURLConnection3.setRequestMethod("POST");
                    httpURLConnection3.setDoInput(true);
                    httpURLConnection3.setDoOutput(true);
                    httpURLConnection3.setUseCaches(false);
                    httpURLConnection3.setConnectTimeout(a.b);
                    httpURLConnection3.setReadTimeout(a.b);
                    httpURLConnection3.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
                    httpURLConnection3.setRequestProperty("Accept-Charset", "UTF-8");
                    httpURLConnection3.setRequestProperty(Headers.ACCEPT_ENCODING, "gzip");
                    if (l.ax != null) {
                        httpURLConnection3.setRequestProperty("bd-loc-android", l.ax);
                    }
                    if (!TextUtils.isEmpty(this.a)) {
                        httpURLConnection3.setRequestProperty("Host", this.a);
                    }
                    outputStream2 = httpURLConnection3.getOutputStream();
                    try {
                        outputStream2.write(stringBuffer.toString().getBytes());
                        outputStream2.flush();
                        if (httpURLConnection3.getResponseCode() == 200) {
                            inputStream2 = httpURLConnection3.getInputStream();
                            try {
                                String contentEncoding = httpURLConnection3.getContentEncoding();
                                inputStream = (contentEncoding == null || !contentEncoding.contains("gzip")) ? inputStream2 : new GZIPInputStream(new BufferedInputStream(inputStream2));
                                try {
                                    byteArrayOutputStream = new ByteArrayOutputStream();
                                    try {
                                        try {
                                            byte[] bArr = new byte[1024];
                                            while (true) {
                                                int read = inputStream.read(bArr);
                                                if (read == -1) {
                                                    break;
                                                }
                                                byteArrayOutputStream.write(bArr, 0, read);
                                            }
                                            this.c.j = new String(byteArrayOutputStream.toByteArray(), "utf-8");
                                            if (this.b) {
                                                this.c.m = byteArrayOutputStream.toByteArray();
                                            }
                                            this.c.a(true);
                                            inputStream3 = inputStream;
                                            byteArrayOutputStream3 = byteArrayOutputStream;
                                            z2 = true;
                                        } catch (Throwable th) {
                                            outputStream3 = outputStream2;
                                            httpURLConnection = httpURLConnection3;
                                            th = th;
                                            if (httpURLConnection != null) {
                                                httpURLConnection.disconnect();
                                            }
                                            if (outputStream3 != null) {
                                                try {
                                                    outputStream3.close();
                                                } catch (Exception e) {
                                                    Log.d(a.a, "close os IOException!");
                                                }
                                            }
                                            if (inputStream != null) {
                                                try {
                                                    inputStream.close();
                                                } catch (Exception e2) {
                                                    Log.d(a.a, "close is IOException!");
                                                }
                                            }
                                            if (byteArrayOutputStream != null) {
                                                try {
                                                    byteArrayOutputStream.close();
                                                } catch (Exception e3) {
                                                    Log.d(a.a, "close baos IOException!");
                                                }
                                            }
                                            throw th;
                                        }
                                    } catch (Error e4) {
                                        Log.d(a.a, "NetworkCommunicationError!");
                                        if (httpURLConnection3 != null) {
                                            httpURLConnection3.disconnect();
                                        }
                                        if (outputStream2 != null) {
                                            try {
                                                outputStream2.close();
                                            } catch (Exception e5) {
                                                Log.d(a.a, "close os IOException!");
                                            }
                                        }
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (Exception e6) {
                                                Log.d(a.a, "close is IOException!");
                                            }
                                        }
                                        if (byteArrayOutputStream != null) {
                                            try {
                                                byteArrayOutputStream.close();
                                            } catch (Exception e7) {
                                                Log.d(a.a, "close baos IOException!");
                                                httpURLConnection4 = httpURLConnection3;
                                                z = false;
                                            }
                                        }
                                        httpURLConnection4 = httpURLConnection3;
                                        z = false;
                                        if (z) {
                                        }
                                    } catch (Exception e8) {
                                        byteArrayOutputStream2 = byteArrayOutputStream;
                                        inputStream2 = inputStream;
                                        httpURLConnection2 = httpURLConnection3;
                                        outputStream = outputStream2;
                                        try {
                                            Log.d(a.a, "NetworkCommunicationException!");
                                            if (httpURLConnection2 != null) {
                                                httpURLConnection2.disconnect();
                                            }
                                            if (outputStream != null) {
                                                try {
                                                    outputStream.close();
                                                } catch (Exception e9) {
                                                    Log.d(a.a, "close os IOException!");
                                                }
                                            }
                                            if (inputStream2 != null) {
                                                try {
                                                    inputStream2.close();
                                                } catch (Exception e10) {
                                                    Log.d(a.a, "close is IOException!");
                                                }
                                            }
                                            if (byteArrayOutputStream2 != null) {
                                                try {
                                                    byteArrayOutputStream2.close();
                                                } catch (Exception e11) {
                                                    Log.d(a.a, "close baos IOException!");
                                                    z = false;
                                                    httpURLConnection4 = httpURLConnection2;
                                                }
                                            }
                                            z = false;
                                            httpURLConnection4 = httpURLConnection2;
                                            if (z) {
                                            }
                                        } catch (Throwable th2) {
                                            outputStream3 = outputStream;
                                            th = th2;
                                            ByteArrayOutputStream byteArrayOutputStream4 = byteArrayOutputStream2;
                                            httpURLConnection = httpURLConnection2;
                                            inputStream = inputStream2;
                                            byteArrayOutputStream = byteArrayOutputStream4;
                                            if (httpURLConnection != null) {
                                            }
                                            if (outputStream3 != null) {
                                            }
                                            if (inputStream != null) {
                                            }
                                            if (byteArrayOutputStream != null) {
                                            }
                                            throw th;
                                        }
                                    }
                                } catch (Error e12) {
                                    byteArrayOutputStream = null;
                                } catch (Exception e13) {
                                    inputStream2 = inputStream;
                                    httpURLConnection2 = httpURLConnection3;
                                    outputStream = outputStream2;
                                    byteArrayOutputStream2 = null;
                                } catch (Throwable th3) {
                                    byteArrayOutputStream = null;
                                    outputStream3 = outputStream2;
                                    httpURLConnection = httpURLConnection3;
                                    th = th3;
                                }
                            } catch (Error e14) {
                                inputStream = inputStream2;
                                byteArrayOutputStream = null;
                            } catch (Exception e15) {
                                httpURLConnection2 = httpURLConnection3;
                                outputStream = outputStream2;
                                byteArrayOutputStream2 = null;
                            } catch (Throwable th4) {
                                inputStream = inputStream2;
                                byteArrayOutputStream = null;
                                outputStream3 = outputStream2;
                                httpURLConnection = httpURLConnection3;
                                th = th4;
                            }
                        } else {
                            z2 = false;
                            byteArrayOutputStream3 = null;
                            inputStream3 = null;
                        }
                        if (httpURLConnection3 != null) {
                            httpURLConnection3.disconnect();
                        }
                        if (outputStream2 != null) {
                            try {
                                outputStream2.close();
                            } catch (Exception e16) {
                                Log.d(a.a, "close os IOException!");
                            }
                        }
                        if (inputStream3 != null) {
                            try {
                                inputStream3.close();
                            } catch (Exception e17) {
                                Log.d(a.a, "close is IOException!");
                            }
                        }
                        if (byteArrayOutputStream3 != null) {
                            try {
                                byteArrayOutputStream3.close();
                            } catch (Exception e18) {
                                Log.d(a.a, "close baos IOException!");
                                boolean z3 = z2;
                                httpURLConnection4 = httpURLConnection3;
                                z = z3;
                            }
                        }
                        boolean z4 = z2;
                        httpURLConnection4 = httpURLConnection3;
                        z = z4;
                    } catch (Error e19) {
                        byteArrayOutputStream = null;
                        inputStream = null;
                    } catch (Exception e20) {
                        inputStream2 = null;
                        httpURLConnection2 = httpURLConnection3;
                        outputStream = outputStream2;
                        byteArrayOutputStream2 = null;
                    } catch (Throwable th5) {
                        inputStream = null;
                        httpURLConnection = httpURLConnection3;
                        th = th5;
                        byteArrayOutputStream = null;
                        outputStream3 = outputStream2;
                    }
                } catch (Error e21) {
                    outputStream2 = null;
                    byteArrayOutputStream = null;
                    inputStream = null;
                } catch (Exception e22) {
                    byteArrayOutputStream2 = null;
                    inputStream2 = null;
                    httpURLConnection2 = httpURLConnection3;
                    outputStream = null;
                } catch (Throwable th6) {
                    byteArrayOutputStream = null;
                    inputStream = null;
                    httpURLConnection = httpURLConnection3;
                    th = th6;
                }
            } catch (Error e23) {
                outputStream2 = null;
                inputStream = null;
                httpURLConnection3 = httpURLConnection4;
                byteArrayOutputStream = null;
            } catch (Exception e24) {
                outputStream = null;
                byteArrayOutputStream2 = null;
                httpURLConnection2 = httpURLConnection4;
                inputStream2 = null;
            } catch (Throwable th7) {
                th = th7;
                inputStream = null;
                httpURLConnection = httpURLConnection4;
                byteArrayOutputStream = null;
            }
            if (z) {
                break;
            }
            i--;
        }
        if (i > 0) {
            f.p = 0;
            return;
        }
        f.p++;
        this.c.j = null;
        this.c.a(false);
    }
}
