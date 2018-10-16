package com.baidu.searchbox.ng.ai.apps.util;

import android.text.TextUtils;
import android.util.Base64;
import com.baidu.searchbox.ng.ai.apps.util.data.SignDataPicker;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
/* loaded from: classes2.dex */
public class AiAppSignChecker {
    private static final String RSA = "RSA";
    private static final String RSA_ALGORITHM = "RSA/ECB/PKCS1Padding";
    private static final String SIGN_RSA_PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDZuy3GEbahJc292fsyvrGneTJKQnzpdhNsJfDS5csb0MtmW+4JEvBH5wCZK5j4+nrRfKBF7JuTHe0nSWOZWNxgLU87pwCxozXSNrsiiOjsV+3KwYfdz5QlvvyCfvmllGObPqL7dWR92V2UYEWMSneBHtwDhCBCzmhAoOxZVsAq2wIDAQAB";
    private static final String UTF_8 = "utf-8";

    public static boolean checkZipSign(File file, String str) {
        return checkZipSign(file, str, null);
    }

    public static boolean checkZipSign(File file, String str, SignDataPicker signDataPicker) {
        if (file == null || !file.exists() || TextUtils.isEmpty(str)) {
            return false;
        }
        String md5 = AiAppMD5Utils.toMd5(file, false);
        if (signDataPicker != null) {
            signDataPicker.localSign = md5;
        }
        try {
            String str2 = new String(decryptByPublicKey(Base64.decode(str.getBytes("utf-8"), 8), loadPublicKey(SIGN_RSA_PUBLIC_KEY)), "utf-8");
            if (signDataPicker != null) {
                signDataPicker.serverSign = str2;
            }
            return TextUtils.equals(str2, md5);
        } catch (Exception e) {
            if (signDataPicker != null) {
                signDataPicker.serverSign = e.getLocalizedMessage();
                return false;
            }
            return false;
        }
    }

    private static byte[] decryptByPublicKey(byte[] bArr, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
        cipher.init(2, publicKey);
        return cipher.doFinal(bArr);
    }

    private static PublicKey loadPublicKey(String str) {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str.getBytes("utf-8"), 0)));
        } catch (UnsupportedEncodingException e) {
            return null;
        } catch (NullPointerException e2) {
            return null;
        } catch (NoSuchAlgorithmException e3) {
            return null;
        } catch (InvalidKeySpecException e4) {
            return null;
        }
    }
}
