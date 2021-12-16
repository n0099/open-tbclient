package com.baidu.location.e;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
/* loaded from: classes10.dex */
public class h extends Thread {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ String a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ e f36199b;

    public h(e eVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f36199b = eVar;
        this.a = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01a6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01ae A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01da A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0205 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01d2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01f5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01fd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:174:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:175:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01a1  */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStream;
        OutputStream outputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        InputStream inputStream2;
        URL url;
        HttpsURLConnection httpsURLConnection;
        StringBuffer stringBuffer;
        URL url2;
        HttpsURLConnection httpsURLConnection2;
        ByteArrayOutputStream byteArrayOutputStream3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f36199b.a();
            this.f36199b.b();
            this.f36199b.f36193h = this.a;
            HttpsURLConnection httpsURLConnection3 = null;
            InputStream inputStream3 = null;
            httpsURLConnection3 = null;
            try {
                try {
                    try {
                        stringBuffer = new StringBuffer();
                        url2 = new URL(this.f36199b.f36193h);
                        try {
                            httpsURLConnection2 = (HttpsURLConnection) url2.openConnection();
                        } catch (Error e2) {
                            e = e2;
                            byteArrayOutputStream2 = null;
                            httpsURLConnection = null;
                            outputStream = null;
                        } catch (Exception e3) {
                            e = e3;
                            byteArrayOutputStream2 = null;
                            httpsURLConnection = null;
                            outputStream = null;
                        } catch (Throwable th) {
                            th = th;
                            byteArrayOutputStream = null;
                            inputStream = null;
                            outputStream = null;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        inputStream = inputStream2;
                        httpsURLConnection3 = httpsURLConnection;
                    }
                } catch (Error e4) {
                    e = e4;
                    byteArrayOutputStream2 = null;
                    inputStream2 = null;
                    url = null;
                    httpsURLConnection = null;
                    outputStream = null;
                } catch (Exception e5) {
                    e = e5;
                    byteArrayOutputStream2 = null;
                    inputStream2 = null;
                    url = null;
                    httpsURLConnection = null;
                    outputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    byteArrayOutputStream = null;
                    inputStream = null;
                    outputStream = null;
                }
                try {
                    httpsURLConnection2.setInstanceFollowRedirects(false);
                    httpsURLConnection2.setDoOutput(true);
                    httpsURLConnection2.setDoInput(true);
                    httpsURLConnection2.setConnectTimeout(a.f36156b);
                    httpsURLConnection2.setReadTimeout(a.f36157c);
                    httpsURLConnection2.setRequestMethod("POST");
                    httpsURLConnection2.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
                    httpsURLConnection2.setRequestProperty("Accept-Encoding", "gzip");
                    if (k.ax != null) {
                        httpsURLConnection2.setRequestProperty("bd-loc-android", k.ax);
                    }
                    for (Map.Entry<String, Object> entry : this.f36199b.f36196k.entrySet()) {
                        stringBuffer.append(entry.getKey());
                        stringBuffer.append("=");
                        stringBuffer.append(entry.getValue());
                        stringBuffer.append("&");
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
                                byteArrayOutputStream3 = new ByteArrayOutputStream();
                                try {
                                    byte[] bArr = new byte[1024];
                                    while (true) {
                                        int read = inputStream.read(bArr);
                                        if (read == -1) {
                                            break;
                                        }
                                        byteArrayOutputStream3.write(bArr, 0, read);
                                    }
                                    this.f36199b.f36195j = new String(byteArrayOutputStream3.toByteArray(), "utf-8");
                                    this.f36199b.a(true);
                                    inputStream3 = inputStream;
                                } catch (Error e6) {
                                    InputStream inputStream4 = inputStream;
                                    byteArrayOutputStream2 = byteArrayOutputStream3;
                                    e = e6;
                                    httpsURLConnection = httpsURLConnection2;
                                    url = url2;
                                    inputStream2 = inputStream4;
                                    e.printStackTrace();
                                    String str = a.a;
                                    this.f36199b.f36195j = null;
                                    this.f36199b.a(false);
                                    if (httpsURLConnection != null) {
                                        httpsURLConnection.disconnect();
                                    }
                                    if (outputStream != null) {
                                        try {
                                            outputStream.close();
                                        } catch (Exception unused) {
                                            String str2 = a.a;
                                        }
                                    }
                                    if (inputStream2 != null) {
                                        try {
                                            inputStream2.close();
                                        } catch (Exception unused2) {
                                            String str3 = a.a;
                                        }
                                    }
                                    if (byteArrayOutputStream2 == null) {
                                        return;
                                    }
                                    byteArrayOutputStream2.close();
                                } catch (Exception e7) {
                                    InputStream inputStream5 = inputStream;
                                    byteArrayOutputStream2 = byteArrayOutputStream3;
                                    e = e7;
                                    httpsURLConnection = httpsURLConnection2;
                                    url = url2;
                                    inputStream2 = inputStream5;
                                    e.printStackTrace();
                                    String str4 = a.a;
                                    this.f36199b.f36195j = null;
                                    this.f36199b.a(false);
                                    if (httpsURLConnection != null) {
                                        httpsURLConnection.disconnect();
                                    }
                                    if (outputStream != null) {
                                        try {
                                            outputStream.close();
                                        } catch (Exception unused3) {
                                            String str5 = a.a;
                                        }
                                    }
                                    if (inputStream2 != null) {
                                        try {
                                            inputStream2.close();
                                        } catch (Exception unused4) {
                                            String str6 = a.a;
                                        }
                                    }
                                    if (byteArrayOutputStream2 == null) {
                                        return;
                                    }
                                    byteArrayOutputStream2.close();
                                } catch (Throwable th4) {
                                    httpsURLConnection3 = httpsURLConnection2;
                                    byteArrayOutputStream = byteArrayOutputStream3;
                                    th = th4;
                                    if (httpsURLConnection3 != null) {
                                        httpsURLConnection3.disconnect();
                                    }
                                    if (outputStream != null) {
                                        try {
                                            outputStream.close();
                                        } catch (Exception unused5) {
                                            String str7 = a.a;
                                        }
                                    }
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Exception unused6) {
                                            String str8 = a.a;
                                        }
                                    }
                                    if (byteArrayOutputStream != null) {
                                        try {
                                            byteArrayOutputStream.close();
                                        } catch (Exception unused7) {
                                            String str9 = a.a;
                                        }
                                    }
                                    throw th;
                                }
                            } catch (Error e8) {
                                e = e8;
                                httpsURLConnection = httpsURLConnection2;
                                url = url2;
                                inputStream2 = inputStream;
                                byteArrayOutputStream2 = null;
                            } catch (Exception e9) {
                                e = e9;
                                httpsURLConnection = httpsURLConnection2;
                                url = url2;
                                inputStream2 = inputStream;
                                byteArrayOutputStream2 = null;
                            } catch (Throwable th5) {
                                th = th5;
                                byteArrayOutputStream = null;
                                httpsURLConnection3 = httpsURLConnection2;
                                if (httpsURLConnection3 != null) {
                                }
                                if (outputStream != null) {
                                }
                                if (inputStream != null) {
                                }
                                if (byteArrayOutputStream != null) {
                                }
                                throw th;
                            }
                        } else {
                            this.f36199b.f36195j = null;
                            this.f36199b.a(false);
                            byteArrayOutputStream3 = null;
                        }
                        if (httpsURLConnection2 != null) {
                            httpsURLConnection2.disconnect();
                        }
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (Exception unused8) {
                                String str10 = a.a;
                            }
                        }
                        if (inputStream3 != null) {
                            try {
                                inputStream3.close();
                            } catch (Exception unused9) {
                                String str11 = a.a;
                            }
                        }
                    } catch (Error e10) {
                        e = e10;
                        byteArrayOutputStream2 = null;
                        httpsURLConnection = httpsURLConnection2;
                        url = url2;
                        inputStream2 = null;
                    } catch (Exception e11) {
                        e = e11;
                        byteArrayOutputStream2 = null;
                        httpsURLConnection = httpsURLConnection2;
                        url = url2;
                        inputStream2 = null;
                    } catch (Throwable th6) {
                        th = th6;
                        byteArrayOutputStream = null;
                        inputStream = null;
                    }
                } catch (Error e12) {
                    e = e12;
                    byteArrayOutputStream2 = null;
                    outputStream = null;
                    httpsURLConnection = httpsURLConnection2;
                    url = url2;
                    inputStream2 = outputStream;
                    e.printStackTrace();
                    String str12 = a.a;
                    this.f36199b.f36195j = null;
                    this.f36199b.a(false);
                    if (httpsURLConnection != null) {
                    }
                    if (outputStream != null) {
                    }
                    if (inputStream2 != null) {
                    }
                    if (byteArrayOutputStream2 == null) {
                    }
                    byteArrayOutputStream2.close();
                } catch (Exception e13) {
                    e = e13;
                    byteArrayOutputStream2 = null;
                    outputStream = null;
                    httpsURLConnection = httpsURLConnection2;
                    url = url2;
                    inputStream2 = outputStream;
                    e.printStackTrace();
                    String str42 = a.a;
                    this.f36199b.f36195j = null;
                    this.f36199b.a(false);
                    if (httpsURLConnection != null) {
                    }
                    if (outputStream != null) {
                    }
                    if (inputStream2 != null) {
                    }
                    if (byteArrayOutputStream2 == null) {
                    }
                    byteArrayOutputStream2.close();
                } catch (Throwable th7) {
                    th = th7;
                    byteArrayOutputStream = null;
                    inputStream = null;
                    outputStream = null;
                }
                if (byteArrayOutputStream3 != null) {
                    byteArrayOutputStream3.close();
                }
            } catch (Exception unused10) {
                String str13 = a.a;
            }
        }
    }
}
