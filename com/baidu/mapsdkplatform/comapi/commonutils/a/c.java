package com.baidu.mapsdkplatform.comapi.commonutils.a;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ExecutorService a;
    public int b;
    public List<com.baidu.mapsdkplatform.comapi.commonutils.a.b> c;
    public InterfaceC0124c d;

    /* loaded from: classes2.dex */
    public interface b {
        void a(com.baidu.mapsdkplatform.comapi.commonutils.a.b bVar);

        void b(com.baidu.mapsdkplatform.comapi.commonutils.a.b bVar);
    }

    /* renamed from: com.baidu.mapsdkplatform.comapi.commonutils.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0124c {
        void a();

        void a(File file);
    }

    /* loaded from: classes2.dex */
    public class a implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;
        public File b;

        public a(c cVar, File file) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, file};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
            this.b = file;
        }

        public /* synthetic */ a(c cVar, File file, com.baidu.mapsdkplatform.comapi.commonutils.a.d dVar) {
            this(cVar, file);
        }

        @Override // com.baidu.mapsdkplatform.comapi.commonutils.a.c.b
        public void a(com.baidu.mapsdkplatform.comapi.commonutils.a.b bVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) && this.a.c != null && this.a.c.size() != 0 && bVar != null && bVar.a() && this.a.c != null) {
                this.a.c.remove(bVar);
                if (this.a.c.size() == 0) {
                    this.a.d.a(this.b);
                }
            }
        }

        @Override // com.baidu.mapsdkplatform.comapi.commonutils.a.c.b
        public void b(com.baidu.mapsdkplatform.comapi.commonutils.a.b bVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) && this.a.c != null && this.a.c.size() != 0 && bVar != null) {
                this.a.c.clear();
                if (this.a.d != null) {
                    this.a.d.a();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class d implements HostnameVerifier {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d() {
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

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = 1;
        this.c = new LinkedList();
        this.a = Executors.newCachedThreadPool();
    }

    private HttpURLConnection a(String str) {
        HttpsURLConnection httpsURLConnection;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, str)) == null) {
            try {
                URL url = new URL(str);
                if (HttpClient.isHttpsEnable) {
                    HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) url.openConnection();
                    httpsURLConnection2.setHostnameVerifier(new d());
                    httpsURLConnection = httpsURLConnection2;
                } else {
                    httpsURLConnection = (HttpURLConnection) url.openConnection();
                }
                httpsURLConnection.setConnectTimeout(5000);
                httpsURLConnection.setRequestMethod("GET");
                httpsURLConnection.connect();
                return httpsURLConnection;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return (HttpURLConnection) invokeL.objValue;
    }

    private void a(String str, File file, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLII(65539, this, str, file, i, i2) == null) && !TextUtils.isEmpty(str) && file != null && i > 0 && i2 > 0) {
            int i3 = 0;
            while (i3 < this.b) {
                int i4 = i3 + 1;
                com.baidu.mapsdkplatform.comapi.commonutils.a.a aVar = new com.baidu.mapsdkplatform.comapi.commonutils.a.a(i3, i3 * i, (i4 * i) - 1);
                if (i3 == this.b - 1) {
                    aVar.a(i2);
                }
                com.baidu.mapsdkplatform.comapi.commonutils.a.b bVar = new com.baidu.mapsdkplatform.comapi.commonutils.a.b(str, file, aVar, new a(this, file, null));
                List<com.baidu.mapsdkplatform.comapi.commonutils.a.b> list = this.c;
                if (list != null) {
                    list.add(bVar);
                }
                ExecutorService executorService = this.a;
                if (executorService != null && !executorService.isShutdown()) {
                    this.a.submit(bVar);
                }
                i3 = i4;
            }
        }
    }

    private void a(String str, String str2, String str3) {
        String headerField;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, this, str, str2, str3) == null) {
            File file = new File(str2);
            if (!file.exists() && !file.mkdirs()) {
                return;
            }
            HttpURLConnection a2 = a(str);
            if (a2 != null) {
                try {
                    if (a2.getResponseCode() == 200) {
                        int contentLength = a2.getContentLength();
                        if (contentLength > 0) {
                            if (str3 == null && ((headerField = a2.getHeaderField("Content-Disposition")) == null || headerField.length() == 0 || (str3 = URLDecoder.decode(headerField.substring(headerField.indexOf("filename=") + 9), "UTF-8")) == null || str3.length() == 0)) {
                                return;
                            }
                            File file2 = new File(file, str3);
                            RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
                            randomAccessFile.setLength(contentLength);
                            randomAccessFile.close();
                            a2.disconnect();
                            int i = this.b;
                            int i2 = contentLength % i;
                            int i3 = contentLength / i;
                            if (i2 != 0) {
                                i3++;
                            }
                            a(str, file2, i3, contentLength);
                            return;
                        }
                        throw new RuntimeException("unKnow file length");
                    }
                } catch (Exception unused) {
                    return;
                }
            }
            throw new RuntimeException("server no response.");
        }
    }

    public void a(String str, String str2, String str3, int i, InterfaceC0124c interfaceC0124c) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, str3, Integer.valueOf(i), interfaceC0124c}) == null) && i > 0 && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            this.b = i;
            this.d = interfaceC0124c;
            a(str, str2, str3);
        }
    }
}
