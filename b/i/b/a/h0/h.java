package b.i.b.a.h0;

import b.i.b.a.i0.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes6.dex */
public final class h implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final boolean f32536a;

    /* renamed from: b  reason: collision with root package name */
    public final int f32537b;

    /* renamed from: c  reason: collision with root package name */
    public final byte[] f32538c;

    /* renamed from: d  reason: collision with root package name */
    public final a[] f32539d;

    /* renamed from: e  reason: collision with root package name */
    public int f32540e;

    /* renamed from: f  reason: collision with root package name */
    public int f32541f;

    /* renamed from: g  reason: collision with root package name */
    public int f32542g;

    /* renamed from: h  reason: collision with root package name */
    public a[] f32543h;

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

    @Override // b.i.b.a.h0.b
    public synchronized void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            synchronized (this) {
                this.f32539d[0] = aVar;
                d(this.f32539d);
            }
        }
    }

    @Override // b.i.b.a.h0.b
    public synchronized void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                int i2 = 0;
                int max = Math.max(0, v.f(this.f32540e, this.f32537b) - this.f32541f);
                if (max >= this.f32542g) {
                    return;
                }
                if (this.f32538c != null) {
                    int i3 = this.f32542g - 1;
                    while (i2 <= i3) {
                        a aVar = this.f32543h[i2];
                        if (aVar.f32519a == this.f32538c) {
                            i2++;
                        } else {
                            a aVar2 = this.f32543h[i3];
                            if (aVar2.f32519a != this.f32538c) {
                                i3--;
                            } else {
                                this.f32543h[i2] = aVar2;
                                this.f32543h[i3] = aVar;
                                i3--;
                                i2++;
                            }
                        }
                    }
                    max = Math.max(max, i2);
                    if (max >= this.f32542g) {
                        return;
                    }
                }
                Arrays.fill(this.f32543h, max, this.f32542g, (Object) null);
                this.f32542g = max;
            }
        }
    }

    @Override // b.i.b.a.h0.b
    public synchronized a c() {
        InterceptResult invokeV;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                this.f32541f++;
                if (this.f32542g > 0) {
                    a[] aVarArr = this.f32543h;
                    int i2 = this.f32542g - 1;
                    this.f32542g = i2;
                    aVar = aVarArr[i2];
                    this.f32543h[i2] = null;
                } else {
                    aVar = new a(new byte[this.f32537b], 0);
                }
            }
            return aVar;
        }
        return (a) invokeV.objValue;
    }

    @Override // b.i.b.a.h0.b
    public synchronized void d(a[] aVarArr) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVarArr) == null) {
            synchronized (this) {
                if (this.f32542g + aVarArr.length >= this.f32543h.length) {
                    this.f32543h = (a[]) Arrays.copyOf(this.f32543h, Math.max(this.f32543h.length * 2, this.f32542g + aVarArr.length));
                }
                for (a aVar : aVarArr) {
                    if (aVar.f32519a != this.f32538c && aVar.f32519a.length != this.f32537b) {
                        z = false;
                        b.i.b.a.i0.a.a(z);
                        a[] aVarArr2 = this.f32543h;
                        int i2 = this.f32542g;
                        this.f32542g = i2 + 1;
                        aVarArr2[i2] = aVar;
                    }
                    z = true;
                    b.i.b.a.i0.a.a(z);
                    a[] aVarArr22 = this.f32543h;
                    int i22 = this.f32542g;
                    this.f32542g = i22 + 1;
                    aVarArr22[i22] = aVar;
                }
                this.f32541f -= aVarArr.length;
                notifyAll();
            }
        }
    }

    @Override // b.i.b.a.h0.b
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f32537b : invokeV.intValue;
    }

    public synchronized int f() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                i2 = this.f32541f * this.f32537b;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public synchronized void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            synchronized (this) {
                if (this.f32536a) {
                    h(0);
                }
            }
        }
    }

    public synchronized void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            synchronized (this) {
                boolean z = i2 < this.f32540e;
                this.f32540e = i2;
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
        b.i.b.a.i0.a.a(i2 > 0);
        b.i.b.a.i0.a.a(i3 >= 0);
        this.f32536a = z;
        this.f32537b = i2;
        this.f32542g = i3;
        this.f32543h = new a[i3 + 100];
        if (i3 > 0) {
            this.f32538c = new byte[i3 * i2];
            for (int i6 = 0; i6 < i3; i6++) {
                this.f32543h[i6] = new a(this.f32538c, i6 * i2);
            }
        } else {
            this.f32538c = null;
        }
        this.f32539d = new a[1];
    }
}
