package c.a.x0.p.c;

import android.os.Process;
import c.a.x0.p.f.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f31001a;

    /* renamed from: b  reason: collision with root package name */
    public c f31002b;

    /* renamed from: c  reason: collision with root package name */
    public b f31003c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.x0.p.g.c f31004d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f31005e;

    /* renamed from: c.a.x0.p.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class C1429a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public class b extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f31006e;

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
            this.f31006e = aVar;
        }

        public /* synthetic */ b(a aVar, C1429a c1429a) {
            this(aVar);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Process.setThreadPriority(-19);
                try {
                    try {
                        this.f31006e.f31002b = new c(-100);
                        if (this.f31006e.f31002b.d() != null) {
                            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(c.f31113d);
                            this.f31006e.f31002b.c();
                            if (this.f31006e.f31002b.e() != 3) {
                                return;
                            }
                            while (!this.f31006e.f31001a) {
                                allocateDirect.clear();
                                int a2 = this.f31006e.f31002b.a(allocateDirect, c.f31113d);
                                if (a2 > 0) {
                                    double a3 = c.a.x0.p.i.a.a(allocateDirect, a2);
                                    if (this.f31006e.f31004d != null && a3 > 0.0d) {
                                        this.f31006e.f31004d.a(a3);
                                    }
                                }
                            }
                        } else if (this.f31006e.f31004d != null) {
                            this.f31006e.f31004d.a("failed to initialize AudioRecord", true);
                        }
                    } catch (Exception unused) {
                        if (this.f31006e.f31004d != null) {
                            this.f31006e.f31004d.a("failed to initialize AudioRecord", true);
                        }
                    }
                } finally {
                    this.f31006e.i();
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
        this.f31001a = false;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f31005e = true;
            this.f31001a = false;
            b bVar = new b(this, null);
            this.f31003c = bVar;
            bVar.start();
        }
    }

    public void d(c.a.x0.p.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.f31004d = cVar;
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f31001a = true;
            this.f31005e = false;
        }
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f31005e : invokeV.booleanValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f31001a = false;
            this.f31005e = false;
            c cVar = this.f31002b;
            if (cVar != null) {
                cVar.b();
            }
            if (this.f31003c != null) {
                this.f31003c = null;
            }
        }
    }
}
