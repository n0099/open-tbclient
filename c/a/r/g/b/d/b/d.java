package c.a.r.g.b.d.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.math.BigInteger;
/* loaded from: classes4.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static byte[] f29317a;

    /* renamed from: b  reason: collision with root package name */
    public static byte[] f29318b;
    public transient /* synthetic */ FieldHolder $fh;

    public static byte[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            byte[] bArr = f29318b;
            if (bArr != null) {
                return bArr;
            }
            byte[] byteArray = new BigInteger(c.f29314c).modPow(new BigInteger(c.f29315d), new BigInteger(c.f29316e)).toByteArray();
            f29318b = byteArray;
            return byteArray;
        }
        return (byte[]) invokeV.objValue;
    }

    public static byte[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            byte[] bArr = f29317a;
            if (bArr != null) {
                return bArr;
            }
            byte[] byteArray = new BigInteger(c.f29312a).modPow(new BigInteger(c.f29313b), new BigInteger(c.f29316e)).toByteArray();
            f29317a = byteArray;
            return byteArray;
        }
        return (byte[]) invokeV.objValue;
    }
}
