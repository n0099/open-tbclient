package c.p.a.e.b.m;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.zip.GZIPInputStream;
import okhttp3.Call;
import okhttp3.Dns;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
/* loaded from: classes4.dex */
public class g implements c.p.a.e.b.o.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final com.ss.android.socialbase.downloader.i.h<String, OkHttpClient> f35214a;

    /* loaded from: classes4.dex */
    public class a extends c.p.a.e.b.o.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ InputStream f35215a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Response f35216b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Call f35217c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ ResponseBody f35218d;

        public a(g gVar, InputStream inputStream, Response response, Call call, ResponseBody responseBody) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, inputStream, response, call, responseBody};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35215a = inputStream;
            this.f35216b = response;
            this.f35217c = call;
            this.f35218d = responseBody;
        }

        @Override // c.p.a.e.b.o.k
        public InputStream a() throws IOException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f35215a : (InputStream) invokeV.objValue;
        }

        @Override // c.p.a.e.b.o.i
        public int b() throws IOException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f35216b.code() : invokeV.intValue;
        }

        @Override // c.p.a.e.b.o.i
        public void c() {
            Call call;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (call = this.f35217c) == null || call.isCanceled()) {
                return;
            }
            this.f35217c.cancel();
        }

        @Override // c.p.a.e.b.o.k
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                try {
                    if (this.f35218d != null) {
                        this.f35218d.close();
                    }
                    if (this.f35217c == null || this.f35217c.isCanceled()) {
                        return;
                    }
                    this.f35217c.cancel();
                } catch (Throwable unused) {
                }
            }
        }

        @Override // c.p.a.e.b.o.c
        public String e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "" : (String) invokeV.objValue;
        }

        @Override // c.p.a.e.b.o.i
        public String a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? this.f35216b.header(str) : (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Dns {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(g gVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public g() {
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
        this.f35214a = new com.ss.android.socialbase.downloader.i.h<>(4, 8);
    }

    public final OkHttpClient a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            try {
                String host = Uri.parse(str).getHost();
                if (!TextUtils.isEmpty(host) && !TextUtils.isEmpty(str2)) {
                    String str3 = host + "_" + str2;
                    synchronized (this.f35214a) {
                        OkHttpClient okHttpClient = this.f35214a.get(str3);
                        if (okHttpClient != null) {
                            return okHttpClient;
                        }
                        OkHttpClient.Builder I0 = c.p.a.e.b.g.e.I0();
                        I0.dns(new b(this, host, str2));
                        OkHttpClient build = I0.build();
                        synchronized (this.f35214a) {
                            this.f35214a.put(str3, build);
                        }
                        return build;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return c.p.a.e.b.g.e.H0();
        }
        return (OkHttpClient) invokeLL.objValue;
    }

    @Override // c.p.a.e.b.o.a
    public c.p.a.e.b.o.k downloadWithConnection(int i2, String str, List<com.ss.android.socialbase.downloader.model.c> list) throws IOException {
        InterceptResult invokeILL;
        String str2;
        OkHttpClient H0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str, list)) == null) {
            Request.Builder url = new Request.Builder().url(str);
            if (list == null || list.size() <= 0) {
                str2 = null;
            } else {
                str2 = null;
                for (com.ss.android.socialbase.downloader.model.c cVar : list) {
                    String a2 = cVar.a();
                    if (str2 == null && "ss_d_request_host_ip_114".equals(a2)) {
                        str2 = cVar.b();
                    } else {
                        url.addHeader(a2, c.p.a.e.b.l.f.R0(cVar.b()));
                    }
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                H0 = a(str, str2);
            } else {
                H0 = c.p.a.e.b.g.e.H0();
            }
            if (H0 != null) {
                Call newCall = H0.newCall(url.build());
                Response execute = newCall.execute();
                if (execute != null) {
                    ResponseBody body = execute.body();
                    if (body != null) {
                        InputStream byteStream = body.byteStream();
                        String header = execute.header("Content-Encoding");
                        return new a(this, (header == null || !AsyncHttpClient.ENCODING_GZIP.equalsIgnoreCase(header) || (byteStream instanceof GZIPInputStream)) ? byteStream : new GZIPInputStream(byteStream), execute, newCall, body);
                    }
                    return null;
                }
                throw new IOException("can't get response");
            }
            throw new IOException("can't get httpClient");
        }
        return (c.p.a.e.b.o.k) invokeILL.objValue;
    }
}
