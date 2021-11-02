package b.a.p0.a.x0.a;

import android.util.Base64;
import b.a.p0.a.k;
import b.a.p0.t.d;
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
    public static final boolean f8932a;

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f8933b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1382586168, "Lb/a/p0/a/x0/a/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1382586168, "Lb/a/p0/a/x0/a/b;");
                return;
            }
        }
        f8932a = k.f6397a;
        f8933b = new byte[]{31, -117};
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE] complete} */
    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, THROW, INVOKE, MOVE_EXCEPTION, INVOKE, THROW, INVOKE, MOVE_EXCEPTION, MOVE_EXCEPTION, THROW, THROW, THROW, INVOKE, MOVE_EXCEPTION, INVOKE, THROW, INVOKE, MOVE_EXCEPTION, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public static File a(byte[] bArr, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, bArr, file)) == null) {
            if (bArr != null && bArr.length >= 2 && file != null && file.exists()) {
                byte[] bArr2 = f8933b;
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
                        if (f8932a) {
                            String str = "first char:" + sb.charAt(0);
                        }
                        String string = new JSONObject(sb.toString()).getString(b.a.p0.a.x0.a.d.a.l);
                        boolean z = f8932a;
                        byte[] doFinal = b(2).doFinal(Base64.decode(string, 0));
                        File file2 = new File(file, b.a.p0.a.x0.a.d.a.l);
                        new FileOutputStream(file2).write(doFinal);
                        if (f8932a) {
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
                    if (f8932a) {
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
                if (f8932a) {
                    e2.printStackTrace();
                    return null;
                }
                return null;
            }
        }
        return (String) invokeL.objValue;
    }
}
