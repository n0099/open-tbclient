package c.a.n0.a.z0.f.c;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.l1.f;
import c.a.n0.a.p2.g1.c;
import c.a.n0.a.t1.e;
import c.a.n0.a.v1.f.z;
import c.a.n0.a.x1.c.d;
import c.a.n0.a.x1.c.i;
import c.a.n0.a.x1.c.j.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.pm.provider.BundleOpProvider;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
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
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.n0.a.z0.f.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0610a implements c<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f7919b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.z0.f.b f7920c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f7921d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f7922e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.z0.f.a f7923f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f7924g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f7925h;
        public final /* synthetic */ a i;

        public C0610a(a aVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, c.a.n0.a.z0.f.b bVar, String str, Context context, c.a.n0.a.z0.f.a aVar2, String str2, e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, callbackHandler, unitedSchemeEntity, bVar, str, context, aVar2, str2, eVar};
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
            this.a = callbackHandler;
            this.f7919b = unitedSchemeEntity;
            this.f7920c = bVar;
            this.f7921d = str;
            this.f7922e = context;
            this.f7923f = aVar2;
            this.f7924g = str2;
            this.f7925h = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (!d.h(iVar)) {
                    d.p(iVar, this.a, this.f7919b);
                    int b2 = iVar == null ? 10001 : iVar.b();
                    this.i.o(this.f7920c, b2, d.f(b2));
                } else if (c.a.n0.a.z0.f.e.a.k().q(this.f7921d)) {
                    this.i.o(this.f7920c, 2001, "error execute time");
                    c.a.n0.a.u.d.c(BundleOpProvider.METHOD_BUNDLE_RECORD, "error execute time");
                } else {
                    this.i.r(this.f7922e, this.f7919b, this.a, this.f7921d, this.f7923f, this.f7920c, this.f7924g, this.f7925h.f6344b);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f7926b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f7927c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Context f7928d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.z0.f.a f7929e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.z0.f.b f7930f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f7931g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f7932h;
        public final /* synthetic */ a i;

        public b(a aVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, Context context, c.a.n0.a.z0.f.a aVar2, c.a.n0.a.z0.f.b bVar, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, callbackHandler, unitedSchemeEntity, str, context, aVar2, bVar, str2, str3};
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
            this.a = callbackHandler;
            this.f7926b = unitedSchemeEntity;
            this.f7927c = str;
            this.f7928d = context;
            this.f7929e = aVar2;
            this.f7930f = bVar;
            this.f7931g = str2;
            this.f7932h = str3;
        }

        @Override // c.a.n0.a.l1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (z.f6924b) {
                    Log.d("AudioRecordAction", str + "");
                }
                this.i.p(this.a, this.f7926b, this.f7927c, this.f7928d, this.f7929e, this.f7930f, this.f7931g, this.f7932h);
            }
        }

        @Override // c.a.n0.a.l1.f
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                if (z.f6924b) {
                    Log.d("AudioRecordAction", str + "");
                }
                c.a.n0.a.u.d.c(BundleOpProvider.METHOD_BUNDLE_RECORD, str);
                this.i.o(this.f7930f, 10005, "system deny");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c.a.n0.a.v1.e eVar) {
        super(eVar, "/swanAPI/recorder");
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

    @Override // c.a.n0.a.v1.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (z.f6924b) {
                Log.d("AudioRecordAction", "handle entity: " + unitedSchemeEntity.toString());
                return false;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // c.a.n0.a.v1.f.z
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, e eVar) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, eVar)) == null) {
            if (z.f6924b) {
                Log.d("AudioRecordAction", "handleSubAction subAction: " + str);
            }
            if (eVar == null) {
                c.a.n0.a.u.d.c(BundleOpProvider.METHOD_BUNDLE_RECORD, "param is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
                if (z.f6924b) {
                    Log.d("AudioRecordAction", "record --- illegal swanApp");
                }
                return false;
            }
            if (eVar.m0()) {
                if (z.f6924b) {
                    Log.d("AudioRecordAction", "AudioRecordAction does not supported when app is invisible.");
                }
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
            if (TextUtils.isEmpty(eVar.f6344b)) {
                c.a.n0.a.u.d.c(BundleOpProvider.METHOD_BUNDLE_RECORD, "aiapp id is invalid");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "none swanApp id");
                if (z.f6924b) {
                    Log.d("AudioRecordAction", "record --- none swanApp id");
                }
                return false;
            } else if (c.a.n0.a.z0.f.e.a.k().p(str)) {
                JSONObject q = q(unitedSchemeEntity.getParam("params"));
                if (TextUtils.equals(str, "/swanAPI/recorder/start") && q == null) {
                    c.a.n0.a.u.d.c(BundleOpProvider.METHOD_BUNDLE_RECORD, "none params");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "none params");
                    return false;
                }
                c.a.n0.a.z0.f.a a = c.a.n0.a.z0.f.a.a(q, c.a.n0.a.z0.f.e.a.k().j());
                if (a == null) {
                    c.a.n0.a.u.d.c(BundleOpProvider.METHOD_BUNDLE_RECORD, "error params");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "error cb");
                    return false;
                }
                JSONObject c3 = a.c();
                if (c3 != null) {
                    c.a.n0.a.u.d.c(BundleOpProvider.METHOD_BUNDLE_RECORD, "error params");
                    unitedSchemeEntity.result = c3;
                    return false;
                }
                c.a.n0.a.z0.f.b a2 = c.a.n0.a.z0.f.b.a(callbackHandler, unitedSchemeEntity, a.f7911g, c.a.n0.a.z0.f.e.a.k().i());
                String x = c.a.n0.a.e2.b.x(eVar.f6344b);
                if (TextUtils.isEmpty(x)) {
                    c.a.n0.a.u.d.c(BundleOpProvider.METHOD_BUNDLE_RECORD, "none tmp path");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                } else if (!(context instanceof Activity)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    c.a.n0.a.u.d.c(BundleOpProvider.METHOD_BUNDLE_RECORD, "handle action, but context is not Activity");
                    return false;
                } else {
                    eVar.d0().g(context, PermissionProxy.SCOPE_ID_RECORD, new C0610a(this, callbackHandler, unitedSchemeEntity, a2, str, context, a, x, eVar));
                    if (z.f6924b) {
                        Log.d("AudioRecordAction", "subAction is : " + str);
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

    public final void o(c.a.n0.a.z0.f.b bVar, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, bVar, i, str) == null) {
            if (bVar != null && !TextUtils.isEmpty(c.a.n0.a.z0.f.b.f7917h)) {
                bVar.d(i, str);
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(StatConstants.KEY_EXT_ERR_CODE, i);
                jSONObject.put(StatConstants.KEY_EXT_ERR_MSG, str);
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                c.a.n0.a.w0.f.U().u(new c.a.n0.a.e0.d.c("recorderError", hashMap));
            } catch (JSONException e2) {
                c.a.n0.a.u.d.d(BundleOpProvider.METHOD_BUNDLE_RECORD, "json error", e2);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void p(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, Context context, c.a.n0.a.z0.f.a aVar, c.a.n0.a.z0.f.b bVar, String str2, String str3) {
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
                c.a.n0.a.u.d.i(BundleOpProvider.METHOD_BUNDLE_RECORD, "pause");
                s();
            } else if (c2 == 2) {
                c.a.n0.a.u.d.i(BundleOpProvider.METHOD_BUNDLE_RECORD, "resume");
                t();
            } else if (c2 != 3) {
            } else {
                c.a.n0.a.u.d.i(BundleOpProvider.METHOD_BUNDLE_RECORD, IntentConfig.STOP);
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
                    if (z.f6924b) {
                        Log.d("AudioRecordAction", Log.getStackTraceString(e2));
                    }
                }
            }
            return null;
        }
        return (JSONObject) invokeL.objValue;
    }

    public final void r(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, c.a.n0.a.z0.f.a aVar, c.a.n0.a.z0.f.b bVar, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{context, unitedSchemeEntity, callbackHandler, str, aVar, bVar, str2, str3}) == null) {
            c.a.n0.a.l1.e.h(new String[]{"android.permission.RECORD_AUDIO"}, 2, context, new b(this, callbackHandler, unitedSchemeEntity, str, context, aVar, bVar, str2, str3));
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            c.a.n0.a.z0.f.e.a.k().t();
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a.n0.a.z0.f.e.a.k().A();
        }
    }

    public final void u(Context context, c.a.n0.a.z0.f.a aVar, c.a.n0.a.z0.f.b bVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, aVar, bVar, str, str2) == null) {
            c.a.n0.a.u.d.i(BundleOpProvider.METHOD_BUNDLE_RECORD, "init");
            c.a.n0.a.z0.f.e.a.k().l(str, aVar, context, bVar, str2);
            c.a.n0.a.u.d.i(BundleOpProvider.METHOD_BUNDLE_RECORD, "start");
            c.a.n0.a.z0.f.e.a.k().D(true);
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            c.a.n0.a.z0.f.e.a.k().F();
            c.a.n0.a.z0.f.e.a.x();
        }
    }
}
