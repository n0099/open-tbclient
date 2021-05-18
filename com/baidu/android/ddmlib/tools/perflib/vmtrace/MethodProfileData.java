package com.baidu.android.ddmlib.tools.perflib.vmtrace;

import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class MethodProfileData {
    public static final TimeUnit DATA_TIME_UNITS = TimeUnit.NANOSECONDS;
    public final boolean mIsRecursive;
    public final Map<Integer, MethodStats> mPerThreadCumulativeStats;
    public final Map<Integer, Map<Long, MethodStats>> mPerThreadStatsByCallee;
    public final Map<Integer, Map<Long, MethodStats>> mPerThreadStatsByCaller;

    /* loaded from: classes.dex */
    public static class MethodStats {
        public long mExclusiveGlobalTime;
        public long mExclusiveThreadTime;
        public long mInclusiveGlobalTime;
        public long mInclusiveThreadTime;
        public long mInvocationCount;

        public MethodStats() {
        }

        public static /* synthetic */ long access$1108(MethodStats methodStats) {
            long j = methodStats.mInvocationCount;
            methodStats.mInvocationCount = 1 + j;
            return j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long getInvocationCount() {
            return this.mInvocationCount;
        }

        public long getExclusiveTime(ClockType clockType, TimeUnit timeUnit) {
            return timeUnit.convert(clockType == ClockType.THREAD ? this.mExclusiveThreadTime : this.mExclusiveGlobalTime, MethodProfileData.DATA_TIME_UNITS);
        }

        public long getInclusiveTime(ClockType clockType, TimeUnit timeUnit) {
            return timeUnit.convert(clockType == ClockType.THREAD ? this.mInclusiveThreadTime : this.mInclusiveGlobalTime, MethodProfileData.DATA_TIME_UNITS);
        }
    }

    public Set<Long> getCallees(ThreadInfo threadInfo) {
        Map<Long, MethodStats> map = this.mPerThreadStatsByCallee.get(Integer.valueOf(threadInfo.getId()));
        if (map == null) {
            return Collections.emptySet();
        }
        return map.keySet();
    }

    public Set<Long> getCallers(ThreadInfo threadInfo) {
        Map<Long, MethodStats> map = this.mPerThreadStatsByCaller.get(Integer.valueOf(threadInfo.getId()));
        if (map == null) {
            return Collections.emptySet();
        }
        return map.keySet();
    }

    public long getExclusiveTime(ThreadInfo threadInfo, ClockType clockType, TimeUnit timeUnit) {
        return getExclusiveTime(this.mPerThreadCumulativeStats.get(Integer.valueOf(threadInfo.getId())), clockType, timeUnit);
    }

    public long getExclusiveTimeByCaller(ThreadInfo threadInfo, Long l, ClockType clockType, TimeUnit timeUnit) {
        Map<Long, MethodStats> map = this.mPerThreadStatsByCaller.get(Integer.valueOf(threadInfo.getId()));
        if (map == null) {
            return 0L;
        }
        return getExclusiveTime(map.get(l), clockType, timeUnit);
    }

    public long getInclusiveTime(ThreadInfo threadInfo, ClockType clockType, TimeUnit timeUnit) {
        return getInclusiveTime(this.mPerThreadCumulativeStats.get(Integer.valueOf(threadInfo.getId())), clockType, timeUnit);
    }

    public long getInclusiveTimeByCallee(ThreadInfo threadInfo, Long l, ClockType clockType, TimeUnit timeUnit) {
        Map<Long, MethodStats> map = this.mPerThreadStatsByCallee.get(Integer.valueOf(threadInfo.getId()));
        if (map == null) {
            return 0L;
        }
        return getInclusiveTime(map.get(l), clockType, timeUnit);
    }

    public long getInclusiveTimeByCaller(ThreadInfo threadInfo, Long l, ClockType clockType, TimeUnit timeUnit) {
        Map<Long, MethodStats> map = this.mPerThreadStatsByCaller.get(Integer.valueOf(threadInfo.getId()));
        if (map == null) {
            return 0L;
        }
        return getInclusiveTime(map.get(l), clockType, timeUnit);
    }

    public long getInvocationCount(ThreadInfo threadInfo) {
        return getInvocationCount(this.mPerThreadCumulativeStats.get(Integer.valueOf(threadInfo.getId())));
    }

    public long getInvocationCountFromCaller(ThreadInfo threadInfo, Long l) {
        Map<Long, MethodStats> map = this.mPerThreadStatsByCaller.get(Integer.valueOf(threadInfo.getId()));
        if (map == null) {
            return 0L;
        }
        return getInvocationCount(map.get(l));
    }

    public boolean isRecursive() {
        return this.mIsRecursive;
    }

    public MethodProfileData(Builder builder) {
        this.mPerThreadCumulativeStats = Collections.unmodifiableMap(new LinkedHashMap(builder.mPerThreadCumulativeStats));
        this.mPerThreadStatsByCallee = Collections.unmodifiableMap(new LinkedHashMap(builder.mPerThreadStatsByCallee));
        this.mPerThreadStatsByCaller = Collections.unmodifiableMap(new LinkedHashMap(builder.mPerThreadStatsByCaller));
        this.mIsRecursive = builder.mRecursive;
    }

    /* loaded from: classes.dex */
    public static class Builder {
        public boolean mRecursive;
        public final Map<Integer, MethodStats> mPerThreadCumulativeStats = new HashMap();
        public final Map<Integer, Map<Long, MethodStats>> mPerThreadStatsByCaller = new LinkedHashMap();
        public final Map<Integer, Map<Long, MethodStats>> mPerThreadStatsByCallee = new LinkedHashMap();

        private void addExclusiveTime(Call call, Call call2, ThreadInfo threadInfo, ClockType clockType) {
            long exclusiveTime = call.getExclusiveTime(clockType, MethodProfileData.DATA_TIME_UNITS);
            addExclusiveTime(getPerThreadStats(threadInfo), exclusiveTime, clockType);
            if (call2 != null) {
                addExclusiveTime(getPerCallerStats(threadInfo, call2), exclusiveTime, clockType);
            }
        }

        private void addInclusiveTime(Call call, Call call2, ThreadInfo threadInfo, ClockType clockType) {
            long inclusiveTime = call.getInclusiveTime(clockType, MethodProfileData.DATA_TIME_UNITS);
            addInclusiveTime(getPerThreadStats(threadInfo), inclusiveTime, clockType);
            if (call2 != null) {
                addInclusiveTime(getPerCallerStats(threadInfo, call2), inclusiveTime, clockType);
            }
            for (Call call3 : call.getCallees()) {
                addInclusiveTime(getPerCalleeStats(threadInfo, call3), call3.getInclusiveTime(clockType, MethodProfileData.DATA_TIME_UNITS), clockType);
            }
        }

        private MethodStats getMethodStatsFromTable(Integer num, Long l, Map<Integer, Map<Long, MethodStats>> map) {
            Map<Long, MethodStats> map2 = map.get(num);
            if (map2 == null) {
                MethodStats methodStats = new MethodStats();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(l, methodStats);
                map.put(num, linkedHashMap);
                return methodStats;
            } else if (map2.get(l) == null) {
                MethodStats methodStats2 = new MethodStats();
                map2.put(l, methodStats2);
                return methodStats2;
            } else {
                return map2.get(l);
            }
        }

        private MethodStats getPerCalleeStats(ThreadInfo threadInfo, Call call) {
            return getMethodStatsFromTable(Integer.valueOf(threadInfo.getId()), Long.valueOf(call.getMethodId()), this.mPerThreadStatsByCallee);
        }

        private MethodStats getPerCallerStats(ThreadInfo threadInfo, Call call) {
            return getMethodStatsFromTable(Integer.valueOf(threadInfo.getId()), Long.valueOf(call.getMethodId()), this.mPerThreadStatsByCaller);
        }

        private MethodStats getPerThreadStats(ThreadInfo threadInfo) {
            MethodStats methodStats = this.mPerThreadCumulativeStats.get(Integer.valueOf(threadInfo.getId()));
            if (methodStats == null) {
                MethodStats methodStats2 = new MethodStats();
                this.mPerThreadCumulativeStats.put(Integer.valueOf(threadInfo.getId()), methodStats2);
                return methodStats2;
            }
            return methodStats;
        }

        public void addCallTime(Call call, Call call2, ThreadInfo threadInfo) {
            ClockType[] values;
            for (ClockType clockType : ClockType.values()) {
                addExclusiveTime(call, call2, threadInfo, clockType);
                if (!call.isRecursive()) {
                    addInclusiveTime(call, call2, threadInfo, clockType);
                }
            }
        }

        public MethodProfileData build() {
            return new MethodProfileData(this);
        }

        public void incrementInvocationCount(Call call, Call call2, ThreadInfo threadInfo) {
            MethodStats.access$1108(getPerThreadStats(threadInfo));
            if (call2 != null) {
                MethodStats.access$1108(getPerCallerStats(threadInfo, call2));
            }
            for (Call call3 : call.getCallees()) {
                MethodStats.access$1108(getPerCalleeStats(threadInfo, call3));
            }
        }

        public void setRecursive() {
            this.mRecursive = true;
        }

        private void addExclusiveTime(MethodStats methodStats, long j, ClockType clockType) {
            if (clockType == ClockType.THREAD) {
                methodStats.mExclusiveThreadTime += j;
            } else {
                methodStats.mExclusiveGlobalTime += j;
            }
        }

        private void addInclusiveTime(MethodStats methodStats, long j, ClockType clockType) {
            if (clockType == ClockType.THREAD) {
                methodStats.mInclusiveThreadTime += j;
            } else {
                methodStats.mInclusiveGlobalTime += j;
            }
        }
    }

    private long getExclusiveTime(@Nullable MethodStats methodStats, ClockType clockType, TimeUnit timeUnit) {
        if (methodStats != null) {
            return methodStats.getExclusiveTime(clockType, timeUnit);
        }
        return 0L;
    }

    private long getInclusiveTime(@Nullable MethodStats methodStats, ClockType clockType, TimeUnit timeUnit) {
        if (methodStats != null) {
            return methodStats.getInclusiveTime(clockType, timeUnit);
        }
        return 0L;
    }

    private long getInvocationCount(MethodStats methodStats) {
        if (methodStats != null) {
            return methodStats.getInvocationCount();
        }
        return 0L;
    }
}
