package com.baidu.android.imsdk.utils;

import android.content.Context;
import android.util.Log;
import com.baidu.android.imsdk.upload.action.IMTrack;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes2.dex */
public class LogFile {
    public static final String TAG = "LogFile";
    public static LogFile mInstance;
    public Context mContext;

    public LogFile(Context context) {
        this.mContext = context;
    }

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

    public void writeByte(byte[] bArr) {
        IMTrack.CrashBuilder crashBuilder;
        FileOutputStream fileOutputStream = null;
        try {
            try {
                Context context = this.mContext;
                fileOutputStream = context.openFileOutput(LogUtils.fileName() + ".log", 32768);
                if (fileOutputStream != null) {
                    fileOutputStream.write(bArr);
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e2) {
                        e = e2;
                        LogUtils.e(TAG, "Exception ", e);
                        crashBuilder = new IMTrack.CrashBuilder(this.mContext);
                        crashBuilder.exception(Log.getStackTraceString(e)).build();
                    }
                }
            } catch (Throwable th) {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e3) {
                        LogUtils.e(TAG, "Exception ", e3);
                        new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e3)).build();
                    }
                }
                throw th;
            }
        } catch (Exception e4) {
            LogUtils.e(TAG, "Exception ", e4);
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e4)).build();
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e5) {
                    e = e5;
                    LogUtils.e(TAG, "Exception ", e);
                    crashBuilder = new IMTrack.CrashBuilder(this.mContext);
                    crashBuilder.exception(Log.getStackTraceString(e)).build();
                }
            }
        }
    }
}
