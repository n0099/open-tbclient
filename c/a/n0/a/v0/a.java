package c.a.n0.a.v0;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.d2.n;
import c.a.n0.a.p2.q0;
import c.a.n0.a.q0.d;
import c.a.n0.a.v0.e.b;
import c.a.n0.a.v0.e.c;
import c.a.n0.a.v1.f.z;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.n0.a.v0.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0478a implements c.a.n0.q.e.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JSONObject f6573b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f6574c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f6575d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f6576e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f6577f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6578g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.t1.e f6579h;
        public final /* synthetic */ a i;

        public C0478a(a aVar, String str, JSONObject jSONObject, String str2, String str3, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.n0.a.t1.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, jSONObject, str2, str3, context, unitedSchemeEntity, callbackHandler, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = aVar;
            this.a = str;
            this.f6573b = jSONObject;
            this.f6574c = str2;
            this.f6575d = str3;
            this.f6576e = context;
            this.f6577f = unitedSchemeEntity;
            this.f6578g = callbackHandler;
            this.f6579h = eVar;
        }

        @Override // c.a.n0.q.e.c
        public void a(@Nullable Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, map) == null) || map == null) {
                return;
            }
            String str = map.get(this.a);
            if (TextUtils.isEmpty(str)) {
                str = this.a;
            }
            this.i.o(this.f6573b, this.f6574c, this.f6575d, this.f6576e, this.f6577f, str, this.f6578g, this.f6579h);
        }

        @Override // c.a.n0.q.e.c
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
                if (z.f6924b) {
                    Log.e("LaunchAction", "getOpenBundleId", exc);
                }
                this.f6577f.result = UnitedSchemeUtility.wrapCallbackParams(201);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements d.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f6580b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f6581c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6582d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f6583e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f6584f;

        public b(a aVar, c.a aVar2, String str, String str2, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2, str, str2, callbackHandler, unitedSchemeEntity, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar2;
            this.f6580b = str;
            this.f6581c = str2;
            this.f6582d = callbackHandler;
            this.f6583e = unitedSchemeEntity;
            this.f6584f = str3;
        }

        @Override // c.a.n0.a.q0.d.c
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        @Override // c.a.n0.a.q0.d.c
        public void onFailed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                c.a.n0.a.k2.a aVar = new c.a.n0.a.k2.a();
                aVar.k(7L);
                aVar.i(9L);
                aVar.f("debug download pkg fail");
                c.a.n0.a.k2.e.a().f(aVar);
                c.a.n0.a.v0.d.a.e(c.a.n0.a.s0.a.c(), aVar, 0, this.f6581c);
                c.a.n0.a.d2.s.d dVar = new c.a.n0.a.d2.s.d();
                dVar.p(aVar);
                dVar.r(this.a);
                n.R(dVar);
                this.f6583e.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            }
        }

        @Override // c.a.n0.a.q0.d.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                ((c.a) this.a.A0(true)).a1("1.6.0");
                SwanLauncher.j().n(this.a, null);
                a.n(this.f6580b, this.f6581c, this.f6582d, this.f6583e, this.f6584f);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f6585b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f6586c;

        public c(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {callbackHandler, unitedSchemeEntity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = callbackHandler;
            this.f6585b = unitedSchemeEntity;
            this.f6586c = str;
        }

        @Override // c.a.n0.a.v0.a.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a.m(this.a, this.f6585b, this.f6586c, 1001);
            }
        }

        @Override // c.a.n0.a.v0.a.e
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                a.m(this.a, this.f6585b, this.f6586c, 0);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d extends c.a.n0.a.o1.a.b.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f6587c;

        public d(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6587c = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.o1.a.b.c.b, c.a.n0.a.o1.a.b.c.c, c.a.n0.a.o1.a.b.c.a
        public void onEvent(@NonNull c.a.n0.a.o1.a.b.a.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                if (bVar.a() != null && bVar.a().getInt("ok") == 0) {
                    e eVar = this.f6587c;
                    if (eVar != null) {
                        eVar.b();
                        return;
                    }
                    return;
                }
                e eVar2 = this.f6587c;
                if (eVar2 != null) {
                    eVar2.a();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public interface e {
        void a();

        void b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c.a.n0.a.v1.e eVar) {
        super(eVar, "/swanAPI/launch");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void m(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(InputDeviceCompat.SOURCE_TRACKBALL, null, callbackHandler, unitedSchemeEntity, str, i) == null) {
            if (TextUtils.isEmpty(str)) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(i));
            } else {
                UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(i).toString(), str);
            }
        }
    }

    public static void n(String str, String str2, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65541, null, str, str2, callbackHandler, unitedSchemeEntity, str3) == null) {
            if (!TextUtils.isEmpty(str3)) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            }
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str3)) {
                return;
            }
            c cVar = new c(callbackHandler, unitedSchemeEntity, str3);
            if (ProcessUtils.isMainProcess()) {
                c.a.n0.a.v0.b.j(str2, cVar);
            } else {
                p(str2, cVar);
            }
        }
    }

    public static void p(String str, e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65542, null, str, eVar) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("desAppId", str);
        c.a.n0.a.t1.d.J().z().W(bundle, c.a.n0.a.v0.b.class, new d(eVar));
    }

    @Override // c.a.n0.a.v1.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.n0.a.t1.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            c.a.n0.a.u.d.b("LaunchAction", "handle entity: ", unitedSchemeEntity);
            String uri = unitedSchemeEntity.getUri() != null ? unitedSchemeEntity.getUri().toString() : "";
            c.a.n0.a.u.d.i("LaunchAction", "launch scheme = " + uri);
            HashMap<String, String> params = unitedSchemeEntity.getParams();
            String str = params.get("params");
            String str2 = params.get("from");
            if (TextUtils.isEmpty(str)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                c.a.n0.a.k2.a aVar = new c.a.n0.a.k2.a();
                aVar.k(1L);
                aVar.i(1L);
                aVar.f("paramsValue is empty");
                c.a.n0.a.k2.e.a().f(aVar);
                c.a.n0.a.v0.d.a.e(context, aVar, 0, "");
                c.a.n0.a.d2.s.d dVar = new c.a.n0.a.d2.s.d();
                dVar.p(aVar);
                dVar.t(str2);
                dVar.l("scheme", uri);
                n.R(dVar);
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("appid");
                String optString2 = jSONObject.optString("navi");
                if (TextUtils.isEmpty(optString)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    c.a.n0.a.k2.a aVar2 = new c.a.n0.a.k2.a();
                    aVar2.k(1L);
                    aVar2.i(1L);
                    aVar2.f("appId is empty");
                    c.a.n0.a.k2.e.a().f(aVar2);
                    c.a.n0.a.v0.d.a.e(context, aVar2, 0, "");
                    c.a.n0.a.d2.s.d dVar2 = new c.a.n0.a.d2.s.d();
                    dVar2.p(aVar2);
                    dVar2.t(str2);
                    dVar2.l("scheme", uri);
                    n.R(dVar2);
                    return false;
                } else if (c.a.n0.q.j.j.b.e().g(!q0.G()) && TextUtils.equals(optString2, "naviTo")) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(optString);
                    c.a.n0.q.b.e(arrayList, c.a.n0.a.t1.d.J().r().N(), new C0478a(this, optString, jSONObject, str2, uri, context, unitedSchemeEntity, callbackHandler, eVar));
                    return true;
                } else {
                    return o(jSONObject, str2, uri, context, unitedSchemeEntity, optString, callbackHandler, eVar);
                }
            } catch (JSONException e2) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                c.a.n0.a.k2.a aVar3 = new c.a.n0.a.k2.a();
                aVar3.k(1L);
                aVar3.i(1L);
                aVar3.f("parse paramsValue with JSONException:" + e2.getMessage());
                c.a.n0.a.k2.e.a().f(aVar3);
                c.a.n0.a.v0.d.a.e(context, aVar3, 0, "");
                c.a.n0.a.d2.s.d dVar3 = new c.a.n0.a.d2.s.d();
                dVar3.p(aVar3);
                dVar3.t(str2);
                dVar3.l("scheme", uri);
                n.R(dVar3);
                return false;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean o(JSONObject jSONObject, String str, String str2, Context context, UnitedSchemeEntity unitedSchemeEntity, String str3, CallbackHandler callbackHandler, c.a.n0.a.t1.e eVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{jSONObject, str, str2, context, unitedSchemeEntity, str3, callbackHandler, eVar})) == null) {
            String h2 = SwanLauncher.h();
            c.a.n0.a.t1.d.J().r().V().J0(h2);
            String optString = jSONObject.optString("url");
            String optString2 = jSONObject.optString(PrefetchEvent.EVENT_DATA_EXTRA_DATA);
            String optString3 = jSONObject.optString("downloadurl");
            String optString4 = jSONObject.optString("clkid");
            String optString5 = jSONObject.optString("notinhis");
            String optString6 = jSONObject.optString("cb");
            String optString7 = jSONObject.optString("navi");
            c.a aVar = (c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) new c.a().v0(str3)).R0(optString)).I0(str)).K0(str2)).y0(optString4)).P0(optString5)).J0(h2);
            if (eVar != null && !TextUtils.isEmpty(optString7)) {
                aVar.r0(PrefetchEvent.EVENT_DATA_EXTRA_DATA, optString2);
                aVar.r0("navi", optString7);
                b.a X = eVar.X();
                if (X == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
                String H = X.H();
                if (c.a.n0.a.l.a.e(X) && !c.a.n0.a.l.a.f(str3)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    return false;
                }
                aVar.r0("srcAppId", H);
                aVar.r0("srcAppKey", X.I());
                aVar.q0("srcPkgType", X.getType());
                aVar.r0("srcAppPage", q0.n().e());
            }
            if (z.f6924b && !TextUtils.isEmpty(optString3)) {
                d.C0422d c0422d = new d.C0422d();
                c0422d.a = optString3;
                c.a.n0.a.q0.d.K(c0422d, new b(this, aVar, optString7, str3, callbackHandler, unitedSchemeEntity, optString6));
                return true;
            } else if (TextUtils.isEmpty(optString3)) {
                aVar.A0(false);
                SwanLauncher.j().n(aVar, null);
                n(optString7, str3, callbackHandler, unitedSchemeEntity, optString6);
                return true;
            } else {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                c.a.n0.a.k2.a aVar2 = new c.a.n0.a.k2.a();
                aVar2.k(1L);
                aVar2.i(1L);
                aVar2.f("release but downloadUrl is not empty");
                c.a.n0.a.k2.e.a().f(aVar2);
                c.a.n0.a.v0.d.a.e(context, aVar2, 0, str3);
                c.a.n0.a.d2.s.d dVar = new c.a.n0.a.d2.s.d();
                dVar.t(str);
                dVar.m(str3);
                dVar.r(aVar);
                dVar.l("scheme", str2);
                n.R(dVar);
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }
}
