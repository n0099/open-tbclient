package com.baidu.swan.apps.pay.panel;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.c0.e.d;
import c.a.n0.a.s1.b.c.a;
import c.a.n0.a.w0.f;
import c.a.n0.a.x.g.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.payment.PaymentManager;
import com.baidu.swan.apps.alliance.login.SwanAppAllianceLoginHelper;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class PaymentPanelManager {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f28994d;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: e  reason: collision with root package name */
    public static volatile PaymentPanelManager f28995e;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile HashMap<String, JSONArray> a;

    /* renamed from: b  reason: collision with root package name */
    public volatile HashMap<String, c> f28996b;

    /* renamed from: c  reason: collision with root package name */
    public final PaymentManager f28997c;

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public class a implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.j1.m.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f28998b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f28999c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ PaymentPanelManager f29000d;

        public a(PaymentPanelManager paymentPanelManager, c.a.n0.a.j1.m.a aVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {paymentPanelManager, aVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29000d = paymentPanelManager;
            this.a = aVar;
            this.f28998b = str;
            this.f28999c = str2;
        }

        @Override // c.a.c0.e.d
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                c.a.n0.a.j1.m.a aVar = this.a;
                String str2 = this.f28998b;
                aVar.d(str2, new c.a.n0.a.k.h.b(1002, str + ""));
                this.f29000d.D();
            }
        }

        @Override // c.a.c0.e.d
        public void onSuccess(String str) {
            JSONArray jSONArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.f29000d.D();
                if (TextUtils.isEmpty(str)) {
                    this.a.d(this.f28998b, new c.a.n0.a.k.h.b(1002, "result data(panel info) empty"));
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    boolean isNull = jSONObject.isNull("coupons");
                    Object remove = jSONObject.remove("coupons");
                    JSONObject jSONObject2 = null;
                    if (isNull) {
                        jSONArray = null;
                    } else if (!(remove instanceof JSONArray)) {
                        this.a.d(this.f28998b, new c.a.n0.a.k.h.b(1002, "result data(panel info) error: coupons"));
                        return;
                    } else {
                        jSONArray = (JSONArray) remove;
                        if (jSONArray.length() > 0 && (jSONObject2 = this.f29000d.u(jSONArray)) == null) {
                            this.a.d(this.f28998b, new c.a.n0.a.k.h.b(1002, "result data(panel info) error: default coupon"));
                            return;
                        }
                    }
                    JSONObject q = this.f29000d.q(jSONArray, jSONObject2, this.f28999c);
                    JSONObject x = this.f29000d.x(jSONObject, q, "totalMoney", "payMoney", "reduceMoney");
                    if (x == null) {
                        this.a.d(this.f28998b, new c.a.n0.a.k.h.b(1002, "result data(panel info) error: price"));
                        return;
                    }
                    jSONObject.put("couponInfo", x);
                    String y = this.f29000d.y(this.f28999c);
                    if (!TextUtils.isEmpty(y)) {
                        this.f29000d.I(y, this.f29000d.w(q));
                        JSONObject jSONObject3 = new JSONObject();
                        this.f29000d.a.put(this.f28999c, jSONArray);
                        jSONObject3.put("panelInfo", jSONObject);
                        this.a.d(this.f28998b, new c.a.n0.a.k.h.b(0, jSONObject3));
                        return;
                    }
                    this.a.d(this.f28998b, new c.a.n0.a.k.h.b(1001, "get inlinePaySign fail"));
                } catch (JSONException e2) {
                    if (PaymentPanelManager.f28994d) {
                        Log.d("PaymentPanelManager", Log.getStackTraceString(e2));
                    }
                    this.a.d(this.f28998b, new c.a.n0.a.k.h.b(1001, "result data(panel info) error: unknown"));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements c.a.c0.e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.j1.m.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f29001b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f29002c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f29003d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONArray f29004e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f29005f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ PaymentPanelManager f29006g;

        /* loaded from: classes4.dex */
        public class a implements c.a.c0.e.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ JSONObject a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f29007b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ JSONObject f29008c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ b f29009d;

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
                this.f29009d = bVar;
                this.a = jSONObject;
                this.f29007b = str;
                this.f29008c = jSONObject2;
            }

            @Override // c.a.c0.e.c
            public void a(JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                    if (jSONObject == null) {
                        b bVar = this.f29009d;
                        bVar.a.d(bVar.f29001b, new c.a.n0.a.k.h.b(1002, "result data(price calculation) empty"));
                        this.f29009d.f29006g.D();
                    } else if (jSONObject.optInt("statusCode", -1) == 0) {
                        try {
                            if (!this.f29009d.f29006g.r(jSONObject.optJSONArray("promotionStatus"), this.a)) {
                                this.f29009d.f29006g.G(this.f29009d.f29004e, this.f29007b);
                                this.f29009d.a.d(this.f29009d.f29001b, new c.a.n0.a.k.h.b(1003, "invalid coupon"));
                                this.f29009d.f29006g.D();
                                return;
                            }
                            JSONObject x = this.f29009d.f29006g.x(jSONObject, this.f29008c, "totalAmount", "userPayAmount", "reduceAmount");
                            if (x == null) {
                                b bVar2 = this.f29009d;
                                bVar2.a.d(bVar2.f29001b, new c.a.n0.a.k.h.b(1002, "result data(price calculation) error: price"));
                                this.f29009d.f29006g.D();
                                return;
                            }
                            JSONObject jSONObject2 = new JSONObject();
                            try {
                                jSONObject2.put("couponInfo", x);
                                b bVar3 = this.f29009d;
                                String y = bVar3.f29006g.y(bVar3.f29005f);
                                if (!TextUtils.isEmpty(y)) {
                                    this.f29009d.f29006g.I(y, this.f29007b);
                                    b bVar4 = this.f29009d;
                                    bVar4.f29006g.K(bVar4.f29004e, this.f29007b);
                                    b bVar5 = this.f29009d;
                                    bVar5.a.d(bVar5.f29001b, new c.a.n0.a.k.h.b(0, jSONObject2));
                                    this.f29009d.f29006g.D();
                                    return;
                                }
                                b bVar6 = this.f29009d;
                                bVar6.a.d(bVar6.f29001b, new c.a.n0.a.k.h.b(1001, "get inlinePaySign fail"));
                                this.f29009d.f29006g.D();
                            } catch (JSONException e2) {
                                if (PaymentPanelManager.f28994d) {
                                    Log.d("PaymentPanelManager", Log.getStackTraceString(e2));
                                }
                                b bVar7 = this.f29009d;
                                bVar7.a.d(bVar7.f29001b, new c.a.n0.a.k.h.b(1002, "result data(price calculation) error: unknown"));
                                this.f29009d.f29006g.D();
                            }
                        } catch (ServerResultException e3) {
                            if (PaymentPanelManager.f28994d) {
                                Log.d("PaymentPanelManager", Log.getStackTraceString(e3));
                            }
                            b bVar8 = this.f29009d;
                            bVar8.a.d(bVar8.f29001b, new c.a.n0.a.k.h.b(1002, "result data(price calculation) error: format or content"));
                            this.f29009d.f29006g.D();
                        }
                    } else {
                        b bVar9 = this.f29009d;
                        bVar9.a.d(bVar9.f29001b, new c.a.n0.a.k.h.b(1002, "result data(price calculation) error: error code is Non-zero"));
                        this.f29009d.f29006g.D();
                    }
                }
            }
        }

        public b(PaymentPanelManager paymentPanelManager, c.a.n0.a.j1.m.a aVar, String str, String str2, String str3, JSONArray jSONArray, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {paymentPanelManager, aVar, str, str2, str3, jSONArray, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29006g = paymentPanelManager;
            this.a = aVar;
            this.f29001b = str;
            this.f29002c = str2;
            this.f29003d = str3;
            this.f29004e = jSONArray;
            this.f29005f = str4;
        }

        @Override // c.a.c0.e.a
        public void a(boolean z, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, jSONObject) == null) {
                if (!z) {
                    this.a.d(this.f29001b, new c.a.n0.a.k.h.b(0));
                } else if (jSONObject != null) {
                    String w = this.f29006g.w(jSONObject);
                    if (TextUtils.isEmpty(w)) {
                        this.a.d(this.f29001b, new c.a.n0.a.k.h.b(1002, "selected coupon result error: empty host info"));
                        return;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString("appKey", this.f29002c);
                    bundle.putString("totalAmount", this.f29003d);
                    JSONArray jSONArray = new JSONArray();
                    try {
                        JSONObject jSONObject2 = new JSONObject(w);
                        jSONArray.put(jSONObject2);
                        bundle.putString("hostMarketingDetail", jSONArray.toString());
                        this.f29006g.o(bundle);
                        this.f29006g.L();
                        this.f29006g.f28997c.n(bundle, new a(this, jSONObject2, w, jSONObject));
                    } catch (JSONException e2) {
                        if (PaymentPanelManager.f28994d) {
                            Log.d("PaymentPanelManager", Log.getStackTraceString(e2));
                        }
                        this.a.d(this.f29001b, new c.a.n0.a.k.h.b(1002, "selected coupon result error: host info error"));
                    }
                } else {
                    this.a.d(this.f29001b, new c.a.n0.a.k.h.b(1002, "selected coupon result is null"));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f29010b;

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
        f28994d = c.a.n0.a.a.a;
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
        this.f28996b = new HashMap<>();
        this.f28997c = new PaymentManager();
    }

    public static void F() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, null) == null) || f28995e == null) {
            return;
        }
        f28995e.t();
        f28995e = null;
    }

    public static PaymentPanelManager z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
            if (f28995e == null) {
                synchronized (PaymentPanelManager.class) {
                    if (f28995e == null) {
                        f28995e = new PaymentPanelManager();
                    }
                }
            }
            return f28995e;
        }
        return (PaymentPanelManager) invokeV.objValue;
    }

    public String A(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            c cVar = this.f28996b.get(str);
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
            c cVar = this.f28996b.get(str);
            if (cVar == null) {
                return null;
            }
            return cVar.f29010b;
        }
        return (String) invokeL.objValue;
    }

    public void C(@NonNull c.a.n0.a.j1.m.a aVar, @NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4, @NonNull String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{aVar, str, str2, str3, str4, str5}) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("dealId", str2);
            bundle.putString("appKey", str3);
            bundle.putString("totalAmount", str4);
            p(bundle);
            L();
            this.f28997c.m(bundle, new a(this, aVar, str5, str));
        }
    }

    public final void D() {
        g V;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (V = f.U().V()) == null) {
            return;
        }
        c.a.n0.a.x.g.d m = V.m();
        if (m instanceof a.InterfaceC0451a) {
            c.a.n0.a.s1.b.d.a.c(m);
        }
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
            c cVar = this.f28996b.get(str);
            if (cVar == null) {
                cVar = new c(null);
                this.f28996b.put(str, cVar);
            }
            cVar.a = str2;
        }
    }

    public final void I(@NonNull String str, @Nullable String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, str2) == null) {
            c cVar = this.f28996b.get(str);
            if (cVar == null) {
                cVar = new c(null);
                this.f28996b.put(str, cVar);
            }
            cVar.f29010b = str2;
        }
    }

    public void J(@NonNull c.a.n0.a.j1.m.a aVar, @NonNull String str, @NonNull String str2, @NonNull String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar, str, str2, str3) == null) {
            JSONObject jSONObject = new JSONObject();
            String y = y(str);
            if (TextUtils.isEmpty(y)) {
                aVar.d(str3, new c.a.n0.a.k.h.b(1001, "get inlinePaySign fail: inline pay key is empty!"));
                return;
            }
            try {
                jSONObject.put("inlinePaySign", y);
                H(y, str2);
                aVar.d(str3, new c.a.n0.a.k.h.b(0, jSONObject));
            } catch (JSONException e2) {
                if (f28994d) {
                    Log.d("PaymentPanelManager", Log.getStackTraceString(e2));
                }
                aVar.d(str3, new c.a.n0.a.k.h.b(1001, "get inlinePaySign fail"));
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
                        if (f28994d) {
                            Log.d("PaymentPanelManager", Log.getStackTraceString(e2));
                        }
                    }
                }
            }
        }
    }

    public final void L() {
        g V;
        FragmentActivity activity;
        c.a.n0.a.s1.b.c.a floatLayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (V = f.U().V()) == null) {
            return;
        }
        c.a.n0.a.x.g.d m = V.m();
        if (!(m instanceof a.InterfaceC0451a) || (activity = m.getActivity()) == null || (floatLayer = ((a.InterfaceC0451a) m).getFloatLayer()) == null) {
            return;
        }
        floatLayer.l(false);
        c.a.n0.a.s1.b.d.a.f(floatLayer, activity, activity.getString(R.string.obfuscated_res_0x7f0f0191), true);
    }

    public final void o(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
            if (SwanAppAllianceLoginHelper.f28743d.f()) {
                bundle.putString("openBduss", c.a.n0.a.s0.a.h0().d(c.a.n0.a.s0.a.c()));
                bundle.putString("clientId", c.a.n0.a.s0.a.n().b());
                return;
            }
            bundle.putString("bduss", c.a.n0.a.s0.a.h0().d(c.a.n0.a.s0.a.c()));
        }
    }

    public final void p(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bundle) == null) {
            o(bundle);
            bundle.putString("deviceType", "ANDROID");
            bundle.putString("cuid", c.a.n0.a.s0.a.h0().i(c.a.n0.a.s0.a.c()));
            bundle.putString("channel", "cashiersdk");
            bundle.putString("nativeAppId", c.a.n0.a.s0.a.n().a());
            bundle.putString("platformId", "100003");
            bundle.putString("swanNativeVersion", c.a.n0.a.b.a());
        }
    }

    public final JSONObject q(JSONArray jSONArray, JSONObject jSONObject, String str) {
        InterceptResult invokeLLL;
        c cVar;
        String str2;
        JSONObject v;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048589, this, jSONArray, jSONObject, str)) == null) {
            if (jSONArray == null) {
                return jSONObject;
            }
            String y = y(str);
            if (TextUtils.isEmpty(y) || (cVar = this.f28996b.get(y)) == null || (str2 = cVar.f29010b) == null || (v = v(jSONArray, str2)) == null) {
                return jSONObject;
            }
            K(jSONArray, cVar.f29010b);
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

    public void s(@NonNull c.a.n0.a.j1.m.a aVar, Activity activity, @NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{aVar, activity, str, str2, str3, str4}) == null) {
            JSONArray jSONArray = this.a.get(str);
            if (jSONArray == null) {
                aVar.d(str4, new c.a.n0.a.k.h.b(1001, "empty coupons list"));
            } else {
                this.f28997c.l(activity, jSONArray, new b(this, aVar, str4, str2, str3, jSONArray, str));
            }
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.a = new HashMap<>();
            this.f28996b = new HashMap<>();
        }
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
                    if (f28994d) {
                        Log.d("PaymentPanelManager", Log.getStackTraceString(e2));
                    }
                }
            }
            return null;
        }
        return (JSONObject) invokeL.objValue;
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

    public final JSONObject x(@NonNull JSONObject jSONObject, @Nullable JSONObject jSONObject2, @NonNull String str, @NonNull String str2, @NonNull String str3) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048596, this, jSONObject, jSONObject2, str, str2, str3)) == null) {
            JSONObject jSONObject3 = new JSONObject();
            if (jSONObject2 != null) {
                try {
                    jSONObject3.put("chosenCoupon", jSONObject2);
                } catch (JSONException e2) {
                    if (f28994d) {
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

    public final String y(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) {
            return c.a.n0.w.f.d((c.a.n0.a.t1.d.J().getAppId() + "_" + str).getBytes(), true);
        }
        return (String) invokeL.objValue;
    }
}
