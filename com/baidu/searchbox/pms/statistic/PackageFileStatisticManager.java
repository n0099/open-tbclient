package com.baidu.searchbox.pms.statistic;

import android.content.Context;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.pms.utils.DebugUtils;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class PackageFileStatisticManager {
    public static final String TAG = "pmsPackageFileStatistic";
    public static volatile PackageFileStatisticManager sInstance;
    public Context mContext;

    /* loaded from: classes4.dex */
    public static class Code {
        public static final int DOWNLOAD_RESULT_CODE_CANCEL = 4;
        public static final int DOWNLOAD_RESULT_CODE_FRONT_FAILED = 21;
        public static final int DOWNLOAD_RESULT_CODE_INIT = 5;
        public static final int DOWNLOAD_RESULT_CODE_RETRY_FAILED = 3;
        public static final int DOWNLOAD_RESULT_CODE_SILENT_FAILED = 22;
        public static final int DOWNLOAD_RESULT_CODE_SUCCESS = 1;
        public static final int DOWNLOAD_START_CODE_FRONT = 1;
        public static final int DOWNLOAD_START_CODE_SILENT = 2;
    }

    public PackageFileStatisticManager(Context context) {
        this.mContext = context;
    }

    public static PackageFileStatisticManager getInstance() {
        if (sInstance == null) {
            synchronized (PackageFileStatisticManager.class) {
                if (sInstance == null) {
                    sInstance = new PackageFileStatisticManager(AppRuntime.getApplication());
                }
            }
        }
        return sInstance;
    }

    public void addDownloadStatistic2(int i, String str, String str2, String str3, long j, String str4, String str5, int i2, int i3) {
        if (!StatisticCallbackManager.getInstance(this.mContext).getStatisticCallback().addDownloadStatistic2(i, str, str2, str3, j, str4, str5, i2, i3)) {
            DebugUtils.log("Host Cannot Handle the addDownloadStatistic2 Callback");
        }
    }

    public void addFetchStatistic2(int i, String str, String str2, JSONObject jSONObject) {
        if (!StatisticCallbackManager.getInstance(this.mContext).getStatisticCallback().addFetchStatistic2InHost(i, str, str2, jSONObject)) {
            DebugUtils.log("Host Cannot Handle the addFetchStatistic2 Callback");
        }
    }
}
