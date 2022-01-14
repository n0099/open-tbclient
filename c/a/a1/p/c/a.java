package c.a.a1.p.c;

import android.os.Process;
import c.a.a1.p.f.c;
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
    public c f1343b;

    /* renamed from: c  reason: collision with root package name */
    public b f1344c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.a1.p.g.c f1345d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1346e;

    /* renamed from: c.a.a1.p.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0020a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public class b extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f1347e;

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
            this.f1347e = aVar;
        }

        public /* synthetic */ b(a aVar, C0020a c0020a) {
            this(aVar);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Process.setThreadPriority(-19);
                try {
                    try {
                        this.f1347e.f1343b = new c(-100);
                        if (this.f1347e.f1343b.d() != null) {
                            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(c.f1439d);
                            this.f1347e.f1343b.c();
                            if (this.f1347e.f1343b.e() != 3) {
                                return;
                            }
                            while (!this.f1347e.a) {
                                allocateDirect.clear();
                                int a = this.f1347e.f1343b.a(allocateDirect, c.f1439d);
                                if (a > 0) {
                                    double a2 = c.a.a1.p.i.a.a(allocateDirect, a);
                                    if (this.f1347e.f1345d != null && a2 > 0.0d) {
                                        this.f1347e.f1345d.a(a2);
                                    }
                                }
                            }
                        } else if (this.f1347e.f1345d != null) {
                            this.f1347e.f1345d.a("failed to initialize AudioRecord", true);
                        }
                    } catch (Exception unused) {
                        if (this.f1347e.f1345d != null) {
                            this.f1347e.f1345d.a("failed to initialize AudioRecord", true);
                        }
                    }
                } finally {
                    this.f1347e.i();
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
            this.f1346e = true;
            this.a = false;
            b bVar = new b(this, null);
            this.f1344c = bVar;
            bVar.start();
        }
    }

    public void d(c.a.a1.p.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.f1345d = cVar;
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a = true;
            this.f1346e = false;
        }
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f1346e : invokeV.booleanValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.a = false;
            this.f1346e = false;
            c cVar = this.f1343b;
            if (cVar != null) {
                cVar.b();
            }
            if (this.f1344c != null) {
                this.f1344c = null;
            }
        }
    }
}
