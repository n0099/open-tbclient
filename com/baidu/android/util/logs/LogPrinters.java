package com.baidu.android.util.logs;

import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes7.dex */
public final class LogPrinters {
    private LogPrinters() {
    }

    public static String getClassFileLineMethod(String str) {
        StackTraceElement stackTraceElement = new Exception().getStackTrace()[1];
        StringBuilder sb = new StringBuilder();
        if (str != null && str.length() > 0) {
            sb.append(str).append(": ");
        }
        sb.append("[").append(stackTraceElement.getFileName()).append(" | ").append(stackTraceElement.getLineNumber()).append(" | ").append(stackTraceElement.getMethodName()).append("()").append("]");
        return sb.toString();
    }

    public static String getFileLineMethod() {
        return getClassFileLineMethod("");
    }

    public static String getFileName() {
        return new Exception().getStackTrace()[1].getFileName();
    }

    public static String getMethodName() {
        return new Exception().getStackTrace()[1].getMethodName();
    }

    public static int getLineNumber() {
        return new Exception().getStackTrace()[1].getLineNumber();
    }

    public static String getTime() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
    }
}
