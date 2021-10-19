package c.b.b.a.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.utils.UtilsBlink;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import kotlin.jvm.internal.ByteCompanionObject;
import ms.bd.c.h;
import ms.bd.c.j;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
/* loaded from: classes4.dex */
public final class c extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SSLSocketFactory f31496a;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // c.b.b.a.a.b
    public Object[] e(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) ? h(str, null, null, str2, false) : (Object[]) invokeLL.objValue;
    }

    @Override // c.b.b.a.a.b
    public Object[] f(String str, byte[] bArr, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bArr, str2)) == null) ? h(str, bArr, str2, null, true) : (Object[]) invokeLLL.objValue;
    }

    @Override // c.b.b.a.a.b
    public Object[] g(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) ? h(str, null, str2, null, false) : (Object[]) invokeLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:126:0x04b0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x04df A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x045f  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x04a4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object[] h(String str, byte[] bArr, String str2, String str3, boolean z) {
        InterceptResult invokeCommon;
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        DataOutputStream dataOutputStream;
        int i2;
        DataOutputStream dataOutputStream2;
        BufferedInputStream bufferedInputStream;
        byte[] bArr2;
        byte[] bArr3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{str, bArr, str2, str3, Boolean.valueOf(z)})) == null) {
            j.a aVar = new j.a();
            int i3 = -1;
            try {
                try {
                    httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                } catch (Throwable th) {
                    th = th;
                    inputStream = null;
                    dataOutputStream = 48;
                }
            } catch (Exception unused) {
                httpURLConnection = null;
            } catch (Throwable th2) {
                th = th2;
                httpURLConnection = null;
            }
            try {
                if (httpURLConnection instanceof HttpsURLConnection) {
                    if (this.f31496a == null) {
                        synchronized (c.class) {
                            if (this.f31496a == null) {
                                SSLContext sSLContext = SSLContext.getInstance((String) h.a(16777217, 0, 0L, "5187f3", new byte[]{16, 31, 120}));
                                sSLContext.init(null, null, null);
                                this.f31496a = sSLContext.getSocketFactory();
                            }
                        }
                    }
                    ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(this.f31496a);
                }
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.setRequestProperty((String) h.a(16777217, 0, 0L, "042ea3", new byte[]{0, 53, 66, 20, 78, 48}), (String) h.a(16777217, 0, 0L, "cdc3db", new byte[]{56, 41, 90}));
                httpURLConnection.setRequestProperty((String) h.a(16777217, 0, 0L, "f4d8a3", new byte[]{84, 57, 25, 66, 91, 39, 113, 28, 58, 102}), (String) h.a(16777217, 0, 0L, "b30ff7", new byte[]{88, 52, 70, 2, 20, 1, 109, 27, 119, 51}));
                httpURLConnection.setRequestProperty((String) h.a(16777217, 0, 0L, "3fbf77", new byte[]{23, 119, 20, 0, 69, 1, 55, 66, 61, 34}), (String) h.a(16777217, 0, 0L, "9d660b", new byte[]{10, ByteCompanionObject.MAX_VALUE, 81, 71, 43, 116, 52, 70, 98, 43, 5, 85, 118, 102, 36}));
                httpURLConnection.setRequestProperty((String) h.a(16777217, 0, 0L, "a6c4ae", new byte[]{83, 59, 30, 84, 91, 124, 118, 90, 6, 125, 96, 49}), (String) h.a(16777217, 0, 0L, "cacf8e", new byte[]{115, 115, 0, 30, 14, 113, 97, 84, 59, 57, 124, 44, 31, 17, 19, 119, 116, 13, PublicSuffixDatabase.EXCEPTION_MARKER, 34, 96, 102, 17, 31}));
                if (str2 != null && str2.trim().length() > 0) {
                    httpURLConnection.setRequestProperty((String) h.a(16777217, 0, 0L, "6c53b7", new byte[]{4, 110, 73, 76, 84, 37}), String.format((String) h.a(16777217, 0, 0L, "23df11", new byte[]{48, 52, 4, 1, 7, 41, 63, 27, 49, 107, 102, 34}), str2));
                }
                aVar.a(str);
                if (z) {
                    httpURLConnection.setRequestMethod((String) h.a(16777217, 0, 0L, "79978a", new byte[]{22, 20, 121, 119}));
                    httpURLConnection.setDoOutput(true);
                    dataOutputStream2 = new DataOutputStream(httpURLConnection.getOutputStream());
                    try {
                        try {
                            dataOutputStream2.write(bArr);
                            dataOutputStream2.flush();
                        } catch (Throwable th3) {
                            th = th3;
                            dataOutputStream = dataOutputStream2;
                            inputStream = null;
                            c(inputStream);
                            d(dataOutputStream);
                            if (httpURLConnection != null) {
                                try {
                                    httpURLConnection.disconnect();
                                } catch (Exception unused2) {
                                    String str4 = (String) h.a(16777217, 0, 0L, "df3b37", new byte[]{102, 108, 67, 41, 4, 49, 53});
                                }
                            }
                            throw th;
                        }
                    } catch (Exception unused3) {
                        i2 = i3;
                        bufferedInputStream = null;
                        String str5 = (String) h.a(16777217, 0, 0L, "2852b4", new byte[]{48, 50, 69, 121, 85, 50});
                        aVar.b(httpURLConnection == null ? httpURLConnection.getHeaderField((String) h.a(16777217, 0, 0L, "9f7bad", new byte[]{48, 41, 80, 2, 19, ByteCompanionObject.MAX_VALUE, 53, 64, 111, 54})) : null, i2);
                        c(bufferedInputStream);
                        d(dataOutputStream2);
                        if (httpURLConnection != null) {
                        }
                        bArr2 = null;
                        return new Object[]{String.valueOf(i2), bArr2};
                    }
                } else {
                    dataOutputStream2 = null;
                }
                i2 = httpURLConnection.getResponseCode();
                try {
                    aVar.c(httpURLConnection.getHeaderField((String) h.a(16777217, 0, 0L, "3b0f90", new byte[]{58, UtilsBlink.VER_TYPE_SEPARATOR, 87, 6, 75, 43, 63, 68, 104, 50})), i2);
                    if (i2 == 200) {
                        bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                        try {
                            OutputStream fileOutputStream = str3 != null ? new FileOutputStream(str3) : new ByteArrayOutputStream();
                            byte[] bArr4 = new byte[256];
                            while (true) {
                                int read = bufferedInputStream.read(bArr4);
                                if (read <= 0) {
                                    break;
                                }
                                fileOutputStream.write(bArr4, 0, read);
                            }
                            fileOutputStream.flush();
                            byte[] byteArray = fileOutputStream instanceof ByteArrayOutputStream ? ((ByteArrayOutputStream) fileOutputStream).toByteArray() : null;
                            fileOutputStream.close();
                            bArr3 = byteArray;
                        } catch (Exception unused4) {
                            String str52 = (String) h.a(16777217, 0, 0L, "2852b4", new byte[]{48, 50, 69, 121, 85, 50});
                            aVar.b(httpURLConnection == null ? httpURLConnection.getHeaderField((String) h.a(16777217, 0, 0L, "9f7bad", new byte[]{48, 41, 80, 2, 19, ByteCompanionObject.MAX_VALUE, 53, 64, 111, 54})) : null, i2);
                            c(bufferedInputStream);
                            d(dataOutputStream2);
                            if (httpURLConnection != null) {
                            }
                            bArr2 = null;
                            return new Object[]{String.valueOf(i2), bArr2};
                        }
                    } else {
                        bufferedInputStream = null;
                        bArr3 = null;
                    }
                    c(bufferedInputStream);
                    d(dataOutputStream2);
                    try {
                        httpURLConnection.disconnect();
                    } catch (Exception unused5) {
                        String str6 = (String) h.a(16777217, 0, 0L, "83bd8b", new byte[]{58, 57, 18, 47, 15, 100, 105});
                    }
                    bArr2 = bArr3;
                } catch (Exception unused6) {
                    i3 = i2;
                    i2 = i3;
                    bufferedInputStream = null;
                    String str522 = (String) h.a(16777217, 0, 0L, "2852b4", new byte[]{48, 50, 69, 121, 85, 50});
                    aVar.b(httpURLConnection == null ? httpURLConnection.getHeaderField((String) h.a(16777217, 0, 0L, "9f7bad", new byte[]{48, 41, 80, 2, 19, ByteCompanionObject.MAX_VALUE, 53, 64, 111, 54})) : null, i2);
                    c(bufferedInputStream);
                    d(dataOutputStream2);
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Exception unused7) {
                            String str7 = (String) h.a(16777217, 0, 0L, "fdbbb4", new byte[]{100, 110, 18, 41, 85, 50, 55});
                        }
                    }
                    bArr2 = null;
                    return new Object[]{String.valueOf(i2), bArr2};
                }
            } catch (Exception unused8) {
                i2 = -1;
                dataOutputStream2 = null;
                bufferedInputStream = null;
                String str5222 = (String) h.a(16777217, 0, 0L, "2852b4", new byte[]{48, 50, 69, 121, 85, 50});
                aVar.b(httpURLConnection == null ? httpURLConnection.getHeaderField((String) h.a(16777217, 0, 0L, "9f7bad", new byte[]{48, 41, 80, 2, 19, ByteCompanionObject.MAX_VALUE, 53, 64, 111, 54})) : null, i2);
                c(bufferedInputStream);
                d(dataOutputStream2);
                if (httpURLConnection != null) {
                }
                bArr2 = null;
                return new Object[]{String.valueOf(i2), bArr2};
            } catch (Throwable th4) {
                th = th4;
                inputStream = null;
                dataOutputStream = null;
                c(inputStream);
                d(dataOutputStream);
                if (httpURLConnection != null) {
                }
                throw th;
            }
            return new Object[]{String.valueOf(i2), bArr2};
        }
        return (Object[]) invokeCommon.objValue;
    }
}
