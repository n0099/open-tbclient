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
/* loaded from: classes3.dex */
public class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f2726a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ boolean f2727b;
    final /* synthetic */ f c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar, String str, boolean z) {
        this.c = fVar;
        this.f2726a = str;
        this.f2727b = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x0247 A[LOOP:0: B:3:0x0016->B:113:0x0247, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0080 A[EDGE_INSN: B:173:0x0080->B:22:0x0080 ?: BREAK  , SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        Throwable th;
        OutputStream outputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStream;
        OutputStream outputStream2;
        ByteArrayOutputStream byteArrayOutputStream2;
        HttpURLConnection httpURLConnection;
        boolean z;
        boolean z2;
        this.c.h = l.e();
        this.c.a();
        HttpURLConnection httpURLConnection2 = null;
        int i = this.c.i;
        while (i > 0) {
            try {
                URL url = new URL(this.c.h);
                StringBuffer stringBuffer = new StringBuffer();
                for (Map.Entry<String, Object> entry : this.c.k.entrySet()) {
                    stringBuffer.append(entry.getKey());
                    stringBuffer.append("=");
                    stringBuffer.append(entry.getValue());
                    stringBuffer.append(ETAG.ITEM_SEPARATOR);
                }
                if (stringBuffer.length() > 0) {
                    stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                }
                httpURLConnection = (HttpURLConnection) url.openConnection();
                try {
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setConnectTimeout(a.f2711b);
                    httpURLConnection.setReadTimeout(a.f2711b);
                    httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
                    httpURLConnection.setRequestProperty("Accept-Charset", "UTF-8");
                    httpURLConnection.setRequestProperty(Headers.ACCEPT_ENCODING, "gzip");
                    if (l.ax != null) {
                        httpURLConnection.setRequestProperty("bd-loc-android", l.ax);
                    }
                    if (!TextUtils.isEmpty(this.f2726a)) {
                        httpURLConnection.setRequestProperty("Host", this.f2726a);
                    }
                    outputStream2 = httpURLConnection.getOutputStream();
                    try {
                        outputStream2.write(stringBuffer.toString().getBytes());
                        outputStream2.flush();
                        if (httpURLConnection.getResponseCode() == 200) {
                            inputStream = httpURLConnection.getInputStream();
                            try {
                                String contentEncoding = httpURLConnection.getContentEncoding();
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
                                        this.c.j = new String(byteArrayOutputStream2.toByteArray(), "utf-8");
                                        if (this.f2727b) {
                                            this.c.m = byteArrayOutputStream2.toByteArray();
                                        }
                                        this.c.a(true);
                                        z2 = true;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        outputStream = outputStream2;
                                        byteArrayOutputStream = byteArrayOutputStream2;
                                        httpURLConnection2 = httpURLConnection;
                                        if (httpURLConnection2 != null) {
                                            httpURLConnection2.disconnect();
                                        }
                                        if (outputStream != null) {
                                            try {
                                                outputStream.close();
                                            } catch (Exception e) {
                                                Log.d(a.f2710a, "close os IOException!");
                                            }
                                        }
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (Exception e2) {
                                                Log.d(a.f2710a, "close is IOException!");
                                            }
                                        }
                                        if (byteArrayOutputStream != null) {
                                            try {
                                                byteArrayOutputStream.close();
                                            } catch (Exception e3) {
                                                Log.d(a.f2710a, "close baos IOException!");
                                            }
                                        }
                                        throw th;
                                    }
                                } catch (Error e4) {
                                    Log.d(a.f2710a, "NetworkCommunicationError!");
                                    if (httpURLConnection != null) {
                                        httpURLConnection.disconnect();
                                    }
                                    if (outputStream2 != null) {
                                        try {
                                            outputStream2.close();
                                        } catch (Exception e5) {
                                            Log.d(a.f2710a, "close os IOException!");
                                        }
                                    }
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Exception e6) {
                                            Log.d(a.f2710a, "close is IOException!");
                                        }
                                    }
                                    if (byteArrayOutputStream2 != null) {
                                        try {
                                            byteArrayOutputStream2.close();
                                        } catch (Exception e7) {
                                            Log.d(a.f2710a, "close baos IOException!");
                                            z = false;
                                            httpURLConnection2 = httpURLConnection;
                                        }
                                    }
                                    z = false;
                                    httpURLConnection2 = httpURLConnection;
                                    if (z) {
                                    }
                                } catch (Exception e8) {
                                    Log.d(a.f2710a, "NetworkCommunicationException!");
                                    if (httpURLConnection != null) {
                                        httpURLConnection.disconnect();
                                    }
                                    if (outputStream2 != null) {
                                        try {
                                            outputStream2.close();
                                        } catch (Exception e9) {
                                            Log.d(a.f2710a, "close os IOException!");
                                        }
                                    }
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Exception e10) {
                                            Log.d(a.f2710a, "close is IOException!");
                                        }
                                    }
                                    if (byteArrayOutputStream2 != null) {
                                        try {
                                            byteArrayOutputStream2.close();
                                        } catch (Exception e11) {
                                            Log.d(a.f2710a, "close baos IOException!");
                                            z = false;
                                            httpURLConnection2 = httpURLConnection;
                                        }
                                    }
                                    z = false;
                                    httpURLConnection2 = httpURLConnection;
                                    if (z) {
                                    }
                                }
                            } catch (Error e12) {
                                byteArrayOutputStream2 = null;
                            } catch (Exception e13) {
                                byteArrayOutputStream2 = null;
                            } catch (Throwable th3) {
                                th = th3;
                                outputStream = outputStream2;
                                byteArrayOutputStream = null;
                                httpURLConnection2 = httpURLConnection;
                            }
                        } else {
                            z2 = false;
                            byteArrayOutputStream2 = null;
                            inputStream = null;
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        if (outputStream2 != null) {
                            try {
                                outputStream2.close();
                            } catch (Exception e14) {
                                Log.d(a.f2710a, "close os IOException!");
                            }
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e15) {
                                Log.d(a.f2710a, "close is IOException!");
                            }
                        }
                        if (byteArrayOutputStream2 != null) {
                            try {
                                byteArrayOutputStream2.close();
                            } catch (Exception e16) {
                                Log.d(a.f2710a, "close baos IOException!");
                                z = z2;
                                httpURLConnection2 = httpURLConnection;
                            }
                        }
                        z = z2;
                        httpURLConnection2 = httpURLConnection;
                    } catch (Error e17) {
                        byteArrayOutputStream2 = null;
                        inputStream = null;
                    } catch (Exception e18) {
                        byteArrayOutputStream2 = null;
                        inputStream = null;
                    } catch (Throwable th4) {
                        th = th4;
                        outputStream = outputStream2;
                        byteArrayOutputStream = null;
                        inputStream = null;
                        httpURLConnection2 = httpURLConnection;
                    }
                } catch (Error e19) {
                    outputStream2 = null;
                    byteArrayOutputStream2 = null;
                    inputStream = null;
                } catch (Exception e20) {
                    outputStream2 = null;
                    byteArrayOutputStream2 = null;
                    inputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    outputStream = null;
                    byteArrayOutputStream = null;
                    inputStream = null;
                    httpURLConnection2 = httpURLConnection;
                }
            } catch (Error e21) {
                outputStream2 = null;
                byteArrayOutputStream2 = null;
                inputStream = null;
                httpURLConnection = httpURLConnection2;
            } catch (Exception e22) {
                outputStream2 = null;
                byteArrayOutputStream2 = null;
                inputStream = null;
                httpURLConnection = httpURLConnection2;
            } catch (Throwable th6) {
                th = th6;
                outputStream = null;
                byteArrayOutputStream = null;
                inputStream = null;
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
