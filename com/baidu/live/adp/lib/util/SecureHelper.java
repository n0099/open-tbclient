package com.baidu.live.adp.lib.util;

import com.baidu.android.imsdk.internal.Constants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.zip.CRC32;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
/* loaded from: classes2.dex */
public class SecureHelper {
    public static final int AES256_PASSWORD_LENGTH = 32;
    public static final String CIPHER_TRIPLE_AES = "AES/ECB/PKCS5Padding";
    public static final Charset defaultCharset = Charset.forName("UTF-8");
    private static final byte[] salt = {-92, Constants.GZIP_CAST_TYPE, -56, 52, -42, -107, -13, 19};

    public static long crc32File(File file) throws IOException {
        FileInputStream fileInputStream;
        CRC32 crc32 = new CRC32();
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = fileInputStream.read(bArr, 0, bArr.length);
                    if (read == -1) {
                        break;
                    }
                    crc32.update(bArr, 0, read);
                }
                long value = crc32.getValue();
                try {
                    fileInputStream.close();
                } catch (Exception e) {
                }
                return value;
            } catch (Throwable th) {
                th = th;
                try {
                    fileInputStream.close();
                } catch (Exception e2) {
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
    }

    public static long crc32FileWithMemoryMap(File file) throws IOException {
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                FileChannel channel = fileInputStream2.getChannel();
                CRC32 crc32 = new CRC32();
                int size = (int) channel.size();
                MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, 0L, size);
                for (int i = 0; i < size; i++) {
                    crc32.update(map.get(i));
                }
                long value = crc32.getValue();
                crc32.reset();
                map.clear();
                channel.close();
                try {
                    fileInputStream2.close();
                } catch (Exception e) {
                }
                return value;
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                try {
                    fileInputStream.close();
                } catch (Exception e2) {
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static PublicKey loadRSAPublicKey(byte[] bArr) throws Exception {
        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArr));
    }

    public static PublicKey loadRSAPublicKey(InputStream inputStream) throws Exception {
        return loadRSAPublicKey(readBytes(inputStream));
    }

    public static PrivateKey loadRSAPrivateKey(InputStream inputStream) throws Exception {
        return KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(readBytes(inputStream)));
    }

    public static byte[] readBytes(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
        } catch (Throwable th) {
            th = th;
            byteArrayOutputStream = null;
        }
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int read = inputStream.read(bArr, 0, 4096);
                if (read == -1) {
                    break;
                } else if (read > 0) {
                    byteArrayOutputStream.write(bArr, 0, read);
                }
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
                inputStream.close();
            } catch (Exception e) {
            }
            return byteArray;
        } catch (Throwable th2) {
            th = th2;
            try {
                byteArrayOutputStream.close();
                inputStream.close();
            } catch (Exception e2) {
            }
            throw th;
        }
    }

    public static KeyPair createKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(1024);
        return keyPairGenerator.generateKeyPair();
    }

    public static byte[] toEncoded(PublicKey publicKey) {
        return new X509EncodedKeySpec(publicKey.getEncoded()).getEncoded();
    }

    public static byte[] encryptWithRSA(PublicKey publicKey, byte[] bArr) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(1, publicKey);
        return cipher.doFinal(bArr);
    }

    public static byte[] encryptWithRSA(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        return encryptWithRSA(KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArr)), bArr2);
    }

    public static byte[] decryptWithRSA(Key key, byte[] bArr) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(2, key);
        return cipher.doFinal(bArr);
    }

    public static SecretKey newAESKey(String str) throws NoSuchAlgorithmException, InvalidKeySpecException {
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        char[] cArr = new char[str.length()];
        for (int i = 0; i < cArr.length; i++) {
            cArr[i] = (char) (((byte) str.charAt(i)) & 255);
        }
        return secretKeyFactory.generateSecret(new PBEKeySpec(cArr, salt, 5, 256));
    }

    public static byte[] encryptWithAES(SecretKey secretKey, byte[] bArr) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance(CIPHER_TRIPLE_AES);
        cipher.init(1, secretKey);
        return cipher.doFinal(bArr);
    }

    public static byte[] decryptWithAES(SecretKey secretKey, byte[] bArr) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance(CIPHER_TRIPLE_AES);
        cipher.init(2, secretKey);
        return cipher.doFinal(bArr);
    }

    public static byte[] decryptWithAES(SecretKey secretKey, byte[] bArr, int i, int i2) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance(CIPHER_TRIPLE_AES);
        cipher.init(2, secretKey);
        return cipher.doFinal(bArr, i, i2);
    }

    public static String newRandomString(int i) {
        String bigInteger = new BigInteger(i * 5, new SecureRandom()).toString(36);
        if (bigInteger.length() > i) {
            return bigInteger.substring(0, bigInteger.length());
        }
        return bigInteger;
    }
}
