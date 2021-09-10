package c.a.m.d.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.math.BigInteger;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static byte[] f4001a;

    /* renamed from: b  reason: collision with root package name */
    public static byte[] f4002b;
    public transient /* synthetic */ FieldHolder $fh;

    public static byte[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            byte[] bArr = f4001a;
            if (bArr != null) {
                return bArr;
            }
            byte[] byteArray = new BigInteger(a.f3996a).modPow(new BigInteger(a.f3997b), new BigInteger(a.f4000e)).toByteArray();
            f4001a = byteArray;
            return byteArray;
        }
        return (byte[]) invokeV.objValue;
    }

    public static byte[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            byte[] bArr = f4002b;
            if (bArr != null) {
                return bArr;
            }
            byte[] byteArray = new BigInteger(a.f3998c).modPow(new BigInteger(a.f3999d), new BigInteger(a.f4000e)).toByteArray();
            f4002b = byteArray;
            return byteArray;
        }
        return (byte[]) invokeV.objValue;
    }
}
