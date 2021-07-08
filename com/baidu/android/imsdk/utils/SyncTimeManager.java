package com.baidu.android.imsdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class SyncTimeManager {
    public static /* synthetic */ Interceptable $ic;
    public static long lightAppId;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-2062707365, "Lcom/baidu/android/imsdk/utils/SyncTimeManager;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-2062707365, "Lcom/baidu/android/imsdk/utils/SyncTimeManager;");
        }
    }

    public SyncTimeManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static long readFriendGroupSyncTime(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0);
            return sharedPreferences.getLong(Constants.FRINEDGROUP_PREFIX + Utility.getUK(context) + lightAppId, 0L);
        }
        return invokeL.longValue;
    }

    public static long readUserInfoSyncTime(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0);
            return sharedPreferences.getLong(Constants.USERINFO_PREFIX + Utility.getUK(context) + lightAppId, 0L);
        }
        return invokeL.longValue;
    }

    public static void writeFriendGroupInfoSyncTime(Context context, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(InputDeviceCompat.SOURCE_TRACKBALL, null, context, j) == null) {
            SharedPreferences.Editor edit = context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).edit();
            edit.putLong(Constants.FRINEDGROUP_PREFIX + Utility.getUK(context) + lightAppId, j).commit();
        }
    }

    public static void writeUserInfoSyncTime(Context context, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(AdIconUtil.AD_TEXT_ID, null, context, j) == null) {
            SharedPreferences.Editor edit = context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).edit();
            edit.putLong(Constants.USERINFO_PREFIX + Utility.getUK(context) + lightAppId, j).commit();
        }
    }
}
