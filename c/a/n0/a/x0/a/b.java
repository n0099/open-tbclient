package c.a.n0.a.x0.a;

import android.util.Base64;
import c.a.n0.a.k;
import c.a.n0.t.d;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.zip.GZIPInputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f9413a;

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f9414b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2143681513, "Lc/a/n0/a/x0/a/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2143681513, "Lc/a/n0/a/x0/a/b;");
                return;
            }
        }
        f9413a = k.f6803a;
        f9414b = new byte[]{31, -117};
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE] complete} */
    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, THROW, INVOKE, MOVE_EXCEPTION, INVOKE, THROW, INVOKE, MOVE_EXCEPTION, MOVE_EXCEPTION, THROW, THROW, THROW, INVOKE, MOVE_EXCEPTION, INVOKE, THROW, INVOKE, MOVE_EXCEPTION, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public static File a(byte[] bArr, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, bArr, file)) == null) {
            if (bArr != null && bArr.length >= 2 && file != null && file.exists()) {
                byte[] bArr2 = f9414b;
                bArr[0] = bArr2[0];
                bArr[1] = bArr2[1];
                try {
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                    GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                    InputStreamReader inputStreamReader = new InputStreamReader(gZIPInputStream);
                    try {
                        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                        StringBuilder sb = new StringBuilder();
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            sb.append(readLine);
                        }
                        if (f9413a) {
                            String str = "first char:" + sb.charAt(0);
                        }
                        String string = new JSONObject(sb.toString()).getString(c.a.n0.a.x0.a.d.a.l);
                        boolean z = f9413a;
                        byte[] doFinal = b(2).doFinal(Base64.decode(string, 0));
                        File file2 = new File(file, c.a.n0.a.x0.a.d.a.l);
                        new FileOutputStream(file2).write(doFinal);
                        if (f9413a) {
                            file2.getAbsolutePath();
                        }
                        bufferedReader.close();
                        inputStreamReader.close();
                        gZIPInputStream.close();
                        byteArrayInputStream.close();
                        return file2;
                    } finally {
                    }
                } catch (Exception e2) {
                    if (f9413a) {
                        e2.printStackTrace();
                    }
                }
            }
            return null;
        }
        return (File) invokeLL.objValue;
    }

    public static Cipher b(int i2) throws Exception {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(i2, new SecretKeySpec(c("la32118_p9d8#*!6)".getBytes()).substring(16).getBytes(), "AES"), new IvParameterSpec("2081147213143090".getBytes()));
            return cipher;
        }
        return (Cipher) invokeI.objValue;
    }

    public static String c(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.reset();
                messageDigest.update(bArr);
                return d.S(messageDigest.digest(), "", false);
            } catch (NoSuchAlgorithmException e2) {
                if (f9413a) {
                    e2.printStackTrace();
                    return null;
                }
                return null;
            }
        }
        return (String) invokeL.objValue;
    }
}
