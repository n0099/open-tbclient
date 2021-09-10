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
/* loaded from: classes4.dex */
public final class b0 implements Closeable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final z f31718e;

    /* renamed from: f  reason: collision with root package name */
    public final Protocol f31719f;

    /* renamed from: g  reason: collision with root package name */
    public final int f31720g;

    /* renamed from: h  reason: collision with root package name */
    public final String f31721h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public final q f31722i;

    /* renamed from: j  reason: collision with root package name */
    public final r f31723j;
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
        this.f31718e = aVar.f31724a;
        this.f31719f = aVar.f31725b;
        this.f31720g = aVar.f31726c;
        this.f31721h = aVar.f31727d;
        this.f31722i = aVar.f31728e;
        this.f31723j = aVar.f31729f.d();
        this.k = aVar.f31730g;
        this.l = aVar.f31731h;
        this.m = aVar.f31732i;
        this.n = aVar.f31733j;
        this.o = aVar.k;
        this.p = aVar.l;
    }

    @Nullable
    public b0 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.n : (b0) invokeV.objValue;
    }

    public Protocol B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f31719f : (Protocol) invokeV.objValue;
    }

    public long C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.p : invokeV.longValue;
    }

    public z D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f31718e : (z) invokeV.objValue;
    }

    public long E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.o : invokeV.longValue;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f31720g : invokeV.intValue;
    }

    @Nullable
    public c0 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.k : (c0) invokeV.objValue;
    }

    public d n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            d dVar = this.q;
            if (dVar != null) {
                return dVar;
            }
            d k = d.k(this.f31723j);
            this.q = k;
            return k;
        }
        return (d) invokeV.objValue;
    }

    @Nullable
    public b0 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.m : (b0) invokeV.objValue;
    }

    @Nullable
    public q r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f31722i : (q) invokeV.objValue;
    }

    @Nullable
    public String s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) ? t(str, null) : (String) invokeL.objValue;
    }

    @Nullable
    public String t(String str, @Nullable String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, str, str2)) == null) {
            String c2 = this.f31723j.c(str);
            return c2 != null ? c2 : str2;
        }
        return (String) invokeLL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return "Response{protocol=" + this.f31719f + ", code=" + this.f31720g + ", message=" + this.f31721h + ", url=" + this.f31718e.h() + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }

    public r v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f31723j : (r) invokeV.objValue;
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            int i2 = this.f31720g;
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

    public String x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f31721h : (String) invokeV.objValue;
    }

    @Nullable
    public b0 y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.l : (b0) invokeV.objValue;
    }

    public a z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? new a(this) : (a) invokeV.objValue;
    }

    /* loaded from: classes4.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        public z f31724a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        public Protocol f31725b;

        /* renamed from: c  reason: collision with root package name */
        public int f31726c;

        /* renamed from: d  reason: collision with root package name */
        public String f31727d;
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        public q f31728e;

        /* renamed from: f  reason: collision with root package name */
        public r.a f31729f;
        @Nullable

        /* renamed from: g  reason: collision with root package name */
        public c0 f31730g;
        @Nullable

        /* renamed from: h  reason: collision with root package name */
        public b0 f31731h;
        @Nullable

        /* renamed from: i  reason: collision with root package name */
        public b0 f31732i;
        @Nullable

        /* renamed from: j  reason: collision with root package name */
        public b0 f31733j;
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
            this.f31726c = -1;
            this.f31729f = new r.a();
        }

        public a a(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
                this.f31729f.a(str, str2);
                return this;
            }
            return (a) invokeLL.objValue;
        }

        public a b(@Nullable c0 c0Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c0Var)) == null) {
                this.f31730g = c0Var;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public b0 c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (this.f31724a != null) {
                    if (this.f31725b != null) {
                        if (this.f31726c >= 0) {
                            if (this.f31727d != null) {
                                return new b0(this);
                            }
                            throw new IllegalStateException("message == null");
                        }
                        throw new IllegalStateException("code < 0: " + this.f31726c);
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
                this.f31732i = b0Var;
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
                this.f31726c = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a h(@Nullable q qVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, qVar)) == null) {
                this.f31728e = qVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a i(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2)) == null) {
                this.f31729f.g(str, str2);
                return this;
            }
            return (a) invokeLL.objValue;
        }

        public a j(r rVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, rVar)) == null) {
                this.f31729f = rVar.f();
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a k(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
                this.f31727d = str;
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
                this.f31731h = b0Var;
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
                this.f31733j = b0Var;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a n(Protocol protocol) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, protocol)) == null) {
                this.f31725b = protocol;
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
                this.f31724a = zVar;
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
            this.f31726c = -1;
            this.f31724a = b0Var.f31718e;
            this.f31725b = b0Var.f31719f;
            this.f31726c = b0Var.f31720g;
            this.f31727d = b0Var.f31721h;
            this.f31728e = b0Var.f31722i;
            this.f31729f = b0Var.f31723j.f();
            this.f31730g = b0Var.k;
            this.f31731h = b0Var.l;
            this.f31732i = b0Var.m;
            this.f31733j = b0Var.n;
            this.k = b0Var.o;
            this.l = b0Var.p;
        }
    }
}
