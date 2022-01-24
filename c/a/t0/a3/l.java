package c.a.t0.a3;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import c.a.t0.a3.i;
import c.a.t0.a3.m;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WeakReference<Activity> a;

    /* renamed from: b  reason: collision with root package name */
    public SensorManager f15260b;

    /* renamed from: c  reason: collision with root package name */
    public i f15261c;

    /* renamed from: d  reason: collision with root package name */
    public Sensor f15262d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f15263e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f15264f;

    /* renamed from: g  reason: collision with root package name */
    public m f15265g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f15266h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f15267i;

    /* renamed from: j  reason: collision with root package name */
    public i.a f15268j;
    public m.a k;

    /* loaded from: classes6.dex */
    public class a implements i.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l a;

        public a(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lVar;
        }

        @Override // c.a.t0.a3.i.a
        public void a(int i2) {
            Activity activity;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.a.a == null || (activity = (Activity) this.a.a.get()) == null || !this.a.f15267i) {
                return;
            }
            int requestedOrientation = activity.getRequestedOrientation();
            if (!this.a.f15266h) {
                if (i2 > 225 && i2 < 315) {
                    if (requestedOrientation == 8) {
                        activity.setRequestedOrientation(0);
                    }
                } else if (i2 <= 45 || i2 >= 135 || requestedOrientation != 0) {
                } else {
                    activity.setRequestedOrientation(8);
                }
            } else if ((i2 > 235 && i2 < 305) || (i2 > 55 && i2 < 125)) {
                if (!this.a.f15264f) {
                    if (i2 <= 55 || i2 >= 125) {
                        if (requestedOrientation != 0) {
                            activity.setRequestedOrientation(0);
                        }
                    } else if (requestedOrientation != 8) {
                        activity.setRequestedOrientation(8);
                    }
                }
                this.a.f15263e = false;
            } else if ((i2 <= 325 || i2 >= 360) && (i2 < 0 || i2 >= 35)) {
            } else {
                if (!this.a.f15263e && requestedOrientation != 1) {
                    activity.setRequestedOrientation(1);
                }
                this.a.f15264f = false;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l a;

        public b(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lVar;
        }

        @Override // c.a.t0.a3.m.a
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.f15266h = z;
            }
        }
    }

    public l(Activity activity) {
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
        this.f15263e = false;
        this.f15264f = false;
        this.f15266h = false;
        this.f15267i = false;
        this.f15268j = new a(this);
        this.k = new b(this);
        if (activity == null) {
            return;
        }
        this.a = new WeakReference<>(activity);
        this.f15260b = (SensorManager) activity.getApplicationContext().getSystemService("sensor");
        this.f15262d = TbadkCoreApplication.getInst().getDefaultSensor(1);
        this.f15261c = new i(this.f15268j);
        if (activity.getClass().getName().contains(SwanAppActivity.TAG)) {
            activity.setRequestedOrientation(1);
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.f15267i = z;
        }
    }

    public void j() {
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SensorManager sensorManager = this.f15260b;
            if (sensorManager != null) {
                sensorManager.registerListener(this.f15261c, this.f15262d, 2);
            }
            WeakReference<Activity> weakReference = this.a;
            if (weakReference == null || (activity = weakReference.get()) == null) {
                return;
            }
            m mVar = new m(activity.getApplicationContext(), new Handler(Looper.getMainLooper()));
            this.f15265g = mVar;
            mVar.b(this.k);
            activity.getContentResolver().registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), true, this.f15265g);
        }
    }

    public void k() {
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SensorManager sensorManager = this.f15260b;
            if (sensorManager != null) {
                sensorManager.unregisterListener(this.f15261c);
            }
            WeakReference<Activity> weakReference = this.a;
            if (weakReference == null || this.f15265g == null || (activity = weakReference.get()) == null) {
                return;
            }
            activity.getContentResolver().unregisterContentObserver(this.f15265g);
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
            this.f15263e = true;
            return;
        }
        activity.setRequestedOrientation(1);
        this.f15264f = true;
    }
}
