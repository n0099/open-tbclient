package c.i.b.a.a0.t;

import c.i.b.a.a0.t.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import kotlin.jvm.internal.ByteCompanionObject;
/* loaded from: classes7.dex */
public final class f implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c.i.b.a.i0.l a;

    /* renamed from: b  reason: collision with root package name */
    public final String f29292b;

    /* renamed from: c  reason: collision with root package name */
    public String f29293c;

    /* renamed from: d  reason: collision with root package name */
    public c.i.b.a.a0.m f29294d;

    /* renamed from: e  reason: collision with root package name */
    public int f29295e;

    /* renamed from: f  reason: collision with root package name */
    public int f29296f;

    /* renamed from: g  reason: collision with root package name */
    public int f29297g;

    /* renamed from: h  reason: collision with root package name */
    public long f29298h;

    /* renamed from: i  reason: collision with root package name */
    public Format f29299i;

    /* renamed from: j  reason: collision with root package name */
    public int f29300j;

    /* renamed from: k  reason: collision with root package name */
    public long f29301k;

    public f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        c.i.b.a.i0.l lVar = new c.i.b.a.i0.l(new byte[15]);
        this.a = lVar;
        byte[] bArr = lVar.a;
        bArr[0] = ByteCompanionObject.MAX_VALUE;
        bArr[1] = -2;
        bArr[2] = ByteCompanionObject.MIN_VALUE;
        bArr[3] = 1;
        this.f29295e = 0;
        this.f29292b = str;
    }

    public final boolean a(c.i.b.a.i0.l lVar, byte[] bArr, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048576, this, lVar, bArr, i2)) == null) {
            int min = Math.min(lVar.a(), i2 - this.f29296f);
            lVar.g(bArr, this.f29296f, min);
            int i3 = this.f29296f + min;
            this.f29296f = i3;
            return i3 == i2;
        }
        return invokeLLI.booleanValue;
    }

    @Override // c.i.b.a.a0.t.h
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f29295e = 0;
            this.f29296f = 0;
            this.f29297g = 0;
        }
    }

    @Override // c.i.b.a.a0.t.h
    public void c(c.i.b.a.i0.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lVar) == null) {
            while (lVar.a() > 0) {
                int i2 = this.f29295e;
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 == 2) {
                            int min = Math.min(lVar.a(), this.f29300j - this.f29296f);
                            this.f29294d.a(lVar, min);
                            int i3 = this.f29296f + min;
                            this.f29296f = i3;
                            int i4 = this.f29300j;
                            if (i3 == i4) {
                                this.f29294d.c(this.f29301k, 1, i4, 0, null);
                                this.f29301k += this.f29298h;
                                this.f29295e = 0;
                            }
                        }
                    } else if (a(lVar, this.a.a, 15)) {
                        g();
                        this.a.J(0);
                        this.f29294d.a(this.a, 15);
                        this.f29295e = 2;
                    }
                } else if (h(lVar)) {
                    this.f29296f = 4;
                    this.f29295e = 1;
                }
            }
        }
    }

    @Override // c.i.b.a.a0.t.h
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    @Override // c.i.b.a.a0.t.h
    public void e(long j2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j2), Boolean.valueOf(z)}) == null) {
            this.f29301k = j2;
        }
    }

    @Override // c.i.b.a.a0.t.h
    public void f(c.i.b.a.a0.g gVar, w.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, gVar, dVar) == null) {
            dVar.a();
            this.f29293c = dVar.b();
            this.f29294d = gVar.a(dVar.c(), 1);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            byte[] bArr = this.a.a;
            if (this.f29299i == null) {
                Format d2 = c.i.b.a.x.f.d(bArr, this.f29293c, this.f29292b, null);
                this.f29299i = d2;
                this.f29294d.b(d2);
            }
            this.f29300j = c.i.b.a.x.f.a(bArr);
            this.f29298h = (int) ((c.i.b.a.x.f.c(bArr) * 1000000) / this.f29299i.sampleRate);
        }
    }

    public final boolean h(c.i.b.a.i0.l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, lVar)) == null) {
            while (lVar.a() > 0) {
                int i2 = this.f29297g << 8;
                this.f29297g = i2;
                int x = i2 | lVar.x();
                this.f29297g = x;
                if (x == 2147385345) {
                    this.f29297g = 0;
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
