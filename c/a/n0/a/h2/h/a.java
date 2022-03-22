package c.a.n0.a.h2.h;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.n0.a.u.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile a i;
    public transient /* synthetic */ FieldHolder $fh;
    public SensorManager a;

    /* renamed from: b  reason: collision with root package name */
    public SensorEventListener f4752b;

    /* renamed from: c  reason: collision with root package name */
    public Sensor f4753c;

    /* renamed from: d  reason: collision with root package name */
    public Sensor f4754d;

    /* renamed from: e  reason: collision with root package name */
    public b f4755e;

    /* renamed from: f  reason: collision with root package name */
    public float[] f4756f;

    /* renamed from: g  reason: collision with root package name */
    public float[] f4757g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f4758h;

    /* renamed from: c.a.n0.a.h2.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0302a implements SensorEventListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C0302a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, sensor, i) == null) {
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
                    this.a.f4756f = (float[]) fArr.clone();
                } else if (sensorEvent == null || (sensor = sensorEvent.sensor) == null || sensor.getType() != 2) {
                } else {
                    float[] fArr2 = sensorEvent.values;
                    if (fArr2 != null && fArr2.length == 3) {
                        this.a.f4757g = (float[]) fArr2.clone();
                    }
                    if (this.a.f4755e == null || this.a.f4756f == null || this.a.f4757g == null || (g2 = this.a.g()) == null) {
                        return;
                    }
                    this.a.f4755e.a(g2);
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
        this.f4758h = false;
    }

    public static a h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
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

    public static void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, null) == null) || i == null) {
            return;
        }
        i.j();
    }

    @Nullable
    public final float[] g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            float[] fArr = new float[9];
            float[] fArr2 = new float[9];
            float[] fArr3 = new float[3];
            if (SensorManager.getRotationMatrix(fArr, null, this.f4756f, this.f4757g) && SensorManager.remapCoordinateSystem(fArr, 2, 129, fArr2)) {
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
            SensorEventListener sensorEventListener = this.f4752b;
            if (sensorEventListener != null) {
                return sensorEventListener;
            }
            C0302a c0302a = new C0302a(this);
            this.f4752b = c0302a;
            return c0302a;
        }
        return (SensorEventListener) invokeV.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d.i("SwanAppOrientationManager", "release");
            if (this.f4758h) {
                m();
            }
            this.a = null;
            this.f4753c = null;
            this.f4754d = null;
            this.f4752b = null;
            this.f4756f = null;
            this.f4757g = null;
            i = null;
        }
    }

    public boolean l(int i2, @NonNull b bVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048579, this, i2, bVar)) == null) {
            if (this.f4758h) {
                d.o("SwanAppOrientationManager", "has already start, change new listener");
                this.f4755e = bVar;
                return true;
            }
            SensorManager sensorManager = (SensorManager) c.a.n0.a.s0.a.c().getSystemService("sensor");
            this.a = sensorManager;
            if (sensorManager != null) {
                this.f4755e = bVar;
                this.f4753c = sensorManager.getDefaultSensor(1);
                Sensor defaultSensor = this.a.getDefaultSensor(2);
                this.f4754d = defaultSensor;
                if (this.f4753c != null && defaultSensor != null) {
                    this.a.registerListener(i(), this.f4753c, i2);
                    this.a.registerListener(i(), this.f4754d, i2);
                    this.f4758h = true;
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
            if (!this.f4758h) {
                d.o("SwanAppOrientationManager", "has already stop");
                return;
            }
            this.f4758h = false;
            SensorEventListener sensorEventListener = this.f4752b;
            if (sensorEventListener != null && (sensorManager = this.a) != null) {
                sensorManager.unregisterListener(sensorEventListener);
                this.f4752b = null;
            }
            this.f4755e = null;
            this.a = null;
            this.f4753c = null;
            this.f4754d = null;
        }
    }
}
