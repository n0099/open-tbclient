package com.baidu.appsearchlib;

import android.util.Base64;
import com.baidu.sapi2.utils.e;
import java.io.UnsupportedEncodingException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes10.dex */
public class Encryption {
    private static SecretKeySpec createKey(String str) {
        byte[] bArr = null;
        if (str == null) {
            str = "";
        }
        StringBuffer stringBuffer = new StringBuffer(16);
        stringBuffer.append(str);
        while (stringBuffer.length() < 16) {
            stringBuffer.append("\u0000");
        }
        if (stringBuffer.length() > 16) {
            stringBuffer.setLength(16);
        }
        try {
            bArr = stringBuffer.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return new SecretKeySpec(bArr, e.q);
    }

    public static String desEncrypt(String str) throws Exception {
        try {
            byte[] decode = Base64.decode(str, 0);
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            cipher.init(2, createKey(Info.PASSWORD), new IvParameterSpec(Info.IV.getBytes()));
            return new String(cipher.doFinal(decode), "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
