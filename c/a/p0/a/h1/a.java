package c.a.p0.a.h1;

import android.content.Context;
import android.text.TextUtils;
import c.a.p0.a.c2.e;
import c.a.p0.a.c2.f.a0;
import c.a.p0.a.e0.d;
import c.a.p0.a.h1.c.c;
import c.a.p0.a.h1.c.f;
import c.a.p0.a.h1.c.g;
import c.a.p0.a.v2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(e eVar) {
        super(eVar, "/swanAPI/map");
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

    @Override // c.a.p0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (a0.f4766b) {
                String str = "handle entity: " + unitedSchemeEntity.toString();
                return false;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // c.a.p0.a.c2.f.a0
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, c.a.p0.a.a2.e eVar) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, eVar)) == null) {
            if (a0.f4766b) {
                String str2 = "handleSubAction subAction: " + str;
            }
            d.g("map", "handleSubAction " + str);
            b a2 = b.a(unitedSchemeEntity, callbackHandler);
            char c2 = 65535;
            switch (str.hashCode()) {
                case -2079680864:
                    if (str.equals("/swanAPI/map/translateMarker")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -2068557416:
                    if (str.equals("/swanAPI/map/getCenterLocation")) {
                        c2 = '\t';
                        break;
                    }
                    break;
                case -398143716:
                    if (str.equals("/swanAPI/map/getScale")) {
                        c2 = 7;
                        break;
                    }
                    break;
                case 51993511:
                    if (str.equals("/swanAPI/map/openLocation")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 379323012:
                    if (str.equals("/swanAPI/map/create")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 515840866:
                    if (str.equals("/swanAPI/map/getRegion")) {
                        c2 = '\b';
                        break;
                    }
                    break;
                case 797006348:
                    if (str.equals("/swanAPI/map/remove")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 892770897:
                    if (str.equals("/swanAPI/map/update")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 1007473955:
                    if (str.equals("/swanAPI/map/includePoints")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case 1142165295:
                    if (str.equals("/swanAPI/map/openWalkNavigation")) {
                        c2 = 11;
                        break;
                    }
                    break;
                case 1256916873:
                    if (str.equals("/swanAPI/map/moveToLocation")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 1475857524:
                    if (str.equals("/swanAPI/map/chooseLocation")) {
                        c2 = '\n';
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    c j2 = j(unitedSchemeEntity, c.class);
                    if (k(j2, a2)) {
                        return false;
                    }
                    return c.a.p0.a.c1.a.F().g(context, j2, a2, eVar);
                case 1:
                    c j3 = j(unitedSchemeEntity, c.class);
                    if (k(j3, a2)) {
                        return false;
                    }
                    return c.a.p0.a.c1.a.F().o(context, j3, a2, eVar);
                case 2:
                    c j4 = j(unitedSchemeEntity, c.class);
                    if (k(j4, a2)) {
                        return false;
                    }
                    return c.a.p0.a.c1.a.F().l(context, j4, a2, eVar);
                case 3:
                    f fVar = (f) j(unitedSchemeEntity, f.class);
                    if (k(fVar, a2)) {
                        return false;
                    }
                    return c.a.p0.a.c1.a.F().j(context, fVar, a2, eVar);
                case 4:
                    c.a.p0.a.h1.c.e eVar2 = (c.a.p0.a.h1.c.e) j(unitedSchemeEntity, c.a.p0.a.h1.c.e.class);
                    if (k(eVar2, a2)) {
                        return false;
                    }
                    return c.a.p0.a.c1.a.F().h(context, eVar2, a2, eVar);
                case 5:
                    c j5 = j(unitedSchemeEntity, c.class);
                    if (k(j5, a2)) {
                        return false;
                    }
                    return c.a.p0.a.c1.a.F().m(context, j5, a2, eVar);
                case 6:
                    c.a.p0.a.h1.c.b bVar = (c.a.p0.a.h1.c.b) j(unitedSchemeEntity, c.a.p0.a.h1.c.b.class);
                    if (k(bVar, a2)) {
                        return false;
                    }
                    return c.a.p0.a.c1.a.F().b(context, bVar, a2, eVar);
                case 7:
                    c j6 = j(unitedSchemeEntity, c.class);
                    if (k(j6, a2)) {
                        return false;
                    }
                    return c.a.p0.a.c1.a.F().c(context, j6, a2, eVar);
                case '\b':
                    c j7 = j(unitedSchemeEntity, c.class);
                    if (k(j7, a2)) {
                        return false;
                    }
                    return c.a.p0.a.c1.a.F().n(context, j7, a2, eVar);
                case '\t':
                    c j8 = j(unitedSchemeEntity, c.class);
                    if (k(j8, a2)) {
                        return false;
                    }
                    return c.a.p0.a.c1.a.F().k(context, j8, a2, eVar);
                case '\n':
                    c.a.p0.a.h1.c.a aVar = (c.a.p0.a.h1.c.a) j(unitedSchemeEntity, c.a.p0.a.h1.c.a.class);
                    if (k(aVar, a2)) {
                        return false;
                    }
                    return c.a.p0.a.c1.a.F().e(context, aVar, a2, eVar);
                case 11:
                    g gVar = (g) j(unitedSchemeEntity, g.class);
                    if (k(gVar, a2)) {
                        return false;
                    }
                    return c.a.p0.a.c1.a.F().a(context, gVar, a2, eVar);
                default:
                    return super.i(context, unitedSchemeEntity, callbackHandler, str, eVar);
            }
        }
        return invokeLLLLL.booleanValue;
    }

    public <T extends c> T j(UnitedSchemeEntity unitedSchemeEntity, Class<T> cls) {
        InterceptResult invokeLL;
        JSONObject jSONObject;
        T newInstance;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, unitedSchemeEntity, cls)) == null) {
            T t = null;
            if (unitedSchemeEntity == null) {
                return null;
            }
            HashMap<String, String> params = unitedSchemeEntity.getParams();
            if (params != null && !params.isEmpty()) {
                String str = params.get("params");
                if (str == null) {
                    d.b("map", "params string is empty");
                    return null;
                }
                try {
                    jSONObject = new JSONObject(str);
                    newInstance = cls.newInstance();
                } catch (Exception e2) {
                    e = e2;
                }
                try {
                    newInstance.a(jSONObject);
                    return newInstance;
                } catch (Exception e3) {
                    e = e3;
                    t = newInstance;
                    e.printStackTrace();
                    d.b("map", "params json parse error");
                    return t;
                }
            }
            d.b("map", "entity get Params is empty");
            return null;
        }
        return (T) invokeLL.objValue;
    }

    public final boolean k(c cVar, b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, cVar, bVar)) == null) {
            if (cVar == null) {
                d.b("map", "parse error, model is null");
                bVar.d(202);
                return true;
            }
            if (TextUtils.isEmpty(cVar.f4658g)) {
                String B = q0.B();
                if (!TextUtils.isEmpty(B)) {
                    cVar.f4658g = B;
                }
                d.l("map", "webView id is empty, use current webView");
            }
            if (q0.m(cVar.f4658g) == null) {
                bVar.d(202);
                d.b("map", "can not find weiView by id " + cVar.f4658g);
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
