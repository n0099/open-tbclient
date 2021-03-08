package com.baidu.swan.apps.core.k;

import android.preference.PreferenceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.games.utils.so.SoLoader;
import com.baidu.swan.games.utils.so.f;
import com.baidu.webkit.internal.GlobalConstants;
import com.yy.mediaframework.stat.VideoDataStatistic;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
/* loaded from: classes8.dex */
public class a {
    public static final String cXZ = AppRuntime.getAppContext().getFilesDir().getAbsolutePath() + File.separator + "zeus" + File.separator + "libs";
    private static final String cYa = AppRuntime.getAppContext().getFilesDir().getAbsolutePath() + File.separator + "libs";
    public static final String cYb = AppRuntime.getAppContext().getFilesDir().getAbsolutePath() + File.separator + "swan_so_lite" + File.separator + "libs";

    public static f fs(boolean z) {
        boolean z2 = true;
        if (z) {
            return f.im(SoLoader.load(AppRuntime.getAppContext(), "v8.engine"));
        }
        if (arJ()) {
            arI();
            boolean o = d.o("zeusv8", cYa, true);
            if (!d.o("arcore_sdk_c", cXZ, false) || !d.o("arcore_sdk_jni", cXZ, false) || !d.o("c++_shared", cXZ, false) || !d.o("v8.engine", cXZ, false)) {
                z2 = false;
            }
            return f.v(o, z2);
        }
        d.o("zeusv8", cYb, true);
        return f.im(d.o("v8.engine", cYb, true));
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [152=5, 153=4, 154=4, 156=4, 157=4, 158=4, 161=4] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00fa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00da A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void arI() {
        Throwable th;
        FileLock fileLock;
        FileChannel fileChannel;
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        Exception exc;
        FileOutputStream fileOutputStream2;
        File file = new File(cXZ + File.separator + GlobalConstants.LIB_ZEUS_V8);
        if (!file.exists() || file.length() <= 0) {
            return;
        }
        File file2 = new File(cYa);
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
            fileChannel = new RandomAccessFile(file4, VideoDataStatistic.AnchorHiidoCoreStatisticKey.CaptureRealResolutionWidth).getChannel();
            try {
                fileLock = fileChannel.lock();
                if (fileLock != null) {
                    try {
                        if (fileLock.isValid()) {
                            if (file.length() == file3.length()) {
                                com.baidu.swan.c.d.closeSafely(null);
                                com.baidu.swan.c.d.closeSafely(null);
                                if (fileLock != null) {
                                    try {
                                        fileLock.release();
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
                                exc = e3;
                                fileOutputStream = null;
                            } catch (Throwable th2) {
                                th = th2;
                                fileOutputStream = null;
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
                                com.baidu.swan.c.d.closeSafely(fileInputStream);
                                com.baidu.swan.c.d.closeSafely(fileOutputStream2);
                                if (fileLock != null) {
                                    try {
                                        fileLock.release();
                                    } catch (IOException e4) {
                                        e4.printStackTrace();
                                    }
                                }
                                com.baidu.swan.c.d.closeSafely(fileChannel);
                            } catch (Exception e5) {
                                exc = e5;
                                fileOutputStream = fileOutputStream2;
                                try {
                                    exc.printStackTrace();
                                    com.baidu.swan.c.d.closeSafely(fileInputStream);
                                    com.baidu.swan.c.d.closeSafely(fileOutputStream);
                                    if (fileLock != null) {
                                        try {
                                            fileLock.release();
                                        } catch (IOException e6) {
                                            e6.printStackTrace();
                                        }
                                    }
                                    com.baidu.swan.c.d.closeSafely(fileChannel);
                                    return;
                                } catch (Throwable th3) {
                                    th = th3;
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
                            } catch (Throwable th4) {
                                th = th4;
                                fileOutputStream = fileOutputStream2;
                                com.baidu.swan.c.d.closeSafely(fileInputStream);
                                com.baidu.swan.c.d.closeSafely(fileOutputStream);
                                if (fileLock != null) {
                                }
                                com.baidu.swan.c.d.closeSafely(fileChannel);
                                throw th;
                            }
                        }
                    } catch (Exception e8) {
                        exc = e8;
                        fileOutputStream = null;
                        fileInputStream = null;
                    } catch (Throwable th5) {
                        th = th5;
                        fileOutputStream = null;
                        fileInputStream = null;
                    }
                }
                fileOutputStream2 = null;
                fileInputStream = null;
                com.baidu.swan.c.d.closeSafely(fileInputStream);
                com.baidu.swan.c.d.closeSafely(fileOutputStream2);
                if (fileLock != null) {
                }
                com.baidu.swan.c.d.closeSafely(fileChannel);
            } catch (Exception e9) {
                exc = e9;
                fileLock = null;
                fileOutputStream = null;
                fileInputStream = null;
            } catch (Throwable th6) {
                th = th6;
                fileLock = null;
                fileOutputStream = null;
                fileInputStream = null;
            }
        } catch (Exception e10) {
            exc = e10;
            fileLock = null;
            fileChannel = null;
            fileOutputStream = null;
            fileInputStream = null;
        } catch (Throwable th7) {
            th = th7;
            fileLock = null;
            fileChannel = null;
            fileOutputStream = null;
            fileInputStream = null;
        }
    }

    public static boolean arJ() {
        return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getBoolean("swan_full_install", true);
    }
}
