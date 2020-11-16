package com.baidu.clientupdate.b;

import com.baidu.android.common.security.RSAUtil;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
/* loaded from: classes14.dex */
public class b {
    public static RSAPublicKey a(String str) {
        try {
            return (RSAPublicKey) KeyFactory.getInstance(RSAUtil.ALGORITHM_RSA).generatePublic(new X509EncodedKeySpec(a.a(str)));
        } catch (NullPointerException e) {
            throw new Exception("公钥数据为空");
        } catch (NoSuchAlgorithmException e2) {
            throw new Exception("无此算法");
        } catch (InvalidKeySpecException e3) {
            throw new Exception("公钥非法");
        }
    }

    public static byte[] a(RSAPublicKey rSAPublicKey, byte[] bArr) {
        if (rSAPublicKey == null) {
            throw new Exception("解密公钥为空, 请设置");
        }
        try {
            Cipher cipher = Cipher.getInstance(RSAUtil.ALGORITHM_RSA);
            cipher.init(2, rSAPublicKey);
            return cipher.doFinal(bArr);
        } catch (InvalidKeyException e) {
            throw new Exception("解密公钥非法,请检查");
        } catch (NoSuchAlgorithmException e2) {
            throw new Exception("无此解密算法");
        } catch (BadPaddingException e3) {
            throw new Exception("密文数据已损坏");
        } catch (IllegalBlockSizeException e4) {
            throw new Exception("密文长度非法");
        } catch (NoSuchPaddingException e5) {
            e5.printStackTrace();
            return null;
        }
    }
}
