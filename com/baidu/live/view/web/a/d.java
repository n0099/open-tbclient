package com.baidu.live.view.web.a;

import android.text.TextUtils;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.scheme.SchemeCallback;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class d extends com.baidu.live.view.web.a {
    private SchemeCallback schemeCallback;

    public d(SchemeCallback schemeCallback) {
        this.schemeCallback = schemeCallback;
    }

    @Override // com.baidu.live.view.web.a
    public String getName() {
        return "cuidBridge";
    }

    @Override // com.baidu.live.view.web.a
    public void iy(String str) {
        JSONObject jSONObject;
        if (this.schemeCallback != null) {
            String cuid = ExtraParamsManager.getInstance().buildParamsExtra().getCuid();
            if (TextUtils.isEmpty(cuid)) {
                this.schemeCallback.doJsCallback(0, "", null, str);
                return;
            }
            if (TextUtils.isEmpty(cuid)) {
                jSONObject = null;
            } else {
                try {
                    jSONObject = new JSONObject();
                    try {
                        jSONObject.put("cuid", cuid);
                    } catch (JSONException e) {
                        e = e;
                        e.printStackTrace();
                        this.schemeCallback.doJsCallback(1, "", jSONObject, str);
                    }
                } catch (JSONException e2) {
                    e = e2;
                    jSONObject = null;
                }
            }
            this.schemeCallback.doJsCallback(1, "", jSONObject, str);
        }
    }
}
