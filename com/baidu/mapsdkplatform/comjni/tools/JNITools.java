package com.baidu.mapsdkplatform.comjni.tools;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class JNITools {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static native boolean CoordinateEncryptEx(float f2, float f3, String str, Object obj);

    public static native boolean CoordinateEncryptMc(float f2, float f3, Object obj);

    public static native void GetDistanceByMC(Object obj);

    public static native String GetToken();

    public static native boolean TransGeoStr2ComplexPt(Object obj);

    public static native boolean TransGeoStr2Pt(Object obj);

    public static native void TransNodeStr2Pt(Object obj);

    public static native double[] baiduToGcj(double d2, double d3);

    public static native double[] gcjToBaidu(double d2, double d3);

    public static native int initClass(Object obj, int i2);

    public static native void openLogEnable(boolean z, int i2);

    public static native double[] wgsToBaidu(double d2, double d3);
}
