package c.a.d0.h0;

import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
/* loaded from: classes.dex */
public class n {
    public static /* synthetic */ Interceptable $ic;
    public static String a;

    /* renamed from: b  reason: collision with root package name */
    public static String f2750b;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static String a() {
        InterceptResult invokeV;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            String lowerCase = Build.MANUFACTURER.toLowerCase(Locale.getDefault());
            switch (lowerCase.hashCode()) {
                case -1443430368:
                    if (lowerCase.equals(RomUtils.MANUFACTURER_SMARTISAN)) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1245779295:
                    if (lowerCase.equals(RomUtils.MANUFACTURER_GIONEE)) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1206476313:
                    if (lowerCase.equals(RomUtils.MANUFACTURER_HUAWEI)) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -759499589:
                    if (lowerCase.equals(RomUtils.MANUFACTURER_XIAOMI)) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3418016:
                    if (lowerCase.equals(RomUtils.MANUFACTURER_OPPO)) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3620012:
                    if (lowerCase.equals(RomUtils.MANUFACTURER_VIVO)) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 103777484:
                    if (lowerCase.equals("meizu")) {
                        c2 = 7;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 105170387:
                    if (lowerCase.equals("nubia")) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            switch (c2) {
                case 0:
                    String e2 = e("ro.build.version.emui");
                    f2750b = e2;
                    if (!TextUtils.isEmpty(e2)) {
                        a = "EMUI";
                        return "EMUI";
                    }
                    return d();
                case 1:
                    String e3 = e("ro.miui.ui.version.name");
                    f2750b = e3;
                    if (!TextUtils.isEmpty(e3)) {
                        a = "MIUI";
                        return "MIUI";
                    }
                    return d();
                case 2:
                    String e4 = e("ro.build.version.opporom");
                    f2750b = e4;
                    if (!TextUtils.isEmpty(e4)) {
                        a = "OPPO";
                        return "OPPO";
                    }
                    return d();
                case 3:
                    String e5 = e("ro.vivo.os.version");
                    f2750b = e5;
                    if (!TextUtils.isEmpty(e5)) {
                        a = "VIVO";
                        return "VIVO";
                    }
                    return d();
                case 4:
                    String e6 = e("ro.smartisan.version");
                    f2750b = e6;
                    if (!TextUtils.isEmpty(e6)) {
                        a = "SMARTISAN";
                        return "SMARTISAN";
                    }
                    return d();
                case 5:
                    String e7 = e(RomUtils.KEY_VERSION_GIONEE);
                    f2750b = e7;
                    if (!TextUtils.isEmpty(e7)) {
                        a = RomUtils.ROM_GIONEE;
                        return RomUtils.ROM_GIONEE;
                    }
                    return d();
                case 6:
                    String e8 = e(RomUtils.KEY_VERSION_NUBIA);
                    f2750b = e8;
                    if (!TextUtils.isEmpty(e8)) {
                        a = RomUtils.ROM_NUBIA;
                        return RomUtils.ROM_NUBIA;
                    }
                    return d();
                case 7:
                    if (Build.DISPLAY.toUpperCase(Locale.getDefault()).contains("FLYME")) {
                        a = "FLYME";
                        return "FLYME";
                    }
                    return d();
                default:
                    return d();
            }
        }
        return (String) invokeV.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? Build.PRODUCT : (String) invokeV.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            String str = a;
            return str == null ? a() : str;
        }
        return (String) invokeV.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            String str = Build.DISPLAY;
            f2750b = str;
            if (str.toUpperCase(Locale.getDefault()).contains("FLYME")) {
                a = "FLYME";
            } else {
                f2750b = "unknown";
                a = Build.MANUFACTURER.toUpperCase(Locale.getDefault());
            }
            return a;
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x005e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String e(String str) {
        InterceptResult invokeL;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) != null) {
            return (String) invokeL.objValue;
        }
        BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()));
                try {
                    String readLine = bufferedReader.readLine();
                    bufferedReader.close();
                    try {
                        bufferedReader.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    return readLine;
                } catch (IOException unused) {
                    String str2 = "Unable to read prop " + str;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                bufferedReader2 = 65540;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException unused2) {
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
            if (bufferedReader2 != null) {
            }
            throw th;
        }
    }
}
