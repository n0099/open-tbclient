package com.baidu.swan.apps.so;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.h2.c;
import b.a.p0.a.k;
import com.baidu.mobads.container.util.AdIconUtil;
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
@Keep
/* loaded from: classes8.dex */
public final class SoUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ARM64_V8A = "arm64-v8a";
    public static final String ARMEABI = "armeabi";
    public static final boolean DEBUG;
    public static final String EXT = ".so";
    public static final boolean LOGFLAG = true;
    public static final String PRE = "lib";
    public static final String SO_EVENT_ID_DEFAULT = "24";
    public static final String SO_EVENT_ID_NEW_SO = "25";
    public static final String SO_EVENT_ID_V8_SO = "26";
    public static final String TAG = "SoUtils";
    public static a sUbcImpl;
    public static String[] uris;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public interface a {
        void onEvent(String str, String str2);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1901980652, "Lcom/baidu/swan/apps/so/SoUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1901980652, "Lcom/baidu/swan/apps/so/SoUtils;");
                return;
            }
        }
        DEBUG = k.f6397a;
        sUbcImpl = new c();
        uris = new String[]{"lib/armeabi", "lib/arm64-v8a"};
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
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            return 0L;
        }
        return invokeLLI.longValue;
    }

    public static String getCurrentCpuAbi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? ("arm64-v8a".equals(Build.CPU_ABI) || "arm64-v8a".equals(Build.CPU_ABI2)) ? "arm64-v8a" : "armeabi" : (String) invokeV.objValue;
    }

    public static String getFullName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            if (!TextUtils.isEmpty(str) && str.startsWith("lib") && str.endsWith(".so")) {
                String[] split = str.split("\\.");
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
        if (interceptable == null || (invokeLI = interceptable.invokeLI(AdIconUtil.BAIDU_LOGO_ID, null, str, i2)) == null) {
            return uris[i2] + File.separator + str;
        }
        return (String) invokeLI.objValue;
    }

    @SuppressLint({"ObsoleteSdkInt"})
    public static boolean hasGingerbread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? Build.VERSION.SDK_INT >= 9 : invokeV.booleanValue;
    }

    public static void init(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, aVar) == null) {
            sUbcImpl = aVar;
        }
    }

    public static void onEvent(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, str, str2) == null) {
            a aVar = sUbcImpl;
            if (aVar != null) {
                aVar.onEvent(str, str2);
            }
            if (DEBUG) {
                String str3 = "onEvent:UbcImpl=" + aVar + ";eventId=" + str + ";content=" + str2;
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
