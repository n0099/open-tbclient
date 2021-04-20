package com.baidu.location.d;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.zip.GZIPInputStream;
/* loaded from: classes2.dex */
public class g extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f6743a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f6744b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ e f6745c;

    public g(e eVar, String str, boolean z) {
        this.f6745c = eVar;
        this.f6743a = str;
        this.f6744b = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x01d7 A[LOOP:0: B:3:0x0022->B:108:0x01d7, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01ef A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01e4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01fa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0204 A[EDGE_INSN: B:167:0x0204->B:126:0x0204 ?: BREAK  , SYNTHETIC] */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        OutputStream outputStream;
        OutputStream outputStream2;
        boolean z;
        this.f6745c.f6741h = j.c();
        this.f6745c.b();
        this.f6745c.a();
        int i = this.f6745c.i;
        OutputStream outputStream3 = null;
        HttpURLConnection httpURLConnection = null;
        while (i > 0) {
            try {
                URL url = new URL(this.f6745c.f6741h);
                StringBuffer stringBuffer = new StringBuffer();
                for (Map.Entry<String, Object> entry : this.f6745c.k.entrySet()) {
                    stringBuffer.append(entry.getKey());
                    stringBuffer.append("=");
                    stringBuffer.append(entry.getValue());
                    stringBuffer.append("&");
                }
                if (stringBuffer.length() > 0) {
                    stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                }
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
                try {
                    httpURLConnection2.setRequestMethod("POST");
                    httpURLConnection2.setDoInput(true);
                    httpURLConnection2.setDoOutput(true);
                    httpURLConnection2.setUseCaches(false);
                    httpURLConnection2.setConnectTimeout(a.f6705b);
                    httpURLConnection2.setReadTimeout(a.f6705b);
                    httpURLConnection2.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
                    httpURLConnection2.setRequestProperty("Accept-Charset", "UTF-8");
                    httpURLConnection2.setRequestProperty("Accept-Encoding", AsyncHttpClient.ENCODING_GZIP);
                    if (!TextUtils.isEmpty(this.f6743a)) {
                        httpURLConnection2.setRequestProperty("Host", this.f6743a);
                    }
                    OutputStream outputStream4 = httpURLConnection2.getOutputStream();
                    try {
                        outputStream4.write(stringBuffer.toString().getBytes());
                        outputStream4.flush();
                        if (httpURLConnection2.getResponseCode() == 200) {
                            inputStream = httpURLConnection2.getInputStream();
                            try {
                                String contentEncoding = httpURLConnection2.getContentEncoding();
                                if (contentEncoding != null && contentEncoding.contains(AsyncHttpClient.ENCODING_GZIP)) {
                                    inputStream = new GZIPInputStream(new BufferedInputStream(inputStream));
                                }
                                byteArrayOutputStream = new ByteArrayOutputStream();
                            } catch (Error unused) {
                                byteArrayOutputStream = null;
                            } catch (Exception unused2) {
                                byteArrayOutputStream = null;
                            } catch (Throwable th) {
                                th = th;
                                byteArrayOutputStream = null;
                            }
                            try {
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int read = inputStream.read(bArr);
                                    if (read == -1) {
                                        break;
                                    }
                                    byteArrayOutputStream.write(bArr, 0, read);
                                }
                                this.f6745c.j = new String(byteArrayOutputStream.toByteArray(), "utf-8");
                                if (this.f6744b) {
                                    this.f6745c.m = byteArrayOutputStream.toByteArray();
                                }
                                this.f6745c.a(true);
                                z = true;
                            } catch (Error unused3) {
                                outputStream2 = outputStream4;
                                httpURLConnection = httpURLConnection2;
                                try {
                                    Log.d(a.f6704a, "NetworkCommunicationError!");
                                    if (httpURLConnection != null) {
                                        httpURLConnection.disconnect();
                                    }
                                    if (outputStream2 != null) {
                                        try {
                                            outputStream2.close();
                                        } catch (Exception unused4) {
                                            Log.d(a.f6704a, "close os IOException!");
                                        }
                                    }
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Exception unused5) {
                                            Log.d(a.f6704a, "close is IOException!");
                                        }
                                    }
                                    if (byteArrayOutputStream != null) {
                                        try {
                                            byteArrayOutputStream.close();
                                        } catch (Exception unused6) {
                                            Log.d(a.f6704a, "close baos IOException!");
                                        }
                                    }
                                    z = false;
                                    if (z) {
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    outputStream3 = outputStream2;
                                    if (httpURLConnection != null) {
                                        httpURLConnection.disconnect();
                                    }
                                    if (outputStream3 != null) {
                                        try {
                                            outputStream3.close();
                                        } catch (Exception unused7) {
                                            Log.d(a.f6704a, "close os IOException!");
                                        }
                                    }
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Exception unused8) {
                                            Log.d(a.f6704a, "close is IOException!");
                                        }
                                    }
                                    if (byteArrayOutputStream != null) {
                                        try {
                                            byteArrayOutputStream.close();
                                        } catch (Exception unused9) {
                                            Log.d(a.f6704a, "close baos IOException!");
                                        }
                                    }
                                    throw th;
                                }
                            } catch (Exception unused10) {
                                outputStream = outputStream4;
                                httpURLConnection = httpURLConnection2;
                                Log.d(a.f6704a, "NetworkCommunicationException!");
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                if (outputStream != null) {
                                    try {
                                        outputStream.close();
                                    } catch (Exception unused11) {
                                        Log.d(a.f6704a, "close os IOException!");
                                    }
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception unused12) {
                                        Log.d(a.f6704a, "close is IOException!");
                                    }
                                }
                                if (byteArrayOutputStream != null) {
                                    byteArrayOutputStream.close();
                                }
                                z = false;
                                if (z) {
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                outputStream3 = outputStream4;
                                httpURLConnection = httpURLConnection2;
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
                        } else {
                            inputStream = null;
                            byteArrayOutputStream = null;
                            z = false;
                        }
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        if (outputStream4 != null) {
                            try {
                                outputStream4.close();
                            } catch (Exception unused13) {
                                Log.d(a.f6704a, "close os IOException!");
                            }
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception unused14) {
                                Log.d(a.f6704a, "close is IOException!");
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception unused15) {
                                Log.d(a.f6704a, "close baos IOException!");
                            }
                        }
                        httpURLConnection = httpURLConnection2;
                    } catch (Error unused16) {
                        inputStream = null;
                        byteArrayOutputStream = null;
                    } catch (Exception unused17) {
                        inputStream = null;
                        byteArrayOutputStream = null;
                    } catch (Throwable th4) {
                        th = th4;
                        inputStream = null;
                        byteArrayOutputStream = null;
                    }
                } catch (Error unused18) {
                    outputStream2 = null;
                    inputStream = null;
                    byteArrayOutputStream = null;
                } catch (Exception unused19) {
                    outputStream = null;
                    inputStream = null;
                    byteArrayOutputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    inputStream = null;
                    byteArrayOutputStream = null;
                }
            } catch (Error unused20) {
                outputStream2 = null;
                inputStream = null;
                byteArrayOutputStream = null;
            } catch (Exception unused21) {
                outputStream = null;
                inputStream = null;
                byteArrayOutputStream = null;
            } catch (Throwable th6) {
                th = th6;
                inputStream = null;
                byteArrayOutputStream = null;
            }
            if (z) {
                break;
            }
            i--;
        }
        if (i > 0) {
            e.p = 0;
            return;
        }
        e.p++;
        e eVar = this.f6745c;
        eVar.j = null;
        eVar.a(false);
    }
}
