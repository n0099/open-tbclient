package com.baidu.android.util.soloader;

import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.NoProGuard;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
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
public final class SoUtils implements NoProGuard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String EXT = ".so";
    public static final boolean LOGFLAG = true;
    public static final String PRE = "lib";
    public static final String TAG = "SoUtils";
    public static SoUbcLoggable sUbcImpl;
    public static String[] uris;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public interface SoUbcLoggable {
        void onEvent(String str, String str2);
    }

    /* loaded from: classes.dex */
    public final class SOLOG {
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1576452423, "Lcom/baidu/android/util/soloader/SoUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1576452423, "Lcom/baidu/android/util/soloader/SoUtils;");
                return;
            }
        }
        uris = new String[]{"lib/arm64-v8a", "lib/armeabi", "lib/x86", "lib/mips"};
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

    @Deprecated
    public static boolean hasGingerbread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            if (Build.VERSION.SDK_INT >= 9) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean is64Bit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 23) {
                return Process.is64Bit();
            }
            if (i < 21) {
                return false;
            }
            String[] strArr = Build.SUPPORTED_64_BIT_ABIS;
            if (strArr.length <= 0) {
                return false;
            }
            return Build.CPU_ABI.equals(strArr[0]);
        }
        return invokeV.booleanValue;
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
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (!str.startsWith("lib")) {
                str2 = "lib" + str;
            } else {
                str2 = str;
            }
            if (!str.endsWith(".so")) {
                return str2 + ".so";
            }
            return str2;
        }
        return (String) invokeL.objValue;
    }

    public static String getSimpleName(String str) {
        InterceptResult invokeL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (!TextUtils.isEmpty(str) && str.startsWith("lib") && str.endsWith(".so") && (split = str.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX)) != null && split.length == 2) {
                return split[0].substring(3);
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

    public static void onEvent(String str, String str2) {
        SoUbcLoggable soUbcLoggable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65545, null, str, str2) == null) && (soUbcLoggable = sUbcImpl) != null) {
            soUbcLoggable.onEvent(str, str2);
        }
    }

    public static void init(SoUbcLoggable soUbcLoggable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, soUbcLoggable) == null) {
            sUbcImpl = soUbcLoggable;
        }
    }

    public static void sendLog(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, null, str) == null) && !TextUtils.isEmpty(str)) {
            onEvent("24", str);
        }
    }

    public static void saveLog(HashMap hashMap, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65546, null, hashMap, str, str2) == null) && !TextUtils.isEmpty(str2)) {
            hashMap.put(str, str2);
        }
    }
}
