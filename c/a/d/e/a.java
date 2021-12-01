package c.a.d.e;

import androidx.core.view.InputDeviceCompat;
import c.a.d.f.m.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static a f2287f;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public b f2288b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f2289c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f2290d;

    /* renamed from: e  reason: collision with root package name */
    public final Runnable f2291e;

    /* renamed from: c.a.d.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0079a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f2292e;

        public RunnableC0079a(a aVar) {
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
            this.f2292e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f2292e.f2288b == null || this.f2292e.f2290d) {
                return;
            }
            this.f2292e.f2290d = true;
            this.f2292e.f2288b.scheduleIdleTask();
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void registerIdleTask(String str, Runnable runnable);

        void scheduleIdleTask();
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
        this.a = false;
        this.f2289c = false;
        this.f2290d = false;
        this.f2291e = new RunnableC0079a(this);
    }

    public static a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f2287f == null) {
                f2287f = new a();
            }
            return f2287f;
        }
        return (a) invokeV.objValue;
    }

    public void d(String str, Runnable runnable) {
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, runnable) == null) {
            if (this.a && !this.f2289c && (bVar = this.f2288b) != null) {
                bVar.registerIdleTask(str, runnable);
            } else {
                runnable.run();
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            e.a().postDelayed(this.f2291e, 20000L);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            e.a().removeCallbacks(this.f2291e);
            b bVar = this.f2288b;
            if (bVar == null || this.f2290d) {
                return;
            }
            this.f2290d = true;
            bVar.scheduleIdleTask();
        }
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.a = z;
            if (z) {
                e();
            }
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f2289c = z;
            if (z) {
                e.a().removeCallbacks(this.f2291e);
            }
        }
    }

    public void j(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f2288b = bVar;
        }
    }
}
