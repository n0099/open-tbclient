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
@UpdateAction(action = DownloadRecommendDialogListener.ACTION, module = "download")
/* loaded from: classes3.dex */
public class DownloadRecommendDialogListener extends AbstractCommandListener<DownloadRecommendDialogModel> {
    public static final String ACTION = "showDownloadDialog";
    public static final String DEFAULT_VERSION = "0";
    public static final String OFFLINE_VERSION = "-1";
    public static final String VERSION = "showDownloadDialog_v";
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String TAG = DownloadRecommendDialogListener.class.getSimpleName();

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
    public boolean executeCommand(Context context, String str, String str2, ActionData<DownloadRecommendDialogModel> actionData) {
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
        DownloadRecommendDialogModel downloadRecommendDialogModel = actionData.data;
        if (downloadRecommendDialogModel == null || TextUtils.equals(str4, localVersion)) {
            return false;
        }
        if (!TextUtils.isEmpty(downloadRecommendDialogModel.dialogSwitch)) {
            DownloadSharedPrefsUtils.getInstance().putString(DownloadRecommendConstants.DIALOG_SWITCH_KEY, downloadRecommendDialogModel.dialogSwitch);
        }
        if (!TextUtils.isEmpty(downloadRecommendDialogModel.enableAppsearchLite)) {
            DownloadSharedPrefsUtils.getInstance().putString(DownloadRecommendConstants.ENABLE_APPSEARCH_LITE_KEY, downloadRecommendDialogModel.enableAppsearchLite);
        }
        if (!TextUtils.isEmpty(downloadRecommendDialogModel.appsearchLiteRecomendUrl)) {
            DownloadSharedPrefsUtils.getInstance().putString(DownloadRecommendConstants.APPSEARCH_LITE_RECOMMEND_URL_KEY, downloadRecommendDialogModel.appsearchLiteRecomendUrl);
        }
        if (!TextUtils.isEmpty(downloadRecommendDialogModel.appsearchCloudStatic)) {
            DownloadSharedPrefsUtils.getInstance().putString(DownloadRecommendConstants.APPSEARCH_CLOUD_STATIC_KEY, downloadRecommendDialogModel.appsearchCloudStatic);
        }
        DownloadSharedPrefsUtils.getInstance().putString(VERSION, str4);
        return true;
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public String getLocalVersion(Context context, String str, String str2) {
        return DownloadSharedPrefsUtils.getInstance().getString(VERSION, "0");
    }
}
