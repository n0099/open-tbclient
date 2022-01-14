package c.a.r0.h.i.p;

import android.content.Context;
import android.text.TextUtils;
import c.a.r0.h.i.p.d;
import c.a.r0.h.i.s.i;
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
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.r0.h.i.m.c f10508b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f10509c;

    /* renamed from: c.a.r0.h.i.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class RunnableC0699a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f10510e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.h.i.m.h f10511f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f10512g;

        /* renamed from: c.a.r0.h.i.p.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0700a extends ResponseCallback<AdResponseInfo> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ RunnableC0699a f10513b;

            /* renamed from: c.a.r0.h.i.p.a$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class RunnableC0701a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ AdElementInfo f10514e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ C0700a f10515f;

                public RunnableC0701a(C0700a c0700a, AdElementInfo adElementInfo) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0700a, adElementInfo};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f10515f = c0700a;
                    this.f10514e = adElementInfo;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f10515f.f10513b.f10512g.f10508b == null) {
                        return;
                    }
                    this.f10515f.f10513b.f10512g.f10508b.c(this.f10514e);
                }
            }

            public C0700a(RunnableC0699a runnableC0699a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {runnableC0699a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f10513b = runnableC0699a;
                this.a = 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: a */
            public void onSuccess(AdResponseInfo adResponseInfo, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, adResponseInfo, i2) == null) {
                    RunnableC0699a runnableC0699a = this.f10513b;
                    runnableC0699a.f10512g.j(runnableC0699a.f10510e, "requestSuccess", runnableC0699a.f10511f);
                    if (adResponseInfo == null) {
                        this.f10513b.f10512g.g("200000");
                    } else if (adResponseInfo.getAdInstanceList().size() <= 0) {
                        if (!this.f10513b.f10512g.f10509c) {
                            RunnableC0699a runnableC0699a2 = this.f10513b;
                            runnableC0699a2.f10512g.j(runnableC0699a2.f10510e, "requestNoAd", runnableC0699a2.f10511f);
                        }
                        if (this.a == 1 && this.f10513b.f10510e.f10544i.c() == "video" && i.h()) {
                            RunnableC0699a runnableC0699a3 = this.f10513b;
                            runnableC0699a3.f10512g.h(runnableC0699a3.f10511f, runnableC0699a3.f10510e, this);
                            return;
                        }
                        this.a = 0;
                        String errorCode = adResponseInfo.getErrorCode();
                        if (errorCode.equals("0")) {
                            errorCode = "201000";
                        }
                        this.f10513b.f10512g.g(errorCode);
                    } else {
                        c.a.r0.h.i.s.d.c(new RunnableC0701a(this, adResponseInfo.getPrimaryAdInstanceInfo()));
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
                                if (this.f10513b.f10512g.f10509c) {
                                    return new AdResponseInfo(string, this.f10513b.f10512g.f10509c);
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
                    this.f10513b.f10512g.g("3010002");
                    RunnableC0699a runnableC0699a = this.f10513b;
                    runnableC0699a.f10512g.j(runnableC0699a.f10510e, "requestFail", runnableC0699a.f10511f);
                }
            }
        }

        public RunnableC0699a(a aVar, f fVar, c.a.r0.h.i.m.h hVar) {
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
            this.f10512g = aVar;
            this.f10510e = fVar;
            this.f10511f = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            f fVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (fVar = this.f10510e) == null || fVar.f10544i == null) {
                return;
            }
            C0700a c0700a = new C0700a(this);
            if (NetworkUtils.f(this.f10512g.a)) {
                if (this.f10512g.f10509c) {
                    f fVar2 = this.f10510e;
                    if (fVar2 instanceof g) {
                        g gVar = (g) fVar2;
                        if (this.f10511f == null || gVar.i() == null) {
                            return;
                        }
                        this.f10511f.a(gVar.g(), gVar.i(), c0700a);
                        return;
                    }
                }
                this.f10512g.f10509c = false;
                String g2 = this.f10510e.g();
                c.a.r0.h.i.m.h hVar = this.f10511f;
                if (hVar != null) {
                    hVar.f(g2, c0700a);
                }
                this.f10512g.j(this.f10510e, "request", this.f10511f);
                return;
            }
            this.f10512g.g("3010003");
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f10516e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f10517f;

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
            this.f10517f = aVar;
            this.f10516e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f10517f.f10508b == null) {
                return;
            }
            this.f10517f.f10508b.a(this.f10516e);
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
            c.a.r0.h.i.s.d.c(new b(this, str));
        }
    }

    public void h(c.a.r0.h.i.m.h hVar, f fVar, ResponseCallback<AdResponseInfo> responseCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hVar, fVar, responseCallback) == null) {
            if (NetworkUtils.f(this.a)) {
                this.f10509c = true;
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
                bVar.o(fVar.f10544i.g());
                bVar.l(c.a.r0.h.i.s.h.i(this.a));
                bVar.i(c.a.r0.h.i.s.h.h(this.a));
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

    public void i(f fVar, c.a.r0.h.i.m.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, fVar, hVar) == null) {
            c.a.r0.h.i.s.c.d(new RunnableC0699a(this, fVar, hVar), "execAdRequest");
        }
    }

    public final void j(f fVar, String str, c.a.r0.h.i.m.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, fVar, str, hVar) == null) {
            c.a.r0.h.i.r.b.n(str, c.a.r0.h.i.r.b.a(fVar.f10544i.c(), fVar.f10544i.f(), fVar.f10544i.e(), fVar.f10544i.b(), false), hVar);
        }
    }

    public void k(c.a.r0.h.i.m.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.f10508b = cVar;
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
        this.f10509c = z;
    }
}
