package c.a.p0.a.r2.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.e0.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    @SuppressLint({"StaticFieldLeak"})
    public static volatile a m;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public SensorManager f7771b;

    /* renamed from: c  reason: collision with root package name */
    public SensorEventListener f7772c;

    /* renamed from: d  reason: collision with root package name */
    public SensorEventListener f7773d;

    /* renamed from: e  reason: collision with root package name */
    public Sensor f7774e;

    /* renamed from: f  reason: collision with root package name */
    public Sensor f7775f;

    /* renamed from: g  reason: collision with root package name */
    public float[] f7776g;

    /* renamed from: h  reason: collision with root package name */
    public float[] f7777h;

    /* renamed from: i  reason: collision with root package name */
    public int f7778i;

    /* renamed from: j  reason: collision with root package name */
    public c f7779j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f7780k;
    public long l;

    /* renamed from: c.a.p0.a.r2.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0440a implements SensorEventListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f7781e;

        public C0440a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7781e = aVar;
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, sensor, i2) == null) {
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            Sensor sensor;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sensorEvent) == null) {
                if (sensorEvent != null && (sensor = sensorEvent.sensor) != null && sensor.getType() == 1) {
                    this.f7781e.f7776g = sensorEvent.values;
                    this.f7781e.f7778i = sensorEvent.accuracy;
                    d.b("SwanAppCompassManager", "accelerometer changed accuracy: " + this.f7781e.f7778i);
                    this.f7781e.k();
                    return;
                }
                d.o("compass", "illegal accelerometer event");
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements SensorEventListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f7782e;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7782e = aVar;
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, sensor, i2) == null) {
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            Sensor sensor;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sensorEvent) == null) {
                if (sensorEvent != null && (sensor = sensorEvent.sensor) != null && sensor.getType() == 2) {
                    this.f7782e.f7777h = sensorEvent.values;
                    this.f7782e.f7778i = sensorEvent.accuracy;
                    d.b("SwanAppCompassManager", "magneticFiled changed accuracy: " + this.f7782e.f7778i);
                    this.f7782e.k();
                    return;
                }
                d.o("compass", "illegal magnetic filed event");
            }
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(float f2, int i2);
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
        this.f7776g = new float[3];
        this.f7777h = new float[3];
        this.f7778i = -100;
        this.f7780k = false;
        this.l = 0L;
    }

    public static String h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i2)) == null) ? i2 != -1 ? i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? "unknow" : "high" : "medium" : "low" : "unreliable" : "no-contact" : (String) invokeI.objValue;
    }

    public static a i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
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

    public static void n() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, null) == null) || m == null) {
            return;
        }
        m.m();
    }

    public final float f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            float[] fArr = new float[3];
            float[] fArr2 = new float[9];
            SensorManager.getRotationMatrix(fArr2, null, this.f7776g, this.f7777h);
            SensorManager.getOrientation(fArr2, fArr);
            return (((float) Math.toDegrees(fArr[0])) + 360.0f) % 360.0f;
        }
        return invokeV.floatValue;
    }

    public final SensorEventListener g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            d.i("compass", "get Accelerometer listener");
            SensorEventListener sensorEventListener = this.f7772c;
            if (sensorEventListener != null) {
                return sensorEventListener;
            }
            C0440a c0440a = new C0440a(this);
            this.f7772c = c0440a;
            return c0440a;
        }
        return (SensorEventListener) invokeV.objValue;
    }

    public final SensorEventListener j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            d.i("compass", "get MagneticFiled listener");
            SensorEventListener sensorEventListener = this.f7773d;
            if (sensorEventListener != null) {
                return sensorEventListener;
            }
            b bVar = new b(this);
            this.f7773d = bVar;
            return bVar;
        }
        return (SensorEventListener) invokeV.objValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f7779j == null || System.currentTimeMillis() - this.l <= 200) {
            return;
        }
        float f2 = f();
        d.b("SwanAppCompassManager", "orientation changed, orientation : " + f2);
        this.f7779j.a(f2, this.f7778i);
        this.l = System.currentTimeMillis();
    }

    public void l(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            this.a = context;
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            d.i("compass", "release");
            if (this.f7780k) {
                q();
            }
            this.f7771b = null;
            this.f7775f = null;
            this.f7774e = null;
            this.f7772c = null;
            this.f7773d = null;
            this.f7779j = null;
            this.a = null;
            m = null;
        }
    }

    public void o(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            this.f7779j = cVar;
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            Context context = this.a;
            if (context == null) {
                d.c("compass", "start error, none context");
            } else if (this.f7780k) {
                d.o("compass", "has already start");
            } else {
                SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
                this.f7771b = sensorManager;
                if (sensorManager != null) {
                    this.f7774e = sensorManager.getDefaultSensor(1);
                    this.f7775f = this.f7771b.getDefaultSensor(2);
                    this.f7771b.registerListener(g(), this.f7774e, 1);
                    this.f7771b.registerListener(j(), this.f7775f, 1);
                    this.f7780k = true;
                    d.i("compass", "start listen");
                    return;
                }
                d.c("compass", "none sensorManager");
            }
        }
    }

    public void q() {
        SensorManager sensorManager;
        SensorManager sensorManager2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (!this.f7780k) {
                d.o("compass", "has already stop");
                return;
            }
            d.i("compass", "stop listen");
            SensorEventListener sensorEventListener = this.f7772c;
            if (sensorEventListener != null && (sensorManager2 = this.f7771b) != null) {
                sensorManager2.unregisterListener(sensorEventListener);
                this.f7772c = null;
            }
            SensorEventListener sensorEventListener2 = this.f7773d;
            if (sensorEventListener2 != null && (sensorManager = this.f7771b) != null) {
                sensorManager.unregisterListener(sensorEventListener2);
                this.f7773d = null;
            }
            this.f7771b = null;
            this.f7775f = null;
            this.f7774e = null;
            this.f7780k = false;
        }
    }
}
