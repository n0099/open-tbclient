package com.baidu.searchbox;
/* loaded from: classes3.dex */
public final class IntentConstants {
    public static final String ACTION_ADD_CARD = "com.baidu.searchbox.intent.action.CARD_MADD";
    public static final String ACTION_ALOADER_VIEW = "com.baidu.searchbox.action.aloader.VIEW";
    public static final String ACTION_APPSEARCH = "com.baidu.searchbox.action.APPSEARCH";
    public static final String ACTION_APPSEARCH_MAIN = "com.baidu.searchbox.action.APPSEARCH_MAIN";
    public static final String ACTION_APPSEARCH_OTHER = "com.baidu.searchbox.action.APPSEARCH_OTHER";
    public static final String ACTION_ASSIST = "android.intent.action.ASSIST";
    public static final String ACTION_BAIDU_SEARCH = "com.baidu.searchbox.action.BAIDU_SEARCH";
    public static final String ACTION_BARCODE_HISTORY = "com.baidu.searchbox.action.BARCODE_HISTORY";
    public static final String ACTION_BOX_BROWSER = "android.intent.action.VIEW";
    public static final String ACTION_BROWSER = "com.baidu.searchbox.action.BROWSER";
    public static final String ACTION_CARD_MSG_NOTIFY = "com.baidu.searchbox.card.action.CARD_MSG_NOTIFY";
    public static final String ACTION_CARD_SEARCH = "com.baidu.searchbox.action.CARD_SEARCH";
    public static final String ACTION_DINGMANAGER = "com.baidu.searchbox.intent.action.VIEW_DING_MANAGER";
    public static final String ACTION_FASTSEARCH_RESULTS = "com.baidu.searchbox.action.FASTSEARCH";
    public static final String ACTION_HOME = "com.baidu.searchbox.action.HOME";
    public static final String ACTION_HOME_TAB = "com.baidu.searchbox.action.HOME_TAB";
    public static final String ACTION_LEAVE_AND_NOTICE = "com.baidu.searchbox.ACTION_LEAVE_AND_NOTICE";
    public static final String ACTION_LIGHT_SEARCH = "com.baidu.searchbox.action.LIGHT_SEARCH";
    public static final String ACTION_NOTIFICATION_DELETE = "com.baidu.searchbox.action.common.PUSH_NOTIFICATION_DELETE";
    public static final String ACTION_NOTIFICATION_EXPIRE = "com.baidu.searchbox.action.common.NOTIFICATION.EXPIRE";
    public static final String ACTION_NOVEL_TEST = "com.baidu.searchbox.intent.action.NOVEL";
    public static final String ACTION_PUSH_HOME_DATA = "com.baidu.searchbox.ACTION_PUSH_HOME_DATA";
    public static final String ACTION_PUSH_HOME_IS_FEED = "com.baidu.searchbox.ACTION_PUSH_HOME_IS_FEED";
    public static final String ACTION_PUSH_HOME_TOKEN = "com.baidu.searchbox.ACTION_PUSH_HOME_TOKEN";
    public static final String ACTION_PUSH_HOME_TYPE = "com.baidu.searchbox.ACTION_PUSH_HOME_DATA_TYPE";
    public static final String ACTION_RESUME_PLAY_HISTORY_VIDEO = "com.baidu.searchbox.player.action.RESUME_PLAY_HISTORY";
    public static final String ACTION_SEARCH = "com.baidu.searchbox.action.SEARCH";
    public static final String ACTION_START_READER = "com.baidu.searchbox.action.VIEW_WITH_GID";
    public static final String ACTION_VIEW = "com.baidu.searchbox.action.VIEW";
    public static final String ACTION_VOICE_SEARCH_RESULTS = "com.baidu.searchbox.action.VOICE_SEARCH_RESULTS";
    public static final String ACTION_WALLET = "com.baidu.searchbox.wallet.action.WALLET_VIEW";
    public static final String CATEGORY_ANALOG = "com.baidu.searchbox.category.ANALOG";
    public static final String CATEGORY_BAIDU_DEFAULT = "com.baidu.searchbox.category.DEFAULT";
    public static final String CATEGORY_DIGITAL = "com.baidu.searchbox.category.DIGITAL";
    public static final String CATEGORY_TRANSPARENT = "com.baidu.searchbox.category.TRANSPARENT";
    public static final String CATEGORY_TYPICAL = "com.baidu.searchbox.category.TYPICAL";
    public static final String CATEGORY_WOOD = "com.baidu.searchbox.category.WOOD";

    /* loaded from: classes3.dex */
    public interface ActivityClass {
        public static final String LIGHTBROWSERACTIVITY_CLASS_NAME = "com.baidu.searchbox.lightbrowser.LightBrowserActivity";
        public static final String LIGHTSEARCHACTIVITY_CLASS_NAME = "com.baidu.browser.search.LightSearchActivity";
        public static final String MAINACTIVITY_CLASS_NAME = "com.baidu.searchbox.MainActivity";
    }

    /* loaded from: classes3.dex */
    public interface Browser {
        public static final String EXTRA_HAS_BACK_WINDOW = "EXTRA_HAS_BACK_WINDOW";
        public static final String EXTRA_URL_NEW_WINDOW = "EXTRA_URL_NEW_WINDOW";
        public static final String SCHEME_SEARCH = "search://";
    }

    /* loaded from: classes3.dex */
    public interface Feed {
        public static final String EXTRA_AD_LOADING_PAGE_TYPE = "loading_page_type";
    }

    /* loaded from: classes3.dex */
    public interface LightBrowser {
        public static final String START_BROWSER_URL_KEY = "bdsb_light_start_url";
        public static final String START_WALLET_APPID = "bdsb_wallet_appid";
    }

    /* loaded from: classes3.dex */
    public interface Plugin {
        public static final String EXTRA_PARAMS = "params";
        public static final String EXTRA_WEBSITE_URL = "website_url";
    }

    /* loaded from: classes3.dex */
    public interface XSearch {
        public static final String XSEARCH_EXTRA_PAGEID = "pageId";
        public static final String XSEARCH_EXTRA_PAGEID_APPID = "appid";
        public static final String XSEARCH_EXTRA_PAGEURL = "url";
    }
}
