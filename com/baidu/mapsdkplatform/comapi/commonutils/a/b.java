package com.baidu.mapsdkplatform.comapi.commonutils.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapsdkplatform.comapi.commonutils.a.c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import org.apache.http.protocol.HTTP;
/* loaded from: classes2.dex */
public class b implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public File b;
    public com.baidu.mapsdkplatform.comapi.commonutils.a.a c;
    public c.b d;
    public volatile boolean e;

    /* loaded from: classes2.dex */
    public static class a implements HostnameVerifier {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, sSLSession)) == null) {
                return HttpsURLConnection.getDefaultHostnameVerifier().verify(str, sSLSession);
            }
            return invokeLL.booleanValue;
        }
    }

    public b(String str, File file, com.baidu.mapsdkplatform.comapi.commonutils.a.a aVar, c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, file, aVar, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = false;
        this.a = str;
        this.b = file;
        this.c = aVar;
        this.d = bVar;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.e;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:50:0x00a6 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:53:0x006d */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:58:0x0096 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00cf A[Catch: IOException -> 0x00cb, TRY_LEAVE, TryCatch #5 {IOException -> 0x00cb, blocks: (B:39:0x00c7, B:43:0x00cf), top: B:55:0x00c7 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00c7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.io.RandomAccessFile, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        RandomAccessFile randomAccessFile;
        HttpsURLConnection httpsURLConnection;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            InputStream inputStream = 0;
            inputStream = 0;
            inputStream = 0;
            try {
                try {
                    try {
                        URL url = new URL(this.a);
                        if (HttpClient.isHttpsEnable) {
                            HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) url.openConnection();
                            httpsURLConnection2.setHostnameVerifier(new a());
                            httpsURLConnection = httpsURLConnection2;
                        } else {
                            httpsURLConnection = (HttpURLConnection) url.openConnection();
                        }
                        httpsURLConnection.setRequestMethod("GET");
                        httpsURLConnection.setConnectTimeout(10000);
                        httpsURLConnection.setReadTimeout(10000);
                        httpsURLConnection.setRequestProperty("Range", "bytes=" + this.c.a() + "-" + this.c.b());
                        httpsURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
                        randomAccessFile = new RandomAccessFile(this.b, "rw");
                        try {
                            randomAccessFile.seek(this.c.a());
                            int responseCode = httpsURLConnection.getResponseCode();
                            if (responseCode == 200 || responseCode == 206) {
                                byte[] bArr = new byte[1048576];
                                inputStream = httpsURLConnection.getInputStream();
                                while (true) {
                                    int read = inputStream.read(bArr);
                                    if (read == -1) {
                                        break;
                                    }
                                    randomAccessFile.write(bArr, 0, read);
                                }
                            }
                            this.e = true;
                            if (inputStream != 0) {
                                inputStream.close();
                            }
                            randomAccessFile.close();
                        } catch (Exception unused) {
                            this.e = false;
                            this.d.b(this);
                            if (inputStream != 0) {
                                inputStream.close();
                            }
                            if (randomAccessFile != null) {
                                randomAccessFile.close();
                            }
                            this.d.a(this);
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (0 != 0) {
                            try {
                                inputStream.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                                throw th;
                            }
                        }
                        if (0 != 0) {
                            inputStream.close();
                        }
                        throw th;
                    }
                } catch (Exception unused2) {
                    randomAccessFile = null;
                } catch (Throwable th2) {
                    th = th2;
                    if (0 != 0) {
                    }
                    if (0 != 0) {
                    }
                    throw th;
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            this.d.a(this);
        }
    }
}
