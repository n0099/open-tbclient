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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b implements com.baidu.swan.apps.aa.a.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String[] dnO = {"duershow"};
    private com.baidu.swan.apps.runtime.e cEY;
    private String cFJ;
    private CallbackHandler cZC;
    private UnitedSchemeEntity dfm;
    private String dnM;
    private com.baidu.k.a dnN = new com.baidu.k.a();
    private String mAppKey;
    private int mStatusCode;
    private String mVersion;

    public b(com.baidu.swan.apps.runtime.e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, String str2, String str3) {
        this.cEY = eVar;
        this.dfm = unitedSchemeEntity;
        this.cZC = callbackHandler;
        this.mVersion = str;
        this.mAppKey = str2;
        this.cFJ = str3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pN(final String str) {
        if (this.cEY.aIE().isLogin(this.cEY.getActivity())) {
            pO(str);
        } else {
            this.cEY.aIE().a(this.cEY.getActivity(), null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.aa.b.1
                @Override // com.baidu.swan.apps.a.a
                public void onResult(int i) {
                    if (i == 0) {
                        b.this.pO(str);
                        return;
                    }
                    b.this.mStatusCode = 5;
                    b.this.dnM = null;
                    b.this.pQ(null);
                }
            });
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pO(String str) {
        this.dnN.a(this.cEY.getActivity(), str, new com.baidu.k.a.a() { // from class: com.baidu.swan.apps.aa.b.2
            @Override // com.baidu.k.a.a
            public void onPayResult(int i, String str2) {
                b.this.mStatusCode = i;
                b.this.dnM = str2;
                if (b.DEBUG) {
                    Log.d("SwanAppPaymentManager", "statusCode: " + i + " ,result:" + str2);
                }
                b.this.h(i, "baiduqianbao", str2);
                if (i != 0 || !TextUtils.equals(b.this.mVersion, "2.0")) {
                    b.this.pQ(null);
                } else {
                    com.baidu.swan.apps.t.a.axd().a(b.this.mAppKey, b.this);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pP(String str) {
        if (DEBUG) {
            Log.d("SwanAppPaymentManager", "start UnitedSchemeWalletDispatcher ACTION_REQUEST_ALI_PAYMENT orderInfo: " + str);
        }
        this.dnN.b(this.cEY.getActivity(), str, new com.baidu.k.a.a() { // from class: com.baidu.swan.apps.aa.b.3
            @Override // com.baidu.k.a.a
            public void onPayResult(int i, String str2) {
                b.this.mStatusCode = i;
                b.this.dnM = str2;
                if (b.DEBUG) {
                    Log.d("SwanAppPaymentManager", "statusCode: " + b.this.mStatusCode + " ,result:" + b.this.dnM);
                }
                b.this.h(i, "alipay", str2);
                if (i != 0 || !TextUtils.equals(b.this.mVersion, "2.0")) {
                    b.this.pQ(null);
                } else {
                    com.baidu.swan.apps.t.a.axd().a(b.this.mAppKey, b.this);
                }
            }
        });
        return true;
    }

    public boolean i(final String str, final JSONObject jSONObject) {
        final String[] strArr;
        Object opt;
        if (TextUtils.isEmpty(str)) {
            this.dfm.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        String optString = jSONObject.optString("__plugin__");
        com.baidu.swan.apps.ac.d.a.print("start payment");
        if (!TextUtils.isEmpty(optString) && (opt = jSONObject.opt(BdStatsConstant.StatsType.ERROR)) != null) {
            String optString2 = jSONObject.optString("slaveId");
            com.baidu.swan.apps.ac.c.c.a aVar = new com.baidu.swan.apps.ac.c.c.a(jSONObject.optString("componentId"));
            aVar.cJd = optString2;
            aVar.dqn = opt;
            aVar.isSuccess = false;
            aVar.dqo = null;
            aVar.aEu();
            this.dfm.result = UnitedSchemeUtility.wrapCallbackParams(1001);
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
        if (this.cEY.aIl() == null) {
            this.mStatusCode = 5;
            this.dnM = null;
            pQ(null);
            if (DEBUG) {
                throw new RuntimeException("swanApp getActivity returns null");
            }
        } else if (this.cEY.aIE().isLogin(this.cEY.getActivity())) {
            if (this.cEY.aIK()) {
                b(str, strArr, jSONObject, true, true);
            } else {
                a(str, strArr, jSONObject, true, true);
            }
        } else {
            this.cEY.aIE().a(this.cEY.getActivity(), null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.aa.b.4
                @Override // com.baidu.swan.apps.a.a
                public void onResult(int i2) {
                    if (i2 == 0) {
                        if (b.this.cEY.aIK()) {
                            b.this.b(str, strArr, jSONObject, true, false);
                            return;
                        } else {
                            b.this.a(str, strArr, jSONObject, true, false);
                            return;
                        }
                    }
                    b.this.mStatusCode = 5;
                    b.this.dnM = null;
                    b.this.pQ(null);
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
        com.baidu.swan.games.b.d.aTt().a(str, new a.InterfaceC0514a() { // from class: com.baidu.swan.apps.aa.b.5
            @Override // com.baidu.swan.games.b.a.InterfaceC0514a
            public void onSuccess() {
                b.this.a(str, strArr, jSONObject, z, z2);
            }

            @Override // com.baidu.swan.games.b.a.InterfaceC0514a
            public void onFail(String str2) {
                if (!TextUtils.isEmpty(b.this.cFJ)) {
                    b.this.cZC.handleSchemeDispatchCallback(b.this.cFJ, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, 6, b.this.cEY.aIl().getString(a.h.swan_game_anti_addiction) + str2).toString());
                }
            }
        });
    }

    private void a(String str, final String[] strArr, final JSONObject jSONObject) {
        try {
            final JSONObject jSONObject2 = new JSONObject(str);
            com.baidu.swan.apps.network.c.b.d.b(jSONObject2.optString("appKey"), new kotlin.jvm.a.b<Boolean, kotlin.h>() { // from class: com.baidu.swan.apps.aa.b.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.a.b
                /* renamed from: k */
                public kotlin.h invoke(Boolean bool) {
                    if (bool.booleanValue()) {
                        b.this.a(jSONObject2, strArr, jSONObject);
                        return null;
                    }
                    b.this.aDh();
                    return null;
                }
            });
        } catch (JSONException e) {
            aDh();
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDh() {
        if (this.cEY != null) {
            com.baidu.swan.apps.res.widget.b.d.u(this.cEY.aIl(), a.h.swanapp_payment_illegal).aHZ();
            if (!TextUtils.isEmpty(this.cFJ)) {
                this.cZC.handleSchemeDispatchCallback(this.cFJ, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, 6, this.cEY.aIl().getString(a.h.swanapp_payment_illegal)).toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject, String[] strArr, final JSONObject jSONObject2) {
        boolean z;
        try {
            if (com.baidu.swan.apps.d.a.f.cBW.ajg()) {
                jSONObject.put("openBduss", com.baidu.swan.apps.t.a.awD().cd(com.baidu.swan.apps.t.a.awy()));
                jSONObject.put("clientId", com.baidu.swan.apps.t.a.axk().ahz());
            } else {
                jSONObject.put("bduss", com.baidu.swan.apps.t.a.awD().cd(com.baidu.swan.apps.t.a.awy()));
            }
            jSONObject.put("cuid", com.baidu.swan.apps.t.a.awD().cc(com.baidu.swan.apps.t.a.awy()));
            String optString = jSONObject.optString("bizInfo");
            JSONObject jSONObject3 = TextUtils.isEmpty(optString) ? new JSONObject() : new JSONObject(optString);
            jSONObject3.put("swanFrom", this.cEY.aIv().ayC());
            jSONObject3.put("cuid", com.baidu.swan.apps.t.a.awD().cc(com.baidu.swan.apps.t.a.awy()));
            jSONObject3.put("appId", com.baidu.swan.apps.runtime.d.aIn().getAppId());
            jSONObject.put("bizInfo", by(jSONObject3).toString());
            jSONObject.put("platformId", "100003");
            jSONObject.put("nativeAppId", com.baidu.swan.apps.t.a.axk().getHostName());
            jSONObject.put("swanNativeVersion", com.baidu.swan.apps.c.getVersion());
            if (DEBUG) {
                Log.i("SwanAppPaymentManager", jSONObject.toString());
            }
        } catch (JSONException e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.v.f.azN().azn();
        String[] strArr2 = dnO;
        int length = strArr2.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = false;
                break;
            } else if (!strArr2[i].equals(com.baidu.swan.apps.t.a.axk().getHostName())) {
                i++;
            } else {
                z = true;
                break;
            }
        }
        if (z) {
            String addParam = com.baidu.swan.c.h.addParam(com.baidu.swan.c.h.addParam("https://etrade.baidu.com/cashier/create-qrcode", "orderInfo", Uri.encode(jSONObject.toString())), CashierData.DEVICE_TYPE, "ANDROID");
            i.b("qrCodePay", com.baidu.swan.apps.model.b.cf(addParam, addParam));
            e.a(new d() { // from class: com.baidu.swan.apps.aa.b.7
                @Override // com.baidu.swan.apps.aa.d
                public void onPayResult(int i2, String str) {
                    b.this.a(i2, str, jSONObject2);
                }
            });
        } else {
            this.dnN.a(this.cEY.aIl(), jSONObject, strArr, new com.baidu.k.a.a() { // from class: com.baidu.swan.apps.aa.b.8
                @Override // com.baidu.k.a.a
                public void onPayResult(int i2, String str) {
                    b.this.a(i2, str, jSONObject2);
                }
            });
        }
        UnitedSchemeUtility.callCallback(this.cZC, this.dfm, UnitedSchemeUtility.wrapCallbackParams(0));
        if (this.cEY.aIi() != null) {
            String valueOf = String.valueOf(this.cEY.aIv().getAppFrameType());
            String valueOf2 = String.valueOf(UnitedSchemeUtility.getParams(this.cEY.aIv().ayE()).get("_baiduboxapp"));
            Bundle bundle = new Bundle();
            bundle.putString("frameType", valueOf);
            bundle.putString("appId", this.cEY.aIv().getAppId());
            try {
                bundle.putString("params", URLEncoder.encode(valueOf2, "UTF-8"));
            } catch (UnsupportedEncodingException e2) {
                if (DEBUG) {
                    throw new RuntimeException("This method requires UTF-8 encoding support", e2);
                }
            }
            this.cEY.aIi().d(7, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, JSONObject jSONObject) {
        com.baidu.swan.apps.v.f.azN().azo();
        h(i, "nuomi", str);
        this.mStatusCode = i;
        this.dnM = str;
        pQ(null);
        if (jSONObject != null && !TextUtils.isEmpty(jSONObject.optString("__plugin__"))) {
            String optString = jSONObject.optString("slaveId");
            String optString2 = jSONObject.optString("componentId");
            Object opt = jSONObject.opt(BdStatsConstant.StatsType.ERROR);
            com.baidu.swan.apps.ac.c.c.a aVar = new com.baidu.swan.apps.ac.c.c.a(optString2);
            aVar.cJd = optString;
            aVar.dqn = opt;
            aVar.isSuccess = i == 0;
            aVar.dqo = str;
            aVar.aEu();
            com.baidu.swan.apps.ac.g.b.aEy();
        }
        if (this.mStatusCode == 0) {
            com.baidu.swan.apps.ae.c.dsc.aGb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aDi() {
        com.baidu.swan.apps.console.c.i("SwanAppPaymentManager", "start UnitedSchemeWalletDispatcher ACTION_REQUEST_WECHAT_PAYMENT");
        if (a.aDg().a(this.cEY, this.cZC, this.dfm)) {
            this.mStatusCode = 0;
            this.dnM = null;
            if (TextUtils.equals(this.mVersion, "2.0")) {
                com.baidu.swan.apps.t.a.axd().a(this.mAppKey, this);
            } else {
                pQ(null);
            }
            h.a("wechatH5Action", (String) null, (ArrayList<String>) null);
            return true;
        }
        this.cZC.handleSchemeDispatchCallback(this.cFJ, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i, String str, String str2) {
        h.a(i == 0, str, str2, this.cEY.aIv().getAppFrameType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pQ(String str) {
        com.baidu.swan.apps.console.c.i("SwanAppPaymentManager", "sendSecondCallback, statusCode: " + this.mStatusCode + ", params: " + this.dnM);
        try {
            if (TextUtils.equals(this.mVersion, "2.0")) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("payId", str);
                if (!TextUtils.isEmpty(this.dnM)) {
                    jSONObject.put("payResult", Base64.encodeToString(this.dnM.getBytes("UTF-8"), 2));
                }
                this.cZC.handleSchemeDispatchCallback(this.cFJ, UnitedSchemeUtility.wrapCallbackParams(jSONObject, this.mStatusCode, io(this.mStatusCode)).toString());
                return;
            }
            this.cZC.handleSchemeDispatchCallback(this.cFJ, UnitedSchemeUtility.wrapCallbackParamsWithBase64(this.dnM, this.mStatusCode, io(this.mStatusCode)).toString());
        } catch (UnsupportedEncodingException | JSONException e) {
            e.printStackTrace();
            this.cZC.handleSchemeDispatchCallback(this.cFJ, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, this.mStatusCode, io(this.mStatusCode)).toString());
        }
    }

    private static String io(int i) {
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
    public void aI(JSONObject jSONObject) {
        String str = null;
        if (jSONObject.optInt(BaseJsonData.TAG_ERRNO) == 0) {
            str = jSONObject.optJSONObject("data").optString("payid");
        }
        pQ(str);
        if (com.baidu.swan.apps.t.a.awD().ca(this.cEY)) {
            com.baidu.swan.apps.ae.c.dsc.aGb();
        } else {
            com.baidu.swan.apps.ae.c.dsc.aGc();
        }
    }

    @Override // com.baidu.swan.apps.ae.a
    public void onFail(String str) {
        com.baidu.swan.apps.console.c.e("SwanAppPaymentManager", "request payId failed");
        com.baidu.swan.apps.console.c.e("SwanAppPaymentManager", str);
        pQ(null);
    }

    private JSONObject by(JSONObject jSONObject) {
        if (this.cEY.aIK() && jSONObject != null) {
            b.a aIv = this.cEY.aIv();
            if (aIv.ayU() != null) {
                JSONObject ayU = aIv.ayU();
                String optString = ayU.optString("log_id");
                String optString2 = ayU.optString("module_id");
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

    public boolean ci(final String str, final String str2) {
        if (TextUtils.isEmpty(str2) && (str.equals("mapp_request_duxiaoman") || str.equals("mapp_request_alipayment"))) {
            this.dfm.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        this.cEY.aID().b(this.cEY.aIl(), str, new com.baidu.swan.apps.ao.e.b<com.baidu.swan.apps.setting.oauth.h<b.d>>() { // from class: com.baidu.swan.apps.aa.b.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: a */
            public void L(com.baidu.swan.apps.setting.oauth.h<b.d> hVar) {
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
                    b.this.cZC.handleSchemeDispatchCallback(b.this.cFJ, UnitedSchemeUtility.wrapCallbackParamsWithBase64(str3, 1001, "authorize denied").toString());
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
                        b.this.pN(str2);
                        return;
                    case 1:
                        b.this.pP(str2);
                        return;
                    case 2:
                        b.this.aDi();
                        return;
                    default:
                        return;
                }
            }
        });
        UnitedSchemeUtility.callCallback(this.cZC, this.dfm, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }
}
