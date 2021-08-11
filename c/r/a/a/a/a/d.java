package c.r.a.a.a.a;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class d implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ b f35256a;

    public d(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f35256a = bVar;
    }

    public static String b(String str, String str2) {
        InterceptResult invokeLL;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                str3 = (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, str2);
            } catch (Exception unused) {
                str3 = null;
            }
            return str3 == null ? "" : str3;
        }
        return (String) invokeLL.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, IF, IGET, INVOKE, SGET, INVOKE, INVOKE, IF, IF, SGET, INVOKE, INVOKE, IF, IF, SGET, INVOKE] complete} */
    @Override // c.r.a.a.a.a.a
    public final void a(boolean z, c.r.a.a.a.b.b bVar) {
        c.r.a.a.c.a.e eVar;
        c.r.a.a.c.a.e eVar2;
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048576, this, z, bVar) == null) {
            try {
                if (z || bVar != null) {
                    b2 = bVar.b();
                    if (!TextUtils.isEmpty(b2)) {
                        b.f35246f = b2;
                    }
                } else {
                    c.r.a.a.c.b.c.b("not support OAID");
                    b2 = null;
                }
                c.r.a.a.c.b.c.b("get OAID " + b2);
                b.c().i();
            } catch (Throwable th) {
                try {
                    c.r.a.a.c.b.c.c(th);
                    try {
                        if (!TextUtils.isEmpty(b.f35246f) && !b.f35246f.startsWith("KWE")) {
                            eVar2 = this.f35256a.f35252e;
                            eVar2.d(b.f35246f);
                        }
                        if (bVar != null) {
                            bVar.d();
                        }
                    } catch (Throwable unused) {
                    }
                } finally {
                    try {
                        if (!TextUtils.isEmpty(b.f35246f) && !b.f35246f.startsWith("KWE")) {
                            eVar = this.f35256a.f35252e;
                            eVar.d(b.f35246f);
                        }
                        if (bVar != null) {
                            bVar.d();
                        }
                    } catch (Throwable unused2) {
                    }
                }
            }
        }
    }
}
