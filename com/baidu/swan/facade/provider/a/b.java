package com.baidu.swan.facade.provider.a;

import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.common.security.RSAUtil;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
/* loaded from: classes16.dex */
public class b {
    public static byte[] a(byte[] bArr, String str, int i) {
        PublicKey uA;
        if (bArr == null || bArr.length == 0 || TextUtils.isEmpty(str) || i <= 0 || (uA = uA(str)) == null) {
            return null;
        }
        return a(bArr, uA, i);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:39:0x0067 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0050 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static byte[] a(byte[] bArr, Key key, int i) {
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] doFinal;
        byte[] bArr2 = null;
        if (bArr != null && (r2 = bArr.length) != 0 && key != null) {
            try {
                if (i > 0) {
                    try {
                        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                        cipher.init(1, key);
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            int length = bArr.length;
                            int i2 = 0;
                            while (length - i2 > 0) {
                                if (length - i2 > i) {
                                    doFinal = cipher.doFinal(bArr, i2, i);
                                } else {
                                    doFinal = cipher.doFinal(bArr, i2, length - i2);
                                }
                                byteArrayOutputStream.write(doFinal, 0, doFinal.length);
                                i2 += i;
                            }
                            bArr2 = byteArrayOutputStream.toByteArray();
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        } catch (InvalidKeyException e2) {
                            e = e2;
                            e.printStackTrace();
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                            }
                            return bArr2;
                        } catch (NoSuchAlgorithmException e4) {
                            e = e4;
                            e.printStackTrace();
                            if (byteArrayOutputStream != null) {
                            }
                            return bArr2;
                        } catch (BadPaddingException e5) {
                            e = e5;
                            e.printStackTrace();
                            if (byteArrayOutputStream != null) {
                            }
                            return bArr2;
                        } catch (IllegalBlockSizeException e6) {
                            e = e6;
                            e.printStackTrace();
                            if (byteArrayOutputStream != null) {
                            }
                            return bArr2;
                        } catch (NoSuchPaddingException e7) {
                            e = e7;
                            e.printStackTrace();
                            if (byteArrayOutputStream != null) {
                            }
                            return bArr2;
                        }
                    } catch (InvalidKeyException e8) {
                        e = e8;
                        byteArrayOutputStream = null;
                    } catch (NoSuchAlgorithmException e9) {
                        e = e9;
                        byteArrayOutputStream = null;
                    } catch (BadPaddingException e10) {
                        e = e10;
                        byteArrayOutputStream = null;
                    } catch (IllegalBlockSizeException e11) {
                        e = e11;
                        byteArrayOutputStream = null;
                    } catch (NoSuchPaddingException e12) {
                        e = e12;
                        byteArrayOutputStream = null;
                    } catch (Throwable th) {
                        ?? length2 = 0;
                        th = th;
                        if (length2 != 0) {
                            try {
                                length2.close();
                            } catch (IOException e13) {
                                e13.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return bArr2;
    }

    private static PublicKey uA(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return KeyFactory.getInstance(RSAUtil.ALGORITHM_RSA).generatePublic(new X509EncodedKeySpec(Base64.decode(str.getBytes("utf-8"), 0)));
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
            return null;
        }
    }
}
