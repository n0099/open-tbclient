package c.a.p0.h.a.h;

import android.content.Context;
import android.text.TextUtils;
import c.a.p0.h.a.h.d;
import c.a.p0.h.a.k.i;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import com.baidu.swan.game.ad.entity.AdResponseInfo;
import com.baidu.swan.game.ad.utils.NetworkUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import okhttp3.Response;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.p0.h.a.e.c f9975b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f9976c;

    /* renamed from: c.a.p0.h.a.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0664a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f9977e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.h.a.e.h f9978f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f9979g;

        /* renamed from: c.a.p0.h.a.h.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0665a extends ResponseCallback<AdResponseInfo> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ RunnableC0664a f9980b;

            /* renamed from: c.a.p0.h.a.h.a$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public class RunnableC0666a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ AdElementInfo f9981e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ C0665a f9982f;

                public RunnableC0666a(C0665a c0665a, AdElementInfo adElementInfo) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0665a, adElementInfo};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f9982f = c0665a;
                    this.f9981e = adElementInfo;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f9982f.f9980b.f9979g.f9975b == null) {
                        return;
                    }
                    this.f9982f.f9980b.f9979g.f9975b.c(this.f9981e);
                }
            }

            public C0665a(RunnableC0664a runnableC0664a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {runnableC0664a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f9980b = runnableC0664a;
                this.a = 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: a */
            public void onSuccess(AdResponseInfo adResponseInfo, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, adResponseInfo, i2) == null) {
                    RunnableC0664a runnableC0664a = this.f9980b;
                    runnableC0664a.f9979g.j(runnableC0664a.f9977e, "requestSuccess", runnableC0664a.f9978f);
                    if (adResponseInfo == null) {
                        this.f9980b.f9979g.g("200000");
                    } else if (adResponseInfo.getAdInstanceList().size() <= 0) {
                        if (!this.f9980b.f9979g.f9976c) {
                            RunnableC0664a runnableC0664a2 = this.f9980b;
                            runnableC0664a2.f9979g.j(runnableC0664a2.f9977e, "requestNoAd", runnableC0664a2.f9978f);
                        }
                        if (this.a == 1 && this.f9980b.f9977e.f10011i.c() == "video" && i.h()) {
                            RunnableC0664a runnableC0664a3 = this.f9980b;
                            runnableC0664a3.f9979g.h(runnableC0664a3.f9978f, runnableC0664a3.f9977e, this);
                            return;
                        }
                        this.a = 0;
                        String errorCode = adResponseInfo.getErrorCode();
                        if (errorCode.equals("0")) {
                            errorCode = "201000";
                        }
                        this.f9980b.f9979g.g(errorCode);
                    } else {
                        c.a.p0.h.a.k.d.c(new RunnableC0666a(this, adResponseInfo.getPrimaryAdInstanceInfo()));
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: b */
            public AdResponseInfo parseResponse(Response response, int i2) {
                InterceptResult invokeLI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, response, i2)) == null) {
                    if (response != null && response.body() != null) {
                        this.a++;
                        if (!response.isSuccessful()) {
                            return null;
                        }
                        try {
                            String string = response.body().string();
                            if (!TextUtils.isEmpty(string)) {
                                if (this.f9980b.f9979g.f9976c) {
                                    return new AdResponseInfo(string, this.f9980b.f9979g.f9976c);
                                }
                                return new AdResponseInfo(string);
                            }
                        } catch (Exception | OutOfMemoryError unused) {
                        }
                    }
                    return null;
                }
                return (AdResponseInfo) invokeLI.objValue;
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                    this.f9980b.f9979g.g("3010002");
                    RunnableC0664a runnableC0664a = this.f9980b;
                    runnableC0664a.f9979g.j(runnableC0664a.f9977e, "requestFail", runnableC0664a.f9978f);
                }
            }
        }

        public RunnableC0664a(a aVar, f fVar, c.a.p0.h.a.e.h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, fVar, hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9979g = aVar;
            this.f9977e = fVar;
            this.f9978f = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            f fVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (fVar = this.f9977e) == null || fVar.f10011i == null) {
                return;
            }
            C0665a c0665a = new C0665a(this);
            if (NetworkUtils.f(this.f9979g.a)) {
                if (this.f9979g.f9976c) {
                    f fVar2 = this.f9977e;
                    if (fVar2 instanceof g) {
                        g gVar = (g) fVar2;
                        if (this.f9978f == null || gVar.i() == null) {
                            return;
                        }
                        this.f9978f.a(gVar.g(), gVar.i(), c0665a);
                        return;
                    }
                }
                this.f9979g.f9976c = false;
                String g2 = this.f9977e.g();
                c.a.p0.h.a.e.h hVar = this.f9978f;
                if (hVar != null) {
                    hVar.f(g2, c0665a);
                }
                this.f9979g.j(this.f9977e, "request", this.f9978f);
                return;
            }
            this.f9979g.g("3010003");
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f9983e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f9984f;

        public b(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9984f = aVar;
            this.f9983e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f9984f.f9975b == null) {
                return;
            }
            this.f9984f.f9975b.a(this.f9983e);
        }
    }

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
    }

    public final void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            c.a.p0.h.a.k.d.c(new b(this, str));
        }
    }

    public void h(c.a.p0.h.a.e.h hVar, f fVar, ResponseCallback<AdResponseInfo> responseCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hVar, fVar, responseCallback) == null) {
            if (NetworkUtils.f(this.a)) {
                this.f9976c = true;
                if (fVar instanceof g) {
                    g gVar = (g) fVar;
                    if (hVar == null || gVar.i() == null) {
                        return;
                    }
                    hVar.a(gVar.g(), gVar.i(), responseCallback);
                    return;
                }
                d.b bVar = new d.b();
                bVar.m(i.c());
                bVar.j(i.d());
                bVar.o(fVar.f10011i.g());
                bVar.l(c.a.p0.h.a.k.h.i(this.a));
                bVar.i(c.a.p0.h.a.k.h.h(this.a));
                g gVar2 = new g(this.a, bVar.h(), 5, 5);
                if (hVar == null || gVar2.i() == null) {
                    return;
                }
                hVar.a(gVar2.g(), gVar2.i(), responseCallback);
                return;
            }
            g("3010003");
        }
    }

    public void i(f fVar, c.a.p0.h.a.e.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, fVar, hVar) == null) {
            c.a.p0.h.a.k.c.d(new RunnableC0664a(this, fVar, hVar), "execAdRequest");
        }
    }

    public final void j(f fVar, String str, c.a.p0.h.a.e.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, fVar, str, hVar) == null) {
            c.a.p0.h.a.j.b.n(str, c.a.p0.h.a.j.b.a(fVar.f10011i.c(), fVar.f10011i.f(), fVar.f10011i.e(), fVar.f10011i.b(), false), hVar);
        }
    }

    public void k(c.a.p0.h.a.e.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.f9975b = cVar;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(Context context, boolean z) {
        this(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f9976c = z;
    }
}
