package com.baidu.ar.face.algo;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class FaceAlgoConfig {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean autoCalibrate;
    public boolean debug;
    public float eyeCloseProbThreshold;
    public int failureThreshold;
    public boolean forceLost;
    public boolean isAnimojiMode;
    public int maxTrackingFace;
    public float minDetectionWidth;
    public boolean mirror;
    public boolean needExpression;
    public boolean needHeadPose;
    public boolean needRefineEyes;
    public boolean needRefineIris;
    public boolean needRefineMouth;
    public boolean needSkeleton;
    public boolean needTriggers;
    public int runningMode;
    public float trackingMouthSmoothAlpha;
    public float trackingMouthThreshold;
    public int trackingQuality;
    public int trackingRotation;
    public float trackingSmoothAlpha;
    public float trackingSmoothThreshold;

    public FaceAlgoConfig(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.runningMode = 0;
        this.maxTrackingFace = 1;
        this.trackingRotation = -1;
        this.failureThreshold = 5;
        this.minDetectionWidth = 100.0f;
        this.trackingSmoothAlpha = 0.1f;
        this.trackingSmoothThreshold = 1.0f;
        this.trackingMouthThreshold = -1.0f;
        this.trackingMouthSmoothAlpha = 0.0075f;
        this.eyeCloseProbThreshold = -1.0f;
        this.mirror = true;
        this.isAnimojiMode = false;
        this.needRefineEyes = false;
        this.needRefineIris = false;
        this.needHeadPose = true;
        this.needSkeleton = true;
        this.needTriggers = true;
        this.forceLost = false;
        this.needRefineMouth = false;
        this.needExpression = false;
        this.debug = false;
        this.trackingRotation = i2;
    }

    public FaceAlgoConfig(int i2, int i3, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2), Float.valueOf(f3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.runningMode = 0;
        this.maxTrackingFace = 1;
        this.trackingRotation = -1;
        this.failureThreshold = 5;
        this.minDetectionWidth = 100.0f;
        this.trackingSmoothAlpha = 0.1f;
        this.trackingSmoothThreshold = 1.0f;
        this.trackingMouthThreshold = -1.0f;
        this.trackingMouthSmoothAlpha = 0.0075f;
        this.eyeCloseProbThreshold = -1.0f;
        this.mirror = true;
        this.isAnimojiMode = false;
        this.needRefineEyes = false;
        this.needRefineIris = false;
        this.needHeadPose = true;
        this.needSkeleton = true;
        this.needTriggers = true;
        this.forceLost = false;
        this.needRefineMouth = false;
        this.needExpression = false;
        this.debug = false;
        this.trackingRotation = i2;
        this.failureThreshold = i3;
        this.trackingSmoothAlpha = f2;
        this.trackingSmoothThreshold = f3;
    }

    public FaceAlgoConfig cloneInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            FaceAlgoConfig faceAlgoConfig = new FaceAlgoConfig(this.trackingRotation, this.failureThreshold, this.trackingSmoothAlpha, this.trackingSmoothThreshold);
            faceAlgoConfig.setAnimateRunningMode(this.needHeadPose, this.needSkeleton, this.needTriggers);
            faceAlgoConfig.setAutoCalibrate(this.autoCalibrate);
            faceAlgoConfig.setRunningMode(this.runningMode);
            faceAlgoConfig.setMirror(this.mirror);
            faceAlgoConfig.setIsAnimojiMode(this.isAnimojiMode);
            faceAlgoConfig.setMaxTrackingFace(this.maxTrackingFace);
            faceAlgoConfig.setNeedRefineEyes(this.needRefineEyes);
            faceAlgoConfig.setForceLost(this.forceLost);
            faceAlgoConfig.setNeedRefineMouth(this.needRefineMouth);
            faceAlgoConfig.setNeedExpression(this.needExpression);
            faceAlgoConfig.setTrackingMouthThreshold(this.trackingMouthThreshold);
            faceAlgoConfig.setTrackingMouthSmoothAlpha(this.trackingMouthSmoothAlpha);
            return faceAlgoConfig;
        }
        return (FaceAlgoConfig) invokeV.objValue;
    }

    public void setAnimateRunningMode(boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            this.needHeadPose = z;
            this.needSkeleton = z2;
            this.needTriggers = z3;
        }
    }

    public void setAutoCalibrate(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.autoCalibrate = z;
        }
    }

    public void setDebug(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.debug = z;
        }
    }

    public void setEyeCloseProbThreshold(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048580, this, f2) == null) {
            this.eyeCloseProbThreshold = f2;
        }
    }

    public void setFailureThreshold(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.failureThreshold = i2;
        }
    }

    public void setForceLost(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.forceLost = z;
        }
    }

    public void setIsAnimojiMode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.isAnimojiMode = z;
        }
    }

    public void setMaxTrackingFace(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.maxTrackingFace = i2;
        }
    }

    public void setMirror(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.mirror = z;
        }
    }

    public void setNeedExpression(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.needExpression = z;
        }
    }

    public void setNeedHeadPose(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.needHeadPose = z;
        }
    }

    public void setNeedRefineEyes(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.needRefineEyes = z;
            this.needRefineIris = z;
        }
    }

    public void setNeedRefineMouth(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.needRefineMouth = z;
        }
    }

    public void setNeedSkeleton(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.needSkeleton = z;
        }
    }

    public void setNeedTriggers(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.needTriggers = z;
        }
    }

    public void setRunningMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.runningMode = i2;
        }
    }

    public void setTrackingMouthSmoothAlpha(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048593, this, f2) == null) {
            this.trackingMouthSmoothAlpha = f2;
        }
    }

    public void setTrackingMouthThreshold(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048594, this, f2) == null) {
            this.trackingMouthThreshold = f2;
        }
    }

    public void setTrackingRT(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.trackingRotation = i2;
        }
    }

    public void setTrackingSmoothAlpha(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048596, this, f2) == null) {
            this.trackingSmoothAlpha = f2;
        }
    }

    public void setTrackingSmoothThreshold(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048597, this, f2) == null) {
            this.trackingSmoothThreshold = f2;
        }
    }
}
