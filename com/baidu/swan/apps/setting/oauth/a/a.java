package com.baidu.swan.apps.setting.oauth.a;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.request.HttpRequest;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a extends h<C0457a> {
    protected final boolean dkd;
    private final String dke;
    protected final Activity mActivity;
    protected final String mScope;

    public a(Activity activity, boolean z, String str, String str2) {
        this.mActivity = activity;
        this.mScope = str;
        this.dkd = z;
        this.dke = str2;
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean aEP() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", aFp().id);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app_key", aFp().getAppKey());
            jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject2.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            String adG = com.baidu.swan.apps.t.a.ass().adG();
            if (!TextUtils.isEmpty(adG)) {
                jSONObject2.put("host_api_key", adG);
            }
            jSONObject.put("open", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("permit", Boolean.toString(this.dkd));
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put(this.mScope, jSONObject3);
            jSONObject.put("accredits", jSONObject4);
            if (!TextUtils.isEmpty(this.dke)) {
                jSONObject.put("provider_appkey", this.dke);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        co("data", jSONObject.toString());
        return true;
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.h
    protected HttpRequest a(h hVar) {
        return com.baidu.swan.apps.t.a.ass().f(this.mActivity, hVar.aFq());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    /* renamed from: bQ */
    public C0457a bL(JSONObject jSONObject) throws JSONException {
        String str;
        JSONObject jSONObject2;
        JSONObject bN = com.baidu.swan.apps.setting.oauth.c.bN(jSONObject);
        int optInt = bN.optInt(BaseJsonData.TAG_ERRNO, 10001);
        if (optInt != 0) {
            throw new JSONException("Illegal errno=" + optInt + " errms=" + bN.optString("errms"));
        }
        JSONObject jSONObject3 = bN.getJSONObject("data");
        if (jSONObject3 == null) {
            str = "";
            jSONObject2 = null;
        } else {
            str = jSONObject3.optString("code", "");
            jSONObject2 = jSONObject3.optJSONObject("opendata");
        }
        return new C0457a(this.dkd, str, jSONObject2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.a.h
    public void aFk() {
        super.aFk();
        com.baidu.swan.apps.network.c.b.a.ayz();
    }

    /* renamed from: com.baidu.swan.apps.setting.oauth.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0457a {
        public final String code;
        public final boolean dju;
        public final JSONObject dkf;

        private C0457a(boolean z, String str, JSONObject jSONObject) {
            this.code = str == null ? "" : str;
            this.dju = z;
            this.dkf = jSONObject;
        }

        public String toString() {
            return String.format("Result(%b):%s", Boolean.valueOf(this.dju), this.code);
        }
    }
}
