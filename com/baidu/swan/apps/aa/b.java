package com.baidu.swan.apps.aa;

import android.net.Uri;
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
import com.baidu.swan.apps.core.d.i;
import com.baidu.swan.apps.setting.oauth.a.b;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.u.c.b;
import com.baidu.swan.games.b.a;
import com.baidu.tieba.ala.live.walletconfig.CashierData;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import kotlin.l;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b implements com.baidu.swan.apps.aa.a.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String[] dgE = {"duershow"};
    private CallbackHandler cSD;
    private UnitedSchemeEntity cYi;
    private String cyN;
    private com.baidu.swan.apps.runtime.e cyc;
    private com.baidu.l.a dgD = new com.baidu.l.a();
    private String mAppKey;
    private String mResult;
    private int mStatusCode;
    private String mVersion;

    public b(com.baidu.swan.apps.runtime.e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, String str2, String str3) {
        this.cyc = eVar;
        this.cYi = unitedSchemeEntity;
        this.cSD = callbackHandler;
        this.mVersion = str;
        this.mAppKey = str2;
        this.cyN = str3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean qy(final String str) {
        if (this.cyc.aGZ().isLogin(this.cyc.getActivity())) {
            qz(str);
        } else {
            this.cyc.aGZ().a(this.cyc.getActivity(), null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.aa.b.1
                @Override // com.baidu.swan.apps.a.a
                public void onResult(int i) {
                    if (i == 0) {
                        b.this.qz(str);
                        return;
                    }
                    b.this.mStatusCode = 5;
                    b.this.mResult = null;
                    b.this.qB(null);
                }
            });
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qz(String str) {
        this.dgD.a(this.cyc.getActivity(), str, new com.baidu.l.a.a() { // from class: com.baidu.swan.apps.aa.b.2
            @Override // com.baidu.l.a.a
            public void onPayResult(int i, String str2) {
                b.this.mStatusCode = i;
                b.this.mResult = str2;
                if (b.DEBUG) {
                    Log.d("SwanAppPaymentManager", "statusCode: " + i + " ,result:" + str2);
                }
                b.this.f(i, "baiduqianbao", str2);
                if (i != 0 || !TextUtils.equals(b.this.mVersion, "2.0")) {
                    b.this.qB(null);
                } else {
                    com.baidu.swan.apps.t.a.awx().a(b.this.mAppKey, b.this);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean qA(String str) {
        if (DEBUG) {
            Log.d("SwanAppPaymentManager", "start UnitedSchemeWalletDispatcher ACTION_REQUEST_ALI_PAYMENT orderInfo: " + str);
        }
        this.dgD.b(this.cyc.getActivity(), str, new com.baidu.l.a.a() { // from class: com.baidu.swan.apps.aa.b.3
            @Override // com.baidu.l.a.a
            public void onPayResult(int i, String str2) {
                b.this.mStatusCode = i;
                b.this.mResult = str2;
                if (b.DEBUG) {
                    Log.d("SwanAppPaymentManager", "statusCode: " + b.this.mStatusCode + " ,result:" + b.this.mResult);
                }
                b.this.f(i, "alipay", str2);
                if (i != 0 || !TextUtils.equals(b.this.mVersion, "2.0")) {
                    b.this.qB(null);
                } else {
                    com.baidu.swan.apps.t.a.awx().a(b.this.mAppKey, b.this);
                }
            }
        });
        return true;
    }

    public boolean h(final String str, final JSONObject jSONObject) {
        final String[] strArr;
        Object opt;
        if (TextUtils.isEmpty(str)) {
            this.cYi.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        String optString = jSONObject.optString("__plugin__");
        com.baidu.swan.apps.ac.d.a.print("start payment");
        if (!TextUtils.isEmpty(optString) && (opt = jSONObject.opt(BdStatsConstant.StatsType.ERROR)) != null) {
            String optString2 = jSONObject.optString("slaveId");
            com.baidu.swan.apps.ac.c.c.a aVar = new com.baidu.swan.apps.ac.c.c.a(jSONObject.optString("componentId"));
            aVar.cCb = optString2;
            aVar.dje = opt;
            aVar.isSuccess = false;
            aVar.djf = null;
            aVar.aDM();
            this.cYi.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("bannedChannels");
        if (optJSONArray != null) {
            strArr = new String[optJSONArray.length()];
            for (int i = 0; i < optJSONArray.length(); i++) {
                strArr[i] = String.valueOf(optJSONArray.opt(i));
            }
        } else {
            strArr = null;
        }
        if (this.cyc.aGG() == null) {
            this.mStatusCode = 5;
            this.mResult = null;
            qB(null);
            if (DEBUG) {
                throw new RuntimeException("swanApp getActivity returns null");
            }
        } else if (this.cyc.aGZ().isLogin(this.cyc.getActivity())) {
            if (this.cyc.aHf()) {
                b(str, strArr, jSONObject, true, true);
            } else {
                a(str, strArr, jSONObject, true, true);
            }
        } else {
            this.cyc.aGZ().a(this.cyc.getActivity(), null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.aa.b.4
                @Override // com.baidu.swan.apps.a.a
                public void onResult(int i2) {
                    if (i2 == 0) {
                        if (b.this.cyc.aHf()) {
                            b.this.b(str, strArr, jSONObject, true, false);
                            return;
                        } else {
                            b.this.a(str, strArr, jSONObject, true, false);
                            return;
                        }
                    }
                    b.this.mStatusCode = 5;
                    b.this.mResult = null;
                    b.this.qB(null);
                    h.a("nuomi", false, false);
                }
            });
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String[] strArr, JSONObject jSONObject, boolean z, boolean z2) {
        a(str, strArr, jSONObject);
        h.a("nuomi", z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final String str, final String[] strArr, final JSONObject jSONObject, final boolean z, final boolean z2) {
        com.baidu.swan.games.b.d.aRN().a(str, new a.InterfaceC0526a() { // from class: com.baidu.swan.apps.aa.b.5
            @Override // com.baidu.swan.games.b.a.InterfaceC0526a
            public void onSuccess() {
                b.this.a(str, strArr, jSONObject, z, z2);
            }

            @Override // com.baidu.swan.games.b.a.InterfaceC0526a
            public void onFail(String str2) {
                if (!TextUtils.isEmpty(b.this.cyN)) {
                    b.this.cSD.handleSchemeDispatchCallback(b.this.cyN, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, 6, b.this.cyc.aGG().getString(a.h.swan_game_anti_addiction) + str2).toString());
                }
            }
        });
    }

    private void a(String str, final String[] strArr, final JSONObject jSONObject) {
        try {
            final JSONObject jSONObject2 = new JSONObject(str);
            com.baidu.swan.apps.network.c.b.d.b(jSONObject2.optString("appKey"), new kotlin.jvm.a.b<Boolean, l>() { // from class: com.baidu.swan.apps.aa.b.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.a.b
                /* renamed from: j */
                public l invoke(Boolean bool) {
                    if (bool.booleanValue()) {
                        b.this.a(jSONObject2, strArr, jSONObject);
                        return null;
                    }
                    b.this.aCx();
                    return null;
                }
            });
        } catch (JSONException e) {
            aCx();
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCx() {
        if (this.cyc != null) {
            com.baidu.swan.apps.res.widget.b.d.k(this.cyc.aGG(), a.h.swanapp_payment_illegal).showToast();
            if (!TextUtils.isEmpty(this.cyN)) {
                this.cSD.handleSchemeDispatchCallback(this.cyN, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, 6, this.cyc.aGG().getString(a.h.swanapp_payment_illegal)).toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject, String[] strArr, final JSONObject jSONObject2) {
        boolean z;
        try {
            if (com.baidu.swan.apps.d.a.f.cva.aiH()) {
                jSONObject.put("openBduss", com.baidu.swan.apps.t.a.avX().br(com.baidu.swan.apps.t.a.avS()));
                jSONObject.put("clientId", com.baidu.swan.apps.t.a.awE().ahc());
            } else {
                jSONObject.put("bduss", com.baidu.swan.apps.t.a.avX().br(com.baidu.swan.apps.t.a.avS()));
            }
            jSONObject.put("cuid", com.baidu.swan.apps.t.a.avX().bq(com.baidu.swan.apps.t.a.avS()));
            String optString = jSONObject.optString("bizInfo");
            JSONObject jSONObject3 = TextUtils.isEmpty(optString) ? new JSONObject() : new JSONObject(optString);
            jSONObject3.put("swanFrom", this.cyc.aGQ().axV());
            jSONObject3.put("cuid", com.baidu.swan.apps.t.a.avX().bq(com.baidu.swan.apps.t.a.avS()));
            jSONObject3.put("appId", com.baidu.swan.apps.runtime.d.aGI().getAppId());
            jSONObject.put("bizInfo", bo(jSONObject3).toString());
            jSONObject.put("platformId", "100003");
            jSONObject.put("nativeAppId", com.baidu.swan.apps.t.a.awE().getHostName());
            jSONObject.put("swanNativeVersion", com.baidu.swan.apps.c.getVersion());
            if (DEBUG) {
                Log.i("SwanAppPaymentManager", jSONObject.toString());
            }
        } catch (JSONException e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.v.f.azg().ayG();
        String[] strArr2 = dgE;
        int length = strArr2.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = false;
                break;
            } else if (!strArr2[i].equals(com.baidu.swan.apps.t.a.awE().getHostName())) {
                i++;
            } else {
                z = true;
                break;
            }
        }
        if (z) {
            String addParam = com.baidu.swan.c.h.addParam(com.baidu.swan.c.h.addParam("https://etrade.baidu.com/cashier/create-qrcode", "orderInfo", Uri.encode(jSONObject.toString())), CashierData.DEVICE_TYPE, "ANDROID");
            i.b("qrCodePay", com.baidu.swan.apps.model.b.ca(addParam, addParam));
            e.a(new d() { // from class: com.baidu.swan.apps.aa.b.7
                @Override // com.baidu.swan.apps.aa.d
                public void onPayResult(int i2, String str) {
                    b.this.a(i2, str, jSONObject2);
                }
            });
        } else {
            this.dgD.a(this.cyc.aGG(), jSONObject, strArr, new com.baidu.l.a.a() { // from class: com.baidu.swan.apps.aa.b.8
                @Override // com.baidu.l.a.a
                public void onPayResult(int i2, String str) {
                    b.this.a(i2, str, jSONObject2);
                }
            });
        }
        UnitedSchemeUtility.callCallback(this.cSD, this.cYi, UnitedSchemeUtility.wrapCallbackParams(0));
        if (this.cyc.aGD() != null) {
            String valueOf = String.valueOf(this.cyc.aGQ().getAppFrameType());
            String valueOf2 = String.valueOf(UnitedSchemeUtility.getParams(this.cyc.aGQ().axX()).get("_baiduboxapp"));
            Bundle bundle = new Bundle();
            bundle.putString("frameType", valueOf);
            bundle.putString("appId", this.cyc.aGQ().getAppId());
            try {
                bundle.putString("params", URLEncoder.encode(valueOf2, "UTF-8"));
            } catch (UnsupportedEncodingException e2) {
                if (DEBUG) {
                    throw new RuntimeException("This method requires UTF-8 encoding support", e2);
                }
            }
            this.cyc.aGD().d(7, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, JSONObject jSONObject) {
        com.baidu.swan.apps.v.f.azg().ayH();
        f(i, "nuomi", str);
        this.mStatusCode = i;
        this.mResult = str;
        qB(null);
        if (jSONObject != null && !TextUtils.isEmpty(jSONObject.optString("__plugin__"))) {
            String optString = jSONObject.optString("slaveId");
            String optString2 = jSONObject.optString("componentId");
            Object opt = jSONObject.opt(BdStatsConstant.StatsType.ERROR);
            com.baidu.swan.apps.ac.c.c.a aVar = new com.baidu.swan.apps.ac.c.c.a(optString2);
            aVar.cCb = optString;
            aVar.dje = opt;
            aVar.isSuccess = i == 0;
            aVar.djf = str;
            aVar.aDM();
            com.baidu.swan.apps.ac.g.b.aDQ();
        }
        if (this.mStatusCode == 0) {
            com.baidu.swan.apps.ae.c.dkS.aFt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aCy() {
        com.baidu.swan.apps.console.c.i("SwanAppPaymentManager", "start UnitedSchemeWalletDispatcher ACTION_REQUEST_WECHAT_PAYMENT");
        if (a.aCw().a(this.cyc, this.cSD, this.cYi)) {
            this.mStatusCode = 0;
            this.mResult = null;
            if (TextUtils.equals(this.mVersion, "2.0")) {
                com.baidu.swan.apps.t.a.awx().a(this.mAppKey, this);
            } else {
                qB(null);
            }
            h.a("wechatH5Action", (String) null, (ArrayList<String>) null);
            return true;
        }
        this.cSD.handleSchemeDispatchCallback(this.cyN, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(int i, String str, String str2) {
        h.a(i == 0, str, str2, this.cyc.aGQ().getAppFrameType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qB(String str) {
        com.baidu.swan.apps.console.c.i("SwanAppPaymentManager", "sendSecondCallback, statusCode: " + this.mStatusCode + ", params: " + this.mResult);
        try {
            if (TextUtils.equals(this.mVersion, "2.0")) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("payId", str);
                if (!TextUtils.isEmpty(this.mResult)) {
                    jSONObject.put("payResult", Base64.encodeToString(this.mResult.getBytes("UTF-8"), 2));
                }
                this.cSD.handleSchemeDispatchCallback(this.cyN, UnitedSchemeUtility.wrapCallbackParams(jSONObject, this.mStatusCode, jB(this.mStatusCode)).toString());
                return;
            }
            this.cSD.handleSchemeDispatchCallback(this.cyN, UnitedSchemeUtility.wrapCallbackParamsWithBase64(this.mResult, this.mStatusCode, jB(this.mStatusCode)).toString());
        } catch (UnsupportedEncodingException | JSONException e) {
            e.printStackTrace();
            this.cSD.handleSchemeDispatchCallback(this.cyN, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, this.mStatusCode, jB(this.mStatusCode)).toString());
        }
    }

    private static String jB(int i) {
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

    @Override // com.baidu.swan.apps.ae.a
    public void ay(JSONObject jSONObject) {
        String str = null;
        if (jSONObject.optInt(BaseJsonData.TAG_ERRNO) == 0) {
            str = jSONObject.optJSONObject("data").optString("payid");
        }
        qB(str);
        if (com.baidu.swan.apps.t.a.avX().bo(this.cyc)) {
            com.baidu.swan.apps.ae.c.dkS.aFt();
        } else {
            com.baidu.swan.apps.ae.c.dkS.aFu();
        }
    }

    @Override // com.baidu.swan.apps.ae.a
    public void onFail(String str) {
        com.baidu.swan.apps.console.c.e("SwanAppPaymentManager", "request payId failed");
        com.baidu.swan.apps.console.c.e("SwanAppPaymentManager", str);
        qB(null);
    }

    private JSONObject bo(JSONObject jSONObject) {
        if (this.cyc.aHf() && jSONObject != null) {
            b.a aGQ = this.cyc.aGQ();
            if (aGQ.ayn() != null) {
                JSONObject ayn = aGQ.ayn();
                String optString = ayn.optString("log_id");
                String optString2 = ayn.optString("module_id");
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
        }
        return jSONObject;
    }

    public boolean cd(final String str, final String str2) {
        if (TextUtils.isEmpty(str2) && (str.equals("mapp_request_duxiaoman") || str.equals("mapp_request_alipayment"))) {
            this.cYi.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        this.cyc.aGY().b(this.cyc.aGG(), str, new com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.setting.oauth.h<b.d>>() { // from class: com.baidu.swan.apps.aa.b.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: a */
            public void M(com.baidu.swan.apps.setting.oauth.h<b.d> hVar) {
                if (!com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                    String str3 = null;
                    if (TextUtils.equals(b.this.mVersion, "2.0")) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("payId", "");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        str3 = String.valueOf(jSONObject);
                    }
                    b.this.cSD.handleSchemeDispatchCallback(b.this.cyN, UnitedSchemeUtility.wrapCallbackParamsWithBase64(str3, 1001, "authorize denied").toString());
                    return;
                }
                String str4 = str;
                char c = 65535;
                switch (str4.hashCode()) {
                    case -1689456891:
                        if (str4.equals("mapp_request_wechatpayment")) {
                            c = 2;
                            break;
                        }
                        break;
                    case -1250772529:
                        if (str4.equals("mapp_request_duxiaoman")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 1111965155:
                        if (str4.equals("mapp_request_alipayment")) {
                            c = 1;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        b.this.qy(str2);
                        return;
                    case 1:
                        b.this.qA(str2);
                        return;
                    case 2:
                        b.this.aCy();
                        return;
                    default:
                        return;
                }
            }
        });
        UnitedSchemeUtility.callCallback(this.cSD, this.cYi, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }
}
