package b.i.b.a.d0;

import android.net.Uri;
import android.os.Handler;
import b.i.b.a.d0.h;
import b.i.b.a.d0.l;
import b.i.b.a.h0.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes6.dex */
public final class i implements l, h.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Uri f31952e;

    /* renamed from: f  reason: collision with root package name */
    public final e.a f31953f;

    /* renamed from: g  reason: collision with root package name */
    public final b.i.b.a.a0.h f31954g;

    /* renamed from: h  reason: collision with root package name */
    public final int f31955h;

    /* renamed from: i  reason: collision with root package name */
    public final Handler f31956i;
    public final a j;
    public final String k;
    public final int l;
    public l.a m;
    public long n;
    public boolean o;

    /* loaded from: classes6.dex */
    public interface a {
        void a(IOException iOException);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public i(Uri uri, e.a aVar, b.i.b.a.a0.h hVar, Handler handler, a aVar2) {
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
                this((Uri) objArr2[0], (e.a) objArr2[1], (b.i.b.a.a0.h) objArr2[2], (Handler) objArr2[3], (a) objArr2[4], (String) objArr2[5]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // b.i.b.a.d0.l
    public void a(b.i.b.a.g gVar, boolean z, l.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{gVar, Boolean.valueOf(z), aVar}) == null) {
            this.m = aVar;
            g(-9223372036854775807L, false);
        }
    }

    @Override // b.i.b.a.d0.l
    public void b() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // b.i.b.a.d0.h.f
    public void c(long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            if (j == -9223372036854775807L) {
                j = this.n;
            }
            if (this.n == j && this.o == z) {
                return;
            }
            g(j, z);
        }
    }

    @Override // b.i.b.a.d0.l
    public k d(l.b bVar, b.i.b.a.h0.b bVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, bVar, bVar2)) == null) {
            b.i.b.a.i0.a.a(bVar.f31958a == 0);
            return new h(this.f31952e, this.f31953f.a(), this.f31954g.a(), this.f31955h, this.f31956i, this.j, this, bVar2, this.k, this.l);
        }
        return (k) invokeLL.objValue;
    }

    @Override // b.i.b.a.d0.l
    public void e(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, kVar) == null) {
            ((h) kVar).O();
        }
    }

    @Override // b.i.b.a.d0.l
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.m = null;
        }
    }

    public final void g(long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            this.n = j;
            this.o = z;
            this.m.c(this, new r(this.n, this.o), null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public i(Uri uri, e.a aVar, b.i.b.a.a0.h hVar, Handler handler, a aVar2, String str) {
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
                this((Uri) objArr2[0], (e.a) objArr2[1], (b.i.b.a.a0.h) objArr2[2], ((Integer) objArr2[3]).intValue(), (Handler) objArr2[4], (a) objArr2[5], (String) objArr2[6], ((Integer) objArr2[7]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public i(Uri uri, e.a aVar, b.i.b.a.a0.h hVar, int i2, Handler handler, a aVar2, String str, int i3) {
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
        this.f31952e = uri;
        this.f31953f = aVar;
        this.f31954g = hVar;
        this.f31955h = i2;
        this.f31956i = handler;
        this.j = aVar2;
        this.k = str;
        this.l = i3;
    }
}
