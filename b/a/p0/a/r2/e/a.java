package b.a.p0.a.r2.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.e0.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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

    /* renamed from: a  reason: collision with root package name */
    public Context f8156a;

    /* renamed from: b  reason: collision with root package name */
    public SensorManager f8157b;

    /* renamed from: c  reason: collision with root package name */
    public SensorEventListener f8158c;

    /* renamed from: d  reason: collision with root package name */
    public SensorEventListener f8159d;

    /* renamed from: e  reason: collision with root package name */
    public Sensor f8160e;

    /* renamed from: f  reason: collision with root package name */
    public Sensor f8161f;

    /* renamed from: g  reason: collision with root package name */
    public float[] f8162g;

    /* renamed from: h  reason: collision with root package name */
    public float[] f8163h;

    /* renamed from: i  reason: collision with root package name */
    public int f8164i;
    public c j;
    public boolean k;
    public long l;

    /* renamed from: b.a.p0.a.r2.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0384a implements SensorEventListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f8165e;

        public C0384a(a aVar) {
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
            this.f8165e = aVar;
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
                    this.f8165e.f8162g = sensorEvent.values;
                    this.f8165e.f8164i = sensorEvent.accuracy;
                    d.b("SwanAppCompassManager", "accelerometer changed accuracy: " + this.f8165e.f8164i);
                    this.f8165e.k();
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
        public final /* synthetic */ a f8166e;

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
            this.f8166e = aVar;
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
                    this.f8166e.f8163h = sensorEvent.values;
                    this.f8166e.f8164i = sensorEvent.accuracy;
                    d.b("SwanAppCompassManager", "magneticFiled changed accuracy: " + this.f8166e.f8164i);
                    this.f8166e.k();
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
        this.f8162g = new float[3];
        this.f8163h = new float[3];
        this.f8164i = -100;
        this.k = false;
        this.l = 0L;
    }

    public static String h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.BAIDU_LOGO_ID, null, i2)) == null) ? i2 != -1 ? i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? "unknow" : "high" : "medium" : "low" : "unreliable" : "no-contact" : (String) invokeI.objValue;
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
            SensorManager.getRotationMatrix(fArr2, null, this.f8162g, this.f8163h);
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
            SensorEventListener sensorEventListener = this.f8158c;
            if (sensorEventListener != null) {
                return sensorEventListener;
            }
            C0384a c0384a = new C0384a(this);
            this.f8158c = c0384a;
            return c0384a;
        }
        return (SensorEventListener) invokeV.objValue;
    }

    public final SensorEventListener j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            d.i("compass", "get MagneticFiled listener");
            SensorEventListener sensorEventListener = this.f8159d;
            if (sensorEventListener != null) {
                return sensorEventListener;
            }
            b bVar = new b(this);
            this.f8159d = bVar;
            return bVar;
        }
        return (SensorEventListener) invokeV.objValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.j == null || System.currentTimeMillis() - this.l <= 200) {
            return;
        }
        float f2 = f();
        d.b("SwanAppCompassManager", "orientation changed, orientation : " + f2);
        this.j.a(f2, this.f8164i);
        this.l = System.currentTimeMillis();
    }

    public void l(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            this.f8156a = context;
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            d.i("compass", "release");
            if (this.k) {
                q();
            }
            this.f8157b = null;
            this.f8161f = null;
            this.f8160e = null;
            this.f8158c = null;
            this.f8159d = null;
            this.j = null;
            this.f8156a = null;
            m = null;
        }
    }

    public void o(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            this.j = cVar;
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            Context context = this.f8156a;
            if (context == null) {
                d.c("compass", "start error, none context");
            } else if (this.k) {
                d.o("compass", "has already start");
            } else {
                SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
                this.f8157b = sensorManager;
                if (sensorManager != null) {
                    this.f8160e = sensorManager.getDefaultSensor(1);
                    this.f8161f = this.f8157b.getDefaultSensor(2);
                    this.f8157b.registerListener(g(), this.f8160e, 1);
                    this.f8157b.registerListener(j(), this.f8161f, 1);
                    this.k = true;
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
            if (!this.k) {
                d.o("compass", "has already stop");
                return;
            }
            d.i("compass", "stop listen");
            SensorEventListener sensorEventListener = this.f8158c;
            if (sensorEventListener != null && (sensorManager2 = this.f8157b) != null) {
                sensorManager2.unregisterListener(sensorEventListener);
                this.f8158c = null;
            }
            SensorEventListener sensorEventListener2 = this.f8159d;
            if (sensorEventListener2 != null && (sensorManager = this.f8157b) != null) {
                sensorManager.unregisterListener(sensorEventListener2);
                this.f8159d = null;
            }
            this.f8157b = null;
            this.f8161f = null;
            this.f8160e = null;
            this.k = false;
        }
    }
}
