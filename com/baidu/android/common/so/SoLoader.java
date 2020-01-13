package com.baidu.android.common.so;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
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
/* loaded from: classes6.dex */
public final class SoLoader {
    private static final boolean DEBUG = false;
    private static final String TAG = "SoLoader";
    private static final Set<String> sLoadedLibraries = Collections.synchronizedSet(new HashSet());
    private static final List<File> soSources = new ArrayList();
    private StringBuilder sb = new StringBuilder();

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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [256=6, 257=6, 258=6, 259=5, 254=7] */
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
            this.sb.append(str2 + ":::" + simpleName + ":" + Log.getStackTraceString(th));
            return false;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [344=4] */
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
            return 0L;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [417=4, 418=4, 419=4, 422=4, 424=4, 425=4, 426=4, 415=5] */
    private boolean releaseFileFromApk(ZipFile zipFile, File file, String str) {
        InputStream inputStream;
        Throwable th;
        FileOutputStream fileOutputStream;
        InputStream inputStream2;
        FileOutputStream fileOutputStream2 = null;
        File file2 = new File(file.getAbsoluteFile() + ".tmp");
        if (zipFile != null) {
            try {
                inputStream = zipFile.getInputStream(zipFile.getEntry(str));
                try {
                    fileOutputStream = new FileOutputStream(file2);
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
                        fileOutputStream2 = fileOutputStream;
                        inputStream2 = inputStream;
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (Exception e4) {
                                e4.printStackTrace();
                            }
                        }
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (Exception e5) {
                                e5.printStackTrace();
                            }
                        }
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
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
                    inputStream2 = inputStream;
                } catch (Throwable th3) {
                    fileOutputStream = null;
                    th = th3;
                }
            } catch (Exception e9) {
                inputStream2 = null;
            } catch (Throwable th4) {
                inputStream = null;
                th = th4;
                fileOutputStream = null;
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
        addSysSoLibraryDirectory();
        addLocalSoLibraryDirectory(context);
    }

    public static File unpackLibraryAndDependencies(String str) {
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
                        return file;
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
