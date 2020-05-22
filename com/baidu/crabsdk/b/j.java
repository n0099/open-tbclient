package com.baidu.crabsdk.b;

import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.crabsdk.CrabSDK;
import com.baidu.crabsdk.OnUploadFilesCallback;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.tbadk.TbConfig;
import com.vivo.push.PushClientConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes8.dex */
public final class j {
    public static JSONObject a(String str, OnUploadFilesCallback onUploadFilesCallback, String str2, String str3, String str4) {
        JSONObject jSONObject;
        try {
            byte[] dL = com.baidu.crabsdk.sender.i.dL(str);
            if (dL == null || dL.length == 0) {
                onUploadFilesCallback.onFailed("Read file error!");
                jSONObject = null;
            } else {
                String encodeToString = Base64.encodeToString(dL, 0);
                jSONObject = a(str2, str3, str4);
                jSONObject.put(IjkMediaMeta.IJKM_KEY_FORMAT, 1);
                jSONObject.put(TbConfig.TMP_LOG_DIR_NAME, encodeToString);
                jSONObject.put("fileName", str.substring(str.lastIndexOf("/") + 1));
            }
            return jSONObject;
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.a("wrap trace to anrRecord error!", e);
            onUploadFilesCallback.onFailed(e.getMessage());
            return null;
        } catch (OutOfMemoryError e2) {
            com.baidu.crabsdk.c.a.a("OutOfMemoryError!", e2);
            onUploadFilesCallback.onFailed(e2.getMessage());
            return null;
        }
    }

    private static JSONObject a(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("recordId", System.currentTimeMillis() + UUID.randomUUID().toString());
            jSONObject.put("appKey", com.baidu.crabsdk.a.d);
            jSONObject.put("phoneTime", System.currentTimeMillis());
            jSONObject.put("networkInfo", o.H());
            jSONObject.put(BdStatsConstant.StatsKey.UNAME, t.getUserName());
            jSONObject.put("uid", t.sP());
            jSONObject.put("batVN", "7.5.1");
            jSONObject.put("nativeVN", CrabSDK.NDK_VERSION);
            jSONObject.put("isRoot", q.sN());
            jSONObject.put(PushClientConstants.TAG_PKG_NAME, p.J());
            jSONObject.put("appLabel", p.sL());
            if (TextUtils.isEmpty(com.baidu.crabsdk.a.o)) {
                jSONObject.put("appVN", p.L());
            } else {
                jSONObject.put("appVN", com.baidu.crabsdk.a.o);
            }
            jSONObject.put("appVC", p.sM());
            jSONObject.put("model", Build.MODEL);
            jSONObject.put(Constants.PHONE_BRAND, Build.BRAND);
            jSONObject.put("os", "Android");
            jSONObject.put("osVN", Build.VERSION.RELEASE);
            jSONObject.put("osVC", Build.VERSION.SDK_INT);
            jSONObject.put("startupTime", a.p());
            jSONObject.put("curPage", a.r());
            jSONObject.put("locale", i.B());
            jSONObject.put("cuid", h.z());
            jSONObject.put("channel", com.baidu.crabsdk.a.b);
            jSONObject.put("cpuabi", Build.CPU_ABI);
            jSONObject.put("romVN", str);
            jSONObject.put("launcherVN", str2);
            jSONObject.put("type", str3);
            if (!TextUtils.isEmpty(t.T())) {
                jSONObject.put("usersCustom", t.T());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
