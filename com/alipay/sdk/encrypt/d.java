package com.alipay.sdk.encrypt;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.inner.util.cipher.RsaCipher;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
/* loaded from: classes4.dex */
public class d {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f35776a = "RSA";
    public transient /* synthetic */ FieldHolder $fh;

    public d() {
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

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:21:0x0048 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0059 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] a(String str, String str2) {
        InterceptResult invokeLL;
        ByteArrayOutputStream byteArrayOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            byte[] bArr = null;
            bArr = null;
            bArr = null;
            ?? r0 = 0;
            try {
                try {
                    try {
                        PublicKey b2 = b("RSA", str2);
                        Cipher cipher = Cipher.getInstance(RsaCipher.RSA_PADDING);
                        cipher.init(1, b2);
                        byte[] bytes = str.getBytes("UTF-8");
                        int blockSize = cipher.getBlockSize();
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        for (int i2 = 0; i2 < bytes.length; i2 += blockSize) {
                            try {
                                byteArrayOutputStream.write(cipher.doFinal(bytes, i2, bytes.length - i2 < blockSize ? bytes.length - i2 : blockSize));
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
                        r0 = interceptable;
                        if (r0 != 0) {
                            try {
                                r0.close();
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
                    if (r0 != 0) {
                    }
                    throw th;
                }
            } catch (IOException e5) {
                com.alipay.sdk.util.c.a(e5);
            }
            return bArr;
        }
        return (byte[]) invokeLL.objValue;
    }

    public static PublicKey b(String str, String str2) throws NoSuchAlgorithmException, Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) ? KeyFactory.getInstance(str).generatePublic(new X509EncodedKeySpec(a.a(str2))) : (PublicKey) invokeLL.objValue;
    }
}
