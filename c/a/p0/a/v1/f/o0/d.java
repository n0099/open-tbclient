package c.a.p0.a.v1.f.o0;

import android.content.Context;
import android.text.TextUtils;
import c.a.p0.a.v1.f.z;
import c.a.p0.a.x.g.g;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes.dex */
public class d extends z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(c.a.p0.a.v1.e eVar) {
        super(eVar, "/swanAPI/navigateBack");
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

    @Override // c.a.p0.a.v1.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.t1.e eVar) {
        InterceptResult invokeLLLL;
        int optInt;
        c.a.p0.a.c1.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (z.f8176b) {
                String str = "handle entity: " + unitedSchemeEntity.toString();
            }
            String uuid = UUID.randomUUID().toString();
            c.a.p0.a.k1.i.b(uuid);
            String str2 = unitedSchemeEntity.getParams().get("params");
            if (TextUtils.isEmpty(str2)) {
                optInt = 1;
            } else {
                try {
                    optInt = new JSONObject(str2).optInt("delta", 1);
                } catch (JSONException e2) {
                    if (z.f8176b) {
                        e2.printStackTrace();
                    }
                    c.a.p0.a.u.d.c("navigateBack", "params parse fail");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    return false;
                }
            }
            c.a.p0.a.x.g.g V = c.a.p0.a.w0.f.U().V();
            if (V == null) {
                c.a.p0.a.u.d.c("navigateBack", "fragmentManager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            int k = V.k();
            if (z.f8176b) {
                String str3 = "back delta: " + optInt;
            }
            if (k == 1) {
                c.a.p0.a.u.d.c("NavigateBackAction", "navigateBack api can only work when slave's count greater than 1");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "navigateBack api can only work when slave's count greater than 1");
                return false;
            }
            if (optInt >= k) {
                optInt = k - 1;
            }
            if (z.f8176b) {
                String str4 = "real back delta: " + optInt;
            }
            c.a.p0.a.x.g.d j2 = V.j((k - optInt) - 1);
            if (j2 instanceof c.a.p0.a.x.g.f) {
                bVar = ((c.a.p0.a.x.g.f) j2).g3();
                bVar.f4646i = "1";
                bVar.f4647j = uuid;
            } else {
                bVar = null;
            }
            c.a.p0.a.d2.i.g(bVar);
            c.a.p0.a.k1.i.c(1, uuid);
            c.a.p0.a.p2.g.a(V, context);
            g.b i2 = V.i("navigateBack");
            i2.n(c.a.p0.a.x.g.g.f8376i, c.a.p0.a.x.g.g.f8375h);
            i2.h(optInt);
            i2.a();
            c.a.p0.a.x.g.f o = V.o();
            c.a.p0.a.c1.b g3 = o != null ? o.g3() : null;
            c.a.p0.a.k1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, uuid).F(new UbcFlowEvent("na_push_page_end"));
            c.a.p0.a.k1.i.a(uuid, g3);
            if (!(V.m() instanceof c.a.p0.a.x.g.f)) {
                c.a.p0.a.u.d.c("navigateBack", "top fragment error");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                c.a.p0.a.d2.i.i(bVar);
                return false;
            }
            c.a.p0.a.x.g.f fVar = (c.a.p0.a.x.g.f) V.m();
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(a.c(fVar != null ? fVar.n3() : ""), 0));
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
