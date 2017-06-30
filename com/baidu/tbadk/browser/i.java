package com.baidu.tbadk.browser;

import android.os.Build;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class i extends com.baidu.tbadk.core.hybrid.w {
    /* JADX INFO: Access modifiers changed from: protected */
    public i(com.baidu.tbadk.core.hybrid.s sVar) {
        super(sVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.hybrid.w
    public String nT() {
        return "TBHY_COMMON_Utils";
    }

    @com.baidu.tbadk.core.hybrid.x(tN = false, value = "showToast")
    private void showToast(JSONObject jSONObject) {
        if (jSONObject != null) {
            BdToast.a(getContext(), jSONObject.optString(PushConstants.EXTRA_PUSH_MESSAGE)).ti();
        }
    }

    @com.baidu.tbadk.core.hybrid.x(tN = false, value = "showNetStatus")
    private JSONObject showNetStatus() {
        JSONObject jSONObject = new JSONObject();
        int i = 0;
        String str = "NotReachable";
        if (com.baidu.adp.lib.util.i.hk()) {
            i = 1;
            str = "WIFI";
        } else if (com.baidu.adp.lib.util.i.ho()) {
            i = 3;
            str = "2G";
        } else if (com.baidu.adp.lib.util.i.hn()) {
            i = 4;
            str = "3G";
        } else if (com.baidu.adp.lib.util.i.hm()) {
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

    @com.baidu.tbadk.core.hybrid.x(tN = false, value = "showDeviceInfo")
    private JSONObject showDeviceInfo() {
        JSONObject jSONObject = new JSONObject();
        String cuid = TbadkCoreApplication.m9getInst().getCuid();
        String str = Build.VERSION.RELEASE;
        String str2 = Build.MODEL;
        String str3 = String.valueOf(String.valueOf(com.baidu.adp.lib.util.k.af(getContext()))) + Constants.ACCEPT_TIME_SEPARATOR_SP + String.valueOf(com.baidu.adp.lib.util.k.ag(getContext()));
        String versionName = TbadkCoreApplication.m9getInst().getVersionName();
        try {
            jSONObject.put("systemName", "android");
            jSONObject.put("systemVersion", str);
            jSONObject.put("model", str2);
            jSONObject.put("cuid", cuid);
            jSONObject.put("resolution", str3);
            jSONObject.put("appVersion", versionName);
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
