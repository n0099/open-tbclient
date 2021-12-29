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
/* loaded from: classes10.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: g  reason: collision with root package name */
    public static final String f38861g = "b";

    /* renamed from: h  reason: collision with root package name */
    public static long f38862h = 1000;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public SensorManager f38863b;

    /* renamed from: c  reason: collision with root package name */
    public Sensor f38864c;

    /* renamed from: d  reason: collision with root package name */
    public SensorEventListener f38865d;

    /* renamed from: e  reason: collision with root package name */
    public long f38866e;

    /* renamed from: f  reason: collision with root package name */
    public float f38867f;

    /* loaded from: classes10.dex */
    public class a implements SensorEventListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ InterfaceC1820b a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f38868b;

        public a(b bVar, InterfaceC1820b interfaceC1820b) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, interfaceC1820b};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38868b = bVar;
            this.a = interfaceC1820b;
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, sensor, i2) == null) {
                String str = b.f38861g;
                Log.w(str, "onAccuracyChanged" + i2);
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sensorEvent) == null) {
                String str = b.f38861g;
                Log.w(str, "onSensorChanged() time:" + System.currentTimeMillis());
                float[] fArr = sensorEvent.values;
                if (fArr != null && fArr.length > 0) {
                    this.f38868b.f38867f = fArr[0];
                    String str2 = b.f38861g;
                    Log.w(str2, "onSensorChanged() event.values[0]:" + this.f38868b.f38867f);
                }
                this.f38868b.f38866e = System.currentTimeMillis();
                InterfaceC1820b interfaceC1820b = this.a;
                if (interfaceC1820b != null) {
                    interfaceC1820b.a(this.f38868b.a());
                }
            }
        }
    }

    /* renamed from: com.baidu.pass.biometrics.face.liveness.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC1820b {
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
        this.f38866e = 0L;
        this.f38867f = 2.1474836E9f;
        this.a = context;
    }

    @TargetApi(3)
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Log.w(f38861g, "unRegisterSensorListener()");
            SensorManager sensorManager = this.f38863b;
            if (sensorManager == null || this.f38864c == null) {
                return;
            }
            sensorManager.unregisterListener(this.f38865d);
        }
    }

    @TargetApi(3)
    public void a(InterfaceC1820b interfaceC1820b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, interfaceC1820b) == null) {
            SensorManager sensorManager = (SensorManager) this.a.getSystemService("sensor");
            this.f38863b = sensorManager;
            if (sensorManager == null) {
                Log.w(f38861g, "sensorManager|senserManager == null");
                return;
            }
            Sensor defaultSensor = sensorManager.getDefaultSensor(5);
            this.f38864c = defaultSensor;
            if (defaultSensor == null) {
                return;
            }
            a aVar = new a(this, interfaceC1820b);
            this.f38865d = aVar;
            this.f38863b.registerListener(aVar, this.f38864c, 3);
        }
    }

    public float a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f38866e != 0 && System.currentTimeMillis() - this.f38866e > f38862h) {
                this.f38867f = 0.0f;
            }
            return this.f38867f;
        }
        return invokeV.floatValue;
    }
}
