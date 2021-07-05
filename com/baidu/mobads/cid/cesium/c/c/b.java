package com.baidu.mobads.cid.cesium.c.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.math.BigInteger;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static byte[] f8298a;

    /* renamed from: b  reason: collision with root package name */
    public static byte[] f8299b;
    public transient /* synthetic */ FieldHolder $fh;

    public static byte[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            byte[] bArr = f8298a;
            if (bArr != null) {
                return bArr;
            }
            byte[] byteArray = new BigInteger(a.f8293a).modPow(new BigInteger(a.f8294b), new BigInteger(a.f8297e)).toByteArray();
            f8298a = byteArray;
            return byteArray;
        }
        return (byte[]) invokeV.objValue;
    }

    public static byte[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            byte[] bArr = f8299b;
            if (bArr != null) {
                return bArr;
            }
            byte[] byteArray = new BigInteger(a.f8295c).modPow(new BigInteger(a.f8296d), new BigInteger(a.f8297e)).toByteArray();
            f8299b = byteArray;
            return byteArray;
        }
        return (byte[]) invokeV.objValue;
    }
}
