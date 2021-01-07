package com.baidu.swan.apps.setting.oauth.a;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.request.HttpRequest;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a extends h<C0486a> {
    protected final boolean dMt;
    private final String dMu;
    protected final Activity mActivity;
    protected final String mScope;

    public a(Activity activity, boolean z, String str, String str2) {
        this.mActivity = activity;
        this.mScope = str;
        this.dMt = z;
        this.dMu = str2;
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean aOa() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", aOA().id);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app_key", aOA().getAppKey());
            jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject2.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            String alL = com.baidu.swan.apps.t.a.aAE().alL();
            if (!TextUtils.isEmpty(alL)) {
                jSONObject2.put("host_api_key", alL);
            }
            jSONObject.put("open", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("permit", Boolean.toString(this.dMt));
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put(this.mScope, jSONObject3);
            jSONObject.put("accredits", jSONObject4);
            if (!TextUtils.isEmpty(this.dMu)) {
                jSONObject.put("provider_appkey", this.dMu);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        cA("data", jSONObject.toString());
        return true;
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.h
    protected HttpRequest a(h hVar) {
        return com.baidu.swan.apps.t.a.aAE().f(this.mActivity, hVar.aOB());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    /* renamed from: cd */
    public C0486a bY(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2;
        JSONObject ca = com.baidu.swan.apps.setting.oauth.c.ca(jSONObject);
        int optInt = ca.optInt(BaseJsonData.TAG_ERRNO, 10001);
        if (optInt != 0) {
            throw new JSONException("Illegal errno=" + optInt + " errms=" + ca.optString("errms"));
        }
        String str = "";
        JSONObject jSONObject3 = ca.getJSONObject("data");
        if (jSONObject3 != null) {
            str = jSONObject3.optString("code", "");
            jSONObject2 = jSONObject3.optJSONObject("opendata");
        } else {
            jSONObject2 = null;
        }
        return new C0486a(this.dMt, str, jSONObject2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.a.h
    public void aOv() {
        super.aOv();
        com.baidu.swan.apps.network.c.b.a.aGP();
    }

    /* renamed from: com.baidu.swan.apps.setting.oauth.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0486a {
        public final String code;
        public final boolean dLK;
        public final JSONObject dMv;

        private C0486a(boolean z, String str, JSONObject jSONObject) {
            this.code = str == null ? "" : str;
            this.dLK = z;
            this.dMv = jSONObject;
        }

        public String toString() {
            return String.format("Result(%b):%s", Boolean.valueOf(this.dLK), this.code);
        }
    }
}
