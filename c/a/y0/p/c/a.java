package c.a.y0.p.c;

import android.os.Process;
import c.a.y0.p.f.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile boolean a;

    /* renamed from: b  reason: collision with root package name */
    public c f27453b;

    /* renamed from: c  reason: collision with root package name */
    public b f27454c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.y0.p.g.c f27455d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f27456e;

    /* renamed from: c.a.y0.p.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class C1578a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public class b extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f27457e;

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
            this.f27457e = aVar;
        }

        public /* synthetic */ b(a aVar, C1578a c1578a) {
            this(aVar);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Process.setThreadPriority(-19);
                try {
                    try {
                        this.f27457e.f27453b = new c(-100);
                        if (this.f27457e.f27453b.d() != null) {
                            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(c.f27553d);
                            this.f27457e.f27453b.c();
                            if (this.f27457e.f27453b.e() != 3) {
                                return;
                            }
                            while (!this.f27457e.a) {
                                allocateDirect.clear();
                                int a = this.f27457e.f27453b.a(allocateDirect, c.f27553d);
                                if (a > 0) {
                                    double a2 = c.a.y0.p.i.a.a(allocateDirect, a);
                                    if (this.f27457e.f27455d != null && a2 > 0.0d) {
                                        this.f27457e.f27455d.a(a2);
                                    }
                                }
                            }
                        } else if (this.f27457e.f27455d != null) {
                            this.f27457e.f27455d.a("failed to initialize AudioRecord", true);
                        }
                    } catch (Exception unused) {
                        if (this.f27457e.f27455d != null) {
                            this.f27457e.f27455d.a("failed to initialize AudioRecord", true);
                        }
                    }
                } finally {
                    this.f27457e.i();
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
            this.f27456e = true;
            this.a = false;
            b bVar = new b(this, null);
            this.f27454c = bVar;
            bVar.start();
        }
    }

    public void d(c.a.y0.p.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.f27455d = cVar;
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a = true;
            this.f27456e = false;
        }
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f27456e : invokeV.booleanValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.a = false;
            this.f27456e = false;
            c cVar = this.f27453b;
            if (cVar != null) {
                cVar.b();
            }
            if (this.f27454c != null) {
                this.f27454c = null;
            }
        }
    }
}
