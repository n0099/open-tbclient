package c.a.l.j.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.math.BigInteger;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static byte[] a;

    /* renamed from: b  reason: collision with root package name */
    public static byte[] f3791b;
    public transient /* synthetic */ FieldHolder $fh;

    public static byte[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            byte[] bArr = f3791b;
            if (bArr != null) {
                return bArr;
            }
            byte[] byteArray = new BigInteger(a.f3788c).modPow(new BigInteger(a.f3789d), new BigInteger(a.f3790e)).toByteArray();
            f3791b = byteArray;
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
            byte[] byteArray = new BigInteger(a.a).modPow(new BigInteger(a.f3787b), new BigInteger(a.f3790e)).toByteArray();
            a = byteArray;
            return byteArray;
        }
        return (byte[]) invokeV.objValue;
    }
}
