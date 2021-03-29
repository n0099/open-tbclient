package com.baidu.android.imsdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.internal.Constants;
/* loaded from: classes.dex */
public class FriendListUtils {
    public static final long DEFAULT_LAST_TIME = 0;
    public static final long DEFAULT_PENULT_TIME = -3;
    public static final String LAST_TIMESTAMP_PREFIX = "last_timestamp";
    public static final String PENULT_TIMESTAMP_PREFIX = "penult_timestamp";
    public static long mAppid = 0;
    public static long mCurTime = -1;
    public static long mLastTime = 0;
    public static long mPenultTime = -3;
    public static long mUk;

    public static long getLastTimeStamp(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0);
        return sharedPreferences.getLong(LAST_TIMESTAMP_PREFIX + mUk + mAppid, 0L);
    }

    public static long getPenultTimeStamp(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0);
        return sharedPreferences.getLong(PENULT_TIMESTAMP_PREFIX + mUk + mAppid, -3L);
    }

    public static void init(Context context) {
        mUk = Utility.getUK(context);
        mAppid = AccountManager.getAppid(context);
        mLastTime = getLastTimeStamp(context);
        mPenultTime = getPenultTimeStamp(context);
    }

    public static boolean isNeedGetInfo(Context context) {
        long j = mLastTime;
        long j2 = mPenultTime;
        return j != j2 || j2 == 0;
    }

    public static void setLastTimeStamp(Context context, long j) {
        SharedPreferences.Editor edit = context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).edit();
        edit.putLong(LAST_TIMESTAMP_PREFIX + mUk + mAppid, j).commit();
    }

    public static void setPenultTimeStamp(Context context, long j) {
        SharedPreferences.Editor edit = context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).edit();
        edit.putLong(PENULT_TIMESTAMP_PREFIX + mUk + mAppid, j).commit();
    }

    public static void updateGetFriendListTime(Context context, long j) {
        mCurTime = j;
        long j2 = mLastTime;
        mPenultTime = j2;
        setPenultTimeStamp(context, j2);
        long j3 = mCurTime;
        mLastTime = j3;
        setLastTimeStamp(context, j3);
    }
}
