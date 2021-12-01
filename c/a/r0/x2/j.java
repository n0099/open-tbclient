package c.a.r0.x2;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import c.a.r0.x2.g;
import c.a.r0.x2.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes7.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WeakReference<Activity> a;

    /* renamed from: b  reason: collision with root package name */
    public SensorManager f25403b;

    /* renamed from: c  reason: collision with root package name */
    public g f25404c;

    /* renamed from: d  reason: collision with root package name */
    public Sensor f25405d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f25406e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f25407f;

    /* renamed from: g  reason: collision with root package name */
    public k f25408g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f25409h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f25410i;

    /* renamed from: j  reason: collision with root package name */
    public g.a f25411j;

    /* renamed from: k  reason: collision with root package name */
    public k.a f25412k;

    /* loaded from: classes7.dex */
    public class a implements g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j a;

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
            this.a = jVar;
        }

        @Override // c.a.r0.x2.g.a
        public void a(int i2) {
            Activity activity;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.a.a == null || (activity = (Activity) this.a.a.get()) == null || !this.a.f25410i) {
                return;
            }
            int requestedOrientation = activity.getRequestedOrientation();
            if (!this.a.f25409h) {
                if (i2 > 225 && i2 < 315) {
                    if (requestedOrientation == 8) {
                        activity.setRequestedOrientation(0);
                    }
                } else if (i2 <= 45 || i2 >= 135 || requestedOrientation != 0) {
                } else {
                    activity.setRequestedOrientation(8);
                }
            } else if ((i2 > 235 && i2 < 305) || (i2 > 55 && i2 < 125)) {
                if (!this.a.f25407f) {
                    if (i2 <= 55 || i2 >= 125) {
                        if (requestedOrientation != 0) {
                            activity.setRequestedOrientation(0);
                        }
                    } else if (requestedOrientation != 8) {
                        activity.setRequestedOrientation(8);
                    }
                }
                this.a.f25406e = false;
            } else if ((i2 <= 325 || i2 >= 360) && (i2 < 0 || i2 >= 35)) {
            } else {
                if (!this.a.f25406e && requestedOrientation != 1) {
                    activity.setRequestedOrientation(1);
                }
                this.a.f25407f = false;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements k.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j a;

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
            this.a = jVar;
        }

        @Override // c.a.r0.x2.k.a
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.f25409h = z;
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
        this.f25406e = false;
        this.f25407f = false;
        this.f25409h = false;
        this.f25410i = false;
        this.f25411j = new a(this);
        this.f25412k = new b(this);
        if (activity == null) {
            return;
        }
        this.a = new WeakReference<>(activity);
        this.f25403b = (SensorManager) activity.getApplicationContext().getSystemService("sensor");
        this.f25405d = TbadkCoreApplication.getInst().getDefaultSensor(1);
        this.f25404c = new g(this.f25411j);
        if (activity.getClass().getName().contains(SwanAppActivity.TAG)) {
            activity.setRequestedOrientation(1);
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.f25410i = z;
        }
    }

    public void j() {
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SensorManager sensorManager = this.f25403b;
            if (sensorManager != null) {
                sensorManager.registerListener(this.f25404c, this.f25405d, 2);
            }
            WeakReference<Activity> weakReference = this.a;
            if (weakReference == null || (activity = weakReference.get()) == null) {
                return;
            }
            k kVar = new k(activity.getApplicationContext(), new Handler(Looper.getMainLooper()));
            this.f25408g = kVar;
            kVar.b(this.f25412k);
            activity.getContentResolver().registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), true, this.f25408g);
        }
    }

    public void k() {
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SensorManager sensorManager = this.f25403b;
            if (sensorManager != null) {
                sensorManager.unregisterListener(this.f25404c);
            }
            WeakReference<Activity> weakReference = this.a;
            if (weakReference == null || this.f25408g == null || (activity = weakReference.get()) == null) {
                return;
            }
            activity.getContentResolver().unregisterContentObserver(this.f25408g);
        }
    }

    public void l() {
        WeakReference<Activity> weakReference;
        Activity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (weakReference = this.a) == null || (activity = weakReference.get()) == null) {
            return;
        }
        if (activity.getRequestedOrientation() == 1) {
            activity.setRequestedOrientation(0);
            this.f25406e = true;
            return;
        }
        activity.setRequestedOrientation(1);
        this.f25407f = true;
    }
}
