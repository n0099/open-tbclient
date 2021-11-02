package b.a.m.d.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.math.BigInteger;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static byte[] f3411a;

    /* renamed from: b  reason: collision with root package name */
    public static byte[] f3412b;
    public transient /* synthetic */ FieldHolder $fh;

    public static byte[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            byte[] bArr = f3411a;
            if (bArr != null) {
                return bArr;
            }
            byte[] byteArray = new BigInteger(a.f3406a).modPow(new BigInteger(a.f3407b), new BigInteger(a.f3410e)).toByteArray();
            f3411a = byteArray;
            return byteArray;
        }
        return (byte[]) invokeV.objValue;
    }

    public static byte[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            byte[] bArr = f3412b;
            if (bArr != null) {
                return bArr;
            }
            byte[] byteArray = new BigInteger(a.f3408c).modPow(new BigInteger(a.f3409d), new BigInteger(a.f3410e)).toByteArray();
            f3412b = byteArray;
            return byteArray;
        }
        return (byte[]) invokeV.objValue;
    }
}
