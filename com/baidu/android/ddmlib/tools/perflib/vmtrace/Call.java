package com.baidu.android.ddmlib.tools.perflib.vmtrace;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.ddmlib.tools.perflib.vmtrace.utils.Strings;
import com.baidu.webkit.sdk.LoadErrorCode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class Call {
    public static final Formatter METHOD_ID_FORMATTER = new Formatter() { // from class: com.baidu.android.ddmlib.tools.perflib.vmtrace.Call.1
        @Override // com.baidu.android.ddmlib.tools.perflib.vmtrace.Call.Formatter
        public String format(Call call) {
            return Long.toString(call.getMethodId());
        }
    };
    public final List<Call> mCallees;
    public final int mDepth;
    public final int mEntryGlobalTime;
    public final int mEntryThreadTime;
    public final int mExitGlobalTime;
    public final int mExitThreadTime;
    public final long mInclusiveGlobalTimeInCallees;
    public final long mInclusiveThreadTimeInCallees;
    public final boolean mIsRecursive;
    public final long mMethodId;

    /* loaded from: classes.dex */
    public static class Builder {
        public List<Builder> mCallees = null;
        public int mEntryGlobalTime;
        public int mEntryThreadTime;
        public int mExitGlobalTime;
        public int mExitThreadTime;
        public final long mMethodId;

        public Builder(long j) {
            this.mMethodId = j;
        }

        public void addCallee(Builder builder) {
            if (this.mCallees == null) {
                this.mCallees = new ArrayList();
            }
            this.mCallees.add(builder);
        }

        @NonNull
        public Call build(@NonNull Stack<Long> stack) {
            return new Call(this, stack);
        }

        @Nullable
        public List<Builder> getCallees() {
            return this.mCallees;
        }

        public int getMethodEntryGlobalTime() {
            return this.mEntryGlobalTime;
        }

        public int getMethodEntryThreadTime() {
            return this.mEntryThreadTime;
        }

        public int getMethodExitGlobalTime() {
            return this.mExitGlobalTime;
        }

        public int getMethodExitThreadTime() {
            return this.mExitThreadTime;
        }

        public long getMethodId() {
            return this.mMethodId;
        }

        public void setMethodEntryTime(int i2, int i3) {
            this.mEntryThreadTime = i2;
            this.mEntryGlobalTime = i3;
        }

        public void setMethodExitTime(int i2, int i3) {
            this.mExitThreadTime = i2;
            this.mExitGlobalTime = i3;
        }
    }

    /* loaded from: classes.dex */
    public static class CallHierarchyIterator implements Iterator<Call> {
        public final Stack<Call> mCallStack;

        public CallHierarchyIterator(@NonNull Call call) {
            Stack<Call> stack = new Stack<>();
            this.mCallStack = stack;
            stack.push(call);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.mCallStack.isEmpty();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public Call next() {
            if (this.mCallStack.isEmpty()) {
                return null;
            }
            Call pop = this.mCallStack.pop();
            for (int size = pop.getCallees().size() - 1; size >= 0; size--) {
                this.mCallStack.push(pop.getCallees().get(size));
            }
            return pop;
        }
    }

    /* loaded from: classes.dex */
    public interface Formatter {
        String format(Call call);
    }

    private void printCallHierarchy(@NonNull StringBuilder sb, Formatter formatter) {
        sb.append(LoadErrorCode.TOKEN_NEXT);
        sb.append(formatter.format(this));
        List<Call> callees = getCallees();
        int length = sb.length() - (sb.lastIndexOf("\n") + 1);
        for (int i2 = 0; i2 < callees.size(); i2++) {
            if (i2 != 0) {
                sb.append("\n");
                sb.append(Strings.repeat(" ", length));
            }
            callees.get(i2).printCallHierarchy(sb, formatter);
        }
    }

    private long sumInclusiveTimes(@NonNull List<Call> list, ClockType clockType) {
        long j = 0;
        for (Call call : list) {
            j += call.getInclusiveTime(clockType, TimeUnit.MICROSECONDS);
        }
        return j;
    }

    public String format(Formatter formatter) {
        StringBuilder sb = new StringBuilder(100);
        printCallHierarchy(sb, formatter);
        return sb.toString();
    }

    @NonNull
    public Iterator<Call> getCallHierarchyIterator() {
        return new CallHierarchyIterator(this);
    }

    @NonNull
    public List<Call> getCallees() {
        return this.mCallees;
    }

    public int getDepth() {
        return this.mDepth;
    }

    public long getEntryTime(ClockType clockType, TimeUnit timeUnit) {
        return timeUnit.convert((clockType == ClockType.THREAD ? this.mEntryThreadTime : this.mEntryGlobalTime) & 4294967295L, VmTraceData.getDefaultTimeUnits());
    }

    public long getExclusiveTime(ClockType clockType, TimeUnit timeUnit) {
        return timeUnit.convert(getInclusiveTime(clockType, VmTraceData.getDefaultTimeUnits()) - (clockType == ClockType.THREAD ? this.mInclusiveThreadTimeInCallees : this.mInclusiveGlobalTimeInCallees), VmTraceData.getDefaultTimeUnits());
    }

    public long getExitTime(ClockType clockType, TimeUnit timeUnit) {
        return timeUnit.convert((clockType == ClockType.THREAD ? this.mExitThreadTime : this.mExitGlobalTime) & 4294967295L, VmTraceData.getDefaultTimeUnits());
    }

    public long getInclusiveTime(ClockType clockType, TimeUnit timeUnit) {
        int i2;
        int i3;
        if (clockType == ClockType.THREAD) {
            i2 = this.mExitThreadTime;
            i3 = this.mEntryThreadTime;
        } else {
            i2 = this.mExitGlobalTime;
            i3 = this.mEntryGlobalTime;
        }
        return timeUnit.convert((i2 - i3) & 4294967295L, VmTraceData.getDefaultTimeUnits());
    }

    public long getMethodId() {
        return this.mMethodId;
    }

    public boolean isRecursive() {
        return this.mIsRecursive;
    }

    public String toString() {
        return format(METHOD_ID_FORMATTER);
    }

    public Call(@NonNull Builder builder, @NonNull Stack<Long> stack) {
        this.mMethodId = builder.mMethodId;
        this.mEntryThreadTime = builder.mEntryThreadTime;
        this.mEntryGlobalTime = builder.mEntryGlobalTime;
        this.mExitThreadTime = builder.mExitThreadTime;
        this.mExitGlobalTime = builder.mExitGlobalTime;
        this.mDepth = stack.size();
        this.mIsRecursive = stack.contains(Long.valueOf(this.mMethodId));
        if (builder.mCallees == null) {
            this.mCallees = Collections.emptyList();
        } else {
            stack.push(Long.valueOf(this.mMethodId));
            ArrayList arrayList = new ArrayList(builder.mCallees.size());
            for (Builder builder2 : builder.mCallees) {
                arrayList.add(builder2.build(stack));
            }
            stack.pop();
            this.mCallees = Collections.unmodifiableList(arrayList);
        }
        this.mInclusiveThreadTimeInCallees = sumInclusiveTimes(this.mCallees, ClockType.THREAD);
        this.mInclusiveGlobalTimeInCallees = sumInclusiveTimes(this.mCallees, ClockType.GLOBAL);
    }
}
