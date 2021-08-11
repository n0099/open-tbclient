package c.a.n0.a.n2.i;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.n0.a.e0.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static volatile a f7455i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SensorManager f7456a;

    /* renamed from: b  reason: collision with root package name */
    public SensorEventListener f7457b;

    /* renamed from: c  reason: collision with root package name */
    public Sensor f7458c;

    /* renamed from: d  reason: collision with root package name */
    public Sensor f7459d;

    /* renamed from: e  reason: collision with root package name */
    public b f7460e;

    /* renamed from: f  reason: collision with root package name */
    public float[] f7461f;

    /* renamed from: g  reason: collision with root package name */
    public float[] f7462g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f7463h;

    /* renamed from: c.a.n0.a.n2.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0319a implements SensorEventListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f7464e;

        public C0319a(a aVar) {
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
            this.f7464e = aVar;
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
            float[] g2;
            Sensor sensor2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sensorEvent) == null) {
                if (sensorEvent != null && (sensor2 = sensorEvent.sensor) != null && sensor2.getType() == 1) {
                    float[] fArr = sensorEvent.values;
                    if (fArr == null || fArr.length != 3) {
                        return;
                    }
                    this.f7464e.f7461f = (float[]) fArr.clone();
                } else if (sensorEvent == null || (sensor = sensorEvent.sensor) == null || sensor.getType() != 2) {
                } else {
                    float[] fArr2 = sensorEvent.values;
                    if (fArr2 != null && fArr2.length == 3) {
                        this.f7464e.f7462g = (float[]) fArr2.clone();
                    }
                    if (this.f7464e.f7460e == null || this.f7464e.f7461f == null || this.f7464e.f7462g == null || (g2 = this.f7464e.g()) == null) {
                        return;
                    }
                    this.f7464e.f7460e.a(g2);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(float[] fArr);
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
        this.f7463h = false;
    }

    public static a h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (f7455i == null) {
                synchronized (a.class) {
                    if (f7455i == null) {
                        f7455i = new a();
                    }
                }
            }
            return f7455i;
        }
        return (a) invokeV.objValue;
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, null) == null) || f7455i == null) {
            return;
        }
        f7455i.j();
    }

    @Nullable
    public final float[] g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            float[] fArr = new float[9];
            float[] fArr2 = new float[9];
            float[] fArr3 = new float[3];
            if (SensorManager.getRotationMatrix(fArr, null, this.f7461f, this.f7462g) && SensorManager.remapCoordinateSystem(fArr, 2, 129, fArr2)) {
                SensorManager.getOrientation(fArr2, fArr3);
                return fArr3;
            }
            return null;
        }
        return (float[]) invokeV.objValue;
    }

    public final SensorEventListener i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            d.g("SwanAppOrientationManager", "get System Sensor listener");
            SensorEventListener sensorEventListener = this.f7457b;
            if (sensorEventListener != null) {
                return sensorEventListener;
            }
            C0319a c0319a = new C0319a(this);
            this.f7457b = c0319a;
            return c0319a;
        }
        return (SensorEventListener) invokeV.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d.g("SwanAppOrientationManager", "release");
            if (this.f7463h) {
                m();
            }
            this.f7456a = null;
            this.f7458c = null;
            this.f7459d = null;
            this.f7457b = null;
            this.f7461f = null;
            this.f7462g = null;
            f7455i = null;
        }
    }

    public boolean l(int i2, @NonNull b bVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048579, this, i2, bVar)) == null) {
            if (this.f7463h) {
                d.l("SwanAppOrientationManager", "has already start, change new listener");
                this.f7460e = bVar;
                return true;
            }
            SensorManager sensorManager = (SensorManager) c.a.n0.a.c1.a.b().getSystemService("sensor");
            this.f7456a = sensorManager;
            if (sensorManager != null) {
                this.f7460e = bVar;
                this.f7458c = sensorManager.getDefaultSensor(1);
                Sensor defaultSensor = this.f7456a.getDefaultSensor(2);
                this.f7459d = defaultSensor;
                if (this.f7458c != null && defaultSensor != null) {
                    this.f7456a.registerListener(i(), this.f7458c, i2);
                    this.f7456a.registerListener(i(), this.f7459d, i2);
                    this.f7463h = true;
                    d.g("SwanAppOrientationManager", "start listen");
                    return true;
                }
                d.b("SwanAppOrientationManager", "Accelerometer || Magnetic is null");
                return false;
            }
            d.b("SwanAppOrientationManager", "none sensorManager");
            return false;
        }
        return invokeIL.booleanValue;
    }

    public void m() {
        SensorManager sensorManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!this.f7463h) {
                d.l("SwanAppOrientationManager", "has already stop");
                return;
            }
            this.f7463h = false;
            SensorEventListener sensorEventListener = this.f7457b;
            if (sensorEventListener != null && (sensorManager = this.f7456a) != null) {
                sensorManager.unregisterListener(sensorEventListener);
                this.f7457b = null;
            }
            this.f7460e = null;
            this.f7456a = null;
            this.f7458c = null;
            this.f7459d = null;
        }
    }
}
