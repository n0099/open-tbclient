package com.baidu.location.b;

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
public class n implements SensorEventListener {
    public static /* synthetic */ Interceptable $ic;
    public static n d;
    public transient /* synthetic */ FieldHolder $fh;
    public float[] a;
    public float[] b;
    public SensorManager c;
    public float e;
    public boolean f;
    public boolean g;
    public boolean h;

    public n() {
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
        this.f = false;
        this.g = false;
        this.h = false;
    }

    public static synchronized n a() {
        InterceptResult invokeV;
        n nVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (n.class) {
                if (d == null) {
                    d = new n();
                }
                nVar = d;
            }
            return nVar;
        }
        return (n) invokeV.objValue;
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.f = z;
        }
    }

    public synchronized void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                if (this.h) {
                    return;
                }
                if (this.f) {
                    if (this.c == null) {
                        this.c = (SensorManager) com.baidu.location.f.getServiceContext().getSystemService("sensor");
                    }
                    if (this.c != null) {
                        Sensor defaultSensor = this.c.getDefaultSensor(11);
                        if (defaultSensor != null && this.f) {
                            this.c.registerListener(this, defaultSensor, 3);
                        }
                        Sensor defaultSensor2 = this.c.getDefaultSensor(2);
                        if (defaultSensor2 != null && this.f) {
                            this.c.registerListener(this, defaultSensor2, 3);
                        }
                    }
                    this.h = true;
                }
            }
        }
    }

    public synchronized void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                if (this.h) {
                    if (this.c != null) {
                        this.c.unregisterListener(this);
                        this.c = null;
                    }
                    this.h = false;
                }
            }
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f : invokeV.booleanValue;
    }

    public float e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.e : invokeV.floatValue;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, sensor, i) == null) {
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, sensorEvent) == null) {
            int type = sensorEvent.sensor.getType();
            if (type == 2) {
                float[] fArr = (float[]) sensorEvent.values.clone();
                this.b = fArr;
                Math.sqrt((fArr[0] * fArr[0]) + (fArr[1] * fArr[1]) + (fArr[2] * fArr[2]));
                float[] fArr2 = this.b;
            } else if (type != 11) {
            } else {
                float[] fArr3 = (float[]) sensorEvent.values.clone();
                this.a = fArr3;
                if (fArr3 != null) {
                    float[] fArr4 = new float[9];
                    try {
                        SensorManager.getRotationMatrixFromVector(fArr4, fArr3);
                        float[] fArr5 = new float[3];
                        SensorManager.getOrientation(fArr4, fArr5);
                        float degrees = (float) Math.toDegrees(fArr5[0]);
                        this.e = degrees;
                        if (degrees < 0.0f) {
                            degrees += 360.0f;
                        }
                        this.e = (float) Math.floor(degrees);
                    } catch (Exception unused) {
                        this.e = 0.0f;
                    }
                }
            }
        }
    }
}
