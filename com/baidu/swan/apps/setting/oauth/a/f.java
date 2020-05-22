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
/* loaded from: classes11.dex */
public class f extends g<JSONObject> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private boolean cEW;
    private final String cFl;
    protected final Activity mActivity;
    private final String mScope;

    public f(Activity activity, String str, String str2, boolean z) {
        this.mActivity = activity;
        this.mScope = str;
        this.cFl = str2;
        this.cEW = z;
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean aqq() {
        bP("data", aqK().toString());
        return true;
    }

    public JSONObject aqK() {
        JSONObject jSONObject = new JSONObject();
        try {
            com.baidu.swan.apps.runtime.e apd = apd();
            jSONObject.put("ma_id", apd.id);
            jSONObject.put("scope", this.mScope);
            jSONObject.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            jSONObject.put("app_key", apd.getAppKey());
            if (apd.QJ() != null && apd.QJ().agK() != null) {
                jSONObject.put(FaceBaseDTO.KEY_BUSINESS_SCENE, apd.QJ().agK());
            }
            if (this.cEW) {
                jSONObject.put(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, "1");
            }
            String SG = com.baidu.swan.apps.u.a.afd().SG();
            if (!TextUtils.isEmpty(SG)) {
                jSONObject.put("host_api_key", SG);
            }
            if (!TextUtils.isEmpty(this.cFl)) {
                jSONObject.put("provider_appkey", this.cFl);
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
        return com.baidu.swan.apps.u.a.afd().i(this.mActivity, gVar.aqM());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    /* renamed from: bo */
    public JSONObject bh(JSONObject jSONObject) throws JSONException {
        JSONObject bj = com.baidu.swan.apps.setting.oauth.c.bj(jSONObject);
        int optInt = bj.optInt(BaseJsonData.TAG_ERRNO, 10001);
        if (optInt != 0) {
            throw new JSONException("Illegal errno=" + optInt + " errms=" + bj.optString("errms"));
        }
        return bj;
    }
}
