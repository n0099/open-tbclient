package com.baidu.mobads.cid.cesium.c.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.math.BigInteger;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static byte[] f41469a;

    /* renamed from: b  reason: collision with root package name */
    public static byte[] f41470b;
    public transient /* synthetic */ FieldHolder $fh;

    public static byte[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            byte[] bArr = f41469a;
            if (bArr != null) {
                return bArr;
            }
            byte[] byteArray = new BigInteger(a.f41464a).modPow(new BigInteger(a.f41465b), new BigInteger(a.f41468e)).toByteArray();
            f41469a = byteArray;
            return byteArray;
        }
        return (byte[]) invokeV.objValue;
    }

    public static byte[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            byte[] bArr = f41470b;
            if (bArr != null) {
                return bArr;
            }
            byte[] byteArray = new BigInteger(a.f41466c).modPow(new BigInteger(a.f41467d), new BigInteger(a.f41468e)).toByteArray();
            f41470b = byteArray;
            return byteArray;
        }
        return (byte[]) invokeV.objValue;
    }
}
