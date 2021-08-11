package c.i.b.a.d0;

import android.net.Uri;
import android.os.Handler;
import c.i.b.a.d0.h;
import c.i.b.a.d0.l;
import c.i.b.a.h0.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class i implements l, h.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Uri f32869e;

    /* renamed from: f  reason: collision with root package name */
    public final e.a f32870f;

    /* renamed from: g  reason: collision with root package name */
    public final c.i.b.a.a0.h f32871g;

    /* renamed from: h  reason: collision with root package name */
    public final int f32872h;

    /* renamed from: i  reason: collision with root package name */
    public final Handler f32873i;

    /* renamed from: j  reason: collision with root package name */
    public final a f32874j;
    public final String k;
    public final int l;
    public l.a m;
    public long n;
    public boolean o;

    /* loaded from: classes4.dex */
    public interface a {
        void a(IOException iOException);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public i(Uri uri, e.a aVar, c.i.b.a.a0.h hVar, Handler handler, a aVar2) {
        this(uri, aVar, hVar, handler, aVar2, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uri, aVar, hVar, handler, aVar2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Uri) objArr2[0], (e.a) objArr2[1], (c.i.b.a.a0.h) objArr2[2], (Handler) objArr2[3], (a) objArr2[4], (String) objArr2[5]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // c.i.b.a.d0.l
    public void a(c.i.b.a.g gVar, boolean z, l.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{gVar, Boolean.valueOf(z), aVar}) == null) {
            this.m = aVar;
            g(-9223372036854775807L, false);
        }
    }

    @Override // c.i.b.a.d0.l
    public void b() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // c.i.b.a.d0.h.f
    public void c(long j2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), Boolean.valueOf(z)}) == null) {
            if (j2 == -9223372036854775807L) {
                j2 = this.n;
            }
            if (this.n == j2 && this.o == z) {
                return;
            }
            g(j2, z);
        }
    }

    @Override // c.i.b.a.d0.l
    public k d(l.b bVar, c.i.b.a.h0.b bVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, bVar, bVar2)) == null) {
            c.i.b.a.i0.a.a(bVar.f32876a == 0);
            return new h(this.f32869e, this.f32870f.a(), this.f32871g.a(), this.f32872h, this.f32873i, this.f32874j, this, bVar2, this.k, this.l);
        }
        return (k) invokeLL.objValue;
    }

    @Override // c.i.b.a.d0.l
    public void e(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, kVar) == null) {
            ((h) kVar).O();
        }
    }

    @Override // c.i.b.a.d0.l
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.m = null;
        }
    }

    public final void g(long j2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Long.valueOf(j2), Boolean.valueOf(z)}) == null) {
            this.n = j2;
            this.o = z;
            this.m.c(this, new r(this.n, this.o), null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public i(Uri uri, e.a aVar, c.i.b.a.a0.h hVar, Handler handler, a aVar2, String str) {
        this(uri, aVar, hVar, -1, handler, aVar2, str, 1048576);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uri, aVar, hVar, handler, aVar2, str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Uri) objArr2[0], (e.a) objArr2[1], (c.i.b.a.a0.h) objArr2[2], ((Integer) objArr2[3]).intValue(), (Handler) objArr2[4], (a) objArr2[5], (String) objArr2[6], ((Integer) objArr2[7]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public i(Uri uri, e.a aVar, c.i.b.a.a0.h hVar, int i2, Handler handler, a aVar2, String str, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uri, aVar, hVar, Integer.valueOf(i2), handler, aVar2, str, Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f32869e = uri;
        this.f32870f = aVar;
        this.f32871g = hVar;
        this.f32872h = i2;
        this.f32873i = handler;
        this.f32874j = aVar2;
        this.k = str;
        this.l = i3;
    }
}
