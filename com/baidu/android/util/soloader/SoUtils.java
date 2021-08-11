package com.baidu.android.util.soloader;

import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface SoUbcLoggable {
        void onEvent(String str, String str2);
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
        uris = new String[]{"lib/armeabi", "lib/x86", "lib/mips"};
    }

    public SoUtils() {
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

    public static long copyStream(InputStream inputStream, OutputStream outputStream, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65538, null, inputStream, outputStream, i2)) == null) {
            if (inputStream != null && outputStream != null) {
                try {
                    byte[] bArr = new byte[i2 * 1024];
                    long j2 = 0;
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read > 0) {
                            outputStream.write(bArr, 0, read);
                            j2 += read;
                        } else {
                            outputStream.flush();
                            return j2;
                        }
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
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
                    String str2 = "SoUtils load but the param soName:" + str + ", name:" + substring;
                }
                return substring;
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static String getUriName(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(AdIconUtil.AD_TEXT_ID, null, str, i2)) == null) {
            return uris[i2] + File.separator + str;
        }
        return (String) invokeLI.objValue;
    }

    public static boolean hasGingerbread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? Build.VERSION.SDK_INT >= 9 : invokeV.booleanValue;
    }

    public static void init(SoUbcLoggable soUbcLoggable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, soUbcLoggable) == null) {
            sUbcImpl = soUbcLoggable;
        }
    }

    public static void onEvent(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, str, str2) == null) {
            SoUbcLoggable soUbcLoggable = sUbcImpl;
            if (soUbcLoggable != null) {
                soUbcLoggable.onEvent(str, str2);
            }
            if (DEBUG) {
                String str3 = "onEvent:UbcImpl=" + soUbcLoggable + ";eventId=" + str + ";content=" + str2;
            }
        }
    }

    public static void saveLog(HashMap<String, String> hashMap, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65545, null, hashMap, str, str2) == null) || TextUtils.isEmpty(str2)) {
            return;
        }
        hashMap.put(str, str2);
    }

    public static void sendLog(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, null, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        onEvent("24", str);
    }
}
