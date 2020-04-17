package com.baidu.swan.apps.ae;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.baidu.android.util.io.BaseJsonData;
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
    private UnitedSchemeEntity bXZ;
    private CallbackHandler bYa;
    private e cfX;
    private com.baidu.g.a cfY = new com.baidu.g.a();
    private String mAppKey;
    private String mResult;
    private int mStatusCode;
    private String mVersion;

    public b(e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, String str2) {
        this.cfX = eVar;
        this.bXZ = unitedSchemeEntity;
        this.bYa = callbackHandler;
        this.mVersion = str;
        this.mAppKey = str2;
    }

    public boolean kW(final String str) {
        if (TextUtils.isEmpty(str)) {
            this.bXZ.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else if (this.cfX == null) {
            this.bXZ.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else if (this.cfX.akY().isLogin(this.cfX.getActivity())) {
            kX(str);
            UnitedSchemeUtility.callCallback(this.bYa, this.bXZ, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        } else {
            this.cfX.akY().a(this.cfX.getActivity(), null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.ae.b.1
                @Override // com.baidu.swan.apps.a.a
                public void onResult(int i) {
                    if (i == 0) {
                        b.this.kX(str);
                        return;
                    }
                    b.this.mStatusCode = 5;
                    b.this.mResult = null;
                    b.this.kZ(null);
                }
            });
            UnitedSchemeUtility.callCallback(this.bYa, this.bXZ, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kX(String str) {
        this.cfY.a(this.cfX.getActivity(), str, new com.baidu.g.a.a() { // from class: com.baidu.swan.apps.ae.b.2
            @Override // com.baidu.g.a.a
            public void onPayResult(int i, String str2) {
                b.this.mStatusCode = i;
                b.this.mResult = str2;
                if (b.DEBUG) {
                    Log.d(b.TAG, "statusCode: " + i + " ,result:" + str2);
                }
                b.this.e(i, "baiduqianbao", str2);
                if (i != 0 || !TextUtils.equals(b.this.mVersion, "2.0")) {
                    b.this.kZ(null);
                } else {
                    com.baidu.swan.apps.w.a.acs().a(b.this.mAppKey, b.this);
                }
            }
        });
    }

    public boolean kY(String str) {
        if (DEBUG) {
            Log.d(TAG, "start UnitedSchemeWalletDispatcher ACTION_REQUEST_ALI_PAYMENT orderInfo: " + str);
        }
        if (TextUtils.isEmpty(str)) {
            this.bXZ.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        this.cfY.b(this.cfX.getActivity(), str, new com.baidu.g.a.a() { // from class: com.baidu.swan.apps.ae.b.3
            @Override // com.baidu.g.a.a
            public void onPayResult(int i, String str2) {
                b.this.mStatusCode = i;
                b.this.mResult = str2;
                if (b.DEBUG) {
                    Log.d(b.TAG, "statusCode: " + b.this.mStatusCode + " ,result:" + b.this.mResult);
                }
                b.this.e(i, "alipay", str2);
                if (i != 0 || !TextUtils.equals(b.this.mVersion, "2.0")) {
                    b.this.kZ(null);
                } else {
                    com.baidu.swan.apps.w.a.acs().a(b.this.mAppKey, b.this);
                }
            }
        });
        UnitedSchemeUtility.callCallback(this.bYa, this.bXZ, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }

    public boolean f(final String str, final JSONObject jSONObject) {
        final String[] strArr;
        Object opt;
        if (TextUtils.isEmpty(str)) {
            this.bXZ.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        String optString = jSONObject.optString("__plugin__");
        com.baidu.swan.apps.ag.d.a.print("start payment");
        if (!TextUtils.isEmpty(optString) && (opt = jSONObject.opt(BdStatsConstant.StatsType.ERROR)) != null) {
            String optString2 = jSONObject.optString("slaveId");
            com.baidu.swan.apps.ag.c.c.a aVar = new com.baidu.swan.apps.ag.c.c.a(jSONObject.optString("componentId"));
            aVar.bGJ = optString2;
            aVar.chq = opt;
            aVar.isSuccess = false;
            aVar.chr = null;
            aVar.aio();
            this.bXZ.result = UnitedSchemeUtility.wrapCallbackParams(1001);
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
        if (this.cfX.getActivity() == null) {
            this.mStatusCode = 5;
            this.mResult = null;
            kZ(null);
            if (DEBUG) {
                throw new RuntimeException("swanApp getActivity returns null");
            }
        } else if (this.cfX.akY().isLogin(this.cfX.getActivity())) {
            a(str, strArr, jSONObject);
            f.a("nuomi", true, true);
        } else {
            this.cfX.akY().a(this.cfX.getActivity(), null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.ae.b.4
                @Override // com.baidu.swan.apps.a.a
                public void onResult(int i2) {
                    if (i2 == 0) {
                        b.this.a(str, strArr, jSONObject);
                        f.a("nuomi", true, false);
                        return;
                    }
                    b.this.mStatusCode = 5;
                    b.this.mResult = null;
                    b.this.kZ(null);
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
                    b.this.ahE();
                    return null;
                }
            });
        } catch (JSONException e) {
            ahE();
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private String ahD() {
        String str = this.bXZ.getParams().get("params");
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
    public void ahE() {
        String ahD = ahD();
        if (this.cfX != null) {
            com.baidu.swan.apps.res.widget.b.d.k(this.cfX.akJ(), a.h.swanapp_payment_illegal).showToast();
            if (!TextUtils.isEmpty(ahD)) {
                this.bYa.handleSchemeDispatchCallback(ahD, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, 6, this.cfX.akJ().getString(a.h.swanapp_payment_illegal)).toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject, String[] strArr, final JSONObject jSONObject2) {
        try {
            if (com.baidu.swan.apps.c.a.e.bAP.Re()) {
                jSONObject.put("maBduss", com.baidu.swan.apps.w.a.abT().bf(com.baidu.swan.apps.w.a.abO()));
            } else {
                jSONObject.put("bduss", com.baidu.swan.apps.w.a.abT().bf(com.baidu.swan.apps.w.a.abO()));
            }
            jSONObject.put("cuid", com.baidu.swan.apps.w.a.abT().be(com.baidu.swan.apps.w.a.abO()));
            String optString = jSONObject.optString("bizInfo");
            JSONObject jSONObject3 = TextUtils.isEmpty(optString) ? new JSONObject() : new JSONObject(optString);
            if (this.cfX.Ow() != null) {
                jSONObject3.put("swanFrom", this.cfX.Ow().adB());
            }
            jSONObject3.put("cuid", com.baidu.swan.apps.w.a.abT().be(com.baidu.swan.apps.w.a.abO()));
            jSONObject3.put("appId", e.akP());
            jSONObject.put("bizInfo", aH(jSONObject3).toString());
            jSONObject.put("platformId", "100003");
            jSONObject.put("nativeAppId", com.baidu.swan.apps.w.a.acz().getHostName());
            jSONObject.put("swanNativeVersion", com.baidu.swan.apps.c.getVersion());
            if (DEBUG) {
                Log.i(TAG, jSONObject.toString());
            }
        } catch (JSONException e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.y.f.aeK().ael();
        this.cfY.a(this.cfX.akJ(), jSONObject, strArr, new com.baidu.g.a.a() { // from class: com.baidu.swan.apps.ae.b.6
            @Override // com.baidu.g.a.a
            public void onPayResult(int i, String str) {
                com.baidu.swan.apps.y.f.aeK().aem();
                b.this.e(i, "nuomi", str);
                b.this.mStatusCode = i;
                b.this.mResult = str;
                b.this.kZ(null);
                if (jSONObject2 != null && !TextUtils.isEmpty(jSONObject2.optString("__plugin__"))) {
                    String optString2 = jSONObject2.optString("slaveId");
                    String optString3 = jSONObject2.optString("componentId");
                    Object opt = jSONObject2.opt(BdStatsConstant.StatsType.ERROR);
                    com.baidu.swan.apps.ag.c.c.a aVar = new com.baidu.swan.apps.ag.c.c.a(optString3);
                    aVar.bGJ = optString2;
                    aVar.chq = opt;
                    aVar.isSuccess = i == 0;
                    aVar.chr = str;
                    aVar.aio();
                    com.baidu.swan.apps.ag.g.b.ais();
                }
            }
        });
        UnitedSchemeUtility.callCallback(this.bYa, this.bXZ, UnitedSchemeUtility.wrapCallbackParams(0));
        if (this.cfX.akG() != null && this.cfX.Ow() != null) {
            String valueOf = String.valueOf(this.cfX.Ow().getAppFrameType());
            String valueOf2 = String.valueOf(UnitedSchemeUtility.getParams(this.cfX.Ow().adD()).get("_baiduboxapp"));
            Bundle bundle = new Bundle();
            bundle.putString("frameType", valueOf);
            bundle.putString("appId", this.cfX.Ow().getAppId());
            try {
                bundle.putString("params", URLEncoder.encode(valueOf2, "UTF-8"));
            } catch (UnsupportedEncodingException e2) {
                if (DEBUG) {
                    throw new RuntimeException("This method requires UTF-8 encoding support", e2);
                }
            }
            this.cfX.akG().d(7, bundle);
        }
    }

    public boolean ahF() {
        com.baidu.swan.apps.console.c.d(TAG, "start UnitedSchemeWalletDispatcher ACTION_REQUEST_WECHAT_PAYMENT");
        if (a.ahC().a(this.cfX, this.bYa, this.bXZ)) {
            if (TextUtils.equals(this.mVersion, "2.0")) {
                this.mStatusCode = 0;
                this.mResult = null;
                com.baidu.swan.apps.w.a.acs().a(this.mAppKey, this);
            }
            f.a("wechatH5Action", (String) null, (ArrayList<String>) null);
            UnitedSchemeUtility.callCallback(this.bYa, this.bXZ, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
        this.bXZ.result = UnitedSchemeUtility.wrapCallbackParams(1001);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i, String str, String str2) {
        b.a Ow = this.cfX.Ow();
        f.a(i == 0, str, str2, Ow != null ? Ow.getAppFrameType() : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kZ(String str) {
        String str2;
        com.baidu.swan.apps.console.c.d(TAG, "sendSecondCallback, statusCode: " + this.mStatusCode + ", params: " + this.mResult);
        String str3 = this.bXZ.getParams().get("params");
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
                        this.bYa.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(jSONObject, this.mStatusCode, fL(this.mStatusCode)).toString());
                        return;
                    }
                    this.bYa.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParamsWithBase64(this.mResult, this.mStatusCode, fL(this.mStatusCode)).toString());
                    return;
                }
                this.bYa.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, this.mStatusCode, fL(this.mStatusCode)).toString());
            } catch (UnsupportedEncodingException e3) {
                e = e3;
                e.printStackTrace();
                this.bYa.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, this.mStatusCode, fL(this.mStatusCode)).toString());
            } catch (JSONException e4) {
                e = e4;
                e.printStackTrace();
                this.bYa.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, this.mStatusCode, fL(this.mStatusCode)).toString());
            }
        }
    }

    private static String fL(int i) {
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
    public void V(JSONObject jSONObject) {
        String str = null;
        if (jSONObject.optInt(BaseJsonData.TAG_ERRNO) == 0) {
            str = jSONObject.optJSONObject("data").optString("payid");
        }
        kZ(str);
    }

    @Override // com.baidu.swan.apps.ai.a
    public void onFail(String str) {
        com.baidu.swan.apps.console.c.e(TAG, "request payId failed");
        com.baidu.swan.apps.console.c.e(TAG, str);
        kZ(null);
    }

    public JSONObject aH(JSONObject jSONObject) {
        b.a Ow;
        if (this.cfX.ale() && jSONObject != null && (Ow = this.cfX.Ow()) != null && Ow.adT() != null) {
            JSONObject adT = Ow.adT();
            String optString = adT.optString("log_id");
            String optString2 = adT.optString("module_id");
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
