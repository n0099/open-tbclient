package com.baidu.android.common.so;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.tieba.aq4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
/* loaded from: classes.dex */
public final class SoUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final String EXT = ".so";
    public static final boolean LOGFLAG = true;
    public static final String PRE = "lib";
    public static final String TAG = "SoUtils";
    public static SoUbcLoggable sUbcImpl;
    public static String[] uris;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static final class SOLOG {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String SO_LOAD_LIBRARY = "SO_LOAD_LIBRARY";
        public static final String SO_LOAD_TAG = "SO_LOAD_TAG";
        public static final String SO_NATIVE_LIB_LOAD = "SO_NATIVE_LIB_LOAD";
        public static final String SO_RELEASE_EXECUTE_LOAD = "SO_RELEASE_EXECUTE_LOAD";
        public static final String SO_RELEASE_LIB_LOAD = "SO_RELEASE_LIB_LOAD";
        public transient /* synthetic */ FieldHolder $fh;

        public SOLOG() {
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
    }

    /* loaded from: classes.dex */
    public interface SoUbcLoggable {
        void onEvent(String str, String str2);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1513290589, "Lcom/baidu/android/common/so/SoUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1513290589, "Lcom/baidu/android/common/so/SoUtils;");
                return;
            }
        }
        DEBUG = aq4.e();
        uris = new String[]{"lib/arm64", "lib/armeabi", "lib/x86", "lib/mips"};
    }

    public SoUtils() {
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

    public static long copyStream(InputStream inputStream, OutputStream outputStream, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65538, null, inputStream, outputStream, i)) == null) {
            if (inputStream != null && outputStream != null) {
                try {
                    byte[] bArr = new byte[i * 1024];
                    long j = 0;
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read > 0) {
                            outputStream.write(bArr, 0, read);
                            j += read;
                        } else {
                            outputStream.flush();
                            return j;
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return 0L;
        }
        return invokeLLI.longValue;
    }

    public static String getFullName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (str.startsWith("lib") && str.endsWith(".so")) {
                return str;
            }
            return "lib" + str + ".so";
        }
        return (String) invokeL.objValue;
    }

    public static String getSimpleName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (!TextUtils.isEmpty(str) && str.startsWith("lib") && str.endsWith(".so")) {
                String[] split = str.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
                String substring = (split == null || split.length != 2) ? str : split[0].substring(3);
                if (DEBUG) {
                    Log.e("SoUtils", "SoUtils load but the param soName:" + str + ", name:" + substring);
                }
                return substring;
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static String getUriName(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65541, null, str, i)) == null) {
            return uris[i] + File.separator + str;
        }
        return (String) invokeLI.objValue;
    }

    @SuppressLint({"ObsoleteSdkInt"})
    @Deprecated
    public static boolean hasGingerbread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? Build.VERSION.SDK_INT >= 9 : invokeV.booleanValue;
    }

    public static void init(SoUbcLoggable soUbcLoggable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, soUbcLoggable) == null) {
            sUbcImpl = soUbcLoggable;
        }
    }

    public static boolean is64Bit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            int i = Build.VERSION.SDK_INT;
            boolean z = false;
            if (i >= 23) {
                z = Process.is64Bit();
            } else if (i >= 21) {
                String[] strArr = Build.SUPPORTED_64_BIT_ABIS;
                if (strArr.length > 0) {
                    z = Build.CPU_ABI.equals(strArr[0]);
                }
            }
            if (DEBUG) {
                if (z) {
                    Log.d("SoUtils", "current process is a  64-bit runtime");
                } else {
                    Log.d("SoUtils", "current process is a  32-bit runtime");
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public static void onEvent(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, str, str2) == null) {
            SoUbcLoggable soUbcLoggable = sUbcImpl;
            if (soUbcLoggable != null) {
                soUbcLoggable.onEvent(str, str2);
            }
            if (DEBUG) {
                Log.d("SoUtils", "onEvent:UbcImpl=" + soUbcLoggable + ";eventId=" + str + ";content=" + str2);
            }
        }
    }

    public static void saveLog(HashMap<String, String> hashMap, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65546, null, hashMap, str, str2) == null) || TextUtils.isEmpty(str2)) {
            return;
        }
        hashMap.put(str, str2);
    }

    public static void sendLog(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65547, null, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        onEvent("24", str);
    }
}
