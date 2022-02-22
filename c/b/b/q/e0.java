package c.b.b.q;

import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebKitFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.apache.commons.lang3.SystemUtils;
/* loaded from: classes9.dex */
public class e0 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f27630b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f27631c;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f27632d;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f27633e;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f27634f;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f27635g;

    /* renamed from: h  reason: collision with root package name */
    public static boolean f27636h;

    /* renamed from: i  reason: collision with root package name */
    public static final HashSet<String> f27637i;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(567896960, "Lc/b/b/q/e0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(567896960, "Lc/b/b/q/e0;");
                return;
            }
        }
        f27630b = System.getProperty("os.name").contains(SystemUtils.OS_NAME_WINDOWS_PREFIX);
        f27631c = System.getProperty("os.name").contains("Linux");
        f27632d = System.getProperty("os.name").contains("Mac");
        f27633e = false;
        f27634f = false;
        f27635g = System.getProperty("os.arch").startsWith("arm") || System.getProperty("os.arch").startsWith("aarch64");
        f27636h = System.getProperty("os.arch").contains(WebKitFactory.OS_64) || System.getProperty("os.arch").startsWith("armv8");
        String property = System.getProperty("java.runtime.name");
        if (property != null && property.contains("Android Runtime")) {
            f27634f = true;
            f27630b = false;
            f27631c = false;
            f27632d = false;
            f27636h = false;
        }
        if (!f27634f && !f27630b && !f27631c && !f27632d) {
            f27633e = true;
            f27634f = false;
            f27630b = false;
            f27631c = false;
            f27632d = false;
            f27636h = false;
        }
        f27637i = new HashSet<>();
    }

    public e0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static synchronized boolean c(String str) {
        InterceptResult invokeL;
        boolean contains;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            synchronized (e0.class) {
                contains = f27637i.contains(str);
            }
            return contains;
        }
        return invokeL.booleanValue;
    }

    public static synchronized void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            synchronized (e0.class) {
                f27637i.add(str);
            }
        }
    }

    public String a(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, inputStream)) == null) {
            if (inputStream != null) {
                CRC32 crc32 = new CRC32();
                byte[] bArr = new byte[4096];
                while (true) {
                    try {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        crc32.update(bArr, 0, read);
                    } catch (Exception unused) {
                    } catch (Throwable th) {
                        i0.a(inputStream);
                        throw th;
                    }
                }
                i0.a(inputStream);
                return Long.toString(crc32.getValue(), 16);
            }
            throw new IllegalArgumentException("input cannot be null.");
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:3|(9:(4:44|45|(9:11|12|14|15|16|17|18|(3:19|20|(1:24)(2:22|23))|25)|9)|14|15|16|17|18|(4:19|20|(0)(0)|23)|25|9)|5|(1:7)|11|12) */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0050, code lost:
        r7 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0051, code lost:
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0053, code lost:
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0054, code lost:
        r0 = null;
        r1 = r8;
        r8 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0039 A[EDGE_INSN: B:55:0x0039->B:19:0x0039 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final File b(String str, String str2, File file) throws IOException {
        InterceptResult invokeLLL;
        String a;
        FileOutputStream fileOutputStream;
        IOException e2;
        InputStream inputStream;
        byte[] bArr;
        int read;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, file)) != null) {
            return (File) invokeLLL.objValue;
        }
        InputStream inputStream2 = null;
        try {
            try {
                try {
                    if (file.exists()) {
                        try {
                            a = a(new FileInputStream(file));
                        } catch (FileNotFoundException unused) {
                        }
                        if (a != null || !a.equals(str2)) {
                            inputStream = h(str);
                            file.getParentFile().mkdirs();
                            fileOutputStream = new FileOutputStream(file);
                            bArr = new byte[4096];
                            while (true) {
                                read = inputStream.read(bArr);
                                if (read != -1) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, read);
                            }
                            i0.a(inputStream);
                            i0.a(fileOutputStream);
                        }
                        return file;
                    }
                    bArr = new byte[4096];
                    while (true) {
                        read = inputStream.read(bArr);
                        if (read != -1) {
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    i0.a(inputStream);
                    i0.a(fileOutputStream);
                    return file;
                } catch (IOException e3) {
                    e2 = e3;
                    throw new GdxRuntimeException("Error extracting file: " + str + "\nTo: " + file.getAbsolutePath(), e2);
                }
            } catch (Throwable th) {
                th = th;
                inputStream2 = inputStream;
                i0.a(inputStream2);
                i0.a(fileOutputStream);
                throw th;
            }
            file.getParentFile().mkdirs();
            fileOutputStream = new FileOutputStream(file);
        } catch (IOException e4) {
            e2 = e4;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
            inputStream2 = inputStream;
            i0.a(inputStream2);
            i0.a(fileOutputStream);
            throw th;
        }
        a = null;
        if (a != null) {
        }
        inputStream = h(str);
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || f27633e) {
            return;
        }
        synchronized (e0.class) {
            if (c(str)) {
                return;
            }
            String g2 = g(str);
            if (f27634f) {
                System.loadLibrary(g2);
            } else {
                f(g2);
            }
            i(str);
        }
    }

    public final Throwable e(String str, String str2, File file) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, str2, file)) == null) {
            try {
                b(str, str2, file);
                System.load(file.getAbsolutePath());
                return null;
            } catch (Throwable th) {
                return th;
            }
        }
        return (Throwable) invokeLLL.objValue;
    }

    public final void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            String a = a(h(str));
            String name = new File(str).getName();
            Throwable e2 = e(str, a, new File(System.getProperty(SystemUtils.JAVA_IO_TMPDIR_KEY) + "/libgdx" + System.getProperty("user.name") + "/" + a, name));
            if (e2 == null) {
                return;
            }
            try {
                File createTempFile = File.createTempFile(a, null);
                if (createTempFile.delete()) {
                    if (e(str, a, createTempFile) == null) {
                        return;
                    }
                }
            } catch (Throwable unused) {
            }
            if (e(str, a, new File(System.getProperty(SystemUtils.USER_HOME_KEY) + "/.libgdx/" + a, name)) == null) {
                return;
            }
            if (e(str, a, new File(".temp/" + a, name)) == null) {
                return;
            }
            File file = new File(System.getProperty("java.library.path"), str);
            if (file.exists()) {
                System.load(file.getAbsolutePath());
                return;
            }
            throw new GdxRuntimeException(e2);
        }
    }

    public String g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (f27630b) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(f27636h ? "64.dll" : ".dll");
                return sb.toString();
            } else if (f27631c) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("lib");
                sb2.append(str);
                sb2.append(f27635g ? "arm" : "");
                sb2.append(f27636h ? "64.so" : ".so");
                return sb2.toString();
            } else if (f27632d) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("lib");
                sb3.append(str);
                sb3.append(f27636h ? "64.dylib" : ".dylib");
                return sb3.toString();
            } else {
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    public final InputStream h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (this.a == null) {
                InputStream resourceAsStream = e0.class.getResourceAsStream("/" + str);
                if (resourceAsStream != null) {
                    return resourceAsStream;
                }
                throw new GdxRuntimeException("Unable to read file for extraction: " + str);
            }
            try {
                ZipFile zipFile = new ZipFile(this.a);
                ZipEntry entry = zipFile.getEntry(str);
                if (entry != null) {
                    return zipFile.getInputStream(entry);
                }
                throw new GdxRuntimeException("Couldn't find '" + str + "' in JAR: " + this.a);
            } catch (IOException e2) {
                throw new GdxRuntimeException("Error reading '" + str + "' in JAR: " + this.a, e2);
            }
        }
        return (InputStream) invokeL.objValue;
    }
}
