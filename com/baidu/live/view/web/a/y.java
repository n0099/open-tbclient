package com.baidu.live.view.web.a;

import android.text.TextUtils;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.scheme.SchemeCallback;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class y extends com.baidu.live.view.web.a {
    private SchemeCallback schemeCallback;

    public y(SchemeCallback schemeCallback) {
        this.schemeCallback = schemeCallback;
    }

    @Override // com.baidu.live.view.web.a
    public String getName() {
        return "zidBridge";
    }

    @Override // com.baidu.live.view.web.a
    public void is(String str) {
        JSONObject jSONObject;
        if (this.schemeCallback != null) {
            String baiduzid = ExtraParamsManager.getBaiduzid();
            if (TextUtils.isEmpty(baiduzid)) {
                this.schemeCallback.doJsCallback(0, "", null, str);
                return;
            }
            if (TextUtils.isEmpty(baiduzid)) {
                jSONObject = null;
            } else {
                try {
                    jSONObject = new JSONObject();
                } catch (JSONException e) {
                    e = e;
                    jSONObject = null;
                }
                try {
                    jSONObject.put("zid", baiduzid);
                } catch (JSONException e2) {
                    e = e2;
                    e.printStackTrace();
                    this.schemeCallback.doJsCallback(1, "", jSONObject, str);
                }
            }
            this.schemeCallback.doJsCallback(1, "", jSONObject, str);
        }
    }
}
