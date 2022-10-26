package com.baidu.tbadk.core.util;

import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.hj;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/* loaded from: classes3.dex */
public class RomTypeUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_VERSION_EMUI = "ro.build.version.emui";
    public static final String KEY_VERSION_MIUI = "ro.miui.ui.version.name";
    public static final String KEY_VERSION_OPPO = "ro.build.version.opporom";
    public static final String KEY_VERSION_SMARTISAN = "ro.smartisan.version";
    public static final String KEY_VERSION_VIVO = "ro.vivo.os.version";
    public static final String ROM_EMUI = "EMUI";
    public static final String ROM_FLYME = "FLYME";
    public static final String ROM_MIUI = "MIUI";
    public static final String ROM_ONEPLUS = "ONEPLUS";
    public static final String ROM_OPPO = "OPPO";
    public static final String ROM_QIKU = "QIKU";
    public static final String ROM_SMARTISAN = "SMARTISAN";
    public static final String ROM_VIVO = "VIVO";
    public static final String TAG = "Rom";
    public static String sName;
    public static String sVersion;
    public transient /* synthetic */ FieldHolder $fh;

    public RomTypeUtil() {
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

    public static String getVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (sVersion == null) {
                check("");
            }
            return sVersion;
        }
        return (String) invokeV.objValue;
    }

    public static boolean isEmui() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return isUseForHuawei();
        }
        return invokeV.booleanValue;
    }

    public static boolean isFlyme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return check("FLYME");
        }
        return invokeV.booleanValue;
    }

    public static boolean isOPPO() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return check("OPPO");
        }
        return invokeV.booleanValue;
    }

    public static boolean isOnePlus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return check(ROM_ONEPLUS);
        }
        return invokeV.booleanValue;
    }

    public static boolean isUseForHuawei() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (check("EMUI") && Build.VERSION.SDK_INT >= 24) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean check(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            String str2 = sName;
            if (str2 != null) {
                return str2.equals(str);
            }
            String prop = getProp("ro.miui.ui.version.name");
            sVersion = prop;
            if (!TextUtils.isEmpty(prop)) {
                sName = "MIUI";
            } else {
                String prop2 = getProp("ro.build.version.emui");
                sVersion = prop2;
                if (!TextUtils.isEmpty(prop2)) {
                    sName = "EMUI";
                } else {
                    String prop3 = getProp("ro.build.version.opporom");
                    sVersion = prop3;
                    if (!TextUtils.isEmpty(prop3)) {
                        sName = "OPPO";
                    } else {
                        String prop4 = getProp("ro.vivo.os.version");
                        sVersion = prop4;
                        if (!TextUtils.isEmpty(prop4)) {
                            sName = "VIVO";
                        } else {
                            String prop5 = getProp("ro.smartisan.version");
                            sVersion = prop5;
                            if (!TextUtils.isEmpty(prop5)) {
                                sName = "SMARTISAN";
                            } else {
                                String str3 = Build.DISPLAY;
                                sVersion = str3;
                                if (str3.toUpperCase().contains("FLYME")) {
                                    sName = "FLYME";
                                } else {
                                    sVersion = "unknown";
                                    sName = hj.f().toUpperCase();
                                }
                            }
                        }
                    }
                }
            }
            return sName.equals(str);
        }
        return invokeL.booleanValue;
    }

    public static String getProp(String str) {
        InterceptResult invokeL;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            BufferedReader bufferedReader2 = null;
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
            } catch (IOException unused) {
                bufferedReader = null;
            } catch (Throwable th) {
                th = th;
            }
            try {
                String readLine = bufferedReader.readLine();
                bufferedReader.close();
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return readLine;
            } catch (IOException unused2) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                throw th;
            }
        }
        return (String) invokeL.objValue;
    }
}
