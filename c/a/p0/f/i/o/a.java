package c.a.p0.f.i.o;

import android.content.Context;
import android.text.TextUtils;
import c.a.p0.f.i.o.c;
import c.a.p0.f.i.r.h;
import c.a.p0.f.i.r.i;
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
    public Context f10623a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.p0.f.i.l.b f10624b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f10625c;

    /* renamed from: c.a.p0.f.i.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0529a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f10626e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.f.i.l.g f10627f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f10628g;

        /* renamed from: c.a.p0.f.i.o.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0530a extends ResponseCallback<AdResponseInfo> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public int f10629a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ RunnableC0529a f10630b;

            /* renamed from: c.a.p0.f.i.o.a$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class RunnableC0531a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ AdElementInfo f10631e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ C0530a f10632f;

                public RunnableC0531a(C0530a c0530a, AdElementInfo adElementInfo) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0530a, adElementInfo};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f10632f = c0530a;
                    this.f10631e = adElementInfo;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f10632f.f10630b.f10628g.f10624b == null) {
                        return;
                    }
                    this.f10632f.f10630b.f10628g.f10624b.c(this.f10631e);
                }
            }

            public C0530a(RunnableC0529a runnableC0529a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {runnableC0529a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f10630b = runnableC0529a;
                this.f10629a = 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: a */
            public void onSuccess(AdResponseInfo adResponseInfo, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, adResponseInfo, i2) == null) {
                    RunnableC0529a runnableC0529a = this.f10630b;
                    runnableC0529a.f10628g.j(runnableC0529a.f10626e, "requestSuccess", runnableC0529a.f10627f);
                    if (adResponseInfo == null) {
                        this.f10630b.f10628g.g("200000");
                    } else if (adResponseInfo.getAdInstanceList().size() <= 0) {
                        if (!this.f10630b.f10628g.f10625c) {
                            RunnableC0529a runnableC0529a2 = this.f10630b;
                            runnableC0529a2.f10628g.j(runnableC0529a2.f10626e, "requestNoAd", runnableC0529a2.f10627f);
                        }
                        if (this.f10629a == 1 && this.f10630b.f10626e.f10659i.c() == "video" && i.h()) {
                            RunnableC0529a runnableC0529a3 = this.f10630b;
                            runnableC0529a3.f10628g.h(runnableC0529a3.f10627f, runnableC0529a3.f10626e, this);
                            return;
                        }
                        this.f10629a = 0;
                        String errorCode = adResponseInfo.getErrorCode();
                        if (errorCode.equals("0")) {
                            errorCode = "201000";
                        }
                        this.f10630b.f10628g.g(errorCode);
                    } else {
                        c.a.p0.f.i.r.d.c(new RunnableC0531a(this, adResponseInfo.getPrimaryAdInstanceInfo()));
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
                        this.f10629a++;
                        if (!response.isSuccessful()) {
                            return null;
                        }
                        try {
                            String string = response.body().string();
                            if (!TextUtils.isEmpty(string)) {
                                if (this.f10630b.f10628g.f10625c) {
                                    return new AdResponseInfo(string, this.f10630b.f10628g.f10625c);
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
                    this.f10630b.f10628g.g("3010002");
                    RunnableC0529a runnableC0529a = this.f10630b;
                    runnableC0529a.f10628g.j(runnableC0529a.f10626e, "requestFail", runnableC0529a.f10627f);
                }
            }
        }

        public RunnableC0529a(a aVar, e eVar, c.a.p0.f.i.l.g gVar) {
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
            this.f10628g = aVar;
            this.f10626e = eVar;
            this.f10627f = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e eVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (eVar = this.f10626e) == null || eVar.f10659i == null) {
                return;
            }
            C0530a c0530a = new C0530a(this);
            if (NetworkUtils.f(this.f10628g.f10623a)) {
                if (this.f10628g.f10625c) {
                    e eVar2 = this.f10626e;
                    if (eVar2 instanceof f) {
                        f fVar = (f) eVar2;
                        if (this.f10627f == null || fVar.i() == null) {
                            return;
                        }
                        this.f10627f.a(fVar.g(), fVar.i(), c0530a);
                        return;
                    }
                }
                this.f10628g.f10625c = false;
                String g2 = this.f10626e.g();
                c.a.p0.f.i.l.g gVar = this.f10627f;
                if (gVar != null) {
                    gVar.e(g2, c0530a);
                }
                this.f10628g.j(this.f10626e, "request", this.f10627f);
                return;
            }
            this.f10628g.g("3010003");
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f10633e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f10634f;

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
            this.f10634f = aVar;
            this.f10633e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f10634f.f10624b == null) {
                return;
            }
            this.f10634f.f10624b.a(this.f10633e);
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
        this.f10623a = context;
    }

    public final void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            c.a.p0.f.i.r.d.c(new b(this, str));
        }
    }

    public void h(c.a.p0.f.i.l.g gVar, e eVar, ResponseCallback<AdResponseInfo> responseCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar, eVar, responseCallback) == null) {
            if (NetworkUtils.f(this.f10623a)) {
                this.f10625c = true;
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
                bVar.o(eVar.f10659i.g());
                bVar.l(h.i(this.f10623a));
                bVar.i(h.h(this.f10623a));
                f fVar2 = new f(this.f10623a, bVar.h(), 5, 5);
                if (gVar == null || fVar2.i() == null) {
                    return;
                }
                gVar.a(fVar2.g(), fVar2.i(), responseCallback);
                return;
            }
            g("3010003");
        }
    }

    public void i(e eVar, c.a.p0.f.i.l.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, eVar, gVar) == null) {
            c.a.p0.f.i.r.c.d(new RunnableC0529a(this, eVar, gVar), "execAdRequest");
        }
    }

    public final void j(e eVar, String str, c.a.p0.f.i.l.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, eVar, str, gVar) == null) {
            c.a.p0.f.i.q.b.n(str, c.a.p0.f.i.q.b.a(eVar.f10659i.c(), eVar.f10659i.f(), eVar.f10659i.e(), eVar.f10659i.b(), false), gVar);
        }
    }

    public void k(c.a.p0.f.i.l.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f10624b = bVar;
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
        this.f10625c = z;
    }
}
