package b.h.b.a.a0.t;

import b.h.b.a.a0.t.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public final class g implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final List<w.a> f32536a;

    /* renamed from: b  reason: collision with root package name */
    public final b.h.b.a.a0.m[] f32537b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f32538c;

    /* renamed from: d  reason: collision with root package name */
    public int f32539d;

    /* renamed from: e  reason: collision with root package name */
    public int f32540e;

    /* renamed from: f  reason: collision with root package name */
    public long f32541f;

    public g(List<w.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f32536a = list;
        this.f32537b = new b.h.b.a.a0.m[list.size()];
    }

    public final boolean a(b.h.b.a.i0.l lVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, lVar, i2)) == null) {
            if (lVar.a() == 0) {
                return false;
            }
            if (lVar.x() != i2) {
                this.f32538c = false;
            }
            this.f32539d--;
            return this.f32538c;
        }
        return invokeLI.booleanValue;
    }

    @Override // b.h.b.a.a0.t.h
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f32538c = false;
        }
    }

    @Override // b.h.b.a.a0.t.h
    public void c(b.h.b.a.i0.l lVar) {
        b.h.b.a.a0.m[] mVarArr;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lVar) == null) && this.f32538c) {
            if (this.f32539d != 2 || a(lVar, 32)) {
                if (this.f32539d != 1 || a(lVar, 0)) {
                    int c2 = lVar.c();
                    int a2 = lVar.a();
                    for (b.h.b.a.a0.m mVar : this.f32537b) {
                        lVar.J(c2);
                        mVar.a(lVar, a2);
                    }
                    this.f32540e += a2;
                }
            }
        }
    }

    @Override // b.h.b.a.a0.t.h
    public void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.f32538c) {
            for (b.h.b.a.a0.m mVar : this.f32537b) {
                mVar.c(this.f32541f, 1, this.f32540e, 0, null);
            }
            this.f32538c = false;
        }
    }

    @Override // b.h.b.a.a0.t.h
    public void e(long j, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) && z) {
            this.f32538c = true;
            this.f32541f = j;
            this.f32540e = 0;
            this.f32539d = 2;
        }
    }

    @Override // b.h.b.a.a0.t.h
    public void f(b.h.b.a.a0.g gVar, w.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, gVar, dVar) == null) {
            for (int i2 = 0; i2 < this.f32537b.length; i2++) {
                w.a aVar = this.f32536a.get(i2);
                dVar.a();
                b.h.b.a.a0.m a2 = gVar.a(dVar.c(), 3);
                a2.b(Format.createImageSampleFormat(dVar.b(), "application/dvbsubs", null, -1, Collections.singletonList(aVar.f32682b), aVar.f32681a, null));
                this.f32537b[i2] = a2;
            }
        }
    }
}
