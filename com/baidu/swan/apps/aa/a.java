package com.baidu.swan.apps.aa;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.aa.a.d;
import java.io.UnsupportedEncodingException;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a implements d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = a.class.getSimpleName();
    private com.baidu.swan.apps.ae.b aDm;
    private String aDn;
    private UnitedSchemeEntity ayH;
    private CallbackHandler ayI;
    private String mAppKey;
    private int mStatusCode;
    private String mVersion;

    public a(com.baidu.swan.apps.ae.b bVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, String str2) {
        this.aDm = bVar;
        this.ayH = unitedSchemeEntity;
        this.ayI = callbackHandler;
        this.mVersion = str;
        this.mAppKey = str2;
    }

    public boolean fw(String str) {
        if (TextUtils.isEmpty(str)) {
            this.ayH.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        com.baidu.swan.apps.u.a.CM().a(this.aDm, str, new com.baidu.swan.apps.aa.a.b() { // from class: com.baidu.swan.apps.aa.a.1
            @Override // com.baidu.swan.apps.aa.a.b
            public void m(int i, String str2) {
                a.this.mStatusCode = i;
                a.this.aDn = str2;
                if (a.DEBUG) {
                    Log.d(a.TAG, "statusCode: " + i + " ,result:" + str2);
                }
                a.this.c(i, "baiduqianbao", str2);
                if (i != 0 || !TextUtils.equals(a.this.mVersion, "2.0")) {
                    a.this.fy(null);
                } else {
                    com.baidu.swan.apps.u.a.CZ().a(a.this.mAppKey, a.this);
                }
            }
        });
        UnitedSchemeUtility.callCallback(this.ayI, this.ayH, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }

    public boolean fx(String str) {
        com.baidu.swan.apps.console.c.d(TAG, "start UnitedSchemeWalletDispatcher ACTION_REQUEST_ALI_PAYMENT");
        if (TextUtils.isEmpty(str)) {
            this.ayH.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        com.baidu.swan.apps.u.a.CM().a(str, new com.baidu.swan.apps.aa.a.a() { // from class: com.baidu.swan.apps.aa.a.2
            @Override // com.baidu.swan.apps.aa.a.a
            public void n(int i, String str2) {
                a.this.mStatusCode = i;
                a.this.aDn = str2;
                if (a.DEBUG) {
                    Log.d(a.TAG, "statusCode: " + a.this.mStatusCode + " ,result:" + a.this.aDn);
                }
                a.this.c(i, "alipay", str2);
                if (i != 0 || !TextUtils.equals(a.this.mVersion, "2.0")) {
                    a.this.fy(null);
                } else {
                    com.baidu.swan.apps.u.a.CZ().a(a.this.mAppKey, a.this);
                }
            }
        });
        UnitedSchemeUtility.callCallback(this.ayI, this.ayH, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }

    public boolean Fq() {
        com.baidu.swan.apps.console.c.d(TAG, "start UnitedSchemeWalletDispatcher ACTION_REQUEST_WECHAT_PAYMENT");
        if (c.Fr().a(this.aDm, this.ayI, this.ayH)) {
            if (TextUtils.equals(this.mVersion, "2.0")) {
                this.mStatusCode = 0;
                this.aDn = null;
                com.baidu.swan.apps.u.a.CZ().a(this.mAppKey, this);
            }
            UnitedSchemeUtility.callCallback(this.ayI, this.ayH, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
        this.ayH.result = UnitedSchemeUtility.wrapCallbackParams(1001);
        com.baidu.swan.apps.statistic.c.gR("wechatH5Action");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i, String str, String str2) {
        com.baidu.swan.apps.v.b.b uA = this.aDm.uA();
        com.baidu.swan.apps.statistic.c.a(i == 0, str, str2, uA != null ? uA.aya : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fy(String str) {
        String str2;
        com.baidu.swan.apps.console.c.d(TAG, "sendSecondCallback, statusCode: " + this.mStatusCode + ", params: " + this.aDn);
        String str3 = this.ayH.getParams().get("params");
        if (!TextUtils.isEmpty(str3)) {
            try {
                str2 = new JSONObject(str3).optString("cb");
                try {
                    if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(this.aDn)) {
                        String optString = new JSONObject(this.aDn).optString("responseData");
                        if (TextUtils.equals(this.mVersion, "2.0")) {
                            JSONObject jSONObject = new JSONObject();
                            if (!TextUtils.isEmpty(str)) {
                                jSONObject.put("payId", str);
                            }
                            if (!TextUtils.isEmpty(this.aDn)) {
                                jSONObject.put("payResult", Base64.encodeToString(optString.getBytes(HTTP.UTF_8), 2));
                            }
                            this.ayI.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(jSONObject, this.mStatusCode, cI(this.mStatusCode)).toString());
                            return;
                        }
                        this.ayI.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParamsWithBase64(optString, this.mStatusCode, cI(this.mStatusCode)).toString());
                        return;
                    }
                    this.ayI.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, this.mStatusCode, cI(this.mStatusCode)).toString());
                } catch (UnsupportedEncodingException e) {
                    e = e;
                    e.printStackTrace();
                    this.ayI.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, this.mStatusCode, cI(this.mStatusCode)).toString());
                } catch (JSONException e2) {
                    e = e2;
                    e.printStackTrace();
                    this.ayI.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, this.mStatusCode, cI(this.mStatusCode)).toString());
                }
            } catch (UnsupportedEncodingException e3) {
                e = e3;
                str2 = null;
            } catch (JSONException e4) {
                e = e4;
                str2 = null;
            }
        }
    }

    private static String cI(int i) {
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

    @Override // com.baidu.swan.apps.ad.a
    public void onFail(String str) {
        com.baidu.swan.apps.console.c.e(TAG, "request payId failed");
        com.baidu.swan.apps.console.c.e(TAG, str);
        fy(null);
    }
}
