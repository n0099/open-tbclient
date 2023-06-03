package com.baidu.searchbox.config;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import com.baidu.down.manage.DownloadConstants;
import com.baidu.sapi2.SapiWebView;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.downloadcenter.service.DownloadCenterFunConstants;
@SuppressLint({"BDOfflineUrl"})
/* loaded from: classes3.dex */
public final class HostConfig {
    public static final String CONFIG_ABTEST_SCOP = "scop_abtest";
    public static final String CONFIG_KEY_TCBOX_HOST = "TCBOX_HOST";
    public static final String CONFIG_LIVE_TASK_HOST = "LIVE_TASK_HOST";
    public static final String CONFIG_NOVEL_FE_HOST = "NOVEL_FE_HOST";
    public static final String CONFIG_SEARCHBOX_H2_HOST = "SEARCH_BOX_H2_HOST";
    public static final String CONFIG_SEARCHBOX_HOST = "SEARCH_BOX_HOST";
    public static final String CONFIG_SUBSCRIBE_HOST = "SEARCH_BOX_SUBSCRIBE_HOST";
    public static final String UBC_DEBUG_HOST = "UBC_DEBUG_HOST";
    public static final String UBC_DEBUG_URL = "http://bjyz-mco-searchbox201609-m12xi3-044.bjyz.baidu.com:8080/ztbox?action=zubc";
    public static ConfigInterceptor sConfigInterceptor;

    /* loaded from: classes3.dex */
    public interface ConfigInterceptor {
        boolean getBooleanConfig(String str, String str2);
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

    public static String getUrlAppMustRead() {
        return "https://m.baidu.com/sf?pd=sd_privacy_terms&ms=1&ms=1&word=%E5%85%8D%E8%B4%A3%E5%A3%B0%E6%98%8E&title=%E5%85%8D%E8%B4%A3%E5%A3%B0%E6%98%8E&openapi=1&from_sf=1&resource_id=37483&dsp=iphone&tn=wisexmlnew&ext=%7B%22pid%22%3A%22mianze-shengming%22%7D&lid=&referlid=9238571407366095574&frsrcid=37483&frorder=1";
    }

    @NonNull
    public static String getAladdinCommonHost() {
        return AppConfig.getStringConfig("ALADDIN_NA_COMMON_HOST", "https://sp0.baidu.com");
    }

    @NonNull
    public static String getAladdinSportHost() {
        return AppConfig.getStringConfig("ALADDIN_NA_SPORT_HOST", "https://tiyu.baidu.com");
    }

    public static String getAntiHijackHost() {
        return AppConfig.getStringConfig("ANTIHIJACK_UPLOAD_URL", "http://boxrd.baidu.com");
    }

    public static String getAppAuthorityDescription() {
        return String.format("%s/webpage?type=user&action=authority", "https://mbd.baidu.com");
    }

    public static String getBaiduLogoHost() {
        return getOldSearchboxHostForHttps();
    }

    public static String getBoxMessageHost() {
        return AppConfig.getStringConfig("BOX_MESSAGE_HOST", getSearchboxHostForHttps());
    }

    public static String getComicFEHost() {
        return AppConfig.getStringConfig("COMIC_FE_HOST", "https://cartoon.baidu.com");
    }

    public static String getComicServerHost() {
        String str;
        if (isSearchboxUseHttps()) {
            str = "https://vp.mbd.baidu.com";
        } else {
            str = "http://vp.mbd.baidu.com";
        }
        return AppConfig.getStringConfig(CONFIG_SEARCHBOX_HOST, str);
    }

    public static String getExtHostForHttps() {
        String str;
        if (isSearchboxUseHttps()) {
            str = "https://ext.baidu.com";
        } else {
            str = "http://ext.baidu.com";
        }
        return AppConfig.getStringConfig(CONFIG_SUBSCRIBE_HOST, str);
    }

    public static String getFeedPreConnectImageUrl() {
        String str;
        if (isSearchboxUseHttps()) {
            str = "https://timgmb.bdimg.com/timg";
        } else {
            str = "http://timgmb.bdimg.com/timg";
        }
        return AppConfig.getStringConfig(CONFIG_SEARCHBOX_HOST, str);
    }

    public static String getGameServerHost() {
        String str;
        if (isSearchboxUseHttps()) {
            str = "https://gamecenter.baidu.com";
        } else {
            str = "http://gamecenter.baidu.com";
        }
        return AppConfig.getStringConfig("GAME_SERVER_HOST", str);
    }

    public static String getHisSyncHost() {
        return AppConfig.getStringConfig("HIS_SYNC_HOST", getSearchboxHostForHttps());
    }

    public static String getImageSearchHost() {
        return AppConfig.getStringConfig("IMAGE_SEARCH_URL", "http://qingpai.baidu.com");
    }

    public static String getLiveTaskHostForHttps() {
        return AppConfig.getStringConfig(CONFIG_LIVE_TASK_HOST, "https://kanzhibo.baidu.com");
    }

    public static String getMediPageUrl() {
        return AppConfig.getStringConfig("XBOX_SHARE_LOOP_HOST", "http://xbox.m.baidu.com/app/share/loop");
    }

    public static String getNovelBoxHostForHttps() {
        String str;
        if (isSearchboxUseHttps()) {
            str = "https://boxnovel.baidu.com";
        } else {
            str = "http://boxnovel.baidu.com";
        }
        return AppConfig.getStringConfig(CONFIG_NOVEL_FE_HOST, str);
    }

    public static String getO2OImgSearchUrl() {
        return AppConfig.getStringConfig("IMG_SEARCH_URL", "http://image.baidu.com/wisebrowse/meitu");
    }

    public static String getOldSearchboxHostForHttpOnly() {
        return AppConfig.getStringConfig(CONFIG_SEARCHBOX_HOST, DownloadConstants.REFER);
    }

    public static String getOldSearchboxHostForHttps() {
        String str;
        if (isSearchboxUseHttps()) {
            str = DownloadCenterFunConstants.Config.DOWNLOAD_MARKET_LINK_HOST;
        } else {
            str = DownloadConstants.REFER;
        }
        return AppConfig.getStringConfig(CONFIG_SEARCHBOX_HOST, str);
    }

    public static String getRedirectUrlHost() {
        return AppConfig.getStringConfig("REDIRECT_URL_HOST", getSearchboxHostForHttps());
    }

    public static String getSearchBoxH2Host() {
        return AppConfig.getStringConfig(CONFIG_SEARCHBOX_H2_HOST, "https://h2mbd.baidu.com");
    }

    @NonNull
    public static String getSearchFullVideoSetHost() {
        String str;
        if (isSearchboxUseHttps()) {
            str = "https://mbd.baidu.com";
        } else {
            str = "http://mbd.baidu.com";
        }
        return AppConfig.getStringConfig("SEARCH_VIDEO_FULL_VIDEO_SET", str);
    }

    public static String getSearchSimCardPreUrl() {
        if (!AppConfig.isDebug()) {
            return "http://mbd.baidu.com";
        }
        return AppConfig.getStringConfig(CONFIG_SEARCHBOX_HOST, "http://mbd.baidu.com");
    }

    public static String getSearchboxHostForHttpOnly() {
        return AppConfig.getStringConfig(CONFIG_SEARCHBOX_HOST, "http://mbd.baidu.com");
    }

    public static String getSearchboxHostForHttps() {
        String str;
        if (isSearchboxUseHttps()) {
            str = "https://mbd.baidu.com";
        } else {
            str = "http://mbd.baidu.com";
        }
        return AppConfig.getStringConfig(CONFIG_SEARCHBOX_HOST, str);
    }

    public static String getTCInPluginHost() {
        return AppConfig.getStringConfig("TC_IN_PLUGIN_HOST", getSearchboxHostForHttps());
    }

    public static String getTcBoxHost() {
        boolean z;
        String searchboxHostForHttps = getSearchboxHostForHttps();
        if (isSearchboxUseHttps()) {
            ConfigInterceptor configInterceptor = sConfigInterceptor;
            if (configInterceptor != null) {
                z = configInterceptor.getBooleanConfig(CONFIG_ABTEST_SCOP, CONFIG_KEY_TCBOX_HOST);
            } else {
                z = false;
            }
            if (!z) {
                searchboxHostForHttps = getOldSearchboxHostForHttpOnly();
            }
        }
        return AppConfig.getStringConfig(CONFIG_KEY_TCBOX_HOST, searchboxHostForHttps);
    }

    public static String getTcBoxHostHttpOnly() {
        return AppConfig.getStringConfig(CONFIG_KEY_TCBOX_HOST, getOldSearchboxHostForHttpOnly());
    }

    public static String getUrlPrivacyPolicy() {
        return String.format("%s/common/agreement/privacy.html", SapiWebView.BROWSE_MODE_AGREEMENT_HOST);
    }

    public static String getUrlServiceProtocal() {
        return String.format("%s/common/agreement/android.html", SapiWebView.BROWSE_MODE_AGREEMENT_HOST);
    }

    public static String getUserQrcodeHost() {
        return AppConfig.getStringConfig("USER_QRCODE_HOST", "http://r.m.baidu.com");
    }

    public static String getUserXHost() {
        return AppConfig.getStringConfig("SEARCH_BOX_USERX_HOST", getSearchboxHostForHttps());
    }

    public static String getVideoHost() {
        return AppConfig.getStringConfig("VIDEO_DOWN_HOST", "http://video.api.baidu.com");
    }

    public static String getVoiceSearchHost() {
        return AppConfig.getStringConfig("VOICE_SEARCH_HOST", "");
    }

    public static String getVoiceServer() {
        return String.format("%s/echo.fcgi", AppConfig.getStringConfig("VOICE_URL", "http://vse.baidu.com"));
    }

    public static String getWalletWhiteListHost() {
        return AppConfig.getStringConfig("WALLET_WHITE_LIST_HOST", "https://www.baifubao.com");
    }

    public static String getXSearchboxHostForHttps() {
        String str;
        if (isSearchboxUseHttps()) {
            str = "https://mbd.baidu.com";
        } else {
            str = "http://mbd.baidu.com";
        }
        return AppConfig.getStringConfig(CONFIG_SEARCHBOX_HOST, str);
    }

    public static boolean isSearchboxUseHttps() {
        boolean z = true;
        return AppConfig.getBooleanConfig("SERACHBOX_USE_HTTPS", (!QuickPersistConfig.getInstance().getBoolean(QuickPersistConfigConst.KEY_SEARCHBOX_SERVER_USE_HTTPS, true) || AppConfig.HTTPSConfig.isTmpUseHttp()) ? false : false);
    }

    public static void setsConfigInterceptor(ConfigInterceptor configInterceptor) {
        sConfigInterceptor = configInterceptor;
    }
}
