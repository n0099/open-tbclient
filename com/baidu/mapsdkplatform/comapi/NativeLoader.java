package com.baidu.mapsdkplatform.comapi;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.pass.biometrics.base.utils.PassBiometricUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
/* loaded from: classes2.dex */
public class NativeLoader {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "NativeLoader";
    public static Context b;
    public static final Set<String> c;
    public static final Set<String> d;
    public static NativeLoader e;
    public static a f;
    public static boolean g;
    public static String h;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public static final a a;
        public static final a b;
        public static final a c;
        public static final a d;
        public static final a e;
        public static final /* synthetic */ a[] g;
        public transient /* synthetic */ FieldHolder $fh;
        public String f;

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
            b = new a("ARMV7", 1, PassBiometricUtil.CPU_TYPE_ARMEABI_V7A);
            c = new a("ARM64", 2, "arm64-v8a");
            d = new a("X86", 3, "x86");
            a aVar = new a("X86_64", 4, "x86_64");
            e = aVar;
            g = new a[]{a, b, c, d, aVar};
        }

        public a(String str, int i, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str3 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f = str2;
        }

        public static a valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (a) Enum.valueOf(a.class, str);
            }
            return (a) invokeL.objValue;
        }

        public static a[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (a[]) g.clone();
            }
            return (a[]) invokeV.objValue;
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.f;
            }
            return (String) invokeV.objValue;
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
        c = new HashSet();
        d = new HashSet();
        f = a.a;
        g = false;
        h = null;
    }

    public NativeLoader() {
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

    @TargetApi(8)
    private String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            if (b == null || 8 > Build.VERSION.SDK_INT) {
                return "";
            }
            return b.getPackageCodePath();
        }
        return (String) invokeV.objValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 23) {
                return Process.is64Bit();
            }
            if (i < 21) {
                return false;
            }
            return Build.CPU_ABI.equals(Build.SUPPORTED_64_BIT_ABIS[0]);
        }
        return invokeV.booleanValue;
    }

    public static synchronized NativeLoader getInstance() {
        InterceptResult invokeV;
        NativeLoader nativeLoader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) {
            synchronized (NativeLoader.class) {
                if (e == null) {
                    e = new NativeLoader();
                    f = c();
                }
                nativeLoader = e;
            }
            return nativeLoader;
        }
        return (NativeLoader) invokeV.objValue;
    }

    private String a(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, aVar)) == null) {
            return "lib/" + aVar.a() + "/";
        }
        return (String) invokeL.objValue;
    }

    public static void setContext(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, context) == null) {
            b = context;
        }
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
                } catch (Throwable th) {
                    try {
                        inputStream.close();
                    } catch (IOException e2) {
                        Log.e(a, "Close InputStream error", e2);
                    }
                    try {
                        fileOutputStream.close();
                    } catch (IOException e3) {
                        Log.e(a, "Close OutputStream error", e3);
                    }
                    throw th;
                }
            }
            fileOutputStream.flush();
            try {
                inputStream.close();
            } catch (IOException e4) {
                Log.e(a, "Close InputStream error", e4);
            }
            try {
                fileOutputStream.close();
            } catch (IOException e5) {
                Log.e(a, "Close OutputStream error", e5);
            }
        }
    }

    private boolean b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, this, str, str2)) == null) {
            if (a(str2, a.a)) {
                return f(str2, str);
            }
            String str3 = a;
            Log.e(str3, "found lib " + a.a.a() + "/" + str + ".so error");
            return false;
        }
        return invokeLL.booleanValue;
    }

    private void g(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65555, this, str, str2) == null) && str != null && !str.isEmpty() && str.contains("libBaiduMapSDK_")) {
            try {
                String[] split = str.split("_v");
                if (split.length <= 1) {
                    return;
                }
                File[] listFiles = new File(b()).listFiles(new d(this, split[1]));
                if (listFiles != null && listFiles.length != 0) {
                    for (File file : listFiles) {
                        file.delete();
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    private void a(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, th) == null) {
            Log.e(a, "loadException", th);
            Iterator<String> it = d.iterator();
            while (it.hasNext()) {
                String str = a;
                Log.e(str, it.next() + " Failed to load.");
            }
        }
    }

    public synchronized boolean loadLibrary(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            synchronized (this) {
                if (!g) {
                    return a(str);
                }
                if (h != null && !h.isEmpty()) {
                    return b(str);
                }
                Log.e(a, "Given custom so file path is null, please check!");
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static void a(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(65542, null, z, str) == null) {
            g = z;
            h = str;
        }
    }

    private boolean c(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, this, str, str2)) == null) {
            if (!a(str2, a.c)) {
                return a(str, str2);
            }
            return f(str2, str);
        }
        return invokeLL.booleanValue;
    }

    private boolean d(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, this, str, str2)) == null) {
            if (!a(str2, a.d)) {
                return a(str, str2);
            }
            return f(str2, str);
        }
        return invokeLL.booleanValue;
    }

    private boolean e(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, this, str, str2)) == null) {
            if (!a(str2, a.e)) {
                return d(str, str2);
            }
            return f(str2, str);
        }
        return invokeLL.booleanValue;
    }

    private boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, str)) == null) {
            try {
                synchronized (c) {
                    if (c.contains(str)) {
                        return true;
                    }
                    System.loadLibrary(str);
                    synchronized (c) {
                        c.add(str);
                    }
                    return true;
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return b(str);
            }
        }
        return invokeL.booleanValue;
    }

    private boolean a(String str, a aVar) {
        InterceptResult invokeLL;
        String str2;
        ZipFile zipFile;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, this, str, aVar)) == null) {
            File file = new File(b(), str);
            if (file.exists() && file.length() > 0) {
                return true;
            }
            String str3 = a(aVar) + str;
            ZipFile zipFile2 = null;
            if (!g) {
                str2 = a();
            } else {
                str2 = h;
            }
            if (str2 != null) {
                try {
                    if (!str2.isEmpty()) {
                        try {
                            zipFile = new ZipFile(str2);
                        } catch (Exception e2) {
                            e = e2;
                        }
                        try {
                            ZipEntry entry = zipFile.getEntry(str3);
                            if (entry == null) {
                                try {
                                    zipFile.close();
                                } catch (IOException e3) {
                                    Log.e(a, "Release file failed", e3);
                                }
                                return false;
                            }
                            a(zipFile.getInputStream(entry), new FileOutputStream(new File(b(), str)));
                            try {
                                zipFile.close();
                            } catch (IOException e4) {
                                Log.e(a, "Release file failed", e4);
                            }
                            return true;
                        } catch (Exception e5) {
                            e = e5;
                            zipFile2 = zipFile;
                            Log.e(a, "Copy library file error", e);
                            if (zipFile2 != null) {
                                try {
                                    zipFile2.close();
                                } catch (IOException e6) {
                                    Log.e(a, "Release file failed", e6);
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
                                    Log.e(a, "Release file failed", e7);
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
        return invokeLL.booleanValue;
    }

    private boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, this, str, str2)) == null) {
            if (!a(str2, a.b)) {
                return b(str, str2);
            }
            return f(str2, str);
        }
        return invokeLL.booleanValue;
    }

    private String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            if (b == null) {
                return "";
            }
            File file = new File(b.getFilesDir(), "libs" + File.separator + f.a());
            if (!file.exists()) {
                file.mkdirs();
            }
            return file.getAbsolutePath();
        }
        return (String) invokeV.objValue;
    }

    private boolean b(String str) {
        InterceptResult invokeL;
        boolean c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, this, str)) == null) {
            String mapLibraryName = System.mapLibraryName(str);
            synchronized (c) {
                if (c.contains(str)) {
                    return true;
                }
                int i = e.a[f.ordinal()];
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                if (i != 5) {
                                    c2 = false;
                                } else {
                                    c2 = d(str, mapLibraryName);
                                }
                            } else {
                                c2 = e(str, mapLibraryName);
                            }
                        } else {
                            c2 = b(str, mapLibraryName);
                        }
                    } else {
                        c2 = a(str, mapLibraryName);
                    }
                } else {
                    c2 = c(str, mapLibraryName);
                }
                synchronized (c) {
                    c.add(str);
                }
                return c2;
            }
        }
        return invokeL.booleanValue;
    }

    @TargetApi(21)
    public static a c() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            if (Build.VERSION.SDK_INT < 21) {
                str = Build.CPU_ABI;
            } else {
                str = Build.SUPPORTED_ABIS[0];
            }
            if (str == null) {
                return a.a;
            }
            if (str.contains("arm") && str.contains("v7")) {
                f = a.b;
            }
            if (str.contains("arm") && str.contains("64") && d()) {
                f = a.c;
            }
            if (str.contains("x86")) {
                if (str.contains("64")) {
                    f = a.e;
                } else {
                    f = a.d;
                }
            }
            return f;
        }
        return (a) invokeV.objValue;
    }

    private boolean f(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65554, this, str, str2)) == null) {
            try {
                System.loadLibrary(new File(b(), str).getAbsolutePath());
                synchronized (c) {
                    c.add(str2);
                }
                g(str, str2);
                return true;
            } catch (Throwable th) {
                synchronized (d) {
                    d.add(str2);
                    a(th);
                    return false;
                }
            }
        }
        return invokeLL.booleanValue;
    }
}
