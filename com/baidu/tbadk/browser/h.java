package com.baidu.tbadk.browser;

import android.os.Build;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class h extends com.baidu.tbadk.core.d.p {
    /* JADX INFO: Access modifiers changed from: protected */
    public h(com.baidu.tbadk.core.d.n nVar) {
        super(nVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.d.p
    public String ob() {
        return "TBHY_COMMON_Utils";
    }

    @com.baidu.tbadk.core.d.q(ub = false, value = "showToast")
    private void showToast(JSONObject jSONObject) {
        if (jSONObject != null) {
            BdToast.a(getContext(), jSONObject.optString("message")).tA();
        }
    }

    @com.baidu.tbadk.core.d.q(ub = false, value = "showNetStatus")
    private JSONObject showNetStatus() {
        JSONObject jSONObject = new JSONObject();
        int i = 0;
        String str = "NotReachable";
        if (com.baidu.adp.lib.util.i.hf()) {
            i = 1;
            str = "WIFI";
        } else if (com.baidu.adp.lib.util.i.hj()) {
            i = 3;
            str = "2G";
        } else if (com.baidu.adp.lib.util.i.hi()) {
            i = 4;
            str = "3G";
        } else if (com.baidu.adp.lib.util.i.hh()) {
            i = 5;
            str = "4G";
        }
        try {
            jSONObject.put("netStatus", i);
            jSONObject.put("netDesc", str);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    @com.baidu.tbadk.core.d.q(ub = false, value = "showDeviceInfo")
    private JSONObject showDeviceInfo() {
        JSONObject jSONObject = new JSONObject();
        String cuid = TbadkCoreApplication.m9getInst().getCuid();
        String str = Build.VERSION.RELEASE;
        String str2 = Build.MODEL;
        String str3 = String.valueOf(String.valueOf(com.baidu.adp.lib.util.k.ag(getContext()))) + "," + String.valueOf(com.baidu.adp.lib.util.k.ah(getContext()));
        String versionName = TbadkCoreApplication.m9getInst().getVersionName();
        try {
            jSONObject.put("systemName", SocialConstants.ANDROID_CLIENT_TYPE);
            jSONObject.put("systemVersion", str);
            jSONObject.put("model", str2);
            jSONObject.put(SocialConstants.PARAM_CUID, cuid);
            jSONObject.put("resolution", str3);
            jSONObject.put("appVersion", versionName);
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
