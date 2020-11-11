package com.baidu.swan.apps.setting.oauth.a;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.request.HttpRequest;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a extends h<C0483a> {
    protected final boolean dyx;
    private final String dyy;
    protected final Activity mActivity;
    protected final String mScope;

    public a(Activity activity, boolean z, String str, String str2) {
        this.mActivity = activity;
        this.mScope = str;
        this.dyx = z;
        this.dyy = str2;
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean aJj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", aJJ().id);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app_key", aJJ().getAppKey());
            jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject2.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            String aia = com.baidu.swan.apps.t.a.awM().aia();
            if (!TextUtils.isEmpty(aia)) {
                jSONObject2.put("host_api_key", aia);
            }
            jSONObject.put("open", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("permit", Boolean.toString(this.dyx));
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put(this.mScope, jSONObject3);
            jSONObject.put("accredits", jSONObject4);
            if (!TextUtils.isEmpty(this.dyy)) {
                jSONObject.put("provider_appkey", this.dyy);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        cv("data", jSONObject.toString());
        return true;
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.h
    protected HttpRequest a(h hVar) {
        return com.baidu.swan.apps.t.a.awM().f(this.mActivity, hVar.aJK());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    /* renamed from: bZ */
    public C0483a bU(JSONObject jSONObject) throws JSONException {
        String str;
        JSONObject jSONObject2;
        JSONObject bW = com.baidu.swan.apps.setting.oauth.c.bW(jSONObject);
        int optInt = bW.optInt(BaseJsonData.TAG_ERRNO, 10001);
        if (optInt != 0) {
            throw new JSONException("Illegal errno=" + optInt + " errms=" + bW.optString("errms"));
        }
        JSONObject jSONObject3 = bW.getJSONObject("data");
        if (jSONObject3 == null) {
            str = "";
            jSONObject2 = null;
        } else {
            str = jSONObject3.optString("code", "");
            jSONObject2 = jSONObject3.optJSONObject("opendata");
        }
        return new C0483a(this.dyx, str, jSONObject2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.a.h
    public void aJE() {
        super.aJE();
        com.baidu.swan.apps.network.c.b.a.aCT();
    }

    /* renamed from: com.baidu.swan.apps.setting.oauth.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0483a {
        public final String code;
        public final boolean dxO;
        public final JSONObject dyz;

        private C0483a(boolean z, String str, JSONObject jSONObject) {
            this.code = str == null ? "" : str;
            this.dxO = z;
            this.dyz = jSONObject;
        }

        public String toString() {
            return String.format("Result(%b):%s", Boolean.valueOf(this.dxO), this.code);
        }
    }
}
