package c.a.n0.a.i1.f.c;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.a2.e;
import c.a.n0.a.c2.f.a0;
import c.a.n0.a.e2.c.d;
import c.a.n0.a.e2.c.i;
import c.a.n0.a.e2.c.j.b;
import c.a.n0.a.s1.f;
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
public class a extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.n0.a.i1.f.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0256a implements c.a.n0.a.v2.e1.b<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6521e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f6522f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.i1.f.b f6523g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f6524h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Context f6525i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.i1.f.a f6526j;
        public final /* synthetic */ String k;
        public final /* synthetic */ e l;
        public final /* synthetic */ a m;

        public C0256a(a aVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, c.a.n0.a.i1.f.b bVar, String str, Context context, c.a.n0.a.i1.f.a aVar2, String str2, e eVar) {
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
            this.f6521e = callbackHandler;
            this.f6522f = unitedSchemeEntity;
            this.f6523g = bVar;
            this.f6524h = str;
            this.f6525i = context;
            this.f6526j = aVar2;
            this.k = str2;
            this.l = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (!d.h(iVar)) {
                    d.o(iVar, this.f6521e, this.f6522f);
                    int b2 = iVar == null ? 10001 : iVar.b();
                    this.m.o(this.f6523g, b2, d.f(b2));
                } else if (c.a.n0.a.i1.f.e.a.k().q(this.f6524h)) {
                    this.m.o(this.f6523g, 2001, "error execute time");
                    c.a.n0.a.e0.d.b(BundleOpProvider.METHOD_BUNDLE_RECORD, "error execute time");
                } else {
                    this.m.r(this.f6525i, this.f6522f, this.f6521e, this.f6524h, this.f6526j, this.f6523g, this.k, this.l.f4284f);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6527a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f6528b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f6529c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Context f6530d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.i1.f.a f6531e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.i1.f.b f6532f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f6533g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f6534h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f6535i;

        public b(a aVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, Context context, c.a.n0.a.i1.f.a aVar2, c.a.n0.a.i1.f.b bVar, String str2, String str3) {
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
            this.f6535i = aVar;
            this.f6527a = callbackHandler;
            this.f6528b = unitedSchemeEntity;
            this.f6529c = str;
            this.f6530d = context;
            this.f6531e = aVar2;
            this.f6532f = bVar;
            this.f6533g = str2;
            this.f6534h = str3;
        }

        @Override // c.a.n0.a.s1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (a0.f4492b) {
                    String str2 = str + "";
                }
                this.f6535i.p(this.f6527a, this.f6528b, this.f6529c, this.f6530d, this.f6531e, this.f6532f, this.f6533g, this.f6534h);
            }
        }

        @Override // c.a.n0.a.s1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                if (a0.f4492b) {
                    String str2 = str + "";
                }
                c.a.n0.a.e0.d.b(BundleOpProvider.METHOD_BUNDLE_RECORD, str);
                this.f6535i.o(this.f6532f, 10005, "system deny");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c.a.n0.a.c2.e eVar) {
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

    @Override // c.a.n0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (a0.f4492b) {
                String str = "handle entity: " + unitedSchemeEntity.toString();
                return false;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // c.a.n0.a.c2.f.a0
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, e eVar) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, eVar)) == null) {
            if (a0.f4492b) {
                String str2 = "handleSubAction subAction: " + str;
            }
            if (eVar == null) {
                c.a.n0.a.e0.d.b(BundleOpProvider.METHOD_BUNDLE_RECORD, "param is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
                boolean z = a0.f4492b;
                return false;
            }
            if (eVar.d0()) {
                boolean z2 = a0.f4492b;
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
            if (TextUtils.isEmpty(eVar.f4284f)) {
                c.a.n0.a.e0.d.b(BundleOpProvider.METHOD_BUNDLE_RECORD, "aiapp id is invalid");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "none swanApp id");
                boolean z3 = a0.f4492b;
                return false;
            } else if (c.a.n0.a.i1.f.e.a.k().p(str)) {
                JSONObject q = q(unitedSchemeEntity.getParam("params"));
                if (TextUtils.equals(str, "/swanAPI/recorder/start") && q == null) {
                    c.a.n0.a.e0.d.b(BundleOpProvider.METHOD_BUNDLE_RECORD, "none params");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "none params");
                    return false;
                }
                c.a.n0.a.i1.f.a a2 = c.a.n0.a.i1.f.a.a(q, c.a.n0.a.i1.f.e.a.k().j());
                if (a2 == null) {
                    c.a.n0.a.e0.d.b(BundleOpProvider.METHOD_BUNDLE_RECORD, "error params");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "error cb");
                    return false;
                }
                JSONObject c3 = a2.c();
                if (c3 != null) {
                    c.a.n0.a.e0.d.b(BundleOpProvider.METHOD_BUNDLE_RECORD, "error params");
                    unitedSchemeEntity.result = c3;
                    return false;
                }
                c.a.n0.a.i1.f.b a3 = c.a.n0.a.i1.f.b.a(callbackHandler, unitedSchemeEntity, a2.f6510g, c.a.n0.a.i1.f.e.a.k().i());
                String x = c.a.n0.a.k2.b.x(eVar.f4284f);
                if (TextUtils.isEmpty(x)) {
                    c.a.n0.a.e0.d.b(BundleOpProvider.METHOD_BUNDLE_RECORD, "none tmp path");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                } else if (!(context instanceof Activity)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    c.a.n0.a.e0.d.b(BundleOpProvider.METHOD_BUNDLE_RECORD, "handle action, but context is not Activity");
                    return false;
                } else {
                    eVar.T().g(context, PermissionProxy.SCOPE_ID_RECORD, new C0256a(this, callbackHandler, unitedSchemeEntity, a3, str, context, a2, x, eVar));
                    if (a0.f4492b) {
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

    public final void o(c.a.n0.a.i1.f.b bVar, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, bVar, i2, str) == null) {
            if (bVar != null && !TextUtils.isEmpty(c.a.n0.a.i1.f.b.f6516h)) {
                bVar.d(i2, str);
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errCode", i2);
                jSONObject.put("errMsg", str);
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                c.a.n0.a.g1.f.V().v(new c.a.n0.a.o0.d.b("recorderError", hashMap));
            } catch (JSONException e2) {
                c.a.n0.a.e0.d.c(BundleOpProvider.METHOD_BUNDLE_RECORD, "json error", e2);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void p(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, Context context, c.a.n0.a.i1.f.a aVar, c.a.n0.a.i1.f.b bVar, String str2, String str3) {
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
                c.a.n0.a.e0.d.g(BundleOpProvider.METHOD_BUNDLE_RECORD, "pause");
                s();
            } else if (c2 == 2) {
                c.a.n0.a.e0.d.g(BundleOpProvider.METHOD_BUNDLE_RECORD, "resume");
                t();
            } else if (c2 != 3) {
            } else {
                c.a.n0.a.e0.d.g(BundleOpProvider.METHOD_BUNDLE_RECORD, IntentConfig.STOP);
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
                    if (a0.f4492b) {
                        Log.getStackTraceString(e2);
                    }
                }
            }
            return null;
        }
        return (JSONObject) invokeL.objValue;
    }

    public final void r(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, c.a.n0.a.i1.f.a aVar, c.a.n0.a.i1.f.b bVar, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{context, unitedSchemeEntity, callbackHandler, str, aVar, bVar, str2, str3}) == null) {
            c.a.n0.a.s1.e.g(new String[]{PermissionRequest.RESOURCE_AUDIO_CAPTURE}, 2, context, new b(this, callbackHandler, unitedSchemeEntity, str, context, aVar, bVar, str2, str3));
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            c.a.n0.a.i1.f.e.a.k().t();
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a.n0.a.i1.f.e.a.k().A();
        }
    }

    public final void u(Context context, c.a.n0.a.i1.f.a aVar, c.a.n0.a.i1.f.b bVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, aVar, bVar, str, str2) == null) {
            c.a.n0.a.e0.d.g(BundleOpProvider.METHOD_BUNDLE_RECORD, "init");
            c.a.n0.a.i1.f.e.a.k().l(str, aVar, context, bVar, str2);
            c.a.n0.a.e0.d.g(BundleOpProvider.METHOD_BUNDLE_RECORD, "start");
            c.a.n0.a.i1.f.e.a.k().D(true);
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            c.a.n0.a.i1.f.e.a.k().F();
            c.a.n0.a.i1.f.e.a.x();
        }
    }
}
