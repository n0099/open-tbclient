package com.baidu.prologue.service.network;

import android.content.Context;
import android.os.Handler;
import b.a.f0.a.c.g;
import b.a.f0.d.a.e;
import b.a.f0.d.a.k;
import b.a.f0.d.a.l;
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
/* loaded from: classes7.dex */
public final class Request {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final URL f43100a;

    /* renamed from: b  reason: collision with root package name */
    public final String f43101b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, String> f43102c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, String> f43103d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f43104e;

    /* renamed from: f  reason: collision with root package name */
    public final Context f43105f;

    /* renamed from: g  reason: collision with root package name */
    public final e f43106g;

    /* renamed from: h  reason: collision with root package name */
    public final Handler f43107h;

    /* renamed from: i  reason: collision with root package name */
    public final RequestError f43108i;
    public boolean j;

    /* loaded from: classes7.dex */
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

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f43109e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Request f43110f;

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
            this.f43110f = request;
            this.f43109e = lVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f43109e.a(this.f43110f.f43108i);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f43111a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Request f43112b;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f43113e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f43114f;

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
                this.f43114f = bVar;
                this.f43113e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f43114f.f43111a.onResponse(this.f43113e);
                }
            }
        }

        /* renamed from: com.baidu.prologue.service.network.Request$b$b  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC1689b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Throwable f43115e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f43116f;

            public RunnableC1689b(b bVar, Throwable th) {
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
                this.f43116f = bVar;
                this.f43115e = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f43116f.f43111a.a(this.f43115e);
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
            this.f43112b = request;
            this.f43111a = lVar;
        }

        @Override // b.a.f0.d.a.k
        public void a(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                this.f43112b.g(new RunnableC1689b(this, th));
            }
        }

        @Override // b.a.f0.d.a.k
        public void b(long j, InputStream inputStream) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j, inputStream) == null) {
                this.f43112b.g(new a(this, new String(Request.h(inputStream))));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Context f43117a;

        /* renamed from: b  reason: collision with root package name */
        public final String f43118b;

        /* renamed from: c  reason: collision with root package name */
        public URL f43119c;

        /* renamed from: d  reason: collision with root package name */
        public String f43120d;

        /* renamed from: e  reason: collision with root package name */
        public Map<String, String> f43121e;

        /* renamed from: f  reason: collision with root package name */
        public Map<String, String> f43122f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f43123g;

        /* renamed from: h  reason: collision with root package name */
        public Object f43124h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f43125i;
        public RequestError j;

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
            this.f43117a = context.getApplicationContext();
            this.f43118b = str;
        }

        public c j(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
                if (this.f43122f == null) {
                    this.f43122f = new HashMap();
                }
                this.f43122f.put(str, str2);
                return this;
            }
            return (c) invokeLL.objValue;
        }

        public c k(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
                if (this.f43121e == null) {
                    this.f43121e = new HashMap();
                }
                this.f43121e.put(str, str2.trim());
                return this;
            }
            return (c) invokeLL.objValue;
        }

        public Request l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (this.f43120d == null) {
                    m();
                }
                if ("GET".equals(this.f43120d)) {
                    try {
                        this.f43119c = new URL(b.a.f0.d.a.b.b(this.f43119c.toString(), this.f43122f));
                    } catch (MalformedURLException e2) {
                        this.j = new RequestError("Failed to create url", e2);
                    } catch (URISyntaxException e3) {
                        this.j = new RequestError("Failed to add parameters to url", e3);
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
                if (this.f43119c != null) {
                    this.j = new RequestError("Method called twice");
                }
                try {
                    this.f43119c = new URL(this.f43118b);
                } catch (MalformedURLException e2) {
                    this.j = new RequestError(e2);
                }
                this.f43120d = "GET";
                return this;
            }
            return (c) invokeV.objValue;
        }

        public c n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                if (this.f43119c != null) {
                    this.j = new RequestError("Method called twice");
                }
                try {
                    this.f43119c = new URL(this.f43118b);
                } catch (MalformedURLException e2) {
                    this.j = new RequestError(e2);
                }
                this.f43120d = "POST";
                return this;
            }
            return (c) invokeV.objValue;
        }

        public c o(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
                this.f43125i = z;
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
                        g.f2888a.e(SingleRequest.TAG, "failed to read is", e2);
                    }
                }
                return byteArrayOutputStream.toByteArray();
            } finally {
                b.a.f0.a.c.k.a(byteArrayOutputStream);
            }
        }
        return (byte[]) invokeL.objValue;
    }

    public void d(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, kVar) == null) {
            this.f43106g.a(this, kVar);
        }
    }

    public void e(l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar) == null) {
            if (this.f43108i != null) {
                g(new a(this, lVar));
            } else {
                this.f43106g.a(this, new b(this, lVar));
            }
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Map<String, String> map = this.f43103d;
            return map != null && map.size() > 0;
        }
        return invokeV.booleanValue;
    }

    public final void g(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, runnable) == null) {
            this.f43107h.post(runnable);
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
        this.f43108i = cVar.j;
        this.f43105f = cVar.f43117a;
        this.f43107h = new Handler(this.f43105f.getMainLooper());
        this.f43100a = cVar.f43119c;
        this.f43101b = cVar.f43120d;
        this.f43102c = cVar.f43121e;
        this.f43103d = cVar.f43122f;
        boolean unused = cVar.f43123g;
        this.f43104e = cVar.f43124h != null ? cVar.f43124h : this;
        this.f43106g = b.a.f0.d.a.c.c(this.f43105f);
        this.j = cVar.f43125i;
    }
}
