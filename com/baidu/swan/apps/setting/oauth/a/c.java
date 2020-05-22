package com.baidu.swan.apps.setting.oauth.a;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.request.HttpRequest;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c extends g<JSONObject> {
    protected final Activity mActivity;
    protected String mAppKey;

    public c(Activity activity, String str) {
        this.mAppKey = str;
        this.mActivity = activity;
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean aqq() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_key", this.mAppKey);
            jSONObject.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            String SG = com.baidu.swan.apps.u.a.afd().SG();
            if (!TextUtils.isEmpty(SG)) {
                jSONObject.put("host_api_key", SG);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        bP("data", jSONObject.toString());
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    /* renamed from: bo */
    public JSONObject bh(JSONObject jSONObject) throws JSONException {
        return com.baidu.swan.apps.setting.oauth.c.bj(jSONObject);
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.g
    protected HttpRequest a(g gVar) {
        return com.baidu.swan.apps.u.a.afd().g(this.mActivity, gVar.aqM());
    }
}
