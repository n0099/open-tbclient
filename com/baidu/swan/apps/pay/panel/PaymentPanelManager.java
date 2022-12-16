package com.baidu.swan.apps.pay.panel;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.payment.PaymentManager;
import com.baidu.swan.apps.alliance.login.SwanAppAllianceLoginHelper;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.ab1;
import com.baidu.tieba.bb1;
import com.baidu.tieba.bx2;
import com.baidu.tieba.d43;
import com.baidu.tieba.ew1;
import com.baidu.tieba.k32;
import com.baidu.tieba.kk4;
import com.baidu.tieba.l33;
import com.baidu.tieba.ln2;
import com.baidu.tieba.m33;
import com.baidu.tieba.n32;
import com.baidu.tieba.ok1;
import com.baidu.tieba.pk1;
import com.baidu.tieba.rp2;
import com.baidu.tieba.ya1;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class PaymentPanelManager {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    @SuppressLint({"StaticFieldLeak"})
    public static volatile PaymentPanelManager e;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile HashMap<String, JSONArray> a;
    public volatile HashMap<String, c> b;
    public final PaymentManager c;

    /* loaded from: classes3.dex */
    public class b implements ya1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bx2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ JSONArray e;
        public final /* synthetic */ String f;
        public final /* synthetic */ PaymentPanelManager g;

        /* loaded from: classes3.dex */
        public class a implements ab1 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ JSONObject a;
            public final /* synthetic */ String b;
            public final /* synthetic */ JSONObject c;
            public final /* synthetic */ b d;

            public a(b bVar, JSONObject jSONObject, String str, JSONObject jSONObject2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, jSONObject, str, jSONObject2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.d = bVar;
                this.a = jSONObject;
                this.b = str;
                this.c = jSONObject2;
            }

            @Override // com.baidu.tieba.ab1
            public void a(JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                    if (jSONObject == null) {
                        b bVar = this.d;
                        bVar.a.d(bVar.b, new ew1(1002, "result data(price calculation) empty"));
                        this.d.g.D();
                    } else if (jSONObject.optInt("statusCode", -1) != 0) {
                        b bVar2 = this.d;
                        bVar2.a.d(bVar2.b, new ew1(1002, "result data(price calculation) error: error code is Non-zero"));
                        this.d.g.D();
                    } else {
                        try {
                            if (!this.d.g.r(jSONObject.optJSONArray("promotionStatus"), this.a)) {
                                this.d.g.G(this.d.e, this.b);
                                this.d.a.d(this.d.b, new ew1(1003, "invalid coupon"));
                                this.d.g.D();
                                return;
                            }
                            JSONObject x = this.d.g.x(jSONObject, this.c, "totalAmount", "userPayAmount", "reduceAmount");
                            if (x == null) {
                                b bVar3 = this.d;
                                bVar3.a.d(bVar3.b, new ew1(1002, "result data(price calculation) error: price"));
                                this.d.g.D();
                                return;
                            }
                            JSONObject jSONObject2 = new JSONObject();
                            try {
                                jSONObject2.put("couponInfo", x);
                                b bVar4 = this.d;
                                String y = bVar4.g.y(bVar4.f);
                                if (TextUtils.isEmpty(y)) {
                                    b bVar5 = this.d;
                                    bVar5.a.d(bVar5.b, new ew1(1001, "get inlinePaySign fail"));
                                    this.d.g.D();
                                    return;
                                }
                                this.d.g.I(y, this.b);
                                b bVar6 = this.d;
                                bVar6.g.K(bVar6.e, this.b);
                                b bVar7 = this.d;
                                bVar7.a.d(bVar7.b, new ew1(0, jSONObject2));
                                this.d.g.D();
                            } catch (JSONException e) {
                                if (PaymentPanelManager.d) {
                                    Log.d("PaymentPanelManager", Log.getStackTraceString(e));
                                }
                                b bVar8 = this.d;
                                bVar8.a.d(bVar8.b, new ew1(1002, "result data(price calculation) error: unknown"));
                                this.d.g.D();
                            }
                        } catch (ServerResultException e2) {
                            if (PaymentPanelManager.d) {
                                Log.d("PaymentPanelManager", Log.getStackTraceString(e2));
                            }
                            b bVar9 = this.d;
                            bVar9.a.d(bVar9.b, new ew1(1002, "result data(price calculation) error: format or content"));
                            this.d.g.D();
                        }
                    }
                }
            }
        }

        public b(PaymentPanelManager paymentPanelManager, bx2 bx2Var, String str, String str2, String str3, JSONArray jSONArray, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {paymentPanelManager, bx2Var, str, str2, str3, jSONArray, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = paymentPanelManager;
            this.a = bx2Var;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = jSONArray;
            this.f = str4;
        }

        @Override // com.baidu.tieba.ya1
        public void a(boolean z, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, jSONObject) == null) {
                if (!z) {
                    this.a.d(this.b, new ew1(0));
                } else if (jSONObject == null) {
                    this.a.d(this.b, new ew1(1002, "selected coupon result is null"));
                } else {
                    String w = this.g.w(jSONObject);
                    if (TextUtils.isEmpty(w)) {
                        this.a.d(this.b, new ew1(1002, "selected coupon result error: empty host info"));
                        return;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString("appKey", this.c);
                    bundle.putString("totalAmount", this.d);
                    JSONArray jSONArray = new JSONArray();
                    try {
                        JSONObject jSONObject2 = new JSONObject(w);
                        jSONArray.put(jSONObject2);
                        bundle.putString("hostMarketingDetail", jSONArray.toString());
                        this.g.o(bundle);
                        this.g.L();
                        this.g.c.n(bundle, new a(this, jSONObject2, w, jSONObject));
                    } catch (JSONException e) {
                        if (PaymentPanelManager.d) {
                            Log.d("PaymentPanelManager", Log.getStackTraceString(e));
                        }
                        this.a.d(this.b, new ew1(1002, "selected coupon result error: host info error"));
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class ServerResultException extends Exception {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ServerResultException(String str) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class a implements bb1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bx2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ PaymentPanelManager d;

        public a(PaymentPanelManager paymentPanelManager, bx2 bx2Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {paymentPanelManager, bx2Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = paymentPanelManager;
            this.a = bx2Var;
            this.b = str;
            this.c = str2;
        }

        @Override // com.baidu.tieba.bb1
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                bx2 bx2Var = this.a;
                String str2 = this.b;
                bx2Var.d(str2, new ew1(1002, str + ""));
                this.d.D();
            }
        }

        @Override // com.baidu.tieba.bb1
        public void onSuccess(String str) {
            JSONArray jSONArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.d.D();
                if (TextUtils.isEmpty(str)) {
                    this.a.d(this.b, new ew1(1002, "result data(panel info) empty"));
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    boolean isNull = jSONObject.isNull("coupons");
                    Object remove = jSONObject.remove("coupons");
                    JSONObject jSONObject2 = null;
                    if (!isNull) {
                        if (!(remove instanceof JSONArray)) {
                            this.a.d(this.b, new ew1(1002, "result data(panel info) error: coupons"));
                            return;
                        }
                        jSONArray = (JSONArray) remove;
                        if (jSONArray.length() > 0 && (jSONObject2 = this.d.u(jSONArray)) == null) {
                            this.a.d(this.b, new ew1(1002, "result data(panel info) error: default coupon"));
                            return;
                        }
                    } else {
                        jSONArray = null;
                    }
                    JSONObject q = this.d.q(jSONArray, jSONObject2, this.c);
                    JSONObject x = this.d.x(jSONObject, q, "totalMoney", "payMoney", "reduceMoney");
                    if (x == null) {
                        this.a.d(this.b, new ew1(1002, "result data(panel info) error: price"));
                        return;
                    }
                    jSONObject.put("couponInfo", x);
                    String y = this.d.y(this.c);
                    if (TextUtils.isEmpty(y)) {
                        this.a.d(this.b, new ew1(1001, "get inlinePaySign fail"));
                        return;
                    }
                    this.d.I(y, this.d.w(q));
                    JSONObject jSONObject3 = new JSONObject();
                    this.d.a.put(this.c, jSONArray);
                    jSONObject3.put("panelInfo", jSONObject);
                    this.a.d(this.b, new ew1(0, jSONObject3));
                } catch (JSONException e) {
                    if (PaymentPanelManager.d) {
                        Log.d("PaymentPanelManager", Log.getStackTraceString(e));
                    }
                    this.a.d(this.b, new ew1(1001, "result data(panel info) error: unknown"));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2066880565, "Lcom/baidu/swan/apps/pay/panel/PaymentPanelManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2066880565, "Lcom/baidu/swan/apps/pay/panel/PaymentPanelManager;");
                return;
            }
        }
        d = ok1.a;
    }

    public static void F() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, null) == null) && e != null) {
            e.t();
            e = null;
        }
    }

    public static PaymentPanelManager z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
            if (e == null) {
                synchronized (PaymentPanelManager.class) {
                    if (e == null) {
                        e = new PaymentPanelManager();
                    }
                }
            }
            return e;
        }
        return (PaymentPanelManager) invokeV.objValue;
    }

    public final void D() {
        n32 V;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || (V = rp2.U().V()) == null) {
            return;
        }
        k32 m = V.m();
        if (!(m instanceof l33.a)) {
            return;
        }
        m33.c(m);
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.a = new HashMap<>();
            this.b = new HashMap<>();
        }
    }

    public PaymentPanelManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new HashMap<>();
        this.b = new HashMap<>();
        this.c = new PaymentManager();
    }

    public final void L() {
        n32 V;
        FragmentActivity activity;
        l33 d2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048586, this) != null) || (V = rp2.U().V()) == null) {
            return;
        }
        k32 m = V.m();
        if (!(m instanceof l33.a) || (activity = m.getActivity()) == null || (d2 = ((l33.a) m).d()) == null) {
            return;
        }
        d2.l(false);
        m33.f(d2, activity, activity.getString(R.string.obfuscated_res_0x7f0f019f), true);
    }

    public String A(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            c cVar = this.b.get(str);
            if (cVar == null) {
                return null;
            }
            return cVar.a;
        }
        return (String) invokeL.objValue;
    }

    public String B(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            c cVar = this.b.get(str);
            if (cVar == null) {
                return null;
            }
            return cVar.b;
        }
        return (String) invokeL.objValue;
    }

    public final String w(@Nullable JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            return E(jSONObject, "host_marketing_detail");
        }
        return (String) invokeL.objValue;
    }

    public final String E(@NonNull JSONObject jSONObject, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, jSONObject, str)) == null) {
            if (jSONObject.isNull(str)) {
                return null;
            }
            return jSONObject.optString(str);
        }
        return (String) invokeLL.objValue;
    }

    public final void G(@NonNull JSONArray jSONArray, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, jSONArray, str) == null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null && TextUtils.equals(E(optJSONObject, "host_marketing_detail"), str)) {
                    jSONArray.remove(i);
                }
            }
        }
    }

    public final void H(@NonNull String str, @Nullable String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) {
            c cVar = this.b.get(str);
            if (cVar == null) {
                cVar = new c(null);
                this.b.put(str, cVar);
            }
            cVar.a = str2;
        }
    }

    public final void I(@NonNull String str, @Nullable String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, str2) == null) {
            c cVar = this.b.get(str);
            if (cVar == null) {
                cVar = new c(null);
                this.b.put(str, cVar);
            }
            cVar.b = str2;
        }
    }

    public void C(@NonNull bx2 bx2Var, @NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4, @NonNull String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{bx2Var, str, str2, str3, str4, str5}) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("dealId", str2);
            bundle.putString("appKey", str3);
            bundle.putString("totalAmount", str4);
            p(bundle);
            L();
            this.c.m(bundle, new a(this, bx2Var, str5, str));
        }
    }

    public void s(@NonNull bx2 bx2Var, Activity activity, @NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{bx2Var, activity, str, str2, str3, str4}) == null) {
            JSONArray jSONArray = this.a.get(str);
            if (jSONArray == null) {
                bx2Var.d(str4, new ew1(1001, "empty coupons list"));
            } else {
                this.c.l(activity, jSONArray, new b(this, bx2Var, str4, str2, str3, jSONArray, str));
            }
        }
    }

    public void J(@NonNull bx2 bx2Var, @NonNull String str, @NonNull String str2, @NonNull String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bx2Var, str, str2, str3) == null) {
            JSONObject jSONObject = new JSONObject();
            String y = y(str);
            if (TextUtils.isEmpty(y)) {
                bx2Var.d(str3, new ew1(1001, "get inlinePaySign fail: inline pay key is empty!"));
                return;
            }
            try {
                jSONObject.put("inlinePaySign", y);
                H(y, str2);
                bx2Var.d(str3, new ew1(0, jSONObject));
            } catch (JSONException e2) {
                if (d) {
                    Log.d("PaymentPanelManager", Log.getStackTraceString(e2));
                }
                bx2Var.d(str3, new ew1(1001, "get inlinePaySign fail"));
            }
        }
    }

    public final void K(@NonNull JSONArray jSONArray, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, jSONArray, str) == null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    try {
                        optJSONObject.put("is_selected", 0);
                        if (TextUtils.equals(E(optJSONObject, "host_marketing_detail"), str)) {
                            optJSONObject.put("is_selected", 1);
                        }
                    } catch (JSONException e2) {
                        if (d) {
                            Log.d("PaymentPanelManager", Log.getStackTraceString(e2));
                        }
                    }
                }
            }
        }
    }

    public final JSONObject v(JSONArray jSONArray, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, jSONArray, str)) == null) {
            if (jSONArray == null || TextUtils.isEmpty(str)) {
                return null;
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null && TextUtils.equals(E(optJSONObject, "host_marketing_detail"), str)) {
                    return optJSONObject;
                }
            }
            return null;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public final void o(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
            if (SwanAppAllianceLoginHelper.d.f()) {
                bundle.putString("openBduss", ln2.h0().d(ln2.c()));
                bundle.putString("clientId", ln2.n().b());
                return;
            }
            bundle.putString("bduss", ln2.h0().d(ln2.c()));
        }
    }

    public final void p(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bundle) == null) {
            o(bundle);
            bundle.putString("deviceType", "ANDROID");
            bundle.putString("cuid", ln2.h0().i(ln2.c()));
            bundle.putString("channel", "cashiersdk");
            bundle.putString("nativeAppId", ln2.n().a());
            bundle.putString(ConstantsAPI.Token.WX_TOKEN_PLATFORMID_KEY, "100003");
            bundle.putString("swanNativeVersion", pk1.a());
        }
    }

    public final JSONObject q(JSONArray jSONArray, JSONObject jSONObject, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048589, this, jSONArray, jSONObject, str)) == null) {
            if (jSONArray == null) {
                return jSONObject;
            }
            String y = y(str);
            if (TextUtils.isEmpty(y)) {
                return jSONObject;
            }
            c cVar = this.b.get(y);
            if (cVar == null) {
                return jSONObject;
            }
            String str2 = cVar.b;
            if (str2 == null) {
                return jSONObject;
            }
            JSONObject v = v(jSONArray, str2);
            if (v == null) {
                return jSONObject;
            }
            K(jSONArray, cVar.b);
            return v;
        }
        return (JSONObject) invokeLLL.objValue;
    }

    public final boolean r(@Nullable JSONArray jSONArray, @Nullable JSONObject jSONObject) throws ServerResultException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, jSONArray, jSONObject)) == null) {
            if (jSONArray != null && jSONObject != null) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        String E = E(jSONObject, "promotionInsId");
                        String E2 = E(optJSONObject, "promotionInsId");
                        if (!TextUtils.isEmpty(E) && !TextUtils.isEmpty(E2)) {
                            if (TextUtils.equals(E, E2)) {
                                String E3 = E(optJSONObject, "valid");
                                if (!TextUtils.isEmpty(E3)) {
                                    return TextUtils.equals(E3, "1");
                                }
                                throw new ServerResultException("Calculate the price result error");
                            }
                        } else {
                            throw new ServerResultException("Calculate the price result error");
                        }
                    } else {
                        throw new ServerResultException("Calculate the price result error");
                    }
                }
                throw new ServerResultException("Calculate the price result error");
            }
            throw new ServerResultException("Calculate the price result error");
        }
        return invokeLL.booleanValue;
    }

    public final JSONObject u(@NonNull JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, jSONArray)) == null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    if (jSONObject.optInt("is_selected") == 1) {
                        return jSONObject;
                    }
                } catch (JSONException e2) {
                    if (d) {
                        Log.d("PaymentPanelManager", Log.getStackTraceString(e2));
                    }
                }
            }
            return null;
        }
        return (JSONObject) invokeL.objValue;
    }

    public final String y(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) {
            return kk4.d((d43.K().getAppId() + "_" + str).getBytes(), true);
        }
        return (String) invokeL.objValue;
    }

    public final JSONObject x(@NonNull JSONObject jSONObject, @Nullable JSONObject jSONObject2, @NonNull String str, @NonNull String str2, @NonNull String str3) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048596, this, jSONObject, jSONObject2, str, str2, str3)) == null) {
            JSONObject jSONObject3 = new JSONObject();
            if (jSONObject2 != null) {
                try {
                    jSONObject3.put("chosenCoupon", jSONObject2);
                } catch (JSONException e2) {
                    if (d) {
                        Log.d("PaymentPanelManager", Log.getStackTraceString(e2));
                        return null;
                    }
                    return null;
                }
            }
            jSONObject3.put("totalAmount", jSONObject.getLong(str));
            jSONObject3.put("userPayAmount", jSONObject.getLong(str2));
            jSONObject3.put("reduceAmount", jSONObject.getLong(str3));
            return jSONObject3;
        }
        return (JSONObject) invokeLLLLL.objValue;
    }
}
