package com.baidu.sofire.utility;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.PowerManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.sofire.ac.DeviceInfoCallback;
import com.baidu.sofire.sharedpreferences.SharedPreferenceManager;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class PrivacyOperationUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long DAY = 86400000;
    public static final long SECOND = 1000;
    public static DeviceInfoCallback mDeviceInfoCallback = null;
    public static boolean sAllowAndroidId = true;
    public static boolean sAllowBackgroundNetwork = true;
    public static boolean sAllowImei = true;
    public static boolean sAllowNetOperator = true;
    public static boolean sAllowOaid = true;
    public static boolean sAllowReadSdCard = true;
    public static boolean sAllowReadSettings = true;
    public static boolean sAllowSimOperator = true;
    public static boolean sAllowWriteSdCard = true;
    public static boolean sAllowWriteSettings = true;
    public static String sAndroidIdTmp;
    public static long sAndroidIdTmpTime;
    public static String sExternalCuidTmp;
    public static long sExternalCuidTmpTime;
    public static String sImeiTmp;
    public static long sImeiTmpTime;
    public static boolean sIsForegroundTmp;
    public static long sIsForegroundTmpTime;
    public static String sNetworkOperatorTmp;
    public static long sNetworkOperatorTmpTime;
    public static String sOaidTmp;
    public static long sOaidTmpTime;
    public static boolean sPolicyLoaded;
    public static String sSettingCuidTmp;
    public static long sSettingCuidTmpTime;
    public static String sSimOperatorNameTmp;
    public static long sSimOperatorNameTmpTime;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(831226312, "Lcom/baidu/sofire/utility/PrivacyOperationUtil;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(831226312, "Lcom/baidu/sofire/utility/PrivacyOperationUtil;");
        }
    }

    public PrivacyOperationUtil() {
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

    public static boolean allowNetwork(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (context == null) {
                return false;
            }
            return sAllowBackgroundNetwork || checkForeground(context);
        }
        return invokeL.booleanValue;
    }

    public static boolean allowReadSdCard(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) ? context != null && sAllowReadSdCard && checkBaseLimit(context) : invokeL.booleanValue;
    }

    public static boolean allowReadSettings(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) ? context != null && sAllowReadSettings && checkBaseLimit(context) : invokeL.booleanValue;
    }

    public static boolean allowWriteSdCard(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) ? context != null && sAllowWriteSdCard && checkBaseLimit(context) : invokeL.booleanValue;
    }

    public static boolean allowWriteSettings(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) ? context != null && sAllowWriteSettings && checkBaseLimit(context) : invokeL.booleanValue;
    }

    public static boolean checkBaseLimit(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) ? PrivacyPolicyUtil.check(context) && checkForeground(context) : invokeL.booleanValue;
    }

    public static boolean checkForeground(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            if (System.currentTimeMillis() - sIsForegroundTmpTime < 1000) {
                return sIsForegroundTmp;
            }
            sIsForegroundTmp = isScreenOn(context) && isHostAppForeground(context);
            sIsForegroundTmpTime = System.currentTimeMillis();
            return sIsForegroundTmp;
        }
        return invokeL.booleanValue;
    }

    public static String getAndroidId(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            if (context != null) {
                try {
                    if (sAllowAndroidId && PrivacyPolicyUtil.check(context)) {
                        if (System.currentTimeMillis() - sAndroidIdTmpTime < 86400000) {
                            return sAndroidIdTmp;
                        }
                        SharedPreferenceManager sharedPreferenceManager = SharedPreferenceManager.getInstance(context);
                        if (TextUtils.isEmpty(sAndroidIdTmp)) {
                            sAndroidIdTmp = sharedPreferenceManager.getAndroidIdTmp();
                            sAndroidIdTmpTime = sharedPreferenceManager.getAndroidIdTmpTime();
                            if (System.currentTimeMillis() - sAndroidIdTmpTime < 86400000) {
                                return sAndroidIdTmp;
                            }
                        }
                        if (!checkForeground(context)) {
                            return sAndroidIdTmp;
                        }
                        String string = Settings.Secure.getString(context.getContentResolver(), HttpRequest.ANDROID_ID);
                        if (!TextUtils.isEmpty(string)) {
                            sAndroidIdTmp = string;
                            sAndroidIdTmpTime = System.currentTimeMillis();
                            sharedPreferenceManager.setAndroidIdTmp(sAndroidIdTmp);
                            sharedPreferenceManager.setAndroidIdTmpTime(sAndroidIdTmpTime);
                        } else {
                            long currentTimeMillis = System.currentTimeMillis();
                            sAndroidIdTmpTime = currentTimeMillis;
                            sharedPreferenceManager.setAndroidIdTmpTime(currentTimeMillis);
                        }
                        return sAndroidIdTmp;
                    }
                } catch (Throwable th) {
                    CommonMethods.handleNuLException(th);
                    return "";
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static DeviceInfoCallback getDeviceInfoCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? mDeviceInfoCallback : (DeviceInfoCallback) invokeV.objValue;
    }

    public static String getExternalCuid(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            if (context != null) {
                try {
                    if (sAllowReadSdCard && PrivacyPolicyUtil.check(context)) {
                        if (System.currentTimeMillis() - sExternalCuidTmpTime < 86400000) {
                            return sExternalCuidTmp;
                        }
                        SharedPreferenceManager sharedPreferenceManager = SharedPreferenceManager.getInstance(context);
                        if (TextUtils.isEmpty(sExternalCuidTmp)) {
                            sExternalCuidTmp = sharedPreferenceManager.getExternalCuidTmp();
                            sExternalCuidTmpTime = sharedPreferenceManager.getExternalCuidTmpTime();
                            if (System.currentTimeMillis() - sExternalCuidTmpTime < 86400000) {
                                return sExternalCuidTmp;
                            }
                        }
                        if (!PermissionChecker.hasSdReadPermission(context)) {
                            return sExternalCuidTmp;
                        }
                        if (!checkForeground(context)) {
                            return sExternalCuidTmp;
                        }
                        String externalCuid = DbUtil.getExternalCuid(context);
                        if (!TextUtils.isEmpty(externalCuid)) {
                            sExternalCuidTmp = externalCuid;
                            sExternalCuidTmpTime = System.currentTimeMillis();
                            sharedPreferenceManager.setExternalCuidTmp(sExternalCuidTmp);
                            sharedPreferenceManager.setExternalCuidTmpTime(sExternalCuidTmpTime);
                        } else {
                            long currentTimeMillis = System.currentTimeMillis();
                            sExternalCuidTmpTime = currentTimeMillis;
                            sharedPreferenceManager.setExternalCuidTmpTime(currentTimeMillis);
                        }
                        return sExternalCuidTmp;
                    }
                } catch (Throwable th) {
                    CommonMethods.handleNuLException(th);
                    return "";
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String getIMEI(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) {
            if (context != null) {
                try {
                    if (sAllowImei && PrivacyPolicyUtil.check(context)) {
                        if (System.currentTimeMillis() - sImeiTmpTime < 86400000) {
                            return sImeiTmp;
                        }
                        if (CommonMethods.PKGNAME_HUAWEI_INPUT.equals(context.getPackageName())) {
                            return "";
                        }
                        SharedPreferenceManager sharedPreferenceManager = SharedPreferenceManager.getInstance(context);
                        if (TextUtils.isEmpty(sImeiTmp)) {
                            sImeiTmp = sharedPreferenceManager.getImeiTmp();
                            sImeiTmpTime = sharedPreferenceManager.getImeiTmpTime();
                            if (System.currentTimeMillis() - sImeiTmpTime < 86400000) {
                                return sImeiTmp;
                            }
                        }
                        if (!PermissionChecker.hasImeiPermission(context)) {
                            return sImeiTmp;
                        }
                        if (!checkForeground(context)) {
                            return sImeiTmp;
                        }
                        String deviceId = Build.VERSION.SDK_INT < 29 ? ((TelephonyManager) context.getSystemService("phone")).getDeviceId() : "";
                        if (!TextUtils.isEmpty(deviceId)) {
                            sImeiTmp = deviceId;
                            sImeiTmpTime = System.currentTimeMillis();
                            sharedPreferenceManager.setImeiTmp(sImeiTmp);
                            sharedPreferenceManager.setImeiTmpTime(sImeiTmpTime);
                        } else {
                            long currentTimeMillis = System.currentTimeMillis();
                            sImeiTmpTime = currentTimeMillis;
                            sharedPreferenceManager.setImeiTmpTime(currentTimeMillis);
                        }
                        return sImeiTmp;
                    }
                } catch (Throwable th) {
                    CommonMethods.handleNuLException(th);
                    return "";
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String getSettingCuid(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, context)) == null) {
            if (context != null) {
                try {
                    if (sAllowReadSettings && PrivacyPolicyUtil.check(context)) {
                        if (System.currentTimeMillis() - sSettingCuidTmpTime < 86400000) {
                            return sSettingCuidTmp;
                        }
                        SharedPreferenceManager sharedPreferenceManager = SharedPreferenceManager.getInstance(context);
                        if (TextUtils.isEmpty(sExternalCuidTmp)) {
                            sSettingCuidTmp = sharedPreferenceManager.getSettingCuidTmp();
                            sSettingCuidTmpTime = sharedPreferenceManager.getSettingCuidTmpTime();
                            if (System.currentTimeMillis() - sSettingCuidTmpTime < 86400000) {
                                return sSettingCuidTmp;
                            }
                        }
                        if (!checkForeground(context)) {
                            return sSettingCuidTmp;
                        }
                        String loadSettingDeviceId = DbUtil.loadSettingDeviceId(context);
                        if (!TextUtils.isEmpty(loadSettingDeviceId)) {
                            sSettingCuidTmp = loadSettingDeviceId;
                            sSettingCuidTmpTime = System.currentTimeMillis();
                            sharedPreferenceManager.setSettingCuidTmp(sSettingCuidTmp);
                            sharedPreferenceManager.setSettingCuidTmpTime(sSettingCuidTmpTime);
                        } else {
                            long currentTimeMillis = System.currentTimeMillis();
                            sSettingCuidTmpTime = currentTimeMillis;
                            sharedPreferenceManager.setSettingCuidTmpTime(currentTimeMillis);
                        }
                        return sSettingCuidTmp;
                    }
                } catch (Throwable th) {
                    CommonMethods.handleNuLException(th);
                    return "";
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static boolean isHostAppForeground(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, context)) == null) {
            try {
                if (Build.VERSION.SDK_INT < 21) {
                    return isHostAppForegroundBelow21(context);
                }
                if (context != null) {
                    for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                        if (runningAppProcessInfo.importance == 100 && runningAppProcessInfo.importanceReasonCode == 0 && runningAppProcessInfo.pkgList != null && runningAppProcessInfo.pkgList.length != 0 && Arrays.asList(runningAppProcessInfo.pkgList).contains(context.getPackageName())) {
                            return true;
                        }
                    }
                    return false;
                }
                return false;
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean isHostAppForegroundBelow21(Context context) {
        InterceptResult invokeL;
        ActivityManager.RunningTaskInfo runningTaskInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, context)) == null) {
            try {
                ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
                if (activityManager.getRunningTasks(1) == null || (runningTaskInfo = activityManager.getRunningTasks(1).get(0)) == null) {
                    return false;
                }
                return context.getPackageName().equals(runningTaskInfo.topActivity.getPackageName());
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean isScreenOn(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, context)) == null) {
            try {
                return ((PowerManager) context.getSystemService("power")).isScreenOn();
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static synchronized void loadPolicy(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, context) == null) {
            synchronized (PrivacyOperationUtil.class) {
                if (context == null) {
                    return;
                }
                try {
                    if (sPolicyLoaded) {
                        return;
                    }
                    sPolicyLoaded = true;
                    updatePolicyToMemory(new JSONObject(SharedPreferenceManager.getInstance(context).getPrivacyConfig()));
                } catch (Throwable th) {
                    CommonMethods.handleNuLException(th);
                }
            }
        }
    }

    public static void setDeviceInfoCallback(DeviceInfoCallback deviceInfoCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, null, deviceInfoCallback) == null) {
            mDeviceInfoCallback = deviceInfoCallback;
        }
    }

    public static void updatePolicy(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65555, null, context, jSONObject) == null) || context == null || jSONObject == null) {
            return;
        }
        try {
            SharedPreferenceManager.getInstance(context).setPrivacyConfig(jSONObject.toString());
            updatePolicyToMemory(jSONObject);
        } catch (Throwable th) {
            CommonMethods.handleNuLException(th);
        }
    }

    public static void updatePolicyToMemory(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65556, null, jSONObject) == null) || jSONObject == null) {
            return;
        }
        sAllowBackgroundNetwork = jSONObject.optInt("0", 1) != 0;
        JSONArray optJSONArray = jSONObject.optJSONArray("1");
        if (optJSONArray == null) {
            return;
        }
        HashSet hashSet = new HashSet();
        for (int i = 0; i < optJSONArray.length(); i++) {
            hashSet.add(Integer.valueOf(optJSONArray.optInt(i)));
        }
        if (hashSet.contains(27)) {
            sAllowImei = false;
        } else {
            sAllowImei = true;
        }
        if (hashSet.contains(34)) {
            sAllowSimOperator = false;
        } else {
            sAllowSimOperator = true;
        }
        if (hashSet.contains(40)) {
            sAllowAndroidId = false;
        } else {
            sAllowAndroidId = true;
        }
        if (hashSet.contains(41)) {
            sAllowOaid = false;
        } else {
            sAllowOaid = true;
        }
        if (hashSet.contains(42)) {
            sAllowReadSettings = false;
        } else {
            sAllowReadSettings = true;
        }
        if (hashSet.contains(43)) {
            sAllowWriteSettings = false;
        } else {
            sAllowWriteSettings = true;
        }
        if (hashSet.contains(44)) {
            sAllowReadSdCard = false;
        } else {
            sAllowReadSdCard = true;
        }
        if (hashSet.contains(45)) {
            sAllowWriteSdCard = false;
        } else {
            sAllowWriteSdCard = true;
        }
        if (hashSet.contains(46)) {
            sAllowNetOperator = false;
        } else {
            sAllowNetOperator = true;
        }
    }
}
