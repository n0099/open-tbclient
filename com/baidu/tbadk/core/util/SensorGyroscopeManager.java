package com.baidu.tbadk.core.util;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class SensorGyroscopeManager implements SensorEventListener, LifecycleObserver {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_SENSOR_DELAY_UI = 20000;
    public static final int INTERVAL_UNIT = 1000000;
    public static final String SENSOR_START = "1";
    public static final String SENSOR_STOP = "2";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isAvailable;
    @Nullable
    public OnSensorEventListener mOnSensorEventListener;
    public int mSamplingFrequency;
    @Nullable
    public Sensor mSensor;
    @Nullable
    public SensorManager mSensorManager;
    @NonNull
    public final float[] mSensorParams;

    /* renamed from: com.baidu.tbadk.core.util.SensorGyroscopeManager$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public interface OnSensorEventListener {
        void onSensorChanged(SensorEvent sensorEvent);
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sensor, i) == null) {
        }
    }

    /* loaded from: classes3.dex */
    public static class SingletonHolder {
        public static /* synthetic */ Interceptable $ic;
        public static final SensorGyroscopeManager INSTANCE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1970331750, "Lcom/baidu/tbadk/core/util/SensorGyroscopeManager$SingletonHolder;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1970331750, "Lcom/baidu/tbadk/core/util/SensorGyroscopeManager$SingletonHolder;");
                    return;
                }
            }
            INSTANCE = new SensorGyroscopeManager(null);
        }

        public SingletonHolder() {
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
    }

    public SensorGyroscopeManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mSensorParams = new float[]{0.0f, 0.0f, 0.0f};
        this.isAvailable = false;
        this.mSamplingFrequency = 2;
        if (TbadkApplication.getInst() == null) {
            return;
        }
        SensorManager sensorManager = (SensorManager) TbadkApplication.getInst().getSystemService("sensor");
        this.mSensorManager = sensorManager;
        if (sensorManager != null && DeviceInfoUtil.isSupportGyroScope(TbadkCoreApplication.getInst())) {
            this.mSensor = this.mSensorManager.getDefaultSensor(1);
        }
    }

    public /* synthetic */ SensorGyroscopeManager(AnonymousClass1 anonymousClass1) {
        this();
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, sensorEvent) == null) && sensorEvent.sensor.getType() == 1) {
            float[] fArr = this.mSensorParams;
            float[] fArr2 = sensorEvent.values;
            fArr[0] = fArr2[0];
            fArr[1] = fArr2[1];
            fArr[2] = fArr2[2];
            OnSensorEventListener onSensorEventListener = this.mOnSensorEventListener;
            if (onSensorEventListener != null) {
                onSensorEventListener.onSensorChanged(sensorEvent);
            }
        }
    }

    public void setSensorEventListener(OnSensorEventListener onSensorEventListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onSensorEventListener) == null) {
            this.mOnSensorEventListener = onSensorEventListener;
        }
    }

    public void start(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.isAvailable = true;
            this.mSamplingFrequency = i;
            if (this.mSensorManager != null && this.mSensor != null) {
                if (i < 20000) {
                    i = 1;
                }
                this.mSensorManager.registerListener(this, this.mSensor, i);
            }
        }
    }

    @NonNull
    public static SensorGyroscopeManager getSensor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return SingletonHolder.INSTANCE;
        }
        return (SensorGyroscopeManager) invokeV.objValue;
    }

    private void removeSensorManager() {
        SensorManager sensorManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, this) == null) && (sensorManager = this.mSensorManager) != null) {
            sensorManager.flush(this);
            this.mSensorManager.unregisterListener(this);
        }
    }

    public float[] getSensorParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mSensorParams;
        }
        return (float[]) invokeV.objValue;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            removeSensorManager();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.isAvailable) {
            start(this.mSamplingFrequency);
        }
    }

    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            start(this.mSamplingFrequency);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.isAvailable = false;
            removeSensorManager();
        }
    }
}
