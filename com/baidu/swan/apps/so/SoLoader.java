package com.baidu.swan.apps.so;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.b93;
import com.baidu.tieba.c93;
import com.baidu.tieba.f93;
import com.baidu.tieba.g93;
import com.baidu.tieba.pj4;
import com.baidu.tieba.vj1;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
@Keep
/* loaded from: classes3.dex */
public final class SoLoader {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final String TAG = "SoLoader";
    public static final Set<String> sLoadedLibraries;
    public static final List<File> soSources;
    public transient /* synthetic */ FieldHolder $fh;
    public StringBuilder sb;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-716524410, "Lcom/baidu/swan/apps/so/SoLoader;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-716524410, "Lcom/baidu/swan/apps/so/SoLoader;");
                return;
            }
        }
        DEBUG = vj1.a;
        sLoadedLibraries = Collections.synchronizedSet(new HashSet());
        soSources = new ArrayList();
    }

    public SoLoader() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.sb = new StringBuilder();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: java.util.List<java.io.File> */
    /* JADX WARN: Multi-variable type inference failed */
    private void addLocalSoLibraryDirectory(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, context) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new File(getNativeLibraryDir(context)));
            arrayList.add(new File(context.getFilesDir(), "lib"));
            for (int i = 0; i < arrayList.size(); i++) {
                if (!soSources.contains(arrayList.get(i))) {
                    soSources.add(arrayList.get(i));
                }
            }
        }
    }

    private void addSysSoLibraryDirectory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            String str = System.getenv("LD_LIBRARY_PATH");
            if (str == null) {
                str = "/vendor/lib:/system/lib";
            }
            for (String str2 : str.split(":")) {
                File file = new File(str2);
                if (!soSources.contains(file)) {
                    soSources.add(file);
                }
            }
        }
    }

    public static synchronized File findSoFilesInLibrary(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str)) == null) {
            synchronized (SoLoader.class) {
                String fullName = SoUtils.getFullName(str);
                if (soSources.size() == 0) {
                    new SoLoader().initSoSource(context);
                }
                for (File file : soSources) {
                    File file2 = new File(file, fullName);
                    if (file2.exists()) {
                        return file2;
                    }
                }
                return null;
            }
        }
        return (File) invokeLL.objValue;
    }

    private String getNativeLibraryDir(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, context)) == null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                if (SoUtils.hasGingerbread()) {
                    return packageInfo.applicationInfo.nativeLibraryDir;
                }
                return new File(packageInfo.applicationInfo.dataDir, "lib").getAbsolutePath();
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static File getReleaseSoFilePath(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) ? new File(context.getFilesDir(), "lib") : (File) invokeL.objValue;
    }

    private long getSoSize(ZipFile zipFile, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, this, zipFile, str)) == null) {
            if (zipFile != null) {
                try {
                    ZipEntry entry = zipFile.getEntry(str);
                    if (entry != null) {
                        return entry.getSize();
                    }
                    return 0L;
                } catch (Exception e) {
                    if (DEBUG) {
                        Log.e("SoLoader", "SoLoader getSoSize exception.", e);
                        return 0L;
                    }
                    return 0L;
                }
            }
            return 0L;
        }
        return invokeLL.longValue;
    }

    public static String getV8SoDependentFilePath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (sLoadedLibraries.contains(f93.c())) {
                String d = f93.d();
                if (DEBUG) {
                    Log.i("SoLoader", "getV8SoDependentFilePath:" + d);
                }
                return d;
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    private void initSoSource(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, context) == null) {
            if (DEBUG) {
                Log.d("SoLoader", "initSoSource is called");
            }
            synchronized (SoLoader.class) {
                addSysSoLibraryDirectory();
                addLocalSoLibraryDirectory(context);
            }
        }
    }

    public static boolean isSoLoadedSucc(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) ? sLoadedLibraries.contains(str) : invokeL.booleanValue;
    }

    public static boolean load(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, context, str)) == null) {
            if (sLoadedLibraries.contains(str)) {
                return true;
            }
            boolean load = load(context, str, (c93) null, true);
            if (load) {
                sLoadedLibraries.add(str);
            }
            return load;
        }
        return invokeLL.booleanValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    private boolean loadInternal(Context context, String str, c93 c93Var, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65551, this, new Object[]{context, str, c93Var, Boolean.valueOf(z)})) == null) {
            if (TextUtils.isEmpty(str)) {
                if (DEBUG) {
                    throw new IllegalArgumentException("load so library argument error,soName is null.");
                }
                return false;
            } else if (loadLibrary(c93Var, str, "SO_LOAD_LIBRARY")) {
                return true;
            } else {
                return loadInternalFromLocal(context, str, c93Var, z);
            }
        }
        return invokeCommon.booleanValue;
    }

    private boolean loadInternalFromLocal(Context context, String str, c93 c93Var, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65552, this, new Object[]{context, str, c93Var, Boolean.valueOf(z)})) == null) {
            String fullName = SoUtils.getFullName(str);
            ZipFile apkZipFile = getApkZipFile(context);
            if (apkZipFile == null) {
                SoUtils.sendLog(this.sb.toString());
                return false;
            }
            try {
                String str2 = SoUtils.uris[0] + File.separator + fullName;
                File file = new File(getNativeLibraryDir(context), fullName);
                if (file.exists() && file.length() == getSoSize(apkZipFile, str2) && load(c93Var, fullName, file.getAbsolutePath(), "SO_NATIVE_LIB_LOAD")) {
                    return true;
                }
                File file2 = new File(getReleaseSoFilePath(context), fullName);
                if (file2.exists() && file2.length() == getSoSize(apkZipFile, str2) && load(c93Var, fullName, file2.getAbsolutePath(), "SO_RELEASE_LIB_LOAD")) {
                    return true;
                }
                if (!z) {
                    SoUtils.sendLog(this.sb.toString());
                    return false;
                }
                for (int i = 0; i < SoUtils.uris.length; i++) {
                    if (executeRelease(apkZipFile, fullName, SoUtils.uris[i], new File(getReleaseSoFilePath(context), fullName)) && load(c93Var, fullName, file2.getAbsolutePath(), "SO_RELEASE_EXECUTE_LOAD")) {
                        return true;
                    }
                }
                SoUtils.sendLog(this.sb.toString());
                return false;
            } finally {
                pj4.d(apkZipFile);
            }
        }
        return invokeCommon.booleanValue;
    }

    private boolean loadLibrary(c93 c93Var, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65553, this, c93Var, str, str2)) == null) {
            String simpleName = SoUtils.getSimpleName(str);
            try {
                c93Var.loadLibrary(simpleName);
                return true;
            } catch (Throwable th) {
                if (DEBUG) {
                    Log.e("SoLoader", "SoLoader load exception.", th);
                }
                StringBuilder sb = this.sb;
                sb.append(str2 + ":::" + simpleName + ":" + Log.getStackTraceString(th));
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public static g93 loadV8EngineSo(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, context)) == null) {
            String c = f93.c();
            if (sLoadedLibraries.contains(c)) {
                return g93.e();
            }
            g93 h = f93.h(context, new SoLoader());
            if (h.b()) {
                sLoadedLibraries.add(c);
            }
            return h;
        }
        return (g93) invokeL.objValue;
    }

    private boolean releaseFileFromApk(ZipFile zipFile, File file, String str) {
        InterceptResult invokeLLL;
        FileOutputStream fileOutputStream;
        InputStream inputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65555, this, zipFile, file, str)) == null) {
            File file2 = new File(file.getAbsoluteFile() + ".tmp");
            InputStream inputStream2 = null;
            if (zipFile != null) {
                try {
                    inputStream = zipFile.getInputStream(zipFile.getEntry(str));
                    try {
                        fileOutputStream = new FileOutputStream(file2);
                    } catch (Exception e) {
                        e = e;
                        fileOutputStream = null;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = null;
                    }
                } catch (Exception e2) {
                    e = e2;
                    fileOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = null;
                }
                try {
                    if (SoUtils.copyStream(inputStream, fileOutputStream, 256) > 0) {
                        boolean renameTo = file2.renameTo(file);
                        pj4.d(inputStream);
                        pj4.d(fileOutputStream);
                        return renameTo;
                    }
                    inputStream2 = inputStream;
                } catch (Exception e3) {
                    e = e3;
                    inputStream2 = inputStream;
                    try {
                        if (DEBUG) {
                            Log.e("SoLoader", "SoLoader releaseFileFromApk exception.", e);
                        }
                        pj4.d(inputStream2);
                        pj4.d(fileOutputStream);
                        return false;
                    } catch (Throwable th3) {
                        th = th3;
                        pj4.d(inputStream2);
                        pj4.d(fileOutputStream);
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    inputStream2 = inputStream;
                    pj4.d(inputStream2);
                    pj4.d(fileOutputStream);
                    throw th;
                }
            } else {
                fileOutputStream = null;
            }
            pj4.d(inputStream2);
            pj4.d(fileOutputStream);
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public void appendErrorLog(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (DEBUG) {
                Log.e("SoLoader", String.valueOf(str));
            }
            this.sb.append(str);
            this.sb.append("\n");
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:56:0x00a7 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0080 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00aa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.Closeable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean executeRelease(ZipFile zipFile, String str, String str2, File file) {
        InterceptResult invokeLLLL;
        FileChannel fileChannel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zipFile, str, str2, file)) == null) {
            if (zipFile == null || file == null) {
                return false;
            }
            boolean z = true;
            ?? parentFile = file.getParentFile();
            if (parentFile == 0) {
                return false;
            }
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            FileLock fileLock = null;
            try {
                try {
                    File file2 = new File((File) parentFile, str + ".lock");
                    if (!file2.exists()) {
                        try {
                            file2.createNewFile();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        fileChannel = new RandomAccessFile(file2, "rw").getChannel();
                    } catch (FileNotFoundException e2) {
                        e = e2;
                        fileChannel = null;
                    }
                    try {
                        try {
                            fileLock = fileChannel.lock();
                        } catch (IOException e3) {
                            try {
                                e3.printStackTrace();
                            } catch (FileNotFoundException e4) {
                                e = e4;
                                e.printStackTrace();
                                if (fileLock != null) {
                                    z = releaseFileFromApk(zipFile, file, str2 + File.separator + str);
                                }
                                if (fileLock != null) {
                                }
                                pj4.d(fileChannel);
                                return z;
                            }
                        }
                        if (fileLock != null && fileLock.isValid()) {
                            z = releaseFileFromApk(zipFile, file, str2 + File.separator + str);
                        }
                        if (fileLock != null) {
                            try {
                                fileLock.release();
                            } catch (IOException e5) {
                                e = e5;
                                e.printStackTrace();
                                pj4.d(fileChannel);
                                return z;
                            }
                        }
                    } catch (Exception e6) {
                        e = e6;
                        this.sb.append(Log.getStackTraceString(e));
                        e.printStackTrace();
                        if (fileLock != null) {
                            try {
                                fileLock.release();
                            } catch (IOException e7) {
                                e = e7;
                                e.printStackTrace();
                                pj4.d(fileChannel);
                                return z;
                            }
                        }
                        pj4.d(fileChannel);
                        return z;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (0 != 0) {
                        try {
                            fileLock.release();
                        } catch (IOException e8) {
                            e8.printStackTrace();
                        }
                    }
                    pj4.d(parentFile);
                    throw th;
                }
            } catch (Exception e9) {
                e = e9;
                fileChannel = null;
            } catch (Throwable th2) {
                th = th2;
                parentFile = 0;
                if (0 != 0) {
                }
                pj4.d(parentFile);
                throw th;
            }
            pj4.d(fileChannel);
            return z;
        }
        return invokeLLLL.booleanValue;
    }

    public ZipFile getApkZipFile(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            try {
                return new ZipFile(context.getApplicationInfo().sourceDir);
            } catch (IOException e) {
                this.sb.append(Log.getStackTraceString(e));
                if (DEBUG) {
                    e.printStackTrace();
                    return null;
                }
                return null;
            }
        }
        return (ZipFile) invokeL.objValue;
    }

    public String getErrorLog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.sb.toString() : (String) invokeV.objValue;
    }

    public static void load(Context context, String str, boolean z, boolean z2) {
        boolean load;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{context, str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || sLoadedLibraries.contains(str)) {
            return;
        }
        b93 a = b93.a();
        if (!z) {
            load = new SoLoader().loadInternalFromLocal(context, str, a, z2);
        } else {
            load = load(context, str, a, z2);
        }
        if (load) {
            sLoadedLibraries.add(str);
        }
    }

    public static boolean load(Context context, String str, c93 c93Var, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, null, new Object[]{context, str, c93Var, Boolean.valueOf(z)})) == null) {
            if (c93Var == null) {
                c93Var = b93.a();
            }
            SoLoader soLoader = new SoLoader();
            if (soSources.size() == 0) {
                soLoader.initSoSource(context);
            }
            return soLoader.loadInternal(context, str, c93Var, z);
        }
        return invokeCommon.booleanValue;
    }

    private boolean load(c93 c93Var, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65550, this, c93Var, str, str2, str3)) == null) {
            try {
                c93Var.load(str2);
                return true;
            } catch (Throwable th) {
                if (DEBUG) {
                    Log.e("SoLoader", "SoLoader load exception.", th);
                }
                StringBuilder sb = this.sb;
                sb.append(str3 + ":::" + str2 + ":" + Log.getStackTraceString(th));
                return false;
            }
        }
        return invokeLLLL.booleanValue;
    }
}
