package c.a.c0.r.s;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.c0.e.g;
import c.a.c0.r.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.net.exception.RequestError;
import com.baidu.nadcore.net.request.Headers;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
/* loaded from: classes.dex */
public class b extends c.a.c0.r.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a.InterfaceC0058a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f1859b;

        /* renamed from: c.a.c0.r.s.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0061a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ IOException f1860e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f1861f;

            public RunnableC0061a(a aVar, IOException iOException) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, iOException};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f1861f = aVar;
                this.f1860e = iOException;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f1861f.a.a(this.f1860e, 502);
                }
            }
        }

        /* renamed from: c.a.c0.r.s.b$a$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0062b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f1862e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f1863f;

            public RunnableC0062b(a aVar, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f1863f = aVar;
                this.f1862e = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f1863f.a.a(new Exception("body is null!"), this.f1862e);
                }
            }
        }

        public a(b bVar, a.InterfaceC0058a interfaceC0058a, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, interfaceC0058a, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = interfaceC0058a;
            this.f1859b = z;
        }

        @Override // okhttp3.Callback
        public void onFailure(@NonNull Call call, @NonNull IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, call, iOException) == null) {
                g.b(new RunnableC0061a(this, iOException));
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, response) == null) {
                Headers.a aVar = new Headers.a();
                int code = response.code();
                ResponseBody body = response.body();
                if (body != null) {
                    for (Map.Entry<String, List<String>> entry : response.headers().toMultimap().entrySet()) {
                        List<String> value = entry.getValue();
                        if (value != null && value.size() > 0) {
                            aVar.a(entry.getKey(), value.get(0));
                        }
                    }
                    try {
                        if (this.f1859b) {
                            this.a.c(aVar.c(), body.string(), code);
                        } else {
                            InputStream byteStream = body.byteStream();
                            this.a.b(aVar.c(), byteStream, code);
                            c.a.c0.e.d.a(byteStream);
                        }
                        return;
                    } catch (Exception e2) {
                        throw new IOException(e2);
                    }
                }
                g.b(new RunnableC0062b(this, code));
            }
        }
    }

    /* renamed from: c.a.c0.r.s.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0063b implements a.InterfaceC0058a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.c0.r.p.b a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f1864b;

        /* renamed from: c.a.c0.r.s.b$b$a */
        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Headers f1865e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Object f1866f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ int f1867g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ C0063b f1868h;

            public a(C0063b c0063b, Headers headers, Object obj, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0063b, headers, obj, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f1868h = c0063b;
                this.f1865e = headers;
                this.f1866f = obj;
                this.f1867g = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f1868h.a.b(this.f1865e, this.f1866f, this.f1867g);
                }
            }
        }

        /* renamed from: c.a.c0.r.s.b$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0064b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Exception f1869e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f1870f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ C0063b f1871g;

            public RunnableC0064b(C0063b c0063b, Exception exc, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0063b, exc, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f1871g = c0063b;
                this.f1869e = exc;
                this.f1870f = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f1871g.a.a(this.f1869e, this.f1870f);
                }
            }
        }

        public C0063b(b bVar, c.a.c0.r.p.b bVar2, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, bVar2, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar2;
            this.f1864b = dVar;
        }

        @Override // c.a.c0.r.a.InterfaceC0058a
        public void a(Exception exc, int i2) {
            c.a.c0.r.p.b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, exc, i2) == null) || (bVar = this.a) == null) {
                return;
            }
            if (this.f1864b.f1887j) {
                g.b(new RunnableC0064b(this, exc, i2));
            } else {
                bVar.a(exc, i2);
            }
        }

        @Override // c.a.c0.r.a.InterfaceC0058a
        public void b(Headers headers, InputStream inputStream, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, headers, inputStream, i2) == null) {
                throw new IllegalStateException("走错路了");
            }
        }

        @Override // c.a.c0.r.a.InterfaceC0058a
        public void c(Headers headers, String str, int i2) throws Exception {
            c.a.c0.r.p.b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, headers, str, i2) == null) || (bVar = this.a) == null) {
                return;
            }
            Object d2 = bVar.d(headers, str, i2);
            if (this.f1864b.f1887j) {
                g.b(new a(this, headers, d2, i2));
            } else {
                this.a.b(headers, d2, i2);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements a.InterfaceC0058a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.c0.r.p.a a;

        public c(b bVar, c.a.c0.r.p.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.c0.r.a.InterfaceC0058a
        public void a(Exception exc, int i2) {
            c.a.c0.r.p.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, exc, i2) == null) || (aVar = this.a) == null) {
                return;
            }
            aVar.a(exc, i2);
        }

        @Override // c.a.c0.r.a.InterfaceC0058a
        public void b(Headers headers, InputStream inputStream, int i2) throws Exception {
            c.a.c0.r.p.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, headers, inputStream, i2) == null) || (aVar = this.a) == null) {
                return;
            }
            aVar.c(headers, inputStream, i2);
        }

        @Override // c.a.c0.r.a.InterfaceC0058a
        public void c(Headers headers, String str, int i2) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, headers, str, i2) == null) {
                throw new IllegalStateException("走错路了");
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
            }
        }
    }

    @Override // c.a.c0.r.k
    public <T> void a(@NonNull d dVar, @Nullable c.a.c0.r.p.b<T> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, dVar, bVar) == null) {
            c(dVar, true, new C0063b(this, bVar, dVar));
        }
    }

    @Override // c.a.c0.r.k
    public void b(@NonNull d dVar, @Nullable c.a.c0.r.p.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar, aVar) == null) {
            c(dVar, false, new c(this, aVar));
        }
    }

    public final void c(@NonNull d dVar, boolean z, @NonNull a.InterfaceC0058a interfaceC0058a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{dVar, Boolean.valueOf(z), interfaceC0058a}) == null) {
            RequestError b2 = dVar.b();
            if (b2 != null) {
                interfaceC0058a.a(b2, 1001);
                return;
            }
            Request.Builder a2 = e.a(dVar);
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            int i2 = dVar.f1884g;
            if (i2 > 0) {
                builder.readTimeout(i2, TimeUnit.MILLISECONDS);
            }
            int i3 = dVar.f1885h;
            if (i3 > 0) {
                builder.writeTimeout(i3, TimeUnit.MILLISECONDS);
            }
            int i4 = dVar.f1883f;
            if (i4 > 0) {
                builder.connectTimeout(i4, TimeUnit.MILLISECONDS);
            }
            if (dVar.f1886i != null) {
                builder.cookieJar(new c.a.c0.r.q.a(dVar.f1886i));
            }
            builder.build().newCall(a2.build()).enqueue(new a(this, interfaceC0058a, z));
        }
    }
}
