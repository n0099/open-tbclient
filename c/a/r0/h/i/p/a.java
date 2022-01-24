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
    public c.a.r0.h.i.m.c f10650b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f10651c;

    /* renamed from: c.a.r0.h.i.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class RunnableC0708a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f10652e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.h.i.m.h f10653f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f10654g;

        /* renamed from: c.a.r0.h.i.p.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0709a extends ResponseCallback<AdResponseInfo> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ RunnableC0708a f10655b;

            /* renamed from: c.a.r0.h.i.p.a$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class RunnableC0710a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ AdElementInfo f10656e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ C0709a f10657f;

                public RunnableC0710a(C0709a c0709a, AdElementInfo adElementInfo) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0709a, adElementInfo};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f10657f = c0709a;
                    this.f10656e = adElementInfo;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f10657f.f10655b.f10654g.f10650b == null) {
                        return;
                    }
                    this.f10657f.f10655b.f10654g.f10650b.c(this.f10656e);
                }
            }

            public C0709a(RunnableC0708a runnableC0708a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {runnableC0708a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f10655b = runnableC0708a;
                this.a = 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: a */
            public void onSuccess(AdResponseInfo adResponseInfo, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, adResponseInfo, i2) == null) {
                    RunnableC0708a runnableC0708a = this.f10655b;
                    runnableC0708a.f10654g.j(runnableC0708a.f10652e, "requestSuccess", runnableC0708a.f10653f);
                    if (adResponseInfo == null) {
                        this.f10655b.f10654g.g("200000");
                    } else if (adResponseInfo.getAdInstanceList().size() <= 0) {
                        if (!this.f10655b.f10654g.f10651c) {
                            RunnableC0708a runnableC0708a2 = this.f10655b;
                            runnableC0708a2.f10654g.j(runnableC0708a2.f10652e, "requestNoAd", runnableC0708a2.f10653f);
                        }
                        if (this.a == 1 && this.f10655b.f10652e.f10686i.c() == "video" && i.h()) {
                            RunnableC0708a runnableC0708a3 = this.f10655b;
                            runnableC0708a3.f10654g.h(runnableC0708a3.f10653f, runnableC0708a3.f10652e, this);
                            return;
                        }
                        this.a = 0;
                        String errorCode = adResponseInfo.getErrorCode();
                        if (errorCode.equals("0")) {
                            errorCode = "201000";
                        }
                        this.f10655b.f10654g.g(errorCode);
                    } else {
                        c.a.r0.h.i.s.d.c(new RunnableC0710a(this, adResponseInfo.getPrimaryAdInstanceInfo()));
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
                                if (this.f10655b.f10654g.f10651c) {
                                    return new AdResponseInfo(string, this.f10655b.f10654g.f10651c);
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
                    this.f10655b.f10654g.g("3010002");
                    RunnableC0708a runnableC0708a = this.f10655b;
                    runnableC0708a.f10654g.j(runnableC0708a.f10652e, "requestFail", runnableC0708a.f10653f);
                }
            }
        }

        public RunnableC0708a(a aVar, f fVar, c.a.r0.h.i.m.h hVar) {
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
            this.f10654g = aVar;
            this.f10652e = fVar;
            this.f10653f = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            f fVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (fVar = this.f10652e) == null || fVar.f10686i == null) {
                return;
            }
            C0709a c0709a = new C0709a(this);
            if (NetworkUtils.f(this.f10654g.a)) {
                if (this.f10654g.f10651c) {
                    f fVar2 = this.f10652e;
                    if (fVar2 instanceof g) {
                        g gVar = (g) fVar2;
                        if (this.f10653f == null || gVar.i() == null) {
                            return;
                        }
                        this.f10653f.a(gVar.g(), gVar.i(), c0709a);
                        return;
                    }
                }
                this.f10654g.f10651c = false;
                String g2 = this.f10652e.g();
                c.a.r0.h.i.m.h hVar = this.f10653f;
                if (hVar != null) {
                    hVar.f(g2, c0709a);
                }
                this.f10654g.j(this.f10652e, "request", this.f10653f);
                return;
            }
            this.f10654g.g("3010003");
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f10658e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f10659f;

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
            this.f10659f = aVar;
            this.f10658e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f10659f.f10650b == null) {
                return;
            }
            this.f10659f.f10650b.a(this.f10658e);
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
                this.f10651c = true;
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
                bVar.o(fVar.f10686i.g());
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
            c.a.r0.h.i.s.c.d(new RunnableC0708a(this, fVar, hVar), "execAdRequest");
        }
    }

    public final void j(f fVar, String str, c.a.r0.h.i.m.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, fVar, str, hVar) == null) {
            c.a.r0.h.i.r.b.n(str, c.a.r0.h.i.r.b.a(fVar.f10686i.c(), fVar.f10686i.f(), fVar.f10686i.e(), fVar.f10686i.b(), false), hVar);
        }
    }

    public void k(c.a.r0.h.i.m.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.f10650b = cVar;
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
        this.f10651c = z;
    }
}
