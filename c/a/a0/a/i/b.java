package c.a.a0.a.i;

import android.text.TextUtils;
import android.util.Base64;
import c.a.a0.a.e;
import c.a.a0.a.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.http.protocol.HTTP;
/* loaded from: classes.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static b f1094c;
    public transient /* synthetic */ FieldHolder $fh;
    public c a;

    /* renamed from: b  reason: collision with root package name */
    public c f1095b;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f1096e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f1097f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f1098g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b f1099h;

        public a(b bVar, int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1099h = bVar;
            this.f1096e = i2;
            this.f1097f = str;
            this.f1098g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f1096e == 24) {
                    this.f1099h.b(this.f1097f, this.f1098g, 24);
                }
                this.f1099h.b(this.f1097f, this.f1098g, 1);
            }
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new c();
        this.f1095b = new c("live_show_session");
    }

    public static byte[] e(byte[] bArr, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, null, bArr, z)) == null) {
            if (z) {
                try {
                    return g.b(bArr);
                } catch (IOException e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            return Base64.encode(bArr, 2);
        }
        return (byte[]) invokeLZ.objValue;
    }

    public static synchronized b g() {
        InterceptResult invokeV;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            synchronized (b.class) {
                if (f1094c == null) {
                    f1094c = new b();
                }
                bVar = f1094c;
            }
            return bVar;
        }
        return (b) invokeV.objValue;
    }

    public final void b(String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, str, str2, i2) == null) {
            String str3 = WebSettingsGlobalBlink.SESSION_UPLOAD_URL + str2;
            boolean z = true;
            byte[] e2 = e(str.getBytes(), true);
            if (e2 == null) {
                e2 = e(str.getBytes(), false);
                z = false;
            }
            if (d(g.a(e2), str3, z)) {
                f();
            } else {
                c(Base64.encode(g.a(e(str.getBytes(), false)), 2), i2);
            }
        }
    }

    public final void c(byte[] bArr, int i2) {
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr, i2) == null) {
            if (i2 == 24) {
                cVar = this.f1095b;
                if (cVar == null) {
                    return;
                }
            } else {
                cVar = this.a;
                if (cVar == null) {
                    return;
                }
            }
            cVar.e(bArr);
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:54:0x00b2 */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0084, code lost:
        if (r9 == null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0086, code lost:
        r9.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00a8, code lost:
        if (r9 == null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00ab, code lost:
        r8 = -1;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00b0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00b1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00b5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00bf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.lang.CharSequence, java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v4, types: [java.net.HttpURLConnection] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean d(byte[] bArr, String str, boolean z) {
        InterceptResult invokeLLZ;
        HttpURLConnection httpURLConnection;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, bArr, str, z)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            OutputStream outputStream = null;
            try {
                try {
                    httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                    try {
                        httpURLConnection.setUseCaches(false);
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
                        httpURLConnection.setRequestProperty("Cache-Control", "no-cache");
                        if (z) {
                            httpURLConnection.setRequestProperty("Content-Type", "application/x-gzip");
                        }
                        outputStream = httpURLConnection.getOutputStream();
                        outputStream.write(bArr);
                        outputStream.flush();
                        i2 = httpURLConnection.getResponseCode();
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                            } catch (Exception unused) {
                            }
                        }
                    } catch (Error e3) {
                        e = e3;
                        e.e("DpSessionDatasUploader", "[sendStatisticsDataToServer()] upload error " + e);
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (Exception e4) {
                                e4.printStackTrace();
                            }
                        }
                    } catch (Exception e5) {
                        e = e5;
                        e.e("DpSessionDatasUploader", "[sendStatisticsDataToServer()] upload error " + e);
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (Exception e6) {
                                e6.printStackTrace();
                            }
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    if (0 != 0) {
                        try {
                            outputStream.close();
                        } catch (Exception e7) {
                            e7.printStackTrace();
                        }
                    }
                    if (str != 0) {
                        try {
                            str.disconnect();
                        } catch (Exception unused2) {
                        }
                    }
                    throw th;
                }
            } catch (Error e8) {
                e = e8;
                httpURLConnection = null;
            } catch (Exception e9) {
                e = e9;
                httpURLConnection = null;
            } catch (Throwable th2) {
                th = th2;
                str = 0;
                if (0 != 0) {
                }
                if (str != 0) {
                }
                throw th;
            }
            return i2 != 200;
        }
        return invokeLLZ.booleanValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c cVar = this.a;
            if (cVar != null) {
                cVar.a();
            }
            c cVar2 = this.f1095b;
            if (cVar2 != null) {
                cVar2.a();
            }
        }
    }

    public void h(String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048580, this, str, str2, i2) == null) {
            c.a.a0.a.a.b().a(new a(this, i2, str, str2));
        }
    }
}
