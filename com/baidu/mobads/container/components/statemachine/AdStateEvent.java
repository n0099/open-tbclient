package com.baidu.mobads.container.components.statemachine;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class AdStateEvent {
    public static /* synthetic */ Interceptable $ic = null;
    public static String EVENT_AD_TIMEOUT = "ato";
    public static String EVENT_APO_FB_ACT = "apoFbAct";
    public static String EVENT_DL_TYPE = "dlType";
    public static String EVENT_LP_CLICKS = "lpClicks";
    public static String EVENT_REQUEST_TIME = "requestTime";
    public static String EVENT_RESPONSE_TIME = "responseTime";
    public static String EVENT_TIME_AD_CLICK = "tAdClick";
    public static String EVENT_TIME_LP_CLOSE = "tLpClose";
    public static String EVENT_TIME_LP_CREATE = "tLpCreate";
    public static String EVENT_TIME_LP_FINISH = "tLpFinish";
    public static String EVENT_TIME_LP_LOAD = "tLpLoadUrl";
    public static String EVENT_TIME_LP_LOADED = "tLpLoaded";
    public static String EVENT_TIME_LP_START = "tLpStart";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(990553744, "Lcom/baidu/mobads/container/components/statemachine/AdStateEvent;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(990553744, "Lcom/baidu/mobads/container/components/statemachine/AdStateEvent;");
        }
    }

    public AdStateEvent() {
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
