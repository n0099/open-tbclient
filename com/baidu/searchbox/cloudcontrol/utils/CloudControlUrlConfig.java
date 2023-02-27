package com.baidu.searchbox.cloudcontrol.utils;

import android.text.TextUtils;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.common.param.CommonUrlParamManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.HostConfig;
/* loaded from: classes2.dex */
public class CloudControlUrlConfig {
    public static final String KEY_RUN_TYPE = "runtype";
    public static final String KEY_TYPE_ID = "type_id";
    public static final String OEM_NAME_SPACE = "OEMConfig";
    public static final String OEM_TYPE_ID = "OEM_TYPE_ID";
    public static String mDebugHost = "";
    public static String mOEMTypeId = "0";
    public static final String mUrl = "%s/ccs/v1/start/confsync";

    public static String getCloudControlUrl(String str) {
        String searchboxHostForHttps = HostConfig.getSearchboxHostForHttps();
        if (AppConfig.isDebug() && !TextUtils.isEmpty(mDebugHost)) {
            searchboxHostForHttps = mDebugHost;
        }
        String appendParam = CommonUrlParamManager.getInstance().appendParam(String.format(mUrl, searchboxHostForHttps), 1);
        if (!TextUtils.isEmpty(str)) {
            appendParam = UrlUtil.addParam(appendParam, KEY_RUN_TYPE, str);
        }
        String valueOf = String.valueOf(mOEMTypeId);
        if (!TextUtils.isEmpty(valueOf)) {
            return UrlUtil.addParam(appendParam, KEY_TYPE_ID, valueOf);
        }
        return appendParam;
    }

    public static void setDebugHost(String str) {
        mDebugHost = str;
    }

    public static void setOemTypeId(String str) {
        mOEMTypeId = str;
    }
}
