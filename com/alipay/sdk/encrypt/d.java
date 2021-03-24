package com.alipay.sdk.encrypt;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final String f1898a = "RSA";

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0052: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:28:0x0052 */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0055 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] a(String str, String str2) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        byte[] bArr = null;
        bArr = null;
        bArr = null;
        ByteArrayOutputStream byteArrayOutputStream3 = null;
        try {
            try {
                try {
                    PublicKey b2 = b("RSA", str2);
                    Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                    cipher.init(1, b2);
                    byte[] bytes = str.getBytes("UTF-8");
                    int blockSize = cipher.getBlockSize();
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    for (int i = 0; i < bytes.length; i += blockSize) {
                        try {
                            byteArrayOutputStream.write(cipher.doFinal(bytes, i, bytes.length - i < blockSize ? bytes.length - i : blockSize));
                        } catch (Exception e2) {
                            e = e2;
                            com.alipay.sdk.util.c.a(e);
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                            return bArr;
                        }
                    }
                    bArr = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream3 = byteArrayOutputStream2;
                    if (byteArrayOutputStream3 != null) {
                        try {
                            byteArrayOutputStream3.close();
                        } catch (IOException e3) {
                            com.alipay.sdk.util.c.a(e3);
                        }
                    }
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                byteArrayOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                if (byteArrayOutputStream3 != null) {
                }
                throw th;
            }
        } catch (IOException e5) {
            com.alipay.sdk.util.c.a(e5);
        }
        return bArr;
    }

    public static PublicKey b(String str, String str2) throws NoSuchAlgorithmException, Exception {
        return KeyFactory.getInstance(str).generatePublic(new X509EncodedKeySpec(a.a(str2)));
    }
}
