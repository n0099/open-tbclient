package com.baidu.android.imsdk.utils;

import android.content.Context;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.internal.Constants;
/* loaded from: classes5.dex */
public class FriendListUtils {
    private static final long DEFAULT_LAST_TIME = 0;
    private static final String LAST_TIMESTAMP_PREFIX = "last_timestamp";
    private static final String PENULT_TIMESTAMP_PREFIX = "penult_timestamp";
    private static long mAppid;
    private static long mUk;
    private static long mLastTime = 0;
    private static final long DEFAULT_PENULT_TIME = -3;
    private static long mPenultTime = DEFAULT_PENULT_TIME;
    private static long mCurTime = -1;

    public static void init(Context context) {
        mUk = Utility.getUK(context);
        mAppid = AccountManager.getAppid(context);
        mLastTime = getLastTimeStamp(context);
        mPenultTime = getPenultTimeStamp(context);
    }

    public static boolean isNeedGetInfo(Context context) {
        return mLastTime != mPenultTime || mPenultTime == 0;
    }

    public static void updateGetFriendListTime(Context context, long j) {
        mCurTime = j;
        mPenultTime = mLastTime;
        setPenultTimeStamp(context, mPenultTime);
        mLastTime = mCurTime;
        setLastTimeStamp(context, mLastTime);
    }

    private static void setPenultTimeStamp(Context context, long j) {
        context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).edit().putLong(PENULT_TIMESTAMP_PREFIX + mUk + mAppid, j).commit();
    }

    private static long getPenultTimeStamp(Context context) {
        return context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).getLong(PENULT_TIMESTAMP_PREFIX + mUk + mAppid, DEFAULT_PENULT_TIME);
    }

    public static void setLastTimeStamp(Context context, long j) {
        context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).edit().putLong(LAST_TIMESTAMP_PREFIX + mUk + mAppid, j).commit();
    }

    public static long getLastTimeStamp(Context context) {
        return context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).getLong(LAST_TIMESTAMP_PREFIX + mUk + mAppid, 0L);
    }
}
