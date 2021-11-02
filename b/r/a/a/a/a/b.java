package b.r.a.a.a.a;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public final class b implements a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: f  reason: collision with root package name */
    public static String f33596f = "KWE_NS";

    /* renamed from: g  reason: collision with root package name */
    public static AtomicBoolean f33597g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public a f33598a;

    /* renamed from: b  reason: collision with root package name */
    public CountDownLatch f33599b;

    /* renamed from: c  reason: collision with root package name */
    public b.r.a.a.a.b.b f33600c;

    /* renamed from: d  reason: collision with root package name */
    public Context f33601d;

    /* renamed from: e  reason: collision with root package name */
    public b.r.a.a.c.a.e f33602e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(880130663, "Lb/r/a/a/a/a/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(880130663, "Lb/r/a/a/a/a/b;");
                return;
            }
        }
        f33597g = new AtomicBoolean(false);
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
                return;
            }
        }
        this.f33599b = null;
        this.f33600c = null;
    }

    public /* synthetic */ b(byte b2) {
        this();
    }

    public static final b c() {
        InterceptResult invokeV;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            bVar = e.f33607a;
            return bVar;
        }
        return (b) invokeV.objValue;
    }

    @Override // b.r.a.a.a.a.a
    public final void a(boolean z, b.r.a.a.a.b.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048576, this, z, bVar) == null) {
            try {
                if (this.f33598a != null) {
                    this.f33598a.a(z, bVar);
                }
            } catch (Throwable th) {
                b.r.a.a.c.b.c.c(th);
            }
        }
    }

    public final void g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            try {
                d dVar = new d(this);
                if (!f33597g.compareAndSet(false, true)) {
                    b.r.a.a.c.b.c.b("OaHelper has been initialized,return");
                    return;
                }
                if (this.f33601d == null) {
                    this.f33601d = context;
                }
                this.f33602e = new b.r.a.a.c.a.e(this.f33601d);
                Thread thread = new Thread(new c(this, context, dVar));
                thread.setName("adsence-dfp");
                thread.start();
            } catch (Throwable th) {
                b.r.a.a.c.b.c.c(th);
            }
        }
    }

    public final void i() {
        CountDownLatch countDownLatch;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (countDownLatch = this.f33599b) == null) {
            return;
        }
        countDownLatch.countDown();
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            try {
                if (this.f33599b == null || this.f33599b.getCount() <= 0) {
                    return;
                }
                b.r.a.a.c.b.c.b("awaitCdOaid");
                this.f33599b.await(2000L, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e2) {
                b.r.a.a.c.b.c.c(e2);
                Thread.currentThread().interrupt();
            }
        }
    }
}
