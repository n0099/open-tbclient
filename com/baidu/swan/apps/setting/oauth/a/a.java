package com.baidu.swan.apps.setting.oauth.a;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.request.HttpRequest;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a extends h<C0466a> {
    protected final boolean dJL;
    private final String dJM;
    protected final Activity mActivity;
    protected final String mScope;

    public a(Activity activity, boolean z, String str, String str2) {
        this.mActivity = activity;
        this.mScope = str;
        this.dJL = z;
        this.dJM = str2;
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean aKz() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", aKZ().id);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app_key", aKZ().getAppKey());
            jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject2.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            String aip = com.baidu.swan.apps.t.a.axi().aip();
            if (!TextUtils.isEmpty(aip)) {
                jSONObject2.put("host_api_key", aip);
            }
            jSONObject.put("open", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("permit", Boolean.toString(this.dJL));
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put(this.mScope, jSONObject3);
            jSONObject.put("accredits", jSONObject4);
            if (!TextUtils.isEmpty(this.dJM)) {
                jSONObject.put("provider_appkey", this.dJM);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ct("data", jSONObject.toString());
        return true;
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.h
    protected HttpRequest a(h hVar) {
        return com.baidu.swan.apps.t.a.axi().f(this.mActivity, hVar.aLa());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    /* renamed from: ca */
    public C0466a bV(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2;
        JSONObject bX = com.baidu.swan.apps.setting.oauth.c.bX(jSONObject);
        int optInt = bX.optInt(BaseJsonData.TAG_ERRNO, 10001);
        if (optInt != 0) {
            throw new JSONException("Illegal errno=" + optInt + " errms=" + bX.optString("errms"));
        }
        String str = "";
        JSONObject jSONObject3 = bX.getJSONObject("data");
        if (jSONObject3 != null) {
            str = jSONObject3.optString("code", "");
            jSONObject2 = jSONObject3.optJSONObject("opendata");
        } else {
            jSONObject2 = null;
        }
        return new C0466a(this.dJL, str, jSONObject2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.a.h
    public void aKU() {
        super.aKU();
        com.baidu.swan.apps.network.c.b.a.aDr();
    }

    /* renamed from: com.baidu.swan.apps.setting.oauth.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0466a {
        public final String code;
        public final JSONObject dJN;
        public final boolean dJc;

        private C0466a(boolean z, String str, JSONObject jSONObject) {
            this.code = str == null ? "" : str;
            this.dJc = z;
            this.dJN = jSONObject;
        }

        public String toString() {
            return String.format("Result(%b):%s", Boolean.valueOf(this.dJc), this.code);
        }
    }
}
