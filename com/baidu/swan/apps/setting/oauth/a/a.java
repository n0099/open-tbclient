package com.baidu.swan.apps.setting.oauth.a;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import okhttp3.Request;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends g<C0221a> {
    protected final boolean box;
    protected final Activity mActivity;
    protected final String mScope;

    public a(Activity activity, boolean z, String str) {
        this.mActivity = activity;
        this.mScope = str;
        this.box = z;
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean IM() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", Rq().id);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app_key", Rq().getAppKey());
            jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject2.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            String BQ = com.baidu.swan.apps.u.a.Ju().BQ();
            if (!TextUtils.isEmpty(BQ)) {
                jSONObject2.put("host_api_key", BQ);
            }
            jSONObject.put("open", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("permit", Boolean.toString(this.box));
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put(this.mScope, jSONObject3);
            jSONObject.put("accredits", jSONObject4);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        aI("data", jSONObject.toString());
        return true;
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.g
    protected Request a(g gVar) {
        return com.baidu.swan.apps.u.a.Ju().e(this.mActivity, gVar.Ss());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    /* renamed from: W */
    public C0221a X(JSONObject jSONObject) throws JSONException {
        String str;
        JSONObject jSONObject2;
        JSONObject aD = com.baidu.swan.apps.setting.oauth.c.aD(jSONObject);
        int optInt = aD.optInt("errno", 11001);
        if (optInt != 0) {
            if (11001 == optInt) {
                com.baidu.swan.apps.setting.oauth.c.aC(aD);
                com.baidu.swan.apps.setting.oauth.c.aH("Accredit", aD.toString());
            }
            throw new JSONException("Illegal errno=" + optInt + " errms=" + aD.optString("errms"));
        }
        JSONObject jSONObject3 = aD.getJSONObject("data");
        if (jSONObject3 == null) {
            str = "";
            jSONObject2 = null;
        } else {
            str = jSONObject3.optString("code", "");
            jSONObject2 = jSONObject3.optJSONObject("opendata");
        }
        return new C0221a(this.box, str, jSONObject2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.a.g
    public void IN() {
        super.IN();
        com.baidu.swan.apps.network.c.b.a.MZ();
    }

    /* renamed from: com.baidu.swan.apps.setting.oauth.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0221a {
        public final boolean boy;
        public final JSONObject boz;
        public final String code;

        private C0221a(boolean z, String str, JSONObject jSONObject) {
            this.code = str == null ? "" : str;
            this.boy = z;
            this.boz = jSONObject;
        }

        public String toString() {
            return String.format("Result(%b):%s", Boolean.valueOf(this.boy), this.code);
        }
    }
}
