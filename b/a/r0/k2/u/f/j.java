package b.a.r0.k2.u.f;

import b.a.e.e.d.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static j f19321c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.a.e.e.d.l<byte[]> f19322a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.e.e.d.l<byte[]> f19323b;

    public j() {
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
        this.f19322a = null;
        this.f19323b = null;
        c();
    }

    public static synchronized j b() {
        InterceptResult invokeV;
        j jVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (j.class) {
                if (f19321c == null) {
                    f19321c = new j();
                }
                jVar = f19321c;
            }
            return jVar;
        }
        return (j) invokeV.objValue;
    }

    public byte[] a(String str, boolean z) {
        InterceptResult invokeLZ;
        l.b<byte[]> h2;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, str, z)) == null) {
            if (z) {
                b.a.e.e.d.l<byte[]> lVar = this.f19322a;
                if (lVar != null && str != null) {
                    h2 = lVar.h(str);
                }
                h2 = null;
            } else {
                b.a.e.e.d.l<byte[]> lVar2 = this.f19323b;
                if (lVar2 != null && str != null) {
                    h2 = lVar2.h(str);
                }
                h2 = null;
            }
            if (h2 == null || (bArr = h2.f1705b) == null) {
                return null;
            }
            return bArr;
        }
        return (byte[]) invokeLZ.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.f19322a == null) {
                b.a.q0.s.r.a.f();
                this.f19322a = b.a.q0.s.r.a.d("tb.pb_mark");
            }
            if (this.f19323b == null) {
                b.a.q0.s.r.a.f();
                this.f19323b = b.a.q0.s.r.a.d("tb.pb_normal");
            }
        }
    }

    public void d(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, str, z) == null) {
            if (z) {
                b.a.e.e.d.l<byte[]> lVar = this.f19322a;
                if (lVar == null || str == null) {
                    return;
                }
                lVar.i(str, new byte[0], 0L);
                return;
            }
            b.a.e.e.d.l<byte[]> lVar2 = this.f19323b;
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
            this.f19322a.e(str, bArr, 604800000L);
        } else {
            this.f19323b.e(str, bArr, 86400000L);
        }
    }

    public void f(String str, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, str, bArr) == null) || bArr == null || str == null) {
            return;
        }
        c();
        this.f19322a.e(str, bArr, 2592000000L);
    }
}
