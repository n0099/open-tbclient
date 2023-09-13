package com.baidu.cyberplayer.sdk.statistics;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.CyberVersion;
import com.baidu.cyberplayer.sdk.Utils;
import com.baidu.mobstat.Config;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes3.dex */
public class DpStatFileWriter {
    public static final int MAX_FILE_LENGTH = 10485760;
    public static final String PLAY_VIDEO_LIVE_SHOW_SESSION = "live_show_session";
    public static final String PLAY_VIDEO_SESSION = "video_session";
    public static final String TAG = "DpStatFileWriter";
    public String mBackFilePath = null;
    public String mBackFileTemp = null;
    public String mSessionUploadTypeStr;

    public DpStatFileWriter() {
        this.mSessionUploadTypeStr = null;
        this.mSessionUploadTypeStr = PLAY_VIDEO_SESSION;
        init(CyberPlayerManager.getApplicationContext());
    }

    public DpStatFileWriter(String str) {
        this.mSessionUploadTypeStr = null;
        this.mSessionUploadTypeStr = str;
        init(CyberPlayerManager.getApplicationContext());
    }

    public static boolean deleteFile(String str) {
        File file = new File(str);
        if (!file.exists() || !file.isFile() || !file.delete()) {
            return false;
        }
        return true;
    }

    public static boolean isFileExist(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (!file.exists() || !file.isFile()) {
            return false;
        }
        return true;
    }

    public void writeStatisticsDataToFile(byte[] bArr) {
        if (bArr != null && !TextUtils.isEmpty(this.mBackFilePath)) {
            ReentrantLock reentrantLock = new ReentrantLock(true);
            reentrantLock.lock();
            try {
                try {
                    writeToFile(this.mBackFilePath, bArr, "\r\n");
                } catch (AssertionError unused) {
                    CyberLog.e(TAG, "write data to file fail");
                }
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public static void changeFileName(String str, String str2) {
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
    public static void writeToFile(String str, byte[] bArr, String str2) {
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
                CyberLog.e(TAG, "file close fail", e);
            }
            try {
            } catch (Error e2) {
                e = e2;
                CyberLog.e(TAG, "FileWriter invoke write error:", e);
                if (fileLock != 0) {
                    try {
                        fileLock.release();
                    } catch (Exception e3) {
                        CyberLog.e(TAG, "file lock release fail", e3);
                    }
                }
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                return;
            } catch (Exception e4) {
                e = e4;
                CyberLog.e(TAG, "FileWriter invoke write exception:", e);
                if (fileLock != 0) {
                    try {
                        fileLock.release();
                    } catch (Exception e5) {
                        CyberLog.e(TAG, "file lock release fail", e5);
                    }
                }
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                return;
            }
        } catch (Error e6) {
            e = e6;
            randomAccessFile = null;
        } catch (Exception e7) {
            e = e7;
            randomAccessFile = null;
        } catch (Throwable th2) {
            th = th2;
            if (0 != 0) {
                try {
                    fileLock.release();
                } catch (Exception e8) {
                    CyberLog.e(TAG, "file lock release fail", e8);
                }
            }
            if (0 != 0) {
                try {
                    fileLock.close();
                } catch (Exception e9) {
                    CyberLog.e(TAG, "file close fail", e9);
                }
            }
            throw th;
        }
        if (randomAccessFile.length() > Config.FULL_TRACE_LOG_LIMIT) {
            try {
                randomAccessFile.close();
                return;
            } catch (Exception e10) {
                CyberLog.e(TAG, "file close fail", e10);
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
                CyberLog.e(TAG, "file lock release fail", e11);
            }
        }
        randomAccessFile.close();
    }

    public void checkAndUploadLogFile() {
        if (!TextUtils.isEmpty(this.mBackFilePath) && !TextUtils.isEmpty(this.mBackFileTemp)) {
            ReentrantLock reentrantLock = new ReentrantLock(true);
            reentrantLock.lock();
            try {
                String str = this.mBackFilePath;
                if (!isFileExist(str)) {
                    return;
                }
                String str2 = this.mBackFileTemp;
                deleteFile(str2);
                if (!readAndUploadLogFile(str, str2)) {
                    deleteFile(str);
                    changeFileName(str2, str);
                    deleteFile(str2);
                } else {
                    deleteFile(str);
                    deleteFile(str2);
                }
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public void init(Context context) {
        String videoStatisticsPath;
        if (context == null || (videoStatisticsPath = Utils.getVideoStatisticsPath(context)) == null) {
            return;
        }
        new File(videoStatisticsPath).mkdirs();
        String coreVersionInternal = CyberVersion.getCoreVersionInternal();
        this.mBackFilePath = videoStatisticsPath + File.separator + this.mSessionUploadTypeStr + "_" + coreVersionInternal + ".bak";
        this.mBackFileTemp = videoStatisticsPath + File.separator + this.mSessionUploadTypeStr + "_log_" + coreVersionInternal + ".tmp";
    }

    public boolean readAndUploadLogFile(String str, String str2) {
        int i;
        boolean z = false;
        boolean z2 = true;
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            if (this.mSessionUploadTypeStr.equals(PLAY_VIDEO_LIVE_SHOW_SESSION)) {
                i = 24;
            } else {
                i = 1;
            }
            String uploadUrl = DpSessionDatasUploader.getInstance().getUploadUrl("sailor_monitor", i);
            if (!TextUtils.isEmpty(uploadUrl)) {
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        if (!DpSessionDatasUploader.getInstance().sendStatisticsDataToServer(Base64.decode(readLine, 2), uploadUrl, false)) {
                            try {
                                writeToFile(str2, readLine.getBytes(), "\r\n");
                                z2 = false;
                            } catch (Exception e) {
                                e = e;
                                e.printStackTrace();
                                CyberLog.e(TAG, "readAndUploadLogFile failed");
                                return z;
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        z = z2;
                        e.printStackTrace();
                        CyberLog.e(TAG, "readAndUploadLogFile failed");
                        return z;
                    }
                }
                z = z2;
            } else {
                z = true;
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
