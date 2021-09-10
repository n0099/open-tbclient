package com.baidu.mobads.cid.cesium.c.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.math.BigInteger;
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static byte[] f42855a;

    /* renamed from: b  reason: collision with root package name */
    public static byte[] f42856b;
    public transient /* synthetic */ FieldHolder $fh;

    public static byte[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            byte[] bArr = f42855a;
            if (bArr != null) {
                return bArr;
            }
            byte[] byteArray = new BigInteger(a.f42850a).modPow(new BigInteger(a.f42851b), new BigInteger(a.f42854e)).toByteArray();
            f42855a = byteArray;
            return byteArray;
        }
        return (byte[]) invokeV.objValue;
    }

    public static byte[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            byte[] bArr = f42856b;
            if (bArr != null) {
                return bArr;
            }
            byte[] byteArray = new BigInteger(a.f42852c).modPow(new BigInteger(a.f42853d), new BigInteger(a.f42854e)).toByteArray();
            f42856b = byteArray;
            return byteArray;
        }
        return (byte[]) invokeV.objValue;
    }
}
