package com.baidu.live.view.web.a;

import android.text.TextUtils;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.scheme.SchemeCallback;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class k extends com.baidu.live.view.web.a {
    private SchemeCallback bkf;

    public k(SchemeCallback schemeCallback) {
        this.bkf = schemeCallback;
    }

    @Override // com.baidu.live.view.web.a
    public String getName() {
        return "zidBridge";
    }

    @Override // com.baidu.live.view.web.a
    public void fO(String str) {
        JSONObject jSONObject;
        JSONException e;
        if (this.bkf != null) {
            String baiduzid = ExtraParamsManager.getBaiduzid();
            if (TextUtils.isEmpty(baiduzid)) {
                this.bkf.doJsCallback(0, "", null, str);
                return;
            }
            if (TextUtils.isEmpty(baiduzid)) {
                jSONObject = null;
            } else {
                try {
                    jSONObject = new JSONObject();
                } catch (JSONException e2) {
                    jSONObject = null;
                    e = e2;
                }
                try {
                    jSONObject.put("zid", baiduzid);
                } catch (JSONException e3) {
                    e = e3;
                    e.printStackTrace();
                    this.bkf.doJsCallback(1, "", jSONObject, str);
                }
            }
            this.bkf.doJsCallback(1, "", jSONObject, str);
        }
    }
}
