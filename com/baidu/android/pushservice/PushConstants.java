package com.baidu.android.pushservice;

import com.baidu.android.imsdk.IMConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class PushConstants {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BDUSS_ACTION_IGNORE = 0;
    public static final int BDUSS_ACTION_SIGN_IN = 1;
    public static final int BDUSS_ACTION_SIGN_OUT = 2;
    public static final String EXTRA_APP_NOTIFY_STATUS = "app_notify_status";
    public static final String EXTRA_BDUSS = "bduss";
    public static final String EXTRA_BDUSS_ACTION = "bduss_action";
    public static final String EXTRA_LOCATION = "location";
    public static final String EXTRA_PUSH_FREQ = "alert_freq";
    public static final int LOGIN_TYPE_API_KEY = 0;
    public static final int MSG_ERROR_APP_ID_DUPLICATE = 34;
    public static final int MSG_ERROR_APP_INVALID = 35;
    public static final int MSG_ERROR_SHOW_AND_DELETE = 30;
    public static final int MSG_ERROR_SHOW_FAIL_AND_DELETE = 32;
    public static final int MSG_ERROR_SHOW_FAIL_ONLY = 33;
    public static final int MSG_ERROR_SHOW_ONLY = 31;
    public static final int NOTIFY_STATUS_CLOSE = 0;
    public static final int NOTIFY_STATUS_OPEN = 1;
    public static final int NOTIFY_STATUS_UNKNOWN = 2;
    public static final int PUSH_FREQUENCY_CHOSEN = 5;
    public static final int PUSH_FREQUENCY_CORE = 4;
    public static final int PUSH_FREQUENCY_DEF = 0;
    public static final int PUSH_FREQUENCY_HIGH = 3;
    public static final int PUSH_FREQUENCY_LOW = 1;
    public static final int PUSH_FREQUENCY_MAX = 7;
    public static final int PUSH_FREQUENCY_MED = 2;
    public static final int PUSH_FREQUENCY_RICH = 6;
    public static final int PUSH_LAUNCH_TASK_LEVEY_BACK_NOT_LAUNCH = 1;
    public static final int PUSH_LAUNCH_TASK_LEVEY_GENERAL = 0;
    public transient /* synthetic */ FieldHolder $fh;

    public PushConstants() {
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

    public static String a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
            if (i != 0) {
                if (i != 30699) {
                    if (i != 110001) {
                        switch (i) {
                            case 10001:
                                return "Network Problem";
                            case 10002:
                                return "Service not available";
                            case 10003:
                                return "Service not available temporary";
                            default:
                                switch (i) {
                                    case 30600:
                                        return "Internal Server Error";
                                    case 30601:
                                        return "Method Not Allowed";
                                    case IMConstants.ERROR_GROUP_DISBAND /* 30602 */:
                                        return "Request Params Not Valid";
                                    case 30603:
                                        return "Authentication Failed";
                                    case 30604:
                                        return "Quota Use Up Payment Required";
                                    case 30605:
                                        return "Data Required Not Found";
                                    case 30606:
                                        return "Request Time Expires Timeout";
                                    case 30607:
                                        return "Channel Token Timeout";
                                    case 30608:
                                        return "Bind Relation Not Found";
                                    case 30609:
                                        return "Bind Number Too Many";
                                    case 30610:
                                        return "Duplicate Operation";
                                    case 30611:
                                        return "Group Not Found";
                                    case 30612:
                                        return "Application Forbidden, Need Whitelist Authorization";
                                    case 30613:
                                        return "App Need Inied First In Push-console";
                                    case 30614:
                                        return "Number Of Tag For User Too Many";
                                    case 30615:
                                        return "Number Of Tag For App Too Many";
                                    default:
                                        return "Unknown";
                                }
                        }
                    }
                    return "User blacked this app";
                }
                return "Requests Are Too Frequent To Be Temporarily Rejected";
            }
            return "Success";
        }
        return (String) invokeI.objValue;
    }
}
