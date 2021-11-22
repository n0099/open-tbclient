package b.a.p0.a.r2.h;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.a.p0.a.e0.d;
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
    public static volatile a f8187i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SensorManager f8188a;

    /* renamed from: b  reason: collision with root package name */
    public SensorEventListener f8189b;

    /* renamed from: c  reason: collision with root package name */
    public Sensor f8190c;

    /* renamed from: d  reason: collision with root package name */
    public Sensor f8191d;

    /* renamed from: e  reason: collision with root package name */
    public b f8192e;

    /* renamed from: f  reason: collision with root package name */
    public float[] f8193f;

    /* renamed from: g  reason: collision with root package name */
    public float[] f8194g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f8195h;

    /* renamed from: b.a.p0.a.r2.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0388a implements SensorEventListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f8196e;

        public C0388a(a aVar) {
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
            this.f8196e = aVar;
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
                    this.f8196e.f8193f = (float[]) fArr.clone();
                } else if (sensorEvent == null || (sensor = sensorEvent.sensor) == null || sensor.getType() != 2) {
                } else {
                    float[] fArr2 = sensorEvent.values;
                    if (fArr2 != null && fArr2.length == 3) {
                        this.f8196e.f8194g = (float[]) fArr2.clone();
                    }
                    if (this.f8196e.f8192e == null || this.f8196e.f8193f == null || this.f8196e.f8194g == null || (g2 = this.f8196e.g()) == null) {
                        return;
                    }
                    this.f8196e.f8192e.a(g2);
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
        this.f8195h = false;
    }

    public static a h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (f8187i == null) {
                synchronized (a.class) {
                    if (f8187i == null) {
                        f8187i = new a();
                    }
                }
            }
            return f8187i;
        }
        return (a) invokeV.objValue;
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, null) == null) || f8187i == null) {
            return;
        }
        f8187i.j();
    }

    @Nullable
    public final float[] g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            float[] fArr = new float[9];
            float[] fArr2 = new float[9];
            float[] fArr3 = new float[3];
            if (SensorManager.getRotationMatrix(fArr, null, this.f8193f, this.f8194g) && SensorManager.remapCoordinateSystem(fArr, 2, 129, fArr2)) {
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
            d.i("SwanAppOrientationManager", "get System Sensor listener");
            SensorEventListener sensorEventListener = this.f8189b;
            if (sensorEventListener != null) {
                return sensorEventListener;
            }
            C0388a c0388a = new C0388a(this);
            this.f8189b = c0388a;
            return c0388a;
        }
        return (SensorEventListener) invokeV.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d.i("SwanAppOrientationManager", "release");
            if (this.f8195h) {
                m();
            }
            this.f8188a = null;
            this.f8190c = null;
            this.f8191d = null;
            this.f8189b = null;
            this.f8193f = null;
            this.f8194g = null;
            f8187i = null;
        }
    }

    public boolean l(int i2, @NonNull b bVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048579, this, i2, bVar)) == null) {
            if (this.f8195h) {
                d.o("SwanAppOrientationManager", "has already start, change new listener");
                this.f8192e = bVar;
                return true;
            }
            SensorManager sensorManager = (SensorManager) b.a.p0.a.c1.a.c().getSystemService("sensor");
            this.f8188a = sensorManager;
            if (sensorManager != null) {
                this.f8192e = bVar;
                this.f8190c = sensorManager.getDefaultSensor(1);
                Sensor defaultSensor = this.f8188a.getDefaultSensor(2);
                this.f8191d = defaultSensor;
                if (this.f8190c != null && defaultSensor != null) {
                    this.f8188a.registerListener(i(), this.f8190c, i2);
                    this.f8188a.registerListener(i(), this.f8191d, i2);
                    this.f8195h = true;
                    d.i("SwanAppOrientationManager", "start listen");
                    return true;
                }
                d.c("SwanAppOrientationManager", "Accelerometer || Magnetic is null");
                return false;
            }
            d.c("SwanAppOrientationManager", "none sensorManager");
            return false;
        }
        return invokeIL.booleanValue;
    }

    public void m() {
        SensorManager sensorManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!this.f8195h) {
                d.o("SwanAppOrientationManager", "has already stop");
                return;
            }
            this.f8195h = false;
            SensorEventListener sensorEventListener = this.f8189b;
            if (sensorEventListener != null && (sensorManager = this.f8188a) != null) {
                sensorManager.unregisterListener(sensorEventListener);
                this.f8189b = null;
            }
            this.f8192e = null;
            this.f8188a = null;
            this.f8190c = null;
            this.f8191d = null;
        }
    }
}
