package com.baidu.crabsdk.b;

import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.crabsdk.CrabSDK;
import com.baidu.crabsdk.OnUploadFilesCallback;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.tbadk.TbConfig;
import com.vivo.push.PushClientConstants;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class j {
    public static JSONObject a(String str, OnUploadFilesCallback onUploadFilesCallback, String str2, String str3, String str4) {
        String message;
        try {
            byte[] l = com.baidu.crabsdk.sender.i.l(str);
            if (l != null && l.length != 0) {
                String encodeToString = Base64.encodeToString(l, 0);
                JSONObject b2 = b(str2, str3, str4);
                b2.put("format", 1);
                b2.put(TbConfig.TMP_LOG_DIR_NAME, encodeToString);
                b2.put("fileName", str.substring(str.lastIndexOf("/") + 1));
                return b2;
            }
            onUploadFilesCallback.onFailed("Read file error!");
            return null;
        } catch (Exception e2) {
            com.baidu.crabsdk.c.a.a("wrap trace to anrRecord error!", e2);
            message = e2.getMessage();
            onUploadFilesCallback.onFailed(message);
            return null;
        } catch (OutOfMemoryError e3) {
            com.baidu.crabsdk.c.a.a("OutOfMemoryError!", e3);
            message = e3.getMessage();
            onUploadFilesCallback.onFailed(message);
            return null;
        }
    }

    public static JSONObject b(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("recordId", System.currentTimeMillis() + UUID.randomUUID().toString());
            jSONObject.put("appKey", com.baidu.crabsdk.a.f4782d);
            jSONObject.put("phoneTime", System.currentTimeMillis());
            jSONObject.put("networkInfo", o.a());
            jSONObject.put("uname", t.g());
            jSONObject.put("uid", t.a());
            jSONObject.put("batVN", "7.5.1");
            jSONObject.put("nativeVN", CrabSDK.NDK_VERSION);
            jSONObject.put("isRoot", q.a());
            jSONObject.put(PushClientConstants.TAG_PKG_NAME, p.a());
            jSONObject.put("appLabel", p.b());
            jSONObject.put("appVN", !TextUtils.isEmpty(com.baidu.crabsdk.a.o) ? com.baidu.crabsdk.a.o : p.c());
            jSONObject.put("appVC", p.d());
            jSONObject.put("model", Build.MODEL);
            jSONObject.put("brand", Build.BRAND);
            jSONObject.put(IAdRequestParam.OS, "Android");
            jSONObject.put("osVN", Build.VERSION.RELEASE);
            jSONObject.put("osVC", Build.VERSION.SDK_INT);
            jSONObject.put("startupTime", a.g());
            jSONObject.put("curPage", a.i());
            jSONObject.put("locale", i.b());
            jSONObject.put("cuid", h.c());
            jSONObject.put("channel", com.baidu.crabsdk.a.f4780b);
            jSONObject.put("cpuabi", Build.CPU_ABI);
            jSONObject.put("romVN", str);
            jSONObject.put("launcherVN", str2);
            jSONObject.put("type", str3);
            if (!TextUtils.isEmpty(t.c())) {
                jSONObject.put("usersCustom", t.c());
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }
}
