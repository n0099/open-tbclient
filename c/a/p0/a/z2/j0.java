package c.a.p0.a.z2;

import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
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
/* loaded from: classes.dex */
public class j0 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(136592917, "Lc/a/p0/a/z2/j0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(136592917, "Lc/a/p0/a/z2/j0;");
                return;
            }
        }
        a = c.a.p0.a.k.a;
    }

    public static boolean a(File file, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, file, str)) == null) ? b(file, str, null) : invokeLL.booleanValue;
    }

    public static boolean b(File file, String str, c.a.p0.a.z2.b1.c cVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, file, str, cVar)) == null) {
            boolean z = file == null;
            if (z || !file.exists() || TextUtils.isEmpty(str)) {
                if (cVar != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("zipfile: isEmpty=");
                    sb.append(z);
                    sb.append("; exists=");
                    sb.append(z ? "" : Boolean.valueOf(file.exists()));
                    cVar.a = sb.toString();
                }
                return false;
            }
            ReadableByteChannel readableByteChannel = null;
            try {
                readableByteChannel = Channels.newChannel(new FileInputStream(file));
                return d(readableByteChannel, str, cVar);
            } catch (IOException e2) {
                if (a) {
                    e2.printStackTrace();
                }
                return false;
            } finally {
                c.a.p0.w.d.d(readableByteChannel);
            }
        }
        return invokeLLL.booleanValue;
    }

    public static boolean c(ReadableByteChannel readableByteChannel, String str) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, readableByteChannel, str)) == null) ? d(readableByteChannel, str, null) : invokeLL.booleanValue;
    }

    public static boolean d(ReadableByteChannel readableByteChannel, String str, c.a.p0.a.z2.b1.c cVar) throws IOException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, readableByteChannel, str, cVar)) == null) {
            boolean z = readableByteChannel == null;
            if (z || TextUtils.isEmpty(str)) {
                if (cVar != null) {
                    cVar.a = "zipSource isNullIs=" + z;
                }
                return false;
            }
            String c2 = c.a.p0.w.f.c(false, readableByteChannel);
            if (cVar != null) {
                cVar.a = c2;
            }
            try {
                String str2 = new String(e(Base64.decode(str.getBytes("utf-8"), 8), f("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDZuy3GEbahJc292fsyvrGneTJKQnzpdhNsJfDS5csb0MtmW+4JEvBH5wCZK5j4+nrRfKBF7JuTHe0nSWOZWNxgLU87pwCxozXSNrsiiOjsV+3KwYfdz5QlvvyCfvmllGObPqL7dWR92V2UYEWMSneBHtwDhCBCzmhAoOxZVsAq2wIDAQAB")), "utf-8");
                if (cVar != null) {
                    cVar.f9118b = str2;
                }
                return TextUtils.equals(str2, c2);
            } catch (Exception e2) {
                if (a) {
                    e2.toString();
                    e2.printStackTrace();
                }
                if (cVar != null) {
                    cVar.f9118b = e2.getLocalizedMessage();
                }
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public static byte[] e(byte[] bArr, PublicKey publicKey) throws GeneralSecurityException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, bArr, publicKey)) == null) {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(2, publicKey);
            return cipher.doFinal(bArr);
        }
        return (byte[]) invokeLL.objValue;
    }

    public static PublicKey f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            try {
                return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str.getBytes("utf-8"), 0)));
            } catch (UnsupportedEncodingException | NullPointerException | NoSuchAlgorithmException | InvalidKeySpecException unused) {
                return null;
            }
        }
        return (PublicKey) invokeL.objValue;
    }
}
