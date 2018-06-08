package com.baidu.ar.util;

import com.baidu.ar.bean.ARConfig;
/* loaded from: classes3.dex */
public final class UrlUtils {
    public static final String AIP_URL_CLOUD_RECG = "/recognize";
    public static final boolean DEBUG_SERVER = false;
    public static String URL_AR_PREFIX = "https://dusee.baidu.com";
    public static final String URL_LOGO_RECG = "https://dusee.baidu.com/artrack-bos/content/RecognizeLogoVis";

    public static String getCloudRecgUrl() {
        return ARConfig.isAipAuth() ? "https://aip.baidubce.com/file/2.0/ar/v1/recognize" : URL_AR_PREFIX + "/artrack-bos/content/recognizeimgvis";
    }

    public static String getDeviceRecgUrl() {
        return URL_AR_PREFIX + "/artrack-bos/content/onlinefeature";
    }

    public static String getQueryPluginUrl() {
        return URL_AR_PREFIX + "/artrack-bos/queryplugin";
    }

    public static String getQueryResourceUrl() {
        return ARConfig.isAipAuth() ? "https://aip.baidubce.com/rpc/2.0/ar/v1/query_resource" : URL_AR_PREFIX + "/artrack-bos/queryarresource";
    }

    public static String getRecommendUrl() {
        return URL_AR_PREFIX + "/artrack-bos/queryarrecommend";
    }

    public static String getShareUrl() {
        return ARConfig.isAipAuth() ? "https://aip.baidubce.com/file/2.0/ar/v1/share_upload" : URL_AR_PREFIX + "/artrack-bos/share/shareupload";
    }

    public static String getStatisticUrl() {
        return URL_AR_PREFIX + "/artrack/count_ar";
    }

    public static String getStepLoadingBatchUrl() {
        return URL_AR_PREFIX + "/artrack-bos/content/zipquery";
    }

    public static boolean setTrackDebugServer(String str) {
        return false;
    }
}
