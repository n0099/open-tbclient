package com.baidu.searchbox.live.interfaces;

import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.managers.setting.GlobalSetting;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b8\bÆ\u0002\u0018\u0000:\u000656789:B\t\b\u0002¢\u0006\u0004\b3\u00104J\u0015\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0006\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0016\u0010\t\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0016\u0010\n\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0007R\u0016\u0010\f\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u0007R\u0016\u0010\r\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u0007R\u0016\u0010\u000e\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u0007R\u0016\u0010\u000f\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0007R\u0016\u0010\u0010\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0007R\u0016\u0010\u0011\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0007R\u0016\u0010\u0012\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0007R\u0016\u0010\u0013\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0007R\u0016\u0010\u0014\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0007R\u0016\u0010\u0015\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0007R\u0016\u0010\u0016\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0007R\u0016\u0010\u0017\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0007R\u0016\u0010\u0018\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0007R\u0016\u0010\u0019\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0007R\u0016\u0010\u001a\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0007R\u0016\u0010\u001b\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0007R\u0016\u0010\u001c\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001c\u0010\u0007R\u0016\u0010\u001d\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001d\u0010\u0007R\u0016\u0010\u001e\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001e\u0010\u0007R\u0016\u0010\u001f\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001f\u0010\u0007R\u0016\u0010 \u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b \u0010\u0007R\u0016\u0010!\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b!\u0010\u0007R\u0016\u0010\"\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\"\u0010\u0007R\u0016\u0010#\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b#\u0010\u0007R\u0016\u0010$\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b$\u0010\u0007R\u0016\u0010%\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b%\u0010\u0007R\u0016\u0010&\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b&\u0010\u0007R\u0016\u0010'\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b'\u0010\u0007R\u0016\u0010(\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b(\u0010\u0007R\u0016\u0010)\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b)\u0010\u0007R\u0016\u0010*\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b*\u0010\u0007R\u0016\u0010+\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b+\u0010\u0007R\u0016\u0010,\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b,\u0010\u0007R\u0016\u0010-\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b-\u0010\u0007R\u0016\u0010.\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b.\u0010\u0007R\u0016\u0010/\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b/\u0010\u0007R\u0016\u00100\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b0\u0010\u0007R\u0016\u00101\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b1\u0010\u0007R\u0016\u00102\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b2\u0010\u0007¨\u0006;"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/DI;", "", "name", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "getServiceRef", "(Ljava/lang/String;)Lcom/baidu/pyramid/runtime/service/ServiceReference;", "AB_NAME", "Ljava/lang/String;", "ACCOUNT", "APP_INFO_NAME", "AUDIO_FLOAT_SERVICE", "FOLLOW_STATUS", "LIGHTBROWSER_VIEW", "LIVE_AR_CONFIG", "LIVE_BOOK_SIMPLE_CONTROLLER", "LIVE_BOTTOM_LIST_MENU", "LIVE_CUSTOM_SETTINGS", "LIVE_DISK", "LIVE_EVENT_DISPATCHER", "LIVE_FLOATING", "LIVE_GET_HOST_ALLACTIVITYS", "LIVE_LIKE", "LIVE_LOCATION", "LIVE_NICK_NAME", "LIVE_PLAYER", "LIVE_PLUGIN_LOADED", "LIVE_QR_CODE", "LIVE_REAL_AUTH", "LIVE_SHOW_TIMING", "LIVE_SHOW_VIDEO_PLAYER", "LIVE_STATUS_NOTIFY", "LIVE_TEXT_SELECT", "LIVE_USER_SECURITY_BEHAVIOR", "LIVE_USER_SECURITY_DEVICE_INFO", "LIVE_VOICE_RECOGNIZE", "LIVE_WEB_DATA_CHANNEL_BRIDGE", "LIVE_YALOG", "LIVE_YY_RTC", "MODULE_NAME", "NET_NAME", "PAY_CHANNEL", "PERMISSION_REQUEST", "REDENVELOP_PENDENT_ANIMATION_VIEW", "REDENVELOP_SEND_COMTROLLER", "ROUTER_NAME", "SHARE_NAME", "STORAGEMANAGER_INFO_SERVICE", "STORAGEMANAGER_SERVICE", "THIRD_PART_ACCOUNT", "TOAST_NAME", "UPLOAD_FILE_REQUEST", "<init>", "()V", GlobalSetting.BD_SDK_WRAPPER, "BJH", "EXT", "TB", "YY", "YYPAY", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public final class DI {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AB_NAME = "ab";
    public static final String ACCOUNT = "account";
    public static final String APP_INFO_NAME = "appInfo";
    public static final String AUDIO_FLOAT_SERVICE = "audio_float_service";
    public static final String FOLLOW_STATUS = "follow_status";
    public static final DI INSTANCE;
    public static final String LIGHTBROWSER_VIEW = "lightbrowser";
    public static final String LIVE_AR_CONFIG = "live_ar_config";
    public static final String LIVE_BOOK_SIMPLE_CONTROLLER = "live_video_controller";
    public static final String LIVE_BOTTOM_LIST_MENU = "live_bottom_list_menu";
    public static final String LIVE_CUSTOM_SETTINGS = "live_custom_settings";
    public static final String LIVE_DISK = "live_disk";
    public static final String LIVE_EVENT_DISPATCHER = "live_event_dispatcher";
    public static final String LIVE_FLOATING = "floating";
    public static final String LIVE_GET_HOST_ALLACTIVITYS = "live_get_host_allactivitys";
    public static final String LIVE_LIKE = "live_like";
    public static final String LIVE_LOCATION = "live_location";
    public static final String LIVE_NICK_NAME = "live_nick_name";
    public static final String LIVE_PLAYER = "player";
    public static final String LIVE_PLUGIN_LOADED = "live_plugin_loaded";
    public static final String LIVE_QR_CODE = "live_qr_code";
    public static final String LIVE_REAL_AUTH = "live_real_auth";
    public static final String LIVE_SHOW_TIMING = "live_show_timing";
    public static final String LIVE_SHOW_VIDEO_PLAYER = "live_show_video_player";
    public static final String LIVE_STATUS_NOTIFY = "live_status_notify";
    public static final String LIVE_TEXT_SELECT = "live_text_select";
    public static final String LIVE_USER_SECURITY_BEHAVIOR = "live_user_security_behavior";
    public static final String LIVE_USER_SECURITY_DEVICE_INFO = "live_user_security_device_info";
    public static final String LIVE_VOICE_RECOGNIZE = "live_voice_recognize";
    public static final String LIVE_WEB_DATA_CHANNEL_BRIDGE = "live_web_data_channel_bridge";
    public static final String LIVE_YALOG = "live_yalog";
    public static final String LIVE_YY_RTC = "live_yy_rtc";
    public static final String MODULE_NAME = "live";
    public static final String NET_NAME = "net";
    public static final String PAY_CHANNEL = "pay_channel";
    public static final String PERMISSION_REQUEST = "permission_request";
    public static final String REDENVELOP_PENDENT_ANIMATION_VIEW = "redenvelop_pendent_animview_interface";
    public static final String REDENVELOP_SEND_COMTROLLER = "redenvelop_sent_controller";
    public static final String ROUTER_NAME = "router";
    public static final String SHARE_NAME = "share";
    public static final String STORAGEMANAGER_INFO_SERVICE = "storage_manager_info_service";
    public static final String STORAGEMANAGER_SERVICE = "storage_manager_service";
    public static final String THIRD_PART_ACCOUNT = "third_part_account";
    public static final String TOAST_NAME = "toast";
    public static final String UPLOAD_FILE_REQUEST = "upload_file_request";
    public transient /* synthetic */ FieldHolder $fh;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\r\bÆ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0003R\u0016\u0010\u0005\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0003R\u0016\u0010\u0006\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0003R\u0016\u0010\u0007\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0003R\u0016\u0010\b\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0003R\u0016\u0010\t\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0003R\u0016\u0010\n\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0003R\u0016\u0010\u000b\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0003¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/DI$BD;", "", "BD_IDENTITY", "Ljava/lang/String;", "COOL_PRAISE_PROXY", "FAVOR", "FEED_PAY", "IM_CHAT", "OEM_NAME", "OPEN_RED_PACKET_DETAIL", "VISIT_HISTORY", "YANHI_TAB_GUIDE", "<init>", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes4.dex */
    public static final class BD {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String BD_IDENTITY = "bd_identity";
        public static final String COOL_PRAISE_PROXY = "cool_praise_proxy";
        public static final String FAVOR = "favor";
        public static final String FEED_PAY = "feed_pay";
        public static final String IM_CHAT = "im_chat";
        public static final BD INSTANCE;
        public static final String OEM_NAME = "oem";
        public static final String OPEN_RED_PACKET_DETAIL = "open_red_packet";
        public static final String VISIT_HISTORY = "visit_history";
        public static final String YANHI_TAB_GUIDE = "yanzhi_tab_guide";
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(65329670, "Lcom/baidu/searchbox/live/interfaces/DI$BD;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(65329670, "Lcom/baidu/searchbox/live/interfaces/DI$BD;");
                    return;
                }
            }
            INSTANCE = new BD();
        }

        public BD() {
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/DI$BJH;", "", "BJH_GUIDE_MANAGE", "Ljava/lang/String;", "<init>", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes4.dex */
    public static final class BJH {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String BJH_GUIDE_MANAGE = "guide_manage";
        public static final BJH INSTANCE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2025225998, "Lcom/baidu/searchbox/live/interfaces/DI$BJH;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2025225998, "Lcom/baidu/searchbox/live/interfaces/DI$BJH;");
                    return;
                }
            }
            INSTANCE = new BJH();
        }

        public BJH() {
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0003R\u0016\u0010\u0005\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0003¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/DI$EXT;", "", "EXT_LIVE_JUMP_PAGE", "Ljava/lang/String;", "EXT_LIVE_LOG", "EXT_LIVE_SESSION_ID", "<init>", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes4.dex */
    public static final class EXT {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String EXT_LIVE_JUMP_PAGE = "ext_live_jump_page";
        public static final String EXT_LIVE_LOG = "ext_live_log";
        public static final String EXT_LIVE_SESSION_ID = "ext_live_session_id";
        public static final EXT INSTANCE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2025329197, "Lcom/baidu/searchbox/live/interfaces/DI$EXT;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2025329197, "Lcom/baidu/searchbox/live/interfaces/DI$EXT;");
                    return;
                }
            }
            INSTANCE = new EXT();
        }

        public EXT() {
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/DI$TB;", "", "SHARE_CHANNEL", "Ljava/lang/String;", "<init>", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes4.dex */
    public static final class TB {
        public static /* synthetic */ Interceptable $ic = null;
        public static final TB INSTANCE;
        public static final String SHARE_CHANNEL = "share_channel";
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(65346906, "Lcom/baidu/searchbox/live/interfaces/DI$TB;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(65346906, "Lcom/baidu/searchbox/live/interfaces/DI$TB;");
                    return;
                }
            }
            INSTANCE = new TB();
        }

        public TB() {
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\bÆ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0003R\u0016\u0010\u0005\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0003R\u0016\u0010\u0006\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0003R\u0016\u0010\u0007\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0003R\u0016\u0010\b\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0003R\u0016\u0010\t\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0003R\u0016\u0010\n\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0003¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/DI$YY;", "", "LIVE_OKHTTP_BRIDGE", "Ljava/lang/String;", "MULTI_PLUGIN", "THIRD_PART_ALI_RECHARGE", "THIRD_PART_DXM_RECHARGE", "THIRD_PART_WX_RECHARGE", "YY_HDID", YYLiveNPSPluginManager.TAG, "YY_TEST", "<init>", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes4.dex */
    public static final class YY {
        public static /* synthetic */ Interceptable $ic = null;
        public static final YY INSTANCE;
        public static final String LIVE_OKHTTP_BRIDGE = "okhttp_bridge";
        public static final String MULTI_PLUGIN = "multi_plugin";
        public static final String THIRD_PART_ALI_RECHARGE = "third_part_ali_recharge";
        public static final String THIRD_PART_DXM_RECHARGE = "third_part_dxm_recharge";
        public static final String THIRD_PART_WX_RECHARGE = "third_part_wx_recharge";
        public static final String YY_HDID = "yy_hdid";
        public static final String YY_PLUGIN = "yy_plugin";
        public static final String YY_TEST = "yy_test";
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(65352424, "Lcom/baidu/searchbox/live/interfaces/DI$YY;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(65352424, "Lcom/baidu/searchbox/live/interfaces/DI$YY;");
                    return;
                }
            }
            INSTANCE = new YY();
        }

        public YY() {
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0003¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/DI$YYPAY;", "", "YY_PAY", "Ljava/lang/String;", "YY_PAY_HOST_DATA", "<init>", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes4.dex */
    public static final class YYPAY {
        public static /* synthetic */ Interceptable $ic = null;
        public static final YYPAY INSTANCE;
        public static final String YY_PAY = "yy_pay";
        public static final String YY_PAY_HOST_DATA = "yy_pay_host_data";
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1294569190, "Lcom/baidu/searchbox/live/interfaces/DI$YYPAY;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1294569190, "Lcom/baidu/searchbox/live/interfaces/DI$YYPAY;");
                    return;
                }
            }
            INSTANCE = new YYPAY();
        }

        public YYPAY() {
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(386810218, "Lcom/baidu/searchbox/live/interfaces/DI;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(386810218, "Lcom/baidu/searchbox/live/interfaces/DI;");
                return;
            }
        }
        INSTANCE = new DI();
    }

    public DI() {
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

    public final ServiceReference getServiceRef(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? new ServiceReference("live", str) : (ServiceReference) invokeL.objValue;
    }
}
