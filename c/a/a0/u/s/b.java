package c.a.a0.u.s;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.a0.h.k;
import c.a.a0.u.a;
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
public class b extends c.a.a0.u.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public OkHttpClient a;

    /* loaded from: classes.dex */
    public class a implements Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a.InterfaceC0066a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f1627b;

        /* renamed from: c.a.a0.u.s.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0069a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ IOException a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f1628b;

            public RunnableC0069a(a aVar, IOException iOException) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, iOException};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f1628b = aVar;
                this.a = iOException;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f1628b.a.a(this.a, 502);
                }
            }
        }

        /* renamed from: c.a.a0.u.s.b$a$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0070b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f1629b;

            public RunnableC0070b(a aVar, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f1629b = aVar;
                this.a = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f1629b.a.a(new Exception("body is null!"), this.a);
                }
            }
        }

        public a(b bVar, a.InterfaceC0066a interfaceC0066a, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, interfaceC0066a, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = interfaceC0066a;
            this.f1627b = z;
        }

        @Override // okhttp3.Callback
        public void onFailure(@NonNull Call call, @NonNull IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, call, iOException) == null) {
                k.b(new RunnableC0069a(this, iOException));
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
                        if (this.f1627b) {
                            this.a.c(aVar.c(), body.string(), code);
                        } else {
                            InputStream byteStream = body.byteStream();
                            this.a.b(aVar.c(), byteStream, code);
                            c.a.a0.h.d.a(byteStream);
                        }
                        return;
                    } catch (Exception e2) {
                        throw new IOException(e2);
                    }
                }
                k.b(new RunnableC0070b(this, code));
            }
        }
    }

    /* renamed from: c.a.a0.u.s.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0071b implements a.InterfaceC0066a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.a0.u.p.b a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f1630b;

        /* renamed from: c.a.a0.u.s.b$b$a */
        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Headers a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Object f1631b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ int f1632c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ C0071b f1633d;

            public a(C0071b c0071b, Headers headers, Object obj, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0071b, headers, obj, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f1633d = c0071b;
                this.a = headers;
                this.f1631b = obj;
                this.f1632c = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f1633d.a.b(this.a, this.f1631b, this.f1632c);
                }
            }
        }

        /* renamed from: c.a.a0.u.s.b$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0072b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Exception a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ int f1634b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ C0071b f1635c;

            public RunnableC0072b(C0071b c0071b, Exception exc, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0071b, exc, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f1635c = c0071b;
                this.a = exc;
                this.f1634b = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f1635c.a.a(this.a, this.f1634b);
                }
            }
        }

        public C0071b(b bVar, c.a.a0.u.p.b bVar2, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, bVar2, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar2;
            this.f1630b = dVar;
        }

        @Override // c.a.a0.u.a.InterfaceC0066a
        public void a(Exception exc, int i) {
            c.a.a0.u.p.b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) || (bVar = this.a) == null) {
                return;
            }
            if (this.f1630b.j) {
                k.b(new RunnableC0072b(this, exc, i));
            } else {
                bVar.a(exc, i);
            }
        }

        @Override // c.a.a0.u.a.InterfaceC0066a
        public void b(Headers headers, InputStream inputStream, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, headers, inputStream, i) == null) {
                throw new IllegalStateException("走错路了");
            }
        }

        @Override // c.a.a0.u.a.InterfaceC0066a
        public void c(Headers headers, String str, int i) throws Exception {
            c.a.a0.u.p.b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, headers, str, i) == null) || (bVar = this.a) == null) {
                return;
            }
            Object d2 = bVar.d(headers, str, i);
            if (this.f1630b.j) {
                k.b(new a(this, headers, d2, i));
            } else {
                this.a.b(headers, d2, i);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements a.InterfaceC0066a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.a0.u.p.a a;

        public c(b bVar, c.a.a0.u.p.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.a0.u.a.InterfaceC0066a
        public void a(Exception exc, int i) {
            c.a.a0.u.p.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) || (aVar = this.a) == null) {
                return;
            }
            aVar.a(exc, i);
        }

        @Override // c.a.a0.u.a.InterfaceC0066a
        public void b(Headers headers, InputStream inputStream, int i) throws Exception {
            c.a.a0.u.p.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, headers, inputStream, i) == null) || (aVar = this.a) == null) {
                return;
            }
            aVar.c(headers, inputStream, i);
        }

        @Override // c.a.a0.u.a.InterfaceC0066a
        public void c(Headers headers, String str, int i) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, headers, str, i) == null) {
                throw new IllegalStateException("走错路了");
            }
        }
    }

    public b() {
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
        this.a = null;
    }

    @Override // c.a.a0.u.k
    public <T> void a(@NonNull d dVar, @Nullable c.a.a0.u.p.b<T> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, dVar, bVar) == null) {
            c(dVar, true, new C0071b(this, bVar, dVar));
        }
    }

    @Override // c.a.a0.u.k
    public void b(@NonNull d dVar, @Nullable c.a.a0.u.p.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar, aVar) == null) {
            c(dVar, false, new c(this, aVar));
        }
    }

    public final void c(@NonNull d dVar, boolean z, @NonNull a.InterfaceC0066a interfaceC0066a) {
        OkHttpClient.Builder builder;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{dVar, Boolean.valueOf(z), interfaceC0066a}) == null) {
            RequestError b2 = dVar.b();
            if (b2 != null) {
                interfaceC0066a.a(b2, 1001);
                return;
            }
            try {
                Request.Builder a2 = e.a(dVar);
                OkHttpClient okHttpClient = this.a;
                if (okHttpClient != null) {
                    builder = okHttpClient.newBuilder();
                } else {
                    builder = new OkHttpClient.Builder();
                }
                int i = dVar.f1648g;
                if (i > 0) {
                    builder.readTimeout(i, TimeUnit.MILLISECONDS);
                }
                int i2 = dVar.f1649h;
                if (i2 > 0) {
                    builder.writeTimeout(i2, TimeUnit.MILLISECONDS);
                }
                int i3 = dVar.f1647f;
                if (i3 > 0) {
                    builder.connectTimeout(i3, TimeUnit.MILLISECONDS);
                }
                if (dVar.i != null) {
                    builder.cookieJar(new c.a.a0.u.q.a(dVar.i));
                }
                OkHttpClient build = builder.build();
                if (this.a == null) {
                    this.a = build;
                }
                build.newCall(a2.build()).enqueue(new a(this, interfaceC0066a, z));
            } catch (RequestError e2) {
                interfaceC0066a.a(e2, 1001);
            }
        }
    }
}
