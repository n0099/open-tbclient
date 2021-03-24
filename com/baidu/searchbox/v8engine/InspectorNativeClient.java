package com.baidu.searchbox.v8engine;
@NotProguard
/* loaded from: classes3.dex */
public class InspectorNativeClient {
    public InspectorNativeChannel mChannel;
    public long mNativePtr;

    public InspectorNativeClient(long j, InspectorNativeChannel inspectorNativeChannel) {
        this.mChannel = inspectorNativeChannel;
        this.mNativePtr = nativeInitInspector(j, inspectorNativeChannel);
    }

    private native void nativeDestroyInspector(long j);

    private native void nativeDispatchProtocolMessage(long j, String str);

    private native long nativeInitInspector(long j, InspectorNativeChannel inspectorNativeChannel);

    private native void nativeScheduleBreak(long j);

    public void destroy() {
        nativeDestroyInspector(this.mNativePtr);
    }

    public void dispatchProtocolMessage(String str) {
        nativeDispatchProtocolMessage(this.mNativePtr, str);
    }

    public void scheduleBreak() {
        nativeScheduleBreak(this.mNativePtr);
    }
}
