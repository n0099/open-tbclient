package aegon.chrome.net;

import aegon.chrome.base.Log;
import aegon.chrome.base.annotations.CalledByNative;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
/* loaded from: classes.dex */
public class AndroidKeyStore {
    @CalledByNative
    public static byte[] encryptWithPrivateKey(PrivateKey privateKey, String str, byte[] bArr) {
        try {
            Cipher cipher = Cipher.getInstance(str);
            try {
                cipher.init(1, privateKey);
                return cipher.doFinal(bArr);
            } catch (Exception e2) {
                Log.e("AndroidKeyStore", "Exception while encrypting input with " + str + " and " + privateKey.getAlgorithm() + " private key (" + privateKey.getClass().getName() + "): " + e2, new Object[0]);
                return null;
            }
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e3) {
            Log.e("AndroidKeyStore", "Cipher " + str + " not supported: " + e3, new Object[0]);
            return null;
        }
    }

    @CalledByNative
    public static String getPrivateKeyClassName(PrivateKey privateKey) {
        return privateKey.getClass().getName();
    }

    @CalledByNative
    public static boolean privateKeySupportsCipher(PrivateKey privateKey, String str) {
        try {
            Cipher.getInstance(str).init(1, privateKey);
            return true;
        } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException unused) {
            return false;
        } catch (Exception e2) {
            Log.e("AndroidKeyStore", "Exception while checking support for " + str + ": " + e2, new Object[0]);
            return false;
        }
    }

    @CalledByNative
    public static boolean privateKeySupportsSignature(PrivateKey privateKey, String str) {
        try {
            Signature.getInstance(str).initSign(privateKey);
            return true;
        } catch (InvalidKeyException | NoSuchAlgorithmException unused) {
            return false;
        } catch (Exception e2) {
            Log.e("AndroidKeyStore", "Exception while checking support for " + str + ": " + e2, new Object[0]);
            return false;
        }
    }

    @CalledByNative
    public static byte[] signWithPrivateKey(PrivateKey privateKey, String str, byte[] bArr) {
        try {
            Signature signature = Signature.getInstance(str);
            try {
                signature.initSign(privateKey);
                signature.update(bArr);
                return signature.sign();
            } catch (Exception e2) {
                Log.e("AndroidKeyStore", "Exception while signing message with " + str + " and " + privateKey.getAlgorithm() + " private key (" + privateKey.getClass().getName() + "): " + e2, new Object[0]);
                return null;
            }
        } catch (NoSuchAlgorithmException e3) {
            Log.e("AndroidKeyStore", "Signature algorithm " + str + " not supported: " + e3, new Object[0]);
            return null;
        }
    }
}
