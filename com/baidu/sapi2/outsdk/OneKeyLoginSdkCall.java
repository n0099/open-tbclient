package com.baidu.sapi2.outsdk;

import android.text.TextUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.sapi2.utils.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class OneKeyLoginSdkCall {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5285a = "OneKeyLogin";

    /* renamed from: b  reason: collision with root package name */
    private static final int f5286b = 1;
    private static final int c = 2;
    private static final int d = 3;
    static final String e = "CM";
    static final String f = "CU";
    static final String g = "CT";
    private static final String h = "0";
    private static final String i = "1";
    private static final String j = "3";
    public static final String k = "login";
    public static final String l = "init";
    public static final String m = "sapi";
    public static final String n = "product";
    static String o;
    static String p;
    static String q;
    static String r;
    static String s;

    /* loaded from: classes3.dex */
    public interface TokenListener extends NoProguard {
        void onGetTokenComplete(JSONObject jSONObject);
    }

    private boolean c(SapiConfiguration sapiConfiguration) {
        return (TextUtils.isEmpty(sapiConfiguration.chinaUnicomAppKey) || TextUtils.isEmpty(sapiConfiguration.chinaUnicomAppPublicKey) || !SapiContext.getInstance().isMeetOneKeyLoginGray(2)) ? false : true;
    }

    public void a(SapiConfiguration sapiConfiguration, String str) {
        a(sapiConfiguration, str, 0, null);
    }

    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (a()) {
                if (!TextUtils.isEmpty(o)) {
                    jSONObject.put("phone", o);
                    jSONObject.put("operator", e);
                } else if (!TextUtils.isEmpty(p)) {
                    jSONObject.put("phone", p);
                    jSONObject.put("operator", g);
                } else {
                    jSONObject.put("phone", r);
                    jSONObject.put("operator", f);
                    jSONObject.put("CUVersion", "2");
                }
            }
        } catch (JSONException e2) {
            Log.e(e2);
        }
        return jSONObject;
    }

    public void a(SapiConfiguration sapiConfiguration, String str, int i2, OneKeyLoginCallback oneKeyLoginCallback) {
        JSONObject jSONObject;
        if (SapiAccountManager.getInstance().isLogin()) {
            Log.i(f5285a, "is login");
            b(oneKeyLoginCallback, -110, null);
            return;
        }
        if ((TextUtils.isEmpty(sapiConfiguration.chinaMobileAppID) || TextUtils.isEmpty(sapiConfiguration.chinaMobileAppKey)) ? false : true) {
            try {
                jSONObject = com.cmic.sso.sdk.b.a.by(sapiConfiguration.context, "rsa2048").id(sapiConfiguration.context);
            } catch (Throwable th) {
                Log.e(f5285a, th);
                jSONObject = null;
            }
            if (jSONObject == null) {
                b(oneKeyLoginCallback, -100, null);
                return;
            }
            int optInt = jSONObject.optInt("operatortype");
            String optString = jSONObject.optString("networktype");
            Log.i(f5285a, "operatorType = " + optInt + " netType = " + optString);
            if (TextUtils.isEmpty(optString)) {
                optString = "0";
            }
            if (optInt == 1) {
                if (!"0".equals(optString) && a(sapiConfiguration)) {
                    new ChinaMobileSdkWrap().a(sapiConfiguration, str, optString, i2, oneKeyLoginCallback);
                } else {
                    b(oneKeyLoginCallback, -101, null);
                }
            } else if (optInt == 2) {
                if (("1".equals(optString) || "3".equals(optString)) && c(sapiConfiguration)) {
                    new ChinaUnicomSdkWrap().a(sapiConfiguration, str, optString, i2, oneKeyLoginCallback);
                } else {
                    b(oneKeyLoginCallback, -101, null);
                }
            } else if (optInt != 3) {
                b(oneKeyLoginCallback, -100, null);
            } else if (("1".equals(optString) || "3".equals(optString)) && b(sapiConfiguration)) {
                new ChinaTelecomSdkWrap().a(sapiConfiguration, str, optString, i2, oneKeyLoginCallback);
            } else {
                b(oneKeyLoginCallback, -101, null);
            }
        } else if (b(sapiConfiguration)) {
            new ChinaTelecomSdkWrap().a(sapiConfiguration, str, "0", i2, oneKeyLoginCallback);
        } else if (c(sapiConfiguration)) {
            new ChinaUnicomSdkWrap().a(sapiConfiguration, str, "0", i2, oneKeyLoginCallback);
        } else {
            b(oneKeyLoginCallback, -101, null);
        }
    }

    public String c() {
        if (a()) {
            return !TextUtils.isEmpty(o) ? e : !TextUtils.isEmpty(p) ? g : f;
        }
        return null;
    }

    public void b(SapiConfiguration sapiConfiguration, TokenListener tokenListener) {
        if (!TextUtils.isEmpty(o)) {
            new ChinaMobileSdkWrap().b(sapiConfiguration, tokenListener);
        } else if (!TextUtils.isEmpty(q)) {
            new ChinaTelecomSdkWrap().a(sapiConfiguration, tokenListener);
        } else if (!TextUtils.isEmpty(s)) {
            new ChinaUnicomSdkWrap().a(sapiConfiguration, tokenListener);
        } else {
            tokenListener.onGetTokenComplete(new JSONObject());
        }
    }

    private boolean b(SapiConfiguration sapiConfiguration) {
        return (TextUtils.isEmpty(sapiConfiguration.chinaTelecomAppKey) || TextUtils.isEmpty(sapiConfiguration.chinaTelecomAppSecret) || !SapiContext.getInstance().isMeetOneKeyLoginGray(3)) ? false : true;
    }

    public void b(OneKeyLoginCallback oneKeyLoginCallback, int i2, String str) {
        if (oneKeyLoginCallback != null) {
            OneKeyLoginResult oneKeyLoginResult = new OneKeyLoginResult();
            oneKeyLoginResult.setResultCode(i2);
            oneKeyLoginResult.setResultMsg(str);
            oneKeyLoginCallback.unAvailable(oneKeyLoginResult);
        }
    }

    public void a(SapiConfiguration sapiConfiguration, TokenListener tokenListener) {
        JSONObject jSONObject;
        if (!TextUtils.isEmpty(o)) {
            new ChinaMobileSdkWrap().a(sapiConfiguration, tokenListener);
        } else if (!TextUtils.isEmpty(s)) {
            new ChinaUnicomSdkWrap().a(sapiConfiguration, null, tokenListener);
        } else {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(BaseJsonData.TAG_ERRNO, "-1");
                jSONObject = com.cmic.sso.sdk.b.a.by(sapiConfiguration.context, "rsa2048").id(sapiConfiguration.context);
            } catch (Throwable th) {
                Log.e(f5285a, th);
                jSONObject = null;
            }
            if (jSONObject == null) {
                tokenListener.onGetTokenComplete(jSONObject2);
                return;
            }
            int optInt = jSONObject.optInt("operatortype");
            String optString = jSONObject.optString("networktype");
            Log.i(f5285a, "operatorType = " + optInt + " netType = " + optString);
            if (TextUtils.isEmpty(optString)) {
                optString = "0";
            }
            if (optInt != 1) {
                if (optInt == 2 && (("1".equals(optString) || "3".equals(optString)) && c(sapiConfiguration))) {
                    new ChinaUnicomSdkWrap().a(sapiConfiguration, optString, tokenListener);
                    return;
                }
            } else if (!"0".equals(optString) && a(sapiConfiguration)) {
                new ChinaMobileSdkWrap().a(sapiConfiguration, tokenListener);
                return;
            }
            tokenListener.onGetTokenComplete(jSONObject2);
        }
    }

    private boolean a(SapiConfiguration sapiConfiguration) {
        return (TextUtils.isEmpty(sapiConfiguration.chinaMobileAppID) || TextUtils.isEmpty(sapiConfiguration.chinaMobileAppKey) || !SapiContext.getInstance().isMeetOneKeyLoginGray(1)) ? false : true;
    }

    public boolean a() {
        return (TextUtils.isEmpty(p) && TextUtils.isEmpty(o) && TextUtils.isEmpty(r)) ? false : true;
    }

    public void a(OneKeyLoginCallback oneKeyLoginCallback, int i2, String str) {
        if (oneKeyLoginCallback != null) {
            OneKeyLoginResult oneKeyLoginResult = new OneKeyLoginResult();
            oneKeyLoginResult.setResultCode(i2);
            oneKeyLoginResult.setResultMsg(str);
            oneKeyLoginCallback.onFail(oneKeyLoginResult);
        }
    }
}
