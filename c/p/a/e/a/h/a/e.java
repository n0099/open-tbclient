package c.p.a.e.a.h.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes4.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int[] f34789a;

    /* renamed from: b  reason: collision with root package name */
    public int[] f34790b;

    public e() {
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

    public static final int a(int[] iArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, iArr, i2)) == null) {
            int i3 = iArr[i2 / 4];
            return (i2 % 4) / 2 == 0 ? i3 & 65535 : i3 >>> 16;
        }
        return invokeLI.intValue;
    }

    public static e b(c cVar) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, cVar)) == null) {
            b.a(cVar, 1835009);
            int e2 = cVar.e();
            int e3 = cVar.e();
            int e4 = cVar.e();
            cVar.e();
            int e5 = cVar.e();
            int e6 = cVar.e();
            e eVar = new e();
            eVar.f34789a = cVar.f(e3);
            if (e4 != 0) {
                cVar.f(e4);
            }
            int i2 = (e6 == 0 ? e2 : e6) - e5;
            if (i2 % 4 == 0) {
                eVar.f34790b = cVar.f(i2 / 4);
                if (e6 != 0) {
                    int i3 = e2 - e6;
                    if (i3 % 4 == 0) {
                        cVar.f(i3 / 4);
                    } else {
                        throw new IOException("Style data size is not multiple of 4 (" + i3 + ").");
                    }
                }
                return eVar;
            }
            throw new IOException("String data size is not multiple of 4 (" + i2 + ").");
        }
        return (e) invokeL.objValue;
    }

    public String c(int i2) {
        InterceptResult invokeI;
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (i2 < 0 || (iArr = this.f34789a) == null || i2 >= iArr.length) {
                return null;
            }
            int i3 = iArr[i2];
            int a2 = a(this.f34790b, i3);
            StringBuilder sb = new StringBuilder(a2);
            while (a2 != 0) {
                i3 += 2;
                sb.append((char) a(this.f34790b, i3));
                a2--;
            }
            return sb.toString();
        }
        return (String) invokeI.objValue;
    }
}
