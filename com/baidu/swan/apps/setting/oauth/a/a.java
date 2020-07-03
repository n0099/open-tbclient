package com.baidu.swan.apps.setting.oauth.a;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.request.HttpRequest;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends g<C0393a> {
    protected final boolean cJC;
    private final String cJD;
    protected final Activity mActivity;
    protected final String mScope;

    public a(Activity activity, boolean z, String str, String str2) {
        this.mActivity = activity;
        this.mScope = str;
        this.cJC = z;
        this.cJD = str2;
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean arw() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", aqk().id);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app_key", aqk().getAppKey());
            jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject2.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            String TM = com.baidu.swan.apps.u.a.agj().TM();
            if (!TextUtils.isEmpty(TM)) {
                jSONObject2.put("host_api_key", TM);
            }
            jSONObject.put("open", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("permit", Boolean.toString(this.cJC));
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put(this.mScope, jSONObject3);
            jSONObject.put("accredits", jSONObject4);
            if (!TextUtils.isEmpty(this.cJD)) {
                jSONObject.put("provider_appkey", this.cJD);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        bR("data", jSONObject.toString());
        return true;
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.g
    protected HttpRequest a(g gVar) {
        return com.baidu.swan.apps.u.a.agj().e(this.mActivity, gVar.arS());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    /* renamed from: bt */
    public C0393a bo(JSONObject jSONObject) throws JSONException {
        String str;
        JSONObject jSONObject2;
        JSONObject bq = com.baidu.swan.apps.setting.oauth.c.bq(jSONObject);
        int optInt = bq.optInt(BaseJsonData.TAG_ERRNO, 10001);
        if (optInt != 0) {
            throw new JSONException("Illegal errno=" + optInt + " errms=" + bq.optString("errms"));
        }
        JSONObject jSONObject3 = bq.getJSONObject("data");
        if (jSONObject3 == null) {
            str = "";
            jSONObject2 = null;
        } else {
            str = jSONObject3.optString("code", "");
            jSONObject2 = jSONObject3.optJSONObject("opendata");
        }
        return new C0393a(this.cJC, str, jSONObject2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.a.g
    public void arO() {
        super.arO();
        com.baidu.swan.apps.network.c.b.a.alT();
    }

    /* renamed from: com.baidu.swan.apps.setting.oauth.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0393a {
        public final JSONObject cJE;
        public final boolean cJa;
        public final String code;

        private C0393a(boolean z, String str, JSONObject jSONObject) {
            this.code = str == null ? "" : str;
            this.cJa = z;
            this.cJE = jSONObject;
        }

        public String toString() {
            return String.format("Result(%b):%s", Boolean.valueOf(this.cJa), this.code);
        }
    }
}
