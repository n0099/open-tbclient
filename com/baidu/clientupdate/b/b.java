package com.baidu.clientupdate.b;

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
/* loaded from: classes.dex */
public class b {
    public static RSAPublicKey a(String str) {
        try {
            return (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(a.a(str)));
        } catch (NullPointerException unused) {
            throw new Exception("公钥数据为空");
        } catch (NoSuchAlgorithmException unused2) {
            throw new Exception("无此算法");
        } catch (InvalidKeySpecException unused3) {
            throw new Exception("公钥非法");
        }
    }

    public static byte[] a(RSAPublicKey rSAPublicKey, byte[] bArr) {
        if (rSAPublicKey != null) {
            try {
                Cipher cipher = Cipher.getInstance("RSA");
                cipher.init(2, rSAPublicKey);
                return cipher.doFinal(bArr);
            } catch (InvalidKeyException unused) {
                throw new Exception("解密公钥非法,请检查");
            } catch (NoSuchAlgorithmException unused2) {
                throw new Exception("无此解密算法");
            } catch (BadPaddingException unused3) {
                throw new Exception("密文数据已损坏");
            } catch (IllegalBlockSizeException unused4) {
                throw new Exception("密文长度非法");
            } catch (NoSuchPaddingException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        throw new Exception("解密公钥为空, 请设置");
    }
}
