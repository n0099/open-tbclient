package com.baidu.mobads.container.util;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.executor.BaseTask;
import com.baidu.mobads.container.executor.TaskScheduler;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
public class OAdTimer {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DELAY = 300;
    public static final int INITIALIZED = -1;
    public static final int PAUSED = 1;
    public static final int RUNNING = 0;
    public static final int STOPED = 2;
    public static String TAG = "OAdTimer";
    public transient /* synthetic */ FieldHolder $fh;
    public EventHandler handler;
    public int interval;
    public int mCounteDown;
    public int mCurrentCount;
    public int mRepeatCount;
    public BaseTask mTockFuture;
    public AtomicInteger state;

    /* loaded from: classes3.dex */
    public interface EventHandler {
        void onTimer(int i2);

        void onTimerComplete();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1332524742, "Lcom/baidu/mobads/container/util/OAdTimer;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1332524742, "Lcom/baidu/mobads/container/util/OAdTimer;");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OAdTimer(int i2) {
        this(i2, 300);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static /* synthetic */ int access$410(OAdTimer oAdTimer) {
        int i2 = oAdTimer.mCounteDown;
        oAdTimer.mCounteDown = i2 - 1;
        return i2;
    }

    public int getCurrentCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mCurrentCount : invokeV.intValue;
    }

    public int getRepeatCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mRepeatCount : invokeV.intValue;
    }

    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            RemoteXAdLogger.getInstance().d(TAG, "pause");
            this.state.set(1);
        }
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            RemoteXAdLogger.getInstance().d(TAG, "reset");
            this.state.set(-1);
            this.mCounteDown = this.mRepeatCount;
        }
    }

    public void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            RemoteXAdLogger.getInstance().d(TAG, "resume");
            this.state.set(0);
        }
    }

    public void setEventHandler(EventHandler eventHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, eventHandler) == null) {
            this.handler = eventHandler;
        }
    }

    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            RemoteXAdLogger.getInstance().d(TAG, "start");
            this.state.set(0);
            try {
                this.mTockFuture = new BaseTask(this) { // from class: com.baidu.mobads.container.util.OAdTimer.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ OAdTimer this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // com.baidu.mobads.container.executor.BaseTask
                    public Object doInBackground() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                            if (this.this$0.state.get() != 0) {
                                return null;
                            }
                            if (this.this$0.handler != null) {
                                OAdTimer oAdTimer = this.this$0;
                                oAdTimer.mCurrentCount = oAdTimer.mRepeatCount - this.this$0.mCounteDown;
                                try {
                                    this.this$0.handler.onTimer(this.this$0.mCurrentCount);
                                } catch (Throwable unused) {
                                }
                            }
                            if (this.this$0.mCounteDown <= 0) {
                                if (this.this$0.handler != null) {
                                    try {
                                        this.this$0.handler.onTimerComplete();
                                    } catch (Throwable unused2) {
                                    }
                                }
                                this.this$0.stop();
                            } else {
                                OAdTimer.access$410(this.this$0);
                            }
                            return null;
                        }
                        return invokeV.objValue;
                    }
                };
                TaskScheduler.getInstance().submitAtFixedRate(this.mTockFuture, 0L, this.interval, TimeUnit.MILLISECONDS);
            } catch (Throwable unused) {
            }
        }
    }

    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            try {
                RemoteXAdLogger.getInstance().d(TAG, IntentConfig.STOP);
                this.state.set(2);
                synchronized (this) {
                    if (this.mTockFuture != null) {
                        this.mTockFuture.cancel(true);
                        this.mTockFuture = null;
                    }
                    if (this.handler != null) {
                        this.handler = null;
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public OAdTimer(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.interval = 300;
        this.interval = i3;
        int i6 = i2 / i3;
        RemoteXAdLogger remoteXAdLogger = RemoteXAdLogger.getInstance();
        String str = TAG;
        remoteXAdLogger.d(str, "RendererTimer(duration=" + i6 + SmallTailInfo.EMOTION_SUFFIX);
        this.mRepeatCount = i6;
        this.mCounteDown = i6;
        this.state = new AtomicInteger(-1);
    }
}
