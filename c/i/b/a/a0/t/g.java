package c.i.b.a.a0.t;

import c.i.b.a.a0.t.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import java.util.Collections;
import java.util.List;
/* loaded from: classes9.dex */
public final class g implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<w.a> a;

    /* renamed from: b  reason: collision with root package name */
    public final c.i.b.a.a0.m[] f28838b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f28839c;

    /* renamed from: d  reason: collision with root package name */
    public int f28840d;

    /* renamed from: e  reason: collision with root package name */
    public int f28841e;

    /* renamed from: f  reason: collision with root package name */
    public long f28842f;

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
        this.a = list;
        this.f28838b = new c.i.b.a.a0.m[list.size()];
    }

    public final boolean a(c.i.b.a.i0.l lVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, lVar, i2)) == null) {
            if (lVar.a() == 0) {
                return false;
            }
            if (lVar.x() != i2) {
                this.f28839c = false;
            }
            this.f28840d--;
            return this.f28839c;
        }
        return invokeLI.booleanValue;
    }

    @Override // c.i.b.a.a0.t.h
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f28839c = false;
        }
    }

    @Override // c.i.b.a.a0.t.h
    public void c(c.i.b.a.i0.l lVar) {
        c.i.b.a.a0.m[] mVarArr;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lVar) == null) && this.f28839c) {
            if (this.f28840d != 2 || a(lVar, 32)) {
                if (this.f28840d != 1 || a(lVar, 0)) {
                    int c2 = lVar.c();
                    int a = lVar.a();
                    for (c.i.b.a.a0.m mVar : this.f28838b) {
                        lVar.J(c2);
                        mVar.a(lVar, a);
                    }
                    this.f28841e += a;
                }
            }
        }
    }

    @Override // c.i.b.a.a0.t.h
    public void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.f28839c) {
            for (c.i.b.a.a0.m mVar : this.f28838b) {
                mVar.c(this.f28842f, 1, this.f28841e, 0, null);
            }
            this.f28839c = false;
        }
    }

    @Override // c.i.b.a.a0.t.h
    public void e(long j2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j2), Boolean.valueOf(z)}) == null) && z) {
            this.f28839c = true;
            this.f28842f = j2;
            this.f28841e = 0;
            this.f28840d = 2;
        }
    }

    @Override // c.i.b.a.a0.t.h
    public void f(c.i.b.a.a0.g gVar, w.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, gVar, dVar) == null) {
            for (int i2 = 0; i2 < this.f28838b.length; i2++) {
                w.a aVar = this.a.get(i2);
                dVar.a();
                c.i.b.a.a0.m a = gVar.a(dVar.c(), 3);
                a.b(Format.createImageSampleFormat(dVar.b(), "application/dvbsubs", null, -1, Collections.singletonList(aVar.f28972b), aVar.a, null));
                this.f28838b[i2] = a;
            }
        }
    }
}
