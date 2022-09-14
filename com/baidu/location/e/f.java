package com.baidu.location.e;

import android.util.Log;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
/* loaded from: classes2.dex */
public class f implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ e a;

    public f(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = eVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x011d A[EDGE_INSN: B:114:0x011d->B:83:0x011d ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00fd A[LOOP:0: B:5:0x001c->B:67:0x00fd, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x010a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0114 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStream;
        boolean z;
        InputStream inputStream2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.h = k.e();
            this.a.b();
            this.a.a();
            int i = this.a.i;
            InputStream inputStream3 = null;
            HttpURLConnection httpURLConnection = null;
            while (i > 0) {
                try {
                    HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(this.a.h).openConnection();
                    try {
                        httpURLConnection2.setRequestMethod("GET");
                        httpURLConnection2.setDoInput(true);
                        httpURLConnection2.setDoOutput(true);
                        httpURLConnection2.setUseCaches(false);
                        httpURLConnection2.setConnectTimeout(a.b);
                        httpURLConnection2.setReadTimeout(a.b);
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
                                    this.a.j = new String(byteArrayOutputStream.toByteArray(), IMAudioTransRequest.CHARSET);
                                    this.a.a(true);
                                    httpURLConnection2.disconnect();
                                    z = true;
                                } catch (Exception unused) {
                                    inputStream = inputStream2;
                                    httpURLConnection = httpURLConnection2;
                                    try {
                                        Log.d(a.a, "NetworkCommunicationException!");
                                        if (httpURLConnection != null) {
                                            httpURLConnection.disconnect();
                                        }
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            }
                                        }
                                        if (byteArrayOutputStream != null) {
                                            try {
                                                byteArrayOutputStream.close();
                                            } catch (Exception e2) {
                                                e2.printStackTrace();
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
                                            } catch (Exception e3) {
                                                e3.printStackTrace();
                                            }
                                        }
                                        if (byteArrayOutputStream != null) {
                                            try {
                                                byteArrayOutputStream.close();
                                            } catch (Exception e4) {
                                                e4.printStackTrace();
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
                            } catch (Exception e5) {
                                e5.printStackTrace();
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception e6) {
                                e6.printStackTrace();
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
                i--;
            }
            if (i > 0) {
                e.p = 0;
                return;
            }
            e.p++;
            e eVar = this.a;
            eVar.j = null;
            eVar.a(false);
        }
    }
}
