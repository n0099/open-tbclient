package c.a.o0.a.w2.i;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.o0.a.c0.c.a.c;
import c.a.o0.a.c2.e;
import c.a.o0.a.c2.f.a0;
import c.a.o0.a.c2.f.b;
import c.a.o0.a.e0.d;
import c.a.o0.a.g1.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.net.URI;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(e eVar) {
        super(eVar, "/swanAPI/animView");
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
                super((e) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.o0.a.c2.f.b
    @NonNull
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "/swanAPI/animView" : (String) invokeV.objValue;
    }

    @Override // c.a.o0.a.c2.f.b
    public boolean m(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, c.a.o0.a.a2.e eVar) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, eVar)) == null) {
            c q = q(unitedSchemeEntity);
            if (q == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                d.b("AbsSwanAppWidget", "model is null");
                return false;
            } else if (!q.l()) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                d.b("AbsSwanAppWidget", "parse insert params, but invalid");
                return false;
            } else {
                String r = r(q.x, eVar);
                if (TextUtils.isEmpty(r)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "parse insert params, anim data is null");
                    return false;
                }
                if (f.V().O()) {
                    try {
                        new JSONObject(r);
                    } catch (Throwable th) {
                        if (a0.f4738b) {
                            th.printStackTrace();
                        }
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "parse insert params, anim data is not json");
                        return false;
                    }
                }
                c.a.o0.a.c0.b.c w = new c.a.o0.a.c0.c.a.b(context, q, r).w();
                boolean a2 = w.a();
                d.g("AbsSwanAppWidget", "insert anim view success = " + a2);
                if (a2) {
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                } else {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, w.f4635b);
                    d.b("AbsSwanAppWidget", "insert anim view, but failure: " + w.f4635b);
                }
                return a2;
            }
        }
        return invokeLLLLL.booleanValue;
    }

    @Override // c.a.o0.a.c2.f.b
    public boolean o(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, c.a.o0.a.a2.e eVar) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, context, unitedSchemeEntity, callbackHandler, str, eVar)) == null) {
            c q = q(unitedSchemeEntity);
            if (q == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                d.b("AbsSwanAppWidget", "model is null");
                return false;
            } else if (!q.isValid()) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                d.b("AbsSwanAppWidget", "parse remove params, but invalid");
                return false;
            } else {
                c.a.o0.a.c0.c.a.b bVar = (c.a.o0.a.c0.c.a.b) c.a.o0.a.c0.d.a.a(q);
                if (bVar == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    d.b("AbsSwanAppWidget", "get component is null");
                    return false;
                }
                c.a.o0.a.c0.b.c C = bVar.C();
                boolean a2 = C.a();
                d.g("AbsSwanAppWidget", "remove anim view success = " + a2);
                if (a2) {
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                } else {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, C.f4635b);
                    d.b("AbsSwanAppWidget", "remove anim view, but failure: " + C.f4635b);
                }
                return a2;
            }
        }
        return invokeLLLLL.booleanValue;
    }

    @Override // c.a.o0.a.c2.f.b
    public boolean p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, c.a.o0.a.a2.e eVar) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048579, this, context, unitedSchemeEntity, callbackHandler, str, eVar)) == null) {
            c q = q(unitedSchemeEntity);
            if (q == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                d.b("AbsSwanAppWidget", "model is null");
                return false;
            } else if (!q.isValid()) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                d.b("AbsSwanAppWidget", "parse update params, but invalid");
                return false;
            } else {
                c.a.o0.a.c0.c.a.b bVar = (c.a.o0.a.c0.c.a.b) c.a.o0.a.c0.d.a.a(q);
                if (bVar == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    d.b("AbsSwanAppWidget", "get component is null");
                    return false;
                }
                c.a.o0.a.c0.b.c G = bVar.G(q);
                boolean a2 = G.a();
                d.a("AbsSwanAppWidget", "update anim view success = " + a2);
                if (a2) {
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                } else {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, G.f4635b);
                    d.b("AbsSwanAppWidget", "update anim view, but failure: " + G.f4635b);
                }
                return a2;
            }
        }
        return invokeLLLLL.booleanValue;
    }

    @Nullable
    public final c q(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, unitedSchemeEntity)) == null) {
            if (unitedSchemeEntity == null) {
                return null;
            }
            JSONObject k = k(unitedSchemeEntity);
            if (k == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                d.b("SwanAppAction", "params is null");
                return null;
            }
            c cVar = new c();
            try {
                cVar.a(k);
            } catch (JSONException e2) {
                e2.printStackTrace();
                d.c("SwanAppAction", "model parse exception:", e2);
            }
            return cVar;
        }
        return (c) invokeL.objValue;
    }

    public final String r(String str, c.a.o0.a.a2.e eVar) {
        InterceptResult invokeLL;
        String L;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, eVar)) == null) {
            if (!TextUtils.isEmpty(str) && eVar != null) {
                try {
                    if ("bdfile".equalsIgnoreCase(URI.create(str).getScheme())) {
                        L = c.a.o0.a.k2.b.M(str, eVar.f4530f);
                    } else {
                        L = c.a.o0.a.k2.b.L(str, eVar, eVar.Z());
                    }
                    if (TextUtils.isEmpty(L)) {
                        return null;
                    }
                    File file = new File(L);
                    if (c.a.o0.t.d.x(file)) {
                        return c.a.o0.t.d.D(file);
                    }
                    return null;
                } catch (Exception e2) {
                    if (a0.f4738b) {
                        e2.printStackTrace();
                    }
                }
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }
}
