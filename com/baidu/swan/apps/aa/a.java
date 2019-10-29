package com.baidu.swan.apps.aa;

import android.app.Activity;
import android.net.http.Headers;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.poly.a;
import com.baidu.poly.bean.PayChannel;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.statistic.e;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
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
    private static com.baidu.poly.a aZu = null;
    private UnitedSchemeEntity aTZ;
    private CallbackHandler aUa;
    private com.baidu.swan.apps.ae.b aZv;
    private String aZw;
    private String mAppKey;
    private int mStatusCode;
    private String mVersion;

    public a(com.baidu.swan.apps.ae.b bVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, String str2) {
        this.aZv = bVar;
        this.aTZ = unitedSchemeEntity;
        this.aUa = callbackHandler;
        this.mVersion = str;
        this.mAppKey = str2;
    }

    public boolean gw(String str) {
        if (TextUtils.isEmpty(str)) {
            this.aTZ.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        com.baidu.swan.apps.u.a.Jy().a(this.aZv, str, new com.baidu.swan.apps.aa.a.b() { // from class: com.baidu.swan.apps.aa.a.1
            @Override // com.baidu.swan.apps.aa.a.b
            public void n(int i, String str2) {
                a.this.mStatusCode = i;
                a.this.aZw = str2;
                if (a.DEBUG) {
                    Log.d(a.TAG, "statusCode: " + i + " ,result:" + str2);
                }
                a.this.d(i, "baiduqianbao", str2);
                if (i != 0 || !TextUtils.equals(a.this.mVersion, "2.0")) {
                    a.this.gy(null);
                } else {
                    com.baidu.swan.apps.u.a.JL().a(a.this.mAppKey, a.this);
                }
            }
        });
        UnitedSchemeUtility.callCallback(this.aUa, this.aTZ, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }

    public boolean gx(String str) {
        com.baidu.swan.apps.console.c.d(TAG, "start UnitedSchemeWalletDispatcher ACTION_REQUEST_ALI_PAYMENT");
        if (TextUtils.isEmpty(str)) {
            this.aTZ.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        com.baidu.swan.apps.u.a.Jy().a(this.aZv, str, new com.baidu.swan.apps.aa.a.a() { // from class: com.baidu.swan.apps.aa.a.2
            @Override // com.baidu.swan.apps.aa.a.a
            public void m(int i, String str2) {
                a.this.mStatusCode = i;
                a.this.aZw = str2;
                if (a.DEBUG) {
                    Log.d(a.TAG, "statusCode: " + a.this.mStatusCode + " ,result:" + a.this.aZw);
                }
                a.this.d(i, "alipay", str2);
                if (i != 0 || !TextUtils.equals(a.this.mVersion, "2.0")) {
                    a.this.gy(null);
                } else {
                    com.baidu.swan.apps.u.a.JL().a(a.this.mAppKey, a.this);
                }
            }
        });
        UnitedSchemeUtility.callCallback(this.aUa, this.aTZ, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }

    public boolean g(final String str, JSONObject jSONObject) {
        final String[] strArr;
        if (TextUtils.isEmpty(str)) {
            this.aTZ.result = UnitedSchemeUtility.wrapCallbackParams(1001);
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
        this.aZv.Re().a(this.aZv.getActivity(), null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.aa.a.3
            @Override // com.baidu.swan.apps.a.a
            public void onResult(int i2) {
                if (i2 == 0) {
                    a.this.d(str, strArr);
                    return;
                }
                a.this.mStatusCode = 5;
                a.this.aZw = null;
                a.this.gy(null);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str, String[] strArr) {
        JSONObject jSONObject;
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            Bundle bundle = new Bundle();
            String bf = com.baidu.swan.apps.u.a.Jn().bf(com.baidu.swan.apps.u.a.Ji());
            if (com.baidu.swan.apps.u.a.Jn().bd(com.baidu.swan.apps.u.a.Ji())) {
                bundle.putString("bduss", com.baidu.swan.apps.u.a.Jn().bg(com.baidu.swan.apps.u.a.Ji()));
            }
            bundle.putString("cuid", bf);
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
            if (this.aZv.AJ() != null) {
                jSONObject.put("swanFrom", this.aZv.AJ().KE());
            }
            jSONObject.put("cuid", bf);
            jSONObject.put("appId", com.baidu.swan.apps.ae.b.Rk());
            bundle.putString("bizInfo", jSONObject.toString());
            bundle.putString(ConstantsAPI.Token.WX_TOKEN_PLATFORMID_KEY, "100003");
            bundle.putString("nativeAppId", com.baidu.swan.apps.u.a.Ju().getHostName());
            bundle.putString("swanNativeVersion", com.baidu.swan.apps.c.getVersion());
            if (!TextUtils.isEmpty(jSONObject2.optString(Headers.LOCATION))) {
                bundle.putString(Headers.LOCATION, jSONObject2.optString(Headers.LOCATION));
            }
            if (!TextUtils.isEmpty(jSONObject2.optString("phone"))) {
                bundle.putString("phone", jSONObject2.optString("phone"));
            }
            if (!TextUtils.isEmpty(jSONObject2.optString(TbEnum.SystemMessage.KEY_USER_ID))) {
                bundle.putString(TbEnum.SystemMessage.KEY_USER_ID, jSONObject2.optString(TbEnum.SystemMessage.KEY_USER_ID));
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
            I(this.aZv.getActivity()).a(bundle, new a.c() { // from class: com.baidu.swan.apps.aa.a.4
                @Override // com.baidu.poly.a.c
                public void onResult(int i2, String str3) {
                    if (a.DEBUG) {
                        Log.d(a.TAG, "statusCode: " + i2 + " payDesc: " + str3);
                    }
                    if (i2 == 0) {
                        try {
                            if (TextUtils.isEmpty(str3)) {
                                a.this.d(6, "nuomi", str3);
                                a.this.mStatusCode = 6;
                                a.this.aZw = null;
                            } else {
                                int optInt = new JSONObject(str3).optInt("statusCode");
                                a.this.mStatusCode = optInt;
                                a.this.aZw = str3;
                                a.this.d(optInt, "nuomi", str3);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            a.this.mStatusCode = 6;
                            a.this.aZw = null;
                            a.this.d(6, "nuomi", str3);
                        }
                        a.this.gy(null);
                    }
                }

                @Override // com.baidu.poly.a.c
                public void onFail(String str3) {
                }

                @Override // com.baidu.poly.a.c
                public void onCancel(String str3) {
                    a.this.mStatusCode = 2;
                    a.this.aZw = str3;
                    a.this.d(2, "nuomi", str3);
                    a.this.gy(null);
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UnitedSchemeUtility.callCallback(this.aUa, this.aTZ, UnitedSchemeUtility.wrapCallbackParams(0));
        if (this.aZv.Iy() != null && this.aZv.AJ() != null) {
            String valueOf = String.valueOf(this.aZv.AJ().KO());
            String valueOf2 = String.valueOf(UnitedSchemeUtility.getParams(this.aZv.AJ().KF()).get("_baiduboxapp"));
            Bundle bundle2 = new Bundle();
            bundle2.putString("frameType", valueOf);
            bundle2.putString("appId", this.aZv.AJ().getAppId());
            try {
                bundle2.putString("params", URLEncoder.encode(valueOf2, HTTP.UTF_8));
            } catch (UnsupportedEncodingException e2) {
                if (DEBUG) {
                    throw new RuntimeException("This method requires UTF-8 encoding support", e2);
                }
            }
            this.aZv.Iy().e(7, bundle2);
        }
    }

    private static com.baidu.poly.a I(Activity activity) {
        if (aZu != null) {
            return aZu;
        }
        aZu = new a.C0126a().a(new com.baidu.poly.d.b.a(activity)).cA(getChannel()).aD(activity);
        return aZu;
    }

    private static int getChannel() {
        if (DEBUG) {
            return com.baidu.swan.apps.ac.a.a.Oe() ? a.b.aAS : a.b.aAR;
        }
        return a.b.aAR;
    }

    @Nullable
    private static com.baidu.poly.a Nf() {
        return aZu;
    }

    public boolean Ng() {
        com.baidu.swan.apps.console.c.d(TAG, "start UnitedSchemeWalletDispatcher ACTION_REQUEST_WECHAT_PAYMENT");
        if (d.Nj().a(this.aZv, this.aUa, this.aTZ)) {
            if (TextUtils.equals(this.mVersion, "2.0")) {
                this.mStatusCode = 0;
                this.aZw = null;
                com.baidu.swan.apps.u.a.JL().a(this.mAppKey, this);
            }
            UnitedSchemeUtility.callCallback(this.aUa, this.aTZ, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
        this.aTZ.result = UnitedSchemeUtility.wrapCallbackParams(1001);
        e.hX("wechatH5Action");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i, String str, String str2) {
        com.baidu.swan.apps.v.b.b AJ = this.aZv.AJ();
        e.a(i == 0, str, str2, AJ != null ? AJ.KO() : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gy(String str) {
        String str2;
        com.baidu.swan.apps.console.c.d(TAG, "sendSecondCallback, statusCode: " + this.mStatusCode + ", params: " + this.aZw);
        String str3 = this.aTZ.getParams().get("params");
        if (!TextUtils.isEmpty(str3)) {
            try {
                str2 = new JSONObject(str3).optString("cb");
                try {
                    if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(this.aZw)) {
                        String optString = new JSONObject(this.aZw).optString("responseData");
                        if (TextUtils.equals(this.mVersion, "2.0")) {
                            JSONObject jSONObject = new JSONObject();
                            if (!TextUtils.isEmpty(str)) {
                                jSONObject.put("payId", str);
                            }
                            if (!TextUtils.isEmpty(this.aZw)) {
                                jSONObject.put("payResult", Base64.encodeToString(optString.getBytes(HTTP.UTF_8), 2));
                            }
                            this.aUa.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(jSONObject, this.mStatusCode, dL(this.mStatusCode)).toString());
                            return;
                        }
                        this.aUa.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParamsWithBase64(optString, this.mStatusCode, dL(this.mStatusCode)).toString());
                        return;
                    }
                    this.aUa.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, this.mStatusCode, dL(this.mStatusCode)).toString());
                } catch (UnsupportedEncodingException e) {
                    e = e;
                    e.printStackTrace();
                    this.aUa.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, this.mStatusCode, dL(this.mStatusCode)).toString());
                } catch (JSONException e2) {
                    e = e2;
                    e.printStackTrace();
                    this.aUa.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, this.mStatusCode, dL(this.mStatusCode)).toString());
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

    public static boolean Nh() {
        com.baidu.poly.a Nf = Nf();
        return Nf != null && Nf.zC();
    }

    private static String dL(int i) {
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
        gy(null);
    }
}
