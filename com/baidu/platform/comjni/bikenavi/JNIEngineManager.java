package com.baidu.platform.comjni.bikenavi;
/* loaded from: classes4.dex */
public class JNIEngineManager {
    public native long getSubSysHandle(long j, int i, long[] jArr);

    public native int initBaseManager(Object obj, long j, long[] jArr);

    public native void uninitBaseManager(long j);
}
