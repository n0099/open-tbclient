package c.a.p0.h.i.p;

import android.content.Context;
import android.text.TextUtils;
import c.a.p0.h.i.p.d;
import c.a.p0.h.i.s.i;
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
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.p0.h.i.m.c f9699b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f9700c;

    /* renamed from: c.a.p0.h.i.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class RunnableC0606a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f9701e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.h.i.m.h f9702f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f9703g;

        /* renamed from: c.a.p0.h.i.p.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0607a extends ResponseCallback<AdResponseInfo> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ RunnableC0606a f9704b;

            /* renamed from: c.a.p0.h.i.p.a$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public class RunnableC0608a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ AdElementInfo f9705e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ C0607a f9706f;

                public RunnableC0608a(C0607a c0607a, AdElementInfo adElementInfo) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0607a, adElementInfo};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f9706f = c0607a;
                    this.f9705e = adElementInfo;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f9706f.f9704b.f9703g.f9699b == null) {
                        return;
                    }
                    this.f9706f.f9704b.f9703g.f9699b.c(this.f9705e);
                }
            }

            public C0607a(RunnableC0606a runnableC0606a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {runnableC0606a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f9704b = runnableC0606a;
                this.a = 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: a */
            public void onSuccess(AdResponseInfo adResponseInfo, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, adResponseInfo, i2) == null) {
                    RunnableC0606a runnableC0606a = this.f9704b;
                    runnableC0606a.f9703g.j(runnableC0606a.f9701e, "requestSuccess", runnableC0606a.f9702f);
                    if (adResponseInfo == null) {
                        this.f9704b.f9703g.g("200000");
                    } else if (adResponseInfo.getAdInstanceList().size() <= 0) {
                        if (!this.f9704b.f9703g.f9700c) {
                            RunnableC0606a runnableC0606a2 = this.f9704b;
                            runnableC0606a2.f9703g.j(runnableC0606a2.f9701e, "requestNoAd", runnableC0606a2.f9702f);
                        }
                        if (this.a == 1 && this.f9704b.f9701e.f9736i.c() == "video" && i.h()) {
                            RunnableC0606a runnableC0606a3 = this.f9704b;
                            runnableC0606a3.f9703g.h(runnableC0606a3.f9702f, runnableC0606a3.f9701e, this);
                            return;
                        }
                        this.a = 0;
                        String errorCode = adResponseInfo.getErrorCode();
                        if (errorCode.equals("0")) {
                            errorCode = "201000";
                        }
                        this.f9704b.f9703g.g(errorCode);
                    } else {
                        c.a.p0.h.i.s.d.c(new RunnableC0608a(this, adResponseInfo.getPrimaryAdInstanceInfo()));
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
                                if (this.f9704b.f9703g.f9700c) {
                                    return new AdResponseInfo(string, this.f9704b.f9703g.f9700c);
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
                    this.f9704b.f9703g.g("3010002");
                    RunnableC0606a runnableC0606a = this.f9704b;
                    runnableC0606a.f9703g.j(runnableC0606a.f9701e, "requestFail", runnableC0606a.f9702f);
                }
            }
        }

        public RunnableC0606a(a aVar, f fVar, c.a.p0.h.i.m.h hVar) {
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
            this.f9703g = aVar;
            this.f9701e = fVar;
            this.f9702f = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            f fVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (fVar = this.f9701e) == null || fVar.f9736i == null) {
                return;
            }
            C0607a c0607a = new C0607a(this);
            if (NetworkUtils.f(this.f9703g.a)) {
                if (this.f9703g.f9700c) {
                    f fVar2 = this.f9701e;
                    if (fVar2 instanceof g) {
                        g gVar = (g) fVar2;
                        if (this.f9702f == null || gVar.i() == null) {
                            return;
                        }
                        this.f9702f.a(gVar.g(), gVar.i(), c0607a);
                        return;
                    }
                }
                this.f9703g.f9700c = false;
                String g2 = this.f9701e.g();
                c.a.p0.h.i.m.h hVar = this.f9702f;
                if (hVar != null) {
                    hVar.f(g2, c0607a);
                }
                this.f9703g.j(this.f9701e, "request", this.f9702f);
                return;
            }
            this.f9703g.g("3010003");
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f9707e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f9708f;

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
            this.f9708f = aVar;
            this.f9707e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f9708f.f9699b == null) {
                return;
            }
            this.f9708f.f9699b.a(this.f9707e);
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
            c.a.p0.h.i.s.d.c(new b(this, str));
        }
    }

    public void h(c.a.p0.h.i.m.h hVar, f fVar, ResponseCallback<AdResponseInfo> responseCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hVar, fVar, responseCallback) == null) {
            if (NetworkUtils.f(this.a)) {
                this.f9700c = true;
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
                bVar.o(fVar.f9736i.g());
                bVar.l(c.a.p0.h.i.s.h.i(this.a));
                bVar.i(c.a.p0.h.i.s.h.h(this.a));
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

    public void i(f fVar, c.a.p0.h.i.m.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, fVar, hVar) == null) {
            c.a.p0.h.i.s.c.d(new RunnableC0606a(this, fVar, hVar), "execAdRequest");
        }
    }

    public final void j(f fVar, String str, c.a.p0.h.i.m.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, fVar, str, hVar) == null) {
            c.a.p0.h.i.r.b.n(str, c.a.p0.h.i.r.b.a(fVar.f9736i.c(), fVar.f9736i.f(), fVar.f9736i.e(), fVar.f9736i.b(), false), hVar);
        }
    }

    public void k(c.a.p0.h.i.m.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.f9699b = cVar;
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
        this.f9700c = z;
    }
}
