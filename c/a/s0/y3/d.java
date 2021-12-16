package c.a.s0.y3;

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
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public static int a;

    /* renamed from: b  reason: collision with root package name */
    public static MainTabScheduleStrategy f26163b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f26164c;

    /* renamed from: d  reason: collision with root package name */
    public static final PriorityQueue<h> f26165d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
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

    /* loaded from: classes8.dex */
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

    /* loaded from: classes8.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f26166e;

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
            this.f26166e = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f26166e.c();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-750714208, "Lc/a/s0/y3/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-750714208, "Lc/a/s0/y3/d;");
                return;
            }
        }
        f26163b = MainTabScheduleStrategy.FLUSHING;
        f26164c = false;
        f26165d = new PriorityQueue<>();
    }

    public static void b(MainTabScheduleStrategy mainTabScheduleStrategy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, mainTabScheduleStrategy) == null) {
            f26163b = mainTabScheduleStrategy;
            if (mainTabScheduleStrategy == MainTabScheduleStrategy.UNSCHEDULE || f26164c) {
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
            f26164c = false;
            if (f26165d.isEmpty() || f26163b == MainTabScheduleStrategy.UNSCHEDULE) {
                return;
            }
            if (f26163b == MainTabScheduleStrategy.FLUSHING) {
                e();
                return;
            }
            if (f26165d.peek() != null && a >= f26165d.peek().f26205e) {
                h poll = f26165d.poll();
                if (poll == null) {
                    return;
                }
                c(poll);
            }
            if (f26163b == MainTabScheduleStrategy.SCHEDULE) {
                g(false);
            }
        }
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            while (!f26165d.isEmpty()) {
                h poll = f26165d.poll();
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
        if (f26163b == MainTabScheduleStrategy.FLUSHING) {
            if (!(hVar instanceof i)) {
                hVar.d();
                hVar.b();
            }
            hVar.c();
            return;
        }
        hVar.d();
        f26165d.add(hVar);
        if (f26163b == MainTabScheduleStrategy.UNSCHEDULE || f26164c) {
            return;
        }
        g(false);
    }

    public static void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65543, null, z) == null) {
            f26164c = true;
            if (z) {
                c.a.d.f.m.e.a().postAtFrontOfQueue(new a());
            } else {
                c.a.d.f.m.e.a().post(new b());
            }
        }
    }
}
