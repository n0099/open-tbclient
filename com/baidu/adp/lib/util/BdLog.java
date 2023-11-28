package com.baidu.adp.lib.util;

import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.log.OldBdLog;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.logsystem.exceptionhandler.api.ExceptionHandler;
import com.baidu.tieba.vd;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class BdLog {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String LOG_TAG = "BaiduLog";
    public static String LogFilter_classNameStartsWith;
    public static boolean enableExceptionLog;
    public static ArrayList<String> logPackage;
    public static vd permissionUtil;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a extends AsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Exception a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Map d;

        public a(Exception exc, String str, String str2, Map map) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {exc, str, str2, map};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = exc;
            this.b = str;
            this.c = str2;
            this.d = map;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            ExceptionHandler exceptionHandler;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                try {
                    if (BdLog.permissionUtil != null && !BdLog.permissionUtil.isBrowseMode() && (exceptionHandler = (ExceptionHandler) ServiceManager.getService(ExceptionHandler.SERVICE_REFERENCE)) != null) {
                        exceptionHandler.onException(this.a, this.b, this.c, this.d);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-321455124, "Lcom/baidu/adp/lib/util/BdLog;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-321455124, "Lcom/baidu/adp/lib/util/BdLog;");
                return;
            }
        }
        logPackage = new ArrayList<>();
    }

    public BdLog() {
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

    public static boolean isDebugMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) {
            if (BdBaseApplication.getInst() == null) {
                return false;
            }
            return BdBaseApplication.getInst().isDebugMode();
        }
        return invokeV.booleanValue;
    }

    public static void addLogPackage(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, str) != null) || TextUtils.isEmpty(str) || logPackage.contains(str)) {
            return;
        }
        logPackage.add(str);
    }

    public static int d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            return printLog(3, str);
        }
        return invokeL.intValue;
    }

    public static int detailException(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, th)) == null) {
            return detailException(null, th, null, null, null, false);
        }
        return invokeL.intValue;
    }

    public static int e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
            return printLog(0, str);
        }
        return invokeL.intValue;
    }

    public static int i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, str)) == null) {
            return printLog(2, str);
        }
        return invokeL.intValue;
    }

    public static void setClassNameStartWithLogFilter(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, null, str) == null) {
            LogFilter_classNameStartsWith = str;
        }
    }

    public static void setPermissionUtil(vd vdVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65561, null, vdVar) == null) {
            permissionUtil = vdVar;
        }
    }

    public static int v(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, str)) == null) {
            return printLog(4, str);
        }
        return invokeL.intValue;
    }

    public static int w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, str)) == null) {
            return printLog(1, str);
        }
        return invokeL.intValue;
    }

    public static String createMsg(boolean z, String str, String str2, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Boolean.valueOf(z), str, str2, str3})) == null) {
            if (!isDebugMode()) {
                return null;
            }
            String str4 = LogFilter_classNameStartsWith;
            if (str4 != null && !str3.startsWith(str4)) {
                return null;
            }
            if (z && !isLogable(str)) {
                return null;
            }
            StringBuffer stringBuffer = new StringBuffer(100);
            stringBuffer.append(str);
            stringBuffer.append(":");
            stringBuffer.append(str2);
            stringBuffer.append(":");
            stringBuffer.append(str3);
            return stringBuffer.toString();
        }
        return (String) invokeCommon.objValue;
    }

    public static void d(String str, String str2, String str3) {
        String createMsg;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65542, null, str, str2, str3) == null) && (createMsg = createMsg(true, str, str2, str3)) != null) {
            OldBdLog.getInstance().d(LOG_TAG, createMsg);
        }
    }

    public static int detailException(String str, Throwable th, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65545, null, str, th, z)) == null) {
            return detailException(str, th, null, null, null, z);
        }
        return invokeLLZ.intValue;
    }

    public static void e(String str, String str2, String str3) {
        String createMsg;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65552, null, str, str2, str3) == null) && (createMsg = createMsg(false, str, str2, str3)) != null) {
            OldBdLog.getInstance().e(LOG_TAG, createMsg);
        }
    }

    public static void i(String str, String str2, String str3) {
        String createMsg;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65554, null, str, str2, str3) == null) && (createMsg = createMsg(true, str, str2, str3)) != null) {
            OldBdLog.getInstance().i(LOG_TAG, createMsg);
        }
    }

    public static void v(String str, String str2, String str3) {
        String createMsg;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65563, null, str, str2, str3) == null) && (createMsg = createMsg(true, str, str2, str3)) != null) {
            OldBdLog.getInstance().v(LOG_TAG, createMsg);
        }
    }

    public static void w(String str, String str2, String str3) {
        String createMsg;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65565, null, str, str2, str3) == null) && (createMsg = createMsg(false, str, str2, str3)) != null) {
            OldBdLog.getInstance().w(LOG_TAG, createMsg);
        }
    }

    public static int detailException(String str, Throwable th) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, th)) == null) {
            return detailException(str, th, null, null, null, false);
        }
        return invokeLL.intValue;
    }

    public static int e(Throwable th, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65551, null, th, z)) == null) {
            return e(th, null, null, null, z);
        }
        return invokeLZ.intValue;
    }

    public static void printExceptionLog(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65557, null, str, str2) == null) && enableExceptionLog) {
            PrintStream printStream = System.out;
            printStream.println(str + ":" + str2);
        }
    }

    public static int detailException(String str, Throwable th, String str2, String str3, Map<String, String> map, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{str, th, str2, str3, map, Boolean.valueOf(z)})) == null) {
            if ((th instanceof Exception) && !isDebugMode() && !z) {
                reportException((Exception) th, str2, str3, map);
            }
            if (isDebugMode() && th != null) {
                Log.e(LOG_TAG, th.getMessage(), th);
                return printLog(0, th.getMessage());
            } else if (str != null && str.length() > 0) {
                return printLog(0, str);
            } else {
                return -1;
            }
        }
        return invokeCommon.intValue;
    }

    public static int detailException(Throwable th, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65547, null, th, z)) == null) {
            return detailException(null, th, null, null, null, z);
        }
        return invokeLZ.intValue;
    }

    public static int e(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, th)) == null) {
            return e(th, null, null, null, false);
        }
        return invokeL.intValue;
    }

    public static int e(Throwable th, String str, String str2, Map<String, String> map, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65550, null, new Object[]{th, str, str2, map, Boolean.valueOf(z)})) == null) {
            if ((th instanceof Exception) && !isDebugMode() && !z) {
                reportException((Exception) th, str, str2, map);
            }
            return printLog(0, th.getMessage());
        }
        return invokeCommon.intValue;
    }

    public static boolean isLogable(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, str)) == null) {
            boolean z = false;
            if (logPackage.size() == 0) {
                return false;
            }
            Iterator<String> it = logPackage.iterator();
            while (it.hasNext()) {
                if (str.startsWith(it.next())) {
                    z = true;
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public static int printLog(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65558, null, i, str)) == null) {
            if (!isDebugMode()) {
                return -1;
            }
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            if (stackTrace.length < 5) {
                return -1;
            }
            StackTraceElement stackTraceElement = stackTrace[4];
            String methodName = stackTraceElement.getMethodName();
            String className = stackTraceElement.getClassName();
            if (i > 1 && !isLogable(className)) {
                return -1;
            }
            if (i == 0) {
                e(className, methodName, str);
                return 0;
            } else if (i == 1) {
                w(className, methodName, str);
                return 0;
            } else if (i == 2) {
                i(className, methodName, str);
                return 0;
            } else if (i == 3) {
                d(className, methodName, str);
                return 0;
            } else {
                v(className, methodName, str);
                return 0;
            }
        }
        return invokeIL.intValue;
    }

    public static void reportException(Exception exc, String str, String str2, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65559, null, exc, str, str2, map) == null) {
            new a(exc, str, str2, map).execute(new Void[0]);
        }
    }
}
