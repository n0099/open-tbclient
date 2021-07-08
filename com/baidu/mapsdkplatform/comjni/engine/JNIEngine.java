package com.baidu.mapsdkplatform.comjni.engine;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes2.dex */
public class JNIEngine {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static native boolean InitEngine(Context context);

    public static native void SetProxyInfo(String str, int i2);

    public static native boolean StartSocketProc();

    public static native boolean UnInitEngine();

    public static native int initClass(Object obj, int i2);
}
