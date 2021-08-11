package c.a.n0.f.i.o;

import android.content.Context;
import android.text.TextUtils;
import c.a.n0.f.i.o.c;
import c.a.n0.f.i.r.h;
import c.a.n0.f.i.r.i;
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
    public Context f10341a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.n0.f.i.l.b f10342b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f10343c;

    /* renamed from: c.a.n0.f.i.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0519a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f10344e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.f.i.l.g f10345f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f10346g;

        /* renamed from: c.a.n0.f.i.o.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0520a extends ResponseCallback<AdResponseInfo> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public int f10347a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ RunnableC0519a f10348b;

            /* renamed from: c.a.n0.f.i.o.a$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class RunnableC0521a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ AdElementInfo f10349e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ C0520a f10350f;

                public RunnableC0521a(C0520a c0520a, AdElementInfo adElementInfo) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0520a, adElementInfo};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f10350f = c0520a;
                    this.f10349e = adElementInfo;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f10350f.f10348b.f10346g.f10342b == null) {
                        return;
                    }
                    this.f10350f.f10348b.f10346g.f10342b.c(this.f10349e);
                }
            }

            public C0520a(RunnableC0519a runnableC0519a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {runnableC0519a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f10348b = runnableC0519a;
                this.f10347a = 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: a */
            public void onSuccess(AdResponseInfo adResponseInfo, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, adResponseInfo, i2) == null) {
                    RunnableC0519a runnableC0519a = this.f10348b;
                    runnableC0519a.f10346g.j(runnableC0519a.f10344e, "requestSuccess", runnableC0519a.f10345f);
                    if (adResponseInfo == null) {
                        this.f10348b.f10346g.g("200000");
                    } else if (adResponseInfo.getAdInstanceList().size() <= 0) {
                        if (!this.f10348b.f10346g.f10343c) {
                            RunnableC0519a runnableC0519a2 = this.f10348b;
                            runnableC0519a2.f10346g.j(runnableC0519a2.f10344e, "requestNoAd", runnableC0519a2.f10345f);
                        }
                        if (this.f10347a == 1 && this.f10348b.f10344e.f10377i.c() == "video" && i.h()) {
                            RunnableC0519a runnableC0519a3 = this.f10348b;
                            runnableC0519a3.f10346g.h(runnableC0519a3.f10345f, runnableC0519a3.f10344e, this);
                            return;
                        }
                        this.f10347a = 0;
                        String errorCode = adResponseInfo.getErrorCode();
                        if (errorCode.equals("0")) {
                            errorCode = "201000";
                        }
                        this.f10348b.f10346g.g(errorCode);
                    } else {
                        c.a.n0.f.i.r.d.c(new RunnableC0521a(this, adResponseInfo.getPrimaryAdInstanceInfo()));
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
                        this.f10347a++;
                        if (!response.isSuccessful()) {
                            return null;
                        }
                        try {
                            String string = response.body().string();
                            if (!TextUtils.isEmpty(string)) {
                                if (this.f10348b.f10346g.f10343c) {
                                    return new AdResponseInfo(string, this.f10348b.f10346g.f10343c);
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
                    this.f10348b.f10346g.g("3010002");
                    RunnableC0519a runnableC0519a = this.f10348b;
                    runnableC0519a.f10346g.j(runnableC0519a.f10344e, "requestFail", runnableC0519a.f10345f);
                }
            }
        }

        public RunnableC0519a(a aVar, e eVar, c.a.n0.f.i.l.g gVar) {
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
            this.f10346g = aVar;
            this.f10344e = eVar;
            this.f10345f = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e eVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (eVar = this.f10344e) == null || eVar.f10377i == null) {
                return;
            }
            C0520a c0520a = new C0520a(this);
            if (NetworkUtils.f(this.f10346g.f10341a)) {
                if (this.f10346g.f10343c) {
                    e eVar2 = this.f10344e;
                    if (eVar2 instanceof f) {
                        f fVar = (f) eVar2;
                        if (this.f10345f == null || fVar.i() == null) {
                            return;
                        }
                        this.f10345f.a(fVar.g(), fVar.i(), c0520a);
                        return;
                    }
                }
                this.f10346g.f10343c = false;
                String g2 = this.f10344e.g();
                c.a.n0.f.i.l.g gVar = this.f10345f;
                if (gVar != null) {
                    gVar.e(g2, c0520a);
                }
                this.f10346g.j(this.f10344e, "request", this.f10345f);
                return;
            }
            this.f10346g.g("3010003");
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f10351e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f10352f;

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
            this.f10352f = aVar;
            this.f10351e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f10352f.f10342b == null) {
                return;
            }
            this.f10352f.f10342b.a(this.f10351e);
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
        this.f10341a = context;
    }

    public final void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            c.a.n0.f.i.r.d.c(new b(this, str));
        }
    }

    public void h(c.a.n0.f.i.l.g gVar, e eVar, ResponseCallback<AdResponseInfo> responseCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar, eVar, responseCallback) == null) {
            if (NetworkUtils.f(this.f10341a)) {
                this.f10343c = true;
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
                bVar.o(eVar.f10377i.g());
                bVar.l(h.i(this.f10341a));
                bVar.i(h.h(this.f10341a));
                f fVar2 = new f(this.f10341a, bVar.h(), 5, 5);
                if (gVar == null || fVar2.i() == null) {
                    return;
                }
                gVar.a(fVar2.g(), fVar2.i(), responseCallback);
                return;
            }
            g("3010003");
        }
    }

    public void i(e eVar, c.a.n0.f.i.l.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, eVar, gVar) == null) {
            c.a.n0.f.i.r.c.d(new RunnableC0519a(this, eVar, gVar), "execAdRequest");
        }
    }

    public final void j(e eVar, String str, c.a.n0.f.i.l.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, eVar, str, gVar) == null) {
            c.a.n0.f.i.q.b.n(str, c.a.n0.f.i.q.b.a(eVar.f10377i.c(), eVar.f10377i.f(), eVar.f10377i.e(), eVar.f10377i.b(), false), gVar);
        }
    }

    public void k(c.a.n0.f.i.l.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f10342b = bVar;
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
        this.f10343c = z;
    }
}
