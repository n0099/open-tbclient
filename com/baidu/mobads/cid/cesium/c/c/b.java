package com.baidu.mobads.cid.cesium.c.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.math.BigInteger;
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static byte[] f42633a;

    /* renamed from: b  reason: collision with root package name */
    public static byte[] f42634b;
    public transient /* synthetic */ FieldHolder $fh;

    public static byte[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            byte[] bArr = f42633a;
            if (bArr != null) {
                return bArr;
            }
            byte[] byteArray = new BigInteger(a.f42628a).modPow(new BigInteger(a.f42629b), new BigInteger(a.f42632e)).toByteArray();
            f42633a = byteArray;
            return byteArray;
        }
        return (byte[]) invokeV.objValue;
    }

    public static byte[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            byte[] bArr = f42634b;
            if (bArr != null) {
                return bArr;
            }
            byte[] byteArray = new BigInteger(a.f42630c).modPow(new BigInteger(a.f42631d), new BigInteger(a.f42632e)).toByteArray();
            f42634b = byteArray;
            return byteArray;
        }
        return (byte[]) invokeV.objValue;
    }
}
