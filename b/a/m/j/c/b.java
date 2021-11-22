package b.a.m.j.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.math.BigInteger;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static byte[] f3530a;

    /* renamed from: b  reason: collision with root package name */
    public static byte[] f3531b;
    public transient /* synthetic */ FieldHolder $fh;

    public static byte[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            byte[] bArr = f3531b;
            if (bArr != null) {
                return bArr;
            }
            byte[] byteArray = new BigInteger(a.f3527c).modPow(new BigInteger(a.f3528d), new BigInteger(a.f3529e)).toByteArray();
            f3531b = byteArray;
            return byteArray;
        }
        return (byte[]) invokeV.objValue;
    }

    public static byte[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            byte[] bArr = f3530a;
            if (bArr != null) {
                return bArr;
            }
            byte[] byteArray = new BigInteger(a.f3525a).modPow(new BigInteger(a.f3526b), new BigInteger(a.f3529e)).toByteArray();
            f3530a = byteArray;
            return byteArray;
        }
        return (byte[]) invokeV.objValue;
    }
}
