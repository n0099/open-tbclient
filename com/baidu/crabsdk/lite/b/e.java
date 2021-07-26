package com.baidu.crabsdk.lite.b;

import android.util.Base64;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yy.hiidostatis.inner.util.cipher.RsaCipher;
import java.io.ByteArrayOutputStream;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
/* loaded from: classes2.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static String f4766a = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDcNo7OFl4AMWXHXHQ/Uyr5Qwmi1EJXbxtkWHQPiT3tBxAgCApZyZXI8Sc0L+g2e3csrK+Mi/uD0W7AFmxdqSunmbiCEP4N8o5+X8NyREPRofM8cfFtIY/kHemCWR65V69FLv++/tPp5DlJQaHERWIvWL5aJXNGhUNzqUQMjRzEPwIDAQAB";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1349384785, "Lcom/baidu/crabsdk/lite/b/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1349384785, "Lcom/baidu/crabsdk/lite/b/e;");
        }
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65537, null, str)) != null) {
            return (String) invokeL.objValue;
        }
        byte[] bytes = str.getBytes();
        PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(f4766a, 0)));
        Cipher cipher = Cipher.getInstance(RsaCipher.RSA_PADDING);
        cipher.init(1, generatePublic);
        int length = bytes.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = length - i2;
            if (i4 <= 0) {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return Base64.encodeToString(byteArray, 2);
            }
            byte[] doFinal = i4 > 117 ? cipher.doFinal(bytes, i2, 117) : cipher.doFinal(bytes, i2, i4);
            byteArrayOutputStream.write(doFinal, 0, doFinal.length);
            i3++;
            i2 = i3 * 117;
        }
    }
}
