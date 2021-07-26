package com.baidu.cyberplayer.sdk;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.main.facesdk.statistic.DeviceInfoUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
@Keep
/* loaded from: classes2.dex */
public class DeviceInfoUtils {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static String f4835a;

    /* renamed from: b  reason: collision with root package name */
    public static String f4836b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(214740422, "Lcom/baidu/cyberplayer/sdk/DeviceInfoUtils;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(214740422, "Lcom/baidu/cyberplayer/sdk/DeviceInfoUtils;");
        }
    }

    public DeviceInfoUtils() {
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

    public static String getAvailMemorySize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            ActivityManager activityManager = (ActivityManager) CyberPlayerManager.getApplicationContext().getSystemService("activity");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            if (activityManager != null) {
                activityManager.getMemoryInfo(memoryInfo);
                return String.valueOf(memoryInfo.availMem / 1000);
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public static String getBatteryHealth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            Intent registerReceiver = CyberPlayerManager.getApplicationContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver != null) {
                return String.valueOf(registerReceiver.getIntExtra("health", 1));
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public static String[] getBatteryInfos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            Intent registerReceiver = CyberPlayerManager.getApplicationContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            String[] strArr = new String[7];
            if (registerReceiver != null) {
                strArr[0] = String.valueOf(registerReceiver.getIntExtra("health", 1));
                strArr[1] = String.valueOf(registerReceiver.getIntExtra("status", 1));
                strArr[2] = String.valueOf(registerReceiver.getIntExtra("level", 0));
                strArr[3] = String.valueOf(registerReceiver.getIntExtra("scale", 0));
                strArr[4] = String.valueOf(registerReceiver.getIntExtra("voltage", 0));
                strArr[5] = String.valueOf(registerReceiver.getIntExtra("temperature", 0));
                strArr[6] = registerReceiver.getStringExtra("technology");
                return strArr;
            }
            return null;
        }
        return (String[]) invokeV.objValue;
    }

    public static String getBatteryLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            Intent registerReceiver = CyberPlayerManager.getApplicationContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver != null) {
                return String.valueOf(registerReceiver.getIntExtra("level", 0));
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public static String getBatteryScale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            Intent registerReceiver = CyberPlayerManager.getApplicationContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver != null) {
                return String.valueOf(registerReceiver.getIntExtra("scale", 0));
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public static String getBatteryStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            Intent registerReceiver = CyberPlayerManager.getApplicationContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver != null) {
                return String.valueOf(registerReceiver.getIntExtra("status", 1));
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public static String getBatteryTechnology() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            Intent registerReceiver = CyberPlayerManager.getApplicationContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver != null) {
                return registerReceiver.getStringExtra("technology");
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public static String getBatteryTemperature() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            Intent registerReceiver = CyberPlayerManager.getApplicationContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver != null) {
                return String.valueOf(registerReceiver.getIntExtra("temperature", 0));
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public static String getBatteryVoltage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            Intent registerReceiver = CyberPlayerManager.getApplicationContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver != null) {
                return String.valueOf(registerReceiver.getIntExtra("voltage", 0));
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public static String getCurCpuFreq() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            try {
                return new BufferedReader(new FileReader(DeviceInfoUtil.CurPath)).readLine().trim();
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
                return null;
            } catch (IOException e3) {
                e3.printStackTrace();
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String getDeviceBoard() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? Build.BOARD : (String) invokeV.objValue;
    }

    public static String getDeviceBrand() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? Build.BRAND : (String) invokeV.objValue;
    }

    public static int getDeviceDensityDpi(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, null, context)) == null) ? context.getResources().getDisplayMetrics().densityDpi : invokeL.intValue;
    }

    public static String getDeviceDevice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? Build.DEVICE : (String) invokeV.objValue;
    }

    public static String getDeviceDisplay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? Build.DISPLAY : (String) invokeV.objValue;
    }

    public static String getDeviceFubgerprint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? Build.FINGERPRINT : (String) invokeV.objValue;
    }

    public static String getDeviceHardware() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? Build.HARDWARE : (String) invokeV.objValue;
    }

    public static int getDeviceHeight(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65555, null, context)) == null) ? context.getResources().getDisplayMetrics().heightPixels : invokeL.intValue;
    }

    public static String getDeviceHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) ? Build.HOST : (String) invokeV.objValue;
    }

    public static String getDeviceId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) ? Build.ID : (String) invokeV.objValue;
    }

    public static String getDeviceManufacturer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) ? Build.MANUFACTURER : (String) invokeV.objValue;
    }

    public static String getDeviceModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) ? Build.MODEL : (String) invokeV.objValue;
    }

    public static String getDeviceProduct() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) ? Build.PRODUCT : (String) invokeV.objValue;
    }

    public static String getDeviceSerial() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) ? Build.SERIAL : (String) invokeV.objValue;
    }

    public static String getDeviceUser() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65562, null)) == null) ? Build.USER : (String) invokeV.objValue;
    }

    public static int getDeviceWidth(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65563, null, context)) == null) ? context.getResources().getDisplayMetrics().widthPixels : invokeL.intValue;
    }

    public static String getMaxCpuFreq() {
        InterceptResult invokeV;
        String str;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65564, null)) == null) {
            String str2 = f4835a;
            if (str2 != null) {
                return str2;
            }
            try {
                InputStream inputStream = new ProcessBuilder("/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq").start().getInputStream();
                String str3 = "";
                while (inputStream.read(new byte[24]) != -1) {
                    str3 = str3 + new String(bArr);
                }
                str = str3.trim();
                inputStream.close();
            } catch (IOException e2) {
                e2.printStackTrace();
                str = null;
            }
            if (str != null) {
                f4835a = str;
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public static String[] getMemoryInfos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65565, null)) == null) {
            String[] strArr = new String[3];
            ActivityManager activityManager = (ActivityManager) CyberPlayerManager.getApplicationContext().getSystemService("activity");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            if (activityManager != null) {
                activityManager.getMemoryInfo(memoryInfo);
                strArr[0] = String.valueOf(memoryInfo.totalMem / 1000);
                strArr[1] = String.valueOf(memoryInfo.availMem / 1000);
                strArr[2] = String.valueOf(memoryInfo.threshold / 1000);
                return strArr;
            }
            return null;
        }
        return (String[]) invokeV.objValue;
    }

    public static String getMemorySize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65566, null)) == null) {
            ActivityManager activityManager = (ActivityManager) CyberPlayerManager.getApplicationContext().getSystemService("activity");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            if (activityManager != null) {
                activityManager.getMemoryInfo(memoryInfo);
                return String.valueOf(memoryInfo.totalMem / 1000);
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public static String getMemoryThresholdSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65567, null)) == null) {
            ActivityManager activityManager = (ActivityManager) CyberPlayerManager.getApplicationContext().getSystemService("activity");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            if (activityManager != null) {
                activityManager.getMemoryInfo(memoryInfo);
                return String.valueOf(memoryInfo.threshold / 1000);
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public static String getMinCpuFreq() {
        InterceptResult invokeV;
        String str;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65568, null)) == null) {
            String str2 = f4836b;
            if (str2 != null) {
                return str2;
            }
            try {
                InputStream inputStream = new ProcessBuilder("/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq").start().getInputStream();
                String str3 = "";
                while (inputStream.read(new byte[24]) != -1) {
                    str3 = str3 + new String(bArr);
                }
                str = str3.trim();
                inputStream.close();
            } catch (IOException e2) {
                e2.printStackTrace();
                str = null;
            }
            if (str != null) {
                f4836b = str;
            }
            return str;
        }
        return (String) invokeV.objValue;
    }
}
