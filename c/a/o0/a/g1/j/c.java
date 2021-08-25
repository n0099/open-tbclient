package c.a.o0.a.g1.j;

import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.v2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c implements c.a.o0.a.g1.j.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f5755a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final List<c.a.o0.a.g1.j.a> f5756b;

    /* renamed from: c  reason: collision with root package name */
    public Runnable f5757c;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f5758e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5758e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                for (c.a.o0.a.g1.j.a aVar : this.f5758e.f5756b) {
                    aVar.onPause();
                }
                this.f5758e.f5755a = true;
                this.f5758e.f5757c = null;
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f5759e;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5759e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f5759e.f5755a) {
                if (this.f5759e.f5757c != null) {
                    q0.a0(this.f5759e.f5757c);
                    this.f5759e.f5757c = null;
                }
                for (c.a.o0.a.g1.j.a aVar : this.f5759e.f5756b) {
                    aVar.onResume();
                }
                this.f5759e.f5755a = false;
            }
        }
    }

    /* renamed from: c.a.o0.a.g1.j.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0194c {
        public static /* synthetic */ Interceptable $ic = null;

        /* renamed from: a  reason: collision with root package name */
        public static int f5760a = -2;

        /* renamed from: b  reason: collision with root package name */
        public static int f5761b = -2;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(650511597, "Lc/a/o0/a/g1/j/c$c;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(650511597, "Lc/a/o0/a/g1/j/c$c;");
            }
        }

        public static boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                if (f5761b == -2) {
                    c.a.o0.a.c1.a.Z().getSwitch("swan_webview_pause_control", 3);
                    f5761b = 3;
                }
                return (f5761b & 2) == 2;
            }
            return invokeV.booleanValue;
        }

        public static boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
                if (f5761b == -2) {
                    c.a.o0.a.c1.a.Z().getSwitch("swan_webview_pause_control", 3);
                    f5761b = 3;
                }
                return (f5761b & 1) == 1;
            }
            return invokeV.booleanValue;
        }

        public static boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                if (f5760a == -2) {
                    c.a.o0.a.c1.a.Z().getSwitch("swan_webview_backstage_optimize", -1);
                    f5760a = -1;
                }
                return f5760a > -1;
            }
            return invokeV.booleanValue;
        }

        public static int d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? f5760a : invokeV.intValue;
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final c f5762a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(650511628, "Lc/a/o0/a/g1/j/c$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(650511628, "Lc/a/o0/a/g1/j/c$d;");
                    return;
                }
            }
            f5762a = new c(null);
        }
    }

    public /* synthetic */ c(a aVar) {
        this();
    }

    public static c.a.o0.a.g1.j.a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? d.f5762a : (c.a.o0.a.g1.j.a) invokeV.objValue;
    }

    @Override // c.a.o0.a.g1.j.a
    @AnyThread
    public void onPause() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && C0194c.c()) {
            this.f5757c = new a(this);
            q0.Y(this.f5757c, C0194c.d() * 1000);
        }
    }

    @Override // c.a.o0.a.g1.j.a
    @AnyThread
    public void onResume() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && C0194c.c()) {
            q0.b0(new b(this));
        }
    }

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
        this.f5755a = false;
        this.f5756b = new ArrayList();
        if (C0194c.c()) {
            if (C0194c.b()) {
                this.f5756b.add(new c.a.o0.a.g1.j.d());
            }
            if (C0194c.a()) {
                this.f5756b.add(new c.a.o0.a.g1.j.b());
            }
        }
    }
}
