package b.a.x0.p.c;

import android.os.Process;
import b.a.x0.p.f.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f29769a;

    /* renamed from: b  reason: collision with root package name */
    public c f29770b;

    /* renamed from: c  reason: collision with root package name */
    public b f29771c;

    /* renamed from: d  reason: collision with root package name */
    public b.a.x0.p.g.c f29772d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f29773e;

    /* renamed from: b.a.x0.p.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class C1430a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public class b extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f29774e;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29774e = aVar;
        }

        public /* synthetic */ b(a aVar, C1430a c1430a) {
            this(aVar);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Process.setThreadPriority(-19);
                try {
                    try {
                        this.f29774e.f29770b = new c(-100);
                        if (this.f29774e.f29770b.d() != null) {
                            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(c.f29877d);
                            this.f29774e.f29770b.c();
                            if (this.f29774e.f29770b.e() != 3) {
                                return;
                            }
                            while (!this.f29774e.f29769a) {
                                allocateDirect.clear();
                                int a2 = this.f29774e.f29770b.a(allocateDirect, c.f29877d);
                                if (a2 > 0) {
                                    double a3 = b.a.x0.p.i.a.a(allocateDirect, a2);
                                    if (this.f29774e.f29772d != null && a3 > 0.0d) {
                                        this.f29774e.f29772d.a(a3);
                                    }
                                }
                            }
                        } else if (this.f29774e.f29772d != null) {
                            this.f29774e.f29772d.a("failed to initialize AudioRecord", true);
                        }
                    } catch (Exception unused) {
                        if (this.f29774e.f29772d != null) {
                            this.f29774e.f29772d.a("failed to initialize AudioRecord", true);
                        }
                    }
                } finally {
                    this.f29774e.i();
                }
            }
        }
    }

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
                return;
            }
        }
        this.f29769a = false;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f29773e = true;
            this.f29769a = false;
            b bVar = new b(this, null);
            this.f29771c = bVar;
            bVar.start();
        }
    }

    public void d(b.a.x0.p.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.f29772d = cVar;
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f29769a = true;
            this.f29773e = false;
        }
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f29773e : invokeV.booleanValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f29769a = false;
            this.f29773e = false;
            c cVar = this.f29770b;
            if (cVar != null) {
                cVar.b();
            }
            if (this.f29771c != null) {
                this.f29771c = null;
            }
        }
    }
}
