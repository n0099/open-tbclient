package com.baidu.location.e;

import android.util.Log;
import com.baidu.webkit.internal.ETAG;
import com.baidubce.http.Headers;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f2729a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ f f2730b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(f fVar, String str) {
        this.f2730b = fVar;
        this.f2729a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        Throwable th;
        OutputStream outputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStream;
        URL url;
        HttpsURLConnection httpsURLConnection;
        Exception e;
        Error e2;
        this.f2730b.a();
        this.f2730b.h = this.f2729a;
        try {
            try {
                StringBuffer stringBuffer = new StringBuffer();
                url = new URL(this.f2730b.h);
                try {
                    HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) url.openConnection();
                    try {
                        httpsURLConnection2.setInstanceFollowRedirects(false);
                        httpsURLConnection2.setDoOutput(true);
                        httpsURLConnection2.setDoInput(true);
                        httpsURLConnection2.setConnectTimeout(a.f2710b);
                        httpsURLConnection2.setReadTimeout(a.c);
                        httpsURLConnection2.setRequestMethod("POST");
                        httpsURLConnection2.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
                        httpsURLConnection2.setRequestProperty(Headers.ACCEPT_ENCODING, "gzip");
                        if (l.ax != null) {
                            httpsURLConnection2.setRequestProperty("bd-loc-android", l.ax);
                        }
                        for (Map.Entry<String, Object> entry : this.f2730b.k.entrySet()) {
                            stringBuffer.append(entry.getKey());
                            stringBuffer.append("=");
                            stringBuffer.append(entry.getValue());
                            stringBuffer.append(ETAG.ITEM_SEPARATOR);
                        }
                        if (stringBuffer.length() > 0) {
                            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                        }
                        outputStream = httpsURLConnection2.getOutputStream();
                        try {
                            outputStream.write(stringBuffer.toString().getBytes());
                            outputStream.flush();
                            if (httpsURLConnection2.getResponseCode() == 200) {
                                inputStream = httpsURLConnection2.getInputStream();
                                try {
                                    String contentEncoding = httpsURLConnection2.getContentEncoding();
                                    if (contentEncoding != null && contentEncoding.contains("gzip")) {
                                        inputStream = new GZIPInputStream(new BufferedInputStream(inputStream));
                                    }
                                    byteArrayOutputStream = new ByteArrayOutputStream();
                                    try {
                                        byte[] bArr = new byte[1024];
                                        while (true) {
                                            int read = inputStream.read(bArr);
                                            if (read == -1) {
                                                break;
                                            }
                                            byteArrayOutputStream.write(bArr, 0, read);
                                        }
                                        this.f2730b.j = new String(byteArrayOutputStream.toByteArray(), "utf-8");
                                        this.f2730b.a(true);
                                    } catch (Error e3) {
                                        e2 = e3;
                                        httpsURLConnection = httpsURLConnection2;
                                        e2.printStackTrace();
                                        Log.i(a.f2709a, "https NetworkCommunicationError!");
                                        this.f2730b.j = null;
                                        this.f2730b.a(false);
                                        if (httpsURLConnection != null) {
                                            httpsURLConnection.disconnect();
                                        }
                                        if (url != null) {
                                        }
                                        if (outputStream != null) {
                                            try {
                                                outputStream.close();
                                            } catch (Exception e4) {
                                                Log.d(a.f2709a, "close os IOException!");
                                            }
                                        }
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (Exception e5) {
                                                Log.d(a.f2709a, "close is IOException!");
                                            }
                                        }
                                        if (byteArrayOutputStream != null) {
                                            try {
                                                byteArrayOutputStream.close();
                                            } catch (Exception e6) {
                                                Log.d(a.f2709a, "close baos IOException!");
                                            }
                                        }
                                        return;
                                    } catch (Exception e7) {
                                        e = e7;
                                        httpsURLConnection = httpsURLConnection2;
                                        e.printStackTrace();
                                        Log.i(a.f2709a, "https NetworkCommunicationException!");
                                        this.f2730b.j = null;
                                        this.f2730b.a(false);
                                        if (httpsURLConnection != null) {
                                            httpsURLConnection.disconnect();
                                        }
                                        if (url != null) {
                                        }
                                        if (outputStream != null) {
                                            try {
                                                outputStream.close();
                                            } catch (Exception e8) {
                                                Log.d(a.f2709a, "close os IOException!");
                                            }
                                        }
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (Exception e9) {
                                                Log.d(a.f2709a, "close is IOException!");
                                            }
                                        }
                                        if (byteArrayOutputStream != null) {
                                            try {
                                                byteArrayOutputStream.close();
                                            } catch (Exception e10) {
                                                Log.d(a.f2709a, "close baos IOException!");
                                            }
                                        }
                                        return;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        httpsURLConnection = httpsURLConnection2;
                                        if (httpsURLConnection != null) {
                                            httpsURLConnection.disconnect();
                                        }
                                        if (url != null) {
                                        }
                                        if (outputStream != null) {
                                            try {
                                                outputStream.close();
                                            } catch (Exception e11) {
                                                Log.d(a.f2709a, "close os IOException!");
                                            }
                                        }
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (Exception e12) {
                                                Log.d(a.f2709a, "close is IOException!");
                                            }
                                        }
                                        if (byteArrayOutputStream != null) {
                                            try {
                                                byteArrayOutputStream.close();
                                            } catch (Exception e13) {
                                                Log.d(a.f2709a, "close baos IOException!");
                                            }
                                        }
                                        throw th;
                                    }
                                } catch (Error e14) {
                                    e2 = e14;
                                    byteArrayOutputStream = null;
                                    httpsURLConnection = httpsURLConnection2;
                                } catch (Exception e15) {
                                    e = e15;
                                    byteArrayOutputStream = null;
                                    httpsURLConnection = httpsURLConnection2;
                                } catch (Throwable th3) {
                                    th = th3;
                                    byteArrayOutputStream = null;
                                    httpsURLConnection = httpsURLConnection2;
                                }
                            } else {
                                this.f2730b.j = null;
                                this.f2730b.a(false);
                                byteArrayOutputStream = null;
                                inputStream = null;
                            }
                            if (httpsURLConnection2 != null) {
                                httpsURLConnection2.disconnect();
                            }
                            if (url != null) {
                            }
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (Exception e16) {
                                    Log.d(a.f2709a, "close os IOException!");
                                }
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e17) {
                                    Log.d(a.f2709a, "close is IOException!");
                                }
                            }
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                } catch (Exception e18) {
                                    Log.d(a.f2709a, "close baos IOException!");
                                }
                            }
                        } catch (Error e19) {
                            e2 = e19;
                            byteArrayOutputStream = null;
                            inputStream = null;
                            httpsURLConnection = httpsURLConnection2;
                        } catch (Exception e20) {
                            e = e20;
                            byteArrayOutputStream = null;
                            inputStream = null;
                            httpsURLConnection = httpsURLConnection2;
                        } catch (Throwable th4) {
                            th = th4;
                            byteArrayOutputStream = null;
                            inputStream = null;
                            httpsURLConnection = httpsURLConnection2;
                        }
                    } catch (Error e21) {
                        e2 = e21;
                        outputStream = null;
                        byteArrayOutputStream = null;
                        inputStream = null;
                        httpsURLConnection = httpsURLConnection2;
                    } catch (Exception e22) {
                        e = e22;
                        outputStream = null;
                        byteArrayOutputStream = null;
                        inputStream = null;
                        httpsURLConnection = httpsURLConnection2;
                    } catch (Throwable th5) {
                        th = th5;
                        outputStream = null;
                        byteArrayOutputStream = null;
                        inputStream = null;
                        httpsURLConnection = httpsURLConnection2;
                    }
                } catch (Error e23) {
                    e2 = e23;
                    outputStream = null;
                    byteArrayOutputStream = null;
                    inputStream = null;
                    httpsURLConnection = null;
                } catch (Exception e24) {
                    e = e24;
                    outputStream = null;
                    byteArrayOutputStream = null;
                    inputStream = null;
                    httpsURLConnection = null;
                } catch (Throwable th6) {
                    th = th6;
                    outputStream = null;
                    byteArrayOutputStream = null;
                    inputStream = null;
                    httpsURLConnection = null;
                }
            } catch (Throwable th7) {
                th = th7;
            }
        } catch (Error e25) {
            e2 = e25;
            outputStream = null;
            byteArrayOutputStream = null;
            inputStream = null;
            url = null;
            httpsURLConnection = null;
        } catch (Exception e26) {
            e = e26;
            outputStream = null;
            byteArrayOutputStream = null;
            inputStream = null;
            url = null;
            httpsURLConnection = null;
        } catch (Throwable th8) {
            th = th8;
            outputStream = null;
            byteArrayOutputStream = null;
            inputStream = null;
            url = null;
            httpsURLConnection = null;
        }
    }
}
