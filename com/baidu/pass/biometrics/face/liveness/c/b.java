package com.baidu.pass.biometrics.face.liveness.c;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.biometrics.base.debug.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: g  reason: collision with root package name */
    public static final String f41864g = "b";

    /* renamed from: h  reason: collision with root package name */
    public static long f41865h = 1000;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f41866a;

    /* renamed from: b  reason: collision with root package name */
    public SensorManager f41867b;

    /* renamed from: c  reason: collision with root package name */
    public Sensor f41868c;

    /* renamed from: d  reason: collision with root package name */
    public SensorEventListener f41869d;

    /* renamed from: e  reason: collision with root package name */
    public long f41870e;

    /* renamed from: f  reason: collision with root package name */
    public float f41871f;

    /* loaded from: classes7.dex */
    public class a implements SensorEventListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ InterfaceC1647b f41872a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f41873b;

        public a(b bVar, InterfaceC1647b interfaceC1647b) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, interfaceC1647b};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41873b = bVar;
            this.f41872a = interfaceC1647b;
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, sensor, i2) == null) {
                String str = b.f41864g;
                Log.w(str, "onAccuracyChanged" + i2);
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sensorEvent) == null) {
                String str = b.f41864g;
                Log.w(str, "onSensorChanged() time:" + System.currentTimeMillis());
                float[] fArr = sensorEvent.values;
                if (fArr != null && fArr.length > 0) {
                    this.f41873b.f41871f = fArr[0];
                    String str2 = b.f41864g;
                    Log.w(str2, "onSensorChanged() event.values[0]:" + this.f41873b.f41871f);
                }
                this.f41873b.f41870e = System.currentTimeMillis();
                InterfaceC1647b interfaceC1647b = this.f41872a;
                if (interfaceC1647b != null) {
                    interfaceC1647b.a(this.f41873b.a());
                }
            }
        }
    }

    /* renamed from: com.baidu.pass.biometrics.face.liveness.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC1647b {
        void a(float f2);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1791500355, "Lcom/baidu/pass/biometrics/face/liveness/c/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1791500355, "Lcom/baidu/pass/biometrics/face/liveness/c/b;");
        }
    }

    public b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f41870e = 0L;
        this.f41871f = 2.1474836E9f;
        this.f41866a = context;
    }

    @TargetApi(3)
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Log.w(f41864g, "unRegisterSensorListener()");
            SensorManager sensorManager = this.f41867b;
            if (sensorManager == null || this.f41868c == null) {
                return;
            }
            sensorManager.unregisterListener(this.f41869d);
        }
    }

    @TargetApi(3)
    public void a(InterfaceC1647b interfaceC1647b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, interfaceC1647b) == null) {
            SensorManager sensorManager = (SensorManager) this.f41866a.getSystemService("sensor");
            this.f41867b = sensorManager;
            if (sensorManager == null) {
                Log.w(f41864g, "sensorManager|senserManager == null");
                return;
            }
            Sensor defaultSensor = sensorManager.getDefaultSensor(5);
            this.f41868c = defaultSensor;
            if (defaultSensor == null) {
                return;
            }
            a aVar = new a(this, interfaceC1647b);
            this.f41869d = aVar;
            this.f41867b.registerListener(aVar, this.f41868c, 3);
        }
    }

    public float a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f41870e != 0 && System.currentTimeMillis() - this.f41870e > f41865h) {
                this.f41871f = 0.0f;
            }
            return this.f41871f;
        }
        return invokeV.floatValue;
    }
}
