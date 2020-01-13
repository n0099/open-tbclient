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
import kotlin.k;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b implements com.baidu.swan.apps.ae.a.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = b.class.getSimpleName();
    private e bCV;
    private com.baidu.j.a bCW = new com.baidu.j.a();
    private UnitedSchemeEntity bvx;
    private CallbackHandler bvy;
    private String mAppKey;
    private String mResult;
    private int mStatusCode;
    private String mVersion;

    public b(e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, String str2) {
        this.bCV = eVar;
        this.bvx = unitedSchemeEntity;
        this.bvy = callbackHandler;
        this.mVersion = str;
        this.mAppKey = str2;
    }

    public boolean jv(final String str) {
        if (TextUtils.isEmpty(str)) {
            this.bvx.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else if (this.bCV == null) {
            this.bvx.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else if (this.bCV.aaA().isLogin(this.bCV.getActivity())) {
            jw(str);
            UnitedSchemeUtility.callCallback(this.bvy, this.bvx, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        } else {
            this.bCV.aaA().a(this.bCV.getActivity(), null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.ae.b.1
                @Override // com.baidu.swan.apps.a.a
                public void onResult(int i) {
                    if (i == 0) {
                        b.this.jw(str);
                        return;
                    }
                    b.this.mStatusCode = 5;
                    b.this.mResult = null;
                    b.this.jy(null);
                }
            });
            UnitedSchemeUtility.callCallback(this.bvy, this.bvx, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jw(String str) {
        this.bCW.a(this.bCV.getActivity(), str, new com.baidu.j.a.a() { // from class: com.baidu.swan.apps.ae.b.2
            @Override // com.baidu.j.a.a
            public void onPayResult(int i, String str2) {
                b.this.mStatusCode = i;
                b.this.mResult = str2;
                if (b.DEBUG) {
                    Log.d(b.TAG, "statusCode: " + i + " ,result:" + str2);
                }
                b.this.d(i, "baiduqianbao", str2);
                if (i != 0 || !TextUtils.equals(b.this.mVersion, "2.0")) {
                    b.this.jy(null);
                } else {
                    com.baidu.swan.apps.w.a.Sk().a(b.this.mAppKey, b.this);
                }
            }
        });
    }

    public boolean jx(String str) {
        if (DEBUG) {
            Log.d(TAG, "start UnitedSchemeWalletDispatcher ACTION_REQUEST_ALI_PAYMENT orderInfo: " + str);
        }
        if (TextUtils.isEmpty(str)) {
            this.bvx.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        this.bCW.b(this.bCV.getActivity(), str, new com.baidu.j.a.a() { // from class: com.baidu.swan.apps.ae.b.3
            @Override // com.baidu.j.a.a
            public void onPayResult(int i, String str2) {
                b.this.mStatusCode = i;
                b.this.mResult = str2;
                if (b.DEBUG) {
                    Log.d(b.TAG, "statusCode: " + b.this.mStatusCode + " ,result:" + b.this.mResult);
                }
                b.this.d(i, "alipay", str2);
                if (i != 0 || !TextUtils.equals(b.this.mVersion, "2.0")) {
                    b.this.jy(null);
                } else {
                    com.baidu.swan.apps.w.a.Sk().a(b.this.mAppKey, b.this);
                }
            }
        });
        UnitedSchemeUtility.callCallback(this.bvy, this.bvx, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }

    public boolean e(final String str, final JSONObject jSONObject) {
        final String[] strArr;
        Object opt;
        if (TextUtils.isEmpty(str)) {
            this.bvx.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        String optString = jSONObject.optString("__plugin__");
        com.baidu.swan.apps.ag.d.a.print("start payment");
        if (!TextUtils.isEmpty(optString) && (opt = jSONObject.opt(BdStatsConstant.StatsType.ERROR)) != null) {
            String optString2 = jSONObject.optString("slaveId");
            com.baidu.swan.apps.ag.c.c.a aVar = new com.baidu.swan.apps.ag.c.c.a(jSONObject.optString("componentId"));
            aVar.bdW = optString2;
            aVar.bEp = opt;
            aVar.isSuccess = false;
            aVar.bEq = null;
            aVar.XQ();
            this.bvx.result = UnitedSchemeUtility.wrapCallbackParams(1001);
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
        if (this.bCV.getActivity() == null) {
            this.mStatusCode = 5;
            this.mResult = null;
            jy(null);
            if (DEBUG) {
                throw new RuntimeException("swanApp getActivity returns null");
            }
        } else if (this.bCV.aaA().isLogin(this.bCV.getActivity())) {
            a(str, strArr, jSONObject);
            f.a("nuomi", true, true);
        } else {
            this.bCV.aaA().a(this.bCV.getActivity(), null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.ae.b.4
                @Override // com.baidu.swan.apps.a.a
                public void onResult(int i2) {
                    if (i2 == 0) {
                        b.this.a(str, strArr, jSONObject);
                        f.a("nuomi", true, false);
                        return;
                    }
                    b.this.mStatusCode = 5;
                    b.this.mResult = null;
                    b.this.jy(null);
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
            d.a(jSONObject2.optString("appKey"), new kotlin.jvm.a.b<Boolean, k>() { // from class: com.baidu.swan.apps.ae.b.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.a.b
                /* renamed from: f */
                public k invoke(Boolean bool) {
                    if (bool.booleanValue()) {
                        b.this.a(jSONObject2, strArr, jSONObject);
                        return null;
                    }
                    b.this.Xg();
                    return null;
                }
            });
        } catch (JSONException e) {
            Xg();
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private String Xf() {
        String str = this.bvx.getParams().get("params");
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
    public void Xg() {
        String Xf = Xf();
        if (this.bCV != null) {
            com.baidu.swan.apps.res.widget.b.d.q(this.bCV.aal(), a.h.swanapp_payment_illegal).showToast();
            if (!TextUtils.isEmpty(Xf)) {
                this.bvy.handleSchemeDispatchCallback(Xf, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, 6, this.bCV.aal().getString(a.h.swanapp_payment_illegal)).toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject, String[] strArr, final JSONObject jSONObject2) {
        try {
            if (com.baidu.swan.apps.c.a.e.aYc.GY()) {
                jSONObject.put("maBduss", com.baidu.swan.apps.w.a.RL().bo(com.baidu.swan.apps.w.a.RG()));
            } else {
                jSONObject.put("bduss", com.baidu.swan.apps.w.a.RL().bo(com.baidu.swan.apps.w.a.RG()));
            }
            jSONObject.put("cuid", com.baidu.swan.apps.w.a.RL().bn(com.baidu.swan.apps.w.a.RG()));
            String optString = jSONObject.optString("bizInfo");
            JSONObject jSONObject3 = TextUtils.isEmpty(optString) ? new JSONObject() : new JSONObject(optString);
            if (this.bCV.En() != null) {
                jSONObject3.put("swanFrom", this.bCV.En().Tt());
            }
            jSONObject3.put("cuid", com.baidu.swan.apps.w.a.RL().bn(com.baidu.swan.apps.w.a.RG()));
            jSONObject3.put("appId", e.aar());
            jSONObject.put("bizInfo", aw(jSONObject3).toString());
            jSONObject.put("platformId", "100003");
            jSONObject.put("nativeAppId", com.baidu.swan.apps.w.a.Sr().getHostName());
            jSONObject.put("swanNativeVersion", com.baidu.swan.apps.c.getVersion());
            if (DEBUG) {
                Log.i(TAG, jSONObject.toString());
            }
        } catch (JSONException e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.y.f.UC().Ud();
        this.bCW.a(this.bCV.aal(), jSONObject, strArr, new com.baidu.j.a.a() { // from class: com.baidu.swan.apps.ae.b.6
            @Override // com.baidu.j.a.a
            public void onPayResult(int i, String str) {
                com.baidu.swan.apps.y.f.UC().Ue();
                b.this.d(i, "nuomi", str);
                b.this.mStatusCode = i;
                b.this.mResult = str;
                b.this.jy(null);
                if (jSONObject2 != null && !TextUtils.isEmpty(jSONObject2.optString("__plugin__"))) {
                    String optString2 = jSONObject2.optString("slaveId");
                    String optString3 = jSONObject2.optString("componentId");
                    Object opt = jSONObject2.opt(BdStatsConstant.StatsType.ERROR);
                    com.baidu.swan.apps.ag.c.c.a aVar = new com.baidu.swan.apps.ag.c.c.a(optString3);
                    aVar.bdW = optString2;
                    aVar.bEp = opt;
                    aVar.isSuccess = i == 0;
                    aVar.bEq = str;
                    aVar.XQ();
                    com.baidu.swan.apps.ag.g.b.XU();
                }
            }
        });
        UnitedSchemeUtility.callCallback(this.bvy, this.bvx, UnitedSchemeUtility.wrapCallbackParams(0));
        if (this.bCV.aai() != null && this.bCV.En() != null) {
            String valueOf = String.valueOf(this.bCV.En().getAppFrameType());
            String valueOf2 = String.valueOf(UnitedSchemeUtility.getParams(this.bCV.En().Tv()).get("_baiduboxapp"));
            Bundle bundle = new Bundle();
            bundle.putString("frameType", valueOf);
            bundle.putString("appId", this.bCV.En().getAppId());
            try {
                bundle.putString("params", URLEncoder.encode(valueOf2, "UTF-8"));
            } catch (UnsupportedEncodingException e2) {
                if (DEBUG) {
                    throw new RuntimeException("This method requires UTF-8 encoding support", e2);
                }
            }
            this.bCV.aai().e(7, bundle);
        }
    }

    public boolean Xh() {
        com.baidu.swan.apps.console.c.d(TAG, "start UnitedSchemeWalletDispatcher ACTION_REQUEST_WECHAT_PAYMENT");
        if (a.Xe().a(this.bCV, this.bvy, this.bvx)) {
            if (TextUtils.equals(this.mVersion, "2.0")) {
                this.mStatusCode = 0;
                this.mResult = null;
                com.baidu.swan.apps.w.a.Sk().a(this.mAppKey, this);
            }
            f.a("wechatH5Action", (String) null, (ArrayList<String>) null);
            UnitedSchemeUtility.callCallback(this.bvy, this.bvx, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
        this.bvx.result = UnitedSchemeUtility.wrapCallbackParams(1001);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i, String str, String str2) {
        b.a En = this.bCV.En();
        f.a(i == 0, str, str2, En != null ? En.getAppFrameType() : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jy(String str) {
        String str2;
        com.baidu.swan.apps.console.c.d(TAG, "sendSecondCallback, statusCode: " + this.mStatusCode + ", params: " + this.mResult);
        String str3 = this.bvx.getParams().get("params");
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
                        this.bvy.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(jSONObject, this.mStatusCode, fo(this.mStatusCode)).toString());
                        return;
                    }
                    this.bvy.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParamsWithBase64(this.mResult, this.mStatusCode, fo(this.mStatusCode)).toString());
                    return;
                }
                this.bvy.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, this.mStatusCode, fo(this.mStatusCode)).toString());
            } catch (UnsupportedEncodingException e3) {
                e = e3;
                e.printStackTrace();
                this.bvy.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, this.mStatusCode, fo(this.mStatusCode)).toString());
            } catch (JSONException e4) {
                e = e4;
                e.printStackTrace();
                this.bvy.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, this.mStatusCode, fo(this.mStatusCode)).toString());
            }
        }
    }

    private static String fo(int i) {
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
        jy(str);
    }

    @Override // com.baidu.swan.apps.ai.a
    public void onFail(String str) {
        com.baidu.swan.apps.console.c.e(TAG, "request payId failed");
        com.baidu.swan.apps.console.c.e(TAG, str);
        jy(null);
    }

    public JSONObject aw(JSONObject jSONObject) {
        b.a En;
        if (this.bCV.aaG() && jSONObject != null && (En = this.bCV.En()) != null && En.TL() != null) {
            JSONObject TL = En.TL();
            String optString = TL.optString("log_id");
            String optString2 = TL.optString("module_id");
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
