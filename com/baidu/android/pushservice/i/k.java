package com.baidu.android.pushservice.i;

import android.util.Base64;
import com.baidu.android.common.security.RSAUtil;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static JSONArray a(String str, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65536, null, str, i, i2)) == null) {
            JSONArray jSONArray = new JSONArray();
            int length = str.length() / 100;
            int length2 = str.length() % 100;
            if (length2 != 0) {
                length++;
            }
            int i3 = 0;
            while (i3 < length) {
                JSONObject jSONObject = new JSONObject();
                try {
                    String encodeToString = Base64.encodeToString(a(str.substring(i3 * 100, (i3 != length + (-1) || length2 == 0) ? (i3 + 1) * 100 : str.length()).getBytes(), BaiduAppSSOJni.getPublicKey(i)), i2);
                    jSONObject.put("data", encodeToString);
                    jSONObject.put("data_len", encodeToString.length());
                    jSONArray.put(jSONObject);
                } catch (Exception unused) {
                }
                i3++;
            }
            return jSONArray;
        }
        return (JSONArray) invokeLII.objValue;
    }

    public static boolean a(byte[] bArr, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, bArr, str, str2)) == null) {
            try {
                PublicKey generatePublic = KeyFactory.getInstance(RSAUtil.ALGORITHM_RSA).generatePublic(new X509EncodedKeySpec(Base64.decode(str2, 2)));
                Signature signature = Signature.getInstance("SHA1WithRSA");
                signature.initVerify(generatePublic);
                signature.update(bArr);
                return signature.verify(Base64.decode(str, 2));
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public static byte[] a(byte[] bArr, String str) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, bArr, str)) == null) {
            PublicKey generatePublic = KeyFactory.getInstance(RSAUtil.ALGORITHM_RSA).generatePublic(new X509EncodedKeySpec(Base64.decode(str, 2)));
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, generatePublic);
            return cipher.doFinal(bArr);
        }
        return (byte[]) invokeLL.objValue;
    }
}
