package com.baidu.searchbox.anr.collector;

import com.android.internal.http.multipart.Part;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes7.dex */
public class ThreadCollector {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ThreadCollector() {
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

    public static String getAllThreadStacks() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            StringBuilder sb = new StringBuilder();
            Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
            if (allStackTraces != null && allStackTraces.size() >= 1) {
                for (Map.Entry<Thread, StackTraceElement[]> entry : allStackTraces.entrySet()) {
                    sb.append(getThreadInfo(entry.getKey()));
                    sb.append(StringUtils.LF);
                }
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public static String getThreadInfo(Thread thread) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, thread)) == null) {
            StringBuilder sb = new StringBuilder();
            if (thread != null) {
                try {
                    sb.append("threadId： ");
                    sb.append(thread.getId());
                    sb.append(StringUtils.LF);
                    if (thread.getName() != null) {
                        sb.append("name: ");
                        sb.append(thread.getName());
                        sb.append(StringUtils.LF);
                    }
                    sb.append("priority: ");
                    sb.append(thread.getPriority());
                    sb.append(StringUtils.LF);
                    sb.append("state: ");
                    sb.append(thread.getState());
                    sb.append(StringUtils.LF);
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
                } catch (Exception unused) {
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String getThreadStack(Thread thread) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, thread)) == null) {
            StringBuilder sb = new StringBuilder();
            if (thread != null) {
                try {
                    StackTraceElement[] stackTrace = thread.getStackTrace();
                    if (stackTrace != null && stackTrace.length >= 1) {
                        for (StackTraceElement stackTraceElement : stackTrace) {
                            sb.append(stackTraceElement.toString() + Part.CRLF);
                        }
                    }
                } catch (Exception unused) {
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }
}
