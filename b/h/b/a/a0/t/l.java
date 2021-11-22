package b.h.b.a.a0.t;

import b.h.b.a.a0.t.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
/* loaded from: classes6.dex */
public final class l implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final b.h.b.a.i0.l f32601a;

    /* renamed from: b  reason: collision with root package name */
    public b.h.b.a.a0.m f32602b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f32603c;

    /* renamed from: d  reason: collision with root package name */
    public long f32604d;

    /* renamed from: e  reason: collision with root package name */
    public int f32605e;

    /* renamed from: f  reason: collision with root package name */
    public int f32606f;

    public l() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f32601a = new b.h.b.a.i0.l(10);
    }

    @Override // b.h.b.a.a0.t.h
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f32603c = false;
        }
    }

    @Override // b.h.b.a.a0.t.h
    public void c(b.h.b.a.i0.l lVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar) == null) && this.f32603c) {
            int a2 = lVar.a();
            int i2 = this.f32606f;
            if (i2 < 10) {
                int min = Math.min(a2, 10 - i2);
                System.arraycopy(lVar.f33493a, lVar.c(), this.f32601a.f33493a, this.f32606f, min);
                if (this.f32606f + min == 10) {
                    this.f32601a.J(0);
                    if (73 == this.f32601a.x() && 68 == this.f32601a.x() && 51 == this.f32601a.x()) {
                        this.f32601a.K(3);
                        this.f32605e = this.f32601a.w() + 10;
                    } else {
                        this.f32603c = false;
                        return;
                    }
                }
            }
            int min2 = Math.min(a2, this.f32605e - this.f32606f);
            this.f32602b.a(lVar, min2);
            this.f32606f += min2;
        }
    }

    @Override // b.h.b.a.a0.t.h
    public void d() {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f32603c && (i2 = this.f32605e) != 0 && this.f32606f == i2) {
            this.f32602b.c(this.f32604d, 1, i2, 0, null);
            this.f32603c = false;
        }
    }

    @Override // b.h.b.a.a0.t.h
    public void e(long j, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) && z) {
            this.f32603c = true;
            this.f32604d = j;
            this.f32605e = 0;
            this.f32606f = 0;
        }
    }

    @Override // b.h.b.a.a0.t.h
    public void f(b.h.b.a.a0.g gVar, w.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, gVar, dVar) == null) {
            dVar.a();
            b.h.b.a.a0.m a2 = gVar.a(dVar.c(), 4);
            this.f32602b = a2;
            a2.b(Format.createSampleFormat(dVar.b(), "application/id3", null, -1, null));
        }
    }
}
