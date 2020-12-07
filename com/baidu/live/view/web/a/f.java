package com.baidu.live.view.web.a;

import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.extraparams.ResultCallback;
import com.baidu.live.tbadk.scheme.SchemeCallback;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class f extends com.baidu.live.view.web.a {
    private SchemeCallback bRj;

    public f(SchemeCallback schemeCallback) {
        this.bRj = schemeCallback;
    }

    @Override // com.baidu.live.view.web.a
    public String getName() {
        return "loginBridge";
    }

    @Override // com.baidu.live.view.web.a
    public void jm(final String str) {
        if (this.bRj != null) {
            ExtraParamsManager.addLoginCallback(new ResultCallback() { // from class: com.baidu.live.view.web.a.f.1
                @Override // com.baidu.live.tbadk.extraparams.ResultCallback
                public void onCallback(JSONObject jSONObject) {
                    f.this.bRj.doJsCallback(jSONObject.optBoolean("status") ? 1 : 0, "", null, str);
                }
            });
        }
        ViewHelper.skipToLoginActivity(TbadkCoreApplication.getInst());
    }
}
