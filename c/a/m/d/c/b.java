package c.a.m.d.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.math.BigInteger;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static byte[] f3998a;

    /* renamed from: b  reason: collision with root package name */
    public static byte[] f3999b;
    public transient /* synthetic */ FieldHolder $fh;

    public static byte[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            byte[] bArr = f3998a;
            if (bArr != null) {
                return bArr;
            }
            byte[] byteArray = new BigInteger(a.f3993a).modPow(new BigInteger(a.f3994b), new BigInteger(a.f3997e)).toByteArray();
            f3998a = byteArray;
            return byteArray;
        }
        return (byte[]) invokeV.objValue;
    }

    public static byte[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            byte[] bArr = f3999b;
            if (bArr != null) {
                return bArr;
            }
            byte[] byteArray = new BigInteger(a.f3995c).modPow(new BigInteger(a.f3996d), new BigInteger(a.f3997e)).toByteArray();
            f3999b = byteArray;
            return byteArray;
        }
        return (byte[]) invokeV.objValue;
    }
}
