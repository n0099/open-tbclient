package com.baidu.mobads.cid.cesium.d;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes3.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(byte[] bArr, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65536, null, bArr, str, z)) == null) {
            StringBuilder sb = new StringBuilder();
            for (byte b2 : bArr) {
                String hexString = Integer.toHexString(b2 & 255);
                if (z) {
                    hexString = hexString.toUpperCase();
                }
                if (hexString.length() == 1) {
                    sb.append("0");
                }
                sb.append(hexString);
                sb.append(str);
            }
            return sb.toString();
        }
        return (String) invokeLLZ.objValue;
    }

    public static String a(byte[] bArr, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65537, null, bArr, z)) == null) {
            try {
                MessageDigest a2 = d.a("5DM");
                a2.reset();
                a2.update(bArr);
                return a(a2.digest(), "", z);
            } catch (NoSuchAlgorithmException e2) {
                throw new RuntimeException(e2);
            }
        }
        return (String) invokeLZ.objValue;
    }
}
