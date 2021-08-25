package c.a.r.g.b.d.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.math.BigInteger;
/* loaded from: classes4.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static byte[] f29599a;

    /* renamed from: b  reason: collision with root package name */
    public static byte[] f29600b;
    public transient /* synthetic */ FieldHolder $fh;

    public static byte[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            byte[] bArr = f29600b;
            if (bArr != null) {
                return bArr;
            }
            byte[] byteArray = new BigInteger(c.f29596c).modPow(new BigInteger(c.f29597d), new BigInteger(c.f29598e)).toByteArray();
            f29600b = byteArray;
            return byteArray;
        }
        return (byte[]) invokeV.objValue;
    }

    public static byte[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            byte[] bArr = f29599a;
            if (bArr != null) {
                return bArr;
            }
            byte[] byteArray = new BigInteger(c.f29594a).modPow(new BigInteger(c.f29595b), new BigInteger(c.f29598e)).toByteArray();
            f29599a = byteArray;
            return byteArray;
        }
        return (byte[]) invokeV.objValue;
    }
}
