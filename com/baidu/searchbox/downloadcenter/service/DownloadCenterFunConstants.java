package com.baidu.searchbox.downloadcenter.service;
/* loaded from: classes3.dex */
public class DownloadCenterFunConstants {
    public static final String CARD_TYPE = "cardType";
    public static final String CATEGORY = "category";
    public static final String CHANNEL = "channel";
    public static final String DOWNLOADCENTER_ENABLE_RECOMMEND = "enable_recommend";
    public static final String DOWNLOAD_BACK_INVOKE_SCHEME = "backInvokeScheme";
    public static final String DOWNLOAD_MARKET_DOWNLOAD_URL = "download_url";
    public static final String DOWNLOAD_MARKET_ICON = "icon";
    public static final String DOWNLOAD_MARKET_INTENT_ID = "id";
    public static final String DOWNLOAD_MARKET_PARAM_FROM = "from";
    public static final String DOWNLOAD_MARKET_PARAM_FROM_VALUE = "searchbox_download_market_link";
    public static final String DOWNLOAD_MARKET_PARAM_PACKAGENAME = "packagename";
    public static final String DOWNLOAD_MARKET_RESULT = "result";
    public static final String DOWNLOAD_MARKET_SNAME = "sname";
    public static final String DOWNLOAD_MARKET_STATUSCODE = "statuscode";
    public static final String DOWNLOAD_MARKET_VERSIONCODE = "versioncode";
    public static final String EXTRA_ENTER_COMPLETED_TAB = "EXTRA_ENTER_COMPLETED_TAB";
    public static final String EXTRA_ENTER_TAB_JSON = "extra_enter_tab_source";
    public static final String EXTRA_INFO = "extraInfo";
    public static final String FILE_ICON = "fileIcon";
    public static final String FILE_NAME = "fileName";
    public static final String IS_VISIBLE_IN_NOTIFICATION = "isVisibleInNotification";
    public static final String MIME_TYPE = "mimeType";
    public static final String PRE_REFERER = "preReferer";
    public static final String REFERER = "referer";
    public static final String SOURCE = "source";
    public static final String SOURCE_ALADING = "apk_alading";
    public static final String SOURCE_FENGCHAO = "apk_fengchao";
    public static final String SOURCE_PINZHUAN = "apk_pinzhuan";
    public static final String SOURCE_YOUXILIANYUN = "apk_youxilianyun";
    public static final String URL = "url";
    public static final String VERSION = "version";

    /* loaded from: classes3.dex */
    public static class PreviewResultCode {
        public static final int ERROR_UN_FIND = 1002;
        public static final int ERROR_UN_SUCCESS = 1001;
        public static final int SUCCESS = 0;
    }

    /* loaded from: classes3.dex */
    public static class Config {
        public static final String DOWNLOAD_MARKET_LINK_HOST = "https://m.baidu.com";

        public static final String getDownloadMarketLinkUrl() {
            return String.format("%s/api?action=getappinfobypackagename&format=json", DOWNLOAD_MARKET_LINK_HOST);
        }
    }
}
