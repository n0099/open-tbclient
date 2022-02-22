package c.a.b1.p.c;

import android.os.Process;
import c.a.b1.p.f.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile boolean a;

    /* renamed from: b  reason: collision with root package name */
    public c f1377b;

    /* renamed from: c  reason: collision with root package name */
    public b f1378c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.b1.p.g.c f1379d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1380e;

    /* renamed from: c.a.b1.p.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0022a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public class b extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f1381e;

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
            this.f1381e = aVar;
        }

        public /* synthetic */ b(a aVar, C0022a c0022a) {
            this(aVar);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Process.setThreadPriority(-19);
                try {
                    try {
                        this.f1381e.f1377b = new c(-100);
                        if (this.f1381e.f1377b.d() != null) {
                            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(c.f1473d);
                            this.f1381e.f1377b.c();
                            if (this.f1381e.f1377b.e() != 3) {
                                return;
                            }
                            while (!this.f1381e.a) {
                                allocateDirect.clear();
                                int a = this.f1381e.f1377b.a(allocateDirect, c.f1473d);
                                if (a > 0) {
                                    double a2 = c.a.b1.p.i.a.a(allocateDirect, a);
                                    if (this.f1381e.f1379d != null && a2 > 0.0d) {
                                        this.f1381e.f1379d.a(a2);
                                    }
                                }
                            }
                        } else if (this.f1381e.f1379d != null) {
                            this.f1381e.f1379d.a("failed to initialize AudioRecord", true);
                        }
                    } catch (Exception unused) {
                        if (this.f1381e.f1379d != null) {
                            this.f1381e.f1379d.a("failed to initialize AudioRecord", true);
                        }
                    }
                } finally {
                    this.f1381e.i();
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
            this.f1380e = true;
            this.a = false;
            b bVar = new b(this, null);
            this.f1378c = bVar;
            bVar.start();
        }
    }

    public void d(c.a.b1.p.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.f1379d = cVar;
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a = true;
            this.f1380e = false;
        }
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f1380e : invokeV.booleanValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.a = false;
            this.f1380e = false;
            c cVar = this.f1377b;
            if (cVar != null) {
                cVar.b();
            }
            if (this.f1378c != null) {
                this.f1378c = null;
            }
        }
    }
}
