package com.baidu.searchbox.aperf.param;

import android.os.Looper;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes2.dex */
public class ThreadCollector {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ThreadCollector() {
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

    public static String getMainThreadStackTrace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return getThreadStack(Looper.getMainLooper().getThread());
        }
        return (String) invokeV.objValue;
    }

    public static String getAllThreadStacks() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            StringBuilder sb = new StringBuilder();
            Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
            if (allStackTraces != null && allStackTraces.size() >= 1) {
                for (Map.Entry<Thread, StackTraceElement[]> entry : allStackTraces.entrySet()) {
                    sb.append(getThreadInfo(entry.getKey()));
                    sb.append("\n");
                }
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public static String getThreadInfo(Thread thread) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, thread)) == null) {
            StringBuilder sb = new StringBuilder();
            if (thread != null) {
                try {
                    sb.append("threadId： ");
                    sb.append(thread.getId());
                    sb.append("\n");
                    if (thread.getName() != null) {
                        sb.append("name: ");
                        sb.append(thread.getName());
                        sb.append("\n");
                    }
                    sb.append("priority: ");
                    sb.append(thread.getPriority());
                    sb.append("\n");
                    sb.append("state: ");
                    sb.append(thread.getState());
                    sb.append("\n");
                    sb.append("stacktrace: \n");
                    StackTraceElement[] stackTrace = thread.getStackTrace();
                    if (stackTrace != null && stackTrace.length >= 1) {
                        for (StackTraceElement stackTraceElement : stackTrace) {
                            String methodName = stackTraceElement.getMethodName();
                            String str = "unknown";
                            if (methodName == null) {
                                methodName = "unknown";
                            }
                            sb.append("\tat ");
                            sb.append(methodName);
                            sb.append("(");
                            String fileName = stackTraceElement.getFileName();
                            if (fileName != null) {
                                str = fileName;
                            }
                            sb.append(str);
                            sb.append(":");
                            sb.append(stackTraceElement.getLineNumber());
                            sb.append(")\n");
                        }
                    }
                } catch (Exception e) {
                    Log.e("ThreadCollector", "ThreadInfo Collector Interrupted!!", e);
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String getThreadStack(Thread thread) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, thread)) == null) {
            StringBuilder sb = new StringBuilder();
            if (thread != null) {
                try {
                    StackTraceElement[] stackTrace = thread.getStackTrace();
                    if (stackTrace != null && stackTrace.length >= 1) {
                        for (StackTraceElement stackTraceElement : stackTrace) {
                            sb.append(stackTraceElement.toString() + "\r\n");
                        }
                    }
                } catch (Exception e) {
                    Log.e("ThreadCollector", "ThreadInfo Collector Interrupted!!", e);
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }
}
