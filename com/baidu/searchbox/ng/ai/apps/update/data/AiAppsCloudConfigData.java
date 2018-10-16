package com.baidu.searchbox.ng.ai.apps.update.data;

import android.content.Intent;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.launch.model.AiAppsLaunchInfo;
/* loaded from: classes2.dex */
public class AiAppsCloudConfigData {
    public static final boolean DEBUG = false;
    public static final String INTENT_KEY_CROSS_DOMAIN = "cross_domain_switch";
    public static final String TAG = AiAppsCloudConfigData.class.getSimpleName();
    public static final String VALUE_ONE = "1";
    public static final String VALUE_ZERO = "0";
    private String mCrossDomain = "0";

    public void setCloudConfigData(Intent intent) {
        if (intent != null) {
            this.mCrossDomain = intent.getStringExtra(INTENT_KEY_CROSS_DOMAIN);
        }
    }

    public void setCloudConfigData(AiAppsLaunchInfo aiAppsLaunchInfo) {
        if (aiAppsLaunchInfo != null && aiAppsLaunchInfo.mExtraData != null) {
            this.mCrossDomain = aiAppsLaunchInfo.mExtraData.getString(INTENT_KEY_CROSS_DOMAIN);
        }
    }

    public String getAllowCrossOriginSwitch() {
        return this.mCrossDomain;
    }

    public boolean isCrossOriginAllowed() {
        return TextUtils.equals(this.mCrossDomain, "1");
    }
}
