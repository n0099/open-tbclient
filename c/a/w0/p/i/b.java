package c.a.w0.p.i;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.arface.utils.ThreadPool;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f30919a;

    /* renamed from: b  reason: collision with root package name */
    public int f30920b;

    /* renamed from: c  reason: collision with root package name */
    public int f30921c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f30922d;

    /* renamed from: e  reason: collision with root package name */
    public InterfaceC1433b f30923e;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f30924e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30924e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f30924e.i();
            }
        }
    }

    /* renamed from: c.a.w0.p.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1433b {
        void a(int i2);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-696865458, "Lc/a/w0/p/i/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-696865458, "Lc/a/w0/p/i/b;");
        }
    }

    public b() {
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

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i2 = this.f30921c;
            if (i2 != 0) {
                return i2;
            }
            int i3 = this.f30920b;
            return i3 != 0 ? i3 : this.f30919a;
        }
        return invokeV.intValue;
    }

    public synchronized void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            synchronized (this) {
                if (i2 == this.f30921c) {
                    return;
                }
                if ((this.f30920b == 0 || i2 != this.f30920b) && (this.f30920b != 0 || i2 != this.f30919a)) {
                    this.f30921c = i2;
                    if (i2 != 0 && !this.f30922d) {
                        this.f30922d = true;
                        g();
                    }
                }
                this.f30921c = 0;
            }
        }
    }

    public void c(InterfaceC1433b interfaceC1433b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, interfaceC1433b) == null) {
            this.f30923e = interfaceC1433b;
        }
    }

    public final synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                if (this.f30921c != this.f30919a) {
                    this.f30920b = this.f30921c;
                }
                this.f30921c = 0;
            }
        }
    }

    public final synchronized void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                if (this.f30920b != 0) {
                    this.f30919a = this.f30920b;
                }
                this.f30920b = 0;
            }
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            ThreadPool.b().e(new a(this));
        }
    }

    public final synchronized void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            synchronized (this) {
                this.f30922d = false;
            }
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048583, this) != null) {
            return;
        }
        while (true) {
            e();
            int i2 = this.f30920b;
            if (i2 == 0) {
                h();
                return;
            }
            InterfaceC1433b interfaceC1433b = this.f30923e;
            if (interfaceC1433b != null) {
                interfaceC1433b.a(i2);
            }
            f();
        }
    }
}
