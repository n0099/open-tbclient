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
    public final InputStream f35174a;

    /* renamed from: b  reason: collision with root package name */
    public final int f35175b;

    /* renamed from: c  reason: collision with root package name */
    public final int f35176c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f35177d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f35178e;

    /* renamed from: f  reason: collision with root package name */
    public c.p.a.e.b.i.a f35179f;

    /* renamed from: g  reason: collision with root package name */
    public c.p.a.e.b.i.a f35180g;

    /* renamed from: h  reason: collision with root package name */
    public c.p.a.e.b.i.a f35181h;

    /* renamed from: i  reason: collision with root package name */
    public c.p.a.e.b.i.a f35182i;

    /* renamed from: j  reason: collision with root package name */
    public c.p.a.e.b.i.a f35183j;
    public c.p.a.e.b.i.a k;
    public volatile boolean l;
    public volatile boolean m;
    public volatile Throwable n;
    public volatile Future o;
    public int p;
    public final Runnable q;

    /* renamed from: c.p.a.e.b.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC1550a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f35184e;

        public RunnableC1550a(a aVar) {
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
            this.f35184e = aVar;
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
                        k = this.f35184e.k();
                        k.f35189c = this.f35184e.f35174a.read(k.f35187a);
                        this.f35184e.j(k);
                    } catch (Throwable th) {
                        try {
                            this.f35184e.n = th;
                            th.printStackTrace();
                            synchronized (this.f35184e.f35178e) {
                                this.f35184e.m = true;
                                this.f35184e.f35178e.notify();
                                f.E(this.f35184e.f35174a);
                                return;
                            }
                        } catch (Throwable th2) {
                            synchronized (this.f35184e.f35178e) {
                                this.f35184e.m = true;
                                this.f35184e.f35178e.notify();
                                f.E(this.f35184e.f35174a);
                                throw th2;
                            }
                        }
                    }
                } while (k.f35189c != -1);
                synchronized (this.f35184e.f35178e) {
                    this.f35184e.m = true;
                    this.f35184e.f35178e.notify();
                }
                f.E(this.f35184e.f35174a);
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
        this.f35177d = new Object();
        this.f35178e = new Object();
        this.q = new RunnableC1550a(this);
        this.f35174a = inputStream;
        this.f35175b = i2;
        if (i3 < 1) {
            i3 = 1;
        } else if (i3 > 64) {
            i3 = 64;
        }
        this.f35176c = i3;
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
            synchronized (this.f35177d) {
                c.p.a.e.b.i.a aVar2 = this.f35180g;
                if (aVar2 == null) {
                    this.f35180g = aVar;
                    this.f35179f = aVar;
                    this.f35177d.notify();
                } else {
                    aVar2.f35190d = aVar;
                    this.f35180g = aVar;
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
            synchronized (this.f35178e) {
                c.p.a.e.b.i.a aVar2 = this.f35183j;
                if (aVar2 == null) {
                    this.f35183j = aVar;
                    this.f35182i = aVar;
                    this.f35178e.notify();
                } else {
                    aVar2.f35190d = aVar;
                    this.f35183j = aVar;
                }
            }
        }
    }

    public final c.p.a.e.b.i.a k() throws p, InterruptedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            c.p.a.e.b.i.a aVar = this.f35181h;
            if (aVar != null) {
                if (!this.l) {
                    this.f35181h = aVar.f35190d;
                    aVar.f35190d = null;
                    return aVar;
                }
                throw new p("");
            }
            synchronized (this.f35177d) {
                if (!this.l) {
                    c.p.a.e.b.i.a aVar2 = this.f35179f;
                    if (aVar2 == null && this.p < this.f35176c) {
                        this.p++;
                        return new c.p.a.e.b.i.a(this.f35175b);
                    }
                    while (aVar2 == null) {
                        this.f35177d.wait();
                        if (!this.l) {
                            aVar2 = this.f35179f;
                        } else {
                            throw new p("");
                        }
                    }
                    this.f35181h = aVar2.f35190d;
                    this.f35180g = null;
                    this.f35179f = null;
                    aVar2.f35190d = null;
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
                this.k = aVar2.f35190d;
                aVar2.f35190d = null;
                return aVar2;
            }
            synchronized (this.f35178e) {
                aVar = this.f35182i;
                if (aVar == null) {
                    while (!this.m) {
                        this.f35178e.wait();
                        aVar = this.f35182i;
                        if (aVar != null) {
                        }
                    }
                    m();
                    throw null;
                }
                this.k = aVar.f35190d;
                this.f35183j = null;
                this.f35182i = null;
                aVar.f35190d = null;
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
            synchronized (this.f35177d) {
                this.l = true;
                this.f35177d.notify();
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
