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
    private boolean dyB;
    private final String dyQ;
    protected final Activity mActivity;
    private final String mScope;

    public g(Activity activity, String str, String str2, boolean z) {
        this.mActivity = activity;
        this.mScope = str;
        this.dyQ = str2;
        this.dyB = z;
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean aJj() {
        cv("data", aJH().toString());
        return true;
    }

    public JSONObject aJH() {
        JSONObject jSONObject = new JSONObject();
        try {
            com.baidu.swan.apps.runtime.e aJJ = aJJ();
            jSONObject.put("ma_id", aJJ.id);
            jSONObject.put("scope", this.mScope);
            jSONObject.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            jSONObject.put("app_key", aJJ.getAppKey());
            if (aJJ.afO() != null && aJJ.afO().ayD() != null) {
                jSONObject.put("scene", aJJ.afO().ayD());
            }
            if (this.dyB) {
                jSONObject.put(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, "1");
            }
            String aia = com.baidu.swan.apps.t.a.awM().aia();
            if (!TextUtils.isEmpty(aia)) {
                jSONObject.put("host_api_key", aia);
            }
            if (!TextUtils.isEmpty(this.dyQ)) {
                jSONObject.put("provider_appkey", this.dyQ);
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
        return com.baidu.swan.apps.t.a.awM().k(this.mActivity, hVar.aJK());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    /* renamed from: cb */
    public JSONObject bU(JSONObject jSONObject) throws JSONException {
        JSONObject bW = com.baidu.swan.apps.setting.oauth.c.bW(jSONObject);
        int optInt = bW.optInt(BaseJsonData.TAG_ERRNO, 10001);
        if (optInt != 0) {
            throw new JSONException("Illegal errno=" + optInt + " errms=" + bW.optString("errms"));
        }
        return bW;
    }
}
