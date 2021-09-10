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
/* loaded from: classes4.dex */
public abstract class g<I extends e, O extends f, E extends Exception> implements c<I, O, E> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Thread f34094a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f34095b;

    /* renamed from: c  reason: collision with root package name */
    public final LinkedList<I> f34096c;

    /* renamed from: d  reason: collision with root package name */
    public final LinkedList<O> f34097d;

    /* renamed from: e  reason: collision with root package name */
    public final I[] f34098e;

    /* renamed from: f  reason: collision with root package name */
    public final O[] f34099f;

    /* renamed from: g  reason: collision with root package name */
    public int f34100g;

    /* renamed from: h  reason: collision with root package name */
    public int f34101h;

    /* renamed from: i  reason: collision with root package name */
    public I f34102i;

    /* renamed from: j  reason: collision with root package name */
    public E f34103j;
    public boolean k;
    public boolean l;
    public int m;

    /* loaded from: classes4.dex */
    public class a extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f34104e;

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
            this.f34104e = gVar;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f34104e.s();
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
        this.f34095b = new Object();
        this.f34096c = new LinkedList<>();
        this.f34097d = new LinkedList<>();
        this.f34098e = iArr;
        this.f34100g = iArr.length;
        for (int i4 = 0; i4 < this.f34100g; i4++) {
            this.f34098e[i4] = g();
        }
        this.f34099f = oArr;
        this.f34101h = oArr.length;
        for (int i5 = 0; i5 < this.f34101h; i5++) {
            this.f34099f[i5] = h();
        }
        a aVar = new a(this);
        this.f34094a = aVar;
        aVar.start();
    }

    public final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? !this.f34096c.isEmpty() && this.f34101h > 0 : invokeV.booleanValue;
    }

    @Override // c.i.b.a.y.c
    public final void flush() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this.f34095b) {
                this.k = true;
                this.m = 0;
                if (this.f34102i != null) {
                    p(this.f34102i);
                    this.f34102i = null;
                }
                while (!this.f34096c.isEmpty()) {
                    p(this.f34096c.removeFirst());
                }
                while (!this.f34097d.isEmpty()) {
                    r(this.f34097d.removeFirst());
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
            synchronized (this.f34095b) {
                while (!this.l && !f()) {
                    this.f34095b.wait();
                }
                if (this.l) {
                    return false;
                }
                I removeFirst = this.f34096c.removeFirst();
                O[] oArr = this.f34099f;
                int i2 = this.f34101h - 1;
                this.f34101h = i2;
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
                    this.f34103j = i3;
                    if (i3 != null) {
                        synchronized (this.f34095b) {
                        }
                        return false;
                    }
                }
                synchronized (this.f34095b) {
                    if (this.k) {
                        r(o);
                    } else if (o.i()) {
                        this.m++;
                        r(o);
                    } else {
                        o.f34093g = this.m;
                        this.m = 0;
                        this.f34097d.addLast(o);
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
            synchronized (this.f34095b) {
                n();
                c.i.b.a.i0.a.f(this.f34102i == null);
                if (this.f34100g == 0) {
                    i2 = null;
                } else {
                    I[] iArr = this.f34098e;
                    int i3 = this.f34100g - 1;
                    this.f34100g = i3;
                    i2 = iArr[i3];
                }
                this.f34102i = i2;
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
            synchronized (this.f34095b) {
                n();
                if (this.f34097d.isEmpty()) {
                    return null;
                }
                return this.f34097d.removeFirst();
            }
        }
        return (O) invokeV.objValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && f()) {
            this.f34095b.notify();
        }
    }

    public final void n() throws Exception {
        E e2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (e2 = this.f34103j) != null) {
            throw e2;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.i.b.a.y.c
    /* renamed from: o */
    public final void d(I i2) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, i2) == null) {
            synchronized (this.f34095b) {
                n();
                c.i.b.a.i0.a.a(i2 == this.f34102i);
                this.f34096c.addLast(i2);
                m();
                this.f34102i = null;
            }
        }
    }

    public final void p(I i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, i2) == null) {
            i2.f();
            I[] iArr = this.f34098e;
            int i3 = this.f34100g;
            this.f34100g = i3 + 1;
            iArr[i3] = i2;
        }
    }

    public void q(O o) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, o) == null) {
            synchronized (this.f34095b) {
                r(o);
                m();
            }
        }
    }

    public final void r(O o) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, o) == null) {
            o.f();
            O[] oArr = this.f34099f;
            int i2 = this.f34101h;
            this.f34101h = i2 + 1;
            oArr[i2] = o;
        }
    }

    @Override // c.i.b.a.y.c
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            synchronized (this.f34095b) {
                this.l = true;
                this.f34095b.notify();
            }
            try {
                this.f34094a.join();
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
            c.i.b.a.i0.a.f(this.f34100g == this.f34098e.length);
            for (I i3 : this.f34098e) {
                i3.n(i2);
            }
        }
    }
}
