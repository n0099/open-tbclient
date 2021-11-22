package b.a.p0.a.a3.i;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.a.p0.a.c0.c.a.c;
import b.a.p0.a.e0.d;
import b.a.p0.a.f2.e;
import b.a.p0.a.f2.f.b;
import b.a.p0.a.f2.f.z;
import b.a.p0.a.g1.f;
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

    @Override // b.a.p0.a.f2.f.b
    @NonNull
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "/swanAPI/animView" : (String) invokeV.objValue;
    }

    @Override // b.a.p0.a.f2.f.b
    public boolean m(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, b.a.p0.a.d2.e eVar) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, eVar)) == null) {
            c q = q(unitedSchemeEntity);
            if (q == null) {
                b.a.p0.a.n2.u.a.b("animView", 1001, "model is null", 201, "model is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                d.c("AbsSwanAppWidget", "model is null");
                return false;
            } else if (!q.k()) {
                b.a.p0.a.n2.u.a.b("animView", 1001, "parse insert params, but invalid", 201, "parse insert params, but invalid");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                d.c("AbsSwanAppWidget", "parse insert params, but invalid");
                return false;
            } else {
                String r = r(q.x, eVar);
                if (TextUtils.isEmpty(r)) {
                    b.a.p0.a.n2.u.a.b("animView", 1001, "AnimConfData is invalid", 201, "parse insert params, anim data is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "parse insert params, anim data is null");
                    return false;
                }
                if (f.U().N()) {
                    try {
                        new JSONObject(r);
                    } catch (Throwable th) {
                        b.a.p0.a.n2.u.a.b("animView", 1001, "parse insert params, anim data is not json", 201, "parse insert params, anim data is not json");
                        if (z.f5228b) {
                            th.printStackTrace();
                        }
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "parse insert params, anim data is not json");
                        return false;
                    }
                }
                b.a.p0.a.c0.b.c insert = new b.a.p0.a.c0.c.a.b(context, q, r).insert();
                boolean a2 = insert.a();
                d.i("AbsSwanAppWidget", "insert anim view success = " + a2);
                if (a2) {
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                } else {
                    b.a.p0.a.n2.u.a.b("animView", 2009, "insert anim view, but failure: " + insert.f4201b, 1001, "insert anim view, but failure: " + insert.f4201b);
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, insert.f4201b);
                    d.c("AbsSwanAppWidget", "insert anim view, but failure: " + insert.f4201b);
                }
                return a2;
            }
        }
        return invokeLLLLL.booleanValue;
    }

    @Override // b.a.p0.a.f2.f.b
    public boolean o(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, b.a.p0.a.d2.e eVar) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, context, unitedSchemeEntity, callbackHandler, str, eVar)) == null) {
            c q = q(unitedSchemeEntity);
            if (q == null) {
                b.a.p0.a.n2.u.a.b("animView", 1001, "model is null", 201, "model is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                d.c("AbsSwanAppWidget", "model is null");
                return false;
            } else if (!q.isValid()) {
                b.a.p0.a.n2.u.a.b("animView", 1001, "parse remove params, but invalid", 201, "parse remove params, but invalid");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                d.c("AbsSwanAppWidget", "parse remove params, but invalid");
                return false;
            } else {
                b.a.p0.a.c0.c.a.b bVar = (b.a.p0.a.c0.c.a.b) b.a.p0.a.c0.d.a.a(q);
                if (bVar == null) {
                    b.a.p0.a.n2.u.a.b("animView", 2001, "get component is null", 1001, "get component is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    d.c("AbsSwanAppWidget", "get component is null");
                    return false;
                }
                b.a.p0.a.c0.b.c B = bVar.B();
                boolean a2 = B.a();
                d.i("AbsSwanAppWidget", "remove anim view success = " + a2);
                if (a2) {
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                } else {
                    b.a.p0.a.n2.u.a.b("animView", 2001, "remove anim view, but failure: " + B.f4201b, 1001, "remove anim view, but failure: " + B.f4201b);
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, B.f4201b);
                    d.c("AbsSwanAppWidget", "remove anim view, but failure: " + B.f4201b);
                }
                return a2;
            }
        }
        return invokeLLLLL.booleanValue;
    }

    @Override // b.a.p0.a.f2.f.b
    public boolean p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, b.a.p0.a.d2.e eVar) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048579, this, context, unitedSchemeEntity, callbackHandler, str, eVar)) == null) {
            c q = q(unitedSchemeEntity);
            if (q == null) {
                b.a.p0.a.n2.u.a.b("animView", 1001, "update, model is null", 201, "model is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                d.c("AbsSwanAppWidget", "model is null");
                return false;
            } else if (!q.isValid()) {
                b.a.p0.a.n2.u.a.b("animView", 1001, "parse update params, but invalid", 201, "parse update params, but invalid");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                d.c("AbsSwanAppWidget", "parse update params, but invalid");
                return false;
            } else {
                b.a.p0.a.c0.c.a.b bVar = (b.a.p0.a.c0.c.a.b) b.a.p0.a.c0.d.a.a(q);
                if (bVar == null) {
                    b.a.p0.a.n2.u.a.b("animView", 2001, "get component is null", 1001, "get component is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    d.c("AbsSwanAppWidget", "get component is null");
                    return false;
                }
                b.a.p0.a.c0.b.c update = bVar.update((b.a.p0.a.c0.c.a.b) q);
                boolean a2 = update.a();
                d.b("AbsSwanAppWidget", "update anim view success = " + a2);
                if (a2) {
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                } else {
                    b.a.p0.a.n2.u.a.b("animView", 2001, "update anim view, but failure: " + update.f4201b, 1001, "update anim view, but failure: " + update.f4201b);
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, update.f4201b);
                    d.c("AbsSwanAppWidget", "update anim view, but failure: " + update.f4201b);
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
                d.c("SwanAppAction", "params is null");
                return null;
            }
            c cVar = new c();
            try {
                cVar.a(k);
            } catch (JSONException e2) {
                e2.printStackTrace();
                d.d("SwanAppAction", "model parse exception:", e2);
            }
            return cVar;
        }
        return (c) invokeL.objValue;
    }

    public final String r(String str, b.a.p0.a.d2.e eVar) {
        InterceptResult invokeLL;
        String L;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, eVar)) == null) {
            if (!TextUtils.isEmpty(str) && eVar != null) {
                try {
                    if ("bdfile".equalsIgnoreCase(URI.create(str).getScheme())) {
                        L = b.a.p0.a.o2.b.M(str, eVar.f4474f);
                    } else {
                        L = b.a.p0.a.o2.b.L(str, eVar, eVar.j0());
                    }
                    if (TextUtils.isEmpty(L)) {
                        return null;
                    }
                    File file = new File(L);
                    if (b.a.p0.w.d.y(file)) {
                        return b.a.p0.w.d.E(file);
                    }
                    return null;
                } catch (Exception e2) {
                    if (z.f5228b) {
                        e2.printStackTrace();
                    }
                }
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }
}
