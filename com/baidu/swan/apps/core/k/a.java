package com.baidu.swan.apps.core.k;

import android.preference.PreferenceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.games.utils.so.SoLoader;
import com.baidu.swan.games.utils.so.f;
import com.baidu.webkit.internal.GlobalConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
/* loaded from: classes10.dex */
public class a {
    public static final String cOT = AppRuntime.getAppContext().getFilesDir().getAbsolutePath() + File.separator + "zeus" + File.separator + "libs";
    private static final String cOU = AppRuntime.getAppContext().getFilesDir().getAbsolutePath() + File.separator + "libs";
    public static final String cOV = AppRuntime.getAppContext().getFilesDir().getAbsolutePath() + File.separator + "swan_so_lite" + File.separator + "libs";

    public static f eT(boolean z) {
        boolean z2 = true;
        if (z) {
            return f.hE(SoLoader.load(AppRuntime.getAppContext(), "v8.engine"));
        }
        if (arl()) {
            ark();
            boolean l = d.l("zeusv8", cOU, true);
            if (!d.l("arcore_sdk_c", cOT, false) || !d.l("arcore_sdk_jni", cOT, false) || !d.l("c++_shared", cOT, false) || !d.l("v8.engine", cOT, false)) {
                z2 = false;
            }
            return f.u(l, z2);
        }
        d.l("zeusv8", cOV, true);
        return f.hE(d.l("v8.engine", cOV, true));
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [152=5, 153=4, 154=4, 156=4, 157=4, 158=4, 161=4] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00e0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00fe A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void ark() {
        FileChannel fileChannel;
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        FileChannel fileChannel2;
        FileInputStream fileInputStream2;
        FileOutputStream fileOutputStream2;
        FileLock fileLock = null;
        FileInputStream fileInputStream3 = null;
        fileLock = null;
        fileLock = null;
        fileLock = null;
        File file = new File(cOT + File.separator + GlobalConstants.LIB_ZEUS_V8);
        if (!file.exists() || file.length() <= 0) {
            return;
        }
        File file2 = new File(cOU);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        File file3 = new File(file2, GlobalConstants.LIB_ZEUS_V8);
        if (file.length() == file3.length()) {
            return;
        }
        try {
            File file4 = new File(file2, "libzeusv8.so.lock");
            if (!file4.exists()) {
                try {
                    file4.createNewFile();
                } catch (IOException e) {
                }
            }
            fileChannel = new RandomAccessFile(file4, "rw").getChannel();
            try {
                FileLock lock = fileChannel.lock();
                if (lock != null) {
                    try {
                        if (lock.isValid()) {
                            if (file.length() == file3.length()) {
                                com.baidu.swan.c.d.closeSafely(null);
                                com.baidu.swan.c.d.closeSafely(null);
                                if (lock != null) {
                                    try {
                                        lock.release();
                                    } catch (IOException e2) {
                                        e2.printStackTrace();
                                    }
                                }
                                com.baidu.swan.c.d.closeSafely(fileChannel);
                                return;
                            }
                            fileInputStream = new FileInputStream(file);
                            try {
                                fileOutputStream2 = new FileOutputStream(file3);
                            } catch (Exception e3) {
                                e = e3;
                                fileOutputStream = null;
                                fileLock = lock;
                                fileInputStream2 = fileInputStream;
                                fileChannel2 = fileChannel;
                            } catch (Throwable th) {
                                th = th;
                                fileOutputStream = null;
                                fileLock = lock;
                            }
                            try {
                                byte[] bArr = new byte[8192];
                                while (true) {
                                    int read = fileInputStream.read(bArr);
                                    if (read <= 0) {
                                        break;
                                    }
                                    fileOutputStream2.write(bArr, 0, read);
                                }
                                fileOutputStream2.flush();
                                fileInputStream3 = fileInputStream;
                                com.baidu.swan.c.d.closeSafely(fileInputStream3);
                                com.baidu.swan.c.d.closeSafely(fileOutputStream2);
                                if (lock != null) {
                                    try {
                                        lock.release();
                                    } catch (IOException e4) {
                                        e4.printStackTrace();
                                    }
                                }
                                com.baidu.swan.c.d.closeSafely(fileChannel);
                            } catch (Exception e5) {
                                fileLock = lock;
                                fileOutputStream = fileOutputStream2;
                                e = e5;
                                fileInputStream2 = fileInputStream;
                                fileChannel2 = fileChannel;
                                try {
                                    e.printStackTrace();
                                    com.baidu.swan.c.d.closeSafely(fileInputStream2);
                                    com.baidu.swan.c.d.closeSafely(fileOutputStream);
                                    if (fileLock != null) {
                                        try {
                                            fileLock.release();
                                        } catch (IOException e6) {
                                            e6.printStackTrace();
                                        }
                                    }
                                    com.baidu.swan.c.d.closeSafely(fileChannel2);
                                    return;
                                } catch (Throwable th2) {
                                    th = th2;
                                    FileChannel fileChannel3 = fileChannel2;
                                    fileInputStream = fileInputStream2;
                                    fileChannel = fileChannel3;
                                    com.baidu.swan.c.d.closeSafely(fileInputStream);
                                    com.baidu.swan.c.d.closeSafely(fileOutputStream);
                                    if (fileLock != null) {
                                        try {
                                            fileLock.release();
                                        } catch (IOException e7) {
                                            e7.printStackTrace();
                                        }
                                    }
                                    com.baidu.swan.c.d.closeSafely(fileChannel);
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                fileLock = lock;
                                fileOutputStream = fileOutputStream2;
                                th = th3;
                                com.baidu.swan.c.d.closeSafely(fileInputStream);
                                com.baidu.swan.c.d.closeSafely(fileOutputStream);
                                if (fileLock != null) {
                                }
                                com.baidu.swan.c.d.closeSafely(fileChannel);
                                throw th;
                            }
                        }
                    } catch (Exception e8) {
                        e = e8;
                        fileChannel2 = fileChannel;
                        fileInputStream2 = null;
                        fileLock = lock;
                        fileOutputStream = null;
                    } catch (Throwable th4) {
                        th = th4;
                        fileInputStream = null;
                        fileLock = lock;
                        fileOutputStream = null;
                    }
                }
                fileOutputStream2 = null;
                com.baidu.swan.c.d.closeSafely(fileInputStream3);
                com.baidu.swan.c.d.closeSafely(fileOutputStream2);
                if (lock != null) {
                }
                com.baidu.swan.c.d.closeSafely(fileChannel);
            } catch (Exception e9) {
                e = e9;
                fileChannel2 = fileChannel;
                fileOutputStream = null;
                fileInputStream2 = null;
            } catch (Throwable th5) {
                th = th5;
                fileOutputStream = null;
                fileInputStream = null;
            }
        } catch (Exception e10) {
            e = e10;
            fileChannel2 = null;
            fileOutputStream = null;
            fileInputStream2 = null;
        } catch (Throwable th6) {
            th = th6;
            fileChannel = null;
            fileOutputStream = null;
            fileInputStream = null;
        }
    }

    public static boolean arl() {
        return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getBoolean("swan_full_install", true);
    }
}
