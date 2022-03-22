package c.a.p.h.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d[] a;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new d[]{new e(8, 0), new f(0, 1), new f(1, 1), new e(7, 1)};
    }

    public byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, bArr)) != null) {
            return (byte[]) invokeL.objValue;
        }
        c cVar = new c();
        byte[] b2 = b.b(bArr, bArr.length + ((this.a.length + 1) * c.f11754b));
        b.a(b2, cVar.b(), bArr.length);
        int i = 0;
        while (true) {
            d[] dVarArr = this.a;
            if (i >= dVarArr.length) {
                return Arrays.copyOf(cVar.b(), c.f11754b);
            }
            d dVar = dVarArr[i];
            i++;
            int length = bArr.length + (c.f11754b * i);
            cVar.a(dVar.b(b2, 0, length), dVar.a(), dVar.c(), dVar.d());
            b.a(b2, cVar.b(), length);
        }
    }
}
