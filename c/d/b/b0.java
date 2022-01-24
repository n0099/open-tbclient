package c.d.b;

import androidx.core.view.InputDeviceCompat;
import c.d.b.r;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.duxiaoman.okhttp3.Protocol;
import java.io.Closeable;
import javax.annotation.Nullable;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes9.dex */
public final class b0 implements Closeable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final z f27643e;

    /* renamed from: f  reason: collision with root package name */
    public final Protocol f27644f;

    /* renamed from: g  reason: collision with root package name */
    public final int f27645g;

    /* renamed from: h  reason: collision with root package name */
    public final String f27646h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public final q f27647i;

    /* renamed from: j  reason: collision with root package name */
    public final r f27648j;
    @Nullable
    public final c0 k;
    @Nullable
    public final b0 l;
    @Nullable
    public final b0 m;
    @Nullable
    public final b0 n;
    public final long o;
    public final long p;
    @Nullable
    public volatile d q;

    public b0(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f27643e = aVar.a;
        this.f27644f = aVar.f27649b;
        this.f27645g = aVar.f27650c;
        this.f27646h = aVar.f27651d;
        this.f27647i = aVar.f27652e;
        this.f27648j = aVar.f27653f.d();
        this.k = aVar.f27654g;
        this.l = aVar.f27655h;
        this.m = aVar.f27656i;
        this.n = aVar.f27657j;
        this.o = aVar.k;
        this.p = aVar.l;
    }

    @Nullable
    public c0 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.k : (c0) invokeV.objValue;
    }

    public d c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            d dVar = this.q;
            if (dVar != null) {
                return dVar;
            }
            d k = d.k(this.f27648j);
            this.q = k;
            return k;
        }
        return (d) invokeV.objValue;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c0 c0Var = this.k;
            if (c0Var != null) {
                c0Var.close();
                return;
            }
            throw new IllegalStateException("response is not eligible for a body and must not be closed");
        }
    }

    public int code() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f27645g : invokeV.intValue;
    }

    @Nullable
    public b0 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.m : (b0) invokeV.objValue;
    }

    @Nullable
    public q f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f27647i : (q) invokeV.objValue;
    }

    @Nullable
    public String g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) ? h(str, null) : (String) invokeL.objValue;
    }

    @Nullable
    public String h(String str, @Nullable String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, str2)) == null) {
            String c2 = this.f27648j.c(str);
            return c2 != null ? c2 : str2;
        }
        return (String) invokeLL.objValue;
    }

    public r j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f27648j : (r) invokeV.objValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            int i2 = this.f27645g;
            if (i2 == 307 || i2 == 308) {
                return true;
            }
            switch (i2) {
                case 300:
                case 301:
                case 302:
                case 303:
                    return true;
                default:
                    return false;
            }
        }
        return invokeV.booleanValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f27646h : (String) invokeV.objValue;
    }

    @Nullable
    public b0 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.l : (b0) invokeV.objValue;
    }

    public a n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? new a(this) : (a) invokeV.objValue;
    }

    @Nullable
    public b0 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.n : (b0) invokeV.objValue;
    }

    public Protocol p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f27644f : (Protocol) invokeV.objValue;
    }

    public long q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.p : invokeV.longValue;
    }

    public z r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f27643e : (z) invokeV.objValue;
    }

    public long s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.o : invokeV.longValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return "Response{protocol=" + this.f27644f + ", code=" + this.f27645g + ", message=" + this.f27646h + ", url=" + this.f27643e.h() + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }

    /* loaded from: classes9.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable
        public z a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        public Protocol f27649b;

        /* renamed from: c  reason: collision with root package name */
        public int f27650c;

        /* renamed from: d  reason: collision with root package name */
        public String f27651d;
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        public q f27652e;

        /* renamed from: f  reason: collision with root package name */
        public r.a f27653f;
        @Nullable

        /* renamed from: g  reason: collision with root package name */
        public c0 f27654g;
        @Nullable

        /* renamed from: h  reason: collision with root package name */
        public b0 f27655h;
        @Nullable

        /* renamed from: i  reason: collision with root package name */
        public b0 f27656i;
        @Nullable

        /* renamed from: j  reason: collision with root package name */
        public b0 f27657j;
        public long k;
        public long l;

        public a() {
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
            this.f27650c = -1;
            this.f27653f = new r.a();
        }

        public a a(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
                this.f27653f.a(str, str2);
                return this;
            }
            return (a) invokeLL.objValue;
        }

        public a b(@Nullable c0 c0Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c0Var)) == null) {
                this.f27654g = c0Var;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public b0 c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (this.a != null) {
                    if (this.f27649b != null) {
                        if (this.f27650c >= 0) {
                            if (this.f27651d != null) {
                                return new b0(this);
                            }
                            throw new IllegalStateException("message == null");
                        }
                        throw new IllegalStateException("code < 0: " + this.f27650c);
                    }
                    throw new IllegalStateException("protocol == null");
                }
                throw new IllegalStateException("request == null");
            }
            return (b0) invokeV.objValue;
        }

        public a d(@Nullable b0 b0Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, b0Var)) == null) {
                if (b0Var != null) {
                    f("cacheResponse", b0Var);
                }
                this.f27656i = b0Var;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final void e(b0 b0Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048580, this, b0Var) == null) && b0Var.k != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        public final void f(String str, b0 b0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, str, b0Var) == null) {
                if (b0Var.k == null) {
                    if (b0Var.l == null) {
                        if (b0Var.m == null) {
                            if (b0Var.n == null) {
                                return;
                            }
                            throw new IllegalArgumentException(str + ".priorResponse != null");
                        }
                        throw new IllegalArgumentException(str + ".cacheResponse != null");
                    }
                    throw new IllegalArgumentException(str + ".networkResponse != null");
                }
                throw new IllegalArgumentException(str + ".body != null");
            }
        }

        public a g(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
                this.f27650c = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a h(@Nullable q qVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, qVar)) == null) {
                this.f27652e = qVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a i(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2)) == null) {
                this.f27653f.g(str, str2);
                return this;
            }
            return (a) invokeLL.objValue;
        }

        public a j(r rVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, rVar)) == null) {
                this.f27653f = rVar.f();
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a k(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
                this.f27651d = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a l(@Nullable b0 b0Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, b0Var)) == null) {
                if (b0Var != null) {
                    f("networkResponse", b0Var);
                }
                this.f27655h = b0Var;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a m(@Nullable b0 b0Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, b0Var)) == null) {
                if (b0Var != null) {
                    e(b0Var);
                }
                this.f27657j = b0Var;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a n(Protocol protocol) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, protocol)) == null) {
                this.f27649b = protocol;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a o(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048590, this, j2)) == null) {
                this.l = j2;
                return this;
            }
            return (a) invokeJ.objValue;
        }

        public a p(z zVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, zVar)) == null) {
                this.a = zVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a q(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048592, this, j2)) == null) {
                this.k = j2;
                return this;
            }
            return (a) invokeJ.objValue;
        }

        public a(b0 b0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b0Var};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f27650c = -1;
            this.a = b0Var.f27643e;
            this.f27649b = b0Var.f27644f;
            this.f27650c = b0Var.f27645g;
            this.f27651d = b0Var.f27646h;
            this.f27652e = b0Var.f27647i;
            this.f27653f = b0Var.f27648j.f();
            this.f27654g = b0Var.k;
            this.f27655h = b0Var.l;
            this.f27656i = b0Var.m;
            this.f27657j = b0Var.n;
            this.k = b0Var.o;
            this.l = b0Var.p;
        }
    }
}
