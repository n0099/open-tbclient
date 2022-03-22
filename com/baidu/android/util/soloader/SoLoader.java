package com.baidu.android.util.soloader;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.NoProGuard;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.lang.ref.WeakReference;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
/* loaded from: classes3.dex */
public final class SoLoader implements NoProGuard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String TAG = "SoLoader";
    public static Map<String, WeakReference<Lock>> releaseSoLockMap;
    public static final Set<String> sLoadedLibraries;
    public static final List<File> soSources;
    public transient /* synthetic */ FieldHolder $fh;
    public StringBuilder sb;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2077002379, "Lcom/baidu/android/util/soloader/SoLoader;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2077002379, "Lcom/baidu/android/util/soloader/SoLoader;");
                return;
            }
        }
        sLoadedLibraries = Collections.synchronizedSet(new HashSet());
        soSources = new ArrayList();
        releaseSoLockMap = new ConcurrentHashMap();
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

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:59:0x009b */
    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.titan.sdk.runtime.Interceptable */
    /* JADX DEBUG: Multi-variable search result rejected for r3v5, resolved type: java.nio.channels.FileChannel */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0078 A[Catch: IOException -> 0x007c, TRY_ENTER, TRY_LEAVE, TryCatch #11 {IOException -> 0x007c, blocks: (B:40:0x0078, B:57:0x0097), top: B:93:0x001b }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0097 A[Catch: IOException -> 0x007c, TRY_ENTER, TRY_LEAVE, TryCatch #11 {IOException -> 0x007c, blocks: (B:40:0x0078, B:57:0x0097), top: B:93:0x001b }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x008d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x006e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00a8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x009e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean executeRelease(Context context, ZipFile zipFile, String str, String str2, long j) {
        FileChannel fileChannel;
        InterceptResult invokeCommon;
        FileChannel fileChannel2;
        Interceptable interceptable = $ic;
        if (interceptable == 0 || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, (fileChannel = new Object[]{context, zipFile, str, str2, Long.valueOf(j)}))) == null) {
            boolean z = false;
            if (zipFile == null) {
                return false;
            }
            File releaseSoFilePath = getReleaseSoFilePath(context);
            if (!releaseSoFilePath.exists()) {
                releaseSoFilePath.mkdirs();
            }
            File file = new File(releaseSoFilePath, str);
            FileLock fileLock = null;
            try {
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            try {
                try {
                    File file2 = new File(releaseSoFilePath, str + ".lock");
                    if (!file2.exists()) {
                        try {
                            file2.createNewFile();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    try {
                        fileChannel2 = new RandomAccessFile(file2, "rw").getChannel();
                    } catch (FileNotFoundException e4) {
                        e = e4;
                        fileChannel2 = null;
                    }
                    try {
                        try {
                            fileLock = fileChannel2.lock();
                        } catch (IOException e5) {
                            try {
                                e5.printStackTrace();
                            } catch (FileNotFoundException e6) {
                                e = e6;
                                e.printStackTrace();
                                if (fileLock != null) {
                                    saveCrc(j, str, releaseSoFilePath);
                                }
                                if (fileLock != null) {
                                }
                                if (fileChannel2 != null) {
                                }
                                return z;
                            }
                        }
                        if (fileLock != null && fileLock.isValid() && (z = releaseFileFromApk(zipFile, file, str2))) {
                            saveCrc(j, str, releaseSoFilePath);
                        }
                        if (fileLock != null) {
                            try {
                                fileLock.release();
                            } catch (IOException e7) {
                                e7.printStackTrace();
                            }
                        }
                    } catch (Exception e8) {
                        e = e8;
                        e.printStackTrace();
                        if (fileLock != null) {
                            try {
                                fileLock.release();
                            } catch (IOException e9) {
                                e9.printStackTrace();
                            }
                        }
                        if (fileChannel2 != null) {
                            fileChannel2.close();
                        }
                        return z;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (0 != 0) {
                        try {
                            fileLock.release();
                        } catch (IOException e10) {
                            e10.printStackTrace();
                        }
                    }
                    if (fileChannel != 0) {
                        try {
                            fileChannel.close();
                        } catch (IOException e11) {
                            e11.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e12) {
                e = e12;
                fileChannel2 = null;
                e.printStackTrace();
                if (fileLock != null) {
                }
                if (fileChannel2 != null) {
                }
                return z;
            } catch (Throwable th2) {
                th = th2;
                fileChannel = 0;
                if (0 != 0) {
                }
                if (fileChannel != 0) {
                }
                throw th;
            }
            if (fileChannel2 != null) {
                fileChannel2.close();
            }
            return z;
        }
        return invokeCommon.booleanValue;
    }

    private String getCrcFileName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, str)) == null) {
            int lastIndexOf = str.lastIndexOf(".");
            if (lastIndexOf != -1) {
                str = str.substring(0, lastIndexOf);
            }
            return str + "_crc";
        }
        return (String) invokeL.objValue;
    }

    public static synchronized Lock getLock(String str) {
        InterceptResult invokeL;
        Lock reentrantLock;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            synchronized (SoLoader.class) {
                WeakReference<Lock> weakReference = releaseSoLockMap.get(str);
                if (weakReference == null || (reentrantLock = weakReference.get()) == null) {
                    reentrantLock = new ReentrantLock();
                    releaseSoLockMap.put(str, new WeakReference<>(reentrantLock));
                }
            }
            return reentrantLock;
        }
        return (Lock) invokeL.objValue;
    }

    private String getNativeLibraryDir(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, context)) == null) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.nativeLibraryDir;
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static File getReleaseSoFilePath(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) ? new File(context.getFilesDir(), "lib") : (File) invokeL.objValue;
    }

    private long getSoCrc(ZipFile zipFile, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, this, zipFile, str)) == null) {
            if (zipFile != null) {
                try {
                    ZipEntry entry = zipFile.getEntry(str);
                    if (entry != null) {
                        return entry.getCrc();
                    }
                    return 0L;
                } catch (Exception unused) {
                    return 0L;
                }
            }
            return 0L;
        }
        return invokeLL.longValue;
    }

    private long getSoSize(ZipFile zipFile, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, this, zipFile, str)) == null) {
            if (zipFile != null) {
                try {
                    ZipEntry entry = zipFile.getEntry(str);
                    if (entry != null) {
                        return entry.getSize();
                    }
                    return 0L;
                } catch (Exception unused) {
                    return 0L;
                }
            }
            return 0L;
        }
        return invokeLL.longValue;
    }

    private void initSoSource(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, context) == null) {
            addSysSoLibraryDirectory();
            addLocalSoLibraryDirectory(context);
        }
    }

    public static boolean isSoLoadedSucc(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) ? sLoadedLibraries.contains(str) : invokeL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0071 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean isValidFile(String str, long j, long j2) {
        InterceptResult invokeCommon;
        BufferedReader bufferedReader;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65549, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2)})) != null) {
            return invokeCommon.booleanValue;
        }
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        BufferedReader bufferedReader2 = null;
        r1 = null;
        r1 = null;
        String str3 = null;
        BufferedReader bufferedReader3 = null;
        try {
            File file2 = new File(file.getParentFile(), getCrcFileName(file.getName()));
            if (file2.exists()) {
                bufferedReader = new BufferedReader(new FileReader(file2));
                try {
                    try {
                        bufferedReader3 = bufferedReader;
                        str2 = bufferedReader.readLine();
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                        }
                        return !TextUtils.equals(String.valueOf(j), str3) ? false : false;
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            } else {
                str2 = null;
            }
            if (bufferedReader3 != null) {
                try {
                    bufferedReader3.close();
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
            str3 = str2;
        } catch (Exception e6) {
            e = e6;
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
            if (bufferedReader2 != null) {
            }
            throw th;
        }
        if (!TextUtils.equals(String.valueOf(j), str3) && j2 == file.length()) {
            return true;
        }
    }

    public static void load(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65550, null, context, str) == null) || sLoadedLibraries.contains(str)) {
            return;
        }
        load(context, str, (ICallingSoLoader) null);
    }

    private boolean loadFromNativeLibDir(Context context, ICallingSoLoader iCallingSoLoader, String str, long j, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65554, this, new Object[]{context, iCallingSoLoader, str, Long.valueOf(j), str2})) == null) {
            File file = new File(getNativeLibraryDir(context), str);
            return file.exists() && file.length() == j && load(iCallingSoLoader, file.getAbsolutePath(), "SO_NATIVE_LIB_LOAD");
        }
        return invokeCommon.booleanValue;
    }

    private boolean loadFromReleaseApk(Context context, ICallingSoLoader iCallingSoLoader, String str, ZipFile zipFile, String str2, long j) {
        InterceptResult invokeCommon;
        long soCrc;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65555, this, new Object[]{context, iCallingSoLoader, str, zipFile, str2, Long.valueOf(j)})) == null) {
            String absolutePath = new File(getReleaseSoFilePath(context), str).getAbsolutePath();
            Lock lock = getLock(str);
            lock.lock();
            try {
                try {
                    soCrc = getSoCrc(zipFile, str2);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (loadFromReleaseCache(iCallingSoLoader, absolutePath, soCrc, j)) {
                    return true;
                }
                if (executeRelease(context, zipFile, str, str2, soCrc)) {
                    if (loadFromReleaseCache(iCallingSoLoader, absolutePath, soCrc, j)) {
                        return true;
                    }
                }
                lock.unlock();
                return false;
            } finally {
                lock.unlock();
            }
        }
        return invokeCommon.booleanValue;
    }

    private boolean loadFromReleaseCache(ICallingSoLoader iCallingSoLoader, String str, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65556, this, new Object[]{iCallingSoLoader, str, Long.valueOf(j), Long.valueOf(j2)})) == null) ? isValidFile(str, j, j2) && load(iCallingSoLoader, str, "SO_RELEASE_LIB_LOAD") : invokeCommon.booleanValue;
    }

    private boolean loadInternal(Context context, String str, ICallingSoLoader iCallingSoLoader) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65557, this, context, str, iCallingSoLoader)) == null) {
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

    /* JADX WARN: Removed duplicated region for block: B:15:0x003b A[Catch: all -> 0x00bc, TRY_ENTER, TRY_LEAVE, TryCatch #7 {all -> 0x00bc, blocks: (B:15:0x003b, B:22:0x0050, B:31:0x0095, B:39:0x00a7), top: B:73:0x0039 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0050 A[Catch: all -> 0x00bc, TRY_ENTER, TRY_LEAVE, TryCatch #7 {all -> 0x00bc, blocks: (B:15:0x003b, B:22:0x0050, B:31:0x0095, B:39:0x00a7), top: B:73:0x0039 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean loadInternalFromLocal(Context context, String str, ICallingSoLoader iCallingSoLoader) {
        InterceptResult invokeLLL;
        Throwable th;
        ZipFile zipFile;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65558, this, context, str, iCallingSoLoader)) == null) {
            String fullName = SoUtils.getFullName(str);
            ZipFile zipFile2 = null;
            try {
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                try {
                    try {
                        zipFile = new ZipFile(new File(context.getApplicationInfo().sourceDir));
                    } catch (ZipException e2) {
                        this.sb.append(Log.getStackTraceString(e2));
                        e2.printStackTrace();
                        zipFile = null;
                        if (zipFile == null) {
                        }
                    }
                } catch (IOException e3) {
                    this.sb.append(Log.getStackTraceString(e3));
                    e3.printStackTrace();
                    zipFile = null;
                    if (zipFile == null) {
                    }
                }
                if (zipFile == null) {
                    SoUtils.sendLog(this.sb.toString());
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    return false;
                }
                int i = !SoUtils.is64Bit() ? 1 : 0;
                String str2 = SoUtils.uris[i] + File.separator + fullName;
                long soSize = getSoSize(zipFile, str2);
                if (loadFromNativeLibDir(context, iCallingSoLoader, fullName, soSize, str2)) {
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    return true;
                } else if (loadFromReleaseApk(context, iCallingSoLoader, fullName, zipFile, str2, soSize)) {
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                    return true;
                } else {
                    SoUtils.sendLog(this.sb.toString());
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException e7) {
                            e7.printStackTrace();
                        }
                    }
                    return false;
                }
            } catch (Throwable th3) {
                th = th3;
                zipFile2 = zipFile;
                if (zipFile2 != null) {
                    try {
                        zipFile2.close();
                    } catch (IOException e8) {
                        e8.printStackTrace();
                    }
                }
                throw th;
            }
        }
        return invokeLLL.booleanValue;
    }

    private boolean loadLibrary(ICallingSoLoader iCallingSoLoader, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65559, this, iCallingSoLoader, str, str2)) == null) {
            String simpleName = SoUtils.getSimpleName(str);
            try {
                iCallingSoLoader.loadLibrary(simpleName);
                return true;
            } catch (Throwable th) {
                StringBuilder sb = this.sb;
                sb.append(str2 + ":::" + simpleName + ":" + Log.getStackTraceString(th));
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    private boolean releaseFileFromApk(ZipFile zipFile, File file, String str) {
        InterceptResult invokeLLL;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65560, this, zipFile, file, str)) == null) {
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
                                        } catch (Exception e2) {
                                            e2.printStackTrace();
                                        }
                                    }
                                    try {
                                        fileOutputStream.close();
                                    } catch (Exception e3) {
                                        e3.printStackTrace();
                                    }
                                    return renameTo;
                                }
                                inputStream = inputStream2;
                            } catch (Exception unused) {
                                inputStream = inputStream2;
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
                                inputStream = inputStream2;
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
                        } catch (Exception unused2) {
                            fileOutputStream = null;
                        } catch (Throwable th2) {
                            th = th2;
                            fileOutputStream = null;
                        }
                    } catch (Exception unused3) {
                        fileOutputStream = null;
                    } catch (Throwable th3) {
                        th = th3;
                        fileOutputStream = null;
                    }
                } else {
                    fileOutputStream = null;
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e7) {
                        e7.printStackTrace();
                    }
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                    return false;
                }
                return false;
            } catch (Exception e8) {
                e8.printStackTrace();
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    private boolean saveCrc(long j, String str, File file) {
        InterceptResult invokeCommon;
        BufferedWriter bufferedWriter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65561, this, new Object[]{Long.valueOf(j), str, file})) == null) {
            BufferedWriter bufferedWriter2 = null;
            try {
                try {
                    bufferedWriter = new BufferedWriter(new FileWriter(new File(file, getCrcFileName(str))));
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                bufferedWriter.write(String.valueOf(j));
                try {
                    bufferedWriter.close();
                    return true;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return true;
                }
            } catch (Exception e4) {
                e = e4;
                bufferedWriter2 = bufferedWriter;
                e.printStackTrace();
                if (bufferedWriter2 != null) {
                    try {
                        bufferedWriter2.close();
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                bufferedWriter2 = bufferedWriter;
                if (bufferedWriter2 != null) {
                    try {
                        bufferedWriter2.close();
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }
                throw th;
            }
        }
        return invokeCommon.booleanValue;
    }

    public static File unpackLibraryAndDependencies(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, str)) == null) {
            String fullName = SoUtils.getFullName(str);
            try {
                if (soSources.size() == 0 || 0 >= soSources.size()) {
                    return null;
                }
                return new File(soSources.get(0), fullName);
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (File) invokeL.objValue;
    }

    public static void load(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(65552, null, context, str, z) == null) || sLoadedLibraries.contains(str)) {
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
        if (interceptable == null || interceptable.invokeLLL(65551, null, context, str, iCallingSoLoader) == null) {
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
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65553, this, iCallingSoLoader, str, str2)) == null) {
            try {
                iCallingSoLoader.load(str);
                return true;
            } catch (Throwable th) {
                StringBuilder sb = this.sb;
                sb.append(str2 + ":::" + str + ":" + Log.getStackTraceString(th));
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }
}
