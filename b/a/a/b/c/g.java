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
    public a f1024b;

    /* renamed from: c  reason: collision with root package name */
    public Executor f1025c;

    /* renamed from: d  reason: collision with root package name */
    public String f1026d;

    /* renamed from: e  reason: collision with root package name */
    public b.a.a.b.d f1027e;

    /* renamed from: f  reason: collision with root package name */
    public d.a f1028f;

    /* renamed from: g  reason: collision with root package name */
    public int f1029g;

    /* renamed from: h  reason: collision with root package name */
    public c f1030h;

    /* renamed from: i  reason: collision with root package name */
    public b.a.a.b.a.a f1031i;

    /* renamed from: j  reason: collision with root package name */
    public List<b.a.a.b.a.b> f1032j;

    public g(c.a.a.c.b bVar, a aVar, Executor executor, String str, b.a.a.b.d dVar, d.a aVar2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, aVar, executor, str, dVar, aVar2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = bVar;
        this.f1024b = aVar;
        this.f1025c = executor;
        this.f1026d = str;
        this.f1027e = dVar;
        this.f1028f = aVar2;
        this.f1030h = new c(bVar.b().toString(), this.a.c(), this.a.a());
        this.f1032j = new LinkedList();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c cVar = this.f1030h;
            File file = new File(cVar.f1018b, cVar.a);
            if (file.exists() && file.isFile()) {
                file.delete();
            }
        }
    }

    public void b(long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            a aVar = this.f1024b;
            aVar.f1013b.n(j2);
            aVar.f1013b.o(j3);
            aVar.f1013b.p((int) ((100 * j2) / j3));
            aVar.f1013b.r(104);
            aVar.a.a(aVar.f1013b);
        }
    }

    public void c(DownloadException downloadException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadException) == null) {
            if (((b) this.f1031i).d()) {
                e();
                return;
            }
            if (((b) this.f1031i).f1016g == 106) {
                h();
                return;
            }
            this.f1029g = 108;
            a aVar = this.f1024b;
            aVar.f1013b.m(downloadException);
            aVar.f1013b.r(108);
            aVar.a.a(aVar.f1013b);
            i();
        }
    }

    @Override // c.a.a.c.c.d
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            b.a.a.b.a.a aVar = this.f1031i;
            if (aVar != null) {
                ((b) aVar).f1016g = 107;
            }
            Iterator<b.a.a.b.a.b> it = this.f1032j.iterator();
            while (it.hasNext()) {
                ((i) it.next()).f1041j = 107;
            }
            if (this.f1029g != 104) {
                g();
            }
        }
    }

    public void d(String str) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            Iterator<b.a.a.b.a.b> it = this.f1032j.iterator();
            while (true) {
                z = false;
                boolean z2 = true;
                if (!it.hasNext()) {
                    z = true;
                    break;
                }
                if (((i) it.next()).f1040i != 105) {
                    z2 = false;
                    continue;
                }
                if (!z2) {
                    break;
                }
            }
            if (z) {
                this.f1029g = 105;
                a aVar = this.f1024b;
                aVar.f1013b.r(105);
                aVar.f1013b.q(str);
                aVar.a.a(aVar.f1013b);
                i();
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            a();
            this.f1029g = 107;
            a aVar = this.f1024b;
            aVar.f1013b.r(107);
            aVar.a.a(aVar.f1013b);
            i();
        }
    }

    public void f(DownloadException downloadException) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, downloadException) == null) {
            Iterator<b.a.a.b.a.b> it = this.f1032j.iterator();
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
                this.f1029g = 108;
                a aVar = this.f1024b;
                aVar.f1013b.m(downloadException);
                aVar.f1013b.r(108);
                aVar.a.a(aVar.f1013b);
                i();
            }
        }
    }

    public void g() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            Iterator<b.a.a.b.a.b> it = this.f1032j.iterator();
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
                this.f1029g = 107;
                a aVar = this.f1024b;
                aVar.f1013b.r(107);
                aVar.a.a(aVar.f1013b);
                i();
            }
        }
    }

    public void h() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            Iterator<b.a.a.b.a.b> it = this.f1032j.iterator();
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
                this.f1029g = 106;
                a aVar = this.f1024b;
                aVar.f1013b.r(106);
                aVar.a.a(aVar.f1013b);
                i();
            }
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f1028f.a(this.f1026d, this);
        }
    }

    @Override // c.a.a.c.c.d
    public boolean isRunning() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            int i2 = this.f1029g;
            return i2 == 101 || i2 == 102 || i2 == 103 || i2 == 104;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.a.c.c.d
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            b.a.a.b.a.a aVar = this.f1031i;
            if (aVar != null) {
                ((b) aVar).f1016g = 106;
            }
            Iterator<b.a.a.b.a.b> it = this.f1032j.iterator();
            while (it.hasNext()) {
                ((i) it.next()).f1041j = 106;
            }
            if (this.f1029g != 104) {
                h();
            }
        }
    }

    @Override // c.a.a.c.c.d
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f1029g = 101;
            a aVar = this.f1024b;
            aVar.f1013b.r(101);
            aVar.f1013b.a().h();
            b bVar = new b(this.a.c(), this);
            this.f1031i = bVar;
            this.f1025c.execute(bVar);
        }
    }
}
