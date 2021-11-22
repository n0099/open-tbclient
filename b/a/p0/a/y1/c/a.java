package b.a.p0.a.y1.c;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.k;
import b.a.p0.a.y1.c.f.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f9465b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c f9466a;

    /* renamed from: b.a.p0.a.y1.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0484a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.y1.c.c f9467e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f9468f;

        public RunnableC0484a(a aVar, b.a.p0.a.y1.c.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9468f = aVar;
            this.f9467e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f9468f.g(this.f9467e);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static a f9469a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1527847607, "Lb/a/p0/a/y1/c/a$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1527847607, "Lb/a/p0/a/y1/c/a$b;");
                    return;
                }
            }
            f9469a = new a();
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void a();

        void b(@NonNull b.a.p0.a.y1.c.c cVar);

        void c(String str);

        void d(String str);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-466393785, "Lb/a/p0/a/y1/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-466393785, "Lb/a/p0/a/y1/c/a;");
                return;
            }
        }
        f9465b = k.f6863a;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static a e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? b.f9469a : (a) invokeV.objValue;
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) {
            boolean z = f9465b;
        }
    }

    public void b(String str) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (cVar = this.f9466a) == null) {
            return;
        }
        cVar.d(str);
    }

    public void c() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (cVar = this.f9466a) == null) {
            return;
        }
        cVar.a();
    }

    public void d(String str) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (cVar = this.f9466a) == null) {
            return;
        }
        cVar.c(str);
    }

    public final void g(@NonNull b.a.p0.a.y1.c.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            boolean isMainProcess = ProcessUtils.isMainProcess();
            if (!isMainProcess && !SwanAppProcessInfo.isInited()) {
                f("send: return by process check");
                return;
            }
            if (this.f9466a == null) {
                this.f9466a = isMainProcess ? new d() : new b.a.p0.a.y1.c.e.b();
            }
            f("send: sender=" + this.f9466a);
            this.f9466a.a();
            this.f9466a.b(cVar);
            this.f9466a.a();
        }
    }

    public void h(@NonNull b.a.p0.a.y1.c.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            long i2 = cVar.i();
            int i3 = (i2 > 0L ? 1 : (i2 == 0L ? 0 : -1));
            if (i3 <= 0 && Looper.getMainLooper() == Looper.myLooper()) {
                g(cVar);
                return;
            }
            Handler L = b.a.p0.a.d2.d.L();
            RunnableC0484a runnableC0484a = new RunnableC0484a(this, cVar);
            if (i3 < 0) {
                i2 = 0;
            }
            L.postDelayed(runnableC0484a, i2);
        }
    }
}
