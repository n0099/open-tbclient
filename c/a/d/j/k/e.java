package c.a.d.j.k;

import android.content.pm.Signature;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.util.Util;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
/* loaded from: classes.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;
    public static Object a;

    /* renamed from: b  reason: collision with root package name */
    public static WeakReference<byte[]> f2521b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-388121456, "Lc/a/d/j/k/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-388121456, "Lc/a/d/j/k/e;");
                return;
            }
        }
        a = new Object();
    }

    public static Signature[] a(String str, Util.a aVar) throws CertificateEncodingException, IOException {
        InterceptResult invokeLL;
        WeakReference<byte[]> weakReference;
        byte[] bArr;
        Certificate[] b2;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, aVar)) == null) {
            if (TextUtils.isEmpty(str) || aVar == null) {
                return null;
            }
            synchronized (a) {
                weakReference = f2521b;
                if (weakReference != null) {
                    f2521b = null;
                    bArr = weakReference.get();
                } else {
                    bArr = null;
                }
                if (bArr == null) {
                    bArr = new byte[8192];
                    weakReference = new WeakReference<>(bArr);
                }
            }
            try {
                JarFile jarFile = new JarFile(str);
                aVar.f23886c = 1;
                Enumeration<JarEntry> entries = jarFile.entries();
                Certificate[] certificateArr = null;
                loop0: while (true) {
                    if (entries.hasMoreElements()) {
                        JarEntry nextElement = entries.nextElement();
                        if (!nextElement.isDirectory()) {
                            String name = nextElement.getName();
                            if (!name.startsWith("META-INF/")) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("jarFile_");
                                sb.append(jarFile.getName());
                                sb.append("-JarEntry_");
                                sb.append(name);
                                aVar.f23885b = sb.toString();
                                aVar.f23886c = 2;
                                try {
                                    b2 = b(jarFile, nextElement, bArr, aVar);
                                } catch (Exception e2) {
                                    sb.append("-Exception_");
                                    sb.append(e2.toString());
                                    aVar.f23885b = sb.toString();
                                    b2 = b(jarFile, nextElement, bArr, aVar);
                                }
                                aVar.f23886c = 5;
                                if (b2 == null) {
                                    aVar.f23886c = 6;
                                    BdLog.e("Package " + str + " has no certificates at entry " + nextElement.getName() + "; ignoring!");
                                    jarFile.close();
                                    return null;
                                } else if (certificateArr == null) {
                                    certificateArr = b2;
                                } else {
                                    for (int i = 0; i < certificateArr.length; i++) {
                                        int i2 = 0;
                                        while (true) {
                                            if (i2 >= b2.length) {
                                                z = false;
                                                break;
                                            } else if (certificateArr[i] != null && certificateArr[i].equals(b2[i2])) {
                                                z = true;
                                                break;
                                            } else {
                                                i2++;
                                            }
                                        }
                                        if (!z || certificateArr.length != b2.length) {
                                            break loop0;
                                        }
                                    }
                                    continue;
                                }
                            }
                        }
                    } else {
                        aVar.f23886c = 8;
                        jarFile.close();
                        synchronized (a) {
                            f2521b = weakReference;
                        }
                        aVar.f23886c = 9;
                        if (certificateArr != null && certificateArr.length > 0) {
                            int length = certificateArr.length;
                            Signature[] signatureArr = new Signature[certificateArr.length];
                            for (int i3 = 0; i3 < length; i3++) {
                                signatureArr[i3] = new Signature(certificateArr[i3].getEncoded());
                            }
                            return signatureArr;
                        }
                        BdLog.e("Package " + str + " has no certificates; ignoring!");
                        return null;
                    }
                }
                aVar.f23886c = 7;
                jarFile.close();
                return null;
            } catch (IOException e3) {
                BdLog.e("Exception reading " + str + "----" + e3.getMessage());
                throw e3;
            } catch (RuntimeException e4) {
                BdLog.e("Exception reading " + str + "----" + e4.getMessage());
                throw e4;
            } catch (CertificateEncodingException e5) {
                BdLog.e("Exception reading " + str + "----" + e5.getMessage());
                throw e5;
            }
        }
        return (Signature[]) invokeLL.objValue;
    }

    public static Certificate[] b(JarFile jarFile, JarEntry jarEntry, byte[] bArr, Util.a aVar) throws IOException {
        InterceptResult invokeLLLL;
        BufferedInputStream bufferedInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, jarFile, jarEntry, bArr, aVar)) == null) {
            BufferedInputStream bufferedInputStream2 = null;
            try {
                try {
                    bufferedInputStream = new BufferedInputStream(jarFile.getInputStream(jarEntry));
                } catch (Throwable th) {
                    th = th;
                }
            } catch (IOException e2) {
                e = e2;
            } catch (RuntimeException e3) {
                e = e3;
            }
            try {
                aVar.f23886c = 3;
                while (bufferedInputStream.read(bArr, 0, bArr.length) != -1) {
                }
                aVar.f23886c = 4;
                Certificate[] certificates = jarEntry != null ? jarEntry.getCertificates() : null;
                c.a.d.f.m.a.c(bufferedInputStream);
                return certificates;
            } catch (IOException e4) {
                e = e4;
                BdLog.e("Exception reading " + jarEntry.getName() + " in " + jarFile.getName() + "----" + e.getMessage());
                throw e;
            } catch (RuntimeException e5) {
                e = e5;
                BdLog.e("Exception reading " + jarEntry.getName() + " in " + jarFile.getName() + "----" + e.getMessage());
                throw e;
            } catch (Throwable th2) {
                th = th2;
                bufferedInputStream2 = bufferedInputStream;
                c.a.d.f.m.a.c(bufferedInputStream2);
                throw th;
            }
        }
        return (Certificate[]) invokeLLLL.objValue;
    }
}
