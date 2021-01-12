package com.baidu.swan.apps.s;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.b;
import com.baidu.swan.c.d;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.charset.Charset;
/* loaded from: classes8.dex */
public class a {
    public static final boolean DEBUG = b.DEBUG;

    /* JADX WARN: Removed duplicated region for block: B:32:0x008f A[Catch: all -> 0x00b3, TRY_LEAVE, TryCatch #4 {, blocks: (B:4:0x0004, B:6:0x000f, B:8:0x0013, B:28:0x0080, B:29:0x0083, B:30:0x0087, B:32:0x008f, B:38:0x00b7, B:44:0x00d2, B:45:0x00d5, B:47:0x00db, B:52:0x00eb, B:53:0x00ee, B:54:0x00f1, B:56:0x00f3), top: B:75:0x0004, inners: #0, #5, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00eb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @SuppressLint({"SwanDebugLog"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized boolean p(String str, String str2, boolean z) {
        boolean z2;
        FileLock fileLock;
        FileChannel fileChannel;
        boolean z3;
        synchronized (a.class) {
            long currentTimeMillis = System.currentTimeMillis();
            z2 = false;
            if (TextUtils.isEmpty(str) && DEBUG) {
                Log.w("SwanAppFile", "path name is null");
            } else {
                try {
                    File file = new File(str);
                    File file2 = new File(file.getParent());
                    if (!file2.exists()) {
                        file2.mkdirs();
                    }
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    fileChannel = new FileOutputStream(file, z).getChannel();
                    try {
                        fileLock = fileChannel.lock();
                        try {
                            try {
                                if (TextUtils.isEmpty(str2)) {
                                    str2 = "";
                                }
                                fileChannel.write(ByteBuffer.wrap(str2.getBytes()));
                                try {
                                    if (DEBUG) {
                                        Log.d("SwanAppFile", "Write file：" + str2);
                                    }
                                    if (fileLock != null) {
                                        try {
                                            fileLock.release();
                                        } catch (IOException e) {
                                            Log.e("SwanAppFile", Log.getStackTraceString(e));
                                        }
                                    }
                                    d.closeSafely(fileChannel);
                                    z2 = true;
                                } catch (IOException e2) {
                                    e = e2;
                                    z3 = true;
                                    Log.e("SwanAppFile", Log.getStackTraceString(e));
                                    if (fileLock != null) {
                                        try {
                                            fileLock.release();
                                        } catch (IOException e3) {
                                            Log.e("SwanAppFile", Log.getStackTraceString(e3));
                                        }
                                    }
                                    d.closeSafely(fileChannel);
                                    z2 = z3;
                                    long currentTimeMillis2 = System.currentTimeMillis();
                                    if (DEBUG) {
                                    }
                                    return z2;
                                }
                            } catch (Throwable th) {
                                th = th;
                                if (fileLock != null) {
                                    try {
                                        fileLock.release();
                                    } catch (IOException e4) {
                                        Log.e("SwanAppFile", Log.getStackTraceString(e4));
                                    }
                                }
                                d.closeSafely(fileChannel);
                                throw th;
                            }
                        } catch (IOException e5) {
                            e = e5;
                            z3 = false;
                        }
                    } catch (IOException e6) {
                        e = e6;
                        fileLock = null;
                        z3 = false;
                    } catch (Throwable th2) {
                        th = th2;
                        fileLock = null;
                        if (fileLock != null) {
                        }
                        d.closeSafely(fileChannel);
                        throw th;
                    }
                } catch (IOException e7) {
                    e = e7;
                    fileLock = null;
                    fileChannel = null;
                    z3 = false;
                } catch (Throwable th3) {
                    th = th3;
                    fileLock = null;
                    fileChannel = null;
                }
                long currentTimeMillis22 = System.currentTimeMillis();
                if (DEBUG) {
                    Log.d("SwanAppFile", "Write file done: cost time =" + (currentTimeMillis22 - currentTimeMillis) + "ms");
                }
            }
        }
        return z2;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0071 A[Catch: all -> 0x00cf, TryCatch #9 {, blocks: (B:4:0x0004, B:6:0x000e, B:8:0x0012, B:11:0x001d, B:33:0x00bc, B:34:0x00bf, B:24:0x0069, B:26:0x0071, B:27:0x0093, B:37:0x00c4, B:22:0x0063, B:23:0x0066, B:43:0x00d3, B:48:0x00e3, B:49:0x00e6, B:50:0x00e9, B:52:0x00eb), top: B:71:0x0004, inners: #0, #2, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00e3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @SuppressLint({"SwanDebugLog"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized String od(String str) {
        FileLock fileLock;
        BufferedReader bufferedReader;
        String str2 = null;
        synchronized (a.class) {
            long currentTimeMillis = System.currentTimeMillis();
            if (TextUtils.isEmpty(str) && DEBUG) {
                Log.w("SwanAppFile", "path name is empty");
            } else {
                StringBuffer stringBuffer = new StringBuffer();
                try {
                    FileChannel channel = new RandomAccessFile(str, "rw").getChannel();
                    fileLock = channel.lock(0L, Long.MAX_VALUE, true);
                    try {
                        bufferedReader = new BufferedReader(Channels.newReader(channel, Charset.defaultCharset().name()));
                        while (true) {
                            try {
                                try {
                                    String readLine = bufferedReader.readLine();
                                    if (readLine == null) {
                                        break;
                                    }
                                    stringBuffer.append(readLine);
                                } catch (IOException e) {
                                    e = e;
                                    Log.e("SwanAppFile", Log.getStackTraceString(e));
                                    if (fileLock != null) {
                                        try {
                                            fileLock.release();
                                        } catch (IOException e2) {
                                            Log.e("SwanAppFile", Log.getStackTraceString(e2));
                                        }
                                    }
                                    d.closeSafely(bufferedReader);
                                    long currentTimeMillis2 = System.currentTimeMillis();
                                    if (DEBUG) {
                                    }
                                    str2 = stringBuffer.toString();
                                    return str2;
                                }
                            } catch (Throwable th) {
                                th = th;
                                if (fileLock != null) {
                                    try {
                                        fileLock.release();
                                    } catch (IOException e3) {
                                        Log.e("SwanAppFile", Log.getStackTraceString(e3));
                                        throw th;
                                    }
                                }
                                d.closeSafely(bufferedReader);
                                throw th;
                            }
                        }
                        if (DEBUG) {
                            Log.d("SwanAppFile", "Read file: " + stringBuffer.toString());
                        }
                        if (fileLock != null) {
                            try {
                                fileLock.release();
                            } catch (IOException e4) {
                                Log.e("SwanAppFile", Log.getStackTraceString(e4));
                            }
                        }
                        d.closeSafely(bufferedReader);
                    } catch (IOException e5) {
                        e = e5;
                        bufferedReader = null;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader = null;
                        if (fileLock != null) {
                        }
                        d.closeSafely(bufferedReader);
                        throw th;
                    }
                } catch (IOException e6) {
                    e = e6;
                    fileLock = null;
                    bufferedReader = null;
                } catch (Throwable th3) {
                    th = th3;
                    fileLock = null;
                    bufferedReader = null;
                }
                long currentTimeMillis22 = System.currentTimeMillis();
                if (DEBUG) {
                    Log.d("SwanAppFile", "Read file done: cost time = " + (currentTimeMillis22 - currentTimeMillis) + "ms");
                }
                str2 = stringBuffer.toString();
            }
        }
        return str2;
    }
}
