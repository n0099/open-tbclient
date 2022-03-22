package c.a.a0.l;

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
    public f f1382b;

    /* renamed from: c  reason: collision with root package name */
    public int f1383c;

    /* renamed from: d  reason: collision with root package name */
    public long f1384d;

    /* renamed from: e  reason: collision with root package name */
    public AtomicBoolean f1385e;

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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(297780725, "Lc/a/a0/l/e$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(297780725, "Lc/a/a0/l/e$b;");
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

    @Override // c.a.a0.l.n
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f1385e.get()) {
            return;
        }
        f fVar = this.f1382b;
        if (fVar != null) {
            fVar.d();
            this.f1382b = null;
            this.f1383c = -1;
        }
        if (z) {
            if (this.f1384d == 0 || System.currentTimeMillis() - this.f1384d <= 300000) {
                return;
            }
            if (this.f1385e.compareAndSet(false, true)) {
                this.f1382b = new f(60, this.f1383c + 1, true);
            }
        } else {
            if (this.f1385e.compareAndSet(false, true)) {
                this.f1382b = new f(60, this.f1383c + 1, false);
            }
            c.a.a0.l.b.d().f();
        }
        b();
        this.f1384d = System.currentTimeMillis();
    }

    public void b() {
        f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int i = this.f1383c + 1;
            this.f1383c = i;
            if (i <= 2 && (fVar = this.f1382b) != null) {
                fVar.e();
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f1385e.set(false);
        }
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1383c = -1;
        this.f1384d = 0L;
        this.f1385e = new AtomicBoolean(false);
    }
}
