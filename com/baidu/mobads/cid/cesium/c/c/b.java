package com.baidu.mobads.cid.cesium.c.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.math.BigInteger;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static byte[] f8341a;

    /* renamed from: b  reason: collision with root package name */
    public static byte[] f8342b;
    public transient /* synthetic */ FieldHolder $fh;

    public static byte[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            byte[] bArr = f8341a;
            if (bArr != null) {
                return bArr;
            }
            byte[] byteArray = new BigInteger(a.f8336a).modPow(new BigInteger(a.f8337b), new BigInteger(a.f8340e)).toByteArray();
            f8341a = byteArray;
            return byteArray;
        }
        return (byte[]) invokeV.objValue;
    }

    public static byte[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            byte[] bArr = f8342b;
            if (bArr != null) {
                return bArr;
            }
            byte[] byteArray = new BigInteger(a.f8338c).modPow(new BigInteger(a.f8339d), new BigInteger(a.f8340e)).toByteArray();
            f8342b = byteArray;
            return byteArray;
        }
        return (byte[]) invokeV.objValue;
    }
}
