package com.baidu.location.e;

import android.text.TextUtils;
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
/* loaded from: classes8.dex */
public class g implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ String a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f35708b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ e f35709c;

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
        this.f35709c = eVar;
        this.a = str;
        this.f35708b = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x01be A[LOOP:0: B:5:0x001e->B:111:0x01be, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01db A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01cb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01d3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:173:0x01e2 A[EDGE_INSN: B:173:0x01e2->B:129:0x01e2 ?: BREAK  , SYNTHETIC] */
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
            this.f35709c.f35704h = k.e();
            this.f35709c.b();
            this.f35709c.a();
            int i2 = this.f35709c.f35705i;
            OutputStream outputStream3 = null;
            HttpURLConnection httpURLConnection = null;
            while (i2 > 0) {
                try {
                    URL url = new URL(this.f35709c.f35704h);
                    StringBuffer stringBuffer = new StringBuffer();
                    for (Map.Entry<String, Object> entry : this.f35709c.f35707k.entrySet()) {
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
                        httpURLConnection2.setConnectTimeout(a.f35667b);
                        httpURLConnection2.setReadTimeout(a.f35667b);
                        httpURLConnection2.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
                        httpURLConnection2.setRequestProperty("Accept-Charset", "UTF-8");
                        httpURLConnection2.setRequestProperty("Accept-Encoding", "gzip");
                        if (k.ax != null) {
                            httpURLConnection2.setRequestProperty("bd-loc-android", k.ax);
                        }
                        if (!TextUtils.isEmpty(this.a)) {
                            httpURLConnection2.setRequestProperty("Host", this.a);
                        }
                        OutputStream outputStream4 = httpURLConnection2.getOutputStream();
                        try {
                            outputStream4.write(stringBuffer.toString().getBytes());
                            outputStream4.flush();
                            if (httpURLConnection2.getResponseCode() == 200) {
                                inputStream = httpURLConnection2.getInputStream();
                                try {
                                    String contentEncoding = httpURLConnection2.getContentEncoding();
                                    if (contentEncoding != null && contentEncoding.contains("gzip")) {
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
                                    this.f35709c.f35706j = new String(byteArrayOutputStream.toByteArray(), "utf-8");
                                    if (this.f35708b) {
                                        this.f35709c.m = byteArrayOutputStream.toByteArray();
                                    }
                                    this.f35709c.a(true);
                                    z = true;
                                } catch (Error unused3) {
                                    outputStream2 = outputStream4;
                                    httpURLConnection = httpURLConnection2;
                                    try {
                                        String str = a.a;
                                        if (httpURLConnection != null) {
                                            httpURLConnection.disconnect();
                                        }
                                        if (outputStream2 != null) {
                                            try {
                                                outputStream2.close();
                                            } catch (Exception unused4) {
                                                String str2 = a.a;
                                            }
                                        }
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (Exception unused5) {
                                                String str3 = a.a;
                                            }
                                        }
                                        if (byteArrayOutputStream != null) {
                                            try {
                                                byteArrayOutputStream.close();
                                            } catch (Exception unused6) {
                                                String str4 = a.a;
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
                                                String str5 = a.a;
                                            }
                                        }
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (Exception unused8) {
                                                String str6 = a.a;
                                            }
                                        }
                                        if (byteArrayOutputStream != null) {
                                            try {
                                                byteArrayOutputStream.close();
                                            } catch (Exception unused9) {
                                                String str7 = a.a;
                                            }
                                        }
                                        throw th;
                                    }
                                } catch (Exception unused10) {
                                    outputStream = outputStream4;
                                    httpURLConnection = httpURLConnection2;
                                    String str8 = a.a;
                                    if (httpURLConnection != null) {
                                        httpURLConnection.disconnect();
                                    }
                                    if (outputStream != null) {
                                        try {
                                            outputStream.close();
                                        } catch (Exception unused11) {
                                            String str9 = a.a;
                                        }
                                    }
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Exception unused12) {
                                            String str10 = a.a;
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
                                    String str11 = a.a;
                                }
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception unused14) {
                                    String str12 = a.a;
                                }
                            }
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                } catch (Exception unused15) {
                                    String str13 = a.a;
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
                        inputStream = null;
                        byteArrayOutputStream = null;
                        httpURLConnection = httpURLConnection2;
                        outputStream2 = null;
                    } catch (Exception unused19) {
                        inputStream = null;
                        byteArrayOutputStream = null;
                        httpURLConnection = httpURLConnection2;
                        outputStream = null;
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
            e eVar = this.f35709c;
            eVar.f35706j = null;
            eVar.a(false);
        }
    }
}
