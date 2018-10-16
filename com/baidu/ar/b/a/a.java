package com.baidu.ar.b.a;

import com.baidu.ar.util.IoUtils;
import com.baidu.sapi2.utils.SapiEnv;
import com.baidu.searchbox.ng.ai.apps.util.AiAppEncryptUtils;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes3.dex */
public class a {
    public static String a(String str, String str2) {
        byte[] bytes = str.getBytes(IoUtils.UTF_8);
        SecretKeySpec secretKeySpec = new SecretKeySpec(MessageDigest.getInstance(AiAppEncryptUtils.ENCRYPT_MD5).digest(str2.getBytes(IoUtils.UTF_8)), SapiEnv.SHARE_ALGORITHM);
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(1, secretKeySpec);
        byte[] bArr = new byte[cipher.getOutputSize(bytes.length)];
        int update = cipher.update(bytes, 0, bytes.length, bArr, 0);
        int doFinal = cipher.doFinal(bArr, update) + update;
        return a(bArr);
    }

    private static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                hexString = '0' + hexString;
            }
            stringBuffer.append(hexString);
        }
        return stringBuffer.toString();
    }
}
