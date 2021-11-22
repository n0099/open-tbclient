package b.a.p0.a.f2.f.o0;

import android.content.Context;
import android.text.TextUtils;
import b.a.p0.a.f2.f.o0.g;
import b.a.p0.a.f2.f.z;
import b.a.p0.a.h0.g.g;
import b.a.p0.a.h0.t.a;
import b.a.p0.a.z2.q0;
import b.a.p0.a.z2.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
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

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f5162a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.g1.f f5163b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.h0.g.g f5164c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.m1.b f5165d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f5166e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f5167f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f5168g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f5169h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ k f5170i;

        /* renamed from: b.a.p0.a.f2.f.o0.k$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0185a implements a.f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a.e f5171a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ JSONObject f5172b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ a f5173c;

            public C0185a(a aVar, a.e eVar, JSONObject jSONObject) {
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
                this.f5173c = aVar;
                this.f5171a = eVar;
                this.f5172b = jSONObject;
            }

            @Override // b.a.p0.a.h0.t.a.f
            public void onReady() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    b.a.p0.a.u1.i.e(this.f5171a, this.f5173c.f5162a);
                    b.a.p0.a.p.e.b bVar = this.f5171a.f6108a;
                    a aVar = this.f5173c;
                    b.a.p0.a.f2.f.o0.a.e(bVar, aVar.f5165d, aVar.f5162a);
                    b.a.p0.a.u1.i.c(5, this.f5173c.f5162a);
                    a aVar2 = this.f5173c;
                    aVar2.f5170i.n(aVar2.f5164c, aVar2.f5165d, aVar2.f5162a);
                    a aVar3 = this.f5173c;
                    UnitedSchemeUtility.callCallback(aVar3.f5166e, aVar3.f5167f, UnitedSchemeUtility.wrapCallbackParams(this.f5172b, 0));
                }
            }
        }

        public a(k kVar, String str, b.a.p0.a.g1.f fVar, b.a.p0.a.h0.g.g gVar, b.a.p0.a.m1.b bVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, String str2) {
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
            this.f5170i = kVar;
            this.f5162a = str;
            this.f5163b = fVar;
            this.f5164c = gVar;
            this.f5165d = bVar;
            this.f5166e = callbackHandler;
            this.f5167f = unitedSchemeEntity;
            this.f5168g = context;
            this.f5169h = str2;
        }

        @Override // b.a.p0.a.f2.f.o0.g.e
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                b.a.p0.a.u1.i.d(this.f5162a);
                this.f5163b.n();
                b.a.p0.a.h0.g.f l = this.f5164c.l();
                if (l != null && !TextUtils.isEmpty(l.t3(this.f5165d.f7017h))) {
                    JSONObject c2 = b.a.p0.a.f2.f.o0.a.c(l.t3(this.f5165d.f7017h));
                    b.a.p0.a.u1.i.c(4, this.f5162a);
                    this.f5170i.n(this.f5164c, this.f5165d, this.f5162a);
                    UnitedSchemeUtility.callCallback(this.f5166e, this.f5167f, UnitedSchemeUtility.wrapCallbackParams(c2, 0));
                    return;
                }
                a.e f2 = b.a.p0.a.h0.t.a.f(this.f5163b.getActivity(), b.a.p0.a.h0.t.f.a.c(this.f5165d.f7017h));
                JSONObject c3 = b.a.p0.a.f2.f.o0.a.c(str);
                HybridUbcFlow q = b.a.p0.a.u1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, this.f5162a);
                q.F(new UbcFlowEvent("na_pre_load_slave_check"));
                q.D("preload", f2.f6109b ? "1" : "0");
                b.a.p0.a.h0.t.a.q(f2, new C0185a(this, f2, c3));
            }
        }

        @Override // b.a.p0.a.f2.f.o0.g.e
        public void b(int i2, b.a.p0.a.u2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, aVar) == null) {
                this.f5163b.n();
                if (z.f5228b) {
                    Context context = this.f5168g;
                    b.a.p0.a.c2.b.f.e.g(context, this.f5168g.getString(b.a.p0.a.h.aiapps_open_pages_failed) + i2).G();
                }
                if (!TextUtils.isEmpty(this.f5169h)) {
                    b.a.p0.a.f2.f.o0.a.j(this.f5167f, this.f5166e, this.f5169h);
                }
                b.a.p0.a.n2.i.j(this.f5165d, aVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.h0.g.g f5174e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.m1.b f5175f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f5176g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ k f5177h;

        public b(k kVar, b.a.p0.a.h0.g.g gVar, b.a.p0.a.m1.b bVar, String str) {
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
            this.f5177h = kVar;
            this.f5174e = gVar;
            this.f5175f = bVar;
            this.f5176g = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5177h.m(this.f5174e, this.f5175f, this.f5176g);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(b.a.p0.a.f2.e eVar) {
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

    @Override // b.a.p0.a.f2.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b.a.p0.a.d2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (z.f5228b) {
                String str = "SwitchTabAction#handle entity: " + unitedSchemeEntity.toString();
            }
            String uuid = UUID.randomUUID().toString();
            b.a.p0.a.u1.i.b(uuid);
            String o = b.a.p0.a.f2.f.o0.a.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                b.a.p0.a.e0.d.c("switchTab", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            String optString = w.d(unitedSchemeEntity.getParam("params")).optString("cb");
            b.a.p0.a.g1.f U = b.a.p0.a.g1.f.U();
            b.a.p0.a.h0.g.g V = U.V();
            if (V == null) {
                b.a.p0.a.e0.d.c("switchTab", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            b.a.p0.a.m1.b e2 = b.a.p0.a.m1.b.e(o, U.z());
            e2.f7018i = "4";
            e2.j = uuid;
            b.a.p0.a.n2.i.g(e2);
            if (!q0.c(U.r(), e2)) {
                b.a.p0.a.e0.d.c("switchTab", "tab params error");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                b.a.p0.a.n2.i.i(e2);
                return false;
            }
            String n = b.a.p0.a.f2.f.o0.a.n(unitedSchemeEntity, "params", "startTime");
            if (!TextUtils.isEmpty(n)) {
                HybridUbcFlow q = b.a.p0.a.u1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n).longValue());
                q.F(ubcFlowEvent);
            }
            U.t();
            g.g(eVar, e2, "", new a(this, uuid, U, V, e2, callbackHandler, unitedSchemeEntity, context, optString), uuid);
            b.a.p0.a.e0.d.i("switchTab", "create and load page");
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void m(b.a.p0.a.h0.g.g gVar, b.a.p0.a.m1.b bVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar, bVar, str) == null) {
            b.a.p0.a.h0.g.f.P3(q0.n());
            g.b i2 = gVar.i("switchTab");
            i2.n(0, 0);
            i2.i();
            i2.q(bVar).b();
            b.a.p0.a.u1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).F(new UbcFlowEvent("na_push_page_end"));
            b.a.p0.a.u1.i.a(str, bVar);
        }
    }

    public final void n(b.a.p0.a.h0.g.g gVar, b.a.p0.a.m1.b bVar, String str) {
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
