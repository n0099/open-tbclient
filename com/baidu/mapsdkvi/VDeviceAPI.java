package com.baidu.mapsdkvi;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Environment;
import android.os.PowerManager;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.PhoneNumberUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.webkit.MimeTypeMap;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.aideviceperformance.utils.HardwareInfoUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
/* loaded from: classes10.dex */
public class VDeviceAPI {
    public static /* synthetic */ Interceptable $ic;
    public static PowerManager.WakeLock a;

    /* renamed from: b  reason: collision with root package name */
    public static BroadcastReceiver f36144b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-668360355, "Lcom/baidu/mapsdkvi/VDeviceAPI;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-668360355, "Lcom/baidu/mapsdkvi/VDeviceAPI;");
        }
    }

    public VDeviceAPI() {
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

    public static String getAppVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            try {
                return b.a().getPackageManager().getPackageInfo(b.a().getApplicationInfo().packageName, 0).versionName;
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public static long getAvailableMemory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) b.a().getSystemService("activity")).getMemoryInfo(memoryInfo);
            return memoryInfo.availMem / 1024;
        }
        return invokeV.longValue;
    }

    public static String getCachePath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? Environment.getDataDirectory().getAbsolutePath() : (String) invokeV.objValue;
    }

    public static int getCurrentNetworkType() {
        InterceptResult invokeV;
        NetworkInfo networkInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            try {
                networkInfo = ((ConnectivityManager) b.a().getSystemService("connectivity")).getActiveNetworkInfo();
            } catch (Exception unused) {
                networkInfo = null;
            }
            if (networkInfo == null) {
                return 0;
            }
            int type = networkInfo.getType();
            if (type != 0) {
                return type != 1 ? 1 : 2;
            }
            return 3;
        }
        return invokeV.intValue;
    }

    public static long getFreeSpace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            StatFs statFs = new StatFs(Environment.getRootDirectory().getPath());
            return (statFs.getBlockSize() * statFs.getAvailableBlocks()) / 1024;
        }
        return invokeV.longValue;
    }

    public static String getModuleFileName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? b.a().getFilesDir().getAbsolutePath() : (String) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0028 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static c getNetworkInfo(int i2) {
        InterceptResult invokeI;
        int i3;
        NetworkInfo networkInfo;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeI = interceptable.invokeI(65544, null, i2)) != null) {
            return (c) invokeI.objValue;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) b.a().getSystemService("connectivity");
        if (i2 == 2) {
            i3 = 1;
        } else if (i2 != 3) {
            networkInfo = null;
            if (networkInfo == null) {
                return new c(networkInfo);
            }
            return null;
        } else {
            i3 = 0;
        }
        networkInfo = connectivityManager.getNetworkInfo(i3);
        if (networkInfo == null) {
        }
    }

    public static String getOsVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? "android" : (String) invokeV.objValue;
    }

    public static int getScreenBrightness() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            ContentResolver contentResolver = b.a().getContentResolver();
            try {
                i2 = Settings.System.getInt(contentResolver, "screen_brightness_mode");
            } catch (Settings.SettingNotFoundException unused) {
                i2 = 0;
            }
            if (i2 == 1) {
                return -1;
            }
            try {
                return Settings.System.getInt(contentResolver, "screen_brightness");
            } catch (Settings.SettingNotFoundException unused2) {
                return -1;
            }
        }
        return invokeV.intValue;
    }

    public static float getScreenDensity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (b.a() == null) {
                return 0.0f;
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) b.a().getSystemService("window");
            if (windowManager != null) {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            }
            return displayMetrics.density;
        }
        return invokeV.floatValue;
    }

    public static int getScreenDensityDpi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            if (b.a() == null) {
                return 0;
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) b.a().getSystemService("window");
            if (windowManager != null) {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            }
            return displayMetrics.densityDpi;
        }
        return invokeV.intValue;
    }

    public static long getSdcardFreeSpace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return (statFs.getBlockSize() * statFs.getAvailableBlocks()) / 1024;
        }
        return invokeV.longValue;
    }

    public static String getSdcardPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            if (externalStorageDirectory != null) {
                return externalStorageDirectory.getAbsolutePath();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public static long getSdcardTotalSpace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return (statFs.getBlockSize() * statFs.getBlockCount()) / 1024;
        }
        return invokeV.longValue;
    }

    public static float getSystemMetricsX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) {
            if (b.a() == null) {
                return 0.0f;
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) b.a().getSystemService("window");
            if (windowManager != null) {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            }
            return displayMetrics.widthPixels;
        }
        return invokeV.floatValue;
    }

    public static float getSystemMetricsY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
            if (b.a() == null) {
                return 0.0f;
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) b.a().getSystemService("window");
            if (windowManager != null) {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            }
            return displayMetrics.heightPixels;
        }
        return invokeV.floatValue;
    }

    public static long getTotalMemory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(HardwareInfoUtils.MEM_INFO_FILE), 8192);
                String readLine = bufferedReader.readLine();
                r1 = readLine != null ? Integer.valueOf(readLine.split("\\s+")[1]).intValue() : 0L;
                bufferedReader.close();
            } catch (IOException unused) {
            }
            return r1;
        }
        return invokeV.longValue;
    }

    public static long getTotalSpace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) {
            StatFs statFs = new StatFs(Environment.getRootDirectory().getPath());
            return (statFs.getBlockSize() * statFs.getBlockCount()) / 1024;
        }
        return invokeV.longValue;
    }

    public static boolean isWifiConnected() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) {
            NetworkInfo networkInfo = ((ConnectivityManager) b.a().getSystemService("connectivity")).getNetworkInfo(1);
            if (networkInfo == null) {
                return false;
            }
            return networkInfo.isConnected();
        }
        return invokeV.booleanValue;
    }

    public static void makeCall(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, str) == null) {
            b.a().startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + str)));
        }
    }

    public static native void onNetworkStateChanged();

    public static void openUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65559, null, str) == null) {
            b.a().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        }
    }

    public static int sendMMS(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65560, null, str, str2, str3, str4)) == null) {
            if (PhoneNumberUtils.isWellFormedSmsAddress(str)) {
                try {
                    String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(Uri.fromFile(new File(str4)).toString()));
                    Intent intent = new Intent("android.intent.action.SEND");
                    intent.putExtra("address", str);
                    intent.putExtra("subject", str2);
                    intent.putExtra("sms_body", str3);
                    intent.putExtra("android.intent.extra.STREAM", Uri.parse("file://" + str4));
                    intent.setType(mimeTypeFromExtension);
                    b.a().startActivity(intent);
                    return 0;
                } catch (Exception unused) {
                    return 2;
                }
            }
            return 1;
        }
        return invokeLLLL.intValue;
    }

    public static void sendSMS(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65561, null, str, str2) == null) {
            Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + str));
            intent.putExtra("sms_body", str2);
            b.a().startActivity(intent);
        }
    }

    public static void setNetworkChangedCallback() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65562, null) == null) {
            unsetNetworkChangedCallback();
            f36144b = new a();
            b.a().registerReceiver(f36144b, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }

    public static void setScreenAlwaysOn(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65563, null, z) == null) {
            if (z) {
                if (a == null) {
                    a = ((PowerManager) b.a().getSystemService("power")).newWakeLock(10, "VDeviceAPI");
                }
                a.acquire();
                return;
            }
            PowerManager.WakeLock wakeLock = a;
            if (wakeLock == null || !wakeLock.isHeld()) {
                return;
            }
            a.release();
            a = null;
        }
    }

    public static void setupSoftware(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65564, null, str) == null) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.fromFile(new File(str)), "application/vnd.android.package-archive");
            b.a().startActivity(intent);
        }
    }

    public static void unsetNetworkChangedCallback() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65565, null) == null) || f36144b == null) {
            return;
        }
        b.a().unregisterReceiver(f36144b);
        f36144b = null;
    }
}
