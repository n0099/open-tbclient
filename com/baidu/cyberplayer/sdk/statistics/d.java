package com.baidu.cyberplayer.sdk.statistics;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.n;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.concurrent.locks.ReentrantLock;
import tv.chushou.basis.http.HttpConsts;
/* loaded from: classes10.dex */
public class d {
    private String a = null;
    private String b = null;
    private String c;

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

    /* JADX WARN: Removed duplicated region for block: B:66:0x00be A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00b9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void a(String str, byte[] bArr, String str2) {
        RandomAccessFile randomAccessFile;
        FileLock fileLock = null;
        if (bArr == null || TextUtils.isEmpty(str)) {
            return;
        }
        FileLock fileLock2 = null;
        try {
            randomAccessFile = new RandomAccessFile(str, "rw");
            try {
                try {
                    if (randomAccessFile.length() > 10485760) {
                        if (0 != 0) {
                            try {
                                fileLock2.release();
                            } catch (Exception e) {
                                CyberLog.e("DpStatFileWriter", "file lock release fail", e);
                            }
                        }
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                                return;
                            } catch (Exception e2) {
                                CyberLog.e("DpStatFileWriter", "file close fail", e2);
                                return;
                            }
                        }
                        return;
                    }
                    fileLock = randomAccessFile.getChannel().tryLock();
                    if (fileLock != null && fileLock.isValid()) {
                        randomAccessFile.seek(randomAccessFile.length());
                        randomAccessFile.write(bArr);
                        if (!TextUtils.isEmpty(str2)) {
                            randomAccessFile.write(str2.getBytes());
                        }
                    }
                    if (fileLock != null) {
                        try {
                            fileLock.release();
                        } catch (Exception e3) {
                            CyberLog.e("DpStatFileWriter", "file lock release fail", e3);
                        }
                    }
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Exception e4) {
                            CyberLog.e("DpStatFileWriter", "file close fail", e4);
                        }
                    }
                } catch (Exception e5) {
                    e = e5;
                    CyberLog.e("DpStatFileWriter", "FileWriter invoke write fail:", e);
                    if (fileLock != null) {
                        try {
                            fileLock.release();
                        } catch (Exception e6) {
                            CyberLog.e("DpStatFileWriter", "file lock release fail", e6);
                        }
                    }
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Exception e7) {
                            CyberLog.e("DpStatFileWriter", "file close fail", e7);
                        }
                    }
                }
            } catch (Throwable th) {
                th = th;
                if (fileLock != null) {
                    try {
                        fileLock.release();
                    } catch (Exception e8) {
                        CyberLog.e("DpStatFileWriter", "file lock release fail", e8);
                    }
                }
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (Exception e9) {
                        CyberLog.e("DpStatFileWriter", "file close fail", e9);
                    }
                }
                throw th;
            }
        } catch (Exception e10) {
            e = e10;
            randomAccessFile = null;
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile = null;
            if (fileLock != null) {
            }
            if (randomAccessFile != null) {
            }
            throw th;
        }
    }

    public static boolean a(String str) {
        File file = new File(str);
        return file.exists() && file.isFile() && file.delete();
    }

    private static boolean b(String str) {
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
                    a(str2);
                } else {
                    a(str);
                    a(str2, str);
                    a(str2);
                }
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public void a(Context context) {
        String b;
        if (context == null || (b = n.b(context)) == null) {
            return;
        }
        new File(b).mkdirs();
        String coreVersion = CyberPlayerManager.getCoreVersion();
        this.a = b + File.separator + this.c + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + coreVersion + HttpConsts.FILE_BACKUP_SUFFIX;
        this.b = b + File.separator + this.c + "_log_" + coreVersion + ".tmp";
    }

    public void a(byte[] bArr) {
        if (bArr == null || TextUtils.isEmpty(this.a)) {
            return;
        }
        ReentrantLock reentrantLock = new ReentrantLock(true);
        reentrantLock.lock();
        try {
            a(this.a, bArr, "\r\n");
        } catch (AssertionError e) {
            CyberLog.e("DpStatFileWriter", "write data to file fail");
        } finally {
            reentrantLock.unlock();
        }
    }

    public boolean b(String str, String str2) {
        Exception e;
        boolean z;
        int i = 1;
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String a = DpSessionDatasUploader.getInstance().a(DpSessionDatasUploader.SAILOR_MONITOR, this.c.equals("live_show_session") ? 24 : 1);
            if (TextUtils.isEmpty(a)) {
                z = true;
            } else {
                z = true;
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        i++;
                        if (!DpSessionDatasUploader.getInstance().a(Base64.decode(readLine, 2), a, false)) {
                            try {
                                a(str2, readLine.getBytes(), "\r\n");
                                z = false;
                            } catch (Exception e2) {
                                z = false;
                                e = e2;
                                e.printStackTrace();
                                CyberLog.e("DpStatFileWriter", "readAndUploadLogFile failed");
                                return z;
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                    }
                }
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
