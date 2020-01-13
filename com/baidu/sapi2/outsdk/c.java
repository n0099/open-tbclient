package com.baidu.sapi2.outsdk;

import android.text.TextUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.utils.Log;
import com.cmic.sso.sdk.auth.AuthnHelper;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c {
    public static final String a = "OneKeyLogin";
    private static final int b = 1;
    private static final int c = 2;
    private static final int d = 3;
    static final String e = "CM";
    static final String f = "CU";
    static final String g = "CT";
    static final String h = "0";
    static String i;
    static String j;
    static String k;
    static String l;
    static String m;

    /* loaded from: classes5.dex */
    public interface a {
        void onGetTokenComplete(JSONObject jSONObject);
    }

    private boolean c(SapiConfiguration sapiConfiguration) {
        return (TextUtils.isEmpty(sapiConfiguration.chinaTelecomAppKey) || TextUtils.isEmpty(sapiConfiguration.chinaTelecomAppSecret) || !SapiContext.getInstance(sapiConfiguration.context).isMeetOneKeyLoginGray(3)) ? false : true;
    }

    private boolean d(SapiConfiguration sapiConfiguration) {
        return (TextUtils.isEmpty(sapiConfiguration.chinaUnicomAppKey) || TextUtils.isEmpty(sapiConfiguration.chinaUnicomAppPublicKey) || !SapiContext.getInstance(sapiConfiguration.context).isMeetOneKeyLoginGray(2)) ? false : true;
    }

    public void a(SapiConfiguration sapiConfiguration) {
        if (!SapiAccountManager.getInstance().isLogin()) {
            if ((TextUtils.isEmpty(sapiConfiguration.chinaMobileAppID) || TextUtils.isEmpty(sapiConfiguration.chinaMobileAppKey)) ? false : true) {
                JSONObject networkType = AuthnHelper.getInstance(sapiConfiguration.context, "rsa2048").getNetworkType(sapiConfiguration.context);
                if (networkType != null) {
                    int optInt = networkType.optInt("operatortype");
                    String optString = networkType.optString("networktype");
                    Log.i(a, "operatorType = " + optInt + " netType = " + optString);
                    if ("0".equals(optString)) {
                        return;
                    }
                    if (optInt == 1) {
                        if (b(sapiConfiguration)) {
                            new com.baidu.sapi2.outsdk.a().a(sapiConfiguration);
                            return;
                        }
                        return;
                    } else if (optInt != 2) {
                        if (optInt == 3 && c(sapiConfiguration)) {
                            new ChinaTelecomSdkWrap().a(sapiConfiguration);
                            return;
                        }
                        return;
                    } else if (d(sapiConfiguration)) {
                        new b().a(sapiConfiguration);
                        return;
                    } else {
                        return;
                    }
                }
                return;
            } else if (c(sapiConfiguration)) {
                new ChinaTelecomSdkWrap().a(sapiConfiguration);
                return;
            } else if (d(sapiConfiguration)) {
                new b().a(sapiConfiguration);
                return;
            } else {
                return;
            }
        }
        Log.i(a, "is login");
    }

    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (a()) {
                if (!TextUtils.isEmpty(i)) {
                    jSONObject.put("phone", i);
                    jSONObject.put("operator", e);
                } else if (!TextUtils.isEmpty(j)) {
                    jSONObject.put("phone", j);
                    jSONObject.put("operator", g);
                } else {
                    jSONObject.put("phone", l);
                    jSONObject.put("operator", f);
                }
            }
        } catch (JSONException e2) {
            Log.e(e2);
        }
        return jSONObject;
    }

    private boolean b(SapiConfiguration sapiConfiguration) {
        return (TextUtils.isEmpty(sapiConfiguration.chinaMobileAppID) || TextUtils.isEmpty(sapiConfiguration.chinaMobileAppKey) || !SapiContext.getInstance(sapiConfiguration.context).isMeetOneKeyLoginGray(1)) ? false : true;
    }

    public void a(SapiConfiguration sapiConfiguration, a aVar) {
        if (!TextUtils.isEmpty(i)) {
            new com.baidu.sapi2.outsdk.a().a(sapiConfiguration, aVar);
        } else if (!TextUtils.isEmpty(k)) {
            new ChinaTelecomSdkWrap().a(sapiConfiguration, aVar);
        } else if (!TextUtils.isEmpty(m)) {
            new b().a(sapiConfiguration, aVar);
        } else {
            aVar.onGetTokenComplete(new JSONObject());
        }
    }

    public boolean a() {
        return (TextUtils.isEmpty(j) && TextUtils.isEmpty(i) && TextUtils.isEmpty(l)) ? false : true;
    }
}
