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
public class n implements SensorEventListener {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static n f6667d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public float[] f6668a;

    /* renamed from: b  reason: collision with root package name */
    public float[] f6669b;

    /* renamed from: c  reason: collision with root package name */
    public SensorManager f6670c;

    /* renamed from: e  reason: collision with root package name */
    public float f6671e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f6672f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f6673g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f6674h;

    public n() {
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
        this.f6672f = false;
        this.f6673g = false;
        this.f6674h = false;
    }

    public static synchronized n a() {
        InterceptResult invokeV;
        n nVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (n.class) {
                if (f6667d == null) {
                    f6667d = new n();
                }
                nVar = f6667d;
            }
            return nVar;
        }
        return (n) invokeV.objValue;
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.f6672f = z;
        }
    }

    public synchronized void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                if (this.f6674h) {
                    return;
                }
                if (this.f6672f) {
                    if (this.f6670c == null) {
                        this.f6670c = (SensorManager) com.baidu.location.f.getServiceContext().getSystemService("sensor");
                    }
                    if (this.f6670c != null) {
                        Sensor defaultSensor = this.f6670c.getDefaultSensor(11);
                        if (defaultSensor != null && this.f6672f) {
                            this.f6670c.registerListener(this, defaultSensor, 3);
                        }
                        Sensor defaultSensor2 = this.f6670c.getDefaultSensor(2);
                        if (defaultSensor2 != null && this.f6672f) {
                            this.f6670c.registerListener(this, defaultSensor2, 3);
                        }
                    }
                    this.f6674h = true;
                }
            }
        }
    }

    public synchronized void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                if (this.f6674h) {
                    if (this.f6670c != null) {
                        this.f6670c.unregisterListener(this);
                        this.f6670c = null;
                    }
                    this.f6674h = false;
                }
            }
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f6672f : invokeV.booleanValue;
    }

    public float e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f6671e : invokeV.floatValue;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, sensor, i2) == null) {
        }
    }

    @Override // android.hardware.SensorEventListener
    @SuppressLint({"NewApi"})
    public void onSensorChanged(SensorEvent sensorEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, sensorEvent) == null) {
            int type = sensorEvent.sensor.getType();
            if (type == 2) {
                float[] fArr = (float[]) sensorEvent.values.clone();
                this.f6669b = fArr;
                Math.sqrt((fArr[0] * fArr[0]) + (fArr[1] * fArr[1]) + (fArr[2] * fArr[2]));
                float[] fArr2 = this.f6669b;
            } else if (type != 11) {
            } else {
                float[] fArr3 = (float[]) sensorEvent.values.clone();
                this.f6668a = fArr3;
                if (fArr3 != null) {
                    float[] fArr4 = new float[9];
                    try {
                        SensorManager.getRotationMatrixFromVector(fArr4, fArr3);
                        float[] fArr5 = new float[3];
                        SensorManager.getOrientation(fArr4, fArr5);
                        float degrees = (float) Math.toDegrees(fArr5[0]);
                        this.f6671e = degrees;
                        if (degrees < 0.0f) {
                            degrees += 360.0f;
                        }
                        this.f6671e = (float) Math.floor(degrees);
                    } catch (Exception unused) {
                        this.f6671e = 0.0f;
                    }
                }
            }
        }
    }
}
