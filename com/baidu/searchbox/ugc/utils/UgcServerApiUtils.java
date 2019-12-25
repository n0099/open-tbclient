package com.baidu.searchbox.ugc.utils;

import com.baidu.searchbox.publisher.base.PublisherConfig;
/* loaded from: classes11.dex */
public class UgcServerApiUtils {
    public static final String DEFAULT_PUBLISHER_USER_AGENT = "okhttp/3.11.0 Dalvik/2.1.0 (Linux; U; Android 8.1.0; MI 8 MIUI/V10.0.11.0.OEACNFH) baiduboxapp/11.7.0.0 (Baidu; P1 8.1.0)";
    public static final String DEFAULT_REFERER = "https://quanmin.baidu.com/";
    public static final String ONLINE_HOST_ADRESS = "https://mbd.baidu.com/";
    public static final String PUBLISHER_ADDRESS_PATH = "publisher/v1/ugc/publish";
    public static final String TAG_FILTER_PATH = "publisher/v1/tool/filter";
    public static final String TOKEN_ADDRESS_PATH = "publisher/v1/ugc/auth";
    public static String mReferer;
    public static String sPublisherUserAgent;
    public static String DEFAULT_DEBUG_TAG_FILTER_HOST_ADRESS = "http://yq01-bac-orp-otp-searchbox-67034.yq01.baidu.com:8210/";
    public static final String DEFAULT_DEBUG_HOST_ADRESS = "http://cp01-wangyuhu.epc.baidu.com:8238/";
    private static String sHostAddress = DEFAULT_DEBUG_HOST_ADRESS;
    private static String sTagFilterHostAddress = DEFAULT_DEBUG_TAG_FILTER_HOST_ADRESS;
    public static String locationInfo = "a0ea1fbd42b849e70bccdd4d";

    public static void setHostAddress(String str) {
        sHostAddress = str;
    }

    public static String getHostAddress() {
        return PublisherConfig.isMainApp() ? UgcConfigUrl.getSearchboxHost() + "/" : sHostAddress;
    }

    public static void setTagFilterHostAddress(String str) {
        sTagFilterHostAddress = str;
    }

    public static String getTagFilterHostAddress() {
        return sTagFilterHostAddress;
    }

    public static String getLocationInfo() {
        return locationInfo;
    }

    public static String getPublisherUserAgent() {
        return sPublisherUserAgent;
    }

    public static void setPublisherUserAgent(String str) {
        sPublisherUserAgent = str;
    }

    public static String getReferer() {
        return mReferer;
    }

    public static void setReferer(String str) {
        mReferer = str;
    }
}
