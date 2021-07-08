package com.baidu.android.imrtc.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class RtcUtility {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_APPID = "appid";
    public static final String KEY_BDUID = "bduid";
    public static final String KEY_CUID = "cuid";
    public static final String KEY_RTC_APP_ID = "rtc_app_id";
    public static final String KEY_RTC_DEBUG = "rtc_debug";
    public static final String KEY_RTC_ROOM_DES = "rtc_room_des";
    public static final String KEY_RTC_ROOM_ID = "rtc_room_id";
    public static final String KEY_RTC_ROOM_NAME = "rtc_room_name";
    public static final String KEY_RTC_ROOM_TOKEN = "rtc_room_token";
    public static final String KEY_RTC_USER_ID = "rtc_user_id";
    public static final String KEY_UK = "uk";
    public static final String PREF_COMMON_DATA = "bim_rtc_sp";
    public static final String TAG = "Utility";
    public transient /* synthetic */ FieldHolder $fh;

    public RtcUtility() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static long getAppId(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) ? readLongData(context, "appid", -1L) : invokeL.longValue;
    }

    public static int getAppState(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            String str = "empty";
            while (true) {
                int i2 = 0;
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                    if (runningAppProcessInfo.processName.equals(context.getPackageName())) {
                        str = runningAppProcessInfo.processName;
                        int i3 = runningAppProcessInfo.importance;
                        if (i3 != 400 && i3 == 100) {
                            break;
                        }
                        i2 = 1;
                    }
                }
                LogUtils.d("Utility", "process = " + str + "   background = " + i2);
                return i2;
            }
        }
        return invokeL.intValue;
    }

    public static String getAppVersionName(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (PackageManager.NameNotFoundException e2) {
                LogUtils.e("Utility", "getAppVersionName NameNotFoundException", e2);
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String getBduid(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) ? readStringData(context, "bduid", "") : (String) invokeL.objValue;
    }

    public static String getCuid(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) {
            String readStringData = readStringData(context, "cuid", "");
            if (TextUtils.isEmpty(readStringData) || readStringData.equals("device_id")) {
                String deviceId = com.baidu.android.imsdk.utils.Utility.getDeviceId(context);
                setCuid(context, deviceId);
                return deviceId;
            }
            return readStringData;
        }
        return (String) invokeL.objValue;
    }

    public static long getIMUK(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) ? readLongData(context, "uk", -1L) : invokeL.longValue;
    }

    public static String getRtcAppId(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) ? readStringData(context, KEY_RTC_APP_ID, "") : (String) invokeL.objValue;
    }

    public static String getRtcRoomDes(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) ? readStringData(context, KEY_RTC_ROOM_DES, "") : (String) invokeL.objValue;
    }

    public static String getRtcRoomId(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) ? readStringData(context, "rtc_room_id", "") : (String) invokeL.objValue;
    }

    public static String getRtcRoomName(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) ? readStringData(context, KEY_RTC_ROOM_NAME, "") : (String) invokeL.objValue;
    }

    public static String getRtcRoomToken(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) ? readStringData(context, KEY_RTC_ROOM_TOKEN, "") : (String) invokeL.objValue;
    }

    public static long getRtcUserId(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, context)) == null) ? readLongData(context, KEY_RTC_USER_ID, 0L) : invokeL.longValue;
    }

    public static boolean isRtcDebug(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, null, context)) == null) ? readBooleanData(context, KEY_RTC_DEBUG, false) : invokeL.booleanValue;
    }

    public static boolean readBooleanData(Context context, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65551, null, context, str, z)) == null) {
            if (context == null) {
                return false;
            }
            return context.getSharedPreferences(PREF_COMMON_DATA, 0).getBoolean(str, z);
        }
        return invokeLLZ.booleanValue;
    }

    public static int readIntData(Context context, String str, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65552, null, context, str, i2)) == null) {
            if (context == null) {
                return -1;
            }
            return context.getSharedPreferences(PREF_COMMON_DATA, 0).getInt(str, i2);
        }
        return invokeLLI.intValue;
    }

    public static long readLongData(Context context, String str, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65553, null, new Object[]{context, str, Long.valueOf(j)})) == null) {
            if (context == null) {
                return -1L;
            }
            return context.getSharedPreferences(PREF_COMMON_DATA, 0).getLong(str, j);
        }
        return invokeCommon.longValue;
    }

    public static String readStringData(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65554, null, context, str, str2)) == null) ? context == null ? "" : context.getSharedPreferences(PREF_COMMON_DATA, 0).getString(str, str2) : (String) invokeLLL.objValue;
    }

    public static void setAppId(Context context, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65555, null, context, j) == null) {
            writeLongData(context, "appid", j);
        }
    }

    public static void setBduid(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65556, null, context, str) == null) {
            writeStringData(context, "bduid", str);
        }
    }

    public static void setCuid(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65557, null, context, str) == null) {
            writeStringData(context, "cuid", str);
        }
    }

    public static void setIMUK(Context context, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65558, null, context, j) == null) {
            writeLongData(context, "uk", j);
        }
    }

    public static void setRtcAppId(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65559, null, context, str) == null) {
            writeStringData(context, KEY_RTC_APP_ID, str);
        }
    }

    public static void setRtcDebug(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65560, null, context, z) == null) {
            writeBooleanData(context, KEY_RTC_DEBUG, z);
        }
    }

    public static void setRtcRoomDes(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65561, null, context, str) == null) {
            writeStringData(context, KEY_RTC_ROOM_DES, str);
        }
    }

    public static void setRtcRoomId(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65562, null, context, str) == null) {
            writeStringData(context, "rtc_room_id", str);
        }
    }

    public static void setRtcRoomName(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65563, null, context, str) == null) {
            writeStringData(context, KEY_RTC_ROOM_NAME, str);
        }
    }

    public static void setRtcRoomToken(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65564, null, context, str) == null) {
            writeStringData(context, KEY_RTC_ROOM_TOKEN, str);
        }
    }

    public static void setRtcUserId(Context context, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65565, null, context, j) == null) {
            writeLongData(context, KEY_RTC_USER_ID, j);
        }
    }

    public static void writeBooleanData(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65566, null, context, str, z) == null) {
            writeSPData(context, str, Boolean.valueOf(z));
        }
    }

    public static void writeIntData(Context context, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65567, null, context, str, i2) == null) {
            writeSPData(context, str, Integer.valueOf(i2));
        }
    }

    public static void writeLongData(Context context, String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65568, null, new Object[]{context, str, Long.valueOf(j)}) == null) {
            writeSPData(context, str, Long.valueOf(j));
        }
    }

    public static void writeObjectData(SharedPreferences sharedPreferences, String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65569, null, sharedPreferences, str, obj) == null) {
            if (obj instanceof Boolean) {
                sharedPreferences.edit().putBoolean(str, ((Boolean) obj).booleanValue()).apply();
            } else if (obj instanceof Integer) {
                sharedPreferences.edit().putInt(str, ((Integer) obj).intValue()).apply();
            } else if (obj instanceof Long) {
                sharedPreferences.edit().putLong(str, ((Long) obj).longValue()).apply();
            } else if (obj instanceof Float) {
                sharedPreferences.edit().putFloat(str, ((Float) obj).floatValue()).apply();
            } else if (obj instanceof String) {
                sharedPreferences.edit().putString(str, (String) obj).apply();
            }
        }
    }

    public static void writeSPData(Context context, String str, Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65570, null, context, str, obj) == null) || context == null) {
            return;
        }
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_COMMON_DATA, 0);
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                TaskManager.getInstance().submitForNetWork(new Runnable(sharedPreferences, str, obj) { // from class: com.baidu.android.imrtc.utils.RtcUtility.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Object val$data;
                    public final /* synthetic */ String val$key;
                    public final /* synthetic */ SharedPreferences val$preferences;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {sharedPreferences, str, obj};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$preferences = sharedPreferences;
                        this.val$key = str;
                        this.val$data = obj;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            RtcUtility.writeObjectData(this.val$preferences, this.val$key, this.val$data);
                        }
                    }
                });
            } else {
                writeObjectData(sharedPreferences, str, obj);
            }
        } catch (Throwable th) {
            LogUtils.e("Utility", th.getMessage());
        }
    }

    public static void writeStringData(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65571, null, context, str, str2) == null) {
            writeSPData(context, str, str2);
        }
    }
}
