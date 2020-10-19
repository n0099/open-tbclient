package com.baidu.clientupdate.d;

import com.baidu.clientupdate.appinfo.AppInfo;
import com.baidu.clientupdate.appinfo.ClientUpdateInfo;
import com.baidu.clientupdate.appinfo.RuleInfo;
import org.json.JSONObject;
/* loaded from: classes17.dex */
public final class h {
    /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: com.baidu.clientupdate.appinfo.ClientUpdateInfo */
    /* JADX WARN: Multi-variable type inference failed */
    public static AppInfo a(JSONObject jSONObject, int i) {
        RuleInfo ruleInfo;
        RuleInfo ruleInfo2 = null;
        ruleInfo2 = null;
        if (jSONObject != null) {
            if (i == 0) {
                ClientUpdateInfo clientUpdateInfo = new ClientUpdateInfo();
                clientUpdateInfo.mIsForceUpdate = jSONObject.optString("isforce");
                clientUpdateInfo.mContentUrl = jSONObject.optString("content_url");
                ruleInfo = clientUpdateInfo;
            } else if (3 == i) {
                RuleInfo ruleInfo3 = new RuleInfo();
                ruleInfo3.mUpgradeid = jSONObject.optString("upgradeid");
                ruleInfo3.mLevel = jSONObject.optString("level");
                ruleInfo3.mSilentDown = jSONObject.optString("silent_down");
                ruleInfo3.mCategory = jSONObject.optString("category");
                ruleInfo3.mRemind = jSONObject.optString("remind");
                ruleInfo3.mRemindTime = jSONObject.optString("remind_time");
                ruleInfo3.mRemindPoint = jSONObject.optString("remind_point");
                ruleInfo3.mRemindPlace = jSONObject.optString("remind_place");
                ruleInfo3.mNetwork = jSONObject.optString("network");
                ruleInfo3.mWifi = jSONObject.optString("wifi");
                ruleInfo3.mGprs = jSONObject.optString("gprs");
                ruleInfo3.mVisitInterface = jSONObject.optString("visit_interface");
                ruleInfo3.mAutoDownload = jSONObject.optString("auto_download");
                ruleInfo3.mRuleid = jSONObject.optString("ruleid");
                ruleInfo3.mUpgradeid = jSONObject.optString("upgradeid");
                ruleInfo3.mContentUrl = jSONObject.optString("content_url");
                ruleInfo = ruleInfo3;
            }
            ruleInfo.mSname = jSONObject.optString("label");
            ruleInfo.mChangelog = jSONObject.optString("changelog");
            ruleInfo.mSign = jSONObject.optString("sign");
            ruleInfo.mProdline = jSONObject.optString("prodline");
            ruleInfo.mDownurl = jSONObject.optString("downurl");
            ruleInfo.mVername = jSONObject.optString("vname");
            ruleInfo.mVercode = jSONObject.optString("vcode");
            ruleInfo.mSignMd5 = jSONObject.optString("signmd5");
            ruleInfo.mApkMd5 = jSONObject.optString("apkmd5");
            ruleInfo.mSize = jSONObject.optString("size");
            ruleInfo.mPatchDownUrl = jSONObject.optString("patch_downurl");
            ruleInfo.mPatchSize = jSONObject.optString("patch_size");
            ruleInfo.mIconUrl = jSONObject.optString("iconurl");
            ruleInfo.mPackageName = jSONObject.optString("packagename");
            ruleInfo.mUpdateTime = jSONObject.optString("update_time");
            ruleInfo2 = ruleInfo;
        }
        return ruleInfo2;
    }
}
