package b.a.p0.a.g1.j;

import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.v2.q0;
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
public class c implements b.a.p0.a.g1.j.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f5141a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final List<b.a.p0.a.g1.j.a> f5142b;

    /* renamed from: c  reason: collision with root package name */
    public Runnable f5143c;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f5144e;

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
            this.f5144e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                for (b.a.p0.a.g1.j.a aVar : this.f5144e.f5142b) {
                    aVar.onPause();
                }
                this.f5144e.f5141a = true;
                this.f5144e.f5143c = null;
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f5145e;

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
            this.f5145e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f5145e.f5141a) {
                if (this.f5145e.f5143c != null) {
                    q0.a0(this.f5145e.f5143c);
                    this.f5145e.f5143c = null;
                }
                for (b.a.p0.a.g1.j.a aVar : this.f5145e.f5142b) {
                    aVar.onResume();
                }
                this.f5145e.f5141a = false;
            }
        }
    }

    /* renamed from: b.a.p0.a.g1.j.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0191c {
        public static /* synthetic */ Interceptable $ic = null;

        /* renamed from: a  reason: collision with root package name */
        public static int f5146a = -2;

        /* renamed from: b  reason: collision with root package name */
        public static int f5147b = -2;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1142025325, "Lb/a/p0/a/g1/j/c$c;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1142025325, "Lb/a/p0/a/g1/j/c$c;");
            }
        }

        public static boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                if (f5147b == -2) {
                    b.a.p0.a.c1.a.Z().getSwitch("swan_webview_pause_control", 3);
                    f5147b = 3;
                }
                return (f5147b & 2) == 2;
            }
            return invokeV.booleanValue;
        }

        public static boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
                if (f5147b == -2) {
                    b.a.p0.a.c1.a.Z().getSwitch("swan_webview_pause_control", 3);
                    f5147b = 3;
                }
                return (f5147b & 1) == 1;
            }
            return invokeV.booleanValue;
        }

        public static boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                if (f5146a == -2) {
                    b.a.p0.a.c1.a.Z().getSwitch("swan_webview_backstage_optimize", -1);
                    f5146a = -1;
                }
                return f5146a > -1;
            }
            return invokeV.booleanValue;
        }

        public static int d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? f5146a : invokeV.intValue;
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final c f5148a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1142025356, "Lb/a/p0/a/g1/j/c$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1142025356, "Lb/a/p0/a/g1/j/c$d;");
                    return;
                }
            }
            f5148a = new c(null);
        }
    }

    public /* synthetic */ c(a aVar) {
        this();
    }

    public static b.a.p0.a.g1.j.a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? d.f5148a : (b.a.p0.a.g1.j.a) invokeV.objValue;
    }

    @Override // b.a.p0.a.g1.j.a
    @AnyThread
    public void onPause() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && C0191c.c()) {
            this.f5143c = new a(this);
            q0.Y(this.f5143c, C0191c.d() * 1000);
        }
    }

    @Override // b.a.p0.a.g1.j.a
    @AnyThread
    public void onResume() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && C0191c.c()) {
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
        this.f5141a = false;
        this.f5142b = new ArrayList();
        if (C0191c.c()) {
            if (C0191c.b()) {
                this.f5142b.add(new b.a.p0.a.g1.j.d());
            }
            if (C0191c.a()) {
                this.f5142b.add(new b.a.p0.a.g1.j.b());
            }
        }
    }
}
