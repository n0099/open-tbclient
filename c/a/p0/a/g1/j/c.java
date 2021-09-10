package c.a.p0.a.g1.j;

import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.v2.q0;
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
public class c implements c.a.p0.a.g1.j.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f5783a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final List<c.a.p0.a.g1.j.a> f5784b;

    /* renamed from: c  reason: collision with root package name */
    public Runnable f5785c;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f5786e;

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
            this.f5786e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                for (c.a.p0.a.g1.j.a aVar : this.f5786e.f5784b) {
                    aVar.onPause();
                }
                this.f5786e.f5783a = true;
                this.f5786e.f5785c = null;
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f5787e;

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
            this.f5787e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f5787e.f5783a) {
                if (this.f5787e.f5785c != null) {
                    q0.a0(this.f5787e.f5785c);
                    this.f5787e.f5785c = null;
                }
                for (c.a.p0.a.g1.j.a aVar : this.f5787e.f5784b) {
                    aVar.onResume();
                }
                this.f5787e.f5783a = false;
            }
        }
    }

    /* renamed from: c.a.p0.a.g1.j.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0196c {
        public static /* synthetic */ Interceptable $ic = null;

        /* renamed from: a  reason: collision with root package name */
        public static int f5788a = -2;

        /* renamed from: b  reason: collision with root package name */
        public static int f5789b = -2;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(144952972, "Lc/a/p0/a/g1/j/c$c;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(144952972, "Lc/a/p0/a/g1/j/c$c;");
            }
        }

        public static boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                if (f5789b == -2) {
                    c.a.p0.a.c1.a.Z().getSwitch("swan_webview_pause_control", 3);
                    f5789b = 3;
                }
                return (f5789b & 2) == 2;
            }
            return invokeV.booleanValue;
        }

        public static boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
                if (f5789b == -2) {
                    c.a.p0.a.c1.a.Z().getSwitch("swan_webview_pause_control", 3);
                    f5789b = 3;
                }
                return (f5789b & 1) == 1;
            }
            return invokeV.booleanValue;
        }

        public static boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                if (f5788a == -2) {
                    c.a.p0.a.c1.a.Z().getSwitch("swan_webview_backstage_optimize", -1);
                    f5788a = -1;
                }
                return f5788a > -1;
            }
            return invokeV.booleanValue;
        }

        public static int d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? f5788a : invokeV.intValue;
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final c f5790a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(144953003, "Lc/a/p0/a/g1/j/c$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(144953003, "Lc/a/p0/a/g1/j/c$d;");
                    return;
                }
            }
            f5790a = new c(null);
        }
    }

    public /* synthetic */ c(a aVar) {
        this();
    }

    public static c.a.p0.a.g1.j.a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? d.f5790a : (c.a.p0.a.g1.j.a) invokeV.objValue;
    }

    @Override // c.a.p0.a.g1.j.a
    @AnyThread
    public void onPause() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && C0196c.c()) {
            this.f5785c = new a(this);
            q0.Y(this.f5785c, C0196c.d() * 1000);
        }
    }

    @Override // c.a.p0.a.g1.j.a
    @AnyThread
    public void onResume() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && C0196c.c()) {
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
        this.f5783a = false;
        this.f5784b = new ArrayList();
        if (C0196c.c()) {
            if (C0196c.b()) {
                this.f5784b.add(new c.a.p0.a.g1.j.d());
            }
            if (C0196c.a()) {
                this.f5784b.add(new c.a.p0.a.g1.j.b());
            }
        }
    }
}
