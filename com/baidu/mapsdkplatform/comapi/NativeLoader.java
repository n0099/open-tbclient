package com.baidu.mapsdkplatform.comapi;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.plugin.install.PluginInstallerService;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebKitFactory;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
/* loaded from: classes10.dex */
public class NativeLoader {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "NativeLoader";

    /* renamed from: b  reason: collision with root package name */
    public static Context f35750b;

    /* renamed from: c  reason: collision with root package name */
    public static final Set<String> f35751c;

    /* renamed from: d  reason: collision with root package name */
    public static final Set<String> f35752d;

    /* renamed from: e  reason: collision with root package name */
    public static NativeLoader f35753e;

    /* renamed from: f  reason: collision with root package name */
    public static a f35754f;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f35755g;

    /* renamed from: h  reason: collision with root package name */
    public static String f35756h;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes10.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public static final a a;

        /* renamed from: b  reason: collision with root package name */
        public static final a f35757b;

        /* renamed from: c  reason: collision with root package name */
        public static final a f35758c;

        /* renamed from: d  reason: collision with root package name */
        public static final a f35759d;

        /* renamed from: e  reason: collision with root package name */
        public static final a f35760e;

        /* renamed from: g  reason: collision with root package name */
        public static final /* synthetic */ a[] f35761g;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public String f35762f;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1110687666, "Lcom/baidu/mapsdkplatform/comapi/NativeLoader$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1110687666, "Lcom/baidu/mapsdkplatform/comapi/NativeLoader$a;");
                    return;
                }
            }
            a = new a("ARMEABI", 0, "armeabi");
            f35757b = new a("ARMV7", 1, "armeabi-v7a");
            f35758c = new a("ARM64", 2, "arm64-v8a");
            f35759d = new a("X86", 3, "x86");
            a aVar = new a("X86_64", 4, "x86_64");
            f35760e = aVar;
            f35761g = new a[]{a, f35757b, f35758c, f35759d, aVar};
        }

        public a(String str, int i2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str3 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f35762f = str2;
        }

        public static a valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (a) Enum.valueOf(a.class, str) : (a) invokeL.objValue;
        }

        public static a[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (a[]) f35761g.clone() : (a[]) invokeV.objValue;
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f35762f : (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1983199595, "Lcom/baidu/mapsdkplatform/comapi/NativeLoader;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1983199595, "Lcom/baidu/mapsdkplatform/comapi/NativeLoader;");
                return;
            }
        }
        f35751c = new HashSet();
        f35752d = new HashSet();
        f35754f = a.a;
        f35755g = false;
        f35756h = null;
    }

    public NativeLoader() {
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

    @TargetApi(8)
    private String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? 8 <= Build.VERSION.SDK_INT ? f35750b.getPackageCodePath() : "" : (String) invokeV.objValue;
    }

    private String a(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, aVar)) == null) {
            return PluginInstallerService.APK_LIB_DIR_PREFIX + aVar.a() + "/";
        }
        return (String) invokeL.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE] complete} */
    private void a(InputStream inputStream, FileOutputStream fileOutputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, inputStream, fileOutputStream) == null) {
            byte[] bArr = new byte[4096];
            while (true) {
                try {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                } finally {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                    }
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused2) {
                    }
                }
            }
            fileOutputStream.flush();
            try {
                fileOutputStream.close();
            } catch (IOException unused3) {
            }
        }
    }

    private void a(Throwable th) {
        Iterator<String> it;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, th) == null) {
            while (f35752d.iterator().hasNext()) {
                String str = it.next() + " Failed to load.";
            }
        }
    }

    public static void a(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(65542, null, z, str) == null) {
            f35755g = z;
            f35756h = str;
        }
    }

    private boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, str)) == null) {
            try {
                synchronized (f35751c) {
                    if (f35751c.contains(str)) {
                        return true;
                    }
                    System.loadLibrary(str);
                    synchronized (f35751c) {
                        f35751c.add(str);
                    }
                    return true;
                }
            } catch (Throwable unused) {
                return b(str);
            }
        }
        return invokeL.booleanValue;
    }

    private boolean a(String str, a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, this, str, aVar)) == null) {
            File file = new File(b(), str);
            if (!file.exists() || file.length() <= 0) {
                String str2 = a(aVar) + str;
                ZipFile zipFile = null;
                String a2 = !f35755g ? a() : f35756h;
                if (a2 != null && !a2.isEmpty()) {
                    try {
                        ZipFile zipFile2 = new ZipFile(a2);
                        try {
                            ZipEntry entry = zipFile2.getEntry(str2);
                            if (entry == null) {
                                try {
                                    zipFile2.close();
                                } catch (IOException unused) {
                                }
                                return false;
                            }
                            a(zipFile2.getInputStream(entry), new FileOutputStream(new File(b(), str)));
                            try {
                                zipFile2.close();
                            } catch (IOException unused2) {
                            }
                            return true;
                        } catch (Exception unused3) {
                            zipFile = zipFile2;
                            if (zipFile != null) {
                                try {
                                    zipFile.close();
                                } catch (IOException unused4) {
                                }
                            }
                            return false;
                        } catch (Throwable th) {
                            th = th;
                            zipFile = zipFile2;
                            if (zipFile != null) {
                                try {
                                    zipFile.close();
                                } catch (IOException unused5) {
                                }
                            }
                            throw th;
                        }
                    } catch (Exception unused6) {
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    private boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65545, this, str, str2)) == null) ? !a(str2, a.f35757b) ? b(str, str2) : f(str2, str) : invokeLL.booleanValue;
    }

    private String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            File file = new File(f35750b.getFilesDir(), "libs");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file.getAbsolutePath();
        }
        return (String) invokeV.objValue;
    }

    private boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, this, str)) == null) {
            String mapLibraryName = System.mapLibraryName(str);
            synchronized (f35751c) {
                if (f35751c.contains(str)) {
                    return true;
                }
                int i2 = d.a[f35754f.ordinal()];
                boolean d2 = i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? false : d(str, mapLibraryName) : e(str, mapLibraryName) : b(str, mapLibraryName) : a(str, mapLibraryName) : c(str, mapLibraryName);
                synchronized (f35751c) {
                    f35751c.add(str);
                }
                return d2;
            }
        }
        return invokeL.booleanValue;
    }

    private boolean b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, this, str, str2)) == null) {
            if (a(str2, a.a)) {
                return f(str2, str);
            }
            String str3 = "found lib" + str + ".so error";
            return false;
        }
        return invokeLL.booleanValue;
    }

    @TargetApi(21)
    public static a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            String str = Build.VERSION.SDK_INT < 21 ? Build.CPU_ABI : Build.SUPPORTED_ABIS[0];
            if (str == null) {
                return a.a;
            }
            if (str.contains("arm") && str.contains("v7")) {
                f35754f = a.f35757b;
            }
            if (str.contains("arm") && str.contains(WebKitFactory.OS_64)) {
                f35754f = a.f35758c;
            }
            if (str.contains("x86")) {
                f35754f = str.contains(WebKitFactory.OS_64) ? a.f35760e : a.f35759d;
            }
            return f35754f;
        }
        return (a) invokeV.objValue;
    }

    private boolean c(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65550, this, str, str2)) == null) ? !a(str2, a.f35758c) ? a(str, str2) : f(str2, str) : invokeLL.booleanValue;
    }

    private boolean d(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65551, this, str, str2)) == null) ? !a(str2, a.f35759d) ? a(str, str2) : f(str2, str) : invokeLL.booleanValue;
    }

    private boolean e(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65552, this, str, str2)) == null) ? !a(str2, a.f35760e) ? d(str, str2) : f(str2, str) : invokeLL.booleanValue;
    }

    private boolean f(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, this, str, str2)) == null) {
            try {
                System.load(new File(b(), str).getAbsolutePath());
                synchronized (f35751c) {
                    f35751c.add(str2);
                }
                return true;
            } catch (Throwable th) {
                synchronized (f35752d) {
                    f35752d.add(str2);
                    a(th);
                    return false;
                }
            }
        }
        return invokeLL.booleanValue;
    }

    public static synchronized NativeLoader getInstance() {
        InterceptResult invokeV;
        NativeLoader nativeLoader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            synchronized (NativeLoader.class) {
                if (f35753e == null) {
                    f35753e = new NativeLoader();
                    f35754f = c();
                }
                nativeLoader = f35753e;
            }
            return nativeLoader;
        }
        return (NativeLoader) invokeV.objValue;
    }

    public static void setContext(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, context) == null) {
            f35750b = context;
        }
    }

    public synchronized boolean loadLibrary(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            synchronized (this) {
                if (f35755g) {
                    if (f35756h == null || f35756h.isEmpty()) {
                        return false;
                    }
                    return b(str);
                }
                return a(str);
            }
        }
        return invokeL.booleanValue;
    }
}
