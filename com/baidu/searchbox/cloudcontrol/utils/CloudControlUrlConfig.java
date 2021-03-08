package com.baidu.searchbox.cloudcontrol.utils;

import android.text.TextUtils;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.d.c.b;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.HostConfig;
/* loaded from: classes4.dex */
public class CloudControlUrlConfig {
    private static final String KEY_RUN_TYPE = "runtype";
    private static final String KEY_TYPE_ID = "type_id";
    private static final String OEM_NAME_SPACE = "OEMConfig";
    private static final String OEM_TYPE_ID = "OEM_TYPE_ID";
    private static String mDebugHost = "";
    private static String mOEMTypeId = "0";
    private static final String mUrl = "%s/ccs/v1/start/confsync";

    public static void setDebugHost(String str) {
        mDebugHost = str;
    }

    public static void setOemTypeId(String str) {
        mOEMTypeId = str;
    }

    public static String getCloudControlUrl(String str) {
        String searchboxHostForHttps = HostConfig.getSearchboxHostForHttps();
        if (AppConfig.isDebug() && !TextUtils.isEmpty(mDebugHost)) {
            searchboxHostForHttps = mDebugHost;
        }
        String processUrl = b.ug().processUrl(String.format(mUrl, searchboxHostForHttps));
        if (!TextUtils.isEmpty(str)) {
            processUrl = UrlUtil.addParam(processUrl, KEY_RUN_TYPE, str);
        }
        String valueOf = String.valueOf(mOEMTypeId);
        if (!TextUtils.isEmpty(valueOf)) {
            return UrlUtil.addParam(processUrl, KEY_TYPE_ID, valueOf);
        }
        return processUrl;
    }
}
