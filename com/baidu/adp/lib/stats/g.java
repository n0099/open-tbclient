package com.baidu.adp.lib.stats;

import android.os.Build;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.ala.helper.AlaLiveBaseInfo;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g {
    private String Mi;
    private String Mj;
    private Map<String, String> Mk;
    private String mAction;
    private c mCommonData;
    private String mErrorCode;
    private String mErrorMessage;
    private String mId;
    private String mTitle;

    public void b(c cVar) {
        this.mCommonData = cVar;
    }

    public void bU(String str) {
        this.Mi = str;
    }

    public void setAction(String str) {
        this.mAction = str;
    }

    public void setErrorCode(String str) {
        this.mErrorCode = str;
    }

    public void setErrorMessage(String str) {
        this.mErrorMessage = str;
    }

    public void x(String str, String str2) {
        if (this.Mk == null) {
            this.Mk = new HashMap();
        }
        this.Mk.put(str, str2);
    }

    public JSONObject lt() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (this.mCommonData != null) {
                jSONObject2.put("app_version", this.mCommonData.mAppVersion);
                jSONObject2.put("client_timestamp", Long.toString(System.currentTimeMillis()));
                jSONObject2.put("cuid", this.mCommonData.mCuid);
                jSONObject2.put("shoubai_cuid", this.mCommonData.LK);
                jSONObject2.put("from", this.mCommonData.mChannel);
                jSONObject2.put("uid", this.mCommonData.mUid);
            }
            jSONObject2.put("client_ip", f.getClientIp());
            jSONObject2.put("network", lu());
            jSONObject2.put("model", Build.MODEL);
            jSONObject2.put(Constants.PHONE_BRAND, Build.BRAND);
            jSONObject2.put(HttpConstants.HTTP_OS_TYPE, AlaLiveBaseInfo.mOSType);
            jSONObject2.put("os_version", Build.VERSION.RELEASE);
            jSONObject2.put("active_id", f.lr());
            jSONObject2.put("mission_id", f.ls());
            jSONObject.put("base_info", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            if (this.Mi != null) {
                jSONObject3.put(BdStatsConstant.StatsKey.TYPE, this.Mi);
            }
            if (this.mAction != null) {
                jSONObject3.put("action", this.mAction);
            }
            if (this.mErrorCode != null) {
                jSONObject3.put("error_code", this.mErrorCode);
            }
            if (this.mErrorMessage != null) {
                jSONObject3.put("error_message", this.mErrorMessage);
            }
            if (this.Mk != null) {
                StringBuilder sb = new StringBuilder();
                for (Map.Entry<String, String> entry : this.Mk.entrySet()) {
                    sb.append(entry.getKey());
                    sb.append(":");
                    sb.append(entry.getValue());
                    sb.append("|");
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                jSONObject3.put("ext1", sb);
            }
            if (this.mId != null) {
                jSONObject3.put("id", this.mId);
            }
            if (this.mTitle != null) {
                jSONObject3.put("title", this.mTitle);
            }
            if (this.Mj != null) {
                jSONObject3.put("abstract", this.Mj);
            }
            jSONObject.put("debug_info", jSONObject3);
            jSONObject.put("kpi", new JSONObject());
        } catch (JSONException e) {
            BdLog.e(e);
        }
        return jSONObject;
    }

    public static String lu() {
        if (j.isWifiNet()) {
            return "WIFI";
        }
        if (j.is2GNet()) {
            return "2G";
        }
        if (j.is3GNet()) {
            return "3G";
        }
        if (!j.is4GNet() && !j.isNetWorkAvailable()) {
            return "NONE";
        }
        return "4G";
    }
}
