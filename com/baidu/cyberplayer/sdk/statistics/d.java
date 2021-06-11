package com.baidu.cyberplayer.sdk.statistics;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.android.internal.http.multipart.Part;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.o;
import com.baidu.mobstat.Config;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f5006a = null;

    /* renamed from: b  reason: collision with root package name */
    public String f5007b = null;

    /* renamed from: c  reason: collision with root package name */
    public String f5008c;

    public d() {
        this.f5008c = null;
        this.f5008c = "video_session";
        a(CyberPlayerManager.getApplicationContext());
    }

    public d(String str) {
        this.f5008c = null;
        this.f5008c = str;
        a(CyberPlayerManager.getApplicationContext());
    }

    public static void a(String str, String str2) {
        File file = new File(str);
        if (file.exists() && file.isFile()) {
            file.renameTo(new File(str2));
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:32:0x0061 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:34:0x0063 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:91:0x0018 */
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
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x0097 -> B:83:0x009a). Please submit an issue!!! */
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
            } catch (Exception e2) {
                CyberLog.e("DpStatFileWriter", "file close fail", e2);
            }
            try {
            } catch (Error e3) {
                e = e3;
                CyberLog.e("DpStatFileWriter", "FileWriter invoke write error:", e);
                if (fileLock != 0) {
                    try {
                        fileLock.release();
                    } catch (Exception e4) {
                        CyberLog.e("DpStatFileWriter", "file lock release fail", e4);
                    }
                }
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                return;
            } catch (Exception e5) {
                e = e5;
                CyberLog.e("DpStatFileWriter", "FileWriter invoke write exception:", e);
                if (fileLock != 0) {
                    try {
                        fileLock.release();
                    } catch (Exception e6) {
                        CyberLog.e("DpStatFileWriter", "file lock release fail", e6);
                    }
                }
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                return;
            }
        } catch (Error e7) {
            e = e7;
            randomAccessFile = null;
        } catch (Exception e8) {
            e = e8;
            randomAccessFile = null;
        } catch (Throwable th2) {
            th = th2;
            if (0 != 0) {
                try {
                    fileLock.release();
                } catch (Exception e9) {
                    CyberLog.e("DpStatFileWriter", "file lock release fail", e9);
                }
            }
            if (0 != 0) {
                try {
                    fileLock.close();
                } catch (Exception e10) {
                    CyberLog.e("DpStatFileWriter", "file close fail", e10);
                }
            }
            throw th;
        }
        if (randomAccessFile.length() > Config.FULL_TRACE_LOG_LIMIT) {
            try {
                randomAccessFile.close();
                return;
            } catch (Exception e11) {
                CyberLog.e("DpStatFileWriter", "file close fail", e11);
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
            } catch (Exception e12) {
                CyberLog.e("DpStatFileWriter", "file lock release fail", e12);
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
        if (TextUtils.isEmpty(this.f5006a) || TextUtils.isEmpty(this.f5007b)) {
            return;
        }
        ReentrantLock reentrantLock = new ReentrantLock(true);
        reentrantLock.lock();
        try {
            String str = this.f5006a;
            if (b(str)) {
                String str2 = this.f5007b;
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
        String b2;
        if (context == null || (b2 = o.b(context)) == null) {
            return;
        }
        new File(b2).mkdirs();
        String coreVersion = CyberPlayerManager.getCoreVersion();
        this.f5006a = b2 + File.separator + this.f5008c + "_" + coreVersion + ".bak";
        this.f5007b = b2 + File.separator + this.f5008c + "_log_" + coreVersion + ".tmp";
    }

    public void a(byte[] bArr) {
        if (bArr == null || TextUtils.isEmpty(this.f5006a)) {
            return;
        }
        ReentrantLock reentrantLock = new ReentrantLock(true);
        reentrantLock.lock();
        try {
            try {
                a(this.f5006a, bArr, Part.CRLF);
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
            String a2 = DpSessionDatasUploader.getInstance().a("sailor_monitor", this.f5008c.equals("live_show_session") ? 24 : 1);
            if (TextUtils.isEmpty(a2)) {
                z = true;
            } else {
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        if (!DpSessionDatasUploader.getInstance().a(Base64.decode(readLine, 2), a2, false)) {
                            try {
                                a(str2, readLine.getBytes(), Part.CRLF);
                                z2 = false;
                            } catch (Exception e2) {
                                e = e2;
                                e.printStackTrace();
                                CyberLog.e("DpStatFileWriter", "readAndUploadLogFile failed");
                                return z;
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
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
        } catch (Exception e4) {
            e = e4;
            z = true;
        }
        return z;
    }
}
