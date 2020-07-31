package com.baidu.swan.apps.setting.oauth.a;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.request.HttpRequest;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a extends g<C0399a> {
    protected final boolean cMT;
    private final String cMU;
    protected final Activity mActivity;
    protected final String mScope;

    public a(Activity activity, boolean z, String str, String str2) {
        this.mActivity = activity;
        this.mScope = str;
        this.cMT = z;
        this.cMU = str2;
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean ato() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", atN().id);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app_key", atN().getAppKey());
            jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject2.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            String Uj = com.baidu.swan.apps.t.a.ahv().Uj();
            if (!TextUtils.isEmpty(Uj)) {
                jSONObject2.put("host_api_key", Uj);
            }
            jSONObject.put("open", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("permit", Boolean.toString(this.cMT));
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put(this.mScope, jSONObject3);
            jSONObject.put("accredits", jSONObject4);
            if (!TextUtils.isEmpty(this.cMU)) {
                jSONObject.put("provider_appkey", this.cMU);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        bS("data", jSONObject.toString());
        return true;
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.g
    protected HttpRequest a(g gVar) {
        return com.baidu.swan.apps.t.a.ahv().e(this.mActivity, gVar.atO());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    /* renamed from: by */
    public C0399a bt(JSONObject jSONObject) throws JSONException {
        String str;
        JSONObject jSONObject2;
        JSONObject bv = com.baidu.swan.apps.setting.oauth.c.bv(jSONObject);
        int optInt = bv.optInt(BaseJsonData.TAG_ERRNO, 10001);
        if (optInt != 0) {
            throw new JSONException("Illegal errno=" + optInt + " errms=" + bv.optString("errms"));
        }
        JSONObject jSONObject3 = bv.getJSONObject("data");
        if (jSONObject3 == null) {
            str = "";
            jSONObject2 = null;
        } else {
            str = jSONObject3.optString("code", "");
            jSONObject2 = jSONObject3.optJSONObject("opendata");
        }
        return new C0399a(this.cMT, str, jSONObject2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.a.g
    public void atJ() {
        super.atJ();
        com.baidu.swan.apps.network.c.b.a.anj();
    }

    /* renamed from: com.baidu.swan.apps.setting.oauth.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0399a {
        public final JSONObject cMV;
        public final boolean cMk;
        public final String code;

        private C0399a(boolean z, String str, JSONObject jSONObject) {
            this.code = str == null ? "" : str;
            this.cMk = z;
            this.cMV = jSONObject;
        }

        public String toString() {
            return String.format("Result(%b):%s", Boolean.valueOf(this.cMk), this.code);
        }
    }
}
