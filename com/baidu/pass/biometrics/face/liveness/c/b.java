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
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: g  reason: collision with root package name */
    public static final String f9231g = "b";

    /* renamed from: h  reason: collision with root package name */
    public static long f9232h = 1000;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f9233a;

    /* renamed from: b  reason: collision with root package name */
    public SensorManager f9234b;

    /* renamed from: c  reason: collision with root package name */
    public Sensor f9235c;

    /* renamed from: d  reason: collision with root package name */
    public SensorEventListener f9236d;

    /* renamed from: e  reason: collision with root package name */
    public long f9237e;

    /* renamed from: f  reason: collision with root package name */
    public float f9238f;

    /* loaded from: classes2.dex */
    public class a implements SensorEventListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0133b f9239a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f9240b;

        public a(b bVar, InterfaceC0133b interfaceC0133b) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, interfaceC0133b};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9240b = bVar;
            this.f9239a = interfaceC0133b;
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, sensor, i2) == null) {
                String str = b.f9231g;
                Log.w(str, "onAccuracyChanged" + i2);
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sensorEvent) == null) {
                String str = b.f9231g;
                Log.w(str, "onSensorChanged() time:" + System.currentTimeMillis());
                float[] fArr = sensorEvent.values;
                if (fArr != null && fArr.length > 0) {
                    this.f9240b.f9238f = fArr[0];
                    String str2 = b.f9231g;
                    Log.w(str2, "onSensorChanged() event.values[0]:" + this.f9240b.f9238f);
                }
                this.f9240b.f9237e = System.currentTimeMillis();
                InterfaceC0133b interfaceC0133b = this.f9239a;
                if (interfaceC0133b != null) {
                    interfaceC0133b.a(this.f9240b.a());
                }
            }
        }
    }

    /* renamed from: com.baidu.pass.biometrics.face.liveness.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0133b {
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
        this.f9237e = 0L;
        this.f9238f = 2.1474836E9f;
        this.f9233a = context;
    }

    @TargetApi(3)
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Log.w(f9231g, "unRegisterSensorListener()");
            SensorManager sensorManager = this.f9234b;
            if (sensorManager == null || this.f9235c == null) {
                return;
            }
            sensorManager.unregisterListener(this.f9236d);
        }
    }

    @TargetApi(3)
    public void a(InterfaceC0133b interfaceC0133b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, interfaceC0133b) == null) {
            SensorManager sensorManager = (SensorManager) this.f9233a.getSystemService("sensor");
            this.f9234b = sensorManager;
            if (sensorManager == null) {
                Log.w(f9231g, "sensorManager|senserManager == null");
                return;
            }
            Sensor defaultSensor = sensorManager.getDefaultSensor(5);
            this.f9235c = defaultSensor;
            if (defaultSensor == null) {
                return;
            }
            a aVar = new a(this, interfaceC0133b);
            this.f9236d = aVar;
            this.f9234b.registerListener(aVar, this.f9235c, 3);
        }
    }

    public float a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f9237e != 0 && System.currentTimeMillis() - this.f9237e > f9232h) {
                this.f9238f = 0.0f;
            }
            return this.f9238f;
        }
        return invokeV.floatValue;
    }
}
