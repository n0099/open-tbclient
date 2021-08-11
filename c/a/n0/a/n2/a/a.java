package c.a.n0.a.n2.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import c.a.n0.a.a2.e;
import c.a.n0.a.e0.d;
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
    public Context f7385e;

    /* renamed from: f  reason: collision with root package name */
    public SensorManager f7386f;

    /* renamed from: g  reason: collision with root package name */
    public Sensor f7387g;

    /* renamed from: h  reason: collision with root package name */
    public InterfaceC0310a f7388h;

    /* renamed from: i  reason: collision with root package name */
    public double[] f7389i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f7390j;
    public long k;
    public int l;

    /* renamed from: c.a.n0.a.n2.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0310a {
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
        this.f7389i = new double[3];
        this.f7390j = false;
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
                this.f7385e = context;
                this.l = i2;
            }
        }
    }

    public final synchronized void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                d.g("accelerometer", "release");
                if (this.f7390j) {
                    g();
                }
                this.f7385e = null;
                m = null;
            }
        }
    }

    public synchronized void e(InterfaceC0310a interfaceC0310a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, interfaceC0310a) == null) {
            synchronized (this) {
                this.f7388h = interfaceC0310a;
            }
        }
    }

    public synchronized void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                if (this.f7385e == null) {
                    d.b("accelerometer", "start error, none context");
                } else if (this.f7390j) {
                    d.l("accelerometer", "has already start");
                } else {
                    SensorManager sensorManager = (SensorManager) this.f7385e.getSystemService("sensor");
                    this.f7386f = sensorManager;
                    if (sensorManager != null) {
                        Sensor defaultSensor = sensorManager.getDefaultSensor(1);
                        this.f7387g = defaultSensor;
                        this.f7386f.registerListener(this, defaultSensor, 1);
                        this.f7390j = true;
                        d.g("accelerometer", "start listen");
                    } else {
                        d.b("accelerometer", "none sensorManager");
                    }
                }
            }
        }
    }

    public synchronized void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                if (!this.f7390j) {
                    d.l("accelerometer", "has already stop");
                    return;
                }
                if (this.f7386f != null) {
                    this.f7386f.unregisterListener(this);
                }
                this.f7386f = null;
                this.f7387g = null;
                this.f7390j = false;
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
                if (this.f7390j && this.f7388h != null && System.currentTimeMillis() - this.k > this.l) {
                    this.f7389i[0] = (-sensorEvent.values[0]) / 9.8d;
                    this.f7389i[1] = (-sensorEvent.values[1]) / 9.8d;
                    this.f7389i[2] = (-sensorEvent.values[2]) / 9.8d;
                    this.f7388h.a(this.f7389i);
                    this.k = System.currentTimeMillis();
                }
                if (e.y) {
                    String str = "current Time : " + this.k + "current Acc x : " + this.f7389i[0] + "current Acc y : " + this.f7389i[1] + "current Acc z : " + this.f7389i[2];
                }
            }
            return;
        }
        d.l("accelerometer", "illegal accelerometer event");
    }
}
