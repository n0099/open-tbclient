package com.baidu.searchbox.ng.ai.apps.launch.model;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.AiAppsLauncherActivity;
import com.baidu.searchbox.ng.ai.apps.console.ConsolePrefsIPCWrapper;
import com.baidu.searchbox.ng.ai.apps.console.debugger.RemoteDebugger;
import com.baidu.searchbox.ng.ai.apps.runtime.config.AiAppsConfigData;
import com.baidu.searchbox.ng.ai.apps.swancore.model.SwanCoreVersion;
import com.baidu.searchbox.ng.ai.apps.util.AiAppImageUtils;
import com.baidu.searchbox.ng.ai.apps.util.AiAppIntentUtils;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUrlUtils;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class AiAppsLaunchInfo {
    public static final int DEVELOP = 1;
    public static final int ERROR_CODE_DEF_VALUE = 0;
    public static final String EXTRA_APP_ICON_KEY = "aiapps_icon";
    public static final String EXTRA_APP_ICON_URL_KEY = "aiapps_icon_url";
    public static final String EXTRA_APP_ID_KEY = "aiapps_app_id";
    public static final String EXTRA_APP_INIT_PARAMS_KEY = "aiapps_extra_data";
    public static final String EXTRA_APP_KEY_KEY = "aiapps_app_key";
    public static final String EXTRA_APP_TITLE_KEY = "aiapps_app_title";
    public static final String EXTRA_APP_ZIP_SIZE = "aiapps_app_zip_size";
    private static final String EXTRA_CONSOLE_SWITCH = "aiapps_app_console_switch";
    public static final String EXTRA_LAUNCH_AD_CLICK_ID = "aiapps_add_click_id";
    public static final String EXTRA_LAUNCH_APP_DOWNLOAD_URL = "aiapps_app_download_url";
    public static final String EXTRA_LAUNCH_APP_FRAME_TYPE = "aiapps_app_frame_type";
    public static final String EXTRA_LAUNCH_APP_OPEN_URL = "aiapps_app_open_url";
    public static final String EXTRA_LAUNCH_CUR_SWAN_VERSION = "aiapps_app_cur_swan_version";
    public static final String EXTRA_LAUNCH_DESCRIPTION_KEY = "aiapps_description";
    public static final String EXTRA_LAUNCH_ERROR_CODE_KEY = "aiapps_error_code";
    public static final String EXTRA_LAUNCH_ERROR_DETAIL_KEY = "aiapps_error_detail";
    public static final String EXTRA_LAUNCH_ERROR_MSG_KEY = "aiapps_error_msg";
    public static final String EXTRA_LAUNCH_FROM_KEY = "aiapps_launch_from";
    public static final String EXTRA_LAUNCH_IS_DEBUG_KEY = "aiapps_is_debug";
    public static final String EXTRA_LAUNCH_MAX_SWAN_VERSION = "aiapps_max_swan_version";
    public static final String EXTRA_LAUNCH_MIN_SWAN_VERSION = "aiapps_min_swan_version";
    public static final String EXTRA_LAUNCH_PAGE_KEY = "aiapps_page";
    public static final String EXTRA_LAUNCH_RESUME_DATE_KEY = "aiapps_resume_date";
    public static final String EXTRA_LAUNCH_SCHEME_KEY = "aiapps_launch_scheme";
    public static final String EXTRA_LAUNCH_SERVICE_CATEGORY = "aiapps_service_category";
    public static final String EXTRA_LAUNCH_SUBJECT_INFO = "aiapps_subject_info";
    public static final String EXTRA_LAUNCH_TYPE_KEY = "aiapps_type";
    public static final String EXTRA_LAUNCH_VERSION = "aiapps_version";
    public static final String EXTRA_NAVIGATE_BAR_COLOR_KEY = "aiapps_navigatebar_color";
    public static final String EXTRA_NOT_IN_HISTORY_KEY = "aiapps_not_in_history";
    private static final String EXTRA_REMOTE_DEBUG = "remoteDebug";
    public static final String EXTRA_SWAN_CORE_VERSION = "aiapps_swan_core_version";
    public static final String EXTRA_VERSION_CODE = "aiapps_version_code";
    public static final int FRAME_APPS = 0;
    public static final int FRAME_GAMES = 1;
    public static final long INVALID_COLOR = 2147483648L;
    public static final int ONLINE = 0;
    public static final String SCHEMA_BAIDUBOXAPP_KEY = "_baiduboxapp";
    public static final String SCHEMA_EXT_KEY = "ext";
    public static final int TRIAL = 2;
    public static final int TRIAL_EXPERIENCE = 3;
    public static final int TYPE_DEV = 1;
    public static final int TYPE_EXP = 3;
    public static final int TYPE_RELEASE = 0;
    public static final int TYPE_TRIAL = 2;
    public static final String TYPE_VERSION_DEF = "0";
    public String mAppDownloadUrl;
    public int mAppFrameType = 0;
    public Bitmap mAppIcon;
    public String mAppIconUrl;
    public String mAppId;
    public String mAppKey;
    public String mAppOpenUrl;
    public String mAppTitle;
    public long mAppZipSize;
    public String mClickId;
    public boolean mConsoleSwitch;
    public String mDescription;
    public int mErrorCode;
    public String mErrorDetail;
    public String mErrorMsg;
    public JSONObject mExtJSonObject;
    public Bundle mExtraData;
    public boolean mIsDebug;
    public String mLaunchFrom;
    public String mLaunchScheme;
    public String mMaxSwanVersion;
    public String mMinSwanVersion;
    public long mNavigateBarColor;
    public String mNotInHistory;
    public String mPage;
    public String mRemoteDebug;
    public String mResumeDate;
    public String mServiceCategory;
    public String mSubjectInfo;
    public SwanCoreVersion mSwanCoreVersion;
    public String mTargetSwanVersion;
    public int mType;
    public String mVersion;
    public String versionCode;

    public static AiAppsLaunchInfo createFromIntent(Intent intent) {
        if (intent == null) {
            throw new IllegalArgumentException("intent must not be null.");
        }
        AiAppsLaunchInfo aiAppsLaunchInfo = new AiAppsLaunchInfo();
        aiAppsLaunchInfo.mAppId = AiAppIntentUtils.safeGetStringExtra(intent, EXTRA_APP_ID_KEY);
        aiAppsLaunchInfo.mAppKey = AiAppIntentUtils.safeGetStringExtra(intent, EXTRA_APP_KEY_KEY);
        aiAppsLaunchInfo.mAppTitle = AiAppIntentUtils.safeGetStringExtra(intent, EXTRA_APP_TITLE_KEY);
        aiAppsLaunchInfo.mNavigateBarColor = AiAppIntentUtils.safeGetLongExtra(intent, EXTRA_NAVIGATE_BAR_COLOR_KEY, 2147483648L);
        aiAppsLaunchInfo.mAppIcon = AiAppImageUtils.decodeBitmapFromString(AiAppIntentUtils.safeGetStringExtra(intent, EXTRA_APP_ICON_KEY));
        aiAppsLaunchInfo.mAppIconUrl = AiAppIntentUtils.safeGetStringExtra(intent, EXTRA_APP_ICON_URL_KEY);
        if (AiAppsLaunchType.isLaunchFromRecent(intent)) {
            aiAppsLaunchInfo.mLaunchFrom = "8003";
        } else {
            aiAppsLaunchInfo.mLaunchFrom = AiAppIntentUtils.safeGetStringExtra(intent, "aiapps_launch_from");
        }
        aiAppsLaunchInfo.mLaunchScheme = AiAppIntentUtils.safeGetStringExtra(intent, EXTRA_LAUNCH_SCHEME_KEY);
        if (aiAppsLaunchInfo.mLaunchScheme != null) {
            String queryParameter = Uri.parse(aiAppsLaunchInfo.mLaunchScheme).getQueryParameter(SCHEMA_BAIDUBOXAPP_KEY);
            if (!TextUtils.isEmpty(queryParameter)) {
                try {
                    aiAppsLaunchInfo.mExtJSonObject = new JSONObject(queryParameter).optJSONObject("ext");
                } catch (JSONException e) {
                }
            }
        }
        aiAppsLaunchInfo.mPage = AiAppIntentUtils.safeGetStringExtra(intent, EXTRA_LAUNCH_PAGE_KEY);
        aiAppsLaunchInfo.mIsDebug = AiAppIntentUtils.safeGetBooleanExtra(intent, EXTRA_LAUNCH_IS_DEBUG_KEY, true);
        aiAppsLaunchInfo.mDescription = AiAppIntentUtils.safeGetStringExtra(intent, EXTRA_LAUNCH_DESCRIPTION_KEY);
        aiAppsLaunchInfo.mErrorCode = AiAppIntentUtils.safeGetIntExtra(intent, EXTRA_LAUNCH_ERROR_CODE_KEY, 0);
        aiAppsLaunchInfo.mErrorDetail = AiAppIntentUtils.safeGetStringExtra(intent, EXTRA_LAUNCH_ERROR_DETAIL_KEY);
        aiAppsLaunchInfo.mErrorMsg = AiAppIntentUtils.safeGetStringExtra(intent, EXTRA_LAUNCH_ERROR_MSG_KEY);
        aiAppsLaunchInfo.mResumeDate = AiAppIntentUtils.safeGetStringExtra(intent, EXTRA_LAUNCH_RESUME_DATE_KEY);
        aiAppsLaunchInfo.mMaxSwanVersion = AiAppIntentUtils.safeGetStringExtra(intent, EXTRA_LAUNCH_MAX_SWAN_VERSION);
        aiAppsLaunchInfo.mMinSwanVersion = AiAppIntentUtils.safeGetStringExtra(intent, EXTRA_LAUNCH_MIN_SWAN_VERSION);
        aiAppsLaunchInfo.mServiceCategory = AiAppIntentUtils.safeGetStringExtra(intent, EXTRA_LAUNCH_SERVICE_CATEGORY);
        aiAppsLaunchInfo.mSubjectInfo = AiAppIntentUtils.safeGetStringExtra(intent, EXTRA_LAUNCH_SUBJECT_INFO);
        aiAppsLaunchInfo.mVersion = AiAppIntentUtils.safeGetStringExtra(intent, EXTRA_LAUNCH_VERSION);
        aiAppsLaunchInfo.mExtraData = AiAppIntentUtils.safeGetBundleExtra(intent, EXTRA_APP_INIT_PARAMS_KEY);
        aiAppsLaunchInfo.mClickId = AiAppIntentUtils.safeGetStringExtra(intent, EXTRA_LAUNCH_AD_CLICK_ID);
        aiAppsLaunchInfo.mType = AiAppIntentUtils.safeGetIntExtra(intent, EXTRA_LAUNCH_TYPE_KEY, 0);
        aiAppsLaunchInfo.mNotInHistory = AiAppIntentUtils.safeGetStringExtra(intent, "aiapps_not_in_history");
        aiAppsLaunchInfo.mAppOpenUrl = AiAppIntentUtils.safeGetStringExtra(intent, EXTRA_LAUNCH_APP_OPEN_URL);
        aiAppsLaunchInfo.mAppDownloadUrl = AiAppIntentUtils.safeGetStringExtra(intent, EXTRA_LAUNCH_APP_DOWNLOAD_URL);
        aiAppsLaunchInfo.mTargetSwanVersion = AiAppIntentUtils.safeGetStringExtra(intent, EXTRA_LAUNCH_CUR_SWAN_VERSION);
        aiAppsLaunchInfo.mSwanCoreVersion = (SwanCoreVersion) AiAppIntentUtils.safeGetParcelableExtra(intent, EXTRA_SWAN_CORE_VERSION);
        aiAppsLaunchInfo.mAppZipSize = AiAppIntentUtils.safeGetLongExtra(intent, EXTRA_APP_ZIP_SIZE, 0L);
        aiAppsLaunchInfo.mAppFrameType = AiAppIntentUtils.safeGetIntExtra(intent, "aiapps_app_frame_type", 0);
        aiAppsLaunchInfo.mConsoleSwitch = AiAppIntentUtils.safeGetBooleanExtra(intent, EXTRA_CONSOLE_SWITCH, false);
        aiAppsLaunchInfo.versionCode = AiAppIntentUtils.safeGetStringExtra(intent, EXTRA_VERSION_CODE);
        return aiAppsLaunchInfo;
    }

    public static Intent createLaunchIntent(Context context, AiAppsLaunchInfo aiAppsLaunchInfo) {
        if (context == null || aiAppsLaunchInfo == null || !aiAppsLaunchInfo.hasExtraInfo()) {
            return null;
        }
        Intent intent = new Intent();
        intent.setAction(AiAppsLauncherActivity.AIAPPS_LAUNCH_ACTION);
        intent.setComponent(new ComponentName(context, AiAppsLauncherActivity.class));
        intent.putExtra(EXTRA_APP_ID_KEY, aiAppsLaunchInfo.mAppId);
        intent.putExtra(EXTRA_APP_KEY_KEY, aiAppsLaunchInfo.mAppKey);
        intent.putExtra(EXTRA_APP_TITLE_KEY, aiAppsLaunchInfo.mAppTitle);
        intent.putExtra(EXTRA_LAUNCH_IS_DEBUG_KEY, aiAppsLaunchInfo.mIsDebug);
        intent.putExtra(EXTRA_LAUNCH_ERROR_CODE_KEY, aiAppsLaunchInfo.mErrorCode);
        intent.putExtra(EXTRA_LAUNCH_DESCRIPTION_KEY, aiAppsLaunchInfo.mDescription);
        intent.putExtra(EXTRA_LAUNCH_ERROR_DETAIL_KEY, aiAppsLaunchInfo.mErrorDetail);
        intent.putExtra(EXTRA_LAUNCH_ERROR_MSG_KEY, aiAppsLaunchInfo.mErrorMsg);
        intent.putExtra(EXTRA_LAUNCH_RESUME_DATE_KEY, aiAppsLaunchInfo.mResumeDate);
        intent.putExtra(EXTRA_LAUNCH_MAX_SWAN_VERSION, aiAppsLaunchInfo.mMaxSwanVersion);
        intent.putExtra(EXTRA_LAUNCH_MIN_SWAN_VERSION, aiAppsLaunchInfo.mMinSwanVersion);
        intent.putExtra(EXTRA_LAUNCH_SERVICE_CATEGORY, aiAppsLaunchInfo.mServiceCategory);
        intent.putExtra(EXTRA_LAUNCH_SUBJECT_INFO, aiAppsLaunchInfo.mSubjectInfo);
        intent.putExtra(EXTRA_APP_INIT_PARAMS_KEY, aiAppsLaunchInfo.mExtraData);
        intent.putExtra(EXTRA_LAUNCH_AD_CLICK_ID, aiAppsLaunchInfo.mClickId);
        intent.putExtra(EXTRA_LAUNCH_TYPE_KEY, aiAppsLaunchInfo.mType);
        intent.putExtra("aiapps_app_frame_type", aiAppsLaunchInfo.mAppFrameType);
        if (aiAppsLaunchInfo.mNavigateBarColor != 2147483648L) {
            intent.putExtra(EXTRA_NAVIGATE_BAR_COLOR_KEY, aiAppsLaunchInfo.mNavigateBarColor);
        }
        if (aiAppsLaunchInfo.mAppIcon != null) {
            intent.putExtra(EXTRA_APP_ICON_KEY, AiAppImageUtils.encodeBitmapAsString(aiAppsLaunchInfo.mAppIcon));
        }
        if (!TextUtils.isEmpty(aiAppsLaunchInfo.mAppIconUrl)) {
            intent.putExtra(EXTRA_APP_ICON_URL_KEY, aiAppsLaunchInfo.mAppIconUrl);
        }
        if (!TextUtils.isEmpty(aiAppsLaunchInfo.mLaunchFrom)) {
            intent.putExtra("aiapps_launch_from", aiAppsLaunchInfo.mLaunchFrom);
        }
        if (!TextUtils.isEmpty(aiAppsLaunchInfo.mLaunchScheme)) {
            intent.putExtra(EXTRA_LAUNCH_SCHEME_KEY, aiAppsLaunchInfo.mLaunchScheme);
        }
        if (!TextUtils.isEmpty(aiAppsLaunchInfo.mPage)) {
            intent.putExtra(EXTRA_LAUNCH_PAGE_KEY, aiAppsLaunchInfo.mPage);
        }
        if (!TextUtils.isEmpty(aiAppsLaunchInfo.mVersion)) {
            intent.putExtra(EXTRA_LAUNCH_VERSION, aiAppsLaunchInfo.mVersion);
        }
        if (!TextUtils.isEmpty(aiAppsLaunchInfo.mNotInHistory)) {
            intent.putExtra("aiapps_not_in_history", aiAppsLaunchInfo.mNotInHistory);
        }
        if (!TextUtils.isEmpty(aiAppsLaunchInfo.mAppOpenUrl)) {
            intent.putExtra(EXTRA_LAUNCH_APP_OPEN_URL, aiAppsLaunchInfo.mAppOpenUrl);
        }
        if (!TextUtils.isEmpty(aiAppsLaunchInfo.mAppDownloadUrl)) {
            intent.putExtra(EXTRA_LAUNCH_APP_DOWNLOAD_URL, aiAppsLaunchInfo.mAppDownloadUrl);
        }
        if (aiAppsLaunchInfo.mSwanCoreVersion != null) {
            intent.putExtra(EXTRA_SWAN_CORE_VERSION, aiAppsLaunchInfo.mSwanCoreVersion);
        }
        if (aiAppsLaunchInfo.mTargetSwanVersion != null) {
            intent.putExtra(EXTRA_LAUNCH_CUR_SWAN_VERSION, aiAppsLaunchInfo.mTargetSwanVersion);
        }
        intent.putExtra(EXTRA_APP_ZIP_SIZE, aiAppsLaunchInfo.mAppZipSize);
        intent.putExtra(EXTRA_CONSOLE_SWITCH, ConsolePrefsIPCWrapper.getConsoleSwitch(aiAppsLaunchInfo.mAppKey));
        if (aiAppsLaunchInfo.versionCode != null) {
            intent.putExtra(EXTRA_VERSION_CODE, aiAppsLaunchInfo.versionCode);
        }
        intent.putExtra(RemoteDebugger.EXTRA_REMOTE_DEBUG_URL, aiAppsLaunchInfo.mRemoteDebug);
        return intent;
    }

    public static Intent createErrorPagesLaunchIntent(Context context, AiAppsLaunchInfo aiAppsLaunchInfo) {
        if (context == null || aiAppsLaunchInfo == null) {
            return null;
        }
        Intent intent = new Intent();
        intent.putExtra(EXTRA_APP_ID_KEY, aiAppsLaunchInfo.mAppId);
        intent.putExtra(EXTRA_APP_TITLE_KEY, aiAppsLaunchInfo.mAppTitle);
        intent.putExtra(EXTRA_LAUNCH_ERROR_CODE_KEY, aiAppsLaunchInfo.mErrorCode);
        intent.putExtra(EXTRA_LAUNCH_DESCRIPTION_KEY, aiAppsLaunchInfo.mDescription);
        intent.putExtra(EXTRA_LAUNCH_ERROR_DETAIL_KEY, aiAppsLaunchInfo.mErrorDetail);
        intent.putExtra(EXTRA_LAUNCH_ERROR_MSG_KEY, aiAppsLaunchInfo.mErrorMsg);
        intent.putExtra(EXTRA_LAUNCH_RESUME_DATE_KEY, aiAppsLaunchInfo.mResumeDate);
        return intent;
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.mAppId);
    }

    public boolean hasExtraInfo() {
        return (TextUtils.isEmpty(this.mAppId) || TextUtils.isEmpty(this.mAppTitle)) ? false : true;
    }

    public Bundle requireExtraData() {
        if (this.mExtraData == null) {
            this.mExtraData = new Bundle();
        }
        return this.mExtraData;
    }

    public static String getPageInfo(AiAppsLaunchInfo aiAppsLaunchInfo, AiAppsConfigData aiAppsConfigData) {
        String str = aiAppsLaunchInfo.mPage;
        if (!TextUtils.isEmpty(str) && str.startsWith(File.separator)) {
            str = str.substring(1);
        }
        aiAppsLaunchInfo.mPage = null;
        return getCheckedLaunchUrl(str, aiAppsConfigData);
    }

    private static String getCheckedLaunchUrl(String str, AiAppsConfigData aiAppsConfigData) {
        if (TextUtils.isEmpty(str) || aiAppsConfigData == null) {
            return null;
        }
        if (aiAppsConfigData.isInPageUrl(AiAppsUrlUtils.delAllParamsFromUrl(str))) {
            return str;
        }
        return null;
    }
}
