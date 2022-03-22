package c.a.o0.r.j0;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = "com.baidu.tieba";

    /* renamed from: b  reason: collision with root package name */
    public static String f10586b = "com.baidu.tieba:remote";

    /* renamed from: c  reason: collision with root package name */
    public static String f10587c = "com.baidu.tieba:bdservice_v1";

    /* renamed from: d  reason: collision with root package name */
    public static String f10588d = "com.baidu.tieba:pluginInstaller";

    /* renamed from: e  reason: collision with root package name */
    public static String f10589e = "com.baidu.tieba:daemon";

    /* renamed from: f  reason: collision with root package name */
    public static String f10590f = "com.baidu.tieba:cdnTachometer";

    /* renamed from: g  reason: collision with root package name */
    public static String f10591g = "plugininstaller_settings";

    /* renamed from: h  reason: collision with root package name */
    public static String f10592h = "daemon_settings";
    public static String i = "cdnTachometer_settings";
    public static final String[] j;
    public static final String[] k;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1074939074, "Lc/a/o0/r/j0/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1074939074, "Lc/a/o0/r/j0/a;");
                return;
            }
        }
        j = new String[]{"skin_", "from_id", "bd_loc_crash_count", "webview_crash_count", "bd_loc_switcher", "install_other_app_file_name", "cuid", "new_cuid", "new_cuid_galaxy2", "gpu_open", "client_id", "keepalive_wifi", "keepalive_nonwifi", "networkcore_type", "socket_reconn_strategy", "image_quality", "capable_of_webp_format", "webp_failure_count", "log_stat_upload_time ", "log_stat_debug_time", "log_stat_switch_data", "log_stat_error_time", "is_motu_forbidden", "cdn_iplist_cache_key_three", "report_user_info_time_key", "image_viewer_tip", "location_lat", "location_lng", "location_pos", "location_on", "xiaoying_crash_count", "plugin_patch_hook_failed_count", "page_stay_duration_switch", "page_stay_max_cost", "applist_intalled_apk_ids", "applist_intalled_apk_ids_timestamp", "KEY_UPLOAD_LOG_INTERVAL", "KEY_LOG_REAL_TIME_UPLOAD_SWITCH", "smart_app_tid", "smart_app_id", "smart_app_name", "key_ai_app_guide_display", "AD_SNIFF_RESULT_KEY", "key_baiduid_for_anti", "key_secret_is_show_new", "key_qq_share_h5_enable", "key_wechat_small_app_to_h5", "key_launch_up_speed", "fun_ad_big_image_floor", "fun_ad_big_image_density", "fun_ad_big_image_size", "fun_ad_big_image_switch", "key_post_thread_has_request_location", "key_sync_extra_field", "key_member_auto_ban_renewal_show"};
        k = new String[0];
    }
}
