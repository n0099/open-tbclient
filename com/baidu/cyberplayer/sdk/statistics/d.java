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
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private String f1887a = null;

    /* renamed from: b  reason: collision with root package name */
    private String f1888b = null;
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

    private static void a(String str, byte[] bArr, String str2) {
        FileLock fileLock;
        RandomAccessFile randomAccessFile;
        FileLock fileLock2;
        if (bArr == null || TextUtils.isEmpty(str)) {
            return;
        }
        FileLock fileLock3 = null;
        try {
            try {
                randomAccessFile = new RandomAccessFile(str, "rw");
            } catch (Throwable th) {
                th = th;
            }
            try {
                if (randomAccessFile.length() > 10485760) {
                    if (0 != 0) {
                        try {
                            fileLock3.release();
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
                fileLock2 = randomAccessFile.getChannel().tryLock();
                if (fileLock2 != null) {
                    try {
                        if (fileLock2.isValid()) {
                            randomAccessFile.seek(randomAccessFile.length());
                            randomAccessFile.write(bArr);
                            if (!TextUtils.isEmpty(str2)) {
                                randomAccessFile.write(str2.getBytes());
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                        CyberLog.e("DpStatFileWriter", "FileWriter invoke write fail:", e);
                        if (fileLock2 != null) {
                            try {
                                fileLock2.release();
                            } catch (Exception e4) {
                                CyberLog.e("DpStatFileWriter", "file lock release fail", e4);
                            }
                        }
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                                return;
                            } catch (Exception e5) {
                                CyberLog.e("DpStatFileWriter", "file close fail", e5);
                                return;
                            }
                        }
                        return;
                    }
                }
                if (fileLock2 != null) {
                    try {
                        fileLock2.release();
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
            } catch (Exception e8) {
                e = e8;
                fileLock2 = null;
            } catch (Throwable th2) {
                th = th2;
                fileLock = null;
                if (fileLock != null) {
                    try {
                        fileLock.release();
                    } catch (Exception e9) {
                        CyberLog.e("DpStatFileWriter", "file lock release fail", e9);
                    }
                }
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (Exception e10) {
                        CyberLog.e("DpStatFileWriter", "file close fail", e10);
                    }
                }
                throw th;
            }
        } catch (Exception e11) {
            e = e11;
            fileLock2 = null;
            randomAccessFile = null;
        } catch (Throwable th3) {
            th = th3;
            fileLock = null;
            randomAccessFile = null;
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
        if (TextUtils.isEmpty(this.f1887a) || TextUtils.isEmpty(this.f1888b)) {
            return;
        }
        ReentrantLock reentrantLock = new ReentrantLock(true);
        reentrantLock.lock();
        try {
            String str = this.f1887a;
            if (b(str)) {
                String str2 = this.f1888b;
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
        String b2;
        if (context == null || (b2 = n.b(context)) == null) {
            return;
        }
        new File(b2).mkdirs();
        String coreVersion = CyberPlayerManager.getCoreVersion();
        this.f1887a = b2 + File.separator + this.c + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + coreVersion + ".bak";
        this.f1888b = b2 + File.separator + this.c + "_log_" + coreVersion + ".tmp";
    }

    public void a(byte[] bArr) {
        if (bArr == null || TextUtils.isEmpty(this.f1887a)) {
            return;
        }
        ReentrantLock reentrantLock = new ReentrantLock(true);
        reentrantLock.lock();
        try {
            a(this.f1887a, bArr, "\r\n");
        } catch (AssertionError e) {
            CyberLog.e("DpStatFileWriter", "write data to file fail");
        } finally {
            reentrantLock.unlock();
        }
    }

    public boolean b(String str, String str2) {
        Exception e;
        boolean z;
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String a2 = DpSessionDatasUploader.getInstance().a(DpSessionDatasUploader.SAILOR_MONITOR, this.c.equals("live_show_session") ? 24 : 1);
            if (TextUtils.isEmpty(a2)) {
                z = true;
            } else {
                int i = 1;
                z = true;
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        int i2 = i + 1;
                        if (!DpSessionDatasUploader.getInstance().a(Base64.decode(readLine, 2), a2, false)) {
                            try {
                                a(str2, readLine.getBytes(), "\r\n");
                                z = false;
                            } catch (Exception e2) {
                                e = e2;
                                z = false;
                                e.printStackTrace();
                                CyberLog.e("DpStatFileWriter", "readAndUploadLogFile failed");
                                return z;
                            }
                        }
                        i = i2;
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
