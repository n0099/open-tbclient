package com.baidu.searchbox.common.security;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.schemeauthenticate.BaseSchemeCheckerHelper;
import com.baidu.searchbox.schemeauthenticate.SchemeAuthenticateMonitor;
import java.util.ArrayList;
import java.util.List;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
/* loaded from: classes3.dex */
public class SchemeCheckerHelperImpl extends BaseSchemeCheckerHelper implements NoProGuard {
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String FRAME_WHITE_LIST_COMIC = "comic";
    public static final String FRAME_WHITE_LIST_SWAN_APP = "ai_apps";
    public static final String FRAME_WHITE_LIST_SWAN_APP_WIDGET = "ai_apps_widget";
    public static final String QIYIHOST = "iqiyi.com";
    public static final String QIYISCHEME = "baiduboxapp://v15/vendor/iqiyi";
    public static final String TAG = "SchemeCheckerConfigImpl";
    public static volatile SchemeCheckerHelperImpl instance;

    @Override // com.baidu.searchbox.schemeauthenticate.BaseSchemeCheckerHelper
    public boolean enableDefaultCheckUrl() {
        return true;
    }

    public static SchemeCheckerHelperImpl getInstance() {
        if (instance == null) {
            synchronized (SchemeCheckerHelperImpl.class) {
                if (instance == null) {
                    instance = new SchemeCheckerHelperImpl();
                }
            }
        }
        return instance;
    }

    @Override // com.baidu.searchbox.schemeauthenticate.BaseSchemeCheckerHelper
    public List<String> getFrameWhiteList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("comic");
        arrayList.add(FRAME_WHITE_LIST_SWAN_APP);
        arrayList.add(FRAME_WHITE_LIST_SWAN_APP_WIDGET);
        return arrayList;
    }

    @Override // com.baidu.searchbox.schemeauthenticate.BaseSchemeCheckerHelper
    public int checkSpecialScheme(String str, String str2) {
        String host = Uri.parse(str).getHost();
        if (!TextUtils.isEmpty(str2) && str2.startsWith(QIYISCHEME)) {
            if (TextUtils.equals(host, QIYIHOST) || host.endsWith(".iqiyi.com")) {
                return 0;
            }
            return 1;
        } else if (SchemeAuthenticateMonitor.getInstanse().checkIsAvalid(str, str2)) {
            return 0;
        } else {
            return 2;
        }
    }

    @Override // com.baidu.searchbox.schemeauthenticate.BaseSchemeCheckerHelper
    public List<String> getInternalWhiteHost() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(PublicSuffixDatabase.BAIDU_TLD_PLUS_ONE);
        arrayList.add("nuomi.com");
        arrayList.add("hao123.com");
        arrayList.add("baifubao.com");
        arrayList.add("dxmpay.com");
        arrayList.add("duxiaoman.com");
        arrayList.add("mipcdn.com");
        arrayList.add("wejianzhan.com");
        arrayList.add("baidu-int.com");
        arrayList.add("web.yy.com");
        return arrayList;
    }

    @Override // com.baidu.searchbox.schemeauthenticate.BaseSchemeCheckerHelper
    public boolean httpSecureCheck(String str) {
        boolean z = SecurityPersistConfig.getInstance().getBoolean(SecurityPersistConfigConst.KEY_SEC_HTTPS_CHECK, false);
        if (DEBUG) {
            Log.i(TAG, "httpSecureCheck:" + z);
        }
        if (z && !UrlUtil.isHttpSecurity(str) && !DEBUG) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.searchbox.schemeauthenticate.BaseSchemeCheckerHelper
    public void httpSecureStatistic(String str, String str2) {
        Uri uri;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (str != null && str.startsWith("http://")) {
                String str3 = null;
                try {
                    uri = Uri.parse(str2);
                } catch (Exception e) {
                    if (DEBUG) {
                        Log.e(TAG, "isPublicPath e:" + e);
                    }
                    uri = null;
                }
                if (uri != null) {
                    str3 = uri.getPath();
                }
                new JsHttpSecureStatistic().setJsType("1").setApi(str3).setUrl(str).statistic();
            }
        } else if (DEBUG) {
            Log.i(TAG, "httpSecureStatistic url:" + str + ",schemeCmd:" + str2);
        }
    }
}
