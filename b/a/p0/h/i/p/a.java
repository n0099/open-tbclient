package b.a.p0.h.i.p;

import android.content.Context;
import android.text.TextUtils;
import b.a.p0.h.i.p.d;
import b.a.p0.h.i.s.i;
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
    public Context f10494a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.p0.h.i.m.c f10495b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f10496c;

    /* renamed from: b.a.p0.h.i.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0550a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f10497e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.h.i.m.h f10498f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f10499g;

        /* renamed from: b.a.p0.h.i.p.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0551a extends ResponseCallback<AdResponseInfo> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public int f10500a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ RunnableC0550a f10501b;

            /* renamed from: b.a.p0.h.i.p.a$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class RunnableC0552a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ AdElementInfo f10502e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ C0551a f10503f;

                public RunnableC0552a(C0551a c0551a, AdElementInfo adElementInfo) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0551a, adElementInfo};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f10503f = c0551a;
                    this.f10502e = adElementInfo;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f10503f.f10501b.f10499g.f10495b == null) {
                        return;
                    }
                    this.f10503f.f10501b.f10499g.f10495b.c(this.f10502e);
                }
            }

            public C0551a(RunnableC0550a runnableC0550a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {runnableC0550a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f10501b = runnableC0550a;
                this.f10500a = 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: a */
            public void onSuccess(AdResponseInfo adResponseInfo, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, adResponseInfo, i2) == null) {
                    RunnableC0550a runnableC0550a = this.f10501b;
                    runnableC0550a.f10499g.j(runnableC0550a.f10497e, "requestSuccess", runnableC0550a.f10498f);
                    if (adResponseInfo == null) {
                        this.f10501b.f10499g.g("200000");
                    } else if (adResponseInfo.getAdInstanceList().size() <= 0) {
                        if (!this.f10501b.f10499g.f10496c) {
                            RunnableC0550a runnableC0550a2 = this.f10501b;
                            runnableC0550a2.f10499g.j(runnableC0550a2.f10497e, "requestNoAd", runnableC0550a2.f10498f);
                        }
                        if (this.f10500a == 1 && this.f10501b.f10497e.f10538i.c() == "video" && i.h()) {
                            RunnableC0550a runnableC0550a3 = this.f10501b;
                            runnableC0550a3.f10499g.h(runnableC0550a3.f10498f, runnableC0550a3.f10497e, this);
                            return;
                        }
                        this.f10500a = 0;
                        String errorCode = adResponseInfo.getErrorCode();
                        if (errorCode.equals("0")) {
                            errorCode = "201000";
                        }
                        this.f10501b.f10499g.g(errorCode);
                    } else {
                        b.a.p0.h.i.s.d.c(new RunnableC0552a(this, adResponseInfo.getPrimaryAdInstanceInfo()));
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
                        this.f10500a++;
                        if (!response.isSuccessful()) {
                            return null;
                        }
                        try {
                            String string = response.body().string();
                            if (!TextUtils.isEmpty(string)) {
                                if (this.f10501b.f10499g.f10496c) {
                                    return new AdResponseInfo(string, this.f10501b.f10499g.f10496c);
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
                    this.f10501b.f10499g.g("3010002");
                    RunnableC0550a runnableC0550a = this.f10501b;
                    runnableC0550a.f10499g.j(runnableC0550a.f10497e, "requestFail", runnableC0550a.f10498f);
                }
            }
        }

        public RunnableC0550a(a aVar, f fVar, b.a.p0.h.i.m.h hVar) {
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
            this.f10499g = aVar;
            this.f10497e = fVar;
            this.f10498f = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            f fVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (fVar = this.f10497e) == null || fVar.f10538i == null) {
                return;
            }
            C0551a c0551a = new C0551a(this);
            if (NetworkUtils.f(this.f10499g.f10494a)) {
                if (this.f10499g.f10496c) {
                    f fVar2 = this.f10497e;
                    if (fVar2 instanceof g) {
                        g gVar = (g) fVar2;
                        if (this.f10498f == null || gVar.i() == null) {
                            return;
                        }
                        this.f10498f.a(gVar.g(), gVar.i(), c0551a);
                        return;
                    }
                }
                this.f10499g.f10496c = false;
                String g2 = this.f10497e.g();
                b.a.p0.h.i.m.h hVar = this.f10498f;
                if (hVar != null) {
                    hVar.f(g2, c0551a);
                }
                this.f10499g.j(this.f10497e, "request", this.f10498f);
                return;
            }
            this.f10499g.g("3010003");
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f10504e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f10505f;

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
            this.f10505f = aVar;
            this.f10504e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f10505f.f10495b == null) {
                return;
            }
            this.f10505f.f10495b.a(this.f10504e);
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
        this.f10494a = context;
    }

    public final void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            b.a.p0.h.i.s.d.c(new b(this, str));
        }
    }

    public void h(b.a.p0.h.i.m.h hVar, f fVar, ResponseCallback<AdResponseInfo> responseCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hVar, fVar, responseCallback) == null) {
            if (NetworkUtils.f(this.f10494a)) {
                this.f10496c = true;
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
                bVar.o(fVar.f10538i.g());
                bVar.l(b.a.p0.h.i.s.h.i(this.f10494a));
                bVar.i(b.a.p0.h.i.s.h.h(this.f10494a));
                g gVar2 = new g(this.f10494a, bVar.h(), 5, 5);
                if (hVar == null || gVar2.i() == null) {
                    return;
                }
                hVar.a(gVar2.g(), gVar2.i(), responseCallback);
                return;
            }
            g("3010003");
        }
    }

    public void i(f fVar, b.a.p0.h.i.m.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, fVar, hVar) == null) {
            b.a.p0.h.i.s.c.d(new RunnableC0550a(this, fVar, hVar), "execAdRequest");
        }
    }

    public final void j(f fVar, String str, b.a.p0.h.i.m.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, fVar, str, hVar) == null) {
            b.a.p0.h.i.r.b.n(str, b.a.p0.h.i.r.b.a(fVar.f10538i.c(), fVar.f10538i.f(), fVar.f10538i.e(), fVar.f10538i.b(), false), hVar);
        }
    }

    public void k(b.a.p0.h.i.m.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.f10495b = cVar;
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
        this.f10496c = z;
    }
}
