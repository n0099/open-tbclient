package com.baidu.searchbox.bddownload.core.priority;

import com.baidu.searchbox.bddownload.DownloadTask;
import com.baidu.searchbox.network.outback.EngineName;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class PriorityStrategy {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public final class Priority {
        public static final /* synthetic */ Priority[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Priority BACKGROUND;
        public static final Priority DEFAULT;
        public static final Priority SPECIAL;
        public static final Priority USER_INTERACTIVE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1270168272, "Lcom/baidu/searchbox/bddownload/core/priority/PriorityStrategy$Priority;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1270168272, "Lcom/baidu/searchbox/bddownload/core/priority/PriorityStrategy$Priority;");
                    return;
                }
            }
            DEFAULT = new Priority(EngineName.DEFAULT_ENGINE, 0);
            BACKGROUND = new Priority("BACKGROUND", 1);
            USER_INTERACTIVE = new Priority("USER_INTERACTIVE", 2);
            Priority priority = new Priority("SPECIAL", 3);
            SPECIAL = priority;
            $VALUES = new Priority[]{DEFAULT, BACKGROUND, USER_INTERACTIVE, priority};
        }

        public Priority(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static Priority valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (Priority) Enum.valueOf(Priority.class, str);
            }
            return (Priority) invokeL.objValue;
        }

        public static Priority[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (Priority[]) $VALUES.clone();
            }
            return (Priority[]) invokeV.objValue;
        }
    }

    public PriorityStrategy() {
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

    public static int compareTaskPriority(DownloadTask downloadTask, DownloadTask downloadTask2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, downloadTask, downloadTask2)) == null) {
            if (downloadTask == null) {
                return -1;
            }
            if (downloadTask2 == null) {
                return 1;
            }
            if (downloadTask.getPriority() == downloadTask2.getPriority()) {
                long lastSeconds = downloadTask.getLastSeconds() - downloadTask2.getLastSeconds();
                if (downloadTask.getLastSeconds() > 0 && downloadTask2.getLastSeconds() > 0) {
                    if (lastSeconds > 0) {
                        return -1;
                    }
                    return 1;
                } else if (lastSeconds <= 0) {
                    return -1;
                } else {
                    return 1;
                }
            }
            return downloadTask.getPriority() - downloadTask2.getPriority();
        }
        return invokeLL.intValue;
    }
}
