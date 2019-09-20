package com.baidu.cyberplayer.sdk.statistics;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.Utils;
import com.baidu.mobstat.Config;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.http.protocol.HTTP;
/* loaded from: classes.dex */
public class d {
    private static d a;
    private String b;
    private String c;
    private String d;

    private d() {
    }

    public static d a() {
        if (a == null) {
            a = new d();
        }
        return a;
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
                    if (randomAccessFile.length() > Config.FULL_TRACE_LOG_LIMIT) {
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

    private void b(Context context) {
        String str = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "baidu" + File.separator + "flyflow" + File.separator + "video_statistic" + File.separator + "duplayer" + File.separator + context.getPackageName();
        String str2 = context != null ? context.getFilesDir().getAbsolutePath() + File.separator + ".video_statistic" + File.separator + "duplayer" : str;
        if (Utils.e() < Config.FULL_TRACE_LOG_LIMIT) {
            str = str2;
        }
        this.d = str;
        new File(str).mkdirs();
        String coreVersion = CyberPlayerManager.getCoreVersion();
        this.c = str + File.separator + "video_session_" + coreVersion + ".bak";
        this.b = str + File.separator + "video_session_log_" + coreVersion + ".log";
    }

    private static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        return file.exists() && file.isFile();
    }

    public void a(Context context) {
        if (TextUtils.isEmpty(this.b)) {
            b(context);
        }
    }

    public void a(byte[] bArr) {
        if (bArr == null) {
            return;
        }
        ReentrantLock reentrantLock = new ReentrantLock(true);
        reentrantLock.lock();
        try {
            a(this.c, bArr, "\r\n");
        } catch (AssertionError e) {
            CyberLog.e("DpStatFileWriter", "write data to file fail");
        } finally {
            reentrantLock.unlock();
        }
    }

    public void b() {
        ReentrantLock reentrantLock = new ReentrantLock(true);
        reentrantLock.lock();
        try {
            String str = this.c;
            if (b(str)) {
                String str2 = this.d + File.separator + "video_session_log_" + CyberPlayerManager.getCoreVersion() + ".tmp";
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

    public boolean b(String str, String str2) {
        Exception e;
        boolean z;
        int i = 1;
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, HTTP.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            z = true;
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    i++;
                    if (!DpSessionDatasUploader.getInstance().a(Base64.decode(readLine, 2), DpSessionDatasUploader.SAILOR_MONITOR, false)) {
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
