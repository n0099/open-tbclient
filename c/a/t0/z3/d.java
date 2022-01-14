package c.a.t0.z3;

import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.tblauncher.MainTabScheduleStrategy;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.PriorityQueue;
/* loaded from: classes9.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public static int a;

    /* renamed from: b  reason: collision with root package name */
    public static MainTabScheduleStrategy f26108b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f26109c;

    /* renamed from: d  reason: collision with root package name */
    public static final PriorityQueue<h> f26110d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.d();
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.d();
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f26111e;

        public c(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26111e = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f26111e.c();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(993019648, "Lc/a/t0/z3/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(993019648, "Lc/a/t0/z3/d;");
                return;
            }
        }
        f26108b = MainTabScheduleStrategy.FLUSHING;
        f26109c = false;
        f26110d = new PriorityQueue<>();
    }

    public static void b(MainTabScheduleStrategy mainTabScheduleStrategy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, mainTabScheduleStrategy) == null) {
            f26108b = mainTabScheduleStrategy;
            if (mainTabScheduleStrategy == MainTabScheduleStrategy.UNSCHEDULE || f26109c) {
                return;
            }
            g(true);
        }
    }

    public static void c(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, hVar) == null) {
            System.nanoTime();
            hVar.b();
            c.a.d.f.m.e.a().postAtFrontOfQueue(new c(hVar));
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            f26109c = false;
            if (f26110d.isEmpty() || f26108b == MainTabScheduleStrategy.UNSCHEDULE) {
                return;
            }
            if (f26108b == MainTabScheduleStrategy.FLUSHING) {
                e();
                return;
            }
            if (f26110d.peek() != null && a >= f26110d.peek().f26148e) {
                h poll = f26110d.poll();
                if (poll == null) {
                    return;
                }
                c(poll);
            }
            if (f26108b == MainTabScheduleStrategy.SCHEDULE) {
                g(false);
            }
        }
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            while (!f26110d.isEmpty()) {
                h poll = f26110d.poll();
                if (poll != null) {
                    poll.b();
                    poll.c();
                }
            }
        }
    }

    public static void f(h hVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, null, hVar) == null) || hVar == null) {
            return;
        }
        if (f26108b == MainTabScheduleStrategy.FLUSHING) {
            if (!(hVar instanceof i)) {
                hVar.d();
                hVar.b();
            }
            hVar.c();
            return;
        }
        hVar.d();
        f26110d.add(hVar);
        if (f26108b == MainTabScheduleStrategy.UNSCHEDULE || f26109c) {
            return;
        }
        g(false);
    }

    public static void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65543, null, z) == null) {
            f26109c = true;
            if (z) {
                c.a.d.f.m.e.a().postAtFrontOfQueue(new a());
            } else {
                c.a.d.f.m.e.a().post(new b());
            }
        }
    }
}
