package b.a.r0.r.e;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.r0.z2.z;
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
/* loaded from: classes5.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c f22972a;

    /* renamed from: b  reason: collision with root package name */
    public AdDownloadData f22973b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.r0.r.e.c f22974c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f22975d;

    /* renamed from: e  reason: collision with root package name */
    public int f22976e;

    /* renamed from: f  reason: collision with root package name */
    public long f22977f;

    /* renamed from: g  reason: collision with root package name */
    public e f22978g;

    /* loaded from: classes5.dex */
    public class a implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f22979a;

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
            this.f22979a = fVar;
        }

        @Override // b.a.r0.r.e.f.e
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f22979a.f22973b != null && this.f22979a.h()) {
                this.f22979a.j(BdBaseApplication.getInst().getApp().getApplicationContext(), this.f22979a.f22973b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements h.n.b<Long> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdDownloadData f22980e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f22981f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ f f22982g;

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
            this.f22982g = fVar;
            this.f22980e = adDownloadData;
            this.f22981f = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        public void call(Long l) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, l) == null) {
                if (this.f22982g.f22972a.a()) {
                    this.f22982g.i(this.f22981f, this.f22980e);
                    return;
                }
                this.f22982g.f22973b = this.f22980e;
                this.f22982g.f22977f = System.currentTimeMillis();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class d {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final f f22986a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1709299578, "Lb/a/r0/r/e/f$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1709299578, "Lb/a/r0/r/e/f$d;");
                    return;
                }
            }
            f22986a = new f(null);
        }
    }

    /* loaded from: classes5.dex */
    public interface e {
        void a();
    }

    public /* synthetic */ f(a aVar) {
        this();
    }

    public static f g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? d.f22986a : (f) invokeV.objValue;
    }

    public final boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (this.f22976e == 0 || b.a.r0.z2.e.e(System.currentTimeMillis(), this.f22977f, this.f22976e)) ? false : true : invokeV.booleanValue;
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
            this.f22974c.a(i2, adDownloadData.pkgName(), adDownloadData.getExtInfo());
            this.f22973b = null;
        }
    }

    public void j(Context context, AdDownloadData adDownloadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, adDownloadData) == null) || context == null || adDownloadData == null || !this.f22975d) {
            return;
        }
        h.d.B(1000L, TimeUnit.MILLISECONDS).k(h.l.b.a.b()).w(new b(this, adDownloadData, context));
    }

    public void k() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.f22975d) {
            TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(this.f22972a);
            this.f22972a.b(this.f22978g);
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
        this.f22972a = new c(null);
        this.f22973b = null;
        this.f22974c = new b.a.r0.r.e.c();
        this.f22975d = b.a.r0.a.h().v();
        this.f22976e = b.a.r0.a.h().i();
        this.f22978g = new a(this);
    }

    /* loaded from: classes5.dex */
    public static class c implements Application.ActivityLifecycleCallbacks {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public WeakReference<Activity> f22983e;

        /* renamed from: f  reason: collision with root package name */
        public e f22984f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f22985g;

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
            this.f22983e = null;
            this.f22984f = null;
            this.f22985g = true;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                WeakReference<Activity> weakReference = this.f22983e;
                return (weakReference == null || weakReference.get() == null || !this.f22985g) ? false : true;
            }
            return invokeV.booleanValue;
        }

        public void b(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
                this.f22984f = eVar;
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
            if ((interceptable == null || interceptable.invokeL(1048579, this, activity) == null) && (weakReference = this.f22983e) != null && weakReference.get() == activity) {
                this.f22983e = null;
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
                this.f22983e = new WeakReference<>(activity);
                if (!this.f22985g && (eVar = this.f22984f) != null) {
                    eVar.a();
                }
                this.f22985g = true;
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
            if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity) == null) && (weakReference = this.f22983e) != null && weakReference.get() == activity) {
                this.f22985g = false;
            }
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }
}
