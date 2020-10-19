package com.baidu.swan.apps.setting.oauth.a;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.fsg.face.liveness.activity.LivenessRecogActivity;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.request.HttpRequest;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class g extends h<JSONObject> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private boolean dkh;
    private final String dkw;
    protected final Activity mActivity;
    private final String mScope;

    public g(Activity activity, String str, String str2, boolean z) {
        this.mActivity = activity;
        this.mScope = str;
        this.dkw = str2;
        this.dkh = z;
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean aEP() {
        co("data", aFn().toString());
        return true;
    }

    public JSONObject aFn() {
        JSONObject jSONObject = new JSONObject();
        try {
            com.baidu.swan.apps.runtime.e aFp = aFp();
            jSONObject.put("ma_id", aFp.id);
            jSONObject.put("scope", this.mScope);
            jSONObject.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            jSONObject.put("app_key", aFp.getAppKey());
            if (aFp.abu() != null && aFp.abu().auj() != null) {
                jSONObject.put("scene", aFp.abu().auj());
            }
            if (this.dkh) {
                jSONObject.put(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, "1");
            }
            String adG = com.baidu.swan.apps.t.a.ass().adG();
            if (!TextUtils.isEmpty(adG)) {
                jSONObject.put("host_api_key", adG);
            }
            if (!TextUtils.isEmpty(this.dkw)) {
                jSONObject.put("provider_appkey", this.dkw);
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
        return com.baidu.swan.apps.t.a.ass().k(this.mActivity, hVar.aFq());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    /* renamed from: bS */
    public JSONObject bL(JSONObject jSONObject) throws JSONException {
        JSONObject bN = com.baidu.swan.apps.setting.oauth.c.bN(jSONObject);
        int optInt = bN.optInt(BaseJsonData.TAG_ERRNO, 10001);
        if (optInt != 0) {
            throw new JSONException("Illegal errno=" + optInt + " errms=" + bN.optString("errms"));
        }
        return bN;
    }
}
