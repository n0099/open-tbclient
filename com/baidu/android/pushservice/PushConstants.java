package com.baidu.android.pushservice;

import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceConstant;
/* loaded from: classes2.dex */
public final class PushConstants {
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
    public static final int PUSH_FREQUENCY_DEF = 0;
    public static final int PUSH_FREQUENCY_HIGH = 3;
    public static final int PUSH_FREQUENCY_LOW = 1;
    public static final int PUSH_FREQUENCY_MED = 2;

    public static String a(int i) {
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
                                case 30602:
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
        return HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_SUCCESS;
    }
}
