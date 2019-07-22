package com.baidu.swan.apps.setting.oauth.a;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.sapi2.utils.SapiGIDEvent;
import com.baidu.searchbox.common.runtime.AppRuntime;
import okhttp3.Request;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f extends g<JSONObject> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected final String aVk;
    protected final Activity mActivity;
    protected final String mScope;

    public f(Activity activity, String str, String str2) {
        this.mActivity = activity;
        this.mScope = str;
        this.aVk = str2;
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean DO() {
        JSONObject jSONObject = new JSONObject();
        try {
            com.baidu.swan.apps.ae.b Mu = Mu();
            jSONObject.put("ma_id", Mu.id);
            jSONObject.put("scope", this.mScope);
            jSONObject.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            jSONObject.put("app_key", Mu.getAppKey());
            if (!TextUtils.equals("0", this.aVk)) {
                jSONObject.put("action_type", this.aVk);
            }
            String wS = com.baidu.swan.apps.u.a.Ew().wS();
            if (!TextUtils.isEmpty(wS)) {
                jSONObject.put("host_api_key", wS);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        aA("data", jSONObject.toString());
        return true;
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.g
    protected Request a(g gVar) {
        return com.baidu.swan.apps.u.a.Ew().i(this.mActivity, gVar.Ny());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    /* renamed from: ah */
    public JSONObject z(JSONObject jSONObject) throws JSONException {
        JSONObject af = com.baidu.swan.apps.setting.oauth.c.af(jSONObject);
        int optInt = af.optInt("errno", SapiGIDEvent.SYSTEM_NETWORK_CHANGE_TO_AVALIABLE);
        if (optInt != 0) {
            if (11001 == optInt) {
                com.baidu.swan.apps.setting.oauth.c.ae(af);
                com.baidu.swan.apps.setting.oauth.c.az("MaOpenDataRequest", af.toString());
            }
            throw new JSONException("Illegal errno=" + optInt + " errms=" + af.optString("errms"));
        }
        return af;
    }
}
