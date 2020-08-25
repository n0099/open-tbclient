package com.baidu.searchbox.config;

import com.baidu.down.manage.DownloadConstants;
import com.baidu.searchbox.config.AppConfig;
/* loaded from: classes11.dex */
public final class HostConfig {
    public static final String CONFIG_ABTEST_SCOP = "scop_abtest";
    public static final String CONFIG_KEY_TCBOX_HOST = "TCBOX_HOST";
    private static final String CONFIG_LIVE_TASK_HOST = "LIVE_TASK_HOST";
    private static final String CONFIG_NOVEL_FE_HOST = "NOVEL_FE_HOST";
    private static final String CONFIG_SEARCHBOX_HOST = "SEARCH_BOX_HOST";
    private static final String CONFIG_SUBSCRIBE_HOST = "SEARCH_BOX_SUBSCRIBE_HOST";
    static final String UBC_DEBUG_HOST = "UBC_DEBUG_HOST";
    static final String UBC_DEBUG_URL = "http://bjyz-mco-searchbox201609-m12xi3-044.bjyz.baidu.com:8080/ztbox?action=zubc";
    private static ConfigInterceptor sConfigInterceptor;

    /* loaded from: classes11.dex */
    public interface ConfigInterceptor {
        boolean getBooleanConfig(String str, String str2);
    }

    private HostConfig() {
    }

    public static String getUrlServiceProtocal() {
        return String.format("%s/common/agreement/android.html", "https://s.bdstatic.com");
    }

    public static String getAppAuthorityDescription() {
        return String.format("%s/webpage?type=user&action=authority", "https://mbd.baidu.com");
    }

    public static String getUrlPrivacyPolicy() {
        return String.format("%s/common/agreement/privacy.html", "https://s.bdstatic.com");
    }

    public static String getUrlAppMustRead() {
        return String.format("%s/duty/wise/wise_index.html", "https://www.baidu.com");
    }

    public static void setsConfigInterceptor(ConfigInterceptor configInterceptor) {
        sConfigInterceptor = configInterceptor;
    }

    public static boolean isSearchboxUseHttps() {
        boolean z = true;
        return AppConfig.getBooleanConfig("SERACHBOX_USE_HTTPS", (!QuickPersistConfig.getInstance().getBoolean(QuickPersistConfigConst.KEY_SEARCHBOX_SERVER_USE_HTTPS, true) || AppConfig.HTTPSConfig.isTmpUseHttp()) ? false : false);
    }

    public static String getSearchboxHostForHttps() {
        return AppConfig.getStringConfig(CONFIG_SEARCHBOX_HOST, isSearchboxUseHttps() ? "https://mbd.baidu.com" : "http://mbd.baidu.com");
    }

    public static String getLiveTaskHostForHttps() {
        return AppConfig.getStringConfig(CONFIG_LIVE_TASK_HOST, "https://kanzhibo.baidu.com");
    }

    public static String getSearchboxHostForHttpOnly() {
        return AppConfig.getStringConfig(CONFIG_SEARCHBOX_HOST, "http://mbd.baidu.com");
    }

    public static String getOldSearchboxHostForHttps() {
        return AppConfig.getStringConfig(CONFIG_SEARCHBOX_HOST, isSearchboxUseHttps() ? "https://m.baidu.com" : DownloadConstants.REFER);
    }

    public static String getOldSearchboxHostForHttpOnly() {
        return AppConfig.getStringConfig(CONFIG_SEARCHBOX_HOST, DownloadConstants.REFER);
    }

    public static String getXSearchboxHostForHttps() {
        return AppConfig.getStringConfig(CONFIG_SEARCHBOX_HOST, isSearchboxUseHttps() ? "https://mbd.baidu.com" : "http://mbd.baidu.com");
    }

    public static String getNovelBoxHostForHttps() {
        return AppConfig.getStringConfig(CONFIG_NOVEL_FE_HOST, isSearchboxUseHttps() ? "https://boxnovel.baidu.com" : "http://boxnovel.baidu.com");
    }

    public static String getExtHostForHttps() {
        return AppConfig.getStringConfig(CONFIG_SUBSCRIBE_HOST, isSearchboxUseHttps() ? "https://ext.baidu.com" : "http://ext.baidu.com");
    }

    public static String getVoiceServer() {
        return String.format("%s/echo.fcgi", AppConfig.getStringConfig("VOICE_URL", "http://vse.baidu.com"));
    }

    public static String getMediPageUrl() {
        return AppConfig.getStringConfig("XBOX_SHARE_LOOP_HOST", "http://xbox.m.baidu.com/app/share/loop");
    }

    public static String getNetTestServer() {
        return "http://112.34.113.161/checkupdate";
    }

    public static String getSchemaUrl() {
        return "https://mbd.baidu.com/webpage?type=user&action=safariadd&format=json";
    }

    public static String getSearchAppServer() {
        return "http://m.baidu.com/pu=sz@1320_224,osname@android/app?tn=tophot";
    }

    public static String getImageSearchHost() {
        return AppConfig.getStringConfig("IMAGE_SEARCH_URL", "http://qingpai.baidu.com");
    }

    public static String getRedirectUrlHost() {
        return AppConfig.getStringConfig("REDIRECT_URL_HOST", getSearchboxHostForHttps());
    }

    public static String getAntiHijackHost() {
        return AppConfig.getStringConfig("ANTIHIJACK_UPLOAD_URL", "http://boxrd.baidu.com");
    }

    public static String getHisSyncHost() {
        return AppConfig.getStringConfig("HIS_SYNC_HOST", getSearchboxHostForHttps());
    }

    public static String getTcBoxHost() {
        String searchboxHostForHttps = getSearchboxHostForHttps();
        if (isSearchboxUseHttps()) {
            ConfigInterceptor configInterceptor = sConfigInterceptor;
            if (!(configInterceptor != null ? configInterceptor.getBooleanConfig(CONFIG_ABTEST_SCOP, CONFIG_KEY_TCBOX_HOST) : false)) {
                searchboxHostForHttps = getOldSearchboxHostForHttpOnly();
            }
        }
        return AppConfig.getStringConfig(CONFIG_KEY_TCBOX_HOST, searchboxHostForHttps);
    }

    public static String getTcBoxHostHttpOnly() {
        return AppConfig.getStringConfig(CONFIG_KEY_TCBOX_HOST, getOldSearchboxHostForHttpOnly());
    }

    public static String getVoiceSearchHost() {
        return AppConfig.getStringConfig("VOICE_SEARCH_HOST", "");
    }

    public static String getO2OImgSearchUrl() {
        return AppConfig.getStringConfig("IMG_SEARCH_URL", "http://image.baidu.com/wisebrowse/meitu");
    }

    public static String getVideoHost() {
        return AppConfig.getStringConfig("VIDEO_DOWN_HOST", "http://video.api.baidu.com");
    }

    public static String getTCInPluginHost() {
        return AppConfig.getStringConfig("TC_IN_PLUGIN_HOST", getSearchboxHostForHttps());
    }

    public static String getBoxMessageHost() {
        return AppConfig.getStringConfig("BOX_MESSAGE_HOST", getSearchboxHostForHttps());
    }

    public static String getUserXHost() {
        return AppConfig.getStringConfig("SEARCH_BOX_USERX_HOST", getSearchboxHostForHttps());
    }

    public static String getUserQrcodeHost() {
        return AppConfig.getStringConfig("USER_QRCODE_HOST", "http://r.m.baidu.com");
    }

    public static String getFeedPreConnectImageUrl() {
        return AppConfig.getStringConfig(CONFIG_SEARCHBOX_HOST, isSearchboxUseHttps() ? "https://timgmb.bdimg.com/timg" : "http://timgmb.bdimg.com/timg");
    }

    public static String getWalletWhiteListHost() {
        return AppConfig.getStringConfig("WALLET_WHITE_LIST_HOST", "https://www.baifubao.com");
    }

    public static String getComicServerHost() {
        return AppConfig.getStringConfig(CONFIG_SEARCHBOX_HOST, isSearchboxUseHttps() ? "https://vp.mbd.baidu.com" : "http://vp.mbd.baidu.com");
    }

    public static String getComicFEHost() {
        return AppConfig.getStringConfig("COMIC_FE_HOST", "https://cartoon.baidu.com");
    }

    public static String getSearchSimCardPreUrl() {
        return AppConfig.isDebug() ? AppConfig.getStringConfig(CONFIG_SEARCHBOX_HOST, "http://mbd.baidu.com") : "http://mbd.baidu.com";
    }

    public static String getBaiduLogoHost() {
        return getOldSearchboxHostForHttps();
    }

    public static String getGameServerHost() {
        return AppConfig.getStringConfig("GAME_SERVER_HOST", isSearchboxUseHttps() ? "https://gamecenter.baidu.com" : "http://gamecenter.baidu.com");
    }
}
