package com.baidu.android.ddmlib.tools.perflib.vmtrace;
/* loaded from: classes.dex */
public interface VmTraceHandler {
    void addMethod(long j, MethodInfo methodInfo);

    void addMethodAction(int i2, long j, TraceAction traceAction, int i3, int i4);

    void addThread(int i2, String str);

    void setProperty(String str, String str2);

    void setStartTimeUs(long j);

    void setVersion(int i2);
}
