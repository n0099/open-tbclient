package com.baidu.android.ddmlib.tools.perflib.vmtrace;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.TimeUnit;
/* loaded from: classes9.dex */
public abstract class TimeSelector {
    public static /* synthetic */ Interceptable $ic;
    public static final TimeSelector sExclusiveGlobalTimeSelector;
    public static final TimeSelector sExclusiveThreadTimeSelector;
    public static final TimeSelector sInclusiveGlobalTimeSelector;
    public static final TimeSelector sInclusiveThreadTimeSelector;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.android.ddmlib.tools.perflib.vmtrace.TimeSelector$5  reason: invalid class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class AnonymousClass5 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$android$ddmlib$tools$perflib$vmtrace$ClockType;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1500025523, "Lcom/baidu/android/ddmlib/tools/perflib/vmtrace/TimeSelector$5;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1500025523, "Lcom/baidu/android/ddmlib/tools/perflib/vmtrace/TimeSelector$5;");
                    return;
                }
            }
            int[] iArr = new int[ClockType.values().length];
            $SwitchMap$com$baidu$android$ddmlib$tools$perflib$vmtrace$ClockType = iArr;
            try {
                iArr[ClockType.THREAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$android$ddmlib$tools$perflib$vmtrace$ClockType[ClockType.GLOBAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1522459774, "Lcom/baidu/android/ddmlib/tools/perflib/vmtrace/TimeSelector;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1522459774, "Lcom/baidu/android/ddmlib/tools/perflib/vmtrace/TimeSelector;");
                return;
            }
        }
        sInclusiveThreadTimeSelector = new TimeSelector() { // from class: com.baidu.android.ddmlib.tools.perflib.vmtrace.TimeSelector.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.android.ddmlib.tools.perflib.vmtrace.TimeSelector
            public long get(MethodInfo methodInfo, ThreadInfo threadInfo, TimeUnit timeUnit) {
                InterceptResult invokeLLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLLL = interceptable2.invokeLLL(1048576, this, methodInfo, threadInfo, timeUnit)) == null) ? methodInfo.getProfileData().getInclusiveTime(threadInfo, ClockType.THREAD, timeUnit) : invokeLLL.longValue;
            }
        };
        sInclusiveGlobalTimeSelector = new TimeSelector() { // from class: com.baidu.android.ddmlib.tools.perflib.vmtrace.TimeSelector.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.android.ddmlib.tools.perflib.vmtrace.TimeSelector
            public long get(MethodInfo methodInfo, ThreadInfo threadInfo, TimeUnit timeUnit) {
                InterceptResult invokeLLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLLL = interceptable2.invokeLLL(1048576, this, methodInfo, threadInfo, timeUnit)) == null) ? methodInfo.getProfileData().getInclusiveTime(threadInfo, ClockType.GLOBAL, timeUnit) : invokeLLL.longValue;
            }
        };
        sExclusiveThreadTimeSelector = new TimeSelector() { // from class: com.baidu.android.ddmlib.tools.perflib.vmtrace.TimeSelector.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.android.ddmlib.tools.perflib.vmtrace.TimeSelector
            public long get(MethodInfo methodInfo, ThreadInfo threadInfo, TimeUnit timeUnit) {
                InterceptResult invokeLLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLLL = interceptable2.invokeLLL(1048576, this, methodInfo, threadInfo, timeUnit)) == null) ? methodInfo.getProfileData().getExclusiveTime(threadInfo, ClockType.THREAD, timeUnit) : invokeLLL.longValue;
            }
        };
        sExclusiveGlobalTimeSelector = new TimeSelector() { // from class: com.baidu.android.ddmlib.tools.perflib.vmtrace.TimeSelector.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.android.ddmlib.tools.perflib.vmtrace.TimeSelector
            public long get(MethodInfo methodInfo, ThreadInfo threadInfo, TimeUnit timeUnit) {
                InterceptResult invokeLLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLLL = interceptable2.invokeLLL(1048576, this, methodInfo, threadInfo, timeUnit)) == null) ? methodInfo.getProfileData().getExclusiveTime(threadInfo, ClockType.GLOBAL, timeUnit) : invokeLLL.longValue;
            }
        };
    }

    public TimeSelector() {
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

    public static TimeSelector create(ClockType clockType, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, null, clockType, z)) == null) {
            int i2 = AnonymousClass5.$SwitchMap$com$baidu$android$ddmlib$tools$perflib$vmtrace$ClockType[clockType.ordinal()];
            if (i2 == 1) {
                return z ? sInclusiveThreadTimeSelector : sExclusiveThreadTimeSelector;
            } else if (i2 == 2) {
                return z ? sInclusiveGlobalTimeSelector : sExclusiveGlobalTimeSelector;
            } else {
                throw new IllegalArgumentException();
            }
        }
        return (TimeSelector) invokeLZ.objValue;
    }

    public abstract long get(MethodInfo methodInfo, ThreadInfo threadInfo, TimeUnit timeUnit);
}
