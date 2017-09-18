package com.baidu.tbadk.browser;

import android.os.Build;
import com.baidu.adp.lib.util.i;
import com.baidu.adp.lib.util.k;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.hybrid.p;
import com.baidu.tbadk.core.hybrid.t;
import com.baidu.tbadk.core.hybrid.u;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c extends t {
    public c(p pVar) {
        super(pVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.hybrid.t
    public String oc() {
        return "TBHY_COMMON_Utils";
    }

    @u(ua = false, value = "showToast")
    private void showToast(JSONObject jSONObject) {
        if (jSONObject != null) {
            BdToast.a(getContext(), jSONObject.optString(PushConstants.EXTRA_PUSH_MESSAGE)).tw();
        }
    }

    @u(ua = false, value = "showNetStatus")
    private JSONObject showNetStatus() {
        JSONObject jSONObject = new JSONObject();
        int i = 0;
        String str = "NotReachable";
        if (i.hj()) {
            i = 1;
            str = "WIFI";
        } else if (i.hn()) {
            i = 3;
            str = "2G";
        } else if (i.hm()) {
            i = 4;
            str = "3G";
        } else if (i.hl()) {
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

    @u(ua = false, value = "showDeviceInfo")
    private JSONObject showDeviceInfo() {
        JSONObject jSONObject = new JSONObject();
        String cuid = TbadkCoreApplication.getInst().getCuid();
        String str = Build.VERSION.RELEASE;
        String str2 = Build.MODEL;
        String str3 = String.valueOf(k.ae(getContext())) + Constants.ACCEPT_TIME_SEPARATOR_SP + String.valueOf(k.af(getContext()));
        String versionName = TbadkCoreApplication.getInst().getVersionName();
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
