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
    protected final String aRL;
    protected final Activity mActivity;
    protected final String mScope;

    public f(Activity activity, String str, String str2) {
        this.mActivity = activity;
        this.mScope = str;
        this.aRL = str2;
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean Cd() {
        JSONObject jSONObject = new JSONObject();
        try {
            com.baidu.swan.apps.ae.b Jl = Jl();
            jSONObject.put("ma_id", Jl.id);
            jSONObject.put("scope", this.mScope);
            jSONObject.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            jSONObject.put("app_key", Jl.getAppKey());
            if (!TextUtils.equals("0", this.aRL)) {
                jSONObject.put("action_type", this.aRL);
            }
            String vC = com.baidu.swan.apps.u.a.CI().vC();
            if (!TextUtils.isEmpty(vC)) {
                jSONObject.put("host_api_key", vC);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        ay("data", jSONObject.toString());
        return true;
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.g
    protected Request a(g gVar) {
        return com.baidu.swan.apps.u.a.CI().i(this.mActivity, gVar.Kj());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    /* renamed from: ag */
    public JSONObject C(JSONObject jSONObject) throws JSONException {
        JSONObject ae = com.baidu.swan.apps.setting.oauth.c.ae(jSONObject);
        int optInt = ae.optInt("errno", SapiGIDEvent.SYSTEM_NETWORK_CHANGE_TO_AVALIABLE);
        if (optInt != 0) {
            throw new JSONException("Illegal errno=" + optInt + " errms=" + ae.optString("errms"));
        }
        return ae;
    }
}
