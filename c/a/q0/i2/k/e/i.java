package c.a.q0.i2.k.e;

import c.a.e.e.d.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static i f19438c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.e.e.d.l<byte[]> f19439a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.e.e.d.l<byte[]> f19440b;

    public i() {
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
        this.f19439a = null;
        this.f19440b = null;
        c();
    }

    public static synchronized i b() {
        InterceptResult invokeV;
        i iVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (i.class) {
                if (f19438c == null) {
                    f19438c = new i();
                }
                iVar = f19438c;
            }
            return iVar;
        }
        return (i) invokeV.objValue;
    }

    public byte[] a(String str, boolean z) {
        InterceptResult invokeLZ;
        l.b<byte[]> h2;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, str, z)) == null) {
            if (z) {
                c.a.e.e.d.l<byte[]> lVar = this.f19439a;
                if (lVar != null && str != null) {
                    h2 = lVar.h(str);
                }
                h2 = null;
            } else {
                c.a.e.e.d.l<byte[]> lVar2 = this.f19440b;
                if (lVar2 != null && str != null) {
                    h2 = lVar2.h(str);
                }
                h2 = null;
            }
            if (h2 == null || (bArr = h2.f2224b) == null) {
                return null;
            }
            return bArr;
        }
        return (byte[]) invokeLZ.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.f19439a == null) {
                c.a.p0.s.r.a.f();
                this.f19439a = c.a.p0.s.r.a.d("tb.pb_mark");
            }
            if (this.f19440b == null) {
                c.a.p0.s.r.a.f();
                this.f19440b = c.a.p0.s.r.a.d("tb.pb_normal");
            }
        }
    }

    public void d(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, str, z) == null) {
            if (z) {
                c.a.e.e.d.l<byte[]> lVar = this.f19439a;
                if (lVar == null || str == null) {
                    return;
                }
                lVar.i(str, new byte[0], 0L);
                return;
            }
            c.a.e.e.d.l<byte[]> lVar2 = this.f19440b;
            if (lVar2 == null || str == null) {
                return;
            }
            lVar2.i(str, new byte[0], 0L);
        }
    }

    public void e(String str, boolean z, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, Boolean.valueOf(z), bArr}) == null) || str == null) {
            return;
        }
        c();
        if (z) {
            this.f19439a.e(str, bArr, 604800000L);
        } else {
            this.f19440b.e(str, bArr, 86400000L);
        }
    }

    public void f(String str, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, str, bArr) == null) || bArr == null || str == null) {
            return;
        }
        c();
        this.f19439a.e(str, bArr, 2592000000L);
    }
}
