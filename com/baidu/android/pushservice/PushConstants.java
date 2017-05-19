package com.baidu.android.pushservice;

import tv.danmaku.ijk.media.player.IjkMediaPlayer;
/* loaded from: classes2.dex */
public final class PushConstants {
    public static final String ACTION_MESSAGE = "com.baidu.android.pushservice.action.MESSAGE";
    public static final String ACTION_METHOD = "com.baidu.android.pushservice.action.METHOD";
    public static final String ACTION_RECEIVE = "com.baidu.android.pushservice.action.RECEIVE";
    public static final int ERROR_SUCCESS = 0;
    public static final String EXTRA_APP = "app";
    public static final String EXTRA_CONTENT = "content";
    public static final String EXTRA_ERROR_CODE = "error_msg";
    public static final String EXTRA_METHOD = "method";
    public static final String EXTRA_PUSH_MESSAGE = "message";
    public static final int LOGIN_TYPE_ACCESS_TOKEN = 1;
    public static final int LOGIN_TYPE_API_KEY = 0;
    public static final int LOGIN_TYPE_BDUSS = 2;
    public static final int LOGIN_TYPE_LIGHT_APP_API_KEY = 4;
    public static final int LOGIN_TYPE_WEB_APP_API_KEY = 3;
    public static final String METHOD_BIND = "method_bind";
    public static final String PACKAGE_NAME = "pkg_name";

    public static String a(int i) {
        switch (i) {
            case 0:
                return "Success";
            case IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND /* 10001 */:
                return "Network Problem";
            case IjkMediaPlayer.PROP_FLOAT_VIDEO_OUTPUT_FRAMES_PER_SECOND /* 10002 */:
                return "Service not available";
            case IjkMediaPlayer.FFP_PROP_FLOAT_PLAYBACK_RATE /* 10003 */:
                return "Service not available temporary";
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
            case 30616:
                return "Application Do Not Have Unicast Capability";
            case 30617:
                return "Application Do Not Have Multicast Capability";
            case 30618:
                return "Application Is Not Approved, Can Not Use The Push Service";
            case 30699:
                return "Requests Are Too Frequent To Be Temporarily Rejected";
            case 40002:
                return "Get lightapp info fail";
            case 110001:
                return "User blacked this app";
            default:
                return "Unknown";
        }
    }
}
