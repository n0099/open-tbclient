package com.baidu.live.business.model;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public class RequestUtil {
    public static final int ORI_STATE = 1;
    public static final int REFRESH_TYPE_BIG = 0;
    public static final int REFRESH_TYPE_SMALL = 1;
    public static final int REQ_STATE_BANNER = 1;
    public static final int REQ_STATE_FEED = 8;
    public static final int REQ_STATE_FOLLOW = 2;
    public static final int REQ_STATE_RESERVE = 16;
    public static final int REQ_STATE_TABS = 4;
    public static final int REQ_STATE_TOPIC = 32;
    public static int resource;

    public static String getResourceParam() {
        String str;
        if ((resource & 1) == 0) {
            str = "";
        } else {
            str = "banner,";
        }
        if ((resource & 2) != 0) {
            str = str + "follow,";
        }
        if ((resource & 4) != 0) {
            str = str + "tab,";
        }
        if ((resource & 8) != 0) {
            str = str + "feed,";
        }
        if ((resource & 16) != 0) {
            str = str + "reserve,";
        }
        if ((resource & 32) != 0) {
            str = str + "topic,";
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str.substring(0, str.length() - 1);
    }

    public static void setResource(int i) {
        resource = i;
    }
}
