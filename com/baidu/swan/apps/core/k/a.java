package com.baidu.swan.apps.core.k;

import android.preference.PreferenceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.games.utils.so.SoLoader;
import com.baidu.webkit.internal.GlobalConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
/* loaded from: classes11.dex */
public class a {
    public static final String ceh = AppRuntime.getAppContext().getFilesDir().getAbsolutePath() + File.separator + "zeus" + File.separator + "libs";
    private static final String cei = AppRuntime.getAppContext().getFilesDir().getAbsolutePath() + File.separator + "libs";
    public static final String cej = AppRuntime.getAppContext().getFilesDir().getAbsolutePath() + File.separator + "swan_so_lite" + File.separator + "libs";

    public static void dO(boolean z) {
        if (z) {
            SoLoader.load(AppRuntime.getAppContext(), "v8.engine");
        } else if (abS()) {
            abR();
            d.k("zeusv8", cei, true);
            d.k("v8.engine", ceh, false);
        } else {
            d.k("zeusv8", cej, true);
            d.k("v8.engine", cej, true);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [143=5, 144=4, 145=4, 147=4, 148=4, 149=4, 152=4] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00e0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00fe A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void abR() {
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
        File file = new File(ceh + File.separator + GlobalConstants.LIB_ZEUS_V8);
        if (!file.exists() || file.length() <= 0) {
            return;
        }
        File file2 = new File(cei);
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
                                com.baidu.swan.e.d.closeSafely(null);
                                com.baidu.swan.e.d.closeSafely(null);
                                if (lock != null) {
                                    try {
                                        lock.release();
                                    } catch (IOException e2) {
                                        e2.printStackTrace();
                                    }
                                }
                                com.baidu.swan.e.d.closeSafely(fileChannel);
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
                                com.baidu.swan.e.d.closeSafely(fileInputStream3);
                                com.baidu.swan.e.d.closeSafely(fileOutputStream2);
                                if (lock != null) {
                                    try {
                                        lock.release();
                                    } catch (IOException e4) {
                                        e4.printStackTrace();
                                    }
                                }
                                com.baidu.swan.e.d.closeSafely(fileChannel);
                            } catch (Exception e5) {
                                fileLock = lock;
                                fileOutputStream = fileOutputStream2;
                                e = e5;
                                fileInputStream2 = fileInputStream;
                                fileChannel2 = fileChannel;
                                try {
                                    e.printStackTrace();
                                    com.baidu.swan.e.d.closeSafely(fileInputStream2);
                                    com.baidu.swan.e.d.closeSafely(fileOutputStream);
                                    if (fileLock != null) {
                                        try {
                                            fileLock.release();
                                        } catch (IOException e6) {
                                            e6.printStackTrace();
                                        }
                                    }
                                    com.baidu.swan.e.d.closeSafely(fileChannel2);
                                    return;
                                } catch (Throwable th2) {
                                    th = th2;
                                    FileChannel fileChannel3 = fileChannel2;
                                    fileInputStream = fileInputStream2;
                                    fileChannel = fileChannel3;
                                    com.baidu.swan.e.d.closeSafely(fileInputStream);
                                    com.baidu.swan.e.d.closeSafely(fileOutputStream);
                                    if (fileLock != null) {
                                        try {
                                            fileLock.release();
                                        } catch (IOException e7) {
                                            e7.printStackTrace();
                                        }
                                    }
                                    com.baidu.swan.e.d.closeSafely(fileChannel);
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                fileLock = lock;
                                fileOutputStream = fileOutputStream2;
                                th = th3;
                                com.baidu.swan.e.d.closeSafely(fileInputStream);
                                com.baidu.swan.e.d.closeSafely(fileOutputStream);
                                if (fileLock != null) {
                                }
                                com.baidu.swan.e.d.closeSafely(fileChannel);
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
                com.baidu.swan.e.d.closeSafely(fileInputStream3);
                com.baidu.swan.e.d.closeSafely(fileOutputStream2);
                if (lock != null) {
                }
                com.baidu.swan.e.d.closeSafely(fileChannel);
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

    public static boolean abS() {
        return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getBoolean("swan_full_install", true);
    }
}
