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
public class i implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ String a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ e f35191b;

    public i(e eVar, String str) {
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
        this.f35191b = eVar;
        this.a = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01a7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01af A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01db A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0206 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01d3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01f6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01fe A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:174:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:175:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01a2  */
    @Override // java.lang.Runnable
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
        ByteArrayOutputStream byteArrayOutputStream3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f35191b.a();
            this.f35191b.b();
            this.f35191b.f35185h = this.a;
            HttpsURLConnection httpsURLConnection2 = null;
            InputStream inputStream3 = null;
            httpsURLConnection2 = null;
            try {
                try {
                    try {
                        StringBuffer stringBuffer = new StringBuffer();
                        URL url2 = new URL(this.f35191b.f35185h);
                        try {
                            HttpsURLConnection httpsURLConnection3 = (HttpsURLConnection) url2.openConnection();
                            try {
                                httpsURLConnection3.setInstanceFollowRedirects(false);
                                httpsURLConnection3.setDoOutput(true);
                                httpsURLConnection3.setDoInput(true);
                                httpsURLConnection3.setConnectTimeout(a.f35150b);
                                httpsURLConnection3.setReadTimeout(a.f35151c);
                                httpsURLConnection3.setRequestMethod("POST");
                                httpsURLConnection3.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
                                httpsURLConnection3.setRequestProperty("Accept-Encoding", "gzip");
                                if (k.ax != null) {
                                    httpsURLConnection3.setRequestProperty("bd-loc-android", k.ax);
                                }
                                for (Map.Entry<String, Object> entry : this.f35191b.k.entrySet()) {
                                    stringBuffer.append(entry.getKey());
                                    stringBuffer.append("=");
                                    stringBuffer.append(entry.getValue());
                                    stringBuffer.append("&");
                                }
                                if (stringBuffer.length() > 0) {
                                    stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                                }
                                outputStream = httpsURLConnection3.getOutputStream();
                                try {
                                    outputStream.write(stringBuffer.toString().getBytes());
                                    outputStream.flush();
                                    if (httpsURLConnection3.getResponseCode() == 200) {
                                        inputStream = httpsURLConnection3.getInputStream();
                                        try {
                                            String contentEncoding = httpsURLConnection3.getContentEncoding();
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
                                                this.f35191b.f35187j = new String(byteArrayOutputStream3.toByteArray(), "utf-8");
                                                this.f35191b.a(true);
                                                inputStream3 = inputStream;
                                            } catch (Error e2) {
                                                InputStream inputStream4 = inputStream;
                                                byteArrayOutputStream2 = byteArrayOutputStream3;
                                                e = e2;
                                                httpsURLConnection = httpsURLConnection3;
                                                url = url2;
                                                inputStream2 = inputStream4;
                                                e.printStackTrace();
                                                String str = a.a;
                                                this.f35191b.f35187j = null;
                                                this.f35191b.a(false);
                                                if (httpsURLConnection != null) {
                                                }
                                                if (outputStream != null) {
                                                }
                                                if (inputStream2 != null) {
                                                }
                                                if (byteArrayOutputStream2 == null) {
                                                }
                                                byteArrayOutputStream2.close();
                                            } catch (Exception e3) {
                                                InputStream inputStream5 = inputStream;
                                                byteArrayOutputStream2 = byteArrayOutputStream3;
                                                e = e3;
                                                httpsURLConnection = httpsURLConnection3;
                                                url = url2;
                                                inputStream2 = inputStream5;
                                                e.printStackTrace();
                                                String str2 = a.a;
                                                this.f35191b.f35187j = null;
                                                this.f35191b.a(false);
                                                if (httpsURLConnection != null) {
                                                }
                                                if (outputStream != null) {
                                                }
                                                if (inputStream2 != null) {
                                                }
                                                if (byteArrayOutputStream2 == null) {
                                                }
                                                byteArrayOutputStream2.close();
                                            } catch (Throwable th) {
                                                httpsURLConnection2 = httpsURLConnection3;
                                                byteArrayOutputStream = byteArrayOutputStream3;
                                                th = th;
                                                if (httpsURLConnection2 != null) {
                                                    httpsURLConnection2.disconnect();
                                                }
                                                if (outputStream != null) {
                                                    try {
                                                        outputStream.close();
                                                    } catch (Exception unused) {
                                                        String str3 = a.a;
                                                    }
                                                }
                                                if (inputStream != null) {
                                                    try {
                                                        inputStream.close();
                                                    } catch (Exception unused2) {
                                                        String str4 = a.a;
                                                    }
                                                }
                                                if (byteArrayOutputStream != null) {
                                                    try {
                                                        byteArrayOutputStream.close();
                                                    } catch (Exception unused3) {
                                                        String str5 = a.a;
                                                    }
                                                }
                                                throw th;
                                            }
                                        } catch (Error e4) {
                                            e = e4;
                                            httpsURLConnection = httpsURLConnection3;
                                            url = url2;
                                            inputStream2 = inputStream;
                                            byteArrayOutputStream2 = null;
                                        } catch (Exception e5) {
                                            e = e5;
                                            httpsURLConnection = httpsURLConnection3;
                                            url = url2;
                                            inputStream2 = inputStream;
                                            byteArrayOutputStream2 = null;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            byteArrayOutputStream = null;
                                            httpsURLConnection2 = httpsURLConnection3;
                                            if (httpsURLConnection2 != null) {
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
                                        this.f35191b.f35187j = null;
                                        this.f35191b.a(false);
                                        byteArrayOutputStream3 = null;
                                    }
                                    if (httpsURLConnection3 != null) {
                                        httpsURLConnection3.disconnect();
                                    }
                                    if (outputStream != null) {
                                        try {
                                            outputStream.close();
                                        } catch (Exception unused4) {
                                            String str6 = a.a;
                                        }
                                    }
                                    if (inputStream3 != null) {
                                        try {
                                            inputStream3.close();
                                        } catch (Exception unused5) {
                                            String str7 = a.a;
                                        }
                                    }
                                } catch (Error e6) {
                                    e = e6;
                                    byteArrayOutputStream2 = null;
                                    httpsURLConnection = httpsURLConnection3;
                                    url = url2;
                                    inputStream2 = null;
                                } catch (Exception e7) {
                                    e = e7;
                                    byteArrayOutputStream2 = null;
                                    httpsURLConnection = httpsURLConnection3;
                                    url = url2;
                                    inputStream2 = null;
                                } catch (Throwable th3) {
                                    th = th3;
                                    byteArrayOutputStream = null;
                                    inputStream = null;
                                }
                            } catch (Error e8) {
                                e = e8;
                                byteArrayOutputStream2 = null;
                                outputStream = null;
                                httpsURLConnection = httpsURLConnection3;
                                url = url2;
                                inputStream2 = outputStream;
                                e.printStackTrace();
                                String str8 = a.a;
                                this.f35191b.f35187j = null;
                                this.f35191b.a(false);
                                if (httpsURLConnection != null) {
                                    httpsURLConnection.disconnect();
                                }
                                if (outputStream != null) {
                                    try {
                                        outputStream.close();
                                    } catch (Exception unused6) {
                                        String str9 = a.a;
                                    }
                                }
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (Exception unused7) {
                                        String str10 = a.a;
                                    }
                                }
                                if (byteArrayOutputStream2 == null) {
                                    return;
                                }
                                byteArrayOutputStream2.close();
                            } catch (Exception e9) {
                                e = e9;
                                byteArrayOutputStream2 = null;
                                outputStream = null;
                                httpsURLConnection = httpsURLConnection3;
                                url = url2;
                                inputStream2 = outputStream;
                                e.printStackTrace();
                                String str22 = a.a;
                                this.f35191b.f35187j = null;
                                this.f35191b.a(false);
                                if (httpsURLConnection != null) {
                                    httpsURLConnection.disconnect();
                                }
                                if (outputStream != null) {
                                    try {
                                        outputStream.close();
                                    } catch (Exception unused8) {
                                        String str11 = a.a;
                                    }
                                }
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (Exception unused9) {
                                        String str12 = a.a;
                                    }
                                }
                                if (byteArrayOutputStream2 == null) {
                                    return;
                                }
                                byteArrayOutputStream2.close();
                            } catch (Throwable th4) {
                                th = th4;
                                byteArrayOutputStream = null;
                                inputStream = null;
                                outputStream = null;
                            }
                        } catch (Error e10) {
                            e = e10;
                            byteArrayOutputStream2 = null;
                            httpsURLConnection = null;
                            outputStream = null;
                        } catch (Exception e11) {
                            e = e11;
                            byteArrayOutputStream2 = null;
                            httpsURLConnection = null;
                            outputStream = null;
                        } catch (Throwable th5) {
                            th = th5;
                            byteArrayOutputStream = null;
                            inputStream = null;
                            outputStream = null;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        inputStream = inputStream2;
                        httpsURLConnection2 = httpsURLConnection;
                    }
                } catch (Error e12) {
                    e = e12;
                    byteArrayOutputStream2 = null;
                    inputStream2 = null;
                    url = null;
                    httpsURLConnection = null;
                    outputStream = null;
                } catch (Exception e13) {
                    e = e13;
                    byteArrayOutputStream2 = null;
                    inputStream2 = null;
                    url = null;
                    httpsURLConnection = null;
                    outputStream = null;
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
