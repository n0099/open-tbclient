package com.baidu.android.imsdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class FriendListUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long DEFAULT_LAST_TIME = 0;
    public static final long DEFAULT_PENULT_TIME = -3;
    public static final String LAST_TIMESTAMP_PREFIX = "last_timestamp";
    public static final String PENULT_TIMESTAMP_PREFIX = "penult_timestamp";
    public static long mAppid = 0;
    public static long mCurTime = -1;
    public static long mLastTime = 0;
    public static long mPenultTime = -3;
    public static long mUk;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-244669397, "Lcom/baidu/android/imsdk/utils/FriendListUtils;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-244669397, "Lcom/baidu/android/imsdk/utils/FriendListUtils;");
        }
    }

    public FriendListUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static long getLastTimeStamp(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0);
            return sharedPreferences.getLong(LAST_TIMESTAMP_PREFIX + mUk + mAppid, 0L);
        }
        return invokeL.longValue;
    }

    public static long getPenultTimeStamp(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0);
            return sharedPreferences.getLong(PENULT_TIMESTAMP_PREFIX + mUk + mAppid, -3L);
        }
        return invokeL.longValue;
    }

    public static void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context) == null) {
            mUk = Utility.getUK(context);
            mAppid = AccountManager.getAppid(context);
            mLastTime = getLastTimeStamp(context);
            mPenultTime = getPenultTimeStamp(context);
        }
    }

    public static boolean isNeedGetInfo(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            long j = mLastTime;
            long j2 = mPenultTime;
            return j != j2 || j2 == 0;
        }
        return invokeL.booleanValue;
    }

    public static void setLastTimeStamp(Context context, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65542, null, context, j) == null) {
            SharedPreferences.Editor edit = context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).edit();
            edit.putLong(LAST_TIMESTAMP_PREFIX + mUk + mAppid, j).commit();
        }
    }

    public static void setPenultTimeStamp(Context context, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65543, null, context, j) == null) {
            SharedPreferences.Editor edit = context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).edit();
            edit.putLong(PENULT_TIMESTAMP_PREFIX + mUk + mAppid, j).commit();
        }
    }

    public static void updateGetFriendListTime(Context context, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65544, null, context, j) == null) {
            mCurTime = j;
            long j2 = mLastTime;
            mPenultTime = j2;
            setPenultTimeStamp(context, j2);
            long j3 = mCurTime;
            mLastTime = j3;
            setLastTimeStamp(context, j3);
        }
    }
}
