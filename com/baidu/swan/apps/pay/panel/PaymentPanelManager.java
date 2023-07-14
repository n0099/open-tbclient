package com.baidu.swan.apps.pay.panel;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.payment.PaymentManager;
import com.baidu.swan.apps.alliance.login.SwanAppAllianceLoginHelper;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.bb2;
import com.baidu.tieba.bs4;
import com.baidu.tieba.cb3;
import com.baidu.tieba.cv2;
import com.baidu.tieba.db3;
import com.baidu.tieba.eb2;
import com.baidu.tieba.fs1;
import com.baidu.tieba.gs1;
import com.baidu.tieba.ix2;
import com.baidu.tieba.pg1;
import com.baidu.tieba.rg1;
import com.baidu.tieba.s43;
import com.baidu.tieba.sg1;
import com.baidu.tieba.ub3;
import com.baidu.tieba.v32;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class PaymentPanelManager {
    public static final boolean d = fs1.a;
    @SuppressLint({"StaticFieldLeak"})
    public static volatile PaymentPanelManager e;
    public volatile HashMap<String, JSONArray> a = new HashMap<>();
    public volatile HashMap<String, c> b = new HashMap<>();
    public final PaymentManager c = new PaymentManager();

    /* loaded from: classes4.dex */
    public class b implements pg1 {
        public final /* synthetic */ s43 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ JSONArray e;
        public final /* synthetic */ String f;

        /* loaded from: classes4.dex */
        public class a implements rg1 {
            public final /* synthetic */ JSONObject a;
            public final /* synthetic */ String b;
            public final /* synthetic */ JSONObject c;

            public a(JSONObject jSONObject, String str, JSONObject jSONObject2) {
                this.a = jSONObject;
                this.b = str;
                this.c = jSONObject2;
            }

            @Override // com.baidu.tieba.rg1
            public void a(JSONObject jSONObject) {
                if (jSONObject == null) {
                    b bVar = b.this;
                    bVar.a.d(bVar.b, new v32(1002, "result data(price calculation) empty"));
                    PaymentPanelManager.this.D();
                } else if (jSONObject.optInt("statusCode", -1) != 0) {
                    b bVar2 = b.this;
                    bVar2.a.d(bVar2.b, new v32(1002, "result data(price calculation) error: error code is Non-zero"));
                    PaymentPanelManager.this.D();
                } else {
                    try {
                        if (!PaymentPanelManager.this.r(jSONObject.optJSONArray("promotionStatus"), this.a)) {
                            PaymentPanelManager.this.G(b.this.e, this.b);
                            b.this.a.d(b.this.b, new v32(1003, "invalid coupon"));
                            PaymentPanelManager.this.D();
                            return;
                        }
                        JSONObject x = PaymentPanelManager.this.x(jSONObject, this.c, "totalAmount", "userPayAmount", "reduceAmount");
                        if (x == null) {
                            b bVar3 = b.this;
                            bVar3.a.d(bVar3.b, new v32(1002, "result data(price calculation) error: price"));
                            PaymentPanelManager.this.D();
                            return;
                        }
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("couponInfo", x);
                            b bVar4 = b.this;
                            String y = PaymentPanelManager.this.y(bVar4.f);
                            if (TextUtils.isEmpty(y)) {
                                b bVar5 = b.this;
                                bVar5.a.d(bVar5.b, new v32(1001, "get inlinePaySign fail"));
                                PaymentPanelManager.this.D();
                                return;
                            }
                            PaymentPanelManager.this.I(y, this.b);
                            b bVar6 = b.this;
                            PaymentPanelManager.this.K(bVar6.e, this.b);
                            b bVar7 = b.this;
                            bVar7.a.d(bVar7.b, new v32(0, jSONObject2));
                            PaymentPanelManager.this.D();
                        } catch (JSONException e) {
                            if (PaymentPanelManager.d) {
                                Log.d("PaymentPanelManager", Log.getStackTraceString(e));
                            }
                            b bVar8 = b.this;
                            bVar8.a.d(bVar8.b, new v32(1002, "result data(price calculation) error: unknown"));
                            PaymentPanelManager.this.D();
                        }
                    } catch (ServerResultException e2) {
                        if (PaymentPanelManager.d) {
                            Log.d("PaymentPanelManager", Log.getStackTraceString(e2));
                        }
                        b bVar9 = b.this;
                        bVar9.a.d(bVar9.b, new v32(1002, "result data(price calculation) error: format or content"));
                        PaymentPanelManager.this.D();
                    }
                }
            }
        }

        public b(s43 s43Var, String str, String str2, String str3, JSONArray jSONArray, String str4) {
            this.a = s43Var;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = jSONArray;
            this.f = str4;
        }

        @Override // com.baidu.tieba.pg1
        public void a(boolean z, JSONObject jSONObject) {
            if (!z) {
                this.a.d(this.b, new v32(0));
            } else if (jSONObject == null) {
                this.a.d(this.b, new v32(1002, "selected coupon result is null"));
            } else {
                String w = PaymentPanelManager.this.w(jSONObject);
                if (TextUtils.isEmpty(w)) {
                    this.a.d(this.b, new v32(1002, "selected coupon result error: empty host info"));
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
                    PaymentPanelManager.this.o(bundle);
                    PaymentPanelManager.this.L();
                    PaymentPanelManager.this.c.n(bundle, new a(jSONObject2, w, jSONObject));
                } catch (JSONException e) {
                    if (PaymentPanelManager.d) {
                        Log.d("PaymentPanelManager", Log.getStackTraceString(e));
                    }
                    this.a.d(this.b, new v32(1002, "selected coupon result error: host info error"));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class ServerResultException extends Exception {
        public ServerResultException(String str) {
            super(str);
        }
    }

    /* loaded from: classes4.dex */
    public class a implements sg1 {
        public final /* synthetic */ s43 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public a(s43 s43Var, String str, String str2) {
            this.a = s43Var;
            this.b = str;
            this.c = str2;
        }

        @Override // com.baidu.tieba.sg1
        public void onError(String str) {
            s43 s43Var = this.a;
            String str2 = this.b;
            s43Var.d(str2, new v32(1002, str + ""));
            PaymentPanelManager.this.D();
        }

        @Override // com.baidu.tieba.sg1
        public void onSuccess(String str) {
            JSONArray jSONArray;
            PaymentPanelManager.this.D();
            if (TextUtils.isEmpty(str)) {
                this.a.d(this.b, new v32(1002, "result data(panel info) empty"));
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                boolean isNull = jSONObject.isNull("coupons");
                Object remove = jSONObject.remove("coupons");
                JSONObject jSONObject2 = null;
                if (!isNull) {
                    if (!(remove instanceof JSONArray)) {
                        this.a.d(this.b, new v32(1002, "result data(panel info) error: coupons"));
                        return;
                    }
                    jSONArray = (JSONArray) remove;
                    if (jSONArray.length() > 0 && (jSONObject2 = PaymentPanelManager.this.u(jSONArray)) == null) {
                        this.a.d(this.b, new v32(1002, "result data(panel info) error: default coupon"));
                        return;
                    }
                } else {
                    jSONArray = null;
                }
                JSONObject q = PaymentPanelManager.this.q(jSONArray, jSONObject2, this.c);
                JSONObject x = PaymentPanelManager.this.x(jSONObject, q, "totalMoney", "payMoney", "reduceMoney");
                if (x == null) {
                    this.a.d(this.b, new v32(1002, "result data(panel info) error: price"));
                    return;
                }
                jSONObject.put("couponInfo", x);
                String y = PaymentPanelManager.this.y(this.c);
                if (TextUtils.isEmpty(y)) {
                    this.a.d(this.b, new v32(1001, "get inlinePaySign fail"));
                    return;
                }
                PaymentPanelManager.this.I(y, PaymentPanelManager.this.w(q));
                JSONObject jSONObject3 = new JSONObject();
                PaymentPanelManager.this.a.put(this.c, jSONArray);
                jSONObject3.put("panelInfo", jSONObject);
                this.a.d(this.b, new v32(0, jSONObject3));
            } catch (JSONException e) {
                if (PaymentPanelManager.d) {
                    Log.d("PaymentPanelManager", Log.getStackTraceString(e));
                }
                this.a.d(this.b, new v32(1001, "result data(panel info) error: unknown"));
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class c {
        public String a;
        public String b;

        public c() {
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    public static void F() {
        if (e != null) {
            e.t();
            e = null;
        }
    }

    public static PaymentPanelManager z() {
        if (e == null) {
            synchronized (PaymentPanelManager.class) {
                if (e == null) {
                    e = new PaymentPanelManager();
                }
            }
        }
        return e;
    }

    public final void D() {
        eb2 U = ix2.T().U();
        if (U == null) {
            return;
        }
        bb2 m = U.m();
        if (!(m instanceof cb3.a)) {
            return;
        }
        db3.c(m);
    }

    public final void t() {
        this.a = new HashMap<>();
        this.b = new HashMap<>();
    }

    public String A(@NonNull String str) {
        c cVar = this.b.get(str);
        if (cVar == null) {
            return null;
        }
        return cVar.a;
    }

    public String B(@NonNull String str) {
        c cVar = this.b.get(str);
        if (cVar == null) {
            return null;
        }
        return cVar.b;
    }

    public final JSONObject u(@NonNull JSONArray jSONArray) {
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

    public final String w(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return E(jSONObject, "host_marketing_detail");
    }

    public final String y(@NonNull String str) {
        return bs4.d((ub3.K().getAppId() + "_" + str).getBytes(), true);
    }

    public final String E(@NonNull JSONObject jSONObject, @NonNull String str) {
        if (jSONObject.isNull(str)) {
            return null;
        }
        return jSONObject.optString(str);
    }

    public final void G(@NonNull JSONArray jSONArray, @NonNull String str) {
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null && TextUtils.equals(E(optJSONObject, "host_marketing_detail"), str)) {
                jSONArray.remove(i);
            }
        }
    }

    public final void H(@NonNull String str, @Nullable String str2) {
        c cVar = this.b.get(str);
        if (cVar == null) {
            cVar = new c(null);
            this.b.put(str, cVar);
        }
        cVar.a = str2;
    }

    public final void I(@NonNull String str, @Nullable String str2) {
        c cVar = this.b.get(str);
        if (cVar == null) {
            cVar = new c(null);
            this.b.put(str, cVar);
        }
        cVar.b = str2;
    }

    public final JSONObject v(JSONArray jSONArray, String str) {
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

    public final JSONObject q(JSONArray jSONArray, JSONObject jSONObject, String str) {
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

    public void C(@NonNull s43 s43Var, @NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4, @NonNull String str5) {
        Bundle bundle = new Bundle();
        bundle.putString("dealId", str2);
        bundle.putString("appKey", str3);
        bundle.putString("totalAmount", str4);
        p(bundle);
        L();
        this.c.m(bundle, new a(s43Var, str5, str));
    }

    public void J(@NonNull s43 s43Var, @NonNull String str, @NonNull String str2, @NonNull String str3) {
        JSONObject jSONObject = new JSONObject();
        String y = y(str);
        if (TextUtils.isEmpty(y)) {
            s43Var.d(str3, new v32(1001, "get inlinePaySign fail: inline pay key is empty!"));
            return;
        }
        try {
            jSONObject.put("inlinePaySign", y);
            H(y, str2);
            s43Var.d(str3, new v32(0, jSONObject));
        } catch (JSONException e2) {
            if (d) {
                Log.d("PaymentPanelManager", Log.getStackTraceString(e2));
            }
            s43Var.d(str3, new v32(1001, "get inlinePaySign fail"));
        }
    }

    public final void K(@NonNull JSONArray jSONArray, @NonNull String str) {
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

    public final void L() {
        FragmentActivity activity;
        cb3 floatLayer;
        eb2 U = ix2.T().U();
        if (U == null) {
            return;
        }
        bb2 m = U.m();
        if (!(m instanceof cb3.a) || (activity = m.getActivity()) == null || (floatLayer = ((cb3.a) m).getFloatLayer()) == null) {
            return;
        }
        floatLayer.l(false);
        db3.f(floatLayer, activity, activity.getString(R.string.obfuscated_res_0x7f0f01c8), true);
    }

    public final void o(@NonNull Bundle bundle) {
        if (SwanAppAllianceLoginHelper.d.f()) {
            bundle.putString("openBduss", cv2.h0().d(cv2.c()));
            bundle.putString("clientId", cv2.n().b());
            return;
        }
        bundle.putString("bduss", cv2.h0().d(cv2.c()));
    }

    public final void p(@NonNull Bundle bundle) {
        o(bundle);
        bundle.putString("deviceType", "ANDROID");
        bundle.putString("cuid", cv2.h0().i(cv2.c()));
        bundle.putString("channel", "cashiersdk");
        bundle.putString("nativeAppId", cv2.n().a());
        bundle.putString(ConstantsAPI.Token.WX_TOKEN_PLATFORMID_KEY, "100003");
        bundle.putString("swanNativeVersion", gs1.a());
    }

    public final boolean r(@Nullable JSONArray jSONArray, @Nullable JSONObject jSONObject) throws ServerResultException {
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

    public void s(@NonNull s43 s43Var, Activity activity, @NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4) {
        JSONArray jSONArray = this.a.get(str);
        if (jSONArray == null) {
            s43Var.d(str4, new v32(1001, "empty coupons list"));
        } else {
            this.c.l(activity, jSONArray, new b(s43Var, str4, str2, str3, jSONArray, str));
        }
    }

    public final JSONObject x(@NonNull JSONObject jSONObject, @Nullable JSONObject jSONObject2, @NonNull String str, @NonNull String str2, @NonNull String str3) {
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
}
