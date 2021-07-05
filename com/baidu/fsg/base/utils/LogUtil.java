package com.baidu.fsg.base.utils;

import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.fsg.base.ApollonConstants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
/* loaded from: classes3.dex */
public final class LogUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;

    /* renamed from: a  reason: collision with root package name */
    public static final String f5372a = "apollon_rest";

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f5373b;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f5374c;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f5375d;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f5376e;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f5377f;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(445916974, "Lcom/baidu/fsg/base/utils/LogUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(445916974, "Lcom/baidu/fsg/base/utils/LogUtil;");
                return;
            }
        }
        boolean z = ApollonConstants.DEBUG;
        DEBUG = z;
        f5373b = z;
        f5374c = z;
        f5375d = z;
        f5376e = z;
        f5377f = z;
    }

    public LogUtil() {
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

    public static StackTraceElement a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            int length = stackTrace.length;
            int i2 = 0;
            boolean z = false;
            while (i2 < length) {
                StackTraceElement stackTraceElement = stackTrace[i2];
                boolean equals = stackTraceElement.getClassName().equals(LogUtil.class.getName());
                if (z && !equals) {
                    return stackTraceElement;
                }
                i2++;
                z = equals;
            }
            return null;
        }
        return (StackTraceElement) invokeV.objValue;
    }

    public static void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65540, null, str, str2) == null) && f5374c) {
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            if (TextUtils.isEmpty(str)) {
                Log.d("apollon_rest", str2);
                return;
            }
            Log.d("(" + a().getFileName() + ":" + a().getLineNumber() + ")[" + a().getMethodName() + PreferencesUtil.RIGHT_MOUNT + str, str2);
        }
    }

    public static void e(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str) == null) && f5377f) {
            Log.e("(" + a().getFileName() + ":" + a().getLineNumber() + ")[" + a().getMethodName() + PreferencesUtil.RIGHT_MOUNT, str);
        }
    }

    public static void errord(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65544, null, str) == null) && ApollonConstants.DEBUG) {
            Log.e("apollon_rest", getTAG() + "---" + str);
        }
    }

    public static String getTAG() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            try {
                StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                StringBuilder sb = new StringBuilder();
                if (stackTrace != null) {
                    StackTraceElement stackTraceElement = stackTrace[4];
                    sb.append(((Object) stackTraceElement.getFileName().subSequence(0, stackTraceElement.getFileName().length() - 5)) + "." + stackTraceElement.getMethodName() + "#" + stackTraceElement.getLineNumber());
                }
                return sb.toString();
            } catch (NullPointerException unused) {
                return "PROGUARDED";
            }
        }
        return (String) invokeV.objValue;
    }

    public static void i(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65548, null, str, str2) == null) && f5375d) {
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            if (TextUtils.isEmpty(str)) {
                Log.i("apollon_rest", str2);
                return;
            }
            Log.i("(" + a().getFileName() + ":" + a().getLineNumber() + ")[" + a().getMethodName() + PreferencesUtil.RIGHT_MOUNT + str, str2);
        }
    }

    public static void logd(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65549, null, str) == null) && ApollonConstants.DEBUG) {
            Log.i("apollon_rest", getTAG() + "---" + str + "#pid=" + Process.myPid());
        }
    }

    public static void mark() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65551, null) == null) && ApollonConstants.DEBUG) {
            Log.w("apollon_rest", getTAG());
        }
    }

    public static void saveLog(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65553, null, str) == null) && f5374c) {
            String str2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS    ", Locale.ENGLISH).format(new Date()) + str + "\n";
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(new File(String.valueOf(Environment.getExternalStorageDirectory()) + "/wallet.log"), true);
                fileOutputStream.write(str2.getBytes());
                fileOutputStream.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void traces() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65554, null) == null) && ApollonConstants.DEBUG) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            StringBuilder sb = new StringBuilder();
            if (stackTrace != null) {
                StackTraceElement stackTraceElement = stackTrace[3];
                sb.append(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + "#line=" + stackTraceElement.getLineNumber() + "的调用：\n");
                for (int i2 = 4; i2 < stackTrace.length && i2 < 15; i2++) {
                    StackTraceElement stackTraceElement2 = stackTrace[i2];
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(i2 - 4);
                    sb2.append("--");
                    sb2.append(stackTraceElement2.getClassName());
                    sb2.append(".");
                    sb2.append(stackTraceElement2.getMethodName());
                    sb2.append("(...)#line:");
                    sb2.append(stackTraceElement2.getLineNumber());
                    sb2.append("\n");
                    sb.append(sb2.toString());
                }
            }
            Log.w("apollon_rest", getTAG() + "--" + sb.toString());
        }
    }

    public static void v(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65555, null, str, str2) == null) && f5373b) {
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            if (TextUtils.isEmpty(str)) {
                Log.v("apollon_rest", str2);
                return;
            }
            Log.v("(" + a().getFileName() + ":" + a().getLineNumber() + ")[" + a().getMethodName() + PreferencesUtil.RIGHT_MOUNT + str, str2);
        }
    }

    public static void w(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65557, null, str, str2) == null) && f5376e) {
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            if (TextUtils.isEmpty(str)) {
                Log.w("apollon_rest", str2);
                return;
            }
            Log.w("(" + a().getFileName() + ":" + a().getLineNumber() + ")[" + a().getMethodName() + PreferencesUtil.RIGHT_MOUNT + str, str2);
        }
    }

    public static void errord(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65545, null, str, str2) == null) && ApollonConstants.DEBUG) {
            Log.e(str, getTAG() + "---" + str2);
        }
    }

    public static void logd(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65550, null, str, str2) == null) && ApollonConstants.DEBUG) {
            Log.i(str, getTAG() + "---" + str2);
        }
    }

    public static void mark(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65552, null, str) == null) && ApollonConstants.DEBUG) {
            Log.w("apollon_rest", getTAG() + "---" + str);
        }
    }

    public static void e(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, str2) == null) && f5377f) {
            Log.e("(" + a().getFileName() + ":" + a().getLineNumber() + ")[" + a().getMethodName() + PreferencesUtil.RIGHT_MOUNT + str, str2);
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, str) == null) && f5375d) {
            Log.d("(" + a().getFileName() + ":" + a().getLineNumber() + ")[" + a().getMethodName() + PreferencesUtil.RIGHT_MOUNT, str);
        }
    }

    public static void i(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, null, str) == null) && f5375d) {
            Log.i("(" + a().getFileName() + ":" + a().getLineNumber() + ")[" + a().getMethodName() + PreferencesUtil.RIGHT_MOUNT, str);
        }
    }

    public static void w(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65556, null, str) == null) && f5376e) {
            Log.w("(" + a().getFileName() + ":" + a().getLineNumber() + ")[" + a().getMethodName() + PreferencesUtil.RIGHT_MOUNT, str);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65543, null, str, str2, th) == null) && f5377f) {
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            if (TextUtils.isEmpty(str)) {
                Log.e("apollon_rest", str2, th);
                return;
            }
            Log.e("(" + a().getFileName() + ":" + a().getLineNumber() + ")[" + a().getMethodName() + PreferencesUtil.RIGHT_MOUNT + str, str2);
        }
    }
}
