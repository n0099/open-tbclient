package c.a.r.g.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d[] f15386a;

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
        this.f15386a = new d[]{new e(8, 0), new f(0, 1), new f(1, 1), new e(7, 1)};
    }

    public byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, bArr)) != null) {
            return (byte[]) invokeL.objValue;
        }
        c cVar = new c();
        byte[] b2 = b.b(bArr, bArr.length + ((this.f15386a.length + 1) * c.f15387b));
        b.a(b2, cVar.b(), bArr.length);
        int i2 = 0;
        while (true) {
            d[] dVarArr = this.f15386a;
            if (i2 >= dVarArr.length) {
                return Arrays.copyOf(cVar.b(), c.f15387b);
            }
            d dVar = dVarArr[i2];
            i2++;
            int length = bArr.length + (c.f15387b * i2);
            cVar.a(dVar.b(b2, 0, length), dVar.a(), dVar.c(), dVar.d());
            b.a(b2, cVar.b(), length);
        }
    }
}
