package c.a.m.h;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public e[] a;

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
        this.a = new e[]{new f(8, 0), new g(0, 1), new g(1, 1), new f(7, 1)};
    }

    public byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, bArr)) != null) {
            return (byte[]) invokeL.objValue;
        }
        d dVar = new d();
        byte[] b2 = b.b(bArr, bArr.length + ((this.a.length + 1) * d.f4361b));
        b.a(b2, dVar.b(), bArr.length);
        int i2 = 0;
        while (true) {
            e[] eVarArr = this.a;
            if (i2 >= eVarArr.length) {
                return Arrays.copyOf(dVar.b(), d.f4361b);
            }
            e eVar = eVarArr[i2];
            i2++;
            int length = bArr.length + (d.f4361b * i2);
            dVar.a(eVar.b(b2, 0, length), eVar.d(), eVar.a(), eVar.c());
            b.a(b2, dVar.b(), length);
        }
    }
}
