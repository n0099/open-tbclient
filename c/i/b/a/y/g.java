package c.i.b.a.y;

import androidx.core.view.InputDeviceCompat;
import c.i.b.a.y.e;
import c.i.b.a.y.f;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.Exception;
import java.util.LinkedList;
/* loaded from: classes9.dex */
public abstract class g<I extends e, O extends f, E extends Exception> implements c<I, O, E> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Thread a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f30931b;

    /* renamed from: c  reason: collision with root package name */
    public final LinkedList<I> f30932c;

    /* renamed from: d  reason: collision with root package name */
    public final LinkedList<O> f30933d;

    /* renamed from: e  reason: collision with root package name */
    public final I[] f30934e;

    /* renamed from: f  reason: collision with root package name */
    public final O[] f30935f;

    /* renamed from: g  reason: collision with root package name */
    public int f30936g;

    /* renamed from: h  reason: collision with root package name */
    public int f30937h;

    /* renamed from: i  reason: collision with root package name */
    public I f30938i;

    /* renamed from: j  reason: collision with root package name */
    public E f30939j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f30940k;
    public boolean l;
    public int m;

    /* loaded from: classes9.dex */
    public class a extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f30941e;

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30941e = gVar;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f30941e.s();
            }
        }
    }

    public g(I[] iArr, O[] oArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iArr, oArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f30931b = new Object();
        this.f30932c = new LinkedList<>();
        this.f30933d = new LinkedList<>();
        this.f30934e = iArr;
        this.f30936g = iArr.length;
        for (int i4 = 0; i4 < this.f30936g; i4++) {
            this.f30934e[i4] = g();
        }
        this.f30935f = oArr;
        this.f30937h = oArr.length;
        for (int i5 = 0; i5 < this.f30937h; i5++) {
            this.f30935f[i5] = h();
        }
        a aVar = new a(this);
        this.a = aVar;
        aVar.start();
    }

    public final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? !this.f30932c.isEmpty() && this.f30937h > 0 : invokeV.booleanValue;
    }

    @Override // c.i.b.a.y.c
    public final void flush() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this.f30931b) {
                this.f30940k = true;
                this.m = 0;
                if (this.f30938i != null) {
                    p(this.f30938i);
                    this.f30938i = null;
                }
                while (!this.f30932c.isEmpty()) {
                    p(this.f30932c.removeFirst());
                }
                while (!this.f30933d.isEmpty()) {
                    r(this.f30933d.removeFirst());
                }
            }
        }
    }

    public abstract I g();

    public abstract O h();

    public abstract E i(I i2, O o, boolean z);

    public final boolean j() throws InterruptedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            synchronized (this.f30931b) {
                while (!this.l && !f()) {
                    this.f30931b.wait();
                }
                if (this.l) {
                    return false;
                }
                I removeFirst = this.f30932c.removeFirst();
                O[] oArr = this.f30935f;
                int i2 = this.f30937h - 1;
                this.f30937h = i2;
                O o = oArr[i2];
                boolean z = this.f30940k;
                this.f30940k = false;
                if (removeFirst.j()) {
                    o.e(4);
                } else {
                    if (removeFirst.i()) {
                        o.e(Integer.MIN_VALUE);
                    }
                    E i3 = i(removeFirst, o, z);
                    this.f30939j = i3;
                    if (i3 != null) {
                        synchronized (this.f30931b) {
                        }
                        return false;
                    }
                }
                synchronized (this.f30931b) {
                    if (this.f30940k) {
                        r(o);
                    } else if (o.i()) {
                        this.m++;
                        r(o);
                    } else {
                        o.f30930g = this.m;
                        this.m = 0;
                        this.f30933d.addLast(o);
                    }
                    p(removeFirst);
                }
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.i.b.a.y.c
    /* renamed from: k */
    public final I a() throws Exception {
        InterceptResult invokeV;
        I i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            synchronized (this.f30931b) {
                n();
                c.i.b.a.i0.a.f(this.f30938i == null);
                if (this.f30936g == 0) {
                    i2 = null;
                } else {
                    I[] iArr = this.f30934e;
                    int i3 = this.f30936g - 1;
                    this.f30936g = i3;
                    i2 = iArr[i3];
                }
                this.f30938i = i2;
            }
            return i2;
        }
        return (I) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.i.b.a.y.c
    /* renamed from: l */
    public final O c() throws Exception {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            synchronized (this.f30931b) {
                n();
                if (this.f30933d.isEmpty()) {
                    return null;
                }
                return this.f30933d.removeFirst();
            }
        }
        return (O) invokeV.objValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && f()) {
            this.f30931b.notify();
        }
    }

    public final void n() throws Exception {
        E e2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (e2 = this.f30939j) != null) {
            throw e2;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.i.b.a.y.c
    /* renamed from: o */
    public final void d(I i2) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, i2) == null) {
            synchronized (this.f30931b) {
                n();
                c.i.b.a.i0.a.a(i2 == this.f30938i);
                this.f30932c.addLast(i2);
                m();
                this.f30938i = null;
            }
        }
    }

    public final void p(I i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, i2) == null) {
            i2.f();
            I[] iArr = this.f30934e;
            int i3 = this.f30936g;
            this.f30936g = i3 + 1;
            iArr[i3] = i2;
        }
    }

    public void q(O o) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, o) == null) {
            synchronized (this.f30931b) {
                r(o);
                m();
            }
        }
    }

    public final void r(O o) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, o) == null) {
            o.f();
            O[] oArr = this.f30935f;
            int i2 = this.f30937h;
            this.f30937h = i2 + 1;
            oArr[i2] = o;
        }
    }

    @Override // c.i.b.a.y.c
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            synchronized (this.f30931b) {
                this.l = true;
                this.f30931b.notify();
            }
            try {
                this.a.join();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            do {
                try {
                } catch (InterruptedException e2) {
                    throw new IllegalStateException(e2);
                }
            } while (j());
        }
    }

    public final void t(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            c.i.b.a.i0.a.f(this.f30936g == this.f30934e.length);
            for (I i3 : this.f30934e) {
                i3.n(i2);
            }
        }
    }
}
