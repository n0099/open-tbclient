package com.baidu.searchbox.afx.decode;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.afx.decode.VideoPlayer;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class SpeedControl implements VideoPlayer.FrameCallback {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long ONE_MILLION = 1000000;
    public static final String TAG = "SpeedControl";
    public transient /* synthetic */ FieldHolder $fh;
    public long mFixedFrameDurationUsec;
    public boolean mLoopReset;
    public long mPrevMonoUsec;
    public long mPrevPresentUsec;

    public SpeedControl() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.searchbox.afx.decode.VideoPlayer.FrameCallback
    public void loopReset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mLoopReset = true;
        }
    }

    @Override // com.baidu.searchbox.afx.decode.VideoPlayer.FrameCallback
    public void preRender(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) != null) {
            return;
        }
        if (this.mPrevMonoUsec == 0) {
            this.mPrevMonoUsec = System.nanoTime() / 1000;
            this.mPrevPresentUsec = j2;
            return;
        }
        if (this.mLoopReset) {
            this.mPrevPresentUsec = j2 - 40000;
            this.mLoopReset = false;
        }
        long j3 = this.mFixedFrameDurationUsec;
        if (j3 == 0) {
            j3 = j2 - this.mPrevPresentUsec;
        }
        int i2 = (j3 > 0L ? 1 : (j3 == 0L ? 0 : -1));
        long j4 = i2 >= 0 ? (i2 != 0 && j3 > 10000000) ? 5000000L : j3 : 0L;
        long j5 = this.mPrevMonoUsec + j4;
        long nanoTime = System.nanoTime();
        while (true) {
            long j6 = nanoTime / 1000;
            if (j6 < j5 - 100) {
                long j7 = j5 - j6;
                if (j7 > 500000) {
                    j7 = 500000;
                }
                try {
                    Thread.sleep(j7 / 1000, ((int) (j7 % 1000)) * 1000);
                } catch (InterruptedException unused) {
                }
                nanoTime = System.nanoTime();
            } else {
                this.mPrevMonoUsec += j4;
                this.mPrevPresentUsec += j4;
                return;
            }
        }
    }

    @Override // com.baidu.searchbox.afx.decode.VideoPlayer.FrameCallback
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.mPrevPresentUsec = 0L;
            this.mPrevMonoUsec = 0L;
            this.mFixedFrameDurationUsec = 0L;
            this.mLoopReset = false;
        }
    }

    public void setFixedPlaybackRate(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.mFixedFrameDurationUsec = 1000000 / i2;
        }
    }
}
