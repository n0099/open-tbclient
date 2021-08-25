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
    public final URL f44309a;

    /* renamed from: b  reason: collision with root package name */
    public final String f44310b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, String> f44311c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, String> f44312d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f44313e;

    /* renamed from: f  reason: collision with root package name */
    public final Context f44314f;

    /* renamed from: g  reason: collision with root package name */
    public final e f44315g;

    /* renamed from: h  reason: collision with root package name */
    public final Handler f44316h;

    /* renamed from: i  reason: collision with root package name */
    public final RequestError f44317i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f44318j;

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
        public final /* synthetic */ l f44319e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Request f44320f;

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
            this.f44320f = request;
            this.f44319e = lVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f44319e.a(this.f44320f.f44317i);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f44321a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Request f44322b;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f44323e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f44324f;

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
                this.f44324f = bVar;
                this.f44323e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f44324f.f44321a.onResponse(this.f44323e);
                }
            }
        }

        /* renamed from: com.baidu.prologue.service.network.Request$b$b  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC1692b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Throwable f44325e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f44326f;

            public RunnableC1692b(b bVar, Throwable th) {
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
                this.f44326f = bVar;
                this.f44325e = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f44326f.f44321a.a(this.f44325e);
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
            this.f44322b = request;
            this.f44321a = lVar;
        }

        @Override // c.a.f0.d.a.k
        public void a(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                this.f44322b.g(new RunnableC1692b(this, th));
            }
        }

        @Override // c.a.f0.d.a.k
        public void b(long j2, InputStream inputStream) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2, inputStream) == null) {
                this.f44322b.g(new a(this, new String(Request.h(inputStream))));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Context f44327a;

        /* renamed from: b  reason: collision with root package name */
        public final String f44328b;

        /* renamed from: c  reason: collision with root package name */
        public URL f44329c;

        /* renamed from: d  reason: collision with root package name */
        public String f44330d;

        /* renamed from: e  reason: collision with root package name */
        public Map<String, String> f44331e;

        /* renamed from: f  reason: collision with root package name */
        public Map<String, String> f44332f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f44333g;

        /* renamed from: h  reason: collision with root package name */
        public Object f44334h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f44335i;

        /* renamed from: j  reason: collision with root package name */
        public RequestError f44336j;

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
            this.f44327a = context.getApplicationContext();
            this.f44328b = str;
        }

        public c j(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
                if (this.f44332f == null) {
                    this.f44332f = new HashMap();
                }
                this.f44332f.put(str, str2);
                return this;
            }
            return (c) invokeLL.objValue;
        }

        public c k(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
                if (this.f44331e == null) {
                    this.f44331e = new HashMap();
                }
                this.f44331e.put(str, str2.trim());
                return this;
            }
            return (c) invokeLL.objValue;
        }

        public Request l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (this.f44330d == null) {
                    m();
                }
                if ("GET".equals(this.f44330d)) {
                    try {
                        this.f44329c = new URL(c.a.f0.d.a.b.b(this.f44329c.toString(), this.f44332f));
                    } catch (MalformedURLException e2) {
                        this.f44336j = new RequestError("Failed to create url", e2);
                    } catch (URISyntaxException e3) {
                        this.f44336j = new RequestError("Failed to add parameters to url", e3);
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
                if (this.f44329c != null) {
                    this.f44336j = new RequestError("Method called twice");
                }
                try {
                    this.f44329c = new URL(this.f44328b);
                } catch (MalformedURLException e2) {
                    this.f44336j = new RequestError(e2);
                }
                this.f44330d = "GET";
                return this;
            }
            return (c) invokeV.objValue;
        }

        public c n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                if (this.f44329c != null) {
                    this.f44336j = new RequestError("Method called twice");
                }
                try {
                    this.f44329c = new URL(this.f44328b);
                } catch (MalformedURLException e2) {
                    this.f44336j = new RequestError(e2);
                }
                this.f44330d = "POST";
                return this;
            }
            return (c) invokeV.objValue;
        }

        public c o(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
                this.f44335i = z;
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
                        g.f3360a.e(SingleRequest.TAG, "failed to read is", e2);
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
            this.f44315g.a(this, kVar);
        }
    }

    public void e(l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar) == null) {
            if (this.f44317i != null) {
                g(new a(this, lVar));
            } else {
                this.f44315g.a(this, new b(this, lVar));
            }
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Map<String, String> map = this.f44312d;
            return map != null && map.size() > 0;
        }
        return invokeV.booleanValue;
    }

    public final void g(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, runnable) == null) {
            this.f44316h.post(runnable);
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
        this.f44317i = cVar.f44336j;
        this.f44314f = cVar.f44327a;
        this.f44316h = new Handler(this.f44314f.getMainLooper());
        this.f44309a = cVar.f44329c;
        this.f44310b = cVar.f44330d;
        this.f44311c = cVar.f44331e;
        this.f44312d = cVar.f44332f;
        boolean unused = cVar.f44333g;
        this.f44313e = cVar.f44334h != null ? cVar.f44334h : this;
        this.f44315g = c.a.f0.d.a.c.c(this.f44314f);
        this.f44318j = cVar.f44335i;
    }
}
