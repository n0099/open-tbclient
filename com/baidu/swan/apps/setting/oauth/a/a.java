package com.baidu.swan.apps.setting.oauth.a;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import okhttp3.Request;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends g<C0294a> {
    protected final boolean bTO;
    private final String bTP;
    protected final Activity mActivity;
    protected final String mScope;

    public a(Activity activity, boolean z, String str, String str2) {
        this.mActivity = activity;
        this.mScope = str;
        this.bTO = z;
        this.bTP = str2;
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean aee() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", acZ().id);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app_key", acZ().getAppKey());
            jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject2.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            String Ia = com.baidu.swan.apps.w.a.Ug().Ia();
            if (!TextUtils.isEmpty(Ia)) {
                jSONObject2.put("host_api_key", Ia);
            }
            jSONObject.put("open", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("permit", Boolean.toString(this.bTO));
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put(this.mScope, jSONObject3);
            jSONObject.put("accredits", jSONObject4);
            if (!TextUtils.isEmpty(this.bTP)) {
                jSONObject.put("provider_appkey", this.bTP);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        bl("data", jSONObject.toString());
        return true;
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.g
    protected Request a(g gVar) {
        return com.baidu.swan.apps.w.a.Ug().e(this.mActivity, gVar.aez());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    /* renamed from: aS */
    public C0294a aN(JSONObject jSONObject) throws JSONException {
        String str;
        JSONObject jSONObject2;
        JSONObject aP = com.baidu.swan.apps.setting.oauth.c.aP(jSONObject);
        int optInt = aP.optInt("errno", 10001);
        if (optInt != 0) {
            throw new JSONException("Illegal errno=" + optInt + " errms=" + aP.optString("errms"));
        }
        JSONObject jSONObject3 = aP.getJSONObject("data");
        if (jSONObject3 == null) {
            str = "";
            jSONObject2 = null;
        } else {
            str = jSONObject3.optString("code", "");
            jSONObject2 = jSONObject3.optJSONObject("opendata");
        }
        return new C0294a(this.bTO, str, jSONObject2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.a.g
    public void aew() {
        super.aew();
        com.baidu.swan.apps.network.c.b.a.Zk();
    }

    /* renamed from: com.baidu.swan.apps.setting.oauth.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0294a {
        public final JSONObject bTQ;
        public final boolean bTl;
        public final String code;

        private C0294a(boolean z, String str, JSONObject jSONObject) {
            this.code = str == null ? "" : str;
            this.bTl = z;
            this.bTQ = jSONObject;
        }

        public String toString() {
            return String.format("Result(%b):%s", Boolean.valueOf(this.bTl), this.code);
        }
    }
}
