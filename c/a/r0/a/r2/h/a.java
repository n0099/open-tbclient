package c.a.r0.a.r2.h;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.r0.a.e0.d;
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
    public static volatile a f8789i;
    public transient /* synthetic */ FieldHolder $fh;
    public SensorManager a;

    /* renamed from: b  reason: collision with root package name */
    public SensorEventListener f8790b;

    /* renamed from: c  reason: collision with root package name */
    public Sensor f8791c;

    /* renamed from: d  reason: collision with root package name */
    public Sensor f8792d;

    /* renamed from: e  reason: collision with root package name */
    public b f8793e;

    /* renamed from: f  reason: collision with root package name */
    public float[] f8794f;

    /* renamed from: g  reason: collision with root package name */
    public float[] f8795g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f8796h;

    /* renamed from: c.a.r0.a.r2.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0546a implements SensorEventListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f8797e;

        public C0546a(a aVar) {
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
            this.f8797e = aVar;
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
                    this.f8797e.f8794f = (float[]) fArr.clone();
                } else if (sensorEvent == null || (sensor = sensorEvent.sensor) == null || sensor.getType() != 2) {
                } else {
                    float[] fArr2 = sensorEvent.values;
                    if (fArr2 != null && fArr2.length == 3) {
                        this.f8797e.f8795g = (float[]) fArr2.clone();
                    }
                    if (this.f8797e.f8793e == null || this.f8797e.f8794f == null || this.f8797e.f8795g == null || (g2 = this.f8797e.g()) == null) {
                        return;
                    }
                    this.f8797e.f8793e.a(g2);
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
        this.f8796h = false;
    }

    public static a h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (f8789i == null) {
                synchronized (a.class) {
                    if (f8789i == null) {
                        f8789i = new a();
                    }
                }
            }
            return f8789i;
        }
        return (a) invokeV.objValue;
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, null) == null) || f8789i == null) {
            return;
        }
        f8789i.j();
    }

    @Nullable
    public final float[] g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            float[] fArr = new float[9];
            float[] fArr2 = new float[9];
            float[] fArr3 = new float[3];
            if (SensorManager.getRotationMatrix(fArr, null, this.f8794f, this.f8795g) && SensorManager.remapCoordinateSystem(fArr, 2, 129, fArr2)) {
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
            SensorEventListener sensorEventListener = this.f8790b;
            if (sensorEventListener != null) {
                return sensorEventListener;
            }
            C0546a c0546a = new C0546a(this);
            this.f8790b = c0546a;
            return c0546a;
        }
        return (SensorEventListener) invokeV.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d.i("SwanAppOrientationManager", "release");
            if (this.f8796h) {
                m();
            }
            this.a = null;
            this.f8791c = null;
            this.f8792d = null;
            this.f8790b = null;
            this.f8794f = null;
            this.f8795g = null;
            f8789i = null;
        }
    }

    public boolean l(int i2, @NonNull b bVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048579, this, i2, bVar)) == null) {
            if (this.f8796h) {
                d.o("SwanAppOrientationManager", "has already start, change new listener");
                this.f8793e = bVar;
                return true;
            }
            SensorManager sensorManager = (SensorManager) c.a.r0.a.c1.a.c().getSystemService("sensor");
            this.a = sensorManager;
            if (sensorManager != null) {
                this.f8793e = bVar;
                this.f8791c = sensorManager.getDefaultSensor(1);
                Sensor defaultSensor = this.a.getDefaultSensor(2);
                this.f8792d = defaultSensor;
                if (this.f8791c != null && defaultSensor != null) {
                    this.a.registerListener(i(), this.f8791c, i2);
                    this.a.registerListener(i(), this.f8792d, i2);
                    this.f8796h = true;
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
            if (!this.f8796h) {
                d.o("SwanAppOrientationManager", "has already stop");
                return;
            }
            this.f8796h = false;
            SensorEventListener sensorEventListener = this.f8790b;
            if (sensorEventListener != null && (sensorManager = this.a) != null) {
                sensorManager.unregisterListener(sensorEventListener);
                this.f8790b = null;
            }
            this.f8793e = null;
            this.a = null;
            this.f8791c = null;
            this.f8792d = null;
        }
    }
}
