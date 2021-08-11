package com.baidu.mobstat.dxmpay;

import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.security.MessageDigest;
/* loaded from: classes5.dex */
public final class s {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static String a(byte[] bArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
                try {
                    return s.b(MessageDigest.getInstance(PackageTable.MD5), bArr);
                } catch (Exception unused) {
                    return "";
                }
            }
            return (String) invokeL.objValue;
        }
    }

    public static String b(MessageDigest messageDigest, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, messageDigest, bArr)) == null) {
            messageDigest.update(bArr);
            return a(messageDigest.digest());
        }
        return (String) invokeLL.objValue;
    }

    public static String a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bArr)) == null) {
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < bArr.length; i2++) {
                int i3 = (bArr[i2] >> 4) & 15;
                int i4 = bArr[i2] & 15;
                sb.append((char) (i3 >= 10 ? (i3 + 97) - 10 : i3 + 48));
                sb.append((char) (i4 >= 10 ? (i4 + 97) - 10 : i4 + 48));
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }
}
