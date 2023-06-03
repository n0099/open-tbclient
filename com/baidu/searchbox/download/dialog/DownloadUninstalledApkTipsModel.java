package com.baidu.searchbox.download.dialog;

import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.download.constants.DownloadRecommendConstants;
import com.google.gson.annotations.SerializedName;
/* loaded from: classes3.dex */
public class DownloadUninstalledApkTipsModel implements NoProGuard {
    @SerializedName(DownloadRecommendConstants.UNINSTALLED_APK_TIPS_SHOW_TIMES_CYCLE_INTERVAL)
    public String remindIntervalCycle;
    @SerializedName(DownloadRecommendConstants.UNINSTALLED_APK_TIPS_SHOW_TIMES_DAY_INTERVAL)
    public String remindIntervalDay;
    @SerializedName(DownloadRecommendConstants.UNINSTALLED_APK_TIPS_SHOW_MAX_TIMES)
    public String remindMaxTimes;
    @SerializedName(DownloadRecommendConstants.UNINSTALLED_APK_TIPS_SHOW_TIMES_TODAY_MAX)
    public String remindTimesPerDay;
}
