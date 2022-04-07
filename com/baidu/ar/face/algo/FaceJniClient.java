package com.baidu.ar.face.algo;

import android.content.res.AssetManager;
import com.baidu.ar.libloader.a;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class FaceJniClient {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1944443298, "Lcom/baidu/ar/face/algo/FaceJniClient;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1944443298, "Lcom/baidu/ar/face/algo/FaceJniClient;");
                return;
            }
        }
        a.require("anakin_lite");
        a.require("FaceAlgoSDK");
    }

    public FaceJniClient() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static native FaceAlgoData animateFace(long j, FaceAlgoData faceAlgoData, long j2);

    public static native long createAnimateCore(String[] strArr);

    public static native long createAnimateCoreFromAssetDir(String[] strArr);

    public static native long createDetectCore(String[] strArr);

    public static native long createDetectCoreFromAssetDir(String[] strArr);

    public static native long createFrame(FAUImage fAUImage);

    public static native long createTrackCore(String[] strArr);

    public static native long createTrackCoreFromAssetDir(String[] strArr);

    public static native boolean destoryFrame(long j);

    public static native FaceAlgoData detectFace(long j, FaceAlgoData faceAlgoData, long j2);

    public static native String getFaceAlgoVersion();

    public static native boolean releaseAnimateCore(long j);

    public static native boolean releaseDetectCore(long j);

    public static native boolean releaseTrackCore(long j);

    public static native int setAssetManager(AssetManager assetManager);

    public static native FaceAlgoData trackFace(long j, FaceAlgoData faceAlgoData, long j2);
}
