package c.a.n0.a.f0.f.g;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.v1.f.z;
import c.a.n0.a.x.u.g;
import c.a.n0.a.x1.c.j.b;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b extends z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements c.a.n0.a.p2.g1.c<c.a.n0.a.x1.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f4363b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f4364c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ JSONObject f4365d;

        public a(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {callbackHandler, unitedSchemeEntity, context, jSONObject};
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
            this.f4363b = unitedSchemeEntity;
            this.f4364c = context;
            this.f4365d = jSONObject;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.n0.a.x1.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.n0.a.x1.c.d.h(iVar)) {
                    try {
                        b.l(this.f4364c, this.f4365d);
                        UnitedSchemeUtility.callCallback(this.a, this.f4363b, UnitedSchemeUtility.wrapCallbackParams(this.f4365d, 0));
                        return;
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                        this.f4363b.result = UnitedSchemeUtility.wrapCallbackParams(1001, "json exception");
                        return;
                    }
                }
                c.a.n0.a.x1.c.d.p(iVar, this.a, this.f4363b);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(c.a.n0.a.v1.e eVar) {
        super(eVar, "/swanAPI/debug/getDebugConfig");
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

    public static JSONObject k(String str, Object obj) throws JSONException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, obj)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", str);
            jSONObject.put("value", obj);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r1v51 */
    public static void l(@NonNull Context context, @NonNull JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, context, jSONObject) == null) {
            String string = context.getString(R.string.obfuscated_res_0x7f0f0135);
            boolean s = c.a.n0.a.n1.a.a.s();
            c.a.n0.a.f0.f.a.a(s);
            jSONObject.put("loadCts", k(string, Integer.valueOf(s ? 1 : 0)));
            String string2 = context.getString(R.string.obfuscated_res_0x7f0f0118);
            boolean r = c.a.n0.a.n1.a.a.r();
            c.a.n0.a.f0.f.a.a(r);
            jSONObject.put("emitLive", k(string2, Integer.valueOf(r ? 1 : 0)));
            String string3 = context.getString(R.string.obfuscated_res_0x7f0f0116);
            boolean o = c.a.n0.a.n1.a.a.o();
            c.a.n0.a.f0.f.a.a(o);
            jSONObject.put("emitHttps", k(string3, Integer.valueOf(o ? 1 : 0)));
            String string4 = context.getString(R.string.obfuscated_res_0x7f0f0149);
            boolean y = c.a.n0.a.n1.a.a.y();
            c.a.n0.a.f0.f.a.a(y);
            jSONObject.put("useExtension", k(string4, Integer.valueOf(y ? 1 : 0)));
            String string5 = context.getString(R.string.obfuscated_res_0x7f0f0114);
            ?? r1 = (c.a.n0.a.n1.a.a.w() || c.a.n0.a.n1.a.a.A()) ? 0 : 1;
            c.a.n0.a.f0.f.a.a(r1);
            jSONObject.put("emitDomain", k(string5, Integer.valueOf((int) r1)));
            String string6 = context.getString(R.string.obfuscated_res_0x7f0f011f);
            boolean q = c.a.n0.a.n1.a.a.q();
            c.a.n0.a.f0.f.a.a(q);
            jSONObject.put("emitWss", k(string6, Integer.valueOf(q ? 1 : 0)));
            String string7 = context.getString(R.string.obfuscated_res_0x7f0f0117);
            boolean x = c.a.n0.a.n1.a.a.x();
            c.a.n0.a.f0.f.a.a(x);
            jSONObject.put("emitLaunchMode", k(string7, Integer.valueOf(x ? 1 : 0)));
            jSONObject.put("debugEnvData", k(context.getString(R.string.obfuscated_res_0x7f0f012c), c.a.n0.a.n1.a.a.g()));
            String string8 = context.getString(R.string.obfuscated_res_0x7f0f011d);
            boolean k = c.a.n0.a.n1.a.a.k();
            c.a.n0.a.f0.f.a.a(k);
            jSONObject.put("emitReplaceSwanCore", k(string8, Integer.valueOf(k ? 1 : 0)));
            String string9 = context.getString(R.string.obfuscated_res_0x7f0f011b);
            boolean h2 = c.a.n0.a.n1.a.a.h();
            c.a.n0.a.f0.f.a.a(h2);
            jSONObject.put("emitReplaceGameCore", k(string9, Integer.valueOf(h2 ? 1 : 0)));
            String string10 = context.getString(R.string.obfuscated_res_0x7f0f011c);
            boolean p = c.a.n0.a.n1.a.a.p();
            c.a.n0.a.f0.f.a.a(p);
            jSONObject.put("emitReplaceJsNative", k(string10, Integer.valueOf(p ? 1 : 0)));
            boolean d2 = g.v.d();
            String string11 = context.getString(R.string.obfuscated_res_0x7f0f011e);
            c.a.n0.a.f0.f.a.a(d2);
            jSONObject.put("emitReplaceV8Core", k(string11, Integer.valueOf(d2 ? 1 : 0)));
            String string12 = context.getString(R.string.obfuscated_res_0x7f0f011a);
            boolean m = c.a.n0.a.f0.f.c.m();
            c.a.n0.a.f0.f.a.a(m);
            jSONObject.put("emitReplaceDynamicLib", k(string12, Integer.valueOf(m ? 1 : 0)));
            jSONObject.put("emitHostEnv", k(context.getString(R.string.obfuscated_res_0x7f0f0115), Integer.valueOf(c.a.n0.a.n1.a.a.t())));
            String string13 = context.getString(R.string.obfuscated_res_0x7f0f013c);
            boolean a2 = c.a.n0.a.f0.f.f.a();
            c.a.n0.a.f0.f.a.a(a2);
            jSONObject.put("openStabilityCollector", k(string13, Integer.valueOf(a2 ? 1 : 0)));
            String string14 = context.getString(R.string.obfuscated_res_0x7f0f013b);
            boolean a3 = c.a.n0.a.f0.f.e.a();
            c.a.n0.a.f0.f.a.a(a3);
            jSONObject.put("openPerformanceTesting", k(string14, Integer.valueOf(a3 ? 1 : 0)));
            String string15 = context.getString(R.string.obfuscated_res_0x7f0f0119);
            boolean k2 = c.a.n0.a.f0.f.b.k();
            c.a.n0.a.f0.f.a.a(k2);
            jSONObject.put("emitReplaceDependency", k(string15, Integer.valueOf(k2 ? 1 : 0)));
        }
    }

    public static boolean m(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.n0.a.t1.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            eVar.d0().g(context, "mapp_cts_debug", new a(callbackHandler, unitedSchemeEntity, context, new JSONObject()));
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public static boolean n(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, unitedSchemeEntity, callbackHandler)) == null) {
            JSONObject jSONObject = new JSONObject();
            c.a.n0.a.u.d.i("getDebugConfig", "swangame getDebugConfig");
            if (!z.f6924b) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302);
                return false;
            }
            JSONObject a2 = z.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                c.a.n0.a.u.d.c("getDebugConfig", "params is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else if (!TextUtils.equals(a2.optString("category"), "swanGame")) {
                c.a.n0.a.u.d.c("getDebugConfig", "params is not swangame");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else {
                try {
                    boolean o = c.a.n0.a.n1.a.a.o();
                    c.a.n0.a.f0.f.a.a(o);
                    jSONObject.put("emitHttps", o ? 1 : 0);
                    boolean q = c.a.n0.a.n1.a.a.q();
                    c.a.n0.a.f0.f.a.a(q);
                    jSONObject.put("emitWss", q ? 1 : 0);
                    jSONObject.put("debugEnvData", c.a.n0.a.n1.a.a.g());
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
                    return true;
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "json exception");
                    return false;
                }
            }
        }
        return invokeLL.booleanValue;
    }

    @Override // c.a.n0.a.v1.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.n0.a.t1.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            c.a.n0.a.u.d.i("getDebugConfig", "swan getDebugConfig");
            int l = c.a.n0.a.t1.d.J().l();
            if (l != 0) {
                if (l != 1) {
                    c.a.n0.a.u.d.c("getDebugConfig", "frame type error");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "frame type error");
                    return false;
                }
                return n(unitedSchemeEntity, callbackHandler);
            }
            return m(context, unitedSchemeEntity, callbackHandler, eVar);
        }
        return invokeLLLL.booleanValue;
    }
}
