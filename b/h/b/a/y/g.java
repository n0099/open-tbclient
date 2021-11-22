package b.h.b.a.y;

import androidx.core.view.InputDeviceCompat;
import b.h.b.a.y.e;
import b.h.b.a.y.f;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.Exception;
import java.util.LinkedList;
/* loaded from: classes6.dex */
public abstract class g<I extends e, O extends f, E extends Exception> implements c<I, O, E> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Thread f33764a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f33765b;

    /* renamed from: c  reason: collision with root package name */
    public final LinkedList<I> f33766c;

    /* renamed from: d  reason: collision with root package name */
    public final LinkedList<O> f33767d;

    /* renamed from: e  reason: collision with root package name */
    public final I[] f33768e;

    /* renamed from: f  reason: collision with root package name */
    public final O[] f33769f;

    /* renamed from: g  reason: collision with root package name */
    public int f33770g;

    /* renamed from: h  reason: collision with root package name */
    public int f33771h;

    /* renamed from: i  reason: collision with root package name */
    public I f33772i;
    public E j;
    public boolean k;
    public boolean l;
    public int m;

    /* loaded from: classes6.dex */
    public class a extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f33773e;

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
            this.f33773e = gVar;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f33773e.s();
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
        this.f33765b = new Object();
        this.f33766c = new LinkedList<>();
        this.f33767d = new LinkedList<>();
        this.f33768e = iArr;
        this.f33770g = iArr.length;
        for (int i4 = 0; i4 < this.f33770g; i4++) {
            this.f33768e[i4] = g();
        }
        this.f33769f = oArr;
        this.f33771h = oArr.length;
        for (int i5 = 0; i5 < this.f33771h; i5++) {
            this.f33769f[i5] = h();
        }
        a aVar = new a(this);
        this.f33764a = aVar;
        aVar.start();
    }

    public final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? !this.f33766c.isEmpty() && this.f33771h > 0 : invokeV.booleanValue;
    }

    @Override // b.h.b.a.y.c
    public final void flush() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this.f33765b) {
                this.k = true;
                this.m = 0;
                if (this.f33772i != null) {
                    p(this.f33772i);
                    this.f33772i = null;
                }
                while (!this.f33766c.isEmpty()) {
                    p(this.f33766c.removeFirst());
                }
                while (!this.f33767d.isEmpty()) {
                    r(this.f33767d.removeFirst());
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
            synchronized (this.f33765b) {
                while (!this.l && !f()) {
                    this.f33765b.wait();
                }
                if (this.l) {
                    return false;
                }
                I removeFirst = this.f33766c.removeFirst();
                O[] oArr = this.f33769f;
                int i2 = this.f33771h - 1;
                this.f33771h = i2;
                O o = oArr[i2];
                boolean z = this.k;
                this.k = false;
                if (removeFirst.j()) {
                    o.e(4);
                } else {
                    if (removeFirst.i()) {
                        o.e(Integer.MIN_VALUE);
                    }
                    E i3 = i(removeFirst, o, z);
                    this.j = i3;
                    if (i3 != null) {
                        synchronized (this.f33765b) {
                        }
                        return false;
                    }
                }
                synchronized (this.f33765b) {
                    if (this.k) {
                        r(o);
                    } else if (o.i()) {
                        this.m++;
                        r(o);
                    } else {
                        o.f33763g = this.m;
                        this.m = 0;
                        this.f33767d.addLast(o);
                    }
                    p(removeFirst);
                }
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.h.b.a.y.c
    /* renamed from: k */
    public final I a() throws Exception {
        InterceptResult invokeV;
        I i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            synchronized (this.f33765b) {
                n();
                b.h.b.a.i0.a.f(this.f33772i == null);
                if (this.f33770g == 0) {
                    i2 = null;
                } else {
                    I[] iArr = this.f33768e;
                    int i3 = this.f33770g - 1;
                    this.f33770g = i3;
                    i2 = iArr[i3];
                }
                this.f33772i = i2;
            }
            return i2;
        }
        return (I) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.h.b.a.y.c
    /* renamed from: l */
    public final O c() throws Exception {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            synchronized (this.f33765b) {
                n();
                if (this.f33767d.isEmpty()) {
                    return null;
                }
                return this.f33767d.removeFirst();
            }
        }
        return (O) invokeV.objValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && f()) {
            this.f33765b.notify();
        }
    }

    public final void n() throws Exception {
        E e2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (e2 = this.j) != null) {
            throw e2;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.h.b.a.y.c
    /* renamed from: o */
    public final void d(I i2) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, i2) == null) {
            synchronized (this.f33765b) {
                n();
                b.h.b.a.i0.a.a(i2 == this.f33772i);
                this.f33766c.addLast(i2);
                m();
                this.f33772i = null;
            }
        }
    }

    public final void p(I i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, i2) == null) {
            i2.f();
            I[] iArr = this.f33768e;
            int i3 = this.f33770g;
            this.f33770g = i3 + 1;
            iArr[i3] = i2;
        }
    }

    public void q(O o) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, o) == null) {
            synchronized (this.f33765b) {
                r(o);
                m();
            }
        }
    }

    public final void r(O o) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, o) == null) {
            o.f();
            O[] oArr = this.f33769f;
            int i2 = this.f33771h;
            this.f33771h = i2 + 1;
            oArr[i2] = o;
        }
    }

    @Override // b.h.b.a.y.c
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            synchronized (this.f33765b) {
                this.l = true;
                this.f33765b.notify();
            }
            try {
                this.f33764a.join();
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
            b.h.b.a.i0.a.f(this.f33770g == this.f33768e.length);
            for (I i3 : this.f33768e) {
                i3.n(i2);
            }
        }
    }
}
