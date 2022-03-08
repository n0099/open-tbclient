package c.a.y0.o.c;

import android.os.Process;
import c.a.y0.o.f.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile boolean a;

    /* renamed from: b  reason: collision with root package name */
    public c f26829b;

    /* renamed from: c  reason: collision with root package name */
    public b f26830c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.y0.o.g.c f26831d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f26832e;

    /* renamed from: c.a.y0.o.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class C1619a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public class b extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f26833e;

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
            this.f26833e = aVar;
        }

        public /* synthetic */ b(a aVar, C1619a c1619a) {
            this(aVar);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Process.setThreadPriority(-19);
                try {
                    try {
                        this.f26833e.f26829b = new c(-100);
                        if (this.f26833e.f26829b.d() != null) {
                            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(c.f26925d);
                            this.f26833e.f26829b.c();
                            if (this.f26833e.f26829b.e() != 3) {
                                return;
                            }
                            while (!this.f26833e.a) {
                                allocateDirect.clear();
                                int a = this.f26833e.f26829b.a(allocateDirect, c.f26925d);
                                if (a > 0) {
                                    double a2 = c.a.y0.o.i.a.a(allocateDirect, a);
                                    if (this.f26833e.f26831d != null && a2 > 0.0d) {
                                        this.f26833e.f26831d.a(a2);
                                    }
                                }
                            }
                        } else if (this.f26833e.f26831d != null) {
                            this.f26833e.f26831d.a("failed to initialize AudioRecord", true);
                        }
                    } catch (Exception unused) {
                        if (this.f26833e.f26831d != null) {
                            this.f26833e.f26831d.a("failed to initialize AudioRecord", true);
                        }
                    }
                } finally {
                    this.f26833e.i();
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
        this.a = false;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f26832e = true;
            this.a = false;
            b bVar = new b(this, null);
            this.f26830c = bVar;
            bVar.start();
        }
    }

    public void d(c.a.y0.o.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.f26831d = cVar;
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a = true;
            this.f26832e = false;
        }
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f26832e : invokeV.booleanValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.a = false;
            this.f26832e = false;
            c cVar = this.f26829b;
            if (cVar != null) {
                cVar.b();
            }
            if (this.f26830c != null) {
                this.f26830c = null;
            }
        }
    }
}
