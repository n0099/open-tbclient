package com.baidu.android.ddmlib.tools.perflib.vmtrace;
/* loaded from: classes10.dex */
public interface VmTraceHandler {
    void addMethod(long j2, MethodInfo methodInfo);

    void addMethodAction(int i2, long j2, TraceAction traceAction, int i3, int i4);

    void addThread(int i2, String str);

    void setProperty(String str, String str2);

    void setStartTimeUs(long j2);

    void setVersion(int i2);
}
