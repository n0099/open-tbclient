package com.baidu.searchbox.schemeauthenticate;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrackConfig;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.schemeauthenticate.dispatcher.UnitedSchemePublicDispatcher;
import java.io.File;
import java.util.List;
/* loaded from: classes4.dex */
public abstract class BaseSchemeCheckerHelper {
    public static final String KEY_CHECK_URL_ENABLE = "check_url_en";
    public static final String KEY_DEBUG_RN_SP = "debug_rn_sp";
    public static final String TAG = "SchemeCheckerHelper";
    public static final int URL_PRE_CHECK_RES_WHITE = 0;
    public static final int URL_RPE_CHECK_RES_BLACK = 1;
    public static final int URL_RPE_CHECK_RES_QUERY_HOST = 2;
    public static volatile BaseSchemeCheckerHelper sInstance;
    public static final boolean DEBUG = AppConfig.isDebug();
    public static int URL_PRE_CHECK_RES_LOCAL = 3;

    public abstract int checkSpecialScheme(String str, String str2);

    public abstract boolean enableDefaultCheckUrl();

    public abstract List<String> getFrameWhiteList();

    public abstract List<String> getInternalWhiteHost();

    public abstract boolean httpSecureCheck(String str);

    public abstract void httpSecureStatistic(String str, String str2);

    private boolean isCheckUrl() {
        return DebugRNPreferenceUtils.getInstance().getBoolean("check_url_en", enableDefaultCheckUrl());
    }

    private boolean isPublicPath(String str) {
        Uri uri;
        List<String> pathSegments;
        try {
            uri = Uri.parse(str);
        } catch (Exception e) {
            if (DEBUG) {
                Log.e(TAG, "isPublicPath e:" + e);
            }
            uri = null;
        }
        if (uri == null || (pathSegments = uri.getPathSegments()) == null || pathSegments.size() <= 0 || !TextUtils.equals(UnitedSchemePublicDispatcher.MODULE_NAME, ((String[]) pathSegments.toArray(new String[0]))[0])) {
            return false;
        }
        return true;
    }

    @Deprecated
    public boolean isInFrameWhileList(String str) {
        for (String str2 : getFrameWhiteList()) {
            if (TextUtils.equals(str2, str)) {
                return true;
            }
        }
        return false;
    }

    public int preCheckUrl(String str) {
        return preCheckUrl(str, null);
    }

    public int preCheckUrl(String str, String str2) {
        return preCheckUrl(str, str2, null);
    }

    public int preCheckUrl(String str, String str2, String str3) {
        boolean z;
        if (DEBUG && !isCheckUrl()) {
            return 0;
        }
        if (!TextUtils.isEmpty(str3)) {
            for (String str4 : getFrameWhiteList()) {
                if (TextUtils.equals(str4, str3)) {
                    return 0;
                }
            }
        }
        if (isPublicPath(str2)) {
            return 0;
        }
        if (TextUtils.isEmpty(str)) {
            return 1;
        }
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        if (TextUtils.isEmpty(scheme)) {
            return 1;
        }
        String[] strArr = {"http", "https", "file"};
        int i = 0;
        while (true) {
            if (i < 3) {
                if (strArr[i].equalsIgnoreCase(scheme)) {
                    z = true;
                    break;
                }
                i++;
            } else {
                z = false;
                break;
            }
        }
        if (!z) {
            return 1;
        }
        if (TextUtils.equals("file", scheme)) {
            if (!TextUtils.isEmpty(parse.getPath())) {
                try {
                    if (new File(parse.getPath()).getCanonicalPath().startsWith(new File(AppRuntime.getAppContext().getFilesDir(), MediaTrackConfig.AE_IMPORT_TEMPLATE).getCanonicalPath())) {
                        if (DEBUG) {
                            Log.d(TAG, "url match local files. ");
                        }
                        return 0;
                    }
                    return URL_PRE_CHECK_RES_LOCAL;
                } catch (Exception unused) {
                }
            }
            return 1;
        }
        String host = parse.getHost();
        if (TextUtils.isEmpty(host)) {
            return 1;
        }
        for (String str5 : getInternalWhiteHost()) {
            if (TextUtils.equals(str5, host)) {
                if (DEBUG) {
                    Log.d(TAG, "host match baidu origin. ");
                }
                if (httpSecureCheck(str)) {
                    return 0;
                }
                httpSecureStatistic(str, str2);
            } else {
                if (host.endsWith("." + str5)) {
                    if (DEBUG) {
                        Log.d(TAG, "host match baidu origin. ");
                    }
                    if (httpSecureCheck(str)) {
                        return 0;
                    }
                    httpSecureStatistic(str, str2);
                } else {
                    continue;
                }
            }
        }
        return checkSpecialScheme(str, str2);
    }
}
