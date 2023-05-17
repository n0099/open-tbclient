package com.baidu.cyberplayer.sdk.statistics;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.CyberVersion;
import com.baidu.cyberplayer.sdk.o;
import com.baidu.mobstat.Config;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes3.dex */
public class d {
    public String a = null;
    public String b = null;
    public String c;

    public d() {
        this.c = null;
        this.c = "video_session";
        a(CyberPlayerManager.getApplicationContext());
    }

    public d(String str) {
        this.c = null;
        this.c = str;
        a(CyberPlayerManager.getApplicationContext());
    }

    public static void a(String str, String str2) {
        File file = new File(str);
        if (file.exists() && file.isFile()) {
            file.renameTo(new File(str2));
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:32:0x0062 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:34:0x0064 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:92:0x0019 */
    /* JADX DEBUG: Multi-variable search result rejected for r3v2, resolved type: java.nio.channels.FileLock */
    /* JADX DEBUG: Multi-variable search result rejected for r3v3, resolved type: java.nio.channels.FileLock */
    /* JADX DEBUG: Multi-variable search result rejected for r3v5, resolved type: java.nio.channels.FileLock */
    /* JADX DEBUG: Multi-variable search result rejected for r3v7, resolved type: java.nio.channels.FileLock */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.io.RandomAccessFile, java.nio.channels.FileLock] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.nio.channels.FileLock] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x0098 -> B:83:0x009b). Please submit an issue!!! */
    public static void a(String str, byte[] bArr, String str2) {
        RandomAccessFile randomAccessFile;
        if (bArr == null || TextUtils.isEmpty(str)) {
            return;
        }
        FileLock fileLock = 0;
        fileLock = 0;
        fileLock = 0;
        fileLock = 0;
        try {
        } catch (Throwable th) {
            th = th;
        }
        try {
            try {
                randomAccessFile = new RandomAccessFile(str, "rw");
            } catch (Exception e) {
                CyberLog.e("DpStatFileWriter", "file close fail", e);
            }
        } catch (Error e2) {
            e = e2;
            randomAccessFile = null;
        } catch (Exception e3) {
            e = e3;
            randomAccessFile = null;
        } catch (Throwable th2) {
            th = th2;
            if (0 != 0) {
                try {
                    fileLock.release();
                } catch (Exception e4) {
                    CyberLog.e("DpStatFileWriter", "file lock release fail", e4);
                }
            }
            if (0 != 0) {
                try {
                    fileLock.close();
                } catch (Exception e5) {
                    CyberLog.e("DpStatFileWriter", "file close fail", e5);
                }
            }
            throw th;
        }
        try {
        } catch (Error e6) {
            e = e6;
            CyberLog.e("DpStatFileWriter", "FileWriter invoke write error:", e);
            if (fileLock != 0) {
                try {
                    fileLock.release();
                } catch (Exception e7) {
                    CyberLog.e("DpStatFileWriter", "file lock release fail", e7);
                }
            }
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            return;
        } catch (Exception e8) {
            e = e8;
            CyberLog.e("DpStatFileWriter", "FileWriter invoke write exception:", e);
            if (fileLock != 0) {
                try {
                    fileLock.release();
                } catch (Exception e9) {
                    CyberLog.e("DpStatFileWriter", "file lock release fail", e9);
                }
            }
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            return;
        }
        if (randomAccessFile.length() > Config.FULL_TRACE_LOG_LIMIT) {
            try {
                randomAccessFile.close();
                return;
            } catch (Exception e10) {
                CyberLog.e("DpStatFileWriter", "file close fail", e10);
                return;
            }
        }
        fileLock = randomAccessFile.getChannel().tryLock();
        if (fileLock != 0 && fileLock.isValid()) {
            randomAccessFile.seek(randomAccessFile.length());
            randomAccessFile.write(bArr);
            if (!TextUtils.isEmpty(str2)) {
                randomAccessFile.write(str2.getBytes());
            }
        }
        if (fileLock != 0) {
            try {
                fileLock.release();
            } catch (Exception e11) {
                CyberLog.e("DpStatFileWriter", "file lock release fail", e11);
            }
        }
        randomAccessFile.close();
    }

    public static boolean a(String str) {
        File file = new File(str);
        return file.exists() && file.isFile() && file.delete();
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        return file.exists() && file.isFile();
    }

    public void a() {
        if (TextUtils.isEmpty(this.a) || TextUtils.isEmpty(this.b)) {
            return;
        }
        ReentrantLock reentrantLock = new ReentrantLock(true);
        reentrantLock.lock();
        try {
            String str = this.a;
            if (b(str)) {
                String str2 = this.b;
                a(str2);
                if (b(str, str2)) {
                    a(str);
                } else {
                    a(str);
                    a(str2, str);
                }
                a(str2);
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public void a(Context context) {
        String b;
        if (context == null || (b = o.b(context)) == null) {
            return;
        }
        new File(b).mkdirs();
        String coreVersionInternal = CyberVersion.getCoreVersionInternal();
        this.a = b + File.separator + this.c + "_" + coreVersionInternal + ".bak";
        this.b = b + File.separator + this.c + "_log_" + coreVersionInternal + ".tmp";
    }

    public void a(byte[] bArr) {
        if (bArr == null || TextUtils.isEmpty(this.a)) {
            return;
        }
        ReentrantLock reentrantLock = new ReentrantLock(true);
        reentrantLock.lock();
        try {
            try {
                a(this.a, bArr, "\r\n");
            } catch (AssertionError unused) {
                CyberLog.e("DpStatFileWriter", "write data to file fail");
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public boolean b(String str, String str2) {
        boolean z = false;
        boolean z2 = true;
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String a = DpSessionDatasUploader.getInstance().a("sailor_monitor", this.c.equals("live_show_session") ? 24 : 1);
            if (TextUtils.isEmpty(a)) {
                z = true;
            } else {
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        if (!DpSessionDatasUploader.getInstance().a(Base64.decode(readLine, 2), a, false)) {
                            try {
                                a(str2, readLine.getBytes(), "\r\n");
                                z2 = false;
                            } catch (Exception e) {
                                e = e;
                                e.printStackTrace();
                                CyberLog.e("DpStatFileWriter", "readAndUploadLogFile failed");
                                return z;
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        z = z2;
                        e.printStackTrace();
                        CyberLog.e("DpStatFileWriter", "readAndUploadLogFile failed");
                        return z;
                    }
                }
                z = z2;
            }
            bufferedReader.close();
            inputStreamReader.close();
            fileInputStream.close();
        } catch (Exception e3) {
            e = e3;
            z = true;
        }
        return z;
    }
}
