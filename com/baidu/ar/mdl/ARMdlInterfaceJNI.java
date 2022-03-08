package com.baidu.ar.mdl;

import android.content.res.AssetManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public class ARMdlInterfaceJNI {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(323654549, "Lcom/baidu/ar/mdl/ARMdlInterfaceJNI;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(323654549, "Lcom/baidu/ar/mdl/ARMdlInterfaceJNI;");
                return;
            }
        }
        com.baidu.ar.libloader.a.require("ARMdlSDK");
    }

    public ARMdlInterfaceJNI() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static native int getVersion();

    public static native int initBodyKeyPoint(String str);

    public static native int initBodyKeyPointFromAssetDir(String str);

    public static native int initGesture(String str, String str2, String str3, int i2, int i3, float f2, float f3, float f4, int i4);

    public static native int initGestureFromAsset(String str, String str2, String str3, int i2, int i3, float f2, float f3, float f4, int i4);

    public static native int initHairSeg(String str);

    public static native int initHairSegFromAssetDir(String str);

    public static native int initHandSkeleton(String str, String str2);

    public static native int initHandSkeletonFromAsset(String str, String str2);

    public static native int initHeadSeg(String str);

    public static native int initHeadSegFromAsset(String str);

    public static native int initHumanSeg(String str, int i2, int[] iArr);

    public static native int initHumanSegFromAssetDir(String str, int i2, int[] iArr);

    public static native int initObjDetect(String str, String str2);

    public static native int initObjDetectFromAsset(String str, String str2);

    public static native int initPose(String str, String str2, String str3, int i2, float f2, float[] fArr, float[] fArr2);

    public static native int initPoseFromAsset(String str, String str2, String str3, int i2, float f2, float[] fArr, float[] fArr2);

    public static native int initSkySeg(String str);

    public static native int initSkySegFromAssetDir(String str);

    public static native int initStyleConversation(String str, int[] iArr);

    public static native int predictBodyKeyPoint(ByteBuffer byteBuffer, int i2, int i3, int i4, float[] fArr);

    public static native int predictGesture(ByteBuffer byteBuffer, int i2, int i3, int i4, boolean z, float[] fArr);

    public static native int predictHairSeg(ByteBuffer byteBuffer, int i2, int i3, int i4, int i5, int i6, int i7, boolean z, byte[] bArr, long j2);

    public static native float[] predictHandSkeleton(ByteBuffer byteBuffer, int i2, int i3, int i4, boolean z);

    public static native int predictHandSkeletonByHandle(long j2, int i2);

    public static native int predictHeadSeg(long j2, boolean z);

    public static native int predictHumanSeg(ByteBuffer byteBuffer, int i2, int i3, int i4, boolean z, byte[] bArr, int[] iArr, long j2);

    public static native int predictObjDetect(ByteBuffer byteBuffer, int i2, int i3, int i4, boolean z, float[] fArr);

    public static native int predictPose(ByteBuffer byteBuffer, int i2, int i3, int i4, boolean z, float[] fArr);

    public static native int predictSkySeg(ByteBuffer byteBuffer, int i2, int i3, int i4, int i5, int i6, int i7, boolean z, byte[] bArr, long j2);

    public static native int predictStyleConversation(ByteBuffer byteBuffer, int i2, int i3, byte[] bArr);

    public static native int releaseBodyKeyPoint();

    public static native int releaseGesture();

    public static native int releaseHairSeg();

    public static native int releaseHandSkeleton();

    public static native int releaseHeadSeg();

    public static native int releaseHumanSeg();

    public static native int releaseObjDetect();

    public static native int releasePose();

    public static native int releaseSkySeg();

    public static native int releaseStyleConversation();

    public static native int setAssetManager(AssetManager assetManager);

    public static native int setCacheDir(String str);

    public static native int updateLastFaceInfo(long j2);
}
