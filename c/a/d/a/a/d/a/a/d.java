package c.a.d.a.a.d.a.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.math.BigInteger;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static byte[] f1736a;
    public transient /* synthetic */ FieldHolder $fh;

    public static byte[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            byte[] bArr = f1736a;
            if (bArr != null) {
                return bArr;
            }
            byte[] byteArray = new BigInteger(c.f1733a).modPow(new BigInteger(c.f1734b), new BigInteger(c.f1735c)).toByteArray();
            f1736a = byteArray;
            return byteArray;
        }
        return (byte[]) invokeV.objValue;
    }
}
