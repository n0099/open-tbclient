package c.a.p0.a.v1.f.o0;

import android.content.Context;
import android.text.TextUtils;
import c.a.p0.a.p2.q0;
import c.a.p0.a.p2.w;
import c.a.p0.a.v1.f.o0.g;
import c.a.p0.a.v1.f.z;
import c.a.p0.a.x.g.g;
import c.a.p0.a.x.t.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.log.bean.FetchLog;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class k extends z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements g.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.w0.f f8111b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.x.g.g f8112c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.c1.b f8113d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f8114e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f8115f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f8116g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f8117h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ k f8118i;

        /* renamed from: c.a.p0.a.v1.f.o0.k$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0508a implements a.f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a.e a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ JSONObject f8119b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ a f8120c;

            public C0508a(a aVar, a.e eVar, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, eVar, jSONObject};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f8120c = aVar;
                this.a = eVar;
                this.f8119b = jSONObject;
            }

            @Override // c.a.p0.a.x.t.a.f
            public void onReady() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.p0.a.k1.i.e(this.a, this.f8120c.a);
                    c.a.p0.a.f.e.b bVar = this.a.a;
                    a aVar = this.f8120c;
                    c.a.p0.a.v1.f.o0.a.e(bVar, aVar.f8113d, aVar.a);
                    c.a.p0.a.k1.i.c(5, this.f8120c.a);
                    a aVar2 = this.f8120c;
                    aVar2.f8118i.n(aVar2.f8112c, aVar2.f8113d, aVar2.a);
                    a aVar3 = this.f8120c;
                    UnitedSchemeUtility.callCallback(aVar3.f8114e, aVar3.f8115f, UnitedSchemeUtility.wrapCallbackParams(this.f8119b, 0));
                }
            }
        }

        public a(k kVar, String str, c.a.p0.a.w0.f fVar, c.a.p0.a.x.g.g gVar, c.a.p0.a.c1.b bVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, str, fVar, gVar, bVar, callbackHandler, unitedSchemeEntity, context, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8118i = kVar;
            this.a = str;
            this.f8111b = fVar;
            this.f8112c = gVar;
            this.f8113d = bVar;
            this.f8114e = callbackHandler;
            this.f8115f = unitedSchemeEntity;
            this.f8116g = context;
            this.f8117h = str2;
        }

        @Override // c.a.p0.a.v1.f.o0.g.e
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                c.a.p0.a.k1.i.d(this.a);
                this.f8111b.o();
                c.a.p0.a.x.g.f l = this.f8112c.l();
                if (l != null && !TextUtils.isEmpty(l.q3(this.f8113d.f4645h))) {
                    JSONObject c2 = c.a.p0.a.v1.f.o0.a.c(l.q3(this.f8113d.f4645h));
                    c.a.p0.a.k1.i.c(4, this.a);
                    this.f8118i.n(this.f8112c, this.f8113d, this.a);
                    UnitedSchemeUtility.callCallback(this.f8114e, this.f8115f, UnitedSchemeUtility.wrapCallbackParams(c2, 0));
                    return;
                }
                a.e f2 = c.a.p0.a.x.t.a.f(this.f8111b.getActivity(), c.a.p0.a.x.t.f.a.c(this.f8113d.f4645h));
                JSONObject c3 = c.a.p0.a.v1.f.o0.a.c(str);
                HybridUbcFlow q = c.a.p0.a.k1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, this.a);
                q.F(new UbcFlowEvent("na_pre_load_slave_check"));
                q.D("preload", f2.f8859b ? "1" : "0");
                c.a.p0.a.x.t.a.q(f2, new C0508a(this, f2, c3));
            }
        }

        @Override // c.a.p0.a.v1.f.o0.g.e
        public void c(int i2, c.a.p0.a.k2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, aVar) == null) {
                this.f8111b.o();
                if (z.f8176b) {
                    Context context = this.f8116g;
                    c.a.p0.a.s1.b.f.e.g(context, this.f8116g.getString(R.string.aiapps_open_pages_failed) + i2).G();
                }
                if (!TextUtils.isEmpty(this.f8117h)) {
                    c.a.p0.a.v1.f.o0.a.j(this.f8115f, this.f8114e, this.f8117h);
                }
                c.a.p0.a.d2.i.j(this.f8113d, aVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.x.g.g f8121e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.c1.b f8122f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f8123g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ k f8124h;

        public b(k kVar, c.a.p0.a.x.g.g gVar, c.a.p0.a.c1.b bVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, gVar, bVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8124h = kVar;
            this.f8121e = gVar;
            this.f8122f = bVar;
            this.f8123g = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8124h.m(this.f8121e, this.f8122f, this.f8123g);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(c.a.p0.a.v1.e eVar) {
        super(eVar, "/swanAPI/switchTab");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.p0.a.v1.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.t1.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (z.f8176b) {
                String str = "SwitchTabAction#handle entity: " + unitedSchemeEntity.toString();
            }
            String uuid = UUID.randomUUID().toString();
            c.a.p0.a.k1.i.b(uuid);
            String o = c.a.p0.a.v1.f.o0.a.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                c.a.p0.a.u.d.c("switchTab", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            String optString = w.d(unitedSchemeEntity.getParam("params")).optString("cb");
            c.a.p0.a.w0.f U = c.a.p0.a.w0.f.U();
            c.a.p0.a.x.g.g V = U.V();
            if (V == null) {
                c.a.p0.a.u.d.c("switchTab", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            c.a.p0.a.c1.b e2 = c.a.p0.a.c1.b.e(o, U.z());
            e2.f4646i = "4";
            e2.f4647j = uuid;
            c.a.p0.a.d2.i.g(e2);
            if (!q0.c(U.s(), e2)) {
                c.a.p0.a.u.d.c("switchTab", "tab params error");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                c.a.p0.a.d2.i.i(e2);
                return false;
            }
            String n = c.a.p0.a.v1.f.o0.a.n(unitedSchemeEntity, "params", FetchLog.START_TIME);
            if (!TextUtils.isEmpty(n)) {
                HybridUbcFlow q = c.a.p0.a.k1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n).longValue());
                q.F(ubcFlowEvent);
            }
            U.a();
            g.g(eVar, e2, "", new a(this, uuid, U, V, e2, callbackHandler, unitedSchemeEntity, context, optString), uuid);
            c.a.p0.a.u.d.i("switchTab", "create and load page");
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void m(c.a.p0.a.x.g.g gVar, c.a.p0.a.c1.b bVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar, bVar, str) == null) {
            c.a.p0.a.x.g.f.M3(q0.n());
            g.b i2 = gVar.i("switchTab");
            i2.n(0, 0);
            i2.i();
            i2.q(bVar).b();
            c.a.p0.a.k1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).F(new UbcFlowEvent("na_push_page_end"));
            c.a.p0.a.k1.i.a(str, bVar);
        }
    }

    public final void n(c.a.p0.a.x.g.g gVar, c.a.p0.a.c1.b bVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, gVar, bVar, str) == null) {
            if (q0.O()) {
                m(gVar, bVar, str);
            } else {
                q0.a0(new b(this, gVar, bVar, str));
            }
        }
    }
}
