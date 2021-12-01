package c.a.p0.a.r2.h;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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

    /* renamed from: i  reason: collision with root package name */
    public static volatile a f7798i;
    public transient /* synthetic */ FieldHolder $fh;
    public SensorManager a;

    /* renamed from: b  reason: collision with root package name */
    public SensorEventListener f7799b;

    /* renamed from: c  reason: collision with root package name */
    public Sensor f7800c;

    /* renamed from: d  reason: collision with root package name */
    public Sensor f7801d;

    /* renamed from: e  reason: collision with root package name */
    public b f7802e;

    /* renamed from: f  reason: collision with root package name */
    public float[] f7803f;

    /* renamed from: g  reason: collision with root package name */
    public float[] f7804g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f7805h;

    /* renamed from: c.a.p0.a.r2.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0444a implements SensorEventListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f7806e;

        public C0444a(a aVar) {
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
            this.f7806e = aVar;
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
                    this.f7806e.f7803f = (float[]) fArr.clone();
                } else if (sensorEvent == null || (sensor = sensorEvent.sensor) == null || sensor.getType() != 2) {
                } else {
                    float[] fArr2 = sensorEvent.values;
                    if (fArr2 != null && fArr2.length == 3) {
                        this.f7806e.f7804g = (float[]) fArr2.clone();
                    }
                    if (this.f7806e.f7802e == null || this.f7806e.f7803f == null || this.f7806e.f7804g == null || (g2 = this.f7806e.g()) == null) {
                        return;
                    }
                    this.f7806e.f7802e.a(g2);
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
        this.f7805h = false;
    }

    public static a h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (f7798i == null) {
                synchronized (a.class) {
                    if (f7798i == null) {
                        f7798i = new a();
                    }
                }
            }
            return f7798i;
        }
        return (a) invokeV.objValue;
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, null) == null) || f7798i == null) {
            return;
        }
        f7798i.j();
    }

    @Nullable
    public final float[] g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            float[] fArr = new float[9];
            float[] fArr2 = new float[9];
            float[] fArr3 = new float[3];
            if (SensorManager.getRotationMatrix(fArr, null, this.f7803f, this.f7804g) && SensorManager.remapCoordinateSystem(fArr, 2, 129, fArr2)) {
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
            SensorEventListener sensorEventListener = this.f7799b;
            if (sensorEventListener != null) {
                return sensorEventListener;
            }
            C0444a c0444a = new C0444a(this);
            this.f7799b = c0444a;
            return c0444a;
        }
        return (SensorEventListener) invokeV.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d.i("SwanAppOrientationManager", "release");
            if (this.f7805h) {
                m();
            }
            this.a = null;
            this.f7800c = null;
            this.f7801d = null;
            this.f7799b = null;
            this.f7803f = null;
            this.f7804g = null;
            f7798i = null;
        }
    }

    public boolean l(int i2, @NonNull b bVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048579, this, i2, bVar)) == null) {
            if (this.f7805h) {
                d.o("SwanAppOrientationManager", "has already start, change new listener");
                this.f7802e = bVar;
                return true;
            }
            SensorManager sensorManager = (SensorManager) c.a.p0.a.c1.a.c().getSystemService("sensor");
            this.a = sensorManager;
            if (sensorManager != null) {
                this.f7802e = bVar;
                this.f7800c = sensorManager.getDefaultSensor(1);
                Sensor defaultSensor = this.a.getDefaultSensor(2);
                this.f7801d = defaultSensor;
                if (this.f7800c != null && defaultSensor != null) {
                    this.a.registerListener(i(), this.f7800c, i2);
                    this.a.registerListener(i(), this.f7801d, i2);
                    this.f7805h = true;
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
            if (!this.f7805h) {
                d.o("SwanAppOrientationManager", "has already stop");
                return;
            }
            this.f7805h = false;
            SensorEventListener sensorEventListener = this.f7799b;
            if (sensorEventListener != null && (sensorManager = this.a) != null) {
                sensorManager.unregisterListener(sensorEventListener);
                this.f7799b = null;
            }
            this.f7802e = null;
            this.a = null;
            this.f7800c = null;
            this.f7801d = null;
        }
    }
}
