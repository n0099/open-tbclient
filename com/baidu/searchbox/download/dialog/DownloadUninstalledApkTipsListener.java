package com.baidu.searchbox.download.dialog;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.download.constants.DownloadRecommendConstants;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.searchbox.net.update.v2.AbstractCommandListener;
import com.baidu.searchbox.net.update.v2.ActionData;
import com.baidu.searchbox.net.update.v2.UpdateAction;
import org.json.JSONException;
@UpdateAction(action = DownloadUninstalledApkTipsListener.ACTION, module = "download")
/* loaded from: classes3.dex */
public class DownloadUninstalledApkTipsListener extends AbstractCommandListener<DownloadUninstalledApkTipsModel> {
    public static final String ACTION = "install_tips";
    public static final String DEFAULT_VERSION = "0";
    public static final String OFFLINE_VERSION = "-1";
    public static final String VERSION = "download_install_tips_v";
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String TAG = DownloadUninstalledApkTipsListener.class.getSimpleName();

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public void addPostData(Context context, String str, String str2, CommandPostData commandPostData) throws JSONException {
        String localVersion = getLocalVersion(context, str, str2);
        if (commandPostData != null && commandPostData.getVersion() != null) {
            commandPostData.getVersion().put(ACTION, localVersion);
        }
        if (DEBUG) {
            String str3 = TAG;
            Log.v(str3, TAG + " request params: " + ACTION + "=" + localVersion);
        }
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public boolean executeCommand(Context context, String str, String str2, ActionData<DownloadUninstalledApkTipsModel> actionData) {
        if (DEBUG) {
            String str3 = TAG;
            Log.d(str3, TAG + " action is : " + str2);
        }
        if (actionData == null || !TextUtils.equals(str2, ACTION)) {
            return false;
        }
        String str4 = actionData.version;
        if (TextUtils.isEmpty(str4)) {
            return false;
        }
        String localVersion = getLocalVersion(context, str, str2);
        DownloadUninstalledApkTipsModel downloadUninstalledApkTipsModel = actionData.data;
        if (downloadUninstalledApkTipsModel == null || TextUtils.equals(str4, localVersion)) {
            return false;
        }
        if (!TextUtils.isEmpty(downloadUninstalledApkTipsModel.remindTimesPerDay)) {
            DownloadSharedPrefsUtils.getInstance().putLong(DownloadRecommendConstants.UNINSTALLED_APK_TIPS_SHOW_TIMES_TODAY_MAX, Long.valueOf(downloadUninstalledApkTipsModel.remindTimesPerDay).longValue());
        }
        if (!TextUtils.isEmpty(downloadUninstalledApkTipsModel.remindIntervalDay)) {
            DownloadSharedPrefsUtils.getInstance().putLong(DownloadRecommendConstants.UNINSTALLED_APK_TIPS_SHOW_TIMES_DAY_INTERVAL, Long.valueOf(downloadUninstalledApkTipsModel.remindIntervalDay).longValue());
        }
        if (!TextUtils.isEmpty(downloadUninstalledApkTipsModel.remindMaxTimes)) {
            DownloadSharedPrefsUtils.getInstance().putLong(DownloadRecommendConstants.UNINSTALLED_APK_TIPS_SHOW_MAX_TIMES, Long.valueOf(downloadUninstalledApkTipsModel.remindMaxTimes).longValue());
        }
        if (!TextUtils.isEmpty(downloadUninstalledApkTipsModel.remindIntervalCycle)) {
            DownloadSharedPrefsUtils.getInstance().putLong(DownloadRecommendConstants.UNINSTALLED_APK_TIPS_SHOW_TIMES_CYCLE_INTERVAL, Long.valueOf(downloadUninstalledApkTipsModel.remindIntervalCycle).longValue());
        }
        DownloadSharedPrefsUtils.getInstance().putString(VERSION, str4);
        return true;
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public String getLocalVersion(Context context, String str, String str2) {
        return DownloadSharedPrefsUtils.getInstance().getString(VERSION, "0");
    }
}
