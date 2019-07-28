package com.baidu.swan.apps.aa;

import android.app.Activity;
import android.net.http.Headers;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.baidu.poly.a;
import com.baidu.poly.bean.PayChannel;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.statistic.e;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a implements com.baidu.swan.apps.aa.a.c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = a.class.getSimpleName();
    private static com.baidu.poly.a aFH = null;
    private UnitedSchemeEntity aAn;
    private CallbackHandler aAo;
    private com.baidu.swan.apps.ae.b aFI;
    private String aFJ;
    private String mAppKey;
    private int mStatusCode;
    private String mVersion;

    public a(com.baidu.swan.apps.ae.b bVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, String str2) {
        this.aFI = bVar;
        this.aAn = unitedSchemeEntity;
        this.aAo = callbackHandler;
        this.mVersion = str;
        this.mAppKey = str2;
    }

    public boolean fP(String str) {
        if (TextUtils.isEmpty(str)) {
            this.aAn.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        com.baidu.swan.apps.u.a.EA().a(this.aFI, str, new com.baidu.swan.apps.aa.a.b() { // from class: com.baidu.swan.apps.aa.a.1
            @Override // com.baidu.swan.apps.aa.a.b
            public void j(int i, String str2) {
                a.this.mStatusCode = i;
                a.this.aFJ = str2;
                if (a.DEBUG) {
                    Log.d(a.TAG, "statusCode: " + i + " ,result:" + str2);
                }
                a.this.c(i, "baiduqianbao", str2);
                if (i != 0 || !TextUtils.equals(a.this.mVersion, "2.0")) {
                    a.this.fR(null);
                } else {
                    com.baidu.swan.apps.u.a.EN().a(a.this.mAppKey, a.this);
                }
            }
        });
        UnitedSchemeUtility.callCallback(this.aAo, this.aAn, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }

    public boolean fQ(String str) {
        com.baidu.swan.apps.console.c.d(TAG, "start UnitedSchemeWalletDispatcher ACTION_REQUEST_ALI_PAYMENT");
        if (TextUtils.isEmpty(str)) {
            this.aAn.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        com.baidu.swan.apps.u.a.EA().a(this.aFI, str, new com.baidu.swan.apps.aa.a.a() { // from class: com.baidu.swan.apps.aa.a.2
            @Override // com.baidu.swan.apps.aa.a.a
            public void i(int i, String str2) {
                a.this.mStatusCode = i;
                a.this.aFJ = str2;
                if (a.DEBUG) {
                    Log.d(a.TAG, "statusCode: " + a.this.mStatusCode + " ,result:" + a.this.aFJ);
                }
                a.this.c(i, "alipay", str2);
                if (i != 0 || !TextUtils.equals(a.this.mVersion, "2.0")) {
                    a.this.fR(null);
                } else {
                    com.baidu.swan.apps.u.a.EN().a(a.this.mAppKey, a.this);
                }
            }
        });
        UnitedSchemeUtility.callCallback(this.aAo, this.aAn, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }

    public boolean g(final String str, JSONObject jSONObject) {
        final String[] strArr;
        if (TextUtils.isEmpty(str)) {
            this.aAn.result = UnitedSchemeUtility.wrapCallbackParams(1001);
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
        this.aFI.Mi().a(this.aFI.getActivity(), null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.aa.a.3
            @Override // com.baidu.swan.apps.a.a
            public void onResult(int i2) {
                if (i2 == 0) {
                    a.this.e(str, strArr);
                    return;
                }
                a.this.mStatusCode = 5;
                a.this.aFJ = null;
                a.this.fR(null);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str, String[] strArr) {
        JSONObject jSONObject;
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            Bundle bundle = new Bundle();
            String bd = com.baidu.swan.apps.u.a.Ep().bd(com.baidu.swan.apps.u.a.Ek());
            if (com.baidu.swan.apps.u.a.Ep().bb(com.baidu.swan.apps.u.a.Ek())) {
                bundle.putString("bduss", com.baidu.swan.apps.u.a.Ep().be(com.baidu.swan.apps.u.a.Ek()));
            }
            bundle.putString("cuid", bd);
            bundle.putString("appKey", jSONObject2.optString("appKey"));
            bundle.putString("dealId", jSONObject2.optString("dealId"));
            bundle.putString("dealTitle", jSONObject2.optString("dealTitle"));
            bundle.putString("rsaSign", jSONObject2.optString("rsaSign"));
            bundle.putString("totalAmount", jSONObject2.optString("totalAmount"));
            bundle.putString("tpOrderId", jSONObject2.optString("tpOrderId"));
            String optString = jSONObject2.optString("bizInfo");
            if (TextUtils.isEmpty(optString)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(optString);
            }
            if (this.aFI.vL() != null) {
                jSONObject.put("swanFrom", this.aFI.vL().FG());
            }
            jSONObject.put("cuid", bd);
            jSONObject.put("appId", com.baidu.swan.apps.ae.b.Mo());
            bundle.putString("bizInfo", jSONObject.toString());
            bundle.putString("platformId", "100003");
            bundle.putString("nativeAppId", com.baidu.swan.apps.u.a.Ew().getHostName());
            bundle.putString("swanNativeVersion", com.baidu.swan.apps.c.getVersion());
            if (!TextUtils.isEmpty(jSONObject2.optString(Headers.LOCATION))) {
                bundle.putString(Headers.LOCATION, jSONObject2.optString(Headers.LOCATION));
            }
            if (!TextUtils.isEmpty(jSONObject2.optString("phone"))) {
                bundle.putString("phone", jSONObject2.optString("phone"));
            }
            if (!TextUtils.isEmpty(jSONObject2.optString("userId"))) {
                bundle.putString("userId", jSONObject2.optString("userId"));
            }
            if (!TextUtils.isEmpty(jSONObject2.optString("isSplit"))) {
                bundle.putString("isSplit", jSONObject2.optString("isSplit"));
            }
            if (!TextUtils.isEmpty(jSONObject2.optString("goodsInfo"))) {
                bundle.putString("goodsInfo", jSONObject2.optString("goodsInfo"));
            }
            if (!TextUtils.isEmpty(jSONObject2.optString("signFieldsRange"))) {
                bundle.putString("signFieldsRange", jSONObject2.optString("signFieldsRange"));
            }
            if (strArr != null) {
                String[] strArr2 = new String[strArr.length];
                for (int i = 0; i < strArr.length; i++) {
                    String str2 = strArr[i];
                    char c = 65535;
                    switch (str2.hashCode()) {
                        case -1708856474:
                            if (str2.equals("WeChat")) {
                                c = 1;
                                break;
                            }
                            break;
                        case 1865715419:
                            if (str2.equals("BDWallet")) {
                                c = 2;
                                break;
                            }
                            break;
                        case 1963873898:
                            if (str2.equals("Alipay")) {
                                c = 0;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            strArr2[i] = PayChannel.ALIPAY;
                            break;
                        case 1:
                            strArr2[i] = PayChannel.WECHAT;
                            break;
                        case 2:
                            strArr2[i] = PayChannel.BAIFUBAO;
                            break;
                    }
                }
                bundle.putStringArray("blockedPayChannels", strArr2);
            }
            J(this.aFI.getActivity()).a(bundle, new a.c() { // from class: com.baidu.swan.apps.aa.a.4
                @Override // com.baidu.poly.a.c
                public void onResult(int i2, String str3) {
                    if (a.DEBUG) {
                        Log.d(a.TAG, "statusCode: " + i2 + " payDesc: " + str3);
                    }
                    if (i2 == 0) {
                        try {
                            if (TextUtils.isEmpty(str3)) {
                                a.this.c(6, "nuomi", str3);
                                a.this.mStatusCode = 6;
                                a.this.aFJ = null;
                            } else {
                                int optInt = new JSONObject(str3).optInt("statusCode");
                                a.this.mStatusCode = optInt;
                                a.this.aFJ = str3;
                                a.this.c(optInt, "nuomi", str3);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            a.this.mStatusCode = 6;
                            a.this.aFJ = null;
                            a.this.c(6, "nuomi", str3);
                        }
                        a.this.fR(null);
                    }
                }

                @Override // com.baidu.poly.a.c
                public void onFail(String str3) {
                }

                @Override // com.baidu.poly.a.c
                public void onCancel(String str3) {
                    a.this.mStatusCode = 2;
                    a.this.aFJ = str3;
                    a.this.c(2, "nuomi", str3);
                    a.this.fR(null);
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UnitedSchemeUtility.callCallback(this.aAo, this.aAn, UnitedSchemeUtility.wrapCallbackParams(0));
        if (this.aFI.DA() != null && this.aFI.vL() != null) {
            String valueOf = String.valueOf(this.aFI.vL().FQ());
            String valueOf2 = String.valueOf(UnitedSchemeUtility.getParams(this.aFI.vL().FH()).get("_baiduboxapp"));
            Bundle bundle2 = new Bundle();
            bundle2.putString("frameType", valueOf);
            bundle2.putString("appId", this.aFI.vL().getAppId());
            try {
                bundle2.putString("params", URLEncoder.encode(valueOf2, HTTP.UTF_8));
            } catch (UnsupportedEncodingException e2) {
                if (DEBUG) {
                    throw new RuntimeException("This method requires UTF-8 encoding support", e2);
                }
            }
            this.aFI.DA().e(7, bundle2);
        }
    }

    private static com.baidu.poly.a J(Activity activity) {
        if (aFH != null) {
            return aFH;
        }
        aFH = new a.C0085a().a(new com.baidu.poly.d.b.a(activity)).bD(getChannel()).az(activity);
        return aFH;
    }

    private static int getChannel() {
        if (DEBUG) {
            return com.baidu.swan.apps.ac.a.a.Jg() ? a.b.agY : a.b.agX;
        }
        return a.b.agX;
    }

    @Nullable
    private static com.baidu.poly.a Ih() {
        return aFH;
    }

    public boolean Ii() {
        com.baidu.swan.apps.console.c.d(TAG, "start UnitedSchemeWalletDispatcher ACTION_REQUEST_WECHAT_PAYMENT");
        if (d.Il().a(this.aFI, this.aAo, this.aAn)) {
            if (TextUtils.equals(this.mVersion, "2.0")) {
                this.mStatusCode = 0;
                this.aFJ = null;
                com.baidu.swan.apps.u.a.EN().a(this.mAppKey, this);
            }
            UnitedSchemeUtility.callCallback(this.aAo, this.aAn, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
        this.aAn.result = UnitedSchemeUtility.wrapCallbackParams(1001);
        e.hs("wechatH5Action");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i, String str, String str2) {
        com.baidu.swan.apps.v.b.b vL = this.aFI.vL();
        e.a(i == 0, str, str2, vL != null ? vL.FQ() : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fR(String str) {
        String str2;
        com.baidu.swan.apps.console.c.d(TAG, "sendSecondCallback, statusCode: " + this.mStatusCode + ", params: " + this.aFJ);
        String str3 = this.aAn.getParams().get("params");
        if (!TextUtils.isEmpty(str3)) {
            try {
                str2 = new JSONObject(str3).optString("cb");
                try {
                    if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(this.aFJ)) {
                        String optString = new JSONObject(this.aFJ).optString("responseData");
                        if (TextUtils.equals(this.mVersion, "2.0")) {
                            JSONObject jSONObject = new JSONObject();
                            if (!TextUtils.isEmpty(str)) {
                                jSONObject.put("payId", str);
                            }
                            if (!TextUtils.isEmpty(this.aFJ)) {
                                jSONObject.put("payResult", Base64.encodeToString(optString.getBytes(HTTP.UTF_8), 2));
                            }
                            this.aAo.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(jSONObject, this.mStatusCode, cP(this.mStatusCode)).toString());
                            return;
                        }
                        this.aAo.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParamsWithBase64(optString, this.mStatusCode, cP(this.mStatusCode)).toString());
                        return;
                    }
                    this.aAo.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, this.mStatusCode, cP(this.mStatusCode)).toString());
                } catch (UnsupportedEncodingException e) {
                    e = e;
                    e.printStackTrace();
                    this.aAo.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, this.mStatusCode, cP(this.mStatusCode)).toString());
                } catch (JSONException e2) {
                    e = e2;
                    e.printStackTrace();
                    this.aAo.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, this.mStatusCode, cP(this.mStatusCode)).toString());
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

    public static boolean Ij() {
        com.baidu.poly.a Ih = Ih();
        return Ih != null && Ih.uE();
    }

    private static String cP(int i) {
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
        fR(null);
    }
}
