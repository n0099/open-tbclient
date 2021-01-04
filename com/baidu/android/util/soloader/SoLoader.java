package com.baidu.android.util.soloader;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.NoProGuard;
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
/* loaded from: classes15.dex */
public final class SoLoader implements NoProGuard {
    private static final String TAG = "SoLoader";
    private StringBuilder sb = new StringBuilder();
    private static final boolean DEBUG = false;
    private static final Set<String> sLoadedLibraries = Collections.synchronizedSet(new HashSet());
    private static final List<File> soSources = new ArrayList();

    private SoLoader() {
    }

    public static void load(Context context, String str) {
        if (!sLoadedLibraries.contains(str)) {
            load(context, str, (ICallingSoLoader) null);
        }
    }

    public static void load(Context context, String str, boolean z) {
        if (!sLoadedLibraries.contains(str)) {
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
    }

    public static void load(Context context, String str, ICallingSoLoader iCallingSoLoader) {
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

    private boolean load(ICallingSoLoader iCallingSoLoader, String str, String str2, String str3) {
        try {
            iCallingSoLoader.load(str2);
            return true;
        } catch (Throwable th) {
            if (DEBUG) {
                Log.e(TAG, "SoLoader load exception.", th);
            }
            this.sb.append(str3 + ":::" + str2 + ":" + Log.getStackTraceString(th));
            return false;
        }
    }

    private boolean loadInternal(Context context, String str, ICallingSoLoader iCallingSoLoader) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("load so library argument error,soName is null.");
        }
        if (loadLibrary(iCallingSoLoader, str, "SO_LOAD_LIBRARY")) {
            return true;
        }
        return loadInternalFromLocal(context, str, iCallingSoLoader);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [218=7, 220=6, 221=6, 222=6] */
    private boolean loadInternalFromLocal(Context context, String str, ICallingSoLoader iCallingSoLoader) {
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
                    if (file.length() == getSoSize(zipFile2, str2) && load(iCallingSoLoader, fullName, file.getAbsolutePath(), "SO_NATIVE_LIB_LOAD")) {
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
                    if (file2.length() == getSoSize(zipFile2, str2) && load(iCallingSoLoader, fullName, file2.getAbsolutePath(), "SO_RELEASE_LIB_LOAD")) {
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
                    if (executeRelease(context, zipFile2, fullName, SoUtils.uris[i]) && load(iCallingSoLoader, fullName, file2.getAbsolutePath(), "SO_RELEASE_EXECUTE_LOAD")) {
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
        return new File(context.getFilesDir(), "lib");
    }

    private boolean loadLibrary(ICallingSoLoader iCallingSoLoader, String str, String str2) {
        String simpleName = SoUtils.getSimpleName(str);
        try {
            iCallingSoLoader.loadLibrary(simpleName);
            return true;
        } catch (Throwable th) {
            if (DEBUG) {
                Log.e(TAG, "SoLoader load exception.", th);
            }
            this.sb.append(str2 + ":::" + simpleName + ":" + Log.getStackTraceString(th));
            return false;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [299=4] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0076 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x004d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0091 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x008c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00bd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00b8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0071 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean executeRelease(Context context, ZipFile zipFile, String str, String str2) {
        FileLock fileLock;
        FileChannel fileChannel;
        boolean releaseFileFromApk;
        FileLock fileLock2 = null;
        if (zipFile == null) {
            return false;
        }
        File releaseSoFilePath = getReleaseSoFilePath(context);
        if (!releaseSoFilePath.exists()) {
            releaseSoFilePath.mkdirs();
        }
        File file = new File(releaseSoFilePath, str);
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
                fileChannel = new RandomAccessFile(file2, "rw").getChannel();
            } catch (FileNotFoundException e2) {
                e = e2;
                fileChannel = null;
            }
            try {
                try {
                    fileLock2 = fileChannel.lock();
                } catch (IOException e3) {
                    try {
                        e3.printStackTrace();
                    } catch (FileNotFoundException e4) {
                        e = e4;
                        e.printStackTrace();
                        fileLock = null;
                        if (fileLock != null) {
                        }
                        releaseFileFromApk = true;
                        if (fileLock != null) {
                        }
                        if (fileChannel != null) {
                        }
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
                                    } catch (IOException e5) {
                                        e5.printStackTrace();
                                    }
                                }
                                if (fileChannel != null) {
                                    try {
                                        fileChannel.close();
                                        return releaseFileFromApk;
                                    } catch (IOException e6) {
                                        e6.printStackTrace();
                                        return releaseFileFromApk;
                                    }
                                }
                                return releaseFileFromApk;
                            }
                        } catch (Exception e7) {
                            e = e7;
                            e.printStackTrace();
                            if (fileLock != null) {
                                try {
                                    fileLock.release();
                                } catch (IOException e8) {
                                    e8.printStackTrace();
                                }
                            }
                            if (fileChannel == null) {
                                try {
                                    fileChannel.close();
                                    return true;
                                } catch (IOException e9) {
                                    e9.printStackTrace();
                                    return true;
                                }
                            }
                            return true;
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (fileLock != null) {
                            try {
                                fileLock.release();
                            } catch (IOException e10) {
                                e10.printStackTrace();
                            }
                        }
                        if (fileChannel != null) {
                            try {
                                fileChannel.close();
                            } catch (IOException e11) {
                                e11.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
                releaseFileFromApk = true;
                if (fileLock != null) {
                }
                if (fileChannel != null) {
                }
            } catch (Exception e12) {
                e = e12;
                fileLock = null;
                e.printStackTrace();
                if (fileLock != null) {
                }
                if (fileChannel == null) {
                }
            } catch (Throwable th2) {
                th = th2;
                fileLock = null;
                if (fileLock != null) {
                }
                if (fileChannel != null) {
                }
                throw th;
            }
        } catch (Exception e13) {
            e = e13;
            fileLock = null;
            fileChannel = null;
        } catch (Throwable th3) {
            th = th3;
            fileLock = null;
            fileChannel = null;
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [361=5, 363=4, 364=4, 365=4, 369=4, 371=4, 372=4, 373=4] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0094 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0099 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean releaseFileFromApk(ZipFile zipFile, File file, String str) {
        FileOutputStream fileOutputStream;
        InputStream inputStream;
        File file2 = new File(file.getAbsoluteFile() + ".tmp");
        if (zipFile != null) {
            try {
                inputStream = zipFile.getInputStream(zipFile.getEntry(str));
                try {
                    fileOutputStream = new FileOutputStream(file2);
                    try {
                        try {
                            if (SoUtils.copyStream(inputStream, fileOutputStream, 256) > 0) {
                                boolean renameTo = file2.renameTo(file);
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                        return renameTo;
                                    } catch (Exception e2) {
                                        e2.printStackTrace();
                                        return renameTo;
                                    }
                                }
                                return renameTo;
                            }
                        } catch (Exception e3) {
                            e = e3;
                            if (DEBUG) {
                                Log.e(TAG, "SoLoader releaseFileFromApk exception.", e);
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e4) {
                                    e4.printStackTrace();
                                }
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (Exception e5) {
                                    e5.printStackTrace();
                                }
                            }
                            return false;
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
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
                        throw th;
                    }
                } catch (Exception e8) {
                    e = e8;
                    fileOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = null;
                    if (inputStream != null) {
                    }
                    if (fileOutputStream != null) {
                    }
                    throw th;
                }
            } catch (Exception e9) {
                e = e9;
                fileOutputStream = null;
                inputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
                inputStream = null;
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
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return SoUtils.hasGingerbread() ? packageInfo.applicationInfo.nativeLibraryDir : new File(packageInfo.applicationInfo.dataDir, "lib").getAbsolutePath();
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
        if (com.baidu.android.util.soloader.SoLoader.DEBUG == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0047, code lost:
        android.util.Log.d(com.baidu.android.util.soloader.SoLoader.TAG, "unpackLibDep soFile path is: " + r1.getAbsolutePath());
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
}
