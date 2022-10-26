package com.baidu.searchbox.config;

import androidx.core.view.InputDeviceCompat;
import com.baidu.down.manage.DownloadConstants;
import com.baidu.sapi2.SapiWebView;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public final class HostConfig {
    public static /* synthetic */ Interceptable $ic = null;
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
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public interface ConfigInterceptor {
        boolean getBooleanConfig(String str, String str2);
    }

    public static String getNetTestServer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? "http://112.34.113.161/checkupdate" : (String) invokeV.objValue;
    }

    public static String getSchemaUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) ? "https://mbd.baidu.com/webpage?type=user&action=safariadd&format=json" : (String) invokeV.objValue;
    }

    public static String getSearchAppServer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) ? "http://m.baidu.com/pu=sz@1320_224,osname@android/app?tn=tophot" : (String) invokeV.objValue;
    }

    public static String getUrlAppMustRead() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65568, null)) == null) ? "https://m.baidu.com/sf?pd=sd_privacy_terms&ms=1&ms=1&word=%E5%85%8D%E8%B4%A3%E5%A3%B0%E6%98%8E&title=%E5%85%8D%E8%B4%A3%E5%A3%B0%E6%98%8E&openapi=1&from_sf=1&resource_id=37483&dsp=iphone&tn=wisexmlnew&ext=%7B%22pid%22%3A%22mianze-shengming%22%7D&lid=&referlid=9238571407366095574&frsrcid=37483&frorder=1" : (String) invokeV.objValue;
    }

    public HostConfig() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String getAladdinCommonHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return AppConfig.getStringConfig("ALADDIN_NA_COMMON_HOST", "https://sp0.baidu.com");
        }
        return (String) invokeV.objValue;
    }

    public static String getAladdinSportHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return AppConfig.getStringConfig("ALADDIN_NA_SPORT_HOST", "https://tiyu.baidu.com");
        }
        return (String) invokeV.objValue;
    }

    public static String getAntiHijackHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return AppConfig.getStringConfig("ANTIHIJACK_UPLOAD_URL", "http://boxrd.baidu.com");
        }
        return (String) invokeV.objValue;
    }

    public static String getAppAuthorityDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return String.format("%s/webpage?type=user&action=authority", "https://mbd.baidu.com");
        }
        return (String) invokeV.objValue;
    }

    public static String getBaiduLogoHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return getOldSearchboxHostForHttps();
        }
        return (String) invokeV.objValue;
    }

    public static String getBoxMessageHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return AppConfig.getStringConfig("BOX_MESSAGE_HOST", getSearchboxHostForHttps());
        }
        return (String) invokeV.objValue;
    }

    public static String getComicFEHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return AppConfig.getStringConfig("COMIC_FE_HOST", "https://cartoon.baidu.com");
        }
        return (String) invokeV.objValue;
    }

    public static String getComicServerHost() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (isSearchboxUseHttps()) {
                str = "https://vp.mbd.baidu.com";
            } else {
                str = "http://vp.mbd.baidu.com";
            }
            return AppConfig.getStringConfig(CONFIG_SEARCHBOX_HOST, str);
        }
        return (String) invokeV.objValue;
    }

    public static String getExtHostForHttps() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (isSearchboxUseHttps()) {
                str = "https://ext.baidu.com";
            } else {
                str = "http://ext.baidu.com";
            }
            return AppConfig.getStringConfig(CONFIG_SUBSCRIBE_HOST, str);
        }
        return (String) invokeV.objValue;
    }

    public static String getFeedPreConnectImageUrl() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            if (isSearchboxUseHttps()) {
                str = "https://timgmb.bdimg.com/timg";
            } else {
                str = "http://timgmb.bdimg.com/timg";
            }
            return AppConfig.getStringConfig(CONFIG_SEARCHBOX_HOST, str);
        }
        return (String) invokeV.objValue;
    }

    public static String getGameServerHost() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (isSearchboxUseHttps()) {
                str = "https://gamecenter.baidu.com";
            } else {
                str = "http://gamecenter.baidu.com";
            }
            return AppConfig.getStringConfig("GAME_SERVER_HOST", str);
        }
        return (String) invokeV.objValue;
    }

    public static String getHisSyncHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            return AppConfig.getStringConfig("HIS_SYNC_HOST", getSearchboxHostForHttps());
        }
        return (String) invokeV.objValue;
    }

    public static String getImageSearchHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            return AppConfig.getStringConfig("IMAGE_SEARCH_URL", "http://qingpai.baidu.com");
        }
        return (String) invokeV.objValue;
    }

    public static String getLiveTaskHostForHttps() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            return AppConfig.getStringConfig(CONFIG_LIVE_TASK_HOST, "https://kanzhibo.baidu.com");
        }
        return (String) invokeV.objValue;
    }

    public static String getMediPageUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            return AppConfig.getStringConfig("XBOX_SHARE_LOOP_HOST", "http://xbox.m.baidu.com/app/share/loop");
        }
        return (String) invokeV.objValue;
    }

    public static String getNovelBoxHostForHttps() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
            if (isSearchboxUseHttps()) {
                str = "https://boxnovel.baidu.com";
            } else {
                str = "http://boxnovel.baidu.com";
            }
            return AppConfig.getStringConfig(CONFIG_NOVEL_FE_HOST, str);
        }
        return (String) invokeV.objValue;
    }

    public static String getO2OImgSearchUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            return AppConfig.getStringConfig("IMG_SEARCH_URL", "http://image.baidu.com/wisebrowse/meitu");
        }
        return (String) invokeV.objValue;
    }

    public static String getOldSearchboxHostForHttpOnly() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) {
            return AppConfig.getStringConfig(CONFIG_SEARCHBOX_HOST, DownloadConstants.REFER);
        }
        return (String) invokeV.objValue;
    }

    public static String getOldSearchboxHostForHttps() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) {
            if (isSearchboxUseHttps()) {
                str = "https://m.baidu.com";
            } else {
                str = DownloadConstants.REFER;
            }
            return AppConfig.getStringConfig(CONFIG_SEARCHBOX_HOST, str);
        }
        return (String) invokeV.objValue;
    }

    public static String getRedirectUrlHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) {
            return AppConfig.getStringConfig("REDIRECT_URL_HOST", getSearchboxHostForHttps());
        }
        return (String) invokeV.objValue;
    }

    public static String getSearchBoxH2Host() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) {
            return AppConfig.getStringConfig(CONFIG_SEARCHBOX_H2_HOST, "https://h2mbd.baidu.com");
        }
        return (String) invokeV.objValue;
    }

    public static String getSearchFullVideoSetHost() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) {
            if (isSearchboxUseHttps()) {
                str = "https://mbd.baidu.com";
            } else {
                str = "http://mbd.baidu.com";
            }
            return AppConfig.getStringConfig("SEARCH_VIDEO_FULL_VIDEO_SET", str);
        }
        return (String) invokeV.objValue;
    }

    public static String getSearchSimCardPreUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65562, null)) == null) {
            if (!AppConfig.isDebug()) {
                return "http://mbd.baidu.com";
            }
            return AppConfig.getStringConfig(CONFIG_SEARCHBOX_HOST, "http://mbd.baidu.com");
        }
        return (String) invokeV.objValue;
    }

    public static String getSearchboxHostForHttpOnly() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65563, null)) == null) {
            return AppConfig.getStringConfig(CONFIG_SEARCHBOX_HOST, "http://mbd.baidu.com");
        }
        return (String) invokeV.objValue;
    }

    public static String getSearchboxHostForHttps() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65564, null)) == null) {
            if (isSearchboxUseHttps()) {
                str = "https://mbd.baidu.com";
            } else {
                str = "http://mbd.baidu.com";
            }
            return AppConfig.getStringConfig(CONFIG_SEARCHBOX_HOST, str);
        }
        return (String) invokeV.objValue;
    }

    public static String getTCInPluginHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65565, null)) == null) {
            return AppConfig.getStringConfig("TC_IN_PLUGIN_HOST", getSearchboxHostForHttps());
        }
        return (String) invokeV.objValue;
    }

    public static String getTcBoxHostHttpOnly() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65567, null)) == null) {
            return AppConfig.getStringConfig(CONFIG_KEY_TCBOX_HOST, getOldSearchboxHostForHttpOnly());
        }
        return (String) invokeV.objValue;
    }

    public static String getUrlPrivacyPolicy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65569, null)) == null) {
            return String.format("%s/common/agreement/privacy.html", SapiWebView.BROWSE_MODE_AGREEMENT_HOST);
        }
        return (String) invokeV.objValue;
    }

    public static String getUrlServiceProtocal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65570, null)) == null) {
            return String.format("%s/common/agreement/android.html", SapiWebView.BROWSE_MODE_AGREEMENT_HOST);
        }
        return (String) invokeV.objValue;
    }

    public static String getUserQrcodeHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65571, null)) == null) {
            return AppConfig.getStringConfig("USER_QRCODE_HOST", "http://r.m.baidu.com");
        }
        return (String) invokeV.objValue;
    }

    public static String getUserXHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65572, null)) == null) {
            return AppConfig.getStringConfig("SEARCH_BOX_USERX_HOST", getSearchboxHostForHttps());
        }
        return (String) invokeV.objValue;
    }

    public static String getVideoHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65573, null)) == null) {
            return AppConfig.getStringConfig("VIDEO_DOWN_HOST", "http://video.api.baidu.com");
        }
        return (String) invokeV.objValue;
    }

    public static String getVoiceSearchHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65574, null)) == null) {
            return AppConfig.getStringConfig("VOICE_SEARCH_HOST", "");
        }
        return (String) invokeV.objValue;
    }

    public static String getVoiceServer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65575, null)) == null) {
            return String.format("%s/echo.fcgi", AppConfig.getStringConfig("VOICE_URL", "http://vse.baidu.com"));
        }
        return (String) invokeV.objValue;
    }

    public static String getWalletWhiteListHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65576, null)) == null) {
            return AppConfig.getStringConfig("WALLET_WHITE_LIST_HOST", "https://www.baifubao.com");
        }
        return (String) invokeV.objValue;
    }

    public static String getXSearchboxHostForHttps() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65577, null)) == null) {
            if (isSearchboxUseHttps()) {
                str = "https://mbd.baidu.com";
            } else {
                str = "http://mbd.baidu.com";
            }
            return AppConfig.getStringConfig(CONFIG_SEARCHBOX_HOST, str);
        }
        return (String) invokeV.objValue;
    }

    public static boolean isSearchboxUseHttps() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65578, null)) == null) {
            boolean z = true;
            return AppConfig.getBooleanConfig("SERACHBOX_USE_HTTPS", (!QuickPersistConfig.getInstance().getBoolean(QuickPersistConfigConst.KEY_SEARCHBOX_SERVER_USE_HTTPS, true) || AppConfig.HTTPSConfig.isTmpUseHttp()) ? false : false);
        }
        return invokeV.booleanValue;
    }

    public static String getTcBoxHost() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65566, null)) == null) {
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
        return (String) invokeV.objValue;
    }

    public static void setsConfigInterceptor(ConfigInterceptor configInterceptor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65579, null, configInterceptor) == null) {
            sConfigInterceptor = configInterceptor;
        }
    }
}
