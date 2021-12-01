package c.a.q.h.b.d.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.math.BigInteger;
/* loaded from: classes5.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public static byte[] a;

    /* renamed from: b  reason: collision with root package name */
    public static byte[] f11470b;
    public transient /* synthetic */ FieldHolder $fh;

    public static byte[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            byte[] bArr = f11470b;
            if (bArr != null) {
                return bArr;
            }
            byte[] byteArray = new BigInteger(c.f11467c).modPow(new BigInteger(c.f11468d), new BigInteger(c.f11469e)).toByteArray();
            f11470b = byteArray;
            return byteArray;
        }
        return (byte[]) invokeV.objValue;
    }

    public static byte[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            byte[] bArr = a;
            if (bArr != null) {
                return bArr;
            }
            byte[] byteArray = new BigInteger(c.a).modPow(new BigInteger(c.f11466b), new BigInteger(c.f11469e)).toByteArray();
            a = byteArray;
            return byteArray;
        }
        return (byte[]) invokeV.objValue;
    }
}
