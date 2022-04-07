package com.baidu.searchbox.retrieve.file.util;

import android.util.Base64;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.inner.util.cipher.Coder;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes2.dex */
public class DESUtil {
    public static /* synthetic */ Interceptable $ic;
    public static byte[] iv;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-154005190, "Lcom/baidu/searchbox/retrieve/file/util/DESUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-154005190, "Lcom/baidu/searchbox/retrieve/file/util/DESUtil;");
                return;
            }
        }
        iv = new byte[]{1, 2, 3, 4, 5, 6, 7, 8};
    }

    public DESUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String decryptDES(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            try {
                byte[] decode = Base64.decode(str, 0);
                IvParameterSpec ivParameterSpec = new IvParameterSpec(str2.getBytes());
                SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), Coder.KEY_DES);
                Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
                cipher.init(2, secretKeySpec, ivParameterSpec);
                return new String(cipher.doFinal(decode));
            } catch (InvalidAlgorithmParameterException e) {
                e.printStackTrace();
                return null;
            } catch (InvalidKeyException e2) {
                e2.printStackTrace();
                return null;
            } catch (NoSuchAlgorithmException e3) {
                e3.printStackTrace();
                return null;
            } catch (BadPaddingException e4) {
                e4.printStackTrace();
                return null;
            } catch (IllegalBlockSizeException e5) {
                e5.printStackTrace();
                return null;
            } catch (NoSuchPaddingException e6) {
                e6.printStackTrace();
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String encryptDES(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            try {
                IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
                SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), Coder.KEY_DES);
                Cipher cipher = Cipher.getInstance("DES/CBC/PKCS7Padding");
                cipher.init(1, secretKeySpec, ivParameterSpec);
                return Base64.encodeToString(cipher.doFinal(str.getBytes()), 0);
            } catch (InvalidAlgorithmParameterException e) {
                e.printStackTrace();
                return null;
            } catch (InvalidKeyException e2) {
                e2.printStackTrace();
                return null;
            } catch (NoSuchAlgorithmException e3) {
                e3.printStackTrace();
                return null;
            } catch (BadPaddingException e4) {
                e4.printStackTrace();
                return null;
            } catch (IllegalBlockSizeException e5) {
                e5.printStackTrace();
                return null;
            } catch (NoSuchPaddingException e6) {
                e6.printStackTrace();
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }
}
