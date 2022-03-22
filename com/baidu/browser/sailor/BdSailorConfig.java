package com.baidu.browser.sailor;

import com.baidu.browser.core.INoProGuard;
import com.baidu.browser.sailor.webkit.loader.BdWebkitManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public final class BdSailorConfig implements INoProGuard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final BdWebkitManager.a BUILTIN_WEBKIT;
    public static final String KEY_ADBLOCK_RULES = "adblock_rules";
    public static final String KEY_ANTI_HIJACK_SERVER = "29_5";
    public static final String KEY_ANTI_HIJACK_WHITE_LIST = "29_6";
    public static final String KEY_CONTENT_CAPTURE_BLACKLIST = "content_capture_blacklist";
    public static final String KEY_EMBED_AD_LIST = "embed_ad";
    public static final String KEY_EMBED_AD_SWITCH = "embed_ad_switch";
    public static final String KEY_ERRORPAGE_ANTI_DNS_HIJACK_SWITCH = "errorpage_search_anti_dns_hijack_switch";
    public static final String KEY_ERROR_PAGE = "error_page";
    public static final String KEY_ERR_PAGE_OUTSEA_LIST = "abroad_top_site_whitelist";
    public static final String KEY_ERR_PAGE_SEARCH = "error_page_search";
    public static final String KEY_ERR_PAGE_SEARCH_SWITCH = "error_page_search_switch";
    public static final String KEY_EXPLORE_ERROR = "25_1";
    public static final String KEY_EXPLORE_WEB_FILTER = "19_3";
    public static final String KEY_GATE = "21_6";
    public static final String KEY_LINK_ADBLOCK_RULES = "adblock_rules_url";
    public static final String KEY_LINK_CONTENT_CAPTURE_BLACK_LIST = "33_19";
    public static final String KEY_LINK_EMBED_AD_LIST = "34_2";
    public static final String KEY_LINK_ERR_PAGE_OUTSEA_LIST = "35_11";
    public static final String KEY_LINK_ERR_PAGE_SEARCH = "35_1";
    public static final String KEY_LINK_EXPLORE_ERROR = "25_1";
    public static final String KEY_LINK_SCHEMA_INVOKE_LIST = "34_1";
    public static final String KEY_RECOMMEND_WHITELIST = "query_recommend_whitelist";
    public static final String KEY_SAILOR_WISE_REG = "14_1";
    public static final String KEY_SCHEMA_INVOKE_LIST = "schema_invoke_list";
    public static final String KEY_SCHEMA_INVOKE_SWITCH = "schema_invoke_switch";
    public static final String KEY_WEBAPP_FLASH = "4_9";
    public static final String KEY_WEBAPP_NO_FLASH = "4_10";
    public static final String KEY_WEBKIT_INIT_FAILED_STATIC = "key_webkit_init_failed_static";
    public static final String KEY_WEBKIT_INIT_STATIC = "key_webkit_init_static";
    public static final String KEY_lINK_RECOMMSEARCH_WHITE_LIST = "32_6";
    public static final String SAILOR_BASE_ERROR_PAGE = "ERROR_PAGE";
    public static final String SAILOR_BASE_GEO = "GEO";
    public static final String SAILOR_BASE_SSL = "SSL";
    public static final String SAILOR_BASE_UPLOAD = "UPLOAD";
    public static final String SAILOR_BASE_ZEUS = "ZEUS";
    public static final String SAILOR_EXT_ADBLOCK = "ADBLOCK";
    public static final String SAILOR_EXT_ADBLOCK2 = "ADBLOCK2";
    public static final String SAILOR_EXT_ANTIHIJACK = "ANTIHIJACK";
    public static final String SAILOR_EXT_APPSWITCH = "APPSWITCH";
    public static final String SAILOR_EXT_ASYNC_SEARCH = "ASYNCSEARCH";
    public static final String SAILOR_EXT_BAIKE = "BAIKE";
    public static final String SAILOR_EXT_CONTENT_CAPTURE = "CONTENTCAPTURE";
    public static final String SAILOR_EXT_EMBED_AD = "EMBED_AD";
    public static final String SAILOR_EXT_ERROR_PAGE = "ERRORPAGE";
    public static final String SAILOR_EXT_ERRPG_SEARCH = "ERRORPAGESEARCH";
    public static final String SAILOR_EXT_JS_ACCOUNT = "bd_account";
    public static final String SAILOR_EXT_JS_COMMON_WIDGET = "bd_common_widget";
    public static final String SAILOR_EXT_JS_DAYMODE = "bd_daymode";
    public static final String SAILOR_EXT_JS_IMAGEMODE = "bd_imagemode";
    public static final String SAILOR_EXT_JS_LOCATION = "bd_location";
    public static final String SAILOR_EXT_JS_NETWORK = "bd_network";
    public static final String SAILOR_EXT_JS_PAGECONTENT = "bdbrowser_webcontent";
    public static final String SAILOR_EXT_JS_PRELOAD = "_bdbrowser_preload";
    public static final String SAILOR_EXT_JS_UTILS = "bd_utils";
    public static final String SAILOR_EXT_JS_VIDEO = "_bdbrowser_video";
    public static final String SAILOR_EXT_JS_WISE = "bd_wise";
    public static final String SAILOR_EXT_LIGHT_APP = "LIGHT_APP";
    public static final String SAILOR_EXT_LONGPRESS = "LONGPRESS";
    public static final String SAILOR_EXT_PICTURE_EXPLORER = "_bdbrowser_picexplorer";
    public static final String SAILOR_EXT_PRELOAD = "PRELOAD";
    public static final String SAILOR_EXT_PRELOAD_NEXT = "PRELOADNEXT";
    public static final String SAILOR_EXT_PRESEARCH = " PRESEARCH";
    public static final String SAILOR_EXT_READER = "_bdbrowser_reader";
    public static final String SAILOR_EXT_READMODE = "_bdbrowser_readmode";
    public static final String SAILOR_EXT_RECOMM_SEARCH = "EXTSEARCH";
    public static final String SAILOR_EXT_SCHEMA_INTERCEPT = "SCHEMAINTERCEPT";
    public static final String SAILOR_EXT_SLIDER = "SLIDER";
    public static final String SAILOR_EXT_WEBAPP = "WEBAPP";
    public static final String SAILOR_EXT_WEBVIEWPAGER = "WEBVIEWPAGER";
    public static final String SAILOR_URL_SAFE_CHECK_CLOUD_SWITCH = "searchbox_urlsafe_switch_pr";
    public static final int SAILOR_URL_SAFE_CHECK_CLOUD_SWITCH_CLOSE = 0;
    public static final int SAILOR_URL_SAFE_CHECK_CLOUD_SWITCH_OPEN = 1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1812519581, "Lcom/baidu/browser/sailor/BdSailorConfig;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1812519581, "Lcom/baidu/browser/sailor/BdSailorConfig;");
                return;
            }
        }
        BUILTIN_WEBKIT = BdWebkitManager.a.f24989c;
    }

    public BdSailorConfig() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }
}
