package b.a.p0.a.f1;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.a1.d;
import b.a.p0.a.f1.e.b;
import b.a.p0.a.f1.e.c;
import b.a.p0.a.f2.f.z;
import b.a.p0.a.n2.n;
import b.a.p0.a.z2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
import com.baidu.wallet.newbindcard.NewBindCardEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.p0.a.f1.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0163a implements b.a.p0.q.f.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f4783a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JSONObject f4784b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f4785c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f4786d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f4787e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f4788f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f4789g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.d2.e f4790h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f4791i;

        public C0163a(a aVar, String str, JSONObject jSONObject, String str2, String str3, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b.a.p0.a.d2.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, jSONObject, str2, str3, context, unitedSchemeEntity, callbackHandler, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4791i = aVar;
            this.f4783a = str;
            this.f4784b = jSONObject;
            this.f4785c = str2;
            this.f4786d = str3;
            this.f4787e = context;
            this.f4788f = unitedSchemeEntity;
            this.f4789g = callbackHandler;
            this.f4790h = eVar;
        }

        @Override // b.a.p0.q.f.c
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                boolean unused = z.f5228b;
                this.f4788f.result = UnitedSchemeUtility.wrapCallbackParams(201);
            }
        }

        @Override // b.a.p0.q.f.c
        public void onResult(@Nullable Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map) == null) || map == null) {
                return;
            }
            String str = map.get(this.f4783a);
            if (TextUtils.isEmpty(str)) {
                str = this.f4783a;
            }
            this.f4791i.o(this.f4784b, this.f4785c, this.f4786d, this.f4787e, this.f4788f, str, this.f4789g, this.f4790h);
        }
    }

    /* loaded from: classes.dex */
    public class b implements d.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a f4792a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f4793b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f4794c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f4795d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f4796e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f4797f;

        public b(a aVar, c.a aVar2, String str, String str2, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str3) {
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
            this.f4792a = aVar2;
            this.f4793b = str;
            this.f4794c = str2;
            this.f4795d = callbackHandler;
            this.f4796e = unitedSchemeEntity;
            this.f4797f = str3;
        }

        @Override // b.a.p0.a.a1.d.c
        public void onFailed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.u2.a aVar = new b.a.p0.a.u2.a();
                aVar.k(7L);
                aVar.i(9L);
                aVar.f("debug download pkg fail");
                b.a.p0.a.u2.e.a().f(aVar);
                b.a.p0.a.f1.d.a.e(b.a.p0.a.c1.a.c(), aVar, 0, this.f4794c);
                b.a.p0.a.n2.s.d dVar = new b.a.p0.a.n2.s.d();
                dVar.p(aVar);
                dVar.r(this.f4792a);
                n.R(dVar);
                this.f4796e.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            }
        }

        @Override // b.a.p0.a.a1.d.c
        public void onProgressChanged(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            }
        }

        @Override // b.a.p0.a.a1.d.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                ((c.a) this.f4792a.A0(true)).a1("1.6.0");
                SwanLauncher.j().n(this.f4792a, null);
                a.n(this.f4793b, this.f4794c, this.f4795d, this.f4796e, this.f4797f);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f4798a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f4799b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f4800c;

        public c(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str) {
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
            this.f4798a = callbackHandler;
            this.f4799b = unitedSchemeEntity;
            this.f4800c = str;
        }

        @Override // b.a.p0.a.f1.a.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a.m(this.f4798a, this.f4799b, this.f4800c, 1001);
            }
        }

        @Override // b.a.p0.a.f1.a.e
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                a.m(this.f4798a, this.f4799b, this.f4800c, 0);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d extends b.a.p0.a.y1.a.b.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f4801c;

        public d(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4801c = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.y1.a.b.c.b, b.a.p0.a.y1.a.b.c.c, b.a.p0.a.y1.a.b.c.a
        public void onEvent(@NonNull b.a.p0.a.y1.a.b.a.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                if (bVar.a() != null && bVar.a().getInt(NewBindCardEntry.BING_CARD_SUCCESS_MSG) == 0) {
                    e eVar = this.f4801c;
                    if (eVar != null) {
                        eVar.b();
                        return;
                    }
                    return;
                }
                e eVar2 = this.f4801c;
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
    public a(b.a.p0.a.f2.e eVar) {
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

    public static void m(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(InputDeviceCompat.SOURCE_TRACKBALL, null, callbackHandler, unitedSchemeEntity, str, i2) == null) {
            if (TextUtils.isEmpty(str)) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(i2));
            } else {
                UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(i2).toString(), str);
            }
        }
    }

    public static void n(String str, String str2, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(AdIconUtil.AD_TEXT_ID, null, str, str2, callbackHandler, unitedSchemeEntity, str3) == null) {
            if (!TextUtils.isEmpty(str3)) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            }
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str3)) {
                return;
            }
            c cVar = new c(callbackHandler, unitedSchemeEntity, str3);
            if (ProcessUtils.isMainProcess()) {
                b.a.p0.a.f1.b.j(str2, cVar);
            } else {
                p(str2, cVar);
            }
        }
    }

    public static void p(String str, e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, eVar) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("desAppId", str);
        b.a.p0.a.d2.d.J().z().W(bundle, b.a.p0.a.f1.b.class, new d(eVar));
    }

    @Override // b.a.p0.a.f2.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b.a.p0.a.d2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            b.a.p0.a.e0.d.b("LaunchAction", "handle entity: ", unitedSchemeEntity);
            String uri = unitedSchemeEntity.getUri() != null ? unitedSchemeEntity.getUri().toString() : "";
            b.a.p0.a.e0.d.i("LaunchAction", "launch scheme = " + uri);
            HashMap<String, String> params = unitedSchemeEntity.getParams();
            String str = params.get("params");
            String str2 = params.get("from");
            if (TextUtils.isEmpty(str)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                b.a.p0.a.u2.a aVar = new b.a.p0.a.u2.a();
                aVar.k(1L);
                aVar.i(1L);
                aVar.f("paramsValue is empty");
                b.a.p0.a.u2.e.a().f(aVar);
                b.a.p0.a.f1.d.a.e(context, aVar, 0, "");
                b.a.p0.a.n2.s.d dVar = new b.a.p0.a.n2.s.d();
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
                    b.a.p0.a.u2.a aVar2 = new b.a.p0.a.u2.a();
                    aVar2.k(1L);
                    aVar2.i(1L);
                    aVar2.f("appId is empty");
                    b.a.p0.a.u2.e.a().f(aVar2);
                    b.a.p0.a.f1.d.a.e(context, aVar2, 0, "");
                    b.a.p0.a.n2.s.d dVar2 = new b.a.p0.a.n2.s.d();
                    dVar2.p(aVar2);
                    dVar2.t(str2);
                    dVar2.l("scheme", uri);
                    n.R(dVar2);
                    return false;
                } else if (b.a.p0.q.k.j.b.e().g(!q0.G()) && TextUtils.equals(optString2, "naviTo")) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(optString);
                    b.a.p0.q.b.e(arrayList, b.a.p0.a.d2.d.J().r().N(), new C0163a(this, optString, jSONObject, str2, uri, context, unitedSchemeEntity, callbackHandler, eVar));
                    return true;
                } else {
                    return o(jSONObject, str2, uri, context, unitedSchemeEntity, optString, callbackHandler, eVar);
                }
            } catch (JSONException e2) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                b.a.p0.a.u2.a aVar3 = new b.a.p0.a.u2.a();
                aVar3.k(1L);
                aVar3.i(1L);
                aVar3.f("parse paramsValue with JSONException:" + e2.getMessage());
                b.a.p0.a.u2.e.a().f(aVar3);
                b.a.p0.a.f1.d.a.e(context, aVar3, 0, "");
                b.a.p0.a.n2.s.d dVar3 = new b.a.p0.a.n2.s.d();
                dVar3.p(aVar3);
                dVar3.t(str2);
                dVar3.l("scheme", uri);
                n.R(dVar3);
                return false;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean o(JSONObject jSONObject, String str, String str2, Context context, UnitedSchemeEntity unitedSchemeEntity, String str3, CallbackHandler callbackHandler, b.a.p0.a.d2.e eVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{jSONObject, str, str2, context, unitedSchemeEntity, str3, callbackHandler, eVar})) == null) {
            String h2 = SwanLauncher.h();
            b.a.p0.a.d2.d.J().r().V().J0(h2);
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
                if (b.a.p0.a.v.a.e(X) && !b.a.p0.a.v.a.f(str3)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    return false;
                }
                aVar.r0("srcAppId", H);
                aVar.r0("srcAppKey", X.I());
                aVar.q0("srcPkgType", X.getType());
                aVar.r0("srcAppPage", q0.n().f());
            }
            if (z.f5228b && !TextUtils.isEmpty(optString3)) {
                d.C0111d c0111d = new d.C0111d();
                c0111d.f3995a = optString3;
                b.a.p0.a.a1.d.K(c0111d, new b(this, aVar, optString7, str3, callbackHandler, unitedSchemeEntity, optString6));
                return true;
            } else if (TextUtils.isEmpty(optString3)) {
                aVar.A0(false);
                SwanLauncher.j().n(aVar, null);
                n(optString7, str3, callbackHandler, unitedSchemeEntity, optString6);
                return true;
            } else {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                b.a.p0.a.u2.a aVar2 = new b.a.p0.a.u2.a();
                aVar2.k(1L);
                aVar2.i(1L);
                aVar2.f("release but downloadUrl is not empty");
                b.a.p0.a.u2.e.a().f(aVar2);
                b.a.p0.a.f1.d.a.e(context, aVar2, 0, str3);
                b.a.p0.a.n2.s.d dVar = new b.a.p0.a.n2.s.d();
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
