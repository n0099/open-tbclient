package com.baidu.searchbox.v8engine;
@NotProguard
/* loaded from: classes2.dex */
public class InspectorNativeClient {
    private InspectorNativeChannel mChannel;
    private long mNativePtr;

    private native void nativeDestroyInspector(long j);

    private native void nativeDispatchProtocolMessage(long j, String str);

    private native long nativeInitInspector(long j, InspectorNativeChannel inspectorNativeChannel);

    private native void nativeScheduleBreak(long j);

    public InspectorNativeClient(long j, InspectorNativeChannel inspectorNativeChannel) {
        this.mChannel = inspectorNativeChannel;
        this.mNativePtr = nativeInitInspector(j, inspectorNativeChannel);
    }

    public void dispatchProtocolMessage(String str) {
        nativeDispatchProtocolMessage(this.mNativePtr, str);
    }

    public void destroy() {
        nativeDestroyInspector(this.mNativePtr);
    }

    public void scheduleBreak() {
        nativeScheduleBreak(this.mNativePtr);
    }
}
