package c.a.o0.h.t.b;

import android.util.Base64;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class f implements c.a.o0.h.t.c.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public f() {
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

    @Override // c.a.o0.h.t.c.g
    public byte[] a(String str, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, bArr)) == null) {
            if (str == null || bArr == null) {
                return bArr;
            }
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != 76158) {
                if (hashCode == 1952093519 && str.equals("BASE64")) {
                    c2 = 1;
                }
            } else if (str.equals("MD5")) {
                c2 = 0;
            }
            if (c2 != 0) {
                return c2 != 1 ? bArr : Base64.encode(bArr, 2);
            }
            return c.a.o0.t.f.d(bArr, false).getBytes();
        }
        return (byte[]) invokeLL.objValue;
    }
}
