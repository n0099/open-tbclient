package com.baidu.crabsdk.lite.b;

import android.util.Base64;
import com.baidu.crabsdk.lite.a.g;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes3.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Key a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            try {
                return new SecretKeySpec(str.getBytes(), "AES");
            } catch (Exception e2) {
                e2.printStackTrace();
                throw e2;
            }
        }
        return (Key) invokeL.objValue;
    }

    public static String b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            return g.b(str + str2);
        }
        return (String) invokeLL.objValue;
    }

    public static byte[] c(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            try {
                String substring = str2.substring(0, 16);
                String substring2 = str2.substring(str2.length() - 16, str2.length());
                Key a2 = a(substring);
                Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
                int blockSize = cipher.getBlockSize();
                byte[] bytes = str.getBytes();
                int length = bytes.length;
                if (length % blockSize != 0) {
                    length += blockSize - (length % blockSize);
                }
                byte[] bArr = new byte[length];
                System.arraycopy(bytes, 0, bArr, 0, bytes.length);
                cipher.init(1, a2, new IvParameterSpec(substring2.getBytes()));
                return cipher.doFinal(bArr);
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (byte[]) invokeLL.objValue;
    }

    public static String d(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) ? Base64.encodeToString(c(str, str2), 0) : (String) invokeLL.objValue;
    }
}
