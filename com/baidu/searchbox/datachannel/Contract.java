package com.baidu.searchbox.datachannel;

import android.text.TextUtils;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.ugc.model.UgcConstant;
/* loaded from: classes16.dex */
public class Contract {
    public static final String ACCOUNT_LOGIN_STATUS = "com.baidu.channel.account.loginstatus";
    public static final String ACTION_DATA_CHANNEL_DEMO = "com.baidu.channel.demo";
    public static final String ALADDIN_DOWNLOADAPK_ACTION = "com.baidu.channel.aladdin.downloadapk";
    public static final String COMMENT_NUM_ACTION = "com.baidu.channel.comment.num";
    public static final String COMMENT_VOTE_SUCCESS = "com.baidu.channel.votesubmit";
    public static final String DATA_CHANNEL_MODULE_NAME = "datachannel";
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String DEFAULT_HOST = "defaultHost";
    public static final String DEFAULT_PAGE = "defaultPage";
    public static final String FEED_ITEM_DATA_UPDATE_ACTION = "com.baidu.channel.feed.assistmessage";
    public static final String FORWARD_NUM_ACTION = "com.baidu.channel.forward.num";
    public static final String HOST_BATTLE_HOME = "battleHome";
    public static final String HOST_BD_EXPLORE_VIEW = "bdExploreView";
    public static final String HOST_DATA_CHANNEL_DEMO = "dataChannelDemo";
    public static final String HOST_FEED_DETAIL = "feedDetail";
    public static final String HOST_HOME_FEED_VIEW = "homeFeedView";
    public static final String HOST_LIGHT_BROWSER = "lightBrowser";
    public static final String HOST_LIGHT_BROWSER_FRAGMENT = "lightBrowserFragment";
    public static final String HOST_WEB_VIEW_FRAGMENT = "webviewfragment";
    public static final String INTENT_KEY_ACTION = "action";
    public static final String INTENT_KEY_DATA = "data";
    public static final String MINI_DETAIL_POSTNOTIFICATIONTYPE_ANCHOR = "com.baidu.channel.minivideo.location";
    public static final String MINI_DETAIL_POSTNOTIFICATIONTYPE_COLLECT = "com.baidu.channel.minivideo.collect";
    public static final String MINI_DETAIL_POSTNOTIFICATIONTYPE_COMMENT = "com.baidu.channel.minivideo.comment";
    public static final String MINI_DETAIL_POSTNOTIFICATIONTYPE_FOLLOW = "com.baidu.channel.minivideo.follow";
    public static final String MINI_DETAIL_POSTNOTIFICATIONTYPE_PRAISE = "com.baidu.channel.minivideo.praise";
    public static final String MINI_DETAIL_UGC_PUBLISH_FINISH_ANCHOR = "com.baidu.channel.ugc.publish_finish";
    public static final String PAGE_DATA_CHANNEL_DEMO_APS = "dataChannelDemoAPS";
    public static final String PAGE_DATA_CHANNEL_DEMO_NA = "dataChannelDemoNa";
    public static final String PAGE_DATA_CHANNEL_DEMO_RN = "dataChannelDemoRn";
    public static final String PAGE_DATA_CHANNEL_DEMO_WEB = "dataChannelDemoWeb";
    public static final String PROFILE_CHANGED = "com.baidu.channel.account.profilechanged";
    public static final String SCHEME_ACTION_REGISTER = "register";
    public static final String SCHEME_ACTION_SEND_BROADCAST = "sendbroadcast";
    public static final String SCHEME_ACTION_UNREGISTER = "unregister";
    public static final String SCHEME_HOST_DATA_CHANNEL = "datachannel";
    public static final String SCHEME_KEY_ACTION = "action";
    public static final String SCHEME_KEY_ALLOWDUPLICATE = "allowDuplicate";
    public static final String SCHEME_KEY_DATA = "data";
    public static final String SCHEME_KEY_HOST = "host";
    public static final String SCHEME_KEY_JSCALLBACK = "jscallback";
    public static final String SCHEME_KEY_PAGE = "page";
    public static final String SCHEME_KEY_RN_MSG = "rnmsg";
    public static final String TAG = "dataChannelTag";
    public static final String TOOL_BAR_LIKE_INFO_UPDATE_ACTION = "com.baidu.channel.like";

    public static String getDataChannelReceiverHostKey(String str, Object obj) {
        String str2 = TextUtils.isEmpty(str) ? DEFAULT_HOST : str;
        return obj == null ? str2 : str2 + UgcConstant.AT_RULE_TAG + String.valueOf(obj.hashCode());
    }
}
