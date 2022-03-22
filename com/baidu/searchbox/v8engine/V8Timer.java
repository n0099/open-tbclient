package com.baidu.searchbox.v8engine;

import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeSet;
@NotProguard
/* loaded from: classes4.dex */
public class V8Timer implements V8Engine.V8StatusListener {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String TAG = "V8Timer";
    public transient /* synthetic */ FieldHolder $fh;
    public LinkedHashMap<Long, TimeTask> mActiveTimer;
    public volatile boolean mDestroyed;
    public boolean mInitialized;
    public Handler mUiHandler;
    public V8Engine mV8Engine;

    /* loaded from: classes4.dex */
    public class TimeTask implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile boolean mRemoved;
        public boolean mRepeat;
        public long mStart;
        public long mTimeOut;
        public long mTimerID;
        public long mTimerPtr;
        public final /* synthetic */ V8Timer this$0;

        public TimeTask(V8Timer v8Timer, long j, long j2, long j3, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v8Timer, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = v8Timer;
            this.mRemoved = false;
            this.mTimerID = j;
            this.mTimerPtr = j2;
            this.mTimeOut = j3;
            this.mRepeat = z;
            this.mStart = System.currentTimeMillis();
            this.mRemoved = false;
        }

        public long nextFireTime() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                long currentTimeMillis = this.mTimeOut - (System.currentTimeMillis() - this.mStart);
                this.mStart = System.currentTimeMillis();
                if (currentTimeMillis < 0) {
                    return 0L;
                }
                return currentTimeMillis;
            }
            return invokeV.longValue;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.mRemoved || this.this$0.mDestroyed) {
                return;
            }
            synchronized (this.this$0) {
                if (this.this$0.mV8Engine == null) {
                    return;
                }
                this.this$0.mV8Engine.postOnJSThread(new Runnable(this) { // from class: com.baidu.searchbox.v8engine.V8Timer.TimeTask.1
                    public static final /* synthetic */ boolean $assertionsDisabled = false;
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ TimeTask this$1;

                    static {
                        InterceptResult invokeClinit;
                        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-61551286, "Lcom/baidu/searchbox/v8engine/V8Timer$TimeTask$1;")) == null) {
                            return;
                        }
                        Interceptable interceptable2 = invokeClinit.interceptor;
                        if (interceptable2 != null) {
                            $ic = interceptable2;
                        }
                        if ((invokeClinit.flags & 1) != 0) {
                            classClinitInterceptable.invokePostClinit(-61551286, "Lcom/baidu/searchbox/v8engine/V8Timer$TimeTask$1;");
                        }
                    }

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65537, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65537, newInitContext);
                                return;
                            }
                        }
                        this.this$1 = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.this$1.mRemoved || this.this$1.this$0.mDestroyed || this.this$1.this$0.mV8Engine.isPaused()) {
                            return;
                        }
                        TimeTask timeTask = this.this$1;
                        timeTask.this$0.nativeTimeOutCallback(timeTask.mTimerPtr);
                        TimeTask timeTask2 = this.this$1;
                        if (timeTask2.mRepeat) {
                            Handler handler = timeTask2.this$0.mUiHandler;
                            TimeTask timeTask3 = this.this$1;
                            handler.postDelayed(timeTask3, timeTask3.mTimeOut);
                            return;
                        }
                        timeTask2.this$0.removeTimeTask(timeTask2.mTimerID, timeTask2.mTimerPtr);
                    }
                });
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return "TimeTask{mTimerID=" + this.mTimerID + ", mTimerPtr=" + this.mTimerPtr + ", mTimeOut=" + this.mTimeOut + ", mStart=" + this.mStart + ", mRepeat=" + this.mRepeat + ", mRemoved=" + this.mRemoved + '}';
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1182237065, "Lcom/baidu/searchbox/v8engine/V8Timer;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1182237065, "Lcom/baidu/searchbox/v8engine/V8Timer;");
        }
    }

    public V8Timer() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mUiHandler = null;
        this.mV8Engine = null;
        this.mInitialized = false;
        this.mDestroyed = false;
        this.mActiveTimer = new LinkedHashMap<>(30);
    }

    public synchronized void addTimeTask(long j, long j2, long j3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                TimeTask timeTask = new TimeTask(this, j, j2, j3, z);
                this.mActiveTimer.put(Long.valueOf(j), timeTask);
                if (this.mV8Engine.isPaused()) {
                    return;
                }
                this.mUiHandler.postDelayed(timeTask, j3);
            }
        }
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.mDestroyed = true;
            for (Long l : new TreeSet(this.mActiveTimer.keySet())) {
                TimeTask timeTask = this.mActiveTimer.get(l);
                if (timeTask != null) {
                    removeTimeTask(timeTask.mTimerID, timeTask.mTimerPtr);
                }
            }
            synchronized (this) {
                this.mV8Engine = null;
            }
            this.mActiveTimer.clear();
        }
    }

    public void initialize(V8Engine v8Engine, Handler handler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, v8Engine, handler) == null) {
            this.mV8Engine = v8Engine;
            v8Engine.addStatusHandler(this);
            this.mUiHandler = handler;
            this.mInitialized = true;
        }
    }

    public native void nativeRemoveTimer(long j);

    public native void nativeTimeOutCallback(long j);

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8StatusListener
    public synchronized void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this) {
                if (!this.mActiveTimer.isEmpty()) {
                    for (Map.Entry<Long, TimeTask> entry : this.mActiveTimer.entrySet()) {
                        this.mUiHandler.removeCallbacks(entry.getValue());
                    }
                }
            }
        }
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8StatusListener
    public synchronized void onReady() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            synchronized (this) {
            }
        }
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8StatusListener
    public synchronized void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (this) {
                if (!this.mActiveTimer.isEmpty()) {
                    for (Map.Entry<Long, TimeTask> entry : this.mActiveTimer.entrySet()) {
                        TimeTask value = entry.getValue();
                        this.mUiHandler.postDelayed(value, value.nextFireTime());
                    }
                }
            }
        }
    }

    public synchronized void removeTimeTask(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            synchronized (this) {
                TimeTask timeTask = this.mActiveTimer.get(Long.valueOf(j));
                if (timeTask == null) {
                    return;
                }
                timeTask.mRemoved = true;
                this.mUiHandler.removeCallbacks(timeTask);
                this.mActiveTimer.remove(Long.valueOf(j));
                nativeRemoveTimer(j2);
            }
        }
    }
}
