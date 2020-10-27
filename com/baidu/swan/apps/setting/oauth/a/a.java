package com.baidu.swan.apps.setting.oauth.a;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.request.HttpRequest;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a extends h<C0471a> {
    protected final boolean dsE;
    private final String dsF;
    protected final Activity mActivity;
    protected final String mScope;

    public a(Activity activity, boolean z, String str, String str2) {
        this.mActivity = activity;
        this.mScope = str;
        this.dsE = z;
        this.dsF = str2;
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean aGJ() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", aHj().id);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app_key", aHj().getAppKey());
            jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject2.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            String afA = com.baidu.swan.apps.t.a.aum().afA();
            if (!TextUtils.isEmpty(afA)) {
                jSONObject2.put("host_api_key", afA);
            }
            jSONObject.put("open", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("permit", Boolean.toString(this.dsE));
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put(this.mScope, jSONObject3);
            jSONObject.put("accredits", jSONObject4);
            if (!TextUtils.isEmpty(this.dsF)) {
                jSONObject.put("provider_appkey", this.dsF);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        cv("data", jSONObject.toString());
        return true;
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.h
    protected HttpRequest a(h hVar) {
        return com.baidu.swan.apps.t.a.aum().f(this.mActivity, hVar.aHk());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    /* renamed from: bT */
    public C0471a bO(JSONObject jSONObject) throws JSONException {
        String str;
        JSONObject jSONObject2;
        JSONObject bQ = com.baidu.swan.apps.setting.oauth.c.bQ(jSONObject);
        int optInt = bQ.optInt(BaseJsonData.TAG_ERRNO, 10001);
        if (optInt != 0) {
            throw new JSONException("Illegal errno=" + optInt + " errms=" + bQ.optString("errms"));
        }
        JSONObject jSONObject3 = bQ.getJSONObject("data");
        if (jSONObject3 == null) {
            str = "";
            jSONObject2 = null;
        } else {
            str = jSONObject3.optString("code", "");
            jSONObject2 = jSONObject3.optJSONObject("opendata");
        }
        return new C0471a(this.dsE, str, jSONObject2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.a.h
    public void aHe() {
        super.aHe();
        com.baidu.swan.apps.network.c.b.a.aAt();
    }

    /* renamed from: com.baidu.swan.apps.setting.oauth.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0471a {
        public final String code;
        public final boolean drU;
        public final JSONObject dsG;

        private C0471a(boolean z, String str, JSONObject jSONObject) {
            this.code = str == null ? "" : str;
            this.drU = z;
            this.dsG = jSONObject;
        }

        public String toString() {
            return String.format("Result(%b):%s", Boolean.valueOf(this.drU), this.code);
        }
    }
}
