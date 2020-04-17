package com.baidu.swan.apps.setting.oauth.a;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.fsg.face.liveness.activity.LivenessRecogActivity;
import com.baidu.sapi2.dto.FaceBaseDTO;
import com.baidu.searchbox.common.runtime.AppRuntime;
import okhttp3.Request;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class f extends g<JSONObject> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private boolean csU;
    private final String ctj;
    protected final Activity mActivity;
    private final String mScope;

    public f(Activity activity, String str, String str2, boolean z) {
        this.mActivity = activity;
        this.mScope = str;
        this.ctj = str2;
        this.csU = z;
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean amo() {
        bu("data", amI().toString());
        return true;
    }

    public JSONObject amI() {
        JSONObject jSONObject = new JSONObject();
        try {
            com.baidu.swan.apps.runtime.e alj = alj();
            jSONObject.put("ma_id", alj.id);
            jSONObject.put("scope", this.mScope);
            jSONObject.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            jSONObject.put("app_key", alj.getAppKey());
            if (alj.Ow() != null && alj.Ow().adB() != null) {
                jSONObject.put(FaceBaseDTO.KEY_BUSINESS_SCENE, alj.Ow().adB());
            }
            if (this.csU) {
                jSONObject.put(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, "1");
            }
            String PR = com.baidu.swan.apps.w.a.aca().PR();
            if (!TextUtils.isEmpty(PR)) {
                jSONObject.put("host_api_key", PR);
            }
            if (!TextUtils.isEmpty(this.ctj)) {
                jSONObject.put("provider_appkey", this.ctj);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.g
    protected Request a(g gVar) {
        return com.baidu.swan.apps.w.a.aca().i(this.mActivity, gVar.amJ());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    /* renamed from: bf */
    public JSONObject aY(JSONObject jSONObject) throws JSONException {
        JSONObject ba = com.baidu.swan.apps.setting.oauth.c.ba(jSONObject);
        int optInt = ba.optInt(BaseJsonData.TAG_ERRNO, 10001);
        if (optInt != 0) {
            throw new JSONException("Illegal errno=" + optInt + " errms=" + ba.optString("errms"));
        }
        return ba;
    }
}
