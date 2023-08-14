package com.baidu.searchbox.permission;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.w2b;
import com.baidu.ubc.UBCManager;
import com.kuaishou.weapon.p0.h;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class DangerousPermissionOpenInfoUtil {
    public static void statisticPermissionForStorage() {
        statisticPermission(new String[]{h.i, "android.permission.WRITE_EXTERNAL_STORAGE"}, "storage");
    }

    public static void statisticPermission(String[] strArr, String str) {
        String str2;
        boolean isPermissionGroupGranted = DangerousPermissionManager.isPermissionGroupGranted(AppRuntime.getAppContext(), strArr);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", "tool");
            jSONObject.put("page", str);
            if (isPermissionGroupGranted) {
                str2 = "agree";
            } else {
                str2 = "disagree";
            }
            jSONObject.put("type", str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ((w2b) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent("2505", jSONObject.toString());
    }
}
