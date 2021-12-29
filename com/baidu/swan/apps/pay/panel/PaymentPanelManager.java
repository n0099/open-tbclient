package com.baidu.swan.apps.pay.panel;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.f0.f.d;
import c.a.r0.a.c2.b.c.a;
import c.a.r0.a.g1.f;
import c.a.r0.a.h;
import c.a.r0.a.h0.g.g;
import c.a.r0.a.k;
import c.a.r0.a.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.payment.PaymentManager;
import com.baidu.swan.apps.alliance.login.SwanAppAllianceLoginHelper;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class PaymentPanelManager {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f40299d;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: e  reason: collision with root package name */
    public static volatile PaymentPanelManager f40300e;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile HashMap<String, JSONArray> a;

    /* renamed from: b  reason: collision with root package name */
    public volatile HashMap<String, c> f40301b;

    /* renamed from: c  reason: collision with root package name */
    public final PaymentManager f40302c;

    /* loaded from: classes11.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public class a implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.r0.a.t1.m.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f40303b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f40304c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ PaymentPanelManager f40305d;

        public a(PaymentPanelManager paymentPanelManager, c.a.r0.a.t1.m.a aVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {paymentPanelManager, aVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f40305d = paymentPanelManager;
            this.a = aVar;
            this.f40303b = str;
            this.f40304c = str2;
        }

        @Override // c.a.f0.f.d
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                c.a.r0.a.t1.m.a aVar = this.a;
                String str2 = this.f40303b;
                aVar.d(str2, new c.a.r0.a.u.h.b(1002, str + ""));
                this.f40305d.D();
            }
        }

        @Override // c.a.f0.f.d
        public void onSuccess(String str) {
            JSONArray jSONArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.f40305d.D();
                if (TextUtils.isEmpty(str)) {
                    this.a.d(this.f40303b, new c.a.r0.a.u.h.b(1002, "result data(panel info) empty"));
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
                        this.a.d(this.f40303b, new c.a.r0.a.u.h.b(1002, "result data(panel info) error: coupons"));
                        return;
                    } else {
                        jSONArray = (JSONArray) remove;
                        if (jSONArray.length() > 0 && (jSONObject2 = this.f40305d.u(jSONArray)) == null) {
                            this.a.d(this.f40303b, new c.a.r0.a.u.h.b(1002, "result data(panel info) error: default coupon"));
                            return;
                        }
                    }
                    JSONObject q = this.f40305d.q(jSONArray, jSONObject2, this.f40304c);
                    JSONObject x = this.f40305d.x(jSONObject, q, "totalMoney", "payMoney", "reduceMoney");
                    if (x == null) {
                        this.a.d(this.f40303b, new c.a.r0.a.u.h.b(1002, "result data(panel info) error: price"));
                        return;
                    }
                    jSONObject.put("couponInfo", x);
                    String y = this.f40305d.y(this.f40304c);
                    if (!TextUtils.isEmpty(y)) {
                        this.f40305d.I(y, this.f40305d.w(q));
                        JSONObject jSONObject3 = new JSONObject();
                        this.f40305d.a.put(this.f40304c, jSONArray);
                        jSONObject3.put("panelInfo", jSONObject);
                        this.a.d(this.f40303b, new c.a.r0.a.u.h.b(0, jSONObject3));
                        return;
                    }
                    this.a.d(this.f40303b, new c.a.r0.a.u.h.b(1001, "get inlinePaySign fail"));
                } catch (JSONException e2) {
                    if (PaymentPanelManager.f40299d) {
                        Log.getStackTraceString(e2);
                    }
                    this.a.d(this.f40303b, new c.a.r0.a.u.h.b(1001, "result data(panel info) error: unknown"));
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public class b implements c.a.f0.f.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.r0.a.t1.m.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f40306b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f40307c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f40308d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONArray f40309e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f40310f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ PaymentPanelManager f40311g;

        /* loaded from: classes11.dex */
        public class a implements c.a.f0.f.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ JSONObject a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f40312b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ JSONObject f40313c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ b f40314d;

            public a(b bVar, JSONObject jSONObject, String str, JSONObject jSONObject2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, jSONObject, str, jSONObject2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f40314d = bVar;
                this.a = jSONObject;
                this.f40312b = str;
                this.f40313c = jSONObject2;
            }

            @Override // c.a.f0.f.c
            public void a(JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                    if (jSONObject == null) {
                        b bVar = this.f40314d;
                        bVar.a.d(bVar.f40306b, new c.a.r0.a.u.h.b(1002, "result data(price calculation) empty"));
                        this.f40314d.f40311g.D();
                    } else if (jSONObject.optInt(EnterDxmPayServiceAction.SERVICE_STATUS_CODE, -1) == 0) {
                        try {
                            if (!this.f40314d.f40311g.r(jSONObject.optJSONArray("promotionStatus"), this.a)) {
                                this.f40314d.f40311g.G(this.f40314d.f40309e, this.f40312b);
                                this.f40314d.a.d(this.f40314d.f40306b, new c.a.r0.a.u.h.b(1003, "invalid coupon"));
                                this.f40314d.f40311g.D();
                                return;
                            }
                            JSONObject x = this.f40314d.f40311g.x(jSONObject, this.f40313c, "totalAmount", "userPayAmount", "reduceAmount");
                            if (x == null) {
                                b bVar2 = this.f40314d;
                                bVar2.a.d(bVar2.f40306b, new c.a.r0.a.u.h.b(1002, "result data(price calculation) error: price"));
                                this.f40314d.f40311g.D();
                                return;
                            }
                            JSONObject jSONObject2 = new JSONObject();
                            try {
                                jSONObject2.put("couponInfo", x);
                                b bVar3 = this.f40314d;
                                String y = bVar3.f40311g.y(bVar3.f40310f);
                                if (!TextUtils.isEmpty(y)) {
                                    this.f40314d.f40311g.I(y, this.f40312b);
                                    b bVar4 = this.f40314d;
                                    bVar4.f40311g.K(bVar4.f40309e, this.f40312b);
                                    b bVar5 = this.f40314d;
                                    bVar5.a.d(bVar5.f40306b, new c.a.r0.a.u.h.b(0, jSONObject2));
                                    this.f40314d.f40311g.D();
                                    return;
                                }
                                b bVar6 = this.f40314d;
                                bVar6.a.d(bVar6.f40306b, new c.a.r0.a.u.h.b(1001, "get inlinePaySign fail"));
                                this.f40314d.f40311g.D();
                            } catch (JSONException e2) {
                                if (PaymentPanelManager.f40299d) {
                                    Log.getStackTraceString(e2);
                                }
                                b bVar7 = this.f40314d;
                                bVar7.a.d(bVar7.f40306b, new c.a.r0.a.u.h.b(1002, "result data(price calculation) error: unknown"));
                                this.f40314d.f40311g.D();
                            }
                        } catch (ServerResultException e3) {
                            if (PaymentPanelManager.f40299d) {
                                Log.getStackTraceString(e3);
                            }
                            b bVar8 = this.f40314d;
                            bVar8.a.d(bVar8.f40306b, new c.a.r0.a.u.h.b(1002, "result data(price calculation) error: format or content"));
                            this.f40314d.f40311g.D();
                        }
                    } else {
                        b bVar9 = this.f40314d;
                        bVar9.a.d(bVar9.f40306b, new c.a.r0.a.u.h.b(1002, "result data(price calculation) error: error code is Non-zero"));
                        this.f40314d.f40311g.D();
                    }
                }
            }
        }

        public b(PaymentPanelManager paymentPanelManager, c.a.r0.a.t1.m.a aVar, String str, String str2, String str3, JSONArray jSONArray, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {paymentPanelManager, aVar, str, str2, str3, jSONArray, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f40311g = paymentPanelManager;
            this.a = aVar;
            this.f40306b = str;
            this.f40307c = str2;
            this.f40308d = str3;
            this.f40309e = jSONArray;
            this.f40310f = str4;
        }

        @Override // c.a.f0.f.a
        public void a(boolean z, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, jSONObject) == null) {
                if (!z) {
                    this.a.d(this.f40306b, new c.a.r0.a.u.h.b(0));
                } else if (jSONObject != null) {
                    String w = this.f40311g.w(jSONObject);
                    if (TextUtils.isEmpty(w)) {
                        this.a.d(this.f40306b, new c.a.r0.a.u.h.b(1002, "selected coupon result error: empty host info"));
                        return;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString("appKey", this.f40307c);
                    bundle.putString("totalAmount", this.f40308d);
                    JSONArray jSONArray = new JSONArray();
                    try {
                        JSONObject jSONObject2 = new JSONObject(w);
                        jSONArray.put(jSONObject2);
                        bundle.putString("hostMarketingDetail", jSONArray.toString());
                        this.f40311g.o(bundle);
                        this.f40311g.L();
                        this.f40311g.f40302c.n(bundle, new a(this, jSONObject2, w, jSONObject));
                    } catch (JSONException e2) {
                        if (PaymentPanelManager.f40299d) {
                            Log.getStackTraceString(e2);
                        }
                        this.a.d(this.f40306b, new c.a.r0.a.u.h.b(1002, "selected coupon result error: host info error"));
                    }
                } else {
                    this.a.d(this.f40306b, new c.a.r0.a.u.h.b(1002, "selected coupon result is null"));
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f40315b;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
        f40299d = k.a;
    }

    public PaymentPanelManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new HashMap<>();
        this.f40301b = new HashMap<>();
        this.f40302c = new PaymentManager();
    }

    public static void F() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, null) == null) || f40300e == null) {
            return;
        }
        f40300e.t();
        f40300e = null;
    }

    public static PaymentPanelManager z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
            if (f40300e == null) {
                synchronized (PaymentPanelManager.class) {
                    if (f40300e == null) {
                        f40300e = new PaymentPanelManager();
                    }
                }
            }
            return f40300e;
        }
        return (PaymentPanelManager) invokeV.objValue;
    }

    public String A(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            c cVar = this.f40301b.get(str);
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
            c cVar = this.f40301b.get(str);
            if (cVar == null) {
                return null;
            }
            return cVar.f40315b;
        }
        return (String) invokeL.objValue;
    }

    public void C(@NonNull c.a.r0.a.t1.m.a aVar, @NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4, @NonNull String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{aVar, str, str2, str3, str4, str5}) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("dealId", str2);
            bundle.putString("appKey", str3);
            bundle.putString("totalAmount", str4);
            p(bundle);
            L();
            this.f40302c.m(bundle, new a(this, aVar, str5, str));
        }
    }

    public final void D() {
        g V;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (V = f.U().V()) == null) {
            return;
        }
        c.a.r0.a.h0.g.d m = V.m();
        if (m instanceof a.InterfaceC0276a) {
            c.a.r0.a.c2.b.d.a.c(m);
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
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                if (optJSONObject != null && TextUtils.equals(E(optJSONObject, "host_marketing_detail"), str)) {
                    jSONArray.remove(i2);
                }
            }
        }
    }

    public final void H(@NonNull String str, @Nullable String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) {
            c cVar = this.f40301b.get(str);
            if (cVar == null) {
                cVar = new c(null);
                this.f40301b.put(str, cVar);
            }
            cVar.a = str2;
        }
    }

    public final void I(@NonNull String str, @Nullable String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, str2) == null) {
            c cVar = this.f40301b.get(str);
            if (cVar == null) {
                cVar = new c(null);
                this.f40301b.put(str, cVar);
            }
            cVar.f40315b = str2;
        }
    }

    public void J(@NonNull c.a.r0.a.t1.m.a aVar, @NonNull String str, @NonNull String str2, @NonNull String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar, str, str2, str3) == null) {
            JSONObject jSONObject = new JSONObject();
            String y = y(str);
            if (TextUtils.isEmpty(y)) {
                aVar.d(str3, new c.a.r0.a.u.h.b(1001, "get inlinePaySign fail: inline pay key is empty!"));
                return;
            }
            try {
                jSONObject.put("inlinePaySign", y);
                H(y, str2);
                aVar.d(str3, new c.a.r0.a.u.h.b(0, jSONObject));
            } catch (JSONException e2) {
                if (f40299d) {
                    Log.getStackTraceString(e2);
                }
                aVar.d(str3, new c.a.r0.a.u.h.b(1001, "get inlinePaySign fail"));
            }
        }
    }

    public final void K(@NonNull JSONArray jSONArray, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, jSONArray, str) == null) {
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    try {
                        optJSONObject.put("is_selected", 0);
                        if (TextUtils.equals(E(optJSONObject, "host_marketing_detail"), str)) {
                            optJSONObject.put("is_selected", 1);
                        }
                    } catch (JSONException e2) {
                        if (f40299d) {
                            Log.getStackTraceString(e2);
                        }
                    }
                }
            }
        }
    }

    public final void L() {
        g V;
        FragmentActivity activity;
        c.a.r0.a.c2.b.c.a floatLayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (V = f.U().V()) == null) {
            return;
        }
        c.a.r0.a.h0.g.d m = V.m();
        if (!(m instanceof a.InterfaceC0276a) || (activity = m.getActivity()) == null || (floatLayer = ((a.InterfaceC0276a) m).getFloatLayer()) == null) {
            return;
        }
        floatLayer.l(false);
        c.a.r0.a.c2.b.d.a.f(floatLayer, activity, activity.getString(h.aiapps_loading), true);
    }

    public final void o(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
            if (SwanAppAllianceLoginHelper.f39956d.f()) {
                bundle.putString("openBduss", c.a.r0.a.c1.a.h0().d(c.a.r0.a.c1.a.c()));
                bundle.putString("clientId", c.a.r0.a.c1.a.n().b());
                return;
            }
            bundle.putString("bduss", c.a.r0.a.c1.a.h0().d(c.a.r0.a.c1.a.c()));
        }
    }

    public final void p(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bundle) == null) {
            o(bundle);
            bundle.putString("deviceType", "ANDROID");
            bundle.putString("cuid", c.a.r0.a.c1.a.h0().i(c.a.r0.a.c1.a.c()));
            bundle.putString("channel", "cashiersdk");
            bundle.putString("nativeAppId", c.a.r0.a.c1.a.n().a());
            bundle.putString("platformId", "100003");
            bundle.putString("swanNativeVersion", l.a());
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
            if (TextUtils.isEmpty(y) || (cVar = this.f40301b.get(y)) == null || (str2 = cVar.f40315b) == null || (v = v(jSONArray, str2)) == null) {
                return jSONObject;
            }
            K(jSONArray, cVar.f40315b);
            return v;
        }
        return (JSONObject) invokeLLL.objValue;
    }

    public final boolean r(@Nullable JSONArray jSONArray, @Nullable JSONObject jSONObject) throws ServerResultException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, jSONArray, jSONObject)) == null) {
            if (jSONArray != null && jSONObject != null) {
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i2);
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

    public void s(@NonNull c.a.r0.a.t1.m.a aVar, Activity activity, @NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{aVar, activity, str, str2, str3, str4}) == null) {
            JSONArray jSONArray = this.a.get(str);
            if (jSONArray == null) {
                aVar.d(str4, new c.a.r0.a.u.h.b(1001, "empty coupons list"));
            } else {
                this.f40302c.l(activity, jSONArray, new b(this, aVar, str4, str2, str3, jSONArray, str));
            }
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.a = new HashMap<>();
            this.f40301b = new HashMap<>();
        }
    }

    public final JSONObject u(@NonNull JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, jSONArray)) == null) {
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    if (jSONObject.optInt("is_selected") == 1) {
                        return jSONObject;
                    }
                } catch (JSONException e2) {
                    if (f40299d) {
                        Log.getStackTraceString(e2);
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
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i2);
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
                    if (f40299d) {
                        Log.getStackTraceString(e2);
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
            return c.a.r0.w.f.d((c.a.r0.a.d2.d.J().getAppId() + "_" + str).getBytes(), true);
        }
        return (String) invokeL.objValue;
    }
}
