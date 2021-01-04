package com.baidu.swan.apps.setting.oauth.a;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.fsg.face.liveness.activity.LivenessRecogActivity;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.request.HttpRequest;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class g extends h<JSONObject> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final String dMM;
    private boolean dMx;
    protected final Activity mActivity;
    private final String mScope;

    public g(Activity activity, String str, String str2, boolean z) {
        this.mActivity = activity;
        this.mScope = str;
        this.dMM = str2;
        this.dMx = z;
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean aNZ() {
        cA("data", aOx().toString());
        return true;
    }

    public JSONObject aOx() {
        JSONObject jSONObject = new JSONObject();
        try {
            com.baidu.swan.apps.runtime.e aOz = aOz();
            jSONObject.put("ma_id", aOz.id);
            jSONObject.put("scope", this.mScope);
            jSONObject.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            jSONObject.put("app_key", aOz.getAppKey());
            if (aOz.aju() != null && aOz.aju().aCv() != null) {
                jSONObject.put("scene", aOz.aju().aCv());
            }
            if (this.dMx) {
                jSONObject.put(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, "1");
            }
            String alK = com.baidu.swan.apps.t.a.aAD().alK();
            if (!TextUtils.isEmpty(alK)) {
                jSONObject.put("host_api_key", alK);
            }
            if (!TextUtils.isEmpty(this.dMM)) {
                jSONObject.put("provider_appkey", this.dMM);
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
        return com.baidu.swan.apps.t.a.aAD().k(this.mActivity, hVar.aOA());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    /* renamed from: cf */
    public JSONObject bY(JSONObject jSONObject) throws JSONException {
        JSONObject ca = com.baidu.swan.apps.setting.oauth.c.ca(jSONObject);
        int optInt = ca.optInt(BaseJsonData.TAG_ERRNO, 10001);
        if (optInt != 0) {
            throw new JSONException("Illegal errno=" + optInt + " errms=" + ca.optString("errms"));
        }
        return ca;
    }
}
