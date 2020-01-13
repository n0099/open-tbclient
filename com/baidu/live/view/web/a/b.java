package com.baidu.live.view.web.a;

import android.text.TextUtils;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.scheme.SchemeCallback;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends com.baidu.live.view.web.a {
    private SchemeCallback aCp;

    public b(SchemeCallback schemeCallback) {
        this.aCp = schemeCallback;
    }

    @Override // com.baidu.live.view.web.a
    public String getName() {
        return "cuidBridge";
    }

    @Override // com.baidu.live.view.web.a
    public void dV(String str) {
        JSONObject jSONObject;
        JSONException e;
        if (this.aCp != null) {
            String cuid = ExtraParamsManager.getInstance().buildParamsExtra().getCuid();
            if (TextUtils.isEmpty(cuid)) {
                this.aCp.doJsCallback(0, "", null, str);
                return;
            }
            if (TextUtils.isEmpty(cuid)) {
                jSONObject = null;
            } else {
                try {
                    jSONObject = new JSONObject();
                    try {
                        jSONObject.put("cuid", cuid);
                    } catch (JSONException e2) {
                        e = e2;
                        e.printStackTrace();
                        this.aCp.doJsCallback(1, "", jSONObject, str);
                    }
                } catch (JSONException e3) {
                    jSONObject = null;
                    e = e3;
                }
            }
            this.aCp.doJsCallback(1, "", jSONObject, str);
        }
    }
}
