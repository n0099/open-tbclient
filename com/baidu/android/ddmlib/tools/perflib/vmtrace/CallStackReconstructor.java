package com.baidu.android.ddmlib.tools.perflib.vmtrace;

import androidx.annotation.Nullable;
import com.baidu.android.ddmlib.tools.perflib.vmtrace.Call;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/* loaded from: classes.dex */
public class CallStackReconstructor {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public Call mTopLevelCall;
    public final long mTopLevelCallId;
    public final List<Call.Builder> mTopLevelCalls = new ArrayList();
    public final Stack<Call.Builder> mCallStack = new Stack<>();

    public CallStackReconstructor(long j) {
        this.mTopLevelCallId = j;
    }

    private void enterMethod(long j, int i2, int i3) {
        Call.Builder builder = new Call.Builder(j);
        builder.setMethodEntryTime(i2, i3);
        if (this.mCallStack.isEmpty()) {
            this.mTopLevelCalls.add(builder);
        } else {
            this.mCallStack.peek().addCallee(builder);
        }
        this.mCallStack.push(builder);
    }

    private void exitMethod(long j, int i2, int i3) {
        if (!this.mCallStack.isEmpty()) {
            Call.Builder pop = this.mCallStack.pop();
            if (pop.getMethodId() == j) {
                pop.setMethodExitTime(i2, i3);
                return;
            }
            throw new RuntimeException(String.format("Error during call stack reconstruction. Attempt to exit from method 0x%1$x while in method 0x%2$x", Long.valueOf(pop.getMethodId()), Long.valueOf(j)));
        }
        Call.Builder builder = new Call.Builder(j);
        for (Call.Builder builder2 : this.mTopLevelCalls) {
            builder.addCallee(builder2);
        }
        this.mTopLevelCalls.clear();
        this.mTopLevelCalls.add(builder);
        builder.setMethodExitTime(i2, i3);
        int i4 = i2 - 1;
        int i5 = i3 - 1;
        if (builder.getCallees() != null && !builder.getCallees().isEmpty()) {
            Call.Builder builder3 = builder.getCallees().get(0);
            i4 = Math.max(builder3.getMethodEntryThreadTime() - 1, 0);
            i5 = Math.max(builder3.getMethodEntryGlobalTime() - 1, 0);
        }
        builder.setMethodEntryTime(i4, i5);
    }

    private void fixupCallStacks() {
        if (this.mTopLevelCall != null) {
            return;
        }
        while (!this.mCallStack.isEmpty()) {
            Call.Builder peek = this.mCallStack.peek();
            exitMethod(peek.getMethodId(), peek.getMethodEntryThreadTime(), peek.getMethodEntryGlobalTime(), peek.getCallees());
        }
        exitMethod(this.mTopLevelCallId, 0, 0, this.mTopLevelCalls);
        this.mTopLevelCall = this.mTopLevelCalls.get(0).build(new Stack<>());
    }

    public void addTraceAction(long j, TraceAction traceAction, int i2, int i3) {
        if (traceAction == TraceAction.METHOD_ENTER) {
            enterMethod(j, i2, i3);
        } else {
            exitMethod(j, i2, i3);
        }
    }

    public Call getTopLevel() {
        fixupCallStacks();
        return this.mTopLevelCall;
    }

    private void exitMethod(long j, int i2, int i3, @Nullable List<Call.Builder> list) {
        int i4;
        int i5;
        if (list == null || list.isEmpty()) {
            int i6 = i3 + 1;
            i4 = i2 + 1;
            i5 = i6;
        } else {
            Call.Builder builder = list.get(list.size() - 1);
            i4 = builder.getMethodExitThreadTime() + 1;
            i5 = builder.getMethodExitGlobalTime() + 1;
        }
        exitMethod(j, i4, i5);
    }
}
