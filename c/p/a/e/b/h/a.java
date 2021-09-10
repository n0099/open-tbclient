package c.p.a.e.b.h;

import android.os.Process;
import androidx.core.view.InputDeviceCompat;
import c.p.a.e.b.g.e;
import c.p.a.e.b.l.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.f.p;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.RevenueServerConst;
import java.io.InputStream;
import java.util.concurrent.Future;
/* loaded from: classes4.dex */
public class a implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final InputStream f35147a;

    /* renamed from: b  reason: collision with root package name */
    public final int f35148b;

    /* renamed from: c  reason: collision with root package name */
    public final int f35149c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f35150d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f35151e;

    /* renamed from: f  reason: collision with root package name */
    public c.p.a.e.b.i.a f35152f;

    /* renamed from: g  reason: collision with root package name */
    public c.p.a.e.b.i.a f35153g;

    /* renamed from: h  reason: collision with root package name */
    public c.p.a.e.b.i.a f35154h;

    /* renamed from: i  reason: collision with root package name */
    public c.p.a.e.b.i.a f35155i;

    /* renamed from: j  reason: collision with root package name */
    public c.p.a.e.b.i.a f35156j;
    public c.p.a.e.b.i.a k;
    public volatile boolean l;
    public volatile boolean m;
    public volatile Throwable n;
    public volatile Future o;
    public int p;
    public final Runnable q;

    /* renamed from: c.p.a.e.b.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC1549a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f35157e;

        public RunnableC1549a(a aVar) {
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
            this.f35157e = aVar;
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 3, expect 1 */
        @Override // java.lang.Runnable
        public void run() {
            c.p.a.e.b.i.a k;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Process.setThreadPriority(10);
                do {
                    try {
                        k = this.f35157e.k();
                        k.f35162c = this.f35157e.f35147a.read(k.f35160a);
                        this.f35157e.j(k);
                    } catch (Throwable th) {
                        try {
                            this.f35157e.n = th;
                            th.printStackTrace();
                            synchronized (this.f35157e.f35151e) {
                                this.f35157e.m = true;
                                this.f35157e.f35151e.notify();
                                f.E(this.f35157e.f35147a);
                                return;
                            }
                        } catch (Throwable th2) {
                            synchronized (this.f35157e.f35151e) {
                                this.f35157e.m = true;
                                this.f35157e.f35151e.notify();
                                f.E(this.f35157e.f35147a);
                                throw th2;
                            }
                        }
                    }
                } while (k.f35162c != -1);
                synchronized (this.f35157e.f35151e) {
                    this.f35157e.m = true;
                    this.f35157e.f35151e.notify();
                }
                f.E(this.f35157e.f35147a);
            }
        }
    }

    public a(InputStream inputStream, int i2, int i3) throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f35150d = new Object();
        this.f35151e = new Object();
        this.q = new RunnableC1549a(this);
        this.f35147a = inputStream;
        this.f35148b = i2;
        if (i3 < 1) {
            i3 = 1;
        } else if (i3 > 64) {
            i3 = 64;
        }
        this.f35149c = i3;
        i();
    }

    @Override // c.p.a.e.b.h.b
    public c.p.a.e.b.i.a a() throws BaseException, InterruptedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? l() : (c.p.a.e.b.i.a) invokeV.objValue;
    }

    public final void g(c.p.a.e.b.i.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            synchronized (this.f35150d) {
                c.p.a.e.b.i.a aVar2 = this.f35153g;
                if (aVar2 == null) {
                    this.f35153g = aVar;
                    this.f35152f = aVar;
                    this.f35150d.notify();
                } else {
                    aVar2.f35163d = aVar;
                    this.f35153g = aVar;
                }
            }
        }
    }

    public final void i() throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.o = e.F0().submit(this.q);
        }
    }

    public final void j(c.p.a.e.b.i.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            synchronized (this.f35151e) {
                c.p.a.e.b.i.a aVar2 = this.f35156j;
                if (aVar2 == null) {
                    this.f35156j = aVar;
                    this.f35155i = aVar;
                    this.f35151e.notify();
                } else {
                    aVar2.f35163d = aVar;
                    this.f35156j = aVar;
                }
            }
        }
    }

    public final c.p.a.e.b.i.a k() throws p, InterruptedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            c.p.a.e.b.i.a aVar = this.f35154h;
            if (aVar != null) {
                if (!this.l) {
                    this.f35154h = aVar.f35163d;
                    aVar.f35163d = null;
                    return aVar;
                }
                throw new p("");
            }
            synchronized (this.f35150d) {
                if (!this.l) {
                    c.p.a.e.b.i.a aVar2 = this.f35152f;
                    if (aVar2 == null && this.p < this.f35149c) {
                        this.p++;
                        return new c.p.a.e.b.i.a(this.f35148b);
                    }
                    while (aVar2 == null) {
                        this.f35150d.wait();
                        if (!this.l) {
                            aVar2 = this.f35152f;
                        } else {
                            throw new p("");
                        }
                    }
                    this.f35154h = aVar2.f35163d;
                    this.f35153g = null;
                    this.f35152f = null;
                    aVar2.f35163d = null;
                    return aVar2;
                }
                throw new p("");
            }
        }
        return (c.p.a.e.b.i.a) invokeV.objValue;
    }

    public final c.p.a.e.b.i.a l() throws BaseException, InterruptedException {
        InterceptResult invokeV;
        c.p.a.e.b.i.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            c.p.a.e.b.i.a aVar2 = this.k;
            if (aVar2 != null) {
                this.k = aVar2.f35163d;
                aVar2.f35163d = null;
                return aVar2;
            }
            synchronized (this.f35151e) {
                aVar = this.f35155i;
                if (aVar == null) {
                    while (!this.m) {
                        this.f35151e.wait();
                        aVar = this.f35155i;
                        if (aVar != null) {
                        }
                    }
                    m();
                    throw null;
                }
                this.k = aVar.f35163d;
                this.f35156j = null;
                this.f35155i = null;
                aVar.f35163d = null;
            }
            return aVar;
        }
        return (c.p.a.e.b.i.a) invokeV.objValue;
    }

    public final void m() throws BaseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            Throwable th = this.n;
            if (th != null) {
                if (th instanceof p) {
                    throw new BaseException((int) RevenueServerConst.GetUserYbDetailsRequest, "async reader closed!");
                }
                f.B(th, "async_read");
                throw null;
            }
            throw new BaseException(1069, "async reader terminated!");
        }
    }

    @Override // c.p.a.e.b.h.b
    public void a(c.p.a.e.b.i.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            g(aVar);
        }
    }

    @Override // c.p.a.e.b.h.b
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this.f35150d) {
                this.l = true;
                this.f35150d.notify();
            }
            Future future = this.o;
            if (future != null) {
                try {
                    future.cancel(true);
                } catch (Throwable unused) {
                }
                this.o = null;
            }
        }
    }
}
