package c.a.r0.a.r2.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import c.a.r0.a.d2.e;
import c.a.r0.a.e0.d;
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
    public static volatile a m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f8604e;

    /* renamed from: f  reason: collision with root package name */
    public SensorManager f8605f;

    /* renamed from: g  reason: collision with root package name */
    public Sensor f8606g;

    /* renamed from: h  reason: collision with root package name */
    public InterfaceC0529a f8607h;

    /* renamed from: i  reason: collision with root package name */
    public double[] f8608i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f8609j;
    public long k;
    public int l;

    /* renamed from: c.a.r0.a.r2.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0529a {
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
        this.f8608i = new double[3];
        this.f8609j = false;
        this.k = 0L;
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (m == null) {
                synchronized (a.class) {
                    if (m == null) {
                        m = new a();
                    }
                }
            }
            return m;
        }
        return (a) invokeV.objValue;
    }

    public static synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            synchronized (a.class) {
                if (m == null) {
                    return;
                }
                m.c();
            }
        }
    }

    public synchronized void b(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, context, i2) == null) {
            synchronized (this) {
                this.f8604e = context;
                this.l = i2;
            }
        }
    }

    public final synchronized void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                d.i("accelerometer", "release");
                if (this.f8609j) {
                    g();
                }
                this.f8604e = null;
                m = null;
            }
        }
    }

    public synchronized void e(InterfaceC0529a interfaceC0529a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, interfaceC0529a) == null) {
            synchronized (this) {
                this.f8607h = interfaceC0529a;
            }
        }
    }

    public synchronized void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                if (this.f8604e == null) {
                    d.c("accelerometer", "start error, none context");
                } else if (this.f8609j) {
                    d.o("accelerometer", "has already start");
                } else {
                    SensorManager sensorManager = (SensorManager) this.f8604e.getSystemService("sensor");
                    this.f8605f = sensorManager;
                    if (sensorManager != null) {
                        Sensor defaultSensor = sensorManager.getDefaultSensor(1);
                        this.f8606g = defaultSensor;
                        this.f8605f.registerListener(this, defaultSensor, 1);
                        this.f8609j = true;
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
                if (!this.f8609j) {
                    d.o("accelerometer", "has already stop");
                    return;
                }
                if (this.f8605f != null) {
                    this.f8605f.unregisterListener(this);
                }
                this.f8605f = null;
                this.f8606g = null;
                this.f8609j = false;
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
                if (this.f8609j && this.f8607h != null && System.currentTimeMillis() - this.k > this.l) {
                    this.f8608i[0] = (-sensorEvent.values[0]) / 9.8d;
                    this.f8608i[1] = (-sensorEvent.values[1]) / 9.8d;
                    this.f8608i[2] = (-sensorEvent.values[2]) / 9.8d;
                    this.f8607h.a(this.f8608i);
                    this.k = System.currentTimeMillis();
                }
                if (e.z) {
                    String str = "current Time : " + this.k + "current Acc x : " + this.f8608i[0] + "current Acc y : " + this.f8608i[1] + "current Acc z : " + this.f8608i[2];
                }
            }
            return;
        }
        d.o("accelerometer", "illegal accelerometer event");
    }
}
