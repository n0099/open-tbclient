package com.baidu.searchbox.download.center.clearcache;

import com.baidu.android.util.sp.SharedPrefsWrapper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0012\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0016\u0010\f\u001a\u00020\b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\nR\u0016\u0010\r\u001a\u00020\b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\nR\u0016\u0010\u000e\u001a\u00020\b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\nR\u0016\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\nR\u0016\u0010\u0010\u001a\u00020\b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\nR\u0016\u0010\u0011\u001a\u00020\b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\nR\u0016\u0010\u0012\u001a\u00020\b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\nR\u0016\u0010\u0013\u001a\u00020\b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\nR\u0016\u0010\u0014\u001a\u00020\b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\nR\u0016\u0010\u0015\u001a\u00020\b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\nR\u0016\u0010\u0016\u001a\u00020\b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0016\u0010\nR\u0016\u0010\u0017\u001a\u00020\b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/baidu/searchbox/download/center/clearcache/DiskManagerSharedPrefsUtils;", "Lcom/baidu/android/util/sp/SharedPrefsWrapper;", "", "CLEANUP_TIMEOUT_DEFAULT", "J", "DISK_CHECK_DURATION_DEFAULT", "NOTIFY_DELAYAFTERSTART_DEFAULT", "QUOTA_DATA_DEFAULT", "", "SP_KEY_APP_CRITICAL_LIMIT", "Ljava/lang/String;", "SP_KEY_APP_LIMIT_SWITCH", "SP_KEY_APP_LIMIT_SWITCH_OFF", "SP_KEY_APP_LIMIT_SWITCH_ON", "SP_KEY_APP_WARING_LIMIT", "SP_KEY_CLEANUP_TIMEOUT", "SP_KEY_CRITICAL_LIMIT", "SP_KEY_CURRENT_STATE", "SP_KEY_DEFAULT_DATA_VERSION", "SP_KEY_DIFF", "SP_KEY_DISK_CHECK_DURATION", "SP_KEY_NOTIFY_DELAYAFTERSTART", "SP_KEY_QUOTA_DATA", "SP_KEY_WARING_LIMIT", "<init>", "()V", "lib-clearcache-base_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public final class DiskManagerSharedPrefsUtils extends SharedPrefsWrapper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long CLEANUP_TIMEOUT_DEFAULT = 10;
    public static final long DISK_CHECK_DURATION_DEFAULT = 1800;
    public static final DiskManagerSharedPrefsUtils INSTANCE;
    public static final long NOTIFY_DELAYAFTERSTART_DEFAULT = 120;
    public static final long QUOTA_DATA_DEFAULT = 50;
    public static final String SP_KEY_APP_CRITICAL_LIMIT = "sp_key_clearcache_app_critical_limit";
    public static final String SP_KEY_APP_LIMIT_SWITCH = "sp_key_clearcache_app_limit_switch";
    public static final String SP_KEY_APP_LIMIT_SWITCH_OFF = "0";
    public static final String SP_KEY_APP_LIMIT_SWITCH_ON = "1";
    public static final String SP_KEY_APP_WARING_LIMIT = "sp_key_clearcache_app_waring_limit";
    public static final String SP_KEY_CLEANUP_TIMEOUT = "sp_key_cleanup_timeout";
    public static final String SP_KEY_CRITICAL_LIMIT = "sp_key_critical_limit";
    public static final String SP_KEY_CURRENT_STATE = "sp_key_current_state";
    public static final String SP_KEY_DEFAULT_DATA_VERSION = "sp_key_default_data_version";
    public static final String SP_KEY_DIFF = "sp_key_diff";
    public static final String SP_KEY_DISK_CHECK_DURATION = "sp_key_disk_check_duration";
    public static final String SP_KEY_NOTIFY_DELAYAFTERSTART = "sp_key_notify_delayafterstart";
    public static final String SP_KEY_QUOTA_DATA = "sp_key_quota_data";
    public static final String SP_KEY_WARING_LIMIT = "sp_key_waring_limit";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-315508622, "Lcom/baidu/searchbox/download/center/clearcache/DiskManagerSharedPrefsUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-315508622, "Lcom/baidu/searchbox/download/center/clearcache/DiskManagerSharedPrefsUtils;");
                return;
            }
        }
        INSTANCE = new DiskManagerSharedPrefsUtils();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiskManagerSharedPrefsUtils() {
        super(DiskManagerSharedPrefsUtilsKt.PRE_NAME);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }
}
