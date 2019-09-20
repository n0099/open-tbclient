package com.baidu.swan.apps.t;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.b;
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
/* loaded from: classes2.dex */
public class a {
    public static final boolean DEBUG = b.DEBUG;

    /* JADX WARN: Removed duplicated region for block: B:34:0x0091 A[Catch: all -> 0x00b5, TRY_LEAVE, TryCatch #5 {, blocks: (B:4:0x0004, B:6:0x000f, B:8:0x0013, B:28:0x0080, B:30:0x0085, B:32:0x0089, B:34:0x0091, B:40:0x00b9, B:46:0x00d5, B:48:0x00da, B:51:0x00e0, B:56:0x00f0, B:58:0x00f5, B:59:0x00f8, B:61:0x00fa), top: B:80:0x0004, inners: #0, #2, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00f5 A[Catch: all -> 0x00b5, IOException -> 0x00f9, TRY_LEAVE, TryCatch #0 {IOException -> 0x00f9, blocks: (B:56:0x00f0, B:58:0x00f5), top: B:73:0x00f0, outer: #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00f0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized boolean e(String str, String str2, boolean z) {
        boolean z2;
        FileChannel fileChannel;
        boolean z3;
        IOException e;
        FileLock fileLock;
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
                            FileLock lock = fileChannel.lock();
                            try {
                                if (TextUtils.isEmpty(str2)) {
                                    str2 = "";
                                }
                                fileChannel.write(ByteBuffer.wrap(str2.getBytes()));
                                try {
                                    if (DEBUG) {
                                        Log.d("SwanAppFile", "Write file：" + str2);
                                    }
                                    if (lock != null) {
                                        try {
                                            lock.release();
                                        } catch (IOException e2) {
                                            Log.e("SwanAppFile", Log.getStackTraceString(e2));
                                            z2 = true;
                                        }
                                    }
                                    if (fileChannel != null) {
                                        fileChannel.close();
                                    }
                                    z2 = true;
                                } catch (IOException e3) {
                                    e = e3;
                                    fileChannel2 = fileChannel;
                                    z3 = true;
                                    fileLock = lock;
                                    try {
                                        Log.e("SwanAppFile", Log.getStackTraceString(e));
                                        if (fileLock != null) {
                                            try {
                                                fileLock.release();
                                            } catch (IOException e4) {
                                                Log.e("SwanAppFile", Log.getStackTraceString(e4));
                                                z2 = z3;
                                            }
                                        }
                                        if (fileChannel2 != null) {
                                            fileChannel2.close();
                                        }
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
                                        if (fileChannel != null) {
                                        }
                                        throw th;
                                    }
                                }
                            } catch (IOException e5) {
                                fileLock = lock;
                                fileChannel2 = fileChannel;
                                z3 = false;
                                e = e5;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (fileLock2 != null) {
                                try {
                                    fileLock2.release();
                                } catch (IOException e6) {
                                    Log.e("SwanAppFile", Log.getStackTraceString(e6));
                                    throw th;
                                }
                            }
                            if (fileChannel != null) {
                                fileChannel.close();
                            }
                            throw th;
                        }
                    } catch (IOException e7) {
                        fileLock = null;
                        fileChannel2 = fileChannel;
                        z3 = false;
                        e = e7;
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

    /* JADX WARN: Removed duplicated region for block: B:27:0x0074 A[Catch: all -> 0x00d4, TryCatch #7 {, blocks: (B:4:0x0004, B:6:0x000e, B:8:0x0012, B:11:0x001d, B:34:0x00bf, B:25:0x006c, B:27:0x0074, B:28:0x0096, B:36:0x00c4, B:39:0x00c9, B:22:0x0064, B:24:0x0069, B:45:0x00d8, B:50:0x00e9, B:52:0x00ee, B:53:0x00f1, B:55:0x00f3), top: B:73:0x0004, inners: #0, #2, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00ee A[Catch: all -> 0x00d4, IOException -> 0x00f2, TRY_LEAVE, TryCatch #8 {IOException -> 0x00f2, blocks: (B:50:0x00e9, B:52:0x00ee), top: B:74:0x00e9, outer: #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00e9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized String eH(String str) {
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
                                    if (bufferedReader2 != null) {
                                        bufferedReader2.close();
                                    }
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
                                    if (bufferedReader != null) {
                                        bufferedReader.close();
                                    }
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                if (fileLock != null) {
                                }
                                if (bufferedReader != null) {
                                }
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
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
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
