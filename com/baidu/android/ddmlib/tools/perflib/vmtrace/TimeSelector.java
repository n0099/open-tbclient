package com.baidu.android.ddmlib.tools.perflib.vmtrace;

import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public abstract class TimeSelector {
    public static final TimeSelector sInclusiveThreadTimeSelector = new TimeSelector() { // from class: com.baidu.android.ddmlib.tools.perflib.vmtrace.TimeSelector.1
        @Override // com.baidu.android.ddmlib.tools.perflib.vmtrace.TimeSelector
        public long get(MethodInfo methodInfo, ThreadInfo threadInfo, TimeUnit timeUnit) {
            return methodInfo.getProfileData().getInclusiveTime(threadInfo, ClockType.THREAD, timeUnit);
        }
    };
    public static final TimeSelector sInclusiveGlobalTimeSelector = new TimeSelector() { // from class: com.baidu.android.ddmlib.tools.perflib.vmtrace.TimeSelector.2
        @Override // com.baidu.android.ddmlib.tools.perflib.vmtrace.TimeSelector
        public long get(MethodInfo methodInfo, ThreadInfo threadInfo, TimeUnit timeUnit) {
            return methodInfo.getProfileData().getInclusiveTime(threadInfo, ClockType.GLOBAL, timeUnit);
        }
    };
    public static final TimeSelector sExclusiveThreadTimeSelector = new TimeSelector() { // from class: com.baidu.android.ddmlib.tools.perflib.vmtrace.TimeSelector.3
        @Override // com.baidu.android.ddmlib.tools.perflib.vmtrace.TimeSelector
        public long get(MethodInfo methodInfo, ThreadInfo threadInfo, TimeUnit timeUnit) {
            return methodInfo.getProfileData().getExclusiveTime(threadInfo, ClockType.THREAD, timeUnit);
        }
    };
    public static final TimeSelector sExclusiveGlobalTimeSelector = new TimeSelector() { // from class: com.baidu.android.ddmlib.tools.perflib.vmtrace.TimeSelector.4
        @Override // com.baidu.android.ddmlib.tools.perflib.vmtrace.TimeSelector
        public long get(MethodInfo methodInfo, ThreadInfo threadInfo, TimeUnit timeUnit) {
            return methodInfo.getProfileData().getExclusiveTime(threadInfo, ClockType.GLOBAL, timeUnit);
        }
    };

    /* renamed from: com.baidu.android.ddmlib.tools.perflib.vmtrace.TimeSelector$5  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass5 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$android$ddmlib$tools$perflib$vmtrace$ClockType;

        static {
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

    public static TimeSelector create(ClockType clockType, boolean z) {
        int i2 = AnonymousClass5.$SwitchMap$com$baidu$android$ddmlib$tools$perflib$vmtrace$ClockType[clockType.ordinal()];
        if (i2 == 1) {
            return z ? sInclusiveThreadTimeSelector : sExclusiveThreadTimeSelector;
        } else if (i2 == 2) {
            return z ? sInclusiveGlobalTimeSelector : sExclusiveGlobalTimeSelector;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public abstract long get(MethodInfo methodInfo, ThreadInfo threadInfo, TimeUnit timeUnit);
}
