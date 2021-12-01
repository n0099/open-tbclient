package c.i.b.a.a0.q;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes7.dex */
public final class l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c a;

    /* renamed from: b  reason: collision with root package name */
    public long f29190b;

    /* renamed from: c  reason: collision with root package name */
    public long f29191c;

    /* renamed from: d  reason: collision with root package name */
    public long f29192d;

    /* renamed from: e  reason: collision with root package name */
    public int f29193e;

    /* renamed from: f  reason: collision with root package name */
    public int f29194f;

    /* renamed from: g  reason: collision with root package name */
    public long[] f29195g;

    /* renamed from: h  reason: collision with root package name */
    public int[] f29196h;

    /* renamed from: i  reason: collision with root package name */
    public int[] f29197i;

    /* renamed from: j  reason: collision with root package name */
    public int[] f29198j;

    /* renamed from: k  reason: collision with root package name */
    public long[] f29199k;
    public boolean[] l;
    public boolean m;
    public boolean[] n;
    public k o;
    public int p;
    public c.i.b.a.i0.l q;
    public boolean r;
    public long s;

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
            }
        }
    }

    public void a(c.i.b.a.a0.f fVar) throws IOException, InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
            fVar.readFully(this.q.a, 0, this.p);
            this.q.J(0);
            this.r = false;
        }
    }

    public void b(c.i.b.a.i0.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar) == null) {
            lVar.g(this.q.a, 0, this.p);
            this.q.J(0);
            this.r = false;
        }
    }

    public long c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? this.f29199k[i2] + this.f29198j[i2] : invokeI.longValue;
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            c.i.b.a.i0.l lVar = this.q;
            if (lVar == null || lVar.d() < i2) {
                this.q = new c.i.b.a.i0.l(i2);
            }
            this.p = i2;
            this.m = true;
            this.r = true;
        }
    }

    public void e(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) {
            this.f29193e = i2;
            this.f29194f = i3;
            int[] iArr = this.f29196h;
            if (iArr == null || iArr.length < i2) {
                this.f29195g = new long[i2];
                this.f29196h = new int[i2];
            }
            int[] iArr2 = this.f29197i;
            if (iArr2 == null || iArr2.length < i3) {
                int i4 = (i3 * 125) / 100;
                this.f29197i = new int[i4];
                this.f29198j = new int[i4];
                this.f29199k = new long[i4];
                this.l = new boolean[i4];
                this.n = new boolean[i4];
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f29193e = 0;
            this.s = 0L;
            this.m = false;
            this.r = false;
            this.o = null;
        }
    }
}
