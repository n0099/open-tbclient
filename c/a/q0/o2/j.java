package c.a.q0.o2;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import c.a.q0.o2.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<Activity> f23188a;

    /* renamed from: b  reason: collision with root package name */
    public SensorManager f23189b;

    /* renamed from: c  reason: collision with root package name */
    public g f23190c;

    /* renamed from: d  reason: collision with root package name */
    public Sensor f23191d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f23192e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f23193f;

    /* renamed from: g  reason: collision with root package name */
    public k f23194g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f23195h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f23196i;

    /* renamed from: j  reason: collision with root package name */
    public Handler f23197j;
    public k.a k;

    /* loaded from: classes3.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f23198a;

        public a(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23198a = jVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Activity activity;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, message) == null) || message == null || this.f23198a.f23188a == null || (activity = (Activity) this.f23198a.f23188a.get()) == null || !this.f23198a.f23196i || message.what != 1) {
                return;
            }
            int requestedOrientation = activity.getRequestedOrientation();
            int i2 = message.arg1;
            if (!this.f23198a.f23195h) {
                if (i2 > 225 && i2 < 315) {
                    if (requestedOrientation == 8) {
                        activity.setRequestedOrientation(0);
                    }
                } else if (i2 <= 45 || i2 >= 135 || requestedOrientation != 0) {
                } else {
                    activity.setRequestedOrientation(8);
                }
            } else if ((i2 > 235 && i2 < 305) || (i2 > 55 && i2 < 125)) {
                if (!this.f23198a.f23193f) {
                    if (i2 <= 55 || i2 >= 125) {
                        if (requestedOrientation != 0) {
                            activity.setRequestedOrientation(0);
                        }
                    } else if (requestedOrientation != 8) {
                        activity.setRequestedOrientation(8);
                    }
                }
                this.f23198a.f23192e = false;
            } else if ((i2 <= 325 || i2 >= 360) && (i2 < 0 || i2 >= 35)) {
            } else {
                if (!this.f23198a.f23192e && requestedOrientation != 1) {
                    activity.setRequestedOrientation(1);
                }
                this.f23198a.f23193f = false;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements k.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f23199a;

        public b(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23199a = jVar;
        }

        @Override // c.a.q0.o2.k.a
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f23199a.f23195h = z;
            }
        }
    }

    public j(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23192e = false;
        this.f23193f = false;
        this.f23195h = false;
        this.f23196i = false;
        this.f23197j = new a(this);
        this.k = new b(this);
        if (activity == null) {
            return;
        }
        this.f23188a = new WeakReference<>(activity);
        SensorManager sensorManager = (SensorManager) activity.getApplicationContext().getSystemService("sensor");
        this.f23189b = sensorManager;
        this.f23191d = sensorManager.getDefaultSensor(1);
        this.f23190c = new g(this.f23197j);
        if (activity.getClass().getName().contains(SwanAppActivity.TAG)) {
            activity.setRequestedOrientation(1);
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.f23196i = z;
        }
    }

    public void j() {
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SensorManager sensorManager = this.f23189b;
            if (sensorManager != null) {
                sensorManager.registerListener(this.f23190c, this.f23191d, 2);
            }
            WeakReference<Activity> weakReference = this.f23188a;
            if (weakReference == null || (activity = weakReference.get()) == null) {
                return;
            }
            k kVar = new k(activity.getApplicationContext(), new Handler(Looper.getMainLooper()));
            this.f23194g = kVar;
            kVar.b(this.k);
            activity.getContentResolver().registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), true, this.f23194g);
        }
    }

    public void k() {
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SensorManager sensorManager = this.f23189b;
            if (sensorManager != null) {
                sensorManager.unregisterListener(this.f23190c);
            }
            this.f23197j.removeCallbacksAndMessages(null);
            WeakReference<Activity> weakReference = this.f23188a;
            if (weakReference == null || this.f23194g == null || (activity = weakReference.get()) == null) {
                return;
            }
            activity.getContentResolver().unregisterContentObserver(this.f23194g);
        }
    }

    public void l() {
        WeakReference<Activity> weakReference;
        Activity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (weakReference = this.f23188a) == null || (activity = weakReference.get()) == null) {
            return;
        }
        if (activity.getRequestedOrientation() == 1) {
            activity.setRequestedOrientation(0);
            this.f23192e = true;
            return;
        }
        activity.setRequestedOrientation(1);
        this.f23193f = true;
    }
}
