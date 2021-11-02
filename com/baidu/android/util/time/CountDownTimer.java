package com.baidu.android.util.time;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class CountDownTimer {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MSG = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public final long mCountdownInterval;
    public long mCountdownMillis;
    @SuppressLint({"HandlerLeak"})
    public Handler mHandler;
    public boolean mIsCancelled;
    public boolean mIsFinished;
    public boolean mIsPaused;
    public StatusListener mListener;
    public long mPauseTime;
    public long mStopTimeInFuture;

    /* loaded from: classes6.dex */
    public static abstract class StatusListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public StatusListener() {
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

        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public void onPause() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        public void onResume() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }

        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            }
        }

        public void onTick(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
            }
        }
    }

    public CountDownTimer(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), Long.valueOf(j2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mIsCancelled = false;
        this.mIsPaused = true;
        this.mIsFinished = false;
        this.mListener = new StatusListener(this) { // from class: com.baidu.android.util.time.CountDownTimer.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CountDownTimer this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.baidu.android.util.time.CountDownTimer.StatusListener
            public void onStart() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    super.onStart();
                }
            }
        };
        this.mHandler = new Handler(this) { // from class: com.baidu.android.util.time.CountDownTimer.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CountDownTimer this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) {
                    this.this$0.handleCountDownMessage(message);
                }
            }
        };
        this.mCountdownMillis = j;
        this.mCountdownInterval = j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleCountDownMessage(Message message) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, message) == null) {
            synchronized (this) {
                if (!this.mIsCancelled && !this.mIsPaused) {
                    long elapsedRealtime = this.mStopTimeInFuture - SystemClock.elapsedRealtime();
                    long j2 = 0;
                    if (elapsedRealtime <= 0) {
                        this.mIsFinished = true;
                        this.mListener.onFinish();
                    } else {
                        long elapsedRealtime2 = SystemClock.elapsedRealtime();
                        this.mListener.onTick(elapsedRealtime);
                        long elapsedRealtime3 = SystemClock.elapsedRealtime() - elapsedRealtime2;
                        if (elapsedRealtime < this.mCountdownInterval) {
                            j = elapsedRealtime - elapsedRealtime3;
                            if (j < 0) {
                                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), j2);
                            }
                        } else {
                            j = this.mCountdownInterval - elapsedRealtime3;
                            while (j < 0) {
                                j += this.mCountdownInterval;
                            }
                        }
                        j2 = j;
                        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), j2);
                    }
                }
            }
        }
    }

    public final synchronized void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                this.mIsCancelled = true;
                this.mHandler.removeMessages(1);
                this.mListener.onCancel();
            }
        }
    }

    public final synchronized void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                if (!this.mIsPaused && !this.mIsCancelled && !this.mIsFinished) {
                    this.mPauseTime = SystemClock.elapsedRealtime();
                    this.mIsPaused = true;
                    this.mListener.onPause();
                    this.mHandler.removeMessages(1);
                }
            }
        }
    }

    public final synchronized void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                if (this.mIsPaused && !this.mIsCancelled && !this.mIsFinished) {
                    this.mIsPaused = false;
                    this.mStopTimeInFuture = SystemClock.elapsedRealtime() + (this.mStopTimeInFuture - this.mPauseTime);
                    this.mListener.onResume();
                    this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
                }
            }
        }
    }

    public void setCountDownMillis(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            this.mCountdownMillis = j;
        }
    }

    public CountDownTimer setStatusListener(StatusListener statusListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, statusListener)) == null) {
            if (statusListener != null) {
                this.mListener = statusListener;
            }
            return this;
        }
        return (CountDownTimer) invokeL.objValue;
    }

    public final synchronized CountDownTimer start() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                this.mIsCancelled = false;
                if (this.mCountdownMillis <= 0) {
                    this.mIsFinished = true;
                    this.mListener.onFinish();
                    return this;
                }
                this.mIsFinished = false;
                this.mIsPaused = false;
                this.mStopTimeInFuture = SystemClock.elapsedRealtime() + this.mCountdownMillis;
                this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
                this.mListener.onStart();
                return this;
            }
        }
        return (CountDownTimer) invokeV.objValue;
    }
}
