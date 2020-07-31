package com.baidu.swan.apps.setting.oauth.a;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.fsg.face.liveness.activity.LivenessRecogActivity;
import com.baidu.sapi2.dto.FaceBaseDTO;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.request.HttpRequest;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class f extends g<JSONObject> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private boolean cMX;
    private final String cNm;
    protected final Activity mActivity;
    private final String mScope;

    public f(Activity activity, String str, String str2, boolean z) {
        this.mActivity = activity;
        this.mScope = str;
        this.cNm = str2;
        this.cMX = z;
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean ato() {
        bS("data", atL().toString());
        return true;
    }

    public JSONObject atL() {
        JSONObject jSONObject = new JSONObject();
        try {
            com.baidu.swan.apps.runtime.e atN = atN();
            jSONObject.put("ma_id", atN.id);
            jSONObject.put("scope", this.mScope);
            jSONObject.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            jSONObject.put("app_key", atN.getAppKey());
            if (atN.Se() != null && atN.Se().ajg() != null) {
                jSONObject.put(FaceBaseDTO.KEY_BUSINESS_SCENE, atN.Se().ajg());
            }
            if (this.cMX) {
                jSONObject.put(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, "1");
            }
            String Uj = com.baidu.swan.apps.t.a.ahv().Uj();
            if (!TextUtils.isEmpty(Uj)) {
                jSONObject.put("host_api_key", Uj);
            }
            if (!TextUtils.isEmpty(this.cNm)) {
                jSONObject.put("provider_appkey", this.cNm);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.g
    protected HttpRequest a(g gVar) {
        return com.baidu.swan.apps.t.a.ahv().i(this.mActivity, gVar.atO());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    /* renamed from: bA */
    public JSONObject bt(JSONObject jSONObject) throws JSONException {
        JSONObject bv = com.baidu.swan.apps.setting.oauth.c.bv(jSONObject);
        int optInt = bv.optInt(BaseJsonData.TAG_ERRNO, 10001);
        if (optInt != 0) {
            throw new JSONException("Illegal errno=" + optInt + " errms=" + bv.optString("errms"));
        }
        return bv;
    }
}
