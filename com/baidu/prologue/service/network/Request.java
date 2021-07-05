package com.baidu.prologue.service.network;

import android.content.Context;
import android.os.Handler;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.request.SingleRequest;
import d.a.h0.a.c.g;
import d.a.h0.d.a.e;
import d.a.h0.d.a.k;
import d.a.h0.d.a.l;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public final class Request {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final URL f9504a;

    /* renamed from: b  reason: collision with root package name */
    public final String f9505b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, String> f9506c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, String> f9507d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f9508e;

    /* renamed from: f  reason: collision with root package name */
    public final Context f9509f;

    /* renamed from: g  reason: collision with root package name */
    public final e f9510g;

    /* renamed from: h  reason: collision with root package name */
    public final Handler f9511h;

    /* renamed from: i  reason: collision with root package name */
    public final RequestError f9512i;
    public boolean j;

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f9513e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Request f9514f;

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
            this.f9514f = request;
            this.f9513e = lVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f9513e.a(this.f9514f.f9512i);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f9515a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Request f9516b;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f9517e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f9518f;

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
                this.f9518f = bVar;
                this.f9517e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f9518f.f9515a.onResponse(this.f9517e);
                }
            }
        }

        /* renamed from: com.baidu.prologue.service.network.Request$b$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0139b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Throwable f9519e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f9520f;

            public RunnableC0139b(b bVar, Throwable th) {
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
                this.f9520f = bVar;
                this.f9519e = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f9520f.f9515a.a(this.f9519e);
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
            this.f9516b = request;
            this.f9515a = lVar;
        }

        @Override // d.a.h0.d.a.k
        public void a(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                this.f9516b.g(new RunnableC0139b(this, th));
            }
        }

        @Override // d.a.h0.d.a.k
        public void b(long j, InputStream inputStream) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j, inputStream) == null) {
                this.f9516b.g(new a(this, new String(Request.h(inputStream))));
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Context f9521a;

        /* renamed from: b  reason: collision with root package name */
        public final String f9522b;

        /* renamed from: c  reason: collision with root package name */
        public URL f9523c;

        /* renamed from: d  reason: collision with root package name */
        public String f9524d;

        /* renamed from: e  reason: collision with root package name */
        public Map<String, String> f9525e;

        /* renamed from: f  reason: collision with root package name */
        public Map<String, String> f9526f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f9527g;

        /* renamed from: h  reason: collision with root package name */
        public Object f9528h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f9529i;
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
            this.f9521a = context.getApplicationContext();
            this.f9522b = str;
        }

        public c j(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
                if (this.f9526f == null) {
                    this.f9526f = new HashMap();
                }
                this.f9526f.put(str, str2);
                return this;
            }
            return (c) invokeLL.objValue;
        }

        public c k(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
                if (this.f9525e == null) {
                    this.f9525e = new HashMap();
                }
                this.f9525e.put(str, str2.trim());
                return this;
            }
            return (c) invokeLL.objValue;
        }

        public Request l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (this.f9524d == null) {
                    m();
                }
                if ("GET".equals(this.f9524d)) {
                    try {
                        this.f9523c = new URL(d.a.h0.d.a.b.b(this.f9523c.toString(), this.f9526f));
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
                if (this.f9523c != null) {
                    this.j = new RequestError("Method called twice");
                }
                try {
                    this.f9523c = new URL(this.f9522b);
                } catch (MalformedURLException e2) {
                    this.j = new RequestError(e2);
                }
                this.f9524d = "GET";
                return this;
            }
            return (c) invokeV.objValue;
        }

        public c n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                if (this.f9523c != null) {
                    this.j = new RequestError("Method called twice");
                }
                try {
                    this.f9523c = new URL(this.f9522b);
                } catch (MalformedURLException e2) {
                    this.j = new RequestError(e2);
                }
                this.f9524d = "POST";
                return this;
            }
            return (c) invokeV.objValue;
        }

        public c o(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
                this.f9529i = z;
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
                        g.f45575a.e(SingleRequest.TAG, "failed to read is", e2);
                    }
                }
                return byteArrayOutputStream.toByteArray();
            } finally {
                d.a.h0.a.c.k.a(byteArrayOutputStream);
            }
        }
        return (byte[]) invokeL.objValue;
    }

    public void d(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, kVar) == null) {
            this.f9510g.a(this, kVar);
        }
    }

    public void e(l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar) == null) {
            if (this.f9512i != null) {
                g(new a(this, lVar));
            } else {
                this.f9510g.a(this, new b(this, lVar));
            }
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Map<String, String> map = this.f9507d;
            return map != null && map.size() > 0;
        }
        return invokeV.booleanValue;
    }

    public final void g(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, runnable) == null) {
            this.f9511h.post(runnable);
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
        this.f9512i = cVar.j;
        this.f9509f = cVar.f9521a;
        this.f9511h = new Handler(this.f9509f.getMainLooper());
        this.f9504a = cVar.f9523c;
        this.f9505b = cVar.f9524d;
        this.f9506c = cVar.f9525e;
        this.f9507d = cVar.f9526f;
        boolean unused = cVar.f9527g;
        this.f9508e = cVar.f9528h != null ? cVar.f9528h : this;
        this.f9510g = d.a.h0.d.a.c.c(this.f9509f);
        this.j = cVar.f9529i;
    }
}
