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
/* loaded from: classes7.dex */
public final class b0 implements Closeable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final z f28035e;

    /* renamed from: f  reason: collision with root package name */
    public final Protocol f28036f;

    /* renamed from: g  reason: collision with root package name */
    public final int f28037g;

    /* renamed from: h  reason: collision with root package name */
    public final String f28038h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public final q f28039i;

    /* renamed from: j  reason: collision with root package name */
    public final r f28040j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    public final c0 f28041k;
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
        this.f28035e = aVar.a;
        this.f28036f = aVar.f28042b;
        this.f28037g = aVar.f28043c;
        this.f28038h = aVar.f28044d;
        this.f28039i = aVar.f28045e;
        this.f28040j = aVar.f28046f.d();
        this.f28041k = aVar.f28047g;
        this.l = aVar.f28048h;
        this.m = aVar.f28049i;
        this.n = aVar.f28050j;
        this.o = aVar.f28051k;
        this.p = aVar.l;
    }

    @Nullable
    public c0 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f28041k : (c0) invokeV.objValue;
    }

    public d c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            d dVar = this.q;
            if (dVar != null) {
                return dVar;
            }
            d k2 = d.k(this.f28040j);
            this.q = k2;
            return k2;
        }
        return (d) invokeV.objValue;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c0 c0Var = this.f28041k;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f28037g : invokeV.intValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f28039i : (q) invokeV.objValue;
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
            String c2 = this.f28040j.c(str);
            return c2 != null ? c2 : str2;
        }
        return (String) invokeLL.objValue;
    }

    public r j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f28040j : (r) invokeV.objValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            int i2 = this.f28037g;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f28038h : (String) invokeV.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f28036f : (Protocol) invokeV.objValue;
    }

    public long q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.p : invokeV.longValue;
    }

    public z r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f28035e : (z) invokeV.objValue;
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
            return "Response{protocol=" + this.f28036f + ", code=" + this.f28037g + ", message=" + this.f28038h + ", url=" + this.f28035e.h() + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable
        public z a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        public Protocol f28042b;

        /* renamed from: c  reason: collision with root package name */
        public int f28043c;

        /* renamed from: d  reason: collision with root package name */
        public String f28044d;
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        public q f28045e;

        /* renamed from: f  reason: collision with root package name */
        public r.a f28046f;
        @Nullable

        /* renamed from: g  reason: collision with root package name */
        public c0 f28047g;
        @Nullable

        /* renamed from: h  reason: collision with root package name */
        public b0 f28048h;
        @Nullable

        /* renamed from: i  reason: collision with root package name */
        public b0 f28049i;
        @Nullable

        /* renamed from: j  reason: collision with root package name */
        public b0 f28050j;

        /* renamed from: k  reason: collision with root package name */
        public long f28051k;
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
            this.f28043c = -1;
            this.f28046f = new r.a();
        }

        public a a(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
                this.f28046f.a(str, str2);
                return this;
            }
            return (a) invokeLL.objValue;
        }

        public a b(@Nullable c0 c0Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c0Var)) == null) {
                this.f28047g = c0Var;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public b0 c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (this.a != null) {
                    if (this.f28042b != null) {
                        if (this.f28043c >= 0) {
                            if (this.f28044d != null) {
                                return new b0(this);
                            }
                            throw new IllegalStateException("message == null");
                        }
                        throw new IllegalStateException("code < 0: " + this.f28043c);
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
                this.f28049i = b0Var;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final void e(b0 b0Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048580, this, b0Var) == null) && b0Var.f28041k != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        public final void f(String str, b0 b0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, str, b0Var) == null) {
                if (b0Var.f28041k == null) {
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
                this.f28043c = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a h(@Nullable q qVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, qVar)) == null) {
                this.f28045e = qVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a i(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2)) == null) {
                this.f28046f.g(str, str2);
                return this;
            }
            return (a) invokeLL.objValue;
        }

        public a j(r rVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, rVar)) == null) {
                this.f28046f = rVar.f();
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a k(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
                this.f28044d = str;
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
                this.f28048h = b0Var;
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
                this.f28050j = b0Var;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a n(Protocol protocol) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, protocol)) == null) {
                this.f28042b = protocol;
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
                this.f28051k = j2;
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
            this.f28043c = -1;
            this.a = b0Var.f28035e;
            this.f28042b = b0Var.f28036f;
            this.f28043c = b0Var.f28037g;
            this.f28044d = b0Var.f28038h;
            this.f28045e = b0Var.f28039i;
            this.f28046f = b0Var.f28040j.f();
            this.f28047g = b0Var.f28041k;
            this.f28048h = b0Var.l;
            this.f28049i = b0Var.m;
            this.f28050j = b0Var.n;
            this.f28051k = b0Var.o;
            this.l = b0Var.p;
        }
    }
}
