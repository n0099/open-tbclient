package com.baidu.searchbox.ng.ai.apps.aps;

import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.launch.model.AiAppsLaunchInfo;
/* loaded from: classes2.dex */
public class AiAppsApsUtils {
    public static final String APP_DOWNLOAD_URL = "download_url";
    public static final String APP_KEY = "app_key";
    public static final String APP_NAME = "app_name";
    public static final String APP_OPEN_URL = "invoke_url";
    public static final String CALL_APP_CONFIG = "call_app_config";
    public static final int CONNECT_APS_DEF_TIME = 0;
    public static final String DESCRIPTION = "description";
    public static final String DEV = "_dev";
    public static final String ERROR_CODE = "error_code";
    public static final String ERROR_DETAIL = "error_detail";
    public static final String ERROR_MSG = "error_msg";
    public static final String ICON_URL = "icon_url";
    public static final String MAX_SWAN_VERSION = "max_swan_version";
    public static final String MIN_SWAN_VERSION = "min_swan_version";
    public static final String RESUME_DATE = "resume_date";
    public static final String SERVICE_CATEGORY = "service_category";
    public static final String SIGN = "sign";
    public static final String SUBJECT_INFO = "subject_info";
    public static final String SWAN_CONF = "swan_conf";
    public static final String TARGET_SWAN_VERSION = "cur_swan_version";
    public static final String TRIAL = "_trial";
    public static final String TYPE = "type";
    public static final String VERSION_CODE = "version_code";
    public static final String WEB_ACTION = "web_action";
    public static final String WEB_VIEW_DOMAINS = "web_view_domains";

    public static boolean isDevPackage(AiAppsLaunchInfo aiAppsLaunchInfo) {
        return aiAppsLaunchInfo != null && aiAppsLaunchInfo.mType == 1;
    }

    public static boolean isTrialPackage(AiAppsLaunchInfo aiAppsLaunchInfo) {
        return aiAppsLaunchInfo != null && aiAppsLaunchInfo.mType == 2;
    }

    public static String getAppKey(String str) {
        if (!TextUtils.isEmpty(str)) {
            int indexOf = str.indexOf(DEV);
            if (indexOf > 0) {
                return str.substring(0, indexOf);
            }
            int indexOf2 = str.indexOf(TRIAL);
            if (indexOf2 > 0) {
                return str.substring(0, indexOf2);
            }
            return str;
        }
        return str;
    }

    public static String getAiAppIdVersion(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(DEV);
        if (lastIndexOf >= 0 && lastIndexOf < str.length()) {
            return str.substring(lastIndexOf);
        }
        int lastIndexOf2 = str.lastIndexOf(TRIAL);
        if (lastIndexOf2 >= 0 && lastIndexOf2 < str.length()) {
            return str.substring(lastIndexOf2);
        }
        return "";
    }
}
