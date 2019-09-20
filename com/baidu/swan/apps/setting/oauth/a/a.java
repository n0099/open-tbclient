package com.baidu.swan.apps.setting.oauth.a;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.sapi2.utils.SapiGIDEvent;
import com.baidu.searchbox.common.runtime.AppRuntime;
import okhttp3.Request;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends g<C0189a> {
    protected final boolean aVt;
    protected final Activity mActivity;
    protected final String mScope;

    public a(Activity activity, boolean z, String str) {
        this.mActivity = activity;
        this.mScope = str;
        this.aVt = z;
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean DS() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", My().id);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app_key", My().getAppKey());
            jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject2.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            String wW = com.baidu.swan.apps.u.a.EA().wW();
            if (!TextUtils.isEmpty(wW)) {
                jSONObject2.put("host_api_key", wW);
            }
            jSONObject.put("open", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("permit", Boolean.toString(this.aVt));
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
        return com.baidu.swan.apps.u.a.EA().e(this.mActivity, gVar.NC());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    /* renamed from: y */
    public C0189a z(JSONObject jSONObject) throws JSONException {
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
        return new C0189a(this.aVt, str, jSONObject2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.a.g
    public void DT() {
        super.DT();
        com.baidu.swan.apps.network.c.b.a.If();
    }

    /* renamed from: com.baidu.swan.apps.setting.oauth.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0189a {
        public final boolean aVu;
        public final JSONObject aVv;
        public final String code;

        private C0189a(boolean z, String str, JSONObject jSONObject) {
            this.code = str == null ? "" : str;
            this.aVu = z;
            this.aVv = jSONObject;
        }

        public String toString() {
            return String.format("Result(%b):%s", Boolean.valueOf(this.aVu), this.code);
        }
    }
}
