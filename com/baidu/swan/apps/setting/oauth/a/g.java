package com.baidu.swan.apps.setting.oauth.a;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.fsg.face.liveness.activity.LivenessRecogActivity;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.request.HttpRequest;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class g extends h<JSONObject> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private boolean dwU;
    private final String dxj;
    protected final Activity mActivity;
    private final String mScope;

    public g(Activity activity, String str, String str2, boolean z) {
        this.mActivity = activity;
        this.mScope = str;
        this.dxj = str2;
        this.dwU = z;
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean aIB() {
        cu("data", aIZ().toString());
        return true;
    }

    public JSONObject aIZ() {
        JSONObject jSONObject = new JSONObject();
        try {
            com.baidu.swan.apps.runtime.e aJb = aJb();
            jSONObject.put("ma_id", aJb.id);
            jSONObject.put("scope", this.mScope);
            jSONObject.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            jSONObject.put("app_key", aJb.getAppKey());
            if (aJb.afg() != null && aJb.afg().axV() != null) {
                jSONObject.put("scene", aJb.afg().axV());
            }
            if (this.dwU) {
                jSONObject.put(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, "1");
            }
            String ahs = com.baidu.swan.apps.t.a.awe().ahs();
            if (!TextUtils.isEmpty(ahs)) {
                jSONObject.put("host_api_key", ahs);
            }
            if (!TextUtils.isEmpty(this.dxj)) {
                jSONObject.put("provider_appkey", this.dxj);
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
        return com.baidu.swan.apps.t.a.awe().k(this.mActivity, hVar.aJc());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    /* renamed from: bV */
    public JSONObject bO(JSONObject jSONObject) throws JSONException {
        JSONObject bQ = com.baidu.swan.apps.setting.oauth.c.bQ(jSONObject);
        int optInt = bQ.optInt(BaseJsonData.TAG_ERRNO, 10001);
        if (optInt != 0) {
            throw new JSONException("Illegal errno=" + optInt + " errms=" + bQ.optString("errms"));
        }
        return bQ;
    }
}
