package c.p.a.e.b.a;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Application f35052a;

    /* renamed from: b  reason: collision with root package name */
    public final List<b> f35053b;

    /* renamed from: c  reason: collision with root package name */
    public int f35054c;

    /* renamed from: d  reason: collision with root package name */
    public WeakReference<Activity> f35055d;

    /* renamed from: e  reason: collision with root package name */
    public volatile int f35056e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f35057f;

    /* renamed from: g  reason: collision with root package name */
    public final Application.ActivityLifecycleCallbacks f35058g;

    /* renamed from: c.p.a.e.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1547a implements Application.ActivityLifecycleCallbacks {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f35059e;

        public C1547a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35059e = aVar;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, activity, bundle) == null) {
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) {
                this.f35059e.f35057f = true;
                if (this.f35059e.f35054c != 0 || activity == null) {
                    return;
                }
                this.f35059e.f35054c = activity.hashCode();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, activity) == null) {
                int i2 = this.f35059e.f35054c;
                this.f35059e.f35057f = false;
                this.f35059e.f35054c = activity != null ? activity.hashCode() : i2;
                if (i2 == 0) {
                    this.f35059e.o();
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, activity, bundle) == null) {
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, activity) == null) {
                this.f35059e.f35055d = new WeakReference(activity);
                int i2 = this.f35059e.f35054c;
                this.f35059e.f35054c = activity != null ? activity.hashCode() : i2;
                this.f35059e.f35057f = false;
                if (i2 == 0) {
                    this.f35059e.o();
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, activity) == null) {
                if (activity != null && activity.hashCode() == this.f35059e.f35054c) {
                    this.f35059e.f35054c = 0;
                    this.f35059e.p();
                }
                this.f35059e.f35057f = false;
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        @MainThread
        void b();

        @MainThread
        void c();
    }

    /* loaded from: classes4.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f35060a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1154300453, "Lc/p/a/e/b/a/a$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1154300453, "Lc/p/a/e/b/a/a$c;");
                    return;
                }
            }
            f35060a = new a(null);
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
    }

    public /* synthetic */ a(C1547a c1547a) {
        this();
    }

    public static a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? c.f35060a : (a) invokeV.objValue;
    }

    public void e(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, context) == null) && this.f35052a == null && (context instanceof Application)) {
            synchronized (this) {
                if (this.f35052a == null) {
                    Application application = (Application) context;
                    this.f35052a = application;
                    application.registerActivityLifecycleCallbacks(this.f35058g);
                }
            }
        }
    }

    public void f(b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) || bVar == null) {
            return;
        }
        synchronized (this.f35053b) {
            if (!this.f35053b.contains(bVar)) {
                this.f35053b.add(bVar);
            }
        }
    }

    public void g(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
        }
    }

    public void i(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            synchronized (this.f35053b) {
                this.f35053b.remove(bVar);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [int, boolean] */
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int i2 = this.f35056e;
            int i3 = i2;
            if (i2 == -1) {
                ?? q = q();
                this.f35056e = q;
                i3 = q;
            }
            return i3 == 1;
        }
        return invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? k() && !this.f35057f : invokeV.booleanValue;
    }

    public final Object[] n() {
        InterceptResult invokeV;
        Object[] array;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this.f35053b) {
                array = this.f35053b.size() > 0 ? this.f35053b.toArray() : null;
            }
            return array;
        }
        return (Object[]) invokeV.objValue;
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f35056e = 1;
            Object[] n = n();
            if (n != null) {
                for (Object obj : n) {
                    ((b) obj).b();
                }
            }
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f35056e = 0;
            Object[] n = n();
            if (n != null) {
                for (Object obj : n) {
                    ((b) obj).c();
                }
            }
        }
    }

    public final boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            try {
                Application application = this.f35052a;
                if (application == null) {
                    return false;
                }
                String packageName = application.getPackageName();
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) application.getSystemService("activity")).getRunningAppProcesses();
                if (runningAppProcesses != null && !runningAppProcesses.isEmpty()) {
                    for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                        if (runningAppProcessInfo.importance == 100 && TextUtils.equals(runningAppProcessInfo.processName, packageName)) {
                            return true;
                        }
                    }
                    return false;
                }
                return false;
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public a() {
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
        this.f35053b = new ArrayList();
        this.f35056e = -1;
        this.f35057f = false;
        this.f35058g = new C1547a(this);
    }
}
