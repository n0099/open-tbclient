package aegon.chrome.net;

import aegon.chrome.base.Log;
import aegon.chrome.base.annotations.CalledByNative;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
/* loaded from: classes.dex */
public class AndroidKeyStore {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public AndroidKeyStore() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @CalledByNative
    public static byte[] encryptWithPrivateKey(PrivateKey privateKey, String str, byte[] bArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, privateKey, str, bArr)) == null) {
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
        return (byte[]) invokeLLL.objValue;
    }

    @CalledByNative
    public static String getPrivateKeyClassName(PrivateKey privateKey) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, privateKey)) == null) ? privateKey.getClass().getName() : (String) invokeL.objValue;
    }

    @CalledByNative
    public static boolean privateKeySupportsCipher(PrivateKey privateKey, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, privateKey, str)) == null) {
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
        return invokeLL.booleanValue;
    }

    @CalledByNative
    public static boolean privateKeySupportsSignature(PrivateKey privateKey, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65540, null, privateKey, str)) == null) {
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
        return invokeLL.booleanValue;
    }

    @CalledByNative
    public static byte[] signWithPrivateKey(PrivateKey privateKey, String str, byte[] bArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, privateKey, str, bArr)) == null) {
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
        return (byte[]) invokeLLL.objValue;
    }
}
