package com.baidu.android.imsdk.utils;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
/* loaded from: classes2.dex */
public class SyncTimeManager {
    private static long lightAppId = 0;

    public static void writeUserInfoSyncTime(Context context, long j) {
        context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).edit().putLong(Constants.USERINFO_PREFIX + Utility.getUK(context) + lightAppId, j).commit();
    }

    public static long readUserInfoSyncTime(Context context) {
        return context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).getLong(Constants.USERINFO_PREFIX + Utility.getUK(context) + lightAppId, 0L);
    }

    public static void writeFriendGroupInfoSyncTime(Context context, long j) {
        context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).edit().putLong(Constants.FRINEDGROUP_PREFIX + Utility.getUK(context) + lightAppId, j).commit();
    }

    public static long readFriendGroupSyncTime(Context context) {
        return context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).getLong(Constants.FRINEDGROUP_PREFIX + Utility.getUK(context) + lightAppId, 0L);
    }
}
