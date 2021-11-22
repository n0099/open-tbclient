package b.h.b.a.a0.t;

import b.h.b.a.a0.t.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import kotlin.jvm.internal.ByteCompanionObject;
/* loaded from: classes6.dex */
public final class f implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final b.h.b.a.i0.l f32527a;

    /* renamed from: b  reason: collision with root package name */
    public final String f32528b;

    /* renamed from: c  reason: collision with root package name */
    public String f32529c;

    /* renamed from: d  reason: collision with root package name */
    public b.h.b.a.a0.m f32530d;

    /* renamed from: e  reason: collision with root package name */
    public int f32531e;

    /* renamed from: f  reason: collision with root package name */
    public int f32532f;

    /* renamed from: g  reason: collision with root package name */
    public int f32533g;

    /* renamed from: h  reason: collision with root package name */
    public long f32534h;

    /* renamed from: i  reason: collision with root package name */
    public Format f32535i;
    public int j;
    public long k;

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
        b.h.b.a.i0.l lVar = new b.h.b.a.i0.l(new byte[15]);
        this.f32527a = lVar;
        byte[] bArr = lVar.f33493a;
        bArr[0] = ByteCompanionObject.MAX_VALUE;
        bArr[1] = -2;
        bArr[2] = ByteCompanionObject.MIN_VALUE;
        bArr[3] = 1;
        this.f32531e = 0;
        this.f32528b = str;
    }

    public final boolean a(b.h.b.a.i0.l lVar, byte[] bArr, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048576, this, lVar, bArr, i2)) == null) {
            int min = Math.min(lVar.a(), i2 - this.f32532f);
            lVar.g(bArr, this.f32532f, min);
            int i3 = this.f32532f + min;
            this.f32532f = i3;
            return i3 == i2;
        }
        return invokeLLI.booleanValue;
    }

    @Override // b.h.b.a.a0.t.h
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f32531e = 0;
            this.f32532f = 0;
            this.f32533g = 0;
        }
    }

    @Override // b.h.b.a.a0.t.h
    public void c(b.h.b.a.i0.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lVar) == null) {
            while (lVar.a() > 0) {
                int i2 = this.f32531e;
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 == 2) {
                            int min = Math.min(lVar.a(), this.j - this.f32532f);
                            this.f32530d.a(lVar, min);
                            int i3 = this.f32532f + min;
                            this.f32532f = i3;
                            int i4 = this.j;
                            if (i3 == i4) {
                                this.f32530d.c(this.k, 1, i4, 0, null);
                                this.k += this.f32534h;
                                this.f32531e = 0;
                            }
                        }
                    } else if (a(lVar, this.f32527a.f33493a, 15)) {
                        g();
                        this.f32527a.J(0);
                        this.f32530d.a(this.f32527a, 15);
                        this.f32531e = 2;
                    }
                } else if (h(lVar)) {
                    this.f32532f = 4;
                    this.f32531e = 1;
                }
            }
        }
    }

    @Override // b.h.b.a.a0.t.h
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    @Override // b.h.b.a.a0.t.h
    public void e(long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            this.k = j;
        }
    }

    @Override // b.h.b.a.a0.t.h
    public void f(b.h.b.a.a0.g gVar, w.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, gVar, dVar) == null) {
            dVar.a();
            this.f32529c = dVar.b();
            this.f32530d = gVar.a(dVar.c(), 1);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            byte[] bArr = this.f32527a.f33493a;
            if (this.f32535i == null) {
                Format d2 = b.h.b.a.x.f.d(bArr, this.f32529c, this.f32528b, null);
                this.f32535i = d2;
                this.f32530d.b(d2);
            }
            this.j = b.h.b.a.x.f.a(bArr);
            this.f32534h = (int) ((b.h.b.a.x.f.c(bArr) * 1000000) / this.f32535i.sampleRate);
        }
    }

    public final boolean h(b.h.b.a.i0.l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, lVar)) == null) {
            while (lVar.a() > 0) {
                int i2 = this.f32533g << 8;
                this.f32533g = i2;
                int x = i2 | lVar.x();
                this.f32533g = x;
                if (x == 2147385345) {
                    this.f32533g = 0;
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
