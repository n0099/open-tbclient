package com.baidu.android.imrtc.utils;

import android.content.Context;
/* loaded from: classes.dex */
public class Utility {
    public static String getCuid(Context context) {
        return RtcUtility.getCuid(context);
    }

    public static String getRtcAppId(Context context) {
        return RtcUtility.getRtcAppId(context);
    }

    public static String getRtcRoomToken(Context context) {
        return RtcUtility.getRtcRoomToken(context);
    }
}
