package com.baidu.android.common.logging;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.FieldPosition;
import java.text.MessageFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
/* loaded from: classes5.dex */
class SimpleFormatter extends Formatter {
    private static String format = "{0,date} {0,time}";
    private MessageFormat formatter;
    Date dat = new Date();
    private Object[] args = new Object[1];

    @Override // java.util.logging.Formatter
    public synchronized String format(LogRecord logRecord) {
        int i;
        String str;
        String str2;
        StringBuffer stringBuffer;
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        int length = stackTrace.length;
        int i2 = 0;
        boolean z = false;
        while (true) {
            if (i2 >= length) {
                i = 0;
                str = null;
                str2 = null;
                break;
            }
            StackTraceElement stackTraceElement = stackTrace[i2];
            if (stackTraceElement.getClassName().startsWith(Log.class.getName())) {
                z = true;
            } else if (z) {
                String className = stackTraceElement.getClassName();
                String methodName = stackTraceElement.getMethodName();
                i = stackTraceElement.getLineNumber();
                str = methodName;
                str2 = className;
                break;
            }
            i2++;
        }
        logRecord.setSourceClassName(str2);
        logRecord.setSourceMethodName(str);
        stringBuffer = new StringBuffer();
        this.dat.setTime(logRecord.getMillis());
        this.args[0] = this.dat;
        StringBuffer stringBuffer2 = new StringBuffer();
        if (this.formatter == null) {
            this.formatter = new MessageFormat(format);
        }
        this.formatter.format(this.args, stringBuffer2, (FieldPosition) null);
        stringBuffer.append(stringBuffer2);
        stringBuffer.append("." + (logRecord.getMillis() % 1000));
        stringBuffer.append(" ");
        if (logRecord.getSourceClassName() != null) {
            stringBuffer.append(logRecord.getSourceClassName());
        } else {
            stringBuffer.append(logRecord.getLoggerName());
        }
        if (logRecord.getSourceMethodName() != null) {
            stringBuffer.append(" ");
            stringBuffer.append(logRecord.getSourceMethodName());
        }
        stringBuffer.append(" ");
        stringBuffer.append(i);
        stringBuffer.append(" ");
        String formatMessage = formatMessage(logRecord);
        stringBuffer.append(logRecord.getLevel().getLocalizedName());
        stringBuffer.append(": ");
        stringBuffer.append(formatMessage);
        stringBuffer.append("\n");
        if (logRecord.getThrown() != null) {
            try {
                StringWriter stringWriter = new StringWriter();
                PrintWriter printWriter = new PrintWriter(stringWriter);
                logRecord.getThrown().printStackTrace(printWriter);
                printWriter.close();
                stringBuffer.append(stringWriter.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return stringBuffer.toString();
    }
}
