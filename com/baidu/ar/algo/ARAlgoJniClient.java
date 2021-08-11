package com.baidu.ar.algo;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public class ARAlgoJniClient {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ARAlgoJniClient arAlgoJniClient;
    public transient /* synthetic */ FieldHolder $fh;
    public long trackSystemHandler;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1944893851, "Lcom/baidu/ar/algo/ARAlgoJniClient;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1944893851, "Lcom/baidu/ar/algo/ARAlgoJniClient;");
                return;
            }
        }
        com.baidu.ar.libloader.a.require("module_basic");
    }

    public ARAlgoJniClient() {
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
        this.trackSystemHandler = 0L;
    }

    public static native int calModelPosition(float[] fArr, float f2, float[] fArr2, float[] fArr3);

    public static ARAlgoJniClient getAlgoInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (arAlgoJniClient == null) {
                synchronized (ARAlgoJniClient.class) {
                    if (arAlgoJniClient == null) {
                        arAlgoJniClient = new ARAlgoJniClient();
                    }
                }
            }
            return arAlgoJniClient;
        }
        return (ARAlgoJniClient) invokeV.objValue;
    }

    public static String getVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? nativeGetVersion() : (String) invokeV.objValue;
    }

    private native int nativeAddTracker2D(long j2, String str);

    private native int nativeAddTracker3D(long j2, String str, int i2);

    private native int nativeAddTrackerVO(long j2, String str);

    private native int nativeAddTrackerVPS(long j2, String str);

    private native int nativeCreateTrackingSystem(long j2, int i2, int i3, float[] fArr, float[] fArr2);

    private native int nativeGet2dMarkerSize(long j2, int i2, int[] iArr);

    private native int nativeGetModelPose(long j2, int i2, String str, float[] fArr);

    private native int nativeGetTrackerPose(long j2, int i2, float[] fArr);

    public static native String nativeGetVersion();

    private native long nativeInitTrackerSystem();

    private native int nativeInsertModel(long j2, int i2, int i3, int i4, String str, float f2, float[] fArr);

    private native int nativeRelease(long j2);

    private native int nativeRemoveAllModels(long j2, int i2);

    private native int nativeRemoveAllTrackers(long j2);

    private native int nativeRemoveModel(long j2, int i2, String str);

    private native int nativeRemoveTracker(long j2, int i2);

    private native int nativeResetAllTrackers(long j2);

    private native int nativeResetTracker(long j2, int i2);

    private native int nativeTrackFrame(long j2, byte[] bArr, double d2, float[] fArr, FrameType frameType);

    private native int nativeTrackFrameByteBuffer(long j2, ByteBuffer byteBuffer, double d2, float[] fArr, FrameType frameType);

    private native int nativeVpsServerReceiver(long j2, int i2, byte[] bArr);

    public int addTracker2D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            long j2 = this.trackSystemHandler;
            if (j2 == 0) {
                return -2;
            }
            return nativeAddTracker2D(j2, str);
        }
        return invokeL.intValue;
    }

    public int addTracker3D(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2)) == null) {
            long j2 = this.trackSystemHandler;
            if (j2 == 0) {
                return -2;
            }
            return nativeAddTracker3D(j2, str, i2);
        }
        return invokeLI.intValue;
    }

    public int addTrackerVO(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            long j2 = this.trackSystemHandler;
            if (j2 == 0) {
                return -2;
            }
            return nativeAddTrackerVO(j2, str);
        }
        return invokeL.intValue;
    }

    public int addTrackerVPS(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            long j2 = this.trackSystemHandler;
            if (j2 == 0) {
                return -2;
            }
            return nativeAddTrackerVPS(j2, str);
        }
        return invokeL.intValue;
    }

    public int createTrackingSystem(int i2, int i3, float[] fArr, float[] fArr2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), fArr, fArr2})) == null) {
            long nativeInitTrackerSystem = nativeInitTrackerSystem();
            this.trackSystemHandler = nativeInitTrackerSystem;
            return nativeCreateTrackingSystem(nativeInitTrackerSystem, i2, i3, fArr, fArr2);
        }
        return invokeCommon.intValue;
    }

    public int get2DMarkerSize(int i2, int[] iArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048581, this, i2, iArr)) == null) {
            long j2 = this.trackSystemHandler;
            if (j2 == 0) {
                return -2;
            }
            return nativeGet2dMarkerSize(j2, i2, iArr);
        }
        return invokeIL.intValue;
    }

    public int getModelPose(int i2, String str, float[] fArr) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, str, fArr)) == null) {
            long j2 = this.trackSystemHandler;
            if (j2 == 0) {
                return -2;
            }
            return nativeGetModelPose(j2, i2, str, fArr);
        }
        return invokeILL.intValue;
    }

    public int getTrackerPose(int i2, float[] fArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048583, this, i2, fArr)) == null) {
            long j2 = this.trackSystemHandler;
            if (j2 == 0) {
                return -2;
            }
            return nativeGetTrackerPose(j2, i2, fArr);
        }
        return invokeIL.intValue;
    }

    public int insertModel(int i2, int i3, int i4, String str, float f2, float[] fArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, Float.valueOf(f2), fArr})) == null) {
            long j2 = this.trackSystemHandler;
            if (j2 == 0) {
                return -2;
            }
            return nativeInsertModel(j2, i2, i3, i4, str, f2, fArr);
        }
        return invokeCommon.intValue;
    }

    public int release() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            long j2 = this.trackSystemHandler;
            if (j2 == 0) {
                return 0;
            }
            int nativeRelease = nativeRelease(j2);
            this.trackSystemHandler = 0L;
            return nativeRelease;
        }
        return invokeV.intValue;
    }

    public int removeAllModels(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            long j2 = this.trackSystemHandler;
            if (j2 == 0) {
                return -2;
            }
            return nativeRemoveAllModels(j2, i2);
        }
        return invokeI.intValue;
    }

    public int removeAllTrackers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            long j2 = this.trackSystemHandler;
            if (j2 == 0) {
                return -2;
            }
            return nativeRemoveAllTrackers(j2);
        }
        return invokeV.intValue;
    }

    public int removeModel(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048588, this, i2, str)) == null) {
            long j2 = this.trackSystemHandler;
            if (j2 == 0) {
                return -2;
            }
            return nativeRemoveModel(j2, i2, str);
        }
        return invokeIL.intValue;
    }

    public int removeTracker(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
            long j2 = this.trackSystemHandler;
            if (j2 == 0) {
                return -2;
            }
            return nativeRemoveTracker(j2, i2);
        }
        return invokeI.intValue;
    }

    public int resetAllTrackers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            long j2 = this.trackSystemHandler;
            if (j2 == 0) {
                return -2;
            }
            return nativeResetAllTrackers(j2);
        }
        return invokeV.intValue;
    }

    public int resetTracker(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
            long j2 = this.trackSystemHandler;
            if (j2 == 0) {
                return -2;
            }
            return nativeResetTracker(j2, i2);
        }
        return invokeI.intValue;
    }

    public int trackFrame(ByteBuffer byteBuffer, double d2, float[] fArr, FrameType frameType) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{byteBuffer, Double.valueOf(d2), fArr, frameType})) == null) {
            long j2 = this.trackSystemHandler;
            if (j2 == 0) {
                return -2;
            }
            return nativeTrackFrameByteBuffer(j2, byteBuffer, d2, fArr, frameType);
        }
        return invokeCommon.intValue;
    }

    public int trackFrame(byte[] bArr, double d2, float[] fArr, FrameType frameType) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{bArr, Double.valueOf(d2), fArr, frameType})) == null) {
            long j2 = this.trackSystemHandler;
            if (j2 == 0) {
                return -2;
            }
            return nativeTrackFrame(j2, bArr, d2, fArr, frameType);
        }
        return invokeCommon.intValue;
    }

    public int vpsServerReceiver(int i2, byte[] bArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048594, this, i2, bArr)) == null) {
            long j2 = this.trackSystemHandler;
            if (j2 == 0) {
                return -2;
            }
            return nativeVpsServerReceiver(j2, i2, bArr);
        }
        return invokeIL.intValue;
    }
}
