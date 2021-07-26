package com.baidu.location.e;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.zip.GZIPInputStream;
/* loaded from: classes2.dex */
public class g implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f6826a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f6827b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ e f6828c;

    public g(e eVar, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar, str, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f6828c = eVar;
        this.f6826a = str;
        this.f6827b = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x01e6 A[LOOP:0: B:5:0x0026->B:113:0x01e6, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01f3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0209 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01fe A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0213 A[EDGE_INSN: B:175:0x0213->B:131:0x0213 ?: BREAK  , SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        OutputStream outputStream;
        OutputStream outputStream2;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f6828c.f6823h = k.e();
            this.f6828c.b();
            this.f6828c.a();
            int i2 = this.f6828c.f6824i;
            OutputStream outputStream3 = null;
            HttpURLConnection httpURLConnection = null;
            while (i2 > 0) {
                try {
                    URL url = new URL(this.f6828c.f6823h);
                    StringBuffer stringBuffer = new StringBuffer();
                    for (Map.Entry<String, Object> entry : this.f6828c.k.entrySet()) {
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
                        httpURLConnection2.setConnectTimeout(a.f6784b);
                        httpURLConnection2.setReadTimeout(a.f6784b);
                        httpURLConnection2.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
                        httpURLConnection2.setRequestProperty("Accept-Charset", "UTF-8");
                        httpURLConnection2.setRequestProperty("Accept-Encoding", AsyncHttpClient.ENCODING_GZIP);
                        if (k.ax != null) {
                            httpURLConnection2.setRequestProperty("bd-loc-android", k.ax);
                        }
                        if (!TextUtils.isEmpty(this.f6826a)) {
                            httpURLConnection2.setRequestProperty("Host", this.f6826a);
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
                                    try {
                                        byte[] bArr = new byte[1024];
                                        while (true) {
                                            int read = inputStream.read(bArr);
                                            if (read == -1) {
                                                break;
                                            }
                                            byteArrayOutputStream.write(bArr, 0, read);
                                        }
                                        this.f6828c.j = new String(byteArrayOutputStream.toByteArray(), "utf-8");
                                        if (this.f6827b) {
                                            this.f6828c.m = byteArrayOutputStream.toByteArray();
                                        }
                                        this.f6828c.a(true);
                                        z = true;
                                    } catch (Error unused) {
                                        outputStream2 = outputStream4;
                                        httpURLConnection = httpURLConnection2;
                                        try {
                                            Log.d(a.f6783a, "NetworkCommunicationError!");
                                            if (httpURLConnection != null) {
                                                httpURLConnection.disconnect();
                                            }
                                            if (outputStream2 != null) {
                                                try {
                                                    outputStream2.close();
                                                } catch (Exception unused2) {
                                                    Log.d(a.f6783a, "close os IOException!");
                                                }
                                            }
                                            if (inputStream != null) {
                                                try {
                                                    inputStream.close();
                                                } catch (Exception unused3) {
                                                    Log.d(a.f6783a, "close is IOException!");
                                                }
                                            }
                                            if (byteArrayOutputStream != null) {
                                                try {
                                                    byteArrayOutputStream.close();
                                                } catch (Exception unused4) {
                                                    Log.d(a.f6783a, "close baos IOException!");
                                                }
                                            }
                                            z = false;
                                            if (z) {
                                            }
                                        } catch (Throwable th) {
                                            th = th;
                                            outputStream3 = outputStream2;
                                            if (httpURLConnection != null) {
                                                httpURLConnection.disconnect();
                                            }
                                            if (outputStream3 != null) {
                                                try {
                                                    outputStream3.close();
                                                } catch (Exception unused5) {
                                                    Log.d(a.f6783a, "close os IOException!");
                                                }
                                            }
                                            if (inputStream != null) {
                                                try {
                                                    inputStream.close();
                                                } catch (Exception unused6) {
                                                    Log.d(a.f6783a, "close is IOException!");
                                                }
                                            }
                                            if (byteArrayOutputStream != null) {
                                                try {
                                                    byteArrayOutputStream.close();
                                                } catch (Exception unused7) {
                                                    Log.d(a.f6783a, "close baos IOException!");
                                                }
                                            }
                                            throw th;
                                        }
                                    } catch (Exception unused8) {
                                        outputStream = outputStream4;
                                        httpURLConnection = httpURLConnection2;
                                        Log.d(a.f6783a, "NetworkCommunicationException!");
                                        if (httpURLConnection != null) {
                                            httpURLConnection.disconnect();
                                        }
                                        if (outputStream != null) {
                                            try {
                                                outputStream.close();
                                            } catch (Exception unused9) {
                                                Log.d(a.f6783a, "close os IOException!");
                                            }
                                        }
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (Exception unused10) {
                                                Log.d(a.f6783a, "close is IOException!");
                                            }
                                        }
                                        if (byteArrayOutputStream != null) {
                                            byteArrayOutputStream.close();
                                        }
                                        z = false;
                                        if (z) {
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
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
                                } catch (Error unused11) {
                                    byteArrayOutputStream = null;
                                } catch (Exception unused12) {
                                    byteArrayOutputStream = null;
                                } catch (Throwable th3) {
                                    th = th3;
                                    byteArrayOutputStream = null;
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
                                    Log.d(a.f6783a, "close os IOException!");
                                }
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception unused14) {
                                    Log.d(a.f6783a, "close is IOException!");
                                }
                            }
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                } catch (Exception unused15) {
                                    Log.d(a.f6783a, "close baos IOException!");
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
                i2--;
            }
            if (i2 > 0) {
                e.p = 0;
                return;
            }
            e.p++;
            e eVar = this.f6828c;
            eVar.j = null;
            eVar.a(false);
        }
    }
}
