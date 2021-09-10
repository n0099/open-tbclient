package c.a.r0.q.e;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.y2.z;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c f24110a;

    /* renamed from: b  reason: collision with root package name */
    public AdDownloadData f24111b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.r0.q.e.c f24112c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f24113d;

    /* renamed from: e  reason: collision with root package name */
    public int f24114e;

    /* renamed from: f  reason: collision with root package name */
    public long f24115f;

    /* renamed from: g  reason: collision with root package name */
    public e f24116g;

    /* loaded from: classes3.dex */
    public class a implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f24117a;

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24117a = fVar;
        }

        @Override // c.a.r0.q.e.f.e
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f24117a.f24111b != null && this.f24117a.h()) {
                this.f24117a.j(BdBaseApplication.getInst().getApp().getApplicationContext(), this.f24117a.f24111b);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements i.n.b<Long> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdDownloadData f24118e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f24119f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ f f24120g;

        public b(f fVar, AdDownloadData adDownloadData, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, adDownloadData, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24120g = fVar;
            this.f24118e = adDownloadData;
            this.f24119f = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // i.n.b
        /* renamed from: a */
        public void call(Long l) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, l) == null) {
                if (this.f24120g.f24110a.a()) {
                    this.f24120g.i(this.f24119f, this.f24118e);
                    return;
                }
                this.f24120g.f24111b = this.f24118e;
                this.f24120g.f24115f = System.currentTimeMillis();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class d {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final f f24124a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1944558104, "Lc/a/r0/q/e/f$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1944558104, "Lc/a/r0/q/e/f$d;");
                    return;
                }
            }
            f24124a = new f(null);
        }
    }

    /* loaded from: classes3.dex */
    public interface e {
        void a();
    }

    public /* synthetic */ f(a aVar) {
        this();
    }

    public static f g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? d.f24124a : (f) invokeV.objValue;
    }

    public final boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (this.f24114e == 0 || c.a.r0.y2.e.e(System.currentTimeMillis(), this.f24115f, this.f24114e)) ? false : true : invokeV.booleanValue;
    }

    public final void i(Context context, AdDownloadData adDownloadData) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, adDownloadData) == null) {
            if (!TextUtils.isEmpty(adDownloadData.getDeeplink()) && z.o(adDownloadData.getDeeplink())) {
                i2 = z.d(context, adDownloadData.getDeeplink(), adDownloadData.adId(), adDownloadData.getExtInfo());
            } else {
                z.x(adDownloadData.getPkgName());
                i2 = -1;
            }
            this.f24112c.a(i2, adDownloadData.pkgName(), adDownloadData.getExtInfo());
            this.f24111b = null;
        }
    }

    public void j(Context context, AdDownloadData adDownloadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, adDownloadData) == null) || context == null || adDownloadData == null || !this.f24113d) {
            return;
        }
        i.d.G(1000L, TimeUnit.MILLISECONDS).o(i.l.b.a.b()).B(new b(this, adDownloadData, context));
    }

    public void k() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.f24113d) {
            TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(this.f24110a);
            this.f24110a.b(this.f24116g);
        }
    }

    public f() {
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
        this.f24110a = new c(null);
        this.f24111b = null;
        this.f24112c = new c.a.r0.q.e.c();
        this.f24113d = c.a.r0.a.h().v();
        this.f24114e = c.a.r0.a.h().i();
        this.f24116g = new a(this);
    }

    /* loaded from: classes3.dex */
    public static class c implements Application.ActivityLifecycleCallbacks {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public WeakReference<Activity> f24121e;

        /* renamed from: f  reason: collision with root package name */
        public e f24122f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f24123g;

        public c() {
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
            this.f24121e = null;
            this.f24122f = null;
            this.f24123g = true;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                WeakReference<Activity> weakReference = this.f24121e;
                return (weakReference == null || weakReference.get() == null || !this.f24123g) ? false : true;
            }
            return invokeV.booleanValue;
        }

        public void b(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
                this.f24122f = eVar;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, activity, bundle) == null) {
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            WeakReference<Activity> weakReference;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048579, this, activity) == null) && (weakReference = this.f24121e) != null && weakReference.get() == activity) {
                this.f24121e = null;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, activity) == null) {
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            e eVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, activity) == null) {
                this.f24121e = new WeakReference<>(activity);
                if (!this.f24123g && (eVar = this.f24122f) != null) {
                    eVar.a();
                }
                this.f24123g = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, activity, bundle) == null) {
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, activity) == null) {
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            WeakReference<Activity> weakReference;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity) == null) && (weakReference = this.f24121e) != null && weakReference.get() == activity) {
                this.f24123g = false;
            }
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }
}
