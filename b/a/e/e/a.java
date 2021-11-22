package b.a.e.e;

import androidx.core.view.InputDeviceCompat;
import b.a.e.f.m.e;
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
    public static a f1577f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f1578a;

    /* renamed from: b  reason: collision with root package name */
    public b f1579b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f1580c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f1581d;

    /* renamed from: e  reason: collision with root package name */
    public final Runnable f1582e;

    /* renamed from: b.a.e.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0023a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f1583e;

        public RunnableC0023a(a aVar) {
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
            this.f1583e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f1583e.f1579b == null || this.f1583e.f1581d) {
                return;
            }
            this.f1583e.f1581d = true;
            this.f1583e.f1579b.scheduleIdleTask();
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
        this.f1578a = true;
        this.f1580c = false;
        this.f1581d = false;
        this.f1582e = new RunnableC0023a(this);
    }

    public static a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f1577f == null) {
                f1577f = new a();
            }
            return f1577f;
        }
        return (a) invokeV.objValue;
    }

    public void d(String str, Runnable runnable) {
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, runnable) == null) {
            if (this.f1578a && !this.f1580c && (bVar = this.f1579b) != null) {
                bVar.registerIdleTask(str, runnable);
            } else {
                runnable.run();
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            e.a().postDelayed(this.f1582e, 20000L);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            e.a().removeCallbacks(this.f1582e);
            b bVar = this.f1579b;
            if (bVar == null || this.f1581d) {
                return;
            }
            this.f1581d = true;
            bVar.scheduleIdleTask();
        }
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f1578a = z;
            if (z) {
                e();
            }
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f1580c = z;
            if (z) {
                e.a().removeCallbacks(this.f1582e);
            }
        }
    }

    public void j(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f1579b = bVar;
        }
    }
}
