package c.a.p0.a.f1;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.a1.e;
import c.a.p0.a.c2.f.a0;
import c.a.p0.a.f1.e.b;
import c.a.p0.a.f1.e.c;
import c.a.p0.a.j2.k;
import c.a.p0.a.v2.q0;
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
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.p0.a.f1.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0180a implements e.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a f5658a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f5659b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f5660c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f5661d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f5662e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f5663f;

        public C0180a(a aVar, c.a aVar2, String str, String str2, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2, str, str2, callbackHandler, unitedSchemeEntity, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5658a = aVar2;
            this.f5659b = str;
            this.f5660c = str2;
            this.f5661d = callbackHandler;
            this.f5662e = unitedSchemeEntity;
            this.f5663f = str3;
        }

        @Override // c.a.p0.a.a1.e.c
        public void onFailed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.a.q2.a aVar = new c.a.p0.a.q2.a();
                aVar.j(7L);
                aVar.h(9L);
                aVar.e("debug download pkg fail");
                c.a.p0.a.q2.e.a().f(aVar);
                c.a.p0.a.f1.d.a.d(c.a.p0.a.c1.a.b(), aVar, 0, this.f5660c);
                c.a.p0.a.j2.p.d dVar = new c.a.p0.a.j2.p.d();
                dVar.p(aVar);
                dVar.r(this.f5658a);
                k.L(dVar);
                this.f5662e.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            }
        }

        @Override // c.a.p0.a.a1.e.c
        public void onProgressChanged(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            }
        }

        @Override // c.a.p0.a.a1.e.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                ((c.a) this.f5658a.z0(true)).Y0("1.6.0");
                SwanLauncher.j().n(this.f5658a, null);
                a.l(this.f5659b, this.f5660c, this.f5661d, this.f5662e, this.f5663f);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f5664a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f5665b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f5666c;

        public b(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {callbackHandler, unitedSchemeEntity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5664a = callbackHandler;
            this.f5665b = unitedSchemeEntity;
            this.f5666c = str;
        }

        @Override // c.a.p0.a.f1.a.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a.k(this.f5664a, this.f5665b, this.f5666c, 1001);
            }
        }

        @Override // c.a.p0.a.f1.a.d
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                a.k(this.f5664a, this.f5665b, this.f5666c, 0);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c extends c.a.p0.a.v1.a.b.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f5667c;

        public c(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5667c = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.v1.a.b.c.b, c.a.p0.a.v1.a.b.c.c, c.a.p0.a.v1.a.b.c.a
        public void onEvent(@NonNull c.a.p0.a.v1.a.b.a.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                if (bVar.a() != null && bVar.a().getInt("ok") == 0) {
                    d dVar = this.f5667c;
                    if (dVar != null) {
                        dVar.b();
                        return;
                    }
                    return;
                }
                d dVar2 = this.f5667c;
                if (dVar2 != null) {
                    dVar2.a();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        void a();

        void b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c.a.p0.a.c2.e eVar) {
        super(eVar, "/swanAPI/launch");
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

    public static void k(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(65538, null, callbackHandler, unitedSchemeEntity, str, i2) == null) {
            if (TextUtils.isEmpty(str)) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(i2));
            } else {
                UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(i2).toString(), str);
            }
        }
    }

    public static void l(String str, String str2, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65539, null, str, str2, callbackHandler, unitedSchemeEntity, str3) == null) {
            if (!TextUtils.isEmpty(str3)) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            }
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str3)) {
                return;
            }
            b bVar = new b(callbackHandler, unitedSchemeEntity, str3);
            if (ProcessUtils.isMainProcess()) {
                c.a.p0.a.f1.b.j(str2, bVar);
            } else {
                m(str2, bVar);
            }
        }
    }

    public static void m(String str, d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, dVar) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("desAppId", str);
        c.a.p0.a.a2.d.g().z().L(bundle, c.a.p0.a.f1.b.class, new c(dVar));
    }

    @Override // c.a.p0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            c.a.p0.a.e0.d.a("LaunchAction", "handle entity: ", unitedSchemeEntity);
            String uri = unitedSchemeEntity.getUri() != null ? unitedSchemeEntity.getUri().toString() : "";
            c.a.p0.a.e0.d.g("LaunchAction", "launch scheme = " + uri);
            String h2 = SwanLauncher.h();
            c.a.p0.a.a2.d.g().r().L().I0(h2);
            HashMap<String, String> params = unitedSchemeEntity.getParams();
            String str = params.get("params");
            String str2 = params.get("from");
            if (TextUtils.isEmpty(str)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                c.a.p0.a.q2.a aVar = new c.a.p0.a.q2.a();
                aVar.j(1L);
                aVar.h(1L);
                aVar.e("paramsValue is empty");
                c.a.p0.a.q2.e.a().f(aVar);
                c.a.p0.a.f1.d.a.d(context, aVar, 0, "");
                c.a.p0.a.j2.p.d dVar = new c.a.p0.a.j2.p.d();
                dVar.p(aVar);
                dVar.t(str2);
                dVar.l("scheme", uri);
                k.L(dVar);
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("appid");
                String optString2 = jSONObject.optString("url");
                String optString3 = jSONObject.optString(PrefetchEvent.EVENT_DATA_EXTRA_DATA);
                String optString4 = jSONObject.optString("navi");
                String optString5 = jSONObject.optString("downloadurl");
                String optString6 = jSONObject.optString("clkid");
                String optString7 = jSONObject.optString("notinhis");
                String optString8 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    c.a.p0.a.q2.a aVar2 = new c.a.p0.a.q2.a();
                    aVar2.j(1L);
                    aVar2.h(1L);
                    aVar2.e("appId is empty");
                    c.a.p0.a.q2.e.a().f(aVar2);
                    c.a.p0.a.f1.d.a.d(context, aVar2, 0, "");
                    c.a.p0.a.j2.p.d dVar2 = new c.a.p0.a.j2.p.d();
                    dVar2.p(aVar2);
                    dVar2.t(str2);
                    dVar2.l("scheme", uri);
                    k.L(dVar2);
                    return false;
                }
                c.a aVar3 = (c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) new c.a().u0(optString)).Q0(optString2)).H0(str2)).J0(uri)).x0(optString6)).O0(optString7)).I0(h2);
                if (eVar != null && !TextUtils.isEmpty(optString4)) {
                    aVar3.q0(PrefetchEvent.EVENT_DATA_EXTRA_DATA, optString3);
                    aVar3.q0("navi", optString4);
                    b.a N = eVar.N();
                    if (N == null) {
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                        return false;
                    }
                    String H = N.H();
                    if (c.a.p0.a.v.a.e(N) && !c.a.p0.a.v.a.f(optString)) {
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                        return false;
                    }
                    aVar3.q0("srcAppId", H);
                    aVar3.q0("srcAppPage", q0.n().h());
                }
                if (a0.f4766b && !TextUtils.isEmpty(optString5)) {
                    e.d dVar3 = new e.d();
                    dVar3.f4497a = optString5;
                    e.I(dVar3, new C0180a(this, aVar3, optString4, optString, callbackHandler, unitedSchemeEntity, optString8));
                    return true;
                } else if (TextUtils.isEmpty(optString5)) {
                    aVar3.z0(false);
                    SwanLauncher.j().n(aVar3, null);
                    l(optString4, optString, callbackHandler, unitedSchemeEntity, optString8);
                    return true;
                } else {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    c.a.p0.a.q2.a aVar4 = new c.a.p0.a.q2.a();
                    aVar4.j(1L);
                    aVar4.h(1L);
                    aVar4.e("release but downloadUrl is not empty");
                    c.a.p0.a.q2.e.a().f(aVar4);
                    c.a.p0.a.f1.d.a.d(context, aVar4, 0, optString);
                    c.a.p0.a.j2.p.d dVar4 = new c.a.p0.a.j2.p.d();
                    dVar4.t(str2);
                    dVar4.m(optString);
                    dVar4.r(aVar3);
                    dVar4.l("scheme", uri);
                    k.L(dVar4);
                    return false;
                }
            } catch (JSONException e2) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                c.a.p0.a.q2.a aVar5 = new c.a.p0.a.q2.a();
                aVar5.j(1L);
                aVar5.h(1L);
                aVar5.e("parse paramsValue with JSONException:" + e2.getMessage());
                c.a.p0.a.q2.e.a().f(aVar5);
                c.a.p0.a.f1.d.a.d(context, aVar5, 0, "");
                c.a.p0.a.j2.p.d dVar5 = new c.a.p0.a.j2.p.d();
                dVar5.p(aVar5);
                dVar5.t(str2);
                dVar5.l("scheme", uri);
                k.L(dVar5);
                return false;
            }
        }
        return invokeLLLL.booleanValue;
    }
}
