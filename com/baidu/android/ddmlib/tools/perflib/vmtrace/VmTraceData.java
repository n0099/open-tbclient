package com.baidu.android.ddmlib.tools.perflib.vmtrace;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.baidu.android.ddmlib.tools.perflib.vmtrace.MethodProfileData;
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
/* loaded from: classes.dex */
public class VmTraceData {
    public final boolean mDataFileOverflow;
    public final long mElapsedTimeUs;
    public final Map<Long, MethodInfo> mMethods;
    public final long mStartTimeUs;
    public final Map<String, ThreadInfo> mThreadInfo;
    public final Map<String, String> mTraceProperties;
    public final int mVersion;
    public final String mVm;
    public final VmClockType mVmClockType;

    /* loaded from: classes.dex */
    public static class Builder implements VmTraceHandler {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        public static final boolean DEBUG = false;
        public static final String KEY_CLOCK = "clock";
        public static final String KEY_DATA_OVERFLOW = "data-file-overflow";
        public static final String KEY_ELAPSED_TIME_US = "elapsed-time-usec";
        public static final String KEY_VM = "vm";
        public boolean mDataFileOverflow;
        public long mElapsedTimeUs;
        public long mStartTimeUs;
        public int mVersion;
        public VmClockType mVmClockType = VmClockType.THREAD_CPU;
        public String mVm = "";
        public final Map<String, String> mProperties = new HashMap(10);
        public final SparseArray<String> mThreads = new SparseArray<>(10);
        public final Map<Long, MethodInfo> mMethods = new HashMap(100);
        public final SparseArray<CallStackReconstructor> mStackReconstructors = new SparseArray<>(10);
        public final SparseArray<Call> mTopLevelCalls = new SparseArray<>(10);

        private void computeTimingStatistics(VmTraceData vmTraceData) {
            ProfileDataBuilder profileDataBuilder = new ProfileDataBuilder();
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

        private long createUniqueMethodIdForThread(int i2) {
            long j = Long.MAX_VALUE - i2;
            this.mMethods.put(Long.valueOf(j), new MethodInfo(j, this.mThreads.get(i2), "", "", "", 0));
            return j;
        }

        @Override // com.baidu.android.ddmlib.tools.perflib.vmtrace.VmTraceHandler
        public void addMethod(long j, MethodInfo methodInfo) {
            this.mMethods.put(Long.valueOf(j), methodInfo);
        }

        @Override // com.baidu.android.ddmlib.tools.perflib.vmtrace.VmTraceHandler
        public void addMethodAction(int i2, long j, TraceAction traceAction, int i3, int i4) {
            CallStackReconstructor callStackReconstructor;
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

        @Override // com.baidu.android.ddmlib.tools.perflib.vmtrace.VmTraceHandler
        public void addThread(int i2, String str) {
            this.mThreads.put(i2, str);
        }

        public VmTraceData build() {
            for (int i2 = 0; i2 < this.mStackReconstructors.size(); i2++) {
                this.mTopLevelCalls.put(this.mStackReconstructors.keyAt(i2), this.mStackReconstructors.valueAt(i2).getTopLevel());
            }
            VmTraceData vmTraceData = new VmTraceData(this);
            computeTimingStatistics(vmTraceData);
            return vmTraceData;
        }

        @Override // com.baidu.android.ddmlib.tools.perflib.vmtrace.VmTraceHandler
        public void setProperty(String str, String str2) {
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

        @Override // com.baidu.android.ddmlib.tools.perflib.vmtrace.VmTraceHandler
        public void setStartTimeUs(long j) {
            this.mStartTimeUs = j;
        }

        @Override // com.baidu.android.ddmlib.tools.perflib.vmtrace.VmTraceHandler
        public void setVersion(int i2) {
            this.mVersion = i2;
        }
    }

    /* loaded from: classes.dex */
    public static class ProfileDataBuilder {
        public final Map<Long, MethodProfileData.Builder> mBuilderMap;

        public ProfileDataBuilder() {
            this.mBuilderMap = new HashMap();
        }

        @NonNull
        private MethodProfileData.Builder getProfileDataBuilder(long j) {
            MethodProfileData.Builder builder = this.mBuilderMap.get(Long.valueOf(j));
            if (builder == null) {
                MethodProfileData.Builder builder2 = new MethodProfileData.Builder();
                this.mBuilderMap.put(Long.valueOf(j), builder2);
                return builder2;
            }
            return builder;
        }

        public void computeCallStats(Call call, Call call2, ThreadInfo threadInfo) {
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

        public Set<Long> getMethodsWithProfileData() {
            return this.mBuilderMap.keySet();
        }

        public MethodProfileData getProfileData(Long l) {
            return this.mBuilderMap.get(l).build();
        }
    }

    public static TimeUnit getDefaultTimeUnits() {
        return TimeUnit.MICROSECONDS;
    }

    public double getDurationPercentage(Call call, ThreadInfo threadInfo, ClockType clockType, boolean z) {
        return getDurationPercentage(TimeSelector.create(clockType, z).get(getMethod(call.getMethodId()), threadInfo, TimeUnit.NANOSECONDS), threadInfo, clockType);
    }

    public long getElapsedTimeUs() {
        return this.mElapsedTimeUs;
    }

    public MethodInfo getMethod(long j) {
        return this.mMethods.get(Long.valueOf(j));
    }

    public Map<Long, MethodInfo> getMethods() {
        return this.mMethods;
    }

    public long getStartTimeUs() {
        return this.mStartTimeUs;
    }

    public ThreadInfo getThread(String str) {
        return this.mThreadInfo.get(str);
    }

    public Collection<ThreadInfo> getThreads() {
        return this.mThreadInfo.values();
    }

    public Map<String, String> getTraceProperties() {
        return this.mTraceProperties;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public String getVm() {
        return this.mVm;
    }

    public VmClockType getVmClockType() {
        return this.mVmClockType;
    }

    public boolean isDataFileOverflow() {
        return this.mDataFileOverflow;
    }

    public SearchResult searchFor(String str, ThreadInfo threadInfo) {
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

    public VmTraceData(Builder builder) {
        this.mVersion = builder.mVersion;
        this.mDataFileOverflow = builder.mDataFileOverflow;
        this.mVmClockType = builder.mVmClockType;
        this.mVm = builder.mVm;
        this.mTraceProperties = builder.mProperties;
        this.mMethods = builder.mMethods;
        this.mStartTimeUs = builder.mStartTimeUs;
        this.mElapsedTimeUs = builder.mElapsedTimeUs;
        this.mThreadInfo = new HashMap(builder.mThreads.size());
        for (int i2 = 0; i2 < builder.mThreads.size(); i2++) {
            int keyAt = builder.mThreads.keyAt(i2);
            String str = (String) builder.mThreads.valueAt(i2);
            if (this.mThreadInfo.get(str) != null) {
                str = String.format("%1$s-%2$d", str, Integer.valueOf(keyAt));
            }
            this.mThreadInfo.put(str, new ThreadInfo(keyAt, str, (Call) builder.mTopLevelCalls.get(keyAt)));
        }
    }

    public List<ThreadInfo> getThreads(boolean z) {
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

    public double getDurationPercentage(long j, ThreadInfo threadInfo, ClockType clockType) {
        Call topLevelCall = getThread(threadInfo.getName()).getTopLevelCall();
        if (topLevelCall == null) {
            return 100.0d;
        }
        return (j / TimeSelector.create(clockType, true).get(getMethod(topLevelCall.getMethodId()), threadInfo, TimeUnit.NANOSECONDS)) * 100.0d;
    }
}
