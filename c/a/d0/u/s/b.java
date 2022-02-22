package c.a.d0.u.s;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.d0.h.k;
import c.a.d0.u.a;
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
public class b extends c.a.d0.u.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public OkHttpClient a;

    /* loaded from: classes.dex */
    public class a implements Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a.InterfaceC0116a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f3182b;

        /* renamed from: c.a.d0.u.s.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0119a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ IOException f3183e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f3184f;

            public RunnableC0119a(a aVar, IOException iOException) {
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
                this.f3184f = aVar;
                this.f3183e = iOException;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f3184f.a.a(this.f3183e, 502);
                }
            }
        }

        /* renamed from: c.a.d0.u.s.b$a$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0120b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f3185e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f3186f;

            public RunnableC0120b(a aVar, int i2) {
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
                this.f3186f = aVar;
                this.f3185e = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f3186f.a.a(new Exception("body is null!"), this.f3185e);
                }
            }
        }

        public a(b bVar, a.InterfaceC0116a interfaceC0116a, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, interfaceC0116a, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = interfaceC0116a;
            this.f3182b = z;
        }

        @Override // okhttp3.Callback
        public void onFailure(@NonNull Call call, @NonNull IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, call, iOException) == null) {
                k.b(new RunnableC0119a(this, iOException));
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
                        if (this.f3182b) {
                            this.a.c(aVar.c(), body.string(), code);
                        } else {
                            InputStream byteStream = body.byteStream();
                            this.a.b(aVar.c(), byteStream, code);
                            c.a.d0.h.d.a(byteStream);
                        }
                        return;
                    } catch (Exception e2) {
                        throw new IOException(e2);
                    }
                }
                k.b(new RunnableC0120b(this, code));
            }
        }
    }

    /* renamed from: c.a.d0.u.s.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0121b implements a.InterfaceC0116a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.d0.u.p.b a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f3187b;

        /* renamed from: c.a.d0.u.s.b$b$a */
        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Headers f3188e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Object f3189f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ int f3190g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ C0121b f3191h;

            public a(C0121b c0121b, Headers headers, Object obj, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0121b, headers, obj, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f3191h = c0121b;
                this.f3188e = headers;
                this.f3189f = obj;
                this.f3190g = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f3191h.a.b(this.f3188e, this.f3189f, this.f3190g);
                }
            }
        }

        /* renamed from: c.a.d0.u.s.b$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0122b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Exception f3192e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f3193f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ C0121b f3194g;

            public RunnableC0122b(C0121b c0121b, Exception exc, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0121b, exc, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f3194g = c0121b;
                this.f3192e = exc;
                this.f3193f = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f3194g.a.a(this.f3192e, this.f3193f);
                }
            }
        }

        public C0121b(b bVar, c.a.d0.u.p.b bVar2, d dVar) {
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
            this.f3187b = dVar;
        }

        @Override // c.a.d0.u.a.InterfaceC0116a
        public void a(Exception exc, int i2) {
            c.a.d0.u.p.b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, exc, i2) == null) || (bVar = this.a) == null) {
                return;
            }
            if (this.f3187b.f3210j) {
                k.b(new RunnableC0122b(this, exc, i2));
            } else {
                bVar.a(exc, i2);
            }
        }

        @Override // c.a.d0.u.a.InterfaceC0116a
        public void b(Headers headers, InputStream inputStream, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, headers, inputStream, i2) == null) {
                throw new IllegalStateException("走错路了");
            }
        }

        @Override // c.a.d0.u.a.InterfaceC0116a
        public void c(Headers headers, String str, int i2) throws Exception {
            c.a.d0.u.p.b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, headers, str, i2) == null) || (bVar = this.a) == null) {
                return;
            }
            Object d2 = bVar.d(headers, str, i2);
            if (this.f3187b.f3210j) {
                k.b(new a(this, headers, d2, i2));
            } else {
                this.a.b(headers, d2, i2);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements a.InterfaceC0116a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.d0.u.p.a a;

        public c(b bVar, c.a.d0.u.p.a aVar) {
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

        @Override // c.a.d0.u.a.InterfaceC0116a
        public void a(Exception exc, int i2) {
            c.a.d0.u.p.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, exc, i2) == null) || (aVar = this.a) == null) {
                return;
            }
            aVar.a(exc, i2);
        }

        @Override // c.a.d0.u.a.InterfaceC0116a
        public void b(Headers headers, InputStream inputStream, int i2) throws Exception {
            c.a.d0.u.p.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, headers, inputStream, i2) == null) || (aVar = this.a) == null) {
                return;
            }
            aVar.c(headers, inputStream, i2);
        }

        @Override // c.a.d0.u.a.InterfaceC0116a
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
                return;
            }
        }
        this.a = null;
    }

    @Override // c.a.d0.u.k
    public <T> void a(@NonNull d dVar, @Nullable c.a.d0.u.p.b<T> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, dVar, bVar) == null) {
            c(dVar, true, new C0121b(this, bVar, dVar));
        }
    }

    @Override // c.a.d0.u.k
    public void b(@NonNull d dVar, @Nullable c.a.d0.u.p.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar, aVar) == null) {
            c(dVar, false, new c(this, aVar));
        }
    }

    public final void c(@NonNull d dVar, boolean z, @NonNull a.InterfaceC0116a interfaceC0116a) {
        OkHttpClient.Builder builder;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{dVar, Boolean.valueOf(z), interfaceC0116a}) == null) {
            RequestError b2 = dVar.b();
            if (b2 != null) {
                interfaceC0116a.a(b2, 1001);
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
                int i2 = dVar.f3207g;
                if (i2 > 0) {
                    builder.readTimeout(i2, TimeUnit.MILLISECONDS);
                }
                int i3 = dVar.f3208h;
                if (i3 > 0) {
                    builder.writeTimeout(i3, TimeUnit.MILLISECONDS);
                }
                int i4 = dVar.f3206f;
                if (i4 > 0) {
                    builder.connectTimeout(i4, TimeUnit.MILLISECONDS);
                }
                if (dVar.f3209i != null) {
                    builder.cookieJar(new c.a.d0.u.q.a(dVar.f3209i));
                }
                OkHttpClient build = builder.build();
                if (this.a == null) {
                    this.a = build;
                }
                build.newCall(a2.build()).enqueue(new a(this, interfaceC0116a, z));
            } catch (RequestError e2) {
                interfaceC0116a.a(e2, 1001);
            }
        }
    }
}
