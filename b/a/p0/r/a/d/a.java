package b.a.p0.r.a.d;

import android.os.Build;
import android.view.LayoutInflater;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final InterfaceC0656a f12108a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.p0.r.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0656a {
        void a(LayoutInflater layoutInflater, e eVar);
    }

    /* loaded from: classes4.dex */
    public static class b implements InterfaceC0656a {
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

        @Override // b.a.p0.r.a.d.a.InterfaceC0656a
        public void a(LayoutInflater layoutInflater, e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, layoutInflater, eVar) == null) {
                b.a.p0.r.a.d.b.a(layoutInflater, eVar);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class c extends b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        @Override // b.a.p0.r.a.d.a.b, b.a.p0.r.a.d.a.InterfaceC0656a
        public void a(LayoutInflater layoutInflater, e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, layoutInflater, eVar) == null) {
                b.a.p0.r.a.d.c.b(layoutInflater, eVar);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class d extends c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d() {
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

        @Override // b.a.p0.r.a.d.a.c, b.a.p0.r.a.d.a.b, b.a.p0.r.a.d.a.InterfaceC0656a
        public void a(LayoutInflater layoutInflater, e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, layoutInflater, eVar) == null) {
                b.a.p0.r.a.d.d.a(layoutInflater, eVar);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1770037432, "Lb/a/p0/r/a/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1770037432, "Lb/a/p0/r/a/d/a;");
                return;
            }
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            f12108a = new d();
        } else if (i2 >= 11) {
            f12108a = new c();
        } else {
            f12108a = new b();
        }
    }

    public static void a(LayoutInflater layoutInflater, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, layoutInflater, eVar) == null) {
            f12108a.a(layoutInflater, eVar);
        }
    }
}
