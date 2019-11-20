package com.baidu.swan.apps.setting.oauth.a;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import okhttp3.Request;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f extends g<JSONObject> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected final String bou;
    protected final Activity mActivity;
    protected final String mScope;

    public f(Activity activity, String str, String str2) {
        this.mActivity = activity;
        this.mScope = str;
        this.bou = str2;
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean IN() {
        JSONObject jSONObject = new JSONObject();
        try {
            com.baidu.swan.apps.ae.b Rs = Rs();
            jSONObject.put("ma_id", Rs.id);
            jSONObject.put("scope", this.mScope);
            jSONObject.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            jSONObject.put("app_key", Rs.getAppKey());
            if (!TextUtils.equals("0", this.bou)) {
                jSONObject.put("action_type", this.bou);
            }
            String BR = com.baidu.swan.apps.u.a.Jv().BR();
            if (!TextUtils.isEmpty(BR)) {
                jSONObject.put("host_api_key", BR);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        aI("data", jSONObject.toString());
        return true;
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.g
    protected Request a(g gVar) {
        return com.baidu.swan.apps.u.a.Jv().i(this.mActivity, gVar.Su());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    /* renamed from: aG */
    public JSONObject Y(JSONObject jSONObject) throws JSONException {
        JSONObject aE = com.baidu.swan.apps.setting.oauth.c.aE(jSONObject);
        int optInt = aE.optInt("errno", 11001);
        if (optInt != 0) {
            if (11001 == optInt) {
                com.baidu.swan.apps.setting.oauth.c.aD(aE);
                com.baidu.swan.apps.setting.oauth.c.aH("MaOpenDataRequest", aE.toString());
            }
            throw new JSONException("Illegal errno=" + optInt + " errms=" + aE.optString("errms"));
        }
        return aE;
    }
}
