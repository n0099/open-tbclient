package b.a.r0.r.e;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.r0.a3.z;
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
    public c f24504a;

    /* renamed from: b  reason: collision with root package name */
    public AdDownloadData f24505b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.r0.r.e.c f24506c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f24507d;

    /* renamed from: e  reason: collision with root package name */
    public int f24508e;

    /* renamed from: f  reason: collision with root package name */
    public long f24509f;

    /* renamed from: g  reason: collision with root package name */
    public e f24510g;

    /* loaded from: classes5.dex */
    public class a implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f24511a;

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
            this.f24511a = fVar;
        }

        @Override // b.a.r0.r.e.f.e
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f24511a.f24505b != null && this.f24511a.h()) {
                this.f24511a.j(BdBaseApplication.getInst().getApp().getApplicationContext(), this.f24511a.f24505b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements h.n.b<Long> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdDownloadData f24512e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f24513f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ f f24514g;

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
            this.f24514g = fVar;
            this.f24512e = adDownloadData;
            this.f24513f = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        public void call(Long l) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, l) == null) {
                if (this.f24514g.f24504a.a()) {
                    this.f24514g.i(this.f24513f, this.f24512e);
                    return;
                }
                this.f24514g.f24505b = this.f24512e;
                this.f24514g.f24509f = System.currentTimeMillis();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class d {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final f f24518a;
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
            f24518a = new f(null);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? d.f24518a : (f) invokeV.objValue;
    }

    public final boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (this.f24508e == 0 || b.a.r0.a3.e.e(System.currentTimeMillis(), this.f24509f, this.f24508e)) ? false : true : invokeV.booleanValue;
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
            this.f24506c.a(i2, adDownloadData.pkgName(), adDownloadData.getExtInfo());
            this.f24505b = null;
        }
    }

    public void j(Context context, AdDownloadData adDownloadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, adDownloadData) == null) || context == null || adDownloadData == null || !this.f24507d) {
            return;
        }
        h.d.B(1000L, TimeUnit.MILLISECONDS).k(h.l.b.a.b()).w(new b(this, adDownloadData, context));
    }

    public void k() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.f24507d) {
            TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(this.f24504a);
            this.f24504a.b(this.f24510g);
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
        this.f24504a = new c(null);
        this.f24505b = null;
        this.f24506c = new b.a.r0.r.e.c();
        this.f24507d = b.a.r0.a.h().w();
        this.f24508e = b.a.r0.a.h().i();
        this.f24510g = new a(this);
    }

    /* loaded from: classes5.dex */
    public static class c implements Application.ActivityLifecycleCallbacks {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public WeakReference<Activity> f24515e;

        /* renamed from: f  reason: collision with root package name */
        public e f24516f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f24517g;

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
            this.f24515e = null;
            this.f24516f = null;
            this.f24517g = true;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                WeakReference<Activity> weakReference = this.f24515e;
                return (weakReference == null || weakReference.get() == null || !this.f24517g) ? false : true;
            }
            return invokeV.booleanValue;
        }

        public void b(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
                this.f24516f = eVar;
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
            if ((interceptable == null || interceptable.invokeL(1048579, this, activity) == null) && (weakReference = this.f24515e) != null && weakReference.get() == activity) {
                this.f24515e = null;
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
                this.f24515e = new WeakReference<>(activity);
                if (!this.f24517g && (eVar = this.f24516f) != null) {
                    eVar.a();
                }
                this.f24517g = true;
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
            if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity) == null) && (weakReference = this.f24515e) != null && weakReference.get() == activity) {
                this.f24517g = false;
            }
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }
}
