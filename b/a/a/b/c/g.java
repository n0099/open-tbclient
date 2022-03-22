package b.a.a.b.c;

import androidx.core.view.InputDeviceCompat;
import b.a.a.b.a.a;
import b.a.a.b.a.b;
import c.a.a.c.c.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cloudbase.download.exception.DownloadException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public class g implements c.a.a.c.c.d, a.InterfaceC0004a, b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.a.c.b a;

    /* renamed from: b  reason: collision with root package name */
    public a f999b;

    /* renamed from: c  reason: collision with root package name */
    public Executor f1000c;

    /* renamed from: d  reason: collision with root package name */
    public String f1001d;

    /* renamed from: e  reason: collision with root package name */
    public b.a.a.b.d f1002e;

    /* renamed from: f  reason: collision with root package name */
    public d.a f1003f;

    /* renamed from: g  reason: collision with root package name */
    public int f1004g;

    /* renamed from: h  reason: collision with root package name */
    public c f1005h;
    public b.a.a.b.a.a i;
    public List<b.a.a.b.a.b> j;

    public g(c.a.a.c.b bVar, a aVar, Executor executor, String str, b.a.a.b.d dVar, d.a aVar2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, aVar, executor, str, dVar, aVar2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = bVar;
        this.f999b = aVar;
        this.f1000c = executor;
        this.f1001d = str;
        this.f1002e = dVar;
        this.f1003f = aVar2;
        this.f1005h = new c(bVar.b().toString(), this.a.c(), this.a.a());
        this.j = new LinkedList();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c cVar = this.f1005h;
            File file = new File(cVar.f993b, cVar.a);
            if (file.exists() && file.isFile()) {
                file.delete();
            }
        }
    }

    public void b(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            a aVar = this.f999b;
            aVar.f989b.n(j);
            aVar.f989b.o(j2);
            aVar.f989b.p((int) ((100 * j) / j2));
            aVar.f989b.r(104);
            aVar.a.a(aVar.f989b);
        }
    }

    public void c(DownloadException downloadException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadException) == null) {
            if (((b) this.i).d()) {
                e();
                return;
            }
            if (((b) this.i).f991c == 106) {
                h();
                return;
            }
            this.f1004g = 108;
            a aVar = this.f999b;
            aVar.f989b.m(downloadException);
            aVar.f989b.r(108);
            aVar.a.a(aVar.f989b);
            i();
        }
    }

    @Override // c.a.a.c.c.d
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            b.a.a.b.a.a aVar = this.i;
            if (aVar != null) {
                ((b) aVar).f991c = 107;
            }
            Iterator<b.a.a.b.a.b> it = this.j.iterator();
            while (it.hasNext()) {
                ((i) it.next()).f1011f = 107;
            }
            if (this.f1004g != 104) {
                g();
            }
        }
    }

    public void d(String str) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            Iterator<b.a.a.b.a.b> it = this.j.iterator();
            while (true) {
                z = false;
                boolean z2 = true;
                if (!it.hasNext()) {
                    z = true;
                    break;
                }
                if (((i) it.next()).f1010e != 105) {
                    z2 = false;
                    continue;
                }
                if (!z2) {
                    break;
                }
            }
            if (z) {
                this.f1004g = 105;
                a aVar = this.f999b;
                aVar.f989b.r(105);
                aVar.f989b.q(str);
                aVar.a.a(aVar.f989b);
                i();
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            a();
            this.f1004g = 107;
            a aVar = this.f999b;
            aVar.f989b.r(107);
            aVar.a.a(aVar.f989b);
            i();
        }
    }

    public void f(DownloadException downloadException) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, downloadException) == null) {
            Iterator<b.a.a.b.a.b> it = this.j.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                } else if (((i) it.next()).m()) {
                    z = false;
                    break;
                }
            }
            if (z) {
                this.f1004g = 108;
                a aVar = this.f999b;
                aVar.f989b.m(downloadException);
                aVar.f989b.r(108);
                aVar.a.a(aVar.f989b);
                i();
            }
        }
    }

    public void g() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            Iterator<b.a.a.b.a.b> it = this.j.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                } else if (((i) it.next()).m()) {
                    z = false;
                    break;
                }
            }
            if (z) {
                a();
                this.f1004g = 107;
                a aVar = this.f999b;
                aVar.f989b.r(107);
                aVar.a.a(aVar.f989b);
                i();
            }
        }
    }

    public void h() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            Iterator<b.a.a.b.a.b> it = this.j.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                } else if (((i) it.next()).m()) {
                    z = false;
                    break;
                }
            }
            if (z) {
                this.f1004g = 106;
                a aVar = this.f999b;
                aVar.f989b.r(106);
                aVar.a.a(aVar.f989b);
                i();
            }
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f1003f.a(this.f1001d, this);
        }
    }

    @Override // c.a.a.c.c.d
    public boolean isRunning() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            int i = this.f1004g;
            return i == 101 || i == 102 || i == 103 || i == 104;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.a.c.c.d
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            b.a.a.b.a.a aVar = this.i;
            if (aVar != null) {
                ((b) aVar).f991c = 106;
            }
            Iterator<b.a.a.b.a.b> it = this.j.iterator();
            while (it.hasNext()) {
                ((i) it.next()).f1011f = 106;
            }
            if (this.f1004g != 104) {
                h();
            }
        }
    }

    @Override // c.a.a.c.c.d
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f1004g = 101;
            a aVar = this.f999b;
            aVar.f989b.r(101);
            aVar.f989b.a().h();
            b bVar = new b(this.a.c(), this);
            this.i = bVar;
            this.f1000c.execute(bVar);
        }
    }
}
