package b.a.r.g.b.d.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.math.BigInteger;
/* loaded from: classes4.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static byte[] f14539a;

    /* renamed from: b  reason: collision with root package name */
    public static byte[] f14540b;
    public transient /* synthetic */ FieldHolder $fh;

    public static byte[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            byte[] bArr = f14540b;
            if (bArr != null) {
                return bArr;
            }
            byte[] byteArray = new BigInteger(c.f14536c).modPow(new BigInteger(c.f14537d), new BigInteger(c.f14538e)).toByteArray();
            f14540b = byteArray;
            return byteArray;
        }
        return (byte[]) invokeV.objValue;
    }

    public static byte[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            byte[] bArr = f14539a;
            if (bArr != null) {
                return bArr;
            }
            byte[] byteArray = new BigInteger(c.f14534a).modPow(new BigInteger(c.f14535b), new BigInteger(c.f14538e)).toByteArray();
            f14539a = byteArray;
            return byteArray;
        }
        return (byte[]) invokeV.objValue;
    }
}
