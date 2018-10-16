package com.baidu.searchbox.ng.ai.apps.io;

import android.text.TextUtils;
import android.util.Log;
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
public class AiAppsFile {
    public static final boolean DEBUG = false;
    public static final String TAG = "AiAppFile";

    /* JADX WARN: Removed duplicated region for block: B:45:0x009b A[Catch: all -> 0x009f, IOException -> 0x00a2, TRY_LEAVE, TryCatch #2 {IOException -> 0x00a2, blocks: (B:43:0x0096, B:45:0x009b), top: B:59:0x0096, outer: #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0096 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized boolean writeFile(String str, String str2, boolean z) {
        FileChannel fileChannel;
        boolean z2;
        FileLock fileLock = null;
        synchronized (AiAppsFile.class) {
            System.currentTimeMillis();
            if (TextUtils.isEmpty(str)) {
            }
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
                        fileLock = fileChannel.lock();
                        if (TextUtils.isEmpty(str2)) {
                            str2 = "";
                        }
                        fileChannel.write(ByteBuffer.wrap(str2.getBytes()));
                        if (fileLock != null) {
                            try {
                                fileLock.release();
                            } catch (IOException e) {
                                Log.e(TAG, Log.getStackTraceString(e));
                                z2 = true;
                            }
                        }
                        if (fileChannel != null) {
                            fileChannel.close();
                        }
                        z2 = true;
                    } catch (IOException e2) {
                        e = e2;
                        Log.e(TAG, Log.getStackTraceString(e));
                        if (fileLock != null) {
                            try {
                                fileLock.release();
                            } catch (IOException e3) {
                                Log.e(TAG, Log.getStackTraceString(e3));
                                z2 = false;
                            }
                        }
                        if (fileChannel != null) {
                            fileChannel.close();
                        }
                        z2 = false;
                        System.currentTimeMillis();
                        return z2;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (fileLock != null) {
                        try {
                            fileLock.release();
                        } catch (IOException e4) {
                            Log.e(TAG, Log.getStackTraceString(e4));
                            throw th;
                        }
                    }
                    if (fileChannel != null) {
                        fileChannel.close();
                    }
                    throw th;
                }
            } catch (IOException e5) {
                e = e5;
                fileChannel = null;
            } catch (Throwable th2) {
                th = th2;
                fileChannel = null;
                if (fileLock != null) {
                }
                if (fileChannel != null) {
                }
                throw th;
            }
            System.currentTimeMillis();
        }
        return z2;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0094 A[Catch: all -> 0x007c, IOException -> 0x0098, TRY_LEAVE, TryCatch #0 {IOException -> 0x0098, blocks: (B:40:0x008f, B:42:0x0094), top: B:57:0x008f, outer: #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x008f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized String readFile(String str) {
        StringBuffer stringBuffer;
        FileLock fileLock;
        FileLock fileLock2;
        BufferedReader bufferedReader = null;
        synchronized (AiAppsFile.class) {
            System.currentTimeMillis();
            if (TextUtils.isEmpty(str)) {
            }
            stringBuffer = new StringBuffer();
            try {
                FileChannel channel = new RandomAccessFile(str, "rw").getChannel();
                fileLock = channel.lock(0L, Long.MAX_VALUE, true);
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(Channels.newReader(channel, Charset.defaultCharset().name()));
                    while (true) {
                        try {
                            String readLine = bufferedReader2.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuffer.append(readLine);
                        } catch (IOException e) {
                            e = e;
                            fileLock2 = fileLock;
                            bufferedReader = bufferedReader2;
                            try {
                                Log.e(TAG, Log.getStackTraceString(e));
                                if (fileLock2 != null) {
                                    try {
                                        fileLock2.release();
                                    } catch (IOException e2) {
                                        Log.e(TAG, Log.getStackTraceString(e2));
                                    }
                                }
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                                System.currentTimeMillis();
                                return stringBuffer.toString();
                            } catch (Throwable th) {
                                th = th;
                                fileLock = fileLock2;
                                if (fileLock != null) {
                                    try {
                                        fileLock.release();
                                    } catch (IOException e3) {
                                        Log.e(TAG, Log.getStackTraceString(e3));
                                        throw th;
                                    }
                                }
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedReader = bufferedReader2;
                            if (fileLock != null) {
                            }
                            if (bufferedReader != null) {
                            }
                            throw th;
                        }
                    }
                    if (fileLock != null) {
                        try {
                            fileLock.release();
                        } catch (IOException e4) {
                            Log.e(TAG, Log.getStackTraceString(e4));
                        }
                    }
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                } catch (IOException e5) {
                    e = e5;
                    fileLock2 = fileLock;
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (IOException e6) {
                e = e6;
                fileLock2 = null;
            } catch (Throwable th4) {
                th = th4;
                fileLock = null;
            }
            System.currentTimeMillis();
        }
        return stringBuffer.toString();
    }
}
