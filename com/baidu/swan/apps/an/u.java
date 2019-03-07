package com.baidu.swan.apps.an;

import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.common.security.RSAUtil;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
/* loaded from: classes2.dex */
public class u {
    public static boolean c(File file, String str) {
        return a(file, str, null);
    }

    public static boolean a(File file, String str, com.baidu.swan.apps.an.a.c cVar) {
        boolean z = file == null;
        if (z || !file.exists() || TextUtils.isEmpty(str)) {
            if (cVar != null) {
                cVar.aWz = "zipfile: isEmpty=" + z + "; exists=" + (z ? "" : Boolean.valueOf(file.exists()));
            }
            return false;
        }
        String c = com.baidu.swan.c.c.c(file, false);
        if (cVar != null) {
            cVar.aWz = c;
        }
        try {
            String str2 = new String(decryptByPublicKey(Base64.decode(str.getBytes("utf-8"), 8), hC("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDZuy3GEbahJc292fsyvrGneTJKQnzpdhNsJfDS5csb0MtmW+4JEvBH5wCZK5j4+nrRfKBF7JuTHe0nSWOZWNxgLU87pwCxozXSNrsiiOjsV+3KwYfdz5QlvvyCfvmllGObPqL7dWR92V2UYEWMSneBHtwDhCBCzmhAoOxZVsAq2wIDAQAB")), "utf-8");
            if (cVar != null) {
                cVar.aWA = str2;
            }
            return TextUtils.equals(str2, c);
        } catch (Exception e) {
            if (cVar != null) {
                cVar.aWA = e.getLocalizedMessage();
            }
            return false;
        }
    }

    private static byte[] decryptByPublicKey(byte[] bArr, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(2, publicKey);
        return cipher.doFinal(bArr);
    }

    private static PublicKey hC(String str) {
        try {
            return KeyFactory.getInstance(RSAUtil.ALGORITHM_RSA).generatePublic(new X509EncodedKeySpec(Base64.decode(str.getBytes("utf-8"), 0)));
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
