package c.i.b.a.h0;

import c.i.b.a.i0.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes4.dex */
public final class h implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final boolean f33494a;

    /* renamed from: b  reason: collision with root package name */
    public final int f33495b;

    /* renamed from: c  reason: collision with root package name */
    public final byte[] f33496c;

    /* renamed from: d  reason: collision with root package name */
    public final a[] f33497d;

    /* renamed from: e  reason: collision with root package name */
    public int f33498e;

    /* renamed from: f  reason: collision with root package name */
    public int f33499f;

    /* renamed from: g  reason: collision with root package name */
    public int f33500g;

    /* renamed from: h  reason: collision with root package name */
    public a[] f33501h;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public h(boolean z, int i2) {
        this(z, i2, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Boolean) objArr2[0]).booleanValue(), ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.i.b.a.h0.b
    public synchronized void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            synchronized (this) {
                this.f33497d[0] = aVar;
                d(this.f33497d);
            }
        }
    }

    @Override // c.i.b.a.h0.b
    public synchronized void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                int i2 = 0;
                int max = Math.max(0, v.f(this.f33498e, this.f33495b) - this.f33499f);
                if (max >= this.f33500g) {
                    return;
                }
                if (this.f33496c != null) {
                    int i3 = this.f33500g - 1;
                    while (i2 <= i3) {
                        a aVar = this.f33501h[i2];
                        if (aVar.f33476a == this.f33496c) {
                            i2++;
                        } else {
                            a aVar2 = this.f33501h[i3];
                            if (aVar2.f33476a != this.f33496c) {
                                i3--;
                            } else {
                                this.f33501h[i2] = aVar2;
                                this.f33501h[i3] = aVar;
                                i3--;
                                i2++;
                            }
                        }
                    }
                    max = Math.max(max, i2);
                    if (max >= this.f33500g) {
                        return;
                    }
                }
                Arrays.fill(this.f33501h, max, this.f33500g, (Object) null);
                this.f33500g = max;
            }
        }
    }

    @Override // c.i.b.a.h0.b
    public synchronized a c() {
        InterceptResult invokeV;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                this.f33499f++;
                if (this.f33500g > 0) {
                    a[] aVarArr = this.f33501h;
                    int i2 = this.f33500g - 1;
                    this.f33500g = i2;
                    aVar = aVarArr[i2];
                    this.f33501h[i2] = null;
                } else {
                    aVar = new a(new byte[this.f33495b], 0);
                }
            }
            return aVar;
        }
        return (a) invokeV.objValue;
    }

    @Override // c.i.b.a.h0.b
    public synchronized void d(a[] aVarArr) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVarArr) == null) {
            synchronized (this) {
                if (this.f33500g + aVarArr.length >= this.f33501h.length) {
                    this.f33501h = (a[]) Arrays.copyOf(this.f33501h, Math.max(this.f33501h.length * 2, this.f33500g + aVarArr.length));
                }
                for (a aVar : aVarArr) {
                    if (aVar.f33476a != this.f33496c && aVar.f33476a.length != this.f33495b) {
                        z = false;
                        c.i.b.a.i0.a.a(z);
                        a[] aVarArr2 = this.f33501h;
                        int i2 = this.f33500g;
                        this.f33500g = i2 + 1;
                        aVarArr2[i2] = aVar;
                    }
                    z = true;
                    c.i.b.a.i0.a.a(z);
                    a[] aVarArr22 = this.f33501h;
                    int i22 = this.f33500g;
                    this.f33500g = i22 + 1;
                    aVarArr22[i22] = aVar;
                }
                this.f33499f -= aVarArr.length;
                notifyAll();
            }
        }
    }

    @Override // c.i.b.a.h0.b
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f33495b : invokeV.intValue;
    }

    public synchronized int f() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                i2 = this.f33499f * this.f33495b;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public synchronized void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            synchronized (this) {
                if (this.f33494a) {
                    h(0);
                }
            }
        }
    }

    public synchronized void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            synchronized (this) {
                boolean z = i2 < this.f33498e;
                this.f33498e = i2;
                if (z) {
                    b();
                }
            }
        }
    }

    public h(boolean z, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        c.i.b.a.i0.a.a(i2 > 0);
        c.i.b.a.i0.a.a(i3 >= 0);
        this.f33494a = z;
        this.f33495b = i2;
        this.f33500g = i3;
        this.f33501h = new a[i3 + 100];
        if (i3 > 0) {
            this.f33496c = new byte[i3 * i2];
            for (int i6 = 0; i6 < i3; i6++) {
                this.f33501h[i6] = new a(this.f33496c, i6 * i2);
            }
        } else {
            this.f33496c = null;
        }
        this.f33497d = new a[1];
    }
}
