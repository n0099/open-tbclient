package com.baidu.swan.apps.aq;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.baidu.android.common.security.RSAUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
/* loaded from: classes7.dex */
public class ae {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static boolean e(File file, String str) {
        return a(file, str, (com.baidu.swan.apps.aq.a.c) null);
    }

    public static boolean b(ReadableByteChannel readableByteChannel, String str) throws IOException {
        return a(readableByteChannel, str, (com.baidu.swan.apps.aq.a.c) null);
    }

    public static boolean a(File file, String str, com.baidu.swan.apps.aq.a.c cVar) {
        boolean z = file == null;
        if (z || !file.exists() || TextUtils.isEmpty(str)) {
            if (cVar != null) {
                cVar.cSF = "zipfile: isEmpty=" + z + "; exists=" + (z ? "" : Boolean.valueOf(file.exists()));
            }
            return false;
        }
        ReadableByteChannel readableByteChannel = null;
        try {
            readableByteChannel = Channels.newChannel(new FileInputStream(file));
            return a(readableByteChannel, str, cVar);
        } catch (IOException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return false;
        } finally {
            com.baidu.swan.d.d.closeSafely(readableByteChannel);
        }
    }

    public static boolean a(ReadableByteChannel readableByteChannel, String str, com.baidu.swan.apps.aq.a.c cVar) throws IOException {
        boolean z = readableByteChannel == null;
        if (z || TextUtils.isEmpty(str)) {
            if (cVar != null) {
                cVar.cSF = "zipSource isNullIs=" + z;
                return false;
            }
            return false;
        }
        String a = com.baidu.swan.d.e.a(readableByteChannel, false);
        if (cVar != null) {
            cVar.cSF = a;
        }
        try {
            String str2 = new String(b(Base64.decode(str.getBytes("utf-8"), 8), qD("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDZuy3GEbahJc292fsyvrGneTJKQnzpdhNsJfDS5csb0MtmW+4JEvBH5wCZK5j4+nrRfKBF7JuTHe0nSWOZWNxgLU87pwCxozXSNrsiiOjsV+3KwYfdz5QlvvyCfvmllGObPqL7dWR92V2UYEWMSneBHtwDhCBCzmhAoOxZVsAq2wIDAQAB")), "utf-8");
            if (cVar != null) {
                cVar.cSG = str2;
            }
            return TextUtils.equals(str2, a);
        } catch (Exception e) {
            if (DEBUG) {
                Log.i("SwanAppSignChecker", e.toString());
                e.printStackTrace();
            }
            if (cVar != null) {
                cVar.cSG = e.getLocalizedMessage();
                return false;
            }
            return false;
        }
    }

    private static byte[] b(byte[] bArr, PublicKey publicKey) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(2, publicKey);
        return cipher.doFinal(bArr);
    }

    private static PublicKey qD(String str) {
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
