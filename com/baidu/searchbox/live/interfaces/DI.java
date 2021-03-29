package com.baidu.searchbox.live.interfaces;

import com.baidu.pyramid.runtime.service.ServiceReference;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\"\bÆ\u0002\u0018\u0000:\u0004!\"#$B\t\b\u0002¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0006\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0016\u0010\t\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0016\u0010\n\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0007R\u0016\u0010\f\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u0007R\u0016\u0010\r\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u0007R\u0016\u0010\u000e\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u0007R\u0016\u0010\u000f\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0007R\u0016\u0010\u0010\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0007R\u0016\u0010\u0011\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0007R\u0016\u0010\u0012\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0007R\u0016\u0010\u0013\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0007R\u0016\u0010\u0014\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0007R\u0016\u0010\u0015\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0007R\u0016\u0010\u0016\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0007R\u0016\u0010\u0017\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0007R\u0016\u0010\u0018\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0007R\u0016\u0010\u0019\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0007R\u0016\u0010\u001a\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0007R\u0016\u0010\u001b\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0007R\u0016\u0010\u001c\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001c\u0010\u0007R\u0016\u0010\u001d\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001d\u0010\u0007R\u0016\u0010\u001e\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001e\u0010\u0007¨\u0006%"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/DI;", "", "name", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "getServiceRef", "(Ljava/lang/String;)Lcom/baidu/pyramid/runtime/service/ServiceReference;", "AB_NAME", "Ljava/lang/String;", "ACCOUNT", "APP_INFO_NAME", "FOLLOW_STATUS", "LIGHTBROWSER_VIEW", "LIVE_AR_CONFIG", "LIVE_CUSTOM_SETTINGS", "LIVE_EVENT_DISPATCHER", "LIVE_FLOATING", "LIVE_GET_HOST_ALLACTIVITYS", "LIVE_LOCATION", "LIVE_NICK_NAME", "LIVE_PLAYER", "LIVE_REAL_AUTH", "LIVE_SHOW_TIMING", "LIVE_SHOW_VIDEO_PLAYER", "LIVE_STATUS_NOTIFY", "MODULE_NAME", "NET_NAME", "PAY_CHANNEL", "ROUTER_NAME", "SHARE_NAME", "THIRD_PART_ACCOUNT", "TOAST_NAME", "<init>", "()V", "BD", "EXT", "TB", "YY", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class DI {
    public static final String AB_NAME = "ab";
    public static final String ACCOUNT = "account";
    public static final String APP_INFO_NAME = "appInfo";
    public static final String FOLLOW_STATUS = "follow_status";
    public static final DI INSTANCE = new DI();
    public static final String LIGHTBROWSER_VIEW = "lightbrowser";
    public static final String LIVE_AR_CONFIG = "live_ar_config";
    public static final String LIVE_CUSTOM_SETTINGS = "live_custom_settings";
    public static final String LIVE_EVENT_DISPATCHER = "livve+event_dispatcher";
    public static final String LIVE_FLOATING = "floating";
    public static final String LIVE_GET_HOST_ALLACTIVITYS = "live_get_host_allactivitys";
    public static final String LIVE_LOCATION = "live_location";
    public static final String LIVE_NICK_NAME = "live_nick_name";
    public static final String LIVE_PLAYER = "player";
    public static final String LIVE_REAL_AUTH = "live_real_auth";
    public static final String LIVE_SHOW_TIMING = "live_show_timing";
    public static final String LIVE_SHOW_VIDEO_PLAYER = "live_show_video_player";
    public static final String LIVE_STATUS_NOTIFY = "live_status_notify";
    public static final String MODULE_NAME = "live";
    public static final String NET_NAME = "net";
    public static final String PAY_CHANNEL = "pay_channel";
    public static final String ROUTER_NAME = "router";
    public static final String SHARE_NAME = "share";
    public static final String THIRD_PART_ACCOUNT = "third_part_account";
    public static final String TOAST_NAME = "toast";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\r\bÆ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0003R\u0016\u0010\u0005\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0003R\u0016\u0010\u0006\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0003R\u0016\u0010\u0007\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0003R\u0016\u0010\b\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0003R\u0016\u0010\t\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0003R\u0016\u0010\n\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0003R\u0016\u0010\u000b\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0003¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/DI$BD;", "", "BD_IDENTITY", "Ljava/lang/String;", "COOL_PRAISE_PROXY", "FAVOR", "FEED_PAY", "IM_CHAT", "OEM_NAME", "OPEN_RED_PACKET_DETAIL", "VISIT_HISTORY", "YANHI_TAB_GUIDE", "<init>", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class BD {
        public static final String BD_IDENTITY = "bd_identity";
        public static final String COOL_PRAISE_PROXY = "cool_praise_proxy";
        public static final String FAVOR = "favor";
        public static final String FEED_PAY = "feed_pay";
        public static final String IM_CHAT = "im_chat";
        public static final BD INSTANCE = new BD();
        public static final String OEM_NAME = "oem";
        public static final String OPEN_RED_PACKET_DETAIL = "open_red_packet";
        public static final String VISIT_HISTORY = "visit_history";
        public static final String YANHI_TAB_GUIDE = "yanzhi_tab_guide";
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0003R\u0016\u0010\u0005\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0003¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/DI$EXT;", "", "EXT_LIVE_JUMP_PAGE", "Ljava/lang/String;", "EXT_LIVE_LOG", "EXT_LIVE_SESSION_ID", "<init>", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class EXT {
        public static final String EXT_LIVE_JUMP_PAGE = "ext_live_jump_page";
        public static final String EXT_LIVE_LOG = "ext_live_log";
        public static final String EXT_LIVE_SESSION_ID = "ext_live_session_id";
        public static final EXT INSTANCE = new EXT();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/DI$TB;", "", "SHARE_CHANNEL", "Ljava/lang/String;", "<init>", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class TB {
        public static final TB INSTANCE = new TB();
        public static final String SHARE_CHANNEL = "share_channel";
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\bÆ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0003R\u0016\u0010\u0005\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0003R\u0016\u0010\u0006\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0003¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/DI$YY;", "", "THIRD_PART_ALI_RECHARGE", "Ljava/lang/String;", "THIRD_PART_WX_RECHARGE", "YY_PLUGIN", "YY_TEST", "<init>", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class YY {
        public static final YY INSTANCE = new YY();
        public static final String THIRD_PART_ALI_RECHARGE = "third_part_ali_recharge";
        public static final String THIRD_PART_WX_RECHARGE = "third_part_wx_recharge";
        public static final String YY_PLUGIN = "yy_plugin";
        public static final String YY_TEST = "yy_test";
    }

    public final ServiceReference getServiceRef(String str) {
        return new ServiceReference("live", str);
    }
}
