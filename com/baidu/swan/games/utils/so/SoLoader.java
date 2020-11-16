package com.baidu.swan.games.utils.so;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.annotation.Keep;
import android.text.TextUtils;
import android.util.Log;
import java.io.Closeable;
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
/* loaded from: classes7.dex */
public final class SoLoader {
    private static final String TAG = "SoLoader";
    private StringBuilder sb = new StringBuilder();
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final Set<String> sLoadedLibraries = Collections.synchronizedSet(new HashSet());
    private static final List<File> soSources = new ArrayList();

    private SoLoader() {
    }

    public static f loadV8EngineSo(Context context) {
        String aXp = e.aXp();
        if (sLoadedLibraries.contains(aXp)) {
            return f.aXr();
        }
        f a2 = e.a(context, new SoLoader());
        if (a2.isSuccess()) {
            sLoadedLibraries.add(aXp);
            return a2;
        }
        return a2;
    }

    public static String getV8SoDependentFilePath() {
        if (!sLoadedLibraries.contains(e.aXp())) {
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
            a aXf = a.aXf();
            if (!z) {
                load = new SoLoader().loadInternalFromLocal(context, str, aXf, z2);
            } else {
                load = load(context, str, aXf, z2);
            }
            if (load) {
                sLoadedLibraries.add(str);
            }
        }
    }

    private static boolean load(Context context, String str, b bVar, boolean z) {
        if (bVar == null) {
            bVar = a.aXf();
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
    /* JADX WARN: Removed duplicated region for block: B:69:0x004f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0092 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0073 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00b6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean executeRelease(ZipFile zipFile, String str, String str2, File file) {
        FileLock fileLock;
        FileChannel fileChannel;
        Throwable th;
        Exception e;
        boolean releaseFileFromApk;
        FileLock fileLock2 = null;
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
            File file2 = new File(parentFile, str + ".lock");
            if (!file2.exists()) {
                try {
                    file2.createNewFile();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            try {
                fileChannel = new RandomAccessFile(file2, "rw").getChannel();
            } catch (FileNotFoundException e3) {
                e = e3;
                fileChannel = null;
            }
            try {
                try {
                    fileLock2 = fileChannel.lock();
                } catch (IOException e4) {
                    try {
                        e4.printStackTrace();
                    } catch (FileNotFoundException e5) {
                        e = e5;
                        e.printStackTrace();
                        fileLock = null;
                        if (fileLock != null) {
                        }
                        releaseFileFromApk = true;
                        if (fileLock != null) {
                        }
                        com.baidu.swan.c.d.closeSafely(fileChannel);
                        return releaseFileFromApk;
                    }
                }
                fileLock = fileLock2;
                if (fileLock != null) {
                    try {
                        try {
                            if (fileLock.isValid()) {
                                releaseFileFromApk = releaseFileFromApk(zipFile, file, str2 + File.separator + str);
                                if (fileLock != null) {
                                    try {
                                        fileLock.release();
                                    } catch (IOException e6) {
                                        e6.printStackTrace();
                                    }
                                }
                                com.baidu.swan.c.d.closeSafely(fileChannel);
                                return releaseFileFromApk;
                            }
                        } catch (Exception e7) {
                            e = e7;
                            this.sb.append(Log.getStackTraceString(e));
                            e.printStackTrace();
                            if (fileLock != null) {
                                try {
                                    fileLock.release();
                                } catch (IOException e8) {
                                    e8.printStackTrace();
                                }
                            }
                            com.baidu.swan.c.d.closeSafely(fileChannel);
                            return true;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileLock != null) {
                            try {
                                fileLock.release();
                            } catch (IOException e9) {
                                e9.printStackTrace();
                            }
                        }
                        com.baidu.swan.c.d.closeSafely(fileChannel);
                        throw th;
                    }
                }
                releaseFileFromApk = true;
                if (fileLock != null) {
                }
                com.baidu.swan.c.d.closeSafely(fileChannel);
                return releaseFileFromApk;
            } catch (Exception e10) {
                fileLock = null;
                e = e10;
                this.sb.append(Log.getStackTraceString(e));
                e.printStackTrace();
                if (fileLock != null) {
                }
                com.baidu.swan.c.d.closeSafely(fileChannel);
                return true;
            } catch (Throwable th3) {
                fileLock = null;
                th = th3;
                if (fileLock != null) {
                }
                com.baidu.swan.c.d.closeSafely(fileChannel);
                throw th;
            }
        } catch (Exception e11) {
            fileChannel = null;
            e = e11;
            fileLock = null;
        } catch (Throwable th4) {
            fileLock = null;
            fileChannel = null;
            th = th4;
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
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [java.io.OutputStream, java.io.Closeable, java.io.FileOutputStream] */
    private boolean releaseFileFromApk(ZipFile zipFile, File file, String str) {
        InputStream inputStream;
        ?? fileOutputStream;
        Closeable closeable;
        InputStream inputStream2 = null;
        File file2 = new File(file.getAbsoluteFile() + ".tmp");
        if (zipFile != null) {
            try {
                inputStream = zipFile.getInputStream(zipFile.getEntry(str));
                try {
                    try {
                        fileOutputStream = new FileOutputStream(file2);
                    } catch (Exception e) {
                        e = e;
                    }
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e2) {
                e = e2;
                inputStream = null;
            } catch (Throwable th2) {
                th = th2;
                inputStream = null;
            }
            try {
                if (SoUtils.copyStream(inputStream, fileOutputStream, 256) > 0) {
                    boolean renameTo = file2.renameTo(file);
                    com.baidu.swan.c.d.closeSafely(inputStream);
                    com.baidu.swan.c.d.closeSafely(fileOutputStream);
                    return renameTo;
                }
                inputStream2 = inputStream;
                closeable = fileOutputStream;
            } catch (Exception e3) {
                inputStream2 = fileOutputStream;
                e = e3;
                if (DEBUG) {
                    Log.e(TAG, "SoLoader releaseFileFromApk exception.", e);
                }
                com.baidu.swan.c.d.closeSafely(inputStream);
                com.baidu.swan.c.d.closeSafely(inputStream2);
                return false;
            } catch (Throwable th3) {
                inputStream2 = fileOutputStream;
                th = th3;
                com.baidu.swan.c.d.closeSafely(inputStream);
                com.baidu.swan.c.d.closeSafely(inputStream2);
                throw th;
            }
        } else {
            closeable = null;
        }
        com.baidu.swan.c.d.closeSafely(inputStream2);
        com.baidu.swan.c.d.closeSafely(closeable);
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
