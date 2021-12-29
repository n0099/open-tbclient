package c.a.r0.a.j1.f.c;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.d2.e;
import c.a.r0.a.f2.f.z;
import c.a.r0.a.h2.c.d;
import c.a.r0.a.h2.c.i;
import c.a.r0.a.h2.c.j.b;
import c.a.r0.a.v1.f;
import c.a.r0.a.z2.g1.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.pm.provider.BundleOpProvider;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.r0.a.j1.f.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0435a implements c<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f7640e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f7641f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.j1.f.b f7642g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f7643h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Context f7644i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.j1.f.a f7645j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ String f7646k;
        public final /* synthetic */ e l;
        public final /* synthetic */ a m;

        public C0435a(a aVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, c.a.r0.a.j1.f.b bVar, String str, Context context, c.a.r0.a.j1.f.a aVar2, String str2, e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, callbackHandler, unitedSchemeEntity, bVar, str, context, aVar2, str2, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.m = aVar;
            this.f7640e = callbackHandler;
            this.f7641f = unitedSchemeEntity;
            this.f7642g = bVar;
            this.f7643h = str;
            this.f7644i = context;
            this.f7645j = aVar2;
            this.f7646k = str2;
            this.l = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (!d.h(iVar)) {
                    d.p(iVar, this.f7640e, this.f7641f);
                    int b2 = iVar == null ? 10001 : iVar.b();
                    this.m.o(this.f7642g, b2, d.f(b2));
                } else if (c.a.r0.a.j1.f.e.a.k().q(this.f7643h)) {
                    this.m.o(this.f7642g, 2001, "error execute time");
                    c.a.r0.a.e0.d.c(BundleOpProvider.METHOD_BUNDLE_RECORD, "error execute time");
                } else {
                    this.m.r(this.f7644i, this.f7641f, this.f7640e, this.f7643h, this.f7645j, this.f7642g, this.f7646k, this.l.f5660f);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f7647e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f7648f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f7649g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Context f7650h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.j1.f.a f7651i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.j1.f.b f7652j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ String f7653k;
        public final /* synthetic */ String l;
        public final /* synthetic */ a m;

        public b(a aVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, Context context, c.a.r0.a.j1.f.a aVar2, c.a.r0.a.j1.f.b bVar, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, callbackHandler, unitedSchemeEntity, str, context, aVar2, bVar, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.m = aVar;
            this.f7647e = callbackHandler;
            this.f7648f = unitedSchemeEntity;
            this.f7649g = str;
            this.f7650h = context;
            this.f7651i = aVar2;
            this.f7652j = bVar;
            this.f7653k = str2;
            this.l = str3;
        }

        @Override // c.a.r0.a.v1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (z.f6340b) {
                    String str2 = str + "";
                }
                this.m.p(this.f7647e, this.f7648f, this.f7649g, this.f7650h, this.f7651i, this.f7652j, this.f7653k, this.l);
            }
        }

        @Override // c.a.r0.a.v1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                if (z.f6340b) {
                    String str2 = str + "";
                }
                c.a.r0.a.e0.d.c(BundleOpProvider.METHOD_BUNDLE_RECORD, str);
                this.m.o(this.f7652j, 10005, "system deny");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c.a.r0.a.f2.e eVar) {
        super(eVar, "/swanAPI/recorder");
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

    @Override // c.a.r0.a.f2.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (z.f6340b) {
                String str = "handle entity: " + unitedSchemeEntity.toString();
                return false;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // c.a.r0.a.f2.f.z
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, e eVar) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, eVar)) == null) {
            if (z.f6340b) {
                String str2 = "handleSubAction subAction: " + str;
            }
            if (eVar == null) {
                c.a.r0.a.e0.d.c(BundleOpProvider.METHOD_BUNDLE_RECORD, "param is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
                boolean z = z.f6340b;
                return false;
            }
            if (eVar.m0()) {
                boolean z2 = z.f6340b;
                char c2 = 65535;
                int hashCode = str.hashCode();
                if (hashCode != -944894266) {
                    if (hashCode == 731105865 && str.equals("/swanAPI/recorder/resume")) {
                        c2 = 1;
                    }
                } else if (str.equals("/swanAPI/recorder/start")) {
                    c2 = 0;
                }
                if (c2 == 0) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "ui operation does not supported when app is invisible.");
                    return false;
                } else if (c2 == 1) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "ui operation does not supported when app is invisible.");
                    return false;
                }
            }
            if (TextUtils.isEmpty(eVar.f5660f)) {
                c.a.r0.a.e0.d.c(BundleOpProvider.METHOD_BUNDLE_RECORD, "aiapp id is invalid");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "none swanApp id");
                boolean z3 = z.f6340b;
                return false;
            } else if (c.a.r0.a.j1.f.e.a.k().p(str)) {
                JSONObject q = q(unitedSchemeEntity.getParam("params"));
                if (TextUtils.equals(str, "/swanAPI/recorder/start") && q == null) {
                    c.a.r0.a.e0.d.c(BundleOpProvider.METHOD_BUNDLE_RECORD, "none params");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "none params");
                    return false;
                }
                c.a.r0.a.j1.f.a a = c.a.r0.a.j1.f.a.a(q, c.a.r0.a.j1.f.e.a.k().j());
                if (a == null) {
                    c.a.r0.a.e0.d.c(BundleOpProvider.METHOD_BUNDLE_RECORD, "error params");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "error cb");
                    return false;
                }
                JSONObject c3 = a.c();
                if (c3 != null) {
                    c.a.r0.a.e0.d.c(BundleOpProvider.METHOD_BUNDLE_RECORD, "error params");
                    unitedSchemeEntity.result = c3;
                    return false;
                }
                c.a.r0.a.j1.f.b a2 = c.a.r0.a.j1.f.b.a(callbackHandler, unitedSchemeEntity, a.f7630g, c.a.r0.a.j1.f.e.a.k().i());
                String x = c.a.r0.a.o2.b.x(eVar.f5660f);
                if (TextUtils.isEmpty(x)) {
                    c.a.r0.a.e0.d.c(BundleOpProvider.METHOD_BUNDLE_RECORD, "none tmp path");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                } else if (!(context instanceof Activity)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    c.a.r0.a.e0.d.c(BundleOpProvider.METHOD_BUNDLE_RECORD, "handle action, but context is not Activity");
                    return false;
                } else {
                    eVar.d0().g(context, PermissionProxy.SCOPE_ID_RECORD, new C0435a(this, callbackHandler, unitedSchemeEntity, a2, str, context, a, x, eVar));
                    if (z.f6340b) {
                        String str3 = "subAction is : " + str;
                    }
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                    return true;
                }
            } else {
                return false;
            }
        }
        return invokeLLLLL.booleanValue;
    }

    public final void o(c.a.r0.a.j1.f.b bVar, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, bVar, i2, str) == null) {
            if (bVar != null && !TextUtils.isEmpty(c.a.r0.a.j1.f.b.f7636h)) {
                bVar.d(i2, str);
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errCode", i2);
                jSONObject.put("errMsg", str);
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                c.a.r0.a.g1.f.U().u(new c.a.r0.a.o0.d.c("recorderError", hashMap));
            } catch (JSONException e2) {
                c.a.r0.a.e0.d.d(BundleOpProvider.METHOD_BUNDLE_RECORD, "json error", e2);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void p(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, Context context, c.a.r0.a.j1.f.a aVar, c.a.r0.a.j1.f.b bVar, String str2, String str3) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{callbackHandler, unitedSchemeEntity, str, context, aVar, bVar, str2, str3}) == null) {
            switch (str.hashCode()) {
                case -948211622:
                    if (str.equals("/swanAPI/recorder/pause")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -944894266:
                    if (str.equals("/swanAPI/recorder/start")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 731105865:
                    if (str.equals("/swanAPI/recorder/resume")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 2047729950:
                    if (str.equals("/swanAPI/recorder/stop")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 == 0) {
                u(context, aVar, bVar, str2, str3);
            } else if (c2 == 1) {
                c.a.r0.a.e0.d.i(BundleOpProvider.METHOD_BUNDLE_RECORD, "pause");
                s();
            } else if (c2 == 2) {
                c.a.r0.a.e0.d.i(BundleOpProvider.METHOD_BUNDLE_RECORD, "resume");
                t();
            } else if (c2 != 3) {
            } else {
                c.a.r0.a.e0.d.i(BundleOpProvider.METHOD_BUNDLE_RECORD, IntentConfig.STOP);
                v();
            }
        }
    }

    public final JSONObject q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    return new JSONObject(str);
                } catch (JSONException e2) {
                    if (z.f6340b) {
                        Log.getStackTraceString(e2);
                    }
                }
            }
            return null;
        }
        return (JSONObject) invokeL.objValue;
    }

    public final void r(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, c.a.r0.a.j1.f.a aVar, c.a.r0.a.j1.f.b bVar, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{context, unitedSchemeEntity, callbackHandler, str, aVar, bVar, str2, str3}) == null) {
            c.a.r0.a.v1.e.h(new String[]{PermissionRequest.RESOURCE_AUDIO_CAPTURE}, 2, context, new b(this, callbackHandler, unitedSchemeEntity, str, context, aVar, bVar, str2, str3));
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            c.a.r0.a.j1.f.e.a.k().t();
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a.r0.a.j1.f.e.a.k().A();
        }
    }

    public final void u(Context context, c.a.r0.a.j1.f.a aVar, c.a.r0.a.j1.f.b bVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, aVar, bVar, str, str2) == null) {
            c.a.r0.a.e0.d.i(BundleOpProvider.METHOD_BUNDLE_RECORD, "init");
            c.a.r0.a.j1.f.e.a.k().l(str, aVar, context, bVar, str2);
            c.a.r0.a.e0.d.i(BundleOpProvider.METHOD_BUNDLE_RECORD, "start");
            c.a.r0.a.j1.f.e.a.k().D(true);
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            c.a.r0.a.j1.f.e.a.k().F();
            c.a.r0.a.j1.f.e.a.x();
        }
    }
}
