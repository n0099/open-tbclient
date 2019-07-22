package com.baidu.swan.apps.setting.oauth.a;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.sapi2.utils.SapiGIDEvent;
import com.baidu.searchbox.common.runtime.AppRuntime;
import okhttp3.Request;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends g<C0175a> {
    protected final boolean aUV;
    protected final Activity mActivity;
    protected final String mScope;

    public a(Activity activity, boolean z, String str) {
        this.mActivity = activity;
        this.mScope = str;
        this.aUV = z;
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean DO() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", Mu().id);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app_key", Mu().getAppKey());
            jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject2.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            String wS = com.baidu.swan.apps.u.a.Ew().wS();
            if (!TextUtils.isEmpty(wS)) {
                jSONObject2.put("host_api_key", wS);
            }
            jSONObject.put("open", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("permit", Boolean.toString(this.aUV));
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put(this.mScope, jSONObject3);
            jSONObject.put("accredits", jSONObject4);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        aA("data", jSONObject.toString());
        return true;
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.g
    protected Request a(g gVar) {
        return com.baidu.swan.apps.u.a.Ew().e(this.mActivity, gVar.Ny());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    /* renamed from: y */
    public C0175a z(JSONObject jSONObject) throws JSONException {
        String str;
        JSONObject jSONObject2;
        JSONObject af = com.baidu.swan.apps.setting.oauth.c.af(jSONObject);
        int optInt = af.optInt("errno", SapiGIDEvent.SYSTEM_NETWORK_CHANGE_TO_AVALIABLE);
        if (optInt != 0) {
            if (11001 == optInt) {
                com.baidu.swan.apps.setting.oauth.c.ae(af);
                com.baidu.swan.apps.setting.oauth.c.az("Accredit", af.toString());
            }
            throw new JSONException("Illegal errno=" + optInt + " errms=" + af.optString("errms"));
        }
        JSONObject jSONObject3 = af.getJSONObject("data");
        if (jSONObject3 == null) {
            str = "";
            jSONObject2 = null;
        } else {
            str = jSONObject3.optString("code", "");
            jSONObject2 = jSONObject3.optJSONObject("opendata");
        }
        return new C0175a(this.aUV, str, jSONObject2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.a.g
    public void DP() {
        super.DP();
        com.baidu.swan.apps.network.c.b.a.Ib();
    }

    /* renamed from: com.baidu.swan.apps.setting.oauth.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0175a {
        public final boolean aUW;
        public final JSONObject aUX;
        public final String code;

        private C0175a(boolean z, String str, JSONObject jSONObject) {
            this.code = str == null ? "" : str;
            this.aUW = z;
            this.aUX = jSONObject;
        }

        public String toString() {
            return String.format("Result(%b):%s", Boolean.valueOf(this.aUW), this.code);
        }
    }
}
