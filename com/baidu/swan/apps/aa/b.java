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
/* loaded from: classes10.dex */
public class b implements com.baidu.swan.apps.aa.a.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String[] cTS = {"duershow"};
    private CallbackHandler cFY;
    private UnitedSchemeEntity cLD;
    private com.baidu.l.a cTR = new com.baidu.l.a();
    private String clZ;
    private com.baidu.swan.apps.runtime.e clo;
    private String mAppKey;
    private String mResult;
    private int mStatusCode;
    private String mVersion;

    public b(com.baidu.swan.apps.runtime.e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, String str2, String str3) {
        this.clo = eVar;
        this.cLD = unitedSchemeEntity;
        this.cFY = callbackHandler;
        this.mVersion = str;
        this.mAppKey = str2;
        this.clZ = str3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pX(final String str) {
        if (this.clo.aDn().isLogin(this.clo.getActivity())) {
            pY(str);
        } else {
            this.clo.aDn().a(this.clo.getActivity(), null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.aa.b.1
                @Override // com.baidu.swan.apps.a.a
                public void onResult(int i) {
                    if (i == 0) {
                        b.this.pY(str);
                        return;
                    }
                    b.this.mStatusCode = 5;
                    b.this.mResult = null;
                    b.this.qa(null);
                }
            });
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pY(String str) {
        this.cTR.a(this.clo.getActivity(), str, new com.baidu.l.a.a() { // from class: com.baidu.swan.apps.aa.b.2
            @Override // com.baidu.l.a.a
            public void onPayResult(int i, String str2) {
                b.this.mStatusCode = i;
                b.this.mResult = str2;
                if (b.DEBUG) {
                    Log.d("SwanAppPaymentManager", "statusCode: " + i + " ,result:" + str2);
                }
                b.this.e(i, "baiduqianbao", str2);
                if (i != 0 || !TextUtils.equals(b.this.mVersion, "2.0")) {
                    b.this.qa(null);
                } else {
                    com.baidu.swan.apps.t.a.asL().a(b.this.mAppKey, b.this);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pZ(String str) {
        if (DEBUG) {
            Log.d("SwanAppPaymentManager", "start UnitedSchemeWalletDispatcher ACTION_REQUEST_ALI_PAYMENT orderInfo: " + str);
        }
        this.cTR.b(this.clo.getActivity(), str, new com.baidu.l.a.a() { // from class: com.baidu.swan.apps.aa.b.3
            @Override // com.baidu.l.a.a
            public void onPayResult(int i, String str2) {
                b.this.mStatusCode = i;
                b.this.mResult = str2;
                if (b.DEBUG) {
                    Log.d("SwanAppPaymentManager", "statusCode: " + b.this.mStatusCode + " ,result:" + b.this.mResult);
                }
                b.this.e(i, "alipay", str2);
                if (i != 0 || !TextUtils.equals(b.this.mVersion, "2.0")) {
                    b.this.qa(null);
                } else {
                    com.baidu.swan.apps.t.a.asL().a(b.this.mAppKey, b.this);
                }
            }
        });
        return true;
    }

    public boolean f(final String str, final JSONObject jSONObject) {
        final String[] strArr;
        Object opt;
        if (TextUtils.isEmpty(str)) {
            this.cLD.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        String optString = jSONObject.optString("__plugin__");
        com.baidu.swan.apps.ac.d.a.print("start payment");
        if (!TextUtils.isEmpty(optString) && (opt = jSONObject.opt(BdStatsConstant.StatsType.ERROR)) != null) {
            String optString2 = jSONObject.optString("slaveId");
            com.baidu.swan.apps.ac.c.c.a aVar = new com.baidu.swan.apps.ac.c.c.a(jSONObject.optString("componentId"));
            aVar.cpq = optString2;
            aVar.cWp = opt;
            aVar.isSuccess = false;
            aVar.cWq = null;
            aVar.aAa();
            this.cLD.result = UnitedSchemeUtility.wrapCallbackParams(1001);
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
        if (this.clo.aCU() == null) {
            this.mStatusCode = 5;
            this.mResult = null;
            qa(null);
            if (DEBUG) {
                throw new RuntimeException("swanApp getActivity returns null");
            }
        } else if (this.clo.aDn().isLogin(this.clo.getActivity())) {
            if (this.clo.aDt()) {
                b(str, strArr, jSONObject, true, true);
            } else {
                a(str, strArr, jSONObject, true, true);
            }
        } else {
            this.clo.aDn().a(this.clo.getActivity(), null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.aa.b.4
                @Override // com.baidu.swan.apps.a.a
                public void onResult(int i2) {
                    if (i2 == 0) {
                        if (b.this.clo.aDt()) {
                            b.this.b(str, strArr, jSONObject, true, false);
                            return;
                        } else {
                            b.this.a(str, strArr, jSONObject, true, false);
                            return;
                        }
                    }
                    b.this.mStatusCode = 5;
                    b.this.mResult = null;
                    b.this.qa(null);
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
        com.baidu.swan.games.b.d.aOb().a(str, new a.InterfaceC0502a() { // from class: com.baidu.swan.apps.aa.b.5
            @Override // com.baidu.swan.games.b.a.InterfaceC0502a
            public void onSuccess() {
                b.this.a(str, strArr, jSONObject, z, z2);
            }

            @Override // com.baidu.swan.games.b.a.InterfaceC0502a
            public void onFail(String str2) {
                if (!TextUtils.isEmpty(b.this.clZ)) {
                    b.this.cFY.handleSchemeDispatchCallback(b.this.clZ, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, 6, b.this.clo.aCU().getString(a.h.swan_game_anti_addiction) + str2).toString());
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
                    b.this.ayL();
                    return null;
                }
            });
        } catch (JSONException e) {
            ayL();
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayL() {
        if (this.clo != null) {
            com.baidu.swan.apps.res.widget.b.d.k(this.clo.aCU(), a.h.swanapp_payment_illegal).showToast();
            if (!TextUtils.isEmpty(this.clZ)) {
                this.cFY.handleSchemeDispatchCallback(this.clZ, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, 6, this.clo.aCU().getString(a.h.swanapp_payment_illegal)).toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject, String[] strArr, final JSONObject jSONObject2) {
        boolean z;
        try {
            if (com.baidu.swan.apps.d.a.f.cim.aeV()) {
                jSONObject.put("openBduss", com.baidu.swan.apps.t.a.ask().br(com.baidu.swan.apps.t.a.asf()));
                jSONObject.put("clientId", com.baidu.swan.apps.t.a.asS().adq());
            } else {
                jSONObject.put("bduss", com.baidu.swan.apps.t.a.ask().br(com.baidu.swan.apps.t.a.asf()));
            }
            jSONObject.put("cuid", com.baidu.swan.apps.t.a.ask().bq(com.baidu.swan.apps.t.a.asf()));
            String optString = jSONObject.optString("bizInfo");
            JSONObject jSONObject3 = TextUtils.isEmpty(optString) ? new JSONObject() : new JSONObject(optString);
            jSONObject3.put("swanFrom", this.clo.aDe().auj());
            jSONObject3.put("cuid", com.baidu.swan.apps.t.a.ask().bq(com.baidu.swan.apps.t.a.asf()));
            jSONObject3.put("appId", com.baidu.swan.apps.runtime.d.aCW().getAppId());
            jSONObject.put("bizInfo", bl(jSONObject3).toString());
            jSONObject.put("platformId", "100003");
            jSONObject.put("nativeAppId", com.baidu.swan.apps.t.a.asS().getHostName());
            jSONObject.put("swanNativeVersion", com.baidu.swan.apps.c.getVersion());
            if (DEBUG) {
                Log.i("SwanAppPaymentManager", jSONObject.toString());
            }
        } catch (JSONException e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.v.f.avu().auU();
        String[] strArr2 = cTS;
        int length = strArr2.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = false;
                break;
            } else if (!strArr2[i].equals(com.baidu.swan.apps.t.a.asS().getHostName())) {
                i++;
            } else {
                z = true;
                break;
            }
        }
        if (z) {
            String addParam = com.baidu.swan.c.h.addParam(com.baidu.swan.c.h.addParam("https://etrade.baidu.com/cashier/create-qrcode", "orderInfo", Uri.encode(jSONObject.toString())), CashierData.DEVICE_TYPE, "ANDROID");
            i.b("qrCodePay", com.baidu.swan.apps.model.b.bU(addParam, addParam));
            e.a(new d() { // from class: com.baidu.swan.apps.aa.b.7
                @Override // com.baidu.swan.apps.aa.d
                public void onPayResult(int i2, String str) {
                    b.this.a(i2, str, jSONObject2);
                }
            });
        } else {
            this.cTR.a(this.clo.aCU(), jSONObject, strArr, new com.baidu.l.a.a() { // from class: com.baidu.swan.apps.aa.b.8
                @Override // com.baidu.l.a.a
                public void onPayResult(int i2, String str) {
                    b.this.a(i2, str, jSONObject2);
                }
            });
        }
        UnitedSchemeUtility.callCallback(this.cFY, this.cLD, UnitedSchemeUtility.wrapCallbackParams(0));
        if (this.clo.aCR() != null) {
            String valueOf = String.valueOf(this.clo.aDe().getAppFrameType());
            String valueOf2 = String.valueOf(UnitedSchemeUtility.getParams(this.clo.aDe().aul()).get("_baiduboxapp"));
            Bundle bundle = new Bundle();
            bundle.putString("frameType", valueOf);
            bundle.putString("appId", this.clo.aDe().getAppId());
            try {
                bundle.putString("params", URLEncoder.encode(valueOf2, "UTF-8"));
            } catch (UnsupportedEncodingException e2) {
                if (DEBUG) {
                    throw new RuntimeException("This method requires UTF-8 encoding support", e2);
                }
            }
            this.clo.aCR().d(7, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, JSONObject jSONObject) {
        com.baidu.swan.apps.v.f.avu().auV();
        e(i, "nuomi", str);
        this.mStatusCode = i;
        this.mResult = str;
        qa(null);
        if (jSONObject != null && !TextUtils.isEmpty(jSONObject.optString("__plugin__"))) {
            String optString = jSONObject.optString("slaveId");
            String optString2 = jSONObject.optString("componentId");
            Object opt = jSONObject.opt(BdStatsConstant.StatsType.ERROR);
            com.baidu.swan.apps.ac.c.c.a aVar = new com.baidu.swan.apps.ac.c.c.a(optString2);
            aVar.cpq = optString;
            aVar.cWp = opt;
            aVar.isSuccess = i == 0;
            aVar.cWq = str;
            aVar.aAa();
            com.baidu.swan.apps.ac.g.b.aAe();
        }
        if (this.mStatusCode == 0) {
            com.baidu.swan.apps.ae.c.cYd.aBH();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ayM() {
        com.baidu.swan.apps.console.c.i("SwanAppPaymentManager", "start UnitedSchemeWalletDispatcher ACTION_REQUEST_WECHAT_PAYMENT");
        if (a.ayK().a(this.clo, this.cFY, this.cLD)) {
            this.mStatusCode = 0;
            this.mResult = null;
            if (TextUtils.equals(this.mVersion, "2.0")) {
                com.baidu.swan.apps.t.a.asL().a(this.mAppKey, this);
            } else {
                qa(null);
            }
            h.a("wechatH5Action", (String) null, (ArrayList<String>) null);
            return true;
        }
        this.cFY.handleSchemeDispatchCallback(this.clZ, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i, String str, String str2) {
        h.a(i == 0, str, str2, this.clo.aDe().getAppFrameType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qa(String str) {
        com.baidu.swan.apps.console.c.i("SwanAppPaymentManager", "sendSecondCallback, statusCode: " + this.mStatusCode + ", params: " + this.mResult);
        try {
            if (TextUtils.equals(this.mVersion, "2.0")) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("payId", str);
                if (!TextUtils.isEmpty(this.mResult)) {
                    jSONObject.put("payResult", Base64.encodeToString(this.mResult.getBytes("UTF-8"), 2));
                }
                this.cFY.handleSchemeDispatchCallback(this.clZ, UnitedSchemeUtility.wrapCallbackParams(jSONObject, this.mStatusCode, jk(this.mStatusCode)).toString());
                return;
            }
            this.cFY.handleSchemeDispatchCallback(this.clZ, UnitedSchemeUtility.wrapCallbackParamsWithBase64(this.mResult, this.mStatusCode, jk(this.mStatusCode)).toString());
        } catch (UnsupportedEncodingException | JSONException e) {
            e.printStackTrace();
            this.cFY.handleSchemeDispatchCallback(this.clZ, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, this.mStatusCode, jk(this.mStatusCode)).toString());
        }
    }

    private static String jk(int i) {
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
    public void av(JSONObject jSONObject) {
        String str = null;
        if (jSONObject.optInt(BaseJsonData.TAG_ERRNO) == 0) {
            str = jSONObject.optJSONObject("data").optString("payid");
        }
        qa(str);
        if (com.baidu.swan.apps.t.a.ask().bo(this.clo)) {
            com.baidu.swan.apps.ae.c.cYd.aBH();
        } else {
            com.baidu.swan.apps.ae.c.cYd.aBI();
        }
    }

    @Override // com.baidu.swan.apps.ae.a
    public void onFail(String str) {
        com.baidu.swan.apps.console.c.e("SwanAppPaymentManager", "request payId failed");
        com.baidu.swan.apps.console.c.e("SwanAppPaymentManager", str);
        qa(null);
    }

    private JSONObject bl(JSONObject jSONObject) {
        if (this.clo.aDt() && jSONObject != null) {
            b.a aDe = this.clo.aDe();
            if (aDe.auB() != null) {
                JSONObject auB = aDe.auB();
                String optString = auB.optString("log_id");
                String optString2 = auB.optString("module_id");
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

    public boolean bX(final String str, final String str2) {
        if (TextUtils.isEmpty(str2) && (str.equals("mapp_request_duxiaoman") || str.equals("mapp_request_alipayment"))) {
            this.cLD.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        this.clo.aDm().b(this.clo.aCU(), str, new com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.setting.oauth.h<b.d>>() { // from class: com.baidu.swan.apps.aa.b.9
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
                    b.this.cFY.handleSchemeDispatchCallback(b.this.clZ, UnitedSchemeUtility.wrapCallbackParamsWithBase64(str3, 1001, "authorize denied").toString());
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
                        b.this.pX(str2);
                        return;
                    case 1:
                        b.this.pZ(str2);
                        return;
                    case 2:
                        b.this.ayM();
                        return;
                    default:
                        return;
                }
            }
        });
        UnitedSchemeUtility.callCallback(this.cFY, this.cLD, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }
}
