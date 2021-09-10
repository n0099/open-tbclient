package c.a.r.g.b.d.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.math.BigInteger;
/* loaded from: classes3.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static byte[] f15429a;

    /* renamed from: b  reason: collision with root package name */
    public static byte[] f15430b;
    public transient /* synthetic */ FieldHolder $fh;

    public static byte[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            byte[] bArr = f15430b;
            if (bArr != null) {
                return bArr;
            }
            byte[] byteArray = new BigInteger(c.f15426c).modPow(new BigInteger(c.f15427d), new BigInteger(c.f15428e)).toByteArray();
            f15430b = byteArray;
            return byteArray;
        }
        return (byte[]) invokeV.objValue;
    }

    public static byte[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            byte[] bArr = f15429a;
            if (bArr != null) {
                return bArr;
            }
            byte[] byteArray = new BigInteger(c.f15424a).modPow(new BigInteger(c.f15425b), new BigInteger(c.f15428e)).toByteArray();
            f15429a = byteArray;
            return byteArray;
        }
        return (byte[]) invokeV.objValue;
    }
}
