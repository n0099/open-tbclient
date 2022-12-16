package com.alipay.sdk.encrypt;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "RSA";
    public transient /* synthetic */ FieldHolder $fh;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:19:0x0043 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0059 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] a(String str, String str2) {
        InterceptResult invokeLL;
        ByteArrayOutputStream byteArrayOutputStream;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            byte[] bArr = null;
            bArr = null;
            bArr = null;
            ?? r0 = 0;
            try {
                try {
                    try {
                        PublicKey b = b("RSA", str2);
                        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                        cipher.init(1, b);
                        byte[] bytes = str.getBytes("UTF-8");
                        int blockSize = cipher.getBlockSize();
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        for (int i2 = 0; i2 < bytes.length; i2 += blockSize) {
                            try {
                                if (bytes.length - i2 < blockSize) {
                                    i = bytes.length - i2;
                                } else {
                                    i = blockSize;
                                }
                                byteArrayOutputStream.write(cipher.doFinal(bytes, i2, i));
                            } catch (Exception e) {
                                e = e;
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
                        r0 = interceptable;
                        if (r0 != 0) {
                            try {
                                r0.close();
                            } catch (IOException e2) {
                                com.alipay.sdk.util.c.a(e2);
                            }
                        }
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    byteArrayOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    if (r0 != 0) {
                    }
                    throw th;
                }
            } catch (IOException e4) {
                com.alipay.sdk.util.c.a(e4);
            }
            return bArr;
        }
        return (byte[]) invokeLL.objValue;
    }

    public static PublicKey b(String str, String str2) throws NoSuchAlgorithmException, Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            return KeyFactory.getInstance(str).generatePublic(new X509EncodedKeySpec(a.a(str2)));
        }
        return (PublicKey) invokeLL.objValue;
    }
}
