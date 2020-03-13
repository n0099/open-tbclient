package com.baidu.swan.apps.ae;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.network.c.b.d;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.f;
import com.baidu.swan.apps.x.b.b;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import kotlin.l;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b implements com.baidu.swan.apps.ae.a.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = b.class.getSimpleName();
    private e bHd;
    private com.baidu.j.a bHe = new com.baidu.j.a();
    private UnitedSchemeEntity bzI;
    private CallbackHandler bzJ;
    private String mAppKey;
    private String mResult;
    private int mStatusCode;
    private String mVersion;

    public b(e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, String str2) {
        this.bHd = eVar;
        this.bzI = unitedSchemeEntity;
        this.bzJ = callbackHandler;
        this.mVersion = str;
        this.mAppKey = str2;
    }

    public boolean jK(final String str) {
        if (TextUtils.isEmpty(str)) {
            this.bzI.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else if (this.bHd == null) {
            this.bzI.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else if (this.bHd.acQ().isLogin(this.bHd.getActivity())) {
            jL(str);
            UnitedSchemeUtility.callCallback(this.bzJ, this.bzI, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        } else {
            this.bHd.acQ().a(this.bHd.getActivity(), null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.ae.b.1
                @Override // com.baidu.swan.apps.a.a
                public void onResult(int i) {
                    if (i == 0) {
                        b.this.jL(str);
                        return;
                    }
                    b.this.mStatusCode = 5;
                    b.this.mResult = null;
                    b.this.jN(null);
                }
            });
            UnitedSchemeUtility.callCallback(this.bzJ, this.bzI, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jL(String str) {
        this.bHe.a(this.bHd.getActivity(), str, new com.baidu.j.a.a() { // from class: com.baidu.swan.apps.ae.b.2
            @Override // com.baidu.j.a.a
            public void onPayResult(int i, String str2) {
                b.this.mStatusCode = i;
                b.this.mResult = str2;
                if (b.DEBUG) {
                    Log.d(b.TAG, "statusCode: " + i + " ,result:" + str2);
                }
                b.this.d(i, "baiduqianbao", str2);
                if (i != 0 || !TextUtils.equals(b.this.mVersion, "2.0")) {
                    b.this.jN(null);
                } else {
                    com.baidu.swan.apps.w.a.UA().a(b.this.mAppKey, b.this);
                }
            }
        });
    }

    public boolean jM(String str) {
        if (DEBUG) {
            Log.d(TAG, "start UnitedSchemeWalletDispatcher ACTION_REQUEST_ALI_PAYMENT orderInfo: " + str);
        }
        if (TextUtils.isEmpty(str)) {
            this.bzI.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        this.bHe.b(this.bHd.getActivity(), str, new com.baidu.j.a.a() { // from class: com.baidu.swan.apps.ae.b.3
            @Override // com.baidu.j.a.a
            public void onPayResult(int i, String str2) {
                b.this.mStatusCode = i;
                b.this.mResult = str2;
                if (b.DEBUG) {
                    Log.d(b.TAG, "statusCode: " + b.this.mStatusCode + " ,result:" + b.this.mResult);
                }
                b.this.d(i, "alipay", str2);
                if (i != 0 || !TextUtils.equals(b.this.mVersion, "2.0")) {
                    b.this.jN(null);
                } else {
                    com.baidu.swan.apps.w.a.UA().a(b.this.mAppKey, b.this);
                }
            }
        });
        UnitedSchemeUtility.callCallback(this.bzJ, this.bzI, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }

    public boolean e(final String str, final JSONObject jSONObject) {
        final String[] strArr;
        Object opt;
        if (TextUtils.isEmpty(str)) {
            this.bzI.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        String optString = jSONObject.optString("__plugin__");
        com.baidu.swan.apps.ag.d.a.print("start payment");
        if (!TextUtils.isEmpty(optString) && (opt = jSONObject.opt(BdStatsConstant.StatsType.ERROR)) != null) {
            String optString2 = jSONObject.optString("slaveId");
            com.baidu.swan.apps.ag.c.c.a aVar = new com.baidu.swan.apps.ag.c.c.a(jSONObject.optString("componentId"));
            aVar.bin = optString2;
            aVar.bIw = opt;
            aVar.isSuccess = false;
            aVar.bIx = null;
            aVar.aag();
            this.bzI.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("bannedChannels");
        if (optJSONArray != null) {
            String[] strArr2 = new String[optJSONArray.length()];
            for (int i = 0; i < optJSONArray.length(); i++) {
                strArr2[i] = String.valueOf(optJSONArray.opt(i));
            }
            strArr = strArr2;
        } else {
            strArr = null;
        }
        if (this.bHd.getActivity() == null) {
            this.mStatusCode = 5;
            this.mResult = null;
            jN(null);
            if (DEBUG) {
                throw new RuntimeException("swanApp getActivity returns null");
            }
        } else if (this.bHd.acQ().isLogin(this.bHd.getActivity())) {
            a(str, strArr, jSONObject);
            f.a("nuomi", true, true);
        } else {
            this.bHd.acQ().a(this.bHd.getActivity(), null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.ae.b.4
                @Override // com.baidu.swan.apps.a.a
                public void onResult(int i2) {
                    if (i2 == 0) {
                        b.this.a(str, strArr, jSONObject);
                        f.a("nuomi", true, false);
                        return;
                    }
                    b.this.mStatusCode = 5;
                    b.this.mResult = null;
                    b.this.jN(null);
                    f.a("nuomi", false, false);
                }
            });
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, final String[] strArr, final JSONObject jSONObject) {
        try {
            final JSONObject jSONObject2 = new JSONObject(str);
            d.a(jSONObject2.optString("appKey"), new kotlin.jvm.a.b<Boolean, l>() { // from class: com.baidu.swan.apps.ae.b.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.a.b
                /* renamed from: f */
                public l invoke(Boolean bool) {
                    if (bool.booleanValue()) {
                        b.this.a(jSONObject2, strArr, jSONObject);
                        return null;
                    }
                    b.this.Zw();
                    return null;
                }
            });
        } catch (JSONException e) {
            Zw();
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private String Zv() {
        String str = this.bzI.getParams().get("params");
        if (!TextUtils.isEmpty(str)) {
            try {
                return new JSONObject(str).optString("cb");
            } catch (JSONException e) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zw() {
        String Zv = Zv();
        if (this.bHd != null) {
            com.baidu.swan.apps.res.widget.b.d.q(this.bHd.acB(), a.h.swanapp_payment_illegal).showToast();
            if (!TextUtils.isEmpty(Zv)) {
                this.bzJ.handleSchemeDispatchCallback(Zv, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, 6, this.bHd.acB().getString(a.h.swanapp_payment_illegal)).toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject, String[] strArr, final JSONObject jSONObject2) {
        try {
            if (com.baidu.swan.apps.c.a.e.bco.Jp()) {
                jSONObject.put("maBduss", com.baidu.swan.apps.w.a.Ub().bs(com.baidu.swan.apps.w.a.TW()));
            } else {
                jSONObject.put("bduss", com.baidu.swan.apps.w.a.Ub().bs(com.baidu.swan.apps.w.a.TW()));
            }
            jSONObject.put("cuid", com.baidu.swan.apps.w.a.Ub().br(com.baidu.swan.apps.w.a.TW()));
            String optString = jSONObject.optString("bizInfo");
            JSONObject jSONObject3 = TextUtils.isEmpty(optString) ? new JSONObject() : new JSONObject(optString);
            if (this.bHd.GE() != null) {
                jSONObject3.put("swanFrom", this.bHd.GE().VJ());
            }
            jSONObject3.put("cuid", com.baidu.swan.apps.w.a.Ub().br(com.baidu.swan.apps.w.a.TW()));
            jSONObject3.put("appId", e.acH());
            jSONObject.put("bizInfo", aw(jSONObject3).toString());
            jSONObject.put("platformId", "100003");
            jSONObject.put("nativeAppId", com.baidu.swan.apps.w.a.UH().getHostName());
            jSONObject.put("swanNativeVersion", com.baidu.swan.apps.c.getVersion());
            if (DEBUG) {
                Log.i(TAG, jSONObject.toString());
            }
        } catch (JSONException e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.y.f.WS().Wt();
        this.bHe.a(this.bHd.acB(), jSONObject, strArr, new com.baidu.j.a.a() { // from class: com.baidu.swan.apps.ae.b.6
            @Override // com.baidu.j.a.a
            public void onPayResult(int i, String str) {
                com.baidu.swan.apps.y.f.WS().Wu();
                b.this.d(i, "nuomi", str);
                b.this.mStatusCode = i;
                b.this.mResult = str;
                b.this.jN(null);
                if (jSONObject2 != null && !TextUtils.isEmpty(jSONObject2.optString("__plugin__"))) {
                    String optString2 = jSONObject2.optString("slaveId");
                    String optString3 = jSONObject2.optString("componentId");
                    Object opt = jSONObject2.opt(BdStatsConstant.StatsType.ERROR);
                    com.baidu.swan.apps.ag.c.c.a aVar = new com.baidu.swan.apps.ag.c.c.a(optString3);
                    aVar.bin = optString2;
                    aVar.bIw = opt;
                    aVar.isSuccess = i == 0;
                    aVar.bIx = str;
                    aVar.aag();
                    com.baidu.swan.apps.ag.g.b.aak();
                }
            }
        });
        UnitedSchemeUtility.callCallback(this.bzJ, this.bzI, UnitedSchemeUtility.wrapCallbackParams(0));
        if (this.bHd.acy() != null && this.bHd.GE() != null) {
            String valueOf = String.valueOf(this.bHd.GE().getAppFrameType());
            String valueOf2 = String.valueOf(UnitedSchemeUtility.getParams(this.bHd.GE().VL()).get("_baiduboxapp"));
            Bundle bundle = new Bundle();
            bundle.putString("frameType", valueOf);
            bundle.putString("appId", this.bHd.GE().getAppId());
            try {
                bundle.putString("params", URLEncoder.encode(valueOf2, "UTF-8"));
            } catch (UnsupportedEncodingException e2) {
                if (DEBUG) {
                    throw new RuntimeException("This method requires UTF-8 encoding support", e2);
                }
            }
            this.bHd.acy().e(7, bundle);
        }
    }

    public boolean Zx() {
        com.baidu.swan.apps.console.c.d(TAG, "start UnitedSchemeWalletDispatcher ACTION_REQUEST_WECHAT_PAYMENT");
        if (a.Zu().a(this.bHd, this.bzJ, this.bzI)) {
            if (TextUtils.equals(this.mVersion, "2.0")) {
                this.mStatusCode = 0;
                this.mResult = null;
                com.baidu.swan.apps.w.a.UA().a(this.mAppKey, this);
            }
            f.a("wechatH5Action", (String) null, (ArrayList<String>) null);
            UnitedSchemeUtility.callCallback(this.bzJ, this.bzI, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
        this.bzI.result = UnitedSchemeUtility.wrapCallbackParams(1001);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i, String str, String str2) {
        b.a GE = this.bHd.GE();
        f.a(i == 0, str, str2, GE != null ? GE.getAppFrameType() : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jN(String str) {
        String str2;
        com.baidu.swan.apps.console.c.d(TAG, "sendSecondCallback, statusCode: " + this.mStatusCode + ", params: " + this.mResult);
        String str3 = this.bzI.getParams().get("params");
        if (!TextUtils.isEmpty(str3)) {
            try {
                str2 = new JSONObject(str3).optString("cb");
            } catch (UnsupportedEncodingException e) {
                e = e;
                str2 = null;
            } catch (JSONException e2) {
                e = e2;
                str2 = null;
            }
            try {
                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(this.mResult)) {
                    if (TextUtils.equals(this.mVersion, "2.0")) {
                        JSONObject jSONObject = new JSONObject();
                        if (!TextUtils.isEmpty(str)) {
                            jSONObject.put("payId", str);
                        }
                        if (!TextUtils.isEmpty(this.mResult)) {
                            jSONObject.put("payResult", Base64.encodeToString(this.mResult.getBytes("UTF-8"), 2));
                        }
                        this.bzJ.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(jSONObject, this.mStatusCode, fE(this.mStatusCode)).toString());
                        return;
                    }
                    this.bzJ.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParamsWithBase64(this.mResult, this.mStatusCode, fE(this.mStatusCode)).toString());
                    return;
                }
                this.bzJ.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, this.mStatusCode, fE(this.mStatusCode)).toString());
            } catch (UnsupportedEncodingException e3) {
                e = e3;
                e.printStackTrace();
                this.bzJ.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, this.mStatusCode, fE(this.mStatusCode)).toString());
            } catch (JSONException e4) {
                e = e4;
                e.printStackTrace();
                this.bzJ.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, this.mStatusCode, fE(this.mStatusCode)).toString());
            }
        }
    }

    private static String fE(int i) {
        switch (i) {
            case 0:
                return "支付成功";
            case 1:
            default:
                return "支付失败";
            case 2:
                return "支付取消";
        }
    }

    @Override // com.baidu.swan.apps.ai.a
    public void K(JSONObject jSONObject) {
        String str = null;
        if (jSONObject.optInt("errno") == 0) {
            str = jSONObject.optJSONObject("data").optString("payid");
        }
        jN(str);
    }

    @Override // com.baidu.swan.apps.ai.a
    public void onFail(String str) {
        com.baidu.swan.apps.console.c.e(TAG, "request payId failed");
        com.baidu.swan.apps.console.c.e(TAG, str);
        jN(null);
    }

    public JSONObject aw(JSONObject jSONObject) {
        b.a GE;
        if (this.bHd.acW() && jSONObject != null && (GE = this.bHd.GE()) != null && GE.Wb() != null) {
            JSONObject Wb = GE.Wb();
            String optString = Wb.optString("log_id");
            String optString2 = Wb.optString("module_id");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                try {
                    jSONObject.put("log_id", optString);
                    jSONObject.put("module_id", optString2);
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return jSONObject;
    }
}
