package com.baidu.swan.apps.so;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import com.baidu.android.util.soloader.SoUtils;
import com.baidu.tieba.af3;
import com.baidu.tieba.bf3;
import com.baidu.tieba.kp4;
import com.baidu.tieba.qp1;
import com.baidu.tieba.we3;
import com.baidu.tieba.xe3;
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
/* loaded from: classes4.dex */
public final class SoLoader {
    public static final String TAG = "SoLoader";
    public StringBuilder sb = new StringBuilder();
    public static final boolean DEBUG = qp1.a;
    public static final Set<String> sLoadedLibraries = Collections.synchronizedSet(new HashSet());
    public static final List<File> soSources = new ArrayList();

    private void addSysSoLibraryDirectory() {
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

    public static String getV8SoDependentFilePath() {
        if (!sLoadedLibraries.contains(af3.c())) {
            return null;
        }
        String d = af3.d();
        if (DEBUG) {
            Log.i("SoLoader", "getV8SoDependentFilePath:" + d);
        }
        return d;
    }

    public String getErrorLog() {
        return this.sb.toString();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: java.util.List<java.io.File> */
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

    public static synchronized File findSoFilesInLibrary(Context context, String str) {
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

    private String getNativeLibraryDir(Context context) {
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

    public static File getReleaseSoFilePath(Context context) {
        return new File(context.getFilesDir(), "lib");
    }

    private void initSoSource(Context context) {
        if (DEBUG) {
            Log.d("SoLoader", "initSoSource is called");
        }
        synchronized (SoLoader.class) {
            addSysSoLibraryDirectory();
            addLocalSoLibraryDirectory(context);
        }
    }

    public static boolean isSoLoadedSucc(String str) {
        return sLoadedLibraries.contains(str);
    }

    public static bf3 loadV8EngineSo(Context context) {
        String c = af3.c();
        if (sLoadedLibraries.contains(c)) {
            return bf3.e();
        }
        bf3 h = af3.h(context, new SoLoader());
        if (h.b()) {
            sLoadedLibraries.add(c);
        }
        return h;
    }

    public void appendErrorLog(String str) {
        if (DEBUG) {
            Log.e("SoLoader", String.valueOf(str));
        }
        this.sb.append(str);
        this.sb.append("\n");
    }

    public ZipFile getApkZipFile(Context context) {
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
            Log.e("SoLoader", "SoLoader getSoSize exception.", e);
            return 0L;
        }
    }

    public static boolean load(Context context, String str) {
        if (sLoadedLibraries.contains(str)) {
            return true;
        }
        boolean load = load(context, str, (xe3) null, true);
        if (load) {
            sLoadedLibraries.add(str);
        }
        return load;
    }

    public static void load(Context context, String str, boolean z, boolean z2) {
        boolean load;
        if (sLoadedLibraries.contains(str)) {
            return;
        }
        we3 a = we3.a();
        if (!z) {
            load = new SoLoader().loadInternalFromLocal(context, str, a, z2);
        } else {
            load = load(context, str, a, z2);
        }
        if (load) {
            sLoadedLibraries.add(str);
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    private boolean loadInternal(Context context, String str, xe3 xe3Var, boolean z) {
        if (TextUtils.isEmpty(str)) {
            if (!DEBUG) {
                return false;
            }
            throw new IllegalArgumentException("load so library argument error,soName is null.");
        } else if (loadLibrary(xe3Var, str, SoUtils.SOLOG.SO_LOAD_LIBRARY)) {
            return true;
        } else {
            return loadInternalFromLocal(context, str, xe3Var, z);
        }
    }

    public static boolean load(Context context, String str, xe3 xe3Var, boolean z) {
        if (xe3Var == null) {
            xe3Var = we3.a();
        }
        SoLoader soLoader = new SoLoader();
        if (soSources.size() == 0) {
            soLoader.initSoSource(context);
        }
        return soLoader.loadInternal(context, str, xe3Var, z);
    }

    private boolean load(xe3 xe3Var, String str, String str2, String str3) {
        try {
            xe3Var.load(str2);
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

    private boolean loadInternalFromLocal(Context context, String str, xe3 xe3Var, boolean z) {
        String fullName = SoUtils.getFullName(str);
        ZipFile apkZipFile = getApkZipFile(context);
        if (apkZipFile == null) {
            SoUtils.sendLog(this.sb.toString());
            return false;
        }
        try {
            String str2 = SoUtils.uris[0] + File.separator + fullName;
            File file = new File(getNativeLibraryDir(context), fullName);
            if (file.exists()) {
                if (file.length() == getSoSize(apkZipFile, str2) && load(xe3Var, fullName, file.getAbsolutePath(), SoUtils.SOLOG.SO_NATIVE_LIB_LOAD)) {
                    return true;
                }
            }
            File file2 = new File(getReleaseSoFilePath(context), fullName);
            if (file2.exists()) {
                if (file2.length() == getSoSize(apkZipFile, str2) && load(xe3Var, fullName, file2.getAbsolutePath(), SoUtils.SOLOG.SO_RELEASE_LIB_LOAD)) {
                    return true;
                }
            }
            if (!z) {
                SoUtils.sendLog(this.sb.toString());
                return false;
            }
            for (int i = 0; i < SoUtils.uris.length; i++) {
                if (executeRelease(apkZipFile, fullName, SoUtils.uris[i], new File(getReleaseSoFilePath(context), fullName)) && load(xe3Var, fullName, file2.getAbsolutePath(), SoUtils.SOLOG.SO_RELEASE_EXECUTE_LOAD)) {
                    return true;
                }
            }
            SoUtils.sendLog(this.sb.toString());
            return false;
        } finally {
            kp4.d(apkZipFile);
        }
    }

    private boolean loadLibrary(xe3 xe3Var, String str, String str2) {
        String simpleName = SoUtils.getSimpleName(str);
        try {
            xe3Var.loadLibrary(simpleName);
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

    private boolean releaseFileFromApk(ZipFile zipFile, File file, String str) {
        FileOutputStream fileOutputStream;
        File file2 = new File(file.getAbsoluteFile() + ".tmp");
        InputStream inputStream = null;
        if (zipFile != null) {
            try {
                InputStream inputStream2 = zipFile.getInputStream(zipFile.getEntry(str));
                try {
                    fileOutputStream = new FileOutputStream(file2);
                    try {
                        if (SoUtils.copyStream(inputStream2, fileOutputStream, 256) > 0) {
                            boolean renameTo = file2.renameTo(file);
                            kp4.d(inputStream2);
                            kp4.d(fileOutputStream);
                            return renameTo;
                        }
                        inputStream = inputStream2;
                    } catch (Exception e) {
                        e = e;
                        inputStream = inputStream2;
                        try {
                            if (DEBUG) {
                                Log.e("SoLoader", "SoLoader releaseFileFromApk exception.", e);
                            }
                            kp4.d(inputStream);
                            kp4.d(fileOutputStream);
                            return false;
                        } catch (Throwable th) {
                            th = th;
                            kp4.d(inputStream);
                            kp4.d(fileOutputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = inputStream2;
                        kp4.d(inputStream);
                        kp4.d(fileOutputStream);
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                    fileOutputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = null;
                }
            } catch (Exception e3) {
                e = e3;
                fileOutputStream = null;
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
            }
        } else {
            fileOutputStream = null;
        }
        kp4.d(inputStream);
        kp4.d(fileOutputStream);
        return false;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:40:0x0083 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:54:0x00a4 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:66:0x003d */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:70:0x007d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00a7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0098 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v15, types: [java.io.IOException] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean executeRelease(ZipFile zipFile, String str, String str2, File file) {
        FileChannel fileChannel;
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
                boolean exists = file2.exists();
                fileChannel = exists;
                if (!exists) {
                    try {
                        file2.createNewFile();
                        fileChannel = exists;
                    } catch (IOException e) {
                        e.printStackTrace();
                        fileChannel = e;
                    }
                }
                try {
                    try {
                        fileChannel = new RandomAccessFile(file2, "rw").getChannel();
                        try {
                            fileLock = fileChannel.lock();
                        } catch (IOException e2) {
                            try {
                                e2.printStackTrace();
                            } catch (FileNotFoundException e3) {
                                e = e3;
                                e.printStackTrace();
                                if (fileLock != null) {
                                    z = releaseFileFromApk(zipFile, file, str2 + File.separator + str);
                                }
                                if (fileLock != null) {
                                }
                                kp4.d(fileChannel);
                                return z;
                            }
                        }
                    } catch (FileNotFoundException e4) {
                        e = e4;
                        fileChannel = null;
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
                            kp4.d(fileChannel);
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
                            kp4.d(fileChannel);
                            return z;
                        }
                    }
                    kp4.d(fileChannel);
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
                kp4.d(parentFile);
                throw th;
            }
        } catch (Exception e9) {
            e = e9;
            fileChannel = null;
            this.sb.append(Log.getStackTraceString(e));
            e.printStackTrace();
            if (fileLock != null) {
            }
            kp4.d(fileChannel);
            return z;
        } catch (Throwable th2) {
            th = th2;
            parentFile = 0;
            if (0 != 0) {
            }
            kp4.d(parentFile);
            throw th;
        }
        kp4.d(fileChannel);
        return z;
    }
}
