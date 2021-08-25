package c.a.o0.f.i.o;

import android.content.Context;
import android.text.TextUtils;
import c.a.o0.f.i.o.c;
import c.a.o0.f.i.r.h;
import c.a.o0.f.i.r.i;
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
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f10587a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.o0.f.i.l.b f10588b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f10589c;

    /* renamed from: c.a.o0.f.i.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0527a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f10590e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.f.i.l.g f10591f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f10592g;

        /* renamed from: c.a.o0.f.i.o.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0528a extends ResponseCallback<AdResponseInfo> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public int f10593a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ RunnableC0527a f10594b;

            /* renamed from: c.a.o0.f.i.o.a$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class RunnableC0529a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ AdElementInfo f10595e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ C0528a f10596f;

                public RunnableC0529a(C0528a c0528a, AdElementInfo adElementInfo) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0528a, adElementInfo};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f10596f = c0528a;
                    this.f10595e = adElementInfo;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f10596f.f10594b.f10592g.f10588b == null) {
                        return;
                    }
                    this.f10596f.f10594b.f10592g.f10588b.c(this.f10595e);
                }
            }

            public C0528a(RunnableC0527a runnableC0527a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {runnableC0527a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f10594b = runnableC0527a;
                this.f10593a = 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: a */
            public void onSuccess(AdResponseInfo adResponseInfo, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, adResponseInfo, i2) == null) {
                    RunnableC0527a runnableC0527a = this.f10594b;
                    runnableC0527a.f10592g.j(runnableC0527a.f10590e, "requestSuccess", runnableC0527a.f10591f);
                    if (adResponseInfo == null) {
                        this.f10594b.f10592g.g("200000");
                    } else if (adResponseInfo.getAdInstanceList().size() <= 0) {
                        if (!this.f10594b.f10592g.f10589c) {
                            RunnableC0527a runnableC0527a2 = this.f10594b;
                            runnableC0527a2.f10592g.j(runnableC0527a2.f10590e, "requestNoAd", runnableC0527a2.f10591f);
                        }
                        if (this.f10593a == 1 && this.f10594b.f10590e.f10623i.c() == "video" && i.h()) {
                            RunnableC0527a runnableC0527a3 = this.f10594b;
                            runnableC0527a3.f10592g.h(runnableC0527a3.f10591f, runnableC0527a3.f10590e, this);
                            return;
                        }
                        this.f10593a = 0;
                        String errorCode = adResponseInfo.getErrorCode();
                        if (errorCode.equals("0")) {
                            errorCode = "201000";
                        }
                        this.f10594b.f10592g.g(errorCode);
                    } else {
                        c.a.o0.f.i.r.d.c(new RunnableC0529a(this, adResponseInfo.getPrimaryAdInstanceInfo()));
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
                        this.f10593a++;
                        if (!response.isSuccessful()) {
                            return null;
                        }
                        try {
                            String string = response.body().string();
                            if (!TextUtils.isEmpty(string)) {
                                if (this.f10594b.f10592g.f10589c) {
                                    return new AdResponseInfo(string, this.f10594b.f10592g.f10589c);
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
                    this.f10594b.f10592g.g("3010002");
                    RunnableC0527a runnableC0527a = this.f10594b;
                    runnableC0527a.f10592g.j(runnableC0527a.f10590e, "requestFail", runnableC0527a.f10591f);
                }
            }
        }

        public RunnableC0527a(a aVar, e eVar, c.a.o0.f.i.l.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, eVar, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10592g = aVar;
            this.f10590e = eVar;
            this.f10591f = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e eVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (eVar = this.f10590e) == null || eVar.f10623i == null) {
                return;
            }
            C0528a c0528a = new C0528a(this);
            if (NetworkUtils.f(this.f10592g.f10587a)) {
                if (this.f10592g.f10589c) {
                    e eVar2 = this.f10590e;
                    if (eVar2 instanceof f) {
                        f fVar = (f) eVar2;
                        if (this.f10591f == null || fVar.i() == null) {
                            return;
                        }
                        this.f10591f.a(fVar.g(), fVar.i(), c0528a);
                        return;
                    }
                }
                this.f10592g.f10589c = false;
                String g2 = this.f10590e.g();
                c.a.o0.f.i.l.g gVar = this.f10591f;
                if (gVar != null) {
                    gVar.e(g2, c0528a);
                }
                this.f10592g.j(this.f10590e, "request", this.f10591f);
                return;
            }
            this.f10592g.g("3010003");
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f10597e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f10598f;

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
            this.f10598f = aVar;
            this.f10597e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f10598f.f10588b == null) {
                return;
            }
            this.f10598f.f10588b.a(this.f10597e);
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
        this.f10587a = context;
    }

    public final void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            c.a.o0.f.i.r.d.c(new b(this, str));
        }
    }

    public void h(c.a.o0.f.i.l.g gVar, e eVar, ResponseCallback<AdResponseInfo> responseCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar, eVar, responseCallback) == null) {
            if (NetworkUtils.f(this.f10587a)) {
                this.f10589c = true;
                if (eVar instanceof f) {
                    f fVar = (f) eVar;
                    if (gVar == null || fVar.i() == null) {
                        return;
                    }
                    gVar.a(fVar.g(), fVar.i(), responseCallback);
                    return;
                }
                c.b bVar = new c.b();
                bVar.m(i.c());
                bVar.j(i.d());
                bVar.o(eVar.f10623i.g());
                bVar.l(h.i(this.f10587a));
                bVar.i(h.h(this.f10587a));
                f fVar2 = new f(this.f10587a, bVar.h(), 5, 5);
                if (gVar == null || fVar2.i() == null) {
                    return;
                }
                gVar.a(fVar2.g(), fVar2.i(), responseCallback);
                return;
            }
            g("3010003");
        }
    }

    public void i(e eVar, c.a.o0.f.i.l.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, eVar, gVar) == null) {
            c.a.o0.f.i.r.c.d(new RunnableC0527a(this, eVar, gVar), "execAdRequest");
        }
    }

    public final void j(e eVar, String str, c.a.o0.f.i.l.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, eVar, str, gVar) == null) {
            c.a.o0.f.i.q.b.n(str, c.a.o0.f.i.q.b.a(eVar.f10623i.c(), eVar.f10623i.f(), eVar.f10623i.e(), eVar.f10623i.b(), false), gVar);
        }
    }

    public void k(c.a.o0.f.i.l.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f10588b = bVar;
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
        this.f10589c = z;
    }
}
