package com.baidu.swan.apps.setting.oauth.a;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.fsg.face.liveness.activity.LivenessRecogActivity;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.request.HttpRequest;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class g extends h<JSONObject> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private boolean dDT;
    private final String dEi;
    protected final Activity mActivity;
    private final String mScope;

    public g(Activity activity, String str, String str2, boolean z) {
        this.mActivity = activity;
        this.mScope = str;
        this.dEi = str2;
        this.dDT = z;
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean aLJ() {
        cB("data", aMh().toString());
        return true;
    }

    public JSONObject aMh() {
        JSONObject jSONObject = new JSONObject();
        try {
            com.baidu.swan.apps.runtime.e aMj = aMj();
            jSONObject.put("ma_id", aMj.id);
            jSONObject.put("scope", this.mScope);
            jSONObject.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            jSONObject.put("app_key", aMj.getAppKey());
            if (aMj.aio() != null && aMj.aio().aBe() != null) {
                jSONObject.put("scene", aMj.aio().aBe());
            }
            if (this.dDT) {
                jSONObject.put(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, "1");
            }
            String akA = com.baidu.swan.apps.t.a.azm().akA();
            if (!TextUtils.isEmpty(akA)) {
                jSONObject.put("host_api_key", akA);
            }
            if (!TextUtils.isEmpty(this.dEi)) {
                jSONObject.put("provider_appkey", this.dEi);
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
        return com.baidu.swan.apps.t.a.azm().k(this.mActivity, hVar.aMk());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    /* renamed from: bX */
    public JSONObject bQ(JSONObject jSONObject) throws JSONException {
        JSONObject bS = com.baidu.swan.apps.setting.oauth.c.bS(jSONObject);
        int optInt = bS.optInt(BaseJsonData.TAG_ERRNO, 10001);
        if (optInt != 0) {
            throw new JSONException("Illegal errno=" + optInt + " errms=" + bS.optString("errms"));
        }
        return bS;
    }
}
