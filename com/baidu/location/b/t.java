package com.baidu.location.b;

import android.annotation.SuppressLint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class t implements SensorEventListener {
    public static /* synthetic */ Interceptable $ic;
    public static t c;
    public transient /* synthetic */ FieldHolder $fh;
    public float[] a;
    public SensorManager b;
    public float d;
    public boolean e;
    public boolean f;
    public boolean g;

    public t() {
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
        this.e = false;
        this.f = false;
        this.g = false;
    }

    public static synchronized t a() {
        InterceptResult invokeV;
        t tVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (t.class) {
                if (c == null) {
                    c = new t();
                }
                tVar = c;
            }
            return tVar;
        }
        return (t) invokeV.objValue;
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.e = z;
        }
    }

    public synchronized void b() {
        Sensor defaultSensor;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                if (this.g) {
                    return;
                }
                if (this.e) {
                    if (this.b == null) {
                        this.b = (SensorManager) com.baidu.location.f.getServiceContext().getSystemService("sensor");
                    }
                    if (this.b != null && (defaultSensor = this.b.getDefaultSensor(11)) != null && this.e) {
                        this.b.registerListener(this, defaultSensor, 3);
                    }
                    this.g = true;
                }
            }
        }
    }

    public synchronized void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                if (this.g) {
                    if (this.b != null) {
                        this.b.unregisterListener(this);
                        this.b = null;
                    }
                    this.g = false;
                }
            }
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.e : invokeV.booleanValue;
    }

    public float e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.d : invokeV.floatValue;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, sensor, i) == null) {
        }
    }

    @Override // android.hardware.SensorEventListener
    @SuppressLint({"NewApi"})
    public void onSensorChanged(SensorEvent sensorEvent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, sensorEvent) == null) && sensorEvent.sensor.getType() == 11) {
            float[] fArr = (float[]) sensorEvent.values.clone();
            this.a = fArr;
            if (fArr != null) {
                float[] fArr2 = new float[9];
                try {
                    SensorManager.getRotationMatrixFromVector(fArr2, fArr);
                    float[] fArr3 = new float[3];
                    SensorManager.getOrientation(fArr2, fArr3);
                    float degrees = (float) Math.toDegrees(fArr3[0]);
                    this.d = degrees;
                    if (degrees < 0.0f) {
                        degrees += 360.0f;
                    }
                    this.d = (float) Math.floor(degrees);
                } catch (Exception unused) {
                    this.d = 0.0f;
                }
            }
        }
    }
}
