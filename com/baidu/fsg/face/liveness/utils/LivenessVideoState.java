package com.baidu.fsg.face.liveness.utils;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class LivenessVideoState {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int STATE_RECOG_FIRST = 1;
    public static final int STATE_RECOG_INIT = 0;
    public static final int STATE_SHOWING_LRCTIP = 3;
    public static final int STATE_TO_SHOW_LRCTIP = 2;
    public static final int STATE_TO_START_VIDEO = 4;
    public static final int STATE_VIDEO = 5;
    public static final int STATE_VIDEO_DONE = 6;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f40028a;

    /* renamed from: b  reason: collision with root package name */
    public long f40029b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f40030c;
    public int currentCount;
    public int currentState;
    public boolean isLrcTipAnimCalling;
    public boolean isLrcTipViewHadGone;
    public boolean isWarningTipAnimCalled;
    public long lrcTextStartTime;
    public int reqTimes;

    public LivenessVideoState() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.currentState = 0;
        this.currentCount = 0;
        this.f40030c = false;
        this.isLrcTipViewHadGone = false;
    }

    public String getLrcStartTimeOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return ((this.lrcTextStartTime - this.f40028a) / 1000) + "";
        }
        return (String) invokeV.objValue;
    }

    public long getVideoTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (System.currentTimeMillis() - this.f40028a) / 1000 : invokeV.longValue;
    }

    public boolean isFirstRecog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.currentState == 1 : invokeV.booleanValue;
    }

    public boolean isFirstRecogTimeout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.currentState < 5 && System.currentTimeMillis() - this.f40028a > 20000 : invokeV.booleanValue;
    }

    public boolean isGotoRecogFace(long[] jArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, jArr)) == null) {
            if (this.currentState < 5 && !this.f40030c) {
                this.f40030c = true;
                return true;
            }
            if (this.currentState == 5 && jArr != null && jArr.length != 0) {
                if (jArr.length > this.currentCount) {
                    int i2 = this.currentCount;
                    if ((System.currentTimeMillis() - this.lrcTextStartTime) / 1000 == jArr[i2]) {
                        this.currentCount = i2 + 1;
                        return true;
                    }
                }
                if (jArr.length > this.currentCount) {
                    int i3 = this.currentCount;
                    if ((System.currentTimeMillis() - this.lrcTextStartTime) / 1000 > jArr[i3]) {
                        this.currentCount = i3 + 1;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean isInitOk() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.currentState > 0 : invokeV.booleanValue;
    }

    public boolean isVideoStateLostFaceTimeout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.currentState == 5 && System.currentTimeMillis() - this.f40029b > 5000 : invokeV.booleanValue;
    }

    public boolean isWarnCancleTipAfterOnPause() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.currentState < 6 : invokeV.booleanValue;
    }

    public void setLastFindFaceStartTime() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f40029b = System.currentTimeMillis();
        }
    }

    public void setLrcTextStartTime() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.lrcTextStartTime = System.currentTimeMillis();
        }
    }

    public void setProcessStartTime() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f40028a = System.currentTimeMillis();
            setLastFindFaceStartTime();
        }
    }

    public void updateState(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.currentState = i2;
        }
    }
}
