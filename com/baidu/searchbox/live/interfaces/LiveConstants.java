package com.baidu.searchbox.live.interfaces;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u0000:\u0001\u0003B\t\b\u0002¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/LiveConstants;", "<init>", "()V", "SdkToHostEvents", "lib-live-interfaces_debug"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes5.dex */
public final class LiveConstants {
    public static /* synthetic */ Interceptable $ic;
    public static final LiveConstants INSTANCE;
    public transient /* synthetic */ FieldHolder $fh;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\bÆ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0003R\u0016\u0010\u0005\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0003R\u0016\u0010\u0006\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0003R\u0016\u0010\u0007\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0003R\u0016\u0010\b\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0003R\u0016\u0010\t\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0003R\u0016\u0010\n\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0003R\u0016\u0010\u000b\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0003R\u0016\u0010\f\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u0003R\u0016\u0010\r\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u0003R\u0016\u0010\u000e\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u0003¨\u0006\u0011"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/LiveConstants$SdkToHostEvents;", "", "BUY_TBEAN_RESULT", "Ljava/lang/String;", "DO_LOG", "GO_FEEDBACK", "GO_USER_INFO", "KEY_PRE_DOWANLOAD_SWAN", "SUB_COMPONENT_END", "SUB_COMPONENT_PROGRESS", "SUB_COMPONENT_START", "SYNC_WEB_COOKIE", "YY_PLUGIN_END", "YY_PLUGIN_PROGRESS", "YY_PLUGIN_START", "<init>", "()V", "lib-live-interfaces_debug"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes5.dex */
    public static final class SdkToHostEvents {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String BUY_TBEAN_RESULT = "buy_tbean_result_callback";
        public static final String DO_LOG = "do_log";
        public static final String GO_FEEDBACK = "go_feedback";
        public static final String GO_USER_INFO = "go_user_info";
        public static final SdkToHostEvents INSTANCE;
        public static final String KEY_PRE_DOWANLOAD_SWAN = "preDowanloadSwan";
        public static final String SUB_COMPONENT_END = "sub_component_end";
        public static final String SUB_COMPONENT_PROGRESS = "sub_component_progress";
        public static final String SUB_COMPONENT_START = "sub_component_start";
        public static final String SYNC_WEB_COOKIE = "sync_web_cookie";
        public static final String YY_PLUGIN_END = "yy_plugin_end";
        public static final String YY_PLUGIN_PROGRESS = "yy_plugin_progress";
        public static final String YY_PLUGIN_START = "yy_plugin_start";
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1333493586, "Lcom/baidu/searchbox/live/interfaces/LiveConstants$SdkToHostEvents;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1333493586, "Lcom/baidu/searchbox/live/interfaces/LiveConstants$SdkToHostEvents;");
                    return;
                }
            }
            INSTANCE = new SdkToHostEvents();
        }

        public SdkToHostEvents() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1396191900, "Lcom/baidu/searchbox/live/interfaces/LiveConstants;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1396191900, "Lcom/baidu/searchbox/live/interfaces/LiveConstants;");
                return;
            }
        }
        INSTANCE = new LiveConstants();
    }

    public LiveConstants() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }
}
