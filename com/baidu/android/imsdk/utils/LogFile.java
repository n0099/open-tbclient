package com.baidu.android.imsdk.utils;

import android.content.Context;
import android.util.Log;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes3.dex */
public class LogFile {
    private static final String TAG = "LogFile";
    private static LogFile mInstance = null;
    private Context mContext;

    public static synchronized LogFile getInstance(Context context) {
        LogFile logFile;
        synchronized (LogFile.class) {
            if (mInstance == null) {
                mInstance = new LogFile(context);
            }
            logFile = mInstance;
        }
        return logFile;
    }

    public LogFile(Context context) {
        this.mContext = context;
    }

    public void writeByte(byte[] bArr) {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                fileOutputStream = this.mContext.openFileOutput(LogUtils.fileName() + BdStatsConstant.StatsFile.LOG_FILE_SUFFIX, 32768);
                if (fileOutputStream != null) {
                    fileOutputStream.write(bArr);
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e) {
                        LogUtils.e(TAG, "Exception ", e);
                        new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                    }
                }
            } catch (Exception e2) {
                LogUtils.e(TAG, "Exception ", e2);
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e3) {
                        LogUtils.e(TAG, "Exception ", e3);
                        new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e3)).build();
                    }
                }
            }
        } catch (Throwable th) {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e4) {
                    LogUtils.e(TAG, "Exception ", e4);
                    new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e4)).build();
                }
            }
            throw th;
        }
    }
}
