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
    public final z f31743e;

    /* renamed from: f  reason: collision with root package name */
    public final Protocol f31744f;

    /* renamed from: g  reason: collision with root package name */
    public final int f31745g;

    /* renamed from: h  reason: collision with root package name */
    public final String f31746h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public final q f31747i;

    /* renamed from: j  reason: collision with root package name */
    public final r f31748j;
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
        this.f31743e = aVar.f31749a;
        this.f31744f = aVar.f31750b;
        this.f31745g = aVar.f31751c;
        this.f31746h = aVar.f31752d;
        this.f31747i = aVar.f31753e;
        this.f31748j = aVar.f31754f.d();
        this.k = aVar.f31755g;
        this.l = aVar.f31756h;
        this.m = aVar.f31757i;
        this.n = aVar.f31758j;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f31744f : (Protocol) invokeV.objValue;
    }

    public long C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.p : invokeV.longValue;
    }

    public z D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f31743e : (z) invokeV.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f31745g : invokeV.intValue;
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
            d k = d.k(this.f31748j);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f31747i : (q) invokeV.objValue;
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
            String c2 = this.f31748j.c(str);
            return c2 != null ? c2 : str2;
        }
        return (String) invokeLL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return "Response{protocol=" + this.f31744f + ", code=" + this.f31745g + ", message=" + this.f31746h + ", url=" + this.f31743e.h() + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }

    public r v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f31748j : (r) invokeV.objValue;
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            int i2 = this.f31745g;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f31746h : (String) invokeV.objValue;
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
        public z f31749a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        public Protocol f31750b;

        /* renamed from: c  reason: collision with root package name */
        public int f31751c;

        /* renamed from: d  reason: collision with root package name */
        public String f31752d;
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        public q f31753e;

        /* renamed from: f  reason: collision with root package name */
        public r.a f31754f;
        @Nullable

        /* renamed from: g  reason: collision with root package name */
        public c0 f31755g;
        @Nullable

        /* renamed from: h  reason: collision with root package name */
        public b0 f31756h;
        @Nullable

        /* renamed from: i  reason: collision with root package name */
        public b0 f31757i;
        @Nullable

        /* renamed from: j  reason: collision with root package name */
        public b0 f31758j;
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
            this.f31751c = -1;
            this.f31754f = new r.a();
        }

        public a a(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
                this.f31754f.a(str, str2);
                return this;
            }
            return (a) invokeLL.objValue;
        }

        public a b(@Nullable c0 c0Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c0Var)) == null) {
                this.f31755g = c0Var;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public b0 c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (this.f31749a != null) {
                    if (this.f31750b != null) {
                        if (this.f31751c >= 0) {
                            if (this.f31752d != null) {
                                return new b0(this);
                            }
                            throw new IllegalStateException("message == null");
                        }
                        throw new IllegalStateException("code < 0: " + this.f31751c);
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
                this.f31757i = b0Var;
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
                this.f31751c = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a h(@Nullable q qVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, qVar)) == null) {
                this.f31753e = qVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a i(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2)) == null) {
                this.f31754f.g(str, str2);
                return this;
            }
            return (a) invokeLL.objValue;
        }

        public a j(r rVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, rVar)) == null) {
                this.f31754f = rVar.f();
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a k(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
                this.f31752d = str;
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
                this.f31756h = b0Var;
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
                this.f31758j = b0Var;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a n(Protocol protocol) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, protocol)) == null) {
                this.f31750b = protocol;
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
                this.f31749a = zVar;
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
            this.f31751c = -1;
            this.f31749a = b0Var.f31743e;
            this.f31750b = b0Var.f31744f;
            this.f31751c = b0Var.f31745g;
            this.f31752d = b0Var.f31746h;
            this.f31753e = b0Var.f31747i;
            this.f31754f = b0Var.f31748j.f();
            this.f31755g = b0Var.k;
            this.f31756h = b0Var.l;
            this.f31757i = b0Var.m;
            this.f31758j = b0Var.n;
            this.k = b0Var.o;
            this.l = b0Var.p;
        }
    }
}
