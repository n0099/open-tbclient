package c.a.r.g.b.d.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.math.BigInteger;
/* loaded from: classes3.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static byte[] f15461a;

    /* renamed from: b  reason: collision with root package name */
    public static byte[] f15462b;
    public transient /* synthetic */ FieldHolder $fh;

    public static byte[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            byte[] bArr = f15462b;
            if (bArr != null) {
                return bArr;
            }
            byte[] byteArray = new BigInteger(c.f15458c).modPow(new BigInteger(c.f15459d), new BigInteger(c.f15460e)).toByteArray();
            f15462b = byteArray;
            return byteArray;
        }
        return (byte[]) invokeV.objValue;
    }

    public static byte[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            byte[] bArr = f15461a;
            if (bArr != null) {
                return bArr;
            }
            byte[] byteArray = new BigInteger(c.f15456a).modPow(new BigInteger(c.f15457b), new BigInteger(c.f15460e)).toByteArray();
            f15461a = byteArray;
            return byteArray;
        }
        return (byte[]) invokeV.objValue;
    }
}
