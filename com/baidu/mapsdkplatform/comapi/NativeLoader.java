package com.baidu.mapsdkplatform.comapi;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.baidu.adp.plugin.install.PluginInstallerService;
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes3.dex */
public class NativeLoader {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f7515a = "NativeLoader";

    /* renamed from: b  reason: collision with root package name */
    public static Context f7516b;

    /* renamed from: c  reason: collision with root package name */
    public static final Set<String> f7517c;

    /* renamed from: d  reason: collision with root package name */
    public static final Set<String> f7518d;

    /* renamed from: e  reason: collision with root package name */
    public static NativeLoader f7519e;

    /* renamed from: f  reason: collision with root package name */
    public static a f7520f;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f7521g;

    /* renamed from: h  reason: collision with root package name */
    public static String f7522h;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f7523a;

        /* renamed from: b  reason: collision with root package name */
        public static final a f7524b;

        /* renamed from: c  reason: collision with root package name */
        public static final a f7525c;

        /* renamed from: d  reason: collision with root package name */
        public static final a f7526d;

        /* renamed from: e  reason: collision with root package name */
        public static final a f7527e;

        /* renamed from: g  reason: collision with root package name */
        public static final /* synthetic */ a[] f7528g;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public String f7529f;

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
            f7523a = new a("ARMEABI", 0, "armeabi");
            f7524b = new a("ARMV7", 1, "armeabi-v7a");
            f7525c = new a("ARM64", 2, "arm64-v8a");
            f7526d = new a("X86", 3, "x86");
            a aVar = new a("X86_64", 4, "x86_64");
            f7527e = aVar;
            f7528g = new a[]{f7523a, f7524b, f7525c, f7526d, aVar};
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
            this.f7529f = str2;
        }

        public static a valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (a) Enum.valueOf(a.class, str) : (a) invokeL.objValue;
        }

        public static a[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (a[]) f7528g.clone() : (a[]) invokeV.objValue;
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f7529f : (String) invokeV.objValue;
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
        f7517c = new HashSet();
        f7518d = new HashSet();
        f7520f = a.f7523a;
        f7521g = false;
        f7522h = null;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? 8 <= Build.VERSION.SDK_INT ? f7516b.getPackageCodePath() : "" : (String) invokeV.objValue;
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
        if (interceptable == null || interceptable.invokeLL(65540, this, inputStream, fileOutputStream) == null) {
            byte[] bArr = new byte[4096];
            while (true) {
                try {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                } catch (Throwable th) {
                    try {
                        inputStream.close();
                    } catch (IOException e2) {
                        Log.e(f7515a, "Close InputStream error", e2);
                    }
                    try {
                        fileOutputStream.close();
                    } catch (IOException e3) {
                        Log.e(f7515a, "Close OutputStream error", e3);
                    }
                    throw th;
                }
            }
            fileOutputStream.flush();
            try {
                inputStream.close();
            } catch (IOException e4) {
                Log.e(f7515a, "Close InputStream error", e4);
            }
            try {
                fileOutputStream.close();
            } catch (IOException e5) {
                Log.e(f7515a, "Close OutputStream error", e5);
            }
        }
    }

    private void a(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, th) == null) {
            Log.e(f7515a, "loadException", th);
            Iterator<String> it = f7518d.iterator();
            while (it.hasNext()) {
                String str = f7515a;
                Log.e(str, it.next() + " Failed to load.");
            }
        }
    }

    public static void a(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(AdIconUtil.BAIDU_LOGO_ID, null, z, str) == null) {
            f7521g = z;
            f7522h = str;
        }
    }

    private boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, str)) == null) {
            try {
                synchronized (f7517c) {
                    if (f7517c.contains(str)) {
                        return true;
                    }
                    System.loadLibrary(str);
                    synchronized (f7517c) {
                        f7517c.add(str);
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
        ZipFile zipFile;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, this, str, aVar)) == null) {
            File file = new File(b(), str);
            if (!file.exists() || file.length() <= 0) {
                String str2 = a(aVar) + str;
                ZipFile zipFile2 = null;
                String a2 = !f7521g ? a() : f7522h;
                if (a2 != null) {
                    try {
                        if (!a2.isEmpty()) {
                            try {
                                zipFile = new ZipFile(a2);
                            } catch (Exception e2) {
                                e = e2;
                            }
                            try {
                                ZipEntry entry = zipFile.getEntry(str2);
                                if (entry == null) {
                                    try {
                                        zipFile.close();
                                    } catch (IOException e3) {
                                        Log.e(f7515a, "Release file failed", e3);
                                    }
                                    return false;
                                }
                                a(zipFile.getInputStream(entry), new FileOutputStream(new File(b(), str)));
                                try {
                                    zipFile.close();
                                } catch (IOException e4) {
                                    Log.e(f7515a, "Release file failed", e4);
                                }
                                return true;
                            } catch (Exception e5) {
                                e = e5;
                                zipFile2 = zipFile;
                                Log.e(f7515a, "Copy library file error", e);
                                if (zipFile2 != null) {
                                    try {
                                        zipFile2.close();
                                    } catch (IOException e6) {
                                        Log.e(f7515a, "Release file failed", e6);
                                    }
                                }
                                return false;
                            } catch (Throwable th) {
                                th = th;
                                zipFile2 = zipFile;
                                if (zipFile2 != null) {
                                    try {
                                        zipFile2.close();
                                    } catch (IOException e7) {
                                        Log.e(f7515a, "Release file failed", e7);
                                    }
                                }
                                throw th;
                            }
                        }
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
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65545, this, str, str2)) == null) ? !a(str2, a.f7524b) ? b(str, str2) : f(str2, str) : invokeLL.booleanValue;
    }

    private String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            File file = new File(f7516b.getFilesDir(), "libs");
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
            synchronized (f7517c) {
                if (f7517c.contains(str)) {
                    return true;
                }
                int i2 = d.f7605a[f7520f.ordinal()];
                boolean d2 = i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? false : d(str, mapLibraryName) : e(str, mapLibraryName) : b(str, mapLibraryName) : a(str, mapLibraryName) : c(str, mapLibraryName);
                synchronized (f7517c) {
                    f7517c.add(str);
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
            if (a(str2, a.f7523a)) {
                return f(str2, str);
            }
            String str3 = f7515a;
            Log.e(str3, "found lib" + str + ".so error");
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
                return a.f7523a;
            }
            if (str.contains("arm") && str.contains("v7")) {
                f7520f = a.f7524b;
            }
            if (str.contains("arm") && str.contains(WebKitFactory.OS_64)) {
                f7520f = a.f7525c;
            }
            if (str.contains("x86")) {
                f7520f = str.contains(WebKitFactory.OS_64) ? a.f7527e : a.f7526d;
            }
            return f7520f;
        }
        return (a) invokeV.objValue;
    }

    private boolean c(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65550, this, str, str2)) == null) ? !a(str2, a.f7525c) ? a(str, str2) : f(str2, str) : invokeLL.booleanValue;
    }

    private boolean d(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65551, this, str, str2)) == null) ? !a(str2, a.f7526d) ? a(str, str2) : f(str2, str) : invokeLL.booleanValue;
    }

    private boolean e(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65552, this, str, str2)) == null) ? !a(str2, a.f7527e) ? d(str, str2) : f(str2, str) : invokeLL.booleanValue;
    }

    private boolean f(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, this, str, str2)) == null) {
            try {
                System.load(new File(b(), str).getAbsolutePath());
                synchronized (f7517c) {
                    f7517c.add(str2);
                }
                return true;
            } catch (Throwable th) {
                synchronized (f7518d) {
                    f7518d.add(str2);
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
                if (f7519e == null) {
                    f7519e = new NativeLoader();
                    f7520f = c();
                }
                nativeLoader = f7519e;
            }
            return nativeLoader;
        }
        return (NativeLoader) invokeV.objValue;
    }

    public static void setContext(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, context) == null) {
            f7516b = context;
        }
    }

    public synchronized boolean loadLibrary(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            synchronized (this) {
                if (f7521g) {
                    if (f7522h == null || f7522h.isEmpty()) {
                        Log.e(f7515a, "Given custom so file path is null, please check!");
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
