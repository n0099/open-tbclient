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
/* loaded from: classes.dex */
public final class SoLoader {
    public static final boolean DEBUG = false;
    public static final String TAG = "SoLoader";
    public static final Set<String> sLoadedLibraries = Collections.synchronizedSet(new HashSet());
    public static final List<File> soSources = new ArrayList();
    public StringBuilder sb = new StringBuilder();

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

    /* JADX WARN: Removed duplicated region for block: B:37:0x0085 A[Catch: IOException -> 0x0089, TRY_ENTER, TRY_LEAVE, TryCatch #6 {IOException -> 0x0089, blocks: (B:37:0x0085, B:56:0x00ac), top: B:79:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00bd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x007b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean executeRelease(Context context, ZipFile zipFile, String str, String str2) {
        FileChannel fileChannel;
        FileChannel fileChannel2;
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
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                try {
                    fileChannel2 = new RandomAccessFile(file2, "rw").getChannel();
                } catch (FileNotFoundException e3) {
                    e = e3;
                    fileChannel2 = null;
                }
            } catch (IOException e4) {
                e4.printStackTrace();
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
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                }
            } catch (Exception e8) {
                fileChannel = fileChannel2;
                e = e8;
                try {
                    e.printStackTrace();
                    if (fileLock != null) {
                        try {
                            fileLock.release();
                        } catch (IOException e9) {
                            e9.printStackTrace();
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
            } catch (Throwable th2) {
                fileChannel = fileChannel2;
                th = th2;
                if (fileLock != null) {
                }
                if (fileChannel != null) {
                }
                throw th;
            }
        } catch (Exception e12) {
            e = e12;
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

    @SuppressLint({"NewApi"})
    private String getNativeLibraryDir(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            if (SoUtils.hasGingerbread()) {
                return packageInfo.applicationInfo.nativeLibraryDir;
            }
            return new File(packageInfo.applicationInfo.dataDir, "lib").getAbsolutePath();
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static File getReleaseSoFilePath(Context context) {
        return new File(context.getFilesDir(), "lib");
    }

    private long getSoSize(ZipFile zipFile, String str) {
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

    private void initSoSource(Context context) {
        addSysSoLibraryDirectory();
        addLocalSoLibraryDirectory(context);
    }

    public static boolean isSoLoadedSucc(String str) {
        return sLoadedLibraries.contains(str);
    }

    public static void load(Context context, String str) {
        if (sLoadedLibraries.contains(str)) {
            return;
        }
        load(context, str, (ICallingSoLoader) null);
    }

    private boolean loadInternal(Context context, String str, ICallingSoLoader iCallingSoLoader) {
        if (!TextUtils.isEmpty(str)) {
            if (loadLibrary(iCallingSoLoader, str, "SO_LOAD_LIBRARY")) {
                return true;
            }
            return loadInternalFromLocal(context, str, iCallingSoLoader);
        }
        throw new IllegalArgumentException("load so library argument error,soName is null.");
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    private boolean loadInternalFromLocal(Context context, String str, ICallingSoLoader iCallingSoLoader) {
        String fullName = SoUtils.getFullName(str);
        ZipFile zipFile = null;
        try {
            String str2 = SoUtils.uris[0] + File.separator + fullName;
            try {
                try {
                    zipFile = new ZipFile(new File(context.getApplicationInfo().sourceDir));
                } catch (IOException e2) {
                    this.sb.append(Log.getStackTraceString(e2));
                    e2.printStackTrace();
                }
            } catch (ZipException e3) {
                this.sb.append(Log.getStackTraceString(e3));
                e3.printStackTrace();
            }
            if (zipFile == null) {
                SoUtils.sendLog(this.sb.toString());
                return false;
            }
            File file = new File(getNativeLibraryDir(context), fullName);
            if (file.exists()) {
                if (file.length() == getSoSize(zipFile, str2) && load(iCallingSoLoader, fullName, file.getAbsolutePath(), "SO_NATIVE_LIB_LOAD")) {
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
            File file2 = new File(getReleaseSoFilePath(context), fullName);
            if (file2.exists()) {
                if (file2.length() == getSoSize(zipFile, str2) && load(iCallingSoLoader, fullName, file2.getAbsolutePath(), "SO_RELEASE_LIB_LOAD")) {
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    return true;
                }
            }
            for (int i = 0; i < SoUtils.uris.length; i++) {
                if (executeRelease(context, zipFile, fullName, SoUtils.uris[i]) && load(iCallingSoLoader, fullName, file2.getAbsolutePath(), "SO_RELEASE_EXECUTE_LOAD")) {
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                    return true;
                }
            }
            SoUtils.sendLog(this.sb.toString());
            if (zipFile != null) {
                try {
                    zipFile.close();
                } catch (IOException e7) {
                    e7.printStackTrace();
                }
            }
            return false;
        } finally {
            if (0 != 0) {
                try {
                    zipFile.close();
                } catch (IOException e8) {
                    e8.printStackTrace();
                }
            }
        }
    }

    private boolean loadLibrary(ICallingSoLoader iCallingSoLoader, String str, String str2) {
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

    private boolean releaseFileFromApk(ZipFile zipFile, File file, String str) {
        FileOutputStream fileOutputStream;
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

    public static File unpackLibraryAndDependencies(String str) {
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

    public static void load(Context context, String str, boolean z) {
        if (sLoadedLibraries.contains(str)) {
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
            StringBuilder sb = this.sb;
            sb.append(str3 + ":::" + str2 + ":" + Log.getStackTraceString(th));
            return false;
        }
    }
}
