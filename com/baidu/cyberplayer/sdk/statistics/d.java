package com.baidu.cyberplayer.sdk.statistics;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.android.internal.http.multipart.Part;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.n;
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
    public String f5236a = null;

    /* renamed from: b  reason: collision with root package name */
    public String f5237b = null;

    /* renamed from: c  reason: collision with root package name */
    public String f5238c;

    public d() {
        this.f5238c = null;
        this.f5238c = "video_session";
        a(CyberPlayerManager.getApplicationContext());
    }

    public d(String str) {
        this.f5238c = null;
        this.f5238c = str;
        a(CyberPlayerManager.getApplicationContext());
    }

    public static void a(String str, String str2) {
        File file = new File(str);
        if (file.exists() && file.isFile()) {
            file.renameTo(new File(str2));
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:32:0x0061 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:76:0x0018 */
    /* JADX DEBUG: Multi-variable search result rejected for r3v2, resolved type: java.nio.channels.FileLock */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0085 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x008f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.io.RandomAccessFile, java.nio.channels.FileLock] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.nio.channels.FileLock] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x007e -> B:63:0x0081). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(String str, byte[] bArr, String str2) {
        RandomAccessFile randomAccessFile;
        if (bArr == null || TextUtils.isEmpty(str)) {
            return;
        }
        FileLock fileLock = 0;
        fileLock = 0;
        try {
            try {
                try {
                    randomAccessFile = new RandomAccessFile(str, "rw");
                    try {
                    } catch (Exception e2) {
                        e = e2;
                        CyberLog.e("DpStatFileWriter", "FileWriter invoke write fail:", e);
                        if (fileLock != 0) {
                            try {
                                fileLock.release();
                            } catch (Exception e3) {
                                CyberLog.e("DpStatFileWriter", "file lock release fail", e3);
                            }
                        }
                        if (randomAccessFile != null) {
                            randomAccessFile.close();
                        }
                        return;
                    }
                } catch (Throwable th) {
                    th = th;
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
            } catch (Exception e6) {
                e = e6;
                randomAccessFile = null;
            } catch (Throwable th2) {
                th = th2;
                if (0 != 0) {
                }
                if (0 != 0) {
                }
                throw th;
            }
        } catch (Exception e7) {
            CyberLog.e("DpStatFileWriter", "file close fail", e7);
        }
        if (randomAccessFile.length() > Config.FULL_TRACE_LOG_LIMIT) {
            try {
                randomAccessFile.close();
                return;
            } catch (Exception e8) {
                CyberLog.e("DpStatFileWriter", "file close fail", e8);
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
            } catch (Exception e9) {
                CyberLog.e("DpStatFileWriter", "file lock release fail", e9);
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
        if (TextUtils.isEmpty(this.f5236a) || TextUtils.isEmpty(this.f5237b)) {
            return;
        }
        ReentrantLock reentrantLock = new ReentrantLock(true);
        reentrantLock.lock();
        try {
            String str = this.f5236a;
            if (b(str)) {
                String str2 = this.f5237b;
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
        if (context == null || (b2 = n.b(context)) == null) {
            return;
        }
        new File(b2).mkdirs();
        String coreVersion = CyberPlayerManager.getCoreVersion();
        this.f5236a = b2 + File.separator + this.f5238c + "_" + coreVersion + ".bak";
        this.f5237b = b2 + File.separator + this.f5238c + "_log_" + coreVersion + ".tmp";
    }

    public void a(byte[] bArr) {
        if (bArr == null || TextUtils.isEmpty(this.f5236a)) {
            return;
        }
        ReentrantLock reentrantLock = new ReentrantLock(true);
        reentrantLock.lock();
        try {
            try {
                a(this.f5236a, bArr, Part.CRLF);
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
            String a2 = DpSessionDatasUploader.getInstance().a(DpSessionDatasUploader.SAILOR_MONITOR, this.f5238c.equals("live_show_session") ? 24 : 1);
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
