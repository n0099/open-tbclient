package com.baidu.android.imsdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.android.imsdk.internal.Constants;
/* loaded from: classes.dex */
public class SyncTimeManager {
    public static long lightAppId;

    public static long readFriendGroupSyncTime(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0);
        return sharedPreferences.getLong(Constants.FRINEDGROUP_PREFIX + Utility.getUK(context) + lightAppId, 0L);
    }

    public static long readUserInfoSyncTime(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0);
        return sharedPreferences.getLong(Constants.USERINFO_PREFIX + Utility.getUK(context) + lightAppId, 0L);
    }

    public static void writeFriendGroupInfoSyncTime(Context context, long j) {
        SharedPreferences.Editor edit = context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).edit();
        edit.putLong(Constants.FRINEDGROUP_PREFIX + Utility.getUK(context) + lightAppId, j).commit();
    }

    public static void writeUserInfoSyncTime(Context context, long j) {
        SharedPreferences.Editor edit = context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).edit();
        edit.putLong(Constants.USERINFO_PREFIX + Utility.getUK(context) + lightAppId, j).commit();
    }
}
