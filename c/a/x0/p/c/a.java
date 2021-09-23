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
    public volatile boolean f31022a;

    /* renamed from: b  reason: collision with root package name */
    public c f31023b;

    /* renamed from: c  reason: collision with root package name */
    public b f31024c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.x0.p.g.c f31025d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f31026e;

    /* renamed from: c.a.x0.p.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class C1427a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public class b extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f31027e;

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
            this.f31027e = aVar;
        }

        public /* synthetic */ b(a aVar, C1427a c1427a) {
            this(aVar);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Process.setThreadPriority(-19);
                try {
                    try {
                        this.f31027e.f31023b = new c(-100);
                        if (this.f31027e.f31023b.d() != null) {
                            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(c.f31134d);
                            this.f31027e.f31023b.c();
                            if (this.f31027e.f31023b.e() != 3) {
                                return;
                            }
                            while (!this.f31027e.f31022a) {
                                allocateDirect.clear();
                                int a2 = this.f31027e.f31023b.a(allocateDirect, c.f31134d);
                                if (a2 > 0) {
                                    double a3 = c.a.x0.p.i.a.a(allocateDirect, a2);
                                    if (this.f31027e.f31025d != null && a3 > 0.0d) {
                                        this.f31027e.f31025d.a(a3);
                                    }
                                }
                            }
                        } else if (this.f31027e.f31025d != null) {
                            this.f31027e.f31025d.a("failed to initialize AudioRecord", true);
                        }
                    } catch (Exception unused) {
                        if (this.f31027e.f31025d != null) {
                            this.f31027e.f31025d.a("failed to initialize AudioRecord", true);
                        }
                    }
                } finally {
                    this.f31027e.i();
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
        this.f31022a = false;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f31026e = true;
            this.f31022a = false;
            b bVar = new b(this, null);
            this.f31024c = bVar;
            bVar.start();
        }
    }

    public void d(c.a.x0.p.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.f31025d = cVar;
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f31022a = true;
            this.f31026e = false;
        }
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f31026e : invokeV.booleanValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f31022a = false;
            this.f31026e = false;
            c cVar = this.f31023b;
            if (cVar != null) {
                cVar.b();
            }
            if (this.f31024c != null) {
                this.f31024c = null;
            }
        }
    }
}
