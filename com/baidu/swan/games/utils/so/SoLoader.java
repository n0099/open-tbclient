package com.baidu.swan.games.utils.so;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.annotation.Keep;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.plugin.Plugin;
import com.baidu.android.common.so.SoUtils;
import com.baidu.mobstat.Config;
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
@Keep
/* loaded from: classes2.dex */
public final class SoLoader {
    private static final String TAG = "SoLoader";
    private StringBuilder sb = new StringBuilder();
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final Set<String> sLoadedLibraries = Collections.synchronizedSet(new HashSet());
    private static final List<File> soSources = new ArrayList();

    private SoLoader() {
    }

    public static void load(Context context, String str) {
        if (!sLoadedLibraries.contains(str)) {
            load(context, str, (b) null);
        }
    }

    public static void load(Context context, String str, boolean z) {
        if (!sLoadedLibraries.contains(str)) {
            a Pm = a.Pm();
            if (!z) {
                if (new SoLoader().loadInternalFromLocal(context, str, Pm)) {
                    sLoadedLibraries.add(str);
                    return;
                }
                return;
            }
            load(context, str, Pm);
        }
    }

    public static void load(Context context, String str, b bVar) {
        if (bVar == null) {
            bVar = a.Pm();
        }
        SoLoader soLoader = new SoLoader();
        if (soSources.size() == 0) {
            soLoader.initSoSource(context);
        }
        if (soLoader.loadInternal(context, str, bVar)) {
            sLoadedLibraries.add(str);
        }
    }

    private boolean load(b bVar, String str, String str2, String str3) {
        try {
            bVar.load(str2);
            return true;
        } catch (Throwable th) {
            if (DEBUG) {
                Log.e(TAG, "SoLoader load exception.", th);
            }
            this.sb.append(str3 + ":::" + str2 + Config.TRACE_TODAY_VISIT_SPLIT + Log.getStackTraceString(th));
            return false;
        }
    }

    private boolean loadInternal(Context context, String str, b bVar) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("load so library argument error,soName is null.");
        }
        if (loadLibrary(bVar, str, SoUtils.SOLOG.SO_LOAD_LIBRARY)) {
            return true;
        }
        return loadInternalFromLocal(context, str, bVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [256=7, 258=6, 259=6, 260=6] */
    private boolean loadInternalFromLocal(Context context, String str, b bVar) {
        ZipFile zipFile;
        ZipFile zipFile2;
        String fullName = SoUtils.getFullName(str);
        try {
            String str2 = SoUtils.uris[0] + File.separator + fullName;
            try {
                zipFile2 = new ZipFile(new File(context.getApplicationInfo().sourceDir));
            } catch (ZipException e) {
                this.sb.append(Log.getStackTraceString(e));
                e.printStackTrace();
                zipFile2 = null;
            } catch (IOException e2) {
                this.sb.append(Log.getStackTraceString(e2));
                e2.printStackTrace();
                zipFile2 = null;
            }
            try {
                if (zipFile2 == null) {
                    SoUtils.sendLog(this.sb.toString());
                    if (zipFile2 != null) {
                        try {
                            zipFile2.close();
                            return false;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            return false;
                        }
                    }
                    return false;
                }
                File file = new File(getNativeLibraryDir(context), fullName);
                if (file.exists()) {
                    if (file.length() == getSoSize(zipFile2, str2) && load(bVar, fullName, file.getAbsolutePath(), SoUtils.SOLOG.SO_NATIVE_LIB_LOAD)) {
                        if (zipFile2 != null) {
                            try {
                                zipFile2.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        return true;
                    }
                }
                File file2 = new File(getReleaseSoFilePath(context), fullName);
                if (file2.exists()) {
                    if (file2.length() == getSoSize(zipFile2, str2) && load(bVar, fullName, file2.getAbsolutePath(), SoUtils.SOLOG.SO_RELEASE_LIB_LOAD)) {
                        if (zipFile2 != null) {
                            try {
                                zipFile2.close();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                            }
                        }
                        return true;
                    }
                }
                for (int i = 0; i < SoUtils.uris.length; i++) {
                    if (executeRelease(context, zipFile2, fullName, SoUtils.uris[i]) && load(bVar, fullName, file2.getAbsolutePath(), SoUtils.SOLOG.SO_RELEASE_EXECUTE_LOAD)) {
                        if (zipFile2 != null) {
                            try {
                                zipFile2.close();
                            } catch (IOException e6) {
                                e6.printStackTrace();
                            }
                        }
                        return true;
                    }
                }
                SoUtils.sendLog(this.sb.toString());
                if (zipFile2 != null) {
                    try {
                        zipFile2.close();
                        return false;
                    } catch (IOException e7) {
                        e7.printStackTrace();
                        return false;
                    }
                }
                return false;
            } catch (Throwable th) {
                th = th;
                zipFile = zipFile2;
                if (zipFile != null) {
                    try {
                        zipFile.close();
                    } catch (IOException e8) {
                        e8.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            zipFile = null;
        }
    }

    public static File getReleaseSoFilePath(Context context) {
        return new File(context.getFilesDir(), Plugin.SO_LIB_DIR_NAME);
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
            this.sb.append(str2 + ":::" + simpleName + Config.TRACE_TODAY_VISIT_SPLIT + Log.getStackTraceString(th));
            return false;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [346=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:42:0x009e */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:64:0x00d2 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:68:0x00d9 */
    /* JADX DEBUG: Multi-variable search result rejected for r2v4, resolved type: java.nio.channels.FileLock */
    /* JADX DEBUG: Multi-variable search result rejected for r3v2, resolved type: java.nio.channels.FileChannel */
    /* JADX DEBUG: Multi-variable search result rejected for r3v3, resolved type: java.nio.channels.FileChannel */
    /* JADX DEBUG: Multi-variable search result rejected for r3v4, resolved type: java.nio.channels.FileChannel */
    /* JADX DEBUG: Multi-variable search result rejected for r3v6, resolved type: java.nio.channels.FileChannel */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0076 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0093 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x008e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0071 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x004d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10, types: [java.nio.channels.FileChannel] */
    /* JADX WARN: Type inference failed for: r3v11, types: [java.nio.channels.FileChannel] */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean executeRelease(Context context, ZipFile zipFile, String str, String str2) {
        Throwable th;
        Exception e;
        FileLock fileLock;
        boolean releaseFileFromApk;
        FileLock fileLock2 = null;
        if (zipFile == null) {
            return false;
        }
        FileLock releaseSoFilePath = getReleaseSoFilePath(context);
        FileChannel exists = releaseSoFilePath.exists();
        if (exists == 0) {
            releaseSoFilePath.mkdirs();
        }
        File file = new File((File) releaseSoFilePath, str);
        try {
            try {
                File file2 = new File((File) releaseSoFilePath, str + ".lock");
                if (!file2.exists()) {
                    try {
                        file2.createNewFile();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                try {
                    exists = new RandomAccessFile(file2, "rw").getChannel();
                } catch (FileNotFoundException e3) {
                    e = e3;
                    exists = 0;
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                try {
                    fileLock2 = exists.lock();
                } catch (IOException e4) {
                    try {
                        e4.printStackTrace();
                    } catch (FileNotFoundException e5) {
                        e = e5;
                        e.printStackTrace();
                        fileLock = null;
                        exists = exists;
                        if (fileLock != null) {
                        }
                        releaseFileFromApk = true;
                        if (fileLock != null) {
                        }
                        if (exists != 0) {
                        }
                    }
                }
                fileLock = fileLock2;
                exists = exists;
                if (fileLock != null) {
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
                            if (exists != 0) {
                                try {
                                    exists.close();
                                    return releaseFileFromApk;
                                } catch (IOException e7) {
                                    e7.printStackTrace();
                                    return releaseFileFromApk;
                                }
                            }
                            return releaseFileFromApk;
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
                        if (exists == 0) {
                            try {
                                exists.close();
                                return true;
                            } catch (IOException e10) {
                                e10.printStackTrace();
                                return true;
                            }
                        }
                        return true;
                    }
                }
                releaseFileFromApk = true;
                if (fileLock != null) {
                }
                if (exists != 0) {
                }
            } catch (Exception e11) {
                fileLock = null;
                e = e11;
                e.printStackTrace();
                if (fileLock != null) {
                }
                if (exists == 0) {
                }
            } catch (Throwable th3) {
                releaseSoFilePath = 0;
                th = th3;
                if (releaseSoFilePath != 0) {
                    try {
                        releaseSoFilePath.release();
                    } catch (IOException e12) {
                        e12.printStackTrace();
                    }
                }
                if (exists != 0) {
                    try {
                        exists.close();
                    } catch (IOException e13) {
                        e13.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e14) {
            exists = 0;
            e = e14;
            fileLock = null;
        } catch (Throwable th4) {
            releaseSoFilePath = 0;
            exists = 0;
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [417=5, 419=4, 420=4, 421=4, 424=4, 426=4, 427=4, 428=4] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0097 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0092 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean releaseFileFromApk(ZipFile zipFile, File file, String str) {
        FileOutputStream fileOutputStream;
        InputStream inputStream;
        InputStream inputStream2 = null;
        File file2 = new File(file.getAbsoluteFile() + ".tmp");
        if (zipFile != null) {
            try {
                inputStream = zipFile.getInputStream(zipFile.getEntry(str));
                try {
                    fileOutputStream = new FileOutputStream(file2);
                } catch (Exception e) {
                    e = e;
                    fileOutputStream = null;
                    inputStream2 = inputStream;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = null;
                    inputStream2 = inputStream;
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
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                            return renameTo;
                        } catch (Exception e4) {
                            e4.printStackTrace();
                            return renameTo;
                        }
                    }
                    return renameTo;
                }
            } catch (Exception e5) {
                e = e5;
                inputStream2 = inputStream;
                try {
                    if (DEBUG) {
                        Log.e(TAG, "SoLoader releaseFileFromApk exception.", e);
                    }
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (Exception e6) {
                            e6.printStackTrace();
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e7) {
                            e7.printStackTrace();
                        }
                    }
                    return false;
                } catch (Throwable th3) {
                    th = th3;
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (Exception e8) {
                            e8.printStackTrace();
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e9) {
                            e9.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                inputStream2 = inputStream;
                if (inputStream2 != null) {
                }
                if (fileOutputStream != null) {
                }
                throw th;
            }
        } else {
            fileOutputStream = null;
            inputStream = null;
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
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
                absolutePath = new File(packageInfo.applicationInfo.dataDir, Plugin.SO_LIB_DIR_NAME).getAbsolutePath();
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

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0045, code lost:
        if (com.baidu.swan.games.utils.so.SoLoader.DEBUG == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0047, code lost:
        android.util.Log.d(com.baidu.swan.games.utils.so.SoLoader.TAG, "unpackLibDep soFile path is: " + r1.getAbsolutePath());
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0066, code lost:
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static File unpackLibraryAndDependencies(String str) {
        if (DEBUG) {
            Log.d(TAG, "unpackLibDep is called, shortName=" + str);
        }
        String fullName = SoUtils.getFullName(str);
        try {
            if (soSources.size() != 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= soSources.size()) {
                        break;
                    }
                    File file = new File(soSources.get(i2), fullName);
                    if (file != null) {
                        break;
                    }
                    i = i2 + 1;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void addSysSoLibraryDirectory() {
        String str = System.getenv("LD_LIBRARY_PATH");
        if (str == null) {
            str = "/vendor/lib:/system/lib";
        }
        String[] split = str.split(Config.TRACE_TODAY_VISIT_SPLIT);
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
        arrayList.add(new File(context.getFilesDir(), Plugin.SO_LIB_DIR_NAME));
        for (int i = 0; i < arrayList.size(); i++) {
            if (!soSources.contains(arrayList.get(i))) {
                soSources.add(arrayList.get(i));
            }
        }
    }
}
