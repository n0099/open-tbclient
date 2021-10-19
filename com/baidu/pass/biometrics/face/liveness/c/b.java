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
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: g  reason: collision with root package name */
    public static final String f44097g = "b";

    /* renamed from: h  reason: collision with root package name */
    public static long f44098h = 1000;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f44099a;

    /* renamed from: b  reason: collision with root package name */
    public SensorManager f44100b;

    /* renamed from: c  reason: collision with root package name */
    public Sensor f44101c;

    /* renamed from: d  reason: collision with root package name */
    public SensorEventListener f44102d;

    /* renamed from: e  reason: collision with root package name */
    public long f44103e;

    /* renamed from: f  reason: collision with root package name */
    public float f44104f;

    /* loaded from: classes5.dex */
    public class a implements SensorEventListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ InterfaceC1690b f44105a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f44106b;

        public a(b bVar, InterfaceC1690b interfaceC1690b) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, interfaceC1690b};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44106b = bVar;
            this.f44105a = interfaceC1690b;
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, sensor, i2) == null) {
                String str = b.f44097g;
                Log.w(str, "onAccuracyChanged" + i2);
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sensorEvent) == null) {
                String str = b.f44097g;
                Log.w(str, "onSensorChanged() time:" + System.currentTimeMillis());
                float[] fArr = sensorEvent.values;
                if (fArr != null && fArr.length > 0) {
                    this.f44106b.f44104f = fArr[0];
                    String str2 = b.f44097g;
                    Log.w(str2, "onSensorChanged() event.values[0]:" + this.f44106b.f44104f);
                }
                this.f44106b.f44103e = System.currentTimeMillis();
                InterfaceC1690b interfaceC1690b = this.f44105a;
                if (interfaceC1690b != null) {
                    interfaceC1690b.a(this.f44106b.a());
                }
            }
        }
    }

    /* renamed from: com.baidu.pass.biometrics.face.liveness.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1690b {
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
        this.f44103e = 0L;
        this.f44104f = 2.1474836E9f;
        this.f44099a = context;
    }

    @TargetApi(3)
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Log.w(f44097g, "unRegisterSensorListener()");
            SensorManager sensorManager = this.f44100b;
            if (sensorManager == null || this.f44101c == null) {
                return;
            }
            sensorManager.unregisterListener(this.f44102d);
        }
    }

    @TargetApi(3)
    public void a(InterfaceC1690b interfaceC1690b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, interfaceC1690b) == null) {
            SensorManager sensorManager = (SensorManager) this.f44099a.getSystemService("sensor");
            this.f44100b = sensorManager;
            if (sensorManager == null) {
                Log.w(f44097g, "sensorManager|senserManager == null");
                return;
            }
            Sensor defaultSensor = sensorManager.getDefaultSensor(5);
            this.f44101c = defaultSensor;
            if (defaultSensor == null) {
                return;
            }
            a aVar = new a(this, interfaceC1690b);
            this.f44102d = aVar;
            this.f44100b.registerListener(aVar, this.f44101c, 3);
        }
    }

    public float a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f44103e != 0 && System.currentTimeMillis() - this.f44103e > f44098h) {
                this.f44104f = 0.0f;
            }
            return this.f44104f;
        }
        return invokeV.floatValue;
    }
}
