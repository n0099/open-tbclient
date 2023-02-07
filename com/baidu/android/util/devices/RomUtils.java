package com.baidu.android.util.devices;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
/* loaded from: classes.dex */
public class RomUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_VERSION_EMUI = "ro.build.version.emui";
    public static final String KEY_VERSION_GIONEE = "ro.gn.sv.version";
    public static final String KEY_VERSION_MIUI = "ro.miui.ui.version.name";
    public static final String KEY_VERSION_NUBIA = "ro.build.rom.id";
    public static final String KEY_VERSION_OPPO = "ro.build.version.opporom";
    public static final String KEY_VERSION_SMARTISAN = "ro.smartisan.version";
    public static final String KEY_VERSION_VIVO = "ro.vivo.os.version";
    public static final String MANUFACTURER_GIONEE = "gionee";
    public static final String MANUFACTURER_HUAWEI = "huawei";
    public static final String MANUFACTURER_MEIZU = "meizu";
    public static final String MANUFACTURER_NUBIA = "nubia";
    public static final String MANUFACTURER_OPPO = "oppo";
    public static final String MANUFACTURER_SMARTISAN = "smartisan";
    public static final String MANUFACTURER_VIVO = "vivo";
    public static final String MANUFACTURER_XIAOMI = "xiaomi";
    public static final String PROP_RO_BUILD_DISPLAY_ID = "ro.build.display.id";
    public static final String PROP_RO_BUILD_FINGERPRINT = "ro.build.fingerprint";
    public static final String PROP_RO_BUILD_VERSION_INCREMENTAL = "ro.build.version.incremental";
    public static final String ROM_EMUI = "EMUI";
    public static final String ROM_FLYME = "FLYME";
    public static final String ROM_GIONEE = "GIONEE";
    public static final String ROM_MIUI = "MIUI";
    public static final String ROM_NUBIA = "NUBIA";
    public static final String ROM_OPPO = "OPPO";
    public static final String ROM_QIKU = "QIKU";
    public static final String ROM_SMARTISAN = "SMARTISAN";
    public static final String ROM_UNKNOWN = "ROM_UNKNOWN";
    public static final String ROM_VIVO = "VIVO";
    public static final String ROM_XIAOMI = "XIAOMI";
    public static final String TAG = "Rom";
    public static final String UNKNOWN = "UNKNOWN";
    public static String sRomName;
    public static String sRomVersion;
    public transient /* synthetic */ FieldHolder $fh;

    public RomUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String getDeviceBrand() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return Build.BRAND;
        }
        return (String) invokeV.objValue;
    }

    public static String getDeviceModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return Build.MODEL;
        }
        return (String) invokeV.objValue;
    }

    public static String getDeviceName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return Build.PRODUCT;
        }
        return (String) invokeV.objValue;
    }

    public static String getIncrementalVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return getProp(PROP_RO_BUILD_VERSION_INCREMENTAL);
        }
        return (String) invokeV.objValue;
    }

    public static String getManufacturer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return Build.MANUFACTURER;
        }
        return (String) invokeV.objValue;
    }

    public static String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            String str = sRomName;
            if (str == null) {
                return check();
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public static String getVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (sRomVersion == null) {
                check();
            }
            return sRomVersion;
        }
        return (String) invokeV.objValue;
    }

    public static boolean is360() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            if (!check("QIKU") && !check("360")) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean isEmui() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            return check("EMUI");
        }
        return invokeV.booleanValue;
    }

    public static boolean isFlyme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            return check("FLYME");
        }
        return invokeV.booleanValue;
    }

    public static boolean isFlymeQuickly() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            String str = Build.DISPLAY;
            if (!TextUtils.isEmpty(str) && str.toUpperCase(Locale.getDefault()).contains("FLYME")) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean isMagicBoxDevice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) {
            String str = Build.MANUFACTURER;
            String str2 = Build.PRODUCT;
            if (str.equalsIgnoreCase("MagicBox") && str2.equalsIgnoreCase("MagicBox")) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean isMiBox2Device() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
            String str = Build.MANUFACTURER;
            String str2 = Build.PRODUCT;
            if (str.equalsIgnoreCase("Xiaomi") && str2.equalsIgnoreCase("dredd")) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean isMiui() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            return check("MIUI");
        }
        return invokeV.booleanValue;
    }

    public static boolean isMiuiOrXiaoMi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) {
            if (!check("MIUI") && !check(ROM_XIAOMI)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean isNubia() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) {
            return check(ROM_NUBIA);
        }
        return invokeV.booleanValue;
    }

    public static boolean isOppo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) {
            return check("OPPO");
        }
        return invokeV.booleanValue;
    }

    public static boolean isSmartisan() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) {
            return check("SMARTISAN");
        }
        return invokeV.booleanValue;
    }

    public static boolean isVivo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) {
            return check("VIVO");
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static String check() {
        InterceptResult invokeV;
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            String lowerCase = Build.MANUFACTURER.toLowerCase(Locale.getDefault());
            switch (lowerCase.hashCode()) {
                case -1443430368:
                    if (lowerCase.equals(MANUFACTURER_SMARTISAN)) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case -1245779295:
                    if (lowerCase.equals(MANUFACTURER_GIONEE)) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case -1206476313:
                    if (lowerCase.equals(MANUFACTURER_HUAWEI)) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -759499589:
                    if (lowerCase.equals(MANUFACTURER_XIAOMI)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 3418016:
                    if (lowerCase.equals("oppo")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 3620012:
                    if (lowerCase.equals("vivo")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 103777484:
                    if (lowerCase.equals("meizu")) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case 105170387:
                    if (lowerCase.equals(MANUFACTURER_NUBIA)) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    String prop = getProp("ro.build.version.emui");
                    sRomVersion = prop;
                    if (!TextUtils.isEmpty(prop)) {
                        sRomName = "EMUI";
                        return "EMUI";
                    }
                    return getOtherRomName();
                case 1:
                    String prop2 = getProp("ro.miui.ui.version.name");
                    sRomVersion = prop2;
                    if (!TextUtils.isEmpty(prop2)) {
                        sRomName = "MIUI";
                        return "MIUI";
                    }
                    return getOtherRomName();
                case 2:
                    String prop3 = getProp("ro.build.version.opporom");
                    sRomVersion = prop3;
                    if (!TextUtils.isEmpty(prop3)) {
                        sRomName = "OPPO";
                        return "OPPO";
                    }
                    return getOtherRomName();
                case 3:
                    String prop4 = getProp("ro.vivo.os.version");
                    sRomVersion = prop4;
                    if (!TextUtils.isEmpty(prop4)) {
                        sRomName = "VIVO";
                        return "VIVO";
                    }
                    return getOtherRomName();
                case 4:
                    String prop5 = getProp("ro.smartisan.version");
                    sRomVersion = prop5;
                    if (!TextUtils.isEmpty(prop5)) {
                        sRomName = "SMARTISAN";
                        return "SMARTISAN";
                    }
                    return getOtherRomName();
                case 5:
                    String prop6 = getProp(KEY_VERSION_GIONEE);
                    sRomVersion = prop6;
                    if (!TextUtils.isEmpty(prop6)) {
                        sRomName = ROM_GIONEE;
                        return ROM_GIONEE;
                    }
                    return getOtherRomName();
                case 6:
                    String prop7 = getProp(KEY_VERSION_NUBIA);
                    sRomVersion = prop7;
                    if (!TextUtils.isEmpty(prop7)) {
                        sRomName = ROM_NUBIA;
                        return ROM_NUBIA;
                    }
                    return getOtherRomName();
                case 7:
                    if (Build.DISPLAY.toUpperCase(Locale.getDefault()).contains("FLYME")) {
                        sRomName = "FLYME";
                        return "FLYME";
                    }
                    return getOtherRomName();
                default:
                    return getOtherRomName();
            }
        }
        return (String) invokeV.objValue;
    }

    public static boolean check(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            String str2 = sRomName;
            if (str2 != null) {
                return str2.equals(str);
            }
            String prop = getProp("ro.miui.ui.version.name");
            sRomVersion = prop;
            if (!TextUtils.isEmpty(prop)) {
                sRomName = "MIUI";
            } else {
                String prop2 = getProp("ro.build.version.emui");
                sRomVersion = prop2;
                if (!TextUtils.isEmpty(prop2)) {
                    sRomName = "EMUI";
                } else {
                    String prop3 = getProp("ro.build.version.opporom");
                    sRomVersion = prop3;
                    if (!TextUtils.isEmpty(prop3)) {
                        sRomName = "OPPO";
                    } else {
                        String prop4 = getProp("ro.vivo.os.version");
                        sRomVersion = prop4;
                        if (!TextUtils.isEmpty(prop4)) {
                            sRomName = "VIVO";
                        } else {
                            String prop5 = getProp("ro.smartisan.version");
                            sRomVersion = prop5;
                            if (!TextUtils.isEmpty(prop5)) {
                                sRomName = "SMARTISAN";
                            } else {
                                String prop6 = getProp(KEY_VERSION_GIONEE);
                                sRomVersion = prop6;
                                if (!TextUtils.isEmpty(prop6)) {
                                    sRomName = ROM_GIONEE;
                                } else {
                                    String prop7 = getProp(KEY_VERSION_NUBIA);
                                    sRomVersion = prop7;
                                    if (!TextUtils.isEmpty(prop7)) {
                                        sRomName = ROM_NUBIA;
                                    } else {
                                        String str3 = Build.DISPLAY;
                                        sRomVersion = str3;
                                        if (str3.toUpperCase(Locale.getDefault()).contains("FLYME")) {
                                            sRomName = "FLYME";
                                        } else {
                                            sRomVersion = "unknown";
                                            sRomName = Build.MANUFACTURER.toUpperCase(Locale.getDefault());
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return sRomName.equals(str);
        }
        return invokeL.booleanValue;
    }

    public static String getOtherRomName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            String str = Build.DISPLAY;
            sRomVersion = str;
            if (str.toUpperCase(Locale.getDefault()).contains("FLYME")) {
                sRomName = "FLYME";
            } else {
                sRomVersion = "unknown";
                sRomName = Build.MANUFACTURER.toUpperCase(Locale.getDefault());
            }
            return sRomName;
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0064: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:26:0x0064 */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0067 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getProp(String str) {
        InterceptResult invokeL;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            BufferedReader bufferedReader3 = null;
            try {
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()));
                    try {
                        String readLine = bufferedReader.readLine();
                        bufferedReader.close();
                        try {
                            bufferedReader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return readLine;
                    } catch (IOException e2) {
                        e = e2;
                        Log.e("Rom", "Unable to read prop " + str, e);
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
                    bufferedReader3 = bufferedReader2;
                    if (bufferedReader3 != null) {
                        try {
                            bufferedReader3.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e5) {
                e = e5;
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
                if (bufferedReader3 != null) {
                }
                throw th;
            }
        } else {
            return (String) invokeL.objValue;
        }
    }
}
