package c.a.d.a.a.a.a;

import android.content.Context;
import com.baidu.ad.magic.flute.a.a.n;
import com.baidu.ad.magic.flute.a.a.q;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final int f1713d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public h f1714a;

    /* renamed from: b  reason: collision with root package name */
    public e f1715b;

    /* renamed from: c  reason: collision with root package name */
    public Context f1716c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-421752351, "Lc/a/d/a/a/a/a/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-421752351, "Lc/a/d/a/a/a/a/c;");
                return;
            }
        }
        f1713d = a.a(24);
    }

    public c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f1716c = context;
        this.f1714a = new h(context);
        this.f1715b = new e(null);
    }

    public final int b(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, obj, obj2)) == null) {
            try {
                return this.f1714a.a(obj, obj2);
            } catch (q e2) {
                throw e2;
            } catch (Throwable th) {
                throw new com.baidu.ad.magic.flute.a.a.g(th);
            }
        }
        return invokeLL.intValue;
    }

    public i c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            int i2 = -103;
            try {
                Object b2 = this.f1714a.b(this.f1716c);
                if (b2 == null) {
                    e = new NullPointerException("gpm null error");
                } else {
                    try {
                        return g(b2, str) == 1 ? i.a(-108) : d(f(b2, str));
                    } catch (com.baidu.ad.magic.flute.a.a.g e2) {
                        e = e2;
                        i2 = -100;
                    } catch (n e3) {
                        e = e3;
                        i2 = -104;
                    } catch (q e4) {
                        e = e4;
                        i2 = -2;
                    }
                }
                return i.b(i2, e);
            } catch (q e5) {
                return i.b(-103, e5);
            }
        }
        return (i) invokeL.objValue;
    }

    public final i d(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bArr)) == null) {
            if (bArr == null || bArr.length == 0) {
                return i.b(-101, null);
            }
            com.baidu.ad.magic.flute.a.a.c a2 = com.baidu.ad.magic.flute.a.a.c.a(bArr);
            if (a2 == null) {
                return i.b(-106, null);
            }
            long[] b2 = a2.b();
            return (b2 == null || b2.length == 0) ? i.b(-107, null) : i.c(c.a.d.a.a.e.a.b(b2[0]));
        }
        return (i) invokeL.objValue;
    }

    public final Object e(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, str, i2)) == null) {
            try {
                Class cls = this.f1714a.f1725c;
                return k.b(cls, new Object[]{str, this.f1715b.f1717a + i2});
            } catch (Exception e2) {
                e2.printStackTrace();
                throw new com.baidu.ad.magic.flute.a.a.g("");
            }
        }
        return invokeLI.objValue;
    }

    public final byte[] f(Object obj, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, obj, str)) == null) {
            g gVar = new g();
            for (int i2 = 0; i2 < f1713d; i2++) {
                gVar.b(f.a(b(obj, e(str, i2))));
            }
            return gVar.a().b();
        }
        return (byte[]) invokeLL.objValue;
    }

    public final int g(Object obj, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, obj, str)) == null) {
            new g();
            return b(obj, h(str));
        }
        return invokeLL.intValue;
    }

    public final Object h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            try {
                return k.b(this.f1714a.f1725c, new Object[]{str, this.f1715b.f1718b});
            } catch (Exception e2) {
                e2.printStackTrace();
                throw new com.baidu.ad.magic.flute.a.a.g("");
            }
        }
        return invokeL.objValue;
    }
}
