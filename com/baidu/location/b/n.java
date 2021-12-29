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
/* loaded from: classes10.dex */
public class n implements SensorEventListener {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static n f36220d;
    public transient /* synthetic */ FieldHolder $fh;
    public float[] a;

    /* renamed from: b  reason: collision with root package name */
    public float[] f36221b;

    /* renamed from: c  reason: collision with root package name */
    public SensorManager f36222c;

    /* renamed from: e  reason: collision with root package name */
    public float f36223e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f36224f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f36225g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f36226h;

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
        this.f36224f = false;
        this.f36225g = false;
        this.f36226h = false;
    }

    public static synchronized n a() {
        InterceptResult invokeV;
        n nVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (n.class) {
                if (f36220d == null) {
                    f36220d = new n();
                }
                nVar = f36220d;
            }
            return nVar;
        }
        return (n) invokeV.objValue;
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.f36224f = z;
        }
    }

    public synchronized void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                if (this.f36226h) {
                    return;
                }
                if (this.f36224f) {
                    if (this.f36222c == null) {
                        this.f36222c = (SensorManager) com.baidu.location.f.getServiceContext().getSystemService("sensor");
                    }
                    if (this.f36222c != null) {
                        Sensor defaultSensor = this.f36222c.getDefaultSensor(11);
                        if (defaultSensor != null && this.f36224f) {
                            this.f36222c.registerListener(this, defaultSensor, 3);
                        }
                        Sensor defaultSensor2 = this.f36222c.getDefaultSensor(2);
                        if (defaultSensor2 != null && this.f36224f) {
                            this.f36222c.registerListener(this, defaultSensor2, 3);
                        }
                    }
                    this.f36226h = true;
                }
            }
        }
    }

    public synchronized void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                if (this.f36226h) {
                    if (this.f36222c != null) {
                        this.f36222c.unregisterListener(this);
                        this.f36222c = null;
                    }
                    this.f36226h = false;
                }
            }
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f36224f : invokeV.booleanValue;
    }

    public float e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f36223e : invokeV.floatValue;
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
                this.f36221b = fArr;
                Math.sqrt((fArr[0] * fArr[0]) + (fArr[1] * fArr[1]) + (fArr[2] * fArr[2]));
                float[] fArr2 = this.f36221b;
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
                        this.f36223e = degrees;
                        if (degrees < 0.0f) {
                            degrees += 360.0f;
                        }
                        this.f36223e = (float) Math.floor(degrees);
                    } catch (Exception unused) {
                        this.f36223e = 0.0f;
                    }
                }
            }
        }
    }
}
