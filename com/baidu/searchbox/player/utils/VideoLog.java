package com.baidu.searchbox.player.utils;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
/* loaded from: classes2.dex */
public abstract class VideoLog {
    public final int TAG_MAX_LEN = 23;
    public final int MAX_LOG_LEN = 4096;

    public abstract boolean isLoggable(int i, @Nullable String str);

    private String getStackTraceString(@NonNull Throwable th) {
        try {
            StringWriter stringWriter = new StringWriter(256);
            PrintWriter printWriter = new PrintWriter((Writer) stringWriter, false);
            th.printStackTrace(printWriter);
            printWriter.flush();
            printWriter.close();
            return stringWriter.toString();
        } catch (Exception e) {
            String message = e.getMessage();
            if (TextUtils.isEmpty(message)) {
                return "unknown throwable by VideoLog.java";
            }
            return message;
        }
    }

    public void d(@Nullable String str) {
        doLog(3, null, str, null);
    }

    public void e(@Nullable String str) {
        doLog(6, null, str, null);
    }

    public void i(@Nullable String str) {
        doLog(4, null, str, null);
    }

    public void v(@Nullable String str) {
        doLog(2, null, str, null);
    }

    public void w(@Nullable String str) {
        doLog(5, null, str, null);
    }

    public void d(@Nullable String str, @Nullable String str2) {
        doLog(3, str, str2, null);
    }

    public void e(@Nullable String str, @Nullable String str2) {
        doLog(6, str, str2, null);
    }

    public void i(@Nullable String str, @Nullable String str2) {
        doLog(4, str, str2, null);
    }

    public void v(@Nullable String str, @Nullable String str2) {
        doLog(2, str, str2, null);
    }

    public void w(@Nullable String str, @Nullable String str2) {
        doLog(5, str, str2, null);
    }

    public void d(@Nullable String str, @Nullable Throwable th) {
        doLog(3, null, str, th);
    }

    public void e(@Nullable String str, @Nullable Throwable th) {
        doLog(6, null, str, th);
    }

    public void i(@Nullable String str, @Nullable Throwable th) {
        doLog(4, null, str, th);
    }

    public void v(@Nullable String str, @Nullable Throwable th) {
        doLog(2, null, str, th);
    }

    public void w(@Nullable String str, @Nullable Throwable th) {
        doLog(5, null, str, th);
    }

    public void doLog(int i, @Nullable String str, @Nullable String str2, @Nullable Throwable th) {
        if (!isLoggable(i, str)) {
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            if (th == null) {
                return;
            }
            str2 = getStackTraceString(th);
        } else if (th != null) {
            str2 = str2 + "\n" + getStackTraceString(th);
        }
        if (TextUtils.isEmpty(str)) {
            log(i, null, str2);
        } else if (str.length() > 23 && Build.VERSION.SDK_INT < 24) {
            log(i, str.substring(0, 23), str2);
        } else {
            log(i, str, str2);
        }
    }

    public void log(int i, @Nullable String str, @NonNull String str2) {
        int min;
        if (str2.length() < 4096) {
            if (i == 7) {
                Log.wtf(str, str2);
                return;
            } else {
                Log.println(i, str, str2);
                return;
            }
        }
        int i2 = 0;
        int length = str2.length();
        while (i2 < length) {
            int indexOf = str2.indexOf(10, i2);
            if (indexOf == -1) {
                indexOf = length;
            }
            while (true) {
                min = Math.min(indexOf, i2 + 4096);
                String substring = str2.substring(i2, min);
                if (i == 7) {
                    Log.wtf(str, substring);
                } else {
                    Log.println(i, str, substring);
                }
                if (min >= indexOf) {
                    break;
                }
                i2 = min;
            }
            i2 = min + 1;
        }
    }
}
