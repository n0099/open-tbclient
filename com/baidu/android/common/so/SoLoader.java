package com.baidu.android.common.so;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.vm4;
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
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
/* loaded from: classes.dex */
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(784249519, "Lcom/baidu/android/common/so/SoLoader;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(784249519, "Lcom/baidu/android/common/so/SoLoader;");
                return;
            }
        }
        DEBUG = vm4.e();
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

    /* JADX WARN: Removed duplicated region for block: B:39:0x0089 A[Catch: IOException -> 0x008d, TRY_ENTER, TRY_LEAVE, TryCatch #3 {IOException -> 0x008d, blocks: (B:39:0x0089, B:58:0x00b0), top: B:81:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00c1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x007f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00b7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean executeRelease(Context context, ZipFile zipFile, String str, String str2) {
        InterceptResult invokeLLLL;
        FileChannel fileChannel;
        FileChannel fileChannel2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, this, context, zipFile, str, str2)) == null) {
            if (zipFile == null) {
                return false;
            }
            boolean z = true;
            File releaseSoFilePath = getReleaseSoFilePath(context);
            if (!releaseSoFilePath.exists()) {
                releaseSoFilePath.mkdirs();
            }
            File file = new File(releaseSoFilePath, str);
            FileLock fileLock = null;
            try {
                try {
                    File file2 = new File(releaseSoFilePath, str + ".lock");
                    if (!file2.exists()) {
                        try {
                            file2.createNewFile();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        fileChannel2 = new RandomAccessFile(file2, "rw").getChannel();
                    } catch (FileNotFoundException e2) {
                        e = e2;
                        fileChannel2 = null;
                    }
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                try {
                    try {
                        fileLock = fileChannel2.lock();
                    } catch (IOException e4) {
                        try {
                            e4.printStackTrace();
                        } catch (FileNotFoundException e5) {
                            e = e5;
                            e.printStackTrace();
                            if (fileLock != null) {
                                z = releaseFileFromApk(zipFile, file, str2 + File.separator + str);
                            }
                            if (fileLock != null) {
                            }
                            if (fileChannel2 != null) {
                            }
                            return z;
                        }
                    }
                    if (fileLock != null && fileLock.isValid()) {
                        z = releaseFileFromApk(zipFile, file, str2 + File.separator + str);
                    }
                    if (fileLock != null) {
                        try {
                            fileLock.release();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                } catch (Exception e7) {
                    fileChannel = fileChannel2;
                    e = e7;
                    try {
                        e.printStackTrace();
                        if (fileLock != null) {
                            try {
                                fileLock.release();
                            } catch (IOException e8) {
                                e8.printStackTrace();
                            }
                        }
                        if (fileChannel != null) {
                            fileChannel.close();
                        }
                        return z;
                    } catch (Throwable th) {
                        th = th;
                        if (fileLock != null) {
                            try {
                                fileLock.release();
                            } catch (IOException e9) {
                                e9.printStackTrace();
                            }
                        }
                        if (fileChannel != null) {
                            try {
                                fileChannel.close();
                            } catch (IOException e10) {
                                e10.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    fileChannel = fileChannel2;
                    th = th2;
                    if (fileLock != null) {
                    }
                    if (fileChannel != null) {
                    }
                    throw th;
                }
            } catch (Exception e11) {
                e = e11;
                fileChannel = null;
            } catch (Throwable th3) {
                th = th3;
                fileChannel = null;
            }
            if (fileChannel2 != null) {
                fileChannel2.close();
            }
            return z;
        }
        return invokeLLLL.booleanValue;
    }

    @SuppressLint({"NewApi"})
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

    private void initSoSource(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, context) == null) {
            if (DEBUG) {
                Log.d("SoLoader", "initSoSource is called");
            }
            addSysSoLibraryDirectory();
            addLocalSoLibraryDirectory(context);
        }
    }

    public static boolean isSoLoadedSucc(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) ? sLoadedLibraries.contains(str) : invokeL.booleanValue;
    }

    public static void load(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65546, null, context, str) == null) || sLoadedLibraries.contains(str)) {
            return;
        }
        load(context, str, (ICallingSoLoader) null);
    }

    private boolean loadInternal(Context context, String str, ICallingSoLoader iCallingSoLoader) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65550, this, context, str, iCallingSoLoader)) == null) {
            if (!TextUtils.isEmpty(str)) {
                if (loadLibrary(iCallingSoLoader, str, "SO_LOAD_LIBRARY")) {
                    return true;
                }
                return loadInternalFromLocal(context, str, iCallingSoLoader);
            }
            throw new IllegalArgumentException("load so library argument error,soName is null.");
        }
        return invokeLLL.booleanValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    private boolean loadInternalFromLocal(Context context, String str, ICallingSoLoader iCallingSoLoader) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65551, this, context, str, iCallingSoLoader)) == null) {
            String fullName = SoUtils.getFullName(str);
            ZipFile zipFile = null;
            try {
                try {
                    zipFile = new ZipFile(new File(context.getApplicationInfo().sourceDir));
                } catch (ZipException e) {
                    this.sb.append(Log.getStackTraceString(e));
                    e.printStackTrace();
                } catch (IOException e2) {
                    this.sb.append(Log.getStackTraceString(e2));
                    e2.printStackTrace();
                }
                if (zipFile == null) {
                    SoUtils.sendLog(this.sb.toString());
                    return false;
                }
                int i = !SoUtils.is64Bit() ? 1 : 0;
                String str2 = SoUtils.uris[i] + File.separator + fullName;
                File file = new File(getNativeLibraryDir(context), fullName);
                if (file.exists()) {
                    if (file.length() == getSoSize(zipFile, str2) && load(iCallingSoLoader, file.getAbsolutePath(), "SO_NATIVE_LIB_LOAD")) {
                        if (zipFile != null) {
                            try {
                                zipFile.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        return true;
                    }
                }
                File file2 = new File(getReleaseSoFilePath(context), fullName);
                if (file2.exists()) {
                    if (file2.length() == getSoSize(zipFile, str2) && load(iCallingSoLoader, file2.getAbsolutePath(), "SO_RELEASE_LIB_LOAD")) {
                        if (zipFile != null) {
                            try {
                                zipFile.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        return true;
                    }
                }
                while (i < SoUtils.uris.length) {
                    if (executeRelease(context, zipFile, fullName, SoUtils.uris[i]) && load(iCallingSoLoader, file2.getAbsolutePath(), "SO_RELEASE_EXECUTE_LOAD")) {
                        if (zipFile != null) {
                            try {
                                zipFile.close();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                            }
                        }
                        return true;
                    }
                    i++;
                }
                SoUtils.sendLog(this.sb.toString());
                if (zipFile != null) {
                    try {
                        zipFile.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
                return false;
            } finally {
                if (0 != 0) {
                    try {
                        zipFile.close();
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                }
            }
        }
        return invokeLLL.booleanValue;
    }

    private boolean loadLibrary(ICallingSoLoader iCallingSoLoader, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65552, this, iCallingSoLoader, str, str2)) == null) {
            String simpleName = SoUtils.getSimpleName(str);
            try {
                iCallingSoLoader.loadLibrary(simpleName);
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

    /* JADX WARN: Removed duplicated region for block: B:77:0x008c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0082 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean releaseFileFromApk(ZipFile zipFile, File file, String str) {
        InterceptResult invokeLLL;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65553, this, zipFile, file, str)) == null) {
            File file2 = new File(file.getAbsoluteFile() + ".tmp");
            InputStream inputStream = null;
            try {
                if (zipFile != null) {
                    try {
                        InputStream inputStream2 = zipFile.getInputStream(zipFile.getEntry(str));
                        try {
                            fileOutputStream = new FileOutputStream(file2);
                            try {
                                if (SoUtils.copyStream(inputStream2, fileOutputStream, 256) > 0) {
                                    boolean renameTo = file2.renameTo(file);
                                    if (inputStream2 != null) {
                                        try {
                                            inputStream2.close();
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                    try {
                                        fileOutputStream.close();
                                    } catch (Exception e2) {
                                        e2.printStackTrace();
                                    }
                                    return renameTo;
                                }
                                inputStream = inputStream2;
                            } catch (Exception e3) {
                                e = e3;
                                inputStream = inputStream2;
                                try {
                                    if (DEBUG) {
                                        Log.e("SoLoader", "SoLoader releaseFileFromApk exception.", e);
                                    }
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Exception e4) {
                                            e4.printStackTrace();
                                        }
                                    }
                                    if (fileOutputStream != null) {
                                        fileOutputStream.close();
                                        return false;
                                    }
                                    return false;
                                } catch (Throwable th) {
                                    th = th;
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Exception e5) {
                                            e5.printStackTrace();
                                        }
                                    }
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                        } catch (Exception e6) {
                                            e6.printStackTrace();
                                        }
                                    }
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                inputStream = inputStream2;
                                if (inputStream != null) {
                                }
                                if (fileOutputStream != null) {
                                }
                                throw th;
                            }
                        } catch (Exception e7) {
                            e = e7;
                            fileOutputStream = null;
                        } catch (Throwable th3) {
                            th = th3;
                            fileOutputStream = null;
                        }
                    } catch (Exception e8) {
                        e = e8;
                        fileOutputStream = null;
                    } catch (Throwable th4) {
                        th = th4;
                        fileOutputStream = null;
                    }
                } else {
                    fileOutputStream = null;
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e9) {
                        e9.printStackTrace();
                    }
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                    return false;
                }
                return false;
            } catch (Exception e10) {
                e10.printStackTrace();
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public static File unpackLibraryAndDependencies(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, str)) == null) {
            if (DEBUG) {
                Log.d("SoLoader", "unpackLibDep is called, shortName=" + str);
            }
            String fullName = SoUtils.getFullName(str);
            try {
                if (soSources.size() == 0 || 0 >= soSources.size()) {
                    return null;
                }
                File file = new File(soSources.get(0), fullName);
                if (DEBUG) {
                    Log.d("SoLoader", "unpackLibDep soFile path is: " + file.getAbsolutePath());
                }
                return file;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return (File) invokeL.objValue;
    }

    public static void load(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(65548, null, context, str, z) == null) || sLoadedLibraries.contains(str)) {
            return;
        }
        DefaultSoLoader defaultSoLoader = DefaultSoLoader.getDefaultSoLoader();
        if (!z) {
            if (new SoLoader().loadInternalFromLocal(context, str, defaultSoLoader)) {
                sLoadedLibraries.add(str);
                return;
            }
            return;
        }
        load(context, str, defaultSoLoader);
    }

    public static void load(Context context, String str, ICallingSoLoader iCallingSoLoader) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, context, str, iCallingSoLoader) == null) {
            if (iCallingSoLoader == null) {
                iCallingSoLoader = DefaultSoLoader.getDefaultSoLoader();
            }
            SoLoader soLoader = new SoLoader();
            if (soSources.size() == 0) {
                soLoader.initSoSource(context);
            }
            if (soLoader.loadInternal(context, str, iCallingSoLoader)) {
                sLoadedLibraries.add(str);
            }
        }
    }

    private boolean load(ICallingSoLoader iCallingSoLoader, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65549, this, iCallingSoLoader, str, str2)) == null) {
            try {
                iCallingSoLoader.load(str);
                return true;
            } catch (Throwable th) {
                if (DEBUG) {
                    Log.e("SoLoader", "SoLoader load exception.", th);
                }
                StringBuilder sb = this.sb;
                sb.append(str2 + ":::" + str + ":" + Log.getStackTraceString(th));
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }
}
