package com.baidu.android.ddmlib.tools.perflib.vmtrace;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.ddmlib.tools.perflib.vmtrace.MethodProfileData;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public class VmTraceData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean mDataFileOverflow;
    public final long mElapsedTimeUs;
    public final Map<Long, MethodInfo> mMethods;
    public final long mStartTimeUs;
    public final Map<String, ThreadInfo> mThreadInfo;
    public final Map<String, String> mTraceProperties;
    public final int mVersion;
    public final String mVm;
    public final VmClockType mVmClockType;

    /* renamed from: com.baidu.android.ddmlib.tools.perflib.vmtrace.VmTraceData$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static class Builder implements VmTraceHandler {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        public static /* synthetic */ Interceptable $ic = null;
        public static final boolean DEBUG = false;
        public static final String KEY_CLOCK = "clock";
        public static final String KEY_DATA_OVERFLOW = "data-file-overflow";
        public static final String KEY_ELAPSED_TIME_US = "elapsed-time-usec";
        public static final String KEY_VM = "vm";
        public transient /* synthetic */ FieldHolder $fh;
        public boolean mDataFileOverflow;
        public long mElapsedTimeUs;
        public final Map<Long, MethodInfo> mMethods;
        public final Map<String, String> mProperties;
        public final SparseArray<CallStackReconstructor> mStackReconstructors;
        public long mStartTimeUs;
        public final SparseArray<String> mThreads;
        public final SparseArray<Call> mTopLevelCalls;
        public int mVersion;
        public String mVm;
        public VmClockType mVmClockType;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(676843069, "Lcom/baidu/android/ddmlib/tools/perflib/vmtrace/VmTraceData$Builder;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(676843069, "Lcom/baidu/android/ddmlib/tools/perflib/vmtrace/VmTraceData$Builder;");
            }
        }

        public Builder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mVmClockType = VmClockType.THREAD_CPU;
            this.mVm = "";
            this.mProperties = new HashMap(10);
            this.mThreads = new SparseArray<>(10);
            this.mMethods = new HashMap(100);
            this.mStackReconstructors = new SparseArray<>(10);
            this.mTopLevelCalls = new SparseArray<>(10);
        }

        private void computeTimingStatistics(VmTraceData vmTraceData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65548, this, vmTraceData) == null) {
                ProfileDataBuilder profileDataBuilder = new ProfileDataBuilder(null);
                for (ThreadInfo threadInfo : vmTraceData.getThreads()) {
                    Call topLevelCall = threadInfo.getTopLevelCall();
                    if (topLevelCall != null) {
                        profileDataBuilder.computeCallStats(topLevelCall, null, threadInfo);
                    }
                }
                for (Long l : profileDataBuilder.getMethodsWithProfileData()) {
                    vmTraceData.getMethod(l.longValue()).setProfileData(profileDataBuilder.getProfileData(l));
                }
            }
        }

        private long createUniqueMethodIdForThread(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65549, this, i2)) == null) {
                long j = Long.MAX_VALUE - i2;
                this.mMethods.put(Long.valueOf(j), new MethodInfo(j, this.mThreads.get(i2), "", "", "", 0));
                return j;
            }
            return invokeI.longValue;
        }

        @Override // com.baidu.android.ddmlib.tools.perflib.vmtrace.VmTraceHandler
        public void addMethod(long j, MethodInfo methodInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJL(1048576, this, j, methodInfo) == null) {
                this.mMethods.put(Long.valueOf(j), methodInfo);
            }
        }

        @Override // com.baidu.android.ddmlib.tools.perflib.vmtrace.VmTraceHandler
        public void addMethodAction(int i2, long j, TraceAction traceAction, int i3, int i4) {
            CallStackReconstructor callStackReconstructor;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j), traceAction, Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
                if (this.mThreads.get(i2) == null) {
                    this.mThreads.put(i2, String.format("Thread id: %1$d", Integer.valueOf(i2)));
                }
                if (this.mMethods.get(Long.valueOf(j)) == null) {
                    this.mMethods.put(Long.valueOf(j), new MethodInfo(j, "unknown", "unknown", "unknown", "unknown", -1));
                }
                CallStackReconstructor callStackReconstructor2 = this.mStackReconstructors.get(i2);
                if (callStackReconstructor2 == null) {
                    CallStackReconstructor callStackReconstructor3 = new CallStackReconstructor(createUniqueMethodIdForThread(i2));
                    this.mStackReconstructors.put(i2, callStackReconstructor3);
                    callStackReconstructor = callStackReconstructor3;
                } else {
                    callStackReconstructor = callStackReconstructor2;
                }
                callStackReconstructor.addTraceAction(j, traceAction, i3, i4);
            }
        }

        @Override // com.baidu.android.ddmlib.tools.perflib.vmtrace.VmTraceHandler
        public void addThread(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, str) == null) {
                this.mThreads.put(i2, str);
            }
        }

        public VmTraceData build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                for (int i2 = 0; i2 < this.mStackReconstructors.size(); i2++) {
                    this.mTopLevelCalls.put(this.mStackReconstructors.keyAt(i2), this.mStackReconstructors.valueAt(i2).getTopLevel());
                }
                VmTraceData vmTraceData = new VmTraceData(this, null);
                computeTimingStatistics(vmTraceData);
                return vmTraceData;
            }
            return (VmTraceData) invokeV.objValue;
        }

        @Override // com.baidu.android.ddmlib.tools.perflib.vmtrace.VmTraceHandler
        public void setProperty(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
                if (str.equals("clock")) {
                    if (str2.equals("thread-cpu")) {
                        this.mVmClockType = VmClockType.THREAD_CPU;
                    } else if (str2.equals("wall")) {
                        this.mVmClockType = VmClockType.WALL;
                    } else if (str2.equals("dual")) {
                        this.mVmClockType = VmClockType.DUAL;
                    }
                } else if (str.equals(KEY_DATA_OVERFLOW)) {
                    this.mDataFileOverflow = Boolean.parseBoolean(str2);
                } else if (str.equals(KEY_VM)) {
                    this.mVm = str2;
                } else if (str.equals(KEY_ELAPSED_TIME_US)) {
                    this.mElapsedTimeUs = Long.parseLong(str2);
                } else {
                    this.mProperties.put(str, str2);
                }
            }
        }

        @Override // com.baidu.android.ddmlib.tools.perflib.vmtrace.VmTraceHandler
        public void setStartTimeUs(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
                this.mStartTimeUs = j;
            }
        }

        @Override // com.baidu.android.ddmlib.tools.perflib.vmtrace.VmTraceHandler
        public void setVersion(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
                this.mVersion = i2;
            }
        }
    }

    public /* synthetic */ VmTraceData(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public static TimeUnit getDefaultTimeUnits() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? TimeUnit.MICROSECONDS : (TimeUnit) invokeV.objValue;
    }

    public double getDurationPercentage(Call call, ThreadInfo threadInfo, ClockType clockType, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{call, threadInfo, clockType, Boolean.valueOf(z)})) == null) ? getDurationPercentage(TimeSelector.create(clockType, z).get(getMethod(call.getMethodId()), threadInfo, TimeUnit.NANOSECONDS), threadInfo, clockType) : invokeCommon.doubleValue;
    }

    public long getElapsedTimeUs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mElapsedTimeUs : invokeV.longValue;
    }

    public MethodInfo getMethod(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) ? this.mMethods.get(Long.valueOf(j)) : (MethodInfo) invokeJ.objValue;
    }

    public Map<Long, MethodInfo> getMethods() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mMethods : (Map) invokeV.objValue;
    }

    public long getStartTimeUs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mStartTimeUs : invokeV.longValue;
    }

    public ThreadInfo getThread(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) ? this.mThreadInfo.get(str) : (ThreadInfo) invokeL.objValue;
    }

    public Collection<ThreadInfo> getThreads() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mThreadInfo.values() : (Collection) invokeV.objValue;
    }

    public Map<String, String> getTraceProperties() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mTraceProperties : (Map) invokeV.objValue;
    }

    public int getVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mVersion : invokeV.intValue;
    }

    public String getVm() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mVm : (String) invokeV.objValue;
    }

    public VmClockType getVmClockType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mVmClockType : (VmClockType) invokeV.objValue;
    }

    public boolean isDataFileOverflow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mDataFileOverflow : invokeV.booleanValue;
    }

    public SearchResult searchFor(String str, ThreadInfo threadInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, str, threadInfo)) == null) {
            String lowerCase = str.toLowerCase(Locale.US);
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            Call topLevelCall = getThread(threadInfo.getName()).getTopLevelCall();
            if (topLevelCall == null) {
                return new SearchResult(hashSet, hashSet2);
            }
            for (MethodInfo methodInfo : getMethods().values()) {
                if (methodInfo.getFullName().toLowerCase(Locale.US).contains(lowerCase) && methodInfo.getProfileData().getInclusiveTime(threadInfo, ClockType.GLOBAL, TimeUnit.NANOSECONDS) > 0) {
                    hashSet.add(methodInfo);
                }
            }
            Iterator<Call> callHierarchyIterator = topLevelCall.getCallHierarchyIterator();
            while (callHierarchyIterator.hasNext()) {
                Call next = callHierarchyIterator.next();
                if (hashSet.contains(getMethod(next.getMethodId()))) {
                    hashSet2.add(next);
                }
            }
            return new SearchResult(hashSet, hashSet2);
        }
        return (SearchResult) invokeLL.objValue;
    }

    /* loaded from: classes6.dex */
    public static class ProfileDataBuilder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Map<Long, MethodProfileData.Builder> mBuilderMap;

        public ProfileDataBuilder() {
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
            this.mBuilderMap = new HashMap();
        }

        @NonNull
        private MethodProfileData.Builder getProfileDataBuilder(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(65538, this, j)) == null) {
                MethodProfileData.Builder builder = this.mBuilderMap.get(Long.valueOf(j));
                if (builder == null) {
                    MethodProfileData.Builder builder2 = new MethodProfileData.Builder();
                    this.mBuilderMap.put(Long.valueOf(j), builder2);
                    return builder2;
                }
                return builder;
            }
            return (MethodProfileData.Builder) invokeJ.objValue;
        }

        public void computeCallStats(Call call, Call call2, ThreadInfo threadInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, call, call2, threadInfo) == null) {
                MethodProfileData.Builder profileDataBuilder = getProfileDataBuilder(call.getMethodId());
                profileDataBuilder.addCallTime(call, call2, threadInfo);
                profileDataBuilder.incrementInvocationCount(call, call2, threadInfo);
                if (call.isRecursive()) {
                    profileDataBuilder.setRecursive();
                }
                for (Call call3 : call.getCallees()) {
                    computeCallStats(call3, call, threadInfo);
                }
            }
        }

        public Set<Long> getMethodsWithProfileData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mBuilderMap.keySet() : (Set) invokeV.objValue;
        }

        public MethodProfileData getProfileData(Long l) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, l)) == null) ? this.mBuilderMap.get(l).build() : (MethodProfileData) invokeL.objValue;
        }

        public /* synthetic */ ProfileDataBuilder(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public VmTraceData(Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mVersion = builder.mVersion;
        this.mDataFileOverflow = builder.mDataFileOverflow;
        this.mVmClockType = builder.mVmClockType;
        this.mVm = builder.mVm;
        this.mTraceProperties = builder.mProperties;
        this.mMethods = builder.mMethods;
        this.mStartTimeUs = builder.mStartTimeUs;
        this.mElapsedTimeUs = builder.mElapsedTimeUs;
        this.mThreadInfo = new HashMap(builder.mThreads.size());
        for (int i4 = 0; i4 < builder.mThreads.size(); i4++) {
            int keyAt = builder.mThreads.keyAt(i4);
            String str = (String) builder.mThreads.valueAt(i4);
            if (this.mThreadInfo.get(str) != null) {
                str = String.format("%1$s-%2$d", str, Integer.valueOf(keyAt));
            }
            this.mThreadInfo.put(str, new ThreadInfo(keyAt, str, (Call) builder.mTopLevelCalls.get(keyAt)));
        }
    }

    public List<ThreadInfo> getThreads(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z)) == null) {
            Collection<ThreadInfo> threads = getThreads();
            if (!z) {
                return new ArrayList(threads);
            }
            ArrayList arrayList = new ArrayList();
            for (ThreadInfo threadInfo : threads) {
                if (threadInfo.getTopLevelCall() != null) {
                    arrayList.add(threadInfo);
                }
            }
            return arrayList;
        }
        return (List) invokeZ.objValue;
    }

    public double getDurationPercentage(long j, ThreadInfo threadInfo, ClockType clockType) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), threadInfo, clockType})) == null) {
            Call topLevelCall = getThread(threadInfo.getName()).getTopLevelCall();
            if (topLevelCall == null) {
                return 100.0d;
            }
            return (j / TimeSelector.create(clockType, true).get(getMethod(topLevelCall.getMethodId()), threadInfo, TimeUnit.NANOSECONDS)) * 100.0d;
        }
        return invokeCommon.doubleValue;
    }
}
