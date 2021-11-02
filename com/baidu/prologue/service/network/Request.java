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
    public final URL f42154a;

    /* renamed from: b  reason: collision with root package name */
    public final String f42155b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, String> f42156c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, String> f42157d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f42158e;

    /* renamed from: f  reason: collision with root package name */
    public final Context f42159f;

    /* renamed from: g  reason: collision with root package name */
    public final e f42160g;

    /* renamed from: h  reason: collision with root package name */
    public final Handler f42161h;

    /* renamed from: i  reason: collision with root package name */
    public final RequestError f42162i;
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
        public final /* synthetic */ l f42163e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Request f42164f;

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
            this.f42164f = request;
            this.f42163e = lVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f42163e.a(this.f42164f.f42162i);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f42165a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Request f42166b;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f42167e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f42168f;

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
                this.f42168f = bVar;
                this.f42167e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f42168f.f42165a.onResponse(this.f42167e);
                }
            }
        }

        /* renamed from: com.baidu.prologue.service.network.Request$b$b  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC1653b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Throwable f42169e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f42170f;

            public RunnableC1653b(b bVar, Throwable th) {
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
                this.f42170f = bVar;
                this.f42169e = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f42170f.f42165a.a(this.f42169e);
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
            this.f42166b = request;
            this.f42165a = lVar;
        }

        @Override // b.a.f0.d.a.k
        public void a(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                this.f42166b.g(new RunnableC1653b(this, th));
            }
        }

        @Override // b.a.f0.d.a.k
        public void b(long j, InputStream inputStream) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j, inputStream) == null) {
                this.f42166b.g(new a(this, new String(Request.h(inputStream))));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Context f42171a;

        /* renamed from: b  reason: collision with root package name */
        public final String f42172b;

        /* renamed from: c  reason: collision with root package name */
        public URL f42173c;

        /* renamed from: d  reason: collision with root package name */
        public String f42174d;

        /* renamed from: e  reason: collision with root package name */
        public Map<String, String> f42175e;

        /* renamed from: f  reason: collision with root package name */
        public Map<String, String> f42176f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f42177g;

        /* renamed from: h  reason: collision with root package name */
        public Object f42178h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f42179i;
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
            this.f42171a = context.getApplicationContext();
            this.f42172b = str;
        }

        public c j(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
                if (this.f42176f == null) {
                    this.f42176f = new HashMap();
                }
                this.f42176f.put(str, str2);
                return this;
            }
            return (c) invokeLL.objValue;
        }

        public c k(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
                if (this.f42175e == null) {
                    this.f42175e = new HashMap();
                }
                this.f42175e.put(str, str2.trim());
                return this;
            }
            return (c) invokeLL.objValue;
        }

        public Request l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (this.f42174d == null) {
                    m();
                }
                if ("GET".equals(this.f42174d)) {
                    try {
                        this.f42173c = new URL(b.a.f0.d.a.b.b(this.f42173c.toString(), this.f42176f));
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
                if (this.f42173c != null) {
                    this.j = new RequestError("Method called twice");
                }
                try {
                    this.f42173c = new URL(this.f42172b);
                } catch (MalformedURLException e2) {
                    this.j = new RequestError(e2);
                }
                this.f42174d = "GET";
                return this;
            }
            return (c) invokeV.objValue;
        }

        public c n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                if (this.f42173c != null) {
                    this.j = new RequestError("Method called twice");
                }
                try {
                    this.f42173c = new URL(this.f42172b);
                } catch (MalformedURLException e2) {
                    this.j = new RequestError(e2);
                }
                this.f42174d = "POST";
                return this;
            }
            return (c) invokeV.objValue;
        }

        public c o(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
                this.f42179i = z;
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
                        g.f2795a.e(SingleRequest.TAG, "failed to read is", e2);
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
            this.f42160g.a(this, kVar);
        }
    }

    public void e(l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar) == null) {
            if (this.f42162i != null) {
                g(new a(this, lVar));
            } else {
                this.f42160g.a(this, new b(this, lVar));
            }
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Map<String, String> map = this.f42157d;
            return map != null && map.size() > 0;
        }
        return invokeV.booleanValue;
    }

    public final void g(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, runnable) == null) {
            this.f42161h.post(runnable);
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
        this.f42162i = cVar.j;
        this.f42159f = cVar.f42171a;
        this.f42161h = new Handler(this.f42159f.getMainLooper());
        this.f42154a = cVar.f42173c;
        this.f42155b = cVar.f42174d;
        this.f42156c = cVar.f42175e;
        this.f42157d = cVar.f42176f;
        boolean unused = cVar.f42177g;
        this.f42158e = cVar.f42178h != null ? cVar.f42178h : this;
        this.f42160g = b.a.f0.d.a.c.c(this.f42159f);
        this.j = cVar.f42179i;
    }
}
