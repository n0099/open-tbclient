package com.baidu.swan.apps.ac;

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
import com.baidu.swan.apps.setting.oauth.a.b;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.v.b.b;
import com.baidu.swan.e.i;
import com.baidu.swan.games.b.a;
import com.baidu.tieba.ala.live.walletconfig.CashierData;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import kotlin.l;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b implements com.baidu.swan.apps.ac.a.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = b.class.getSimpleName();
    private static String[] cqP = {"duershow"};
    private com.baidu.swan.apps.runtime.e bLN;
    private String bMu;
    private UnitedSchemeEntity ciH;
    private CallbackHandler ciI;
    private com.baidu.g.a cqO = new com.baidu.g.a();
    private String mAppKey;
    private String mResult;
    private int mStatusCode;
    private String mVersion;

    public b(com.baidu.swan.apps.runtime.e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, String str2, String str3) {
        this.bLN = eVar;
        this.ciH = unitedSchemeEntity;
        this.ciI = callbackHandler;
        this.mVersion = str;
        this.mAppKey = str2;
        this.bMu = str3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean mk(final String str) {
        if (this.bLN.aoS().isLogin(this.bLN.getActivity())) {
            ml(str);
        } else {
            this.bLN.aoS().a(this.bLN.getActivity(), null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.ac.b.1
                @Override // com.baidu.swan.apps.a.a
                public void onResult(int i) {
                    if (i == 0) {
                        b.this.ml(str);
                        return;
                    }
                    b.this.mStatusCode = 5;
                    b.this.mResult = null;
                    b.this.mn(null);
                }
            });
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ml(String str) {
        this.cqO.a(this.bLN.getActivity(), str, new com.baidu.g.a.a() { // from class: com.baidu.swan.apps.ac.b.2
            @Override // com.baidu.g.a.a
            public void onPayResult(int i, String str2) {
                b.this.mStatusCode = i;
                b.this.mResult = str2;
                if (b.DEBUG) {
                    Log.d(b.TAG, "statusCode: " + i + " ,result:" + str2);
                }
                b.this.e(i, "baiduqianbao", str2);
                if (i != 0 || !TextUtils.equals(b.this.mVersion, "2.0")) {
                    b.this.mn(null);
                } else {
                    com.baidu.swan.apps.u.a.afu().a(b.this.mAppKey, b.this);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean mm(String str) {
        if (DEBUG) {
            Log.d(TAG, "start UnitedSchemeWalletDispatcher ACTION_REQUEST_ALI_PAYMENT orderInfo: " + str);
        }
        this.cqO.b(this.bLN.getActivity(), str, new com.baidu.g.a.a() { // from class: com.baidu.swan.apps.ac.b.3
            @Override // com.baidu.g.a.a
            public void onPayResult(int i, String str2) {
                b.this.mStatusCode = i;
                b.this.mResult = str2;
                if (b.DEBUG) {
                    Log.d(b.TAG, "statusCode: " + b.this.mStatusCode + " ,result:" + b.this.mResult);
                }
                b.this.e(i, "alipay", str2);
                if (i != 0 || !TextUtils.equals(b.this.mVersion, "2.0")) {
                    b.this.mn(null);
                } else {
                    com.baidu.swan.apps.u.a.afu().a(b.this.mAppKey, b.this);
                }
            }
        });
        return true;
    }

    public boolean f(final String str, final JSONObject jSONObject) {
        final String[] strArr;
        Object opt;
        if (TextUtils.isEmpty(str)) {
            this.ciH.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        String optString = jSONObject.optString("__plugin__");
        com.baidu.swan.apps.ae.d.a.print("start payment");
        if (!TextUtils.isEmpty(optString) && (opt = jSONObject.opt(BdStatsConstant.StatsType.ERROR)) != null) {
            String optString2 = jSONObject.optString("slaveId");
            com.baidu.swan.apps.ae.c.c.a aVar = new com.baidu.swan.apps.ae.c.c.a(jSONObject.optString("componentId"));
            aVar.bPG = optString2;
            aVar.csL = opt;
            aVar.isSuccess = false;
            aVar.csM = null;
            aVar.alU();
            this.ciH.result = UnitedSchemeUtility.wrapCallbackParams(1001);
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
        if (this.bLN.aoz() == null) {
            this.mStatusCode = 5;
            this.mResult = null;
            mn(null);
            if (DEBUG) {
                throw new RuntimeException("swanApp getActivity returns null");
            }
        } else if (this.bLN.aoS().isLogin(this.bLN.getActivity())) {
            if (this.bLN.aoY()) {
                b(str, strArr, jSONObject, true, true);
            } else {
                a(str, strArr, jSONObject, true, true);
            }
        } else {
            this.bLN.aoS().a(this.bLN.getActivity(), null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.ac.b.4
                @Override // com.baidu.swan.apps.a.a
                public void onResult(int i2) {
                    if (i2 == 0) {
                        if (b.this.bLN.aoY()) {
                            b.this.b(str, strArr, jSONObject, true, false);
                            return;
                        } else {
                            b.this.a(str, strArr, jSONObject, true, false);
                            return;
                        }
                    }
                    b.this.mStatusCode = 5;
                    b.this.mResult = null;
                    b.this.mn(null);
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
        com.baidu.swan.games.b.d.axh().a(str, new a.InterfaceC0423a() { // from class: com.baidu.swan.apps.ac.b.5
            @Override // com.baidu.swan.games.b.a.InterfaceC0423a
            public void onSuccess() {
                b.this.a(str, strArr, jSONObject, z, z2);
            }

            @Override // com.baidu.swan.games.b.a.InterfaceC0423a
            public void onFail(String str2) {
                if (!TextUtils.isEmpty(b.this.bMu)) {
                    b.this.ciI.handleSchemeDispatchCallback(b.this.bMu, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, 6, b.this.bLN.aoz().getString(a.h.swan_game_anti_addiction) + str2).toString());
                }
            }
        });
    }

    private void a(String str, final String[] strArr, final JSONObject jSONObject) {
        try {
            final JSONObject jSONObject2 = new JSONObject(str);
            com.baidu.swan.apps.network.c.b.d.a(jSONObject2.optString("appKey"), new kotlin.jvm.a.b<Boolean, l>() { // from class: com.baidu.swan.apps.ac.b.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.a.b
                /* renamed from: f */
                public l invoke(Boolean bool) {
                    if (bool.booleanValue()) {
                        b.this.a(jSONObject2, strArr, jSONObject);
                        return null;
                    }
                    b.this.akX();
                    return null;
                }
            });
        } catch (JSONException e) {
            akX();
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akX() {
        if (this.bLN != null) {
            com.baidu.swan.apps.res.widget.b.d.k(this.bLN.aoz(), a.h.swanapp_payment_illegal).showToast();
            if (!TextUtils.isEmpty(this.bMu)) {
                this.ciI.handleSchemeDispatchCallback(this.bMu, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, 6, this.bLN.aoz().getString(a.h.swanapp_payment_illegal)).toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject, String[] strArr, final JSONObject jSONObject2) {
        boolean z;
        try {
            jSONObject.put("bduss", com.baidu.swan.apps.u.a.aeW().bd(com.baidu.swan.apps.u.a.aeR()));
            jSONObject.put("cuid", com.baidu.swan.apps.u.a.aeW().bc(com.baidu.swan.apps.u.a.aeR()));
            String optString = jSONObject.optString("bizInfo");
            JSONObject jSONObject3 = TextUtils.isEmpty(optString) ? new JSONObject() : new JSONObject(optString);
            jSONObject3.put("swanFrom", this.bLN.aoJ().agK());
            jSONObject3.put("cuid", com.baidu.swan.apps.u.a.aeW().bc(com.baidu.swan.apps.u.a.aeR()));
            jSONObject3.put("appId", com.baidu.swan.apps.runtime.d.aoB().getAppId());
            jSONObject.put("bizInfo", aL(jSONObject3).toString());
            jSONObject.put("platformId", "100003");
            jSONObject.put("nativeAppId", com.baidu.swan.apps.u.a.afB().getHostName());
            jSONObject.put("swanNativeVersion", com.baidu.swan.apps.c.getVersion());
            if (DEBUG) {
                Log.i(TAG, jSONObject.toString());
            }
        } catch (JSONException e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.w.f.ahV().ahv();
        String[] strArr2 = cqP;
        int length = strArr2.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = false;
                break;
            } else if (!strArr2[i].equals(com.baidu.swan.apps.u.a.afB().getHostName())) {
                i++;
            } else {
                z = true;
                break;
            }
        }
        if (z) {
            String addParam = i.addParam(i.addParam("https://etrade.baidu.com/cashier/create-qrcode", "orderInfo", Uri.encode(jSONObject.toString())), CashierData.DEVICE_TYPE, "ANDROID");
            com.baidu.swan.apps.core.d.h.b("qrCodePay", com.baidu.swan.apps.model.b.bx(addParam, addParam));
            e.a(new d() { // from class: com.baidu.swan.apps.ac.b.7
                @Override // com.baidu.swan.apps.ac.d
                public void onPayResult(int i2, String str) {
                    b.this.a(i2, str, jSONObject2);
                }
            });
        } else {
            this.cqO.a(this.bLN.aoz(), jSONObject, strArr, new com.baidu.g.a.a() { // from class: com.baidu.swan.apps.ac.b.8
                @Override // com.baidu.g.a.a
                public void onPayResult(int i2, String str) {
                    b.this.a(i2, str, jSONObject2);
                }
            });
        }
        UnitedSchemeUtility.callCallback(this.ciI, this.ciH, UnitedSchemeUtility.wrapCallbackParams(0));
        if (this.bLN.aow() != null) {
            String valueOf = String.valueOf(this.bLN.aoJ().getAppFrameType());
            String valueOf2 = String.valueOf(UnitedSchemeUtility.getParams(this.bLN.aoJ().agM()).get("_baiduboxapp"));
            Bundle bundle = new Bundle();
            bundle.putString("frameType", valueOf);
            bundle.putString("appId", this.bLN.aoJ().getAppId());
            try {
                bundle.putString("params", URLEncoder.encode(valueOf2, "UTF-8"));
            } catch (UnsupportedEncodingException e2) {
                if (DEBUG) {
                    throw new RuntimeException("This method requires UTF-8 encoding support", e2);
                }
            }
            this.bLN.aow().d(7, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, JSONObject jSONObject) {
        com.baidu.swan.apps.w.f.ahV().ahw();
        e(i, "nuomi", str);
        this.mStatusCode = i;
        this.mResult = str;
        mn(null);
        if (jSONObject != null && !TextUtils.isEmpty(jSONObject.optString("__plugin__"))) {
            String optString = jSONObject.optString("slaveId");
            String optString2 = jSONObject.optString("componentId");
            Object opt = jSONObject.opt(BdStatsConstant.StatsType.ERROR);
            com.baidu.swan.apps.ae.c.c.a aVar = new com.baidu.swan.apps.ae.c.c.a(optString2);
            aVar.bPG = optString;
            aVar.csL = opt;
            aVar.isSuccess = i == 0;
            aVar.csM = str;
            aVar.alU();
            com.baidu.swan.apps.ae.g.b.alY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean akY() {
        com.baidu.swan.apps.console.c.d(TAG, "start UnitedSchemeWalletDispatcher ACTION_REQUEST_WECHAT_PAYMENT");
        if (a.akW().a(this.bLN, this.ciI, this.ciH)) {
            this.mStatusCode = 0;
            this.mResult = null;
            if (TextUtils.equals(this.mVersion, "2.0")) {
                com.baidu.swan.apps.u.a.afu().a(this.mAppKey, this);
            } else {
                mn(null);
            }
            h.a("wechatH5Action", (String) null, (ArrayList<String>) null);
            return true;
        }
        this.ciI.handleSchemeDispatchCallback(this.bMu, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i, String str, String str2) {
        h.a(i == 0, str, str2, this.bLN.aoJ().getAppFrameType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mn(String str) {
        com.baidu.swan.apps.console.c.d(TAG, "sendSecondCallback, statusCode: " + this.mStatusCode + ", params: " + this.mResult);
        try {
            if (TextUtils.equals(this.mVersion, "2.0")) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("payId", str);
                if (!TextUtils.isEmpty(this.mResult)) {
                    jSONObject.put("payResult", Base64.encodeToString(this.mResult.getBytes("UTF-8"), 2));
                }
                this.ciI.handleSchemeDispatchCallback(this.bMu, UnitedSchemeUtility.wrapCallbackParams(jSONObject, this.mStatusCode, gc(this.mStatusCode)).toString());
                return;
            }
            this.ciI.handleSchemeDispatchCallback(this.bMu, UnitedSchemeUtility.wrapCallbackParamsWithBase64(this.mResult, this.mStatusCode, gc(this.mStatusCode)).toString());
        } catch (UnsupportedEncodingException | JSONException e) {
            e.printStackTrace();
            this.ciI.handleSchemeDispatchCallback(this.bMu, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, this.mStatusCode, gc(this.mStatusCode)).toString());
        }
    }

    private static String gc(int i) {
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

    @Override // com.baidu.swan.apps.ag.a
    public void aa(JSONObject jSONObject) {
        String str = null;
        if (jSONObject.optInt(BaseJsonData.TAG_ERRNO) == 0) {
            str = jSONObject.optJSONObject("data").optString("payid");
        }
        mn(str);
    }

    @Override // com.baidu.swan.apps.ag.a
    public void onFail(String str) {
        com.baidu.swan.apps.console.c.e(TAG, "request payId failed");
        com.baidu.swan.apps.console.c.e(TAG, str);
        mn(null);
    }

    private JSONObject aL(JSONObject jSONObject) {
        if (this.bLN.aoY() && jSONObject != null) {
            b.a aoJ = this.bLN.aoJ();
            if (aoJ.ahc() != null) {
                JSONObject ahc = aoJ.ahc();
                String optString = ahc.optString("log_id");
                String optString2 = ahc.optString("module_id");
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

    public boolean bz(final String str, final String str2) {
        if (TextUtils.isEmpty(str2) && (str.equals("mapp_request_duxiaoman") || str.equals("mapp_request_alipayment"))) {
            this.ciH.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        this.bLN.aoR().b(this.bLN.aoz(), str, new com.baidu.swan.apps.aq.e.b<com.baidu.swan.apps.setting.oauth.h<b.d>>() { // from class: com.baidu.swan.apps.ac.b.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: a */
            public void H(com.baidu.swan.apps.setting.oauth.h<b.d> hVar) {
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
                    b.this.ciI.handleSchemeDispatchCallback(b.this.bMu, UnitedSchemeUtility.wrapCallbackParamsWithBase64(str3, 1001, "authorize denied").toString());
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
                        b.this.mk(str2);
                        return;
                    case 1:
                        b.this.mm(str2);
                        return;
                    case 2:
                        b.this.akY();
                        return;
                    default:
                        return;
                }
            }
        });
        UnitedSchemeUtility.callCallback(this.ciI, this.ciH, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }
}
