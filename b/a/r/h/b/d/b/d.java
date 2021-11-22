package b.a.r.h.b.d.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.math.BigInteger;
/* loaded from: classes4.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static byte[] f15360a;

    /* renamed from: b  reason: collision with root package name */
    public static byte[] f15361b;
    public transient /* synthetic */ FieldHolder $fh;

    public static byte[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            byte[] bArr = f15361b;
            if (bArr != null) {
                return bArr;
            }
            byte[] byteArray = new BigInteger(c.f15357c).modPow(new BigInteger(c.f15358d), new BigInteger(c.f15359e)).toByteArray();
            f15361b = byteArray;
            return byteArray;
        }
        return (byte[]) invokeV.objValue;
    }

    public static byte[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            byte[] bArr = f15360a;
            if (bArr != null) {
                return bArr;
            }
            byte[] byteArray = new BigInteger(c.f15355a).modPow(new BigInteger(c.f15356b), new BigInteger(c.f15359e)).toByteArray();
            f15360a = byteArray;
            return byteArray;
        }
        return (byte[]) invokeV.objValue;
    }
}
