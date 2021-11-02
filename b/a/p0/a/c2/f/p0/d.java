package b.a.p0.a.c2.f.p0;

import android.content.Context;
import android.text.TextUtils;
import b.a.p0.a.c2.f.a0;
import b.a.p0.a.h0.g.g;
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
public class d extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(b.a.p0.a.c2.e eVar) {
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

    @Override // b.a.p0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b.a.p0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        int optInt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (a0.f4160b) {
                String str = "handle entity: " + unitedSchemeEntity.toString();
            }
            String uuid = UUID.randomUUID().toString();
            b.a.p0.a.r1.i.b(uuid);
            String str2 = unitedSchemeEntity.getParams().get("params");
            if (TextUtils.isEmpty(str2)) {
                optInt = 1;
            } else {
                try {
                    optInt = new JSONObject(str2).optInt("delta", 1);
                } catch (JSONException e2) {
                    if (a0.f4160b) {
                        e2.printStackTrace();
                    }
                    b.a.p0.a.e0.d.b("navigateBack", "params parse fail");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    return false;
                }
            }
            b.a.p0.a.h0.g.g U = b.a.p0.a.g1.f.T().U();
            if (U == null) {
                b.a.p0.a.e0.d.b("navigateBack", "fragmentManager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            int k = U.k();
            if (a0.f4160b) {
                String str3 = "back delta: " + optInt;
            }
            if (k == 1) {
                b.a.p0.a.e0.d.b("NavigateBackAction", "navigateBack api can only work when slave's count greater than 1");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "navigateBack api can only work when slave's count greater than 1");
                return false;
            }
            if (optInt >= k) {
                optInt = k - 1;
            }
            if (a0.f4160b) {
                String str4 = "real back delta: " + optInt;
            }
            b.a.p0.a.h0.g.d j = U.j((k - optInt) - 1);
            b.a.p0.a.j2.h.f((j == null || j.E1() == null) ? "" : j.E1().g(), "1");
            b.a.p0.a.r1.i.c(1, uuid);
            b.a.p0.a.v2.g.a(U, context);
            g.b i2 = U.i("navigateBack");
            i2.n(b.a.p0.a.h0.g.g.f5282i, b.a.p0.a.h0.g.g.f5281h);
            i2.h(optInt);
            i2.a();
            b.a.p0.a.h0.g.f o = U.o();
            b.a.p0.a.l1.b T2 = o == null ? null : o.T2();
            b.a.p0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, uuid).C(new UbcFlowEvent("na_push_page_end"));
            b.a.p0.a.r1.i.a(uuid, T2);
            if (!(U.m() instanceof b.a.p0.a.h0.g.f)) {
                b.a.p0.a.e0.d.b("navigateBack", "top fragment error");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            }
            b.a.p0.a.h0.g.f fVar = (b.a.p0.a.h0.g.f) U.m();
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(a.c(fVar != null ? fVar.a3() : ""), 0));
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
