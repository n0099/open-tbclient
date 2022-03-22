package com.baidu.android.ddmlib.tools.perflib.vmtrace;
/* loaded from: classes3.dex */
public interface VmTraceHandler {
    void addMethod(long j, MethodInfo methodInfo);

    void addMethodAction(int i, long j, TraceAction traceAction, int i2, int i3);

    void addThread(int i, String str);

    void setProperty(String str, String str2);

    void setStartTimeUs(long j);

    void setVersion(int i);
}
