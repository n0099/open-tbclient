package b.a.p0.f.i.o;

import android.content.Context;
import android.text.TextUtils;
import b.a.p0.f.i.o.c;
import b.a.p0.f.i.r.h;
import b.a.p0.f.i.r.i;
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
    public Context f9836a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.p0.f.i.l.b f9837b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f9838c;

    /* renamed from: b.a.p0.f.i.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0524a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f9839e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.f.i.l.g f9840f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f9841g;

        /* renamed from: b.a.p0.f.i.o.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0525a extends ResponseCallback<AdResponseInfo> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public int f9842a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ RunnableC0524a f9843b;

            /* renamed from: b.a.p0.f.i.o.a$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class RunnableC0526a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ AdElementInfo f9844e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ C0525a f9845f;

                public RunnableC0526a(C0525a c0525a, AdElementInfo adElementInfo) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0525a, adElementInfo};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f9845f = c0525a;
                    this.f9844e = adElementInfo;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f9845f.f9843b.f9841g.f9837b == null) {
                        return;
                    }
                    this.f9845f.f9843b.f9841g.f9837b.c(this.f9844e);
                }
            }

            public C0525a(RunnableC0524a runnableC0524a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {runnableC0524a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f9843b = runnableC0524a;
                this.f9842a = 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: a */
            public void onSuccess(AdResponseInfo adResponseInfo, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, adResponseInfo, i2) == null) {
                    RunnableC0524a runnableC0524a = this.f9843b;
                    runnableC0524a.f9841g.j(runnableC0524a.f9839e, "requestSuccess", runnableC0524a.f9840f);
                    if (adResponseInfo == null) {
                        this.f9843b.f9841g.g("200000");
                    } else if (adResponseInfo.getAdInstanceList().size() <= 0) {
                        if (!this.f9843b.f9841g.f9838c) {
                            RunnableC0524a runnableC0524a2 = this.f9843b;
                            runnableC0524a2.f9841g.j(runnableC0524a2.f9839e, "requestNoAd", runnableC0524a2.f9840f);
                        }
                        if (this.f9842a == 1 && this.f9843b.f9839e.f9872i.c() == "video" && i.h()) {
                            RunnableC0524a runnableC0524a3 = this.f9843b;
                            runnableC0524a3.f9841g.h(runnableC0524a3.f9840f, runnableC0524a3.f9839e, this);
                            return;
                        }
                        this.f9842a = 0;
                        String errorCode = adResponseInfo.getErrorCode();
                        if (errorCode.equals("0")) {
                            errorCode = "201000";
                        }
                        this.f9843b.f9841g.g(errorCode);
                    } else {
                        b.a.p0.f.i.r.d.c(new RunnableC0526a(this, adResponseInfo.getPrimaryAdInstanceInfo()));
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
                        this.f9842a++;
                        if (!response.isSuccessful()) {
                            return null;
                        }
                        try {
                            String string = response.body().string();
                            if (!TextUtils.isEmpty(string)) {
                                if (this.f9843b.f9841g.f9838c) {
                                    return new AdResponseInfo(string, this.f9843b.f9841g.f9838c);
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
                    this.f9843b.f9841g.g("3010002");
                    RunnableC0524a runnableC0524a = this.f9843b;
                    runnableC0524a.f9841g.j(runnableC0524a.f9839e, "requestFail", runnableC0524a.f9840f);
                }
            }
        }

        public RunnableC0524a(a aVar, e eVar, b.a.p0.f.i.l.g gVar) {
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
            this.f9841g = aVar;
            this.f9839e = eVar;
            this.f9840f = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e eVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (eVar = this.f9839e) == null || eVar.f9872i == null) {
                return;
            }
            C0525a c0525a = new C0525a(this);
            if (NetworkUtils.f(this.f9841g.f9836a)) {
                if (this.f9841g.f9838c) {
                    e eVar2 = this.f9839e;
                    if (eVar2 instanceof f) {
                        f fVar = (f) eVar2;
                        if (this.f9840f == null || fVar.i() == null) {
                            return;
                        }
                        this.f9840f.a(fVar.g(), fVar.i(), c0525a);
                        return;
                    }
                }
                this.f9841g.f9838c = false;
                String g2 = this.f9839e.g();
                b.a.p0.f.i.l.g gVar = this.f9840f;
                if (gVar != null) {
                    gVar.e(g2, c0525a);
                }
                this.f9841g.j(this.f9839e, "request", this.f9840f);
                return;
            }
            this.f9841g.g("3010003");
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f9846e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f9847f;

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
            this.f9847f = aVar;
            this.f9846e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f9847f.f9837b == null) {
                return;
            }
            this.f9847f.f9837b.a(this.f9846e);
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
        this.f9836a = context;
    }

    public final void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            b.a.p0.f.i.r.d.c(new b(this, str));
        }
    }

    public void h(b.a.p0.f.i.l.g gVar, e eVar, ResponseCallback<AdResponseInfo> responseCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar, eVar, responseCallback) == null) {
            if (NetworkUtils.f(this.f9836a)) {
                this.f9838c = true;
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
                bVar.o(eVar.f9872i.g());
                bVar.l(h.i(this.f9836a));
                bVar.i(h.h(this.f9836a));
                f fVar2 = new f(this.f9836a, bVar.h(), 5, 5);
                if (gVar == null || fVar2.i() == null) {
                    return;
                }
                gVar.a(fVar2.g(), fVar2.i(), responseCallback);
                return;
            }
            g("3010003");
        }
    }

    public void i(e eVar, b.a.p0.f.i.l.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, eVar, gVar) == null) {
            b.a.p0.f.i.r.c.d(new RunnableC0524a(this, eVar, gVar), "execAdRequest");
        }
    }

    public final void j(e eVar, String str, b.a.p0.f.i.l.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, eVar, str, gVar) == null) {
            b.a.p0.f.i.q.b.n(str, b.a.p0.f.i.q.b.a(eVar.f9872i.c(), eVar.f9872i.f(), eVar.f9872i.e(), eVar.f9872i.b(), false), gVar);
        }
    }

    public void k(b.a.p0.f.i.l.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f9837b = bVar;
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
        this.f9838c = z;
    }
}
