package com.baidu.swan.apps.setting.oauth.a;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.request.HttpRequest;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a extends h<C0481a> {
    protected final boolean dwQ;
    private final String dwR;
    protected final Activity mActivity;
    protected final String mScope;

    public a(Activity activity, boolean z, String str, String str2) {
        this.mActivity = activity;
        this.mScope = str;
        this.dwQ = z;
        this.dwR = str2;
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean aIB() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", aJb().id);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app_key", aJb().getAppKey());
            jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject2.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            String ahs = com.baidu.swan.apps.t.a.awe().ahs();
            if (!TextUtils.isEmpty(ahs)) {
                jSONObject2.put("host_api_key", ahs);
            }
            jSONObject.put("open", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("permit", Boolean.toString(this.dwQ));
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put(this.mScope, jSONObject3);
            jSONObject.put("accredits", jSONObject4);
            if (!TextUtils.isEmpty(this.dwR)) {
                jSONObject.put("provider_appkey", this.dwR);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        cu("data", jSONObject.toString());
        return true;
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.h
    protected HttpRequest a(h hVar) {
        return com.baidu.swan.apps.t.a.awe().f(this.mActivity, hVar.aJc());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    /* renamed from: bT */
    public C0481a bO(JSONObject jSONObject) throws JSONException {
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
        return new C0481a(this.dwQ, str, jSONObject2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.a.h
    public void aIW() {
        super.aIW();
        com.baidu.swan.apps.network.c.b.a.aCl();
    }

    /* renamed from: com.baidu.swan.apps.setting.oauth.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0481a {
        public final String code;
        public final JSONObject dwS;
        public final boolean dwh;

        private C0481a(boolean z, String str, JSONObject jSONObject) {
            this.code = str == null ? "" : str;
            this.dwh = z;
            this.dwS = jSONObject;
        }

        public String toString() {
            return String.format("Result(%b):%s", Boolean.valueOf(this.dwh), this.code);
        }
    }
}
