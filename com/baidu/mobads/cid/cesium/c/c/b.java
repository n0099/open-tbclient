package com.baidu.mobads.cid.cesium.c.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.math.BigInteger;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static byte[] f40637a;

    /* renamed from: b  reason: collision with root package name */
    public static byte[] f40638b;
    public transient /* synthetic */ FieldHolder $fh;

    public static byte[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            byte[] bArr = f40637a;
            if (bArr != null) {
                return bArr;
            }
            byte[] byteArray = new BigInteger(a.f40632a).modPow(new BigInteger(a.f40633b), new BigInteger(a.f40636e)).toByteArray();
            f40637a = byteArray;
            return byteArray;
        }
        return (byte[]) invokeV.objValue;
    }

    public static byte[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            byte[] bArr = f40638b;
            if (bArr != null) {
                return bArr;
            }
            byte[] byteArray = new BigInteger(a.f40634c).modPow(new BigInteger(a.f40635d), new BigInteger(a.f40636e)).toByteArray();
            f40638b = byteArray;
            return byteArray;
        }
        return (byte[]) invokeV.objValue;
    }
}
