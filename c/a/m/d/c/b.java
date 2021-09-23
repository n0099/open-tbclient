package c.a.m.d.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.math.BigInteger;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static byte[] f4004a;

    /* renamed from: b  reason: collision with root package name */
    public static byte[] f4005b;
    public transient /* synthetic */ FieldHolder $fh;

    public static byte[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            byte[] bArr = f4004a;
            if (bArr != null) {
                return bArr;
            }
            byte[] byteArray = new BigInteger(a.f3999a).modPow(new BigInteger(a.f4000b), new BigInteger(a.f4003e)).toByteArray();
            f4004a = byteArray;
            return byteArray;
        }
        return (byte[]) invokeV.objValue;
    }

    public static byte[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            byte[] bArr = f4005b;
            if (bArr != null) {
                return bArr;
            }
            byte[] byteArray = new BigInteger(a.f4001c).modPow(new BigInteger(a.f4002d), new BigInteger(a.f4003e)).toByteArray();
            f4005b = byteArray;
            return byteArray;
        }
        return (byte[]) invokeV.objValue;
    }
}
