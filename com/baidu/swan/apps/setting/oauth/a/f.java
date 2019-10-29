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
    protected final String boM;
    protected final Activity mActivity;
    protected final String mScope;

    public f(Activity activity, String str, String str2) {
        this.mActivity = activity;
        this.mScope = str;
        this.boM = str2;
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean IM() {
        JSONObject jSONObject = new JSONObject();
        try {
            com.baidu.swan.apps.ae.b Rq = Rq();
            jSONObject.put("ma_id", Rq.id);
            jSONObject.put("scope", this.mScope);
            jSONObject.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            jSONObject.put("app_key", Rq.getAppKey());
            if (!TextUtils.equals("0", this.boM)) {
                jSONObject.put("action_type", this.boM);
            }
            String BQ = com.baidu.swan.apps.u.a.Ju().BQ();
            if (!TextUtils.isEmpty(BQ)) {
                jSONObject.put("host_api_key", BQ);
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
        return com.baidu.swan.apps.u.a.Ju().i(this.mActivity, gVar.Ss());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    /* renamed from: aF */
    public JSONObject X(JSONObject jSONObject) throws JSONException {
        JSONObject aD = com.baidu.swan.apps.setting.oauth.c.aD(jSONObject);
        int optInt = aD.optInt("errno", 11001);
        if (optInt != 0) {
            if (11001 == optInt) {
                com.baidu.swan.apps.setting.oauth.c.aC(aD);
                com.baidu.swan.apps.setting.oauth.c.aH("MaOpenDataRequest", aD.toString());
            }
            throw new JSONException("Illegal errno=" + optInt + " errms=" + aD.optString("errms"));
        }
        return aD;
    }
}
