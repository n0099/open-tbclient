package com.baidu.ar.pose;

import android.os.Bundle;
import android.os.SystemClock;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.core.pixel.FramePixels;
import com.baidu.ar.arplay.core.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.pixel.PixelType;
import com.baidu.ar.b.b.b;
import com.baidu.ar.bus.CallBack;
import com.baidu.ar.c.c;
import com.baidu.ar.d.e;
import com.baidu.ar.mdl.ARMdlInterfaceJNI;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class PoseDetector extends com.baidu.ar.b.a.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "PoseDetector";
    public static int[] tP;
    public static int[] tQ;
    public transient /* synthetic */ FieldHolder $fh;
    public int oU;
    public boolean tO;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1757350186, "Lcom/baidu/ar/pose/PoseDetector;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1757350186, "Lcom/baidu/ar/pose/PoseDetector;");
                return;
            }
        }
        tP = new int[]{2, 3, 4, 8, 9, 10, 14, 16};
        tQ = new int[]{5, 6, 7, 11, 12, 13, 15, 17};
    }

    public PoseDetector() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.oU = 0;
        this.tO = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0014 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0017 A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int c(int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) != null) {
            return invokeCommon.intValue;
        }
        if (i2 == -90) {
            return 0;
        }
        if (i2 != 0) {
            if (i2 != 90) {
                return (i2 == 180 ? !z : z) ? -90 : 90;
            }
            return 180;
        } else if (z) {
        }
    }

    public static void m(float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, fArr) == null) {
            for (int i2 = 0; i2 < 8; i2++) {
                int[] iArr = tP;
                float f2 = fArr[iArr[i2] * 3];
                float f3 = fArr[(iArr[i2] * 3) + 1];
                float f4 = fArr[(iArr[i2] * 3) + 2];
                int[] iArr2 = tQ;
                fArr[iArr[i2] * 3] = fArr[iArr2[i2] * 3];
                fArr[(iArr[i2] * 3) + 1] = fArr[(iArr2[i2] * 3) + 1];
                fArr[(iArr[i2] * 3) + 2] = fArr[(iArr2[i2] * 3) + 2];
                fArr[iArr2[i2] * 3] = f2;
                fArr[(iArr2[i2] * 3) + 1] = f3;
                fArr[(iArr2[i2] * 3) + 2] = f4;
            }
        }
    }

    public void I(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.tO = z;
        }
    }

    @Override // com.baidu.ar.b.a.a
    public b a(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle)) == null) ? new b(this, this.oU, bundle) { // from class: com.baidu.ar.pose.PoseDetector.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Bundle qr;
            public final /* synthetic */ PoseDetector tR;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(r8), bundle};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super(((Integer) newInitContext.callArgs[0]).intValue());
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.tR = this;
                this.qr = bundle;
            }

            @Override // com.baidu.ar.b.b.b
            public int a(com.baidu.ar.mdl.a aVar) {
                InterceptResult invokeL2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, aVar)) == null) {
                    String[] strArr = aVar.tw;
                    if (strArr == null || strArr.length == 0) {
                        return -1;
                    }
                    float f2 = this.qr.getFloat(PoseAR.MDL_MAGIC_FILTER_CUTOFFSLOPE, 1.0f);
                    float[] floatArray = this.qr.getFloatArray(PoseAR.MDL_MAGIC_FILTER_MIN_CUTOFFFREQ);
                    return aVar.f36466tv ? ARMdlInterfaceJNI.initPoseFromAsset(strArr[0], strArr[1], strArr[2], 1, f2, floatArray, floatArray) : ARMdlInterfaceJNI.initPose(strArr[0], strArr[1], strArr[2], 1, f2, floatArray, floatArray);
                }
                return invokeL2.intValue;
            }

            @Override // com.baidu.ar.c.a
            public String getTag() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "pose" : (String) invokeV.objValue;
            }
        } : (b) invokeL.objValue;
    }

    @Override // com.baidu.ar.b.a.a, com.baidu.ar.d.j
    public void aq() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.aq();
            c.cd().b(this);
        }
    }

    @Override // com.baidu.ar.b.a.a
    public com.baidu.ar.b.b.a at() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new com.baidu.ar.b.b.a(this, this.oU) { // from class: com.baidu.ar.pose.PoseDetector.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PoseDetector tR;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super(((Integer) newInitContext.callArgs[0]).intValue());
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.tR = this;
            }

            @Override // com.baidu.ar.b.b.a
            public int ax() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048576, this)) == null) ? ARMdlInterfaceJNI.releasePose() : invokeV2.intValue;
            }

            @Override // com.baidu.ar.c.a
            public String getTag() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "pose" : (String) invokeV2.objValue;
            }
        } : (com.baidu.ar.b.b.a) invokeV.objValue;
    }

    @Override // com.baidu.ar.b.a.a
    public int au() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.ar.b.a.a
    public com.baidu.ar.b.b.c d(FramePixels framePixels) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, framePixels)) == null) ? new com.baidu.ar.b.b.c(this, this.oU, framePixels) { // from class: com.baidu.ar.pose.PoseDetector.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PoseDetector tR;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r9, framePixels);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(r9), framePixels};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super(((Integer) objArr2[0]).intValue(), (FramePixels) objArr2[1]);
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.tR = this;
            }

            @Override // com.baidu.ar.c.a
            public String getTag() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "pose" : (String) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.ar.b.b.c
            /* renamed from: j */
            public a e(FramePixels framePixels2) {
                InterceptResult invokeL2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, framePixels2)) == null) {
                    int c2 = framePixels2.isCameraFrame() ? this.tR.c(framePixels2.getOrientation().getDegree(), framePixels2.isFrontCamera()) : 180;
                    long timestamp = framePixels2.getTimestamp();
                    float[] fArr = new float[54];
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    ARMdlInterfaceJNI.predictPose(framePixels2.getPixelsAddress(), framePixels2.getWidth(), framePixels2.getHeight(), c2, framePixels2.isFrontCamera(), fArr);
                    StatisticApi.getPerformanceApi().recordAlgoTimeCost("body_pose", "predict", SystemClock.elapsedRealtime() - elapsedRealtime, 0);
                    if (framePixels2.isFrontCamera()) {
                        PoseDetector.m(fArr);
                        for (int i2 = 0; i2 < 18; i2++) {
                            int i3 = (i2 * 3) + 1;
                            fArr[i3] = 1.0f - fArr[i3];
                        }
                    }
                    return new a(this.tR.getName(), fArr, timestamp);
                }
                return (a) invokeL2.objValue;
            }
        } : (com.baidu.ar.b.b.c) invokeL.objValue;
    }

    @Override // com.baidu.ar.d.k
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? TAG : (String) invokeV.objValue;
    }

    public void i(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048583, this, i2, i3) == null) {
            c.cd().a(this);
            PixelReadParams pixelReadParams = new PixelReadParams(PixelType.BGR);
            this.nk = pixelReadParams;
            pixelReadParams.setOutputWidth(i2);
            this.nk.setOutputHeight(i3);
        }
    }

    @CallBack
    public void onMdlResult(a aVar) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) || (eVar = this.mv) == null) {
            return;
        }
        eVar.a(aVar);
    }
}
