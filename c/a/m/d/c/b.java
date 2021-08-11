package c.a.m.d.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.math.BigInteger;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static byte[] f4023a;

    /* renamed from: b  reason: collision with root package name */
    public static byte[] f4024b;
    public transient /* synthetic */ FieldHolder $fh;

    public static byte[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            byte[] bArr = f4023a;
            if (bArr != null) {
                return bArr;
            }
            byte[] byteArray = new BigInteger(a.f4018a).modPow(new BigInteger(a.f4019b), new BigInteger(a.f4022e)).toByteArray();
            f4023a = byteArray;
            return byteArray;
        }
        return (byte[]) invokeV.objValue;
    }

    public static byte[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            byte[] bArr = f4024b;
            if (bArr != null) {
                return bArr;
            }
            byte[] byteArray = new BigInteger(a.f4020c).modPow(new BigInteger(a.f4021d), new BigInteger(a.f4022e)).toByteArray();
            f4024b = byteArray;
            return byteArray;
        }
        return (byte[]) invokeV.objValue;
    }
}
