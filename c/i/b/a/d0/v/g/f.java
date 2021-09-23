package c.i.b.a.d0.v.g;

import android.net.Uri;
import c.i.b.a.i0.u;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final long f33283a;

    /* renamed from: b  reason: collision with root package name */
    public final long f33284b;

    /* renamed from: c  reason: collision with root package name */
    public final String f33285c;

    /* renamed from: d  reason: collision with root package name */
    public int f33286d;

    public f(String str, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Long.valueOf(j2), Long.valueOf(j3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33285c = str == null ? "" : str;
        this.f33283a = j2;
        this.f33284b = j3;
    }

    public f a(f fVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, fVar, str)) == null) {
            String c2 = c(str);
            if (fVar != null && c2.equals(fVar.c(str))) {
                long j2 = this.f33284b;
                if (j2 != -1) {
                    long j3 = this.f33283a;
                    if (j3 + j2 == fVar.f33283a) {
                        long j4 = fVar.f33284b;
                        return new f(c2, j3, j4 != -1 ? j2 + j4 : -1L);
                    }
                }
                long j5 = fVar.f33284b;
                if (j5 != -1) {
                    long j6 = fVar.f33283a;
                    if (j6 + j5 == this.f33283a) {
                        long j7 = this.f33284b;
                        return new f(c2, j6, j7 != -1 ? j5 + j7 : -1L);
                    }
                }
            }
            return null;
        }
        return (f) invokeLL.objValue;
    }

    public Uri b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? u.d(str, this.f33285c) : (Uri) invokeL.objValue;
    }

    public String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? u.c(str, this.f33285c) : (String) invokeL.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || f.class != obj.getClass()) {
                return false;
            }
            f fVar = (f) obj;
            return this.f33283a == fVar.f33283a && this.f33284b == fVar.f33284b && this.f33285c.equals(fVar.f33285c);
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f33286d == 0) {
                this.f33286d = ((((527 + ((int) this.f33283a)) * 31) + ((int) this.f33284b)) * 31) + this.f33285c.hashCode();
            }
            return this.f33286d;
        }
        return invokeV.intValue;
    }
}
