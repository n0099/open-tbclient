package com.baidu.swan.apps.setting.oauth.a;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.fsg.face.liveness.activity.LivenessRecogActivity;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.request.HttpRequest;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g extends h<JSONObject> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private boolean cXX;
    private final String cYm;
    protected final Activity mActivity;
    private final String mScope;

    public g(Activity activity, String str, String str2, boolean z) {
        this.mActivity = activity;
        this.mScope = str;
        this.cYm = str2;
        this.cXX = z;
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean aCg() {
        cj("data", aCE().toString());
        return true;
    }

    public JSONObject aCE() {
        JSONObject jSONObject = new JSONObject();
        try {
            com.baidu.swan.apps.runtime.e aCG = aCG();
            jSONObject.put("ma_id", aCG.id);
            jSONObject.put("scope", this.mScope);
            jSONObject.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            jSONObject.put("app_key", aCG.getAppKey());
            if (aCG.YI() != null && aCG.YI().arx() != null) {
                jSONObject.put("scene", aCG.YI().arx());
            }
            if (this.cXX) {
                jSONObject.put(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, "1");
            }
            String aaU = com.baidu.swan.apps.t.a.apG().aaU();
            if (!TextUtils.isEmpty(aaU)) {
                jSONObject.put("host_api_key", aaU);
            }
            if (!TextUtils.isEmpty(this.cYm)) {
                jSONObject.put("provider_appkey", this.cYm);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.h
    protected HttpRequest a(h hVar) {
        return com.baidu.swan.apps.t.a.apG().k(this.mActivity, hVar.aCH());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    /* renamed from: bL */
    public JSONObject bE(JSONObject jSONObject) throws JSONException {
        JSONObject bG = com.baidu.swan.apps.setting.oauth.c.bG(jSONObject);
        int optInt = bG.optInt(BaseJsonData.TAG_ERRNO, 10001);
        if (optInt != 0) {
            throw new JSONException("Illegal errno=" + optInt + " errms=" + bG.optString("errms"));
        }
        return bG;
    }
}
