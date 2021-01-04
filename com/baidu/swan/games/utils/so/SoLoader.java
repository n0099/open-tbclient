package com.baidu.swan.games.utils.so;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
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
/* loaded from: classes9.dex */
public final class SoLoader {
    private static final String TAG = "SoLoader";
    private StringBuilder sb = new StringBuilder();
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final Set<String> sLoadedLibraries = Collections.synchronizedSet(new HashSet());
    private static final List<File> soSources = new ArrayList();

    private SoLoader() {
    }

    public static f loadV8EngineSo(Context context) {
        String bcO = e.bcO();
        if (sLoadedLibraries.contains(bcO)) {
            return f.bcQ();
        }
        f a2 = e.a(context, new SoLoader());
        if (a2.isSuccess()) {
            sLoadedLibraries.add(bcO);
            return a2;
        }
        return a2;
    }

    public static String getV8SoDependentFilePath() {
        if (!sLoadedLibraries.contains(e.bcO())) {
            return null;
        }
        String v8SoDependentFilePath = e.getV8SoDependentFilePath();
        if (DEBUG) {
            Log.i(TAG, "getV8SoDependentFilePath:" + v8SoDependentFilePath);
            return v8SoDependentFilePath;
        }
        return v8SoDependentFilePath;
    }

    public static boolean load(Context context, String str) {
        boolean z = true;
        if (!sLoadedLibraries.contains(str) && (z = load(context, str, (b) null, true))) {
            sLoadedLibraries.add(str);
        }
        return z;
    }

    public static void load(Context context, String str, boolean z, boolean z2) {
        boolean load;
        if (!sLoadedLibraries.contains(str)) {
            a bcE = a.bcE();
            if (!z) {
                load = new SoLoader().loadInternalFromLocal(context, str, bcE, z2);
            } else {
                load = load(context, str, bcE, z2);
            }
            if (load) {
                sLoadedLibraries.add(str);
            }
        }
    }

    private static boolean load(Context context, String str, b bVar, boolean z) {
        if (bVar == null) {
            bVar = a.bcE();
        }
        SoLoader soLoader = new SoLoader();
        if (soSources.size() == 0) {
            soLoader.initSoSource(context);
        }
        return soLoader.loadInternal(context, str, bVar, z);
    }

    private boolean load(b bVar, String str, String str2, String str3) {
        try {
            bVar.load(str2);
            return true;
        } catch (Throwable th) {
            if (DEBUG) {
                Log.e(TAG, "SoLoader load exception.", th);
            }
            this.sb.append(str3 + ":::" + str2 + ":" + Log.getStackTraceString(th));
            return false;
        }
    }

    private boolean loadInternal(Context context, String str, b bVar, boolean z) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("load so library argument error,soName is null.");
        }
        if (loadLibrary(bVar, str, "SO_LOAD_LIBRARY")) {
            return true;
        }
        return loadInternalFromLocal(context, str, bVar, z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [301=5] */
    private boolean loadInternalFromLocal(Context context, String str, b bVar, boolean z) {
        boolean z2 = false;
        String fullName = SoUtils.getFullName(str);
        ZipFile apkZipFile = getApkZipFile(context);
        if (apkZipFile == null) {
            SoUtils.sendLog(this.sb.toString());
        } else {
            try {
                String str2 = SoUtils.uris[0] + File.separator + fullName;
                File file = new File(getNativeLibraryDir(context), fullName);
                if (file.exists()) {
                    if (file.length() == getSoSize(apkZipFile, str2) && load(bVar, fullName, file.getAbsolutePath(), "SO_NATIVE_LIB_LOAD")) {
                        com.baidu.swan.c.d.closeSafely(apkZipFile);
                        z2 = true;
                    }
                }
                File file2 = new File(getReleaseSoFilePath(context), fullName);
                if (file2.exists()) {
                    if (file2.length() == getSoSize(apkZipFile, str2) && load(bVar, fullName, file2.getAbsolutePath(), "SO_RELEASE_LIB_LOAD")) {
                        com.baidu.swan.c.d.closeSafely(apkZipFile);
                        z2 = true;
                    }
                }
                if (z) {
                    int i = 0;
                    while (true) {
                        if (i >= SoUtils.uris.length) {
                            SoUtils.sendLog(this.sb.toString());
                            com.baidu.swan.c.d.closeSafely(apkZipFile);
                            break;
                        } else if (executeRelease(apkZipFile, fullName, SoUtils.uris[i], new File(getReleaseSoFilePath(context), str)) && load(bVar, fullName, file2.getAbsolutePath(), "SO_RELEASE_EXECUTE_LOAD")) {
                            com.baidu.swan.c.d.closeSafely(apkZipFile);
                            z2 = true;
                            break;
                        } else {
                            i++;
                        }
                    }
                } else {
                    SoUtils.sendLog(this.sb.toString());
                }
            } finally {
                com.baidu.swan.c.d.closeSafely(apkZipFile);
            }
        }
        return z2;
    }

    public static File getReleaseSoFilePath(Context context) {
        return new File(context.getFilesDir(), "lib");
    }

    private boolean loadLibrary(b bVar, String str, String str2) {
        String simpleName = SoUtils.getSimpleName(str);
        try {
            bVar.loadLibrary(simpleName);
            return true;
        } catch (Throwable th) {
            if (DEBUG) {
                Log.e(TAG, "SoLoader load exception.", th);
            }
            this.sb.append(str2 + ":::" + simpleName + ":" + Log.getStackTraceString(th));
            return false;
        }
    }

    public ZipFile getApkZipFile(Context context) {
        try {
            return new ZipFile(context.getApplicationInfo().sourceDir);
        } catch (IOException e) {
            this.sb.append(Log.getStackTraceString(e));
            if (DEBUG) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public void appendErrorLog(String str) {
        if (DEBUG) {
            Log.e(TAG, String.valueOf(str));
        }
        this.sb.append(str);
        this.sb.append("\n");
    }

    public String getErrorLog() {
        return this.sb.toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [428=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:39:0x009e */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0090 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0073 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x004f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v18 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean executeRelease(ZipFile zipFile, String str, String str2, File file) {
        FileLock fileLock;
        FileChannel fileChannel;
        FileLock fileLock2;
        FileChannel fileChannel2;
        FileChannel fileChannel3;
        FileChannel fileChannel4;
        boolean releaseFileFromApk;
        FileLock fileLock3 = null;
        if (zipFile == null || file == null) {
            return false;
        }
        File parentFile = file.getParentFile();
        if (parentFile == null) {
            return false;
        }
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        try {
            try {
                File file2 = new File(parentFile, str + ".lock");
                if (!file2.exists()) {
                    try {
                        file2.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    fileChannel3 = new RandomAccessFile(file2, "rw").getChannel();
                } catch (FileNotFoundException e2) {
                    e = e2;
                    fileChannel3 = null;
                }
            } catch (Throwable th) {
                th = th;
                fileChannel = parentFile;
            }
        } catch (Exception e3) {
            e = e3;
            fileLock2 = null;
            fileChannel2 = null;
        } catch (Throwable th2) {
            th = th2;
            fileLock = null;
            fileChannel = null;
        }
        try {
            try {
                fileLock3 = fileChannel3.lock();
            } catch (IOException e4) {
                try {
                    e4.printStackTrace();
                } catch (FileNotFoundException e5) {
                    e = e5;
                    e.printStackTrace();
                    fileLock2 = null;
                    fileChannel4 = fileChannel3;
                    if (fileLock2 != null) {
                    }
                    releaseFileFromApk = true;
                    if (fileLock2 != null) {
                    }
                    com.baidu.swan.c.d.closeSafely(fileChannel4);
                    return releaseFileFromApk;
                }
            }
            fileLock2 = fileLock3;
            fileChannel4 = fileChannel3;
            if (fileLock2 != null) {
                try {
                    if (fileLock2.isValid()) {
                        releaseFileFromApk = releaseFileFromApk(zipFile, file, str2 + File.separator + str);
                        if (fileLock2 != null) {
                            try {
                                fileLock2.release();
                            } catch (IOException e6) {
                                e6.printStackTrace();
                            }
                        }
                        com.baidu.swan.c.d.closeSafely(fileChannel4);
                        return releaseFileFromApk;
                    }
                } catch (Exception e7) {
                    e = e7;
                    fileChannel2 = fileChannel4;
                    this.sb.append(Log.getStackTraceString(e));
                    e.printStackTrace();
                    if (fileLock2 != null) {
                        try {
                            fileLock2.release();
                        } catch (IOException e8) {
                            e8.printStackTrace();
                        }
                    }
                    com.baidu.swan.c.d.closeSafely(fileChannel2);
                    return true;
                }
            }
            releaseFileFromApk = true;
            if (fileLock2 != null) {
            }
            com.baidu.swan.c.d.closeSafely(fileChannel4);
            return releaseFileFromApk;
        } catch (Exception e9) {
            e = e9;
            fileLock2 = null;
            fileChannel2 = fileChannel3;
            this.sb.append(Log.getStackTraceString(e));
            e.printStackTrace();
            if (fileLock2 != null) {
            }
            com.baidu.swan.c.d.closeSafely(fileChannel2);
            return true;
        } catch (Throwable th3) {
            th = th3;
            fileLock = null;
            fileChannel = fileChannel3;
            if (fileLock != null) {
                try {
                    fileLock.release();
                } catch (IOException e10) {
                    e10.printStackTrace();
                }
            }
            com.baidu.swan.c.d.closeSafely(fileChannel);
            throw th;
        }
    }

    private long getSoSize(ZipFile zipFile, String str) {
        if (zipFile == null) {
            return 0L;
        }
        try {
            ZipEntry entry = zipFile.getEntry(str);
            if (entry == null) {
                return 0L;
            }
            return entry.getSize();
        } catch (Exception e) {
            if (!DEBUG) {
                return 0L;
            }
            Log.e(TAG, "SoLoader getSoSize exception.", e);
            return 0L;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [492=5, 493=4] */
    private boolean releaseFileFromApk(ZipFile zipFile, File file, String str) {
        Throwable th;
        FileOutputStream fileOutputStream;
        InputStream inputStream;
        Exception exc;
        FileOutputStream fileOutputStream2;
        File file2 = new File(file.getAbsoluteFile() + ".tmp");
        if (zipFile != null) {
            try {
                inputStream = zipFile.getInputStream(zipFile.getEntry(str));
                try {
                    fileOutputStream2 = new FileOutputStream(file2);
                } catch (Exception e) {
                    exc = e;
                    fileOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = null;
                }
            } catch (Exception e2) {
                exc = e2;
                fileOutputStream = null;
                inputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
                inputStream = null;
            }
            try {
                if (SoUtils.copyStream(inputStream, fileOutputStream2, 256) > 0) {
                    boolean renameTo = file2.renameTo(file);
                    com.baidu.swan.c.d.closeSafely(inputStream);
                    com.baidu.swan.c.d.closeSafely(fileOutputStream2);
                    return renameTo;
                }
            } catch (Exception e3) {
                exc = e3;
                fileOutputStream = fileOutputStream2;
                try {
                    if (DEBUG) {
                        Log.e(TAG, "SoLoader releaseFileFromApk exception.", exc);
                    }
                    com.baidu.swan.c.d.closeSafely(inputStream);
                    com.baidu.swan.c.d.closeSafely(fileOutputStream);
                    return false;
                } catch (Throwable th4) {
                    th = th4;
                    com.baidu.swan.c.d.closeSafely(inputStream);
                    com.baidu.swan.c.d.closeSafely(fileOutputStream);
                    throw th;
                }
            } catch (Throwable th5) {
                th = th5;
                fileOutputStream = fileOutputStream2;
                com.baidu.swan.c.d.closeSafely(inputStream);
                com.baidu.swan.c.d.closeSafely(fileOutputStream);
                throw th;
            }
        } else {
            fileOutputStream2 = null;
            inputStream = null;
        }
        com.baidu.swan.c.d.closeSafely(inputStream);
        com.baidu.swan.c.d.closeSafely(fileOutputStream2);
        return false;
    }

    @SuppressLint({"NewApi"})
    private String getNativeLibraryDir(Context context) {
        String absolutePath;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            if (SoUtils.hasGingerbread()) {
                absolutePath = packageInfo.applicationInfo.nativeLibraryDir;
            } else {
                absolutePath = new File(packageInfo.applicationInfo.dataDir, "lib").getAbsolutePath();
            }
            return absolutePath;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static boolean isSoLoadedSucc(String str) {
        return sLoadedLibraries.contains(str);
    }

    private void initSoSource(Context context) {
        if (DEBUG) {
            Log.d(TAG, "initSoSource is called");
        }
        addSysSoLibraryDirectory();
        addLocalSoLibraryDirectory(context);
    }

    private void addSysSoLibraryDirectory() {
        String str = System.getenv("LD_LIBRARY_PATH");
        if (str == null) {
            str = "/vendor/lib:/system/lib";
        }
        String[] split = str.split(":");
        for (String str2 : split) {
            File file = new File(str2);
            if (!soSources.contains(file)) {
                soSources.add(file);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v5, resolved type: java.util.List<java.io.File> */
    /* JADX WARN: Multi-variable type inference failed */
    private void addLocalSoLibraryDirectory(Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new File(getNativeLibraryDir(context)));
        arrayList.add(new File(context.getFilesDir(), "lib"));
        for (int i = 0; i < arrayList.size(); i++) {
            if (!soSources.contains(arrayList.get(i))) {
                soSources.add(arrayList.get(i));
            }
        }
    }

    public static File findSoFilesInLibrary(Context context, String str) {
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
