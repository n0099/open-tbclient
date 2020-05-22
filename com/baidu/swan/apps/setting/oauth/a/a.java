package com.baidu.swan.apps.setting.oauth.a;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.request.HttpRequest;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends g<C0387a> {
    protected final boolean cES;
    private final String cET;
    protected final Activity mActivity;
    protected final String mScope;

    public a(Activity activity, boolean z, String str, String str2) {
        this.mActivity = activity;
        this.mScope = str;
        this.cES = z;
        this.cET = str2;
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean aqq() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", apd().id);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app_key", apd().getAppKey());
            jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject2.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            String SG = com.baidu.swan.apps.u.a.afd().SG();
            if (!TextUtils.isEmpty(SG)) {
                jSONObject2.put("host_api_key", SG);
            }
            jSONObject.put("open", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("permit", Boolean.toString(this.cES));
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put(this.mScope, jSONObject3);
            jSONObject.put("accredits", jSONObject4);
            if (!TextUtils.isEmpty(this.cET)) {
                jSONObject.put("provider_appkey", this.cET);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        bP("data", jSONObject.toString());
        return true;
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.g
    protected HttpRequest a(g gVar) {
        return com.baidu.swan.apps.u.a.afd().e(this.mActivity, gVar.aqM());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    /* renamed from: bm */
    public C0387a bh(JSONObject jSONObject) throws JSONException {
        String str;
        JSONObject jSONObject2;
        JSONObject bj = com.baidu.swan.apps.setting.oauth.c.bj(jSONObject);
        int optInt = bj.optInt(BaseJsonData.TAG_ERRNO, 10001);
        if (optInt != 0) {
            throw new JSONException("Illegal errno=" + optInt + " errms=" + bj.optString("errms"));
        }
        JSONObject jSONObject3 = bj.getJSONObject("data");
        if (jSONObject3 == null) {
            str = "";
            jSONObject2 = null;
        } else {
            str = jSONObject3.optString("code", "");
            jSONObject2 = jSONObject3.optJSONObject("opendata");
        }
        return new C0387a(this.cES, str, jSONObject2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.a.g
    public void aqI() {
        super.aqI();
        com.baidu.swan.apps.network.c.b.a.akN();
    }

    /* renamed from: com.baidu.swan.apps.setting.oauth.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0387a {
        public final JSONObject cEU;
        public final boolean cEq;
        public final String code;

        private C0387a(boolean z, String str, JSONObject jSONObject) {
            this.code = str == null ? "" : str;
            this.cEq = z;
            this.cEU = jSONObject;
        }

        public String toString() {
            return String.format("Result(%b):%s", Boolean.valueOf(this.cEq), this.code);
        }
    }
}
