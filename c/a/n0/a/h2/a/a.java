package c.a.n0.a.h2.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import c.a.n0.a.t1.e;
import c.a.n0.a.u.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a implements SensorEventListener {
    public static /* synthetic */ Interceptable $ic;
    @SuppressLint({"StaticFieldLeak"})
    public static volatile a i;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public SensorManager f4715b;

    /* renamed from: c  reason: collision with root package name */
    public Sensor f4716c;

    /* renamed from: d  reason: collision with root package name */
    public InterfaceC0294a f4717d;

    /* renamed from: e  reason: collision with root package name */
    public double[] f4718e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f4719f;

    /* renamed from: g  reason: collision with root package name */
    public long f4720g;

    /* renamed from: h  reason: collision with root package name */
    public int f4721h;

    /* renamed from: c.a.n0.a.h2.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0294a {
        void a(double[] dArr);
    }

    public a() {
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
        this.f4718e = new double[3];
        this.f4719f = false;
        this.f4720g = 0L;
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (i == null) {
                synchronized (a.class) {
                    if (i == null) {
                        i = new a();
                    }
                }
            }
            return i;
        }
        return (a) invokeV.objValue;
    }

    public static synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            synchronized (a.class) {
                if (i == null) {
                    return;
                }
                i.c();
            }
        }
    }

    public synchronized void b(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, context, i2) == null) {
            synchronized (this) {
                this.a = context;
                this.f4721h = i2;
            }
        }
    }

    public final synchronized void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                d.i("accelerometer", "release");
                if (this.f4719f) {
                    g();
                }
                this.a = null;
                i = null;
            }
        }
    }

    public synchronized void e(InterfaceC0294a interfaceC0294a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, interfaceC0294a) == null) {
            synchronized (this) {
                this.f4717d = interfaceC0294a;
            }
        }
    }

    public synchronized void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                if (this.a == null) {
                    d.c("accelerometer", "start error, none context");
                } else if (this.f4719f) {
                    d.o("accelerometer", "has already start");
                } else {
                    SensorManager sensorManager = (SensorManager) this.a.getSystemService("sensor");
                    this.f4715b = sensorManager;
                    if (sensorManager != null) {
                        Sensor defaultSensor = sensorManager.getDefaultSensor(1);
                        this.f4716c = defaultSensor;
                        this.f4715b.registerListener(this, defaultSensor, 1);
                        this.f4719f = true;
                        d.i("accelerometer", "start listen");
                    } else {
                        d.c("accelerometer", "none sensorManager");
                    }
                }
            }
        }
    }

    public synchronized void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                if (!this.f4719f) {
                    d.o("accelerometer", "has already stop");
                    return;
                }
                if (this.f4715b != null) {
                    this.f4715b.unregisterListener(this);
                }
                this.f4715b = null;
                this.f4716c = null;
                this.f4719f = false;
            }
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, sensor, i2) == null) {
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        Sensor sensor;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, sensorEvent) == null) || sensorEvent == null || (sensor = sensorEvent.sensor) == null || sensor.getType() != 1) {
            return;
        }
        float[] fArr = sensorEvent.values;
        if (fArr != null && fArr.length == 3) {
            synchronized (this) {
                if (this.f4719f && this.f4717d != null && System.currentTimeMillis() - this.f4720g > this.f4721h) {
                    this.f4718e[0] = (-sensorEvent.values[0]) / 9.8d;
                    this.f4718e[1] = (-sensorEvent.values[1]) / 9.8d;
                    this.f4718e[2] = (-sensorEvent.values[2]) / 9.8d;
                    this.f4717d.a(this.f4718e);
                    this.f4720g = System.currentTimeMillis();
                }
                if (e.v) {
                    Log.d("AccelerometerManager", "current Time : " + this.f4720g + "current Acc x : " + this.f4718e[0] + "current Acc y : " + this.f4718e[1] + "current Acc z : " + this.f4718e[2]);
                }
            }
            return;
        }
        d.o("accelerometer", "illegal accelerometer event");
    }
}
