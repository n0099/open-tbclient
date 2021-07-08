package com.baidu.android.ddmlib.tools.perflib.vmtrace;

import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class MethodProfileData {
    public static /* synthetic */ Interceptable $ic;
    public static final TimeUnit DATA_TIME_UNITS;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean mIsRecursive;
    public final Map<Integer, MethodStats> mPerThreadCumulativeStats;
    public final Map<Integer, Map<Long, MethodStats>> mPerThreadStatsByCallee;
    public final Map<Integer, Map<Long, MethodStats>> mPerThreadStatsByCaller;

    /* renamed from: com.baidu.android.ddmlib.tools.perflib.vmtrace.MethodProfileData$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public static class MethodStats {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long mExclusiveGlobalTime;
        public long mExclusiveThreadTime;
        public long mInclusiveGlobalTime;
        public long mInclusiveThreadTime;
        public long mInvocationCount;

        public MethodStats() {
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

        public static /* synthetic */ long access$1108(MethodStats methodStats) {
            long j = methodStats.mInvocationCount;
            methodStats.mInvocationCount = 1 + j;
            return j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long getInvocationCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) ? this.mInvocationCount : invokeV.longValue;
        }

        public long getExclusiveTime(ClockType clockType, TimeUnit timeUnit) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, clockType, timeUnit)) == null) {
                return timeUnit.convert(clockType == ClockType.THREAD ? this.mExclusiveThreadTime : this.mExclusiveGlobalTime, MethodProfileData.DATA_TIME_UNITS);
            }
            return invokeLL.longValue;
        }

        public long getInclusiveTime(ClockType clockType, TimeUnit timeUnit) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, clockType, timeUnit)) == null) {
                return timeUnit.convert(clockType == ClockType.THREAD ? this.mInclusiveThreadTime : this.mInclusiveGlobalTime, MethodProfileData.DATA_TIME_UNITS);
            }
            return invokeLL.longValue;
        }

        public /* synthetic */ MethodStats(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1637264902, "Lcom/baidu/android/ddmlib/tools/perflib/vmtrace/MethodProfileData;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1637264902, "Lcom/baidu/android/ddmlib/tools/perflib/vmtrace/MethodProfileData;");
                return;
            }
        }
        DATA_TIME_UNITS = TimeUnit.NANOSECONDS;
    }

    public /* synthetic */ MethodProfileData(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public Set<Long> getCallees(ThreadInfo threadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, threadInfo)) == null) {
            Map<Long, MethodStats> map = this.mPerThreadStatsByCallee.get(Integer.valueOf(threadInfo.getId()));
            if (map == null) {
                return Collections.emptySet();
            }
            return map.keySet();
        }
        return (Set) invokeL.objValue;
    }

    public Set<Long> getCallers(ThreadInfo threadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadInfo)) == null) {
            Map<Long, MethodStats> map = this.mPerThreadStatsByCaller.get(Integer.valueOf(threadInfo.getId()));
            if (map == null) {
                return Collections.emptySet();
            }
            return map.keySet();
        }
        return (Set) invokeL.objValue;
    }

    public long getExclusiveTime(ThreadInfo threadInfo, ClockType clockType, TimeUnit timeUnit) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, threadInfo, clockType, timeUnit)) == null) ? getExclusiveTime(this.mPerThreadCumulativeStats.get(Integer.valueOf(threadInfo.getId())), clockType, timeUnit) : invokeLLL.longValue;
    }

    public long getExclusiveTimeByCaller(ThreadInfo threadInfo, Long l, ClockType clockType, TimeUnit timeUnit) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, threadInfo, l, clockType, timeUnit)) == null) {
            Map<Long, MethodStats> map = this.mPerThreadStatsByCaller.get(Integer.valueOf(threadInfo.getId()));
            if (map == null) {
                return 0L;
            }
            return getExclusiveTime(map.get(l), clockType, timeUnit);
        }
        return invokeLLLL.longValue;
    }

    public long getInclusiveTime(ThreadInfo threadInfo, ClockType clockType, TimeUnit timeUnit) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, threadInfo, clockType, timeUnit)) == null) ? getInclusiveTime(this.mPerThreadCumulativeStats.get(Integer.valueOf(threadInfo.getId())), clockType, timeUnit) : invokeLLL.longValue;
    }

    public long getInclusiveTimeByCallee(ThreadInfo threadInfo, Long l, ClockType clockType, TimeUnit timeUnit) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048581, this, threadInfo, l, clockType, timeUnit)) == null) {
            Map<Long, MethodStats> map = this.mPerThreadStatsByCallee.get(Integer.valueOf(threadInfo.getId()));
            if (map == null) {
                return 0L;
            }
            return getInclusiveTime(map.get(l), clockType, timeUnit);
        }
        return invokeLLLL.longValue;
    }

    public long getInclusiveTimeByCaller(ThreadInfo threadInfo, Long l, ClockType clockType, TimeUnit timeUnit) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048582, this, threadInfo, l, clockType, timeUnit)) == null) {
            Map<Long, MethodStats> map = this.mPerThreadStatsByCaller.get(Integer.valueOf(threadInfo.getId()));
            if (map == null) {
                return 0L;
            }
            return getInclusiveTime(map.get(l), clockType, timeUnit);
        }
        return invokeLLLL.longValue;
    }

    public long getInvocationCount(ThreadInfo threadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, threadInfo)) == null) ? getInvocationCount(this.mPerThreadCumulativeStats.get(Integer.valueOf(threadInfo.getId()))) : invokeL.longValue;
    }

    public long getInvocationCountFromCaller(ThreadInfo threadInfo, Long l) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, threadInfo, l)) == null) {
            Map<Long, MethodStats> map = this.mPerThreadStatsByCaller.get(Integer.valueOf(threadInfo.getId()));
            if (map == null) {
                return 0L;
            }
            return getInvocationCount(map.get(l));
        }
        return invokeLL.longValue;
    }

    public boolean isRecursive() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mIsRecursive : invokeV.booleanValue;
    }

    public MethodProfileData(Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mPerThreadCumulativeStats = Collections.unmodifiableMap(new LinkedHashMap(builder.mPerThreadCumulativeStats));
        this.mPerThreadStatsByCallee = Collections.unmodifiableMap(new LinkedHashMap(builder.mPerThreadStatsByCallee));
        this.mPerThreadStatsByCaller = Collections.unmodifiableMap(new LinkedHashMap(builder.mPerThreadStatsByCaller));
        this.mIsRecursive = builder.mRecursive;
    }

    /* loaded from: classes.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Map<Integer, MethodStats> mPerThreadCumulativeStats;
        public final Map<Integer, Map<Long, MethodStats>> mPerThreadStatsByCallee;
        public final Map<Integer, Map<Long, MethodStats>> mPerThreadStatsByCaller;
        public boolean mRecursive;

        public Builder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mPerThreadCumulativeStats = new HashMap();
            this.mPerThreadStatsByCaller = new LinkedHashMap();
            this.mPerThreadStatsByCallee = new LinkedHashMap();
        }

        private void addExclusiveTime(Call call, Call call2, ThreadInfo threadInfo, ClockType clockType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(AdIconUtil.AD_TEXT_ID, this, call, call2, threadInfo, clockType) == null) {
                long exclusiveTime = call.getExclusiveTime(clockType, MethodProfileData.DATA_TIME_UNITS);
                addExclusiveTime(getPerThreadStats(threadInfo), exclusiveTime, clockType);
                if (call2 != null) {
                    addExclusiveTime(getPerCallerStats(threadInfo, call2), exclusiveTime, clockType);
                }
            }
        }

        private void addInclusiveTime(Call call, Call call2, ThreadInfo threadInfo, ClockType clockType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(65543, this, call, call2, threadInfo, clockType) == null) {
                long inclusiveTime = call.getInclusiveTime(clockType, MethodProfileData.DATA_TIME_UNITS);
                addInclusiveTime(getPerThreadStats(threadInfo), inclusiveTime, clockType);
                if (call2 != null) {
                    addInclusiveTime(getPerCallerStats(threadInfo, call2), inclusiveTime, clockType);
                }
                for (Call call3 : call.getCallees()) {
                    addInclusiveTime(getPerCalleeStats(threadInfo, call3), call3.getInclusiveTime(clockType, MethodProfileData.DATA_TIME_UNITS), clockType);
                }
            }
        }

        private MethodStats getMethodStatsFromTable(Integer num, Long l, Map<Integer, Map<Long, MethodStats>> map) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65545, this, num, l, map)) == null) {
                Map<Long, MethodStats> map2 = map.get(num);
                if (map2 == null) {
                    MethodStats methodStats = new MethodStats(null);
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put(l, methodStats);
                    map.put(num, linkedHashMap);
                    return methodStats;
                } else if (map2.get(l) == null) {
                    MethodStats methodStats2 = new MethodStats(null);
                    map2.put(l, methodStats2);
                    return methodStats2;
                } else {
                    return map2.get(l);
                }
            }
            return (MethodStats) invokeLLL.objValue;
        }

        private MethodStats getPerCalleeStats(ThreadInfo threadInfo, Call call) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65546, this, threadInfo, call)) == null) ? getMethodStatsFromTable(Integer.valueOf(threadInfo.getId()), Long.valueOf(call.getMethodId()), this.mPerThreadStatsByCallee) : (MethodStats) invokeLL.objValue;
        }

        private MethodStats getPerCallerStats(ThreadInfo threadInfo, Call call) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65547, this, threadInfo, call)) == null) ? getMethodStatsFromTable(Integer.valueOf(threadInfo.getId()), Long.valueOf(call.getMethodId()), this.mPerThreadStatsByCaller) : (MethodStats) invokeLL.objValue;
        }

        private MethodStats getPerThreadStats(ThreadInfo threadInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65548, this, threadInfo)) == null) {
                MethodStats methodStats = this.mPerThreadCumulativeStats.get(Integer.valueOf(threadInfo.getId()));
                if (methodStats == null) {
                    MethodStats methodStats2 = new MethodStats(null);
                    this.mPerThreadCumulativeStats.put(Integer.valueOf(threadInfo.getId()), methodStats2);
                    return methodStats2;
                }
                return methodStats;
            }
            return (MethodStats) invokeL.objValue;
        }

        public void addCallTime(Call call, Call call2, ThreadInfo threadInfo) {
            ClockType[] values;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, call, call2, threadInfo) == null) {
                for (ClockType clockType : ClockType.values()) {
                    addExclusiveTime(call, call2, threadInfo, clockType);
                    if (!call.isRecursive()) {
                        addInclusiveTime(call, call2, threadInfo, clockType);
                    }
                }
            }
        }

        public MethodProfileData build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new MethodProfileData(this, null) : (MethodProfileData) invokeV.objValue;
        }

        public void incrementInvocationCount(Call call, Call call2, ThreadInfo threadInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, call, call2, threadInfo) == null) {
                MethodStats.access$1108(getPerThreadStats(threadInfo));
                if (call2 != null) {
                    MethodStats.access$1108(getPerCallerStats(threadInfo, call2));
                }
                for (Call call3 : call.getCallees()) {
                    MethodStats.access$1108(getPerCalleeStats(threadInfo, call3));
                }
            }
        }

        public void setRecursive() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.mRecursive = true;
            }
        }

        private void addExclusiveTime(MethodStats methodStats, long j, ClockType clockType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, this, new Object[]{methodStats, Long.valueOf(j), clockType}) == null) {
                if (clockType == ClockType.THREAD) {
                    methodStats.mExclusiveThreadTime += j;
                } else {
                    methodStats.mExclusiveGlobalTime += j;
                }
            }
        }

        private void addInclusiveTime(MethodStats methodStats, long j, ClockType clockType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(65544, this, new Object[]{methodStats, Long.valueOf(j), clockType}) == null) {
                if (clockType == ClockType.THREAD) {
                    methodStats.mInclusiveThreadTime += j;
                } else {
                    methodStats.mInclusiveGlobalTime += j;
                }
            }
        }
    }

    private long getExclusiveTime(@Nullable MethodStats methodStats, ClockType clockType, TimeUnit timeUnit) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, this, methodStats, clockType, timeUnit)) == null) {
            if (methodStats != null) {
                return methodStats.getExclusiveTime(clockType, timeUnit);
            }
            return 0L;
        }
        return invokeLLL.longValue;
    }

    private long getInclusiveTime(@Nullable MethodStats methodStats, ClockType clockType, TimeUnit timeUnit) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, this, methodStats, clockType, timeUnit)) == null) {
            if (methodStats != null) {
                return methodStats.getInclusiveTime(clockType, timeUnit);
            }
            return 0L;
        }
        return invokeLLL.longValue;
    }

    private long getInvocationCount(MethodStats methodStats) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, methodStats)) == null) {
            if (methodStats != null) {
                return methodStats.getInvocationCount();
            }
            return 0L;
        }
        return invokeL.longValue;
    }
}
