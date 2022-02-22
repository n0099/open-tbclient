package c.a.s0.a.t1.m;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import c.a.s0.a.d2.e;
import c.a.s0.a.k;
import c.a.s0.a.u.c.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.poly.widget.PolyActivity;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.pay.panel.PaymentPanelManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends c.a.s0.a.t1.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f9121f;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-731933004, "Lc/a/s0/a/t1/m/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-731933004, "Lc/a/s0/a/t1/m/a;");
                return;
            }
        }
        f9121f = k.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.s0.a.u.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "PaymentPanelApi" : (String) invokeV.objValue;
    }

    public c.a.s0.a.u.h.b x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#chooseCoupon", false);
            e a0 = e.a0();
            if (a0 == null) {
                boolean z = f9121f;
                return new c.a.s0.a.u.h.b(1001, "swan app is null");
            }
            SwanAppActivity x = a0.x();
            if (x == null) {
                boolean z2 = f9121f;
                return new c.a.s0.a.u.h.b(1001, "swan activity is null");
            }
            Pair<c.a.s0.a.u.h.b, JSONObject> s = s(str);
            c.a.s0.a.u.h.b bVar = (c.a.s0.a.u.h.b) s.first;
            if (bVar.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    return new c.a.s0.a.u.h.b(202, "cb is empty");
                }
                String optString2 = jSONObject.optString("componentId");
                if (TextUtils.isEmpty(optString2)) {
                    return new c.a.s0.a.u.h.b(202, "empty componentId");
                }
                String optString3 = jSONObject.optString("appKey");
                if (TextUtils.isEmpty(optString3)) {
                    return new c.a.s0.a.u.h.b(202, "empty appKey");
                }
                String optString4 = jSONObject.optString("totalAmount");
                if (TextUtils.isEmpty(optString4)) {
                    return new c.a.s0.a.u.h.b(202, "empty totalAmount");
                }
                PaymentPanelManager.z().s(this, x, optString2, optString3, optString4, optString);
                return c.a.s0.a.u.h.b.f();
            }
            return bVar;
        }
        return (c.a.s0.a.u.h.b) invokeL.objValue;
    }

    public c.a.s0.a.u.h.b y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#getPaymentInfo", false);
            if (e.a0() == null) {
                boolean z = f9121f;
                return new c.a.s0.a.u.h.b(1001, "swan app is null");
            }
            Pair<c.a.s0.a.u.h.b, JSONObject> s = s(str);
            c.a.s0.a.u.h.b bVar = (c.a.s0.a.u.h.b) s.first;
            if (bVar.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    return new c.a.s0.a.u.h.b(202, "cb is empty");
                }
                String optString2 = jSONObject.optString("componentId");
                if (TextUtils.isEmpty(optString2)) {
                    return new c.a.s0.a.u.h.b(202, "empty componentId");
                }
                String optString3 = jSONObject.optString("dealId");
                if (TextUtils.isEmpty(optString3)) {
                    return new c.a.s0.a.u.h.b(202, "empty dealId");
                }
                String optString4 = jSONObject.optString("appKey");
                if (TextUtils.isEmpty(optString4)) {
                    return new c.a.s0.a.u.h.b(202, "empty appKey");
                }
                String optString5 = jSONObject.optString("totalAmount");
                if (TextUtils.isEmpty(optString5)) {
                    return new c.a.s0.a.u.h.b(202, "empty totalAmount");
                }
                PaymentPanelManager.z().C(this, optString2, optString3, optString4, optString5, optString);
                return c.a.s0.a.u.h.b.f();
            }
            return bVar;
        }
        return (c.a.s0.a.u.h.b) invokeL.objValue;
    }

    public c.a.s0.a.u.h.b z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            q("#setPaymentInfo", false);
            if (e.a0() == null) {
                boolean z = f9121f;
                return new c.a.s0.a.u.h.b(1001, "swan app is null");
            }
            Pair<c.a.s0.a.u.h.b, JSONObject> s = s(str);
            c.a.s0.a.u.h.b bVar = (c.a.s0.a.u.h.b) s.first;
            if (bVar.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    return new c.a.s0.a.u.h.b(202, "cb is empty");
                }
                String optString2 = jSONObject.optString("componentId");
                if (TextUtils.isEmpty(optString2)) {
                    return new c.a.s0.a.u.h.b(202, "empty componentId");
                }
                String optString3 = jSONObject.optString(PolyActivity.CHOSEN_CHANNEL_KEY);
                if (TextUtils.isEmpty(optString3)) {
                    return new c.a.s0.a.u.h.b(202, "empty chosenChannel");
                }
                PaymentPanelManager.z().J(this, optString2, optString3, optString);
                return c.a.s0.a.u.h.b.f();
            }
            return bVar;
        }
        return (c.a.s0.a.u.h.b) invokeL.objValue;
    }
}
