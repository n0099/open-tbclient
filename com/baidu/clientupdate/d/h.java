package com.baidu.clientupdate.d;

import androidx.core.app.NotificationCompatJellybean;
import com.baidu.clientupdate.appinfo.AppInfo;
import com.baidu.clientupdate.appinfo.ClientUpdateInfo;
import com.baidu.clientupdate.appinfo.RuleInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Multi-variable search result rejected for r5v3, resolved type: com.baidu.clientupdate.appinfo.ClientUpdateInfo */
    /* JADX WARN: Multi-variable type inference failed */
    public static AppInfo a(JSONObject jSONObject, int i2) {
        InterceptResult invokeLI;
        RuleInfo ruleInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65536, null, jSONObject, i2)) == null) {
            if (jSONObject == null) {
                return null;
            }
            if (i2 == 0) {
                ClientUpdateInfo clientUpdateInfo = new ClientUpdateInfo();
                clientUpdateInfo.mIsForceUpdate = jSONObject.optString("isforce");
                clientUpdateInfo.mContentUrl = jSONObject.optString("content_url");
                ruleInfo = clientUpdateInfo;
            } else if (3 != i2) {
                return null;
            } else {
                RuleInfo ruleInfo2 = new RuleInfo();
                ruleInfo2.mUpgradeid = jSONObject.optString("upgradeid");
                ruleInfo2.mLevel = jSONObject.optString("level");
                ruleInfo2.mSilentDown = jSONObject.optString("silent_down");
                ruleInfo2.mCategory = jSONObject.optString("category");
                ruleInfo2.mRemind = jSONObject.optString("remind");
                ruleInfo2.mRemindTime = jSONObject.optString("remind_time");
                ruleInfo2.mRemindPoint = jSONObject.optString("remind_point");
                ruleInfo2.mRemindPlace = jSONObject.optString("remind_place");
                ruleInfo2.mNetwork = jSONObject.optString("network");
                ruleInfo2.mWifi = jSONObject.optString("wifi");
                ruleInfo2.mGprs = jSONObject.optString("gprs");
                ruleInfo2.mVisitInterface = jSONObject.optString("visit_interface");
                ruleInfo2.mAutoDownload = jSONObject.optString("auto_download");
                ruleInfo2.mRuleid = jSONObject.optString("ruleid");
                ruleInfo2.mUpgradeid = jSONObject.optString("upgradeid");
                ruleInfo2.mContentUrl = jSONObject.optString("content_url");
                ruleInfo = ruleInfo2;
            }
            ruleInfo.mSname = jSONObject.optString(NotificationCompatJellybean.KEY_LABEL);
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
            return ruleInfo;
        }
        return (AppInfo) invokeLI.objValue;
    }
}
