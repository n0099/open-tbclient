package com.baidu.prologue.service.network;

import android.content.Context;
import android.os.Handler;
import c.a.f0.a.c.g;
import c.a.f0.d.a.e;
import c.a.f0.d.a.k;
import c.a.f0.d.a.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.request.SingleRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public final class Request {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final URL f44486a;

    /* renamed from: b  reason: collision with root package name */
    public final String f44487b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, String> f44488c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, String> f44489d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f44490e;

    /* renamed from: f  reason: collision with root package name */
    public final Context f44491f;

    /* renamed from: g  reason: collision with root package name */
    public final e f44492g;

    /* renamed from: h  reason: collision with root package name */
    public final Handler f44493h;

    /* renamed from: i  reason: collision with root package name */
    public final RequestError f44494i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f44495j;

    /* loaded from: classes5.dex */
    public static class RequestError extends IOException {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RequestError(String str) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RequestError(String str, Throwable th) {
            super(str, th);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, th};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (Throwable) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RequestError(Throwable th) {
            super(th);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {th};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Throwable) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f44496e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Request f44497f;

        public a(Request request, l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {request, lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44497f = request;
            this.f44496e = lVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f44496e.a(this.f44497f.f44494i);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f44498a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Request f44499b;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f44500e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f44501f;

            public a(b bVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f44501f = bVar;
                this.f44500e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f44501f.f44498a.onResponse(this.f44500e);
                }
            }
        }

        /* renamed from: com.baidu.prologue.service.network.Request$b$b  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC1694b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Throwable f44502e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f44503f;

            public RunnableC1694b(b bVar, Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, th};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f44503f = bVar;
                this.f44502e = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f44503f.f44498a.a(this.f44502e);
                }
            }
        }

        public b(Request request, l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {request, lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44499b = request;
            this.f44498a = lVar;
        }

        @Override // c.a.f0.d.a.k
        public void a(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                this.f44499b.g(new RunnableC1694b(this, th));
            }
        }

        @Override // c.a.f0.d.a.k
        public void b(long j2, InputStream inputStream) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2, inputStream) == null) {
                this.f44499b.g(new a(this, new String(Request.h(inputStream))));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Context f44504a;

        /* renamed from: b  reason: collision with root package name */
        public final String f44505b;

        /* renamed from: c  reason: collision with root package name */
        public URL f44506c;

        /* renamed from: d  reason: collision with root package name */
        public String f44507d;

        /* renamed from: e  reason: collision with root package name */
        public Map<String, String> f44508e;

        /* renamed from: f  reason: collision with root package name */
        public Map<String, String> f44509f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f44510g;

        /* renamed from: h  reason: collision with root package name */
        public Object f44511h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f44512i;

        /* renamed from: j  reason: collision with root package name */
        public RequestError f44513j;

        public c(Context context, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44504a = context.getApplicationContext();
            this.f44505b = str;
        }

        public c j(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
                if (this.f44509f == null) {
                    this.f44509f = new HashMap();
                }
                this.f44509f.put(str, str2);
                return this;
            }
            return (c) invokeLL.objValue;
        }

        public c k(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
                if (this.f44508e == null) {
                    this.f44508e = new HashMap();
                }
                this.f44508e.put(str, str2.trim());
                return this;
            }
            return (c) invokeLL.objValue;
        }

        public Request l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (this.f44507d == null) {
                    m();
                }
                if ("GET".equals(this.f44507d)) {
                    try {
                        this.f44506c = new URL(c.a.f0.d.a.b.b(this.f44506c.toString(), this.f44509f));
                    } catch (MalformedURLException e2) {
                        this.f44513j = new RequestError("Failed to create url", e2);
                    } catch (URISyntaxException e3) {
                        this.f44513j = new RequestError("Failed to add parameters to url", e3);
                    }
                }
                return new Request(this, null);
            }
            return (Request) invokeV.objValue;
        }

        public c m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (this.f44506c != null) {
                    this.f44513j = new RequestError("Method called twice");
                }
                try {
                    this.f44506c = new URL(this.f44505b);
                } catch (MalformedURLException e2) {
                    this.f44513j = new RequestError(e2);
                }
                this.f44507d = "GET";
                return this;
            }
            return (c) invokeV.objValue;
        }

        public c n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                if (this.f44506c != null) {
                    this.f44513j = new RequestError("Method called twice");
                }
                try {
                    this.f44506c = new URL(this.f44505b);
                } catch (MalformedURLException e2) {
                    this.f44513j = new RequestError(e2);
                }
                this.f44507d = "POST";
                return this;
            }
            return (c) invokeV.objValue;
        }

        public c o(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
                this.f44512i = z;
                return this;
            }
            return (c) invokeZ.objValue;
        }
    }

    public /* synthetic */ Request(c cVar, a aVar) {
        this(cVar);
    }

    public static byte[] h(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, inputStream)) == null) {
            if (inputStream == null) {
                return new byte[0];
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    try {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    } catch (IOException e2) {
                        g.f3352a.e(SingleRequest.TAG, "failed to read is", e2);
                    }
                }
                return byteArrayOutputStream.toByteArray();
            } finally {
                c.a.f0.a.c.k.a(byteArrayOutputStream);
            }
        }
        return (byte[]) invokeL.objValue;
    }

    public void d(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, kVar) == null) {
            this.f44492g.a(this, kVar);
        }
    }

    public void e(l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar) == null) {
            if (this.f44494i != null) {
                g(new a(this, lVar));
            } else {
                this.f44492g.a(this, new b(this, lVar));
            }
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Map<String, String> map = this.f44489d;
            return map != null && map.size() > 0;
        }
        return invokeV.booleanValue;
    }

    public final void g(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, runnable) == null) {
            this.f44493h.post(runnable);
        }
    }

    public Request(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f44494i = cVar.f44513j;
        this.f44491f = cVar.f44504a;
        this.f44493h = new Handler(this.f44491f.getMainLooper());
        this.f44486a = cVar.f44506c;
        this.f44487b = cVar.f44507d;
        this.f44488c = cVar.f44508e;
        this.f44489d = cVar.f44509f;
        boolean unused = cVar.f44510g;
        this.f44490e = cVar.f44511h != null ? cVar.f44511h : this;
        this.f44492g = c.a.f0.d.a.c.c(this.f44491f);
        this.f44495j = cVar.f44512i;
    }
}
