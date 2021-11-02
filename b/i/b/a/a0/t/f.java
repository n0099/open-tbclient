package b.i.b.a.a0.t;

import b.i.b.a.a0.t.w;
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
    public final b.i.b.a.i0.l f31669a;

    /* renamed from: b  reason: collision with root package name */
    public final String f31670b;

    /* renamed from: c  reason: collision with root package name */
    public String f31671c;

    /* renamed from: d  reason: collision with root package name */
    public b.i.b.a.a0.m f31672d;

    /* renamed from: e  reason: collision with root package name */
    public int f31673e;

    /* renamed from: f  reason: collision with root package name */
    public int f31674f;

    /* renamed from: g  reason: collision with root package name */
    public int f31675g;

    /* renamed from: h  reason: collision with root package name */
    public long f31676h;

    /* renamed from: i  reason: collision with root package name */
    public Format f31677i;
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
        b.i.b.a.i0.l lVar = new b.i.b.a.i0.l(new byte[15]);
        this.f31669a = lVar;
        byte[] bArr = lVar.f32635a;
        bArr[0] = ByteCompanionObject.MAX_VALUE;
        bArr[1] = -2;
        bArr[2] = ByteCompanionObject.MIN_VALUE;
        bArr[3] = 1;
        this.f31673e = 0;
        this.f31670b = str;
    }

    public final boolean a(b.i.b.a.i0.l lVar, byte[] bArr, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048576, this, lVar, bArr, i2)) == null) {
            int min = Math.min(lVar.a(), i2 - this.f31674f);
            lVar.g(bArr, this.f31674f, min);
            int i3 = this.f31674f + min;
            this.f31674f = i3;
            return i3 == i2;
        }
        return invokeLLI.booleanValue;
    }

    @Override // b.i.b.a.a0.t.h
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f31673e = 0;
            this.f31674f = 0;
            this.f31675g = 0;
        }
    }

    @Override // b.i.b.a.a0.t.h
    public void c(b.i.b.a.i0.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lVar) == null) {
            while (lVar.a() > 0) {
                int i2 = this.f31673e;
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 == 2) {
                            int min = Math.min(lVar.a(), this.j - this.f31674f);
                            this.f31672d.a(lVar, min);
                            int i3 = this.f31674f + min;
                            this.f31674f = i3;
                            int i4 = this.j;
                            if (i3 == i4) {
                                this.f31672d.c(this.k, 1, i4, 0, null);
                                this.k += this.f31676h;
                                this.f31673e = 0;
                            }
                        }
                    } else if (a(lVar, this.f31669a.f32635a, 15)) {
                        g();
                        this.f31669a.J(0);
                        this.f31672d.a(this.f31669a, 15);
                        this.f31673e = 2;
                    }
                } else if (h(lVar)) {
                    this.f31674f = 4;
                    this.f31673e = 1;
                }
            }
        }
    }

    @Override // b.i.b.a.a0.t.h
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    @Override // b.i.b.a.a0.t.h
    public void e(long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            this.k = j;
        }
    }

    @Override // b.i.b.a.a0.t.h
    public void f(b.i.b.a.a0.g gVar, w.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, gVar, dVar) == null) {
            dVar.a();
            this.f31671c = dVar.b();
            this.f31672d = gVar.a(dVar.c(), 1);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            byte[] bArr = this.f31669a.f32635a;
            if (this.f31677i == null) {
                Format d2 = b.i.b.a.x.f.d(bArr, this.f31671c, this.f31670b, null);
                this.f31677i = d2;
                this.f31672d.b(d2);
            }
            this.j = b.i.b.a.x.f.a(bArr);
            this.f31676h = (int) ((b.i.b.a.x.f.c(bArr) * 1000000) / this.f31677i.sampleRate);
        }
    }

    public final boolean h(b.i.b.a.i0.l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, lVar)) == null) {
            while (lVar.a() > 0) {
                int i2 = this.f31675g << 8;
                this.f31675g = i2;
                int x = i2 | lVar.x();
                this.f31675g = x;
                if (x == 2147385345) {
                    this.f31675g = 0;
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
