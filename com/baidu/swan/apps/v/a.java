package com.baidu.swan.apps.v;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.b;
import com.baidu.swan.d.c;
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
/* loaded from: classes11.dex */
public class a {
    public static final boolean DEBUG = b.DEBUG;

    /* JADX WARN: Removed duplicated region for block: B:32:0x008f A[Catch: all -> 0x00b3, TRY_LEAVE, TryCatch #2 {, blocks: (B:4:0x0004, B:6:0x000f, B:8:0x0013, B:28:0x0080, B:29:0x0083, B:30:0x0087, B:32:0x008f, B:38:0x00b7, B:44:0x00d2, B:45:0x00d5, B:47:0x00db, B:52:0x00ea, B:53:0x00ed, B:54:0x00f0, B:56:0x00f2), top: B:72:0x0004, inners: #0, #3, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00ea A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @SuppressLint({"SwanDebugLog"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized boolean j(String str, String str2, boolean z) {
        boolean z2;
        FileChannel fileChannel;
        boolean z3;
        IOException e;
        FileLock fileLock;
        FileLock lock;
        FileLock fileLock2 = null;
        fileLock2 = null;
        FileChannel fileChannel2 = null;
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
                        try {
                            lock = fileChannel.lock();
                            try {
                                if (TextUtils.isEmpty(str2)) {
                                    str2 = "";
                                }
                                fileChannel.write(ByteBuffer.wrap(str2.getBytes()));
                            } catch (IOException e2) {
                                fileLock = lock;
                                fileChannel2 = fileChannel;
                                z3 = false;
                                e = e2;
                            }
                        } catch (IOException e3) {
                            fileLock = null;
                            fileChannel2 = fileChannel;
                            z3 = false;
                            e = e3;
                        }
                        try {
                            if (DEBUG) {
                                Log.d("SwanAppFile", "Write file：" + str2);
                            }
                            if (lock != null) {
                                try {
                                    lock.release();
                                } catch (IOException e4) {
                                    Log.e("SwanAppFile", Log.getStackTraceString(e4));
                                }
                            }
                            c.closeSafely(fileChannel);
                            z2 = true;
                        } catch (IOException e5) {
                            e = e5;
                            fileChannel2 = fileChannel;
                            z3 = true;
                            fileLock = lock;
                            try {
                                Log.e("SwanAppFile", Log.getStackTraceString(e));
                                if (fileLock != null) {
                                    try {
                                        fileLock.release();
                                    } catch (IOException e6) {
                                        Log.e("SwanAppFile", Log.getStackTraceString(e6));
                                    }
                                }
                                c.closeSafely(fileChannel2);
                                z2 = z3;
                                long currentTimeMillis2 = System.currentTimeMillis();
                                if (DEBUG) {
                                }
                                return z2;
                            } catch (Throwable th) {
                                th = th;
                                fileChannel = fileChannel2;
                                fileLock2 = fileLock;
                                if (fileLock2 != null) {
                                }
                                c.closeSafely(fileChannel);
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileLock2 != null) {
                            try {
                                fileLock2.release();
                            } catch (IOException e7) {
                                Log.e("SwanAppFile", Log.getStackTraceString(e7));
                            }
                        }
                        c.closeSafely(fileChannel);
                        throw th;
                    }
                } catch (IOException e8) {
                    z3 = false;
                    e = e8;
                    fileLock = null;
                } catch (Throwable th3) {
                    th = th3;
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

    /* JADX WARN: Removed duplicated region for block: B:26:0x0072 A[Catch: all -> 0x00d0, TryCatch #1 {, blocks: (B:4:0x0004, B:6:0x000e, B:8:0x0012, B:11:0x001d, B:33:0x00bd, B:34:0x00c0, B:24:0x006a, B:26:0x0072, B:27:0x0094, B:37:0x00c5, B:22:0x0064, B:23:0x0067, B:43:0x00d4, B:48:0x00e5, B:49:0x00e8, B:50:0x00eb, B:52:0x00ed), top: B:64:0x0004, inners: #3, #4, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00e5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @SuppressLint({"SwanDebugLog"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized String ju(String str) {
        FileLock fileLock;
        BufferedReader bufferedReader;
        Throwable th;
        BufferedReader bufferedReader2;
        IOException e;
        FileLock fileLock2;
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
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                stringBuffer.append(readLine);
                            } catch (IOException e2) {
                                e = e2;
                                fileLock2 = fileLock;
                                bufferedReader2 = bufferedReader;
                                try {
                                    Log.e("SwanAppFile", Log.getStackTraceString(e));
                                    if (fileLock2 != null) {
                                        try {
                                            fileLock2.release();
                                        } catch (IOException e3) {
                                            Log.e("SwanAppFile", Log.getStackTraceString(e3));
                                        }
                                    }
                                    c.closeSafely(bufferedReader2);
                                    long currentTimeMillis2 = System.currentTimeMillis();
                                    if (DEBUG) {
                                    }
                                    str2 = stringBuffer.toString();
                                    return str2;
                                } catch (Throwable th2) {
                                    th = th2;
                                    bufferedReader = bufferedReader2;
                                    fileLock = fileLock2;
                                    if (fileLock != null) {
                                        try {
                                            fileLock.release();
                                        } catch (IOException e4) {
                                            Log.e("SwanAppFile", Log.getStackTraceString(e4));
                                            throw th;
                                        }
                                    }
                                    c.closeSafely(bufferedReader);
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                if (fileLock != null) {
                                }
                                c.closeSafely(bufferedReader);
                                throw th;
                            }
                        }
                        if (DEBUG) {
                            Log.d("SwanAppFile", "Read file: " + stringBuffer.toString());
                        }
                        if (fileLock != null) {
                            try {
                                fileLock.release();
                            } catch (IOException e5) {
                                Log.e("SwanAppFile", Log.getStackTraceString(e5));
                            }
                        }
                        c.closeSafely(bufferedReader);
                    } catch (IOException e6) {
                        fileLock2 = fileLock;
                        bufferedReader2 = null;
                        e = e6;
                    } catch (Throwable th4) {
                        bufferedReader = null;
                        th = th4;
                    }
                } catch (IOException e7) {
                    bufferedReader2 = null;
                    e = e7;
                    fileLock2 = null;
                } catch (Throwable th5) {
                    fileLock = null;
                    bufferedReader = null;
                    th = th5;
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
