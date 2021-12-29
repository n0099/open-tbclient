package c.a.c0.i;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class e implements n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public f f2196b;

    /* renamed from: c  reason: collision with root package name */
    public int f2197c;

    /* renamed from: d  reason: collision with root package name */
    public long f2198d;

    /* renamed from: e  reason: collision with root package name */
    public AtomicBoolean f2199e;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public static final e a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(891951642, "Lc/a/c0/i/e$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(891951642, "Lc/a/c0/i/e$b;");
                    return;
                }
            }
            a = new e(null);
        }
    }

    public /* synthetic */ e(a aVar) {
        this();
    }

    public static e c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b.a : (e) invokeV.objValue;
    }

    @Override // c.a.c0.i.n
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f2199e.get()) {
            return;
        }
        f fVar = this.f2196b;
        if (fVar != null) {
            fVar.d();
            this.f2196b = null;
            this.f2197c = -1;
        }
        if (z) {
            if (this.f2198d == 0 || System.currentTimeMillis() - this.f2198d <= 300000) {
                return;
            }
            if (this.f2199e.compareAndSet(false, true)) {
                this.f2196b = new f(60, this.f2197c + 1, true);
            }
        } else {
            if (this.f2199e.compareAndSet(false, true)) {
                this.f2196b = new f(60, this.f2197c + 1, false);
            }
            c.a.c0.i.b.d().f();
        }
        b();
        this.f2198d = System.currentTimeMillis();
    }

    public void b() {
        f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int i2 = this.f2197c + 1;
            this.f2197c = i2;
            if (i2 <= 2 && (fVar = this.f2196b) != null) {
                fVar.e();
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f2199e.set(false);
        }
    }

    public e() {
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
        this.f2197c = -1;
        this.f2198d = 0L;
        this.f2199e = new AtomicBoolean(false);
    }
}
